package io.lattekit.util

import android.content.Context
import android.util.TypedValue

/**
 * Created by maan on 3/29/16.
 */
val PATTERN : Regex = Regex("""(-?\d+(?:\.\d+)?)([^\d%]+)?""")

object Values {
    fun toBoolean(value : String) = if (value== "true") true else false

    fun toInt(number: String, context: Context): Int {
        return toFloat(number,context).toInt()
    }


    fun toFloat(number: String, context: Context): Float {
        var match = PATTERN.matchEntire(number)
        if (match != null) {
            var number = match.groupValues[1].toFloat()
            var unit = match.groupValues[2]
            if (unit == "" || unit == null) unit = "px"
            return when (unit) {
                "dp" -> TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, number, context.resources.displayMetrics);
                "dip" -> TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, number, context.resources.displayMetrics);
                "sp" -> TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, number, context.resources.displayMetrics);
                else -> number!!;
            }
        }
        return 0f;
    }
}