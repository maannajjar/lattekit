package io.lattekit.transformer

import io.lattekit.transformer.extractor.GenericCodeExtractor
import io.lattekit.transformer.extractor.LayoutCode
import io.lattekit.transformer.parser.TagParser
import io.lattekit.transformer.tree.Tag

abstract class BaseTransformer {
	protected Iterable<String> imports;
	def String compile(Tag code);
	
	def String findFQN( String cls) {
		imports.findFirst[it.endsWith('''.«cls»''');]
	}
	
	def getExtractor() {
		return new GenericCodeExtractor();
	}

	def String transform(String source) {
		var extractor = getExtractor();
		extractor.readSource(source)
		val sb = new StringBuffer();
		var LayoutCode next;
		imports = #[
			"io.lattekit.ui.view.ImageView",
			"io.lattekit.ui.view.LinearLayout",
			"io.lattekit.ui.view.ListView",
			"io.lattekit.ui.view.RelativeLayout"
		] + extractor.imports
		while ((next = extractor.getNext()) != null) {
			var layouCode = new TagParser().parse(next.code)
			var compiledCode = compile(layouCode)
			next.matcher.appendReplacement(sb,compiledCode)
		}
		extractor.matcher.appendTail(sb)
		return sb.toString;
	}
	
}