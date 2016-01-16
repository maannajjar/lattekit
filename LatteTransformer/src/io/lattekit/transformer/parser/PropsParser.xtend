package io.lattekit.transformer.parser

import io.lattekit.transformer.tree.Node
import java.util.ArrayList
import java.util.List
import java.util.Stack
import java.util.regex.Matcher
import java.util.regex.Pattern
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Prop extends Node {
	new(Matcher m) {
		super(m)
	}
	String name
	String value
	int start;
	int end
	String type;
}

@Accessors
class LambdaProp extends Prop {
	List<String> paramList;
	List<String> paramTypes;
	String returnType;
	List<CodeStatement> statements = newArrayList()
	override void setValue(String value) {
		super.setValue(value)
		parseLambdaCode()
	}	
	def parseLambdaCode() {
		var split = value.split('''\|''',2)
		paramList = split.get(0).trim().split(",").map[trim]
		paramTypes = paramList.map[ trim().split(" ").get(0).trim() ]
		statements = new CodeParser().parse(split.get(1))
	}
}

@Accessors
class DictProp extends Prop { }
@Accessors
class CodeProp extends Prop {
	List<CodeStatement> statements = newArrayList()
}


class PropsParser {
	static var TOKENS_RE = Pattern.compile('''(\s+|[^ \[\{\}\]="]+|\{\{|\}\}|\{|\}|\[|\]|=|(?:(["'])(?:(?=(\\?))\3.)*?\2))''')
	String source;


	def consumeSpaces(Matcher m) {
		while (!m.hitEnd && m.group(1).trim() == "") {
			if (!m.find()) {
				return
			}
		}
	}
	def acceptProp(Matcher m) {
		var start = m.start
		var end = m.end
		var name = acceptPropName(m);
		var value = ""
		var type ="literal"
		if (name == null) {
			throw new Exception("Illegal character found, expecting property name. Found "+m.group(1))
		}
		if (accept("=",m) == null) {
			throw new Exception("Illegal character found, expecting '='. Found "+ m.group(1))
		}
		var bracket = acceptBracketOpen(m);
		if (bracket != null) {
			var Stack<String> stack = new Stack();
			stack.push(bracket)
			var text = ""
			if (bracket == "{{") {
				type = "dict"
			} else if (bracket == "{") {
				type = "code"
			} else if (bracket == "[") {
				type = "lambda"
			}
			while (!stack.empty()) {
				if (m.group(1).isBracketOpen) {
					stack.push(accept(m))
					text += stack.peek()
				} else if (m.group(1).isBracketClose) {
					if (stack.empty()) {
						throw new Exception("Found unmatched closing bracket "+m.group(1))
					} else if (closingOf(stack.peek()) != m.group(1)) {
						throw new Exception("Found unmatched closing bracket "+m.group(1) +", expected closing of "+ stack.peek())
					} else {
						end = m.end
						var closing = accept(m)
						if (stack.size() > 1) {
							text += closing
						}
						stack.pop()
					}
				} else {
					text += accept(m)
				}
			}
			value = text
		} else if (m.group(1).startsWith('"') || m.group(1).startsWith("'")) {
			type = "string"
			end = m.end
			value =  accept(m)
		} else {
			throw new Exception("Illegal character found, expecting string literal, dictionary, lambda or java code wrapped in braces. Found: "+m.group(1))			
		}

		if (type == "string") {
			var prop = new Prop(m)
			prop.start = start
			prop.end = end
			prop.text = source.substring(start,end)
			prop.name = name
			prop.value = value
			return prop
		} else if (type == "lambda") {
			var prop = new LambdaProp(m)
			prop.start = start
			prop.end = end
			prop.name = name
			prop.value = value
			prop.text = source.substring(start,end)
			return prop
		} else if (type == "dict") {
			var prop = new DictProp(m)
			prop.start = start
			prop.end = end
			prop.name = name
			prop.value = value
			prop.text = source.substring(start,end)
			return prop
		} else if (type == "code") {
			var prop = new CodeProp(m)
			prop.start = start
			prop.end = end
			prop.name = name
			prop.value = value
			prop.statements = new CodeParser().parse(value);
			prop.text = source.substring(start,end)
			return prop
		}
		return null
		
	}
	
	public def static closingOf(String bracket) {
		return #{
			"(" -> ")",
			"{" -> "}",
			"[" -> "]",
			"{{" -> "}}"
		}.get(bracket)
	}
	
	def acceptBracketOpen(Matcher m) {
		if (m.group(1) == "{" || m.group(1) == "[" || m.group(1) == "{{")  {
			return accept(m)
		}
		return null;
	}
	def isBracketOpen(String str) {
		return #["{{","{","["].findFirst[it == str] != null;
	}
	def isBracketClose(String str) {
		return #["}}","}","]"].findFirst[it == str] != null;
	}	
	def isBracket(String str) {
		return #["{{", "}}", "{", "}", "[", "]"].findFirst[it == str] != null;
	}
	def acceptPropName(Matcher m) {
		if (m.group(1).isBracket() || m.group(1) == "=" || m.group(1).trim() == "") {
			return null;
		}
		return accept(m)
	}
	
	def accept(String s, Matcher m) {
		if (m.group(1) == s) {
			return accept(m)
		}
		return null;
	}
	def accept(Matcher m) {
		var result = m.group(1);
//		System.out.println("Accepted "+result +" : "+m.start)
		m.find()
		return result
	}
	
	def parse(String str) {
		var List<Prop> props = new ArrayList<Prop>(); 
		source = str
		var matcher = TOKENS_RE.matcher(str)
		matcher.find()
		consumeSpaces(matcher)
		while (!matcher.hitEnd) {
			var prop = acceptProp(matcher)
			props += prop
			consumeSpaces(matcher)
		}
		return props
	}
		
}