package io.lattekit.ui.view

import android.content.Context
import android.view.View
import android.widget.LinearLayout.LayoutParams

public class LinearLayout extends NativeViewGroup {


    def String getOrientation() {
        return props.get("orientation") as String
    }
    override applyProps() {
        super.applyProps()
        var view = androidView as android.widget.LinearLayout;
        if (orientation == "horizontal") {
            view.orientation = android.widget.LinearLayout.HORIZONTAL;
        } else {
            view.orientation = android.widget.LinearLayout.VERTICAL;
        }
    }

    override getViewClass() {
        return android.widget.LinearLayout;
    }

    override getLayoutParamsClass() {
        return android.widget.LinearLayout.LayoutParams
    }
}