package io.lattekit.plugin.css

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.*
import android.os.Build
import io.lattekit.R
import io.lattekit.drawable.BorderDrawable
import io.lattekit.view.NativeView

/**
 * Created by maan on 2/25/16.
 */
inline fun NativeView.getCss() : CssAccessory {
    return CssAccessory.getCssAccessory(this);
}
inline fun NativeView.getStyle() : NodeStyle {
    return CssAccessory.getCssAccessory(this).style;
}
//
//class SelectorQuery(selectors : List<String>) {
//    var segments: List<String> = selectors;
//    var currentIndex : Int = 0
//    var type : Int = 0;
//    val DESCENDANT_TYPE = 1;
//    val CHILD_TYPE = 2;
//
//    val isMatched : Boolean
//        get() = currentIndex == segments.size
//
//    init {
//        advance()
//    }
//
//    fun advance()  {
//        if (currentIndex+1 < segments.size) {
//            currentIndex += 1
//
//        }
//    }
//
//    fun match(viewType : String, viewClasses : List<String>, viewId : String) : SelectorQuery? {
//        if (currentIndex >= segments.size) {
//            return null
//        }
//        var currentEl = segments[currentIndex]
//        if (currentEl.startsWith(".") && viewClasses.contains(currentEl.substring(1))) {
//
//        }
//    }
//
//
//}
class CssAccessory(view : NativeView) {
    var style : NodeStyle = NodeStyle(view)
    var shapeDrawable : ShapeDrawable = ShapeDrawable()
    var gradientDrawable : GradientDrawable = GradientDrawable()
    var borderDrawable : BorderDrawable = BorderDrawable()
    var rippleDrawable : Drawable? = null;

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
        var rippleColor = ColorStateList(arrayOf(intArrayOf()), intArrayOf(Color.TRANSPARENT));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            rippleDrawable = view.androidView!!.resources.getDrawable(R.drawable.ripple).mutate();
            var drawable =  rippleDrawable as RippleDrawable
            drawable.setDrawableByLayerId(R.id.border_layer, borderDrawable)
            drawable.setDrawableByLayerId(R.id.background_layer, gradientDrawable)
            if (view.androidView?.background != null) {
                drawable.setDrawableByLayerId(R.id.native_background_layer,view.androidView?.background);
            }
        } else {
            var layerDrawable : LayerDrawable = LayerDrawable(arrayOf(gradientDrawable, ColorDrawable(), borderDrawable,ColorDrawable()))
            layerDrawable.setId(0, 0)
            layerDrawable.setId(1, 1)
            layerDrawable.setId(2, 2)
            layerDrawable.setId(3,3)
            rippleDrawable = codetail.graphics.drawables.RippleDrawable(rippleColor, layerDrawable, shapeDrawable);
            if (view.androidView?.background != null) {
                layerDrawable.setDrawableByLayerId(3,view.androidView?.background);
            }
        }
        view.androidView?.background = rippleDrawable;
    }

    fun setRippleColor(color : Int) {
        var rippleColor = ColorStateList(arrayOf(intArrayOf()), intArrayOf(color));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            (rippleDrawable as RippleDrawable).setColor(rippleColor)
        } else {
            (rippleDrawable as codetail.graphics.drawables.RippleDrawable).setColor(rippleColor)
        }

    }

}