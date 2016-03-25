package io.lattekit.plugin.css

import android.content.res.Resources
import io.lattekit.view.LatteView
import io.lattekit.view.LatteListView
import io.lattekit.view.NativeView
import io.lattekit.view.NativeViewGroup

/**
 * Created by maan on 2/26/16.
 */

fun getParentNativeViewGroup(view : LatteView) : NativeView? {
    if (view.parentView == null) {
        return null;
    } else if (view.parentView is LatteListView) {
        return view.parentView as LatteListView
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
    } else if (parentGroup is LatteListView ) {
        parentGroup.getModelIndex(view) == index
    } else {
        false
    }
}

fun testLastChild(view : NativeView) : Boolean {
    var parentGroup = getParentNativeViewGroup(view);
    return if (parentGroup is NativeViewGroup ) {
        parentGroup?.managedViews?.last() == view.androidView
    } else if (parentGroup is LatteListView ) {
        parentGroup.getModelIndex(view) == parentGroup.data.size-1
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

fun getNativeView(view : LatteView) : NativeView {
    if (view is NativeView) {
        return view
    }
    return getNativeView(view.renderedViews[0])
}
