package io.lattekit

import org.eclipse.xtend.lib.macro.AbstractMethodProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration
import org.eclipse.xtend.lib.macro.TransformationContext

@Active(typeof(LatteProcessor))
annotation Latte {
}

class LatteProcessor extends AbstractMethodProcessor {
	
	override doTransform(MutableMethodDeclaration annotatedMethod, extension TransformationContext context) {
		annotatedMethod.returnType = findTypeGlobally("io.lattekit.ui.view.LatteView").newTypeReference();
		annotatedMethod.body = '''return null;'''
	}
	
}
