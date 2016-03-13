package io.lattekit

import android.app.Activity
import android.content.Context
import android.util.Log
import android.util.Xml
import android.view.View
import android.view.ViewGroup
import io.lattekit.plugin.LattePlugin
import io.lattekit.plugin.css.CssPlugin
import io.lattekit.ui.view.*
import org.xmlpull.v1.XmlPullParser
import java.io.StringReader
import java.lang.ref.WeakReference
import java.lang.reflect.Field
import java.util.*

/**
 * Created by maan on 2/27/16.
 */

class Latte {
    companion object {
        var PLUGINS = mutableListOf<LattePlugin>(CssPlugin())
        var SAVED_OBJECTS = mutableMapOf<String, LatteView>();
        var PROP_FILEDS = mutableMapOf<String, MutableMap<String, Field>>()
        var RECYCLED_VIEWS = mutableMapOf<String, MutableList<WeakReference<LatteView>>>()
        var RECYCLED_INSTANCES = mutableMapOf<String, MutableList<WeakReference<LatteView>>>()

        @JvmStatic
        var LOOKUP_CACHE: MutableMap<String, Class<out Any>> = mutableMapOf(
            "View" to View::class.java,
            "TextView" to android.widget.TextView::class.java,
            "ImageView" to ImageView::class.java,
            "ListView" to ListView::class.java,
            "LinearLayout" to LinearLayout::class.java,
            "RelativeLayout" to RelativeLayout::class.java,
            "ViewPager" to ViewPager::class.java,
            "WebView" to android.webkit.WebView::class.java
        )

        fun recycleView(view: LatteView) {
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

        fun getRecycledView(forView: LatteView): LatteView? {
            if (forView is NativeView) {
                var recycleKey = forView.props.get("recycle")
                if (recycleKey != null) {

                    var list = RECYCLED_VIEWS.get(forView.getViewClass().name + ":" + recycleKey);
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
        fun log(message: String) {
            Log.d("Latte", message)
        }

        @JvmStatic
        fun log(tag: String, message: String) {
            Log.d(tag, message)
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

        @JvmStatic
        fun create(layoutFn : LatteView.() -> Unit): LatteView {
            var layout: LatteView = LatteView();
            layout.layoutFn = layoutFn
            return layout
        }

        @JvmStatic
        fun render(layoutXml : String): LatteView {
            return xml(layoutXml)
        }

        @JvmStatic
        fun recycle(view : LatteView) {
            if (view is NativeView && view.androidView != null) {
                return;
            }
            var key = view.props.get("__cache_key") ?: view.javaClass.name
            RECYCLED_INSTANCES.getOrPut(key as String, { mutableListOf() }).add(WeakReference(view))
        }

        @JvmStatic
        fun create(clazz: Class<*>, props: MutableMap<String, Any?>, childrenProc: ChildrenProc): LatteView {
            var layout: LatteView?;
            var cache = RECYCLED_INSTANCES.get(clazz.name)
            if (cache != null && !cache.isEmpty()) {
                layout = cache.removeAt(0).get()
                if (layout != null ) {
                    layout.props = props;
                    layout.children = mutableListOf()
                    childrenProc?.apply(layout)
                    return layout
                }
            }
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
            props.put("__cache_key", clazz.name)
            layout.children = mutableListOf()
            childrenProc?.apply(layout)

            return layout
        }


    }
}



fun lxml(layoutXml: String): LatteView {
    throw Exception("Using LXML requires gradle plugin")
}

fun xml(layoutXml: String): LatteView {
    var currentView: LatteView? = null
    var topLevelViews = mutableListOf<LatteView>()
    var viewStack = Stack<LatteView>()

    var parser = Xml.newPullParser();
    parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
    parser.setInput(StringReader(layoutXml))
    while (parser.next() != XmlPullParser.END_DOCUMENT) {
        if (parser.getEventType() == XmlPullParser.START_TAG) {
            var tagName = parser.getName();
            var myView = Latte.create(Latte.lookupClass(tagName), mutableMapOf(), ChildrenProc {})
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
fun Activity.render(xml: String): LatteView {
    var latteView = Latte.render(xml)
    setContentView(latteView.buildView(this,null))
    return latteView;
}