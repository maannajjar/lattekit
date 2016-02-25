package io.lattekit.plugin.css.property

import android.content.Context
import android.graphics.Color
import io.lattekit.plugin.css.CssAccessory
import io.lattekit.plugin.css.NodeStyle
import io.lattekit.plugin.css.declaration.BorderValue
import io.lattekit.ui.view.NativeView

/**
 * Created by maan on 2/23/16.
 */

open class BorderCssProperty : CssProperty("border") {
    override val INHERITED = true
    override val INITIAL_VALUE: String? = "0px"

    var borderWidth = mutableMapOf(
        "border-top" to 0f,
        "border-right" to 0f,
        "border-bottom" to 0f,
        "border-left" to 0f
    )
    var borderColor = mutableMapOf(
        "border-top" to Color.BLACK,
        "border-right" to Color.BLACK,
        "border-bottom" to Color.BLACK,
        "border-left" to Color.BLACK
    )
    var borderStyle = mutableMapOf(
        "border-top" to "solid",
        "border-right" to "solid",
        "border-bottom" to "solid",
        "border-left" to "solid"
    )

    fun setBorderWidth(borderName : String, value : Float) {
        if (borderName == "border") {
            borderWidth.forEach {  borderWidth.put(it.key, value)  }
        } else {
            borderWidth.put(borderName,value)
        }
    }

    fun setBorderColor(borderName : String, value : Int) {
        if (borderName == "border") {
            borderColor.forEach {  borderColor.put(it.key, value)  }
        } else {
            borderColor.put(borderName,value)
        }
    }

    fun readShorthand(borderName : String, value : BorderValue, context : Context) {
        if (value.borderWidth != null) {
            setBorderWidth(borderName, value.borderWidth!!.inPixels(context))
        }
        if (value.borderColor != null) {
            setBorderColor(borderName, value.borderColor!!.color)
        } else {
            // TODO: use 'color' value
        }
        if (value.borderStyle != null) {
            setBorderColor(borderName, value.borderColor!!.color)
        }
    }

    override fun computeValue(context: Context, view: NativeView, style: NodeStyle) {
        var declarations = style.getDeclarations("border","border-top","border-right","border-bottom","border-left")
        declarations.forEach {
            if (it.value is BorderValue) {
                readShorthand(it.propertyName, it.value,context)
            }
        }
    }

    override fun apply(view: NativeView, style: NodeStyle) {
        var borderDrawable = CssAccessory.getCssAccessory(view).borderDrawable
        borderDrawable.topBorderWidth = borderWidth["border-top"]!!
        borderDrawable.rightBorderWidth = borderWidth["border-right"]!!
        borderDrawable.bottomBorderWidth = borderWidth["border-bottom"]!!
        borderDrawable.leftBorderWidth = borderWidth["border-left"]!!

        borderDrawable.topBorderColor = borderColor["border-top"]!!
        borderDrawable.rightBorderColor = borderColor["border-right"]!!
        borderDrawable.bottomBorderColor = borderColor["border-bottom"]!!
        borderDrawable.leftBorderColor = borderColor["border-left"]!!

    }
}


