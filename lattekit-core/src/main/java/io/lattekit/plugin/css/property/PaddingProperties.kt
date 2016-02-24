package io.lattekit.plugin.css.property

import io.lattekit.plugin.css.NodeStyle
import io.lattekit.ui.view.NativeView

/**
 * Created by maan on 2/23/16.
 */
open class SinglePaddingCssProperty(property: String) : NumberProperty(property) {

    override val INHERITED = true
    override val INITIAL_VALUE: String? = "0px"

    init {
        this.propertyName = property
    }
    override fun apply(view: NativeView, style: NodeStyle) {
        when (PROPERTY_NAME) {
            "padding-top" -> view.androidView?.setPadding(view.androidView!!.paddingLeft, computedValue!!.toInt(), view.androidView!!.paddingRight, view.androidView!!.paddingBottom)
            "padding-left" -> view.androidView?.setPadding(computedValue!!.toInt(), view.androidView!!.paddingTop, view.androidView!!.paddingRight, view.androidView!!.paddingBottom)
            "padding-right" -> view.androidView?.setPadding(view.androidView!!.paddingLeft, view.androidView!!.paddingTop, computedValue!!.toInt(), view.androidView!!.paddingBottom)
            "padding-bottom" -> view.androidView?.setPadding(view.androidView!!.paddingLeft, view.androidView!!.paddingTop, view.androidView!!.paddingRight, computedValue!!.toInt())
        }
    }
}

class PaddingLeftCssProperty : SinglePaddingCssProperty("padding-left") {}
class PaddingTopCssProperty : SinglePaddingCssProperty("padding-top") {}
class PaddingRightCssProperty : SinglePaddingCssProperty("padding-right") {}
class PaddingBottomCssProperty : SinglePaddingCssProperty("padding-bottom") {}
