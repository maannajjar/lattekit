package io.lattekit.dsl.layout.jvmmodel

import io.lattekit.dsl.layout.layout.TemplateExpression
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.compiler.XbaseCompiler
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable

class LayoutCompiler extends XbaseCompiler {
//	
	public static var i = 0;
	override doInternalToJavaStatement(XExpression expr, ITreeAppendable tree, boolean isReferenced) {
		switch expr {
			TemplateExpression: {
				expr.compile(tree,isReferenced);
			}
			default: {
				System.out.println("Compiling "+ expr)
				super.doInternalToJavaStatement(expr, tree, isReferenced)
			}
		}
	}
	
	
	def compile(TemplateExpression expr, ITreeAppendable tree,boolean isReferenced) {
		val viewName = "view"+(i++);
		val attrProcName = "createAttributes_view"+(i++);
		val childrenProcName = "createChildren_view"+(i++);
		tree.newLine
		tree.append('''// START MARKER''')
		tree.append('''io.lattekit.ui.LatteView «viewName» = new io.lattekit.ui.LatteView();''')
		tree.newLine
		tree.append('''
			final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.LatteView> «attrProcName» = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.LatteView>() {
				public void apply(final io.lattekit.ui.LatteView it) {
					// TODO: HANDLE ATTRS
				}
			};
		''')
		tree.newLine
		tree.append("final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.LatteView> "+childrenProcName+" = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.LatteView>() {");
		tree.newLine
			tree.increaseIndentation
			tree.newLine
			tree.append("public void apply(final io.lattekit.ui.LatteView it) {");
			tree.newLine
				tree.increaseIndentation
				expr.expressions.forEach [
					doInternalToJavaStatement(it,tree,isReferenced)
				]
				tree.decreaseIndentation
			tree.newLine
			tree.append("}")
			tree.decreaseIndentation
		tree.newLine
		tree.append("};")
		tree.newLine
		tree.append(viewName+".processNode(it, "+attrProcName+","+childrenProcName+" );")
		tree.append('''// END MARKER''')
	}
//	override protected doInternalToJavaStatement(XExpression expr, ITreeAppendable it, boolean isReferenced) {
//		switch expr {
//			RichString : {
//				val name = declareVariable(expr, '_appendable')
//				newLine
//				append('''
//					StringBuilder «name» = new StringBuilder();
//				''')
//				for (nestedExpression : expr.expressions) {
//					nestedExpression.internalToJavaStatement(it, true)
//					newLine
//					append('''«name».append(org.eclipse.xtext.xbase.lib.ObjectExtensions.operator_elvis(''')
//					nestedExpression.internalToJavaExpression(it)
//					append(',""));')
//				}
//			}
//			
//			RichStringForLoop : {
//				expr.forExpression.internalToJavaStatement(it, true)
//				val paramType = getLightweightType(expr.declaredParam)
//				val name = declareVariable(expr, '_forLoopResult')
//				newLine
//				append('''
//					StringBuilder «name» = new StringBuilder();
//					for (final ''')
//				if (paramType != null) {
//					append(paramType);
//				} else {
//					append("Object");
//				}
//				append(''' «declareVariable(expr.declaredParam, makeJavaIdentifier(expr.declaredParam.name))» : ''')
//				internalToJavaExpression(expr.forExpression, it)
//				append(") {").increaseIndentation
//					expr.eachExpression.internalToJavaStatement(it, true)
//					newLine
//					append('''«name».append(''')
//					expr.eachExpression.internalToJavaExpression(it)
//					append(');')
//				decreaseIndentation.newLine.append("}")
//			}
//			
//			default :
//				super.doInternalToJavaStatement(expr, it, isReferenced)
//		}
//	}
//	
//	override protected internalToConvertedExpression(XExpression obj, ITreeAppendable it) {
//		if (hasName(obj))
//			append(getName(obj))
//		else 
//			super.internalToConvertedExpression(obj, it) 
//	}
	
}