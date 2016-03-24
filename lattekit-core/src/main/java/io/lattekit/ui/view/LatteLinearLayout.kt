package io.lattekit.ui.view

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
    }

}