package io.lattekit.plugin.css.property

import android.content.res.ColorStateList
import android.graphics.Color.TRANSPARENT
import android.graphics.drawable.*
import android.os.Build
import io.lattekit.ui.drawable.BorderDrawable
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

class BackgroundColorCssProperty : ColorProperty() {

    override val PREDEFINED_VALUES = mapOf(
        "white" to "#ffffff"
    )

    override val PROPERTY_NAME = "background-color"
    override val INHERITED = true
    override val INITIAL_VALUE: String? = "white"

    var backgroundGradientDrawable: GradientDrawable? = null

    override fun apply(view: NativeView) {

        if (backgroundGradientDrawable == null) {
            backgroundGradientDrawable = GradientDrawable()
        }
        backgroundGradientDrawable?.setColors(listOf(computedValue!!, computedValue!!).toIntArray())

        getBackgroundLayerDrawable(view).setDrawableByLayerId(0, backgroundGradientDrawable)

    }
}

open class SinglePaddingCssProperty(property: String) : NumberProperty() {
    var propertyName : String = ""
    override val PROPERTY_NAME: String
        get() = propertyName
    override val INHERITED = true
    override val INITIAL_VALUE: String? = "0px"

    init {
        this.propertyName = property
    }
    override fun apply(view: NativeView) {
        when (PROPERTY_NAME) {
            "padding-top" -> view.androidView?.setPadding(view.androidView!!.paddingLeft, computedValue!!.toInt(), view.androidView!!.paddingRight, view.androidView!!.paddingBottom)
            "padding-left" -> view.androidView?.setPadding(computedValue!!.toInt(), view.androidView!!.paddingTop, view.androidView!!.paddingRight, view.androidView!!.paddingBottom)
            "padding-right" -> view.androidView?.setPadding(view.androidView!!.paddingLeft, view.androidView!!.paddingTop, computedValue!!.toInt(), view.androidView!!.paddingBottom)
            "padding-bottom" -> view.androidView?.setPadding(view.androidView!!.paddingLeft, view.androidView!!.paddingTop, view.androidView!!.paddingRight, computedValue!!.toInt())
        }
    }
}

class PaddingTopCssProperty : SinglePaddingCssProperty("padding-top") {}
class PaddingLeftCssProperty : SinglePaddingCssProperty("padding-left") {}
class PaddingRightCssProperty : SinglePaddingCssProperty("padding-right") {}
class PaddingBottomCssProperty : SinglePaddingCssProperty("padding-bottom") {}


open class SingleBorderWidthCssProperty(property: String) : NumberProperty() {
    var propertyName : String = ""
    override val PROPERTY_NAME: String
        get() = propertyName
    override val INHERITED = true
    override val INITIAL_VALUE: String? = "0px"

    init {
        this.propertyName = property
    }
    override fun apply(view: NativeView) {
        var borderDrawable = view.dataOrPut("css:borderDrawable",BorderDrawable()) as BorderDrawable
        getBackgroundLayerDrawable(view).setDrawableByLayerId(2, borderDrawable)


        when (PROPERTY_NAME) {
            "border-top-width" -> borderDrawable.topBorderWidth = computedValue!!
            "border-bottom-width" -> borderDrawable.bottomBorderWidth = computedValue!!
            "border-left-width" -> borderDrawable.leftBorderWidth = computedValue!!
            "border-right-width" -> borderDrawable.rightBorderWidth = computedValue!!
        }
    }
}

class BorderTopWidthCssProperty : SingleBorderWidthCssProperty("border-top-width") {}
class BorderLeftWidthCssProperty : SingleBorderWidthCssProperty("border-left-width") {}
class BorderRightWidthCssProperty : SingleBorderWidthCssProperty("border-right-width") {}
class BorderBottomWidthCssProperty : SingleBorderWidthCssProperty("border-bottom-width") {}
