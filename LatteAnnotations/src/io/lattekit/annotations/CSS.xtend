package io.lattekit.annotations

import java.util.List
import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration

@Active(typeof(CssProcessor))
annotation CSS {
	String[] files = #[];
}

class CssProcessor extends AbstractClassProcessor {

	override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
		super.doTransform(annotatedClass, context)
		
		val filesList = annotatedClass.annotations.findFirst[ a|
			a.annotationTypeDeclaration == CSS.newTypeReference().type
		].getStringArrayValue("files")
		
		annotatedClass.addMethod("getCssFiles") [
			returnType = List.newTypeReference(findTypeGlobally("io.lattekit.ui.style.Stylesheet").newTypeReference());
			body = '''
				java.util.List<io.lattekit.ui.style.Stylesheet> stylesheets = new java.util.ArrayList<io.lattekit.ui.style.Stylesheet>();
				«FOR file: filesList»
					stylesheets.add(io.lattekit.ui.style.Stylesheet.getStylesheet("«file»"));
				«ENDFOR»
				return stylesheets;
			'''
		];
		
	}
	
}