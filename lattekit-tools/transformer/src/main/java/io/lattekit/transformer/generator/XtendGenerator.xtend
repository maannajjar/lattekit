package io.lattekit.transformer.generator

import io.lattekit.transformer.parser.CodeProp
import io.lattekit.transformer.parser.CodeStatement
import io.lattekit.transformer.parser.DictProp
import io.lattekit.transformer.parser.LambdaProp
import io.lattekit.transformer.parser.Prop
import io.lattekit.transformer.tree.Tag
import io.lattekit.transformer.tree.TextNode
import java.util.List
import java.util.regex.Pattern

class XtendGenerator extends BaseGenerator {

	val static TOKENS_RE = Pattern.compile("(class\\s+([^\\s]*)\\s*(?:(extends|implements)\\s+([^ ]*)\\s*)\\{|(?:@Latte)\\s+(?:def|override)\\s+[^ ]+\\s+'''([^''']*)'''|('''|'|\")(?:(?=(\\\\?))\\7[\\S\\s])*?\\6|(\\/\\*)(?:(?=(\\\\?))\\9[\\S\\s])*?\\*\\/|\\/\\/.*|[\\S\\s])");

	override getTokensPattern() {
		return TOKENS_RE
	}

	def String compile(Prop prop) { prop.compileProp }

	def dispatch String compileProp(Prop prop) ''' "«prop.name»",«prop.value» '''

	def dispatch String compileProp(CodeProp prop) ''' "«prop.name»",«prop.value» '''

	def dispatch String compileProp(DictProp prop) ''' "«prop.name»",«prop.value» '''

	def dispatch String compileProp(LambdaProp prop) ''' "«prop.name»", [ «prop.paramList.join(",")» |
			«prop.statements.compileStatements»
		]'''

	def compileStatements(List<CodeStatement> statements) {
		if (statements.empty) {
			// TOOD: Warn of no-op
			return '''return null;'''
		} else if (statements.last.text.trim().endsWith("}")) {
			var i = statements.length
			// TOOD: Warn of no-return
			return '''«FOR x : i..<statements.length»
			«statements.get(i).text»
			«ENDFOR»
			return null;
			'''
		} else {
			var i = statements.length
			return '''«FOR x : i..<statements.length-1»
			«statements.get(i).text»
			«ENDFOR»
			return  «statements.last.text»«IF !statements.last.text.endsWith(";")»;«ENDIF»
			'''
		}
	}

	def getFirstParams(Tag tag) {
		if (findFQN(tag.name) !=
			null) {
			return '''"«findFQN(tag.name)»"'''
		} else {
			return '''#[«imports.map['''"«it»"'''].join(",")»],"«tag.name»"'''
		}
	}

	override String compile(Tag tag) '''
	«IF tag.parentTag == null»
	override render() { 
		return
	«ENDIF»
		LatteView.createLayout(«getFirstParams(tag)», LatteView.props(«tag.props.map[compile].join(",")»), new io.lattekit.ui.view.ChildrenProc() {
			override java.util.List<LatteView> apply() {
				var java.util.List<LatteView> myChildren = newArrayList();
				«FOR child : tag.childNodes»
					«IF child instanceof TextNode»«child.text»«ENDIF»
					«IF child instanceof Tag»
						myChildren.add(«child.compile»);
					«ENDIF»
				«ENDFOR»
				return myChildren;
			}
		})
	«IF tag.parentTag == null»
	}
	«ENDIF»		
	'''

}
