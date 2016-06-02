package io.lattekit.view

import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import io.lattekit.Latte
import java.lang.reflect.ParameterizedType

/**
 * Created by maan on 3/25/16.
 */
class LatteTemplateAdapter(parentView : LatteView) : BaseAdapter() {
    var data : List<Any> = emptyList()
    var templates : List<LatteView> = emptyList()
    var parentView = parentView;

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return data.get(position)!!
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getViewTypeCount(): Int {
        return templates.size
    }

    override fun getItemViewType(position: Int): Int {
        var item = getItem(position);

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

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var type = getItemViewType(position);
        var template = templates.get(type);
        if (convertView != null) {
            var oldTemplate = convertView.getTag() as LatteView;
            var oldProps = oldTemplate.props
            var newTemplate = template.copy()
            oldTemplate.childTree = newTemplate.childTree
            oldTemplate.props = newTemplate.props
            oldTemplate.props.put("modelIndex", position);
            oldTemplate.props.put("model", getItem(position));
            oldTemplate.injectProps()
            Latte.PLUGINS.forEach { it.onPropsUpdated(oldTemplate, oldProps) }
            if (oldTemplate.onPropsUpdated(oldProps)) {
                oldTemplate.notifyStateChanged()
            }
            return convertView;
        }

        template = template.copy();
        template.props.put("modelIndex", position);
        template.props.put("model", getItem(position));
        template.parentView = parentView
        template.renderingView = parentView.renderingView
        var lp = AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT);
        var v = template.buildView(parentView.activity!!, lp)
        v.tag = template
        return v;
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