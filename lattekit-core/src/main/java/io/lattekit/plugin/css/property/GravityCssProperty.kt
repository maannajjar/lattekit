package io.lattekit.plugin.css.property

import android.content.Context
import android.widget.TextView
import io.lattekit.plugin.css.NodeStyle
import io.lattekit.plugin.css.declaration.GravityValue
import io.lattekit.ui.view.NativeView

/**
 * Created by maan on 3/5/16.
 */
class GravityCssProperty : CssProperty("gravity"){
    var gravity: Int? = null;

    override fun computeValue(context: Context, view: NativeView, style: NodeStyle) {
        var declaration = style.getDeclaration("gravity");
        gravity = if (declaration != null) {
            (declaration.value as GravityValue).value
        } else null
    }

    override fun apply(view: NativeView, style: NodeStyle) {
        if (gravity != null)  {
            (view.androidView as? TextView)?.gravity = gravity!!;
        }
    }
}