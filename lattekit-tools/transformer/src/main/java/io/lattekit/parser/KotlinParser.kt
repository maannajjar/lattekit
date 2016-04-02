/**
 * Created by maan on 4/2/16.
 */
package io.lattekit.parser

import io.lattekit.parser.LatteBaseVisitor
import io.lattekit.parser.LatteLexer
import io.lattekit.parser.LatteParser;
import io.lattekit.transformer.KotlinTransformer
import io.lattekit.transformer.Reflection
import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.TerminalNode

/**
 * Created by maan on 4/2/16.
 */
val CLASS_NAME_RE = Regex(""".*class\s+([^ :]+).*""")

class KotlinParser : AstVisitor {
    var latteFile : LatteFile = LatteFile();

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
        var clsName = CLASS_NAME_RE.matchEntire(ctx.LAYOUT_CLASS().text)!!.groupValues[1]
        var latteClass = LatteClass();
        ctx.classBody().layoutFunction().forEach {
            var layoutFunction = visitLayoutFunction(it)
            latteClass.layoutFunctions.add(layoutFunction);
        }
        return latteClass
    }

    fun visitLayoutFunction(ctx : LatteParser.LayoutFunctionContext) : LayoutFunction {
        var layoutFunction = LayoutFunction();
        var funWords = if (ctx.LAYOUT_FUN() != null) {
            ctx.LAYOUT_FUN()
        } else {
            ctx.LAYOUT_FUN_BLOCK()
        }.text.replace(Regex("\\s+")," ").split(" ");
        var keywords = mutableListOf<String>()
        var functionNameWithParams = funWords.find { if (!it.contains("(")) { keywords.add(it); false } else true; }
        layoutFunction.functionModifiers = keywords;
        layoutFunction.functionName = functionNameWithParams!!.split("(")[0]
        layoutFunction.functionParams = functionNameWithParams.substring(layoutFunction.functionName.length)
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
        return result;
    }

    fun visitXmlTag(ctx : LatteParser.XmlTagContext) : XmlTag {
        var result = XmlTag();
        result.tagName =  ctx.XML_TAG_OPEN().text.substring(1);
        if (ctx.layoutBody() != null) {
            result.children = visitLayoutBody(ctx.layoutBody());
        }
        ctx.layoutProp().forEach {
            var prop = Prop();
            prop.propName = it.propName().text
            if (it.inlineCode() != null) {
                prop.valueType = Prop.ValueType.INLINE_CODE
                prop.value = visitInlineCodeContent(it.inlineCode().inlineCodeContent()).map { if (it is NativeCode) it.code else null }.filterNotNull().joinToString("")
            } else if (it.STRING_LITERAL() != null) {
                prop.valueType = Prop.ValueType.LITERAL
                prop.value = it.STRING_LITERAL().text
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
        return result;
    }




    override fun parseSource( source : String) : LatteFile {
        var inputStream = ANTLRInputStream(source);
        var lexer = LatteLexer(inputStream);
        var tokens = CommonTokenStream(lexer);
        var parser = LatteParser(tokens)
        latteFile = LatteFile();
        visitUnit(parser.unit())
        return latteFile;
    }

}

fun printLayout(layoutCode : LayoutNode) {
    if (layoutCode is NativeCode) {
        print(layoutCode.code)
    } else if (layoutCode is XmlTag) {
        print("<${layoutCode.tagName} ${layoutCode.props.map { it.propName +"="+it.value }.joinToString(" ")}>");

        layoutCode.children.forEach { printLayout(it) }
        print("</${layoutCode.tagName}>");
    }
}


val DOLLAR = "$";
val MQ = "\"\"\"";

fun main(args : Array<String>) {
    Reflection.loadAndroidSdk("/Users/maan/Library/Android/sdk","android-23");
    var parsed = KotlinParser().parseSource("""
package mobi.yummyfood.android
import io.lattekit.hello;

open class MyApp : LatteView() {

    override fun layout() = lxml($MQ
        <LinearLayout class="container" orientation="vertical">
            <RelativeLayout clickable="true" orientation="vertical" class="card">
                <ImageView id="@+id/foodImage" src=$DOLLAR{model?.`object`?.photoUrl+"?s=1000"} class="img" scaleType="centerCrop"/>
                <ImageView id="@+id/userAvatar" below="@id/foodImage" src=$DOLLAR{model?.userInfo?.avatarUrl} class="avatar" scaleType="centerCrop"/>
                <TextView id="@+id/userName" below="@id/foodImage" toEndOf="@id/userAvatar" text=$DOLLAR{model?.userInfo?.displayName} class="username"/>
                <TextView below="@id/userName" toEndOf="@id/userAvatar" text=$DOLLAR{Html.fromHtml(model?.`object`?.text ?: "SS")} class="text"/>
            </RelativeLayout>
            $DOLLAR{model?.comments?.forEach { $MQ<mobi.yummyfood.android.CommentItem comment=$DOLLAR{it} />$MQ }}
        </LinearLayout>
        $DOLLAR{println("Hello")}
    $MQ)
}
    """)

    println(parsed.packageName)
    println("IMPORTS = "+ parsed.imports.joinToString(","))
    parsed.classes.forEach {
        println("\tClass $it");
        it.layoutFunctions.forEach {
            print("\t${it.functionModifiers.joinToString(" ")} ${it.functionName}${it.functionParams} {")
            it.children.forEach { printLayout(it) }
            print("}")
        }
    }
}
