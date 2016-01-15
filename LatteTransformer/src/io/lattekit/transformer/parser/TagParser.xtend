package io.lattekit.transformer.parser

import io.lattekit.transformer.tree.Tag
import io.lattekit.transformer.tree.TextNode
import java.util.Stack
import java.util.regex.Pattern

class TagParser {

	var tagPattern = Pattern.compile('''<(\/?)((?:\w|\.)*)(\s*\w+=(?:([\[{"'])(?:(?=(\\?))\5.*)?(?:\4|}|])))?(\s*\/?)>|([\s\S])''')
	var Stack<Tag> stack = new Stack<Tag>()
	
	def Tag parse(String code) {
		var m = tagPattern.matcher(code)
		var Tag lastTag = null
		while (m.find()) {
			if (m.group(7) != null && m.group(7) != "") {
				if (!stack.empty()) {
					var lastChild = (stack.peek().childNodes).last
					if (lastChild instanceof TextNode) {
						// Just concat with previous node
						lastChild.concat(m);
					} else {
						// Create new text node
						var TextNode textNode = new TextNode(m,code)
						stack.peek().childNodes += textNode
					}
				}
			} else if (m.group(1) == "/") {
//				System.out.println("Found closing tag "+m.group(2))
				if (stack.empty() ) {
//					System.out.println("ERROR: Unmatched closing tag. Not tags are open ")
				} else if ((stack.peek() as Tag).name != m.group(2)) {
//				 	System.out.println("ERROR: Unmatched closing tag.Found: "+ m.group(2)+" Expected: "+stack.peek().name)
				} else {
					lastTag = stack.pop()
				}
			} else {
//				System.out.println("Found tag "+m.group(2))
				var tag = new Tag(m, code)
				tag.start = m.start
				tag.attributesString = m.group(3);
				tag.props = new PropsParser().parse(tag.attributesString)
				tag.tagEnd = m.end
				tag.name = m.group(2);
				if (!stack.empty()) {
					stack.peek().childNodes += tag
				}
				if (m.group(6) == "") {
					stack.push(tag)
				} else {
					tag.selfClosed = true;
					lastTag = tag
				}
			}
		}
		
		return lastTag
	}
	
	
	def dispatch String dumpTree(TextNode tree) '''«tree.text»'''
	def dispatch String dumpTree(Tag tree) '''
		«IF tree.selfClosed»- «tree.name»«ELSE»
		- «tree.name»
			«FOR child: tree.childNodes»
			«IF child instanceof TextNode»
«dumpTree(child)»
			«ELSE»
				«dumpTree(child)»
			«ENDIF»
			«ENDFOR»
		«ENDIF»
	'''
}