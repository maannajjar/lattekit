package io.lattekit;

import org.eclipse.xtend.lib.macro.AbstractFieldProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.services.AnnotationReferenceBuildContext;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class StateProcessor extends AbstractFieldProcessor {
  @Override
  public void doTransform(final MutableFieldDeclaration annotatedField, @Extension final TransformationContext context) {
    super.doTransform(annotatedField, context);
    final String fieldName = annotatedField.getSimpleName();
    final TypeReference rawType = annotatedField.getType();
    String _substring = fieldName.substring(0, 1);
    String _upperCase = _substring.toUpperCase();
    String _substring_1 = fieldName.substring(1);
    final String capiatlized = (_upperCase + _substring_1);
    final String rawName = fieldName;
    annotatedField.setSimpleName(("_" + rawName));
    final Procedure1<AnnotationReferenceBuildContext> _function = (AnnotationReferenceBuildContext it) -> {
      it.setStringValue("value", "all");
    };
    AnnotationReference _newAnnotationReference = context.newAnnotationReference(SuppressWarnings.class, _function);
    annotatedField.addAnnotation(_newAnnotationReference);
    annotatedField.markAsRead();
    MutableTypeDeclaration _declaringType = annotatedField.getDeclaringType();
    final Procedure1<MutableMethodDeclaration> _function_1 = (MutableMethodDeclaration it) -> {
      it.setReturnType(rawType);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("return _");
          _builder.append(rawName, "");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      };
      it.setBody(_client);
    };
    _declaringType.addMethod(("get" + capiatlized), _function_1);
    MutableTypeDeclaration _declaringType_1 = annotatedField.getDeclaringType();
    final Procedure1<MutableMethodDeclaration> _function_2 = (MutableMethodDeclaration it) -> {
      it.addParameter("newValue", rawType);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("_");
          _builder.append(rawName, "");
          _builder.append(" = newValue;");
          _builder.newLineIfNotEmpty();
          _builder.append("onStateChanged(\"");
          _builder.append(rawName, "");
          _builder.append("\");");
          _builder.newLineIfNotEmpty();
        }
      };
      it.setBody(_client);
    };
    _declaringType_1.addMethod(("set" + capiatlized), _function_2);
  }
}
