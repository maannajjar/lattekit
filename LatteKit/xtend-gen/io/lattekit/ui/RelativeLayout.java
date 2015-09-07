package io.lattekit.ui;

import android.app.Activity;
import android.util.Log;
import android.view.ViewGroup;
import com.google.common.base.Objects;
import io.lattekit.LatteView;
import io.lattekit.ui.View;
import java.util.HashMap;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

@LatteView
@SuppressWarnings("all")
public class RelativeLayout extends View {
  public void init() {
  }
  
  @Override
  public void applyAttributes() {
    super.applyAttributes();
    android.view.View _androidView = this.getAndroidView();
    android.widget.RelativeLayout view = ((android.widget.RelativeLayout) _androidView);
  }
  
  @Override
  public android.view.View createAndroidView(final Activity a) {
    android.view.View _androidView = this.getAndroidView();
    boolean _equals = Objects.equal(_androidView, null);
    if (_equals) {
      android.widget.RelativeLayout _relativeLayout = new android.widget.RelativeLayout(a);
      this.setAndroidView(_relativeLayout);
      this.applyAttributes();
    }
    return this.getAndroidView();
  }
  
  @Override
  public android.widget.RelativeLayout.LayoutParams createLayoutParams(final int width, final int height) {
    android.widget.RelativeLayout.LayoutParams lp = new android.widget.RelativeLayout.LayoutParams(width, height);
    return lp;
  }
  
  @Override
  public void onChildrenAdded() {
    super.onChildrenAdded();
    final HashMap<String, Integer> viewMap = CollectionLiterals.<String, Integer>newHashMap();
    List<View> _subviews = this.getSubviews();
    final Procedure1<View> _function = new Procedure1<View>() {
      @Override
      public void apply(final View it) {
        boolean _and = false;
        android.view.View _rootAndroidView = it.getRootAndroidView();
        int _id = _rootAndroidView.getId();
        boolean _equals = (_id == (-1));
        if (!_equals) {
          _and = false;
        } else {
          boolean _notEquals = (!Objects.equal(it.id, null));
          _and = _notEquals;
        }
        if (_and) {
          android.view.View _rootAndroidView_1 = it.getRootAndroidView();
          int _hashCode = it.id.hashCode();
          _rootAndroidView_1.setId(_hashCode);
        }
        boolean _notEquals_1 = (!Objects.equal(it.id, null));
        if (_notEquals_1) {
          android.view.View _rootAndroidView_2 = it.getRootAndroidView();
          int _id_1 = _rootAndroidView_2.getId();
          viewMap.put(it.id, Integer.valueOf(_id_1));
        }
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("My Id = ");
        android.view.View _rootAndroidView_3 = it.getRootAndroidView();
        int _id_2 = _rootAndroidView_3.getId();
        _builder.append(_id_2, "");
        Log.d("Latte", _builder.toString());
      }
    };
    IterableExtensions.<View>forEach(_subviews, _function);
    List<View> _subviews_1 = this.getSubviews();
    final Procedure1<View> _function_1 = new Procedure1<View>() {
      @Override
      public void apply(final View it) {
        RelativeLayout.this.addLayoutRules(it, viewMap);
      }
    };
    IterableExtensions.<View>forEach(_subviews_1, _function_1);
  }
  
