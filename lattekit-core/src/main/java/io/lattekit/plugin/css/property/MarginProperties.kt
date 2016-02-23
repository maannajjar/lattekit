package io.lattekit.plugin.css.property

import android.view.ViewGroup
import io.lattekit.ui.view.NativeView

/**
 * Created by maan on 2/23/16.
 */


open class SingleMarginCssProperty(property: String) : NumberProperty(property) {
    override val INHERITED = true
    override val INITIAL_VALUE: String? = "0px"

    init {
        this.propertyName = property
    }
    override fun apply(view: NativeView) {
        var marginLayoutParams = view.androidView?.layoutParams
        if (marginLayoutParams is ViewGroup.MarginLayoutParams) {
            when (PROPERTY_NAME) {
                "margin-top" -> marginLayoutParams.topMargin = computedValue!!.toInt()
                "margin-bottom" -> marginLayoutParams.bottomMargin = computedValue!!.toInt()
                "margin-left" -> marginLayoutParams.leftMargin = computedValue!!.toInt()
                "margin-right" -> marginLayoutParams.rightMargin = computedValue!!.toInt()
            }
        }
    }
}

class MarginLeftCssProperty : SingleMarginCssProperty("margin-left") {}
class MarginTopCssProperty : SingleMarginCssProperty("margin-top") {}
class MarginRightCssProperty : SingleMarginCssProperty("margin-right") {}
class MarginBottomCssProperty : SingleMarginCssProperty("margin-bottom") {}
