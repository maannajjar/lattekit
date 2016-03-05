package io.lattekit.ui.view

import android.content.Context
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import java.util.*

/**
 * Created by maan on 2/15/16.
 */
open class NativeViewGroup : NativeView() {


    companion object {
        var SIZE_PATTERN  = Regex("""(\d+(?:\.\d+)?)([^\d ]+)""")

        fun parseSize(size : String, fallBack: Int, context : Context) : Int {
            if (size.toLowerCase() == "match_parent" || size.toLowerCase() == "fill_container") {
                return ViewGroup.LayoutParams.MATCH_PARENT
            } else if (size.toLowerCase() == "wrap_content") {
                return ViewGroup.LayoutParams.WRAP_CONTENT
            } else {
                var match = SIZE_PATTERN.matchEntire(size)
                if (match != null) {
                    var value = match.groupValues.get(1).toFloat();
                    var unit = match.groupValues.get(2)
                    return when (unit) {
                        "dp" -> TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,value,context.resources.displayMetrics).toInt();
                        "dip" -> TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,value,context.resources.displayMetrics).toInt();
                        "sp" -> TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,value,context.resources.displayMetrics).toInt();
                        else -> value.toInt();
                    }
                }
            }
            return fallBack
        }

    }
    var managedViews = ArrayList<View>();

    open fun getLayoutParamsClass() : Class<out ViewGroup.LayoutParams> {
        if (this.androidView != null) {
            var cls = this.androidView?.javaClass?.getDeclaredClasses()?.find{ it.name == this.androidView?.javaClass?.name+"\$LayoutParams" } as Class<out ViewGroup.LayoutParams>?
            if (cls != null ) {
                return cls
            }
        }
        return ViewGroup.MarginLayoutParams::class.java
    }

    fun createLayoutParams() : ViewGroup.LayoutParams {
        return getLayoutParamsClass().constructors.find{
                it.parameterTypes.size == 2 &&
                it.parameterTypes[0] == Integer.TYPE &&
                it.parameterTypes[1] == Integer.TYPE
            }?.newInstance(-1,-1) as ViewGroup.LayoutParams
    }


    open fun onChildrenAdded() {}

    fun applyChildLayoutProps(child: LatteView, params: ViewGroup.LayoutParams) {
        child.props.forEach {
            var keyName = it.key
            when (keyName) {

                "layout_gravity" -> {
                    var value = child.props.get(keyName);
                    var field = params.javaClass.getField("gravity");
                    field.setAccessible(true);
                    if (value is String) {
                        var realVal = Gravity::class.java.getField(value.toUpperCase()).get(null)
                        field.set(params, realVal)
                    } else if (value is Integer) {
                        field.set(params, value)
                    }
                }

                "layout_width" -> {
                    var value = child.props.get(keyName);
                    params.width = if (value is String) { parseSize(value,ViewGroup.LayoutParams.MATCH_PARENT, child.activity!!) } else { value as Int }
                }

                "layout_height" -> {
                    var value = child.props.get(keyName);
                    params.height = if (value is String) { parseSize(value,ViewGroup.LayoutParams.WRAP_CONTENT,child.activity!!) } else { value as Int }
                }

                "layout_weight" -> {
                    var value = child.props.get(keyName);
                    if (value is String) {
                        (params as android.widget.LinearLayout.LayoutParams).weight = value.toFloat()
                    } else if (value is Float) {
                        (params as android.widget.LinearLayout.LayoutParams).weight = value
                    } else if (value is Int) {
                        (params as android.widget.LinearLayout.LayoutParams).weight = value.toFloat()
                    }

                }

            }

        }
    }

    fun mountChildren() {
        log("${this.androidView} Here about to add my children " + this.renderedViews.size)
        var newViews = ArrayList<View>();
        var myContainer = this.androidView as ViewGroup;

        for(i in 0..Math.max(managedViews.size,renderedViews.size)-1) {
            if (i < renderedViews.size) {
                var v = renderedViews[i]

                var childLP = createLayoutParams();
                var childView = v.buildAndroidViewTree(this.activity as Context, childLP);
                applyChildLayoutProps(v, childView.layoutParams)
                if (i >= managedViews.size) {
                    myContainer.addView(childView);
                } else if (managedViews[i] != childView) {
                    myContainer.removeView(managedViews[i]);
                    myContainer.addView(childView,i);
                }

                v.androidView = childView
                newViews.add(childView);
                if (!v.isMounted) {
                    v.notifyMounted()
                }
            } else if (i < managedViews.size) {
                myContainer.removeViewInLayout(managedViews.get(i))
            }
        }
        managedViews = newViews

        onChildrenAdded()
    }

    override fun onPropsUpdated(oldProps: Map<String, Any?>): Boolean {
        super.onPropsUpdated(oldProps);
        return true
    }

}