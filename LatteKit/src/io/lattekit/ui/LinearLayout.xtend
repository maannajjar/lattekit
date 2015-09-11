package io.lattekit.ui

import android.app.Activity
import android.view.View
import android.widget.LinearLayout.LayoutParams
import io.lattekit.Latte
import io.lattekit.State

@Latte
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
	
	override View createAndroidView(Activity a) {
		if (androidView == null) {
			androidView = new android.widget.LinearLayout(a);
			applyAttributes();
		}
		return androidView;
	}

	override LayoutParams createLayoutParams(int width, int height) {
		var lp = new android.widget.LinearLayout.LayoutParams(width, height);
		return lp
	}
}