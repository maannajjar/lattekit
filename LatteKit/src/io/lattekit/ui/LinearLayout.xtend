package io.lattekit.ui

import android.content.Context
import android.view.View
import android.widget.LinearLayout.LayoutParams
import io.lattekit.State

public class LinearLayout extends LatteView {
	
	@State String orientation;
	def void init() {
	}
	
	override applyAttributes() {
		super.applyAttributes()
		var view = androidView as android.widget.LinearLayout;
		if (orientation == "horizontal") {
			view.orientation = android.widget.LinearLayout.HORIZONTAL;
		} else {
			view.orientation = android.widget.LinearLayout.VERTICAL;
		}
	}
	
	override View createAndroidView(Context a) {
		return new android.widget.LinearLayout(a);
	}

	override LayoutParams createLayoutParams(int width, int height) {
		var lp = new android.widget.LinearLayout.LayoutParams(width, height);
		return lp
	}
}