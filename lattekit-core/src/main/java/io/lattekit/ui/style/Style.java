package io.lattekit.ui.style;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.common.base.Objects;
import io.lattekit.annotations.StyleProperty;
import io.lattekit.ui.drawable.BorderDrawable;
import io.lattekit.ui.style.NumberValue;
import io.lattekit.ui.view.NativeView;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class Style {
    public final static int MATCH_PARENT = ViewGroup.LayoutParams.MATCH_PARENT;

    public final static int WRAP_CONTENT = ViewGroup.LayoutParams.WRAP_CONTENT;

    public final static int match_parent = ViewGroup.LayoutParams.MATCH_PARENT;

    public final static int wrap_content = ViewGroup.LayoutParams.WRAP_CONTENT;

    @Accessors
    private String definedSelector;

    @Accessors
    private Map<String, Style> descendantStyles = CollectionLiterals.<String, Style>newHashMap();

    @Accessors
    private Map<String, Style> directChildrenStyles = CollectionLiterals.<String, Style>newHashMap();

    @Accessors
    private Map<String, Style> siblingStyles = CollectionLiterals.<String, Style>newHashMap();

    @Accessors
    private Style parentStyle;

    @StyleProperty
    @SuppressWarnings(value = "all")
    public Object _backgroundColor = null;;

    @StyleProperty
    @SuppressWarnings(value = "all")
    public Object _rippleColor = null;;

    @StyleProperty
    @SuppressWarnings(value = "all")
    public Object _textColor = null;;

    @StyleProperty(animatable = false)
    @SuppressWarnings(value = "all")
    public String _backgroundDrawable = null;;

    @StyleProperty(animatable = false)
    @SuppressWarnings(value = "all")
    public String _backgroundRepeat = null;;

    @StyleProperty(animatable = false)
    @SuppressWarnings(value = "all")
    public String _backgroundGravity = null;;

    @StyleProperty(shorthands = { "background-filter" })
    @SuppressWarnings(value = "all")
    public Object _backgroundFilterColor = null;;

    @StyleProperty(shorthands = { "background-filter" }, animatable = false)
    @SuppressWarnings(value = "all")
    public String _backgroundFilterType = null;;

    @StyleProperty(shorthands = { "border", "border-left" })
    @SuppressWarnings(value = "all")
    public Object _borderLeftColor = null;;

    @StyleProperty(shorthands = { "border", "border-top" })
    @SuppressWarnings(value = "all")
    public Object _borderTopColor = null;;

    @StyleProperty(shorthands = { "border", "border-right" })
    @SuppressWarnings(value = "all")
    public Object _borderRightColor = null;;

    @StyleProperty(shorthands = { "border", "border-bottom" })
    @SuppressWarnings(value = "all")
    public Object _borderBottomColor = null;;

    @StyleProperty(shorthands = { "border-radius", "border-top-left-radius" })
    @SuppressWarnings(value = "all")
    public NumberValue _borderTopLeftRadiusH = null;;

    @StyleProperty(shorthands = { "border-radius", "border-top-right-radius" })
    @SuppressWarnings(value = "all")
    public NumberValue _borderTopRightRadiusH = null;;

    @StyleProperty(shorthands = { "border-radius", "border-bottom-left-radius" })
    @SuppressWarnings(value = "all")
    public NumberValue _borderBottomLeftRadiusH = null;;

    @StyleProperty(shorthands = { "border-radius", "border-bottom-right-radius" })
    @SuppressWarnings(value = "all")
    public NumberValue _borderBottomRightRadiusH = null;;

    @StyleProperty(shorthands = { "border-radius", "border-top-left-radius" })
    @SuppressWarnings(value = "all")
    public NumberValue _borderTopLeftRadiusV = null;;

    @StyleProperty(shorthands = { "border-radius", "border-top-right-radius" })
    @SuppressWarnings(value = "all")
    public NumberValue _borderTopRightRadiusV = null;;

    @StyleProperty(shorthands = { "border-radius", "border-bottom-left-radius" })
    @SuppressWarnings(value = "all")
    public NumberValue _borderBottomLeftRadiusV = null;;

    @StyleProperty(shorthands = { "border-radius", "border-bottom-right-radius" })
    @SuppressWarnings(value = "all")
    public NumberValue _borderBottomRightRadiusV = null;;

    @StyleProperty(shorthands = { "border", "border-width", "border-left" })
    @SuppressWarnings(value = "all")
    public NumberValue _borderLeftWidth = null;;

    @StyleProperty(shorthands = { "border", "border-width", "border-top" })
    @SuppressWarnings(value = "all")
    public NumberValue _borderTopWidth = null;;

    @StyleProperty(shorthands = { "border", "border-width", "border-right" })
    @SuppressWarnings(value = "all")
    public NumberValue _borderRightWidth = null;;

    @StyleProperty(shorthands = { "border", "border-width", "border-bottom" })
    @SuppressWarnings(value = "all")
    public NumberValue _borderBottomWidth = null;;

    @StyleProperty(shorthands = { "margin" })
    @SuppressWarnings(value = "all")
    public NumberValue _marginTop = null;;

    @StyleProperty(shorthands = { "margin" })
    @SuppressWarnings(value = "all")
    public NumberValue _marginBottom = null;;

    @StyleProperty(shorthands = { "margin" })
    @SuppressWarnings(value = "all")
    public NumberValue _marginLeft = null;;

    @StyleProperty(shorthands = { "margin" })
    @SuppressWarnings(value = "all")
    public NumberValue _marginRight = null;;

    @StyleProperty
    @SuppressWarnings(value = "all")
    public NumberValue _elevation = null;;

    @StyleProperty
    @SuppressWarnings(value = "all")
    public NumberValue _translationY = null;;

    @StyleProperty
    @SuppressWarnings(value = "all")
    public NumberValue _translationX = null;;

    @StyleProperty
    @SuppressWarnings(value = "all")
    public NumberValue _x = null;;

    @StyleProperty
    @SuppressWarnings(value = "all")
    public NumberValue _y = null;;

    @StyleProperty(shorthands = { "padding" })
    @SuppressWarnings(value = "all")
    public NumberValue _paddingTop = null;;

    @StyleProperty(shorthands = { "padding" })
    @SuppressWarnings(value = "all")
    public NumberValue _paddingBottom = null;;

    @StyleProperty(shorthands = { "padding" })
    @SuppressWarnings(value = "all")
    public NumberValue _paddingLeft = null;;

    @StyleProperty(shorthands = { "padding" })
    @SuppressWarnings(value = "all")
    public NumberValue _paddingRight = null;;

    @StyleProperty(animatable = false)
    @SuppressWarnings(value = "all")
    public String _fontFamily = null;;

    @StyleProperty(animatable = false)
    @SuppressWarnings(value = "all")
    public String _fontStyle = null;;

    @StyleProperty
    @SuppressWarnings(value = "all")
    public NumberValue _fontSize = null;;

    @StyleProperty(animatable = false)
    @SuppressWarnings(value = "all")
    public List<List<Object>> _transition = null;;

    @StyleProperty
    @SuppressWarnings(value = "all")
    public NumberValue _width = null;;

    @StyleProperty
    @SuppressWarnings(value = "all")
    public NumberValue _height = null;;

    public Float _computedX;

    public Float _computedY;

    private static Set<String> DRAWABLE_PROPS = CollectionLiterals.<String>newHashSet("borderColor", "borderTopColor", "borderLeftColor", "borderRightColor", "borderBottomColor", "borderRadius", "borderTopLeftRadiusV", "borderTopRightRadiusV", "borderBottomLeftRadiusV", "borderBottomRightRadiusV", "borderTopLeftRadiusH", "borderTopRightRadiusH", "borderBottomLeftRadiusH", "borderBottomRightRadiusH", "backgroundDrawable", "backgroundFilterColor", "backgroundFilterType", "backgroundFilter", "backgroundRepeat", "backgroundGravity", "backgroundColor", "rippleColor", "borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth");

    private static Map<String, Typeface> allFonts;

    protected GradientDrawable backgroundGradientDrawable;

    protected Drawable backgroundImageDrawable;

    protected BorderDrawable borderDrawable;

    public static void initFonts(final Context context) {
        boolean _equals = Objects.equal(Style.allFonts, null);
        if (_equals) {
            HashMap<String, Typeface> _newHashMap = CollectionLiterals.<String, Typeface>newHashMap();
            Style.allFonts = _newHashMap;
            AssetManager _assets = context.getAssets();
            Style.loadFontsInAssetPath(_assets, "", Style.allFonts);
        }
    }

    public static void loadFontsInAssetPath(final AssetManager assets, final String path, final Map<String, Typeface> fonts) {
        try {
            String[] _list = assets.list(path);
            final Procedure1<String> _function = new Procedure1<String>() {
                @Override
                public void apply(final String it) {
                    try {
                        String _xifexpression = null;
                        boolean _notEquals = (!Objects.equal(path, ""));
                        if (_notEquals) {
                            _xifexpression = (path + "/");
                        } else {
                            _xifexpression = "";
                        }
                        String fullPath = (_xifexpression + it);
                        String[] _list = assets.list(fullPath);
                        int _length = _list.length;
                        boolean _greaterThan = (_length > 0);
                        if (_greaterThan) {
                            Style.loadFontsInAssetPath(assets, fullPath, fonts);
                        } else {
                            boolean _or = false;
                            boolean _endsWith = it.endsWith(".ttf");
                            if (_endsWith) {
                                _or = true;
                            } else {
                                boolean _endsWith_1 = it.endsWith(".otf");
                                _or = _endsWith_1;
                            }
                            if (_or) {
                                try {
                                    Log.d("Latte", ("Loading font " + fullPath));
                                    Typeface font = Typeface.createFromAsset(assets, fullPath);
                                    int _length_1 = it.length();
                                    int _minus = (_length_1 - 4);
                                    String _substring = it.substring(0, _minus);
                                    String _lowerCase = _substring.toLowerCase();
                                    Style.allFonts.put(_lowerCase, font);
                                } catch (final Throwable _t) {
                                    if (_t instanceof Exception) {
                                        final Exception ex = (Exception)_t;
                                        ex.printStackTrace();
                                    } else {
                                        throw Exceptions.sneakyThrow(_t);
                                    }
                                }
                            }
                        }
                    } catch (Throwable _e) {
                        throw Exceptions.sneakyThrow(_e);
                    }
                }
            };
            IterableExtensions.<String>forEach(((Iterable<String>)Conversions.doWrapArray(_list)), _function);
        } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
        }
    }

    public static Style newStyle(final Object... keysAndValues) {
        Style _style = new Style();
        final Procedure1<Style> _function = new Procedure1<Style>() {
            @Override
            public void apply(final Style it) {
                final Procedure2<Object, Integer> _function = new Procedure2<Object, Integer>() {
                    @Override
                    public void apply(final Object v, final Integer index) {
                        if (((index % 2) == 0)) {
                            Object _get = keysAndValues[(index + 1)];
                            it.setProperty(((String) v), _get);
                        }
                    }
                };
                IterableExtensions.<Object>forEach(((Iterable<Object>)Conversions.doWrapArray(keysAndValues)), _function);
            }
        };
        Style style = ObjectExtensions.<Style>operator_doubleArrow(_style, _function);
        return style;
    }

    public AnimatorSet createAnimatorFrom(final Style startStyle, final NativeView latteView, final boolean revertToNormal) {
        final AnimatorSet animSet = new AnimatorSet();
        final Set<String> transitionProperties = CollectionLiterals.<String>newHashSet();
        final Map<String, Set<String>> animationGroups = CollectionLiterals.<String, Set<String>>newHashMap();
        final Map<String, List<Object>> animationParams = CollectionLiterals.<String, List<Object>>newHashMap();
        List<List<Object>> _transition = this.getTransition();
        boolean _notEquals = (!Objects.equal(_transition, null));
        if (_notEquals) {
            List<List<Object>> _transition_1 = this.getTransition();
            final Procedure1<List<Object>> _function = new Procedure1<List<Object>>() {
                @Override
                public void apply(final List<Object> it) {
                    Object _get = it.get(0);
                    final String transitionName = ((String) _get);
                    Integer _elvis = null;
                    Object _get_1 = it.get(1);
                    if (((Integer) _get_1) != null) {
                        _elvis = ((Integer) _get_1);
                    } else {
                        _elvis = Integer.valueOf(0);
                    }
                    final Integer duration = _elvis;
                    String _elvis_1 = null;
                    Object _get_2 = it.get(2);
                    if (((String) _get_2) != null) {
                        _elvis_1 = ((String) _get_2);
                    } else {
                        _elvis_1 = "";
                    }
                    final String fn = _elvis_1;
                    Integer _elvis_2 = null;
                    Object _get_3 = it.get(3);
                    if (((Integer) _get_3) != null) {
                        _elvis_2 = ((Integer) _get_3);
                    } else {
                        _elvis_2 = Integer.valueOf(0);
                    }
                    final Integer delay = _elvis_2;
                    Object _get_4 = it.get(1);
                    String _plus = (_get_4 + ",");
                    Object _get_5 = it.get(2);
                    String _plus_1 = (_plus + _get_5);
                    String _plus_2 = (_plus_1 + ",");
                    Object _get_6 = it.get(3);
                    final String groupName = (_plus_2 + _get_6);
                    Set<String> group = animationGroups.get(groupName);
                    boolean _equals = Objects.equal(group, null);
                    if (_equals) {
                        HashSet<String> _newHashSet = CollectionLiterals.<String>newHashSet();
                        group = _newHashSet;
                        animationGroups.put(groupName, group);
                        animationParams.put(groupName, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(duration, fn, delay)));
                    }
                    transitionProperties.add(transitionName);
                    group.add(transitionName);
                }
            };
            IterableExtensions.<List<Object>>forEach(_transition_1, _function);
        }
        final Point actualSize = latteView.getMeasuredSize(this);
        final Point startActualSize = latteView.getMeasuredSize(startStyle);
        final Set<String> expandedTransitions = this.expandShorthands(transitionProperties);
        final HashSet<String> modifiedAttributes = CollectionLiterals.<String>newHashSet();
        final Function1<String, Boolean> _function_1 = new Function1<String, Boolean>() {
            @Override
            public Boolean apply(final String it) {
                boolean _or = false;
                boolean _contains = Style.this.UNANIMATED_PROPERTIES.contains(it);
                if (_contains) {
                    _or = true;
                } else {
                    boolean _contains_1 = expandedTransitions.contains(it);
                    boolean _not = (!_contains_1);
                    _or = _not;
                }
                return Boolean.valueOf(_or);
            }
        };
        Iterable<String> _filter = IterableExtensions.<String>filter(this.PROPERTIES, _function_1);
        final Procedure1<String> _function_2 = new Procedure1<String>() {
            @Override
            public void apply(final String it) {
                boolean _and = false;
                boolean _and_1 = false;
                boolean _and_2 = false;
                boolean _equals = Objects.equal(it, "x");
                if (!_equals) {
                    _and_2 = false;
                } else {
                    boolean _notEquals = (!Objects.equal(Style.this._computedX, null));
                    _and_2 = _notEquals;
                }
                if (!_and_2) {
                    _and_1 = false;
                } else {
                    _and_1 = revertToNormal;
                }
                if (!_and_1) {
                    _and = false;
                } else {
                    NumberValue _x = startStyle.getX();
                    boolean _notEquals_1 = (!Objects.equal(_x, null));
                    _and = _notEquals_1;
                }
                if (_and) {
                    NumberValue _numberValue = new NumberValue((Style.this._computedX).floatValue(), TypedValue.COMPLEX_UNIT_PX);
                    startStyle.setProperty(it, _numberValue);
                } else {
                    boolean _and_3 = false;
                    boolean _and_4 = false;
                    boolean _and_5 = false;
                    boolean _equals_1 = Objects.equal(it, "y");
                    if (!_equals_1) {
                        _and_5 = false;
                    } else {
                        boolean _notEquals_2 = (!Objects.equal(Style.this._computedY, null));
                        _and_5 = _notEquals_2;
                    }
                    if (!_and_5) {
                        _and_4 = false;
                    } else {
                        _and_4 = revertToNormal;
                    }
                    if (!_and_4) {
                        _and_3 = false;
                    } else {
                        NumberValue _y = startStyle.getY();
                        boolean _notEquals_3 = (!Objects.equal(_y, null));
                        _and_3 = _notEquals_3;
                    }
                    if (_and_3) {
                        NumberValue _numberValue_1 = new NumberValue((Style.this._computedY).floatValue(), TypedValue.COMPLEX_UNIT_PX);
                        startStyle.setProperty(it, _numberValue_1);
                    } else {
                        Object _property = Style.this.getProperty(it);
                        boolean _notEquals_4 = (!Objects.equal(_property, null));
                        if (_notEquals_4) {
                            Object _property_1 = Style.this.getProperty(it);
                            Object _property_2 = startStyle.getProperty(it);
                            boolean _notEquals_5 = (!Objects.equal(_property_1, _property_2));
                            if (_notEquals_5) {
                                modifiedAttributes.add(it);
                            }
                            Object _property_3 = Style.this.getProperty(it);
                            startStyle.setProperty(it, _property_3);
                        }
                    }
                }
            }
        };
        IterableExtensions.<String>forEach(_filter, _function_2);
        boolean _isEmpty = modifiedAttributes.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
            startStyle.applyToView(latteView, ((String[])Conversions.unwrapArray(modifiedAttributes, String.class)));
        }
        Set<String> _keySet = animationGroups.keySet();
        final Function1<String, ValueAnimator> _function_3 = new Function1<String, ValueAnimator>() {
            @Override
            public ValueAnimator apply(final String it) {
                Set<String> _get = animationGroups.get(it);
                final Set<String> propertyList = Style.this.expandShorthands(_get);
                List<Object> animationParam = animationParams.get(it);
                Object _get_1 = animationParam.get(0);
                final Integer duration = ((Integer) _get_1);
                Object _get_2 = animationParam.get(2);
                final Integer delay = ((Integer) _get_2);
                final Map<String, String> propertyTypes = CollectionLiterals.<String, String>newHashMap();
                final Function1<String, PropertyValuesHolder> _function = new Function1<String, PropertyValuesHolder>() {
                    @Override
                    public PropertyValuesHolder apply(final String propName) {
                        Object _xifexpression = null;
                        boolean _equals = Objects.equal(propName, "x");
                        if (_equals) {
                            View _androidView = latteView.getAndroidView();
                            _xifexpression = Float.valueOf(_androidView.getX());
                        } else {
                            Object _xifexpression_1 = null;
                            boolean _equals_1 = Objects.equal(propName, "y");
                            if (_equals_1) {
                                View _androidView_1 = latteView.getAndroidView();
                                _xifexpression_1 = Float.valueOf(_androidView_1.getY());
                            } else {
                                _xifexpression_1 = startStyle.getProperty(propName);
                            }
                            _xifexpression = _xifexpression_1;
                        }
                        Object startValue = _xifexpression;
                        Object _xifexpression_2 = null;
                        boolean _and = false;
                        boolean _and_1 = false;
                        boolean _equals_2 = Objects.equal(propName, "x");
                        if (!_equals_2) {
                            _and_1 = false;
                        } else {
                            boolean _notEquals = (!Objects.equal(Style.this._computedX, null));
                            _and_1 = _notEquals;
                        }
                        if (!_and_1) {
                            _and = false;
                        } else {
                            _and = revertToNormal;
                        }
                        if (_and) {
                            _xifexpression_2 = Style.this._computedX;
                        } else {
                            Object _xifexpression_3 = null;
                            boolean _and_2 = false;
                            boolean _and_3 = false;
                            boolean _equals_3 = Objects.equal(propName, "y");
                            if (!_equals_3) {
                                _and_3 = false;
                            } else {
                                boolean _notEquals_1 = (!Objects.equal(Style.this._computedY, null));
                                _and_3 = _notEquals_1;
                            }
                            if (!_and_3) {
                                _and_2 = false;
                            } else {
                                _and_2 = revertToNormal;
                            }
                            if (_and_2) {
                                _xifexpression_3 = Style.this._computedY;
                            } else {
                                _xifexpression_3 = Style.this.getProperty(propName);
                            }
                            _xifexpression_2 = _xifexpression_3;
                        }
                        Object myValue = _xifexpression_2;
                        boolean _equals_4 = Objects.equal(propName, "width");
                        if (_equals_4) {
                            NumberValue _numberValue = new NumberValue(actualSize.x, 0);
                            myValue = _numberValue;
                            NumberValue _numberValue_1 = new NumberValue(startActualSize.x, 0);
                            startValue = _numberValue_1;
                        }
                        boolean _equals_5 = Objects.equal(propName, "height");
                        if (_equals_5) {
                            NumberValue _numberValue_2 = new NumberValue(actualSize.y, 0);
                            myValue = _numberValue_2;
                            NumberValue _numberValue_3 = new NumberValue(startActualSize.y, 0);
                            startValue = _numberValue_3;
                        }
                        boolean _or = false;
                        boolean _equals_6 = Objects.equal(myValue, null);
                        if (_equals_6) {
                            _or = true;
                        } else {
                            boolean _equals_7 = Objects.equal(startValue, null);
                            _or = _equals_7;
                        }
                        if (_or) {
                            String _plus = (latteView + ": No start or end value for ");
                            String _plus_1 = (_plus + propName);
                            Log.d("Latte", _plus_1);
                            return null;
                        }
                        boolean _and_4 = false;
                        if (!(startValue instanceof NumberValue)) {
                            _and_4 = false;
                        } else {
                            String _valueType = ((NumberValue) startValue).getValueType();
                            boolean _equals_8 = Objects.equal(_valueType, "Integer");
                            _and_4 = _equals_8;
                        }
                        if (_and_4) {
                            Integer _xifexpression_4 = null;
                            if ((startValue instanceof NumberValue)) {
                                View _androidView_2 = latteView.getAndroidView();
                                Context _context = _androidView_2.getContext();
                                _xifexpression_4 = Integer.valueOf(((NumberValue)startValue).inPixelsInt(_context));
                            } else {
                                _xifexpression_4 = ((Integer) startValue);
                            }
                            Integer start = _xifexpression_4;
                            Integer _xifexpression_5 = null;
                            if ((myValue instanceof NumberValue)) {
                                View _androidView_3 = latteView.getAndroidView();
                                Context _context_1 = _androidView_3.getContext();
                                _xifexpression_5 = Integer.valueOf(((NumberValue)myValue).inPixelsInt(_context_1));
                            } else {
                                _xifexpression_5 = ((Integer) myValue);
                            }
                            Integer end = _xifexpression_5;
                            propertyTypes.put(propName, "Integer");
                            return PropertyValuesHolder.ofInt(propName, (start).intValue(), (end).intValue());
                        } else {
                            boolean _and_5 = false;
                            if (!(startValue instanceof NumberValue)) {
                                _and_5 = false;
                            } else {
                                String _valueType_1 = ((NumberValue) startValue).getValueType();
                                boolean _equals_9 = Objects.equal(_valueType_1, "Float");
                                _and_5 = _equals_9;
                            }
                            if (_and_5) {
                                Float _xifexpression_6 = null;
                                if ((startValue instanceof NumberValue)) {
                                    View _androidView_4 = latteView.getAndroidView();
                                    Context _context_2 = _androidView_4.getContext();
                                    _xifexpression_6 = ((NumberValue)startValue).inPixels(_context_2);
                                } else {
                                    _xifexpression_6 = ((Float) startValue);
                                }
                                Float start_1 = _xifexpression_6;
                                Float _xifexpression_7 = null;
                                if ((myValue instanceof NumberValue)) {
                                    View _androidView_5 = latteView.getAndroidView();
                                    Context _context_3 = _androidView_5.getContext();
                                    _xifexpression_7 = ((NumberValue)myValue).inPixels(_context_3);
                                } else {
                                    _xifexpression_7 = ((Float) myValue);
                                }
                                Float end_1 = _xifexpression_7;
                                propertyTypes.put(propName, "Float");
                                return PropertyValuesHolder.ofFloat(propName, (start_1).floatValue(), (end_1).floatValue());
                            }
                        }
                        return null;
                    }
                };
                Iterable<PropertyValuesHolder> _map = IterableExtensions.<String, PropertyValuesHolder>map(propertyList, _function);
                Iterable<PropertyValuesHolder> _filterNull = IterableExtensions.<PropertyValuesHolder>filterNull(_map);
                final List<PropertyValuesHolder> propertyValues = IterableExtensions.<PropertyValuesHolder>toList(_filterNull);
                ValueAnimator animator = ValueAnimator.ofPropertyValuesHolder(((PropertyValuesHolder[])Conversions.unwrapArray(propertyValues, PropertyValuesHolder.class)));
                animator.setDuration((duration).intValue());
                animator.setStartDelay((delay).intValue());
                final ValueAnimator.AnimatorUpdateListener _function_1 = new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(final ValueAnimator anim) {
                        boolean _equals = Objects.equal(latteView.getCurrentAnimation(), animSet);
                        if (_equals) {
                            PropertyValuesHolder[] _values = anim.getValues();
                            final Procedure1<PropertyValuesHolder> _function = new Procedure1<PropertyValuesHolder>() {
                                @Override
                                public void apply(final PropertyValuesHolder it) {
                                    String _propertyName = it.getPropertyName();
                                    Object value = anim.getAnimatedValue(_propertyName);
                                    String _propertyName_1 = it.getPropertyName();
                                    String _get = propertyTypes.get(_propertyName_1);
                                    boolean _equals = Objects.equal(_get, "Integer");
                                    if (_equals) {
                                        String _propertyName_2 = it.getPropertyName();
                                        NumberValue _numberValue = new NumberValue((((Integer) value)).intValue(), 0);
                                        startStyle.setProperty(_propertyName_2, _numberValue);
                                    } else {
                                        String _propertyName_3 = it.getPropertyName();
                                        String _get_1 = propertyTypes.get(_propertyName_3);
                                        boolean _equals_1 = Objects.equal(_get_1, "Float");
                                        if (_equals_1) {
                                            String _propertyName_4 = it.getPropertyName();
                                            NumberValue _numberValue_1 = new NumberValue((((Float) value)).floatValue(), 0);
                                            startStyle.setProperty(_propertyName_4, _numberValue_1);
                                        }
                                    }
                                }
                            };
                            IterableExtensions.<PropertyValuesHolder>forEach(((Iterable<PropertyValuesHolder>)Conversions.doWrapArray(_values)), _function);
                            startStyle.applyToView(latteView, ((String[])Conversions.unwrapArray(propertyList, String.class)));
                        }
                    }
                };
                animator.addUpdateListener(_function_1);
                return animator;
            }
        };
        Iterable<ValueAnimator> _map = IterableExtensions.<String, ValueAnimator>map(_keySet, _function_3);
        final Function1<ValueAnimator, Long> _function_4 = new Function1<ValueAnimator, Long>() {
            @Override
            public Long apply(final ValueAnimator it) {
                return Long.valueOf(it.getStartDelay());
            }
        };
        List<ValueAnimator> allAnims = IterableExtensions.<ValueAnimator, Long>sortBy(_map, _function_4);
        boolean _isEmpty_1 = allAnims.isEmpty();
        boolean _not_1 = (!_isEmpty_1);
        if (_not_1) {
            final List<ValueAnimator> _converted_allAnims = (List<ValueAnimator>)allAnims;
            animSet.playTogether(((Animator[])Conversions.unwrapArray(_converted_allAnims, Animator.class)));
        }
        final NativeView nativeParent = latteView.getNonVirtualParent();
        boolean _notEquals_1 = (!Objects.equal(nativeParent, null));
        if (_notEquals_1) {
            nativeParent.getPendingChildAnimations().add(animSet);
            animSet.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(final Animator animation) {
                    nativeParent.getPendingChildAnimations().remove(animSet);
                    Handler _handler = new Handler();
                    final Runnable _function = new Runnable() {
                        @Override
                        public void run() {
                            boolean _isEmpty = nativeParent.getPendingChildAnimations().isEmpty();
                            if (_isEmpty) {
                                nativeParent.applySubviewStyles();
                            }
                        }
                    };
                    _handler.postDelayed(_function, 10);
                }
            });
        }
        return animSet;
    }

    public void setBorderBottom(final NumberValue borderWidth, final String borderStyle, final Object borderColor) {
        boolean _notEquals = (!Objects.equal(borderWidth, null));
        if (_notEquals) {
            this.setBorderBottomWidth(borderWidth);
        }
        boolean _notEquals_1 = (!Objects.equal(borderColor, null));
        if (_notEquals_1) {
            this.setBorderBottomColor(borderColor);
        }
    }

    public void setBorderTop(final NumberValue borderWidth, final String borderStyle, final Object borderColor) {
        boolean _notEquals = (!Objects.equal(borderWidth, null));
        if (_notEquals) {
            this.setBorderTopWidth(borderWidth);
        }
        boolean _notEquals_1 = (!Objects.equal(borderColor, null));
        if (_notEquals_1) {
            this.setBorderTopColor(borderColor);
        }
    }

    public void setBorderLeft(final NumberValue borderWidth, final String borderStyle, final Object borderColor) {
        boolean _notEquals = (!Objects.equal(borderWidth, null));
        if (_notEquals) {
            this.setBorderLeftWidth(borderWidth);
        }
        boolean _notEquals_1 = (!Objects.equal(borderColor, null));
        if (_notEquals_1) {
            this.setBorderLeftColor(borderColor);
        }
    }

    public void setBorderRight(final NumberValue borderWidth, final String borderStyle, final Object borderColor) {
        boolean _notEquals = (!Objects.equal(borderWidth, null));
        if (_notEquals) {
            this.setBorderRightWidth(borderWidth);
        }
        boolean _notEquals_1 = (!Objects.equal(borderColor, null));
        if (_notEquals_1) {
            this.setBorderRightColor(borderColor);
        }
    }

    public void setBorder(final NumberValue borderWidth, final String borderStyle, final Object borderColor) {
        this.setBorderLeft(borderWidth, borderStyle, borderColor);
        this.setBorderTop(borderWidth, borderStyle, borderColor);
        this.setBorderRight(borderWidth, borderStyle, borderColor);
        this.setBorderBottom(borderWidth, borderStyle, borderColor);
    }

    public void setBorderColor(final Object... vals) {
        Iterable<Object> values = IterableExtensions.<Object>filterNull(((Iterable<Object>)Conversions.doWrapArray(vals)));
        final Iterable<Object> _converted_values = (Iterable<Object>)values;
        int _length = ((Object[])Conversions.unwrapArray(_converted_values, Object.class)).length;
        boolean _equals = (_length == 1);
        if (_equals) {
            final Iterable<Object> _converted_values_1 = (Iterable<Object>)values;
            Object _get = ((Object[])Conversions.unwrapArray(_converted_values_1, Object.class))[0];
            this.setBorderTopColor(_get);
            final Iterable<Object> _converted_values_2 = (Iterable<Object>)values;
            Object _get_1 = ((Object[])Conversions.unwrapArray(_converted_values_2, Object.class))[0];
            this.setBorderRightColor(_get_1);
            final Iterable<Object> _converted_values_3 = (Iterable<Object>)values;
            Object _get_2 = ((Object[])Conversions.unwrapArray(_converted_values_3, Object.class))[0];
            this.setBorderBottomColor(_get_2);
            final Iterable<Object> _converted_values_4 = (Iterable<Object>)values;
            Object _get_3 = ((Object[])Conversions.unwrapArray(_converted_values_4, Object.class))[0];
            this.setBorderLeftColor(_get_3);
        } else {
            final Iterable<Object> _converted_values_5 = (Iterable<Object>)values;
            int _length_1 = ((Object[])Conversions.unwrapArray(_converted_values_5, Object.class)).length;
            boolean _equals_1 = (_length_1 == 2);
            if (_equals_1) {
                final Iterable<Object> _converted_values_6 = (Iterable<Object>)values;
                Object _get_4 = ((Object[])Conversions.unwrapArray(_converted_values_6, Object.class))[0];
                this.setBorderTopColor(_get_4);
                final Iterable<Object> _converted_values_7 = (Iterable<Object>)values;
                Object _get_5 = ((Object[])Conversions.unwrapArray(_converted_values_7, Object.class))[0];
                this.setBorderBottomColor(_get_5);
                final Iterable<Object> _converted_values_8 = (Iterable<Object>)values;
                Object _get_6 = ((Object[])Conversions.unwrapArray(_converted_values_8, Object.class))[1];
                this.setBorderLeftColor(_get_6);
                final Iterable<Object> _converted_values_9 = (Iterable<Object>)values;
                Object _get_7 = ((Object[])Conversions.unwrapArray(_converted_values_9, Object.class))[1];
                this.setBorderRightColor(_get_7);
            } else {
                final Iterable<Object> _converted_values_10 = (Iterable<Object>)values;
                int _length_2 = ((Object[])Conversions.unwrapArray(_converted_values_10, Object.class)).length;
                boolean _equals_2 = (_length_2 == 3);
                if (_equals_2) {
                    final Iterable<Object> _converted_values_11 = (Iterable<Object>)values;
                    Object _get_8 = ((Object[])Conversions.unwrapArray(_converted_values_11, Object.class))[0];
                    this.setBorderTopColor(_get_8);
                    final Iterable<Object> _converted_values_12 = (Iterable<Object>)values;
                    Object _get_9 = ((Object[])Conversions.unwrapArray(_converted_values_12, Object.class))[2];
                    this.setBorderBottomColor(_get_9);
                    final Iterable<Object> _converted_values_13 = (Iterable<Object>)values;
                    Object _get_10 = ((Object[])Conversions.unwrapArray(_converted_values_13, Object.class))[1];
                    this.setBorderLeftColor(_get_10);
                    final Iterable<Object> _converted_values_14 = (Iterable<Object>)values;
                    Object _get_11 = ((Object[])Conversions.unwrapArray(_converted_values_14, Object.class))[1];
                    this.setBorderRightColor(_get_11);
                } else {
                    final Iterable<Object> _converted_values_15 = (Iterable<Object>)values;
                    int _length_3 = ((Object[])Conversions.unwrapArray(_converted_values_15, Object.class)).length;
                    boolean _equals_3 = (_length_3 == 4);
                    if (_equals_3) {
                        final Iterable<Object> _converted_values_16 = (Iterable<Object>)values;
                        Object _get_12 = ((Object[])Conversions.unwrapArray(_converted_values_16, Object.class))[0];
                        this.setBorderTopColor(_get_12);
                        final Iterable<Object> _converted_values_17 = (Iterable<Object>)values;
                        Object _get_13 = ((Object[])Conversions.unwrapArray(_converted_values_17, Object.class))[1];
                        this.setBorderRightColor(_get_13);
                        final Iterable<Object> _converted_values_18 = (Iterable<Object>)values;
                        Object _get_14 = ((Object[])Conversions.unwrapArray(_converted_values_18, Object.class))[2];
                        this.setBorderBottomColor(_get_14);
                        final Iterable<Object> _converted_values_19 = (Iterable<Object>)values;
                        Object _get_15 = ((Object[])Conversions.unwrapArray(_converted_values_19, Object.class))[3];
                        this.setBorderLeftColor(_get_15);
                    }
                }
            }
        }
    }

    public void setBorderTopLeftRadius(final NumberValue... vals) {
        Iterable<NumberValue> values = IterableExtensions.<NumberValue>filterNull(((Iterable<NumberValue>)Conversions.doWrapArray(vals)));
        final Iterable<NumberValue> _converted_values = (Iterable<NumberValue>)values;
        int _length = ((Object[])Conversions.unwrapArray(_converted_values, Object.class)).length;
        boolean _equals = (_length == 1);
        if (_equals) {
            final Iterable<NumberValue> _converted_values_1 = (Iterable<NumberValue>)values;
            NumberValue _get = ((NumberValue[])Conversions.unwrapArray(_converted_values_1, NumberValue.class))[0];
            this.setBorderTopLeftRadiusH(_get);
            final Iterable<NumberValue> _converted_values_2 = (Iterable<NumberValue>)values;
            NumberValue _get_1 = ((NumberValue[])Conversions.unwrapArray(_converted_values_2, NumberValue.class))[0];
            this.setBorderTopLeftRadiusV(_get_1);
        } else {
            final Iterable<NumberValue> _converted_values_3 = (Iterable<NumberValue>)values;
            NumberValue _get_2 = ((NumberValue[])Conversions.unwrapArray(_converted_values_3, NumberValue.class))[0];
            this.setBorderTopLeftRadiusH(_get_2);
            final Iterable<NumberValue> _converted_values_4 = (Iterable<NumberValue>)values;
            NumberValue _get_3 = ((NumberValue[])Conversions.unwrapArray(_converted_values_4, NumberValue.class))[1];
            this.setBorderTopLeftRadiusV(_get_3);
        }
    }

    public void setBorderTopRightRadius(final NumberValue... vals) {
        Iterable<NumberValue> values = IterableExtensions.<NumberValue>filterNull(((Iterable<NumberValue>)Conversions.doWrapArray(vals)));
        final Iterable<NumberValue> _converted_values = (Iterable<NumberValue>)values;
        int _length = ((Object[])Conversions.unwrapArray(_converted_values, Object.class)).length;
        boolean _equals = (_length == 1);
        if (_equals) {
            final Iterable<NumberValue> _converted_values_1 = (Iterable<NumberValue>)values;
            NumberValue _get = ((NumberValue[])Conversions.unwrapArray(_converted_values_1, NumberValue.class))[0];
            this.setBorderTopRightRadiusH(_get);
            final Iterable<NumberValue> _converted_values_2 = (Iterable<NumberValue>)values;
            NumberValue _get_1 = ((NumberValue[])Conversions.unwrapArray(_converted_values_2, NumberValue.class))[0];
            this.setBorderTopRightRadiusV(_get_1);
        } else {
            final Iterable<NumberValue> _converted_values_3 = (Iterable<NumberValue>)values;
            NumberValue _get_2 = ((NumberValue[])Conversions.unwrapArray(_converted_values_3, NumberValue.class))[0];
            this.setBorderTopRightRadiusH(_get_2);
            final Iterable<NumberValue> _converted_values_4 = (Iterable<NumberValue>)values;
            NumberValue _get_3 = ((NumberValue[])Conversions.unwrapArray(_converted_values_4, NumberValue.class))[1];
            this.setBorderTopRightRadiusV(_get_3);
        }
    }

    public void setBorderBottomLeftRadius(final NumberValue... vals) {
        Iterable<NumberValue> values = IterableExtensions.<NumberValue>filterNull(((Iterable<NumberValue>)Conversions.doWrapArray(vals)));
        final Iterable<NumberValue> _converted_values = (Iterable<NumberValue>)values;
        int _length = ((Object[])Conversions.unwrapArray(_converted_values, Object.class)).length;
        boolean _equals = (_length == 1);
        if (_equals) {
            final Iterable<NumberValue> _converted_values_1 = (Iterable<NumberValue>)values;
            NumberValue _get = ((NumberValue[])Conversions.unwrapArray(_converted_values_1, NumberValue.class))[0];
            this.setBorderBottomLeftRadiusH(_get);
            final Iterable<NumberValue> _converted_values_2 = (Iterable<NumberValue>)values;
            NumberValue _get_1 = ((NumberValue[])Conversions.unwrapArray(_converted_values_2, NumberValue.class))[0];
            this.setBorderBottomLeftRadiusV(_get_1);
        } else {
            final Iterable<NumberValue> _converted_values_3 = (Iterable<NumberValue>)values;
            NumberValue _get_2 = ((NumberValue[])Conversions.unwrapArray(_converted_values_3, NumberValue.class))[0];
            this.setBorderBottomLeftRadiusH(_get_2);
            final Iterable<NumberValue> _converted_values_4 = (Iterable<NumberValue>)values;
            NumberValue _get_3 = ((NumberValue[])Conversions.unwrapArray(_converted_values_4, NumberValue.class))[1];
            this.setBorderBottomLeftRadiusV(_get_3);
        }
    }

    public void setBorderBottomRightRadius(final NumberValue... vals) {
        Iterable<NumberValue> values = IterableExtensions.<NumberValue>filterNull(((Iterable<NumberValue>)Conversions.doWrapArray(vals)));
        final Iterable<NumberValue> _converted_values = (Iterable<NumberValue>)values;
        int _length = ((Object[])Conversions.unwrapArray(_converted_values, Object.class)).length;
        boolean _equals = (_length == 1);
        if (_equals) {
            final Iterable<NumberValue> _converted_values_1 = (Iterable<NumberValue>)values;
            NumberValue _get = ((NumberValue[])Conversions.unwrapArray(_converted_values_1, NumberValue.class))[0];
            this.setBorderBottomRightRadiusH(_get);
            final Iterable<NumberValue> _converted_values_2 = (Iterable<NumberValue>)values;
            NumberValue _get_1 = ((NumberValue[])Conversions.unwrapArray(_converted_values_2, NumberValue.class))[0];
            this.setBorderBottomRightRadiusV(_get_1);
        } else {
            final Iterable<NumberValue> _converted_values_3 = (Iterable<NumberValue>)values;
            NumberValue _get_2 = ((NumberValue[])Conversions.unwrapArray(_converted_values_3, NumberValue.class))[0];
            this.setBorderBottomRightRadiusH(_get_2);
            final Iterable<NumberValue> _converted_values_4 = (Iterable<NumberValue>)values;
            NumberValue _get_3 = ((NumberValue[])Conversions.unwrapArray(_converted_values_4, NumberValue.class))[1];
            this.setBorderBottomRightRadiusV(_get_3);
        }
    }

    public void setBorderRadius(final NumberValue... vals) {
        Iterable<NumberValue> values = IterableExtensions.<NumberValue>filterNull(((Iterable<NumberValue>)Conversions.doWrapArray(vals)));
        final Iterable<NumberValue> _converted_values = (Iterable<NumberValue>)values;
        int _length = ((Object[])Conversions.unwrapArray(_converted_values, Object.class)).length;
        boolean _equals = (_length == 1);
        if (_equals) {
            final Iterable<NumberValue> _converted_values_1 = (Iterable<NumberValue>)values;
            NumberValue _get = ((NumberValue[])Conversions.unwrapArray(_converted_values_1, NumberValue.class))[0];
            this.setBorderTopLeftRadius(_get);
            final Iterable<NumberValue> _converted_values_2 = (Iterable<NumberValue>)values;
            NumberValue _get_1 = ((NumberValue[])Conversions.unwrapArray(_converted_values_2, NumberValue.class))[0];
            this.setBorderTopRightRadius(_get_1);
            final Iterable<NumberValue> _converted_values_3 = (Iterable<NumberValue>)values;
            NumberValue _get_2 = ((NumberValue[])Conversions.unwrapArray(_converted_values_3, NumberValue.class))[0];
            this.setBorderBottomRightRadius(_get_2);
            final Iterable<NumberValue> _converted_values_4 = (Iterable<NumberValue>)values;
            NumberValue _get_3 = ((NumberValue[])Conversions.unwrapArray(_converted_values_4, NumberValue.class))[0];
            this.setBorderBottomLeftRadius(_get_3);
        } else {
            final Iterable<NumberValue> _converted_values_5 = (Iterable<NumberValue>)values;
            int _length_1 = ((Object[])Conversions.unwrapArray(_converted_values_5, Object.class)).length;
            boolean _equals_1 = (_length_1 == 2);
            if (_equals_1) {
                final Iterable<NumberValue> _converted_values_6 = (Iterable<NumberValue>)values;
                NumberValue _get_4 = ((NumberValue[])Conversions.unwrapArray(_converted_values_6, NumberValue.class))[0];
                this.setBorderTopLeftRadius(_get_4);
                final Iterable<NumberValue> _converted_values_7 = (Iterable<NumberValue>)values;
                NumberValue _get_5 = ((NumberValue[])Conversions.unwrapArray(_converted_values_7, NumberValue.class))[0];
                this.setBorderBottomRightRadius(_get_5);
                final Iterable<NumberValue> _converted_values_8 = (Iterable<NumberValue>)values;
                NumberValue _get_6 = ((NumberValue[])Conversions.unwrapArray(_converted_values_8, NumberValue.class))[1];
                this.setBorderTopRightRadius(_get_6);
                final Iterable<NumberValue> _converted_values_9 = (Iterable<NumberValue>)values;
                NumberValue _get_7 = ((NumberValue[])Conversions.unwrapArray(_converted_values_9, NumberValue.class))[1];
                this.setBorderBottomLeftRadius(_get_7);
            } else {
                final Iterable<NumberValue> _converted_values_10 = (Iterable<NumberValue>)values;
                int _length_2 = ((Object[])Conversions.unwrapArray(_converted_values_10, Object.class)).length;
                boolean _equals_2 = (_length_2 == 3);
                if (_equals_2) {
                    final Iterable<NumberValue> _converted_values_11 = (Iterable<NumberValue>)values;
                    NumberValue _get_8 = ((NumberValue[])Conversions.unwrapArray(_converted_values_11, NumberValue.class))[0];
                    this.setBorderTopLeftRadius(_get_8);
                    final Iterable<NumberValue> _converted_values_12 = (Iterable<NumberValue>)values;
                    NumberValue _get_9 = ((NumberValue[])Conversions.unwrapArray(_converted_values_12, NumberValue.class))[2];
                    this.setBorderBottomRightRadius(_get_9);
                    final Iterable<NumberValue> _converted_values_13 = (Iterable<NumberValue>)values;
                    NumberValue _get_10 = ((NumberValue[])Conversions.unwrapArray(_converted_values_13, NumberValue.class))[1];
                    this.setBorderTopRightRadius(_get_10);
                    final Iterable<NumberValue> _converted_values_14 = (Iterable<NumberValue>)values;
                    NumberValue _get_11 = ((NumberValue[])Conversions.unwrapArray(_converted_values_14, NumberValue.class))[1];
                    this.setBorderBottomLeftRadius(_get_11);
                } else {
                    final Iterable<NumberValue> _converted_values_15 = (Iterable<NumberValue>)values;
                    int _length_3 = ((Object[])Conversions.unwrapArray(_converted_values_15, Object.class)).length;
                    boolean _equals_3 = (_length_3 == 4);
                    if (_equals_3) {
                        final Iterable<NumberValue> _converted_values_16 = (Iterable<NumberValue>)values;
                        NumberValue _get_12 = ((NumberValue[])Conversions.unwrapArray(_converted_values_16, NumberValue.class))[0];
                        this.setBorderTopLeftRadius(_get_12);
                        final Iterable<NumberValue> _converted_values_17 = (Iterable<NumberValue>)values;
                        NumberValue _get_13 = ((NumberValue[])Conversions.unwrapArray(_converted_values_17, NumberValue.class))[1];
                        this.setBorderTopRightRadius(_get_13);
                        final Iterable<NumberValue> _converted_values_18 = (Iterable<NumberValue>)values;
                        NumberValue _get_14 = ((NumberValue[])Conversions.unwrapArray(_converted_values_18, NumberValue.class))[2];
                        this.setBorderBottomRightRadius(_get_14);
                        final Iterable<NumberValue> _converted_values_19 = (Iterable<NumberValue>)values;
                        NumberValue _get_15 = ((NumberValue[])Conversions.unwrapArray(_converted_values_19, NumberValue.class))[3];
                        this.setBorderBottomLeftRadius(_get_15);
                    }
                }
            }
        }
    }

    public void setBorderWidth(final NumberValue... vals) {
        Iterable<NumberValue> values = IterableExtensions.<NumberValue>filterNull(((Iterable<NumberValue>)Conversions.doWrapArray(vals)));
        final Iterable<NumberValue> _converted_values = (Iterable<NumberValue>)values;
        int _length = ((Object[])Conversions.unwrapArray(_converted_values, Object.class)).length;
        boolean _equals = (_length == 1);
        if (_equals) {
            final Iterable<NumberValue> _converted_values_1 = (Iterable<NumberValue>)values;
            NumberValue _get = ((NumberValue[])Conversions.unwrapArray(_converted_values_1, NumberValue.class))[0];
            this.setBorderTopWidth(_get);
            final Iterable<NumberValue> _converted_values_2 = (Iterable<NumberValue>)values;
            NumberValue _get_1 = ((NumberValue[])Conversions.unwrapArray(_converted_values_2, NumberValue.class))[0];
            this.setBorderRightWidth(_get_1);
            final Iterable<NumberValue> _converted_values_3 = (Iterable<NumberValue>)values;
            NumberValue _get_2 = ((NumberValue[])Conversions.unwrapArray(_converted_values_3, NumberValue.class))[0];
            this.setBorderBottomWidth(_get_2);
            final Iterable<NumberValue> _converted_values_4 = (Iterable<NumberValue>)values;
            NumberValue _get_3 = ((NumberValue[])Conversions.unwrapArray(_converted_values_4, NumberValue.class))[0];
            this.setBorderLeftWidth(_get_3);
        } else {
            final Iterable<NumberValue> _converted_values_5 = (Iterable<NumberValue>)values;
            int _length_1 = ((Object[])Conversions.unwrapArray(_converted_values_5, Object.class)).length;
            boolean _equals_1 = (_length_1 == 2);
            if (_equals_1) {
                final Iterable<NumberValue> _converted_values_6 = (Iterable<NumberValue>)values;
                NumberValue _get_4 = ((NumberValue[])Conversions.unwrapArray(_converted_values_6, NumberValue.class))[0];
                this.setBorderTopWidth(_get_4);
                final Iterable<NumberValue> _converted_values_7 = (Iterable<NumberValue>)values;
                NumberValue _get_5 = ((NumberValue[])Conversions.unwrapArray(_converted_values_7, NumberValue.class))[0];
                this.setBorderBottomWidth(_get_5);
                final Iterable<NumberValue> _converted_values_8 = (Iterable<NumberValue>)values;
                NumberValue _get_6 = ((NumberValue[])Conversions.unwrapArray(_converted_values_8, NumberValue.class))[1];
                this.setBorderLeftWidth(_get_6);
                final Iterable<NumberValue> _converted_values_9 = (Iterable<NumberValue>)values;
                NumberValue _get_7 = ((NumberValue[])Conversions.unwrapArray(_converted_values_9, NumberValue.class))[1];
                this.setBorderRightWidth(_get_7);
            } else {
                final Iterable<NumberValue> _converted_values_10 = (Iterable<NumberValue>)values;
                int _length_2 = ((Object[])Conversions.unwrapArray(_converted_values_10, Object.class)).length;
                boolean _equals_2 = (_length_2 == 3);
                if (_equals_2) {
                    final Iterable<NumberValue> _converted_values_11 = (Iterable<NumberValue>)values;
                    NumberValue _get_8 = ((NumberValue[])Conversions.unwrapArray(_converted_values_11, NumberValue.class))[0];
                    this.setBorderTopWidth(_get_8);
                    final Iterable<NumberValue> _converted_values_12 = (Iterable<NumberValue>)values;
                    NumberValue _get_9 = ((NumberValue[])Conversions.unwrapArray(_converted_values_12, NumberValue.class))[2];
                    this.setBorderBottomWidth(_get_9);
                    final Iterable<NumberValue> _converted_values_13 = (Iterable<NumberValue>)values;
                    NumberValue _get_10 = ((NumberValue[])Conversions.unwrapArray(_converted_values_13, NumberValue.class))[1];
                    this.setBorderLeftWidth(_get_10);
                    final Iterable<NumberValue> _converted_values_14 = (Iterable<NumberValue>)values;
                    NumberValue _get_11 = ((NumberValue[])Conversions.unwrapArray(_converted_values_14, NumberValue.class))[1];
                    this.setBorderRightWidth(_get_11);
                } else {
                    final Iterable<NumberValue> _converted_values_15 = (Iterable<NumberValue>)values;
                    int _length_3 = ((Object[])Conversions.unwrapArray(_converted_values_15, Object.class)).length;
                    boolean _equals_3 = (_length_3 == 4);
                    if (_equals_3) {
                        final Iterable<NumberValue> _converted_values_16 = (Iterable<NumberValue>)values;
                        NumberValue _get_12 = ((NumberValue[])Conversions.unwrapArray(_converted_values_16, NumberValue.class))[0];
                        this.setBorderTopWidth(_get_12);
                        final Iterable<NumberValue> _converted_values_17 = (Iterable<NumberValue>)values;
                        NumberValue _get_13 = ((NumberValue[])Conversions.unwrapArray(_converted_values_17, NumberValue.class))[1];
                        this.setBorderRightWidth(_get_13);
                        final Iterable<NumberValue> _converted_values_18 = (Iterable<NumberValue>)values;
                        NumberValue _get_14 = ((NumberValue[])Conversions.unwrapArray(_converted_values_18, NumberValue.class))[2];
                        this.setBorderBottomWidth(_get_14);
                        final Iterable<NumberValue> _converted_values_19 = (Iterable<NumberValue>)values;
                        NumberValue _get_15 = ((NumberValue[])Conversions.unwrapArray(_converted_values_19, NumberValue.class))[3];
                        this.setBorderLeftWidth(_get_15);
                    }
                }
            }
        }
    }

    public void setMargin(final NumberValue... vals) {
        Iterable<NumberValue> values = IterableExtensions.<NumberValue>filterNull(((Iterable<NumberValue>)Conversions.doWrapArray(vals)));
        final Iterable<NumberValue> _converted_values = (Iterable<NumberValue>)values;
        int _length = ((Object[])Conversions.unwrapArray(_converted_values, Object.class)).length;
        boolean _equals = (_length == 1);
        if (_equals) {
            final Iterable<NumberValue> _converted_values_1 = (Iterable<NumberValue>)values;
            NumberValue _get = ((NumberValue[])Conversions.unwrapArray(_converted_values_1, NumberValue.class))[0];
            this.setMarginTop(_get);
            final Iterable<NumberValue> _converted_values_2 = (Iterable<NumberValue>)values;
            NumberValue _get_1 = ((NumberValue[])Conversions.unwrapArray(_converted_values_2, NumberValue.class))[0];
            this.setMarginRight(_get_1);
            final Iterable<NumberValue> _converted_values_3 = (Iterable<NumberValue>)values;
            NumberValue _get_2 = ((NumberValue[])Conversions.unwrapArray(_converted_values_3, NumberValue.class))[0];
            this.setMarginBottom(_get_2);
            final Iterable<NumberValue> _converted_values_4 = (Iterable<NumberValue>)values;
            NumberValue _get_3 = ((NumberValue[])Conversions.unwrapArray(_converted_values_4, NumberValue.class))[0];
            this.setMarginLeft(_get_3);
        } else {
            final Iterable<NumberValue> _converted_values_5 = (Iterable<NumberValue>)values;
            int _length_1 = ((Object[])Conversions.unwrapArray(_converted_values_5, Object.class)).length;
            boolean _equals_1 = (_length_1 == 2);
            if (_equals_1) {
                final Iterable<NumberValue> _converted_values_6 = (Iterable<NumberValue>)values;
                NumberValue _get_4 = ((NumberValue[])Conversions.unwrapArray(_converted_values_6, NumberValue.class))[0];
                this.setMarginTop(_get_4);
                final Iterable<NumberValue> _converted_values_7 = (Iterable<NumberValue>)values;
                NumberValue _get_5 = ((NumberValue[])Conversions.unwrapArray(_converted_values_7, NumberValue.class))[0];
                this.setMarginBottom(_get_5);
                final Iterable<NumberValue> _converted_values_8 = (Iterable<NumberValue>)values;
                NumberValue _get_6 = ((NumberValue[])Conversions.unwrapArray(_converted_values_8, NumberValue.class))[1];
                this.setMarginLeft(_get_6);
                final Iterable<NumberValue> _converted_values_9 = (Iterable<NumberValue>)values;
                NumberValue _get_7 = ((NumberValue[])Conversions.unwrapArray(_converted_values_9, NumberValue.class))[1];
                this.setMarginRight(_get_7);
            } else {
                final Iterable<NumberValue> _converted_values_10 = (Iterable<NumberValue>)values;
                int _length_2 = ((Object[])Conversions.unwrapArray(_converted_values_10, Object.class)).length;
                boolean _equals_2 = (_length_2 == 3);
                if (_equals_2) {
                    final Iterable<NumberValue> _converted_values_11 = (Iterable<NumberValue>)values;
                    NumberValue _get_8 = ((NumberValue[])Conversions.unwrapArray(_converted_values_11, NumberValue.class))[0];
                    this.setMarginTop(_get_8);
                    final Iterable<NumberValue> _converted_values_12 = (Iterable<NumberValue>)values;
                    NumberValue _get_9 = ((NumberValue[])Conversions.unwrapArray(_converted_values_12, NumberValue.class))[2];
                    this.setMarginBottom(_get_9);
                    final Iterable<NumberValue> _converted_values_13 = (Iterable<NumberValue>)values;
                    NumberValue _get_10 = ((NumberValue[])Conversions.unwrapArray(_converted_values_13, NumberValue.class))[1];
                    this.setMarginLeft(_get_10);
                    final Iterable<NumberValue> _converted_values_14 = (Iterable<NumberValue>)values;
                    NumberValue _get_11 = ((NumberValue[])Conversions.unwrapArray(_converted_values_14, NumberValue.class))[1];
                    this.setMarginRight(_get_11);
                } else {
                    final Iterable<NumberValue> _converted_values_15 = (Iterable<NumberValue>)values;
                    int _length_3 = ((Object[])Conversions.unwrapArray(_converted_values_15, Object.class)).length;
                    boolean _equals_3 = (_length_3 == 4);
                    if (_equals_3) {
                        final Iterable<NumberValue> _converted_values_16 = (Iterable<NumberValue>)values;
                        NumberValue _get_12 = ((NumberValue[])Conversions.unwrapArray(_converted_values_16, NumberValue.class))[0];
                        this.setMarginTop(_get_12);
                        final Iterable<NumberValue> _converted_values_17 = (Iterable<NumberValue>)values;
                        NumberValue _get_13 = ((NumberValue[])Conversions.unwrapArray(_converted_values_17, NumberValue.class))[2];
                        this.setMarginRight(_get_13);
                        final Iterable<NumberValue> _converted_values_18 = (Iterable<NumberValue>)values;
                        NumberValue _get_14 = ((NumberValue[])Conversions.unwrapArray(_converted_values_18, NumberValue.class))[3];
                        this.setMarginBottom(_get_14);
                        final Iterable<NumberValue> _converted_values_19 = (Iterable<NumberValue>)values;
                        NumberValue _get_15 = ((NumberValue[])Conversions.unwrapArray(_converted_values_19, NumberValue.class))[4];
                        this.setMarginLeft(_get_15);
                    }
                }
            }
        }
    }

    public void setPadding(final NumberValue... vals) {
        Iterable<NumberValue> values = IterableExtensions.<NumberValue>filterNull(((Iterable<NumberValue>)Conversions.doWrapArray(vals)));
        final Iterable<NumberValue> _converted_values = (Iterable<NumberValue>)values;
        int _length = ((Object[])Conversions.unwrapArray(_converted_values, Object.class)).length;
        boolean _equals = (_length == 1);
        if (_equals) {
            final Iterable<NumberValue> _converted_values_1 = (Iterable<NumberValue>)values;
            NumberValue _get = ((NumberValue[])Conversions.unwrapArray(_converted_values_1, NumberValue.class))[0];
            this.setPaddingTop(_get);
            final Iterable<NumberValue> _converted_values_2 = (Iterable<NumberValue>)values;
            NumberValue _get_1 = ((NumberValue[])Conversions.unwrapArray(_converted_values_2, NumberValue.class))[0];
            this.setPaddingRight(_get_1);
            final Iterable<NumberValue> _converted_values_3 = (Iterable<NumberValue>)values;
            NumberValue _get_2 = ((NumberValue[])Conversions.unwrapArray(_converted_values_3, NumberValue.class))[0];
            this.setPaddingBottom(_get_2);
            final Iterable<NumberValue> _converted_values_4 = (Iterable<NumberValue>)values;
            NumberValue _get_3 = ((NumberValue[])Conversions.unwrapArray(_converted_values_4, NumberValue.class))[0];
            this.setPaddingLeft(_get_3);
        } else {
            final Iterable<NumberValue> _converted_values_5 = (Iterable<NumberValue>)values;
            int _length_1 = ((Object[])Conversions.unwrapArray(_converted_values_5, Object.class)).length;
            boolean _equals_1 = (_length_1 == 2);
            if (_equals_1) {
                final Iterable<NumberValue> _converted_values_6 = (Iterable<NumberValue>)values;
                NumberValue _get_4 = ((NumberValue[])Conversions.unwrapArray(_converted_values_6, NumberValue.class))[0];
                this.setPaddingTop(_get_4);
                final Iterable<NumberValue> _converted_values_7 = (Iterable<NumberValue>)values;
                NumberValue _get_5 = ((NumberValue[])Conversions.unwrapArray(_converted_values_7, NumberValue.class))[0];
                this.setPaddingBottom(_get_5);
                final Iterable<NumberValue> _converted_values_8 = (Iterable<NumberValue>)values;
                NumberValue _get_6 = ((NumberValue[])Conversions.unwrapArray(_converted_values_8, NumberValue.class))[1];
                this.setPaddingLeft(_get_6);
                final Iterable<NumberValue> _converted_values_9 = (Iterable<NumberValue>)values;
                NumberValue _get_7 = ((NumberValue[])Conversions.unwrapArray(_converted_values_9, NumberValue.class))[1];
                this.setPaddingRight(_get_7);
            } else {
                final Iterable<NumberValue> _converted_values_10 = (Iterable<NumberValue>)values;
                int _length_2 = ((Object[])Conversions.unwrapArray(_converted_values_10, Object.class)).length;
                boolean _equals_2 = (_length_2 == 3);
                if (_equals_2) {
                    final Iterable<NumberValue> _converted_values_11 = (Iterable<NumberValue>)values;
                    NumberValue _get_8 = ((NumberValue[])Conversions.unwrapArray(_converted_values_11, NumberValue.class))[0];
                    this.setPaddingTop(_get_8);
                    final Iterable<NumberValue> _converted_values_12 = (Iterable<NumberValue>)values;
                    NumberValue _get_9 = ((NumberValue[])Conversions.unwrapArray(_converted_values_12, NumberValue.class))[2];
                    this.setPaddingBottom(_get_9);
                    final Iterable<NumberValue> _converted_values_13 = (Iterable<NumberValue>)values;
                    NumberValue _get_10 = ((NumberValue[])Conversions.unwrapArray(_converted_values_13, NumberValue.class))[1];
                    this.setPaddingLeft(_get_10);
                    final Iterable<NumberValue> _converted_values_14 = (Iterable<NumberValue>)values;
                    NumberValue _get_11 = ((NumberValue[])Conversions.unwrapArray(_converted_values_14, NumberValue.class))[1];
                    this.setPaddingRight(_get_11);
                } else {
                    final Iterable<NumberValue> _converted_values_15 = (Iterable<NumberValue>)values;
                    int _length_3 = ((Object[])Conversions.unwrapArray(_converted_values_15, Object.class)).length;
                    boolean _equals_3 = (_length_3 == 4);
                    if (_equals_3) {
                        final Iterable<NumberValue> _converted_values_16 = (Iterable<NumberValue>)values;
                        NumberValue _get_12 = ((NumberValue[])Conversions.unwrapArray(_converted_values_16, NumberValue.class))[0];
                        this.setPaddingTop(_get_12);
                        final Iterable<NumberValue> _converted_values_17 = (Iterable<NumberValue>)values;
                        NumberValue _get_13 = ((NumberValue[])Conversions.unwrapArray(_converted_values_17, NumberValue.class))[2];
                        this.setPaddingRight(_get_13);
                        final Iterable<NumberValue> _converted_values_18 = (Iterable<NumberValue>)values;
                        NumberValue _get_14 = ((NumberValue[])Conversions.unwrapArray(_converted_values_18, NumberValue.class))[3];
                        this.setPaddingBottom(_get_14);
                        final Iterable<NumberValue> _converted_values_19 = (Iterable<NumberValue>)values;
                        NumberValue _get_15 = ((NumberValue[])Conversions.unwrapArray(_converted_values_19, NumberValue.class))[4];
                        this.setPaddingLeft(_get_15);
                    }
                }
            }
        }
    }

    public void setBackgroundFilter(final Object filterColor, final String filterType) {
        boolean _notEquals = (!Objects.equal(filterColor, null));
        if (_notEquals) {
            this.setBackgroundFilterColor(filterColor);
        }
        boolean _notEquals_1 = (!Objects.equal(filterType, null));
        if (_notEquals_1) {
            this.setBackgroundFilterType(filterType);
        }
    }

    public int gravityFromString(final String gravity) {
        String[] _split = gravity.split(",");
        final Function1<String, Integer> _function = new Function1<String, Integer>() {
            @Override
            public Integer apply(final String it) {
                int _switchResult = (int) 0;
                String _lowerCase = it.toLowerCase();
                String _trim = _lowerCase.trim();
                switch (_trim) {
                    case "top":
                        _switchResult = Gravity.TOP;
                        break;
                    case "bottom":
                        _switchResult = Gravity.BOTTOM;
                        break;
                    case "left":
                        _switchResult = Gravity.LEFT;
                        break;
                    case "right":
                        _switchResult = Gravity.RIGHT;
                        break;
                    case "center_vertical":
                        _switchResult = Gravity.CENTER_VERTICAL;
                        break;
                    case "center_horizontal":
                        _switchResult = Gravity.CENTER_HORIZONTAL;
                        break;
                    case "fill_vertical":
                        _switchResult = Gravity.FILL_VERTICAL;
                        break;
                    case "fill_horizontal":
                        _switchResult = Gravity.FILL_HORIZONTAL;
                        break;
                    case "center":
                        _switchResult = Gravity.CENTER;
                        break;
                    case "clip_vertical":
                        _switchResult = Gravity.CLIP_VERTICAL;
                        break;
                    case "clip_horizontal":
                        _switchResult = Gravity.CLIP_HORIZONTAL;
                        break;
                    case "start":
                        _switchResult = Gravity.START;
                        break;
                    case "end":
                        _switchResult = Gravity.END;
                        break;
                    default:
                        _switchResult = 0;
                        break;
                }
                return Integer.valueOf(_switchResult);
            }
        };
        List<Integer> _map = ListExtensions.<String, Integer>map(((List<String>)Conversions.doWrapArray(_split)), _function);
        final Function2<Integer, Integer, Integer> _function_1 = new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer apply(final Integer g, final Integer i) {
                return Integer.valueOf(((g).intValue() | (i).intValue()));
            }
        };
        return (int) IterableExtensions.<Integer>reduce(_map, _function_1);
    }

    public void updateDrawables(final NativeView view) {
        boolean _equals = Objects.equal(this.backgroundGradientDrawable, null);
        if (_equals) {
            GradientDrawable _gradientDrawable = new GradientDrawable();
            this.backgroundGradientDrawable = _gradientDrawable;
        }
        Object _backgroundColor = this.getBackgroundColor();
        int _asColor = Style.asColor(_backgroundColor);
        Object _backgroundColor_1 = this.getBackgroundColor();
        int _asColor_1 = Style.asColor(_backgroundColor_1);
        this.backgroundGradientDrawable.setColors(new int[] { _asColor, _asColor_1 });
        float[] _cornerRadii = this.getCornerRadii(view);
        this.backgroundGradientDrawable.setCornerRadii(_cornerRadii);
        boolean _and = false;
        String _backgroundDrawable = this.getBackgroundDrawable();
        boolean _notEquals = (!Objects.equal(_backgroundDrawable, null));
        if (!_notEquals) {
            _and = false;
        } else {
            String _backgroundDrawable_1 = this.getBackgroundDrawable();
            boolean _notEquals_1 = (!Objects.equal(_backgroundDrawable_1, ""));
            _and = _notEquals_1;
        }
        if (_and) {
            View _androidView = view.getAndroidView();
            Context _context = _androidView.getContext();
            Resources _resources = _context.getResources();
            String _backgroundDrawable_2 = this.getBackgroundDrawable();
            View _androidView_1 = view.getAndroidView();
            Context _context_1 = _androidView_1.getContext();
            String _packageName = _context_1.getPackageName();
            int drawableResourceId = _resources.getIdentifier(_backgroundDrawable_2, "drawable", _packageName);
            View _androidView_2 = view.getAndroidView();
            Context _context_2 = _androidView_2.getContext();
            Resources _resources_1 = _context_2.getResources();
            Drawable _drawable = _resources_1.getDrawable(drawableResourceId);
            Drawable _mutate = _drawable.mutate();
            this.backgroundImageDrawable = _mutate;
            if ((this.backgroundImageDrawable instanceof BitmapDrawable)) {
                final BitmapDrawable bg = ((BitmapDrawable) this.backgroundImageDrawable);
                boolean _and_1 = false;
                Object _backgroundFilterColor = this.getBackgroundFilterColor();
                boolean _notEquals_2 = (!Objects.equal(_backgroundFilterColor, null));
                if (!_notEquals_2) {
                    _and_1 = false;
                } else {
                    Object _backgroundFilterColor_1 = this.getBackgroundFilterColor();
                    int _asColor_2 = Style.asColor(_backgroundFilterColor_1);
                    boolean _notEquals_3 = (_asColor_2 != Color.TRANSPARENT);
                    _and_1 = _notEquals_3;
                }
                if (_and_1) {
                    Object _backgroundFilterColor_2 = this.getBackgroundFilterColor();
                    int _asColor_3 = Style.asColor(_backgroundFilterColor_2);
                    String _backgroundFilterType = this.getBackgroundFilterType();
                    String _upperCase = _backgroundFilterType.toUpperCase();
                    PorterDuff.Mode _valueOf = PorterDuff.Mode.valueOf(_upperCase);
                    bg.setColorFilter(_asColor_3, _valueOf);
                } else {
                    bg.setColorFilter(null);
                }
                String _backgroundGravity = this.getBackgroundGravity();
                boolean _notEquals_4 = (!Objects.equal(_backgroundGravity, null));
                if (_notEquals_4) {
                    String _backgroundGravity_1 = this.getBackgroundGravity();
                    int _gravityFromString = this.gravityFromString(_backgroundGravity_1);
                    bg.setGravity(_gravityFromString);
                }
                String _backgroundRepeat = this.getBackgroundRepeat();
                boolean _notEquals_5 = (!Objects.equal(_backgroundRepeat, null));
                if (_notEquals_5) {
                    bg.setTileModeY(null);
                    bg.setTileModeX(null);
                    String _backgroundRepeat_1 = this.getBackgroundRepeat();
                    String[] _split = _backgroundRepeat_1.split(" ");
                    final Procedure1<String> _function = new Procedure1<String>() {
                        @Override
                        public void apply(final String it) {
                            boolean _equals = Objects.equal(it, "repeat-x");
                            if (_equals) {
                                bg.setTileModeX(Shader.TileMode.REPEAT);
                            } else {
                                boolean _equals_1 = Objects.equal(it, "mirror-x");
                                if (_equals_1) {
                                    bg.setTileModeX(Shader.TileMode.MIRROR);
                                } else {
                                    boolean _equals_2 = Objects.equal(it, "clamp-x");
                                    if (_equals_2) {
                                        bg.setTileModeX(Shader.TileMode.CLAMP);
                                    } else {
                                        boolean _equals_3 = Objects.equal(it, "no-repeat-x");
                                        if (_equals_3) {
                                            bg.setTileModeX(null);
                                        }
                                    }
                                }
                            }
                            boolean _equals_4 = Objects.equal(it, "repeat-y");
                            if (_equals_4) {
                                bg.setTileModeY(Shader.TileMode.REPEAT);
                            } else {
                                boolean _equals_5 = Objects.equal(it, "mirror-y");
                                if (_equals_5) {
                                    bg.setTileModeY(Shader.TileMode.MIRROR);
                                } else {
                                    boolean _equals_6 = Objects.equal(it, "clamp-y");
                                    if (_equals_6) {
                                        bg.setTileModeY(Shader.TileMode.CLAMP);
                                    } else {
                                        boolean _equals_7 = Objects.equal(it, "no-repeat-y");
                                        if (_equals_7) {
                                            bg.setTileModeY(null);
                                        }
                                    }
                                }
                            }
                        }
                    };
                    IterableExtensions.<String>forEach(((Iterable<String>)Conversions.doWrapArray(_split)), _function);
                }
            }
        } else {
            ColorDrawable _colorDrawable = new ColorDrawable(Color.TRANSPARENT);
            this.backgroundImageDrawable = _colorDrawable;
        }
        boolean _equals_1 = Objects.equal(this.borderDrawable, null);
        if (_equals_1) {
            BorderDrawable _borderDrawable = new BorderDrawable();
            this.borderDrawable = _borderDrawable;
        }
        NumberValue _borderTopWidth = this.getBorderTopWidth();
        View _androidView_3 = view.getAndroidView();
        Context _context_3 = _androidView_3.getContext();
        Float _inPixels = _borderTopWidth.inPixels(_context_3);
        this.borderDrawable.setTopBorderWidth((_inPixels).floatValue());
        NumberValue _borderBottomWidth = this.getBorderBottomWidth();
        View _androidView_4 = view.getAndroidView();
        Context _context_4 = _androidView_4.getContext();
        Float _inPixels_1 = _borderBottomWidth.inPixels(_context_4);
        this.borderDrawable.setBottomBorderWidth((_inPixels_1).floatValue());
        NumberValue _borderLeftWidth = this.getBorderLeftWidth();
        View _androidView_5 = view.getAndroidView();
        Context _context_5 = _androidView_5.getContext();
        Float _inPixels_2 = _borderLeftWidth.inPixels(_context_5);
        this.borderDrawable.setLeftBorderWidth((_inPixels_2).floatValue());
        NumberValue _borderRightWidth = this.getBorderRightWidth();
        View _androidView_6 = view.getAndroidView();
        Context _context_6 = _androidView_6.getContext();
        Float _inPixels_3 = _borderRightWidth.inPixels(_context_6);
        this.borderDrawable.setRightBorderWidth((_inPixels_3).floatValue());
        NumberValue _borderTopRightRadiusH = this.getBorderTopRightRadiusH();
        View _androidView_7 = view.getAndroidView();
        Context _context_7 = _androidView_7.getContext();
        Float _inPixels_4 = _borderTopRightRadiusH.inPixels(_context_7);
        this.borderDrawable.setTopRightRadiusH((_inPixels_4).floatValue());
        NumberValue _borderTopRightRadiusV = this.getBorderTopRightRadiusV();
        View _androidView_8 = view.getAndroidView();
        Context _context_8 = _androidView_8.getContext();
        Float _inPixels_5 = _borderTopRightRadiusV.inPixels(_context_8);
        this.borderDrawable.setTopRightRadiusV((_inPixels_5).floatValue());
        NumberValue _borderTopLeftRadiusH = this.getBorderTopLeftRadiusH();
        View _androidView_9 = view.getAndroidView();
        Context _context_9 = _androidView_9.getContext();
        Float _inPixels_6 = _borderTopLeftRadiusH.inPixels(_context_9);
        this.borderDrawable.setTopLeftRadiusH((_inPixels_6).floatValue());
        NumberValue _borderTopLeftRadiusV = this.getBorderTopLeftRadiusV();
        View _androidView_10 = view.getAndroidView();
        Context _context_10 = _androidView_10.getContext();
        Float _inPixels_7 = _borderTopLeftRadiusV.inPixels(_context_10);
        this.borderDrawable.setTopLeftRadiusV((_inPixels_7).floatValue());
        NumberValue _borderBottomLeftRadiusH = this.getBorderBottomLeftRadiusH();
        View _androidView_11 = view.getAndroidView();
        Context _context_11 = _androidView_11.getContext();
        Float _inPixels_8 = _borderBottomLeftRadiusH.inPixels(_context_11);
        this.borderDrawable.setBottomLeftRadiusH((_inPixels_8).floatValue());
        NumberValue _borderBottomLeftRadiusV = this.getBorderBottomLeftRadiusV();
        View _androidView_12 = view.getAndroidView();
        Context _context_12 = _androidView_12.getContext();
        Float _inPixels_9 = _borderBottomLeftRadiusV.inPixels(_context_12);
        this.borderDrawable.setBottomLeftRadiusV((_inPixels_9).floatValue());
        NumberValue _borderBottomRightRadiusH = this.getBorderBottomRightRadiusH();
        View _androidView_13 = view.getAndroidView();
        Context _context_13 = _androidView_13.getContext();
        Float _inPixels_10 = _borderBottomRightRadiusH.inPixels(_context_13);
        this.borderDrawable.setBottomRightRadiusH((_inPixels_10).floatValue());
        NumberValue _borderBottomRightRadiusV = this.getBorderBottomRightRadiusV();
        View _androidView_14 = view.getAndroidView();
        Context _context_14 = _androidView_14.getContext();
        Float _inPixels_11 = _borderBottomRightRadiusV.inPixels(_context_14);
        this.borderDrawable.setBottomRightRadiusV((_inPixels_11).floatValue());
        Object _borderTopColor = this.getBorderTopColor();
        int _asColor_4 = Style.asColor(_borderTopColor);
        this.borderDrawable.setTopBorderColor(_asColor_4);
        Object _borderBottomColor = this.getBorderBottomColor();
        int _asColor_5 = Style.asColor(_borderBottomColor);
        this.borderDrawable.setBottomBorderColor(_asColor_5);
        Object _borderLeftColor = this.getBorderLeftColor();
        int _asColor_6 = Style.asColor(_borderLeftColor);
        this.borderDrawable.setLeftBorderColor(_asColor_6);
        Object _borderRightColor = this.getBorderRightColor();
        int _asColor_7 = Style.asColor(_borderRightColor);
        this.borderDrawable.setRightBorderColor(_asColor_7);
    }

    public boolean applyDrawableStyle(final NativeView view) {
        boolean _xblockexpression = false;
        {
            this.updateDrawables(view);
            view.getBackgroundDrawable().setDrawableByLayerId(0, this.backgroundGradientDrawable);
            view.getBackgroundDrawable().setDrawableByLayerId(1, this.backgroundImageDrawable);
            _xblockexpression = view.getBackgroundDrawable().setDrawableByLayerId(2, this.borderDrawable);
        }
        return _xblockexpression;
    }

    public float[] getCornerRadii(final NativeView latteView) {
        NumberValue _borderTopLeftRadiusH = this.getBorderTopLeftRadiusH();
        View _androidView = latteView.getAndroidView();
        Context _context = _androidView.getContext();
        Float topLeft = _borderTopLeftRadiusH.inPixels(_context);
        NumberValue _borderTopRightRadiusH = this.getBorderTopRightRadiusH();
        View _androidView_1 = latteView.getAndroidView();
        Context _context_1 = _androidView_1.getContext();
        Float topRight = _borderTopRightRadiusH.inPixels(_context_1);
        NumberValue _borderBottomLeftRadiusH = this.getBorderBottomLeftRadiusH();
        View _androidView_2 = latteView.getAndroidView();
        Context _context_2 = _androidView_2.getContext();
        Float bottomLeft = _borderBottomLeftRadiusH.inPixels(_context_2);
        NumberValue _borderBottomLeftRadiusH_1 = this.getBorderBottomLeftRadiusH();
        View _androidView_3 = latteView.getAndroidView();
        Context _context_3 = _androidView_3.getContext();
        Float bottomRight = _borderBottomLeftRadiusH_1.inPixels(_context_3);
        return new float[] { (topLeft).floatValue(), (topLeft).floatValue(), (topRight).floatValue(), (topRight).floatValue(), (bottomRight).floatValue(), (bottomRight).floatValue(), (bottomLeft).floatValue(), (bottomLeft).floatValue() };
    }

    public RoundRectShape getShape(final NativeView latteView) {
        float[] _cornerRadii = this.getCornerRadii(latteView);
        return new RoundRectShape(_cornerRadii, null, null);
    }

    public boolean isDrawableProperty(final String propertyName) {
        return Style.DRAWABLE_PROPS.contains(propertyName);
    }

    public void applyToView(final NativeView latteView, final String... properties) {
        View _androidView = latteView.getAndroidView();
        boolean _equals = Objects.equal(_androidView, null);
        if (_equals) {
            return;
        }
        View _androidView_1 = latteView.getAndroidView();
        Context _context = _androidView_1.getContext();
        Style.initFonts(_context);
        boolean applyAll = ((List<String>)Conversions.doWrapArray(properties)).isEmpty();
        View androidView = latteView.getAndroidView();
        boolean _and = false;
        boolean _or = false;
        if (applyAll) {
            _or = true;
        } else {
            boolean _contains = ((List<String>)Conversions.doWrapArray(properties)).contains("elevation");
            _or = _contains;
        }
        if (!_or) {
            _and = false;
        } else {
            _and = (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP);
        }
        if (_and) {
            NumberValue _elevation = this.getElevation();
            Context _context_1 = androidView.getContext();
            Float _inPixels = _elevation.inPixels(_context_1);
            androidView.setElevation((_inPixels).floatValue());
        }
        boolean _or_1 = false;
        if (applyAll) {
            _or_1 = true;
        } else {
            final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
                @Override
                public Boolean apply(final String it) {
                    return Boolean.valueOf(Style.this.isDrawableProperty(it));
                }
            };
            String _findFirst = IterableExtensions.<String>findFirst(((Iterable<String>)Conversions.doWrapArray(properties)), _function);
            boolean _notEquals = (!Objects.equal(_findFirst, null));
            _or_1 = _notEquals;
        }
        if (_or_1) {
            this.applyDrawableStyle(latteView);
        }
        boolean _or_2 = false;
        if (applyAll) {
            _or_2 = true;
        } else {
            boolean _contains_1 = ((List<String>)Conversions.doWrapArray(properties)).contains("translationY");
            _or_2 = _contains_1;
        }
        if (_or_2) {
            NumberValue _translationY = this.getTranslationY();
            Context _context_2 = androidView.getContext();
            Float _inPixels_1 = _translationY.inPixels(_context_2);
            androidView.setTranslationY((_inPixels_1).floatValue());
        }
        boolean _or_3 = false;
        if (applyAll) {
            _or_3 = true;
        } else {
            boolean _contains_2 = ((List<String>)Conversions.doWrapArray(properties)).contains("translationX");
            _or_3 = _contains_2;
        }
        if (_or_3) {
            NumberValue _translationX = this.getTranslationX();
            Context _context_3 = androidView.getContext();
            Float _inPixels_2 = _translationX.inPixels(_context_3);
            androidView.setTranslationX((_inPixels_2).floatValue());
        }
        boolean _and_1 = false;
        boolean _or_4 = false;
        if (applyAll) {
            _or_4 = true;
        } else {
            boolean _contains_3 = ((List<String>)Conversions.doWrapArray(properties)).contains("x");
            _or_4 = _contains_3;
        }
        if (!_or_4) {
            _and_1 = false;
        } else {
            NumberValue _x = this.getX();
            boolean _notEquals_1 = (!Objects.equal(_x, null));
            _and_1 = _notEquals_1;
        }
        if (_and_1) {
            NumberValue _x_1 = this.getX();
            Context _context_4 = androidView.getContext();
            Float _inPixels_3 = _x_1.inPixels(_context_4);
            androidView.setX((_inPixels_3).floatValue());
        }
        boolean _and_2 = false;
        boolean _or_5 = false;
        if (applyAll) {
            _or_5 = true;
        } else {
            boolean _contains_4 = ((List<String>)Conversions.doWrapArray(properties)).contains("y");
            _or_5 = _contains_4;
        }
        if (!_or_5) {
            _and_2 = false;
        } else {
            NumberValue _y = this.getY();
            boolean _notEquals_2 = (!Objects.equal(_y, null));
            _and_2 = _notEquals_2;
        }
        if (_and_2) {
            NumberValue _y_1 = this.getY();
            Context _context_5 = androidView.getContext();
            Float _inPixels_4 = _y_1.inPixels(_context_5);
            androidView.setY((_inPixels_4).floatValue());
        }
        boolean _or_6 = false;
        if (applyAll) {
            _or_6 = true;
        } else {
            final Function1<String, Boolean> _function_1 = new Function1<String, Boolean>() {
                @Override
                public Boolean apply(final String it) {
                    int _indexOf = it.indexOf("padding");
                    return Boolean.valueOf((_indexOf != (-1)));
                }
            };
            Iterable<String> _filter = IterableExtensions.<String>filter(((Iterable<String>)Conversions.doWrapArray(properties)), _function_1);
            boolean _isEmpty = IterableExtensions.isEmpty(_filter);
            boolean _not = (!_isEmpty);
            _or_6 = _not;
        }
        if (_or_6) {
            NumberValue _paddingLeft = this.getPaddingLeft();
            Context _context_6 = androidView.getContext();
            int _inPixelsInt = _paddingLeft.inPixelsInt(_context_6);
            NumberValue _borderLeftWidth = this.getBorderLeftWidth();
            Context _context_7 = androidView.getContext();
            int _inPixelsInt_1 = _borderLeftWidth.inPixelsInt(_context_7);
            int pLeft = (_inPixelsInt + _inPixelsInt_1);
            NumberValue _paddingRight = this.getPaddingRight();
            Context _context_8 = androidView.getContext();
            int _inPixelsInt_2 = _paddingRight.inPixelsInt(_context_8);
            NumberValue _borderRightWidth = this.getBorderRightWidth();
            Context _context_9 = androidView.getContext();
            int _inPixelsInt_3 = _borderRightWidth.inPixelsInt(_context_9);
            int pRight = (_inPixelsInt_2 + _inPixelsInt_3);
            NumberValue _paddingTop = this.getPaddingTop();
            Context _context_10 = androidView.getContext();
            int _inPixelsInt_4 = _paddingTop.inPixelsInt(_context_10);
            NumberValue _borderTopWidth = this.getBorderTopWidth();
            Context _context_11 = androidView.getContext();
            int _inPixelsInt_5 = _borderTopWidth.inPixelsInt(_context_11);
            int pTop = (_inPixelsInt_4 + _inPixelsInt_5);
            NumberValue _paddingBottom = this.getPaddingBottom();
            Context _context_12 = androidView.getContext();
            int _inPixelsInt_6 = _paddingBottom.inPixelsInt(_context_12);
            NumberValue _borderBottomWidth = this.getBorderBottomWidth();
            Context _context_13 = androidView.getContext();
            int _inPixelsInt_7 = _borderBottomWidth.inPixelsInt(_context_13);
            int pBottom = (_inPixelsInt_6 + _inPixelsInt_7);
            androidView.setPadding(pLeft, pTop, pRight, pBottom);
        }
        if ((androidView instanceof TextView)) {
            boolean _or_7 = false;
            if (applyAll) {
                _or_7 = true;
            } else {
                boolean _contains_5 = ((List<String>)Conversions.doWrapArray(properties)).contains("textColor");
                _or_7 = _contains_5;
            }
            if (_or_7) {
                Object _textColor = this.getTextColor();
                int _asColor = Style.asColor(_textColor);
                ((TextView)androidView).setTextColor(_asColor);
            }
            boolean _and_3 = false;
            boolean _or_8 = false;
            if (applyAll) {
                _or_8 = true;
            } else {
                boolean _contains_6 = ((List<String>)Conversions.doWrapArray(properties)).contains("fontSize");
                _or_8 = _contains_6;
            }
            if (!_or_8) {
                _and_3 = false;
            } else {
                NumberValue _fontSize = this.getFontSize();
                boolean _notEquals_3 = (!Objects.equal(_fontSize, null));
                _and_3 = _notEquals_3;
            }
            if (_and_3) {
                NumberValue _fontSize_1 = this.getFontSize();
                Context _context_14 = ((TextView)androidView).getContext();
                int _inPixelsInt_8 = _fontSize_1.inPixelsInt(_context_14);
                ((TextView)androidView).setTextSize(TypedValue.COMPLEX_UNIT_PX, _inPixelsInt_8);
            }
            boolean _and_4 = false;
            boolean _or_9 = false;
            if (applyAll) {
                _or_9 = true;
            } else {
                boolean _contains_7 = ((List<String>)Conversions.doWrapArray(properties)).contains("fontFamily");
                _or_9 = _contains_7;
            }
            if (!_or_9) {
                _and_4 = false;
            } else {
                String _fontFamily = this.getFontFamily();
                boolean _notEquals_4 = (!Objects.equal(_fontFamily, null));
                _and_4 = _notEquals_4;
            }
            if (_and_4) {
                String _fontFamily_1 = this.getFontFamily();
                boolean _equals_1 = Objects.equal(_fontFamily_1, "default");
                if (_equals_1) {
                    Typeface _xifexpression = null;
                    boolean _or_10 = false;
                    String _fontStyle = this.getFontStyle();
                    boolean _equals_2 = Objects.equal(_fontStyle, "bold");
                    if (_equals_2) {
                        _or_10 = true;
                    } else {
                        String _fontStyle_1 = this.getFontStyle();
                        boolean _equals_3 = Objects.equal(_fontStyle_1, "bold-italic");
                        _or_10 = _equals_3;
                    }
                    if (_or_10) {
                        _xifexpression = Typeface.DEFAULT_BOLD;
                    } else {
                        _xifexpression = Typeface.DEFAULT;
                    }
                    ((TextView)androidView).setTypeface(_xifexpression);
                } else {
                    String _fontFamily_2 = this.getFontFamily();
                    String _lowerCase = _fontFamily_2.toLowerCase();
                    Typeface _get = Style.allFonts.get(_lowerCase);
                    ((TextView)androidView).setTypeface(_get);
                }
            }
            boolean _and_5 = false;
            boolean _or_11 = false;
            if (applyAll) {
                _or_11 = true;
            } else {
                boolean _contains_8 = ((List<String>)Conversions.doWrapArray(properties)).contains("fontStyle");
                _or_11 = _contains_8;
            }
            if (!_or_11) {
                _and_5 = false;
            } else {
                String _fontStyle_2 = this.getFontStyle();
                boolean _notEquals_5 = (!Objects.equal(_fontStyle_2, null));
                _and_5 = _notEquals_5;
            }
            if (_and_5) {
                String _fontStyle_3 = this.getFontStyle();
                boolean _equals_4 = Objects.equal(_fontStyle_3, "bold");
                if (_equals_4) {
                    Typeface _typeface = ((TextView)androidView).getTypeface();
                    ((TextView)androidView).setTypeface(_typeface, Typeface.BOLD);
                } else {
                    String _fontStyle_4 = this.getFontStyle();
                    boolean _equals_5 = Objects.equal(_fontStyle_4, "bold-italic");
                    if (_equals_5) {
                        Typeface _typeface_1 = ((TextView)androidView).getTypeface();
                        ((TextView)androidView).setTypeface(_typeface_1, Typeface.BOLD_ITALIC);
                    } else {
                        String _fontStyle_5 = this.getFontStyle();
                        boolean _equals_6 = Objects.equal(_fontStyle_5, "italic");
                        if (_equals_6) {
                            Typeface _typeface_2 = ((TextView)androidView).getTypeface();
                            ((TextView)androidView).setTypeface(_typeface_2, Typeface.ITALIC);
                        } else {
                            Typeface _typeface_3 = ((TextView)androidView).getTypeface();
                            ((TextView)androidView).setTypeface(_typeface_3, Typeface.NORMAL);
                        }
                    }
                }
            }
        }
        ViewGroup.LayoutParams lp = androidView.getLayoutParams();
        boolean lpChanged = false;
        boolean _or_12 = false;
        if (applyAll) {
            _or_12 = true;
        } else {
            boolean _contains_9 = ((List<String>)Conversions.doWrapArray(properties)).contains("width");
            _or_12 = _contains_9;
        }
        if (_or_12) {
            NumberValue _width = this.getWidth();
            Context _context_15 = androidView.getContext();
            int _inPixelsInt_9 = _width.inPixelsInt(_context_15);
            lp.width = _inPixelsInt_9;
            lpChanged = true;
        }
        boolean _or_13 = false;
        if (applyAll) {
            _or_13 = true;
        } else {
            boolean _contains_10 = ((List<String>)Conversions.doWrapArray(properties)).contains("height");
            _or_13 = _contains_10;
        }
        if (_or_13) {
            NumberValue _height = this.getHeight();
            Context _context_16 = androidView.getContext();
            int _inPixelsInt_10 = _height.inPixelsInt(_context_16);
            lp.height = _inPixelsInt_10;
            lpChanged = true;
        }
        boolean _or_14 = false;
        if (applyAll) {
            _or_14 = true;
        } else {
            final Function1<String, Boolean> _function_2 = new Function1<String, Boolean>() {
                @Override
                public Boolean apply(final String it) {
                    int _indexOf = it.indexOf("margin");
                    return Boolean.valueOf((_indexOf != (-1)));
                }
            };
            Iterable<String> _filter_1 = IterableExtensions.<String>filter(((Iterable<String>)Conversions.doWrapArray(properties)), _function_2);
            boolean _isEmpty_1 = IterableExtensions.isEmpty(_filter_1);
            boolean _not_1 = (!_isEmpty_1);
            _or_14 = _not_1;
        }
        if (_or_14) {
            if ((lp instanceof ViewGroup.MarginLayoutParams)) {
                lpChanged = true;
                NumberValue _marginLeft = this.getMarginLeft();
                boolean _notEquals_6 = (!Objects.equal(_marginLeft, null));
                if (_notEquals_6) {
                    NumberValue _marginLeft_1 = this.getMarginLeft();
                    Context _context_17 = androidView.getContext();
                    int _inPixelsInt_11 = _marginLeft_1.inPixelsInt(_context_17);
                    ((ViewGroup.MarginLayoutParams)lp).leftMargin = _inPixelsInt_11;
                }
                NumberValue _marginRight = this.getMarginRight();
                boolean _notEquals_7 = (!Objects.equal(_marginRight, null));
                if (_notEquals_7) {
                    NumberValue _marginRight_1 = this.getMarginRight();
                    Context _context_18 = androidView.getContext();
                    int _inPixelsInt_12 = _marginRight_1.inPixelsInt(_context_18);
                    ((ViewGroup.MarginLayoutParams)lp).rightMargin = _inPixelsInt_12;
                }
                NumberValue _marginBottom = this.getMarginBottom();
                boolean _notEquals_8 = (!Objects.equal(_marginBottom, null));
                if (_notEquals_8) {
                    NumberValue _marginBottom_1 = this.getMarginBottom();
                    Context _context_19 = androidView.getContext();
                    int _inPixelsInt_13 = _marginBottom_1.inPixelsInt(_context_19);
                    ((ViewGroup.MarginLayoutParams)lp).bottomMargin = _inPixelsInt_13;
                }
                NumberValue _marginTop = this.getMarginTop();
                boolean _notEquals_9 = (!Objects.equal(_marginTop, null));
                if (_notEquals_9) {
                    NumberValue _marginTop_1 = this.getMarginTop();
                    Context _context_20 = androidView.getContext();
                    int _inPixelsInt_14 = _marginTop_1.inPixelsInt(_context_20);
                    ((ViewGroup.MarginLayoutParams)lp).topMargin = _inPixelsInt_14;
                }
            }
        }
        if (lpChanged) {
            androidView.setLayoutParams(lp);
        }
    }

    @Override
    public boolean equals(final Object other) {
        return super.equals(other);
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
    public String getDefinedSelector() {
        return this.definedSelector;
    }

    public void setDefinedSelector(final String definedSelector) {
        this.definedSelector = definedSelector;
    }

    @Pure
    public Map<String, Style> getDescendantStyles() {
        return this.descendantStyles;
    }

    public void setDescendantStyles(final Map<String, Style> descendantStyles) {
        this.descendantStyles = descendantStyles;
    }

    @Pure
    public Map<String, Style> getDirectChildrenStyles() {
        return this.directChildrenStyles;
    }

    public void setDirectChildrenStyles(final Map<String, Style> directChildrenStyles) {
        this.directChildrenStyles = directChildrenStyles;
    }

    @Pure
    public Map<String, Style> getSiblingStyles() {
        return this.siblingStyles;
    }

    public void setSiblingStyles(final Map<String, Style> siblingStyles) {
        this.siblingStyles = siblingStyles;
    }

    @Pure
    public Style getParentStyle() {
        return this.parentStyle;
    }

    public void setParentStyle(final Style parentStyle) {
        this.parentStyle = parentStyle;
    }

    public List<String> PROPERTIES = java.util.Collections.<String>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<String>newArrayList("backgroundColor","rippleColor","textColor","backgroundDrawable","backgroundRepeat","backgroundGravity","backgroundFilterColor","backgroundFilterType","borderLeftColor","borderTopColor","borderRightColor","borderBottomColor","borderTopLeftRadiusH","borderTopRightRadiusH","borderBottomLeftRadiusH","borderBottomRightRadiusH","borderTopLeftRadiusV","borderTopRightRadiusV","borderBottomLeftRadiusV","borderBottomRightRadiusV","borderLeftWidth","borderTopWidth","borderRightWidth","borderBottomWidth","marginTop","marginBottom","marginLeft","marginRight","elevation","translationY","translationX","x","y","paddingTop","paddingBottom","paddingLeft","paddingRight","fontFamily","fontStyle","fontSize","transition","width","height"));

    private List<String> UNANIMATED_PROPERTIES = java.util.Collections.<String>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<String>newArrayList("backgroundDrawable","backgroundRepeat","backgroundGravity","backgroundFilterType","fontFamily","fontStyle","transition"));

    public Set<String> expandShorthands(final Set<String> currentList) {
        final Set<String> expandedProperties = new java.util.HashSet<String>();
        for (String prop: currentList) {
            if ("border".equals(prop)) {
                expandedProperties.add("borderLeftColor");
                expandedProperties.add("borderTopColor");
                expandedProperties.add("borderRightColor");
                expandedProperties.add("borderBottomColor");
                expandedProperties.add("borderLeftWidth");
                expandedProperties.add("borderTopWidth");
                expandedProperties.add("borderRightWidth");
                expandedProperties.add("borderBottomWidth");
                ;
            } else  if ("padding".equals(prop)) {
                expandedProperties.add("paddingTop");
                expandedProperties.add("paddingBottom");
                expandedProperties.add("paddingLeft");
                expandedProperties.add("paddingRight");
                ;
            } else  if ("margin".equals(prop)) {
                expandedProperties.add("marginTop");
                expandedProperties.add("marginBottom");
                expandedProperties.add("marginLeft");
                expandedProperties.add("marginRight");
                ;
            } else  if ("borderTop".equals(prop)) {
                expandedProperties.add("borderTopColor");
                expandedProperties.add("borderTopWidth");
                ;
            } else  if ("borderTopLeftRadius".equals(prop)) {
                expandedProperties.add("borderTopLeftRadiusH");
                expandedProperties.add("borderTopLeftRadiusV");
                ;
            } else  if ("borderLeft".equals(prop)) {
                expandedProperties.add("borderLeftColor");
                expandedProperties.add("borderLeftWidth");
                ;
            } else  if ("borderRadius".equals(prop)) {
                expandedProperties.add("borderTopLeftRadiusH");
                expandedProperties.add("borderTopRightRadiusH");
                expandedProperties.add("borderBottomLeftRadiusH");
                expandedProperties.add("borderBottomRightRadiusH");
                expandedProperties.add("borderTopLeftRadiusV");
                expandedProperties.add("borderTopRightRadiusV");
                expandedProperties.add("borderBottomLeftRadiusV");
                expandedProperties.add("borderBottomRightRadiusV");
                ;
            } else  if ("borderBottomLeftRadius".equals(prop)) {
                expandedProperties.add("borderBottomLeftRadiusH");
                expandedProperties.add("borderBottomLeftRadiusV");
                ;
            } else  if ("backgroundFilter".equals(prop)) {
                expandedProperties.add("backgroundFilterColor");
                expandedProperties.add("backgroundFilterType");
                ;
            } else  if ("borderRight".equals(prop)) {
                expandedProperties.add("borderRightColor");
                expandedProperties.add("borderRightWidth");
                ;
            } else  if ("borderWidth".equals(prop)) {
                expandedProperties.add("borderLeftWidth");
                expandedProperties.add("borderTopWidth");
                expandedProperties.add("borderRightWidth");
                expandedProperties.add("borderBottomWidth");
                ;
            } else  if ("borderBottomRightRadius".equals(prop)) {
                expandedProperties.add("borderBottomRightRadiusH");
                expandedProperties.add("borderBottomRightRadiusV");
                ;
            } else  if ("borderTopRightRadius".equals(prop)) {
                expandedProperties.add("borderTopRightRadiusH");
                expandedProperties.add("borderTopRightRadiusV");
                ;
            } else  if ("borderBottom".equals(prop)) {
                expandedProperties.add("borderBottomColor");
                expandedProperties.add("borderBottomWidth");
                ;
            } else  {
                expandedProperties.add(prop);
            }
        }
        return expandedProperties;
    }

    public void overrideWithStyle(final Style overridingStyle) {
        if (overridingStyle._backgroundColor != null) {
            _backgroundColor = overridingStyle._backgroundColor;
        }
        if (overridingStyle._rippleColor != null) {
            _rippleColor = overridingStyle._rippleColor;
        }
        if (overridingStyle._textColor != null) {
            _textColor = overridingStyle._textColor;
        }
        if (overridingStyle._backgroundDrawable != null) {
            _backgroundDrawable = overridingStyle._backgroundDrawable;
        }
        if (overridingStyle._backgroundRepeat != null) {
            _backgroundRepeat = overridingStyle._backgroundRepeat;
        }
        if (overridingStyle._backgroundGravity != null) {
            _backgroundGravity = overridingStyle._backgroundGravity;
        }
        if (overridingStyle._backgroundFilterColor != null) {
            _backgroundFilterColor = overridingStyle._backgroundFilterColor;
        }
        if (overridingStyle._backgroundFilterType != null) {
            _backgroundFilterType = overridingStyle._backgroundFilterType;
        }
        if (overridingStyle._borderLeftColor != null) {
            _borderLeftColor = overridingStyle._borderLeftColor;
        }
        if (overridingStyle._borderTopColor != null) {
            _borderTopColor = overridingStyle._borderTopColor;
        }
        if (overridingStyle._borderRightColor != null) {
            _borderRightColor = overridingStyle._borderRightColor;
        }
        if (overridingStyle._borderBottomColor != null) {
            _borderBottomColor = overridingStyle._borderBottomColor;
        }
        if (overridingStyle._borderTopLeftRadiusH != null) {
            _borderTopLeftRadiusH = overridingStyle._borderTopLeftRadiusH;
        }
        if (overridingStyle._borderTopRightRadiusH != null) {
            _borderTopRightRadiusH = overridingStyle._borderTopRightRadiusH;
        }
        if (overridingStyle._borderBottomLeftRadiusH != null) {
            _borderBottomLeftRadiusH = overridingStyle._borderBottomLeftRadiusH;
        }
        if (overridingStyle._borderBottomRightRadiusH != null) {
            _borderBottomRightRadiusH = overridingStyle._borderBottomRightRadiusH;
        }
        if (overridingStyle._borderTopLeftRadiusV != null) {
            _borderTopLeftRadiusV = overridingStyle._borderTopLeftRadiusV;
        }
        if (overridingStyle._borderTopRightRadiusV != null) {
            _borderTopRightRadiusV = overridingStyle._borderTopRightRadiusV;
        }
        if (overridingStyle._borderBottomLeftRadiusV != null) {
            _borderBottomLeftRadiusV = overridingStyle._borderBottomLeftRadiusV;
        }
        if (overridingStyle._borderBottomRightRadiusV != null) {
            _borderBottomRightRadiusV = overridingStyle._borderBottomRightRadiusV;
        }
        if (overridingStyle._borderLeftWidth != null) {
            _borderLeftWidth = overridingStyle._borderLeftWidth;
        }
        if (overridingStyle._borderTopWidth != null) {
            _borderTopWidth = overridingStyle._borderTopWidth;
        }
        if (overridingStyle._borderRightWidth != null) {
            _borderRightWidth = overridingStyle._borderRightWidth;
        }
        if (overridingStyle._borderBottomWidth != null) {
            _borderBottomWidth = overridingStyle._borderBottomWidth;
        }
        if (overridingStyle._marginTop != null) {
            _marginTop = overridingStyle._marginTop;
        }
        if (overridingStyle._marginBottom != null) {
            _marginBottom = overridingStyle._marginBottom;
        }
        if (overridingStyle._marginLeft != null) {
            _marginLeft = overridingStyle._marginLeft;
        }
        if (overridingStyle._marginRight != null) {
            _marginRight = overridingStyle._marginRight;
        }
        if (overridingStyle._elevation != null) {
            _elevation = overridingStyle._elevation;
        }
        if (overridingStyle._translationY != null) {
            _translationY = overridingStyle._translationY;
        }
        if (overridingStyle._translationX != null) {
            _translationX = overridingStyle._translationX;
        }
        if (overridingStyle._x != null) {
            _x = overridingStyle._x;
        }
        if (overridingStyle._y != null) {
            _y = overridingStyle._y;
        }
        if (overridingStyle._paddingTop != null) {
            _paddingTop = overridingStyle._paddingTop;
        }
        if (overridingStyle._paddingBottom != null) {
            _paddingBottom = overridingStyle._paddingBottom;
        }
        if (overridingStyle._paddingLeft != null) {
            _paddingLeft = overridingStyle._paddingLeft;
        }
        if (overridingStyle._paddingRight != null) {
            _paddingRight = overridingStyle._paddingRight;
        }
        if (overridingStyle._fontFamily != null) {
            _fontFamily = overridingStyle._fontFamily;
        }
        if (overridingStyle._fontStyle != null) {
            _fontStyle = overridingStyle._fontStyle;
        }
        if (overridingStyle._fontSize != null) {
            _fontSize = overridingStyle._fontSize;
        }
        if (overridingStyle._transition != null) {
            _transition = overridingStyle._transition;
        }
        if (overridingStyle._width != null) {
            _width = overridingStyle._width;
        }
        if (overridingStyle._height != null) {
            _height = overridingStyle._height;
        }
    }

    public void cloneFrom(final Style copyStyle) {
        _backgroundColor = copyStyle._backgroundColor;
        _rippleColor = copyStyle._rippleColor;
        _textColor = copyStyle._textColor;
        _backgroundDrawable = copyStyle._backgroundDrawable;
        _backgroundRepeat = copyStyle._backgroundRepeat;
        _backgroundGravity = copyStyle._backgroundGravity;
        _backgroundFilterColor = copyStyle._backgroundFilterColor;
        _backgroundFilterType = copyStyle._backgroundFilterType;
        _borderLeftColor = copyStyle._borderLeftColor;
        _borderTopColor = copyStyle._borderTopColor;
        _borderRightColor = copyStyle._borderRightColor;
        _borderBottomColor = copyStyle._borderBottomColor;
        _borderTopLeftRadiusH = copyStyle._borderTopLeftRadiusH;
        _borderTopRightRadiusH = copyStyle._borderTopRightRadiusH;
        _borderBottomLeftRadiusH = copyStyle._borderBottomLeftRadiusH;
        _borderBottomRightRadiusH = copyStyle._borderBottomRightRadiusH;
        _borderTopLeftRadiusV = copyStyle._borderTopLeftRadiusV;
        _borderTopRightRadiusV = copyStyle._borderTopRightRadiusV;
        _borderBottomLeftRadiusV = copyStyle._borderBottomLeftRadiusV;
        _borderBottomRightRadiusV = copyStyle._borderBottomRightRadiusV;
        _borderLeftWidth = copyStyle._borderLeftWidth;
        _borderTopWidth = copyStyle._borderTopWidth;
        _borderRightWidth = copyStyle._borderRightWidth;
        _borderBottomWidth = copyStyle._borderBottomWidth;
        _marginTop = copyStyle._marginTop;
        _marginBottom = copyStyle._marginBottom;
        _marginLeft = copyStyle._marginLeft;
        _marginRight = copyStyle._marginRight;
        _elevation = copyStyle._elevation;
        _translationY = copyStyle._translationY;
        _translationX = copyStyle._translationX;
        _x = copyStyle._x;
        _y = copyStyle._y;
        _paddingTop = copyStyle._paddingTop;
        _paddingBottom = copyStyle._paddingBottom;
        _paddingLeft = copyStyle._paddingLeft;
        _paddingRight = copyStyle._paddingRight;
        _fontFamily = copyStyle._fontFamily;
        _fontStyle = copyStyle._fontStyle;
        _fontSize = copyStyle._fontSize;
        _transition = copyStyle._transition;
        _width = copyStyle._width;
        _height = copyStyle._height;
    }

    public void setProperty(final String key, final Object value) {
        String propertyName = key;
        if (!PROPERTIES.contains(key)) {
            propertyName = com.google.common.base.CaseFormat.LOWER_HYPHEN.to(com.google.common.base.CaseFormat.LOWER_CAMEL,key);
        }
        if (propertyName.equals("backgroundColor")) { setBackgroundColor((java.lang.Object)value); return; }
        if (propertyName.equals("rippleColor")) { setRippleColor((java.lang.Object)value); return; }
        if (propertyName.equals("textColor")) { setTextColor((java.lang.Object)value); return; }
        if (propertyName.equals("backgroundDrawable")) { setBackgroundDrawable((java.lang.String)value); return; }
        if (propertyName.equals("backgroundRepeat")) { setBackgroundRepeat((java.lang.String)value); return; }
        if (propertyName.equals("backgroundGravity")) { setBackgroundGravity((java.lang.String)value); return; }
        if (propertyName.equals("backgroundFilterColor")) { setBackgroundFilterColor((java.lang.Object)value); return; }
        if (propertyName.equals("backgroundFilterType")) { setBackgroundFilterType((java.lang.String)value); return; }
        if (propertyName.equals("borderLeftColor")) { setBorderLeftColor((java.lang.Object)value); return; }
        if (propertyName.equals("borderTopColor")) { setBorderTopColor((java.lang.Object)value); return; }
        if (propertyName.equals("borderRightColor")) { setBorderRightColor((java.lang.Object)value); return; }
        if (propertyName.equals("borderBottomColor")) { setBorderBottomColor((java.lang.Object)value); return; }
        if (propertyName.equals("borderTopLeftRadiusH") && value instanceof io.lattekit.ui.style.NumberValue) { setBorderTopLeftRadiusH((io.lattekit.ui.style.NumberValue)value); return; }
        if (propertyName.equals("borderTopLeftRadiusH") && value instanceof String) { setBorderTopLeftRadiusH((String)value); return; }
        if (propertyName.equals("borderTopRightRadiusH") && value instanceof io.lattekit.ui.style.NumberValue) { setBorderTopRightRadiusH((io.lattekit.ui.style.NumberValue)value); return; }
        if (propertyName.equals("borderTopRightRadiusH") && value instanceof String) { setBorderTopRightRadiusH((String)value); return; }
        if (propertyName.equals("borderBottomLeftRadiusH") && value instanceof io.lattekit.ui.style.NumberValue) { setBorderBottomLeftRadiusH((io.lattekit.ui.style.NumberValue)value); return; }
        if (propertyName.equals("borderBottomLeftRadiusH") && value instanceof String) { setBorderBottomLeftRadiusH((String)value); return; }
        if (propertyName.equals("borderBottomRightRadiusH") && value instanceof io.lattekit.ui.style.NumberValue) { setBorderBottomRightRadiusH((io.lattekit.ui.style.NumberValue)value); return; }
        if (propertyName.equals("borderBottomRightRadiusH") && value instanceof String) { setBorderBottomRightRadiusH((String)value); return; }
        if (propertyName.equals("borderTopLeftRadiusV") && value instanceof io.lattekit.ui.style.NumberValue) { setBorderTopLeftRadiusV((io.lattekit.ui.style.NumberValue)value); return; }
        if (propertyName.equals("borderTopLeftRadiusV") && value instanceof String) { setBorderTopLeftRadiusV((String)value); return; }
        if (propertyName.equals("borderTopRightRadiusV") && value instanceof io.lattekit.ui.style.NumberValue) { setBorderTopRightRadiusV((io.lattekit.ui.style.NumberValue)value); return; }
        if (propertyName.equals("borderTopRightRadiusV") && value instanceof String) { setBorderTopRightRadiusV((String)value); return; }
        if (propertyName.equals("borderBottomLeftRadiusV") && value instanceof io.lattekit.ui.style.NumberValue) { setBorderBottomLeftRadiusV((io.lattekit.ui.style.NumberValue)value); return; }
        if (propertyName.equals("borderBottomLeftRadiusV") && value instanceof String) { setBorderBottomLeftRadiusV((String)value); return; }
        if (propertyName.equals("borderBottomRightRadiusV") && value instanceof io.lattekit.ui.style.NumberValue) { setBorderBottomRightRadiusV((io.lattekit.ui.style.NumberValue)value); return; }
        if (propertyName.equals("borderBottomRightRadiusV") && value instanceof String) { setBorderBottomRightRadiusV((String)value); return; }
        if (propertyName.equals("borderLeftWidth") && value instanceof io.lattekit.ui.style.NumberValue) { setBorderLeftWidth((io.lattekit.ui.style.NumberValue)value); return; }
        if (propertyName.equals("borderLeftWidth") && value instanceof String) { setBorderLeftWidth((String)value); return; }
        if (propertyName.equals("borderTopWidth") && value instanceof io.lattekit.ui.style.NumberValue) { setBorderTopWidth((io.lattekit.ui.style.NumberValue)value); return; }
        if (propertyName.equals("borderTopWidth") && value instanceof String) { setBorderTopWidth((String)value); return; }
        if (propertyName.equals("borderRightWidth") && value instanceof io.lattekit.ui.style.NumberValue) { setBorderRightWidth((io.lattekit.ui.style.NumberValue)value); return; }
        if (propertyName.equals("borderRightWidth") && value instanceof String) { setBorderRightWidth((String)value); return; }
        if (propertyName.equals("borderBottomWidth") && value instanceof io.lattekit.ui.style.NumberValue) { setBorderBottomWidth((io.lattekit.ui.style.NumberValue)value); return; }
        if (propertyName.equals("borderBottomWidth") && value instanceof String) { setBorderBottomWidth((String)value); return; }
        if (propertyName.equals("marginTop") && value instanceof io.lattekit.ui.style.NumberValue) { setMarginTop((io.lattekit.ui.style.NumberValue)value); return; }
        if (propertyName.equals("marginTop") && value instanceof String) { setMarginTop((String)value); return; }
        if (propertyName.equals("marginBottom") && value instanceof io.lattekit.ui.style.NumberValue) { setMarginBottom((io.lattekit.ui.style.NumberValue)value); return; }
        if (propertyName.equals("marginBottom") && value instanceof String) { setMarginBottom((String)value); return; }
        if (propertyName.equals("marginLeft") && value instanceof io.lattekit.ui.style.NumberValue) { setMarginLeft((io.lattekit.ui.style.NumberValue)value); return; }
        if (propertyName.equals("marginLeft") && value instanceof String) { setMarginLeft((String)value); return; }
        if (propertyName.equals("marginRight") && value instanceof io.lattekit.ui.style.NumberValue) { setMarginRight((io.lattekit.ui.style.NumberValue)value); return; }
        if (propertyName.equals("marginRight") && value instanceof String) { setMarginRight((String)value); return; }
        if (propertyName.equals("elevation") && value instanceof io.lattekit.ui.style.NumberValue) { setElevation((io.lattekit.ui.style.NumberValue)value); return; }
        if (propertyName.equals("elevation") && value instanceof String) { setElevation((String)value); return; }
        if (propertyName.equals("translationY") && value instanceof io.lattekit.ui.style.NumberValue) { setTranslationY((io.lattekit.ui.style.NumberValue)value); return; }
        if (propertyName.equals("translationY") && value instanceof String) { setTranslationY((String)value); return; }
        if (propertyName.equals("translationX") && value instanceof io.lattekit.ui.style.NumberValue) { setTranslationX((io.lattekit.ui.style.NumberValue)value); return; }
        if (propertyName.equals("translationX") && value instanceof String) { setTranslationX((String)value); return; }
        if (propertyName.equals("x") && value instanceof io.lattekit.ui.style.NumberValue) { setX((io.lattekit.ui.style.NumberValue)value); return; }
        if (propertyName.equals("x") && value instanceof String) { setX((String)value); return; }
        if (propertyName.equals("y") && value instanceof io.lattekit.ui.style.NumberValue) { setY((io.lattekit.ui.style.NumberValue)value); return; }
        if (propertyName.equals("y") && value instanceof String) { setY((String)value); return; }
        if (propertyName.equals("paddingTop") && value instanceof io.lattekit.ui.style.NumberValue) { setPaddingTop((io.lattekit.ui.style.NumberValue)value); return; }
        if (propertyName.equals("paddingTop") && value instanceof String) { setPaddingTop((String)value); return; }
        if (propertyName.equals("paddingBottom") && value instanceof io.lattekit.ui.style.NumberValue) { setPaddingBottom((io.lattekit.ui.style.NumberValue)value); return; }
        if (propertyName.equals("paddingBottom") && value instanceof String) { setPaddingBottom((String)value); return; }
        if (propertyName.equals("paddingLeft") && value instanceof io.lattekit.ui.style.NumberValue) { setPaddingLeft((io.lattekit.ui.style.NumberValue)value); return; }
        if (propertyName.equals("paddingLeft") && value instanceof String) { setPaddingLeft((String)value); return; }
        if (propertyName.equals("paddingRight") && value instanceof io.lattekit.ui.style.NumberValue) { setPaddingRight((io.lattekit.ui.style.NumberValue)value); return; }
        if (propertyName.equals("paddingRight") && value instanceof String) { setPaddingRight((String)value); return; }
        if (propertyName.equals("fontFamily")) { setFontFamily((java.lang.String)value); return; }
        if (propertyName.equals("fontStyle")) { setFontStyle((java.lang.String)value); return; }
        if (propertyName.equals("fontSize") && value instanceof io.lattekit.ui.style.NumberValue) { setFontSize((io.lattekit.ui.style.NumberValue)value); return; }
        if (propertyName.equals("fontSize") && value instanceof String) { setFontSize((String)value); return; }
        if (propertyName.equals("transition")) { setTransition((java.util.List<java.util.List<java.lang.Object>>)value); return; }
        if (propertyName.equals("width") && value instanceof io.lattekit.ui.style.NumberValue) { setWidth((io.lattekit.ui.style.NumberValue)value); return; }
        if (propertyName.equals("width") && value instanceof String) { setWidth((String)value); return; }
        if (propertyName.equals("height") && value instanceof io.lattekit.ui.style.NumberValue) { setHeight((io.lattekit.ui.style.NumberValue)value); return; }
        if (propertyName.equals("height") && value instanceof String) { setHeight((String)value); return; }
    }

    public Object getProperty(final String propertyName) {
        if (propertyName.equals("backgroundColor")) { return getBackgroundColor(); }
        if (propertyName.equals("rippleColor")) { return getRippleColor(); }
        if (propertyName.equals("textColor")) { return getTextColor(); }
        if (propertyName.equals("backgroundDrawable")) { return getBackgroundDrawable(); }
        if (propertyName.equals("backgroundRepeat")) { return getBackgroundRepeat(); }
        if (propertyName.equals("backgroundGravity")) { return getBackgroundGravity(); }
        if (propertyName.equals("backgroundFilterColor")) { return getBackgroundFilterColor(); }
        if (propertyName.equals("backgroundFilterType")) { return getBackgroundFilterType(); }
        if (propertyName.equals("borderLeftColor")) { return getBorderLeftColor(); }
        if (propertyName.equals("borderTopColor")) { return getBorderTopColor(); }
        if (propertyName.equals("borderRightColor")) { return getBorderRightColor(); }
        if (propertyName.equals("borderBottomColor")) { return getBorderBottomColor(); }
        if (propertyName.equals("borderTopLeftRadiusH")) { return getBorderTopLeftRadiusH(); }
        if (propertyName.equals("borderTopRightRadiusH")) { return getBorderTopRightRadiusH(); }
        if (propertyName.equals("borderBottomLeftRadiusH")) { return getBorderBottomLeftRadiusH(); }
        if (propertyName.equals("borderBottomRightRadiusH")) { return getBorderBottomRightRadiusH(); }
        if (propertyName.equals("borderTopLeftRadiusV")) { return getBorderTopLeftRadiusV(); }
        if (propertyName.equals("borderTopRightRadiusV")) { return getBorderTopRightRadiusV(); }
        if (propertyName.equals("borderBottomLeftRadiusV")) { return getBorderBottomLeftRadiusV(); }
        if (propertyName.equals("borderBottomRightRadiusV")) { return getBorderBottomRightRadiusV(); }
        if (propertyName.equals("borderLeftWidth")) { return getBorderLeftWidth(); }
        if (propertyName.equals("borderTopWidth")) { return getBorderTopWidth(); }
        if (propertyName.equals("borderRightWidth")) { return getBorderRightWidth(); }
        if (propertyName.equals("borderBottomWidth")) { return getBorderBottomWidth(); }
        if (propertyName.equals("marginTop")) { return getMarginTop(); }
        if (propertyName.equals("marginBottom")) { return getMarginBottom(); }
        if (propertyName.equals("marginLeft")) { return getMarginLeft(); }
        if (propertyName.equals("marginRight")) { return getMarginRight(); }
        if (propertyName.equals("elevation")) { return getElevation(); }
        if (propertyName.equals("translationY")) { return getTranslationY(); }
        if (propertyName.equals("translationX")) { return getTranslationX(); }
        if (propertyName.equals("x")) { return getX(); }
        if (propertyName.equals("y")) { return getY(); }
        if (propertyName.equals("paddingTop")) { return getPaddingTop(); }
        if (propertyName.equals("paddingBottom")) { return getPaddingBottom(); }
        if (propertyName.equals("paddingLeft")) { return getPaddingLeft(); }
        if (propertyName.equals("paddingRight")) { return getPaddingRight(); }
        if (propertyName.equals("fontFamily")) { return getFontFamily(); }
        if (propertyName.equals("fontStyle")) { return getFontStyle(); }
        if (propertyName.equals("fontSize")) { return getFontSize(); }
        if (propertyName.equals("transition")) { return getTransition(); }
        if (propertyName.equals("width")) { return getWidth(); }
        if (propertyName.equals("height")) { return getHeight(); }
        return null;
    }

    public Object getBackgroundColor() {
        if (_backgroundColor == null) {
            if (parentStyle == null) {
                return Color.WHITE;
            } else {
                return parentStyle.getBackgroundColor();
            }
        }
        return _backgroundColor;
    }

    public void setBackgroundColor(final Object newValue) {
        _backgroundColor = newValue;
    }

    public Object getRippleColor() {
        if (_rippleColor == null) {
            if (parentStyle == null) {
                return Color.TRANSPARENT;
            } else {
                return parentStyle.getRippleColor();
            }
        }
        return _rippleColor;
    }

    public void setRippleColor(final Object newValue) {
        _rippleColor = newValue;
    }

    public Object getTextColor() {
        if (_textColor == null) {
            if (parentStyle == null) {
                return Color.BLACK;
            } else {
                return parentStyle.getTextColor();
            }
        }
        return _textColor;
    }

    public void setTextColor(final Object newValue) {
        _textColor = newValue;
    }

    public String getBackgroundDrawable() {
        if (_backgroundDrawable == null) {
            if (parentStyle == null) {
                return "";
            } else {
                return parentStyle.getBackgroundDrawable();
            }
        }
        return _backgroundDrawable;
    }

    public void setBackgroundDrawable(final String newValue) {
        _backgroundDrawable = newValue;
    }

    public String getBackgroundRepeat() {
        if (_backgroundRepeat == null) {
            if (parentStyle == null) {
                return "no-repeat-x no-repeat-y";
            } else {
                return parentStyle.getBackgroundRepeat();
            }
        }
        return _backgroundRepeat;
    }

    public void setBackgroundRepeat(final String newValue) {
        _backgroundRepeat = newValue;
    }

    public String getBackgroundGravity() {
        if (_backgroundGravity == null) {
            if (parentStyle == null) {
                return "fill_vertical, fill_horizontal";
            } else {
                return parentStyle.getBackgroundGravity();
            }
        }
        return _backgroundGravity;
    }

    public void setBackgroundGravity(final String newValue) {
        _backgroundGravity = newValue;
    }

    public Object getBackgroundFilterColor() {
        if (_backgroundFilterColor == null) {
            if (parentStyle == null) {
                return Color.TRANSPARENT;
            } else {
                return parentStyle.getBackgroundFilterColor();
            }
        }
        return _backgroundFilterColor;
    }

    public void setBackgroundFilterColor(final Object newValue) {
        _backgroundFilterColor = newValue;
    }

    public String getBackgroundFilterType() {
        if (_backgroundFilterType == null) {
            if (parentStyle == null) {
                return "SRC_ATOP";
            } else {
                return parentStyle.getBackgroundFilterType();
            }
        }
        return _backgroundFilterType;
    }

    public void setBackgroundFilterType(final String newValue) {
        _backgroundFilterType = newValue;
    }

    public Object getBorderLeftColor() {
        if (_borderLeftColor == null) {
            if (parentStyle == null) {
                return Color.BLACK;
            } else {
                return parentStyle.getBorderLeftColor();
            }
        }
        return _borderLeftColor;
    }

    public void setBorderLeftColor(final Object newValue) {
        _borderLeftColor = newValue;
    }

    public Object getBorderTopColor() {
        if (_borderTopColor == null) {
            if (parentStyle == null) {
                return Color.BLACK;
            } else {
                return parentStyle.getBorderTopColor();
            }
        }
        return _borderTopColor;
    }

    public void setBorderTopColor(final Object newValue) {
        _borderTopColor = newValue;
    }

    public Object getBorderRightColor() {
        if (_borderRightColor == null) {
            if (parentStyle == null) {
                return Color.BLACK;
            } else {
                return parentStyle.getBorderRightColor();
            }
        }
        return _borderRightColor;
    }

    public void setBorderRightColor(final Object newValue) {
        _borderRightColor = newValue;
    }

    public Object getBorderBottomColor() {
        if (_borderBottomColor == null) {
            if (parentStyle == null) {
                return Color.BLACK;
            } else {
                return parentStyle.getBorderBottomColor();
            }
        }
        return _borderBottomColor;
    }

    public void setBorderBottomColor(final Object newValue) {
        _borderBottomColor = newValue;
    }

    public NumberValue getBorderTopLeftRadiusH() {
        if (_borderTopLeftRadiusH == null) {
            if (parentStyle == null) {
                return new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
            } else {
                return parentStyle.getBorderTopLeftRadiusH();
            }
        }
        return _borderTopLeftRadiusH;
    }

    public void setBorderTopLeftRadiusH(final Integer value) {
        _borderTopLeftRadiusH = new NumberValue(value,0);
    }

    public void setBorderTopLeftRadiusH(final String value) {
        if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
            _borderTopLeftRadiusH = new NumberValue(Style.MATCH_PARENT,0);
        } else if (value.toLowerCase().equals("wrap_content")) {
            _borderTopLeftRadiusH = new NumberValue(Style.WRAP_CONTENT,0);
        } else {
            int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
            if (value.indexOf("dp")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
            } else if (value.indexOf("sp") != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
            } else if (value.indexOf("pt")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
            }
            _borderTopLeftRadiusH = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
        }
    }

    public void setBorderTopLeftRadiusH(final NumberValue newValue) {
        _borderTopLeftRadiusH = newValue;
    }

    public NumberValue getBorderTopRightRadiusH() {
        if (_borderTopRightRadiusH == null) {
            if (parentStyle == null) {
                return new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
            } else {
                return parentStyle.getBorderTopRightRadiusH();
            }
        }
        return _borderTopRightRadiusH;
    }

    public void setBorderTopRightRadiusH(final Integer value) {
        _borderTopRightRadiusH = new NumberValue(value,0);
    }

    public void setBorderTopRightRadiusH(final String value) {
        if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
            _borderTopRightRadiusH = new NumberValue(Style.MATCH_PARENT,0);
        } else if (value.toLowerCase().equals("wrap_content")) {
            _borderTopRightRadiusH = new NumberValue(Style.WRAP_CONTENT,0);
        } else {
            int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
            if (value.indexOf("dp")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
            } else if (value.indexOf("sp") != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
            } else if (value.indexOf("pt")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
            }
            _borderTopRightRadiusH = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
        }
    }

    public void setBorderTopRightRadiusH(final NumberValue newValue) {
        _borderTopRightRadiusH = newValue;
    }

    public NumberValue getBorderBottomLeftRadiusH() {
        if (_borderBottomLeftRadiusH == null) {
            if (parentStyle == null) {
                return new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
            } else {
                return parentStyle.getBorderBottomLeftRadiusH();
            }
        }
        return _borderBottomLeftRadiusH;
    }

    public void setBorderBottomLeftRadiusH(final Integer value) {
        _borderBottomLeftRadiusH = new NumberValue(value,0);
    }

    public void setBorderBottomLeftRadiusH(final String value) {
        if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
            _borderBottomLeftRadiusH = new NumberValue(Style.MATCH_PARENT,0);
        } else if (value.toLowerCase().equals("wrap_content")) {
            _borderBottomLeftRadiusH = new NumberValue(Style.WRAP_CONTENT,0);
        } else {
            int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
            if (value.indexOf("dp")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
            } else if (value.indexOf("sp") != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
            } else if (value.indexOf("pt")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
            }
            _borderBottomLeftRadiusH = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
        }
    }

    public void setBorderBottomLeftRadiusH(final NumberValue newValue) {
        _borderBottomLeftRadiusH = newValue;
    }

    public NumberValue getBorderBottomRightRadiusH() {
        if (_borderBottomRightRadiusH == null) {
            if (parentStyle == null) {
                return new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
            } else {
                return parentStyle.getBorderBottomRightRadiusH();
            }
        }
        return _borderBottomRightRadiusH;
    }

    public void setBorderBottomRightRadiusH(final Integer value) {
        _borderBottomRightRadiusH = new NumberValue(value,0);
    }

    public void setBorderBottomRightRadiusH(final String value) {
        if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
            _borderBottomRightRadiusH = new NumberValue(Style.MATCH_PARENT,0);
        } else if (value.toLowerCase().equals("wrap_content")) {
            _borderBottomRightRadiusH = new NumberValue(Style.WRAP_CONTENT,0);
        } else {
            int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
            if (value.indexOf("dp")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
            } else if (value.indexOf("sp") != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
            } else if (value.indexOf("pt")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
            }
            _borderBottomRightRadiusH = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
        }
    }

    public void setBorderBottomRightRadiusH(final NumberValue newValue) {
        _borderBottomRightRadiusH = newValue;
    }

    public NumberValue getBorderTopLeftRadiusV() {
        if (_borderTopLeftRadiusV == null) {
            if (parentStyle == null) {
                return new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
            } else {
                return parentStyle.getBorderTopLeftRadiusV();
            }
        }
        return _borderTopLeftRadiusV;
    }

    public void setBorderTopLeftRadiusV(final Integer value) {
        _borderTopLeftRadiusV = new NumberValue(value,0);
    }

    public void setBorderTopLeftRadiusV(final String value) {
        if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
            _borderTopLeftRadiusV = new NumberValue(Style.MATCH_PARENT,0);
        } else if (value.toLowerCase().equals("wrap_content")) {
            _borderTopLeftRadiusV = new NumberValue(Style.WRAP_CONTENT,0);
        } else {
            int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
            if (value.indexOf("dp")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
            } else if (value.indexOf("sp") != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
            } else if (value.indexOf("pt")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
            }
            _borderTopLeftRadiusV = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
        }
    }

    public void setBorderTopLeftRadiusV(final NumberValue newValue) {
        _borderTopLeftRadiusV = newValue;
    }

    public NumberValue getBorderTopRightRadiusV() {
        if (_borderTopRightRadiusV == null) {
            if (parentStyle == null) {
                return new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
            } else {
                return parentStyle.getBorderTopRightRadiusV();
            }
        }
        return _borderTopRightRadiusV;
    }

    public void setBorderTopRightRadiusV(final Integer value) {
        _borderTopRightRadiusV = new NumberValue(value,0);
    }

    public void setBorderTopRightRadiusV(final String value) {
        if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
            _borderTopRightRadiusV = new NumberValue(Style.MATCH_PARENT,0);
        } else if (value.toLowerCase().equals("wrap_content")) {
            _borderTopRightRadiusV = new NumberValue(Style.WRAP_CONTENT,0);
        } else {
            int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
            if (value.indexOf("dp")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
            } else if (value.indexOf("sp") != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
            } else if (value.indexOf("pt")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
            }
            _borderTopRightRadiusV = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
        }
    }

    public void setBorderTopRightRadiusV(final NumberValue newValue) {
        _borderTopRightRadiusV = newValue;
    }

    public NumberValue getBorderBottomLeftRadiusV() {
        if (_borderBottomLeftRadiusV == null) {
            if (parentStyle == null) {
                return new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
            } else {
                return parentStyle.getBorderBottomLeftRadiusV();
            }
        }
        return _borderBottomLeftRadiusV;
    }

    public void setBorderBottomLeftRadiusV(final Integer value) {
        _borderBottomLeftRadiusV = new NumberValue(value,0);
    }

    public void setBorderBottomLeftRadiusV(final String value) {
        if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
            _borderBottomLeftRadiusV = new NumberValue(Style.MATCH_PARENT,0);
        } else if (value.toLowerCase().equals("wrap_content")) {
            _borderBottomLeftRadiusV = new NumberValue(Style.WRAP_CONTENT,0);
        } else {
            int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
            if (value.indexOf("dp")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
            } else if (value.indexOf("sp") != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
            } else if (value.indexOf("pt")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
            }
            _borderBottomLeftRadiusV = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
        }
    }

    public void setBorderBottomLeftRadiusV(final NumberValue newValue) {
        _borderBottomLeftRadiusV = newValue;
    }

    public NumberValue getBorderBottomRightRadiusV() {
        if (_borderBottomRightRadiusV == null) {
            if (parentStyle == null) {
                return new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
            } else {
                return parentStyle.getBorderBottomRightRadiusV();
            }
        }
        return _borderBottomRightRadiusV;
    }

    public void setBorderBottomRightRadiusV(final Integer value) {
        _borderBottomRightRadiusV = new NumberValue(value,0);
    }

    public void setBorderBottomRightRadiusV(final String value) {
        if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
            _borderBottomRightRadiusV = new NumberValue(Style.MATCH_PARENT,0);
        } else if (value.toLowerCase().equals("wrap_content")) {
            _borderBottomRightRadiusV = new NumberValue(Style.WRAP_CONTENT,0);
        } else {
            int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
            if (value.indexOf("dp")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
            } else if (value.indexOf("sp") != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
            } else if (value.indexOf("pt")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
            }
            _borderBottomRightRadiusV = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
        }
    }

    public void setBorderBottomRightRadiusV(final NumberValue newValue) {
        _borderBottomRightRadiusV = newValue;
    }

    public NumberValue getBorderLeftWidth() {
        if (_borderLeftWidth == null) {
            if (parentStyle == null) {
                return new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
            } else {
                return parentStyle.getBorderLeftWidth();
            }
        }
        return _borderLeftWidth;
    }

    public void setBorderLeftWidth(final Integer value) {
        _borderLeftWidth = new NumberValue(value,0);
    }

    public void setBorderLeftWidth(final String value) {
        if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
            _borderLeftWidth = new NumberValue(Style.MATCH_PARENT,0);
        } else if (value.toLowerCase().equals("wrap_content")) {
            _borderLeftWidth = new NumberValue(Style.WRAP_CONTENT,0);
        } else {
            int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
            if (value.indexOf("dp")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
            } else if (value.indexOf("sp") != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
            } else if (value.indexOf("pt")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
            }
            _borderLeftWidth = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
        }
    }

    public void setBorderLeftWidth(final NumberValue newValue) {
        _borderLeftWidth = newValue;
    }

    public NumberValue getBorderTopWidth() {
        if (_borderTopWidth == null) {
            if (parentStyle == null) {
                return new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
            } else {
                return parentStyle.getBorderTopWidth();
            }
        }
        return _borderTopWidth;
    }

    public void setBorderTopWidth(final Integer value) {
        _borderTopWidth = new NumberValue(value,0);
    }

    public void setBorderTopWidth(final String value) {
        if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
            _borderTopWidth = new NumberValue(Style.MATCH_PARENT,0);
        } else if (value.toLowerCase().equals("wrap_content")) {
            _borderTopWidth = new NumberValue(Style.WRAP_CONTENT,0);
        } else {
            int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
            if (value.indexOf("dp")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
            } else if (value.indexOf("sp") != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
            } else if (value.indexOf("pt")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
            }
            _borderTopWidth = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
        }
    }

    public void setBorderTopWidth(final NumberValue newValue) {
        _borderTopWidth = newValue;
    }

    public NumberValue getBorderRightWidth() {
        if (_borderRightWidth == null) {
            if (parentStyle == null) {
                return new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
            } else {
                return parentStyle.getBorderRightWidth();
            }
        }
        return _borderRightWidth;
    }

    public void setBorderRightWidth(final Integer value) {
        _borderRightWidth = new NumberValue(value,0);
    }

    public void setBorderRightWidth(final String value) {
        if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
            _borderRightWidth = new NumberValue(Style.MATCH_PARENT,0);
        } else if (value.toLowerCase().equals("wrap_content")) {
            _borderRightWidth = new NumberValue(Style.WRAP_CONTENT,0);
        } else {
            int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
            if (value.indexOf("dp")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
            } else if (value.indexOf("sp") != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
            } else if (value.indexOf("pt")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
            }
            _borderRightWidth = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
        }
    }

    public void setBorderRightWidth(final NumberValue newValue) {
        _borderRightWidth = newValue;
    }

    public NumberValue getBorderBottomWidth() {
        if (_borderBottomWidth == null) {
            if (parentStyle == null) {
                return new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
            } else {
                return parentStyle.getBorderBottomWidth();
            }
        }
        return _borderBottomWidth;
    }

    public void setBorderBottomWidth(final Integer value) {
        _borderBottomWidth = new NumberValue(value,0);
    }

    public void setBorderBottomWidth(final String value) {
        if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
            _borderBottomWidth = new NumberValue(Style.MATCH_PARENT,0);
        } else if (value.toLowerCase().equals("wrap_content")) {
            _borderBottomWidth = new NumberValue(Style.WRAP_CONTENT,0);
        } else {
            int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
            if (value.indexOf("dp")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
            } else if (value.indexOf("sp") != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
            } else if (value.indexOf("pt")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
            }
            _borderBottomWidth = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
        }
    }

    public void setBorderBottomWidth(final NumberValue newValue) {
        _borderBottomWidth = newValue;
    }

    public NumberValue getMarginTop() {
        if (_marginTop == null) {
            if (parentStyle == null) {
                return new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
            } else {
                return parentStyle.getMarginTop();
            }
        }
        return _marginTop;
    }

    public void setMarginTop(final Integer value) {
        _marginTop = new NumberValue(value,0);
    }

    public void setMarginTop(final String value) {
        if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
            _marginTop = new NumberValue(Style.MATCH_PARENT,0);
        } else if (value.toLowerCase().equals("wrap_content")) {
            _marginTop = new NumberValue(Style.WRAP_CONTENT,0);
        } else {
            int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
            if (value.indexOf("dp")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
            } else if (value.indexOf("sp") != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
            } else if (value.indexOf("pt")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
            }
            _marginTop = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
        }
    }

    public void setMarginTop(final NumberValue newValue) {
        _marginTop = newValue;
    }

    public NumberValue getMarginBottom() {
        if (_marginBottom == null) {
            if (parentStyle == null) {
                return new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
            } else {
                return parentStyle.getMarginBottom();
            }
        }
        return _marginBottom;
    }

    public void setMarginBottom(final Integer value) {
        _marginBottom = new NumberValue(value,0);
    }

    public void setMarginBottom(final String value) {
        if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
            _marginBottom = new NumberValue(Style.MATCH_PARENT,0);
        } else if (value.toLowerCase().equals("wrap_content")) {
            _marginBottom = new NumberValue(Style.WRAP_CONTENT,0);
        } else {
            int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
            if (value.indexOf("dp")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
            } else if (value.indexOf("sp") != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
            } else if (value.indexOf("pt")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
            }
            _marginBottom = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
        }
    }

    public void setMarginBottom(final NumberValue newValue) {
        _marginBottom = newValue;
    }

    public NumberValue getMarginLeft() {
        if (_marginLeft == null) {
            if (parentStyle == null) {
                return new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
            } else {
                return parentStyle.getMarginLeft();
            }
        }
        return _marginLeft;
    }

    public void setMarginLeft(final Integer value) {
        _marginLeft = new NumberValue(value,0);
    }

    public void setMarginLeft(final String value) {
        if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
            _marginLeft = new NumberValue(Style.MATCH_PARENT,0);
        } else if (value.toLowerCase().equals("wrap_content")) {
            _marginLeft = new NumberValue(Style.WRAP_CONTENT,0);
        } else {
            int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
            if (value.indexOf("dp")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
            } else if (value.indexOf("sp") != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
            } else if (value.indexOf("pt")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
            }
            _marginLeft = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
        }
    }

    public void setMarginLeft(final NumberValue newValue) {
        _marginLeft = newValue;
    }

    public NumberValue getMarginRight() {
        if (_marginRight == null) {
            if (parentStyle == null) {
                return new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
            } else {
                return parentStyle.getMarginRight();
            }
        }
        return _marginRight;
    }

    public void setMarginRight(final Integer value) {
        _marginRight = new NumberValue(value,0);
    }

    public void setMarginRight(final String value) {
        if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
            _marginRight = new NumberValue(Style.MATCH_PARENT,0);
        } else if (value.toLowerCase().equals("wrap_content")) {
            _marginRight = new NumberValue(Style.WRAP_CONTENT,0);
        } else {
            int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
            if (value.indexOf("dp")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
            } else if (value.indexOf("sp") != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
            } else if (value.indexOf("pt")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
            }
            _marginRight = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
        }
    }

    public void setMarginRight(final NumberValue newValue) {
        _marginRight = newValue;
    }

    public NumberValue getElevation() {
        if (_elevation == null) {
            if (parentStyle == null) {
                return new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
            } else {
                return parentStyle.getElevation();
            }
        }
        return _elevation;
    }

    public void setElevation(final Integer value) {
        _elevation = new NumberValue(value,0);
    }

    public void setElevation(final String value) {
        if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
            _elevation = new NumberValue(Style.MATCH_PARENT,0);
        } else if (value.toLowerCase().equals("wrap_content")) {
            _elevation = new NumberValue(Style.WRAP_CONTENT,0);
        } else {
            int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
            if (value.indexOf("dp")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
            } else if (value.indexOf("sp") != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
            } else if (value.indexOf("pt")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
            }
            _elevation = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
        }
    }

    public void setElevation(final NumberValue newValue) {
        _elevation = newValue;
    }

    public NumberValue getTranslationY() {
        if (_translationY == null) {
            if (parentStyle == null) {
                return new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
            } else {
                return parentStyle.getTranslationY();
            }
        }
        return _translationY;
    }

    public void setTranslationY(final Integer value) {
        _translationY = new NumberValue(value,0);
    }

    public void setTranslationY(final String value) {
        if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
            _translationY = new NumberValue(Style.MATCH_PARENT,0);
        } else if (value.toLowerCase().equals("wrap_content")) {
            _translationY = new NumberValue(Style.WRAP_CONTENT,0);
        } else {
            int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
            if (value.indexOf("dp")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
            } else if (value.indexOf("sp") != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
            } else if (value.indexOf("pt")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
            }
            _translationY = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
        }
    }

    public void setTranslationY(final NumberValue newValue) {
        _translationY = newValue;
    }

    public NumberValue getTranslationX() {
        if (_translationX == null) {
            if (parentStyle == null) {
                return new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
            } else {
                return parentStyle.getTranslationX();
            }
        }
        return _translationX;
    }

    public void setTranslationX(final Integer value) {
        _translationX = new NumberValue(value,0);
    }

    public void setTranslationX(final String value) {
        if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
            _translationX = new NumberValue(Style.MATCH_PARENT,0);
        } else if (value.toLowerCase().equals("wrap_content")) {
            _translationX = new NumberValue(Style.WRAP_CONTENT,0);
        } else {
            int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
            if (value.indexOf("dp")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
            } else if (value.indexOf("sp") != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
            } else if (value.indexOf("pt")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
            }
            _translationX = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
        }
    }

    public void setTranslationX(final NumberValue newValue) {
        _translationX = newValue;
    }

    public NumberValue getX() {
        if (_x == null && parentStyle != null) {
            return parentStyle.getX();
        }
        return _x;
    }

    public void setX(final Integer value) {
        _x = new NumberValue(value,0);
    }

    public void setX(final String value) {
        if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
            _x = new NumberValue(Style.MATCH_PARENT,0);
        } else if (value.toLowerCase().equals("wrap_content")) {
            _x = new NumberValue(Style.WRAP_CONTENT,0);
        } else {
            int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
            if (value.indexOf("dp")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
            } else if (value.indexOf("sp") != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
            } else if (value.indexOf("pt")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
            }
            _x = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
        }
    }

    public void setX(final NumberValue newValue) {
        _x = newValue;
    }

    public NumberValue getY() {
        if (_y == null && parentStyle != null) {
            return parentStyle.getY();
        }
        return _y;
    }

    public void setY(final Integer value) {
        _y = new NumberValue(value,0);
    }

    public void setY(final String value) {
        if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
            _y = new NumberValue(Style.MATCH_PARENT,0);
        } else if (value.toLowerCase().equals("wrap_content")) {
            _y = new NumberValue(Style.WRAP_CONTENT,0);
        } else {
            int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
            if (value.indexOf("dp")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
            } else if (value.indexOf("sp") != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
            } else if (value.indexOf("pt")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
            }
            _y = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
        }
    }

    public void setY(final NumberValue newValue) {
        _y = newValue;
    }

    public NumberValue getPaddingTop() {
        if (_paddingTop == null) {
            if (parentStyle == null) {
                return new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
            } else {
                return parentStyle.getPaddingTop();
            }
        }
        return _paddingTop;
    }

    public void setPaddingTop(final Integer value) {
        _paddingTop = new NumberValue(value,0);
    }

    public void setPaddingTop(final String value) {
        if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
            _paddingTop = new NumberValue(Style.MATCH_PARENT,0);
        } else if (value.toLowerCase().equals("wrap_content")) {
            _paddingTop = new NumberValue(Style.WRAP_CONTENT,0);
        } else {
            int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
            if (value.indexOf("dp")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
            } else if (value.indexOf("sp") != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
            } else if (value.indexOf("pt")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
            }
            _paddingTop = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
        }
    }

    public void setPaddingTop(final NumberValue newValue) {
        _paddingTop = newValue;
    }

    public NumberValue getPaddingBottom() {
        if (_paddingBottom == null) {
            if (parentStyle == null) {
                return new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
            } else {
                return parentStyle.getPaddingBottom();
            }
        }
        return _paddingBottom;
    }

    public void setPaddingBottom(final Integer value) {
        _paddingBottom = new NumberValue(value,0);
    }

    public void setPaddingBottom(final String value) {
        if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
            _paddingBottom = new NumberValue(Style.MATCH_PARENT,0);
        } else if (value.toLowerCase().equals("wrap_content")) {
            _paddingBottom = new NumberValue(Style.WRAP_CONTENT,0);
        } else {
            int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
            if (value.indexOf("dp")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
            } else if (value.indexOf("sp") != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
            } else if (value.indexOf("pt")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
            }
            _paddingBottom = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
        }
    }

    public void setPaddingBottom(final NumberValue newValue) {
        _paddingBottom = newValue;
    }

    public NumberValue getPaddingLeft() {
        if (_paddingLeft == null) {
            if (parentStyle == null) {
                return new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
            } else {
                return parentStyle.getPaddingLeft();
            }
        }
        return _paddingLeft;
    }

    public void setPaddingLeft(final Integer value) {
        _paddingLeft = new NumberValue(value,0);
    }

    public void setPaddingLeft(final String value) {
        if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
            _paddingLeft = new NumberValue(Style.MATCH_PARENT,0);
        } else if (value.toLowerCase().equals("wrap_content")) {
            _paddingLeft = new NumberValue(Style.WRAP_CONTENT,0);
        } else {
            int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
            if (value.indexOf("dp")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
            } else if (value.indexOf("sp") != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
            } else if (value.indexOf("pt")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
            }
            _paddingLeft = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
        }
    }

    public void setPaddingLeft(final NumberValue newValue) {
        _paddingLeft = newValue;
    }

    public NumberValue getPaddingRight() {
        if (_paddingRight == null) {
            if (parentStyle == null) {
                return new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
            } else {
                return parentStyle.getPaddingRight();
            }
        }
        return _paddingRight;
    }

    public void setPaddingRight(final Integer value) {
        _paddingRight = new NumberValue(value,0);
    }

    public void setPaddingRight(final String value) {
        if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
            _paddingRight = new NumberValue(Style.MATCH_PARENT,0);
        } else if (value.toLowerCase().equals("wrap_content")) {
            _paddingRight = new NumberValue(Style.WRAP_CONTENT,0);
        } else {
            int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
            if (value.indexOf("dp")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
            } else if (value.indexOf("sp") != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
            } else if (value.indexOf("pt")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
            }
            _paddingRight = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
        }
    }

    public void setPaddingRight(final NumberValue newValue) {
        _paddingRight = newValue;
    }

    public String getFontFamily() {
        if (_fontFamily == null) {
            if (parentStyle == null) {
                return "default";
            } else {
                return parentStyle.getFontFamily();
            }
        }
        return _fontFamily;
    }

    public void setFontFamily(final String newValue) {
        _fontFamily = newValue;
    }

    public String getFontStyle() {
        if (_fontStyle == null) {
            if (parentStyle == null) {
                return "normal";
            } else {
                return parentStyle.getFontStyle();
            }
        }
        return _fontStyle;
    }

    public void setFontStyle(final String newValue) {
        _fontStyle = newValue;
    }

    public NumberValue getFontSize() {
        if (_fontSize == null && parentStyle != null) {
            return parentStyle.getFontSize();
        }
        return _fontSize;
    }

    public void setFontSize(final Integer value) {
        _fontSize = new NumberValue(value,0);
    }

    public void setFontSize(final String value) {
        if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
            _fontSize = new NumberValue(Style.MATCH_PARENT,0);
        } else if (value.toLowerCase().equals("wrap_content")) {
            _fontSize = new NumberValue(Style.WRAP_CONTENT,0);
        } else {
            int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
            if (value.indexOf("dp")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
            } else if (value.indexOf("sp") != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
            } else if (value.indexOf("pt")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
            }
            _fontSize = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
        }
    }

    public void setFontSize(final NumberValue newValue) {
        _fontSize = newValue;
    }

    public List<List<Object>> getTransition() {
        if (_transition == null && parentStyle != null) {
            return parentStyle.getTransition();
        }
        return _transition;
    }

    public void setTransition(final List<List<Object>> newValue) {
        _transition = newValue;
    }

    public NumberValue getWidth() {
        if (_width == null) {
            if (parentStyle == null) {
                return new NumberValue(ViewGroup.LayoutParams.WRAP_CONTENT, TypedValue.COMPLEX_UNIT_PX);
            } else {
                return parentStyle.getWidth();
            }
        }
        return _width;
    }

    public void setWidth(final Integer value) {
        _width = new NumberValue(value,0);
    }

    public void setWidth(final String value) {
        if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
            _width = new NumberValue(Style.MATCH_PARENT,0);
        } else if (value.toLowerCase().equals("wrap_content")) {
            _width = new NumberValue(Style.WRAP_CONTENT,0);
        } else {
            int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
            if (value.indexOf("dp")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
            } else if (value.indexOf("sp") != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
            } else if (value.indexOf("pt")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
            }
            _width = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
        }
    }

    public void setWidth(final NumberValue newValue) {
        _width = newValue;
    }

    public NumberValue getHeight() {
        if (_height == null) {
            if (parentStyle == null) {
                return new NumberValue(ViewGroup.LayoutParams.WRAP_CONTENT, TypedValue.COMPLEX_UNIT_PX);
            } else {
                return parentStyle.getHeight();
            }
        }
        return _height;
    }

    public void setHeight(final Integer value) {
        _height = new NumberValue(value,0);
    }

    public void setHeight(final String value) {
        if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
            _height = new NumberValue(Style.MATCH_PARENT,0);
        } else if (value.toLowerCase().equals("wrap_content")) {
            _height = new NumberValue(Style.WRAP_CONTENT,0);
        } else {
            int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
            if (value.indexOf("dp")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
            } else if (value.indexOf("sp") != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
            } else if (value.indexOf("pt")  != -1) {
                unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
            }
            _height = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
        }
    }

    public void setHeight(final NumberValue newValue) {
        _height = newValue;
    }
}
