package io.lattekit.ui.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.view.ViewGroup
import io.lattekit.annotation.Prop
import io.lattekit.plugin.css.CssPlugin
import io.lattekit.ui.LatteActivity
import java.lang.ref.WeakReference
import java.lang.reflect.Field

/**
 * Created by maan on 2/15/16.
 */
open class LatteView {

    companion object {
        var PLUGINS  = mutableListOf(CssPlugin())
        var SAVED_OBJECTS = mutableMapOf<String,LatteView>();
        var PROP_FILEDS = mutableMapOf<String, MutableMap<String,Field>>()
        var RECYCLED_VIEWS = mutableMapOf<String, MutableList<WeakReference<LatteView>>>()

        @JvmStatic
        var LOOKUP_CACHE : MutableMap<String,Class<out Any>>  = mutableMapOf(
                "View" to View::class.java,
                "TextView" to android.widget.TextView::class.java,
                "ImageView" to ImageView::class.java,
                "ListView" to ListView::class.java,
                "LinearLayout" to LinearLayout::class.java,
                "RelativeLayout" to RelativeLayout::class.java,
                "ViewPager" to ViewPager::class.java,
                "WebView" to android.webkit.WebView::class.java
        )

        fun recycleView(view : LatteView) {
            if (view is NativeView) {
                var recycleKey = view.props.get("recycle")
                if (recycleKey != null) {
                    var list = RECYCLED_VIEWS.get(view.getViewClass().name + ":" + recycleKey);
                    if (list == null) {
                        list = mutableListOf()
                        RECYCLED_VIEWS.put(view.getViewClass().name + ":" + recycleKey, list)
                    }
                    view.isMounted = false
                    list.add(WeakReference(view))
                }
            }
        }

        fun getRecycledView(forView : LatteView) : LatteView? {
            if (forView is NativeView) {
                var recycleKey = forView.props.get("recycle")
                if (recycleKey != null) {

                    var list = RECYCLED_VIEWS.get(forView.getViewClass().name+":"+recycleKey);
                    if (list == null) {
                        list = mutableListOf()
                        RECYCLED_VIEWS.put(forView.getViewClass().name + ":" + recycleKey, list)
                    }
                    var view = list.getOrNull(0)
                    if (view != null) {
                        list.removeAt(0);
                        log("Recycler", "Re-used View ${view}")
                    }
                    return view?.get()
                }
            }
            return null;
        }

        @JvmStatic
        fun props(vararg objects : Any?) : MutableMap<String,Any?> {
            var map = mutableMapOf<String,Any?>()
            for (i in 0..objects.size-1 step 2) {
                map.put(objects.get(i) as String, objects.get(i+1))
            }
            return map;
        }

        @JvmStatic
        fun getSavedObject(id : String) : LatteView? {
            return SAVED_OBJECTS.get(id)
        }

        @JvmStatic
        fun log(message : String) {
            Log.d("Latte",message)
        }

        @JvmStatic
        fun log(tag : String, message : String) {
            Log.d(tag,message)
        }


        @JvmStatic
        fun createLayout( viewType : String , props: MutableMap<String,Any?> ) : LatteView {
            return createLayout(mutableListOf(), viewType, props, ChildrenProc { mutableListOf() })
        }

        @JvmStatic
        fun createLayout(viewType : String , props: MutableMap<String,Any?> , childrenProc: ChildrenProc) : LatteView {
            return createLayout(mutableListOf(), viewType, props, childrenProc)
        }

        @JvmStatic
        fun createLayout(imports : MutableList<String>, vT: String , props: MutableMap<String,Any?>, childrenProc: ChildrenProc) : LatteView {
            var layout : LatteView? = null;
            var viewType = vT;
            var cachedCls: Class<*>? = LOOKUP_CACHE.get(vT);
            var clazz = if ( cachedCls != null ) {
                cachedCls
            } else if (vT.contains(".")) {
                var cls =  try {
                    var cls = Class.forName(vT+"Impl")
                    if (!LatteView::class.java.isAssignableFrom(cls)) {
                        cls = Class.forName(vT)
                    }
                    cls
                } catch (ex: ClassNotFoundException ){
                    Class.forName(vT)
                }
                LOOKUP_CACHE.put(vT,cls);
                cls
            } else {
                var cls = Class.forName("android.widget."+vT);
                LOOKUP_CACHE.put(vT,cls);
                cls
            }
            log("Found class " + clazz)
            if (ViewGroup::class.java.isAssignableFrom(clazz)) {
                layout = NativeViewGroup();
                (layout as NativeViewGroup).nativeViewClass = clazz as Class<out View>
                viewType = clazz.name
            } else if (View::class.java.isAssignableFrom(clazz)) {
                layout = NativeView();
                (layout as NativeView).nativeViewClass = clazz as Class<out View>
                viewType = clazz.name
            } else {
                layout = clazz.newInstance() as LatteView;
                viewType = clazz.name
            }

            layout.viewType = viewType;
            layout.props = props;
            layout.childrenProc = childrenProc;
            layout.children = layout.childrenProc?.apply() as MutableList<LatteView>

            return layout
        }


    }

