package io.lattekit.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import java.lang.reflect.ParameterizedType

/**
 * Created by maan on 3/25/16.
 */
class LatteTemplateRecyclerAdapter(parentView : LatteView) : RecyclerView.Adapter<LatteViewHolder>() {

    var data : List<Any> = emptyList()
    var templates : List<LatteView> = emptyList()
    var parentView = parentView;

    override fun getItemCount(): Int = data.size
    override fun getItemId(position: Int) = position.toLong()
    fun getItem(position: Int) = data[position]

    override fun getItemViewType(position: Int): Int {
        var item = data[position];

        var defaultView: Int = -1;
        for (i in 0..templates.size - 1) {
            var child = templates.get(i);
            if (isMatch(child, item, position)) {
                return i;
            }
            if (child.props.get("defaultView") == true || child.props.get("defaultView") == "true") {
                defaultView = i;
            }
        }

        if (defaultView == -1) {
            throw Exception("Couldn't find template matching for item " + position);
        }
        return defaultView;
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): LatteViewHolder? {
        var template = templates.get(viewType);
        template = template.copy();
        template.parentView = parentView

        if (template.props["nullUnsafe"] as? Boolean == true) {
            return LatteNullUnsafeViewHolder(template);
        } else {
            return LatteNullSafeViewHolder(template);
        }

    }

    override fun onBindViewHolder(holder: LatteViewHolder?, position: Int) {
        holder?.bindView(getItem(position),position)
    }

    fun isMatch(template: LatteView, item: Any, position: Int): Boolean {
        var testLambda = template.props.get("when");
        if (testLambda == null) {
            return false;
        }
        if ( (!(testLambda is kotlin.Function1<*, *>) && !(testLambda is kotlin.Function2<*, *, *>))) {
            LatteView.log("Warning: 'when' parameter should be a lambda that returns boolean")
            return false;
        }
        var isFn2 = testLambda is kotlin.Function2<*, *, *>
        var modelType = (testLambda.javaClass.genericInterfaces.get(0) as ParameterizedType).actualTypeArguments.get(0) as Class<*>

        if (modelType.isAssignableFrom(item.javaClass)) {
            var secondParamType: Class<*>? = null
            if (isFn2) {
                secondParamType = (testLambda.javaClass.genericInterfaces.get(0) as ParameterizedType).actualTypeArguments.get(1) as Class<*>;
                if (!secondParamType.isAssignableFrom(Integer::class.java)) {
                    LatteView.log("Warning: second parameter's type is " + secondParamType.name + ". It must be an integer which will contain model index")
                    return false;
                }
            }
            var isMatch = if (!isFn2) {
                (testLambda as Function1<Any,Any>).invoke(item) as Boolean
            } else {
                (testLambda as Function2<Any,Any,Any>).invoke(item,position) as Boolean
            }
            return isMatch;
        } else {
            LatteView.log("Warning: model of type " + item.javaClass.name + " is not assignable to " + modelType)
        }
        return false;
    }

}

abstract class LatteViewHolder(view : View)  : RecyclerView.ViewHolder(view) {
    open abstract fun bindView(model : Any, modelIndex : Int);
}

class LatteNullSafeViewHolder(template : LatteView) : LatteViewHolder(template.buildView(template.parentView?.activity!!,null)) {
    var template : LatteView = template

    init {
        itemView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }

    override fun bindView(model : Any, modelIndex : Int) {
        template.props.put("model", model);
        template.props.put("modelIndex", modelIndex);
        template.notifyStateChanged();
        itemView.layoutParams = ViewGroup.LayoutParams(template.rootAndroidView?.layoutParams)
    }
}



class LatteNullUnsafeViewHolder(template : LatteView) : LatteViewHolder(FrameLayout(template.parentView?.activity!!) ) {
    var template : LatteView = template
    var isAttached = false;

    init {
        (itemView as FrameLayout).layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }

    override fun bindView(model : Any, modelIndex : Int) {
        template.props.put("model", model);
        template.props.put("modelIndex", modelIndex);
        if (!isAttached) {
            isAttached = true;
            (itemView as FrameLayout).addView(template.buildView(template.parentView?.activity!!, null))
        } else {
            template.notifyStateChanged();
        }

    }
}


