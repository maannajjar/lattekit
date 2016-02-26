package io.lattekit.ui.view

import android.content.Context
import android.view.MotionEvent
import android.view.View
import android.widget.AdapterView
import io.lattekit.util.Util
import org.eclipse.xtext.xbase.lib.Functions
import org.eclipse.xtext.xbase.lib.Procedures
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

    open fun getViewClass() : Class<out View> {
        return if (nativeViewClass != null) {
            nativeViewClass as Class<out View>
        } else {
            View::class.java
        }
    }

    fun renderNative(context : Context) : View {
        return getViewClass().constructors.find{ it.parameterTypes.size == 1 }?.newInstance(context) as View
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

    fun createLambdaProxyInstance(receiverClass : Class<*> , value: Object ) : Any {
        var instance = Proxy.newProxyInstance(receiverClass.getClassLoader(), arrayOf(receiverClass),
                { any, invokedMethod, arrayOfAnys ->
                    if (value is Procedures.Procedure0) {
                        value.apply()
                    } else if (value is Functions.Function0<*>) {
                        value.apply()
                    } else if ( Util.hasKotlin() && value is Function0<*>) {
                        value.invoke()
                    } else {
                        null
                    }
                })
        return instance;
    }


    open fun applyProps() {
        applyProps(false);
    }

    fun applyProps(onlyDelayed : Boolean ) {
        if (androidView != null) {
            // Default clickable to false
            this.androidView?.isClickable = false
            val myCls = getViewClass()
            props.forEach { entry ->
                var it = entry.key
                if (it == "id") {
                    this.androidView?.id = if (this.props.get("id")!! is String) Util.makeResId("latte", "id", this.props.get("id") as String) else this.props.get("id") as Int
                } else if (it.startsWith("@") && !isAttached) {
                } else if (onlyDelayed && !it.startsWith("@")) {
                } else {
                    val value = props.get(it);
                    var field = if (it.startsWith("@")) {
                        it.substring(1)
                    } else it;
                    var isFn = value is Procedures.Procedure0
                            || value is Functions.Function0<*>
                            || (Util.hasKotlin() && value is Function0<*>)
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
                            method.invoke(androidView, if (isFn) createLambdaProxyInstance(method.parameterTypes.get(0), value as Object) else value);
                        }
                    }
                }

            }


        }
    }

    override fun onPropsUpdated(oldProps :Map<String, Any?>) : Boolean {
        applyProps();
        return false
    }

    override fun onViewMounted() {
        if (androidView != null) {
            if (!(androidView is AdapterView<*>)) {
                androidView?.setOnClickListener(this)
            }
            androidView?.setOnTouchListener(this);

            applyProps()
        }
    }

    override fun onTouch(v : View, e : MotionEvent) : Boolean {

        return false;
    }

    override fun onClick(v: View?) {


    }
}