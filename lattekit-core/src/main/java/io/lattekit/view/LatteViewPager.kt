package io.lattekit.view

import android.R
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.PagerAdapter
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.FrameLayout
import android.widget.ListView
import io.lattekit.util.Util
import java.util.*

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
            val _arguments = this.arguments
            val _string = _arguments.getString("_LATTE_KIT_OBJ_ID")
            val _get = LatteViewPager.PagerFragment.Companion.SAVED_OBJECTS[_string]
            this.templateView = _get

            if (this.templateView == null) {
                return View(this.activity)
            }
            return this.templateView!!.buildView(_activity, lp)
        }

        companion object {
            private val SAVED_OBJECTS = HashMap<String, LatteView>()

            fun newInstance(template: LatteView): LatteViewPager.PagerFragment {
                val myId = "" + 100*Math.random()!! + System.currentTimeMillis()
                val args = Bundle()
                args.putString("_LATTE_KIT_OBJ_ID", myId)
                LatteViewPager.PagerFragment.Companion.SAVED_OBJECTS.put(myId, template)
                val instance = LatteViewPager.PagerFragment()
                instance.arguments = args
                return instance
            }
        }
    }

    private var adapter: PagerAdapter? = null

    override fun applyProps(props : Map<String,Any?>) {
        super.applyProps(props)
        val view = this.androidView as android.support.v4.view.ViewPager
        if (view.adapter != adapter) {
            view.adapter = adapter
        }
        adapter?.notifyDataSetChanged()

    }
    override fun getViewClass(): Class<out View> {
        return android.support.v4.view.ViewPager::class.java
    }

    override fun onViewCreated() {
        if (!this.props.containsKey("id")) {
            this.androidView?.id = Util.makeResId("io.lattekit", "id", "viewPager")
        }

//        if (this.props.containsKey("data")) {
//            this.adapter = LatteFragmentStatePagerAdapter(this);
//        } else {
//            this.adapter = LatteFragmentPagerAdapter(this);
//        }
        this.adapter = LattePlainPagerAdapter(this);
        val view = this.androidView as android.support.v4.view.ViewPager
        view.adapter = this.adapter
        this.adapter!!.notifyDataSetChanged()
        super.onViewCreated()
    }

}
