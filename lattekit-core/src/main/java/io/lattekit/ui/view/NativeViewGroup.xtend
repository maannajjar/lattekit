package io.lattekit.ui.view

import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import java.util.Map
import java.util.List

class NativeViewGroup extends NativeView {

    var List<View> managedViews = newArrayList();
    def Class<? extends ViewGroup.LayoutParams> getLayoutParamsClass() {
        return ViewGroup.LayoutParams
    }
	def LayoutParams createLayoutParams() {
        return getLayoutParamsClass().constructors.findFirst[ parameterTypes.size == 2 &&
                                            parameterTypes.get(0) == typeof(int) &&
                                            parameterTypes.get(1) == typeof(int)].newInstance(-1,-1) as LayoutParams
    }

    def void onChildrenAdded() {}
	
	def mountChildren() {
		log(this+" Here about to add my children "+this.renderedViews.size)
        if (LatteView.RENDER_TARGET == ANDROID) {
            var List<View> newViews = newArrayList();
            var myContainer = this.androidView as ViewGroup;
            var i = 0;
            for(LatteView v : renderedViews) {
                var childLP = createLayoutParams();
                var View childView = v.buildAndroidViewTree(this.activity, childLP);
                if(i >= myContainer.childCount) {
                    myContainer.addView(childView, i, childLP)
                } else if(myContainer.getChildAt(i) == childView) {
                    // childView.layoutParams = childLP;
                } else {
                    childView.layoutParams = childLP;
                    myContainer.addView(childView,i, childLP);
                }
                v.androidView = childView
                newViews += childView;
                if(!v.isMounted) {
                    v.notifyMounted()
                }
                i++;
            }
            for(var z = i; z < myContainer.childCount; z++) {
                if (managedViews.contains(z)) myContainer.removeViewAt(z);
            }
            managedViews = newViews
        }
        onChildrenAdded()
	}
	
	override onPropsUpdated(Map<String, Object> oldProps) {
		return true
	}
	
}