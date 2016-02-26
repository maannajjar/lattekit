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
    
    fun getRoot(view : LatteView) : LatteView {
        if (view.parentView == null) {
            return view
        } else {
            return getRoot(view.parentView!!)
        }
    }

    fun getStylesheetsFor(view : LatteView) : List<Stylesheet> {
        var rootView = getRoot(view)
        var stylesheetList = rootView.data("css:stylesheet")
        if (stylesheetList != null && stylesheetList is List<*>) {
            return stylesheetList as List<Stylesheet>;
        } else {
            var stylesheets = mutableListOf<Stylesheet>()
            var cssFiles = rootView.data("css")
            if (cssFiles != null) {
                var files = if (cssFiles is String) { // Single CSS file
                    listOf(cssFiles)
                } else if (cssFiles is List<*>) {
                    cssFiles as List<*>
                } else { emptyList<String>() }
                files.forEach {
                    Log.d("LatteCss","Loading $it")
                    if (it is String) {
                        stylesheets.add(Stylesheet.getStylesheet(it))
                    } else if (it is Stylesheet) {
                        stylesheets.add(it)
                    }

                }
                rootView.data("css:stylesheet",stylesheets)
            }
            return stylesheets
        }
    }

    override fun onPropsUpdated(view: LatteView, oldProps: MutableMap<String,Any?>) {
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




