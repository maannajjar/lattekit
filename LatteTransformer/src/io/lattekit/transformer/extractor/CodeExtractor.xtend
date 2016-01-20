package io.lattekit.transformer.extractor

import java.util.List
import java.util.regex.Matcher
import java.util.regex.Pattern
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data

abstract class CodeExtractor {
	def void readSource(String source);
	def LayoutCode getNext();
}

@Data 
class LayoutCode {
	Matcher matcher;
	int start
	int end
	String allCode
	String code
}


public class GenericCodeExtractor extends CodeExtractor {
	var IMPORTS_RE = Pattern.compile('''(import|package)\s+([^;\s\n]*);?''')
	var static commentPattern = Pattern.compile('''\$\(\/\*((?:(?!\*\/\))[\s\S])*)\*\/\)''')
	var String source;
	
	@Accessors var Matcher matcher;
	
	def getPattern() {
		return commentPattern
	}

	override readSource(String source) {
		this.source = source;
		matcher = pattern.matcher(source)
	}
	
	def List<String> getImports() {
		var List<String> imports = newArrayList();
		var m = IMPORTS_RE.matcher(source)
		while (m.find()) {
			if (m.group(1) == "package") {
				imports += m.group(2) +".*"
			} else {
				imports += m.group(2)
			}
		}
		
		return imports;
	}
	override getNext() {
		if (matcher.find()) {
			var allCode =  matcher.group(0)
			return new LayoutCode(matcher,matcher.start(0),matcher.end(0),allCode,matcher.group(1))
		}
		return null
	}
}
