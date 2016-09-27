package io.lattekit.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import io.lattekit.Latte
import io.lattekit.activity.LatteActivity
import io.lattekit.annotation.Bind
import io.lattekit.annotation.Prop
import java.lang.reflect.Field

/**
 * Created by maan on 2/15/16.
 */

open class LatteView  {

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

    var subViews: MutableList<LatteView> = mutableListOf()
    var newRenderedViews = mutableListOf<LatteView>()
    var androidView: View? = null
    var __current : LatteView = this;
    var popupWindow : PopupWindow? = null

    var props: MutableMap<String, Any?> = mutableMapOf()
    var propsOptions: Map<String, Int> = emptyMap()
    var injectedProps: MutableMap<String,Any?> = mutableMapOf();
    var parentView: LatteView? = null

    var childTree = mutableListOf<LatteView>()
    var children = mutableListOf<LatteView>()

    var activity: Activity? = null
    var isMounted: Boolean = false;

    var dataValues = mutableMapOf<String, Any?>()

    var layoutFn : (LatteView.() -> Unit)? = null
    var isViewCreated = false;

    var renderingView : LatteView? = null;
    var isDetached = false

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
                            val idName = if (anno.value == "") f.name else if (anno.value.startsWith("@") && anno.value.split("/").size > 1) anno.value.split("/",limit=2)[1] else anno.value
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
            } else if (this.subViews[0] != null) {
                return this.subViews[0].rootNativeView;
            }
            return null
        }

    var rootAndroidView: View? = null
        get() {
            if (this.androidView != null) {
                return this.androidView
            } else if (this.subViews.isNotEmpty() && this.subViews[0] != null) {
                return this.subViews[0].rootAndroidView;
            }
            return null
        }


    var id: Int = 0
        get() = this.props.get("id") as Int

    fun findViewById(id: Int) : View? {
        return rootAndroidView?.findViewById(id);
    }

    fun buildView(activity: Activity, lp: ViewGroup.LayoutParams?): View {
        this.activity = activity;
        this.injectProps()
        this.renderTree()
        this.buildAndroidViewTree(activity, lp);
        if (!isViewCreated) {
            // TODO: investigate if we can call only when there's a referenced Android view in layout is being used in a property value
            notifyStateChanged();
            isViewCreated = true;
        }
        return this.rootAndroidView!!;
    }

    fun notifyViewCreated() {
        isMounted = true;
        bindViews(this.subViews);
        Latte.PLUGINS.forEach { it.onViewCreated(this) }
        onViewCreated();
    }

    open fun notifyStateChanged() {
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

    fun dataOrPut(key: String, defaultValue: ()->Any?): Any? {
        var originalValue = dataValues[key]
        if (originalValue == null) {
            var default = defaultValue.invoke();
            dataValues.put(key, default)
            return default
        }
        return originalValue
    }

    open fun onViewCreated() {}
    open fun onViewWillDetach() {}

    fun dismiss() {
        if (popupWindow != null) {
            popupWindow?.dismiss()
            isDetached = true
        }
    }

    fun buildAndroidViewTree(a: Context, lp: ViewGroup.LayoutParams?): View {
        // First build my view
        this.activity = a as Activity;
        if (this is NativeView) {
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
            var subAndroid = this.subViews[0].buildAndroidViewTree(a, lp);
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
        copy.childTree = mutableListOf()
        childTree.forEach { copy.childTree.add(it.copy()) }
        return copy;
    }

    open fun injectProps() {
        propFields.forEach { it ->
            if (!this.props.containsKey(it.key)) {
                // Remove deleted property
                injectedProps.remove(it.key)
                var field = propFields.get(it.key)
                if (!(field?.type?.isPrimitive?:false)) {
                    field?.set(this, null)
                }
            }
        }

        this.props?.forEach { entry ->
            var previousValue = injectedProps.get(entry.key)
            if ( previousValue != entry.value) {
                var field: Field? = this.propFields[entry.key]
                if (field != null) {
                    if (entry.value != null) {
                        if (field.getType().isAssignableFrom(entry.value?.javaClass)) {
                            injectedProps.put(entry.key, entry.value)
                            field.set(this, entry.value)
                        } else if (field.getType() == String::class.java) {
                            field.set(this, entry.value?.toString())
                        } else if (field.type.isPrimitive || entry.value?.javaClass!!.isAssignableFrom(field.type)) {
                            field.set(this, entry.value)
                        } else {
                            LatteView.Companion.log("WARNING: LatteView \"${this.javaClass.name.substring(0, this.javaClass.name.length - 4)}\" retrieved incorrect value for property \"@Prop ${entry.key}\". Expected: ${field.type.name}, Got: ${entry.value?.javaClass?.name}. @Prop ${entry.key} is set to null.")
                        }
                    } else {
                        field?.set(this, null)
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
            this.bindViews(it.subViews)
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

    // NOTE: addChild is also called by layout() top level.. So root views will also
    // be add to children which is not right (children array represents children passed by
    // other views).. I.e:
    // <CustomView><TextView></CustomView>
    // TextView is here the passed children to CustomView
    // Since we know there is only ONE root child added in layout().. we will remove last element in children
    // array after layout() is called
    fun addChild(child: LatteView) {
        this.children.add(child)
        childTree.add(child)
    }

    fun renderChild(index : Int) {
        __current.childTree.add(children[index])
    }

    fun renderChildren() {
        children.forEachIndexed { i, latteView -> renderChild(i) }
    }
    fun render(newView : LatteView) {
        var i = newRenderedViews.size
        if (i < subViews.size) {
            var oldView: LatteView = subViews[i]
            if (sameView(oldView, newView)) {
                var oldProps = oldView.props
                oldView.childTree = newView.childTree
                oldView.children = newView.children
                oldView.props = newView.props
                oldView.injectProps()
                Latte.PLUGINS.forEach { it.onPropsUpdated(oldView, oldProps) }
                if (oldView.onPropsUpdated(oldProps)) {
                    oldView.renderTree()
                }
                newRenderedViews.add(oldView)
            } else {
                newView.parentView = this
                newView.activity = activity;
                newView.injectProps()
                newView.renderTree()
                newRenderedViews.add(newView)

            }
        } else {
            newView.parentView = this
            newView.activity = activity;
            newView.injectProps()
            newView.renderTree()
            newRenderedViews.add(newView)
        }
    }

    fun prop(str : String, value : Any) {
        this.props.put(str,value)
    }

    open fun layout() {
        if (this.layoutFn != null) {
            this.childTree.clear()
            this.layoutFn!!()
        }
    }

    fun renderTree() {
        newRenderedViews = mutableListOf()
        if (this !is NativeView) {
            // Virtual view:
            __current = this;
            this.childTree.clear()
            this.layout();
            // Remove last child (root view), see addChild for more info
            children.removeAt(children.lastIndex)
        } else {
            if (this.androidView == null) {
                this.androidView = this.renderNative(this.activity!!);
            }
            __current = this;
            this.layout();
        }
        for (child in this.childTree) {
            render(child)
        }
        (subViews-newRenderedViews).forEach {
            it.notifyWillDetach()
        }
        this.subViews = newRenderedViews;
    }

    open fun notifyWillDetach() {
        subViews.forEach { it.notifyWillDetach() }
        onViewWillDetach()
        isDetached = true
    }
    open fun onPropsUpdated(oldProps: Map<String, Any?>): Boolean {
        return true;
    }

    fun xml(layoutXml: String) {
        throw Exception("Using XML requires gradle plugin")
    }

    fun getColor(color : Int) : Int{
        if (Build.VERSION.SDK_INT >= 23) {
            return activity!!.resources.getColor(color, null);
        } else {
            return activity!!.getResources().getColor(color);
        }
    }




    //-------------------
    // Activity Listeners
    fun activityOnRequestPermissionsResult(fn: (Int,Array<out String>,IntArray)->Unit) {
        if (activity !is LatteActivity) {
            throw Exception("Attempted to attach onRequestPermission listener in LatteView that is not hosted by LatteActivity. Please make sure top level activity is instance of LatteActivity")
        }
        (activity as LatteActivity).onRequestPermissionsResult(fn)

    }
    fun activityOnBackPressed(fn : ()->Boolean) {
        if (activity !is LatteActivity) {
            throw Exception("Attempted to attach onBackPressed listener in LatteView that is not hosted by LatteActivity. Please make sure top level activity is instance of LatteActivity")
        }
        (activity as LatteActivity).onBackPressed(fn)
    }

    fun activityOnResume(fn : ()->Unit) {
        if (activity !is LatteActivity) {
            throw Exception("Attempted to attach onResume listener in LatteView that is not hosted by LatteActivity. Please make sure top level activity is instance of LatteActivity")
        }
        (activity as LatteActivity).onResume(fn)
    }
    fun activityOnResumeOnce(fn : ()->Unit) {
        if (activity !is LatteActivity) {
            throw Exception("Attempted to attach onResume listener in LatteView that is not hosted by LatteActivity. Please make sure top level activity is instance of LatteActivity")
        }
        (activity as LatteActivity).onResumeOnce(fn)
    }


    fun activityOnPauseOnce(fn : ()->Unit) {
        if (activity !is LatteActivity) {
            throw Exception("Attempted to attach onPause listener in LatteView that is not hosted by LatteActivity. Please make sure top level activity is instance of LatteActivity")
        }
        (activity as LatteActivity).onPause(fn)
    }



    fun activityOnPause(fn : ()->Unit) {
        if (activity !is LatteActivity) {
            throw Exception("Attempted to attach onPause listener in LatteView that is not hosted by LatteActivity. Please make sure top level activity is instance of LatteActivity")
        }
        (activity as LatteActivity).onPause(fn)
    }

    fun activityOnStart(fn : ()->Unit) {
        if (activity !is LatteActivity) {
            throw Exception("Attempted to attach onStart listener in LatteView that is not hosted by LatteActivity. Please make sure top level activity is instance of LatteActivity")
        }
        (activity as LatteActivity).onStart(fn)
    }

    fun activityOnStop(fn : ()->Unit) {
        if (activity !is LatteActivity) {
            throw Exception("Attempted to attach onStop listener in LatteView that is not hosted by LatteActivity. Please make sure top level activity is instance of LatteActivity")
        }
        (activity as LatteActivity).onStop(fn)
    }

    fun activityOnDestroy(fn : ()->Unit) {
        if (activity !is LatteActivity) {
            throw Exception("Attempted to attach onDestroy listener in LatteView that is not hosted by LatteActivity. Please make sure top level activity is instance of LatteActivity")
        }
        (activity as LatteActivity).onDestroy(fn)
    }

    fun activityOnActivityResult(fn: (Int, Int, Intent?)->Unit) {
        if (activity !is LatteActivity) {
            throw Exception("Attempted to attach onActivityResult listener in LatteView that is not hosted by LatteActivity. Please make sure top level activity is instance of LatteActivity")
        }
        (activity as LatteActivity).onActivityResult(fn)
    }

    fun activityOnActivityResultOnce(fn: (Int, Int, Intent?)->Unit) {
        if (activity !is LatteActivity) {
            throw Exception("Attempted to attach onActivityResult listener in LatteView that is not hosted by LatteActivity. Please make sure top level activity is instance of LatteActivity")
        }
        (activity as LatteActivity).onActivityResultOnce(fn)
    }

}

