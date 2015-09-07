package io.lattekit.ui

import android.app.Activity
import android.widget.LinearLayout.LayoutParams
import io.lattekit.LatteView
import io.lattekit.State

@LatteView(
)
public class LinearLayout extends View {
	
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
	
	override android.view.View createAndroidView(Activity a) {
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