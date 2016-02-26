package io.lattekit.ui.style;

import com.google.common.base.CaseFormat;
import com.google.common.base.Objects;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.lattekit.plugin.css.CssDeclaration;
import io.lattekit.plugin.css.RuleSet;

@SuppressWarnings("all")
public class Stylesheet {
    private static Map<String, Stylesheet> styleSheets = new HashMap<String, Stylesheet>();

    private Map<String, Style> classes = new HashMap<String, Style>();

    public static void registerStylesheet(final String fileName, final Stylesheet stylesheet) {
        Stylesheet.styleSheets.put(fileName, stylesheet);
    }

    public List<RuleSet> getRuleSets() {
        return new ArrayList<>();
    }
    public static Stylesheet getStylesheet(final String fileName) {
        try {
            String[] parts = fileName.split("/");
            final String[] _converted_parts = (String[])parts;
            String _last = IterableExtensions.<String>last(((Iterable<String>)Conversions.doWrapArray(_converted_parts)));
            String _replace = _last.replace(".css", "");
            String _to = CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_CAMEL, _replace);
            String clsName = (_to + "Stylesheet");
            String packageName = parts[0];
            Class<?> _forName = Class.forName(((packageName + ".") + clsName));
            Constructor<?>[] _constructors = _forName.getConstructors();
            Constructor<?> _get = _constructors[0];
            Object _newInstance = _get.newInstance();
            return ((Stylesheet) _newInstance);
        } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
        }
    }

    public Style registerStyle(final String selector_finalParam_, final Style style) {
        String selector = selector_finalParam_;
        String _trim = selector.trim();
        selector = _trim;
        String _replaceAll = selector.replaceAll("(.)>(.)", "$1 > $2");
        String _replaceAll_1 = _replaceAll.replaceAll("\\s\\s+", " ");
        String _trim_1 = _replaceAll_1.trim();
        String[] allSelectors = _trim_1.split(" ");
        int _length = allSelectors.length;
        boolean _tripleEquals = (_length == 1);
        if (_tripleEquals) {
            style.setDefinedSelector(selector);
            Style existingStyle = this.classes.get(selector);
            if ((existingStyle != null)) {
                existingStyle.overrideWithStyle(style);
                Map<String, Style> _descendantStyles = existingStyle.getDescendantStyles();
                Map<String, Style> _descendantStyles_1 = style.getDescendantStyles();
                _descendantStyles.putAll(_descendantStyles_1);
                Map<String, Style> _directChildrenStyles = existingStyle.getDirectChildrenStyles();
                Map<String, Style> _directChildrenStyles_1 = style.getDirectChildrenStyles();
                _directChildrenStyles.putAll(_directChildrenStyles_1);
                return existingStyle;
            } else {
                this.classes.put(selector, style);
                return style;
            }
        } else {
            Style currentParent = null;
            String currentRelation = null;
            for (int i = 0; (i < allSelectors.length); i++) {
                {
                    String _xblockexpression = null;
                    {
                        final int _rdIndx_allSelectors = i;
                        _xblockexpression = allSelectors[_rdIndx_allSelectors];
                    }
                    String currentSelector = _xblockexpression.trim();
                    Style newStyle = new Style();
                    newStyle.setDefinedSelector(currentSelector);
                    int _length_1 = allSelectors.length;
                    int _minus = (_length_1 - 1);
                    boolean _tripleEquals_1 = (i == _minus);
                    if (_tripleEquals_1) {
                        newStyle = style;
                    }
                    if ((i == 0)) {
                        Style _registerStyle = this.registerStyle(currentSelector, newStyle);
                        newStyle = _registerStyle;
                    } else {
                        boolean _equals = currentSelector.equals(">");
                        if (_equals) {
                            currentRelation = ">";
                        } else {
                            boolean _and = false;
                            if (!(currentRelation != null)) {
                                _and = false;
                            } else {
                                boolean _equals_1 = currentRelation.equals(">");
                                _and = _equals_1;
                            }
                            if (_and) {
                                Map<String, Style> _directChildrenStyles_2 = currentParent.getDirectChildrenStyles();
                                _directChildrenStyles_2.put(currentSelector, newStyle);
                            } else {
                                Map<String, Style> _descendantStyles_2 = currentParent.getDescendantStyles();
                                _descendantStyles_2.put(currentSelector, newStyle);
                            }
                            currentRelation = null;
                        }
                    }
                    boolean _notEquals = (!Objects.equal(currentRelation, ">"));
                    if (_notEquals) {
                        currentParent = newStyle;
                    }
                }
            }
            return currentParent;
        }
    }

    public void registerStyleForChild(final String selector, final String parentSelector, final Style style) {
        Style parent = this.getStyle(parentSelector);
        if ((parent == null)) {
            Style _style = new Style();
            parent = _style;
            this.classes.put(parentSelector, parent);
        }
        Map<String, Style> _directChildrenStyles = parent.getDirectChildrenStyles();
        _directChildrenStyles.put(selector, style);
    }

    public void registerStyleForDescendant(final String selector, final String parentSelector, final Style style) {
        Style parent = this.getStyle(parentSelector);
        if ((parent == null)) {
            Style _style = new Style();
            parent = _style;
            this.classes.put(parentSelector, parent);
        }
        Map<String, Style> _descendantStyles = parent.getDescendantStyles();
        _descendantStyles.put(selector, style);
    }

    public void registerClass(final String className, final Style style) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(".");
        _builder.append(className, "");
        this.classes.put(_builder.toString(), style);
    }

    public Style getClass(final String className) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(".");
        _builder.append(className, "");
        return this.classes.get(_builder);
    }

    public Style getStyle(final String simpleSelector) {
        return this.classes.get(simpleSelector);
    }

    public void apply(final Stylesheet stylesheet) {
    }

    public String getCssFile() {
        StringConcatenation _builder = new StringConcatenation();
        Set<String> _keySet = this.classes.keySet();
        final Function1<String, String> _function = new Function1<String, String>() {
            @Override
            public String apply(final String key) {
                StringConcatenation _builder = new StringConcatenation();
                _builder.append(".");
                _builder.append(key, "");
                _builder.append(" {");
                _builder.newLineIfNotEmpty();
                _builder.append("    ");
                _builder.append("width: ");
                Style _get = Stylesheet.this.classes.get(key);
                NumberValue _width = _get.getWidth();
                int _value = _width.getValue();
                _builder.append(_value, "    ");
                _builder.append("px;");
                _builder.newLineIfNotEmpty();
                _builder.append("    ");
                _builder.append("height: ");
                Style _get_1 = Stylesheet.this.classes.get(key);
                NumberValue _height = _get_1.getHeight();
                int _value_1 = _height.getValue();
                _builder.append(_value_1, "    ");
                _builder.append("px;");
                _builder.newLineIfNotEmpty();
                _builder.append("    ");
                _builder.append("border-right-width: ");
                Style _get_2 = Stylesheet.this.classes.get(key);
                NumberValue _borderRightWidth = _get_2.getBorderRightWidth();
                int _value_2 = _borderRightWidth.getValue();
                _builder.append(_value_2, "    ");
                _builder.append("px;");
                _builder.newLineIfNotEmpty();
                _builder.append("    ");
                _builder.append("border-left-width: ");
                Style _get_3 = Stylesheet.this.classes.get(key);
                NumberValue _borderLeftWidth = _get_3.getBorderLeftWidth();
                int _value_3 = _borderLeftWidth.getValue();
                _builder.append(_value_3, "    ");
                _builder.append("px;");
                _builder.newLineIfNotEmpty();
                _builder.append("    ");
                _builder.append("border-top-width: ");
                Style _get_4 = Stylesheet.this.classes.get(key);
                NumberValue _borderTopWidth = _get_4.getBorderTopWidth();
                int _value_4 = _borderTopWidth.getValue();
                _builder.append(_value_4, "    ");
                _builder.append("px;");
                _builder.newLineIfNotEmpty();
                _builder.append("    ");
                _builder.append("border-bottom-width: ");
                Style _get_5 = Stylesheet.this.classes.get(key);
                NumberValue _borderRightWidth_1 = _get_5.getBorderRightWidth();
                int _value_5 = _borderRightWidth_1.getValue();
                _builder.append(_value_5, "    ");
                _builder.append("px;");
                _builder.newLineIfNotEmpty();
                _builder.newLine();
                _builder.append("}");
                _builder.newLine();
                return _builder.toString();
            }
        };
        Iterable<String> _map = IterableExtensions.<String, String>map(_keySet, _function);
        _builder.append(_map, "");
        _builder.newLineIfNotEmpty();
        return _builder.toString();
    }
}
