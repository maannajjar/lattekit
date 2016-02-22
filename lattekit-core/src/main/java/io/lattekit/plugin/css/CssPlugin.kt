package io.lattekit.plugin.css

import android.util.Log
import io.lattekit.plugin.LattePlugin
import io.lattekit.ui.view.LatteView
import io.lattekit.ui.view.NativeView

/**
 * Created by maan on 2/20/16.
 */

var testStyle: Map<String, Map<String, List<String>>> = mapOf(
        ".kicker" to mapOf(
            "font-family" to listOf("Chalk"),
            "font-size" to listOf("20sp"),
            "font-style" to listOf("bold"),
            "width" to listOf("match_parent"),
            "height" to listOf("wrap_content"),
            "text-color" to listOf("#777777"),
            "background-color" to listOf("#ffffff"),
            "padding-top" to listOf("30dp")
        ),
        ".story" to mapOf(
            "padding-left" to listOf("20dp")
        )
)


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

    var testStylesheet = Stylesheet()

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
                testStylesheet.assignStyles(view)
            }
            onPropsUpdated(view, view.props)
        }
    }

    override fun onViewWillMount(view: LatteView) {
        if (view.parentView == null) {
            Log.d("LatteCss", "About to assign styles to $view")
            testStylesheet.processCss(testStyle)
        }

    }
}




