package io.lattekit.plugin.css

import android.content.res.Resources
import io.lattekit.ui.view.LatteView
import io.lattekit.ui.view.ListView
import io.lattekit.ui.view.NativeView
import io.lattekit.ui.view.NativeViewGroup
import java.util.regex.Pattern

/**
 * Created by maan on 2/22/16.
 */
fun getNativeView(view : LatteView) : NativeView {
    if (view is NativeView) {
        return view
    }
    return getNativeView(view.renderedViews[0])
}

val TOKENS_RE = Pattern.compile("""((?:\.|#|:)?[^>\s\.#:]+|:|\s*>\s*|\s+)""")

data class RuleSet ( val selectorString : String, val declaraions: List<CssDeclaration>) {
    val selectors  : MutableList<List<String>> = mutableListOf()
    init {

        selectorString.split(",").forEach {
            var matcher = TOKENS_RE.matcher(it)
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

class Stylesheet {
    companion object {
        val TOKENS_RE = Pattern.compile("""((?:\.|#|:)?[^>\s\.#:]+|:|\s*>\s*|\s+)""")
    }

    var allSelectors  = listOf<RuleSet>()

    fun getParentNativeViewGroup(view : LatteView) : NativeView? {
        if (view.parentView == null) {
            return null;
        } else if (view.parentView is ListView) {
            return view.parentView as ListView
        } else if (view.parentView is NativeViewGroup) {
            return view.parentView as NativeViewGroup
        } else {
            return getParentNativeViewGroup(view.parentView!!)
        }
    }

    fun testNthChild(index : Int, view : NativeView) : Boolean {
        var parentGroup = getParentNativeViewGroup(view);
        return if (parentGroup is NativeViewGroup ) {
            parentGroup?.managedViews?.getOrNull(index) == view.androidView
        } else if (parentGroup is ListView ) {
            parentGroup.getModelIndex(view) == index
        } else {
            false
        }
    }

    fun testLastChild(view : NativeView) : Boolean {
        var parentGroup = getParentNativeViewGroup(view);
        return if (parentGroup is NativeViewGroup ) {
            parentGroup?.managedViews?.last() == view.androidView
        } else if (parentGroup is ListView ) {
            parentGroup.getModelIndex(view) == parentGroup.getData().size-1
        } else {
            false
        }
    }


    fun elMatches(elName : String, view : NativeView) : Boolean {
        if (elName.startsWith(":")) {
            var pseudo = elName.substring(1)
            return when(pseudo) {
                "first-child" -> testNthChild(0, view)
                "last-child" -> testLastChild(view)
                else -> if (pseudo.startsWith("nth-child")) {
                    // TODO: optimize and accept series an+b
                    var index = Regex("""nth-child\(\s*(\d+)\s*\)""").matchEntire(pseudo)?.groupValues?.getOrNull(1)
                    if ( index != null && index != "" ) {
                        testNthChild(index.toInt(),view)
                    } else {
                        false
                    }
                } else {
                    true
                }
            }
        } else if (elName.startsWith("#")) {
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



    fun getDirectChildren(view : NativeView) : List<NativeView> {
        if (view is NativeViewGroup) {
            return view.renderedViews.map { getNativeView(it) }
        }
        return emptyList()
    }

    fun assignStyles(rootView : LatteView, shouldClear : Boolean = false) {
        var nativeRoot = getNativeView(rootView)
        var clearedStyles = mutableSetOf<NodeStyle>()
        for ( ruleSet in  allSelectors) {
            var declarations = ruleSet.declaraions
            ruleSet.selectors.forEach { selectorElements ->
                var matched = query(selectorElements, listOf(nativeRoot))
                matched.forEach {
                    var style = CssAccessory.getCssAccessory(it).style
                    if(shouldClear && !clearedStyles.contains(style)) {
                        style.clearDeclarations()
                        clearedStyles.add(style)
                    }
                    for (declaration in declarations) {
                        declaration.selector = selectorElements;
                        style?.addDeclaration(declaration)
                    }
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
            } else if (el.startsWith(":")){
                currentViews = currentViews.filter { elMatches(el,it) }
            } else {
                var selectedViews = mutableListOf<NativeView>()
                currentViews.forEach {
                    var native = getNativeView(it)
                    if (elMatches(el, native)) {
                        selectedViews.add(native)
                    }
                    native.renderedViews.forEach {
                        query(listOf(el), listOf(getNativeView(it))).forEach {
                            selectedViews.add(it)
                        }
                    }
                }
                currentViews = selectedViews.toList()
            }
            currentEl++
        }
        return currentViews
    }


    fun processCss(ruleSets :  List<RuleSet>) {
        allSelectors = ruleSets
    }
}

