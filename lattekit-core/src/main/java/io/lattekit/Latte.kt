package io.lattekit

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Xml
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.*
import io.lattekit.activity.LatteActivity
import io.lattekit.plugin.LattePlugin
import io.lattekit.plugin.css.CssPlugin
import io.lattekit.view.*
import org.xmlpull.v1.XmlPullParser
import java.io.StringReader
import java.lang.reflect.Field
import java.lang.reflect.Proxy
import java.util.*

/**
 * Created by maan on 2/27/16.
 */

object Latte {
    object PropOption {
        val NO_OPTIONS = 0;
        val WAIT_LAYOUT = 1;
    }

    var CLASS_ORDER = Comparator<Class<out View>> { p0, p1 ->
        if (p0.isAssignableFrom(p1)) 1 else -1
    }

    var PLUGINS = mutableListOf<LattePlugin>(CssPlugin())
    var SAVED_OBJECTS = mutableMapOf<String, LatteView>();
    var PROP_FILEDS = mutableMapOf<String, MutableMap<String, Field>>()
    var VIEW_FILEDS = mutableMapOf<String, MutableMap<Int, Field>>()
    var ADAPTERS =  mutableMapOf(
        ImageView::class.java to LatteImageView::class.java,
        AdapterView::class.java to LatteListView::class.java,
        RelativeLayout::class.java to LatteRelativeLayout::class.java,
        LinearLayout::class.java to LatteLinearLayout::class.java
    )

    var LOOKUP_CACHE: MutableMap<String, Class<out Any>> = mutableMapOf(
        "WebView" to android.webkit.WebView::class.java
    )

    init {
        try {
            ADAPTERS.put(android.support.v7.widget.RecyclerView::class.java, LatteRecyclerView::class.java)
        } catch (e: NoClassDefFoundError) { }
        try {
            ADAPTERS.put(android.support.v4.view.ViewPager::class.java, LatteViewPager::class.java)
        } catch (e: NoClassDefFoundError) { }
    }

    fun props(vararg objects: Any?): MutableMap<String, Any?> {
        var map = mutableMapOf<String, Any?>()
        for (i in 0..objects.size - 1 step 2) {
            map.put(objects.get(i) as String, objects.get(i + 1))
        }
        return map;
    }

    fun getSavedObject(id: String): LatteView? {
        return SAVED_OBJECTS.get(id)
    }

    fun lookupClass(className: String): Class<*> {
        var cachedCls: Class<*>? = LOOKUP_CACHE.get(className);
        var clazz = if ( cachedCls != null ) {
            cachedCls
        } else if (className.contains("."))  {
            var cls = Class.forName(className)
            LOOKUP_CACHE.put(className, cls);
            cls
        } else {
            var cls = Class.forName("android.widget." + className);
            LOOKUP_CACHE.put(className, cls);
            cls
        }
        return clazz
    }

    fun render(layoutXml : String, props: MutableMap<String, Any?> = mutableMapOf()): LatteView {
        var layout = parseXml(layoutXml)
        layout.props = props;
        return layout
    }

    fun createNative(renderingView : LatteView, clazz: Class<*>, props: MutableMap<String, Any?>, propsOptions: Map<String,Int>, propsSetter: (NativeView, Map<String,Any?>)->List<String>, childrenProc: (LatteView)->Unit): LatteView {
        var layout: LatteView?;
        var adaptableClass = ADAPTERS.filterKeys { it.isAssignableFrom(clazz) }.keys.sortedWith(CLASS_ORDER).getOrNull(0);
        if (adaptableClass != null) {
            var adapter = ADAPTERS.get(adaptableClass)!!;
            layout = adapter.newInstance()
            layout.nativeViewClass = clazz as Class<out View>
            layout.propsSetter = propsSetter;
        } else if (ViewGroup::class.java.isAssignableFrom(clazz)) {
            layout = NativeViewGroup();
            layout.nativeViewClass = clazz as Class<out View>
            layout.propsSetter = propsSetter;
        } else {
            layout = NativeView();
            layout.nativeViewClass = clazz as Class<out View>
            layout.propsSetter = propsSetter;
        }
        layout!!.renderingView = renderingView;
        layout!!.props = props;
        layout!!.propsOptions = propsOptions;
        layout!!.childTree = mutableListOf()
        childrenProc?.invoke(layout)

        return layout!!;
    }

    fun create(renderingView : LatteView?, clazz: Class<*>, props: MutableMap<String, Any?>,  propsOptions: Map<String,Int>,childrenProc: (LatteView)->Unit): LatteView {
        var layout: LatteView?;
        var adaptableClass = ADAPTERS.filterKeys { it.isAssignableFrom(clazz) }.keys.sortedWith(CLASS_ORDER).getOrNull(0);
        if (adaptableClass != null) {
            var adapter = ADAPTERS.get(adaptableClass)!!;
            layout = adapter.newInstance()
            layout.nativeViewClass = clazz as Class<out View>
        } else if (ViewGroup::class.java.isAssignableFrom(clazz)) {
            layout = NativeViewGroup();
            layout.nativeViewClass = clazz as Class<out View>
        } else if (View::class.java.isAssignableFrom(clazz)) {
            layout = NativeView();
            layout.nativeViewClass = clazz as Class<out View>
        }  else if (NativeView::class.java.isAssignableFrom(clazz)) {
            layout = clazz.newInstance() as LatteView;
        }  else {
            var implClass =  try {
                Class.forName(clazz.name + "Impl")
            } catch(ex : ClassNotFoundException ) {
                clazz
            }
            layout = implClass.newInstance() as LatteView;
        }
        layout?.props = props;
        layout!!.propsOptions = propsOptions;
        layout.childTree = mutableListOf()
        layout.renderingView = renderingView;
        childrenProc?.invoke(layout)

        return layout
    }

