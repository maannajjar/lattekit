package io.lattekit.ui.view

import android.content.Context
import android.util.Log
import android.view.View
import java.util.HashMap

public class RelativeLayout extends LatteView<android.widget.RelativeLayout> {
	
	
	def void init() {
	}
		
	override View createAndroidView(Context a) {
		return new android.widget.RelativeLayout(a);
	}

	override android.widget.RelativeLayout.LayoutParams createLayoutParams(int width, int height) {
		var lp = new android.widget.RelativeLayout.LayoutParams(width, height);
		return lp
	}
	
	override onChildrenAdded() {
		super.onChildrenAdded()
		val viewMap = newHashMap()
		subviews.forEach[
			if (id != null) {
				viewMap.put(id, rootAndroidView.id);
			}
		]
		subviews.forEach[ clearRules ]
		subviews.forEach[ applyLayoutRules(viewMap) ]
	}
	
	def clearRules(LatteView<?> virtualView) {
		for (i:0..21) (virtualView.rootAndroidView.layoutParams as android.widget.RelativeLayout.LayoutParams).removeRule(i);
	}
	
	def applyLayoutRules(LatteView<?> virtualView, HashMap<String,Integer> viewIds) {
		var rootAndroidView = virtualView.rootAndroidView
		val params = rootAndroidView.layoutParams as android.widget.RelativeLayout.LayoutParams; 
		virtualView.attributes.forEach[key, value|
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