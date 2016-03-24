package io.lattekit.plugin.css.property

import android.content.Context
import android.view.ViewGroup
import io.lattekit.plugin.css.NodeStyle
import io.lattekit.plugin.css.declaration.LengthValue
import io.lattekit.plugin.css.declaration.MarginValue
import io.lattekit.view.NativeView

/**
 * Created by maan on 2/23/16.
 */


open class MarginCssProperty : CssProperty("margin") {

    override val INHERITED = true
    override val INITIAL_VALUE: String? = "0px"


    var marginLeft: Int = 0
    var marginTop: Int = 0
    var marginRight: Int = 0
    var marginBottom: Int = 0

    fun readShorthand(values: List<LengthValue>, context: Context) {

        if (values.size == 1) {
            marginTop = values[0].inPixels(context).toInt()
            marginRight = values[0].inPixels(context).toInt()
            marginBottom = values[0].inPixels(context).toInt()
            marginLeft = values[0].inPixels(context).toInt()
        } else if (values.size == 2) {
            marginTop = values[0].inPixels(context).toInt()
            marginRight = values[1].inPixels(context).toInt()
            marginBottom = values[0].inPixels(context).toInt()
            marginLeft = values[1].inPixels(context).toInt()
        } else if (values.size == 3) {
            marginTop = values[0].inPixels(context).toInt()
            marginRight = values[1].inPixels(context).toInt()
            marginBottom = values[2].inPixels(context).toInt()
            marginLeft = values[1].inPixels(context).toInt()
        } else if (values.size == 4) {
            marginTop = values[0].inPixels(context).toInt()
            marginRight = values[1].inPixels(context).toInt()
            marginBottom = values[2].inPixels(context).toInt()
            marginLeft = values[3].inPixels(context).toInt()
        }
    }

    override fun computeValue(context: Context, view: NativeView, style: NodeStyle) {
        marginLeft = 0
        marginTop = 0
        marginRight = 0
        marginBottom = 0

        var declarations = style.getDeclarations("margin", "margin-top", "margin-right", "margin-bottom", "margin-left")
        declarations.forEach {
            var values = (it.value as MarginValue).marginValues
            if (it.propertyName == "margin") {
                readShorthand(values, context)
            } else when (it.propertyName) {
                "margin-top" -> marginTop = values[0].inPixels(context).toInt()
                "margin-right" -> marginRight = values[0].inPixels(context).toInt()
                "margin-bottom" -> marginBottom = values[0].inPixels(context).toInt()
                "margin-left" -> marginLeft = values[0].inPixels(context).toInt()
            }
        }
    }

    override fun apply(view: NativeView, style: NodeStyle) {
        var marginLayoutParams = view.androidView?.layoutParams
        if (marginLayoutParams is ViewGroup.MarginLayoutParams) {
            marginLayoutParams.topMargin = marginTop
            marginLayoutParams.leftMargin = marginLeft
            marginLayoutParams.rightMargin = marginRight
            marginLayoutParams.bottomMargin = marginBottom
        }
    }
}
