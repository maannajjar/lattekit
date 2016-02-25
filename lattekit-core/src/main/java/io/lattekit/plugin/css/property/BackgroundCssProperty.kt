package io.lattekit.plugin.css.property

import android.content.Context
import android.graphics.Color
import io.lattekit.plugin.css.CssAccessory
import io.lattekit.plugin.css.NodeStyle
import io.lattekit.plugin.css.declaration.ColorValue
import io.lattekit.ui.view.NativeView

/**
 * Created by maan on 2/22/16.
 */

class BackgroundCssProperty : CssProperty("background") {

    override val INHERITED = true
    override val INITIAL_VALUE: String? = "white"


    var backgroundColor : Int = Color.WHITE;

    override fun computeValue(context: Context, view: NativeView, style: NodeStyle) {
        var declarations = style.getDeclarations("background-color")
        declarations.forEach {
            if (it.value is ColorValue) {
                backgroundColor = it.value.color
            }
        }
    }

    override fun apply(view: NativeView,style: NodeStyle) {
        CssAccessory.getCssAccessory(view).gradientDrawable.setColors(listOf(backgroundColor, backgroundColor).toIntArray())
    }
}


