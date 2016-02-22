package io.lattekit.plugin.css

import android.content.res.Resources
import android.util.Log
import io.lattekit.plugin.LattePlugin
import io.lattekit.plugin.css.property.CssProperty
import io.lattekit.plugin.css.property.FontSizeCssProperty
import io.lattekit.ui.view.LatteView
import io.lattekit.ui.view.NativeView
import io.lattekit.ui.view.NativeViewGroup
import java.util.regex.Pattern

/**
 * Created by maan on 2/20/16.
 */

var testStyle: Map<String, Map<String, List<String>>> = mapOf(
        ".kicker" to mapOf(
                "font-family" to listOf("GraphikApp-Bold"),
                "font-size" to listOf("12sp"),
                "font-style" to listOf("bold"),
                "width" to listOf("match_parent"),
                "height" to listOf("wrap_content"),
                "text-color" to listOf("#777777"),
                "background-color" to listOf("#000000")
        )
)

class Stylesheet {
    companion object {
        val TOKENS_RE = Pattern.compile("""((?:\.|#)?[^>\s\.#:]+|:|\s*>\s*|\s+)""")
    }

    var classesSelectors = mutableMapOf<String,Pair<MutableList<String>,Map<String,List<String>>>>()
    var idsSelectors = mutableMapOf<String,Pair<MutableList<String>,Map<String,List<String>>>>()
    var allSelectors = mutableMapOf<MutableList<String>,Map<String,List<String>>>()


    fun elMatches(elName : String, view : LatteView) : Boolean {
        if (elName.startsWith("#")) {
            try {
                var viewId = view.androidView?.getResources()?.getResourceName(view.androidView?.id!!)
                if ("#"+viewId == elName) {
                    return true;
                }
            } catch(e: Resources.NotFoundException) {
            }
            return false;
        } else if (elName.startsWith(".")){
            if (view.props.get("cls") != null) {
                (view.props.get("cls") as String).split(" ").forEach {
                    if (it.trim() == elName.substring(1)) {
                        return true;
                    }
                }
            }
        }

        return  false;

    }


    fun getNativeView(view : LatteView) : NativeView {
        if (view is NativeView) {
            return view
        }
        return getNativeView(view.renderedViews[0])
    }

    fun getDirectChildren(view : NativeView) : List<NativeView> {
        if (view is NativeViewGroup) {
            return view.renderedViews.map { getNativeView(it) }
        }
        return emptyList()
    }

    fun assignStyles(rootView : LatteView) {
        Log.d("LatteCss", "Assigning styles for $rootView")
        var nativeRoot = getNativeView(rootView)

        for ( (selector, declarations) in  allSelectors) {
            var matched = query(selector, listOf(nativeRoot))
            matched.forEach {
                var style = CssPlugin.getStyleFor(it)
                for ((key,values) in declarations) {
                    // TODO: determine specificity
                    style?.declarations?.put(key,values)
                }
            }
        }

    }

    fun query(selector : List<String>, views : List<NativeView>) : List<NativeView> {
        var currentEl = 0
        var el : String;
        Log.d("LatteCss", "Querying $selector")
        var currentViews = views;
        while (currentEl < selector.size ) {
            el = selector[currentEl]
            Log.d("LatteCss", "Finding $el")
            if (el == ">") { // child combinator
                var childViews = mutableListOf<NativeView>()
                currentViews.forEach {
                    childViews.addAll(getDirectChildren(it))
                }
                currentViews = childViews.toList()
            } else {
                var selectedViews = mutableListOf<NativeView>()
                currentViews.forEach{
                    var native = getNativeView(it)
                    if (elMatches(el, native)) {
                        selectedViews.add(native)
                    }
                }
                currentViews = selectedViews.toList()
            }
            Log.d("LatteCss", " $el => $currentViews")
            currentEl++
        }
        return currentViews
    }


    fun processCss(ruleSets : Map<String, Map<String,List<String>>>) {
        for ((selectorGroup, declarations) in ruleSets) {
            selectorGroup.split(",").forEach { selector ->

                var matcher = TOKENS_RE.matcher(selector)
                var selectorElements = mutableListOf<String>()
                var isHashed = false
                while (matcher.find()) {
                    var el = matcher.group().trim()
                    if (el == "" && selectorElements.isEmpty()) {
                    } else {
                        if (el.startsWith("#")) {
                            isHashed = true
                            idsSelectors.put(el,Pair(selectorElements,declarations));
                        } else if (el.startsWith(".")) {
                            isHashed = true
                            classesSelectors.put(el,Pair(selectorElements,declarations));
                        }
                        selectorElements.add(el)
                    }
                }
                Log.d("LatteCss","Processed selectors $selectorElements => $declarations")
                allSelectors.put(selectorElements,declarations)
            }
        }
    }
}



class NodeStyle {
    var properties = mutableListOf<CssProperty>()
    var declarations = mutableMapOf<String,List<String>>()
    init {
        properties.add(FontSizeCssProperty())
    }

    fun read() {
        properties.forEach {
            for ((key,value) in declarations) {
                it.read(key,value)
            }
        }
    }

    fun apply(view : NativeView) {
        properties.forEach{
            it.computeValue(view.activity!!, view)
            it.apply(view)
        }

    }
}

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