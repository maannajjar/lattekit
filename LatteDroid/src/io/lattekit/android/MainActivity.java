package io.lattekit.android;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TestViewController c = new TestViewController();
		c.renderOn(this);
	}
 
}
