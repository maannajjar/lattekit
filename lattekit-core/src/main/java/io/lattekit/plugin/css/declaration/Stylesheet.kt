package io.lattekit.plugin.css.declaration

import com.google.common.base.CaseFormat
import io.lattekit.plugin.css.CssAccessory
import io.lattekit.plugin.css.NodeStyle
import io.lattekit.plugin.css.getNativeView
import io.lattekit.plugin.css.query
import io.lattekit.ui.view.LatteView

/**
 * Created by maan on 2/22/16.
 */

open class Stylesheet {

    companion object {
        var stylesheets = mutableMapOf<String, Stylesheet>()

        @JvmStatic
        fun register(fileName : String , stylesheet : Stylesheet ) {
            stylesheets.put(fileName, stylesheet)
        }

        @JvmStatic
        fun getStylesheet( fileName: String) :Stylesheet{
            var parts = fileName.split("/");
            var clsName = CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_CAMEL,parts.last().replace(".css",""))+"Stylesheet";
            var packageName = parts.get(0);
            return Class.forName(packageName+"."+clsName).constructors.get(0).newInstance() as Stylesheet;
        }
    }

    var ruleSets  = mutableListOf<RuleSet>()

    fun addRuleSet(ruleSet : RuleSet) = ruleSets.add(ruleSet)

    fun assignStyles(rootView : LatteView, shouldClear : Boolean = false) {
        var nativeRoot = getNativeView(rootView)
        var clearedStyles = mutableSetOf<NodeStyle>()
        for ( ruleSet in  ruleSets) {
            var declarations = ruleSet.declaraions
            ruleSet.selectors.forEach { selectorElements ->
                var matched = query(selectorElements, listOf(nativeRoot))
                matched.forEach {
                    var style = CssAccessory.getCssAccessory(it).style
                    if(shouldClear && !clearedStyles.contains(style)) {
                        style.clearDeclarations()
                        clearedStyles.add(style)
                    }
                    for (declaration in declarations) {
                        declaration.selector = selectorElements;
                        style?.addDeclaration(declaration)
                    }
                }
            }
        }
    }


}

