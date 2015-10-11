package io.lattekit.android

import android.app.Activity
import android.os.Bundle
import io.lattekit.Latte
import io.lattekit.stylesheet.MainStylesheet
import io.lattekit.State

class MainActivity extends Activity {

	var latteCss = #[new MainStylesheet()];
	
	String myTitle = "Hello";
	
	@Latte
	var mainView = '''
		<RelativeLayout style="width: match_parent;height: match_parent">
			<CheckBox id="Button1" alignParentStart={true}  class="mainButton" label="Button 1" />
			<Button cls="mainButton" onClick={MainActivity.this.onClick();} style="font-size: 10" id="Button2" alignParentEnd={true} text={myTitle} />
		
		</RelativeLayout>
	'''
	
	@Override 
	override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState)		
		contentView = mainView.buildView(this);
	}

	
	def onClick() {
		myTitle ="WHAT IS UP";
		mainView.onStateChanged("Clicked");
	}



}
