package io.lattekit.ui.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.widget.SwipeRefreshLayout
import android.view.MotionEvent
import android.view.View
import android.widget.AbsListView
import android.widget.AdapterView
import android.widget.ProgressBar
import android.widget.TextView
import io.lattekit.Latte
import io.lattekit.util.Util
import java.lang.reflect.Method
import java.lang.reflect.Proxy
import kotlin.jvm.functions.Function0

/**
 * Created by maan on 2/15/16.
 */
open class NativeView : LatteView(), View.OnClickListener, View.OnTouchListener {

    private var isAttached = false

    var nativeViewClass : Class<out View>? = null

    val methodCache = mutableMapOf<String, Method?>()
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
            return getViewClass().constructors.find{ it.parameterTypes.size == 1 }?.newInstance(context) as View
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



    open fun applyProps(applyTo : Map<String,Any?>) {
        applyProps(applyTo, false);
    }

    fun applyBasicProps(propsToApply : Map<String,Any?>, onlyDelayed : Boolean ) {
        androidView?.isClickable = false
        propsToApply.forEach { var (key,value) =  it
            if (key.startsWith("@") && !isAttached) {
            } else if (onlyDelayed && !key.startsWith("@")) {
            } else {
                if (key.startsWith("@")) key = key.substring(1)
                if (key == "alpha" ) {
                    androidView?.alpha = value as Float
                } else if (key == "text" && androidView is TextView) {
                    (androidView as TextView).text = value as String
                } else if (key == "hint" && androidView is TextView) {
                    (androidView as TextView).hint = value as String
                } else if (key == "imeOptions" && androidView is TextView) {
                    (androidView as TextView).imeOptions = value as Int
                } else if (key == "inputType" && androidView is TextView) {
                    (androidView as TextView).inputType = value as Int
                } else if (key == "onEditorActionListener" && androidView is TextView) {
                    (androidView as TextView).setOnEditorActionListener(value as TextView.OnEditorActionListener)
                } else if (key == "onScrollListener" && androidView is AbsListView) {
                    (androidView as AbsListView).setOnScrollListener(value as AbsListView.OnScrollListener)
                } else if (key == "clickable") {
                    androidView?.isClickable = value as Boolean;
                } else if (key == "visibility") {
                    androidView?.visibility = value as Int
                } else if (key == "id") {
                    this.androidView?.id = if (this.props.get("id")!! is String) Util.makeResId("latte", "id", this.props.get("id") as String) else this.props.get("id") as Int
                } else if (key == "logo" && androidView is android.support.v7.widget.Toolbar) {
                    if (value is Int) {
                        (androidView as android.support.v7.widget.Toolbar).setLogo(value)
                    } else if (value is Drawable) {
                        (androidView as android.support.v7.widget.Toolbar).setLogo(value)
                    }
                } else if (key == "progress" && androidView is ProgressBar) {
                    (androidView as ProgressBar).progress = value as Int
                } else if (key == "max" && androidView is ProgressBar) {
                    (androidView as ProgressBar).max = value as Int
                } else if (key == "refreshing" && androidView is SwipeRefreshLayout) {
                    (androidView as SwipeRefreshLayout).isRefreshing = value as Boolean
                } else if (key == "onRefresh" && androidView is SwipeRefreshLayout) {
                    if (value is SwipeRefreshLayout.OnRefreshListener) {
                        (androidView as SwipeRefreshLayout).setOnRefreshListener(value)
                    } else if (value is Function<*>){
                        var listener = Latte.createLambdaProxyInstance(SwipeRefreshLayout.OnRefreshListener::class.java, value as Object) as SwipeRefreshLayout.OnRefreshListener
                        (androidView as SwipeRefreshLayout).setOnRefreshListener(listener);
                    }
                }
            }
        }
    }

    fun applyProps(propsToApply : Map<String,Any?>, onlyDelayed : Boolean ) {
        if (androidView != null) {
            androidView?.isClickable = false
            propsSetter.invoke(this,propsToApply);
//            applyBasicProps(propsToApply,onlyDelayed);
            return;
            // Default clickable to false
            this.androidView?.isClickable = false
            val myCls = getViewClass()
            propsToApply.forEach { entry ->
                var it = entry.key
                if (it == "onTouch" || it == "onClick") {
                } else if (it == "id") {
                    this.androidView?.id = if (this.props.get("id")!! is String) Util.makeResId("latte", "id", this.props.get("id") as String) else this.props.get("id") as Int
                } else if (it.startsWith("@") && !isAttached) {
                } else if (onlyDelayed && !it.startsWith("@")) {
                } else {
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

