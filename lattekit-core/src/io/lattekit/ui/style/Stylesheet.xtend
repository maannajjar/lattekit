package io.lattekit.ui.style

import com.google.common.base.CaseFormat
import java.util.HashMap
import java.util.Map

class Stylesheet {
	
	static Map<String, Stylesheet> styleSheets = new HashMap()
	
	Map<String, Style> classes = new HashMap()
	
	def static void registerStylesheet(String fileName, Stylesheet stylesheet) {
		styleSheets.put(fileName, stylesheet) 
	}
	
	def static Stylesheet getStylesheet(String fileName) {
		var parts = fileName.split("/");
		var clsName = CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_CAMEL,parts.last.replace(".css",""))+"Stylesheet";
		var packageName = parts.get(0);
		return Class.forName(packageName+"."+clsName).constructors.get(0).newInstance() as Stylesheet; 
	}
	
	def Style registerStyle(String selector_finalParam_, Style style) {
		var  selector=selector_finalParam_ 
		selector=selector.trim() var String[] allSelectors=selector.replaceAll("(.)>(.)", "$1 > $2").replaceAll("\\s\\s+", " ").trim().split(" ") 
		if (allSelectors.length === 1) {
			style.setDefinedSelector(selector) var Style existingStyle=classes.get(selector) 
			if (existingStyle !== null) {
				existingStyle.overrideWithStyle(style) // TODO: Should merge existing descendant with my descendants (e.g. if different files have same descendant)
				existingStyle.getDescendantStyles().putAll(style.getDescendantStyles()) existingStyle.getDirectChildrenStyles().putAll(style.getDirectChildrenStyles()) return existingStyle 
			} else {
				classes.put(selector, style) return style 
			}
		} else {
			var Style currentParent=null 
			var String currentRelation=null 
			
			for (var int i=0 ; i < allSelectors.length; i++) {
				var String currentSelector={val _rdIndx_allSelectors=i allSelectors.get(_rdIndx_allSelectors)}.trim() 
				var Style newStyle=new Style() 
				newStyle.setDefinedSelector(currentSelector) 
				
				if (i === allSelectors.length - 1) {
					newStyle=style 
				}
				if (i === 0) {
					newStyle=registerStyle(currentSelector, newStyle) 
				} else if (currentSelector.equals(">")) {
					currentRelation=">"
					
				} else {
					if (currentRelation !== null && currentRelation.equals(">")) {
						currentParent.getDirectChildrenStyles().put(currentSelector, newStyle) 
					} else {
						currentParent.getDescendantStyles().put(currentSelector, newStyle) 
					}
					currentRelation=null 
				}
				
				if (currentRelation != ">") currentParent = newStyle 
			}
			return currentParent 
		}
	}
	
	def void registerStyleForChild(String selector, String parentSelector, Style style) {
		// Add to parent
		var Style parent=getStyle(parentSelector) 
		if (parent === null) {
			parent=new Style() classes.put(parentSelector, parent) 
		}
		parent.getDirectChildrenStyles().put(selector, style) 
	}
	
	def void registerStyleForDescendant(String selector, String parentSelector, Style style) {
		// Add to parent
		var Style parent=getStyle(parentSelector) 
		if (parent === null) {
			parent=new Style() classes.put(parentSelector, parent) 
		}
		parent.getDescendantStyles().put(selector, style) 
	}
	
	def void registerClass(String className, Style style) {
		classes.put('''.«className»''', style) 
	}
	
	def Style getClass(String className) {
		return classes.get('''.«className»''') 
	}
	
	def Style getStyle(String simpleSelector) {
		return classes.get(simpleSelector) 
	}
	
	def void apply(Stylesheet stylesheet) {
		
	}
	
}