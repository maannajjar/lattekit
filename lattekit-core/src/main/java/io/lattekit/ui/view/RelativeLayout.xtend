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
			val viewMap = newHashMap()
			renderedViews.forEach[
				if(it.id != null) {
					viewMap.put(it.id, it.rootAndroidView.id);
				}
			]
			renderedViews.forEach[ clearRules ]
			renderedViews.forEach[ applyLayoutRules(viewMap) ]
		}
	}
	
	def clearRules(LatteView virtualView) {
		for (i:0..21) (virtualView.rootAndroidView.layoutParams as android.widget.RelativeLayout.LayoutParams).removeRule(i);
	}
	
	def applyLayoutRules(LatteView virtualView, HashMap<String,Integer> viewIds) {
		var rootAndroidView = virtualView.rootAndroidView
		val params = rootAndroidView.layoutParams as android.widget.RelativeLayout.LayoutParams; 
		virtualView.props.forEach[key, value|
			if (key == "below") {
				params.addRule(android.widget.RelativeLayout.BELOW, viewIds.get(value));
			} else if (key == "above") {
				params.addRule(android.widget.RelativeLayout.ABOVE, viewIds.get(value));
			} else if (key == "toStartOf") {
				params.addRule(android.widget.RelativeLayout.START_OF, viewIds.get(value));
			} else if (key == "toEndOf") {
				params.addRule(android.widget.RelativeLayout.END_OF, viewIds.get(value));
			} else if (key == "alignStart") {
				params.addRule(android.widget.RelativeLayout.ALIGN_START, viewIds.get(value));
			} else if (key == "alignEnd") {
				 params.addRule(android.widget.RelativeLayout.ALIGN_END, viewIds.get(value));
			} else if (key == "alignTop") {
				params.addRule(android.widget.RelativeLayout.ALIGN_TOP, viewIds.get(value));
			} else if (key == "alignBottom") {
				params.addRule(android.widget.RelativeLayout.ALIGN_BOTTOM, viewIds.get(value));
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