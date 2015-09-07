package io.lattekit.ui;

import android.app.Activity;
import com.google.common.base.Objects;
import io.lattekit.LatteView;
import io.lattekit.State;
import io.lattekit.ui.View;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@LatteView
@SuppressWarnings("all")
public class LinearLayout extends View {
  @State
  @SuppressWarnings(value = "all")
  private String _orientation;
  
  public void init() {
  }
  
  @Override
  public void applyAttributes() {
    super.applyAttributes();
    android.view.View _androidView = this.getAndroidView();
    android.widget.LinearLayout view = ((android.widget.LinearLayout) _androidView);
    String _orientation = this.getOrientation();
    boolean _equals = Objects.equal(_orientation, "horizontal");
    if (_equals) {
      view.setOrientation(android.widget.LinearLayout.HORIZONTAL);
    } else {
      view.setOrientation(android.widget.LinearLayout.VERTICAL);
    }
  }
  
  @Override
  public android.view.View createAndroidView(final Activity a) {
    android.view.View _androidView = this.getAndroidView();
    boolean _equals = Objects.equal(_androidView, null);
    if (_equals) {
      android.widget.LinearLayout _linearLayout = new android.widget.LinearLayout(a);
      this.setAndroidView(_linearLayout);
      this.applyAttributes();
    }
    return this.getAndroidView();
  }
  
  @Override
  public android.widget.LinearLayout.LayoutParams createLayoutParams(final int width, final int height) {
    android.widget.LinearLayout.LayoutParams lp = new android.widget.LinearLayout.LayoutParams(width, height);
    return lp;
  }
  
  private String viewVariant;
  
  public static LinearLayout LinearLayout(final View parentView, final String id, final Procedure1<LinearLayout> attrs, final Procedure1<LinearLayout> children) {
    LinearLayout me = new LinearLayout();
    me.processNode(parentView,id,attrs,children);
    me.viewVariant = "LinearLayout";
    return me;
  }
  
  public static LinearLayout LinearLayout(final View parentView, final Procedure1<LinearLayout> attrs, final Procedure1<LinearLayout> children) {
    LinearLayout me = new LinearLayout();
    me.processNode(parentView,null,attrs,children);
    me.viewVariant = "LinearLayout";
    return me;
  }
  
  public static LinearLayout LinearLayout(final View parentView, final String id, final Procedure1<LinearLayout> attrs) {
    LinearLayout me = new LinearLayout();
    me.processNode(parentView,id,attrs,null);
    me.viewVariant = "LinearLayout";
    return me;
  }
  
  public static LinearLayout LinearLayout(final View parentView, final Procedure1<LinearLayout> attrs) {
    LinearLayout me = new LinearLayout();
    me.processNode(parentView,null,attrs,null);
    me.viewVariant = "LinearLayout";
    return me;
  }
  
  public static LinearLayout LinearLayout(final View parentView, final String id) {
    LinearLayout me = new LinearLayout();;
    me.processNode(parentView,id,null,null);
    me.viewVariant = "LinearLayout";
    return me;
  }
  
  public static LinearLayout LinearLayout(final View parentView) {
    LinearLayout me = new LinearLayout();
    me.processNode(parentView,null,null,null);
    me.viewVariant = "LinearLayout";
    return me;
  }
  
  public String getOrientation() {
    return _orientation;
  }
  
  public void setOrientation(final String newValue) {
    _orientation = newValue;
    onStateChanged("orientation");
  }
}
