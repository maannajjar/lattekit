package io.lattekit.dsl.layout

import com.google.inject.Inject
import org.eclipse.xtext.conversion.IValueConverter
import org.eclipse.xtext.conversion.ValueConverter
import org.eclipse.xtext.conversion.ValueConverterWithValueException
import org.eclipse.xtext.conversion.impl.STRINGValueConverter
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.util.Strings
import org.eclipse.xtext.xbase.conversion.XbaseValueConverterService

class LayoutValueConverterService extends XbaseValueConverterService {

	@Inject TextValueConverter textValueConverter
	
	@ValueConverter(rule = "TEXT")
	def IValueConverter<String> TEXT() {
		return textValueConverter;
	}
}

/**
 * removes the surrounding terminals in template text
 */
class TextValueConverter extends STRINGValueConverter {
	
	override protected toEscapedString(String value) {
		'»' + Strings.convertToJavaString(value, false) + '«'
	}		
	
	//TODO why is this needed?
	override protected convertFromString(String literal, INode node) throws ValueConverterWithValueException {
		return literal.substring(1, literal.length-1)
	}
	
}