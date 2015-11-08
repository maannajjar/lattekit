package io.lattekit.stylesheet;

import io.lattekit.ui.Style;

import java.util.HashMap;
import java.util.Map;

public class Stylesheet {
	static Map<String,Stylesheet> styleSheets = new HashMap<>();
	Map<String,Style> classes = new HashMap<>();

	public static void registerStylesheet(String fileName,Stylesheet stylesheet) {
		styleSheets.put(fileName, stylesheet);
	}
	public static Stylesheet getStylesheet(String fileName) {
		return styleSheets.get(fileName);
	}
	
	public Style registerStyle(String selector, Style style) {
		selector = selector.trim();		
		String[] allSelectors = selector.replaceAll("(.)>(.)","$1 > $2").replaceAll("\\s\\s+"," ").trim().split(" ");
		if (allSelectors.length == 1) {

			style.setDefinedSelector(selector);
			Style existingStyle = classes.get(selector);
			if (existingStyle != null) {
				existingStyle.overrideWithStyle(style);
				
				// TODO: Should merge existing descendant with my descendants (e.g. if different files have same descendant)
				existingStyle.getDescendantStyles().putAll(style.getDescendantStyles());
				existingStyle.getDirectChildrenStyles().putAll(style.getDirectChildrenStyles());
				
				return existingStyle;
			} else {
				classes.put(selector, style);
				return style;
			}
			
		} else {
			Style currentParent = null;
			String currentRelation = null;
			for (int i = 0;i<allSelectors.length;i++) {
				String currentSelector = allSelectors[i].trim();
				Style newStyle = new Style();
				newStyle.setDefinedSelector(currentSelector);
				if (i == allSelectors.length-1) {
					newStyle = style;
				}
				if (i == 0) {
					newStyle = registerStyle(currentSelector, newStyle);
				} else if (currentSelector.equals(">")) {
					currentRelation = ">";
					continue;
				} else {
					if (currentRelation != null && currentRelation.equals(">")) {
						currentParent.getDirectChildrenStyles().put(currentSelector, newStyle);
					} else {
						currentParent.getDescendantStyles().put(currentSelector, newStyle);
					}
					currentRelation = null;
				}
				currentParent = newStyle;
			}
			return currentParent;			
		}
		
	}
	public void registerStyleForChild(String selector, String parentSelector,Style style) {
		// Add to parent
		Style parent = getStyle(parentSelector);
		if (parent == null) {
			parent = new Style();
			classes.put(parentSelector, parent);
		}
		parent.getDirectChildrenStyles().put(selector, style);
	}	
	public void registerStyleForDescendant(String selector, String parentSelector,Style style) {
		// Add to parent
		Style parent = getStyle(parentSelector);
		if (parent == null) {
			parent = new Style();
			classes.put(parentSelector, parent);
		}
		parent.getDescendantStyles().put(selector, style);
	}	
	
	public void registerClass(String className, Style style) {
		classes.put("."+className, style);
	}
	public Style getClass(String className) {
		return classes.get("."+className);
	}

	public Style getStyle(String simpleSelector) {
		return classes.get(simpleSelector);
	}
	
	public void apply(Stylesheet stylesheet) {
		
	}
	
}
