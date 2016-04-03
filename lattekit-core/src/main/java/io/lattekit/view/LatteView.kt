package io.lattekit.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.view.ViewGroup
import io.lattekit.Latte
import io.lattekit.activity.LatteActivity
import io.lattekit.annotation.Bind
import io.lattekit.annotation.Prop
import java.lang.reflect.Field
import kotlin.reflect.KClass

/**
 * Created by maan on 2/15/16.
 */


open class LatteView {

    companion object {
        @JvmStatic
        fun log(message: String) {
            Log.d("Latte", message)
        }

        @JvmStatic
        fun log(tag: String, message: String) {
            Log.d(tag, message)
        }
    }

    var renderedViews: MutableList<LatteView> = mutableListOf()
    var newRenderedViews = mutableListOf<LatteView>()
    var androidView: View? = null
    var __current : LatteView = this;

    var props: MutableMap<String, Any?> = mutableMapOf()
    var propsOptions: Map<String, Int> = emptyMap()
    var injectedProps: MutableMap<String,Any?> = mutableMapOf();
    var parentView: LatteView? = null

    var children = mutableListOf<LatteView>()

    var activity: Activity? = null
    var isMounted: Boolean = false;

    var dataValues = mutableMapOf<String, Any?>()

    var layoutFn : (LatteView.() -> Unit)? = null
    var isViewCreated = false;

    val propFields: MutableMap<String, Field>
        get() {
            var map = Latte.PROP_FILEDS[this.javaClass.name]
            if (map == null) {
                val newMap = mutableMapOf<String, Field>()
                var cls: Class<in Object> = this.javaClass
                while (cls != Object::class.java) {
                    cls.declaredFields.forEach { f ->
                        if (f.isAnnotationPresent(Prop::class.java)) {
                            var anno = f.getAnnotation(Prop::class.java);
                            var name: String = if (anno.value != "") anno.value else f.name;
                            f.setAccessible(true);
                            newMap.put(name, f)
                        }
                    }
                    cls = cls.superclass
                }
                Latte.PROP_FILEDS.put(this.javaClass.name, newMap)
                return newMap
            }
            return map!!
        }

    val viewFields: MutableMap<Int, Field>
        get() {
            var map = Latte.VIEW_FILEDS[this.javaClass.name]
            if (map == null) {
                val newMap = mutableMapOf<Int, Field>()
                var cls: Class<in Object> = this.javaClass
                while (cls != LatteView::class.java) {
                    cls.declaredFields.forEach { f ->
                        if (f.isAnnotationPresent(Bind::class.java)) {
                            var anno = f.getAnnotation(Bind::class.java);
                            val idName = if (anno.value == "") f.name else if (anno.value.startsWith("@")) anno.value.substring(1) else anno.value
                            val packageName = activity!!.applicationContext.packageName
                            var mappedResource = activity!!.getResources().getIdentifier(idName,"id",packageName)
                            f.setAccessible(true);
                            newMap.put(mappedResource, f)
                        }
                    }
                    cls = cls.superclass
                }
                Latte.VIEW_FILEDS.put(this.javaClass.name, newMap)
                return newMap
            }
            return map!!
        }

    var rootNativeView: NativeView? = null
        get() {
            if (this is NativeView) {
                return this
            } else if (this.renderedViews[0] != null) {
                return this.renderedViews[0].rootNativeView;
            }
            return null
        }

    var rootAndroidView: View? = null
        get() {
            if (this.androidView != null) {
                return this.androidView
            } else if (this.renderedViews.get(0) != null) {
                return this.renderedViews.get(0).rootAndroidView;
            }
            return null
        }


    var id: Int = 0
        get() = this.props.get("id") as Int

    fun buildView(activity: Activity, lp: ViewGroup.LayoutParams?): View {
        this.activity = activity;
        this.renderTree()
        this.buildAndroidViewTree(activity, lp);
        if (!isViewCreated) {
            // This will update properties in layout that were dependent on bound views
            // TODO: investigate if we can only call when a bound Android view within the same layout is being used in a property value
            applyChanges();
            isViewCreated = true;
        }
        return this.rootAndroidView!!;
    }

    fun notifyViewCreated() {
        isMounted = true;
        bindViews(this.renderedViews);
        Latte.PLUGINS.forEach { it.onViewCreated(this) }
        onViewCreated();
    }

    fun applyChanges() {
        this.renderTree()
        this.buildAndroidViewTree(activity as Context, rootAndroidView?.layoutParams!!);
    }

    fun data(key: String): Any? {
        return dataValues.get(key)
    }

    inline fun data(key: String, value: Any?): Any? {
        dataValues.put(key, value)
        return value
    }

    fun dataOrPut(key: String, defaultValue: Any?): Any? {
        var originalValue = dataValues.get(key)
        if (originalValue == null) {
            dataValues.put(key, defaultValue)
            return defaultValue
        }
        return originalValue
    }

