package io.lattekit.ui

import android.content.Context
import android.view.View
import android.widget.Button
import io.lattekit.State

public class xButton extends LatteView {

	@State private String label;

	def void init() {
	}

	override applyAttributes() {
		super.applyAttributes()
		var Button myButton = androidView as Button;
		myButton.text = getLabel();
	}


	override View createAndroidView(Context context) {
		return new Button(context);
	}

}