package io.lattekit.android;

import android.app.Application
import com.facebook.stetho.Stetho

class MyApplication extends Application {
	override onCreate() {
		super.onCreate();
	    Stetho.initialize(
	      Stetho.newInitializerBuilder(this)
	        .enableDumpapp(
	            Stetho.defaultDumperPluginsProvider(this))
	        .enableWebKitInspector(
	            Stetho.defaultInspectorModulesProvider(this))
	        .build());
	}
}