    fun show(activity: Activity) {
        var myId = "${System.currentTimeMillis()}";
        var intent = Intent(activity, LatteActivity::class.java);
        intent.putExtra("_LATTE_KIT_OBJ_ID", myId)
        Latte.SAVED_OBJECTS.put(myId, this)
        activity.startActivity(intent);
    }

    open fun onViewCreated() {}

    fun buildAndroidViewTree(a: Context, lp: ViewGroup.LayoutParams?): View {
        // First build my view
        this.activity = a as Activity;
        if (this is NativeView) {
            if (this.androidView == null) {
                this.androidView = this.renderNative(a);
            }
            if (this.androidView?.layoutParams == null) {
                this.androidView?.layoutParams = lp ?: ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            }
            if (this is NativeViewGroup) {
                this.mountChildren()
            }
            if (!isMounted) {
                notifyViewCreated();
            }
            return this.androidView!!
        } else {
            // If we don't have native android view, then we are virtual node
            var subAndroid = this.renderedViews[0].buildAndroidViewTree(a, lp);
            if (!isMounted) {
                notifyViewCreated();
            }
            return subAndroid;
        }
    }

    fun copy(): LatteView {
        val copy = this.javaClass.newInstance()
        var copyProps = mutableMapOf<String,Any?>();
        this.props.forEach { entry -> copyProps.put(entry.key, entry.value) }
        copy.props = copyProps
        copy.children = mutableListOf()
        children.forEach { copy.children.add(it.copy()) }
        return copy;
    }

    open fun injectProps() {
        propFields.forEach { it ->
            if (!this.props.containsKey(it.key)) {
                // Remove deleted property
                injectedProps.remove(it.key)
                var field = propFields.get(it.key)
                field?.set(this, null)
            }
        }

        this.props?.forEach { entry ->
            var previousValue = injectedProps.get(entry.key)
            if ( previousValue != entry.value) {
                var field: Field? = this.propFields[entry.key]
                if ( field != null) {
                    if (field.getType().isAssignableFrom(entry.value?.javaClass)) {
                        injectedProps.put(entry.key,entry.value)
                        field.set(this, entry.value)
                    } else if (field.getType() == String::class.java) {
                        field.set(this, entry.value?.toString())
                    } else {
                        LatteView.Companion.log("WARNING: Injected property ${entry.key} has different type from the value in props, it will be set to null")
                    }
                }
            }
        }
    }


    open fun bindViews(subViews: List<LatteView>) {
        subViews.forEach { it: LatteView ->
            var ref: Int? = it.props["id"] as Int?
            if ( ref != null ) {
                val fieldName = ref;
                var field = this.viewFields[fieldName]
                if (field != null) {
                    if (field.type.isAssignableFrom(it.javaClass)) {
                        field.set(this, it);
                    } else if (it.androidView != null && field.getType().isAssignableFrom(it.androidView?.javaClass)) {
                        field.set(this, it.androidView);
                    }
                }
            }
            this.bindViews(it.children)
        }
    }

    fun sameView(leftView: LatteView, rightView: LatteView): Boolean {
        if (leftView is NativeView && rightView is NativeView) {
            return leftView.getViewClass() == rightView.getViewClass()
        } else if (leftView.javaClass == rightView.javaClass) {
            return true;
        }
        return false;
    }

    inline fun register(clazz: KClass<*>, crossinline init: LatteView.() -> Unit) : LatteView {
        var view = Latte.create(clazz.java,mutableMapOf(), emptyMap(), { it ->
            it.init()
        })
        addChild(view);
        return view
    }

    fun addChild(child: LatteView) {
        children.add(child)
    }

    fun render(newView : LatteView) {
        var i = newRenderedViews.size
        if (i < renderedViews.size) {
            var oldView: LatteView = renderedViews[i]
            if (sameView(oldView, newView)) {
                var oldProps = oldView.props
                oldView.children = newView.children
                oldView.props = newView.props
                Latte.PLUGINS.forEach { it.onPropsUpdated(oldView, oldProps) }
                if (oldView.onPropsUpdated(oldProps)) {
                    oldView.renderTree()
                }
                newRenderedViews.add(oldView)
            } else {
                // Try find recycled view
                newView.parentView = this
                newView.renderTree()
                newRenderedViews.add(newView)

            }
        } else {
            newView.parentView = this
            newView.renderTree()
            newRenderedViews.add(newView)
        }
    }

    fun prop(str : String, value : Any) {
        this.props.put(str,value)
    }

    open fun layout() {
        if (this.layoutFn != null) {
            this.children.clear()
            this.layoutFn!!()
        }
    }

    fun renderTree() {
        newRenderedViews = mutableListOf()
        injectProps()
        if (this !is NativeView) {
            // Virtual view:
            __current = this;
            this.children.clear()
            this.layout();
        } else {
            this.layout();
        }
        for (child in this.children) {
            render(child)
        }
        this.renderedViews = newRenderedViews;
    }

    open fun onPropsUpdated(props: Map<String, Any?>): Boolean {
        return true;
    }

}

