package io.lattekit.ui;

import android.app.Activity;
import com.google.common.base.Objects;
import io.lattekit.LatteView;
import io.lattekit.State;
import io.lattekit.ui.View;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@LatteView
@SuppressWarnings("all")
public class Button extends View {
  @State
  @SuppressWarnings(value = "all")
  private String _label;
  
  public void init() {
  }
  
  @Override
  public void applyAttributes() {
    super.applyAttributes();
    android.view.View _androidView = this.getAndroidView();
    android.widget.Button myButton = ((android.widget.Button) _androidView);
    String _label = this.getLabel();
    myButton.setText(_label);
  }
  
  @Override
  public android.view.View createAndroidView(final Activity a) {
    android.view.View _androidView = this.getAndroidView();
    boolean _equals = Objects.equal(_androidView, null);
    if (_equals) {
      android.widget.Button _button = new android.widget.Button(a);
      this.setAndroidView(_button);
      this.applyAttributes();
    }
    return this.getAndroidView();
  }
  
  private String viewVariant;
  
  public static Button Button(final View parentView, final String id, final Procedure1<Button> attrs, final Procedure1<Button> children) {
    Button me = new Button();
    me.processNode(parentView,id,attrs,children);
    me.viewVariant = "Button";
    return me;
  }
  
  public static Button Button(final View parentView, final Procedure1<Button> attrs, final Procedure1<Button> children) {
    Button me = new Button();
    me.processNode(parentView,null,attrs,children);
    me.viewVariant = "Button";
    return me;
  }
  
  public static Button Button(final View parentView, final String id, final Procedure1<Button> attrs) {
    Button me = new Button();
    me.processNode(parentView,id,attrs,null);
    me.viewVariant = "Button";
    return me;
  }
  
  public static Button Button(final View parentView, final Procedure1<Button> attrs) {
    Button me = new Button();
    me.processNode(parentView,null,attrs,null);
    me.viewVariant = "Button";
    return me;
  }
  
  public static Button Button(final View parentView, final String id) {
    Button me = new Button();;
    me.processNode(parentView,id,null,null);
    me.viewVariant = "Button";
    return me;
  }
  
  public static Button Button(final View parentView) {
    Button me = new Button();
    me.processNode(parentView,null,null,null);
    me.viewVariant = "Button";
    return me;
  }
  
  public String getLabel() {
    return _label;
  }
  
  public void setLabel(final String newValue) {
    _label = newValue;
    onStateChanged("label");
  }
}
