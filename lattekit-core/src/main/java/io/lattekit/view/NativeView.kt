package io.lattekit.view

import android.content.Context
import android.view.MotionEvent
import android.view.View
import android.widget.AdapterView
import io.lattekit.Latte
import java.lang.reflect.Method

/**
 * Created by maan on 2/15/16.
 */
open class NativeView : LatteView(), View.OnClickListener, View.OnTouchListener {

    private var isAttached = false

    var nativeViewClass : Class<out View>? = null

    var propsSetter : (NativeView, Map<String,Any?>)->List<String> = { view, props -> emptyList() };
    val methodCache = mutableMapOf<String, Method?>()

    open fun getViewClass() : Class<out View> {
        return if (nativeViewClass != null) {
            nativeViewClass as Class<out View>
        } else {
            View::class.java
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
            var acceptedProps = propsSetter.invoke(this,propsToApply);
            var remainingProps = propsToApply.filterKeys { !acceptedProps.contains(it) && it != "onTouch" && it != "onClick" };
            if (!getViewClass().name.startsWith("android.")) {
                setPropsRuntime(remainingProps)
            }
            return;
        }
    }

    fun setPropsRuntime(propsToApply : Map<String,Any?>) {
        val myCls = getViewClass()
        propsToApply.forEach { entry ->
            var it = entry.key
                val value = propsToApply.get(it);
                var field = if (it.startsWith("@")) {
                    it.substring(1)
                } else it;
                var isFn =  value is Function0<*>
                var setter = "set" + field.substring(0, 1).toUpperCase() + field.substring(1) + (if (isFn) "Listener" else "")
                if (value == null) {
                } else {
                    var valueCls = value.javaClass

                    var methodKey = myCls.toString() + ":" + field + ":" + value.javaClass
                    var method = methodCache.get(methodKey);
                    if (!methodCache.containsKey(methodKey)) {
                        // This is the first time we look
                        method = findSetter(setter, valueCls, isFn)
                        if (method == null) {
                            setter = field;
                            method = findSetter(setter, valueCls, isFn)
                        }
                        methodCache.put(methodKey, method);
                    }
                    if (method != null) {
                        method.invoke(androidView, if (isFn) Latte.createLambdaProxyInstance(method.parameterTypes.get(0), value as Object) else value);
                    }

            }
        }
    }

    fun findSetter(setter : String , valueType: Class<Any>, isFnValue : Boolean) : Method? {
        var myCls = getViewClass();
        var currentCls : Class<*> = myCls;
        var valueCls : Class<*> = valueType;
        var reachedEnd = false;
        var method : Method?;
        while (!reachedEnd) {
            if (isFnValue) {
                method = currentCls.declaredMethods.find{ it.name == setter };
                if (method != null && method.parameterTypes.size == 1) {
                    var listenerInterface : Class<*> = method?.parameterTypes?.get(0)!!;
                    if (listenerInterface.isInterface) {
                        return method;
                    }
                } else {
                    currentCls = currentCls.superclass
                    if (currentCls == Object::class.java) {
                        reachedEnd = true;
                    }
                }
            } else {
                try {
                    method = myCls.getMethod(setter, valueCls);
                    return method;
                } catch(ex : NoSuchMethodException) {
                }
                try {
                    var primitiveType = valueCls.getField("TYPE").get(null) as Class<*>;
                    method = myCls.getMethod(setter, primitiveType);
                    return method;
                } catch(nsfe : NoSuchFieldException ) {
                } catch(ex : NoSuchMethodException ) {
                }
                for(iface in valueCls.interfaces) {
                    try {
                        method = myCls.getMethod(setter, iface);
                        return method;
                    } catch(ex: NoSuchMethodException ) {
                    }
                }
            }
            if (valueCls.superclass == null) {
                reachedEnd = true;
            } else {
                valueCls = valueCls.superclass
            }
        }
        return null;
    }

}

