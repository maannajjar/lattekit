// Generated from /Users/maan/git/lattekit-android/lattekit-tools/transformer/src/main/antlr/io/lattekit/parser/Latte.g4 by ANTLR 4.5.1
package io.lattekit.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LatteParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, LAYOUT_CLASS=13, LAYOUT_FUN=14, LAYOUT_FUN_BLOCK=15, 
		BRACE_OPEN=16, BRACE_CLOSE=17, PAREN_OPEN=18, PAREN_CLOSE=19, CHAR=20, 
		XML_TAG_OPEN=21, XML_TAG_CLOSE=22, PACKAGE_DECLARATION=23, IMPORT_STMT=24, 
		WS=25, STRING_LITERAL=26, UnterminatedStringLiteral=27;
	public static final int
		RULE_unit = 0, RULE_classDeclaration = 1, RULE_classBody = 2, RULE_code = 3, 
		RULE_packageDeclaration = 4, RULE_importStatement = 5, RULE_layoutFunction = 6, 
		RULE_layoutString = 7, RULE_layoutBody = 8, RULE_inlineCode = 9, RULE_codeBase = 10, 
		RULE_inlineCodeContent = 11, RULE_codeChar = 12, RULE_xmlTag = 13, RULE_propName = 14, 
		RULE_layoutProp = 15, RULE_strPropValue = 16;
	public static final String[] ruleNames = {
		"unit", "classDeclaration", "classBody", "code", "packageDeclaration", 
		"importStatement", "layoutFunction", "layoutString", "layoutBody", "inlineCode", 
		"codeBase", "inlineCodeContent", "codeChar", "xmlTag", "propName", "layoutProp", 
		"strPropValue"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\"\"\"'", "'$'", "'<'", "'>'", "'/>'", "'/'", "'\"'", "'='", "'''", 
		"'@'", "':'", "'lxml'", null, null, null, "'{'", "'}'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "LAYOUT_CLASS", "LAYOUT_FUN", "LAYOUT_FUN_BLOCK", "BRACE_OPEN", 
		"BRACE_CLOSE", "PAREN_OPEN", "PAREN_CLOSE", "CHAR", "XML_TAG_OPEN", "XML_TAG_CLOSE", 
		"PACKAGE_DECLARATION", "IMPORT_STMT", "WS", "STRING_LITERAL", "UnterminatedStringLiteral"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Latte.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LatteParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class UnitContext extends ParserRuleContext {
		public List<PackageDeclarationContext> packageDeclaration() {
			return getRuleContexts(PackageDeclarationContext.class);
		}
		public PackageDeclarationContext packageDeclaration(int i) {
			return getRuleContext(PackageDeclarationContext.class,i);
		}
		public List<ImportStatementContext> importStatement() {
			return getRuleContexts(ImportStatementContext.class);
		}
		public ImportStatementContext importStatement(int i) {
			return getRuleContext(ImportStatementContext.class,i);
		}
		public List<ClassDeclarationContext> classDeclaration() {
			return getRuleContexts(ClassDeclarationContext.class);
		}
		public ClassDeclarationContext classDeclaration(int i) {
			return getRuleContext(ClassDeclarationContext.class,i);
		}
		public List<CodeContext> code() {
			return getRuleContexts(CodeContext.class);
		}
		public CodeContext code(int i) {
			return getRuleContext(CodeContext.class,i);
		}
		public UnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).enterUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).exitUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteVisitor ) return ((LatteVisitor<? extends T>)visitor).visitUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnitContext unit() throws RecognitionException {
		UnitContext _localctx = new UnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_unit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << LAYOUT_CLASS) | (1L << BRACE_OPEN) | (1L << PAREN_OPEN) | (1L << PAREN_CLOSE) | (1L << CHAR) | (1L << XML_TAG_OPEN) | (1L << PACKAGE_DECLARATION) | (1L << IMPORT_STMT) | (1L << WS) | (1L << STRING_LITERAL))) != 0)) {
				{
				setState(38);
				switch (_input.LA(1)) {
				case PACKAGE_DECLARATION:
					{
					setState(34);
					packageDeclaration();
					}
					break;
				case IMPORT_STMT:
					{
					setState(35);
					importStatement();
					}
					break;
				case LAYOUT_CLASS:
					{
					setState(36);
					classDeclaration();
					}
					break;
				case T__0:
				case T__1:
				case T__2:
				case T__3:
				case T__4:
				case T__5:
				case T__6:
				case T__7:
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case BRACE_OPEN:
				case PAREN_OPEN:
				case PAREN_CLOSE:
				case CHAR:
				case XML_TAG_OPEN:
				case WS:
				case STRING_LITERAL:
					{
					setState(37);
					code();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclarationContext extends ParserRuleContext {
		public TerminalNode LAYOUT_CLASS() { return getToken(LatteParser.LAYOUT_CLASS, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).exitClassDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteVisitor ) return ((LatteVisitor<? extends T>)visitor).visitClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(LAYOUT_CLASS);
			setState(44);
			match(BRACE_OPEN);
			setState(45);
			classBody();
			setState(46);
			match(BRACE_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassBodyContext extends ParserRuleContext {
		public List<LayoutFunctionContext> layoutFunction() {
			return getRuleContexts(LayoutFunctionContext.class);
		}
		public LayoutFunctionContext layoutFunction(int i) {
			return getRuleContext(LayoutFunctionContext.class,i);
		}
		public List<CodeContext> code() {
			return getRuleContexts(CodeContext.class);
		}
		public CodeContext code(int i) {
			return getRuleContext(CodeContext.class,i);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).exitClassBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteVisitor ) return ((LatteVisitor<? extends T>)visitor).visitClassBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << LAYOUT_FUN) | (1L << LAYOUT_FUN_BLOCK) | (1L << BRACE_OPEN) | (1L << PAREN_OPEN) | (1L << PAREN_CLOSE) | (1L << CHAR) | (1L << XML_TAG_OPEN) | (1L << WS) | (1L << STRING_LITERAL))) != 0)) {
				{
				setState(50);
				switch (_input.LA(1)) {
				case LAYOUT_FUN:
				case LAYOUT_FUN_BLOCK:
					{
					setState(48);
					layoutFunction();
					}
					break;
				case T__0:
				case T__1:
				case T__2:
				case T__3:
				case T__4:
				case T__5:
				case T__6:
				case T__7:
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case BRACE_OPEN:
				case PAREN_OPEN:
				case PAREN_CLOSE:
				case CHAR:
				case XML_TAG_OPEN:
				case WS:
				case STRING_LITERAL:
					{
					setState(49);
					code();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CodeContext extends ParserRuleContext {
		public List<CodeCharContext> codeChar() {
			return getRuleContexts(CodeCharContext.class);
		}
		public CodeCharContext codeChar(int i) {
			return getRuleContext(CodeCharContext.class,i);
		}
		public TerminalNode STRING_LITERAL() { return getToken(LatteParser.STRING_LITERAL, 0); }
		public List<TerminalNode> WS() { return getTokens(LatteParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(LatteParser.WS, i);
		}
		public List<CodeContext> code() {
			return getRuleContexts(CodeContext.class);
		}
		public CodeContext code(int i) {
			return getRuleContext(CodeContext.class,i);
		}
		public CodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).enterCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).exitCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteVisitor ) return ((LatteVisitor<? extends T>)visitor).visitCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_code);
		int _la;
		try {
			int _alt;
			setState(80);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(56); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(55);
						codeChar();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(58); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				match(STRING_LITERAL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(62); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(61);
						match(WS);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(64); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << PAREN_OPEN) | (1L << PAREN_CLOSE) | (1L << CHAR) | (1L << XML_TAG_OPEN))) != 0)) {
					{
					{
					setState(66);
					codeChar();
					}
					}
					setState(71);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(72);
				match(BRACE_OPEN);
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << BRACE_OPEN) | (1L << PAREN_OPEN) | (1L << PAREN_CLOSE) | (1L << CHAR) | (1L << XML_TAG_OPEN) | (1L << WS) | (1L << STRING_LITERAL))) != 0)) {
					{
					{
					setState(73);
					code();
					}
					}
					setState(78);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(79);
				match(BRACE_CLOSE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PackageDeclarationContext extends ParserRuleContext {
		public TerminalNode PACKAGE_DECLARATION() { return getToken(LatteParser.PACKAGE_DECLARATION, 0); }
		public PackageDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).enterPackageDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).exitPackageDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteVisitor ) return ((LatteVisitor<? extends T>)visitor).visitPackageDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageDeclarationContext packageDeclaration() throws RecognitionException {
		PackageDeclarationContext _localctx = new PackageDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_packageDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(PACKAGE_DECLARATION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportStatementContext extends ParserRuleContext {
		public TerminalNode IMPORT_STMT() { return getToken(LatteParser.IMPORT_STMT, 0); }
		public ImportStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).enterImportStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).exitImportStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteVisitor ) return ((LatteVisitor<? extends T>)visitor).visitImportStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportStatementContext importStatement() throws RecognitionException {
		ImportStatementContext _localctx = new ImportStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_importStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(IMPORT_STMT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LayoutFunctionContext extends ParserRuleContext {
		public TerminalNode LAYOUT_FUN() { return getToken(LatteParser.LAYOUT_FUN, 0); }
		public LayoutStringContext layoutString() {
			return getRuleContext(LayoutStringContext.class,0);
		}
		public TerminalNode LAYOUT_FUN_BLOCK() { return getToken(LatteParser.LAYOUT_FUN_BLOCK, 0); }
		public LayoutFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_layoutFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).enterLayoutFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).exitLayoutFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteVisitor ) return ((LatteVisitor<? extends T>)visitor).visitLayoutFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LayoutFunctionContext layoutFunction() throws RecognitionException {
		LayoutFunctionContext _localctx = new LayoutFunctionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_layoutFunction);
		try {
			setState(97);
			switch (_input.LA(1)) {
			case LAYOUT_FUN:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				match(LAYOUT_FUN);
				setState(87);
				match(PAREN_OPEN);
				setState(88);
				layoutString();
				setState(89);
				match(PAREN_CLOSE);
				}
				break;
			case LAYOUT_FUN_BLOCK:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				match(LAYOUT_FUN_BLOCK);
				setState(92);
				match(PAREN_OPEN);
				setState(93);
				layoutString();
				setState(94);
				match(PAREN_CLOSE);
				setState(95);
				match(BRACE_CLOSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LayoutStringContext extends ParserRuleContext {
		public LayoutBodyContext layoutBody() {
			return getRuleContext(LayoutBodyContext.class,0);
		}
		public LayoutStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_layoutString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).enterLayoutString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).exitLayoutString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteVisitor ) return ((LatteVisitor<? extends T>)visitor).visitLayoutString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LayoutStringContext layoutString() throws RecognitionException {
		LayoutStringContext _localctx = new LayoutStringContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_layoutString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(T__0);
			setState(100);
			layoutBody();
			setState(101);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LayoutBodyContext extends ParserRuleContext {
		public List<XmlTagContext> xmlTag() {
			return getRuleContexts(XmlTagContext.class);
		}
		public XmlTagContext xmlTag(int i) {
			return getRuleContext(XmlTagContext.class,i);
		}
		public List<InlineCodeContext> inlineCode() {
			return getRuleContexts(InlineCodeContext.class);
		}
		public InlineCodeContext inlineCode(int i) {
			return getRuleContext(InlineCodeContext.class,i);
		}
		public List<TerminalNode> CHAR() { return getTokens(LatteParser.CHAR); }
		public TerminalNode CHAR(int i) {
			return getToken(LatteParser.CHAR, i);
		}
		public List<TerminalNode> WS() { return getTokens(LatteParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(LatteParser.WS, i);
		}
		public LayoutBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_layoutBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).enterLayoutBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).exitLayoutBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteVisitor ) return ((LatteVisitor<? extends T>)visitor).visitLayoutBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LayoutBodyContext layoutBody() throws RecognitionException {
		LayoutBodyContext _localctx = new LayoutBodyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_layoutBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << BRACE_OPEN) | (1L << CHAR) | (1L << XML_TAG_OPEN) | (1L << WS))) != 0)) {
				{
				setState(107);
				switch (_input.LA(1)) {
				case XML_TAG_OPEN:
					{
					setState(103);
					xmlTag();
					}
					break;
				case T__1:
				case BRACE_OPEN:
					{
					setState(104);
					inlineCode();
					}
					break;
				case CHAR:
					{
					setState(105);
					match(CHAR);
					}
					break;
				case WS:
					{
					setState(106);
					match(WS);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InlineCodeContext extends ParserRuleContext {
		public InlineCodeContentContext inlineCodeContent() {
			return getRuleContext(InlineCodeContentContext.class,0);
		}
		public InlineCodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineCode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).enterInlineCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).exitInlineCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteVisitor ) return ((LatteVisitor<? extends T>)visitor).visitInlineCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InlineCodeContext inlineCode() throws RecognitionException {
		InlineCodeContext _localctx = new InlineCodeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_inlineCode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(112);
				match(T__1);
				}
			}

			setState(115);
			match(BRACE_OPEN);
			setState(116);
			inlineCodeContent();
			setState(117);
			match(BRACE_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CodeBaseContext extends ParserRuleContext {
		public LayoutStringContext layoutString() {
			return getRuleContext(LayoutStringContext.class,0);
		}
		public List<CodeCharContext> codeChar() {
			return getRuleContexts(CodeCharContext.class);
		}
		public CodeCharContext codeChar(int i) {
			return getRuleContext(CodeCharContext.class,i);
		}
		public TerminalNode STRING_LITERAL() { return getToken(LatteParser.STRING_LITERAL, 0); }
		public List<TerminalNode> WS() { return getTokens(LatteParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(LatteParser.WS, i);
		}
		public CodeBaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codeBase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).enterCodeBase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).exitCodeBase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteVisitor ) return ((LatteVisitor<? extends T>)visitor).visitCodeBase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeBaseContext codeBase() throws RecognitionException {
		CodeBaseContext _localctx = new CodeBaseContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_codeBase);
		try {
			int _alt;
			setState(131);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				layoutString();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(121); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(120);
						codeChar();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(123); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(125);
				match(STRING_LITERAL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(127); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(126);
						match(WS);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(129); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InlineCodeContentContext extends ParserRuleContext {
		public List<CodeBaseContext> codeBase() {
			return getRuleContexts(CodeBaseContext.class);
		}
		public CodeBaseContext codeBase(int i) {
			return getRuleContext(CodeBaseContext.class,i);
		}
		public List<InlineCodeContentContext> inlineCodeContent() {
			return getRuleContexts(InlineCodeContentContext.class);
		}
		public InlineCodeContentContext inlineCodeContent(int i) {
			return getRuleContext(InlineCodeContentContext.class,i);
		}
		public InlineCodeContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineCodeContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).enterInlineCodeContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).exitInlineCodeContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteVisitor ) return ((LatteVisitor<? extends T>)visitor).visitInlineCodeContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InlineCodeContentContext inlineCodeContent() throws RecognitionException {
		InlineCodeContentContext _localctx = new InlineCodeContentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_inlineCodeContent);
		int _la;
		try {
			int _alt;
			setState(152);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(133);
						codeBase();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(136); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << PAREN_OPEN) | (1L << PAREN_CLOSE) | (1L << CHAR) | (1L << XML_TAG_OPEN) | (1L << WS) | (1L << STRING_LITERAL))) != 0)) {
					{
					{
					setState(138);
					codeBase();
					}
					}
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(144);
				match(BRACE_OPEN);
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << BRACE_OPEN) | (1L << PAREN_OPEN) | (1L << PAREN_CLOSE) | (1L << CHAR) | (1L << XML_TAG_OPEN) | (1L << WS) | (1L << STRING_LITERAL))) != 0)) {
					{
					{
					setState(145);
					inlineCodeContent();
					}
					}
					setState(150);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(151);
				match(BRACE_CLOSE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CodeCharContext extends ParserRuleContext {
		public TerminalNode CHAR() { return getToken(LatteParser.CHAR, 0); }
		public TerminalNode XML_TAG_OPEN() { return getToken(LatteParser.XML_TAG_OPEN, 0); }
		public CodeCharContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codeChar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).enterCodeChar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).exitCodeChar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteVisitor ) return ((LatteVisitor<? extends T>)visitor).visitCodeChar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeCharContext codeChar() throws RecognitionException {
		CodeCharContext _localctx = new CodeCharContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_codeChar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << PAREN_OPEN) | (1L << PAREN_CLOSE) | (1L << CHAR) | (1L << XML_TAG_OPEN))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class XmlTagContext extends ParserRuleContext {
		public TerminalNode XML_TAG_OPEN() { return getToken(LatteParser.XML_TAG_OPEN, 0); }
		public List<TerminalNode> WS() { return getTokens(LatteParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(LatteParser.WS, i);
		}
		public List<LayoutPropContext> layoutProp() {
			return getRuleContexts(LayoutPropContext.class);
		}
		public LayoutPropContext layoutProp(int i) {
			return getRuleContext(LayoutPropContext.class,i);
		}
		public LayoutBodyContext layoutBody() {
			return getRuleContext(LayoutBodyContext.class,0);
		}
		public TerminalNode XML_TAG_CLOSE() { return getToken(LatteParser.XML_TAG_CLOSE, 0); }
		public XmlTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xmlTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).enterXmlTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).exitXmlTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteVisitor ) return ((LatteVisitor<? extends T>)visitor).visitXmlTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XmlTagContext xmlTag() throws RecognitionException {
		XmlTagContext _localctx = new XmlTagContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_xmlTag);
		int _la;
		try {
			int _alt;
			setState(199);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				match(XML_TAG_OPEN);
				setState(160);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(157);
						match(WS);
						}
						} 
					}
					setState(162);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9 || _la==CHAR) {
					{
					{
					setState(163);
					layoutProp();
					}
					}
					setState(168);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(169);
					match(WS);
					}
					}
					setState(174);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(175);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				match(XML_TAG_OPEN);
				setState(180);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(177);
						match(WS);
						}
						} 
					}
					setState(182);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				}
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9 || _la==CHAR) {
					{
					{
					setState(183);
					layoutProp();
					}
					}
					setState(188);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(189);
					match(WS);
					}
					}
					setState(194);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(195);
				match(T__3);
				setState(196);
				layoutBody();
				setState(197);
				match(XML_TAG_CLOSE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropNameContext extends ParserRuleContext {
		public List<TerminalNode> CHAR() { return getTokens(LatteParser.CHAR); }
		public TerminalNode CHAR(int i) {
			return getToken(LatteParser.CHAR, i);
		}
		public PropNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).enterPropName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).exitPropName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteVisitor ) return ((LatteVisitor<? extends T>)visitor).visitPropName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropNameContext propName() throws RecognitionException {
		PropNameContext _localctx = new PropNameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_propName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(201);
				match(T__9);
				}
			}

			setState(205); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(204);
				match(CHAR);
				}
				}
				setState(207); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CHAR );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LayoutPropContext extends ParserRuleContext {
		public PropNameContext propName() {
			return getRuleContext(PropNameContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(LatteParser.STRING_LITERAL, 0); }
		public List<TerminalNode> WS() { return getTokens(LatteParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(LatteParser.WS, i);
		}
		public InlineCodeContext inlineCode() {
			return getRuleContext(InlineCodeContext.class,0);
		}
		public LayoutPropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_layoutProp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).enterLayoutProp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).exitLayoutProp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteVisitor ) return ((LatteVisitor<? extends T>)visitor).visitLayoutProp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LayoutPropContext layoutProp() throws RecognitionException {
		LayoutPropContext _localctx = new LayoutPropContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_layoutProp);
		try {
			int _alt;
			setState(227);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				propName();
				setState(210);
				match(T__7);
				setState(211);
				match(STRING_LITERAL);
				setState(215);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(212);
						match(WS);
						}
						} 
					}
					setState(217);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				propName();
				setState(219);
				match(T__7);
				setState(220);
				inlineCode();
				setState(224);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(221);
						match(WS);
						}
						} 
					}
					setState(226);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StrPropValueContext extends ParserRuleContext {
		public List<TerminalNode> CHAR() { return getTokens(LatteParser.CHAR); }
		public TerminalNode CHAR(int i) {
			return getToken(LatteParser.CHAR, i);
		}
		public List<InlineCodeContext> inlineCode() {
			return getRuleContexts(InlineCodeContext.class);
		}
		public InlineCodeContext inlineCode(int i) {
			return getRuleContext(InlineCodeContext.class,i);
		}
		public StrPropValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strPropValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).enterStrPropValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteListener ) ((LatteListener)listener).exitStrPropValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteVisitor ) return ((LatteVisitor<? extends T>)visitor).visitStrPropValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrPropValueContext strPropValue() throws RecognitionException {
		StrPropValueContext _localctx = new StrPropValueContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_strPropValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__5) | (1L << T__8) | (1L << T__9) | (1L << BRACE_OPEN) | (1L << CHAR))) != 0)) {
				{
				setState(234);
				switch (_input.LA(1)) {
				case CHAR:
					{
					setState(229);
					match(CHAR);
					}
					break;
				case T__1:
				case BRACE_OPEN:
					{
					setState(230);
					inlineCode();
					}
					break;
				case T__8:
					{
					setState(231);
					match(T__8);
					}
					break;
				case T__9:
					{
					setState(232);
					match(T__9);
					}
					break;
				case T__5:
					{
					setState(233);
					match(T__5);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\35\u00f2\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\3\2\7\2)\n\2\f\2\16\2,\13\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\7"+
		"\4\65\n\4\f\4\16\48\13\4\3\5\6\5;\n\5\r\5\16\5<\3\5\3\5\6\5A\n\5\r\5\16"+
		"\5B\3\5\7\5F\n\5\f\5\16\5I\13\5\3\5\3\5\7\5M\n\5\f\5\16\5P\13\5\3\5\5"+
		"\5S\n\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5"+
		"\bd\n\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\7\nn\n\n\f\n\16\nq\13\n\3\13\5"+
		"\13t\n\13\3\13\3\13\3\13\3\13\3\f\3\f\6\f|\n\f\r\f\16\f}\3\f\3\f\6\f\u0082"+
		"\n\f\r\f\16\f\u0083\5\f\u0086\n\f\3\r\6\r\u0089\n\r\r\r\16\r\u008a\3\r"+
		"\7\r\u008e\n\r\f\r\16\r\u0091\13\r\3\r\3\r\7\r\u0095\n\r\f\r\16\r\u0098"+
		"\13\r\3\r\5\r\u009b\n\r\3\16\3\16\3\17\3\17\7\17\u00a1\n\17\f\17\16\17"+
		"\u00a4\13\17\3\17\7\17\u00a7\n\17\f\17\16\17\u00aa\13\17\3\17\7\17\u00ad"+
		"\n\17\f\17\16\17\u00b0\13\17\3\17\3\17\3\17\7\17\u00b5\n\17\f\17\16\17"+
		"\u00b8\13\17\3\17\7\17\u00bb\n\17\f\17\16\17\u00be\13\17\3\17\7\17\u00c1"+
		"\n\17\f\17\16\17\u00c4\13\17\3\17\3\17\3\17\3\17\5\17\u00ca\n\17\3\20"+
		"\5\20\u00cd\n\20\3\20\6\20\u00d0\n\20\r\20\16\20\u00d1\3\21\3\21\3\21"+
		"\3\21\7\21\u00d8\n\21\f\21\16\21\u00db\13\21\3\21\3\21\3\21\3\21\7\21"+
		"\u00e1\n\21\f\21\16\21\u00e4\13\21\5\21\u00e6\n\21\3\22\3\22\3\22\3\22"+
		"\3\22\7\22\u00ed\n\22\f\22\16\22\u00f0\13\22\3\22\2\2\23\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"\2\3\4\2\3\16\24\27\u010d\2*\3\2\2\2\4-\3\2"+
		"\2\2\6\66\3\2\2\2\bR\3\2\2\2\nT\3\2\2\2\fV\3\2\2\2\16c\3\2\2\2\20e\3\2"+
		"\2\2\22o\3\2\2\2\24s\3\2\2\2\26\u0085\3\2\2\2\30\u009a\3\2\2\2\32\u009c"+
		"\3\2\2\2\34\u00c9\3\2\2\2\36\u00cc\3\2\2\2 \u00e5\3\2\2\2\"\u00ee\3\2"+
		"\2\2$)\5\n\6\2%)\5\f\7\2&)\5\4\3\2\')\5\b\5\2($\3\2\2\2(%\3\2\2\2(&\3"+
		"\2\2\2(\'\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\3\3\2\2\2,*\3\2\2\2-"+
		".\7\17\2\2./\7\22\2\2/\60\5\6\4\2\60\61\7\23\2\2\61\5\3\2\2\2\62\65\5"+
		"\16\b\2\63\65\5\b\5\2\64\62\3\2\2\2\64\63\3\2\2\2\658\3\2\2\2\66\64\3"+
		"\2\2\2\66\67\3\2\2\2\67\7\3\2\2\28\66\3\2\2\29;\5\32\16\2:9\3\2\2\2;<"+
		"\3\2\2\2<:\3\2\2\2<=\3\2\2\2=S\3\2\2\2>S\7\34\2\2?A\7\33\2\2@?\3\2\2\2"+
		"AB\3\2\2\2B@\3\2\2\2BC\3\2\2\2CS\3\2\2\2DF\5\32\16\2ED\3\2\2\2FI\3\2\2"+
		"\2GE\3\2\2\2GH\3\2\2\2HJ\3\2\2\2IG\3\2\2\2JN\7\22\2\2KM\5\b\5\2LK\3\2"+
		"\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2OQ\3\2\2\2PN\3\2\2\2QS\7\23\2\2R:\3"+
		"\2\2\2R>\3\2\2\2R@\3\2\2\2RG\3\2\2\2S\t\3\2\2\2TU\7\31\2\2U\13\3\2\2\2"+
		"VW\7\32\2\2W\r\3\2\2\2XY\7\20\2\2YZ\7\24\2\2Z[\5\20\t\2[\\\7\25\2\2\\"+
		"d\3\2\2\2]^\7\21\2\2^_\7\24\2\2_`\5\20\t\2`a\7\25\2\2ab\7\23\2\2bd\3\2"+
		"\2\2cX\3\2\2\2c]\3\2\2\2d\17\3\2\2\2ef\7\3\2\2fg\5\22\n\2gh\7\3\2\2h\21"+
		"\3\2\2\2in\5\34\17\2jn\5\24\13\2kn\7\26\2\2ln\7\33\2\2mi\3\2\2\2mj\3\2"+
		"\2\2mk\3\2\2\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2p\23\3\2\2\2qo\3"+
		"\2\2\2rt\7\4\2\2sr\3\2\2\2st\3\2\2\2tu\3\2\2\2uv\7\22\2\2vw\5\30\r\2w"+
		"x\7\23\2\2x\25\3\2\2\2y\u0086\5\20\t\2z|\5\32\16\2{z\3\2\2\2|}\3\2\2\2"+
		"}{\3\2\2\2}~\3\2\2\2~\u0086\3\2\2\2\177\u0086\7\34\2\2\u0080\u0082\7\33"+
		"\2\2\u0081\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0081\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\u0086\3\2\2\2\u0085y\3\2\2\2\u0085{\3\2\2\2\u0085"+
		"\177\3\2\2\2\u0085\u0081\3\2\2\2\u0086\27\3\2\2\2\u0087\u0089\5\26\f\2"+
		"\u0088\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b"+
		"\3\2\2\2\u008b\u009b\3\2\2\2\u008c\u008e\5\26\f\2\u008d\u008c\3\2\2\2"+
		"\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092"+
		"\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0096\7\22\2\2\u0093\u0095\5\30\r\2"+
		"\u0094\u0093\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097"+
		"\3\2\2\2\u0097\u0099\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009b\7\23\2\2"+
		"\u009a\u0088\3\2\2\2\u009a\u008f\3\2\2\2\u009b\31\3\2\2\2\u009c\u009d"+
		"\t\2\2\2\u009d\33\3\2\2\2\u009e\u00a2\7\27\2\2\u009f\u00a1\7\33\2\2\u00a0"+
		"\u009f\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2"+
		"\2\2\u00a3\u00a8\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a7\5 \21\2\u00a6"+
		"\u00a5\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2"+
		"\2\2\u00a9\u00ae\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00ad\7\33\2\2\u00ac"+
		"\u00ab\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2"+
		"\2\2\u00af\u00b1\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00ca\7\7\2\2\u00b2"+
		"\u00b6\7\27\2\2\u00b3\u00b5\7\33\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00b8\3"+
		"\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00bc\3\2\2\2\u00b8"+
		"\u00b6\3\2\2\2\u00b9\u00bb\5 \21\2\u00ba\u00b9\3\2\2\2\u00bb\u00be\3\2"+
		"\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00c2\3\2\2\2\u00be"+
		"\u00bc\3\2\2\2\u00bf\u00c1\7\33\2\2\u00c0\u00bf\3\2\2\2\u00c1\u00c4\3"+
		"\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c5\3\2\2\2\u00c4"+
		"\u00c2\3\2\2\2\u00c5\u00c6\7\6\2\2\u00c6\u00c7\5\22\n\2\u00c7\u00c8\7"+
		"\30\2\2\u00c8\u00ca\3\2\2\2\u00c9\u009e\3\2\2\2\u00c9\u00b2\3\2\2\2\u00ca"+
		"\35\3\2\2\2\u00cb\u00cd\7\f\2\2\u00cc\u00cb\3\2\2\2\u00cc\u00cd\3\2\2"+
		"\2\u00cd\u00cf\3\2\2\2\u00ce\u00d0\7\26\2\2\u00cf\u00ce\3\2\2\2\u00d0"+
		"\u00d1\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\37\3\2\2"+
		"\2\u00d3\u00d4\5\36\20\2\u00d4\u00d5\7\n\2\2\u00d5\u00d9\7\34\2\2\u00d6"+
		"\u00d8\7\33\2\2\u00d7\u00d6\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3"+
		"\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00e6\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc"+
		"\u00dd\5\36\20\2\u00dd\u00de\7\n\2\2\u00de\u00e2\5\24\13\2\u00df\u00e1"+
		"\7\33\2\2\u00e0\u00df\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2"+
		"\u00e2\u00e3\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00d3"+
		"\3\2\2\2\u00e5\u00dc\3\2\2\2\u00e6!\3\2\2\2\u00e7\u00ed\7\26\2\2\u00e8"+
		"\u00ed\5\24\13\2\u00e9\u00ed\7\13\2\2\u00ea\u00ed\7\f\2\2\u00eb\u00ed"+
		"\7\b\2\2\u00ec\u00e7\3\2\2\2\u00ec\u00e8\3\2\2\2\u00ec\u00e9\3\2\2\2\u00ec"+
		"\u00ea\3\2\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2"+
		"\2\2\u00ee\u00ef\3\2\2\2\u00ef#\3\2\2\2\u00f0\u00ee\3\2\2\2$(*\64\66<"+
		"BGNRcmos}\u0083\u0085\u008a\u008f\u0096\u009a\u00a2\u00a8\u00ae\u00b6"+
		"\u00bc\u00c2\u00c9\u00cc\u00d1\u00d9\u00e2\u00e5\u00ec\u00ee";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}