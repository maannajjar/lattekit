package io.lattekit.android

import android.view.View
import android.view.View.OnClickListener
import io.lattekit.Css
import io.lattekit.Layout
import io.lattekit.ui.LatteActivity

@Css(files=#["io/lattekit/android/main.css"])
class MainActivity extends LatteActivity implements OnClickListener {

	String myTitle = "Hello";
	
	var String myBg = "#ffffff";
	var String myBgImage = null;
	var String theme = "light";


	@Layout
	override render() '''
		<LinearLayout cls={"container "+theme} orientation="vertical">
			
			<LinearLayout orientation="horizontal"  cls="topBar" style={{width:"match_parent"}}>
			</LinearLayout>
			for (i: 1 ..3) {
				<Button cls="mainButton" text={"Hi "+theme} style={{fontStyle: "bold-italic"}}  style={{marginLeft: "50dp"}} onClickListener={MainActivity.this} alignParentEnd={true}/>
			}
		
		</LinearLayout>
	'''

	override onClick(View v) {
		myTitle ="WHAT IS UP";
		myBg = "#000000";
		theme = if (theme == "light") "dark" else "light";
		myBgImage = "ic_launcher";
		onStateChanged();
	}
	
}
