package io.lattekit.activity

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.view.View
import android.widget.FrameLayout
import io.lattekit.Latte
import io.lattekit.view.LatteView

/**
 * Created by maan on 2/15/16.
 */
open class LatteActivity : FragmentActivity()  {

    var latteView : LatteView? = null;
    var androidView  : View? = null;

    var listeners : MutableMap<String,MutableList<Function0<*>>> = mutableMapOf()
    var permissionListeners : MutableMap<String,MutableList<Function3<*,*,*,*>>> = mutableMapOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        var myId = getIntent().getStringExtra("_LATTE_KIT_OBJ_ID");

        if (myId != null) {
            latteView = Latte.getSavedObject(myId)
            androidView = latteView?.buildView(this, FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
            setContentView(androidView);
        }
    }

    //-------------------
    // onBackPressed Listeners

    fun onBackPressed(fn : ()->Boolean) {
        listeners.getOrPut("onBackPressed", { mutableListOf() }).add(fn)
    }

    override fun onBackPressed() {
        var shortCircuit = listeners["onBackPressed"]?.map {
            var result = it.invoke()
            if (result != null && result is Boolean) result else false
        }?.reduce { c, b -> c || b } ?: false

        if (!shortCircuit) {
            super.onBackPressed()
        }
    }

    //-------------------
    // onResume Listeners

    fun onResume(fn : ()->Unit) {
        listeners.getOrPut("onResume", { mutableListOf() }).add(fn)
    }

    override fun onResume() {
        super.onResume()
        listeners["onResume"]?.forEach {
            var result = it.invoke()
        }
    }

    //-------------------
    // onPause Listeners
    fun onPause(fn : ()->Unit) {
        listeners.getOrPut("onPause", { mutableListOf() }).add(fn)
    }

    override fun onPause() {
        super.onPause()
        listeners["onPause"]?.forEach {
            var result = it.invoke()
        }
    }

    //-------------------
    // onStart Listeners
    fun onStart(fn : ()->Unit) {
        listeners.getOrPut("onStart", { mutableListOf() }).add(fn)
    }

    override fun onStart() {
        super.onStart()
        listeners["onStart"]?.forEach {
            var result = it.invoke()
        }
    }

    //-------------------
    // onStop Listeners
    fun onStop(fn : ()->Unit) {
        listeners.getOrPut("onStop", { mutableListOf() }).add(fn)
    }

    override fun onStop() {
        super.onStop()
        listeners["onStop"]?.forEach {
            var result = it.invoke()
        }
    }

    //-------------------
    // onStop Listeners
    fun onDestroy(fn : ()->Unit) {
        listeners.getOrPut("onDestroy", { mutableListOf() }).add(fn)
    }

    override fun onDestroy() {
        super.onDestroy()
        latteView?.notifyWillDetach()
        listeners["onDestroy"]?.forEach {
            var result = it.invoke()
        }

        var myId = intent.getStringExtra("_LATTE_KIT_OBJ_ID");
        if (myId != null) {
            Latte.SAVED_OBJECTS.remove(myId)
        }

    }

    //-----------------
    // onRequestPermissionsResult
    fun onRequestPermissionsResult(fn : (Int,Array<out String>,IntArray)->Unit) {
        permissionListeners.getOrPut("onRequestPermissionsResult", { mutableListOf() }).add(fn)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        permissionListeners["onRequestPermissionsResult"]?.forEach {
            (it as (Int,Array<out String>,IntArray)->Unit).invoke(requestCode,permissions,grantResults)
        }

    }
}