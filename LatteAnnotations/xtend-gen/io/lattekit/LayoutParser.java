package io.lattekit;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ResolvedMethod;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure4;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure5;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure6;
import org.eclipse.xtext.xbase.lib.Pure;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

@SuppressWarnings("all")
public class LayoutParser extends DefaultHandler {
  @Accessors
  private String renderBody;
  
  private TransformationContext context;
  
  private Stack<Map<String, Object>> elStack = new Stack<Map<String, Object>>();
  
  private List<String> errorList = CollectionLiterals.<String>newArrayList();
  
  private List<String> warningList = CollectionLiterals.<String>newArrayList();
  
  private List<String> importList = CollectionLiterals.<String>newArrayList();
  
  private StringBuilder currentProc = null;
  
  private Map<String, Object> currentEl = null;
  
  private MutableTypeDeclaration declaringType;
  
  private int tagsIncrement = 0;
  
  public String translateCode(final String code) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@([_a-z]\\w*)");
    String regex = _builder.toString();
    Pattern p = Pattern.compile(regex);
    Matcher matcher = p.matcher(code);
    List<List> replaces = CollectionLiterals.<List>newArrayList();
    final StringBuffer newSource = new StringBuffer(code);
    while (matcher.find()) {
      {
        String propName = matcher.group(1);
        int _start = matcher.start(0);
        int _end = matcher.end(0);
        String _substring = propName.substring(0, 1);
        String _upperCase = _substring.toUpperCase();
        String _plus = ("get" + _upperCase);
        String _substring_1 = propName.substring(1);
        String _plus_1 = (_plus + _substring_1);
        String _plus_2 = (_plus_1 + "()");
        replaces.add(Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(Integer.valueOf(_start), Integer.valueOf(_end), _plus_2)));
      }
    }
    List<List> _reverse = ListExtensions.<List>reverse(replaces);
    final Consumer<List> _function = (List it) -> {
      Object _get = it.get(0);
      Object _get_1 = it.get(1);
      Object _get_2 = it.get(2);
      newSource.replace((((Integer) _get)).intValue(), (((Integer) _get_1)).intValue(), ((String) _get_2));
    };
    _reverse.forEach(_function);
    return newSource.toString();
  }
  
  public Type findViewType(@Extension final TransformationContext context, final String view, final List<String> importList) {
    final Function1<String, Type> _function = (String it) -> {
      return context.findTypeGlobally(((it + ".") + view));
    };
    List<Type> _map = ListExtensions.<String, Type>map(importList, _function);
    final Function1<Type, Boolean> _function_1 = (Type it) -> {
      return Boolean.valueOf((!Objects.equal(it, null)));
    };
    return IterableExtensions.<Type>findFirst(_map, _function_1);
  }
  
  public Iterable<? extends TypeReference> findDeclaringClasses(@Extension final TransformationContext context, final TypeReference classRef, final String methodName) {
    Iterable<? extends TypeReference> _declaredSuperTypes = classRef.getDeclaredSuperTypes();
    final Function1<TypeReference, Boolean> _function = (TypeReference it) -> {
      boolean _xblockexpression = false;
      {
        Iterable<? extends ResolvedMethod> _declaredResolvedMethods = it.getDeclaredResolvedMethods();
        final Function1<ResolvedMethod, Boolean> _function_1 = (ResolvedMethod it_1) -> {
          MethodDeclaration _declaration = it_1.getDeclaration();
          String _simpleName = _declaration.getSimpleName();
          return Boolean.valueOf(Objects.equal(_simpleName, methodName));
        };
        Iterable<? extends ResolvedMethod> methods = IterableExtensions.filter(_declaredResolvedMethods, _function_1);
        boolean _isEmpty = IterableExtensions.isEmpty(methods);
        _xblockexpression = (!_isEmpty);
      }
      return Boolean.valueOf(_xblockexpression);
    };
    Iterable<? extends TypeReference> classes = IterableExtensions.filter(_declaredSuperTypes, _function);
    boolean _isEmpty = IterableExtensions.isEmpty(classes);
    if (_isEmpty) {
      Iterable<? extends TypeReference> _declaredSuperTypes_1 = classRef.getDeclaredSuperTypes();
      final Function1<TypeReference, Iterable<? extends TypeReference>> _function_1 = (TypeReference it) -> {
        return this.findDeclaringClasses(context, it, methodName);
      };
      Iterable<Iterable<? extends TypeReference>> upstreamClasses = IterableExtensions.map(_declaredSuperTypes_1, _function_1);
      return Iterables.<TypeReference>concat(upstreamClasses);
    }
    return classes;
  }
  
  public Class<?> getProcedureType(@Extension final TransformationContext context, final TypeReference type) {
    Class<?> _xblockexpression = null;
    {
      List<? extends Class<?>> procs = Collections.<Class<?>>unmodifiableList(CollectionLiterals.<Class<?>>newArrayList(Procedure0.class, Procedure1.class, Procedure2.class, Procedure3.class, Procedure4.class, Procedure5.class, Procedure6.class));
      final Function1<Class<?>, Boolean> _function = (Class<?> it) -> {
        TypeReference _newTypeReference = context.newTypeReference(it);
        return Boolean.valueOf(_newTypeReference.isAssignableFrom(type));
      };
      _xblockexpression = IterableExtensions.findFirst(procs, _function);
    }
    return _xblockexpression;
  }
  
  public static String preprocess(final String sourceStr) {
    String _replaceAll = sourceStr.replaceAll("< ", "&lt; ");
    String source = _replaceAll.replaceAll("<=", "&lt;=");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("([a-zA-Z0-9]+)=(\\{(\\\\\\}|[^\\}])+\\})");
    String regex = _builder.toString();
    Pattern p = Pattern.compile(regex);
    Matcher matcher = p.matcher(source);
    List<List> replaces = CollectionLiterals.<List>newArrayList();
    final StringBuffer newSource = new StringBuffer(source);
    while (matcher.find()) {
      {
        int _start = matcher.start(1);
        int _end = matcher.end(1);
        String _group = matcher.group(1);
        String _plus = ("__x__" + _group);
        List<? extends Object> replaceAttr = Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(Integer.valueOf(_start), Integer.valueOf(_end), _plus));
        replaces.add(replaceAttr);
        String content = matcher.group(2);
        int _length = content.length();
        int _minus = (_length - 1);
        String contentCode = content.substring(1, _minus);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("\"");
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("\"");
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("&quot;");
        String _replaceAll_1 = contentCode.replaceAll(_builder_2.toString(), _builder_3.toString());
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append("\\}");
        StringConcatenation _builder_5 = new StringConcatenation();
        _builder_5.append("}");
        String _replaceAll_2 = _replaceAll_1.replaceAll(_builder_4.toString(), _builder_5.toString());
        _builder_1.append(_replaceAll_2, "");
        _builder_1.append("\"");
        String newVal = _builder_1.toString();
        int _start_1 = matcher.start(2);
        int _end_1 = matcher.end(2);
        List<? extends Object> replaceVal = Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(Integer.valueOf(_start_1), Integer.valueOf(_end_1), newVal));
        replaces.add(replaceVal);
      }
    }
    List<List> _reverse = ListExtensions.<List>reverse(replaces);
    final Consumer<List> _function = (List it) -> {
      Object _get = it.get(0);
      Object _get_1 = it.get(1);
      Object _get_2 = it.get(2);
      newSource.replace((((Integer) _get)).intValue(), (((Integer) _get_1)).intValue(), ((String) _get_2));
    };
    _reverse.forEach(_function);
    return newSource.toString();
  }
  
  @Override
  public void startElement(final String uri, final String localName, final String qName, final Attributes attributes) throws SAXException {
    this.tagsIncrement++;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("_createChildren_");
    _builder.append(this.tagsIncrement, "");
    String childProcName = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("_createAttributes_");
    _builder_1.append(this.tagsIncrement, "");
    String attrProcName = _builder_1.toString();
    String elName = qName;
    String tagSimpleName = elName;
    final Type viewType = this.findViewType(this.context, elName, this.importList);
    boolean _equals = Objects.equal(viewType, null);
    if (_equals) {
      this.errorList.add(("Couldn\'t find view with type " + elName));
    } else {
      String _qualifiedName = viewType.getQualifiedName();
      elName = _qualifiedName;
    }
    String attrsProc = "";
    int _length = attributes.getLength();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _length, true);
    for (final Integer i : _doubleDotLessThan) {
      {
        String attrName = attributes.getLocalName((i).intValue());
        String attrValue = attributes.getValue((i).intValue());
        boolean isJavaCode = attrName.startsWith("__x__");
        String _xifexpression = null;
        boolean _startsWith = attrName.startsWith("__x__");
        if (_startsWith) {
          int _length_1 = "__x__".length();
          _xifexpression = attrName.substring(_length_1);
        } else {
          _xifexpression = attrName;
        }
        final String property = _xifexpression;
        String _substring = property.substring(0, 1);
        String _upperCase = _substring.toUpperCase();
        String _plus = ("set" + _upperCase);
        String _substring_1 = property.substring(1);
        final String propertySetter = (_plus + _substring_1);
        String _attrsProc = attrsProc;
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("// ");
        _builder_2.append(propertySetter, "");
        String _plus_1 = (_builder_2.toString() + "\n");
        attrsProc = (_attrsProc + _plus_1);
        List<MethodDeclaration> setterMethods = CollectionLiterals.<MethodDeclaration>newArrayList();
        ClassDeclaration currentClass = ((ClassDeclaration) viewType);
        Iterable<? extends MethodDeclaration> _declaredMethods = currentClass.getDeclaredMethods();
        final Function1<MethodDeclaration, Boolean> _function = (MethodDeclaration it) -> {
          boolean _and = false;
          String _simpleName = it.getSimpleName();
          boolean _equals_1 = Objects.equal(_simpleName, propertySetter);
          if (!_equals_1) {
            _and = false;
          } else {
            Iterable<? extends ParameterDeclaration> _parameters = it.getParameters();
            int _size = IterableExtensions.size(_parameters);
            boolean _equals_2 = (_size == 1);
            _and = _equals_2;
          }
          return Boolean.valueOf(_and);
        };
        Iterable<? extends MethodDeclaration> methods = IterableExtensions.filter(_declaredMethods, _function);
        Iterables.<MethodDeclaration>addAll(setterMethods, methods);
        TypeReference _newTypeReference = this.context.newTypeReference(currentClass);
        Iterable<? extends TypeReference> declaringClasses = this.findDeclaringClasses(this.context, _newTypeReference, propertySetter);
        final Function1<TypeReference, Iterable<? extends ResolvedMethod>> _function_1 = (TypeReference it) -> {
          return it.getDeclaredResolvedMethods();
        };
        Iterable<Iterable<? extends ResolvedMethod>> _map = IterableExtensions.map(declaringClasses, _function_1);
        Iterable<ResolvedMethod> _flatten = Iterables.<ResolvedMethod>concat(_map);
        final Function1<ResolvedMethod, MethodDeclaration> _function_2 = (ResolvedMethod it) -> {
          return it.getDeclaration();
        };
        Iterable<MethodDeclaration> upstreamMethods = IterableExtensions.<ResolvedMethod, MethodDeclaration>map(_flatten, _function_2);
        final Function1<MethodDeclaration, Boolean> _function_3 = (MethodDeclaration it) -> {
          boolean _and = false;
          String _simpleName = it.getSimpleName();
          boolean _equals_1 = Objects.equal(_simpleName, propertySetter);
          if (!_equals_1) {
            _and = false;
          } else {
            Iterable<? extends ParameterDeclaration> _parameters = it.getParameters();
            int _size = IterableExtensions.size(_parameters);
            boolean _equals_2 = (_size == 1);
            _and = _equals_2;
          }
          return Boolean.valueOf(_and);
        };
        Iterable<MethodDeclaration> _filter = IterableExtensions.<MethodDeclaration>filter(upstreamMethods, _function_3);
        Iterables.<MethodDeclaration>addAll(setterMethods, _filter);
        final Function1<MethodDeclaration, Boolean> _function_4 = (MethodDeclaration it) -> {
          Iterable<? extends ParameterDeclaration> _parameters = it.getParameters();
          final Function1<ParameterDeclaration, Boolean> _function_5 = (ParameterDeclaration it_1) -> {
            return Boolean.valueOf(true);
          };
          ParameterDeclaration _findFirst = IterableExtensions.findFirst(_parameters, _function_5);
          TypeReference _type = _findFirst.getType();
          Class<?> _procedureType = this.getProcedureType(this.context, _type);
          return Boolean.valueOf((!Objects.equal(_procedureType, null)));
        };
        final MethodDeclaration closureSetter = IterableExtensions.<MethodDeclaration>findFirst(setterMethods, _function_4);
        boolean _isEmpty = setterMethods.isEmpty();
        boolean hasSetter = (!_isEmpty);
        String _xifexpression_1 = null;
        if (isJavaCode) {
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append("\"");
          _xifexpression_1 = attrValue.replaceAll("&quot;", _builder_3.toString());
        } else {
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append("\\\"");
          String _replaceAll = attrValue.replaceAll("&quot;", _builder_4.toString());
          String _plus_2 = ("\"" + _replaceAll);
          _xifexpression_1 = (_plus_2 + "\"");
        }
        String value = _xifexpression_1;
        boolean _notEquals = (!Objects.equal(closureSetter, null));
        if (_notEquals) {
          Iterable<? extends ParameterDeclaration> _parameters = closureSetter.getParameters();
          final Function1<ParameterDeclaration, Boolean> _function_5 = (ParameterDeclaration it) -> {
            return Boolean.valueOf(true);
          };
          ParameterDeclaration _findFirst = IterableExtensions.findFirst(_parameters, _function_5);
          TypeReference _type = _findFirst.getType();
          Class<?> _procedureType = this.getProcedureType(this.context, _type);
          String closureType = _procedureType.getCanonicalName();
          Iterable<? extends ParameterDeclaration> _parameters_1 = closureSetter.getParameters();
          final Function1<ParameterDeclaration, Boolean> _function_6 = (ParameterDeclaration it) -> {
            return Boolean.valueOf(true);
          };
          ParameterDeclaration _findFirst_1 = IterableExtensions.findFirst(_parameters_1, _function_6);
          TypeReference _type_1 = _findFirst_1.getType();
          List<TypeReference> _actualTypeArguments = _type_1.getActualTypeArguments();
          final Function1<TypeReference, String> _function_7 = (TypeReference it) -> {
            TypeReference _lowerBound = it.getLowerBound();
            return _lowerBound.getName();
          };
          final List<String> typeList = ListExtensions.<TypeReference, String>map(_actualTypeArguments, _function_7);
          final List<String> paramList = CollectionLiterals.<String>newArrayList();
          int _size = typeList.size();
          ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size, true);
          for (final Integer index : _doubleDotLessThan_1) {
            StringConcatenation _builder_5 = new StringConcatenation();
            _builder_5.append("final ");
            String _get = typeList.get((index).intValue());
            _builder_5.append(_get, "");
            _builder_5.append(" $");
            _builder_5.append(index, "");
            paramList.add(_builder_5.toString());
          }
          String _attrsProc_1 = attrsProc;
          StringConcatenation _builder_6 = new StringConcatenation();
          _builder_6.append("final ");
          _builder_6.append(closureType, "");
          _builder_6.append("<");
          String _join = IterableExtensions.join(typeList, ",");
          _builder_6.append(_join, "");
          _builder_6.append("> _");
          _builder_6.append(property, "");
          _builder_6.append("_handler = new ");
          _builder_6.append(closureType, "");
          _builder_6.append("<");
          String _join_1 = IterableExtensions.join(typeList, ",");
          _builder_6.append(_join_1, "");
          _builder_6.append(">() {");
          _builder_6.newLineIfNotEmpty();
          _builder_6.append("\t\t\t\t\t\t");
          _builder_6.append("public void apply(");
          String _join_2 = IterableExtensions.join(paramList, ",");
          _builder_6.append(_join_2, "\t\t\t\t\t\t");
          _builder_6.append(") {");
          _builder_6.newLineIfNotEmpty();
          _builder_6.append("\t\t\t\t\t\t\t");
          TypeReference _newSelfTypeReference = this.context.newSelfTypeReference(this.declaringType);
          _builder_6.append(_newSelfTypeReference, "\t\t\t\t\t\t\t");
          _builder_6.append(" self =  ");
          String _simpleName = this.declaringType.getSimpleName();
          _builder_6.append(_simpleName, "\t\t\t\t\t\t\t");
          _builder_6.append(".this;");
          _builder_6.newLineIfNotEmpty();
          _builder_6.append("\t\t\t\t\t\t\t");
          _builder_6.append(value, "\t\t\t\t\t\t\t");
          String _xifexpression_2 = null;
          if ((!isJavaCode)) {
            _xifexpression_2 = "()";
          } else {
            _xifexpression_2 = "";
          }
          _builder_6.append(_xifexpression_2, "\t\t\t\t\t\t\t");
          _builder_6.append(";");
          _builder_6.newLineIfNotEmpty();
          _builder_6.append("\t\t\t\t\t\t");
          _builder_6.append("} ");
          _builder_6.newLine();
          _builder_6.append("\t\t\t\t\t");
          _builder_6.append("};");
          _builder_6.newLine();
          _builder_6.append("\t\t\t\t\t");
          _builder_6.append("it.");
          _builder_6.append(propertySetter, "\t\t\t\t\t");
          _builder_6.append("(_");
          _builder_6.append(property, "\t\t\t\t\t");
          _builder_6.append("_handler);");
          _builder_6.newLineIfNotEmpty();
          _builder_6.append("\t\t\t\t\t");
          _builder_6.newLine();
          attrsProc = (_attrsProc_1 + _builder_6);
        } else {
          if (hasSetter) {
            String _attrsProc_2 = attrsProc;
            StringConcatenation _builder_7 = new StringConcatenation();
            _builder_7.append("it.");
            _builder_7.append(propertySetter, "");
            _builder_7.append("(");
            _builder_7.append(value, "");
            _builder_7.append(");");
            String _plus_3 = (_builder_7.toString() + "\n");
            attrsProc = (_attrsProc_2 + _plus_3);
          } else {
            String _attrsProc_3 = attrsProc;
            StringConcatenation _builder_8 = new StringConcatenation();
            _builder_8.append("it.setAttribute(\"");
            _builder_8.append(property, "");
            _builder_8.append("\",");
            _builder_8.append(value, "");
            _builder_8.append(");");
            String _plus_4 = (_builder_8.toString() + "\n");
            attrsProc = (_attrsProc_3 + _plus_4);
          }
        }
      }
    }
    StringBuilder _stringBuilder = new StringBuilder();
    this.currentProc = _stringBuilder;
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<");
    _builder_2.append(elName, "");
    _builder_2.append("> ");
    _builder_2.append(attrProcName, "");
    _builder_2.append(" = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<");
    _builder_2.append(elName, "");
    _builder_2.append(">() {");
    _builder_2.newLineIfNotEmpty();
    _builder_2.append("public void apply(final ");
    _builder_2.append(elName, "");
    _builder_2.append(" it) {");
    _builder_2.newLineIfNotEmpty();
    _builder_2.append("\t\t");
    _builder_2.append(attrsProc, "\t\t");
    _builder_2.newLineIfNotEmpty();
    _builder_2.append("\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("};");
    _builder_2.newLine();
    _builder_2.newLine();
    _builder_2.append("final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<");
    _builder_2.append(elName, "");
    _builder_2.append("> ");
    _builder_2.append(childProcName, "");
    _builder_2.append(" = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<");
    _builder_2.append(elName, "");
    _builder_2.append(">() {");
    _builder_2.newLineIfNotEmpty();
    _builder_2.append("public void apply(final ");
    _builder_2.append(elName, "");
    _builder_2.append(" it) {");
    _builder_2.newLineIfNotEmpty();
    _builder_2.newLine();
    this.currentProc.append(_builder_2);
    boolean _notEquals = (!Objects.equal(this.currentEl, null));
    if (_notEquals) {
      this.elStack.push(this.currentEl);
    }
    Pair<String, String> _mappedTo = Pair.<String, String>of("name", elName);
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("simpleName", tagSimpleName);
    Pair<String, StringBuilder> _mappedTo_2 = Pair.<String, StringBuilder>of("childrenProcBody", this.currentProc);
    Pair<String, String> _mappedTo_3 = Pair.<String, String>of("attrProcBody", "");
    Pair<String, String> _mappedTo_4 = Pair.<String, String>of("childrenProcName", childProcName);
    Pair<String, String> _mappedTo_5 = Pair.<String, String>of("attrProcName", attrProcName);
    this.currentEl = Collections.<String, Object>unmodifiableMap(CollectionLiterals.<String, Object>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4, _mappedTo_5));
  }
  
  @Override
  public void characters(final char[] ch, final int start, final int length) throws SAXException {
    String _copyValueOf = String.copyValueOf(ch, start, length);
    String _trim = _copyValueOf.trim();
    this.currentProc.append(_trim);
  }
  
  @Override
  public void endElement(final String uri, final String localName, final String qName) throws SAXException {
    super.endElement(uri, localName, qName);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("};");
    _builder.newLine();
    this.currentProc.append(_builder);
    boolean _isEmpty = this.elStack.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      Map<String, Object> myEl = this.currentEl;
      StringBuilder myProc = this.currentProc;
      Map<String, Object> _pop = this.elStack.pop();
      this.currentEl = _pop;
      Object _get = this.currentEl.get("childrenProcBody");
      this.currentProc = ((StringBuilder) _get);
      this.currentProc.append(myProc);
      StringConcatenation _builder_1 = new StringConcatenation();
      Object _get_1 = myEl.get("name");
      _builder_1.append(_get_1, "");
      _builder_1.append(".");
      Object _get_2 = myEl.get("simpleName");
      _builder_1.append(_get_2, "");
      _builder_1.append("(it, ");
      Object _get_3 = myEl.get("attrProcName");
      _builder_1.append(_get_3, "");
      _builder_1.append(", ");
      Object _get_4 = myEl.get("childrenProcName");
      _builder_1.append(_get_4, "");
      _builder_1.append(");");
      this.currentProc.append(_builder_1);
    } else {
      this.currentProc.append("return ");
      StringConcatenation _builder_2 = new StringConcatenation();
      Object _get_5 = this.currentEl.get("name");
      _builder_2.append(_get_5, "");
      _builder_2.append(".");
      Object _get_6 = this.currentEl.get("simpleName");
      _builder_2.append(_get_6, "");
      _builder_2.append("(this, ");
      Object _get_7 = this.currentEl.get("attrProcName");
      _builder_2.append(_get_7, "");
      _builder_2.append(", ");
      Object _get_8 = this.currentEl.get("childrenProcName");
      _builder_2.append(_get_8, "");
      _builder_2.append(");");
      this.currentProc.append(_builder_2);
      String _string = this.currentProc.toString();
      String _translateCode = this.translateCode(_string);
      this.renderBody = _translateCode;
    }
  }
  
  public void parseLayout(@Extension final TransformationContext context, final MutableTypeDeclaration declaringType, final List importList, final String layoutStr) {
    try {
      this.context = context;
      this.importList = importList;
      this.declaringType = declaringType;
      String source = LayoutParser.preprocess(layoutStr);
      SAXParserFactory parserFactor = SAXParserFactory.newInstance();
      SAXParser parser = parserFactor.newSAXParser();
      byte[] _bytes = source.getBytes(StandardCharsets.UTF_8);
      InputStream stream = new ByteArrayInputStream(_bytes);
      parser.parse(stream, this);
      Stack<Map<String, Object>> elStack = new Stack<Map<String, Object>>();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Pure
  public String getRenderBody() {
    return this.renderBody;
  }
  
  public void setRenderBody(final String renderBody) {
    this.renderBody = renderBody;
  }
}
