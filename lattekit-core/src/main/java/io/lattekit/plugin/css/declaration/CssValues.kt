package io.lattekit.plugin.css.declaration

import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import android.view.ViewGroup
import java.util.regex.Pattern

/**
 * Created by maan on 2/24/16.
 */

data class LengthValue(val valueString : String) {
    var number : Float
    var unit : String? = null
    val PREDEFINED_VALUES = mapOf("match_parent" to ViewGroup.LayoutParams.MATCH_PARENT,"wrap_content" to ViewGroup.LayoutParams.WRAP_CONTENT)
    companion object {
        val PATTERN : Regex = Regex("""(\d+(?:\.\d+)?)(?<unit>[^\d%]+)""")
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

data class ColorValue(val valueString : String) {
    var color : Int;
    companion object {
        val PREDEFINED_VALUES = mapOf(
            "white" to "#ffffff",
            "black" to "#000000"
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

data class SingleCornerBorderRadius(val valueString : String) {
    var hLength : LengthValue? = null;
    var vLength : LengthValue? = null

    init {
        var values = valueString.trim().split(" ")
        if (values.size >= 1) hLength = LengthValue(values.get(0))
        if (values.size >= 2) vLength = LengthValue(values.get(1))
    }
}

data class BorderRadius(val valueString : String) {
    val hRadius : MutableList<LengthValue?> = mutableListOf()
    val vRadius : MutableList<LengthValue?> = mutableListOf()

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

data class MarginValue(val valueString : String) {
    var marginValues: MutableList<LengthValue> = mutableListOf()
    init {
        valueString.trim().split(" ").forEach {
            marginValues.add(LengthValue(it))
        }
    }
}
data class PaddingValue(val valueString : String) {
    var paddingValues: MutableList<LengthValue> = mutableListOf()
    init {
        valueString.trim().split(" ").forEach {
            paddingValues.add(LengthValue(it))
        }
    }
}

data class BorderValue(val valueString : String) {
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


