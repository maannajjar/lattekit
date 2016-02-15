package io.lattekit.ui.view

import android.content.Context
import android.view.View
import java.util.HashMap

public class RelativeLayout extends NativeViewGroup {
	
	
	override getViewClass() {
		return android.widget.RelativeLayout;
	}

	override getLayoutParamsClass() {
		return android.widget.RelativeLayout.LayoutParams
	}

	override onChildrenAdded() {
		if (RENDER_TARGET == ANDROID) {
			renderedViews.forEach[ clearRules applyLayoutRules ]
			this.androidView.requestLayout
		}
	}
	
	def clearRules(LatteView virtualView) {
		for (i:0..21) (virtualView.rootAndroidView.layoutParams as android.widget.RelativeLayout.LayoutParams).removeRule(i);
	}
	
	def applyLayoutRules(LatteView virtualView) {
		var rootAndroidView = virtualView.rootAndroidView
		val params = rootAndroidView.layoutParams as android.widget.RelativeLayout.LayoutParams; 
		virtualView.props.forEach[key, value|
			if (key == "below") {
				params.addRule(android.widget.RelativeLayout.BELOW, value as Integer);
			} else if (key == "above") {
				params.addRule(android.widget.RelativeLayout.ABOVE, value as Integer);
			} else if (key == "toStartOf") {
				params.addRule(android.widget.RelativeLayout.START_OF, value as Integer);
			} else if (key == "toEndOf") {
				params.addRule(android.widget.RelativeLayout.END_OF,value as Integer);
			} else if (key == "alignStart") {
				params.addRule(android.widget.RelativeLayout.ALIGN_START, value as Integer);
			} else if (key == "alignEnd") {
				 params.addRule(android.widget.RelativeLayout.ALIGN_END, value as Integer);
			} else if (key == "alignTop") {
				params.addRule(android.widget.RelativeLayout.ALIGN_TOP, value as Integer);
			} else if (key == "alignBottom") {
				params.addRule(android.widget.RelativeLayout.ALIGN_BOTTOM, value as Integer);
			} else if (key == "alignParentStart" ) {
				if (value == true || value == "true") params.addRule(android.widget.RelativeLayout.ALIGN_PARENT_START);
			} else if (key == "alignParentEnd") {
				if (value == true || value == "true") params.addRule(android.widget.RelativeLayout.ALIGN_PARENT_END);
			} else if (key == "alignParentTop") {
				if (value == true || value == "true") params.addRule(android.widget.RelativeLayout.ALIGN_PARENT_TOP);
			} else if (key == "alignParentBottom") {
				if (value == true || value == "true") params.addRule(android.widget.RelativeLayout.ALIGN_PARENT_BOTTOM);
			}
		]
		rootAndroidView.layoutParams = params
	}
	
}