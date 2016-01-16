package io.lattekit.transformer

import io.lattekit.transformer.extractor.GenricCodeExtractor
import io.lattekit.transformer.extractor.LayoutCode
import io.lattekit.transformer.parser.CodeProp
import io.lattekit.transformer.parser.CodeStatement
import io.lattekit.transformer.parser.DictProp
import io.lattekit.transformer.parser.LambdaProp
import io.lattekit.transformer.parser.Prop
import io.lattekit.transformer.parser.TagParser
import io.lattekit.transformer.tree.Tag
import io.lattekit.transformer.tree.TextNode
import java.util.List

class Transformer {
	def  String compile(Prop prop) { prop.compileProp }
	
	def dispatch String compileProp(Prop prop) ''' "«prop.name»",«prop.value» '''
	def dispatch String compileProp(CodeProp prop) ''' "«prop.name»",«prop.value» '''
	def dispatch String compileProp(DictProp prop) ''' "«prop.name»",«prop.value» '''
	def dispatch String compileProp(LambdaProp prop) ''' "«prop.name»", new org.eclipse.xtext.xbase.lib.Functions.Function«prop.paramList.size»<«FOR type: prop.paramTypes SEPARATOR ',' AFTER ','»«type»«ENDFOR»Object>() {
		public Object apply(«prop.paramList.join(",")») {
			«prop.statements.compileStatements»
		} 
	}'''
	
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
	
	def String compile(Tag tag) '''
		LatteView.createLayout("«tag.name»", LatteView.props(«tag.props.map[compile].join(",")»), new io.lattekit.ui.view.ChildrenProc() {
			public List<LatteView> apply() {
				List<LatteView> myChildren = new ArrayList<LatteView>();
				«FOR child:tag.childNodes»
					«IF child instanceof TextNode»«child.text»«ENDIF»
					«IF child instanceof Tag»
						myChildren.add(«child.compile»);
					«ENDIF»
				«ENDFOR»
				return myChildren;
			}
		})
	'''
	
	def String transform(String source) {
		var extractor = new GenricCodeExtractor();
		extractor.readSource(source)
		val sb = new StringBuffer();
		var LayoutCode next;
		while ((next = extractor.getNext()) != null) {
			var layouCode = new TagParser().parse(next.code)
			var compiledCode = compile(layouCode)
			next.matcher.appendReplacement(sb,compiledCode)
		}
		extractor.matcher.appendTail(sb)
		return sb.toString;
	}
	

}

