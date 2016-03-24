package io.lattekit.plugin.css.property

import android.content.Context
import io.lattekit.plugin.css.NodeStyle
import io.lattekit.view.NativeView

/**
 * Created by maan on 2/21/16.
 */
open abstract class CssProperty(property : String) {
    var propertyName : String = ""
    val PROPERTY_NAME: String
        get() = propertyName

    init {
        this.propertyName = property
    }

    open val INHERITED: Boolean = false;
    open val INITIAL_VALUE: String? = null;

    open abstract fun apply(view: NativeView, style: NodeStyle);
    open fun computeValue(context : Context, view : NativeView, style: NodeStyle) {}

}