    fun createLambdaProxyInstance(receiverClass : Class<*> , value: Object ) : Any {
        var instance = Proxy.newProxyInstance(receiverClass.getClassLoader(), arrayOf(receiverClass),
            { any, invokedMethod, args ->
                if (value is kotlin.Function0<*>) {
                    value.invoke()
                } else if (args.size == 1 && value is Function1<*,*>) {
                    (value as Function1<Any?,Any?>).invoke(args[0])
                } else if (args.size == 2 && value is Function2<*,*,*>) {
                    (value as Function2<Any?,Any?,Any?>).invoke(args[0],args[1])
                } else if (args.size == 3 && value is Function3<*,*,*,*>) {
                    (value as Function3<Any?,Any?,Any?,Any?>).invoke(args[0],args[1],args[2])
                } else if (args.size == 4 && value is Function4<*,*,*,*,*>) {
                    (value as Function4<Any?,Any?,Any?,Any?,Any?>).invoke(args[0],args[1],args[2],args[3])
                } else if (args.size == 0 && value is kotlin.Function0<*>) {
                    value.invoke()
                } else {
                    null
                }            })
        return instance;
    }

    fun registerAdapter(androidClass : Class<out View>, adapterClass : Class<out NativeView>) {
        ADAPTERS.put(androidClass, adapterClass)
    }

    fun showActivity(latteView : LatteView, viewXml: String, props: MutableMap<String,Any?> = mutableMapOf()) {
        showActivity(latteView.activity!!, viewXml,props)
    }


    fun showActivity(context: Context,viewXml: String, props: MutableMap<String,Any?> = mutableMapOf()) {
        var latteView = Latte.render(viewXml,props);
        var myId = "${System.currentTimeMillis()}";
        var intent = Intent(context, LatteActivity::class.java);
        intent.putExtra("_LATTE_KIT_OBJ_ID", myId)
        Latte.SAVED_OBJECTS.put(myId, latteView)
        context.startActivity(intent);
    }

    fun showDialog(activity: Activity,viewXml: String,  props: MutableMap<String,Any?> = mutableMapOf(), width : Int = WindowManager.LayoutParams.MATCH_PARENT, height: Int = WindowManager.LayoutParams.WRAP_CONTENT) {
        var latteView = Latte.render(viewXml,props);
        var dialogBuilder = AlertDialog.Builder(activity)
        dialogBuilder.setView(latteView.buildView(activity,null))
        var dialog = dialogBuilder.create()
        var lp = WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = width;
        lp.height = height;
        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }

    fun showDropdown(latteView : LatteView,viewXml: String, anchor : View, props: MutableMap<String,Any?> = mutableMapOf(), xOffset : Int= 0, yOffset : Int = 0, gravity : Int= Gravity.TOP or Gravity.LEFT) {
        var renderedView = Latte.render(viewXml,props);
        renderedView.parentView = latteView
        var view = renderedView.buildView(latteView.activity!!,null)
        var window = PopupWindow(view,ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        window.isFocusable = true
        renderedView.popupWindow = window
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.showAsDropDown(anchor, xOffset, yOffset, gravity)
        } else {
            window.showAsDropDown(anchor, xOffset, yOffset)
        }

    }


    fun showDialog(latteView : LatteView,viewXml: String,  props: MutableMap<String,Any?> = mutableMapOf(), width : Int = WindowManager.LayoutParams.MATCH_PARENT, height: Int = WindowManager.LayoutParams.WRAP_CONTENT) {
        showDialog(latteView.activity!!, viewXml,props,width,height)
    }
}


fun parseXml(layoutXml: String): LatteView {
    var currentView: LatteView? = null
    var topLevelViews = mutableListOf<LatteView>()
    var viewStack = Stack<LatteView>()

    var parser = Xml.newPullParser();
    parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
    parser.setInput(StringReader(layoutXml))
    while (parser.next() != XmlPullParser.END_DOCUMENT) {
        if (parser.getEventType() == XmlPullParser.START_TAG) {
            var tagName = parser.getName();
            var myView = Latte.create(null, Latte.lookupClass(tagName), mutableMapOf(), emptyMap(), {})
            myView.renderingView = myView;
            if (currentView != null) {
                viewStack.add(currentView)
                currentView.childTree.add(myView)
            }
            for (i in 0..parser.attributeCount-1) {
                myView.prop(parser.getAttributeName(i),parser.getAttributeValue(i))
            }
            currentView = myView
        } else if (parser.eventType == XmlPullParser.END_TAG) {
            if (!viewStack.empty()) {
                currentView = viewStack.pop()
            } else {
                topLevelViews.add(currentView!!)
            }
        }
    }
    return topLevelViews[0]!!
}


fun Activity.render(xml: String, props : MutableMap<String,Any?> = mutableMapOf()): LatteView {
    var latteView = Latte.render(xml,props)
    if (this is LatteActivity) {
        this.latteView = latteView
    }
    setContentView(latteView.buildView(this,WindowManager.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT)))
    return latteView;
}
fun IF(condition : Boolean, result  :()->Unit ) : Unit  {
    if(condition) result.invoke() else ""
    return;
};