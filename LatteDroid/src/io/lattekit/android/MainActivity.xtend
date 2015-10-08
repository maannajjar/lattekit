package io.lattekit.android

import android.app.Activity
import android.os.Bundle
import io.lattekit.Latte
import io.lattekit.stylesheet.MainStylesheet

class MainActivity extends Activity {
	
	var latteCss = #[new MainStylesheet()];
	
	var String myTitle = "Hello";
	var totalButtons = 3;
	
	@Latte
	var mainView = '''
		<LinearLayout orientation="vertical" style="width: match_parent;height: match_parent">
			for (int i =0 ; i< totalButtons; i++) {
				final int j = i;
				<Button id={"Button"+j} cls="mainButton" onClick={MainActivity.this.onClick();} style="font-size: 10" text={"Button"+j} />
			}
		</LinearLayout>
	'''

	@Override 
	override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState)		
		contentView = mainView.buildView(this);
	}

	
	def onClick() {
	
//		totalButtons++;
//		mainView.onStateChanged();
	}



}
