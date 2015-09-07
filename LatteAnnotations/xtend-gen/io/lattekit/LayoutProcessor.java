package io.lattekit;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import io.lattekit.Layout;
import io.lattekit.LayoutParser;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.macro.AbstractMethodProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class LayoutProcessor extends AbstractMethodProcessor {
  @Override
  public void doTransform(final MutableMethodDeclaration annotatedMethod, @Extension final TransformationContext context) {
    super.doTransform(annotatedMethod, context);
    Expression _body = annotatedMethod.getBody();
    final String layoutStr = _body.toString();
    annotatedMethod.markAsRead();
    ArrayList<String> importList = CollectionLiterals.<String>newArrayList("io.lattekit.ui");
    Iterable<? extends AnnotationReference> _annotations = annotatedMethod.getAnnotations();
    final Function1<AnnotationReference, Boolean> _function = (AnnotationReference a) -> {
      AnnotationTypeDeclaration _annotationTypeDeclaration = a.getAnnotationTypeDeclaration();
      TypeReference _newTypeReference = context.newTypeReference(Layout.class);
      Type _type = _newTypeReference.getType();
      return Boolean.valueOf(Objects.equal(_annotationTypeDeclaration, _type));
    };
    AnnotationReference _findFirst = IterableExtensions.findFirst(_annotations, _function);
    String[] importListParam = _findFirst.getStringArrayValue("imports");
    final String[] _converted_importListParam = (String[])importListParam;
    int _size = ((List<String>)Conversions.doWrapArray(_converted_importListParam)).size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      final String[] _converted_importListParam_1 = (String[])importListParam;
      Iterables.<String>addAll(importList, ((Iterable<? extends String>)Conversions.doWrapArray(_converted_importListParam_1)));
    }
    final LayoutParser layoutParser = new LayoutParser();
    int _length = layoutStr.length();
    int _minus = (_length - 3);
    final String layoutSource = layoutStr.substring(3, _minus);
    MutableTypeDeclaration _declaringType = annotatedMethod.getDeclaringType();
    layoutParser.parseLayout(context, _declaringType, importList, layoutSource);
    Type _findTypeGlobally = context.findTypeGlobally("io.lattekit.ui.View");
    TypeReference _newTypeReference = context.newTypeReference(_findTypeGlobally);
    annotatedMethod.setReturnType(_newTypeReference);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        String _renderBody = layoutParser.getRenderBody();
        _builder.append(_renderBody, "");
        _builder.newLineIfNotEmpty();
      }
    };
    annotatedMethod.setBody(_client);
  }
}
