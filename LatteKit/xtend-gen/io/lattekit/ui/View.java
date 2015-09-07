package io.lattekit.ui;

import android.R;
import android.animation.AnimatorSet;
import android.animation.StateListAnimator;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.common.base.Objects;
import io.lattekit.ui.Style;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public abstract class View {
  public final int MATCH_PARENT = ViewGroup.LayoutParams.MATCH_PARENT;
  
  public final int WRAP_CONTENT = ViewGroup.LayoutParams.WRAP_CONTENT;
  
  public final int match_parent = ViewGroup.LayoutParams.MATCH_PARENT;
  
  public final int wrap_content = ViewGroup.LayoutParams.WRAP_CONTENT;
  
  /**
   * Base Attributes
   */
  @Accessors
  public String id;
  
  @Accessors
  public Procedure1<? super View> onTap;
  
  @Accessors
  public int width = this.WRAP_CONTENT;
  
  @Accessors
  public int height = this.WRAP_CONTENT;
  
  @Accessors
  public Style style = ObjectExtensions.<Style>operator_doubleArrow(new Style(), new Procedure1<Style>() {
    @Override
    public void apply(final Style it) {
      it.backgroundColor = Integer.valueOf(Color.WHITE);
    }
  });
  
  @Accessors
  public Style touchedStyle;
  
  @Accessors
  public Style disabledStyle;
  
  @Accessors
  public boolean enabled = true;
  
  public Map<String, Object> attributes = CollectionLiterals.<String, Object>newHashMap();
  
  @Accessors
  public View parentView;
  
  @Accessors
  public List<View> children = CollectionLiterals.<View>newArrayList();
  
  @Accessors
  private List<View> subviews = CollectionLiterals.<View>newArrayList();
  
  private List<View> _children = CollectionLiterals.<View>newArrayList();
  
  private Activity activity;
  
  @Accessors
  private android.view.View androidView;
  
  private View latteView;
  
  protected Procedure1<? super View> attributesProc;
  
  protected Procedure1<? super View> layoutProc;
  
  private boolean isRendering = false;
  
  public Style getActiveStyle() {
    boolean _and = false;
    if (!(!this.enabled)) {
      _and = false;
    } else {
      boolean _notEquals = (!Objects.equal(this.disabledStyle, null));
      _and = _notEquals;
    }
    if (_and) {
      return this.disabledStyle.inheritsFrom(this.style);
    } else {
      boolean _and_1 = false;
      boolean _and_2 = false;
      boolean _notEquals_1 = (!Objects.equal(this.androidView, null));
      if (!_notEquals_1) {
        _and_2 = false;
      } else {
        boolean _isPressed = this.androidView.isPressed();
        _and_2 = _isPressed;
      }
      if (!_and_2) {
        _and_1 = false;
      } else {
        boolean _notEquals_2 = (!Objects.equal(this.touchedStyle, null));
        _and_1 = _notEquals_2;
      }
      if (_and_1) {
        return this.touchedStyle.inheritsFrom(this.style);
      }
    }
    return this.style;
  }
  
  public void applyAttributes() {
    boolean _notEquals = (!Objects.equal(this.androidView, null));
    if (_notEquals) {
      this.androidView.setEnabled(this.enabled);
      this.updateBackgroundDrawable();
      this.updateTextColorDrawable();
      this.updateStateListAnimator();
      Style _activeStyle = this.getActiveStyle();
      _activeStyle.applyStyle(this.androidView);
      boolean _notEquals_1 = (!Objects.equal(this.onTap, null));
      if (_notEquals_1) {
        final android.view.View.OnClickListener _function = new android.view.View.OnClickListener() {
          @Override
          public void onClick(final android.view.View it) {
            View.this.onTap.apply(View.this);
          }
        };
        this.androidView.setOnClickListener(_function);
      }
    }
  }
  
  public void updateStateListAnimator() {
    if ((Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP)) {
      return;
    }
    StateListAnimator stateAnimator = new StateListAnimator();
    boolean _notEquals = (!Objects.equal(this.touchedStyle, null));
    if (_notEquals) {
      Style _inheritsFrom = this.touchedStyle.inheritsFrom(this.style);
      AnimatorSet _createAnimatorFrom = _inheritsFrom.createAnimatorFrom(this.style, this.androidView);
      stateAnimator.addState(new int[] { R.attr.state_enabled, R.attr.state_pressed }, _createAnimatorFrom);
      Style _inheritsFrom_1 = this.touchedStyle.inheritsFrom(this.style);
      AnimatorSet _createAnimatorFrom_1 = this.style.createAnimatorFrom(_inheritsFrom_1, this.androidView);
      stateAnimator.addState(new int[] { R.attr.state_enabled, (-R.attr.state_pressed) }, _createAnimatorFrom_1);
    }
    this.androidView.setStateListAnimator(stateAnimator);
  }
  
  public void updateBackgroundDrawable() {
    List<List<Integer>> colorStates = CollectionLiterals.<List<Integer>>newArrayList();
    final List<Integer> colorList = CollectionLiterals.<Integer>newArrayList();
    boolean _notEquals = (!Objects.equal(this.touchedStyle, null));
    if (_notEquals) {
      colorStates.add(Collections.<Integer>unmodifiableList(CollectionLiterals.<Integer>newArrayList(Integer.valueOf(R.attr.state_enabled), Integer.valueOf(R.attr.state_pressed))));
      Style _inheritsFrom = this.touchedStyle.inheritsFrom(this.style);
      int _asColor = Style.asColor(_inheritsFrom.backgroundColor);
      colorList.add(Integer.valueOf(_asColor));
    }
    colorStates.add(Collections.<Integer>unmodifiableList(CollectionLiterals.<Integer>newArrayList(Integer.valueOf(R.attr.state_enabled), Integer.valueOf((-R.attr.state_pressed)))));
    int _asColor_1 = Style.asColor(this.style.backgroundColor);
    colorList.add(Integer.valueOf(_asColor_1));
    boolean _notEquals_1 = (!Objects.equal(this.disabledStyle, null));
    if (_notEquals_1) {
      colorStates.add(Collections.<Integer>unmodifiableList(CollectionLiterals.<Integer>newArrayList(Integer.valueOf((-R.attr.state_enabled)))));
      Style _inheritsFrom_1 = this.disabledStyle.inheritsFrom(this.style);
      int _asColor_2 = Style.asColor(_inheritsFrom_1.backgroundColor);
      colorList.add(Integer.valueOf(_asColor_2));
    }
    if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)) {
      final StateListDrawable sld = new StateListDrawable();
      boolean _notEquals_2 = (!Objects.equal(this.disabledStyle, null));
      if (_notEquals_2) {
        Style _inheritsFrom_2 = this.disabledStyle.inheritsFrom(this.style);
        Drawable _drawable = _inheritsFrom_2.getDrawable();
        sld.addState(new int[] { (-R.attr.state_enabled) }, _drawable);
      }
      Drawable _drawable_1 = this.style.getDrawable();
      sld.addState(new int[] {}, _drawable_1);
      int[][] _unwrap = io.lattekit.xtend.ArrayLiterals2.unwrap(colorStates);
      ColorStateList _colorStateList = new ColorStateList(_unwrap, ((int[])Conversions.unwrapArray(colorList, int.class)));
      ShapeDrawable _shapeDrawable = this.style.getShapeDrawable();
      RippleDrawable _rippleDrawable = new RippleDrawable(_colorStateList, sld, _shapeDrawable);
      this.androidView.setBackground(_rippleDrawable);
    } else {
      StateListDrawable sld_1 = new StateListDrawable();
      boolean _notEquals_3 = (!Objects.equal(this.touchedStyle, null));
      if (_notEquals_3) {
        Style _inheritsFrom_3 = this.touchedStyle.inheritsFrom(this.style);
        Drawable _drawable_2 = _inheritsFrom_3.getDrawable();
        sld_1.addState(new int[] { R.attr.state_enabled, R.attr.state_pressed }, _drawable_2);
      }
      Drawable _drawable_3 = this.style.getDrawable();
      sld_1.addState(new int[] { R.attr.state_enabled, (-R.attr.state_pressed) }, _drawable_3);
      boolean _notEquals_4 = (!Objects.equal(this.disabledStyle, null));
      if (_notEquals_4) {
        Style _inheritsFrom_4 = this.disabledStyle.inheritsFrom(this.style);
        Drawable _drawable_4 = _inheritsFrom_4.getDrawable();
        sld_1.addState(new int[] { (-R.attr.state_enabled) }, _drawable_4);
      }
      this.androidView.setBackground(sld_1);
    }
  }
  
  public void updateTextColorDrawable() {
    List<List<Integer>> colorStates = CollectionLiterals.<List<Integer>>newArrayList();
    List<Integer> colorList = CollectionLiterals.<Integer>newArrayList();
    boolean _notEquals = (!Objects.equal(this.touchedStyle, null));
    if (_notEquals) {
      colorStates.add(Collections.<Integer>unmodifiableList(CollectionLiterals.<Integer>newArrayList(Integer.valueOf(R.attr.state_enabled), Integer.valueOf(R.attr.state_pressed))));
      Style _inheritsFrom = this.touchedStyle.inheritsFrom(this.style);
      int _asColor = Style.asColor(_inheritsFrom.textColor);
      colorList.add(Integer.valueOf(_asColor));
    }
    colorStates.add(Collections.<Integer>unmodifiableList(CollectionLiterals.<Integer>newArrayList(Integer.valueOf(R.attr.state_enabled), Integer.valueOf((-R.attr.state_pressed)))));
    int _asColor_1 = Style.asColor(this.style.textColor);
    colorList.add(Integer.valueOf(_asColor_1));
    boolean _notEquals_1 = (!Objects.equal(this.disabledStyle, null));
    if (_notEquals_1) {
      colorStates.add(Collections.<Integer>unmodifiableList(CollectionLiterals.<Integer>newArrayList(Integer.valueOf((-R.attr.state_enabled)))));
      Style _inheritsFrom_1 = this.disabledStyle.inheritsFrom(this.style);
      int _asColor_2 = Style.asColor(_inheritsFrom_1.textColor);
      colorList.add(Integer.valueOf(_asColor_2));
    }
    if ((this.androidView instanceof TextView)) {
      int _size = colorStates.size();
      final int[][] colorStatesArray = new int[_size][];
      int i = 0;
      for (final List<Integer> state : colorStates) {
        {
          colorStatesArray[i] = ((int[]) ((int[])Conversions.unwrapArray(state, int.class)));
          i++;
        }
      }
      final List<Integer> _converted_colorList = (List<Integer>)colorList;
      ColorStateList _colorStateList = new ColorStateList(colorStatesArray, ((int[])Conversions.unwrapArray(_converted_colorList, int.class)));
      ((TextView)this.androidView).setTextColor(_colorStateList);
    }
  }
  
  public android.view.View createAndroidView(final Activity a) {
    return null;
  }
  
  public void onChildrenAdded() {
  }
  
  public <T extends View> void processNode(final View parent, final String id, final Procedure1<? super T> attrs, final Procedure1<? super T> children) {
    this.isRendering = true;
    this.parentView = ((View) parent);
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(parent, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _notEquals_1 = (!Objects.equal(parent._children, null));
      _and = _notEquals_1;
    }
    if (_and) {
      parent.children.add(this);
    }
    ArrayList<View> _newArrayList = CollectionLiterals.<View>newArrayList();
    this._children = _newArrayList;
    boolean _notEquals_2 = (!Objects.equal(attrs, null));
    if (_notEquals_2) {
      this.attributesProc = ((Procedure1<? super View>) ((Procedure1<? super View>)attrs));
      attrs.apply(((T) this));
    }
    boolean _notEquals_3 = (!Objects.equal(children, null));
    if (_notEquals_3) {
      this.layoutProc = ((Procedure1<? super View>) ((Procedure1<? super View>)children));
      children.apply(((T) this));
    }
    View oldLatteView = this.latteView;
    View _render = this.render();
    this.latteView = _render;
    boolean _notEquals_4 = (!Objects.equal(this.latteView, null));
    if (_notEquals_4) {
      ArrayList<View> _newArrayList_1 = CollectionLiterals.<View>newArrayList();
      this.subviews = _newArrayList_1;
      this.subviews.add(this.latteView);
      boolean _notEquals_5 = (!Objects.equal(oldLatteView, null));
      if (_notEquals_5) {
        this.compareView(this.latteView, oldLatteView);
      }
    } else {
      ArrayList<View> newSubviews = CollectionLiterals.<View>newArrayList();
      for (int i = 0; (i < this.children.size()); i++) {
        {
          View newChild = this.children.get(i);
          newSubviews.add(newChild);
          int _size = this.subviews.size();
          boolean _lessThan = (i < _size);
          if (_lessThan) {
            View _get = this.subviews.get(i);
            this.compareView(newChild, _get);
          }
        }
      }
      this.subviews = newSubviews;
    }
    this.isRendering = false;
  }
  
  public void setAttribute(final String key, final Object value) {
    this.attributes.put(key, value);
    this.onStateChanged(key);
  }
  
  public void onStateChanged(final String stateName) {
    if ((!this.isRendering)) {
      this.handleStateChanged();
    }
  }
  
  public void handleStateChanged() {
    this.<View>processNode(null, null, null, this.layoutProc);
    android.view.View _rootAndroidView = this.getRootAndroidView();
    ViewGroup.LayoutParams _layoutParams = _rootAndroidView.getLayoutParams();
    this.buildAndroidViewTree(this.activity, _layoutParams);
  }
  
  public void compareView(final View newView, final View oldView) {
    Class<? extends View> _class = newView.getClass();
    Class<? extends View> _class_1 = oldView.getClass();
    boolean _notEquals = (!Objects.equal(_class, _class_1));
    if (_notEquals) {
      return;
    } else {
      boolean _and = false;
      boolean _notEquals_1 = (!Objects.equal(newView.latteView, null));
      if (!_notEquals_1) {
        _and = false;
      } else {
        boolean _notEquals_2 = (!Objects.equal(oldView.latteView, null));
        _and = _notEquals_2;
      }
      if (_and) {
        this.compareView(newView.latteView, oldView.latteView);
        for (int i = 0; (i < this.subviews.size()); i++) {
          {
            View _xifexpression = null;
            int _size = oldView.subviews.size();
            boolean _greaterThan = (_size > i);
            if (_greaterThan) {
              _xifexpression = oldView.subviews.get(i);
            } else {
              _xifexpression = null;
            }
            View oldChildView = _xifexpression;
            boolean _notEquals_3 = (!Objects.equal(oldChildView, null));
            if (_notEquals_3) {
              View _get = this.subviews.get(i);
              this.compareView(_get, oldChildView);
            }
          }
        }
      } else {
        boolean _or = false;
        boolean _and_1 = false;
        boolean _notEquals_3 = (!Objects.equal(newView.latteView, null));
        if (!_notEquals_3) {
          _and_1 = false;
        } else {
          boolean _equals = Objects.equal(oldView.latteView, null);
          _and_1 = _equals;
        }
        if (_and_1) {
          _or = true;
        } else {
          boolean _and_2 = false;
          boolean _equals_1 = Objects.equal(newView.latteView, null);
          if (!_equals_1) {
            _and_2 = false;
          } else {
            boolean _notEquals_4 = (!Objects.equal(oldView.latteView, null));
            _and_2 = _notEquals_4;
          }
          _or = _and_2;
        }
        if (_or) {
        } else {
          boolean _and_3 = false;
          boolean _equals_2 = Objects.equal(newView.androidView, null);
          if (!_equals_2) {
            _and_3 = false;
          } else {
            boolean _notEquals_5 = (!Objects.equal(oldView.androidView, null));
            _and_3 = _notEquals_5;
          }
          if (_and_3) {
            Log.d("Latte", ("Re-using " + oldView.androidView));
            newView.androidView = oldView.androidView;
            for (int i = 0; (i < newView.subviews.size()); i++) {
              {
                View _xifexpression = null;
                int _size = oldView.subviews.size();
                boolean _greaterThan = (_size > i);
                if (_greaterThan) {
                  _xifexpression = oldView.subviews.get(i);
                } else {
                  _xifexpression = null;
                }
                View oldChildView = _xifexpression;
                boolean _notEquals_6 = (!Objects.equal(oldChildView, null));
                if (_notEquals_6) {
                  View _get = newView.subviews.get(i);
                  this.compareView(_get, oldChildView);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public ViewGroup.LayoutParams createLayoutParams(final int width, final int height) {
    return null;
  }
  
  public View render() {
    return null;
  }
  
  public android.view.View getRootAndroidView() {
    boolean _equals = Objects.equal(this.androidView, null);
    if (_equals) {
      return this.latteView.getRootAndroidView();
    }
    return this.androidView;
  }
  
  public android.view.View buildAndroidViewTree(final Activity a, final ViewGroup.LayoutParams lp) {
    this.activity = a;
    android.view.View _xifexpression = null;
    boolean _equals = Objects.equal(this.androidView, null);
    if (_equals) {
      android.view.View _xblockexpression = null;
      {
        android.view.View c = this.createAndroidView(a);
        _xblockexpression = c;
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = this.androidView;
    }
    android.view.View myView = _xifexpression;
    boolean _equals_1 = Objects.equal(myView, null);
    if (_equals_1) {
      return this.latteView.buildAndroidViewTree(a, lp);
    }
    boolean _and = false;
    int _id = this.androidView.getId();
    boolean _equals_2 = (_id == (-1));
    if (!_equals_2) {
      _and = false;
    } else {
      boolean _notEquals = (!Objects.equal(this.id, null));
      _and = _notEquals;
    }
    if (_and) {
      int _hashCode = this.id.hashCode();
      this.androidView.setId(_hashCode);
    }
    boolean _and_1 = false;
    boolean _notEquals_1 = (!Objects.equal(this.androidView, null));
    if (!_notEquals_1) {
      _and_1 = false;
    } else {
      boolean _notEquals_2 = (!Objects.equal(lp, null));
      _and_1 = _notEquals_2;
    }
    if (_and_1) {
      this.androidView.setLayoutParams(lp);
    }
    this.applyAttributes();
    int _size = this.subviews.size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      ViewGroup myContainer = ((ViewGroup) myView);
      myContainer.removeAllViews();
      for (final View v : this.subviews) {
        {
          ViewGroup.LayoutParams childLP = this.createLayoutParams(v.width, v.height);
          android.view.View childView = v.buildAndroidViewTree(a, childLP);
          myContainer.addView(childView, childLP);
        }
      }
      this.onChildrenAdded();
    }
    return myView;
  }
  
  public void renderOn(final Activity a) {
    this.activity = a;
    View _render = this.render();
    this.latteView = _render;
    boolean _notEquals = (!Objects.equal(this.latteView, null));
    if (_notEquals) {
      this.latteView.<View>processNode(this, null, null, null);
      android.view.View nativeView = this.buildAndroidViewTree(a, null);
      a.setContentView(nativeView);
    }
  }
  
  @Pure
  public String getId() {
    return this.id;
  }
  
  public void setId(final String id) {
    this.id = id;
  }
  
  @Pure
  public Procedure1<? super View> getOnTap() {
    return this.onTap;
  }
  
  public void setOnTap(final Procedure1<? super View> onTap) {
    this.onTap = onTap;
  }
  
  @Pure
  public int getWidth() {
    return this.width;
  }
  
  public void setWidth(final int width) {
    this.width = width;
  }
  
  @Pure
  public int getHeight() {
    return this.height;
  }
  
  public void setHeight(final int height) {
    this.height = height;
  }
  
  @Pure
  public Style getStyle() {
    return this.style;
  }
  
  public void setStyle(final Style style) {
    this.style = style;
  }
  
  @Pure
  public Style getTouchedStyle() {
    return this.touchedStyle;
  }
  
  public void setTouchedStyle(final Style touchedStyle) {
    this.touchedStyle = touchedStyle;
  }
  
  @Pure
  public Style getDisabledStyle() {
    return this.disabledStyle;
  }
  
  public void setDisabledStyle(final Style disabledStyle) {
    this.disabledStyle = disabledStyle;
  }
  
  @Pure
  public boolean isEnabled() {
    return this.enabled;
  }
  
  public void setEnabled(final boolean enabled) {
    this.enabled = enabled;
  }
  
  @Pure
  public View getParentView() {
    return this.parentView;
  }
  
  public void setParentView(final View parentView) {
    this.parentView = parentView;
  }
  
  @Pure
  public List<View> getChildren() {
    return this.children;
  }
  
  public void setChildren(final List<View> children) {
    this.children = children;
  }
  
  @Pure
  public List<View> getSubviews() {
    return this.subviews;
  }
  
  public void setSubviews(final List<View> subviews) {
    this.subviews = subviews;
  }
  
  @Pure
  public android.view.View getAndroidView() {
    return this.androidView;
  }
  
  public void setAndroidView(final android.view.View androidView) {
    this.androidView = androidView;
  }
}
