package io.lattekit.plugin.css

import android.util.Log
import io.lattekit.plugin.css.property.*
import io.lattekit.ui.view.NativeView

/**
 * Created by maan on 2/22/16.
 */
class NodeStyle {
    var properties = mutableMapOf<String,CssProperty>()
    var declarations = mutableMapOf<String,String>()

    companion object {
        val PROPERTY_CLASSES = listOf(
            FontSizeCssProperty::class.java,
            FontFamilyCssProperty::class.java,
            BackgroundColorCssProperty::class.java,
            PaddingLeftCssProperty::class.java,
            PaddingTopCssProperty::class.java,
            PaddingRightCssProperty::class.java,
            PaddingBottomCssProperty::class.java,
            BorderLeftWidthCssProperty::class.java,
            BorderTopWidthCssProperty::class.java,
            BorderRightWidthCssProperty::class.java,
            BorderBottomWidthCssProperty::class.java,
            MarginLeftCssProperty::class.java,
            MarginTopCssProperty::class.java,
            MarginRightCssProperty::class.java,
            MarginBottomCssProperty::class.java,
            BorderRadiusTopLeftCssProperty::class.java,
            BorderRadiusTopRightCssProperty::class.java,
            BorderRadiusBottomLeftCssProperty::class.java,
            BorderRadiusBottomRightCssProperty::class.java,
            BorderRadiusBottomRightCssProperty::class.java,
            ColorCssProperty::class.java,
            TextAlignCssProperty::class.java,
            FontWeightCssProperty::class.java,
            BorderLeftCssProperty::class.java,
            BorderTopCssProperty::class.java,
            BorderRightCssProperty::class.java,
            BorderBottomCssProperty::class.java
        )
    }

    init {
        PROPERTY_CLASSES.forEach { cls ->
            var prop = cls.newInstance()
            properties.put(prop.PROPERTY_NAME,prop)
        }
    }

    fun read() {
        properties.values.forEach {
            Log.d("LatteCss", "Applying ${it.PROPERTY_NAME}")
            var declaredValue = declarations.get(it.PROPERTY_NAME)
            if (declaredValue != null) {
                it.read(declaredValue)
            }
        }
    }

    fun apply(view : NativeView) {
        properties.values.forEach{
            it.computeValue(view.activity!!, view)
            it.apply(view, this)
        }

    }
}