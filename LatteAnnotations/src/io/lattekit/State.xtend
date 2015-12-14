package io.lattekit

import java.util.List
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
		
		
		if (annotatedField.declaringType.findDeclaredMethod("getStateFields") == null) {
			val properties = annotatedField.declaringType.declaredFields.filter[!annotations.filter[annotationTypeDeclaration.simpleName=="State"].empty];
			val propertyNames = properties.map[it.simpleName]
			annotatedField.declaringType.addMethod("getStateFields") [
				returnType = List.newTypeReference(String.newTypeReference());
				body = '''
					List<String> states = «if (annotatedField.declaringType.newTypeReference.name!="io.lattekit.ui.view.LatteView") "super.getStateFields()" else "new java.util.ArrayList<String>()"»;
					«propertyNames.map['''states.add("«if (it.startsWith("_")) it.substring(1) else it»")'''].join(";\n")»;
					return states;
				'''			
			]
			
			annotatedField.declaringType.addMethod("copyState") [
				returnType = Boolean.newTypeReference().primitiveIfWrapper
				addParameter("fromView", findTypeGlobally("io.lattekit.ui.view.LatteView").newTypeReference())
				val allSetters = new StringBuffer();
				
				properties.forEach[
					val name = if (it.simpleName.startsWith("_")) it.simpleName.substring(1) else it.simpleName;
					allSetters.append('''
						if (otherView.hasProperty("«name»")) {
							this._«name» = otherView._«name»;
							didCopy = true;
						}
					''');
				];
				body = '''
					boolean didCopy = false;
					«annotatedField.declaringType.newTypeReference().simpleName» otherView = («annotatedField.declaringType.newTypeReference().simpleName»)fromView;
					«if (annotatedField.declaringType.newTypeReference.name!="io.lattekit.ui.view.LatteView") "didCopy = super.copyState(otherView)"»;
					this.attributes = otherView.attributes;
					
					«allSetters.toString»
					return didCopy;
				'''
			]
			
			annotatedField.declaringType.addMethod("setProperty") [
				addParameter("propertyName", String.newTypeReference())
				addParameter("value", Object.newTypeReference())
				val allSetters = new StringBuffer();
				
				properties.forEach[
					val name = if (it.simpleName.startsWith("_")) it.simpleName.substring(1) else it.simpleName;
					allSetters.append('''if (propertyName.equals("«name»")) { set«name.substring(0,1).toUpperCase+name.substring(1)»((«it.type.name.replaceAll("\\$",".")»)value); }
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
		
		
		if (annotatedField.declaringType.findDeclaredMethod("get" + capiatlized) == null) {
			annotatedField.declaringType.addMethod("get" + capiatlized) [
				returnType = rawType
				body = '''
					return _«rawName»;
				'''
			];
		}
		
		if (annotatedField.declaringType.findDeclaredMethod("set" + capiatlized,rawType) == null) {
			annotatedField.declaringType.addMethod("set" + capiatlized) [
				addParameter("newValue", rawType)
				body = '''
					_«rawName» = newValue;
					onStateChanged("«rawName»");
				'''
			];
		}

	}

}