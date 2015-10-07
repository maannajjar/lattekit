package io.lattekit.android;

import android.app.Application;


public class MyApplication extends Application {
	  public void onCreate() {
	    super.onCreate();
//	    Stetho.initialize(
//	      Stetho.newInitializerBuilder(this)
//	        .enableDumpapp(
//	            Stetho.defaultDumperPluginsProvider(this))
//	        .enableWebKitInspector(
//	            Stetho.defaultInspectorModulesProvider(this))
//	        .build());
	  }
	}
