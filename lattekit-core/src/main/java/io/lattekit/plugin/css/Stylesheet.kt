package io.lattekit.plugin.css

import android.content.res.Resources
import android.util.Log
import io.lattekit.ui.view.LatteView
import io.lattekit.ui.view.NativeView
import io.lattekit.ui.view.NativeViewGroup
import java.util.regex.Pattern

/**
 * Created by maan on 2/22/16.
 */
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
        var currentViews = views;
        while (currentEl < selector.size ) {
            el = selector[currentEl]
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

