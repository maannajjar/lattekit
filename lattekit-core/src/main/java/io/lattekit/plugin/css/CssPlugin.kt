package io.lattekit.plugin.css

import android.util.Log
import io.lattekit.plugin.LattePlugin
import io.lattekit.plugin.css.declaration.Stylesheet
import io.lattekit.ui.view.LatteView
import io.lattekit.ui.view.NativeView

/**
 * Created by maan on 2/20/16.
 */


class CssPlugin : LattePlugin() {

    fun getStylesheetsFor(view: LatteView): List<Stylesheet> {
        var results = mutableListOf<Stylesheet>()
        findStylesheets(view, results)
        return results;
    }

    fun findStylesheets(view: LatteView, results: MutableList<Stylesheet>) {
        var stylesheetList = view.data("css:stylesheet")
        if (stylesheetList != null && stylesheetList is List<*>) {
            results.addAll(0,stylesheetList as List<Stylesheet>)
        } else {
            var cssFiles = view.data("css")
            if (cssFiles != null) {
                var files = if (cssFiles is String) {
                    // Single CSS file
                    listOf(cssFiles)
                } else if (cssFiles is List<*>) {
                    cssFiles as List<*>
                } else {
                    emptyList<String>()
                }
                files.forEach {
                    if (it is String) {
                        results.add(Stylesheet.getStylesheet(it))
                    } else if (it is Stylesheet) {
                        results.add(it)
                    }
                }
            }
            if (view.parentView != null) {
                findStylesheets(view.parentView!!, results)
            }
            view.data("css:stylesheet", results.toList())
        }

    }

    override fun onPropsUpdated(view: LatteView, oldProps: MutableMap<String, Any?>) {
        if (view is NativeView) {
            getStylesheetsFor(view).forEachIndexed { i, s -> s.assignStyles(view, i == 0) }
            CssAccessory.getCssAccessory(view).style.apply(view)
        }
    }

    override fun onViewMounted(view: LatteView) {
        if (view is NativeView) {
            getStylesheetsFor(view).forEachIndexed { i, s -> s.assignStyles(view, i == 0) }
            CssAccessory.getCssAccessory(view).style.apply(view)
        }
    }
}




