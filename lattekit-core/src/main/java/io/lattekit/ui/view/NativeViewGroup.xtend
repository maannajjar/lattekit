package io.lattekit.ui.view

import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import java.util.Map
import java.util.List
import android.view.Gravity

class NativeViewGroup extends NativeView {

    var List<View> managedViews = newArrayList();
    def Class<? extends ViewGroup.LayoutParams> getLayoutParamsClass() {
        if (this.androidView != null) {
            var Class<? extends ViewGroup.LayoutParams> cls = this.androidView.class.getDeclaredClasses.findFirst[name == this.androidView.class.name+"$LayoutParams"] as Class<? extends ViewGroup.LayoutParams>
            if (cls != null ) {
                return cls
            }
        }
        return ViewGroup.LayoutParams
    }
    def LayoutParams createLayoutParams() {
        return getLayoutParamsClass().constructors.findFirst[ parameterTypes.size == 2 &&
                                            parameterTypes.get(0) == typeof(int) &&
                                            parameterTypes.get(1) == typeof(int)].newInstance(-1,-1) as LayoutParams
    }

    def void onChildrenAdded() {}

    def applyChildLayoutProps(LatteView child, LayoutParams params) {
            child.props.keySet().filter[startsWith("layout_")].forEach[
                // TODO: Be more dynamic
                if (it == "layout_gravity") {
                    var value = child.props.get(it);
                    var field = params.class.getField("gravity");
                    field.setAccessible(true);
                    if (value instanceof String) {
                        var realVal = Gravity.getField(value.toUpperCase).get(null)
                        field.set(params,realVal)
                    } else if (value instanceof Integer) {
                        field.set(params, value)
                    }
                }
            ]
    }

    def mountChildren() {
        log(this+" Here about to add my children "+this.renderedViews.size)
        if (LatteView.RENDER_TARGET == ANDROID) {
            var List<View> newViews = newArrayList();
            var myContainer = this.androidView as ViewGroup;
            var i = 0;
            for(LatteView v : renderedViews) {
                var childLP = createLayoutParams();
                var View childView = v.buildAndroidViewTree(this.activity, childLP);
                applyChildLayoutProps(v,childLP)
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
        super.onPropsUpdated(oldProps);
        return true
    }

}