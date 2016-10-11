/**
 * Created by maan on 4/2/16.
 */
package io.lattekit.parser

import freemarker.cache.ClassTemplateLoader
import freemarker.template.Configuration
import io.lattekit.evaluator.Resolver
import io.lattekit.template.KotlinTemplate
import io.lattekit.transformer.Reflection
import org.antlr.v4.runtime.*
import java.io.OutputStreamWriter

/**
 * Created by maan on 4/2/16.
 */
val CLASS_NAME_RE = Regex(""".*class\s+([^ :]+).*""")
val ANDROID_RES_RE = Regex("""@(?:([^:\/]+):)?\+?([^:\/]+)\/(.*)""")
val WS             = Regex("""[\r\n ]+""")

class KotlinParser : AstVisitor {
    var latteFile : LatteFile = LatteFile();
    var errors = mutableListOf<String>();

    var errorListener = object : BaseErrorListener() {
        override fun <T : Token?> syntaxError(recognizer: Recognizer<T, *>?, offendingSymbol: T, line: Int, charPositionInLine: Int, msg: String?, e: RecognitionException?) {
            errors.add("($line, $charPositionInLine): $msg at  ($line,$charPositionInLine) ")
        }
    }

    fun visitUnit(ctx: LatteParser.UnitContext ) {
        // Find package name
        var packageDeclaration = ctx.packageDeclaration()?.firstOrNull();
        if (packageDeclaration != null) {
            latteFile.packageName = packageDeclaration.text.split(" ").last()
        }
        // Find imports name
        ctx.importStatement()?.forEach {
            latteFile.imports.add(it.text.split(" ").last());
        }

        ctx.classDeclaration().forEach {
            var latteClass = visitClass(it);
            if (!latteClass.layoutFunctions.isEmpty()) {
                latteClass.latteFile = latteFile;
                latteFile.classes.add(latteClass);
            }
        }
    }
    fun visitClass(ctx: LatteParser.ClassDeclarationContext) : LatteClass {

        var latteClass = LatteClass();
        latteClass.className = CLASS_NAME_RE.matchEntire(ctx.LAYOUT_CLASS().text)!!.groupValues[1]
        ctx.classBody().layoutFunction().forEach {
            var layoutFunction = visitLayoutFunction(it)
            latteClass.layoutFunctions.add(layoutFunction);
        }

        return latteClass
    }

    fun visitLayoutFunction(ctx : LatteParser.LayoutFunctionContext) : LayoutFunction {
        var layoutFunction = LayoutFunction();
        var text = if (ctx.LAYOUT_FUN() != null) {
            ctx.LAYOUT_FUN()
        } else {
            ctx.LAYOUT_FUN_BLOCK()
        }.text.replace(Regex("\\s+")," ")
        var funWords = text.substring(0,text.indexOf("=")).split(" ");
        var keywords = mutableListOf<String>()
        funWords.forEach { if (!it.contains("(")) { keywords.add(it); } }
        var functionNameStartIndex = funWords.indexOfFirst{ it.contains("(") }
        var functionNameWithParams = funWords.filterIndexed { i, s -> i >= functionNameStartIndex  }.joinToString("")
        var functionName = functionNameWithParams!!.split("(")[0]

        layoutFunction.functionModifiers = keywords;
        layoutFunction.functionName = functionNameWithParams!!.split("(")[0]
        layoutFunction.functionParams = functionNameWithParams.substring(functionName.length)
        layoutFunction.children = visitLayoutBody(ctx.layoutString().layoutBody())
        return layoutFunction;
    }

    fun visitLayoutBody(ctx : LatteParser.LayoutBodyContext) : List<LayoutNode> {
        var result = mutableListOf<LayoutNode>()
        var currentNode : NativeCode? = null;
        ctx.children.forEach {
            if (it is LatteParser.InlineCodeContext) {
                result.addAll(visitInlineCodeContent(it.inlineCodeContent()))
                currentNode = null;
            } else if (it is LatteParser.XmlTagContext) {
                result.add(visitXmlTag(it))
                currentNode = null;
            } else {
                if (currentNode == null) {
                    currentNode = NativeCode();
                    result.add(currentNode!!);
                }
                currentNode!!.code += it.text
            }
        }
        return result.filter { it is XmlTag || (it is NativeCode && it.code.replace(WS,"") != "") };
    }