  public void addLayoutRules(final View virtualView, final HashMap<String, Integer> viewIds) {
    android.view.View rootAndroidView = virtualView.getRootAndroidView();
    ViewGroup.LayoutParams _layoutParams = rootAndroidView.getLayoutParams();
    android.widget.RelativeLayout.LayoutParams oldParams = ((android.widget.RelativeLayout.LayoutParams) _layoutParams);
    final android.widget.RelativeLayout.LayoutParams newParams = new android.widget.RelativeLayout.LayoutParams(oldParams);
    final Procedure2<String, Object> _function = new Procedure2<String, Object>() {
      @Override
      public void apply(final String key, final Object value) {
        boolean _equals = Objects.equal(key, "below");
        if (_equals) {
          Integer _get = viewIds.get(value);
          newParams.addRule(android.widget.RelativeLayout.BELOW, (_get).intValue());
        } else {
          boolean _equals_1 = Objects.equal(key, "above");
          if (_equals_1) {
            Integer _get_1 = viewIds.get(value);
            newParams.addRule(android.widget.RelativeLayout.ABOVE, (_get_1).intValue());
          } else {
            boolean _equals_2 = Objects.equal(key, "toStartOf");
            if (_equals_2) {
              Integer _get_2 = viewIds.get(value);
              newParams.addRule(android.widget.RelativeLayout.START_OF, (_get_2).intValue());
            } else {
              boolean _equals_3 = Objects.equal(key, "toEndOf");
              if (_equals_3) {
                Integer _get_3 = viewIds.get(value);
                newParams.addRule(android.widget.RelativeLayout.END_OF, (_get_3).intValue());
              } else {
                boolean _equals_4 = Objects.equal(key, "alignStart");
                if (_equals_4) {
                  Integer _get_4 = viewIds.get(value);
                  newParams.addRule(android.widget.RelativeLayout.ALIGN_START, (_get_4).intValue());
                } else {
                  boolean _equals_5 = Objects.equal(key, "alignEnd");
                  if (_equals_5) {
                    Integer _get_5 = viewIds.get(value);
                    newParams.addRule(android.widget.RelativeLayout.ALIGN_END, (_get_5).intValue());
                  } else {
                    boolean _equals_6 = Objects.equal(key, "alignTop");
                    if (_equals_6) {
                      Integer _get_6 = viewIds.get(value);
                      newParams.addRule(android.widget.RelativeLayout.ALIGN_TOP, (_get_6).intValue());
                    } else {
                      boolean _equals_7 = Objects.equal(key, "alignBottom");
                      if (_equals_7) {
                        Integer _get_7 = viewIds.get(value);
                        newParams.addRule(android.widget.RelativeLayout.ALIGN_BOTTOM, (_get_7).intValue());
                      } else {
                        boolean _and = false;
                        boolean _equals_8 = Objects.equal(key, "alignParentStart");
                        if (!_equals_8) {
                          _and = false;
                        } else {
                          boolean _equals_9 = Objects.equal(value, Boolean.valueOf(true));
                          _and = _equals_9;
                        }
                        if (_and) {
                          newParams.addRule(android.widget.RelativeLayout.ALIGN_PARENT_START);
                        } else {
                          boolean _and_1 = false;
                          boolean _equals_10 = Objects.equal(key, "alignParentEnd");
                          if (!_equals_10) {
                            _and_1 = false;
                          } else {
                            boolean _equals_11 = Objects.equal(value, Boolean.valueOf(true));
                            _and_1 = _equals_11;
                          }
                          if (_and_1) {
                            newParams.addRule(android.widget.RelativeLayout.ALIGN_PARENT_END);
                          } else {
                            boolean _and_2 = false;
                            boolean _equals_12 = Objects.equal(key, "alignParentTop");
                            if (!_equals_12) {
                              _and_2 = false;
                            } else {
                              boolean _equals_13 = Objects.equal(value, Boolean.valueOf(true));
                              _and_2 = _equals_13;
                            }
                            if (_and_2) {
                              newParams.addRule(android.widget.RelativeLayout.ALIGN_PARENT_TOP);
                            } else {
                              boolean _and_3 = false;
                              boolean _equals_14 = Objects.equal(key, "alignParentBottom");
                              if (!_equals_14) {
                                _and_3 = false;
                              } else {
                                boolean _equals_15 = Objects.equal(value, Boolean.valueOf(true));
                                _and_3 = _equals_15;
                              }
                              if (_and_3) {
                                newParams.addRule(android.widget.RelativeLayout.ALIGN_PARENT_BOTTOM);
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    };
    MapExtensions.<String, Object>forEach(virtualView.attributes, _function);
    rootAndroidView.setLayoutParams(newParams);
  }
  
  private String viewVariant;
  
  public static RelativeLayout RelativeLayout(final View parentView, final String id, final Procedure1<RelativeLayout> attrs, final Procedure1<RelativeLayout> children) {
    RelativeLayout me = new RelativeLayout();
    me.processNode(parentView,id,attrs,children);
    me.viewVariant = "RelativeLayout";
    return me;
  }
  
  public static RelativeLayout RelativeLayout(final View parentView, final Procedure1<RelativeLayout> attrs, final Procedure1<RelativeLayout> children) {
    RelativeLayout me = new RelativeLayout();
    me.processNode(parentView,null,attrs,children);
    me.viewVariant = "RelativeLayout";
    return me;
  }
  
  public static RelativeLayout RelativeLayout(final View parentView, final String id, final Procedure1<RelativeLayout> attrs) {
    RelativeLayout me = new RelativeLayout();
    me.processNode(parentView,id,attrs,null);
    me.viewVariant = "RelativeLayout";
    return me;
  }
  
  public static RelativeLayout RelativeLayout(final View parentView, final Procedure1<RelativeLayout> attrs) {
    RelativeLayout me = new RelativeLayout();
    me.processNode(parentView,null,attrs,null);
    me.viewVariant = "RelativeLayout";
    return me;
  }
  
  public static RelativeLayout RelativeLayout(final View parentView, final String id) {
    RelativeLayout me = new RelativeLayout();;
    me.processNode(parentView,id,null,null);
    me.viewVariant = "RelativeLayout";
    return me;
  }
  
  public static RelativeLayout RelativeLayout(final View parentView) {
    RelativeLayout me = new RelativeLayout();
    me.processNode(parentView,null,null,null);
    me.viewVariant = "RelativeLayout";
    return me;
  }
}
