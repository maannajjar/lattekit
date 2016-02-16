package io.lattekit.ui.view

import android.view.View
import android.view.ViewGroup

/**
 * Created by maan on 2/15/16.
 */
class LinearLayout : NativeViewGroup() {

    var orientation : String? = null
        get() =  props.get("orientation") as String

    override fun applyProps() {
        super.applyProps()
        var view = androidView as android.widget.LinearLayout;
        if (orientation == "horizontal") {
            view.orientation = android.widget.LinearLayout.HORIZONTAL;
        } else {
            view.orientation = android.widget.LinearLayout.VERTICAL;
        }
    }

    override fun getViewClass() : Class<out View> {
        return android.widget.LinearLayout::class.java
    }

    override fun getLayoutParamsClass(): Class<out ViewGroup.LayoutParams> {
        return android.widget.LinearLayout.LayoutParams::class.java
    }

}