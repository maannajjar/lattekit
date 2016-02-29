package io.lattekit.plugin.css

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.*
import android.os.Build
import io.lattekit.ui.drawable.BorderDrawable
import io.lattekit.ui.view.NativeView

/**
 * Created by maan on 2/25/16.
 */
inline fun NativeView.getCss() : CssAccessory {
    return CssAccessory.getCssAccessory(this);
}
inline fun NativeView.getStyle() : NodeStyle {
    return CssAccessory.getCssAccessory(this).style;
}
class CssAccessory(view : NativeView) {
    var style : NodeStyle = NodeStyle(view)
    var shapeDrawable : ShapeDrawable = ShapeDrawable()
    var gradientDrawable : GradientDrawable = GradientDrawable()
    var borderDrawable : BorderDrawable = BorderDrawable()
    var layerDrawable : LayerDrawable = LayerDrawable(arrayOf(gradientDrawable, ColorDrawable(), borderDrawable))

    companion object {
        fun getCssAccessory(view : NativeView) : CssAccessory {
            var accessory = view.data("css:accessory")
            if (accessory == null) {
                accessory = CssAccessory(view)
                view.data("css:accessory",accessory)
            }
            return accessory as CssAccessory
        }
    }

    init {
        layerDrawable.setId(0, 0)
        layerDrawable.setId(1, 1)
        layerDrawable.setId(2, 2)

        var rippleColor = ColorStateList(arrayOf(intArrayOf()), intArrayOf(Color.TRANSPARENT));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            view.androidView?.background = RippleDrawable(rippleColor, layerDrawable, shapeDrawable);
        } else {
            view.androidView?.background = codetail.graphics.drawables.RippleDrawable(rippleColor, layerDrawable, shapeDrawable);
        }
    }

}