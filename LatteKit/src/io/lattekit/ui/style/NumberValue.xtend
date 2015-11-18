package io.lattekit.ui.style

import android.content.Context
import android.util.TypedValue
import org.eclipse.xtend.lib.annotations.Accessors

class NumberValue {
    @Accessors var int value;
    @Accessors var int type;
    @Accessors String valueType;
    Float cached;
    new(int value, int type) {
        this.value = value;
        this.type = type;
        valueType = "Integer";
        if (type == TypedValue.COMPLEX_UNIT_PX) {
            cached = value as float;
        }   
    }
    
    new(float value, int type) {
        this.value = Math.round(value);
        this.type = type;
        valueType = "Float";
        if (type == TypedValue.COMPLEX_UNIT_PX) {
            cached = value;
        }
    }   
    def inPixels(Context context) {
        if (cached != null) { return cached;}
        if (type == TypedValue.COMPLEX_UNIT_DIP) {
            cached = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value,context.resources.displayMetrics);
        } else if (type == TypedValue.COMPLEX_UNIT_SP) {
            cached = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, value,context.resources.displayMetrics);
        }
        if (cached == null) {
            cached = value as float
        }
        return cached;
    }
    
    def int inPixelsInt(Context context) {
        return Math.round(inPixels(context))
    }
} 
