package io.lattekit

import java.util.List
import org.eclipse.xtend.lib.macro.AbstractFieldProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration

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
				addParameter("propertyName", String.newTypeReference())
				addParameter("value", Object.newTypeReference())
				val allSetters = new StringBuffer();
				
				properties.forEach[
					val name = if (it.simpleName.startsWith("_")) it.simpleName.substring(1) else it.simpleName;
					allSetters.append('''if (propertyName.equals("«name»")) { set«name.substring(0,1).toUpperCase+name.substring(1)»((«it.type.name»)value); }
					''');
				];
				body = '''
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
						return «initilizer»;
					}
					return _«rawName»;
				'''	
			} else {
				body = '''
					return _«rawName»;
				'''
			}
		];
		annotatedField.declaringType.addMethod("set" + capiatlized) [
			addParameter("newValue", rawType)
			body = '''
				_«rawName» = newValue;
			'''
		];
		annotatedField.initializer = '''null;''';
	}

}

@Active(typeof(StateProcessor))
annotation State {
}
class StateProcessor extends AbstractFieldProcessor {

	override doTransform(MutableFieldDeclaration annotatedField, extension TransformationContext context) {
		super.doTransform(annotatedField, context)
		val fieldName = annotatedField.simpleName;
		val rawType = annotatedField.type;

		val capiatlized = fieldName.substring(0, 1).toUpperCase + fieldName.substring(1);
		val rawName = fieldName;//"_state" + capiatlized;
		annotatedField.simpleName = "_"+rawName;
		annotatedField.addAnnotation(SuppressWarnings.newAnnotationReference [
			setStringValue("value","all")
		])
		
		
		annotatedField.markAsRead
		
		
		annotatedField.declaringType.addMethod("get" + capiatlized) [
			returnType = rawType
			body = '''
				return _«rawName»;
			'''

		];
		annotatedField.declaringType.addMethod("set" + capiatlized) [
			addParameter("newValue", rawType)
			body = '''
				_«rawName» = newValue;
				onStateChanged("«rawName»");
			'''
		];

	}

}