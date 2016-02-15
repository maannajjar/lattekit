package io.lattekit.ui.view

import android.content.Context
import android.view.View
import com.bumptech.glide.Glide

class ImageView extends NativeView {

    def Object getSrc() {
        return if (props.containsKey("src")) props.get("src") else null;
    }

    def String getScaleType(){
        return if (props.containsKey("scaleType")) props.get("scaleType") as String else null
    }
    def loadWithGlide(android.widget.ImageView view) {
        var glideRequest = Glide.with(activity).load(props.get("src") as String);
        if (props.containsKey("placeholder")) {
            glideRequest.placeholder(props.get("placeholder") as Integer)
        }
        if (props.get("crossFade") == "true" || props.get("crossFade") == true) {
            glideRequest.crossFade();
        }
        if (props.get("centerCrop") == "true" || props.get("centerCrop") == true) {
            glideRequest.centerCrop();
        }
        glideRequest.into(view);

    }
    override applyProps() {
        super.applyProps()
        var view = androidView as android.widget.ImageView;
        if (src instanceof String) {
            loadWithGlide(view);
        } else if (src instanceof Integer) {
            view.imageResource = src as Integer;
        }

        if (scaleType != null) {
            view.scaleType = if (scaleType == "fitXY") {
                android.widget.ImageView.ScaleType.FIT_XY;
            } else {
                try {
                    android.widget.ImageView.ScaleType.valueOf(scaleType.replaceAll("([A-Z])","_$1").toUpperCase);
                } catch (Exception ex) {
                    null;
                }
            }
        }



    }


    override getViewClass() {
        return android.widget.ImageView;
    }


}