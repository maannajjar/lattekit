package io.lattekit.android

import android.graphics.Color
import android.view.MotionEvent
import io.lattekit.Layout
import io.lattekit.State
import io.lattekit.ui.style.Style
import io.lattekit.ui.view.LatteView

class TestViewController extends LatteView {

	@State var int red = 50;
	@State var int green = 50;
	@State var int blue = 50;
	@State var int totalRows = 5;

	@State var String anchor = "Button1";

	new() {
		this.loadStylesheet(new MainStylesheet());
	}

	@State Style currentStyle = style;
	@State var int myColor = Color.GREEN;


	@Layout(imports=#["io.lattekit.android", "android.support.v4.view"])
	override render() '''
		<LinearLayout orientation="vertical">
			for (var i = 0;i<totalRows;i++) {
				<Button cls="mainButton" alignParentEnd={true} text="Button 2" />
			}
		</LinearLayout>
	'''
	
	def void addRow(VirtualGroup virtualGroup) {
		virtualGroup.totalRows = virtualGroup.totalRows + 1;
	}

	def void setMyAnchor(String a, MotionEvent e) {
		this.anchor = a;
	}


}