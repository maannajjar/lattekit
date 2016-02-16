package io.lattekit.ui.style;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.google.common.base.Objects;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class NumberValue {
    @Accessors
    private int value;

    @Accessors
    private int type;

    @Accessors
    private String valueType;

    private Float cached;

    public NumberValue(final int value, final int type) {
        this.value = value;
        this.type = type;
        this.valueType = "Integer";
        if ((type == TypedValue.COMPLEX_UNIT_PX)) {
            this.cached = Float.valueOf(((float) value));
        }
    }

    public NumberValue(final float value, final int type) {
        int _round = Math.round(value);
        this.value = _round;
        this.type = type;
        this.valueType = "Float";
        if ((type == TypedValue.COMPLEX_UNIT_PX)) {
            this.cached = Float.valueOf(value);
        }
    }

    public Float inPixels(final Context context) {
        boolean _notEquals = (!Objects.equal(this.cached, null));
        if (_notEquals) {
            return this.cached;
        }
        if ((this.type == TypedValue.COMPLEX_UNIT_DIP)) {
            Resources _resources = context.getResources();
            DisplayMetrics _displayMetrics = _resources.getDisplayMetrics();
            float _applyDimension = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.value, _displayMetrics);
            this.cached = Float.valueOf(_applyDimension);
        } else {
            if ((this.type == TypedValue.COMPLEX_UNIT_SP)) {
                Resources _resources_1 = context.getResources();
                DisplayMetrics _displayMetrics_1 = _resources_1.getDisplayMetrics();
                float _applyDimension_1 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, this.value, _displayMetrics_1);
                this.cached = Float.valueOf(_applyDimension_1);
            }
        }
        boolean _equals = Objects.equal(this.cached, null);
        if (_equals) {
            this.cached = Float.valueOf(((float) this.value));
        }
        return this.cached;
    }

    public int inPixelsInt(final Context context) {
        Float _inPixels = this.inPixels(context);
        return Math.round((_inPixels).floatValue());
    }

    @Override
    public boolean equals(final Object other) {
        if ((other instanceof NumberValue)) {
            return ((((NumberValue)other).type == this.type) && (((NumberValue)other).value == this.value));
        }
        return super.equals(other);
    }

    @Pure
    public int getValue() {
        return this.value;
    }

    public void setValue(final int value) {
        this.value = value;
    }

    @Pure
    public int getType() {
        return this.type;
    }

    public void setType(final int type) {
        this.type = type;
    }

    @Pure
    public String getValueType() {
        return this.valueType;
    }

    public void setValueType(final String valueType) {
        this.valueType = valueType;
    }
}
