// Generated from /Users/maan/git/lattekit-android/lattekit-tools/transformer/src/main/antlr/io/lattekit/parser/Latte.g4 by ANTLR 4.5.1
package io.lattekit.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LatteParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LatteVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LatteParser#unit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnit(LatteParser.UnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(LatteParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(LatteParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(LatteParser.CodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteParser#packageDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageDeclaration(LatteParser.PackageDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteParser#importStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportStatement(LatteParser.ImportStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteParser#layoutFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLayoutFunction(LatteParser.LayoutFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteParser#layoutString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLayoutString(LatteParser.LayoutStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteParser#layoutBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLayoutBody(LatteParser.LayoutBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteParser#inlineCode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlineCode(LatteParser.InlineCodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteParser#inlineCodeContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlineCodeContent(LatteParser.InlineCodeContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteParser#codeChar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeChar(LatteParser.CodeCharContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteParser#xmlTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTag(LatteParser.XmlTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteParser#propName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropName(LatteParser.PropNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteParser#layoutProp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLayoutProp(LatteParser.LayoutPropContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatteParser#strPropValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrPropValue(LatteParser.StrPropValueContext ctx);
}