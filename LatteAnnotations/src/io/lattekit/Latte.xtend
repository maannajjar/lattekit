package io.lattekit

import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration

@Active(typeof(LatteViewProcessor))
annotation Latte {
	String[] variants = #[]
}

class LatteViewProcessor extends AbstractClassProcessor {
	
	override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
		super.doTransform(annotatedClass, context)
		val className = annotatedClass.simpleName;
		annotatedClass.addField("viewVariant") [
			type = String.newTypeReference
		]
		var variantList = #[ className ];
		var variantListParam = annotatedClass.annotations.findFirst[ a|
			a.annotationTypeDeclaration == Latte.newTypeReference().type
		].getStringArrayValue("variants")
		
		if (variantListParam.size > 0) {
			variantList = variantListParam 
		}
		
		val initMethod = annotatedClass.findDeclaredMethod("init",String.newTypeReference());
		variantList.forEach [ LatteViewUtil::addVariantMethods(context, annotatedClass,it,initMethod?.simpleName); ]
		
						
	}

}


class LatteViewUtil {

	def static addVariantMethods(extension TransformationContext context, MutableTypeDeclaration viewType, String variantName,String processingMethod) {
		val parentTypeRef = findTypeGlobally("io.lattekit.ui.LatteView").newTypeReference();


		val StringTypeRef = String.newTypeReference();		
		val AttrsProcTypeRef = Procedures.Procedure1.newTypeReference(viewType.newTypeReference())
		val returnTR = viewType.newTypeReference();
		viewType.addMethod(variantName) [
			static = true
			addParameter("parentView",  parentTypeRef)
			addParameter("id",  StringTypeRef)
			addParameter("attrs",  AttrsProcTypeRef)
			addParameter("children",  AttrsProcTypeRef)
			returnType = returnTR
			body = '''
				«viewType.simpleName» me = new «viewType.simpleName»();
				me.processNode(parentView,id,attrs,children);
				me.viewVariant = "«variantName»";
				«if (processingMethod != null) { "me."+processingMethod+"();" } else {""}»
				return me;
			'''
		];
		
		viewType.addMethod(variantName) [
			static = true
			addParameter("parentView",  parentTypeRef)
			addParameter("attrs",  AttrsProcTypeRef)
			addParameter("children",  AttrsProcTypeRef)
			returnType = returnTR
			body = '''
				«viewType.simpleName» me = new «viewType.simpleName»();
				me.processNode(parentView,null,attrs,children);
				me.viewVariant = "«variantName»";
				«if (processingMethod != null) { "me."+processingMethod+"();" } else {""}»
				return me;
			'''
		];			
		
		viewType.addMethod(variantName) [
			static = true
			addParameter("parentView",  parentTypeRef)
			addParameter("id",  StringTypeRef)
			addParameter("attrs",  AttrsProcTypeRef)
			returnType = returnTR
			body = '''
				«viewType.simpleName» me = new «viewType.simpleName»();
				me.processNode(parentView,id,attrs,null);
				me.viewVariant = "«variantName»";
				«if (processingMethod != null) { "me."+processingMethod+"();" } else {""}»
				return me;
			'''
		];
		
		
		viewType.addMethod(variantName) [
			static = true
			addParameter("parentView",  parentTypeRef)
			addParameter("attrs",  AttrsProcTypeRef)
			returnType = returnTR
			body = '''
				«viewType.simpleName» me = new «viewType.simpleName»();
				me.processNode(parentView,null,attrs,null);
				me.viewVariant = "«variantName»";
				«if (processingMethod != null) { "me."+processingMethod+"();" } else {""}»
				return me;
			'''
		];
					
		
		viewType.addMethod(variantName) [
			static = true
			addParameter("parentView",  parentTypeRef)
			addParameter("id",  StringTypeRef)
			returnType = returnTR
			body = '''
				«viewType.simpleName» me = new «viewType.simpleName»();;
				me.processNode(parentView,id,null,null);
				me.viewVariant = "«variantName»";
				«if (processingMethod != null) { "me."+processingMethod+"();" } else {""}»
				return me;
			'''
		];		
		
		viewType.addMethod(variantName) [
			static = true
			addParameter("parentView",  parentTypeRef)
			returnType = returnTR
			body = '''
				«viewType.simpleName» me = new «viewType.simpleName»();
				me.processNode(parentView,null,null,null);
				me.viewVariant = "«variantName»";
				«if (processingMethod != null) { "me."+processingMethod+"();" } else {""}»
				return me;
			'''
		];		
		
	}
		
}