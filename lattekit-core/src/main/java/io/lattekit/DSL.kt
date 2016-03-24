package io.lattekit

import android.support.v4.widget.DrawerLayout
import android.widget.Toolbar
import io.lattekit.ui.view.LatteView
import io.lattekit.ui.view.LatteLinearLayout

/**
 * Created by maan on 2/27/16.
 */
inline fun LatteView.DrawerLayout(noinline init: LatteView.() -> Unit = {}) = register(DrawerLayout::class,init);
inline fun LatteView.LinearLayout(noinline init: LatteView.() -> Unit = {}) = register(LatteLinearLayout::class,init);
inline fun LatteView.Toolbar(noinline init: LatteView.() -> Unit = {}) = register(Toolbar::class,init);
