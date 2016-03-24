package io.lattekit.plugin

import io.lattekit.view.LatteView

/**
 * Created by maan on 2/20/16.
 */


open abstract class LattePlugin {
    open fun onPropsUpdated(view : LatteView, oldProps: MutableMap<String,Any?>) {}
    open fun onViewMounted(view : LatteView) {}
    open fun onViewWillMount(view : LatteView) {}
    open fun onViewRendered(view : LatteView) {}

}