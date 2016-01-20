package io.lattekit.transformer.parser

import io.lattekit.transformer.tree.Node
import java.util.ArrayList
import java.util.List
import java.util.Stack
import java.util.regex.Matcher
import java.util.regex.Pattern

class CodeStatement extends Node {
	new(Matcher m) {
		super(m)
	}
}
class CodeParser {
	static var TOKENS_RE = Pattern.compile('''([^;\{\}\(\)]+|\(|\)|\{|\}|;|(?:(["'])(?:(?=(\\?))\3.)*?\2))''')
	String source;
	def List<CodeStatement> parse(String str) {
		var List<CodeStatement> statements = new ArrayList<CodeStatement>(); 
		source = str;
		var matcher = TOKENS_RE.matcher(str);
		var Stack<String> brackets = new Stack();
		var currentCode = ""
		while (matcher.find()) {
			
			if (matcher.group(1) == "}" || matcher.group(1) == ")") {
				
				if (brackets.empty() || PropsParser.closingOf(brackets.peek()) != matcher.group(1)) {
					throw new Exception("Found unmatched closing for "+brackets.peek()+". Expected: "+ PropsParser.closingOf(brackets.peek())+" But found "+ matcher.group(1));
				} else {
					brackets.pop()
				}
				currentCode += matcher.group(1)
				if (brackets.empty()) {
					var statement = new CodeStatement(matcher);
					statement.text = currentCode
					currentCode = ""
					statements += statement		
				}
			} else if (matcher.group(1) == "{" || matcher.group(1) == "(") {
				brackets.push(matcher.group(1))
				currentCode += matcher.group(1)
			} else if (matcher.group(1) == ";") {
				currentCode += matcher.group(1)
				if (brackets.empty()) {
					if (currentCode.trim() != "" && currentCode.trim() != ";") {
						var statement = new CodeStatement(matcher);
						statement.text = currentCode
						currentCode = ""
						statements += statement
					}
				}
			} else {
				currentCode += matcher.group(1)
			}
		}
		if (currentCode.trim() != "" && currentCode.trim() != ";") {

			var statement = new CodeStatement(matcher);
			statement.text = currentCode
			statements += statement
		}
		
		return statements
	}
	
	def static void main(String... args) {
		var result = new CodeParser().parse('''		if (currentCode.trim() != "" && currentCode.trim() != ";") {
		
					var statement = new CodeStatement(matcher);
					statement.text = currentCode
					statements += statement
				}
				console.log("x");
''');
		if (result.last?.text.trim().endsWith("}")) {
			System.out.println("Must return something!!")
		} else {
			result.last.text = "return "+ result.last.text.trim() + ( if (result.last.text.trim().endsWith(";")) "" else ";");
		}
		result.forEach[
			println(text)
		];
		
		
	}
}