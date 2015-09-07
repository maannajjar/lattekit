/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.lattekit;


import io.lattekit.device.LatteWindowManager;
import io.lattekit.device.Window;
import io.lattekit.view.LatteView;

import java.util.HashMap;

import android.graphics.Canvas;

/**
 *
 * @author maannj
 */
public class Simulator  {
	
	
	static Application app;
	static Canvas canvas;
	static volatile Window currentWindow;
	static LatteWindowManager windowManager = new LatteWindowManager() {
		
		@Override
		public void setCurrentWindow(Window w) {
			currentWindow = w;
			nativeInvalidate();
		};
		
		public Window createWindow() {
			return new Window() {
				
				@Override
				public void invalidate() {
					nativeInvalidate();	
				}
				
			};
			
		};
	};
    public static void run() {
    	String className = "com.sampleapp.SampleApp";
    	try {
			app = (Application) Class.forName(className).newInstance();
			app.setWindowManager(windowManager);
	    	int deviceWidth = 620;
	        int deviceHeight = 960;
	        
	        int height =  740;
	        float heightScale = (float)height/deviceHeight;
	        int width = (int)(deviceWidth*heightScale);
	        
	        LatteView.initDeviceConfig(width,height);
	        Application.app = app;
	        app.appLaunched(new HashMap<String, Object>());
	        currentWindow = windowManager.createWindow();
//	        currentWindow.setController(app.getRootViewController());
	        
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void handleEvent(int eventType, float x, float y) {
//    	currentWindow.getController().getView()._touchTest(x, y, eventType);
    }
    
    
	public static void draw(long canvasHandle) {
		Canvas canvas = new Canvas(canvasHandle);
//		currentWindow.getController().draw(canvas);
	}
	

	public native static void nativeInvalidate();

    // /Applications/eclipse/plugins/org.eclipse.xtext.xbase.lib.source_2.6.0.v201405210727.jar:/Applications/eclipse/plugins/com.google.guava.source_15.0.0.v201403281430.jar:/Applications/eclipse/plugins/org.eclipse.xtend.lib.source_2.6.0.v201405210727.jar
    
}
