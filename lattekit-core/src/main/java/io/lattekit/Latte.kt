package io.lattekit

import android.app.Activity
import android.support.v4.view.ViewPager
import android.util.Xml
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import io.lattekit.plugin.LattePlugin
import io.lattekit.plugin.css.CssPlugin
import io.lattekit.view.*
import org.xmlpull.v1.XmlPullParser
import java.io.StringReader
import java.lang.reflect.Field
import java.lang.reflect.Proxy
import java.util.*
import kotlin.jvm.functions.Function0

/**
 * Created by maan on 2/27/16.
 */

class Latte {
    companion object {
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
            LinearLayout::class.java to LatteLinearLayout::class.java,
            ViewPager::class.java to LatteViewPager::class.java,
            android.support.v7.widget.RecyclerView::class.java to LatteRecyclerView::class.java
        )

        @JvmStatic
        var LOOKUP_CACHE: MutableMap<String, Class<out Any>> = mutableMapOf(
            "WebView" to android.webkit.WebView::class.java
        )

        @JvmStatic
        fun props(vararg objects: Any?): MutableMap<String, Any?> {
            var map = mutableMapOf<String, Any?>()
            for (i in 0..objects.size - 1 step 2) {
                map.put(objects.get(i) as String, objects.get(i + 1))
            }
            return map;
        }

        @JvmStatic
        fun getSavedObject(id: String): LatteView? {
            return SAVED_OBJECTS.get(id)
        }

        @JvmStatic
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

        fun create(layoutFn : LatteView.() -> Unit): LatteView {
            var layout: LatteView = LatteView();
            layout.layoutFn = layoutFn
            return layout
        }

        fun render(layoutXml : String): LatteView {
            return parseXml(layoutXml)
        }

        @JvmStatic
        fun createNative(clazz: Class<*>, props: MutableMap<String, Any?>, propsOptions: Map<String,Int>, propsSetter: (NativeView, Map<String,Any?>)->List<String>, childrenProc: (LatteView)->Unit): LatteView {
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

            layout!!.props = props;
            layout!!.propsOptions = propsOptions;
            layout!!.children = mutableListOf()
            childrenProc?.invoke(layout)

            return layout!!;
        }

        @JvmStatic
        fun create(clazz: Class<*>, props: MutableMap<String, Any?>,  propsOptions: Map<String,Int>,childrenProc: (LatteView)->Unit): LatteView {
            var layout: LatteView?;
            if (ViewGroup::class.java.isAssignableFrom(clazz)) {
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
            layout.props = props;
            layout!!.propsOptions = propsOptions;
            layout.children = mutableListOf()
            childrenProc?.invoke(layout)

            return layout
        }

        fun createLambdaProxyInstance(receiverClass : Class<*> , value: Object ) : Any {
            var instance = Proxy.newProxyInstance(receiverClass.getClassLoader(), arrayOf(receiverClass),
                { any, invokedMethod, arrayOfAnys ->
                    if (value is Function0<*>) {
                        value.invoke()
                    } else {
                        null
                    }
                })
            return instance;
        }

        fun registerAdapter(androidClass : Class<out View>, adapterClass : Class<out NativeView>) {
            ADAPTERS.put(androidClass, adapterClass)
        }

    }

}



fun lxml(layoutXml: String): LatteView {
    throw Exception("Using LXML requires gradle plugin")
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
            var myView = Latte.create(Latte.lookupClass(tagName), mutableMapOf(), emptyMap(), {})
            if (currentView != null) {
                viewStack.add(currentView)
                currentView.children.add(myView)
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

object PropOption {
    val NO_OPTIONS = 0;
    val WAIT_LAYOUT = 1;
}

fun Activity.render(xml: String): LatteView {
    var latteView = Latte.render(xml)
    setContentView(latteView.buildView(this,null))
    return latteView;
}