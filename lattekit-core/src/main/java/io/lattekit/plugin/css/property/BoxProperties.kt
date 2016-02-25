package io.lattekit.plugin.css.property

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Color.TRANSPARENT
import android.graphics.drawable.*
import android.os.Build
import android.widget.TextView
import io.lattekit.plugin.css.NodeStyle
import io.lattekit.plugin.css.declaration.ColorValue
import io.lattekit.ui.view.NativeView

/**
 * Created by maan on 2/22/16.
 */
fun getBackgroundLayerDrawable(view: NativeView): LayerDrawable {
    var backgroundDrawable = view.data("css:backgroundLayerDrawable")
    if (backgroundDrawable == null) {
        backgroundDrawable = LayerDrawable(arrayOf(ColorDrawable(), ColorDrawable(), ColorDrawable()))
        backgroundDrawable?.setId(0, 0)
        backgroundDrawable?.setId(1, 1)
        backgroundDrawable?.setId(2, 2)

        // TODO Shape and Ripple
        var shapeDrawable = ShapeDrawable();
        view.data("css:shapeDrawable", shapeDrawable)
        var rippleColor = ColorStateList(arrayOf(intArrayOf()), intArrayOf(TRANSPARENT));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            view.androidView?.background = RippleDrawable(rippleColor, backgroundDrawable, shapeDrawable);
        } else {
            view.androidView?.background = codetail.graphics.drawables.RippleDrawable(rippleColor, backgroundDrawable, shapeDrawable);
        }
        view.data("css:backgroundLayerDrawable", backgroundDrawable)
    }
    return backgroundDrawable as LayerDrawable
}

class BackgroundCssProperty : ColorProperty("background") {

    override val INHERITED = true
    override val INITIAL_VALUE: String? = "white"

    var backgroundGradientDrawable: GradientDrawable? = null

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
        if (backgroundGradientDrawable == null) {
            backgroundGradientDrawable = GradientDrawable()
        }
        backgroundGradientDrawable?.setColors(listOf(backgroundColor, backgroundColor).toIntArray())

        getBackgroundLayerDrawable(view).setDrawableByLayerId(0, backgroundGradientDrawable)
    }
}


class ColorCssProperty : ColorProperty("color") {

    override val INHERITED = true
    override val INITIAL_VALUE: String? = "black"

    var color : Int = Color.BLACK

    override fun computeValue(context: Context, view: NativeView, style: NodeStyle) {
        var declaration = style.getDeclaration("color")
        if (declaration != null) {
            color = (declaration.value as ColorValue).color
        }
    }

    override fun apply(view: NativeView,style: NodeStyle) {
        if (view.androidView is TextView) {
            (view.androidView as TextView).setTextColor(color)
        }
    }
}

