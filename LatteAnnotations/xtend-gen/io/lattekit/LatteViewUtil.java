package io.lattekit;

import com.google.common.base.Objects;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class LatteViewUtil {
  public static MutableMethodDeclaration addVariantMethods(@Extension final TransformationContext context, final MutableTypeDeclaration viewType, final String variantName, final String processingMethod) {
    MutableMethodDeclaration _xblockexpression = null;
    {
      Type _findTypeGlobally = context.findTypeGlobally("io.lattekit.ui.View");
      final TypeReference parentTypeRef = context.newTypeReference(_findTypeGlobally);
      final TypeReference StringTypeRef = context.newTypeReference(String.class);
      TypeReference _newTypeReference = context.newTypeReference(viewType);
      final TypeReference AttrsProcTypeRef = context.newTypeReference(Procedure1.class, _newTypeReference);
      final TypeReference returnTR = context.newTypeReference(viewType);
      final Procedure1<MutableMethodDeclaration> _function = (MutableMethodDeclaration it) -> {
        it.setStatic(true);
        it.addParameter("parentView", parentTypeRef);
        it.addParameter("id", StringTypeRef);
        it.addParameter("attrs", AttrsProcTypeRef);
        it.addParameter("children", AttrsProcTypeRef);
        it.setReturnType(returnTR);
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            String _simpleName = viewType.getSimpleName();
            _builder.append(_simpleName, "");
            _builder.append(" me = new ");
            String _simpleName_1 = viewType.getSimpleName();
            _builder.append(_simpleName_1, "");
            _builder.append("();");
            _builder.newLineIfNotEmpty();
            _builder.append("me.processNode(parentView,id,attrs,children);");
            _builder.newLine();
            _builder.append("me.viewVariant = \"");
            _builder.append(variantName, "");
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
            String _xifexpression = null;
            boolean _notEquals = (!Objects.equal(processingMethod, null));
            if (_notEquals) {
              _xifexpression = (("me." + processingMethod) + "();");
            } else {
              _xifexpression = "";
            }
            _builder.append(_xifexpression, "");
            _builder.newLineIfNotEmpty();
            _builder.append("return me;");
            _builder.newLine();
          }
        };
        it.setBody(_client);
      };
      viewType.addMethod(variantName, _function);
      final Procedure1<MutableMethodDeclaration> _function_1 = (MutableMethodDeclaration it) -> {
        it.setStatic(true);
        it.addParameter("parentView", parentTypeRef);
        it.addParameter("attrs", AttrsProcTypeRef);
        it.addParameter("children", AttrsProcTypeRef);
        it.setReturnType(returnTR);
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            String _simpleName = viewType.getSimpleName();
            _builder.append(_simpleName, "");
            _builder.append(" me = new ");
            String _simpleName_1 = viewType.getSimpleName();
            _builder.append(_simpleName_1, "");
            _builder.append("();");
            _builder.newLineIfNotEmpty();
            _builder.append("me.processNode(parentView,null,attrs,children);");
            _builder.newLine();
            _builder.append("me.viewVariant = \"");
            _builder.append(variantName, "");
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
            String _xifexpression = null;
            boolean _notEquals = (!Objects.equal(processingMethod, null));
            if (_notEquals) {
              _xifexpression = (("me." + processingMethod) + "();");
            } else {
              _xifexpression = "";
            }
            _builder.append(_xifexpression, "");
            _builder.newLineIfNotEmpty();
            _builder.append("return me;");
            _builder.newLine();
          }
        };
        it.setBody(_client);
      };
      viewType.addMethod(variantName, _function_1);
      final Procedure1<MutableMethodDeclaration> _function_2 = (MutableMethodDeclaration it) -> {
        it.setStatic(true);
        it.addParameter("parentView", parentTypeRef);
        it.addParameter("id", StringTypeRef);
        it.addParameter("attrs", AttrsProcTypeRef);
        it.setReturnType(returnTR);
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            String _simpleName = viewType.getSimpleName();
            _builder.append(_simpleName, "");
            _builder.append(" me = new ");
            String _simpleName_1 = viewType.getSimpleName();
            _builder.append(_simpleName_1, "");
            _builder.append("();");
            _builder.newLineIfNotEmpty();
            _builder.append("me.processNode(parentView,id,attrs,null);");
            _builder.newLine();
            _builder.append("me.viewVariant = \"");
            _builder.append(variantName, "");
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
            String _xifexpression = null;
            boolean _notEquals = (!Objects.equal(processingMethod, null));
            if (_notEquals) {
              _xifexpression = (("me." + processingMethod) + "();");
            } else {
              _xifexpression = "";
            }
            _builder.append(_xifexpression, "");
            _builder.newLineIfNotEmpty();
            _builder.append("return me;");
            _builder.newLine();
          }
        };
        it.setBody(_client);
      };
      viewType.addMethod(variantName, _function_2);
      final Procedure1<MutableMethodDeclaration> _function_3 = (MutableMethodDeclaration it) -> {
        it.setStatic(true);
        it.addParameter("parentView", parentTypeRef);
        it.addParameter("attrs", AttrsProcTypeRef);
        it.setReturnType(returnTR);
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            String _simpleName = viewType.getSimpleName();
            _builder.append(_simpleName, "");
            _builder.append(" me = new ");
            String _simpleName_1 = viewType.getSimpleName();
            _builder.append(_simpleName_1, "");
            _builder.append("();");
            _builder.newLineIfNotEmpty();
            _builder.append("me.processNode(parentView,null,attrs,null);");
            _builder.newLine();
            _builder.append("me.viewVariant = \"");
            _builder.append(variantName, "");
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
            String _xifexpression = null;
            boolean _notEquals = (!Objects.equal(processingMethod, null));
            if (_notEquals) {
              _xifexpression = (("me." + processingMethod) + "();");
            } else {
              _xifexpression = "";
            }
            _builder.append(_xifexpression, "");
            _builder.newLineIfNotEmpty();
            _builder.append("return me;");
            _builder.newLine();
          }
        };
        it.setBody(_client);
      };
      viewType.addMethod(variantName, _function_3);
      final Procedure1<MutableMethodDeclaration> _function_4 = (MutableMethodDeclaration it) -> {
        it.setStatic(true);
        it.addParameter("parentView", parentTypeRef);
        it.addParameter("id", StringTypeRef);
        it.setReturnType(returnTR);
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            String _simpleName = viewType.getSimpleName();
            _builder.append(_simpleName, "");
            _builder.append(" me = new ");
            String _simpleName_1 = viewType.getSimpleName();
            _builder.append(_simpleName_1, "");
            _builder.append("();;");
            _builder.newLineIfNotEmpty();
            _builder.append("me.processNode(parentView,id,null,null);");
            _builder.newLine();
            _builder.append("me.viewVariant = \"");
            _builder.append(variantName, "");
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
            String _xifexpression = null;
            boolean _notEquals = (!Objects.equal(processingMethod, null));
            if (_notEquals) {
              _xifexpression = (("me." + processingMethod) + "();");
            } else {
              _xifexpression = "";
            }
            _builder.append(_xifexpression, "");
            _builder.newLineIfNotEmpty();
            _builder.append("return me;");
            _builder.newLine();
          }
        };
        it.setBody(_client);
      };
      viewType.addMethod(variantName, _function_4);
      final Procedure1<MutableMethodDeclaration> _function_5 = (MutableMethodDeclaration it) -> {
        it.setStatic(true);
        it.addParameter("parentView", parentTypeRef);
        it.setReturnType(returnTR);
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            String _simpleName = viewType.getSimpleName();
            _builder.append(_simpleName, "");
            _builder.append(" me = new ");
            String _simpleName_1 = viewType.getSimpleName();
            _builder.append(_simpleName_1, "");
            _builder.append("();");
            _builder.newLineIfNotEmpty();
            _builder.append("me.processNode(parentView,null,null,null);");
            _builder.newLine();
            _builder.append("me.viewVariant = \"");
            _builder.append(variantName, "");
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
            String _xifexpression = null;
            boolean _notEquals = (!Objects.equal(processingMethod, null));
            if (_notEquals) {
              _xifexpression = (("me." + processingMethod) + "();");
            } else {
              _xifexpression = "";
            }
            _builder.append(_xifexpression, "");
            _builder.newLineIfNotEmpty();
            _builder.append("return me;");
            _builder.newLine();
          }
        };
        it.setBody(_client);
      };
      _xblockexpression = viewType.addMethod(variantName, _function_5);
    }
    return _xblockexpression;
  }
}
