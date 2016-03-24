package io.lattekit.plugin.css.property

import android.content.Context
import android.view.View
import io.lattekit.plugin.css.NodeStyle
import io.lattekit.plugin.css.declaration.StringValue
import io.lattekit.view.NativeView

/**
 * Created by maan on 2/25/16.
 */
open class DisplayCssProperty : CssProperty("display") {

    var display : String = "block"
    override fun computeValue(context: Context, view: NativeView, style: NodeStyle) {
        var declaration = style.getDeclaration("display")
        if (declaration != null) {
            display = (declaration.value as StringValue).valueString;
        } else {
            display = "block";
        }
    }

    override fun apply(view: NativeView, style: NodeStyle) {
        view.androidView?.visibility = if (display == "none") View.GONE else View.VISIBLE;
    }
}