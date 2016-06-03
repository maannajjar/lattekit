package io.lattekit.plugin.css.declaration

import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import android.view.Gravity
import android.view.ViewGroup
import java.util.regex.Pattern

/**
 * Created by maan on 2/24/16.
 */


fun getCssValue(propertyName : String, valueString : String) : CssValue = when(propertyName) {
    "margin" -> MarginValue(valueString)
    "margin-left" -> MarginValue(valueString)
    "margin-top" -> MarginValue(valueString)
    "margin-right" -> MarginValue(valueString)
    "margin-bottom" -> MarginValue(valueString)
    "padding" -> PaddingValue(valueString)
    "padding-left" -> PaddingValue(valueString)
    "padding-top" -> PaddingValue(valueString)
    "padding-right" -> PaddingValue(valueString)
    "padding-bottom" -> PaddingValue(valueString)
    "border" -> BorderValue(valueString)
    "border-left" -> BorderValue(valueString)
    "border-top" -> BorderValue(valueString)
    "border-right" -> BorderValue(valueString)
    "border-bottom" -> BorderValue(valueString)
    "border-width" -> LengthValue(valueString)
    "border-left-width" -> LengthValue(valueString)
    "border-top-width" -> LengthValue(valueString)
    "border-right-width" -> LengthValue(valueString)
    "border-bottom-width" -> LengthValue(valueString)
    "border-radius" -> BorderRadius(valueString)
    "border-top-left-radius" -> SingleCornerBorderRadius(valueString)
    "border-top-right-radius" -> SingleCornerBorderRadius(valueString)
    "border-bottom-right-radius" -> SingleCornerBorderRadius(valueString)
    "border-bottom-left-radius" -> SingleCornerBorderRadius(valueString)
    "font-size" -> FontSizeValue(valueString)
    "line-height" -> LengthValue(valueString)
    "letter-spacing" -> LengthValue(valueString)
    "font-family" -> FontFamilyValue(valueString)
    "color" -> ColorValue(valueString)
    "background-color" -> ColorValue(valueString)
    "ripple-color" -> ColorValue(valueString)
    "elevation" -> LengthValue(valueString)
    "height" ->  LengthValue(valueString)
    "width" ->  LengthValue(valueString)
    "gravity" ->  GravityValue(valueString)
    else -> StringValue(valueString)
}

interface CssValue {}

data class StringValue(val valueString : String) : CssValue {
}

data class FontFamilyValue(val valueString : String) : CssValue {
    var fontList : List<String>;
    init {
        fontList = valueString.split(",")
    }
}

data class GravityValue(val valueString : String) : CssValue {
    companion object {
        var GRAVITY_MAPPING = mapOf(
            "center" to Gravity.CENTER,
            "center_horizontal" to Gravity.CENTER_HORIZONTAL,
            "center_vertical" to Gravity.CENTER_VERTICAL,
            "top" to Gravity.TOP,
            "bottom" to Gravity.BOTTOM,
            "start" to Gravity.START,
            "end" to Gravity.END,
            "left" to Gravity.LEFT,
            "right" to Gravity.RIGHT
        )
    }
    val value : Int
    init {
        value = valueString.split(",").map { GRAVITY_MAPPING[it] }.filterNotNull().reduce { accum, right ->  accum or right }
    }
}

data class LengthValue(val valueString : String) : CssValue {
    var number : Float
    var unit : String? = null
    val PREDEFINED_VALUES = mapOf("match_parent" to ViewGroup.LayoutParams.MATCH_PARENT,"wrap_content" to ViewGroup.LayoutParams.WRAP_CONTENT)
    companion object {
        val PATTERN : Regex = Regex("""(-?\d+(?:\.\d+)?)([^\d%]+)""")
    }

    init {
        if (PREDEFINED_VALUES[valueString.toLowerCase()] != null) {
            number = PREDEFINED_VALUES[valueString.toLowerCase()]?.toFloat()!!;
            unit = "px"
        } else {
            var match = PATTERN.matchEntire(valueString)
            if (match != null) {
                number = match.groupValues.get(1).toFloat()
                unit = match.groupValues.get(2)
            } else {
                number = -2f
            }
        }
    }

