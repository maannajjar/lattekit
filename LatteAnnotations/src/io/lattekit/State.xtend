package io.lattekit

import org.eclipse.xtend.lib.macro.AbstractFieldProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration


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