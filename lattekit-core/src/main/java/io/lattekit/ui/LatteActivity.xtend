package io.lattekit.ui

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import io.lattekit.ui.style.Stylesheet
import io.lattekit.ui.view.LatteView
import java.util.List
import android.support.v4.app.FragmentActivity

class LatteActivity extends FragmentActivity {

    protected LatteView latteView;
    protected View androidView;


    override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        var myId = intent.getStringExtra("_LATTE_KIT_OBJ_ID");

        if (myId != null) {
            latteView = LatteView.getSavedObject(myId)
            androidView = latteView.buildView(this, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT));
            setContentView(androidView);
        }
    }

    def onStateChanged() {
        latteView.onStateChanged();
    }

    def onViewMounted() {

    }

    def List<Stylesheet> getCssFiles() {
        return #[]
    }
}