    fun visitXmlTag(ctx : LatteParser.XmlTagContext) : XmlTag {
        var result = XmlTag();
        result.tagName =  ctx.XML_TAG_OPEN().text.substring(1);
        if (ctx.layoutBody() != null) {
            result.children = visitLayoutBody(ctx.layoutBody());
        }
        ctx.layoutProp().forEach {
            var prop = Prop();
            var propName = it.propName().text

            if (propName.contains(":")) {
                prop.namespace = propName.split(":",limit=2)[0]
                if (prop.namespace.startsWith("@")) {
                    prop.propModifier = "@";
                    prop.namespace = prop.namespace.substring(1)
                }
                prop.propName = propName.split(":",limit=2).get(1)
            } else {
                prop.propName = propName;
                if (propName.startsWith("@")) {
                    prop.propModifier = "@";
                    prop.propName = propName.substring(1)
                }
            }

            if (it.inlineCode() != null) {
                prop.valueType = Prop.ValueType.INLINE_CODE
                prop.value = visitInlineCodeContent(it.inlineCode().inlineCodeContent()).map { if (it is NativeCode) it.code else null }.filterNotNull().joinToString("")
            } else if (it.STRING_LITERAL() != null) {
                prop.valueType = Prop.ValueType.LITERAL
                var stringLiteral = it.STRING_LITERAL().text;
                var stringValue = stringLiteral.substring(1,stringLiteral.length-1)
                var matcher = ANDROID_RES_RE.matchEntire(stringValue)
                prop.value = if(matcher != null) {
                    val resPackageName = if(matcher.groupValues.getOrNull(1) != null && matcher.groupValues[1] != "") {
                        matcher.groupValues[1]
                    } else { null }
                    if(matcher.groupValues.getOrNull(2) == "id" && resPackageName == null) {
                        latteFile.resourceIds.add(matcher.groupValues[3])
                    }
                    prop.valueType = Prop.ValueType.RESOURCE_REF
                    prop.resourcePackage = resPackageName;
                    prop.resourceType = matcher.groupValues[2]
                    prop.resourceName = matcher.groupValues[3];
                    """${resPackageName}.R.${matcher.groupValues[2]}.${matcher.groupValues[3]}"""
                } else {
                    stringLiteral
                }

            }
            result.props.add(prop);
        }
        return result;
    }

    fun visitInlineCodeContent(ctx : LatteParser.InlineCodeContentContext) : List<LayoutNode> {
        var result = mutableListOf<LayoutNode>()
        var currentNode : NativeCode? = null;
        ctx.children.forEach {
            if (it is LatteParser.CodeBaseContext) {
                it.children.forEach {
                    if (it is LatteParser.LayoutStringContext) {
                        currentNode = null;
                        result.addAll(visitLayoutBody(it.layoutBody()))
                    } else {
                        if (currentNode == null) {
                            currentNode = NativeCode();
                            result.add(currentNode!!);
                        }
                        currentNode!!.code += it.text
                    }
                }
            } else if (it is LatteParser.InlineCodeContentContext){
                currentNode = null;
                result.addAll(visitInlineCodeContent(it))
            } else {
                if (currentNode == null) {
                    currentNode = NativeCode();
                    result.add(currentNode!!);
                }
                currentNode!!.code += it.text
            }
        }

        return result.filter { it is XmlTag || (it is NativeCode && it.code.replace(WS,"") != "") };
    }

    override fun parseSource( source : String) : LatteFile {
        var inputStream = ANTLRInputStream(source);
        var lexer = LatteLexer(inputStream);
        var tokens = CommonTokenStream(lexer);
        var parser = LatteParser(tokens)
        parser.removeErrorListeners()
        lexer.removeErrorListeners()
        lexer.addErrorListener(errorListener as ANTLRErrorListener<in Int>);
        parser.addErrorListener(errorListener);
        try {
            latteFile = LatteFile();
            visitUnit(parser.unit())
        } catch (e : Exception) {}
        return latteFile;
    }

}

//
//fun printLayout(layoutCode : LayoutNode) {
//    if (layoutCode is NativeCode) {
//        print(layoutCode.code)
//    } else if (layoutCode is XmlTag) {
//        print("<${layoutCode.tagName} ${layoutCode.props.map { it.propName +"="+it.value }.joinToString(" ")}>");
//
//        layoutCode.children.forEach { printLayout(it) }
//        print("</${layoutCode.tagName}>");
//    }
//}
//
val DOLLAR = "$";
val MQ = "\"\"\"";

fun main(args : Array<String>) {
    Reflection.loadAndroidSdk("/Users/maan/Library/Android/sdk","android-23");

    var cfg = Configuration(Configuration.VERSION_2_3_25);
//cfg.setClassForTemplateLoading(KotlinP)
    cfg.templateLoader = ClassTemplateLoader(Object().javaClass, "/")
    var temp = cfg.getTemplate("templates/test.ftl");

    var out = OutputStreamWriter(System.out);
    temp.process(Object(), out);

//    var parsed = KotlinParser().parseSource("""
//package mobi.yummyfood.android
//import io.lattekit.hello;
//
//open class MyApp : LatteView() {
//    init {
//        css("com.myapp.style/main.css")
//    }
//
//    fun shouldAddToolbarBorder () = Build.VERSION.SDK_INT < 21
//
//    override fun layout() = lxml($MQ
//        <LinearLayout orientation="vertical" layout_width=match_parent" layout_height="match_parent">
//            <android.support.v7.widget.Toolbar class="toolbar" logo="@drawable/home_logo" layout_width="match_parent" layout_height="wrap_content"/>
//            $DOLLAR{IF (shouldAddToolbarBorder()) { $MQ<View class="toolbar_border" />$MQ }}
//            <my.HomeFeed />
//         </LinearLayout>
//    $MQ)
//
//}
//    """)
//    Resolver("mobi.yummyfood.android").evaluate(parsed);
//
//    parsed.classes.forEach {
//        print( KotlinTemplate().renderClass(it, parsed))
//    }


//    println(parsed.packageName)
//    println("IMPORTS = "+ parsed.imports.joinToString(","))
//    parsed.classes.forEach {
//        println("\tClass $it");
//        it.layoutFunctions.forEach {
//            print("\t${it.functionModifiers.joinToString(" ")} ${it.functionName}${it.functionParams} {")
//            it.children.forEach { printLayout(it) }
//            print("}")
//        }
//    }
}
