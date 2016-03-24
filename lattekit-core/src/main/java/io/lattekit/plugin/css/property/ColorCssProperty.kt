package io.lattekit.plugin.css.property

import android.content.Context
import android.graphics.Color
import android.widget.TextView
import io.lattekit.plugin.css.NodeStyle
import io.lattekit.plugin.css.declaration.ColorValue
import io.lattekit.view.NativeView

/**
 * Created by maan on 2/25/16.
 */
class ColorCssProperty : CssProperty("color") {

    override val INHERITED = true
    override val INITIAL_VALUE: String? = "black"

    var color : Int = Color.BLACK

    override fun computeValue(context: Context, view: NativeView, style: NodeStyle) {
        var declaration = style.getDeclaration("color")
        if (declaration != null) {
            color = (declaration.value as ColorValue).color
        }
    }

    override fun apply(view: NativeView, style: NodeStyle) {
        if (view.androidView is TextView) {
            (view.androidView as TextView).setTextColor(color)
        }
    }
}

