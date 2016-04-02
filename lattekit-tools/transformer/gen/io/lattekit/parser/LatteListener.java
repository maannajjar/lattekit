// Generated from /Users/maan/git/lattekit-android/lattekit-tools/transformer/src/main/antlr/io/lattekit/parser/Latte.g4 by ANTLR 4.5.1
package io.lattekit.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LatteParser}.
 */
public interface LatteListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LatteParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterUnit(LatteParser.UnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitUnit(LatteParser.UnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(LatteParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(LatteParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(LatteParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(LatteParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCode(LatteParser.CodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCode(LatteParser.CodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPackageDeclaration(LatteParser.PackageDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPackageDeclaration(LatteParser.PackageDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void enterImportStatement(LatteParser.ImportStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void exitImportStatement(LatteParser.ImportStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteParser#layoutFunction}.
	 * @param ctx the parse tree
	 */
	void enterLayoutFunction(LatteParser.LayoutFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteParser#layoutFunction}.
	 * @param ctx the parse tree
	 */
	void exitLayoutFunction(LatteParser.LayoutFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteParser#layoutString}.
	 * @param ctx the parse tree
	 */
	void enterLayoutString(LatteParser.LayoutStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteParser#layoutString}.
	 * @param ctx the parse tree
	 */
	void exitLayoutString(LatteParser.LayoutStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteParser#layoutBody}.
	 * @param ctx the parse tree
	 */
	void enterLayoutBody(LatteParser.LayoutBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteParser#layoutBody}.
	 * @param ctx the parse tree
	 */
	void exitLayoutBody(LatteParser.LayoutBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteParser#inlineCode}.
	 * @param ctx the parse tree
	 */
	void enterInlineCode(LatteParser.InlineCodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteParser#inlineCode}.
	 * @param ctx the parse tree
	 */
	void exitInlineCode(LatteParser.InlineCodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteParser#inlineCodeContent}.
	 * @param ctx the parse tree
	 */
	void enterInlineCodeContent(LatteParser.InlineCodeContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteParser#inlineCodeContent}.
	 * @param ctx the parse tree
	 */
	void exitInlineCodeContent(LatteParser.InlineCodeContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteParser#codeChar}.
	 * @param ctx the parse tree
	 */
	void enterCodeChar(LatteParser.CodeCharContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteParser#codeChar}.
	 * @param ctx the parse tree
	 */
	void exitCodeChar(LatteParser.CodeCharContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteParser#xmlTag}.
	 * @param ctx the parse tree
	 */
	void enterXmlTag(LatteParser.XmlTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteParser#xmlTag}.
	 * @param ctx the parse tree
	 */
	void exitXmlTag(LatteParser.XmlTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteParser#propName}.
	 * @param ctx the parse tree
	 */
	void enterPropName(LatteParser.PropNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteParser#propName}.
	 * @param ctx the parse tree
	 */
	void exitPropName(LatteParser.PropNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteParser#layoutProp}.
	 * @param ctx the parse tree
	 */
	void enterLayoutProp(LatteParser.LayoutPropContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteParser#layoutProp}.
	 * @param ctx the parse tree
	 */
	void exitLayoutProp(LatteParser.LayoutPropContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatteParser#strPropValue}.
	 * @param ctx the parse tree
	 */
	void enterStrPropValue(LatteParser.StrPropValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatteParser#strPropValue}.
	 * @param ctx the parse tree
	 */
	void exitStrPropValue(LatteParser.StrPropValueContext ctx);
}