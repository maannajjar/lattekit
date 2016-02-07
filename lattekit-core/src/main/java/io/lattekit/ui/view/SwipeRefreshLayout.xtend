package io.lattekit.ui.view


import android.content.Context
import android.os.Handler
import android.widget.FrameLayout
import android.view.ViewGroup
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Created by maan on 2/6/16.
 */


class SwipeRefreshLayout  extends NativeViewGroup {

    override getViewClass() {
        return android.support.v4.widget.SwipeRefreshLayout
    }


}