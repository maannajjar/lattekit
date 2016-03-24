package io.lattekit.plugin.css.property

import android.content.Context
import io.lattekit.plugin.css.NodeStyle
import io.lattekit.plugin.css.declaration.LengthValue
import io.lattekit.view.NativeView

/**
 * Created by maan on 3/5/16.
 */
class SizeCssProperty : CssProperty("height") {
    var height : Int? = null;
    var width : Int? = null;
    override fun computeValue(context: Context, view: NativeView, style: NodeStyle) {
        var declaration = style.getDeclaration("height");
        height = if (declaration != null) {
            (declaration.value as LengthValue).inPixels(context).toInt()
        } else null
        declaration = style.getDeclaration("width");
        width = if (declaration != null) {
            (declaration.value as LengthValue).inPixels(context).toInt()
        } else null
    }

    override fun apply(view: NativeView, style: NodeStyle) {
        if (width != null) view.androidView?.layoutParams?.width = width
        if (height != null) view.androidView?.layoutParams?.height = height
    }
}