    var viewType : String? = null;
    var renderedViews: MutableList<LatteView> = mutableListOf()
    var androidView: View? = null

    var props : MutableMap<String,Any?> = mutableMapOf()
    var parentView : LatteView? = null

    var children = mutableListOf<LatteView>()

    var objectId : String? = null;
    var activity : Activity? = null
    var childrenProc : ChildrenProc? = null
    var isMounted : Boolean = false;

    var dataValues  = mutableMapOf<String,Any?>()

    val propFields : MutableMap<String,Field>
        get() {
            var map = PROP_FILEDS[this.javaClass.name]
            if (map == null) {
                val newMap = mutableMapOf<String,Field>()
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
                PROP_FILEDS.put(this.javaClass.name,newMap)
                return newMap
            }
            return map!!
        }


    var rootAndroidView : View? = null
        get() {
            if (this.androidView != null) {
                return this.androidView
            } else if (this.renderedViews.get(0) != null) {
                return this.renderedViews.get(0).rootAndroidView;
            }
            return null
        }


    var id : Int = 0
        get() = this.props.get("id") as Int

    fun buildView(activity: Activity, lp : ViewGroup.LayoutParams) : View {
        this.activity = activity;
        this.renderTree()
        this.buildAndroidViewTree(activity,lp);
        return this.rootAndroidView!!;
    }

    fun notifyMounted() {
        isMounted = true;
        findRefs(this.renderedViews);
        PLUGINS.forEach { it.onViewMounted(this) }
        onViewMounted();
    }

    fun onStateChanged() {
        handleStateChanged()
    }

    fun handleStateChanged() {
        this.renderTree()
        this.buildAndroidViewTree(activity as Context, rootAndroidView?.layoutParams!!);
        PLUGINS.forEach { it.onViewRendered(this) }
    }

    fun data(key : String) : Any? {
        return dataValues.get(key)
    }

    fun data(key : String, value : Any?) : Any? {
        dataValues.put(key,value)
        return value
    }

    fun dataOrPut(key : String, defaultValue : Any?) : Any? {
        var originalValue = dataValues.get(key)
        if (originalValue == null) {
            dataValues.put(key,defaultValue)
            return defaultValue
        }
        return originalValue
    }


    fun show(caller : LatteView) {
        var myId = "${System.currentTimeMillis()}";
        var intent = Intent(caller.rootAndroidView?.context, LatteActivity::class.java);
        intent.putExtra("_LATTE_KIT_OBJ_ID",myId)
        LatteView.SAVED_OBJECTS.put(myId,this)
        caller.rootAndroidView?.context?.startActivity(intent);
    }

    open fun onViewMounted() {
    }
    open fun onViewWillMount() {

    }
    fun buildAndroidViewTree(a: Context, lp: ViewGroup.LayoutParams) : View {
        // First build my view
        this.activity = a as Activity;
        if (!isMounted) {
            PLUGINS.forEach { it.onViewWillMount(this) }
            this.onViewWillMount()
        }
        if (this is NativeView) {
            if (this.androidView == null) {
                this.androidView = this.renderNative(a);
            }
            if (this.androidView?.layoutParams == null) {
                this.androidView?.layoutParams = lp;
            }
            if (this is NativeViewGroup) {
                this.mountChildren()
            }
            if (!isMounted) {
                notifyMounted();
            }
            return this.androidView!!
        } else {
            // If we don't have native android view, then we are virtual node
            var subAndroid =  this.renderedViews[0].buildAndroidViewTree(a, lp);
            if (!isMounted) {
                notifyMounted();
            }
            return subAndroid;
        }
    }

    fun getNonVirtualParent() : NativeView? {
        if (parentView is NativeView) {
            return parentView as NativeView;
        }
        return parentView?.getNonVirtualParent()
    }

