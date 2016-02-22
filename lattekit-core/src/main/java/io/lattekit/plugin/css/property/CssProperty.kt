package io.lattekit.plugin.css.property

import android.content.Context
import io.lattekit.ui.view.LatteView
import io.lattekit.ui.view.NativeView

/**
 * Created by maan on 2/21/16.
 */
open abstract class CssProperty {
    open val SHORTHAND_PROPERTIES: List<String> = mutableListOf()
    open val PROPERTY_NAME: String = ""
    open val INHERITED: Boolean = false;
    open val INITIAL_VALUE: String? = null;
    var specifiedValue: String? = null

    open abstract fun apply(view: NativeView);
    open abstract fun read(propertyName: String, propertyValue: List<String>);
    open abstract fun computeValue(context : Context, view : LatteView);
}