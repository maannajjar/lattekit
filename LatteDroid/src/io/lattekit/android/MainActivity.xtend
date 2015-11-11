package io.lattekit.android

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.ImageView
import io.lattekit.Latte
import io.lattekit.ui.style.MainStylesheet
import io.lattekit.ui.style.Style
import io.lattekit.ui.view.LatteView
import java.util.List

class MainActivity extends Activity implements OnClickListener {

	var latteCss = #[new MainStylesheet()];
	
	String myTitle = "Hello";
	String currentTheme = "mainTheme"
	var List<Integer> rowData = #[1,2,3,4,5];
	LatteView<ImageView> logoView;
	
	var Style testStyle = new Style => [
		borderColor = "#cccccc";
		backgroundColor = "#000000";
	];
	var String myBg = "#ffffff";
	var String myBgImage = null;
	var String theme = "light";
	var i = 0;

	@Latte
	var mainView = '''
		<LinearLayout cls={"container "+theme} orientation="vertical">
			<LinearLayout orientation="horizontal"  cls="topBar" style={{width:"match_parent"}}>
			</LinearLayout>
			for (i: 1 ..3) {
				<Button cls="mainButton" text="Hi There" style={{fontStyle: "bold-italic"}}  style={{marginLeft: "50dp"}} onClickListener={MainActivity.this} alignParentEnd={true}/>
			}
		
		</LinearLayout>
	'''
	
	@Override 
	override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState)
		contentView = mainView.buildView(this);
//		setContentView(R.layout.activity_main);
//		var button = findViewById(R.id.test) as Button;
//		
//		var ripple = new RippleDrawable(new ColorStateList(#[#[
//		]],#[ Color.BLACK ]), new ColorDrawable(Color.WHITE),null );
//		button.background = resources.getDrawable(R.drawable.latte_view_background);
//		findViewById(R.id.test2).background = ripple;

	}

	override onClick(View v) {
		myTitle ="WHAT IS UP";
		myBg = "#000000";
		theme = if (theme == "light") "dark" else "light";
		myBgImage = "ic_launcher";
		mainView.onStateChanged("Clicked");
		mainView.onStateChanged("Clicked");
		mainView.onStateChanged("Clicked");
		mainView.onStateChanged("Clicked");
		mainView.onStateChanged("Clicked");
	}



}
