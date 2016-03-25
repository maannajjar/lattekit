package io.lattekit.view

import android.content.Context
import android.view.MotionEvent
import android.view.View
import android.widget.AdapterView

/**
 * Created by maan on 2/15/16.
 */
open class NativeView : LatteView(), View.OnClickListener, View.OnTouchListener {

    private var isAttached = false

    var nativeViewClass : Class<out View>? = null

    var propsSetter : (NativeView, Map<String,Any?>)->List<String> = { view, props -> emptyList() };

    open fun getViewClass() : Class<out View> {
        return if (nativeViewClass != null) {
            nativeViewClass as Class<out View>
        } else {
            View::class.java
        }
    }

    fun renderNative(context : Context) : View {
        var style = this.props.get("style");
        if (style != null && style is Int) {
            return getViewClass().constructors.find{ it.parameterTypes.size == 3 }?.newInstance(context,null,style) as View
        } else {
            var constructor = getViewClass().constructors.getOrNull(0)
            if (constructor != null) {
                if (constructor.parameterTypes.size == 1) {
                    return constructor.newInstance(context) as View
                } else if (constructor.parameterTypes.size == 2) {
                    return constructor.newInstance(context,null) as View
                } else if (constructor.parameterTypes.size == 3) {
                    return constructor.newInstance(context,null,0) as View
                }
            }
            throw Exception("Couldn't find suitable constructor for custom view ${getViewClass().name}")
        }
    }

    open fun applyProps(applyTo : Map<String,Any?>) {
        applyProps(applyTo, false);
    }

    fun applyProps(propsToApply : Map<String,Any?>, onlyDelayed : Boolean ) {
        if (androidView != null) {
            androidView?.isClickable = false
            propsSetter.invoke(this,propsToApply);
            return;
        }
    }

    override fun onPropsUpdated(oldProps :Map<String, Any?>) : Boolean {
        var changedProps = props.filter { props[it.component1()] != oldProps[it.component1()] }
        applyProps(props);
        return false
    }

    override fun onViewMounted() {
        if (androidView != null) {
            if (!(androidView is AdapterView<*>)) {
                androidView?.setOnClickListener(this)
            }
            androidView?.setOnTouchListener(this);

            applyProps(this.props)
        }
    }

    override fun onTouch(v : View, e : MotionEvent) : Boolean {
        var handlerLambda: Any? = props.get("onTouch");
        if (handlerLambda == null) {
            return false;
        }
        if (handlerLambda is kotlin.Function0<*>) {
            var result = handlerLambda.invoke();
            if (result is Boolean) {
                return result;
            }
        } else if (handlerLambda is kotlin.Function1<*,*>) {
            var result = (handlerLambda as kotlin.Function1<Any,Any>).invoke(v);
            if (result is Boolean) {
                return result;
            }
        } else if (handlerLambda is kotlin.Function2<*,*,*>) {
            var result = (handlerLambda as kotlin.Function2<Any,Any,Any>).invoke(v, e);
            if (result is Boolean) {
                return result;
            }
        }
        return false;
    }

    override fun onClick(v: View) {
        var handlerLambda: Any? = props.get("onClick");
        if (handlerLambda == null) {
            return
        }
        if (handlerLambda is kotlin.Function0<*>) {
            handlerLambda.invoke();
        } else if (handlerLambda is kotlin.Function1<*,*>) {
            (handlerLambda as kotlin.Function1<Any,Any>).invoke(v);
        }

    }
}

