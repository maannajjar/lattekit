package io.lattekit.view

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.ViewGroup
import io.lattekit.Latte
import java.lang.reflect.ParameterizedType

/**
 * Created by maan on 4/26/16.
 */

class LattePagerAdapter(var parentView : LatteView) {
    var childItems : MutableMap<Int, LatteView> = mutableMapOf()
    val data: List<*>?
        get() {
            val _get = parentView.props["data"]
            return _get as List<*>?
        }
    fun isMatch(template: LatteView, item: Any, position: Int): Boolean {
        var testLambda = template.props.get("when");
        if (testLambda == null) {
            return false;
        }
        if (testLambda !is kotlin.Function1<*, *> && testLambda !is kotlin.Function2<*, *, *>) {
            LatteView.log("Latte", "Warning 'when' should be a lambda ")
            return false;
        }
        var isFn2 = testLambda is kotlin.Function2<*, *, *>
        var modelType = (testLambda.javaClass.genericInterfaces.get(0) as ParameterizedType).actualTypeArguments.get(0) as Class<*>

        if (modelType.isAssignableFrom(item.javaClass)) {
            var secondParamType: Class<*>? = null
            if (isFn2) {
                secondParamType = (testLambda.javaClass.genericInterfaces.get(0) as ParameterizedType).actualTypeArguments.get(1) as Class<*>;
                if (!secondParamType.isAssignableFrom(Integer::class.java)) {
                    LatteView.log("Warning: second parameter's type is " + secondParamType.name + ". It must be an integer which will contain model index")
                    return false;
                }
            }
            var isMatch = if (!isFn2) {
                (testLambda as Function1<Any,Any>).invoke(item) as Boolean
            } else {
                (testLambda as Function2<Any,Any,Any>).invoke(item,position) as Boolean
            }
            return isMatch;
        } else {
            LatteView.log("Warning: model of type " + item.javaClass.name + " is not assignable to " + modelType)
        }
        return false;
    }


    fun getCount(): Int {
        return data?.size ?: parentView.childTree.size
    }

    fun getPageTitle(position: Int): CharSequence? {
        var template = getMatchingTemplate(position);
        var pageTitle = template.props.get("pageTitle")
        if (pageTitle != null && pageTitle is String) {
            return pageTitle;
        }
        return null;
    }

    fun getMatchingTemplate(position: Int) : LatteView {
        if (data != null) {
            val item = data!![position]
            var defaultView = -1
            var selectedTemplate = -1
            for (i in 0..parentView.childTree.size - 1) {
                val child = parentView.childTree[i]
                if (isMatch(child, item!!, position)!!) {
                    selectedTemplate = i
                }
                if (child.props["defaultView"] == true || child.props["defaultView"] == "true") {
                    defaultView = i
                }
            }
            if (defaultView == -1 && selectedTemplate == -1) {
                throw Exception("Couldn't find template for psoition " + Integer.valueOf(position)!!)
            } else {
                if (selectedTemplate == -1) {
                    selectedTemplate = defaultView
                }
            }
            val template = parentView.childTree[selectedTemplate]
            return template
        } else {
            return parentView.childTree[position]
        }
    }

    fun getItem(position: Int): Fragment {
        var selectedTemplate = getMatchingTemplate(position);
        if (data != null) {
            // When data set is provided, the template will be shared by multiple items. So we should make a copy of it
            val item = data!![position]
            val template = selectedTemplate.copy()
            template.props.put("modelIndex", Integer.valueOf(position))
            template.props.put("model", item)
            template.parentView = parentView
            childItems.put(position,template)
            return LatteViewPager.PagerFragment.Companion.newInstance(template)
        } else {
            selectedTemplate.parentView = parentView
            childItems.put(position,selectedTemplate)
            return LatteViewPager.PagerFragment.Companion.newInstance(selectedTemplate)
        }
    }

    fun destroyItem(position: Int) {
        childItems[position]?.onViewWillDetach()
        childItems.remove(position)
    }
    fun notifyDataSetChanged() {
        childItems.keys.forEach { position ->
            var view = childItems[position]
            var selectedTemplate = getMatchingTemplate(position);
            if (view != null && selectedTemplate.javaClass == view!!.javaClass) {
                var oldProps = view!!.props
                var newTemplate = selectedTemplate!!.copy()
                view.childTree = newTemplate.childTree
                view.props = newTemplate.props
                view?.injectProps()
                Latte.PLUGINS.forEach { it.onPropsUpdated(view, oldProps) }
                if (view.onPropsUpdated(oldProps)) {
                    view.notifyStateChanged()
                }
            }
        }
    }

}

class LatteFragmentPagerAdapter(var latteView : LatteView) : FragmentPagerAdapter((latteView.activity!! as FragmentActivity).supportFragmentManager) {
    var pagerAdapter = LattePagerAdapter(latteView);
    override fun getCount(): Int = pagerAdapter.getCount()
    override fun getItem(position: Int): Fragment? = pagerAdapter.getItem(position)
    override fun getPageTitle(position: Int) = pagerAdapter.getPageTitle(position) ?: super.getPageTitle(position)
    override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) = pagerAdapter.destroyItem(position)
    override fun notifyDataSetChanged() {
        pagerAdapter?.notifyDataSetChanged()
        super.notifyDataSetChanged()
    }
}

class LatteFragmentStatePagerAdapter(var latteView : LatteView) : FragmentStatePagerAdapter((latteView.activity!! as FragmentActivity).supportFragmentManager) {
    var pagerAdapter = LattePagerAdapter(latteView);
    override fun getCount(): Int = pagerAdapter.getCount()
    override fun getItem(position: Int): Fragment? = pagerAdapter.getItem(position)
    override fun getPageTitle(position: Int) = pagerAdapter.getPageTitle(position) ?: super.getPageTitle(position)
    override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) = pagerAdapter.destroyItem(position)
    override fun notifyDataSetChanged() {
        pagerAdapter?.notifyDataSetChanged()
        super.notifyDataSetChanged()
    }

}