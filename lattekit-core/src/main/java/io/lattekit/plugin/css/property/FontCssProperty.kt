package io.lattekit.plugin.css.property

import android.content.Context
import android.content.res.AssetManager
import android.graphics.Typeface
import android.util.TypedValue
import android.widget.TextView
import io.lattekit.plugin.css.NodeStyle
import io.lattekit.plugin.css.declaration.FontFamilyValue
import io.lattekit.plugin.css.declaration.FontSizeValue
import io.lattekit.plugin.css.declaration.LengthValue
import io.lattekit.plugin.css.declaration.StringValue
import io.lattekit.view.NativeView

/**
 * Created by maan on 2/21/16.
 */

class FontCssProperty : CssProperty("font-family") {

    var typeface : Typeface? = Typeface.DEFAULT
    var fontStyle : String? = null
    var fontWeight : String? = null
    var fontSize : Float? = null
    var lineHeight : LengthValue? = null;
    var letterSpacing : LengthValue? = null;

    override fun computeValue(context: Context, view: NativeView, style : NodeStyle) {
        initFonts(view.activity!!)
        typeface = if ( view.androidView is TextView ) (view.androidView as TextView).typeface else Typeface.DEFAULT
        fontSize = if ( view.androidView is TextView ) (view.androidView as TextView).textSize else FontSizeValue("18sp").inPixels(view.activity!!)
        lineHeight= null;
        letterSpacing = null;
        var declarations = style.getDeclarations("font","font-family","font-style","font-weight","font-size","line-height","letter-spacing")
        declarations.forEach {
            if (it.value is FontFamilyValue) {
                typeface = allFonts?.getOrElse(it.value.fontList[0].toLowerCase(), { Typeface.DEFAULT })
            } else if (it.propertyName == "font-weight") {
                fontWeight = (it.value as StringValue).valueString
            } else if (it.propertyName == "font-style") {
                fontStyle = (it.value as StringValue).valueString
            } else if (it.propertyName == "font-size") {
                fontSize = (it.value as FontSizeValue).inPixels(view.activity!!)
            } else if (it.propertyName == "line-height") {
                lineHeight = it.value as LengthValue;
            } else if (it.propertyName == "letter-spacing") {
                letterSpacing = it.value as LengthValue;
            }
        }
    }

    fun getStyle() : Int {
        if (fontWeight == "bold" && fontStyle == "italic") {
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
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, fontSize!!)
            if (lineHeight != null) {
                textView.setLineSpacing(lineHeight!!.inPixels(view.androidView!!.context)-fontSize!!,1f);
            } else {
                textView.setLineSpacing(0f,1f);
            }
            if (letterSpacing != null) {
                textView.letterSpacing = letterSpacing!!.inPixels(view.androidView!!.context)-fontSize!!;
            }
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



