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
        subViews.forEach { clearRules(it); applyLayoutRules(it) }
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
            if (key == "layout_below") {
                params.addRule(android.widget.RelativeLayout.BELOW, value as Int);
            } else if (key == "layout_above") {
                params.addRule(android.widget.RelativeLayout.ABOVE, value as Int);
            } else if (key == "layout_toRightOf") {
                params.addRule(android.widget.RelativeLayout.RIGHT_OF, value as Int);
            } else if (key == "layout_toLeftOf") {
                params.addRule(android.widget.RelativeLayout.LEFT_OF, value as Int);
            } else if (key == "layout_toStartOf") {
                params.addRule(android.widget.RelativeLayout.START_OF, value as Int);
            } else if (key == "layout_toEndOf") {
                params.addRule(android.widget.RelativeLayout.END_OF, value as Int);
            } else if (key == "layout_alignStart") {
                params.addRule(android.widget.RelativeLayout.ALIGN_START, value as Int);
            } else if (key == "layout_alignLeft") {
                params.addRule(android.widget.RelativeLayout.ALIGN_LEFT, value as Int);
            } else if (key == "layout_alignEnd") {
                params.addRule(android.widget.RelativeLayout.ALIGN_END, value as Int);
            } else if (key == "layout_alignRight") {
                params.addRule(android.widget.RelativeLayout.ALIGN_RIGHT, value as Int);
            } else if (key == "layout_alignTop") {
                params.addRule(android.widget.RelativeLayout.ALIGN_TOP, value as Int);
            } else if (key == "layout_alignBottom") {
                params.addRule(android.widget.RelativeLayout.ALIGN_BOTTOM, value as Int);
            } else if (key == "layout_alignParentStart" ) {
                if (value == true || value == "true") params.addRule(android.widget.RelativeLayout.ALIGN_PARENT_START);
            } else if (key == "layout_alignParentLeft" ) {
                if (value == true || value == "true") params.addRule(android.widget.RelativeLayout.ALIGN_PARENT_LEFT);
            } else if (key == "layout_alignParentEnd") {
                if (value == true || value == "true") params.addRule(android.widget.RelativeLayout.ALIGN_PARENT_END);
            } else if (key == "layout_alignParentRight") {
                if (value == true || value == "true") params.addRule(android.widget.RelativeLayout.ALIGN_PARENT_RIGHT);
            } else if (key == "layout_alignParentTop") {
                if (value == true || value == "true") params.addRule(android.widget.RelativeLayout.ALIGN_PARENT_TOP);
            } else if (key == "layout_alignParentBottom") {
                if (value == true || value == "true") params.addRule(android.widget.RelativeLayout.ALIGN_PARENT_BOTTOM);
            } else if (key == "layout_centerInParent") {
                if (value == true || value == "true") params.addRule(android.widget.RelativeLayout.CENTER_IN_PARENT);
            } else if (key == "layout_centerHorizontal") {
                if (value == true || value == "true") params.addRule(android.widget.RelativeLayout.CENTER_HORIZONTAL);
            } else if (key == "layout_centerVertical") {
                if (value == true || value == "true") params.addRule(android.widget.RelativeLayout.CENTER_VERTICAL);
            }
        }
        rootAndroidView?.layoutParams = params
    }

}