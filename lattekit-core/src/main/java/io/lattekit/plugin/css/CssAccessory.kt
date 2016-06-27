package io.lattekit.plugin.css

import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Outline
import android.graphics.Rect
import android.graphics.drawable.*
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Switch
import io.lattekit.R
import io.lattekit.drawable.BorderDrawable
import io.lattekit.view.ClippableImageView
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
class CssAccessory(view : NativeView)  {
    var style : NodeStyle = NodeStyle(view)
    var shapeDrawable : ShapeDrawable = ShapeDrawable()
    var gradientDrawable : GradientDrawable = GradientDrawable()
    var borderDrawable : BorderDrawable = BorderDrawable()
    var rippleDrawable : Drawable? = null;
    var clipRadius : Float = 0f;



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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            rippleDrawable = view.androidView!!.resources.getDrawable(R.drawable.ripple).mutate();
            var drawable =  rippleDrawable as RippleDrawable
            if (view.androidView is Button) {
                drawable.setDrawableByLayerId(R.id.button_bg_layer, gradientDrawable)
            } else {
                drawable.setDrawableByLayerId(R.id.background_layer, gradientDrawable)
            }

            drawable.setDrawableByLayerId(android.R.id.mask, shapeDrawable)
            var nativeBackground = view.androidView?.background;
            if (view.androidView?.background != null) {
                drawable.setDrawableByLayerId(R.id.native_background_layer,view.androidView?.background);
            }
            view.androidView?.outlineProvider = object: ViewOutlineProvider() {
                override fun getOutline(v: View, outline: Outline) {
                    var padding = Rect(0,0,0,0);
                    if (v is Button || view.androidView?.javaClass?.name == "android.support.design.widget.FloatingActionButton") {
                        nativeBackground?.getOutline(outline);
                    } else {
                        outline?.setRoundRect(Rect(padding.left,
                            padding.top,
                            v.width - padding.right,
                            v.height - padding.bottom), clipRadius)
                    }


                }
            }
            view.androidView?.clipToOutline = view.androidView !is Switch
            if (view.androidView is ViewGroup) {
                (view.androidView as ViewGroup).clipToPadding = false;
            }

            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M && view.androidView !is ClippableImageView) {
                // Foreground is not supported for this view, we will have to use it as background layer
                drawable.setDrawableByLayerId(R.id.border_layer, borderDrawable)
            }

            var backgroundOverride = view.props["background"];
            if (backgroundOverride is Int) {
                try {
                    drawable.setDrawableByLayerId(R.id.native_background_layer, view.androidView!!.resources.getDrawable(backgroundOverride))
                } catch(nfe : Resources.NotFoundException) {
                    try {
                        drawable.setDrawableByLayerId(R.id.native_background_layer, ColorDrawable(view.androidView!!.resources.getColor(backgroundOverride)))
                    } catch (nfe2: Resources.NotFoundException) {
                        //TODO: Warn
                    }
                }
            } else if (backgroundOverride is Drawable) {
                drawable.setDrawableByLayerId(R.id.native_background_layer, backgroundOverride)
            }

        } else {
            var rippleColor = ColorStateList(arrayOf(intArrayOf()), intArrayOf(Color.TRANSPARENT));
            var layerDrawable : LayerDrawable = LayerDrawable(arrayOf(gradientDrawable, ColorDrawable(), ColorDrawable(),borderDrawable))
            layerDrawable.setId(0, 0)
            layerDrawable.setId(1, 1)
            layerDrawable.setId(2, 2)
            layerDrawable.setId(3,3)
            rippleDrawable = codetail.graphics.drawables.RippleDrawable(rippleColor, layerDrawable, shapeDrawable);
            if (view.androidView?.background != null) {
                layerDrawable.setDrawableByLayerId(2,view.androidView?.background);
            }
            var backgroundOverride = view.props["background"];
            if (backgroundOverride is Int) {
                try {
                    layerDrawable.setDrawableByLayerId(2, view.androidView!!.resources.getDrawable(backgroundOverride))
                } catch(nfe : Resources.NotFoundException) {
                    try {
                        layerDrawable.setDrawableByLayerId(2, ColorDrawable(view.androidView!!.resources.getColor(backgroundOverride)))
                    } catch (nfe2: Resources.NotFoundException) {
                        //TODO: Warn
                    }
                }
            } else if (backgroundOverride is Drawable) {
                layerDrawable.setDrawableByLayerId(2, backgroundOverride)
            }

        }
        view.androidView?.background = rippleDrawable;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            view.androidView?.foreground = borderDrawable;
        } else if (view.androidView is ClippableImageView) {
            (view.androidView as ClippableImageView).foregroundDrawable = borderDrawable;
        }

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