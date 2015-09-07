package io.lattekit;

import com.google.common.base.Objects;
import io.lattekit.LatteView;
import io.lattekit.LatteViewUtil;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class LatteViewProcessor extends AbstractClassProcessor {
  @Override
  public void doTransform(final MutableClassDeclaration annotatedClass, @Extension final TransformationContext context) {
    super.doTransform(annotatedClass, context);
    final String className = annotatedClass.getSimpleName();
    final Procedure1<MutableFieldDeclaration> _function = (MutableFieldDeclaration it) -> {
      TypeReference _newTypeReference = context.newTypeReference(String.class);
      it.setType(_newTypeReference);
    };
    annotatedClass.addField("viewVariant", _function);
    List<String> variantList = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(className));
    Iterable<? extends AnnotationReference> _annotations = annotatedClass.getAnnotations();
    final Function1<AnnotationReference, Boolean> _function_1 = (AnnotationReference a) -> {
      AnnotationTypeDeclaration _annotationTypeDeclaration = a.getAnnotationTypeDeclaration();
      TypeReference _newTypeReference = context.newTypeReference(LatteView.class);
      Type _type = _newTypeReference.getType();
      return Boolean.valueOf(Objects.equal(_annotationTypeDeclaration, _type));
    };
    AnnotationReference _findFirst = IterableExtensions.findFirst(_annotations, _function_1);
    String[] variantListParam = _findFirst.getStringArrayValue("variants");
    final String[] _converted_variantListParam = (String[])variantListParam;
    int _size = ((List<String>)Conversions.doWrapArray(_converted_variantListParam)).size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      final String[] _converted_variantListParam_1 = (String[])variantListParam;
      variantList = ((List<String>)Conversions.doWrapArray(_converted_variantListParam_1));
    }
    TypeReference _newTypeReference = context.newTypeReference(String.class);
    final MutableMethodDeclaration initMethod = annotatedClass.findDeclaredMethod("init", _newTypeReference);
    final Consumer<String> _function_2 = (String it) -> {
      String _simpleName = null;
      if (initMethod!=null) {
        _simpleName=initMethod.getSimpleName();
      }
      LatteViewUtil.addVariantMethods(context, annotatedClass, it, _simpleName);
    };
    variantList.forEach(_function_2);
  }
}
