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
		WS=25;
	public static final int
		RULE_unit = 0, RULE_classDeclaration = 1, RULE_classBody = 2, RULE_code = 3, 
		RULE_packageDeclaration = 4, RULE_importStatement = 5, RULE_layoutFunction = 6, 
		RULE_layoutString = 7, RULE_layoutBody = 8, RULE_inlineCode = 9, RULE_inlineCodeContent = 10, 
		RULE_codeChar = 11, RULE_xmlTag = 12, RULE_propName = 13, RULE_layoutProp = 14, 
		RULE_strPropValue = 15;
	public static final String[] ruleNames = {
		"unit", "classDeclaration", "classBody", "code", "packageDeclaration", 
		"importStatement", "layoutFunction", "layoutString", "layoutBody", "inlineCode", 
		"inlineCodeContent", "codeChar", "xmlTag", "propName", "layoutProp", "strPropValue"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\"\"\"'", "'$'", "'<'", "'>'", "'/>'", "'/'", "'\"'", "'='", "'''", 
		"'@'", "':'", "'lxml'", null, null, null, "'{'", "'}'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "LAYOUT_CLASS", "LAYOUT_FUN", "LAYOUT_FUN_BLOCK", "BRACE_OPEN", 
		"BRACE_CLOSE", "PAREN_OPEN", "PAREN_CLOSE", "CHAR", "XML_TAG_OPEN", "XML_TAG_CLOSE", 
		"PACKAGE_DECLARATION", "IMPORT_STMT", "WS"
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
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << LAYOUT_CLASS) | (1L << BRACE_OPEN) | (1L << PAREN_OPEN) | (1L << PAREN_CLOSE) | (1L << CHAR) | (1L << XML_TAG_OPEN) | (1L << PACKAGE_DECLARATION) | (1L << IMPORT_STMT))) != 0)) {
				{
				setState(36);
				switch (_input.LA(1)) {
				case PACKAGE_DECLARATION:
					{
					setState(32);
					packageDeclaration();
					}
					break;
				case IMPORT_STMT:
					{
					setState(33);
					importStatement();
					}
					break;
				case LAYOUT_CLASS:
					{
					setState(34);
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
					{
					setState(35);
					code();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(40);
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
			setState(41);
			match(LAYOUT_CLASS);
			setState(42);
			match(BRACE_OPEN);
			setState(43);
			classBody();
			setState(44);
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
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << LAYOUT_FUN) | (1L << LAYOUT_FUN_BLOCK) | (1L << BRACE_OPEN) | (1L << PAREN_OPEN) | (1L << PAREN_CLOSE) | (1L << CHAR) | (1L << XML_TAG_OPEN))) != 0)) {
				{
				setState(48);
				switch (_input.LA(1)) {
				case LAYOUT_FUN:
				case LAYOUT_FUN_BLOCK:
					{
					setState(46);
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
					{
					setState(47);
					code();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(52);
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
			setState(72);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(54); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(53);
						codeChar();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(56); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << PAREN_OPEN) | (1L << PAREN_CLOSE) | (1L << CHAR) | (1L << XML_TAG_OPEN))) != 0)) {
					{
					{
					setState(58);
					codeChar();
					}
					}
					setState(63);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(64);
				match(BRACE_OPEN);
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << BRACE_OPEN) | (1L << PAREN_OPEN) | (1L << PAREN_CLOSE) | (1L << CHAR) | (1L << XML_TAG_OPEN))) != 0)) {
					{
					{
					setState(65);
					code();
					}
					}
					setState(70);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(71);
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
			setState(74);
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
			setState(76);
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
			setState(89);
			switch (_input.LA(1)) {
			case LAYOUT_FUN:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				match(LAYOUT_FUN);
				setState(79);
				match(PAREN_OPEN);
				setState(80);
				layoutString();
				setState(81);
				match(PAREN_CLOSE);
				}
				break;
			case LAYOUT_FUN_BLOCK:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				match(LAYOUT_FUN_BLOCK);
				setState(84);
				match(PAREN_OPEN);
				setState(85);
				layoutString();
				setState(86);
				match(PAREN_CLOSE);
				setState(87);
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
			setState(91);
			match(T__0);
			setState(92);
			layoutBody();
			setState(93);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << BRACE_OPEN) | (1L << CHAR) | (1L << XML_TAG_OPEN))) != 0)) {
				{
				setState(102);
				switch (_input.LA(1)) {
				case XML_TAG_OPEN:
					{
					setState(95);
					xmlTag();
					}
					break;
				case T__1:
				case BRACE_OPEN:
					{
					setState(96);
					inlineCode();
					}
					break;
				case CHAR:
					{
					setState(98); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(97);
							match(CHAR);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(100); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(106);
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
			setState(108);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(107);
				match(T__1);
				}
			}

			setState(110);
			match(BRACE_OPEN);
			setState(111);
			inlineCodeContent();
			setState(112);
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

	public static class InlineCodeContentContext extends ParserRuleContext {
		public List<LayoutStringContext> layoutString() {
			return getRuleContexts(LayoutStringContext.class);
		}
		public LayoutStringContext layoutString(int i) {
			return getRuleContext(LayoutStringContext.class,i);
		}
		public List<CodeContext> code() {
			return getRuleContexts(CodeContext.class);
		}
		public CodeContext code(int i) {
			return getRuleContext(CodeContext.class,i);
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
		enterRule(_localctx, 20, RULE_inlineCodeContent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << BRACE_OPEN) | (1L << PAREN_OPEN) | (1L << PAREN_CLOSE) | (1L << CHAR) | (1L << XML_TAG_OPEN))) != 0)) {
				{
				setState(116);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(114);
					layoutString();
					}
					break;
				case 2:
					{
					setState(115);
					code();
					}
					break;
				}
				}
				setState(120);
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
		enterRule(_localctx, 22, RULE_codeChar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
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
		enterRule(_localctx, 24, RULE_xmlTag);
		int _la;
		try {
			setState(142);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				match(XML_TAG_OPEN);
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CHAR) {
					{
					{
					setState(124);
					layoutProp();
					}
					}
					setState(129);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(130);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				match(XML_TAG_OPEN);
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CHAR) {
					{
					{
					setState(132);
					layoutProp();
					}
					}
					setState(137);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(138);
				match(T__3);
				setState(139);
				layoutBody();
				setState(140);
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
		enterRule(_localctx, 26, RULE_propName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(144);
				match(CHAR);
				}
				}
				setState(147); 
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
		public StrPropValueContext strPropValue() {
			return getRuleContext(StrPropValueContext.class,0);
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
		enterRule(_localctx, 28, RULE_layoutProp);
		try {
			setState(159);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				propName();
				setState(150);
				match(T__7);
				setState(151);
				match(T__6);
				setState(152);
				strPropValue();
				setState(153);
				match(T__6);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				propName();
				setState(156);
				match(T__7);
				setState(157);
				inlineCode();
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
		enterRule(_localctx, 30, RULE_strPropValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__5) | (1L << T__8) | (1L << T__9) | (1L << BRACE_OPEN) | (1L << CHAR))) != 0)) {
				{
				setState(166);
				switch (_input.LA(1)) {
				case CHAR:
					{
					setState(161);
					match(CHAR);
					}
					break;
				case T__1:
				case BRACE_OPEN:
					{
					setState(162);
					inlineCode();
					}
					break;
				case T__8:
					{
					setState(163);
					match(T__8);
					}
					break;
				case T__9:
					{
					setState(164);
					match(T__9);
					}
					break;
				case T__5:
					{
					setState(165);
					match(T__5);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(170);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\33\u00ae\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2"+
		"\3\2\3\2\7\2\'\n\2\f\2\16\2*\13\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\7\4\63\n"+
		"\4\f\4\16\4\66\13\4\3\5\6\59\n\5\r\5\16\5:\3\5\7\5>\n\5\f\5\16\5A\13\5"+
		"\3\5\3\5\7\5E\n\5\f\5\16\5H\13\5\3\5\5\5K\n\5\3\6\3\6\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\\\n\b\3\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\6\ne\n\n\r\n\16\nf\7\ni\n\n\f\n\16\nl\13\n\3\13\5\13o\n\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\7\fw\n\f\f\f\16\fz\13\f\3\r\3\r\3\16\3\16\7\16\u0080"+
		"\n\16\f\16\16\16\u0083\13\16\3\16\3\16\3\16\7\16\u0088\n\16\f\16\16\16"+
		"\u008b\13\16\3\16\3\16\3\16\3\16\5\16\u0091\n\16\3\17\6\17\u0094\n\17"+
		"\r\17\16\17\u0095\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5"+
		"\20\u00a2\n\20\3\21\3\21\3\21\3\21\3\21\7\21\u00a9\n\21\f\21\16\21\u00ac"+
		"\13\21\3\21\2\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\3\4\2\3\16"+
		"\24\27\u00b9\2(\3\2\2\2\4+\3\2\2\2\6\64\3\2\2\2\bJ\3\2\2\2\nL\3\2\2\2"+
		"\fN\3\2\2\2\16[\3\2\2\2\20]\3\2\2\2\22j\3\2\2\2\24n\3\2\2\2\26x\3\2\2"+
		"\2\30{\3\2\2\2\32\u0090\3\2\2\2\34\u0093\3\2\2\2\36\u00a1\3\2\2\2 \u00aa"+
		"\3\2\2\2\"\'\5\n\6\2#\'\5\f\7\2$\'\5\4\3\2%\'\5\b\5\2&\"\3\2\2\2&#\3\2"+
		"\2\2&$\3\2\2\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)\3\3\2\2\2*(\3"+
		"\2\2\2+,\7\17\2\2,-\7\22\2\2-.\5\6\4\2./\7\23\2\2/\5\3\2\2\2\60\63\5\16"+
		"\b\2\61\63\5\b\5\2\62\60\3\2\2\2\62\61\3\2\2\2\63\66\3\2\2\2\64\62\3\2"+
		"\2\2\64\65\3\2\2\2\65\7\3\2\2\2\66\64\3\2\2\2\679\5\30\r\28\67\3\2\2\2"+
		"9:\3\2\2\2:8\3\2\2\2:;\3\2\2\2;K\3\2\2\2<>\5\30\r\2=<\3\2\2\2>A\3\2\2"+
		"\2?=\3\2\2\2?@\3\2\2\2@B\3\2\2\2A?\3\2\2\2BF\7\22\2\2CE\5\b\5\2DC\3\2"+
		"\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2GI\3\2\2\2HF\3\2\2\2IK\7\23\2\2J8\3"+
		"\2\2\2J?\3\2\2\2K\t\3\2\2\2LM\7\31\2\2M\13\3\2\2\2NO\7\32\2\2O\r\3\2\2"+
		"\2PQ\7\20\2\2QR\7\24\2\2RS\5\20\t\2ST\7\25\2\2T\\\3\2\2\2UV\7\21\2\2V"+
		"W\7\24\2\2WX\5\20\t\2XY\7\25\2\2YZ\7\23\2\2Z\\\3\2\2\2[P\3\2\2\2[U\3\2"+
		"\2\2\\\17\3\2\2\2]^\7\3\2\2^_\5\22\n\2_`\7\3\2\2`\21\3\2\2\2ai\5\32\16"+
		"\2bi\5\24\13\2ce\7\26\2\2dc\3\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3\2\2\2gi\3"+
		"\2\2\2ha\3\2\2\2hb\3\2\2\2hd\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\23"+
		"\3\2\2\2lj\3\2\2\2mo\7\4\2\2nm\3\2\2\2no\3\2\2\2op\3\2\2\2pq\7\22\2\2"+
		"qr\5\26\f\2rs\7\23\2\2s\25\3\2\2\2tw\5\20\t\2uw\5\b\5\2vt\3\2\2\2vu\3"+
		"\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y\27\3\2\2\2zx\3\2\2\2{|\t\2\2\2|"+
		"\31\3\2\2\2}\u0081\7\27\2\2~\u0080\5\36\20\2\177~\3\2\2\2\u0080\u0083"+
		"\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0084\3\2\2\2\u0083"+
		"\u0081\3\2\2\2\u0084\u0091\7\7\2\2\u0085\u0089\7\27\2\2\u0086\u0088\5"+
		"\36\20\2\u0087\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a\u008c\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008d\7\6"+
		"\2\2\u008d\u008e\5\22\n\2\u008e\u008f\7\30\2\2\u008f\u0091\3\2\2\2\u0090"+
		"}\3\2\2\2\u0090\u0085\3\2\2\2\u0091\33\3\2\2\2\u0092\u0094\7\26\2\2\u0093"+
		"\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2"+
		"\2\2\u0096\35\3\2\2\2\u0097\u0098\5\34\17\2\u0098\u0099\7\n\2\2\u0099"+
		"\u009a\7\t\2\2\u009a\u009b\5 \21\2\u009b\u009c\7\t\2\2\u009c\u00a2\3\2"+
		"\2\2\u009d\u009e\5\34\17\2\u009e\u009f\7\n\2\2\u009f\u00a0\5\24\13\2\u00a0"+
		"\u00a2\3\2\2\2\u00a1\u0097\3\2\2\2\u00a1\u009d\3\2\2\2\u00a2\37\3\2\2"+
		"\2\u00a3\u00a9\7\26\2\2\u00a4\u00a9\5\24\13\2\u00a5\u00a9\7\13\2\2\u00a6"+
		"\u00a9\7\f\2\2\u00a7\u00a9\7\b\2\2\u00a8\u00a3\3\2\2\2\u00a8\u00a4\3\2"+
		"\2\2\u00a8\u00a5\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a7\3\2\2\2\u00a9"+
		"\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab!\3\2\2\2"+
		"\u00ac\u00aa\3\2\2\2\30&(\62\64:?FJ[fhjnvx\u0081\u0089\u0090\u0095\u00a1"+
		"\u00a8\u00aa";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}