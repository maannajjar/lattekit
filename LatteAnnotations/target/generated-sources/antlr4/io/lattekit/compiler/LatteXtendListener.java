// Generated from io/lattekit/compiler/LatteXtend.g4 by ANTLR 4.5.1
package io.lattekit.compiler;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LatteXtendParser}.
 */
public interface LatteXtendListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(LatteXtendParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(LatteXtendParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPackageDeclaration(LatteXtendParser.PackageDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPackageDeclaration(LatteXtendParser.PackageDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclaration(LatteXtendParser.ImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclaration(LatteXtendParser.ImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(LatteXtendParser.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(LatteXtendParser.TypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(LatteXtendParser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(LatteXtendParser.ModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#classOrInterfaceModifier}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceModifier(LatteXtendParser.ClassOrInterfaceModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#classOrInterfaceModifier}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceModifier(LatteXtendParser.ClassOrInterfaceModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void enterVariableModifier(LatteXtendParser.VariableModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void exitVariableModifier(LatteXtendParser.VariableModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(LatteXtendParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(LatteXtendParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameters(LatteXtendParser.TypeParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameters(LatteXtendParser.TypeParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameter(LatteXtendParser.TypeParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameter(LatteXtendParser.TypeParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#typeBound}.
	 * @param ctx the parse tree
	 */
	void enterTypeBound(LatteXtendParser.TypeBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#typeBound}.
	 * @param ctx the parse tree
	 */
	void exitTypeBound(LatteXtendParser.TypeBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEnumDeclaration(LatteXtendParser.EnumDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEnumDeclaration(LatteXtendParser.EnumDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#enumConstants}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstants(LatteXtendParser.EnumConstantsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#enumConstants}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstants(LatteXtendParser.EnumConstantsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstant(LatteXtendParser.EnumConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstant(LatteXtendParser.EnumConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterEnumBodyDeclarations(LatteXtendParser.EnumBodyDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitEnumBodyDeclarations(LatteXtendParser.EnumBodyDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceDeclaration(LatteXtendParser.InterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceDeclaration(LatteXtendParser.InterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#typeList}.
	 * @param ctx the parse tree
	 */
	void enterTypeList(LatteXtendParser.TypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#typeList}.
	 * @param ctx the parse tree
	 */
	void exitTypeList(LatteXtendParser.TypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(LatteXtendParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(LatteXtendParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBody(LatteXtendParser.InterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBody(LatteXtendParser.InterfaceBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclaration(LatteXtendParser.ClassBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclaration(LatteXtendParser.ClassBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#memberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMemberDeclaration(LatteXtendParser.MemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#memberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMemberDeclaration(LatteXtendParser.MemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(LatteXtendParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(LatteXtendParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#genericMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterGenericMethodDeclaration(LatteXtendParser.GenericMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#genericMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitGenericMethodDeclaration(LatteXtendParser.GenericMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclaration(LatteXtendParser.ConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclaration(LatteXtendParser.ConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#genericConstructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterGenericConstructorDeclaration(LatteXtendParser.GenericConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#genericConstructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitGenericConstructorDeclaration(LatteXtendParser.GenericConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(LatteXtendParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(LatteXtendParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#interfaceBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBodyDeclaration(LatteXtendParser.InterfaceBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#interfaceBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBodyDeclaration(LatteXtendParser.InterfaceBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMemberDeclaration(LatteXtendParser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMemberDeclaration(LatteXtendParser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#constDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstDeclaration(LatteXtendParser.ConstDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#constDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstDeclaration(LatteXtendParser.ConstDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#constantDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterConstantDeclarator(LatteXtendParser.ConstantDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#constantDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitConstantDeclarator(LatteXtendParser.ConstantDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethodDeclaration(LatteXtendParser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethodDeclaration(LatteXtendParser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#genericInterfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterGenericInterfaceMethodDeclaration(LatteXtendParser.GenericInterfaceMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#genericInterfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitGenericInterfaceMethodDeclaration(LatteXtendParser.GenericInterfaceMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#variableDeclarators}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarators(LatteXtendParser.VariableDeclaratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#variableDeclarators}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarators(LatteXtendParser.VariableDeclaratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarator(LatteXtendParser.VariableDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarator(LatteXtendParser.VariableDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorId(LatteXtendParser.VariableDeclaratorIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorId(LatteXtendParser.VariableDeclaratorIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializer(LatteXtendParser.VariableInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializer(LatteXtendParser.VariableInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializer(LatteXtendParser.ArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializer(LatteXtendParser.ArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#enumConstantName}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstantName(LatteXtendParser.EnumConstantNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#enumConstantName}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstantName(LatteXtendParser.EnumConstantNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(LatteXtendParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(LatteXtendParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceType(LatteXtendParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceType(LatteXtendParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(LatteXtendParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(LatteXtendParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(LatteXtendParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(LatteXtendParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void enterTypeArguments(LatteXtendParser.TypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void exitTypeArguments(LatteXtendParser.TypeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgument(LatteXtendParser.TypeArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgument(LatteXtendParser.TypeArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#qualifiedNameList}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedNameList(LatteXtendParser.QualifiedNameListContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#qualifiedNameList}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedNameList(LatteXtendParser.QualifiedNameListContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(LatteXtendParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(LatteXtendParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(LatteXtendParser.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(LatteXtendParser.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(LatteXtendParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(LatteXtendParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 */
	void enterLastFormalParameter(LatteXtendParser.LastFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 */
	void exitLastFormalParameter(LatteXtendParser.LastFormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(LatteXtendParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(LatteXtendParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void enterConstructorBody(LatteXtendParser.ConstructorBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void exitConstructorBody(LatteXtendParser.ConstructorBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(LatteXtendParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(LatteXtendParser.QualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(LatteXtendParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(LatteXtendParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(LatteXtendParser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(LatteXtendParser.AnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#annotationName}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationName(LatteXtendParser.AnnotationNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#annotationName}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationName(LatteXtendParser.AnnotationNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#elementValuePairs}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePairs(LatteXtendParser.ElementValuePairsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#elementValuePairs}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePairs(LatteXtendParser.ElementValuePairsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePair(LatteXtendParser.ElementValuePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePair(LatteXtendParser.ElementValuePairContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#elementValue}.
	 * @param ctx the parse tree
	 */
	void enterElementValue(LatteXtendParser.ElementValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#elementValue}.
	 * @param ctx the parse tree
	 */
	void exitElementValue(LatteXtendParser.ElementValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterElementValueArrayInitializer(LatteXtendParser.ElementValueArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitElementValueArrayInitializer(LatteXtendParser.ElementValueArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeDeclaration(LatteXtendParser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeDeclaration(LatteXtendParser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#annotationTypeBody}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeBody(LatteXtendParser.AnnotationTypeBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#annotationTypeBody}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeBody(LatteXtendParser.AnnotationTypeBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeElementDeclaration(LatteXtendParser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeElementDeclaration(LatteXtendParser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#annotationTypeElementRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeElementRest(LatteXtendParser.AnnotationTypeElementRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#annotationTypeElementRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeElementRest(LatteXtendParser.AnnotationTypeElementRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#annotationMethodOrConstantRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationMethodOrConstantRest(LatteXtendParser.AnnotationMethodOrConstantRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#annotationMethodOrConstantRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationMethodOrConstantRest(LatteXtendParser.AnnotationMethodOrConstantRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#annotationMethodRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationMethodRest(LatteXtendParser.AnnotationMethodRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#annotationMethodRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationMethodRest(LatteXtendParser.AnnotationMethodRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#annotationConstantRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationConstantRest(LatteXtendParser.AnnotationConstantRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#annotationConstantRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationConstantRest(LatteXtendParser.AnnotationConstantRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void enterDefaultValue(LatteXtendParser.DefaultValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void exitDefaultValue(LatteXtendParser.DefaultValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(LatteXtendParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(LatteXtendParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#blockBody}.
	 * @param ctx the parse tree
	 */
	void enterBlockBody(LatteXtendParser.BlockBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#blockBody}.
	 * @param ctx the parse tree
	 */
	void exitBlockBody(LatteXtendParser.BlockBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(LatteXtendParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(LatteXtendParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#xmlElement}.
	 * @param ctx the parse tree
	 */
	void enterXmlElement(LatteXtendParser.XmlElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#xmlElement}.
	 * @param ctx the parse tree
	 */
	void exitXmlElement(LatteXtendParser.XmlElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#xmlAttribute}.
	 * @param ctx the parse tree
	 */
	void enterXmlAttribute(LatteXtendParser.XmlAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#xmlAttribute}.
	 * @param ctx the parse tree
	 */
	void exitXmlAttribute(LatteXtendParser.XmlAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclarationStatement(LatteXtendParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclarationStatement(LatteXtendParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclaration(LatteXtendParser.LocalVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclaration(LatteXtendParser.LocalVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(LatteXtendParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(LatteXtendParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#catchClause}.
	 * @param ctx the parse tree
	 */
	void enterCatchClause(LatteXtendParser.CatchClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#catchClause}.
	 * @param ctx the parse tree
	 */
	void exitCatchClause(LatteXtendParser.CatchClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#catchType}.
	 * @param ctx the parse tree
	 */
	void enterCatchType(LatteXtendParser.CatchTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#catchType}.
	 * @param ctx the parse tree
	 */
	void exitCatchType(LatteXtendParser.CatchTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void enterFinallyBlock(LatteXtendParser.FinallyBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void exitFinallyBlock(LatteXtendParser.FinallyBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void enterResourceSpecification(LatteXtendParser.ResourceSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void exitResourceSpecification(LatteXtendParser.ResourceSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#resources}.
	 * @param ctx the parse tree
	 */
	void enterResources(LatteXtendParser.ResourcesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#resources}.
	 * @param ctx the parse tree
	 */
	void exitResources(LatteXtendParser.ResourcesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#resource}.
	 * @param ctx the parse tree
	 */
	void enterResource(LatteXtendParser.ResourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#resource}.
	 * @param ctx the parse tree
	 */
	void exitResource(LatteXtendParser.ResourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBlockStatementGroup(LatteXtendParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBlockStatementGroup(LatteXtendParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void enterSwitchLabel(LatteXtendParser.SwitchLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void exitSwitchLabel(LatteXtendParser.SwitchLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#forControl}.
	 * @param ctx the parse tree
	 */
	void enterForControl(LatteXtendParser.ForControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#forControl}.
	 * @param ctx the parse tree
	 */
	void exitForControl(LatteXtendParser.ForControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(LatteXtendParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(LatteXtendParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#enhancedForControl}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForControl(LatteXtendParser.EnhancedForControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#enhancedForControl}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForControl(LatteXtendParser.EnhancedForControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(LatteXtendParser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(LatteXtendParser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void enterParExpression(LatteXtendParser.ParExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void exitParExpression(LatteXtendParser.ParExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(LatteXtendParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(LatteXtendParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpression(LatteXtendParser.StatementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpression(LatteXtendParser.StatementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpression(LatteXtendParser.ConstantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpression(LatteXtendParser.ConstantExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(LatteXtendParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(LatteXtendParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(LatteXtendParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(LatteXtendParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterCreator(LatteXtendParser.CreatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitCreator(LatteXtendParser.CreatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#createdName}.
	 * @param ctx the parse tree
	 */
	void enterCreatedName(LatteXtendParser.CreatedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#createdName}.
	 * @param ctx the parse tree
	 */
	void exitCreatedName(LatteXtendParser.CreatedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#innerCreator}.
	 * @param ctx the parse tree
	 */
	void enterInnerCreator(LatteXtendParser.InnerCreatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#innerCreator}.
	 * @param ctx the parse tree
	 */
	void exitInnerCreator(LatteXtendParser.InnerCreatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#arrayCreatorRest}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreatorRest(LatteXtendParser.ArrayCreatorRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#arrayCreatorRest}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreatorRest(LatteXtendParser.ArrayCreatorRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#classCreatorRest}.
	 * @param ctx the parse tree
	 */
	void enterClassCreatorRest(LatteXtendParser.ClassCreatorRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#classCreatorRest}.
	 * @param ctx the parse tree
	 */
	void exitClassCreatorRest(LatteXtendParser.ClassCreatorRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#explicitGenericInvocation}.
	 * @param ctx the parse tree
	 */
	void enterExplicitGenericInvocation(LatteXtendParser.ExplicitGenericInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#explicitGenericInvocation}.
	 * @param ctx the parse tree
	 */
	void exitExplicitGenericInvocation(LatteXtendParser.ExplicitGenericInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#nonWildcardTypeArguments}.
	 * @param ctx the parse tree
	 */
	void enterNonWildcardTypeArguments(LatteXtendParser.NonWildcardTypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#nonWildcardTypeArguments}.
	 * @param ctx the parse tree
	 */
	void exitNonWildcardTypeArguments(LatteXtendParser.NonWildcardTypeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgumentsOrDiamond(LatteXtendParser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgumentsOrDiamond(LatteXtendParser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#nonWildcardTypeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void enterNonWildcardTypeArgumentsOrDiamond(LatteXtendParser.NonWildcardTypeArgumentsOrDiamondContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#nonWildcardTypeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void exitNonWildcardTypeArgumentsOrDiamond(LatteXtendParser.NonWildcardTypeArgumentsOrDiamondContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#superSuffix}.
	 * @param ctx the parse tree
	 */
	void enterSuperSuffix(LatteXtendParser.SuperSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#superSuffix}.
	 * @param ctx the parse tree
	 */
	void exitSuperSuffix(LatteXtendParser.SuperSuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#explicitGenericInvocationSuffix}.
	 * @param ctx the parse tree
	 */
	void enterExplicitGenericInvocationSuffix(LatteXtendParser.ExplicitGenericInvocationSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#explicitGenericInvocationSuffix}.
	 * @param ctx the parse tree
	 */
	void exitExplicitGenericInvocationSuffix(LatteXtendParser.ExplicitGenericInvocationSuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(LatteXtendParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(LatteXtendParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#eos}.
	 * @param ctx the parse tree
	 */
	void enterEos(LatteXtendParser.EosContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#eos}.
	 * @param ctx the parse tree
	 */
	void exitEos(LatteXtendParser.EosContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteXtendParser#eof}.
	 * @param ctx the parse tree
	 */
	void enterEof(LatteXtendParser.EofContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteXtendParser#eof}.
	 * @param ctx the parse tree
	 */
	void exitEof(LatteXtendParser.EofContext ctx);
}