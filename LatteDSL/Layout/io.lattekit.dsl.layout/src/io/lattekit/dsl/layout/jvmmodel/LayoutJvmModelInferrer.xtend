package io.lattekit.dsl.layout.jvmmodel

import com.google.inject.Inject
import io.lattekit.dsl.layout.layout.LayoutFile
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder

/**
 * <p>Infers a JVM model from the source model.</p> 
 *
 * <p>The JVM model should contain all elements that would appear in the Java code 
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>     
 */
class LayoutJvmModelInferrer extends AbstractModelInferrer {

//    /**
//     * convenience API to build and initialize JVM types and their members.
//     */

	@Inject extension JvmTypesBuilder
   	def dispatch void infer(LayoutFile script, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
   		val className = script.eResource.URI.trimFileExtension.lastSegment
   		acceptor.accept(script.toClass(className)) [
   			// the class gets one main method
//   			val me = it;
//			script.eContents.filter[it instanceof TemplateExpression].forEach[
//				me.members += it.toMethod("buildLayout",  typeRef(Void.TYPE)) [
//					body = '''// Hello''';
//				]
//			]
//			me.members += it.toMethod("buildLayout",  typeRef(Void.TYPE)) [
//				body = '''// «script.eAllContents.map[it].join(",")»''';
//			]
   			
   			members += script.toMethod('main', typeRef(Void.TYPE)) [ it |
   				parameters += script.toParameter("args", typeRef(String).addArrayTypeDimension)
   				static = true
   				varArgs = true
   				// Associate the script as the body of the main method
   				body = script
//   				body = '''
//   					«FOR x : script.eContents»
//   						«x»
//   					«ENDFOR»
//   				'''
   			]	
   		]
  	}
//  	
//  	def compile(EObject e) {
//
//  	}
  	
//  	def dispatch void infer(TemplateExpression template, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
//  		acceptor.accept(template.toClass("Hello"))	[
//  			members += template.toMethod("buildLayout",  typeRef(Void.TYPE)) [
//  				body = template
//  			]
//  			
//  		]
//  	}

}

