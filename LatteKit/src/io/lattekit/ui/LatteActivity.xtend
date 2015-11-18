package io.lattekit.ui

import android.app.Activity
import android.os.Bundle
import io.lattekit.Layout
import io.lattekit.ui.view.LatteView

class LatteActivity extends Activity {
	 
	override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState)
		setContentView(render().buildView(this));
	}

	@Layout
	def LatteView<?> render() '''
		<FrameLayout style={{width:"match_parent", height:"match_parent"}}>
		</FrameLayout>
	'''
}