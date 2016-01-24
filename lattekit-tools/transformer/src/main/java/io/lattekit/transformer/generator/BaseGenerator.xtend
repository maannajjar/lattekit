package io.lattekit.transformer.generator

import io.lattekit.transformer.parser.TagParser
import io.lattekit.transformer.tree.Tag
import java.util.regex.Pattern
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.Stack
import java.util.List

abstract class BaseGenerator {

	var IMPORTS_RE = Pattern.compile('''(import|package)\s+([^;\s\n]*);?''')

    var String packageName;
	protected Iterable<String> imports;
	def String compile(Tag code);
	
	def String findFQN( String cls) {
		imports.findFirst[it.endsWith('''.«cls»''');]
	}

    def abstract Pattern getTokensPattern();

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

	def List<TransformedClass> transform(String source) {
		val sb = new StringBuffer();
		imports = #[
			"io.lattekit.ui.view.ImageView",
			"io.lattekit.ui.view.LinearLayout",
			"io.lattekit.ui.view.ListView",
			"io.lattekit.ui.view.RelativeLayout"
		] + getImports(source)

		var result = new TransformResult();

		var matcher = getTokensPattern().matcher(source)
		var bracesStack = new Stack<String>();
		var List<TransformedClass> classes = newArrayList();
		var TransformedClass currentClass;

		while (matcher.find()) {
			if (matcher.group(1).startsWith("class")) {
				var isInner = true;
				if (currentClass == null) {
					currentClass = new TransformedClass();
					classes += currentClass
					isInner = false;
				}
				bracesStack.push(matcher.group(1));

				if (matcher.group(3) == "extends" && (matcher.group(4) == "LatteView") || matcher.group(4) == "io.lattekit.ui.LatteView") {
					if (!isInner) {
						currentClass.name= matcher.group(2)
					}
                    currentClass.imports = imports.toList;
                    currentClass.packageName = packageName;
                    currentClass.hasLayout = true;
					currentClass.append( "class "+matcher.group(2) + "Impl extends "+matcher.group(2)+ " {")
				} else {
					if (!isInner) {
						currentClass.name = matcher.group(2)+"Impl"
					}
					currentClass.append(matcher.group(1))
				}
				bracesStack.push(matcher.group(1))
			} else if (matcher.group(5) != null && matcher.group(5) != "") {
				var layouCode = new TagParser().parse(matcher.group(5))
				var compiledCode = compile(layouCode)
				currentClass.append(compiledCode)
			} else {
				if (currentClass != null) {
					currentClass.append(matcher.group(1))
				} else {
				}
			}

			if (matcher.group(1) == "}") {
				if (bracesStack.empty()) {
					throw new Exception("Found unmathced closing brace at "+matcher.start);
				}
				var lastBrace = bracesStack.pop();
				if (lastBrace != "{") {
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
class TransformedClass {
    String packageName;
    List<String> imports;
	String code = "";
	String name;
	boolean hasLayout;
	def append(String a) {
		code += a
	}

    override toString() '''
    package «packageName»;
    «FOR cls:imports»
        import «cls»;
    «ENDFOR»

    «code»
    '''

}

@Accessors
class TransformResult {
	String out;
	boolean hasLayoutCode;

}