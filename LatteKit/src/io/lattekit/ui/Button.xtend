package io.lattekit.ui

import android.app.Activity
import android.view.View
import io.lattekit.Latte
import io.lattekit.State

@Latte
public class Button extends LatteView {

	@State private String label;

	def void init() {
	}

	override applyAttributes() {
		super.applyAttributes()
		var android.widget.Button myButton = androidView as android.widget.Button;
		myButton.text = getLabel();
	}


	override View createAndroidView(Activity a) {
		return new android.widget.Button(a);
	}

}