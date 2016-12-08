package io.lattekit.view

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

/**
 * Created by maan on 3/26/16.
 */
class LatteRecyclerView : NativeView() {

    var data : List<Any>? = emptyList()
        get() = props["data"] as List<Any>?

    var adapter = LatteTemplateRecyclerAdapter(this);

    override fun applyProps(props: Map<String, Any?>) {
        super.applyProps(props)
//        if (data != null || childTree.isNotEmpty()) {
//            if (data != null) adapter.data = data!!
//            adapter.templates = childTree
//            var recyclerView = (this.androidView as RecyclerView)
//            recyclerView.adapter = adapter;
//            if (recyclerView.layoutManager == null) {
//                recyclerView.layoutManager = LinearLayoutManager(this.activity);
//            }
//            adapter.notifyDataSetChanged()
//        }
    }
}