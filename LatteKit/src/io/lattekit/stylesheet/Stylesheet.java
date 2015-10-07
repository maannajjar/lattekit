package io.lattekit.stylesheet;

import io.lattekit.ui.Style;

import java.util.HashMap;
import java.util.Map;

public class Stylesheet {
	static Map<String,Stylesheet> styleSheets = new HashMap<>();

	public static void registerStylesheet(String fileName,Stylesheet stylesheet) {
		styleSheets.put(fileName, stylesheet);
	}
	public static Stylesheet getStylesheet(String fileName) {
		return styleSheets.get(fileName);
	}
	
	public final void loadStylesheet(String filename) {
		
	}
	
	Map<String,Style> classes = new HashMap<>();
	public void registerClass(String className, Style style) {
		classes.put(className, style);
	}
	public Style getClass(String className) {
		return classes.get(className);
	}
	
	
	
}
