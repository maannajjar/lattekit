package io.lattekit.ui.view

import android.content.Context
import android.view.View
import org.eclipse.xtend.lib.annotations.Accessors

class ImageView extends LatteView<android.widget.ImageView> {
	
	@Accessors int src;
	@Accessors String scaleType;
	
	override applyAttributes() {
		super.applyAttributes()
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
	
	
	override View createAndroidView(Context a) {
		return new android.widget.ImageView(a);
	}
	
	
}