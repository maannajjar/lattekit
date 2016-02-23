package io.lattekit.plugin.css.property

import android.content.Context
import android.content.res.AssetManager
import android.graphics.Typeface
import android.util.TypedValue
import android.widget.TextView
import io.lattekit.ui.view.LatteView
import io.lattekit.ui.view.NativeView

/**
 * Created by maan on 2/21/16.
 */
class FontSizeCssProperty : NumberProperty() {

    override val PREDEFINED_VALUES = mapOf(
        "xx-small" to 10,
        "x-small" to 12,
        "small" to 14,
        "medium" to 18,
        "large" to 22,
        "x-large" to 24,
        "xx-large" to 26
    )

    override val PROPERTY_NAME = "font-size"
    override val INHERITED = true
    override val INITIAL_VALUE: String? = "medium"

    override fun apply(view: NativeView) {
        if (view.androidView is TextView) {
            (view.androidView as TextView).setTextSize(TypedValue.COMPLEX_UNIT_PX,computedValue!!)
        }
    }
}


class FontFamilyCssProperty : CssProperty() {

    var typeface : Typeface? = Typeface.DEFAULT
    override val PROPERTY_NAME: String = "font-family"
    override fun computeValue(context: Context, view: LatteView) {
        initFonts(view.activity!!)
        if (specifiedValue != null) {
            // TODO: split by , for fallback
            typeface = allFonts?.getOrElse(specifiedValue!!.toLowerCase(), { Typeface.DEFAULT })
        }
    }
    override fun apply(view: NativeView) {
        if (view.androidView is TextView) {
            (view.androidView as TextView).typeface = typeface
        }
    }


    companion object {
        var allFonts : MutableMap<String,Typeface>? = null;

        fun initFonts(context: Context) {
            if (allFonts == null) {
                allFonts = mutableMapOf()
                loadFontsInAssetPath(context.assets, "")
            }
        }

        fun loadFontsInAssetPath(assets: AssetManager, path: String) {
            assets.list(path).forEach { it ->
                val fullPath = (if (path != "") path + "/" else "") + it
                if (assets.list(fullPath).size > 0) {
                    loadFontsInAssetPath(assets, fullPath)
                } else {
                    if (it.endsWith(".ttf") || it.endsWith(".otf")) {
                        val font = Typeface.createFromAsset(assets, fullPath)
                        allFonts?.put(it.substring(0, it.length-4).toLowerCase(), font)
                    }
                }
            }
        }
    }

}