package io.lattekit.plugin.css.property

import android.content.Context
import android.graphics.Color
import io.lattekit.plugin.css.CssAccessory
import io.lattekit.plugin.css.NodeStyle
import io.lattekit.plugin.css.declaration.ColorValue
import io.lattekit.view.NativeView

/**
 * Created by maan on 2/22/16.
 */

class BackgroundCssProperty : CssProperty("background") {

    override val INHERITED = true
    override val INITIAL_VALUE: String? = "white"


    var backgroundColor : Int = Color.WHITE;
    var rippleColor : Int = Color.TRANSPARENT;
    var touchedBackgroundColor : Int = Color.WHITE;

    override fun computeValue(context: Context, view: NativeView, style: NodeStyle) {
        backgroundColor = Color.TRANSPARENT;
        touchedBackgroundColor = Color.TRANSPARENT;

        var bgDeclaration = style.getDeclaration("background-color")
        if (bgDeclaration != null) {
            backgroundColor = (bgDeclaration.value as ColorValue).color
        }
        var rippleDeclaration = style.getDeclaration("background-color")
        if (rippleDeclaration != null) {
            rippleColor = (rippleDeclaration.value as ColorValue).color
        }
        var touchedBg = style.getTouchedDeclaration("background-color")
        if (touchedBg != null) {
            touchedBackgroundColor = (touchedBg?.value as ColorValue).color
        }
    }

    override fun apply(view: NativeView, style: NodeStyle) {
        var css = CssAccessory.getCssAccessory(view)
        css.gradientDrawable.setColors(listOf(backgroundColor, backgroundColor).toIntArray())
        css.setRippleColor(rippleColor);
    }
}


