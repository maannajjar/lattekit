package io.lattekit.plugin.css

import android.util.Log
import io.lattekit.plugin.css.property.*
import io.lattekit.ui.view.NativeView

/**
 * Created by maan on 2/22/16.
 */
class NodeStyle {
    var properties = mutableListOf<CssProperty>()
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
            BorderRadiusBottomRightCssProperty::class.java
        )
    }

    init {
        PROPERTY_CLASSES.forEach { cls ->
            properties.add(cls.newInstance())
        }
    }

    fun read() {
        properties.forEach {
            Log.d("LatteCss", "Applying ${it.PROPERTY_NAME}")
            var declaredValue = declarations.get(it.PROPERTY_NAME)
            if (declaredValue != null) {
                it.read(declaredValue)
            }
        }
    }

    fun apply(view : NativeView) {
        properties.forEach{
            it.computeValue(view.activity!!, view)
            it.apply(view)
        }

    }
}