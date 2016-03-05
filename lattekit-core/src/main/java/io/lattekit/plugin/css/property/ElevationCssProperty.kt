package io.lattekit.plugin.css.property

import android.content.Context
import android.os.Build
import io.lattekit.plugin.css.NodeStyle
import io.lattekit.plugin.css.declaration.LengthValue
import io.lattekit.ui.view.NativeView

/**
 * Created by maan on 2/25/16.
 */
class ElevationCssProperty : CssProperty("elevation") {
    var elevation : Float = 0f;
    override fun computeValue(context: Context, view: NativeView, style: NodeStyle) {
        var declaration = style.getDeclaration("elevation");
        if (declaration != null) {
            elevation = (declaration.value as LengthValue).inPixels(context)
        }
    }

    override fun apply(view: NativeView, style: NodeStyle) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            view.androidView?.elevation = elevation
        }
    }
}