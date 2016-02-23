package io.lattekit.plugin.css.property

import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import io.lattekit.ui.view.LatteView
import io.lattekit.ui.view.NativeView

/**
 * Created by maan on 2/21/16.
 */
open abstract class CssProperty {
    open val PROPERTY_NAME: String = ""
    open val INHERITED: Boolean = false;
    open val INITIAL_VALUE: String? = null;
    var specifiedValue: String? = null

    open abstract fun apply(view: NativeView);
    open fun computeValue(context : Context, view : LatteView) {}

    open fun read(propertyValue: List<String>) {
        specifiedValue = propertyValue[0]
    }

}


open abstract class NumberProperty : CssProperty() {

    open val PREDEFINED_VALUES = mapOf<String,Int>()
    var computedValue : Float? = null
    var PATTERN = Regex("""(\d+(?:\.\d+)?)([^\d%]+)""")

    fun parseValue(size: String, context: Context): Float {
        if (PREDEFINED_VALUES[size.toLowerCase()] != null) {
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, PREDEFINED_VALUES.get(size.toLowerCase())!!.toFloat(), context.resources.displayMetrics);
        } else {
            var match = PATTERN.matchEntire(size)
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
        throw Exception("Invalid $PROPERTY_NAME value ${size}")
    }


    override fun computeValue(context : Context, view : LatteView) {
        computedValue = if (specifiedValue != null) {
            parseValue(specifiedValue!!, context)
        } else {
            parseValue(INITIAL_VALUE!!, context)
        }
    }
}

open abstract class ColorProperty : CssProperty() {

    open val PREDEFINED_VALUES = mapOf<String,String>()
    var computedValue : Int? = null

    fun parseValue(colorHex: String, context: Context): Int {
        if (PREDEFINED_VALUES[colorHex.toLowerCase()] != null) {
            return Color.parseColor(PREDEFINED_VALUES.get(colorHex.toLowerCase()))
        } else {
            return Color.parseColor(colorHex)
        }
        throw Exception("Invalid $PROPERTY_NAME value ${colorHex}")
    }

    override fun computeValue(context : Context, view : LatteView) {
        computedValue = if (specifiedValue != null) {
            parseValue(specifiedValue!!, context)
        } else {
            parseValue(INITIAL_VALUE!!, context)
        }
    }


}
