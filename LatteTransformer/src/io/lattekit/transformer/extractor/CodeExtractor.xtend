package io.lattekit.transformer.extractor

import java.util.regex.Matcher
import java.util.regex.Pattern
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.annotations.Accessors

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


class GenricCodeExtractor extends CodeExtractor {
	var pattern = Pattern.compile('''\$\(\/\*((?:(?!\*\/\))[\s\S])*)\*\/\)''')
	@Accessors var Matcher matcher;
	override readSource(String source) {
		matcher = pattern.matcher(source)
	}
	
	override getNext() {
		if (matcher.find()) {
			var allCode =  matcher.group(0)
			return new LayoutCode(matcher,matcher.start(0),matcher.end(0),allCode,allCode.substring(4,allCode.length-3))
		}
		return null
	}
}
