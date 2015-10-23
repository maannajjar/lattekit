// Generated from io/lattekit/compiler/LatteXtend.g4 by ANTLR 4.5.1
package io.lattekit.compiler;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LatteXtendParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LatteXtendVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(LatteXtendParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#packageDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageDeclaration(LatteXtendParser.PackageDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDeclaration(LatteXtendParser.ImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#typeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDeclaration(LatteXtendParser.TypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifier(LatteXtendParser.ModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#classOrInterfaceModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassOrInterfaceModifier(LatteXtendParser.ClassOrInterfaceModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#variableModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableModifier(LatteXtendParser.VariableModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(LatteXtendParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#typeParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameters(LatteXtendParser.TypeParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#typeParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameter(LatteXtendParser.TypeParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#typeBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBound(LatteXtendParser.TypeBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#enumDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDeclaration(LatteXtendParser.EnumDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#enumConstants}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstants(LatteXtendParser.EnumConstantsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#enumConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstant(LatteXtendParser.EnumConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumBodyDeclarations(LatteXtendParser.EnumBodyDeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceDeclaration(LatteXtendParser.InterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#typeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeList(LatteXtendParser.TypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(LatteXtendParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#interfaceBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceBody(LatteXtendParser.InterfaceBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBodyDeclaration(LatteXtendParser.ClassBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#memberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberDeclaration(LatteXtendParser.MemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(LatteXtendParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#genericMethodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericMethodDeclaration(LatteXtendParser.GenericMethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(LatteXtendParser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#genericConstructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericConstructorDeclaration(LatteXtendParser.GenericConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(LatteXtendParser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#interfaceBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceBodyDeclaration(LatteXtendParser.InterfaceBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMemberDeclaration(LatteXtendParser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#constDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDeclaration(LatteXtendParser.ConstDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#constantDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDeclarator(LatteXtendParser.ConstantDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMethodDeclaration(LatteXtendParser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#genericInterfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericInterfaceMethodDeclaration(LatteXtendParser.GenericInterfaceMethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#variableDeclarators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarators(LatteXtendParser.VariableDeclaratorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#variableDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarator(LatteXtendParser.VariableDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorId(LatteXtendParser.VariableDeclaratorIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#variableInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializer(LatteXtendParser.VariableInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#arrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitializer(LatteXtendParser.ArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#enumConstantName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstantName(LatteXtendParser.EnumConstantNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(LatteXtendParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassOrInterfaceType(LatteXtendParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(LatteXtendParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(LatteXtendParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#typeArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArguments(LatteXtendParser.TypeArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#typeArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgument(LatteXtendParser.TypeArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#qualifiedNameList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedNameList(LatteXtendParser.QualifiedNameListContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(LatteXtendParser.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterList(LatteXtendParser.FormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(LatteXtendParser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLastFormalParameter(LatteXtendParser.LastFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(LatteXtendParser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#constructorBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorBody(LatteXtendParser.ConstructorBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(LatteXtendParser.QualifiedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(LatteXtendParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#annotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotation(LatteXtendParser.AnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#annotationName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationName(LatteXtendParser.AnnotationNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#elementValuePairs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValuePairs(LatteXtendParser.ElementValuePairsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#elementValuePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValuePair(LatteXtendParser.ElementValuePairContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#elementValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValue(LatteXtendParser.ElementValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValueArrayInitializer(LatteXtendParser.ElementValueArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeDeclaration(LatteXtendParser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#annotationTypeBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeBody(LatteXtendParser.AnnotationTypeBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeElementDeclaration(LatteXtendParser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#annotationTypeElementRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeElementRest(LatteXtendParser.AnnotationTypeElementRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#annotationMethodOrConstantRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationMethodOrConstantRest(LatteXtendParser.AnnotationMethodOrConstantRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#annotationMethodRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationMethodRest(LatteXtendParser.AnnotationMethodRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#annotationConstantRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationConstantRest(LatteXtendParser.AnnotationConstantRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultValue(LatteXtendParser.DefaultValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(LatteXtendParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#blockBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockBody(LatteXtendParser.BlockBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(LatteXtendParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#xmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlElement(LatteXtendParser.XmlElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#xmlAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlAttribute(LatteXtendParser.XmlAttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclarationStatement(LatteXtendParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclaration(LatteXtendParser.LocalVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(LatteXtendParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#catchClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchClause(LatteXtendParser.CatchClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#catchType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchType(LatteXtendParser.CatchTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#finallyBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinallyBlock(LatteXtendParser.FinallyBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#resourceSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResourceSpecification(LatteXtendParser.ResourceSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#resources}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResources(LatteXtendParser.ResourcesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#resource}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResource(LatteXtendParser.ResourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBlockStatementGroup(LatteXtendParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#switchLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchLabel(LatteXtendParser.SwitchLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#forControl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForControl(LatteXtendParser.ForControlContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(LatteXtendParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#enhancedForControl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnhancedForControl(LatteXtendParser.EnhancedForControlContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#forUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdate(LatteXtendParser.ForUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#parExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpression(LatteXtendParser.ParExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(LatteXtendParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#statementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpression(LatteXtendParser.StatementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#constantExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantExpression(LatteXtendParser.ConstantExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(LatteXtendParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(LatteXtendParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreator(LatteXtendParser.CreatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#createdName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatedName(LatteXtendParser.CreatedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#innerCreator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInnerCreator(LatteXtendParser.InnerCreatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#arrayCreatorRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreatorRest(LatteXtendParser.ArrayCreatorRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#classCreatorRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassCreatorRest(LatteXtendParser.ClassCreatorRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#explicitGenericInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitGenericInvocation(LatteXtendParser.ExplicitGenericInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#nonWildcardTypeArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonWildcardTypeArguments(LatteXtendParser.NonWildcardTypeArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgumentsOrDiamond(LatteXtendParser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#nonWildcardTypeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonWildcardTypeArgumentsOrDiamond(LatteXtendParser.NonWildcardTypeArgumentsOrDiamondContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#superSuffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperSuffix(LatteXtendParser.SuperSuffixContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#explicitGenericInvocationSuffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitGenericInvocationSuffix(LatteXtendParser.ExplicitGenericInvocationSuffixContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(LatteXtendParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#eos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEos(LatteXtendParser.EosContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteXtendParser#eof}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEof(LatteXtendParser.EofContext ctx);
}