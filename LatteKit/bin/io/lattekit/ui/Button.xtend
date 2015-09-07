package io.lattekit.ui

import android.app.Activity
import io.lattekit.LatteView
import io.lattekit.State

@LatteView
public class Button extends View {

	@State private String label;

	def void init() {
	}

	override applyAttributes() {
		super.applyAttributes()
		var android.widget.Button myButton = androidView as android.widget.Button;
		myButton.text = getLabel();
	}


	override android.view.View createAndroidView(Activity a) {
		if (androidView == null) {
			androidView = new android.widget.Button(a);
			applyAttributes();
		}
		
		return androidView;

	}

}