package io.lattekit.transformer.parser

import java.util.List
import java.util.regex.Matcher
import java.util.regex.Pattern
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class CssDefinition  {
	new(Matcher m,String source) {
		start = m.start
		end = m .end
	}
	int start;
	int end;
	String selector;
	List<CssProperty> childNodes = newArrayList()
}

@Accessors
class CssProperty  {
	new(Matcher m,String source) {
		start = m.start
		end = m .end
	}
	
	int start;
	int end;
	String text;
	String name;
	String value;
}

class CssParser {
	var TOKENS = Pattern.compile(
			// Group 1:captures selectors
			'''((?:(?:\.|#)?[^,> \n]+)(?:\s*[,> ]\s*(?:\.|#)?[^,> \n]+)*)\s+(?=\{)'''
			// Group 2: captures {
			+'''|(\{)'''
			// Group 3: captures property name
			// Group 4: captures property value
			+'''|\s*([^\n:]+):\s*([^\n;]+)(?:;|\s*\n\s*(?=\}))'''
			// Group 5: captures }
			+'''|(\})''')
	
	
	def acceptDefinition(Matcher m, String source) {
		if (m.group(1) == null || m.group(1).trim() == "") {
			throw new Exception("Expected CSS definition block. Found"+m.group)
		}
		
		var selector = m.group(1);
		var definition = new CssDefinition(m, source)
		definition.selector = selector;
		m.find()
		
		if (m.group(2) == null || m.group(2).trim() == "" ){
			throw new Exception("Expected {")
		}
		m.find()
		
		while (m.group(5) == null || m.group(5).trim() == "") {
			definition.childNodes += acceptProperty(m,source);
			m.find()
		}
		m.find()
		return definition;
	}
	
	def CssProperty acceptProperty(Matcher m, String source) {
		var property = new CssProperty(m, source);
		property.name = m.group(3)
		property.value = m.group(4)
		return property
	}
	
	def List<CssDefinition> parse(String source) {
		var matcher = TOKENS.matcher(source);
		var List<CssDefinition> results = newArrayList();
		matcher.find()
		while (!matcher.hitEnd) {
			results += acceptDefinition(matcher,source);
			
		}
		return results;
	}
	def static void main(String... args) {
		var test = new CssParser();
		test.parse('''

			.module > .ss  > #hello   { 
				height: wrap_content;
			    width: match_parent;
			}
			.container {
				width: hala;
				height: match_parent
			}
			
			.test {
				width: 200px;
				height: 200px;
				background-color: #eeeeee;
			}
			.story {
			    height: wrap_content;
			    width: match_parent;
			    background-color:#00000000;
			    ripple-color: #aaaaaa;
			}		
		''')
	}
	
}