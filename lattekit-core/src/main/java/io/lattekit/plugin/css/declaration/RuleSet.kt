package io.lattekit.plugin.css.declaration

import java.util.regex.Pattern

/**
 * Created by maan on 2/26/16.
 */

class RuleSet ( val selectorString : String) {

    val selectors  : MutableList<List<String>> = mutableListOf()
    val declaraions : MutableList<CssDeclaration> = mutableListOf()

    inline fun add(propertyName : String, value : String) {
        declaraions.add(CssDeclaration(propertyName, getCssValue(propertyName,value)))
    }

    companion object {
        val SELECTOR_TOKENS_REGEX = Pattern.compile("""((?:\.|#|:)?[^>\s\.#:]+|:|\s*>\s*|\s+)""")
    }

    init {
        selectorString.split(",").forEach {
            var matcher = SELECTOR_TOKENS_REGEX.matcher(it)
            var selectorElements = mutableListOf<String>()
            while (matcher.find()) {
                var el = matcher.group().trim()
                if (el == "" && selectorElements.isEmpty()) {
                } else {
                    selectorElements.add(el)
                }
            }
            selectors.add(selectorElements)
        }
    }


}

