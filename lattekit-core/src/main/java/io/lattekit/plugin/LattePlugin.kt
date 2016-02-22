package io.lattekit.plugin

import io.lattekit.ui.view.LatteView

/**
 * Created by maan on 2/20/16.
 */


open abstract class LattePlugin {


    open abstract fun onPropsUpdated(view : LatteView, oldProps: MutableMap<String,Any?>);
    open abstract fun onViewMounted(view : LatteView);
    open abstract fun onViewWillMount(view : LatteView);

}