package io.lattekit.view

import android.R
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ListView
import java.lang.reflect.ParameterizedType

/**
 * Created by maan on 2/15/16.
 */
class LatteListView : NativeView(), AdapterView.OnItemClickListener {

    var adapter = LatteTemplateAdapter(this)
    var data : List<Any> = emptyList()
        get() = props["data"] as List<Any>

    fun getModelIndex(view : LatteView) : Int {
        var topMost : LatteView? = view;
        while (topMost != null ) {
            topMost = topMost.parentView;
            if (topMost?.parentView == this) {
                break
            }
        }
        if (topMost == null) {
            return -1;
        }  else {
            return topMost.props.get("modelIndex") as Int
        }
    }

    override fun applyProps(props : Map<String,Any?>) {
        super.applyProps(props)
        var view = androidView as AdapterView<Adapter>;
        if (view is ListView) {
            view.setSelector(R.color.transparent)
            view.onItemClickListener = this;
        }
        adapter.data = data
        adapter.templates = childTree
        if (view.adapter != adapter) {
            view.adapter = adapter
        }
        adapter.notifyDataSetChanged()
    }

    override fun notifyWillDetach() {
        super.notifyWillDetach()
        var view = androidView as AdapterView<Adapter>;

        for (i in 0..view.childCount-1) {
            var latteView = view.getChildAt(i).tag as? LatteView
            latteView?.notifyWillDetach()
        }
    }
    override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        var handlerLambda: Any? = props.get("onItemClick");
        if (handlerLambda == null) {
            return
        }
        var obj : Any = adapter.getItem(position);
        var paramType = (handlerLambda.javaClass.genericInterfaces.get(0) as ParameterizedType).actualTypeArguments.get(0) as Class<*>
        if (!paramType.isAssignableFrom(obj.javaClass)) {
            // TODO: warn about wrong param type
            log("Warning " + paramType + " is not the same as " + obj.javaClass)
        }
        if (handlerLambda is kotlin.Function2<*,*,*>) {
            (handlerLambda as kotlin.Function2<Any,Any,Any>).invoke(obj, position);
        } else if (handlerLambda is kotlin.Function1<*,*>) {
            (handlerLambda as kotlin.Function1<Any,Any>).invoke(obj)
        } else {
            log("Warning: onItemClick should have parameters (" + paramType + ",(optional)int) ")
        }
    }
}
