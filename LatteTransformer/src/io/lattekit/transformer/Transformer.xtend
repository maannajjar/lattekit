package io.lattekit.transformer

import io.lattekit.transformer.extractor.GenricCodeExtractor
import io.lattekit.transformer.extractor.LayoutCode
import io.lattekit.transformer.parser.Prop
import io.lattekit.transformer.parser.TagParser
import io.lattekit.transformer.tree.Tag
import io.lattekit.transformer.tree.TextNode

class Transformer {
	
	def String compile(Prop prop) ''' "«prop.name»",«prop.value» '''
	def String compile(Tag tag) '''
		LatteView.createLayout("«tag.name»", LatteView.props(«tag.props.map[compile].join(",")»), new ChildrenProc() {
			public List<LatteView> apply(LatteView it) {
				List<LatteView> myChildren = new ArrayList<LatteView>();
				«FOR child:tag.childNodes»
					«IF child instanceof TextNode»«child.text»«ENDIF»
					«IF child instanceof Tag»
						myChildren.add(«child.compile»);
					«ENDIF»
					
				«ENDFOR»
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
		return sb.toString;
	}
	

}

