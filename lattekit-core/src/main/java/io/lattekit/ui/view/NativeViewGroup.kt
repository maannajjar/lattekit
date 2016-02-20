package io.lattekit.ui.view

import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import java.util.*

/**
 * Created by maan on 2/15/16.
 */
open class NativeViewGroup : NativeView() {

    var managedViews = ArrayList<View>();

    open fun getLayoutParamsClass() : Class<out ViewGroup.LayoutParams> {
        if (this.androidView != null) {
            var cls = this.androidView?.javaClass?.getDeclaredClasses()?.find{ it.name == this.androidView?.javaClass?.name+"\$LayoutParams" } as Class<out ViewGroup.LayoutParams>?
            if (cls != null ) {
                return cls
            }
        }
        return ViewGroup.LayoutParams::class.java
    }

    fun createLayoutParams() : ViewGroup.LayoutParams {
        return getLayoutParamsClass().constructors.find{
                it.parameterTypes.size == 2 &&
                it.parameterTypes[0] == Integer.TYPE &&
                it.parameterTypes[1] == Integer.TYPE
            }?.newInstance(-1,-1) as ViewGroup.LayoutParams
    }

    open fun onChildrenAdded() {}

    fun applyChildLayoutProps(child: LatteView, params: ViewGroup.LayoutParams) {
        child.props.forEach {
            var keyName = it.key
            if (keyName.startsWith("layout_")) {
                // TODO: Be more dynamic
                if (keyName == "layout_gravity") {
                    var value = child.props.get(keyName);
                    var field = params.javaClass.getField("gravity");
                    field.setAccessible(true);
                    if (value is String) {
                        var realVal = Gravity::class.java.getField(value.toUpperCase()).get(null)
                        field.set(params, realVal)
                    } else if (value is Integer) {
                        field.set(params, value)
                    }
                }
            }
        }
    }

    fun mountChildren() {
        log("${this.androidView} Here about to add my children " + this.renderedViews.size)
        var newViews = ArrayList<View>();
        var myContainer = this.androidView as ViewGroup;

        for(i in 0..Math.max(managedViews.size,renderedViews.size)-1) {
            if (i < renderedViews.size) {
                var v = renderedViews[i]

                var childLP = createLayoutParams();
                var childView = v.buildAndroidViewTree(this.activity as Context, childLP);
                applyChildLayoutProps(v, childView.layoutParams)
                if (i >= managedViews.size) {
                    myContainer.addView(childView);
                }

                v.androidView = childView
                newViews.add(childView);
                if (!v.isMounted) {
                    v.notifyMounted()
                }
            } else if (i < managedViews.size) {
                myContainer.removeViewInLayout(managedViews.get(i))
            }
        }
        managedViews = newViews

        onChildrenAdded()
    }

    override fun onPropsUpdated(oldProps: Map<String, Any?>): Boolean {
        super.onPropsUpdated(oldProps);
        return true
    }

}