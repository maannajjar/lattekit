package io.lattekit.ui;

import android.animation.AnimatorSet;
import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.base.Objects;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class Style {
  @Accessors
  public Object backgroundColor;
  
  @Accessors
  public Object borderColor;
  
  @Accessors
  public Object textColor;
  
  @Accessors
  public Integer backgroundDrawable;
  
  @Accessors
  public Integer cornerRadius;
  
  @Accessors
  public Integer borderWidth;
  
  @Accessors
  public Integer margin;
  
  @Accessors
  public Integer marginTop;
  
  @Accessors
  public Integer marginBottom;
  
  @Accessors
  public Integer marginLeft;
  
  @Accessors
  public Integer marginRight;
  
  @Accessors
  public Integer elevation;
  
  @Accessors
  public Integer translationY;
  
  @Accessors
  public Integer translationX;
  
  public Style inheritsFrom(final Style parentStyle) {
    Style myStyle = new Style();
    Object _otherwise = this.otherwise(this.backgroundColor, parentStyle.backgroundColor);
    myStyle.backgroundColor = _otherwise;
    Object _otherwise_1 = this.otherwise(this.borderColor, parentStyle.borderColor);
    myStyle.borderColor = _otherwise_1;
    Object _otherwise_2 = this.otherwise(this.textColor, parentStyle.textColor);
    myStyle.textColor = _otherwise_2;
    Integer _otherwise_3 = this.otherwise(this.backgroundDrawable, parentStyle.backgroundDrawable);
    myStyle.backgroundDrawable = _otherwise_3;
    Integer _otherwise_4 = this.otherwise(this.cornerRadius, parentStyle.cornerRadius);
    myStyle.cornerRadius = _otherwise_4;
    Integer _otherwise_5 = this.otherwise(this.borderWidth, parentStyle.borderWidth);
    myStyle.borderWidth = _otherwise_5;
    Integer _otherwise_6 = this.otherwise(this.margin, parentStyle.margin);
    myStyle.margin = _otherwise_6;
    Integer _otherwise_7 = this.otherwise(this.marginTop, parentStyle.marginTop);
    myStyle.marginTop = _otherwise_7;
    Integer _otherwise_8 = this.otherwise(this.marginBottom, parentStyle.marginBottom);
    myStyle.marginBottom = _otherwise_8;
    Integer _otherwise_9 = this.otherwise(this.marginLeft, parentStyle.marginLeft);
    myStyle.marginLeft = _otherwise_9;
    Integer _otherwise_10 = this.otherwise(this.marginRight, parentStyle.marginRight);
    myStyle.marginRight = _otherwise_10;
    Integer _otherwise_11 = this.otherwise(this.elevation, parentStyle.elevation);
    myStyle.elevation = _otherwise_11;
    Integer _otherwise_12 = this.otherwise(this.translationX, parentStyle.translationX);
    myStyle.translationX = _otherwise_12;
    Integer _otherwise_13 = this.otherwise(this.translationY, parentStyle.translationY);
    myStyle.translationY = _otherwise_13;
    return myStyle;
  }
  
  public AnimatorSet createAnimatorFrom(final Style startStyle, final View androidView) {
    AnimatorSet animSet = new AnimatorSet();
    IntEvaluator _intEvaluator = new IntEvaluator();
    Integer _otherwise = this.otherwise(startStyle.elevation, Integer.valueOf(0));
    Integer _otherwise_1 = this.otherwise(this.elevation, Integer.valueOf(0));
    ObjectAnimator animator1 = ObjectAnimator.ofObject(androidView, "elevation", _intEvaluator, _otherwise, _otherwise_1);
    animator1.setDuration(100);
    IntEvaluator _intEvaluator_1 = new IntEvaluator();
    Integer _otherwise_2 = this.otherwise(startStyle.translationY, Integer.valueOf(0));
    Integer _otherwise_3 = this.otherwise(this.translationY, Integer.valueOf(0));
    ObjectAnimator animator2 = ObjectAnimator.ofObject(androidView, "translationY", _intEvaluator_1, _otherwise_2, _otherwise_3);
    animator2.setDuration(100);
    IntEvaluator _intEvaluator_2 = new IntEvaluator();
    Integer _otherwise_4 = this.otherwise(startStyle.translationX, Integer.valueOf(0));
    Integer _otherwise_5 = this.otherwise(this.translationX, Integer.valueOf(0));
    ObjectAnimator animator3 = ObjectAnimator.ofObject(androidView, "translationX", _intEvaluator_2, _otherwise_4, _otherwise_5);
    animator3.setDuration(100);
    animSet.playTogether(animator1, animator2, animator3);
    return animSet;
  }
  
  public Object otherwise(final Object left, final Object or) {
    Object _xifexpression = null;
    boolean _notEquals = (!Objects.equal(left, null));
    if (_notEquals) {
      _xifexpression = left;
    } else {
      _xifexpression = or;
    }
    return _xifexpression;
  }
  
  public Integer otherwise(final Integer left, final Integer or) {
    Integer _xifexpression = null;
    boolean _notEquals = (!Objects.equal(left, null));
    if (_notEquals) {
      _xifexpression = left;
    } else {
      _xifexpression = or;
    }
    return _xifexpression;
  }
  
  public Drawable getDrawable() {
    int _asColor = Style.asColor(this.backgroundColor);
    int _asColor_1 = Style.asColor(this.backgroundColor);
    GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { _asColor, _asColor_1 });
    Integer _otherwise = this.otherwise(this.borderWidth, Integer.valueOf(0));
    int _asColor_2 = Style.asColor(this.borderColor);
    drawable.setStroke((_otherwise).intValue(), _asColor_2);
    Integer _otherwise_1 = this.otherwise(this.cornerRadius, Integer.valueOf(0));
    drawable.setCornerRadius((_otherwise_1).intValue());
    return drawable;
  }
  
  public ShapeDrawable getShapeDrawable() {
    float[] _xifexpression = null;
    boolean _notEquals = (!Objects.equal(this.cornerRadius, null));
    if (_notEquals) {
      _xifexpression = new float[] { (this.cornerRadius).intValue(), (this.cornerRadius).intValue(), (this.cornerRadius).intValue(), (this.cornerRadius).intValue(), (this.cornerRadius).intValue(), (this.cornerRadius).intValue(), (this.cornerRadius).intValue(), (this.cornerRadius).intValue() };
    } else {
      _xifexpression = null;
    }
    float[] radii = _xifexpression;
    RoundRectShape shape = new RoundRectShape(radii, null, null);
    return new ShapeDrawable(shape);
  }
  
  public ViewGroup.LayoutParams applyStyle(final View androidView) {
    if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)) {
      Integer _otherwise = this.otherwise(this.elevation, Integer.valueOf(0));
      androidView.setElevation((_otherwise).intValue());
    }
    Integer _otherwise_1 = this.otherwise(this.translationY, Integer.valueOf(0));
    androidView.setTranslationY((_otherwise_1).intValue());
    Integer _otherwise_2 = this.otherwise(this.translationX, Integer.valueOf(0));
    androidView.setTranslationX((_otherwise_2).intValue());
    ViewGroup.LayoutParams lp = androidView.getLayoutParams();
    if ((lp instanceof ViewGroup.MarginLayoutParams)) {
      Log.d("Latte", "Setting margins");
      boolean _notEquals = (!Objects.equal(this.margin, null));
      if (_notEquals) {
        ((ViewGroup.MarginLayoutParams)lp).leftMargin = (this.margin).intValue();
        ((ViewGroup.MarginLayoutParams)lp).topMargin = (this.margin).intValue();
        ((ViewGroup.MarginLayoutParams)lp).rightMargin = (this.margin).intValue();
        ((ViewGroup.MarginLayoutParams)lp).bottomMargin = (this.margin).intValue();
      }
      boolean _notEquals_1 = (!Objects.equal(this.marginLeft, null));
      if (_notEquals_1) {
        ((ViewGroup.MarginLayoutParams)lp).leftMargin = (this.marginLeft).intValue();
      }
      boolean _notEquals_2 = (!Objects.equal(this.marginRight, null));
      if (_notEquals_2) {
        ((ViewGroup.MarginLayoutParams)lp).rightMargin = (this.marginRight).intValue();
      }
      boolean _notEquals_3 = (!Objects.equal(this.marginBottom, null));
      if (_notEquals_3) {
        ((ViewGroup.MarginLayoutParams)lp).bottomMargin = (this.marginBottom).intValue();
      }
      boolean _notEquals_4 = (!Objects.equal(this.marginTop, null));
      if (_notEquals_4) {
        Log.d("Latte", "Setting top margin");
        ((ViewGroup.MarginLayoutParams)lp).topMargin = (this.marginTop).intValue();
      }
    }
    return lp;
  }
  
  public static int asColor(final Object color) {
    boolean _equals = Objects.equal(color, null);
    if (_equals) {
      return Color.WHITE;
    } else {
      if ((color instanceof Integer)) {
        return (((Integer) color)).intValue();
      } else {
        return Color.parseColor(((String) color));
      }
    }
  }
  
  public static ColorDrawable asColorDrawable(final Object color) {
    int _asColor = Style.asColor(color);
    return new ColorDrawable(_asColor);
  }
  
  @Pure
  public Object getBackgroundColor() {
    return this.backgroundColor;
  }
  
  public void setBackgroundColor(final Object backgroundColor) {
    this.backgroundColor = backgroundColor;
  }
  
  @Pure
  public Object getBorderColor() {
    return this.borderColor;
  }
  
  public void setBorderColor(final Object borderColor) {
    this.borderColor = borderColor;
  }
  
  @Pure
  public Object getTextColor() {
    return this.textColor;
  }
  
  public void setTextColor(final Object textColor) {
    this.textColor = textColor;
  }
  
  @Pure
  public Integer getBackgroundDrawable() {
    return this.backgroundDrawable;
  }
  
  public void setBackgroundDrawable(final Integer backgroundDrawable) {
    this.backgroundDrawable = backgroundDrawable;
  }
  
  @Pure
  public Integer getCornerRadius() {
    return this.cornerRadius;
  }
  
  public void setCornerRadius(final Integer cornerRadius) {
    this.cornerRadius = cornerRadius;
  }
  
  @Pure
  public Integer getBorderWidth() {
    return this.borderWidth;
  }
  
  public void setBorderWidth(final Integer borderWidth) {
    this.borderWidth = borderWidth;
  }
  
  @Pure
  public Integer getMargin() {
    return this.margin;
  }
  
  public void setMargin(final Integer margin) {
    this.margin = margin;
  }
  
  @Pure
  public Integer getMarginTop() {
    return this.marginTop;
  }
  
  public void setMarginTop(final Integer marginTop) {
    this.marginTop = marginTop;
  }
  
  @Pure
  public Integer getMarginBottom() {
    return this.marginBottom;
  }
  
  public void setMarginBottom(final Integer marginBottom) {
    this.marginBottom = marginBottom;
  }
  
  @Pure
  public Integer getMarginLeft() {
    return this.marginLeft;
  }
  
  public void setMarginLeft(final Integer marginLeft) {
    this.marginLeft = marginLeft;
  }
  
  @Pure
  public Integer getMarginRight() {
    return this.marginRight;
  }
  
  public void setMarginRight(final Integer marginRight) {
    this.marginRight = marginRight;
  }
  
  @Pure
  public Integer getElevation() {
    return this.elevation;
  }
  
  public void setElevation(final Integer elevation) {
    this.elevation = elevation;
  }
  
  @Pure
  public Integer getTranslationY() {
    return this.translationY;
  }
  
  public void setTranslationY(final Integer translationY) {
    this.translationY = translationY;
  }
  
  @Pure
  public Integer getTranslationX() {
    return this.translationX;
  }
  
  public void setTranslationX(final Integer translationX) {
    this.translationX = translationX;
  }
}