    fun copy() : LatteView {
        val copy = this.javaClass.newInstance()
        copy.props = mutableMapOf();
        this.props.forEach { entry -> copy.props.put(entry.key,entry.value) }
        copy.children = mutableListOf()
        children.forEach { copy.children.add(it.copy()) }
        copy.viewType = viewType
        return copy;
    }

    fun findRefs(subViews : List<LatteView>) {
        subViews.forEach { it : LatteView ->
            var ref : String? = it.props.get("ref") as String?
            if ( ref != null ) {
                val fieldName = ref;
                var field = this.javaClass.getDeclaredFields().find { f -> f.name == fieldName}
                if (field != null) {
                    field.setAccessible(true);
                    if (field.getType().isAssignableFrom(it.javaClass)) {
                        field.set(this, it);
                    } else if (it.androidView != null && field.getType().isAssignableFrom(it.androidView?.javaClass)) {
                        field.set(this, it.androidView);
                    }
                } else {
                    log("Couldn't find field " + fieldName)
                }
            }
            this.findRefs(it.children)
        }
    }



    open fun  injectProps() {
        log("${this} I have props fields ${propFields.map{"${it.key}"}.joinToString(",")} ::: ${this.javaClass.declaredFields.map{"${it.name} : ${it.isAnnotationPresent(Prop::class.java)}"}.joinToString(",")}")
        propFields.forEach{ it ->
            if (!this.props.containsKey(it.key)) {
                // Remove deleted property
                var field = propFields.get(it.key)
                field?.set(this, null)
            }
        }

        this.props?.forEach { entry ->
            var field : Field? = this.propFields[entry.key]
            if ( field != null) {
                if (field.getType().isAssignableFrom(entry.value?.javaClass)) {
                    field.set(this,entry.value)
                } else {
                    // TODO: Maybe need to throw exception ?
                    log("WARNING: Provided property ${entry.key} value with different type, it will be set to null")
                }

            }
        }
    }
    open fun renderImpl() : LatteView? {
        return null
    }


    fun sameView(leftView : LatteView, rightView : LatteView) : Boolean {
        if (leftView.javaClass == rightView.javaClass && leftView.viewType == rightView.viewType) {
            return true;
        }
        return false;
    }

    fun renderTree() {
        var newRenderedViews  = mutableListOf<LatteView>()

        injectProps()

        var renderMe = this.renderImpl()
        if (renderMe != null) {
            newRenderedViews.add(renderMe)
        }
        if (this is NativeViewGroup) {
            for (child in this.children) {
                newRenderedViews.add(child)
            }
        }

        for (i in 0..newRenderedViews.size-1) {
            var newView = newRenderedViews.get(i);
            if (i < renderedViews.size) {
                var oldView : LatteView = renderedViews.get(i)
                if (sameView(oldView, newView)) {
                    var oldProps = oldView.props
                    oldView.children = newView.children
                    oldView.props = newView.props
                    PLUGINS.forEach { it.onPropsUpdated(oldView,oldView.props) }
                    if (oldView.onPropsUpdated(oldProps)) {
                        oldView.renderTree()
                    }
                    newRenderedViews[i] = oldView
                } else {
                    // Try find recycled view
                    var recycledOldView = getRecycledView(newView)
                    if (recycledOldView != null) {
                        recycledOldView.parentView = this
                        recycledOldView.children = newView.children
                        recycledOldView.props = newView.props
                        recycledOldView.isMounted = false
                        recycledOldView.renderTree()
                        newRenderedViews[i] = recycledOldView
                    } else {
                        newView.parentView = this
                        newView.renderTree()
                    }
                }
            } else {
                var recycledOldView = getRecycledView(newView)
                if (recycledOldView != null) {
                    recycledOldView.parentView = this
                    recycledOldView.children = newView.children
                    recycledOldView.props = newView.props
                    recycledOldView.isMounted = false
                    recycledOldView.renderTree()
                    newRenderedViews[i] = recycledOldView
                } else {
                    newView.parentView = this
                    newView.renderTree()
                }
            }
        }
        this.renderedViews.forEach {
            if (!newRenderedViews.contains(it)) {
                recycleView(it)
            }
        }

        this.renderedViews = newRenderedViews;

    }


    open fun onPropsUpdated(props : Map<String, Any?> ) : Boolean {
        return true;
    }

    open fun render() : String {
        return ""
    }


}