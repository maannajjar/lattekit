package io.lattekit.ui.view

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams

class NativeViewGroup extends NativeView {
	
	def LayoutParams createLayoutParams() {
        return null;
    }
	
	def void onChildrenAdded() {}
	
	override onViewMounted() {
		super.onViewMounted()
		Log.d("Latte",this+" Here about to add my children "+this.children.size)
        if (children.size > 0) {
            var myContainer = this.androidView as ViewGroup
            var i = 0;
            for (LatteView v : children) {
                var childLP = createLayoutParams();
                if (childLP != null) {
                    // In case we get null LayoutParams, this means that view adapter doesn't want us to build & add the child
                    var View childView = v.buildAndroidViewTree(this.activity, childLP);
                    if (i >= myContainer.childCount) {
                        myContainer.addView(childView, i, childLP)  
                    } else if (myContainer.getChildAt(i) == childView) {
                    } else {
                        childView.layoutParams = childLP;
                        myContainer.addView(childView,i, childLP);
                    }
                }
                i++;
            }
            for (var z = i; z < myContainer.childCount; z++) {
                myContainer.removeViewAt(z);
            }
        }
        onChildrenAdded()
	}
	
}