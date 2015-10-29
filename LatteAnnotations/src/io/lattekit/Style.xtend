package io.lattekit 

import java.util.List
import org.eclipse.xtend.lib.macro.AbstractFieldProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration
import com.google.common.base.CaseFormat

@Active(typeof(StylePropertyProcessor))
annotation StyleProperty {
}
class StylePropertyProcessor extends AbstractFieldProcessor {
	override doTransform(MutableFieldDeclaration annotatedField, extension TransformationContext context) {
		super.doTransform(annotatedField, context)
		val fieldName = annotatedField.simpleName;
		val rawType = annotatedField.type;

		val capiatlized = fieldName.substring(0, 1).toUpperCase + fieldName.substring(1);
		val rawName = fieldName;//"_state" + capiatlized;
		annotatedField.simpleName = "_"+rawName;
		annotatedField.addAnnotation(SuppressWarnings.newAnnotationReference [
			setStringValue("value","all")
		]);
		
		if (annotatedField.declaringType.findDeclaredField("_properties") == null) {
			val properties = annotatedField.declaringType.declaredFields.filter[!annotations.filter[annotationTypeDeclaration.simpleName=="StyleProperty"].empty];
			val propertyNames = properties.map[it.simpleName]
			annotatedField.declaringType.addField("_properties") [
				type = List.newTypeReference(String.newTypeReference());
				initializer = '''
				java.util.Collections.<String>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<String>newArrayList(«propertyNames.map['''"«if (it.startsWith("_")) it.substring(1) else it»"'''].join(",")»))
				'''			
			]
						
			annotatedField.declaringType.addMethod("setProperty") [
				addParameter("key", String.newTypeReference())
				addParameter("value", Object.newTypeReference())
				val allSetters = new StringBuffer();
				
				properties.forEach[
					val name = if (it.simpleName.startsWith("_")) it.simpleName.substring(1) else it.simpleName;
					if (it.type.name == "io.lattekit.ui.NumberValue") {
						allSetters.append('''if (propertyName.equals("«name»") && value instanceof io.lattekit.ui.NumberValue) { set«name.substring(0,1).toUpperCase+name.substring(1)»((io.lattekit.ui.NumberValue)value); }
						''');				
						allSetters.append('''if (propertyName.equals("«name»") && value instanceof String) { set«name.substring(0,1).toUpperCase+name.substring(1)»((String)value); }
						''');														
					} else {
						allSetters.append('''if (propertyName.equals("«name»")) { set«name.substring(0,1).toUpperCase+name.substring(1)»((«it.type.name»)value); }
					''');						
					}
				];
				body = '''
					String propertyName = key;
					if (!_properties.contains(key)) {
						propertyName = com.google.common.base.CaseFormat.LOWER_HYPHEN.to(com.google.common.base.CaseFormat.LOWER_CAMEL,key);
					}
					«allSetters.toString»
				'''
			]
			
			annotatedField.declaringType.addMethod("getProperty") [
				addParameter("propertyName", String.newTypeReference())
				returnType = Object.newTypeReference
				val allGetters = new StringBuffer();
				properties.forEach[
					val name = if (it.simpleName.startsWith("_")) it.simpleName.substring(1) else it.simpleName;
					allGetters.append('''if (propertyName.equals("«name»")) { return get«name.substring(0,1).toUpperCase+name.substring(1)»(); }
					''');
				];
				body = '''
					«allGetters.toString»
					return null;
				'''
			]			
		} 
		
		annotatedField.markAsRead
		
		
		val initilizer = annotatedField.initializer;
		annotatedField.declaringType.addMethod("get" + capiatlized) [
			returnType = rawType
			if (initilizer != null) {
				body = '''
					if (_«rawName» == null) {
						if (parentStyle == null) {
							return «initilizer»;
						} else {
							return parentStyle.get«capiatlized»();
						}
					}
					return _«rawName»;
				'''	
			} else {
				body = '''
					if (_«rawName» == null && parentStyle != null) {
						return parentStyle.get«capiatlized»();
					}				
					return _«rawName»;
				'''
			}
		];
		
		if (rawType.simpleName == "NumberValue") {
			
			annotatedField.declaringType.addMethod("set"+capiatlized) [
				addParameter("value", Integer.newTypeReference())
				body = '''
					_«rawName» = new NumberValue(value,0);
				'''
			]
			
			annotatedField.declaringType.addMethod("set"+capiatlized) [
				addParameter("value", String.newTypeReference())
				body = '''
					if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
						_«rawName» = new NumberValue(io.lattekit.ui.LatteView.MATCH_PARENT,0);
					} else if (value.toLowerCase().equals("wrap_content")) {
						_«rawName» = new NumberValue(io.lattekit.ui.LatteView.WRAP_CONTENT,0);
					} else {
						int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
						if (value.indexOf("dp")  != -1) {
							unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
						} else if (value.indexOf("sp") != -1) {
							unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
						} else if (value.indexOf("pt")  != -1) {
							unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
						}
						_«rawName» = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
					}
				'''
			]
			
		}

		annotatedField.declaringType.addMethod("set" + capiatlized) [
			addParameter("newValue", rawType)
			body = '''
				_«rawName» = newValue;
			'''
		];
		annotatedField.initializer = '''null;''';
	}

}