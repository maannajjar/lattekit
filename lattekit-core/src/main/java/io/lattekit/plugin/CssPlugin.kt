package io.lattekit.plugin

import android.content.Context
import android.content.res.Resources
import android.util.Log
import android.util.TypedValue
import android.widget.TextView
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

open abstract class CssProperty {
    open val SHORTHAND_PROPERTIES: List<String> = mutableListOf()
    open val PROPERTY_NAME: String = ""
    open val INHERITED: Boolean = false;
    open val INITIAL_VALUE: String? = null;
    var specifiedValue: String? = null

    open abstract fun apply(view: NativeView);
    open abstract fun read(propertyName: String, propertyValue: List<String>);
    open abstract fun computeValue(context : Context, view : LatteView);
}

class FontSizeCss : CssProperty() {

    companion object {
        val SIZE_PATTERN = Regex("""(\d+(?:\.\d+)?)([^\d ]+)""")
        val PREDEFINED = mapOf(
                "xx-small" to 10,
                "x-small" to 12,
                "small" to 14,
                "medium" to 18,
                "large" to 22,
                "x-large" to 24,
                "xx-large" to 26
        )

        fun parseValue(size: String, context: Context): Float {
           if (PREDEFINED[size.toLowerCase()] != null) {
               return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, PREDEFINED.get(size.toLowerCase())!!.toFloat(), context.resources.displayMetrics);
           } else {
                var match = SIZE_PATTERN.matchEntire(size)
                Log.d("LatteCss", "Parsing ${size}")
                if (match != null) {
                    var value = match.groupValues.get(1).toFloat();
                    var unit = match.groupValues.get(2)
                    Log.d("LatteCss", "Parsed to ${value} $unit")
                    return when (unit) {
                        "dp" -> TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.resources.displayMetrics);
                        "dip" -> TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.resources.displayMetrics);
                        "sp" -> TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, value, context.resources.displayMetrics);
                        else -> value;
                    }
                }
            }
            throw Exception("Invalid value ${size}")
        }

    }

    override val PROPERTY_NAME = "font-size"
    override val SHORTHAND_PROPERTIES = listOf("font")
    override val INHERITED = true
    override val INITIAL_VALUE: String? = "medium"

    var computedValue : Float? = null

    override fun computeValue(context : Context, view : LatteView) {
        computedValue = if (specifiedValue != null) {
            Log.d("LatteCss","COMPUTED VALUE $specifiedValue FOR $view")
            parseValue(specifiedValue!!, context)
        } else {
            parseValue(INITIAL_VALUE!!, context)
        }
    }

    override fun read(propertyName: String, propertyValue: List<String>) {
        Log.d("LatteCss", "TESTING $propertyName")
        if (propertyName == "font-size") {
            Log.d("LatteCss","READ VALUE $propertyValue")
            specifiedValue = propertyValue[0]
        }

    }

    override fun apply(view: NativeView) {
        if (view.androidView is TextView) {
            (view.androidView as TextView).setTextSize(TypedValue.COMPLEX_UNIT_PX,computedValue!!)
        }
    }


}

class NodeStyle {
    var properties = mutableListOf<CssProperty>()
    var declarations = mutableMapOf<String,List<String>>()
    init {
        properties.add(FontSizeCss())
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
        var STYLES = mutableMapOf<LatteView,NodeStyle>();
        var PROCESSED = mutableSetOf<LatteView>();


        fun getStyleFor(view : LatteView) : NodeStyle {
            var style = STYLES.get(view)
            if (style == null) {
                style = NodeStyle()
                STYLES.put(view, style)
            }
            return style;
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