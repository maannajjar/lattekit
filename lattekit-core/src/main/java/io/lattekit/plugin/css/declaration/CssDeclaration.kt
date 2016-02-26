package io.lattekit.plugin.css.declaration

/**
 * Created by maan on 2/26/16.
 */
data class CssDeclaration(val propertyName : String, val value: CssValue) {
    var index : Int = 0
    var selector: List<String>? = null
}