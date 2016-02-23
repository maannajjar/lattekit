package io.lattekit.plugin.css

import android.util.Log
import io.lattekit.plugin.LattePlugin
import io.lattekit.ui.view.LatteView
import io.lattekit.ui.view.NativeView

/**
 * Created by maan on 2/20/16.
 */

var testStyle: Map<String, Map<String, String>> = mapOf(
    ".kicker" to mapOf(
        "font-family" to "Chalk",
        "font-size" to "x-small",
        "font-style" to "bold",
        "width" to "match_parent",
        "height" to "wrap_content",
        "text-color" to "#777777",
        "background-color" to "#ffffff",
        "border-bottom-width" to "1dp",
        "border-left-width" to "1dp",
        "border-right-width" to "1dp",
        "border-top-width" to "1dp",
        "border-top-left-radius" to "10dp",
        "border-top-right-radius" to "5dp 10dp",
        "border-bottom-left-radius" to "5dp",
        "border-bottom-right-radius" to "20dp",
        "margin-top" to "10dp",
        "margin-bottom" to "10dp",
        "margin-right" to "10dp",
        "margin-left" to "10dp"

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




