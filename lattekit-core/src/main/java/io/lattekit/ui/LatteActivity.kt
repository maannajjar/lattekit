package io.lattekit.ui

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.view.View
import android.widget.FrameLayout
import io.lattekit.Latte
import io.lattekit.plugin.css.declaration.Stylesheet
import io.lattekit.view.LatteView

/**
 * Created by maan on 2/15/16.
 */
class LatteActivity : FragmentActivity()  {

    var latteView : LatteView? = null;
    var androidView  : View? = null;

    var onBackPress : ()->Boolean = { false }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        var myId = getIntent().getStringExtra("_LATTE_KIT_OBJ_ID");

        if (myId != null) {
            latteView = Latte.getSavedObject(myId)
            androidView = latteView?.buildView(this, FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT));
            setContentView(androidView);
        }
    }

    override fun onBackPressed() {
        if (!this.onBackPress()) {
            super.onBackPressed()
        }
    }
    fun onStateChanged() {
        latteView?.onStateChanged();
    }

    fun onViewMounted() {

    }

    fun getCssFiles() :  List<Stylesheet> {
        return emptyList()
    }

    override fun onDestroy() {
        super.onDestroy()
        var myId = getIntent().getStringExtra("_LATTE_KIT_OBJ_ID");

        if (myId != null) {
            Latte.Companion.SAVED_OBJECTS.remove(myId)
        }

    }
}