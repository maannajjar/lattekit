package io.lattekit.transformer.extractor

import java.util.regex.Pattern

class XtendCodeExtractor extends GenericCodeExtractor  {
	var static xtendPattern = Pattern.compile("(?:@Latte)\\s+(?:def|override)\\s+[^ ]+\\s+'''([^''']*)'''");
	
	override getPattern() {
		return xtendPattern
	}	
}