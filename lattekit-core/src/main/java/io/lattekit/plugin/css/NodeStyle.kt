package io.lattekit.plugin.css

import android.widget.EditText
import io.lattekit.plugin.css.declaration.CssDeclaration
import io.lattekit.plugin.css.declaration.RuleSet
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
    var touchedDeclarations = LinkedHashMap<String, CssDeclaration>()
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

    fun selectorMatches(selectorElements : List<String>, myClasses : List<String>) : Boolean {
        return selectorElements.map {
            if (it.trim() == "") false else (it.startsWith(":") || myClasses.contains(it.substring(1)))
        }.reduce { a, b -> a && b }
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
                            ruleSet.selectors.forEach {
                                if (selectorMatches(it, myClasses)) {
                                    acceptRuleSet(ruleSet,it)
                                }
                            }
                        }
                    }
                }
            }
            apply(this.view);
        }
    }

    fun acceptRuleSet(ruleSet : RuleSet, matchingSelector : List<String>) {
        if (matchingSelector.last() == ":active") {
            ruleSet.declarations.forEach { this.addDeclaration(it,touchedDeclarations) }
        } else {
            ruleSet.declarations.forEach { this.addDeclaration(it,declarations) }
        }

    }

    fun addDeclaration(declaration : CssDeclaration, addToBucket: LinkedHashMap<String, CssDeclaration>) {
        // TODO: Determine which declaration based on specifity, currently picks last declaration
        declaration.index = addToBucket.size
        addToBucket.put(declaration.propertyName, declaration)
    }

    fun getDeclarations(vararg properties : String) : List<CssDeclaration> {
        return properties.map { declarations[it] }.filterNotNull().sortedBy { it.index }
    }

    fun getDeclaration(propertyName : String) : CssDeclaration? {
        return declarations[propertyName]
    }

    fun getTouchedDeclaration(propertyName : String) : CssDeclaration? {
        return touchedDeclarations[propertyName]
    }


    fun apply(view : NativeView) {
        properties.values.forEach{
            it.computeValue(view.activity!!, view, this)
            it.apply(view, this)
        }
    }
}