package io.lattekit.ui

import android.app.Activity
import android.os.Bundle
import android.view.View
import io.lattekit.Layout
import io.lattekit.ui.style.Stylesheet
import io.lattekit.ui.view.LatteView
import java.util.List

class LatteActivity extends Activity {
	
	var LatteView<?> latteView;
	var View androidView;
	
	override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		latteView =  LatteActivity.this.render();
		latteView.loadStylesheet(cssFiles);
		androidView = latteView.buildView(this);
		setContentView(androidView);
	}
	
	def onStateChanged() {
		latteView.onStateChanged();		
	}
	
	def List<Stylesheet> getCssFiles() {
		return #[]		
	}

	@Layout
	def LatteView<?> render() '''
		<FrameLayout style={{backgroundColor:"#ffffff"; width:"match_parent", height:"match_parent"}}>
		</FrameLayout>
	'''
}