package io.lattekit.plugin.css.property

import android.content.Context
import android.graphics.Color
import android.util.Log
import io.lattekit.plugin.css.NodeStyle
import io.lattekit.plugin.css.declaration.BorderValue
import io.lattekit.ui.drawable.BorderDrawable
import io.lattekit.ui.view.NativeView
import io.lattekit.util.RegexBuilder
import io.lattekit.util.regex

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
        var borderDrawable = view.dataOrPut("css:borderDrawable",BorderDrawable()) as BorderDrawable
        getBackgroundLayerDrawable(view).setDrawableByLayerId(2, borderDrawable)

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



open class SingleBorderRadiusCssProperty(property: String) : CustomProperty(property) {

    override val INHERITED = true
    override val INITIAL_VALUE: String? = "0px 0px"
    override var PATTERN: RegexBuilder = regex {
        group("major_decimal", """\d+(?:\.\d+)?""")
        group("major_unit", """[^\d%]+""")
        group(modifier = "?") {
            pattern("""\s+""")
            group("minor_decimal", """\d+(?:\.\d+)?""")
            group("minor_unit", """[^\d%]+""")
        }
    }

    var semiMajor : Float = 0f;
    var semiMinor : Float = 0f;

    override fun computeValue(parsedValues: Map<String, String?>, context: Context) {
        semiMajor = inPixels(parsedValues.get("major_decimal"), parsedValues.get("major_unit"),context)
        if (parsedValues.get("minor_decimal") != null) {
            semiMinor = inPixels(parsedValues.get("minor_decimal"), parsedValues.get("minor_unit"),context)
        } else {
            semiMinor = semiMajor;
        }
    }
    override fun apply(view: NativeView, style: NodeStyle) {
        var borderDrawable = view.dataOrPut("css:borderDrawable", BorderDrawable()) as BorderDrawable
        getBackgroundLayerDrawable(view).setDrawableByLayerId(2, borderDrawable)
        when (PROPERTY_NAME) {
            "border-top-left-radius" -> { borderDrawable.topLeftRadiusH = semiMajor; borderDrawable.topLeftRadiusV = semiMinor;  }
            "border-top-right-radius" -> { borderDrawable.topRightRadiusH = semiMajor; borderDrawable.topRightRadiusV = semiMinor;  }
            "border-bottom-right-radius" -> { borderDrawable.bottomRightRadiusH = semiMajor; borderDrawable.bottomRightRadiusV = semiMinor;  }
            "border-bottom-left-radius" -> { borderDrawable.bottomLeftRadiusH = semiMajor; borderDrawable.bottomLeftRadiusV = semiMinor;  }
        }
    }
}

class BorderRadiusTopLeftCssProperty : SingleBorderRadiusCssProperty("border-top-left-radius") {}
class BorderRadiusTopRightCssProperty : SingleBorderRadiusCssProperty("border-top-right-radius") {}
class BorderRadiusBottomLeftCssProperty : SingleBorderRadiusCssProperty("border-bottom-left-radius") {}
class BorderRadiusBottomRightCssProperty : SingleBorderRadiusCssProperty("border-bottom-right-radius") {}




open class ShorthandSingleBorderCssProperty(property: String) : CustomProperty(property) {

    override val INHERITED = true
    override val INITIAL_VALUE: String? = ""
    override var PATTERN: RegexBuilder = regex {
        group("width","?") {
            group("width_decimal", """\d+(?:\.\d+)?""")
            group("width_unit", """[^\d%]{1,3}""")
        }
        group(modifier="?") {
            pattern("\\s+")
            group("style","",{ pattern("none|solid") })
        }
        group(modifier="?") {
            pattern("\\s+")
            group("color","", { pattern("#[^ ]+|red|green|blue") })
        }
    }

    var borderWidth : Float? = null;
    var borderStyle : String? = null;
    var borderColor : String? = null;

    override fun computeValue(parsedValues: Map<String, String?>, context: Context) {
        if (parsedValues.get("width_decimal") != null) {
            borderWidth = inPixels(parsedValues.get("width_decimal"), parsedValues.get("width_unit"), context)
        }
        borderStyle = parsedValues.get("style")?.trim()
        borderColor = parsedValues.get("color")?.trim()
        Log.d("LatteCss", "VALUES ARE ${parsedValues}")
    }

    override fun apply(view: NativeView, style: NodeStyle) {
        var borderDrawable = view.dataOrPut("css:borderDrawable", BorderDrawable()) as BorderDrawable
        getBackgroundLayerDrawable(view).setDrawableByLayerId(2, borderDrawable)
        when (PROPERTY_NAME) {
            "border-left" -> {
                if (borderWidth != null) borderDrawable.leftBorderWidth = borderWidth!!
                if (borderColor != null) borderDrawable.leftBorderColor = Color.parseColor(borderColor!!)
                //if (borderStyle != null) borderDrawable.bottomBorderWidth = borderWidth!!
            }
            "border-top" -> {
                if (borderWidth != null) borderDrawable.topBorderWidth = borderWidth!!
                if (borderColor != null) borderDrawable.topBorderColor = Color.parseColor(borderColor!!)
                //if (borderStyle != null) borderDrawable.bottomBorderWidth = borderWidth!!
            }
            "border-right" -> {
                if (borderWidth != null) borderDrawable.rightBorderWidth = borderWidth!!
                if (borderColor != null) borderDrawable.rightBorderColor = Color.parseColor(borderColor!!)
                //if (borderStyle != null) borderDrawable.bottomBorderWidth = borderWidth!!
            }
            "border-bottom" -> {
                if (borderWidth != null) borderDrawable.bottomBorderWidth = borderWidth!!
                if (borderColor != null) borderDrawable.bottomBorderColor = Color.parseColor(borderColor!!)
                //if (borderStyle != null) borderDrawable.bottomBorderWidth = borderWidth!!
            }
        }
    }
}

class BorderLeftCssProperty : ShorthandSingleBorderCssProperty("border-left") {}
class BorderTopCssProperty : ShorthandSingleBorderCssProperty("border-top") {}
class BorderRightCssProperty : ShorthandSingleBorderCssProperty("border-right") {}
class BorderBottomCssProperty : ShorthandSingleBorderCssProperty("border-bottom") {}
