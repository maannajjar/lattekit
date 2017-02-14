package io.lattekit.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.FrameLayout
import io.lattekit.Latte
import io.lattekit.render
import io.lattekit.util.Util
import io.lattekit.view.LatteView

/**
 * Created by maan on 2/15/16.
 */
open class LatteActivity : AppCompatActivity()  {

    var latteView : LatteView? = null;
    var androidView  : View? = null;

    var listeners : MutableMap<String,MutableList<Function0<*>>> = mutableMapOf()
    var permissionListeners : MutableMap<String,MutableList<Function3<*,*,*,*>>> = mutableMapOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        if (intent != null && intent.getIntExtra("activityTheme",-1) != -1) {
            setTheme(intent.getIntExtra("activityTheme",-1))
        }
        renderContent()
    }

    fun renderContent() {
        if (this.javaClass != LatteActivity::class.java) return;
        var viewXml = intent.getStringExtra("_LATTE_XML");
        var props = intent.getBundleExtra("_LATTE_PROPS");
        if (viewXml != null) {
            render(viewXml, Util.toMap(props))
            return;
        } else {
            var myId = intent.getStringExtra("_LATTE_KIT_OBJ_ID");
            if (myId != null) {
                latteView = Latte.getSavedObject(myId)
                androidView = latteView?.buildView(this, FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
                if (androidView != null) {
                    setContentView(androidView)
                }
            }
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

    fun onResumeOnce(fn : ()->Unit) {
        listeners.getOrPut("onResumeOnce", { mutableListOf() }).add(fn)
    }



    override fun onResume() {
        super.onResume()
        listeners["onResume"]?.forEach {
            var result = it.invoke()
        }
        listeners["onResumeOnce"]?.forEach {
            var result = it.invoke()
        }
        listeners["onResumeOnce"]?.clear()
    }

    //-------------------
    // onPause Listeners
    fun onPause(fn : ()->Unit) {
        listeners.getOrPut("onPause", { mutableListOf() }).add(fn)
    }
    fun onPauseOnce(fn : ()->Unit) {
        listeners.getOrPut("onPauseOnce", { mutableListOf() }).add(fn)
    }

    override fun onPause() {
        super.onPause()
        listeners["onPause"]?.forEach {
            var result = it.invoke()
        }
        listeners["onPauseOnce"]?.forEach {
            var result = it.invoke()
        }
        listeners["onPauseOnce"]?.clear()
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
        permissionListeners["onRequestPermissionsResult"]?.clear()

    }


    //-----------------
    // onActivityResult
    fun onActivityResult(fn : (Int,Int,Intent?)->Unit) {
        permissionListeners.getOrPut("onActivityResult", { mutableListOf() }).add(fn)
    }

    fun onActivityResultOnce(fn : (Int,Int,Intent?)->Unit) {
        permissionListeners.getOrPut("onActivityResultOnce", { mutableListOf() }).add(fn)
    }
    
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        permissionListeners["onActivityResult"]?.forEach {
            (it as (Int,Int,Intent?)->Unit).invoke(requestCode,resultCode,data)
        }

        permissionListeners["onActivityResultOnce"]?.forEach {
            (it as (Int,Int,Intent?)->Unit).invoke(requestCode,resultCode,data)
        }
        permissionListeners["onActivityResultOnce"]?.clear()

    }




}