    fun inPixels(context:Context) : Float {
        return when (unit) {
            "dp" -> TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, number, context.resources.displayMetrics);
            "dip" -> TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, number, context.resources.displayMetrics);
            "sp" -> TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, number, context.resources.displayMetrics);
            else -> number!!;
        }
    }
}


data class FontSizeValue(val valueString : String) : CssValue {

    var number : Float
    var unit : String? = null
    val PREDEFINED_VALUES = mapOf(
        "xx-small" to 10,
        "x-small" to 12,
        "small" to 14,
        "medium" to 18,
        "large" to 22,
        "x-large" to 24,
        "xx-large" to 26
    )
    companion object {
        val PATTERN : Regex = Regex("""(\d+(?:\.\d+)?)([^\d%]+)""")
    }

    init {
        if (PREDEFINED_VALUES[valueString.toLowerCase()] != null) {
            number = PREDEFINED_VALUES[valueString.toLowerCase()]?.toFloat()!!;
            unit = "sp"
        } else {
            var match = PATTERN.matchEntire(valueString)
            if (match != null) {
                number = match.groupValues.get(1).toFloat()
                unit = match.groupValues.get(2)
            } else {
                number = 18f
                unit = "sp"
            }
        }
    }

    fun inPixels(context:Context) : Float {
        return when (unit) {
            "dp" -> TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, number, context.resources.displayMetrics);
            "dip" -> TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, number, context.resources.displayMetrics);
            "sp" -> TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, number, context.resources.displayMetrics);
            else -> number!!;
        }
    }
}

data class ColorValue(val valueString : String) : CssValue {
    var color : Int;
    companion object {
        val PREDEFINED_VALUES = mapOf(
            "white" to "#ffffff",
            "black" to "#000000",
            "blue" to "#ff0000"
        )
    }
    init {
        if (PREDEFINED_VALUES[valueString.toLowerCase()] != null) {
            color = Color.parseColor(PREDEFINED_VALUES.get(valueString.toLowerCase()))
        } else {
            color = Color.parseColor(valueString)
        }
    }
}

data class SingleCornerBorderRadius(val valueString : String) : CssValue {
    var hLength : LengthValue? = null;
    var vLength : LengthValue? = null

    init {
        var values = valueString.trim().split(" ")
        if (values.size >= 1) hLength = LengthValue(values.get(0))
        if (values.size >= 2) vLength = LengthValue(values.get(1))
    }
}

data class BorderRadius(val valueString : String) : CssValue  {
    val hRadius : MutableList<LengthValue> = mutableListOf()
    val vRadius : MutableList<LengthValue> = mutableListOf()

    init {
        var values = valueString.trim().split("/");
        if (values.size >= 1) {
            values[0].trim().split(" ").forEach {
                hRadius.add(LengthValue(it))
            }
        }
        if (values.size >= 2) {
            values[1].trim().split(" ").forEach {
                vRadius.add(LengthValue(it))
            }
        }
    }

}

data class MarginValue(val valueString : String) : CssValue  {
    var marginValues: MutableList<LengthValue> = mutableListOf()
    init {
        valueString.trim().split(" ").forEach {
            marginValues.add(LengthValue(it))
        }
    }
}
data class PaddingValue(val valueString : String) : CssValue  {
    var paddingValues: MutableList<LengthValue> = mutableListOf()
    init {
        valueString.trim().split(" ").forEach {
            paddingValues.add(LengthValue(it))
        }
    }
}

data class BorderValue(val valueString : String) : CssValue  {
    var borderWidth: LengthValue? = null
    var borderStyle : String? = null
    var borderColor: ColorValue? = null

    companion object {
        var PATTERN = Pattern.compile("""(\d+(?:\.\d+)?[%a-z]{1,3})|(none|solid)|(#[^\s]+|${ColorValue.PREDEFINED_VALUES.keys.joinToString("|")})""")
    }

    init {
        var matcher = PATTERN.matcher(valueString);

        while (matcher.find())  {
            if (matcher.group(1) != null && matcher.group(1) != "" && borderWidth == null) {
                borderWidth = LengthValue(matcher.group(1))
            } else if (matcher.group(2) != null && matcher.group(2) != "" && borderStyle == null) {
                borderStyle = matcher.group(2)
            } else if (matcher.group(3) != null && matcher.group(3) != "" && borderColor == null) {
                borderColor = ColorValue(matcher.group(3))
            }
        }
    }


}


