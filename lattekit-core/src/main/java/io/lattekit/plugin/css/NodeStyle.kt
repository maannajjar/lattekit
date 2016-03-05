package io.lattekit.plugin.css

import android.util.Log
import io.lattekit.plugin.css.declaration.CssDeclaration
import io.lattekit.plugin.css.declaration.Stylesheet
import io.lattekit.plugin.css.property.*
import io.lattekit.ui.view.NativeView
import java.util.*

/**
 * Created by maan on 2/22/16.
 */


class NodeStyle(nativeView : NativeView) {
    var currentClasses : String = ""
    var properties = mutableMapOf<String,CssProperty>()
    var declarations = LinkedHashMap<String, CssDeclaration>()
    var allDeclarations = mutableMapOf<String,MutableList<CssDeclaration>>()
    var view : NativeView = nativeView

    companion object {
        val PROPERTY_CLASSES = listOf(
            FontCssProperty::class.java,
            PaddingCssProperty::class.java,
            MarginCssProperty::class.java,
            BorderCssProperty::class.java,
            BackgroundCssProperty::class.java,
            TextAlignCssProperty::class.java,
            ColorCssProperty::class.java,
            BorderRadiusCssProperty::class.java,
            ElevationCssProperty::class.java,
            DisplayCssProperty::class.java,
            SizeCssProperty::class.java,
            GravityCssProperty::class.java
        )
    }

    init {
        PROPERTY_CLASSES.forEach { cls ->
            var prop = cls.newInstance()
            properties.put(prop.PROPERTY_NAME,prop)
        }
    }


    fun applyStylesheets(stylesheets : List<Stylesheet>) {
        declarations.clear()
        allDeclarations.clear()
        var classes = view.props.get("cls")
        if (classes != null && classes != currentClasses) {
            currentClasses = classes as String
            var myClasses = classes.split(" ")
            stylesheets.forEach { stylesheet ->
                myClasses.forEach { cls ->
                    stylesheet.classesRules.get(".$cls")?.forEach { ruleSet ->
                        if (ruleSet != null) {
                            ruleSet.declarations.forEach { this.addDeclaration(it) }
                        }
                    }
                }
            }
            apply(this.view);
        }


    }

    fun addDeclaration(declaration : CssDeclaration) {
        var propertyDeclarations = allDeclarations.getOrPut(declaration.propertyName, { mutableListOf<CssDeclaration>() } )
        propertyDeclarations.add(declaration)
        // TODO: Determine which declaration based on specifity, currently picks last declaration
        var selectedDeclaration = propertyDeclarations[propertyDeclarations.lastIndex]
        declaration.index = declarations.size
        declarations.put(declaration.propertyName, selectedDeclaration)
    }

    fun getDeclarations(vararg properties : String) : List<CssDeclaration> {
        return properties.map { declarations[it] }.filterNotNull().sortedBy { it.index }
    }

    fun getDeclaration(propertyName : String) : CssDeclaration? {
        return declarations[propertyName]
    }

    fun apply(view : NativeView) {
        properties.values.forEach{
            it.computeValue(view.activity!!, view, this)
            it.apply(view, this)
        }
    }
}