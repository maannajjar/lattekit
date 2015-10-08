package io.lattekit.android

import android.content.Context
import android.graphics.Color
import android.view.MotionEvent
import android.view.View
import io.lattekit.Layout
import io.lattekit.State
import io.lattekit.stylesheet.MainStylesheet
import io.lattekit.ui.LatteView
import io.lattekit.ui.Style

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
		<RelativeLayout style="width: match_parent;height: match_parent">
			<CheckBox id="Button1" alignParentStart={true}  class="mainButton" label="Button 1" />
			<Button cls="mainButton" onClick={System.out.println("CLICKED ON "+$0); } style="font-size: 10" id="Button2" alignParentEnd={true} text="Button 2" />
		
		</RelativeLayout>
	'''

	def void addRow(VirtualGroup virtualGroup) {
		virtualGroup.totalRows = virtualGroup.totalRows + 1;
	}

	def void setMyAnchor(String a, MotionEvent e) {
		this.anchor = a;
	}

	@Layout
	def View getView(Context context) '''
		<RelativeLayout>
		</RelativeLayout>
	'''

}