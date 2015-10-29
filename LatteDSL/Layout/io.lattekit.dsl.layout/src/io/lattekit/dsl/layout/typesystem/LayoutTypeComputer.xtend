package io.lattekit.dsl.layout.typesystem

import io.lattekit.dsl.layout.layout.TemplateExpression
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState
import org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer
import org.eclipse.xtext.xbase.XBlockExpression

class LayoutTypeComputer extends XbaseTypeComputer {
	
	override computeTypes(XExpression expression, ITypeComputationState state) {
		if(expression instanceof TemplateExpression) {
			_computeTypes(expression, state);
		} else {
			super.computeTypes(expression, state)
		}
	}
//	
	protected def _computeTypes(TemplateExpression expression, ITypeComputationState state) {
		super._computeTypes(expression as XBlockExpression, state);
		state.acceptActualType(getTypeForName(StringBuilder, state))
	}
//	 
//	protected def _computeTypes(RichStringForLoop expression, ITypeComputationState state) {
//		super._computeTypes(expression as XForLoopExpression, state)
//		state.acceptActualType(getTypeForName(StringBuilder, state))
//	}
}