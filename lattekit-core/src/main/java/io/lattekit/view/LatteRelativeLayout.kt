package io.lattekit.view

import android.view.View
import android.view.ViewGroup

/**
 * Created by maan on 2/15/16.
 */
class LatteRelativeLayout : NativeViewGroup() {

    override fun getViewClass(): Class<out View> {
        return android.widget.RelativeLayout::class.java;
    }

    override fun getLayoutParamsClass(): Class<out ViewGroup.LayoutParams> {
        return android.widget.RelativeLayout.LayoutParams::class.java
    }

    override fun onChildrenAdded() {
        renderedViews.forEach { clearRules(it); applyLayoutRules(it) }
        this.androidView?.requestLayout()
    }

    fun clearRules(virtualView: LatteView) {
        for (i in 0..21-1) (virtualView.rootAndroidView?.layoutParams as android.widget.RelativeLayout.LayoutParams).removeRule(i);
    }

    fun applyLayoutRules(virtualView : LatteView) {
        var rootAndroidView = virtualView.rootAndroidView
        val params = rootAndroidView?.layoutParams as android.widget.RelativeLayout.LayoutParams;
        virtualView.props.forEach {
            var key = it.key;
            var value = it.value
            if (key == "below") {
                params.addRule(android.widget.RelativeLayout.BELOW, value as Int);
            } else if (key == "above") {
                params.addRule(android.widget.RelativeLayout.ABOVE, value as Int);
            } else if (key == "toStartOf") {
                params.addRule(android.widget.RelativeLayout.START_OF, value as Int);
            } else if (key == "toEndOf") {
                params.addRule(android.widget.RelativeLayout.END_OF, value as Int);
            } else if (key == "alignStart") {
                params.addRule(android.widget.RelativeLayout.ALIGN_START, value as Int);
            } else if (key == "alignEnd") {
                params.addRule(android.widget.RelativeLayout.ALIGN_END, value as Int);
            } else if (key == "alignTop") {
                params.addRule(android.widget.RelativeLayout.ALIGN_TOP, value as Int);
            } else if (key == "alignBottom") {
                params.addRule(android.widget.RelativeLayout.ALIGN_BOTTOM, value as Int);
            } else if (key == "alignParentStart" ) {
                if (value == true || value == "true") params.addRule(android.widget.RelativeLayout.ALIGN_PARENT_START);
            } else if (key == "alignParentEnd") {
                if (value == true || value == "true") params.addRule(android.widget.RelativeLayout.ALIGN_PARENT_END);
            } else if (key == "alignParentTop") {
                if (value == true || value == "true") params.addRule(android.widget.RelativeLayout.ALIGN_PARENT_TOP);
            } else if (key == "alignParentBottom") {
                if (value == true || value == "true") params.addRule(android.widget.RelativeLayout.ALIGN_PARENT_BOTTOM);
            }
        }
        rootAndroidView?.layoutParams = params
    }

}