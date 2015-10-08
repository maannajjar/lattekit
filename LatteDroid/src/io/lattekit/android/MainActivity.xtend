package io.lattekit.android

import android.app.Activity
import android.os.Bundle
import io.lattekit.Layout
import io.lattekit.stylesheet.MainStylesheet

class MainActivity extends Activity {
	
	var latteCss = #[new MainStylesheet()];
	
	@Override 
	override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState)
		var TestViewController c = new TestViewController()
		c.renderOn(this)
		
//		contentView = render();
	}


//	@Layout(imports=#["io.lattekit.android", "android.support.v4.view"])
//	def render() '''
//		<RelativeLayout style="width: match_parent;height: match_parent">
//			<CheckBox id="Button1" alignParentStart={true}  class="mainButton" label="Button 1" />
//			<Button cls="mainButton" onClick={System.out.println("CLICKED ON "+$0); } style="font-size: 10" id="Button2" alignParentEnd={true} text="BUTTON HI" />
//		
//		</RelativeLayout>
//	'''

}
