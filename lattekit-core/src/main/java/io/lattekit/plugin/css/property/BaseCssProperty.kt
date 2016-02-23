package io.lattekit.plugin.css.property

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.util.TypedValue
import io.lattekit.ui.view.LatteView
import io.lattekit.ui.view.NativeView
import io.lattekit.util.RegexBuilder
import io.lattekit.util.regex

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

    open fun read(propertyValue: String) {
        specifiedValue = propertyValue
    }

}


open abstract class NumberProperty : CssProperty() {

    open val PREDEFINED_VALUES = mapOf<String,Int>()
    var computedValue : Float? = null

    open val PATTERN : Regex by lazy {
        Regex("""(\d+(?:\.\d+)?)(?<unit>[^\d%]+)${if (PREDEFINED_VALUES.isNotEmpty()) PREDEFINED_VALUES.keys.joinToString(separator="|",prefix="|") else ""}""")
    }


    fun inPixels(strValue : String, value : String?, unit: String?, context:Context) : Float {
        if (PREDEFINED_VALUES[strValue.toLowerCase()] != null) {
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, PREDEFINED_VALUES.get(strValue.toLowerCase())!!.toFloat(), context.resources.displayMetrics);
        } else {
            return when (unit) {
                "dp" -> TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value!!.toFloat(), context.resources.displayMetrics);
                "dip" -> TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value!!.toFloat(), context.resources.displayMetrics);
                "sp" -> TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, value!!.toFloat(), context.resources.displayMetrics);
                else -> value?.toFloat();
            }

        }
    }

    fun parseValue(size: String, context: Context): Float {
        Log.d("LatteCss","REGEX IS "+ """(\d+(?:\.\d+)?)([^\d%]+)${if (PREDEFINED_VALUES.isNotEmpty()) PREDEFINED_VALUES.keys.joinToString(separator="|",prefix="|") else ""}""")
        var match = PATTERN.matchEntire(size)
        if (match != null) {
            var value = match.groupValues.get(1);
            var unit = match.groupValues.get(2)
            return inPixels(match.groupValues.get(0), value, unit,context)
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

    open val PREDEFINED_VALUES = mapOf(
        "white" to "#ffffff"
    )

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


open abstract class CustomProperty : CssProperty() {

    open var PATTERN : RegexBuilder = regex {  }
    var parsedValues : Map<String,String?> = emptyMap()

    fun inPixels(value : String?, unit: String?, context:Context) : Float = when (unit) {
        "dp" -> TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value!!.toFloat(), context.resources.displayMetrics);
        "dip" -> TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value!!.toFloat(), context.resources.displayMetrics);
        "sp" -> TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, value!!.toFloat(), context.resources.displayMetrics);
        else -> value?.toFloat();
    }

    fun parseValue(size: String)  {
        var match = PATTERN.match(size)
        parsedValues = match.getGroupValues()
    }

    open abstract fun computeValue(parsedValues: Map<String,String?> ,context : Context);

    final override fun computeValue(context : Context, view : LatteView) {
        if (specifiedValue != null) {
            parseValue(specifiedValue!!)
        } else {
            parseValue(INITIAL_VALUE!!)
        }
        computeValue(parsedValues, context)
    }
}
