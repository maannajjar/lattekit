package io.lattekit

import android.app.Activity
import android.util.Log
import android.util.Xml
import android.view.View
import android.view.ViewGroup
import io.lattekit.plugin.LattePlugin
import io.lattekit.plugin.css.CssPlugin
import io.lattekit.ui.view.*
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
        var PLUGINS = mutableListOf<LattePlugin>(CssPlugin())
        var SAVED_OBJECTS = mutableMapOf<String, LatteView>();
        var PROP_FILEDS = mutableMapOf<String, MutableMap<String, Field>>()

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

        fun create(layoutFn : LatteView.() -> Unit): LatteView {
            var layout: LatteView = LatteView();
            layout.layoutFn = layoutFn
            return layout
        }

        fun render(layoutXml : String): LatteView {
            return xml(layoutXml)
        }

        @JvmStatic
        fun createNative(clazz: Class<*>, props: MutableMap<String, Any?>, propsSetter: (NativeView, Map<String,Any?>)->List<String> , childrenProc: ChildrenProc): LatteView {
            var layout: LatteView?;
            log("Checking ${clazz.simpleName}")
            var cachedCls = LOOKUP_CACHE.get(clazz.simpleName)

            if (cachedCls != null && NativeView::class.java.isAssignableFrom(cachedCls)) {
                log("Creating ${cachedCls} instead")
                layout = cachedCls!!.newInstance() as NativeView;
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

            layout.props = props;
            layout.children = mutableListOf()
            childrenProc?.apply(layout)

            return layout;
        }

        @JvmStatic
        fun create(clazz: Class<*>, props: MutableMap<String, Any?>, childrenProc: ChildrenProc): LatteView {
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
            layout.children = mutableListOf()
            childrenProc?.apply(layout)

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