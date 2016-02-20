package io.lattekit.ui.view

import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.FrameLayout
import io.lattekit.util.Util
import org.eclipse.xtext.xbase.lib.Functions
import org.eclipse.xtext.xbase.lib.Procedures
import java.lang.reflect.ParameterizedType

/**
 * Created by maan on 2/15/16.
 */
class ListView : NativeView(), AdapterView.OnItemClickListener {


    var adapter: BaseAdapter = object : BaseAdapter() {
        override fun getCount(): Int {
            return getData().size
        }

        override fun getItem(position: Int): Any {
            return getData().get(position)!!
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getViewTypeCount(): Int {
            return children.size
        }

        override fun getItemViewType(position: Int): Int {
            var item = getItem(position);

            var defaultView: Int = -1;
            for (i in 0..children.size - 1) {
                var child = children.get(i);
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
            log("Getting item " + getItem(position))
            var template = children.get(type);
            if (convertView != null) {
                template = convertView.getTag() as LatteView;
                template.props.put("model", getItem(position));
                template.props.put("modelIndex", position);
                template.onStateChanged();
                return convertView;
            }

            template = template.copy();
            template.props.put("modelIndex", position);
            template.props.put("model", getItem(position));
            template.parentView = this@ListView
            template.stylesheet = this@ListView.stylesheet
            var lp = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
            var v = template.buildView(activity!!, lp)
            v.setTag(template)
            return v;
        }

    }


    fun getData(): List<*> {
        return props.get("data") as List<*>;
    }


    fun getDividerHeight(): Int {
        if (this.props.containsKey("dividerHeight")) {
            return this.props.get("dividerHeight") as Int
        }
        return 0;
    }

    fun isMatch(template: LatteView, item: Any, position: Int): Boolean {
        var testLambda = template.props.get("when");
        if (testLambda == null) {
            return false;
        }
        if ( (!(testLambda is Function1<*, *>) && !(testLambda is Function2<*, *, *>))
                && (!(Util.hasKotlin() && testLambda is kotlin.jvm.functions.Function1<*, *>) && !(Util.hasKotlin() && testLambda is kotlin.jvm.functions.Function2<*, *, *>))) {
            // TODO: Warn about wrong "when" variable
            return false;
        }
        var isFn2 = testLambda is Function2<*, *, *> || testLambda is kotlin.jvm.functions.Function2<*, *, *>
        var isKotlin = Util.hasKotlin() && (testLambda is kotlin.jvm.functions.Function2<*, *, *> || testLambda is kotlin.jvm.functions.Function1<*, *>)
        var modelType = (testLambda.javaClass.genericInterfaces.get(0) as ParameterizedType).actualTypeArguments.get(0) as Class<*>

        if (modelType.isAssignableFrom(item.javaClass)) {
            var secondParamType: Class<*>? = null
            if (isFn2) {
                secondParamType = (testLambda.javaClass.genericInterfaces.get(0) as ParameterizedType).actualTypeArguments.get(1) as Class<*>;
                if (!secondParamType.isAssignableFrom(Integer::class.java)) {
                    log("Warning: second parameter's type is " + secondParamType.name + ". It must be an integer which will contain model index")
                    return false;
                }
            }
            var isMatch = if (!isFn2) {
                var m = if (isKotlin) testLambda.javaClass.getMethod("invoke", modelType) else testLambda.javaClass.getMethod("apply", modelType);
                m.setAccessible(true);
                m.invoke(testLambda, item) as Boolean;
            } else {
                var m = if (isKotlin) testLambda.javaClass.getMethod("invoke", modelType, Int::class.java) else testLambda.javaClass.getMethod("apply", modelType, secondParamType)
                m.setAccessible(true);
                m.invoke(testLambda, item, position) as Boolean;
            }
            return isMatch;
        } else {
            log("Warning: model of type " + item.javaClass.name + " is not assignable to " + modelType)
        }
        return false;
    }


    override fun applyProps() {
        super.applyProps()
        var view = androidView as android.widget.ListView;
        if (getDividerHeight() != null) {
            view.dividerHeight = getDividerHeight();
        }
        if (props.get("onItemClickListener") != null) {
            view.onItemClickListener = props.get("onItemClickListener")  as AdapterView.OnItemClickListener;
        } else {
            view.onItemClickListener = this;
        }

        view.adapter = adapter;
        adapter.notifyDataSetChanged()
    }

    override fun getViewClass(): Class<out View> {
        return android.widget.ListView::class.java
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
        if (handlerLambda is Procedures.Procedure1<*>) {
            (handlerLambda as Procedures.Procedure1<Any>).apply(obj);
        } else if (handlerLambda is Procedures.Procedure2<*,*>) {
            (handlerLambda as Procedures.Procedure2<Any,Any>).apply(obj, position );
        } else if (handlerLambda is Functions.Function1<*,*>) {
            (handlerLambda as Functions.Function1<Any,Any>).apply(obj);
        } else if (handlerLambda is Functions.Function2<*,*,*>) {
            (handlerLambda as Functions.Function2<Any,Any,Any>).apply(obj, position);
        } else if (handlerLambda is kotlin.jvm.functions.Function2<*,*,*>) {
            (handlerLambda as kotlin.jvm.functions.Function2<Any,Any,Any>).invoke(obj, position);
        } else if (handlerLambda is kotlin.jvm.functions.Function1<*,*>) {
            (handlerLambda as kotlin.jvm.functions.Function1<Any,Any>).invoke(obj)
        } else {
            log("Warning: onItemClick should have parameters (" + paramType + ",(optional)int) ")
            // TODO: Warn about wrong "onItemClick" variable
        }

    }


}