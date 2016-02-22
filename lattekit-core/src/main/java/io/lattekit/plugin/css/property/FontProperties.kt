package io.lattekit.plugin.css.property

import android.content.Context
import android.util.Log
import android.util.TypedValue
import android.widget.TextView
import io.lattekit.ui.view.LatteView
import io.lattekit.ui.view.NativeView

/**
 * Created by maan on 2/21/16.
 */

class FontSizeCssProperty : CssProperty() {

    companion object {
        val SIZE_PATTERN = Regex("""(\d+(?:\.\d+)?)([^\d ]+)""")
        val PREDEFINED = mapOf(
                "xx-small" to 10,
                "x-small" to 12,
                "small" to 14,
                "medium" to 18,
                "large" to 22,
                "x-large" to 24,
                "xx-large" to 26
        )

        fun parseValue(size: String, context: Context): Float {
            if (PREDEFINED[size.toLowerCase()] != null) {
                return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, PREDEFINED.get(size.toLowerCase())!!.toFloat(), context.resources.displayMetrics);
            } else {
                var match = SIZE_PATTERN.matchEntire(size)
                if (match != null) {
                    var value = match.groupValues.get(1).toFloat();
                    var unit = match.groupValues.get(2)
                    return when (unit) {
                        "dp" -> TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.resources.displayMetrics);
                        "dip" -> TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.resources.displayMetrics);
                        "sp" -> TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, value, context.resources.displayMetrics);
                        else -> value;
                    }
                }
            }
            throw Exception("Invalid font size value ${size}")
        }

    }

    override val PROPERTY_NAME = "font-size"
    override val SHORTHAND_PROPERTIES = listOf("font")
    override val INHERITED = true
    override val INITIAL_VALUE: String? = "medium"

    var computedValue : Float? = null

    override fun computeValue(context : Context, view : LatteView) {
        computedValue = if (specifiedValue != null) {
            parseValue(specifiedValue!!, context)
        } else {
            parseValue(INITIAL_VALUE!!, context)
        }
    }

    override fun read(propertyName: String, propertyValue: List<String>) {
        if (propertyName == "font-size") {
            specifiedValue = propertyValue[0]
        }
    }

    override fun apply(view: NativeView) {
        if (view.androidView is TextView) {
            (view.androidView as TextView).setTextSize(TypedValue.COMPLEX_UNIT_PX,computedValue!!)
        }
    }
}
