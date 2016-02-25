package io.lattekit.plugin.css.property

import android.content.Context
import android.content.res.AssetManager
import android.graphics.Typeface
import android.util.TypedValue
import android.view.Gravity
import android.widget.TextView
import io.lattekit.plugin.css.NodeStyle
import io.lattekit.plugin.css.declaration.FontFamilyValue
import io.lattekit.plugin.css.declaration.FontSizeValue
import io.lattekit.plugin.css.declaration.StringValue
import io.lattekit.ui.view.NativeView

/**
 * Created by maan on 2/21/16.
 */

class FontCssProperty : CssProperty("font-family") {

    var typeface : Typeface? = Typeface.DEFAULT
    var fontStyle : String? = "normal"
    var fontWeight : String? = "normal"
    var fontSize : FontSizeValue = FontSizeValue("18sp")

    override fun computeValue(context: Context, view: NativeView ,style : NodeStyle) {
        initFonts(view.activity!!)
        var declarations = style.getDeclarations("font","font-family","font-style","font-weight","font-size")
        declarations.forEach {
            if (it.value is FontFamilyValue) {
                typeface = allFonts?.getOrElse(it.value.fontList[0].toLowerCase(), { Typeface.DEFAULT })
            } else if (it.propertyName == "font-weight") {
                fontWeight = (it.value as StringValue).valueString
            } else if (it.propertyName == "font-style") {
                fontStyle = (it.value as StringValue).valueString
            } else if (it.propertyName == "font-size") {
                fontSize = it.value as FontSizeValue
            }
        }
    }

    fun getStyle() : Int {
        if (fontStyle == "bold" && fontWeight == "italic") {
            return Typeface.BOLD_ITALIC
        } else if (fontWeight == "bold") {
            return Typeface.BOLD
        } else if (fontStyle == "italic") {
            return Typeface.ITALIC
        } else {
            return Typeface.NORMAL
        }
    }

    override fun apply(view: NativeView, style: NodeStyle) {
        if (view.androidView is TextView) {
            var textView = view.androidView as TextView
            textView.setTypeface(typeface,getStyle())
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, fontSize.inPixels(view.androidView!!.context))
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


class TextAlignCssProperty : StaticProperty<Int>("text-align") {

    val VALUES = mapOf(
        "center" to Gravity.CENTER_HORIZONTAL,
        "start" to  Gravity.START,
        "end" to  Gravity.END,
        "left" to  Gravity.LEFT,
        "right" to  Gravity.RIGHT
    )

    override val INHERITED = true
    override val INITIAL_VALUE: String? = "start"

    var textAlign : String = "start"

    override fun computeValue(context: Context, view: NativeView, style: NodeStyle) {
        var declaration = style.getDeclaration("text-align")
        if (declaration != null) {
            textAlign = (declaration as StringValue).valueString
        }
    }

    override fun apply(view: NativeView, style: NodeStyle) {
        if (view.androidView is TextView) {
            (view.androidView as TextView).gravity = VALUES[textAlign] ?: Gravity.START
        }
    }
}

