package io.lattekit.plugin.css

import android.util.Log
import io.lattekit.plugin.LattePlugin
import io.lattekit.ui.view.LatteView
import io.lattekit.ui.view.NativeView

/**
 * Created by maan on 2/20/16.
 */


class CssPlugin : LattePlugin() {

    companion object {
        var PROCESSED = mutableSetOf<LatteView>();

        fun getStyleFor(view : LatteView) : NodeStyle {
            var style = view.data("latteCssStyle")
            if (style != null) {
                return style as NodeStyle
            } else {
                style = NodeStyle()
                view.data("latteCssStyle", style)
                return style;
            }
        }
    }

    fun getRoot(view : LatteView) : LatteView {
        if (view.parentView == null) {
            return view
        } else {
            return getRoot(view.parentView!!)
        }
    }

    fun getStylesheetsFor(view : LatteView) : List<Stylesheet> {
        var rootView = getRoot(view)
        Log.d("LatteCss","ROOT VIEW IS $rootView")
        var stylesheetList = rootView.data("css:stylesheet")
        if (stylesheetList != null && stylesheetList is List<*>) {
            return stylesheetList as List<Stylesheet>;
        } else {
            var stylesheets = mutableListOf<Stylesheet>()
            var cssFiles = rootView.data("css")
            Log.d("LatteCss","CSS FILE IS $cssFiles")
            if (cssFiles != null) {
                var files = if (cssFiles is String) { // Single CSS file
                    listOf(cssFiles)
                } else if (cssFiles is List<*>) {
                    cssFiles as List<String>
                } else { emptyList<String>() }
                files.forEach {
                    Log.d("LatteCss","Loading $it")
                    var newStylesheet = Stylesheet()
                    var legacyStylesheet = io.lattekit.ui.style.Stylesheet.getStylesheet(it)
                    newStylesheet.processCss(legacyStylesheet.ruleSets)
                    stylesheets.add(newStylesheet)
                }
                rootView.data("css:stylesheet",stylesheets)
            }
            return stylesheets
        }
    }
    override fun onPropsUpdated(view: LatteView, oldProps: MutableMap<String,Any?>) {
        if (view is NativeView) {
            var style = getStyleFor(view)
            style.read()
            style.apply(view)
        }
    }

    override fun onViewMounted(view: LatteView) {
        if (view is NativeView) {
            if (!PROCESSED.contains(view)) {
                PROCESSED.add(view)
                Log.d("LatteCss","STYLESHEETS ARE ${getStylesheetsFor(view)}")
                getStylesheetsFor(view).forEach{ it.assignStyles(view) }
            }
            onPropsUpdated(view, view.props)
        }
    }

    override fun onViewWillMount(view: LatteView) {
    }

}




