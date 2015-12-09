package io.lattekit

import io.lattekit.compiler.LayoutCompiler
import org.eclipse.xtend.lib.macro.AbstractFieldProcessor
import org.eclipse.xtend.lib.macro.AbstractMethodProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration

@Active(typeof(LayoutProcessor))
annotation Layout {
	String[] imports = #[]
}

class LayoutProcessor extends AbstractMethodProcessor {
	
	override doTransform(MutableMethodDeclaration annotatedMethod, extension TransformationContext context) {
		super.doTransform(annotatedMethod, context)

		val layoutStr = annotatedMethod.body.toString
		annotatedMethod.markAsRead
		
		val latteViewTR = findTypeGlobally("io.lattekit.ui.view.LatteView").newTypeReference();
		
		var importList = newArrayList("io.lattekit.ui.view", "android.widget","android.support.v4.widget","android.support.v7.widget","android.support.v13.widget");
		var importListParam = annotatedMethod.annotations.findFirst[ a|
			a.annotationTypeDeclaration == Layout.newTypeReference().type
		].getStringArrayValue("imports")
		
		if (importListParam.size > 0) {
			importList += importListParam 
		}

		val isAdHoc = annotatedMethod.simpleName != "render" || !latteViewTR.isAssignableFrom(annotatedMethod.declaringType.newTypeReference());
		val layoutSource = layoutStr.substring(3,layoutStr.length-3);
		if (isAdHoc) {
			annotatedMethod.returnType = latteViewTR;
		}
		val layoutCode = if (isAdHoc) { 
			LayoutCompiler.compileLayout(context,layoutSource,annotatedMethod.declaringType as MutableClassDeclaration,"null",importList);
		} else {
			LayoutCompiler.compileLayout(context,layoutSource,annotatedMethod.declaringType as MutableClassDeclaration,"this",importList);
		}
		
		annotatedMethod.body = '''
			«IF !isAdHoc»
				«layoutCode»
			«ELSE»
				«layoutCode»
				«IF annotatedMethod.declaringType.findDeclaredField("latteCss") != null»
					myView.loadStylesheets(this.latteCss);
				«ENDIF»
				return myView;
			«ENDIF»
		''';

	}
}


@Active(typeof(LayoutFieldProcessor))
annotation Latte {
	String[] imports = #[]
}

class LayoutFieldProcessor extends AbstractFieldProcessor {
	
	override doTransform(MutableFieldDeclaration annotatedField, extension TransformationContext context) {
		super.doTransform(annotatedField, context)

		val layoutStr = annotatedField.initializer.toString
		annotatedField.markAsRead
		
		val latteViewTR = findTypeGlobally("io.lattekit.ui.view.LatteView").newTypeReference();
		
		var importList = newArrayList("io.lattekit.ui.view", "android.widget","android.support.v4.widget","android.support.v7.widget","android.support.v13.widget");
		var importListParam = annotatedField.annotations.findFirst[ a|
			a.annotationTypeDeclaration == Latte.newTypeReference().type
		].getStringArrayValue("imports")
		
		if (importListParam.size > 0) {
			importList += importListParam 
		}
		val layoutSource = layoutStr.substring(3,layoutStr.length-3);
		val layoutCode = LayoutCompiler.compileLayout(context,layoutSource,annotatedField.declaringType as MutableClassDeclaration,"this",importList);

		annotatedField.type = latteViewTR;
		annotatedField.initializer = ''' 
			new io.lattekit.ui.view.LatteView() {
				public void render() {
					«layoutCode»
					«IF annotatedField.declaringType.findDeclaredField("latteCss") != null»
						myView.loadStylesheets(«annotatedField.declaringType.simpleName».this.latteCss);
					«ENDIF»
				}
			};
		''';

	}
	
	
}


