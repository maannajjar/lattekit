package io.lattekit.ui.view

import android.view.ViewGroup
import android.widget.FrameLayout
import android.content.Context
import android.view.View

/**
 * Created by maan on 2/7/16.
 * This is basically the same as native view group but it's helpful for custom view groups that modify or add children
 * For example, android.support.v4.widget.SwipeRefreshLayout adds its own child (the refresh indicator)
 * NativeWrapperViewGroup will ensure that the refresh indictaor is not touched
 *
 * Use io.lattekit.ui.view.NativeViewGroup if you're sure your native ViewGroup doesn't modify its children (i.e. android.widget.LinearLayout,..etc)
 */
abstract class NativeWrapperViewGroup extends NativeViewGroup {

    FrameLayout containerView;
    ViewGroup layoutView;

    override renderNative(Context context) {
        layoutView = super.renderNative(context) as ViewGroup
        containerView = new FrameLayout(context);
        layoutView.addView(containerView, super.createLayoutParams());
        return layoutView;
    }

    override createLayoutParams() {
        return new FrameLayout.LayoutParams(-1,-1);
    }

    override getContainer() {
        return containerView;
    }


}