package io.lattekit.ui.view


import android.content.Context
import android.os.Handler
import android.widget.FrameLayout
import android.view.ViewGroup

/**
 * Created by maan on 2/6/16.
 */
class SwipeRefreshLayout  extends NativeWrapperViewGroup {

    override getViewClass() {
        return android.support.v4.widget.SwipeRefreshLayout
    }

}