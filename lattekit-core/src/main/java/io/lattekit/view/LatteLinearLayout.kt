package io.lattekit.view

import android.view.Gravity

/**
 * Created by maan on 2/15/16.
 */
class LatteLinearLayout : NativeViewGroup() {

    var orientation : String? = null
        get() =  (props.get("orientation") ?: "vertical" ) as String

    override fun applyProps(props : Map<String,Any?>) {
        super.applyProps(props)
        var view = androidView as android.widget.LinearLayout;
        if (orientation == "horizontal") {
            view.orientation = android.widget.LinearLayout.HORIZONTAL;
        } else {
            view.orientation = android.widget.LinearLayout.VERTICAL;
        }

        if (props["gravity"] != null) {
            var value = props["gravity"]
            if (value is String) {
                view.setGravity(Gravity::class.java.getField(value.toUpperCase()).get(null) as Int)
            } else if (value is Int) {
                view.setGravity(value)
            }
        }
    }

}