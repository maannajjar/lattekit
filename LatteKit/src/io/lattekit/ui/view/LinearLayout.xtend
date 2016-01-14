package io.lattekit.ui.view

import android.content.Context
import android.view.View
import android.widget.LinearLayout.LayoutParams

public class LinearLayout extends NativeViewGroup {
	
//	@Accessors String orientation;
	def void init() {
	}
	
	def String getOrientation() {
		return props.get("orientation") as String
	}
	override applyProps() {
		super.applyProps()
		var view = androidView as android.widget.LinearLayout;
		if (orientation == "horizontal") {
			view.orientation = android.widget.LinearLayout.HORIZONTAL;
		} else {
			view.orientation = android.widget.LinearLayout.VERTICAL;
		}
	}
	
	override View renderNative(Context a) {
		return new android.widget.LinearLayout(a);
	}

	override LayoutParams createLayoutParams() {
		var lp = new android.widget.LinearLayout.LayoutParams(0,0);
		return lp
	}
}