package io.lattekit.ui

import android.app.Activity
import android.util.Log
import android.view.View
import io.lattekit.Latte
import java.util.HashMap

@Latte
public class RelativeLayout extends LatteView {
	
	
	def void init() {
	}
	
	override applyAttributes() {
		super.applyAttributes()
		var view = androidView as android.widget.RelativeLayout;
	}
	
	override View createAndroidView(Activity a) {
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
			if (rootAndroidView.id == -1 && id != null) {
				rootAndroidView.id = id.hashCode;
			}
			if (id != null) {
				viewMap.put(id, rootAndroidView.id);
			}
			Log.d("Latte", '''My Id = «rootAndroidView.id»''')
		]
		
		subviews.forEach[
			addLayoutRules(viewMap)			
		]		
	}
	
	def addLayoutRules(LatteView virtualView, HashMap<String,Integer> viewIds) {
		var rootAndroidView = virtualView.rootAndroidView
		var oldParams = rootAndroidView.layoutParams as android.widget.RelativeLayout.LayoutParams;
		val newParams = new android.widget.RelativeLayout.LayoutParams(oldParams); 
				
		virtualView.attributes.forEach[key, value|
			if (key == "below") {
				newParams.addRule(android.widget.RelativeLayout.BELOW, viewIds.get(value));
			} else if (key == "above") {
				newParams.addRule(android.widget.RelativeLayout.ABOVE, viewIds.get(value));
			} else if (key == "toStartOf") {
				newParams.addRule(android.widget.RelativeLayout.START_OF, viewIds.get(value));
			} else if (key == "toEndOf") {
				newParams.addRule(android.widget.RelativeLayout.END_OF, viewIds.get(value));
			} else if (key == "alignStart") {
				newParams.addRule(android.widget.RelativeLayout.ALIGN_START, viewIds.get(value));
			} else if (key == "alignEnd") {
				newParams.addRule(android.widget.RelativeLayout.ALIGN_END, viewIds.get(value));
			} else if (key == "alignTop") {
				newParams.addRule(android.widget.RelativeLayout.ALIGN_TOP, viewIds.get(value));
			} else if (key == "alignBottom") {
				newParams.addRule(android.widget.RelativeLayout.ALIGN_BOTTOM, viewIds.get(value));
			} else if (key == "alignParentStart" && value == true) {
				newParams.addRule(android.widget.RelativeLayout.ALIGN_PARENT_START);
			} else if (key == "alignParentEnd" && value == true) {
				newParams.addRule(android.widget.RelativeLayout.ALIGN_PARENT_END);
			} else if (key == "alignParentTop" && value == true) {
				newParams.addRule(android.widget.RelativeLayout.ALIGN_PARENT_TOP);
			} else if (key == "alignParentBottom" && value == true) {
				newParams.addRule(android.widget.RelativeLayout.ALIGN_PARENT_BOTTOM);
			}

		]
		rootAndroidView.layoutParams =  newParams;		
	}
	
}