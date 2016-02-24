package io.lattekit.plugin.css.property

import android.content.Context
import io.lattekit.plugin.css.NodeStyle
import io.lattekit.ui.drawable.BorderDrawable
import io.lattekit.ui.view.NativeView
import io.lattekit.util.RegexBuilder
import io.lattekit.util.regex

/**
 * Created by maan on 2/23/16.
 */



open class SingleBorderWidthCssProperty(property: String) : NumberProperty(property) {
    override val INHERITED = true
    override val INITIAL_VALUE: String? = "0px"

    override fun apply(view: NativeView, style: NodeStyle) {
        var borderDrawable = view.dataOrPut("css:borderDrawable",BorderDrawable()) as BorderDrawable
        getBackgroundLayerDrawable(view).setDrawableByLayerId(2, borderDrawable)


        when (PROPERTY_NAME) {
            "border-top-width" -> borderDrawable.topBorderWidth = computedValue!!
            "border-bottom-width" -> borderDrawable.bottomBorderWidth = computedValue!!
            "border-left-width" -> borderDrawable.leftBorderWidth = computedValue!!
            "border-right-width" -> borderDrawable.rightBorderWidth = computedValue!!
        }
    }
}

class BorderLeftWidthCssProperty : SingleBorderWidthCssProperty("border-left-width") {}
class BorderTopWidthCssProperty : SingleBorderWidthCssProperty("border-top-width") {}
class BorderRightWidthCssProperty : SingleBorderWidthCssProperty("border-right-width") {}
class BorderBottomWidthCssProperty : SingleBorderWidthCssProperty("border-bottom-width") {}



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
