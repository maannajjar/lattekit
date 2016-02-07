package io.lattekit.ui.view

import android.content.Context
import android.view.View

/**
 * Created by maan on 2/6/16.
 */
class TextView extends NativeView {

    def String getText(){
        return if (props.containsKey("text")) props.get("text") as String else null
    }


    override applyProps() {
        super.applyProps();
        var view = androidView as android.widget.TextView
        view.text = text
    }

    override getViewClass() {
        return android.widget.TextView;
    }

}