package io.lattekit.ui.view

import android.content.Context
import android.view.View

class ImageView extends NativeView {
		
	def int getSrc() {
		return if (props.containsKey("src")) props.get("src") as Integer else 0;
	}

	def String getScaleType(){
		return if (props.containsKey("scaleType")) props.get("scaleType") as String else null
	}
	override applyProps() {
		super.applyProps()
		var view = androidView as android.widget.ImageView;
		if (src != 0) {
			view.imageResource = src;
		}
		
		if (scaleType != null) {
			view.scaleType = if (scaleType == "fitXY") {
				android.widget.ImageView.ScaleType.FIT_XY;
			} else {
				try {
					android.widget.ImageView.ScaleType.valueOf(scaleType.replaceAll("([A-Z])","_$1").toUpperCase);
				} catch (Exception ex) {
					null;
				}
			}
		}
		
	}
	
	
	override getViewClass() {
		return android.widget.ImageView;
	}
	
	
}