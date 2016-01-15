package io.lattekit.ui.view

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import java.util.Map

class NativeViewGroup extends NativeView {
	
	def LayoutParams createLayoutParams() {
        return null;
    }
	
	def void onChildrenAdded() {}
	
	def mountChildren() {
		Log.d("Latte",this+" Here about to add my children "+this.renderedViews.size)
        if (renderedViews.size > 0) {
            var myContainer = this.androidView as ViewGroup
            var i = 0;
            for (LatteView v : renderedViews) {
                var childLP = createLayoutParams();
                var View childView = v.buildAndroidViewTree(this.activity, childLP);
                if (i >= myContainer.childCount) {
                    myContainer.addView(childView, i, childLP)  
                } else if (myContainer.getChildAt(i) == childView) {
//                    	childView.layoutParams = childLP;
                } else {
                    childView.layoutParams = childLP;
                    myContainer.addView(childView,i, childLP);
                }
                v.androidView = childView
            
               
                if (!v.isMounted){
                	v.onViewMounted()
                }
                i++;
            }
            for (var z = i; z < myContainer.childCount; z++) {
                myContainer.removeViewAt(z);
            }
        }
        onChildrenAdded()
	}
	
	override onPropsUpdated(Map<String, Object> oldProps) {
		return true
	}
	
}