package io.lattekit.transformer.generator

import io.lattekit.transformer.parser.TagParser
import io.lattekit.transformer.tree.Tag
import java.util.List
import java.util.Stack
import java.util.regex.Pattern
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.Set

abstract class BaseGenerator {

    var IMPORTS_RE = Pattern.compile('''(import|package)\s+([^;\s\n]*);?''')
    var static ANDROID_RES_RE = Pattern.compile('''@(?:([^:\/]+):)?\+?([^:\/]+)\/(.*)''')


    @Accessors var String androidPackageName;
    var String packageName;
    @Accessors Set<String> resourceIds = newHashSet();

    protected Iterable<String> imports;
    def String compile(Tag code);

    def String findFQN( String cls) {
        imports.findFirst[it.endsWith('''.«cls»''');]
    }

    def abstract Pattern getTokensPattern();

    def emitId(String generatedId) {
        resourceIds += generatedId;
    }

    def compilePropStringValue(String value) {

        if (value.trim().startsWith('"') && value.trim().endsWith('"')) {
            var strContent = value.trim().substring(1,value.trim().length-1)
            if(strContent.startsWith("@")) {
                var matcher = ANDROID_RES_RE.matcher(strContent)
                if(matcher.find()) {
                    val resPackageName = if(matcher.group(1) != null && matcher.group(1) != "") {
                        matcher.group(1)
                    } else { androidPackageName }
                    if(matcher.group(2) == "id" && resPackageName == androidPackageName) {
                        emitId(matcher.group(3))
                    }
                    return '''«resPackageName».R.«matcher.group(2)».«matcher.group(3)»'''
                }
            }
        }
        return value;
    }

    def List<String> getImports(String source) {
        var List<String> imports = newArrayList();
        var m = IMPORTS_RE.matcher(source)
        while (m.find()) {
            if (m.group(1) == "package") {
                imports += m.group(2) +".*"
                packageName = m.group(2);
            } else {
                imports += m.group(2)
            }
        }

        return imports;
    }
    def extendsKeyword() {"extends"}
    def List<TransformedClass> transform(String androidPackage, String source) {
        androidPackageName = androidPackage;
        val sb = new StringBuffer();
        var fileImports = getImports(source);
        imports = #[
            "io.lattekit.ui.view.ImageView",
            "io.lattekit.ui.view.LinearLayout",
            "io.lattekit.ui.view.ListView",
            "io.lattekit.ui.view.RelativeLayout"
        ] + fileImports

        var result = new TransformResult();

        var matcher = getTokensPattern().matcher(source)
        var bracesStack = new Stack<Object>();
        var List<TransformedClass> classes = newArrayList();
        var TransformedClass currentClass;
        var TransformedFunction currentFunction;

        while (matcher.find()) {
            var isFunctionStart = false;
            if (matcher.group(1).startsWith("class")) {
                var isInner = true;
                if (currentClass == null) {
                    currentClass = new TransformedClass();
                    classes += currentClass
                    isInner = false;
                }
                bracesStack.push(matcher.group(1));
                currentClass.imports = fileImports.toList;

                if (matcher.group(3) == extendsKeyword) {
                    if (!isInner) {
                        currentClass.name= matcher.group(2)+"Impl"
                    }
                    currentClass.packageName = packageName;

                    currentClass.append( "class "+matcher.group(2) + "Impl "+extendsKeyword+" "+matcher.group(2)+ "() {\n")
                } else {
                    if (!isInner) {
                        currentClass.name = matcher.group(2)+"Impl"
                    }
                    if (currentFunction != null) {
                        currentFunction.append(matcher.group(1))
                    }

                }
                bracesStack.push(matcher.group(1))
            } else if (matcher.group(5) != null && matcher.group(5) != "") {
                var layouCode = new TagParser().parse(matcher.group(5))
                var compiledCode = compile(layouCode)
                println("Processed "+currentClass.name +" layout")
                currentClass.hasLayout = true;
                println("Class has a layout function :"+currentFunction.name)
                currentFunction.append(compiledCode);
                currentClass.append(currentFunction)

            } else if (matcher.group(8) != null && matcher.group(8) != "") {
                currentFunction = new TransformedFunction();
                currentFunction.name = matcher.group(8);
                currentFunction.opener = matcher.group(9);
                if (currentFunction.opener == "{") {
                    bracesStack.push(currentFunction);
                }
                isFunctionStart = true;
            } else {
                if (currentClass != null && currentFunction != null) {
                    currentFunction.append(matcher.group(1))
                } else {
                }
            }
            if (!isFunctionStart) {
                if (currentFunction != null && currentFunction.opener == '=') {
                    currentFunction = null;
                }
            }
            if (matcher.group(1) == "}") {
                if (bracesStack.empty()) {
                    throw new Exception("Found unmathced closing brace at "+matcher.start);
                }
                var lastBrace = bracesStack.pop();
                if (lastBrace instanceof TransformedFunction) {
                    currentFunction = null;
                } else if (lastBrace != "{") {
                    if (currentClass != null) currentClass.append(matcher.group(1))
                    currentClass =  null;
                }
            } else if (matcher.group(1) == "{") {
                bracesStack.push(matcher.group(1))
            }

        }
        return classes.filter[ hasLayout ].toList
    }


    def static void main(String... args) {
        var test = '''
            package hello;
            class Hello extends LatteView {
                @Latte
                override render() «"'''"»
                    <LinearLayout />
                «"'''"»

                class GoodStuff {

                }
            }

        '''
    }
}

@Accessors
class TransformedFunction {
    String code = "";
    String name;
    String opener;
    def append(String a) {
        code += a
    }
    override toString() '''
        override fun «name» «IF opener == "{"»{«ELSE» = «ENDIF» «code»
    '''
}


@Accessors
class TransformedClass {
    String packageName;
    List<String> imports;
    String code = "";
    List<Object> codeParts = newArrayList();
    String name;
    boolean hasLayout;

    def append(Object a) {
        codeParts += a
    }

    override toString() '''
    package «packageName»;
    «FOR cls:imports»
        import «cls»;
    «ENDFOR»

    «FOR code : codeParts»«code.toString»«ENDFOR»
    '''

}

@Accessors
class TransformResult {
    String out;
    boolean hasLayoutCode;

}