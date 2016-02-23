package io.lattekit.plugin.css

import android.util.Log
import io.lattekit.plugin.css.property.*
import io.lattekit.ui.view.NativeView

/**
 * Created by maan on 2/22/16.
 */
class NodeStyle {
    var properties = mutableListOf<CssProperty>()
    var declarations = mutableMapOf<String,List<String>>()

    companion object {
        val PROPERTY_CLASSES = listOf(
                FontSizeCssProperty::class.java,
                FontFamilyCssProperty::class.java,
                BackgroundColorCssProperty::class.java,
                PaddingTopCssProperty::class.java,
                PaddingLeftCssProperty::class.java,
                PaddingRightCssProperty::class.java,
                PaddingBottomCssProperty::class.java,
                BorderTopWidthCssProperty::class.java,
                BorderLeftWidthCssProperty::class.java,
                BorderRightWidthCssProperty::class.java,
                BorderBottomWidthCssProperty::class.java

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