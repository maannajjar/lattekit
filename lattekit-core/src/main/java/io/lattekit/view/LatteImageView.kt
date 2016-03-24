package io.lattekit.view

import android.view.View
import com.bumptech.glide.Glide

/**
 * Created by maan on 2/15/16.
 */
class LatteImageView : NativeView() {

    fun getSrc() : Any? {
        return if (props.containsKey("src")) props.get("src") else null;
    }

    fun getScaleType() : String? {
        return props.get("scaleType") as String?
    }
    fun loadWithGlide(view : android.widget.ImageView) {
        var glideRequest = Glide.with(activity).load(props.get("src") as String);
        if (props.containsKey("placeholder")) {
            glideRequest.placeholder(props.get("placeholder") as Int)
        }
        if (props.get("crossFade") == "true" || props.get("crossFade") == true) {
            glideRequest.crossFade();
        }
        if (props.get("centerCrop") == "true" || props.get("centerCrop") == true) {
            glideRequest.centerCrop();
        }
        glideRequest.into(view);

    }

    override fun applyProps(props : Map<String,Any?>) {
        super.applyProps(props)
        var view = androidView as android.widget.ImageView;
        if (getSrc() is String) {
            loadWithGlide(view);
        } else if (getSrc() is Int) {
            view.setImageResource(getSrc() as Int);
        }

        if (getScaleType() != null) {
            view.scaleType = if (getScaleType() == "fitXY") {
                android.widget.ImageView.ScaleType.FIT_XY;
            } else {
                try {
                    android.widget.ImageView.ScaleType.valueOf(getScaleType()?.replace("([A-Z])".toRegex(),"_\$1" )?.toUpperCase()!!);
                } catch ( ex : Exception) {
                    null;
                }
            }
        }
    }

    override fun getViewClass() : Class<out View> {
        return android.widget.ImageView::class.java;
    }
}