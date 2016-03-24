package io.lattekit.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentPagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import io.lattekit.util.Util
import java.lang.reflect.ParameterizedType
import java.util.*

/**
 * Created by maan on 3/8/16.
 */



/**
 * Created by maan on 2/7/16.
 */
class LatteViewPager : NativeView() {
    class PagerFragment : Fragment() {

        private var templateView: LatteView? = null

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            val _arguments = this.arguments
            val _string = _arguments.getString("_LATTE_KIT_OBJ_ID")
            val _get = LatteViewPager.PagerFragment.Companion.SAVED_OBJECTS[_string]
            this.templateView = _get
        }

        override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            val lp = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT)
            val _activity = this.activity
            return this.templateView!!.buildView(_activity, lp)
        }

        companion object {
            private val SAVED_OBJECTS = HashMap<String, LatteView>()

            fun newInstance(template: LatteView): LatteViewPager.PagerFragment {
                val myId = "" + Math.random()!! + System.currentTimeMillis()
                val args = Bundle()
                args.putString("_LATTE_KIT_OBJ_ID", myId)
                LatteViewPager.PagerFragment.Companion.SAVED_OBJECTS.put(myId, template)
                val instance = LatteViewPager.PagerFragment()
                instance.arguments = args
                return instance
            }
        }
    }

    private var adapter: FragmentPagerAdapter? = null

    val data: List<*>
        get() {
            val _get = this.props["data"]
            return _get as List<*>
        }


    override fun getViewClass(): Class<out View> {
        return android.support.v4.view.ViewPager::class.java
    }

    override fun onViewMounted() {
        this.androidView?.id = Util.makeResId("io.lattekit", "id", "viewPager")

        this.adapter = object : FragmentPagerAdapter((this.activity as FragmentActivity).supportFragmentManager) {

            override fun getCount(): Int {
                return data.size
            }

            override fun getItem(position: Int): Fragment {
                val item = data[position]
                var defaultView = -1
                var selectedTemplate = -1
                for (i in 0..children.size-1) {
                    run {
                        val child = children[i]
                        if (isMatch(child, item!!, position)!!) {
                            selectedTemplate = i
                        }
                        if (child.props["defaultView"] == true || child.props["defaultView"] == "true") {
                            defaultView = i
                        }
                    }
                }
                if (defaultView == -1 && selectedTemplate == -1) {
                    throw Exception("Couldn't find template for psoition " + Integer.valueOf(position)!!)
                } else {
                    if (selectedTemplate == -1) {
                        selectedTemplate = defaultView
                    }
                }
                val template = children[selectedTemplate].copy()
                template.props.put("modelIndex", Integer.valueOf(position))
                template.props.put("model", item)
                template.parentView = this@LatteViewPager
                return LatteViewPager.PagerFragment.Companion.newInstance(template)
            }
        }
        val view = this.androidView as android.support.v4.view.ViewPager
        view.adapter = this.adapter
        this.adapter!!.notifyDataSetChanged()
        super.onViewMounted()
    }

    fun isMatch(template: LatteView, item: Any, position: Int): Boolean {
        var testLambda = template.props.get("when");
        if (testLambda == null) {
            return false;
        }
        if (testLambda !is kotlin.Function1<*, *> && testLambda !is kotlin.Function2<*, *, *>) {
            // TODO: Warn about wrong "when" variable
            log("Latte", "Warning 'when' should be a lambda ")
            return false;
        }
        var isMatch = false;
        if (testLambda is kotlin.Function2<*,*,*>) {
            var modelType = (testLambda.javaClass.genericInterfaces.get(0) as ParameterizedType).actualTypeArguments.get(0) as Class<*>
            if (modelType.isAssignableFrom(item.javaClass)) {
                var test = (testLambda as kotlin.Function2<Any,Any,Any>).invoke(item,position);
                if (test is Boolean) {
                    return test;
                } else {
                    log("Latte", "Warning 'when' should return boolean ")
                }
            } else {
                log("Latte", "Skipping $template : $testLambda ")
            }
        }
        return isMatch;
    }

}
