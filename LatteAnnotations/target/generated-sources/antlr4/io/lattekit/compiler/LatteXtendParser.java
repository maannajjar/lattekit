// Generated from io/lattekit/compiler/LatteXtend.g4 by ANTLR 4.5.1
package io.lattekit.compiler;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LatteXtendParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, NEW_ARRAY_LIST=11, NEW_HASH_MAP=12, ABSTRACT=13, ASSERT=14, BOOLEAN=15, 
		BREAK=16, BYTE=17, CASE=18, CATCH=19, CHAR=20, CLASS=21, CONST=22, CONTINUE=23, 
		DEFAULT=24, DO=25, DOUBLE=26, ELSE=27, ENUM=28, EXTENDS=29, FINAL=30, 
		FINALLY=31, FLOAT=32, FOR=33, IF=34, GOTO=35, IMPLEMENTS=36, IMPORT=37, 
		INSTANCEOF=38, INT=39, INTERFACE=40, LONG=41, NATIVE=42, NEW=43, PACKAGE=44, 
		PRIVATE=45, PROTECTED=46, PUBLIC=47, RETURN=48, SHORT=49, STATIC=50, STRICTFP=51, 
		SUPER=52, SWITCH=53, SYNCHRONIZED=54, THIS=55, THROW=56, THROWS=57, TRANSIENT=58, 
		TRY=59, VOID=60, VOLATILE=61, WHILE=62, IntegerLiteral=63, FloatingPointLiteral=64, 
		BooleanLiteral=65, CharacterLiteral=66, StringLiteral=67, NullLiteral=68, 
		LPAREN=69, RPAREN=70, LBRACE=71, RBRACE=72, LBRACK=73, RBRACK=74, SEMI=75, 
		COMMA=76, DOT=77, RANGE=78, ASSIGN=79, GT=80, LT=81, BANG=82, TILDE=83, 
		QUESTION=84, COLON=85, EQUAL=86, LE=87, GE=88, NOTEQUAL=89, AND=90, OR=91, 
		INC=92, DEC=93, ADD=94, SUB=95, MUL=96, DIV=97, BITAND=98, BITOR=99, CARET=100, 
		MOD=101, ADD_ASSIGN=102, SUB_ASSIGN=103, MUL_ASSIGN=104, DIV_ASSIGN=105, 
		AND_ASSIGN=106, OR_ASSIGN=107, XOR_ASSIGN=108, MOD_ASSIGN=109, LSHIFT_ASSIGN=110, 
		RSHIFT_ASSIGN=111, URSHIFT_ASSIGN=112, Identifier=113, AT=114, ELLIPSIS=115, 
		WhiteSpaces=116, LineTerminator=117, COMMENT=118, LINE_COMMENT=119;
	public static final int
		RULE_compilationUnit = 0, RULE_packageDeclaration = 1, RULE_importDeclaration = 2, 
		RULE_typeDeclaration = 3, RULE_modifier = 4, RULE_classOrInterfaceModifier = 5, 
		RULE_variableModifier = 6, RULE_classDeclaration = 7, RULE_typeParameters = 8, 
		RULE_typeParameter = 9, RULE_typeBound = 10, RULE_enumDeclaration = 11, 
		RULE_enumConstants = 12, RULE_enumConstant = 13, RULE_enumBodyDeclarations = 14, 
		RULE_interfaceDeclaration = 15, RULE_typeList = 16, RULE_classBody = 17, 
		RULE_interfaceBody = 18, RULE_classBodyDeclaration = 19, RULE_memberDeclaration = 20, 
		RULE_methodDeclaration = 21, RULE_genericMethodDeclaration = 22, RULE_constructorDeclaration = 23, 
		RULE_genericConstructorDeclaration = 24, RULE_fieldDeclaration = 25, RULE_interfaceBodyDeclaration = 26, 
		RULE_interfaceMemberDeclaration = 27, RULE_constDeclaration = 28, RULE_constantDeclarator = 29, 
		RULE_interfaceMethodDeclaration = 30, RULE_genericInterfaceMethodDeclaration = 31, 
		RULE_variableDeclarators = 32, RULE_variableDeclarator = 33, RULE_variableDeclaratorId = 34, 
		RULE_variableInitializer = 35, RULE_arrayInitializer = 36, RULE_enumConstantName = 37, 
		RULE_type = 38, RULE_classOrInterfaceType = 39, RULE_arrayType = 40, RULE_primitiveType = 41, 
		RULE_typeArguments = 42, RULE_typeArgument = 43, RULE_qualifiedNameList = 44, 
		RULE_formalParameters = 45, RULE_formalParameterList = 46, RULE_formalParameter = 47, 
		RULE_lastFormalParameter = 48, RULE_methodBody = 49, RULE_constructorBody = 50, 
		RULE_qualifiedName = 51, RULE_literal = 52, RULE_annotation = 53, RULE_annotationName = 54, 
		RULE_elementValuePairs = 55, RULE_elementValuePair = 56, RULE_elementValue = 57, 
		RULE_elementValueArrayInitializer = 58, RULE_annotationTypeDeclaration = 59, 
		RULE_annotationTypeBody = 60, RULE_annotationTypeElementDeclaration = 61, 
		RULE_annotationTypeElementRest = 62, RULE_annotationMethodOrConstantRest = 63, 
		RULE_annotationMethodRest = 64, RULE_annotationConstantRest = 65, RULE_defaultValue = 66, 
		RULE_block = 67, RULE_blockBody = 68, RULE_blockStatement = 69, RULE_xmlElement = 70, 
		RULE_xmlAttribute = 71, RULE_localVariableDeclarationStatement = 72, RULE_localVariableDeclaration = 73, 
		RULE_statement = 74, RULE_catchClause = 75, RULE_catchType = 76, RULE_finallyBlock = 77, 
		RULE_resourceSpecification = 78, RULE_resources = 79, RULE_resource = 80, 
		RULE_switchBlockStatementGroup = 81, RULE_switchLabel = 82, RULE_forControl = 83, 
		RULE_forInit = 84, RULE_enhancedForControl = 85, RULE_forUpdate = 86, 
		RULE_parExpression = 87, RULE_expressionList = 88, RULE_statementExpression = 89, 
		RULE_constantExpression = 90, RULE_expression = 91, RULE_primary = 92, 
		RULE_creator = 93, RULE_createdName = 94, RULE_innerCreator = 95, RULE_arrayCreatorRest = 96, 
		RULE_classCreatorRest = 97, RULE_explicitGenericInvocation = 98, RULE_nonWildcardTypeArguments = 99, 
		RULE_typeArgumentsOrDiamond = 100, RULE_nonWildcardTypeArgumentsOrDiamond = 101, 
		RULE_superSuffix = 102, RULE_explicitGenericInvocationSuffix = 103, RULE_arguments = 104, 
		RULE_eos = 105, RULE_eof = 106;
	public static final String[] ruleNames = {
		"compilationUnit", "packageDeclaration", "importDeclaration", "typeDeclaration", 
		"modifier", "classOrInterfaceModifier", "variableModifier", "classDeclaration", 
		"typeParameters", "typeParameter", "typeBound", "enumDeclaration", "enumConstants", 
		"enumConstant", "enumBodyDeclarations", "interfaceDeclaration", "typeList", 
		"classBody", "interfaceBody", "classBodyDeclaration", "memberDeclaration", 
		"methodDeclaration", "genericMethodDeclaration", "constructorDeclaration", 
		"genericConstructorDeclaration", "fieldDeclaration", "interfaceBodyDeclaration", 
		"interfaceMemberDeclaration", "constDeclaration", "constantDeclarator", 
		"interfaceMethodDeclaration", "genericInterfaceMethodDeclaration", "variableDeclarators", 
		"variableDeclarator", "variableDeclaratorId", "variableInitializer", "arrayInitializer", 
		"enumConstantName", "type", "classOrInterfaceType", "arrayType", "primitiveType", 
		"typeArguments", "typeArgument", "qualifiedNameList", "formalParameters", 
		"formalParameterList", "formalParameter", "lastFormalParameter", "methodBody", 
		"constructorBody", "qualifiedName", "literal", "annotation", "annotationName", 
		"elementValuePairs", "elementValuePair", "elementValue", "elementValueArrayInitializer", 
		"annotationTypeDeclaration", "annotationTypeBody", "annotationTypeElementDeclaration", 
		"annotationTypeElementRest", "annotationMethodOrConstantRest", "annotationMethodRest", 
		"annotationConstantRest", "defaultValue", "block", "blockBody", "blockStatement", 
		"xmlElement", "xmlAttribute", "localVariableDeclarationStatement", "localVariableDeclaration", 
		"statement", "catchClause", "catchType", "finallyBlock", "resourceSpecification", 
		"resources", "resource", "switchBlockStatementGroup", "switchLabel", "forControl", 
		"forInit", "enhancedForControl", "forUpdate", "parExpression", "expressionList", 
		"statementExpression", "constantExpression", "expression", "primary", 
		"creator", "createdName", "innerCreator", "arrayCreatorRest", "classCreatorRest", 
		"explicitGenericInvocation", "nonWildcardTypeArguments", "typeArgumentsOrDiamond", 
		"nonWildcardTypeArgumentsOrDiamond", "superSuffix", "explicitGenericInvocationSuffix", 
		"arguments", "eos", "eof"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'def'", "'override'", "'var'", "'val'", "'</'", "'/>'", "'as'", 
		"'<<'", "'>>>'", "'>>'", "'newArrayList'", "'newHashMap'", "'abstract'", 
		"'assert'", "'boolean'", "'break'", "'byte'", "'case'", "'catch'", "'char'", 
		"'class'", "'const'", "'continue'", "'default'", "'do'", "'double'", "'else'", 
		"'enum'", "'extends'", "'final'", "'finally'", "'float'", "'for'", "'if'", 
		"'goto'", "'implements'", "'import'", "'instanceof'", "'int'", "'interface'", 
		"'long'", "'native'", "'new'", "'package'", "'private'", "'protected'", 
		"'public'", "'return'", "'short'", "'static'", "'strictfp'", "'super'", 
		"'switch'", "'synchronized'", "'this'", "'throw'", "'throws'", "'transient'", 
		"'try'", "'void'", "'volatile'", "'while'", null, null, null, null, null, 
		"'null'", "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "','", "'.'", 
		"'..'", "'='", "'>'", "'<'", "'!'", "'~'", "'?'", "':'", "'=='", "'<='", 
		"'>='", "'!='", "'&&'", "'||'", "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", 
		"'&'", "'|'", "'^'", "'%'", "'+='", "'-='", "'*='", "'/='", "'&='", "'|='", 
		"'^='", "'%='", "'<<='", "'>>='", "'>>>='", null, "'@'", "'...'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "NEW_ARRAY_LIST", 
		"NEW_HASH_MAP", "ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE", "CASE", 
		"CATCH", "CHAR", "CLASS", "CONST", "CONTINUE", "DEFAULT", "DO", "DOUBLE", 
		"ELSE", "ENUM", "EXTENDS", "FINAL", "FINALLY", "FLOAT", "FOR", "IF", "GOTO", 
		"IMPLEMENTS", "IMPORT", "INSTANCEOF", "INT", "INTERFACE", "LONG", "NATIVE", 
		"NEW", "PACKAGE", "PRIVATE", "PROTECTED", "PUBLIC", "RETURN", "SHORT", 
		"STATIC", "STRICTFP", "SUPER", "SWITCH", "SYNCHRONIZED", "THIS", "THROW", 
		"THROWS", "TRANSIENT", "TRY", "VOID", "VOLATILE", "WHILE", "IntegerLiteral", 
		"FloatingPointLiteral", "BooleanLiteral", "CharacterLiteral", "StringLiteral", 
		"NullLiteral", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", 
		"SEMI", "COMMA", "DOT", "RANGE", "ASSIGN", "GT", "LT", "BANG", "TILDE", 
		"QUESTION", "COLON", "EQUAL", "LE", "GE", "NOTEQUAL", "AND", "OR", "INC", 
		"DEC", "ADD", "SUB", "MUL", "DIV", "BITAND", "BITOR", "CARET", "MOD", 
		"ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "AND_ASSIGN", 
		"OR_ASSIGN", "XOR_ASSIGN", "MOD_ASSIGN", "LSHIFT_ASSIGN", "RSHIFT_ASSIGN", 
		"URSHIFT_ASSIGN", "Identifier", "AT", "ELLIPSIS", "WhiteSpaces", "LineTerminator", 
		"COMMENT", "LINE_COMMENT"
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
	public String getGrammarFileName() { return "LatteXtend.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		enum ExpressionType {
			MemberReference,
			ThisReference,
			SubAnonymouseClass,
			SuperInvocation,
			ExplicitGenericInvocation,
			ArraySubscript,
			MethodInvocation,
			CreatorExpression,
			MutableArrayLiteral,
			MutableMapLiteral,
			TypeCasting,
			PostfixOperator,
			PrefixOperator,
			Negate,
			Arithmetic,
			Logical,
			InstanceOf,
			EqualTest,
			Range,
			AssignWithOp
		}
	  	ExpressionType expressionType;
	  	java.util.Map<ParserRuleContext,ExpressionType> exprTypes = new java.util.HashMap<>();
	  	
	  	
	    /**
	     * Returns {@code true} iff on the current index of the parser's
	     * token stream a token exists on the {@code HIDDEN} channel which
	     * either is a line terminator, or is a multi line comment that
	     * contains a line terminator.
	     *
	     * @return {@code true} iff on the current index of the parser's
	     * token stream a token exists on the {@code HIDDEN} channel which
	     * either is a line terminator, or is a multi line comment that
	     * contains a line terminator.
	     */
	    private boolean lineTerminatorAhead() {
	        // Get the token ahead of the current index.
	        int possibleIndexEosToken = this.getCurrentToken().getTokenIndex() - 1;
	        Token ahead = _input.get(possibleIndexEosToken);        
	        if (ahead.getChannel() != Lexer.HIDDEN) {
	            // We're only interested in tokens on the HIDDEN channel.
	            return false;
	        }

	        if (ahead.getType() == LineTerminator) {
	            // There is definitely a line terminator ahead.
	            return true;
	        }

	        if (ahead.getType() == WhiteSpaces) {
	            // Get the token ahead of the current whitespaces.
	            possibleIndexEosToken = this.getCurrentToken().getTokenIndex() - 2;
	            ahead = _input.get(possibleIndexEosToken);
	        }

	        // Get the token's text and type.
	        String text = ahead.getText();
	        int type = ahead.getType();
	        // Check if the token is, or contains a line terminator.
	        return  (type == COMMENT && (text.contains("\r") || text.contains("\n"))) ||
	                (type == LineTerminator);
	    }                                

	public LatteXtendParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CompilationUnitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(LatteXtendParser.EOF, 0); }
		public PackageDeclarationContext packageDeclaration() {
			return getRuleContext(PackageDeclarationContext.class,0);
		}
		public List<ImportDeclarationContext> importDeclaration() {
			return getRuleContexts(ImportDeclarationContext.class);
		}
		public ImportDeclarationContext importDeclaration(int i) {
			return getRuleContext(ImportDeclarationContext.class,i);
		}
		public List<TypeDeclarationContext> typeDeclaration() {
			return getRuleContexts(TypeDeclarationContext.class);
		}
		public TypeDeclarationContext typeDeclaration(int i) {
			return getRuleContext(TypeDeclarationContext.class,i);
		}
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterCompilationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitCompilationUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitCompilationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compilationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(214);
				packageDeclaration();
				}
				break;
			}
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(217);
				importDeclaration();
				}
				}
				setState(222);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << CLASS) | (1L << ENUM) | (1L << FINAL) | (1L << INTERFACE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << STRICTFP))) != 0) || _la==SEMI || _la==AT) {
				{
				{
				setState(223);
				typeDeclaration();
				}
				}
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(229);
			match(EOF);
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
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public PackageDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterPackageDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitPackageDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitPackageDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageDeclarationContext packageDeclaration() throws RecognitionException {
		PackageDeclarationContext _localctx = new PackageDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_packageDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(231);
				annotation();
				}
				}
				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(237);
			match(PACKAGE);
			setState(238);
			qualifiedName();
			setState(239);
			match(SEMI);
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

	public static class ImportDeclarationContext extends ParserRuleContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public ImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterImportDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitImportDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitImportDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportDeclarationContext importDeclaration() throws RecognitionException {
		ImportDeclarationContext _localctx = new ImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(IMPORT);
			setState(243);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(242);
				match(STATIC);
				}
			}

			setState(245);
			qualifiedName();
			setState(248);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(246);
				match(DOT);
				setState(247);
				match(MUL);
				}
			}

			setState(250);
			match(SEMI);
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

	public static class TypeDeclarationContext extends ParserRuleContext {
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public List<ClassOrInterfaceModifierContext> classOrInterfaceModifier() {
			return getRuleContexts(ClassOrInterfaceModifierContext.class);
		}
		public ClassOrInterfaceModifierContext classOrInterfaceModifier(int i) {
			return getRuleContext(ClassOrInterfaceModifierContext.class,i);
		}
		public EnumDeclarationContext enumDeclaration() {
			return getRuleContext(EnumDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public AnnotationTypeDeclarationContext annotationTypeDeclaration() {
			return getRuleContext(AnnotationTypeDeclarationContext.class,0);
		}
		public TypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitTypeDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitTypeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDeclarationContext typeDeclaration() throws RecognitionException {
		TypeDeclarationContext _localctx = new TypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_typeDeclaration);
		int _la;
		try {
			int _alt;
			setState(281);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << STRICTFP))) != 0) || _la==AT) {
					{
					{
					setState(252);
					classOrInterfaceModifier();
					}
					}
					setState(257);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(258);
				classDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << STRICTFP))) != 0) || _la==AT) {
					{
					{
					setState(259);
					classOrInterfaceModifier();
					}
					}
					setState(264);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(265);
				enumDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << STRICTFP))) != 0) || _la==AT) {
					{
					{
					setState(266);
					classOrInterfaceModifier();
					}
					}
					setState(271);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(272);
				interfaceDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(276);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(273);
						classOrInterfaceModifier();
						}
						} 
					}
					setState(278);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				}
				setState(279);
				annotationTypeDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(280);
				match(SEMI);
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

	public static class ModifierContext extends ParserRuleContext {
		public ClassOrInterfaceModifierContext classOrInterfaceModifier() {
			return getRuleContext(ClassOrInterfaceModifierContext.class,0);
		}
		public ModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifierContext modifier() throws RecognitionException {
		ModifierContext _localctx = new ModifierContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_modifier);
		int _la;
		try {
			setState(285);
			switch (_input.LA(1)) {
			case ABSTRACT:
			case FINAL:
			case PRIVATE:
			case PROTECTED:
			case PUBLIC:
			case STATIC:
			case STRICTFP:
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(283);
				classOrInterfaceModifier();
				}
				break;
			case NATIVE:
			case SYNCHRONIZED:
			case TRANSIENT:
			case VOLATILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(284);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NATIVE) | (1L << SYNCHRONIZED) | (1L << TRANSIENT) | (1L << VOLATILE))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
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

	public static class ClassOrInterfaceModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public ClassOrInterfaceModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classOrInterfaceModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterClassOrInterfaceModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitClassOrInterfaceModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitClassOrInterfaceModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassOrInterfaceModifierContext classOrInterfaceModifier() throws RecognitionException {
		ClassOrInterfaceModifierContext _localctx = new ClassOrInterfaceModifierContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_classOrInterfaceModifier);
		int _la;
		try {
			setState(289);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(287);
				annotation();
				}
				break;
			case ABSTRACT:
			case FINAL:
			case PRIVATE:
			case PROTECTED:
			case PUBLIC:
			case STATIC:
			case STRICTFP:
				enterOuterAlt(_localctx, 2);
				{
				setState(288);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << STRICTFP))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
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

	public static class VariableModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public VariableModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterVariableModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitVariableModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitVariableModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableModifierContext variableModifier() throws RecognitionException {
		VariableModifierContext _localctx = new VariableModifierContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_variableModifier);
		try {
			setState(293);
			switch (_input.LA(1)) {
			case FINAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(291);
				match(FINAL);
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 2);
				{
				setState(292);
				annotation();
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

	public static class ClassDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(LatteXtendParser.Identifier, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitClassDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			match(CLASS);
			setState(296);
			match(Identifier);
			setState(298);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(297);
				typeParameters();
				}
			}

			setState(302);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(300);
				match(EXTENDS);
				setState(301);
				type();
				}
			}

			setState(306);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(304);
				match(IMPLEMENTS);
				setState(305);
				typeList();
				}
			}

			setState(308);
			classBody();
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

	public static class TypeParametersContext extends ParserRuleContext {
		public List<TypeParameterContext> typeParameter() {
			return getRuleContexts(TypeParameterContext.class);
		}
		public TypeParameterContext typeParameter(int i) {
			return getRuleContext(TypeParameterContext.class,i);
		}
		public TypeParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterTypeParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitTypeParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitTypeParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeParametersContext typeParameters() throws RecognitionException {
		TypeParametersContext _localctx = new TypeParametersContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_typeParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			match(LT);
			setState(311);
			typeParameter();
			setState(316);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(312);
				match(COMMA);
				setState(313);
				typeParameter();
				}
				}
				setState(318);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(319);
			match(GT);
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

	public static class TypeParameterContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(LatteXtendParser.Identifier, 0); }
		public TypeBoundContext typeBound() {
			return getRuleContext(TypeBoundContext.class,0);
		}
		public TypeParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterTypeParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitTypeParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitTypeParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeParameterContext typeParameter() throws RecognitionException {
		TypeParameterContext _localctx = new TypeParameterContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_typeParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			match(Identifier);
			setState(324);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(322);
				match(EXTENDS);
				setState(323);
				typeBound();
				}
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

	public static class TypeBoundContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TypeBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeBound; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterTypeBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitTypeBound(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitTypeBound(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeBoundContext typeBound() throws RecognitionException {
		TypeBoundContext _localctx = new TypeBoundContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_typeBound);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			type();
			setState(331);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BITAND) {
				{
				{
				setState(327);
				match(BITAND);
				setState(328);
				type();
				}
				}
				setState(333);
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

	public static class EnumDeclarationContext extends ParserRuleContext {
		public TerminalNode ENUM() { return getToken(LatteXtendParser.ENUM, 0); }
		public TerminalNode Identifier() { return getToken(LatteXtendParser.Identifier, 0); }
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public EnumConstantsContext enumConstants() {
			return getRuleContext(EnumConstantsContext.class,0);
		}
		public EnumBodyDeclarationsContext enumBodyDeclarations() {
			return getRuleContext(EnumBodyDeclarationsContext.class,0);
		}
		public EnumDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterEnumDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitEnumDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitEnumDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumDeclarationContext enumDeclaration() throws RecognitionException {
		EnumDeclarationContext _localctx = new EnumDeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_enumDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			match(ENUM);
			setState(335);
			match(Identifier);
			setState(338);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(336);
				match(IMPLEMENTS);
				setState(337);
				typeList();
				}
			}

			setState(340);
			match(LBRACE);
			setState(342);
			_la = _input.LA(1);
			if (_la==Identifier || _la==AT) {
				{
				setState(341);
				enumConstants();
				}
			}

			setState(345);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(344);
				match(COMMA);
				}
			}

			setState(348);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(347);
				enumBodyDeclarations();
				}
			}

			setState(350);
			match(RBRACE);
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

	public static class EnumConstantsContext extends ParserRuleContext {
		public List<EnumConstantContext> enumConstant() {
			return getRuleContexts(EnumConstantContext.class);
		}
		public EnumConstantContext enumConstant(int i) {
			return getRuleContext(EnumConstantContext.class,i);
		}
		public EnumConstantsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConstants; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterEnumConstants(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitEnumConstants(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitEnumConstants(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumConstantsContext enumConstants() throws RecognitionException {
		EnumConstantsContext _localctx = new EnumConstantsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_enumConstants);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			enumConstant();
			setState(357);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(353);
					match(COMMA);
					setState(354);
					enumConstant();
					}
					} 
				}
				setState(359);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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

	public static class EnumConstantContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(LatteXtendParser.Identifier, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public EnumConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterEnumConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitEnumConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitEnumConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumConstantContext enumConstant() throws RecognitionException {
		EnumConstantContext _localctx = new EnumConstantContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_enumConstant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(360);
				annotation();
				}
				}
				setState(365);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(366);
			match(Identifier);
			setState(368);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(367);
				arguments();
				}
			}

			setState(371);
			_la = _input.LA(1);
			if (_la==LBRACE) {
				{
				setState(370);
				classBody();
				}
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

	public static class EnumBodyDeclarationsContext extends ParserRuleContext {
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public EnumBodyDeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumBodyDeclarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterEnumBodyDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitEnumBodyDeclarations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitEnumBodyDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumBodyDeclarationsContext enumBodyDeclarations() throws RecognitionException {
		EnumBodyDeclarationsContext _localctx = new EnumBodyDeclarationsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_enumBodyDeclarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			match(SEMI);
			setState(377);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << ABSTRACT) | (1L << CLASS) | (1L << ENUM) | (1L << FINAL) | (1L << INTERFACE) | (1L << NATIVE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << STRICTFP) | (1L << SYNCHRONIZED) | (1L << TRANSIENT) | (1L << VOLATILE))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (LBRACE - 71)) | (1L << (SEMI - 71)) | (1L << (LT - 71)) | (1L << (Identifier - 71)) | (1L << (AT - 71)))) != 0)) {
				{
				{
				setState(374);
				classBodyDeclaration();
				}
				}
				setState(379);
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

	public static class InterfaceDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(LatteXtendParser.Identifier, 0); }
		public InterfaceBodyContext interfaceBody() {
			return getRuleContext(InterfaceBodyContext.class,0);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public InterfaceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterInterfaceDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitInterfaceDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitInterfaceDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceDeclarationContext interfaceDeclaration() throws RecognitionException {
		InterfaceDeclarationContext _localctx = new InterfaceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_interfaceDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			match(INTERFACE);
			setState(381);
			match(Identifier);
			setState(383);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(382);
				typeParameters();
				}
			}

			setState(387);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(385);
				match(EXTENDS);
				setState(386);
				typeList();
				}
			}

			setState(389);
			interfaceBody();
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

	public static class TypeListContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitTypeList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitTypeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeListContext typeList() throws RecognitionException {
		TypeListContext _localctx = new TypeListContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_typeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			type();
			setState(396);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(392);
				match(COMMA);
				setState(393);
				type();
				}
				}
				setState(398);
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

	public static class ClassBodyContext extends ParserRuleContext {
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitClassBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitClassBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
			match(LBRACE);
			setState(403);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << ABSTRACT) | (1L << CLASS) | (1L << ENUM) | (1L << FINAL) | (1L << INTERFACE) | (1L << NATIVE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << STRICTFP) | (1L << SYNCHRONIZED) | (1L << TRANSIENT) | (1L << VOLATILE))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (LBRACE - 71)) | (1L << (SEMI - 71)) | (1L << (LT - 71)) | (1L << (Identifier - 71)) | (1L << (AT - 71)))) != 0)) {
				{
				{
				setState(400);
				classBodyDeclaration();
				}
				}
				setState(405);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(406);
			match(RBRACE);
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

	public static class InterfaceBodyContext extends ParserRuleContext {
		public List<InterfaceBodyDeclarationContext> interfaceBodyDeclaration() {
			return getRuleContexts(InterfaceBodyDeclarationContext.class);
		}
		public InterfaceBodyDeclarationContext interfaceBodyDeclaration(int i) {
			return getRuleContext(InterfaceBodyDeclarationContext.class,i);
		}
		public InterfaceBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterInterfaceBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitInterfaceBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitInterfaceBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceBodyContext interfaceBody() throws RecognitionException {
		InterfaceBodyContext _localctx = new InterfaceBodyContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_interfaceBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408);
			match(LBRACE);
			setState(412);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << DOUBLE) | (1L << ENUM) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NATIVE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << SYNCHRONIZED) | (1L << TRANSIENT) | (1L << VOID) | (1L << VOLATILE))) != 0) || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & ((1L << (SEMI - 75)) | (1L << (LT - 75)) | (1L << (Identifier - 75)) | (1L << (AT - 75)))) != 0)) {
				{
				{
				setState(409);
				interfaceBodyDeclaration();
				}
				}
				setState(414);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(415);
			match(RBRACE);
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

	public static class ClassBodyDeclarationContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MemberDeclarationContext memberDeclaration() {
			return getRuleContext(MemberDeclarationContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public ClassBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBodyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterClassBodyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitClassBodyDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitClassBodyDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyDeclarationContext classBodyDeclaration() throws RecognitionException {
		ClassBodyDeclarationContext _localctx = new ClassBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_classBodyDeclaration);
		int _la;
		try {
			int _alt;
			setState(429);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(417);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(419);
				_la = _input.LA(1);
				if (_la==STATIC) {
					{
					setState(418);
					match(STATIC);
					}
				}

				setState(421);
				block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(425);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(422);
						modifier();
						}
						} 
					}
					setState(427);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				}
				setState(428);
				memberDeclaration();
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

	public static class MemberDeclarationContext extends ParserRuleContext {
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public GenericMethodDeclarationContext genericMethodDeclaration() {
			return getRuleContext(GenericMethodDeclarationContext.class,0);
		}
		public FieldDeclarationContext fieldDeclaration() {
			return getRuleContext(FieldDeclarationContext.class,0);
		}
		public ConstructorDeclarationContext constructorDeclaration() {
			return getRuleContext(ConstructorDeclarationContext.class,0);
		}
		public GenericConstructorDeclarationContext genericConstructorDeclaration() {
			return getRuleContext(GenericConstructorDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public AnnotationTypeDeclarationContext annotationTypeDeclaration() {
			return getRuleContext(AnnotationTypeDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public EnumDeclarationContext enumDeclaration() {
			return getRuleContext(EnumDeclarationContext.class,0);
		}
		public MemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterMemberDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitMemberDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitMemberDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberDeclarationContext memberDeclaration() throws RecognitionException {
		MemberDeclarationContext _localctx = new MemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_memberDeclaration);
		int _la;
		try {
			setState(443);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(431);
				_la = _input.LA(1);
				if ( !(_la==T__0 || _la==T__1) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(432);
				methodDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(433);
				_la = _input.LA(1);
				if ( !(_la==T__0 || _la==T__1) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(434);
				genericMethodDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(435);
				_la = _input.LA(1);
				if ( !(_la==T__2 || _la==T__3) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(436);
				fieldDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(437);
				constructorDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(438);
				genericConstructorDeclaration();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(439);
				interfaceDeclaration();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(440);
				annotationTypeDeclaration();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(441);
				classDeclaration();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(442);
				enumDeclaration();
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

	public static class MethodDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(LatteXtendParser.Identifier, 0); }
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public QualifiedNameListContext qualifiedNameList() {
			return getRuleContext(QualifiedNameListContext.class,0);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitMethodDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitMethodDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(447);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case Identifier:
				{
				setState(445);
				type();
				}
				break;
			case VOID:
				{
				setState(446);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(449);
			match(Identifier);
			setState(450);
			formalParameters();
			setState(455);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(451);
				match(LBRACK);
				setState(452);
				match(RBRACK);
				}
				}
				setState(457);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(460);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(458);
				match(THROWS);
				setState(459);
				qualifiedNameList();
				}
			}

			setState(464);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(462);
				methodBody();
				}
				break;
			case SEMI:
				{
				setState(463);
				match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class GenericMethodDeclarationContext extends ParserRuleContext {
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public GenericMethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericMethodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterGenericMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitGenericMethodDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitGenericMethodDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenericMethodDeclarationContext genericMethodDeclaration() throws RecognitionException {
		GenericMethodDeclarationContext _localctx = new GenericMethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_genericMethodDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			typeParameters();
			setState(467);
			methodDeclaration();
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

	public static class ConstructorDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(LatteXtendParser.Identifier, 0); }
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public ConstructorBodyContext constructorBody() {
			return getRuleContext(ConstructorBodyContext.class,0);
		}
		public QualifiedNameListContext qualifiedNameList() {
			return getRuleContext(QualifiedNameListContext.class,0);
		}
		public ConstructorDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterConstructorDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitConstructorDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitConstructorDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorDeclarationContext constructorDeclaration() throws RecognitionException {
		ConstructorDeclarationContext _localctx = new ConstructorDeclarationContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_constructorDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			match(Identifier);
			setState(470);
			formalParameters();
			setState(473);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(471);
				match(THROWS);
				setState(472);
				qualifiedNameList();
				}
			}

			setState(475);
			constructorBody();
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

	public static class GenericConstructorDeclarationContext extends ParserRuleContext {
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public ConstructorDeclarationContext constructorDeclaration() {
			return getRuleContext(ConstructorDeclarationContext.class,0);
		}
		public GenericConstructorDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericConstructorDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterGenericConstructorDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitGenericConstructorDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitGenericConstructorDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenericConstructorDeclarationContext genericConstructorDeclaration() throws RecognitionException {
		GenericConstructorDeclarationContext _localctx = new GenericConstructorDeclarationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_genericConstructorDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			typeParameters();
			setState(478);
			constructorDeclaration();
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

	public static class FieldDeclarationContext extends ParserRuleContext {
		public VariableDeclaratorsContext variableDeclarators() {
			return getRuleContext(VariableDeclaratorsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterFieldDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitFieldDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitFieldDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_fieldDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				{
				setState(480);
				type();
				}
				break;
			}
			setState(483);
			variableDeclarators();
			setState(484);
			match(SEMI);
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

	public static class InterfaceBodyDeclarationContext extends ParserRuleContext {
		public InterfaceMemberDeclarationContext interfaceMemberDeclaration() {
			return getRuleContext(InterfaceMemberDeclarationContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public InterfaceBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceBodyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterInterfaceBodyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitInterfaceBodyDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitInterfaceBodyDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceBodyDeclarationContext interfaceBodyDeclaration() throws RecognitionException {
		InterfaceBodyDeclarationContext _localctx = new InterfaceBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_interfaceBodyDeclaration);
		try {
			int _alt;
			setState(494);
			switch (_input.LA(1)) {
			case ABSTRACT:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case CLASS:
			case DOUBLE:
			case ENUM:
			case FINAL:
			case FLOAT:
			case INT:
			case INTERFACE:
			case LONG:
			case NATIVE:
			case PRIVATE:
			case PROTECTED:
			case PUBLIC:
			case SHORT:
			case STATIC:
			case STRICTFP:
			case SYNCHRONIZED:
			case TRANSIENT:
			case VOID:
			case VOLATILE:
			case LT:
			case Identifier:
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(489);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(486);
						modifier();
						}
						} 
					}
					setState(491);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
				}
				setState(492);
				interfaceMemberDeclaration();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				setState(493);
				match(SEMI);
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

	public static class InterfaceMemberDeclarationContext extends ParserRuleContext {
		public ConstDeclarationContext constDeclaration() {
			return getRuleContext(ConstDeclarationContext.class,0);
		}
		public InterfaceMethodDeclarationContext interfaceMethodDeclaration() {
			return getRuleContext(InterfaceMethodDeclarationContext.class,0);
		}
		public GenericInterfaceMethodDeclarationContext genericInterfaceMethodDeclaration() {
			return getRuleContext(GenericInterfaceMethodDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public AnnotationTypeDeclarationContext annotationTypeDeclaration() {
			return getRuleContext(AnnotationTypeDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public EnumDeclarationContext enumDeclaration() {
			return getRuleContext(EnumDeclarationContext.class,0);
		}
		public InterfaceMemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMemberDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterInterfaceMemberDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitInterfaceMemberDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitInterfaceMemberDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceMemberDeclarationContext interfaceMemberDeclaration() throws RecognitionException {
		InterfaceMemberDeclarationContext _localctx = new InterfaceMemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_interfaceMemberDeclaration);
		try {
			setState(503);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(496);
				constDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(497);
				interfaceMethodDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(498);
				genericInterfaceMethodDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(499);
				interfaceDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(500);
				annotationTypeDeclaration();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(501);
				classDeclaration();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(502);
				enumDeclaration();
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

	public static class ConstDeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<ConstantDeclaratorContext> constantDeclarator() {
			return getRuleContexts(ConstantDeclaratorContext.class);
		}
		public ConstantDeclaratorContext constantDeclarator(int i) {
			return getRuleContext(ConstantDeclaratorContext.class,i);
		}
		public ConstDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterConstDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitConstDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitConstDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstDeclarationContext constDeclaration() throws RecognitionException {
		ConstDeclarationContext _localctx = new ConstDeclarationContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_constDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			type();
			setState(506);
			constantDeclarator();
			setState(511);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(507);
				match(COMMA);
				setState(508);
				constantDeclarator();
				}
				}
				setState(513);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(514);
			match(SEMI);
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

	public static class ConstantDeclaratorContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(LatteXtendParser.Identifier, 0); }
		public VariableInitializerContext variableInitializer() {
			return getRuleContext(VariableInitializerContext.class,0);
		}
		public ConstantDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterConstantDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitConstantDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitConstantDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantDeclaratorContext constantDeclarator() throws RecognitionException {
		ConstantDeclaratorContext _localctx = new ConstantDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_constantDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516);
			match(Identifier);
			setState(521);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(517);
				match(LBRACK);
				setState(518);
				match(RBRACK);
				}
				}
				setState(523);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(524);
			match(ASSIGN);
			setState(525);
			variableInitializer();
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

	public static class InterfaceMethodDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(LatteXtendParser.Identifier, 0); }
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public QualifiedNameListContext qualifiedNameList() {
			return getRuleContext(QualifiedNameListContext.class,0);
		}
		public InterfaceMethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMethodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterInterfaceMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitInterfaceMethodDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitInterfaceMethodDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceMethodDeclarationContext interfaceMethodDeclaration() throws RecognitionException {
		InterfaceMethodDeclarationContext _localctx = new InterfaceMethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_interfaceMethodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(529);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case Identifier:
				{
				setState(527);
				type();
				}
				break;
			case VOID:
				{
				setState(528);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(531);
			match(Identifier);
			setState(532);
			formalParameters();
			setState(537);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(533);
				match(LBRACK);
				setState(534);
				match(RBRACK);
				}
				}
				setState(539);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(542);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(540);
				match(THROWS);
				setState(541);
				qualifiedNameList();
				}
			}

			setState(544);
			match(SEMI);
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

	public static class GenericInterfaceMethodDeclarationContext extends ParserRuleContext {
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public InterfaceMethodDeclarationContext interfaceMethodDeclaration() {
			return getRuleContext(InterfaceMethodDeclarationContext.class,0);
		}
		public GenericInterfaceMethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericInterfaceMethodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterGenericInterfaceMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitGenericInterfaceMethodDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitGenericInterfaceMethodDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenericInterfaceMethodDeclarationContext genericInterfaceMethodDeclaration() throws RecognitionException {
		GenericInterfaceMethodDeclarationContext _localctx = new GenericInterfaceMethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_genericInterfaceMethodDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(546);
			typeParameters();
			setState(547);
			interfaceMethodDeclaration();
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

	public static class VariableDeclaratorsContext extends ParserRuleContext {
		public List<VariableDeclaratorContext> variableDeclarator() {
			return getRuleContexts(VariableDeclaratorContext.class);
		}
		public VariableDeclaratorContext variableDeclarator(int i) {
			return getRuleContext(VariableDeclaratorContext.class,i);
		}
		public VariableDeclaratorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterVariableDeclarators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitVariableDeclarators(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitVariableDeclarators(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclaratorsContext variableDeclarators() throws RecognitionException {
		VariableDeclaratorsContext _localctx = new VariableDeclaratorsContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_variableDeclarators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(549);
			variableDeclarator();
			setState(554);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(550);
				match(COMMA);
				setState(551);
				variableDeclarator();
				}
				}
				setState(556);
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

	public static class VariableDeclaratorContext extends ParserRuleContext {
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public VariableInitializerContext variableInitializer() {
			return getRuleContext(VariableInitializerContext.class,0);
		}
		public VariableDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterVariableDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitVariableDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitVariableDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclaratorContext variableDeclarator() throws RecognitionException {
		VariableDeclaratorContext _localctx = new VariableDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_variableDeclarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(557);
			variableDeclaratorId();
			setState(560);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				setState(558);
				match(ASSIGN);
				setState(559);
				variableInitializer();
				}
				break;
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

	public static class VariableDeclaratorIdContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(LatteXtendParser.Identifier, 0); }
		public VariableDeclaratorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaratorId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterVariableDeclaratorId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitVariableDeclaratorId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitVariableDeclaratorId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclaratorIdContext variableDeclaratorId() throws RecognitionException {
		VariableDeclaratorIdContext _localctx = new VariableDeclaratorIdContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_variableDeclaratorId);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(562);
			match(Identifier);
			setState(567);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(563);
					match(LBRACK);
					setState(564);
					match(RBRACK);
					}
					} 
				}
				setState(569);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
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

	public static class VariableInitializerContext extends ParserRuleContext {
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterVariableInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitVariableInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitVariableInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableInitializerContext variableInitializer() throws RecognitionException {
		VariableInitializerContext _localctx = new VariableInitializerContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_variableInitializer);
		try {
			setState(572);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(570);
				arrayInitializer();
				}
				break;
			case NEW_ARRAY_LIST:
			case NEW_HASH_MAP:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case SHORT:
			case SUPER:
			case THIS:
			case VOID:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case LT:
			case BANG:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(571);
				expression(0);
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

	public static class ArrayInitializerContext extends ParserRuleContext {
		public List<VariableInitializerContext> variableInitializer() {
			return getRuleContexts(VariableInitializerContext.class);
		}
		public VariableInitializerContext variableInitializer(int i) {
			return getRuleContext(VariableInitializerContext.class,i);
		}
		public ArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterArrayInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitArrayInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitArrayInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayInitializerContext arrayInitializer() throws RecognitionException {
		ArrayInitializerContext _localctx = new ArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_arrayInitializer);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(574);
			match(LBRACE);
			setState(586);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW_ARRAY_LIST) | (1L << NEW_HASH_MAP) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(575);
				variableInitializer();
				setState(580);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(576);
						match(COMMA);
						setState(577);
						variableInitializer();
						}
						} 
					}
					setState(582);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
				}
				setState(584);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(583);
					match(COMMA);
					}
				}

				}
			}

			setState(588);
			match(RBRACE);
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

	public static class EnumConstantNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(LatteXtendParser.Identifier, 0); }
		public EnumConstantNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConstantName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterEnumConstantName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitEnumConstantName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitEnumConstantName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumConstantNameContext enumConstantName() throws RecognitionException {
		EnumConstantNameContext _localctx = new EnumConstantNameContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_enumConstantName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(590);
			match(Identifier);
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

	public static class TypeContext extends ParserRuleContext {
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public List<ArrayTypeContext> arrayType() {
			return getRuleContexts(ArrayTypeContext.class);
		}
		public ArrayTypeContext arrayType(int i) {
			return getRuleContext(ArrayTypeContext.class,i);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_type);
		try {
			int _alt;
			setState(606);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(592);
				classOrInterfaceType();
				setState(596);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(593);
						arrayType();
						}
						} 
					}
					setState(598);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
				}
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
				enterOuterAlt(_localctx, 2);
				{
				setState(599);
				primitiveType();
				setState(603);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(600);
						arrayType();
						}
						} 
					}
					setState(605);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
				}
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

	public static class ClassOrInterfaceTypeContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(LatteXtendParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(LatteXtendParser.Identifier, i);
		}
		public List<TypeArgumentsContext> typeArguments() {
			return getRuleContexts(TypeArgumentsContext.class);
		}
		public TypeArgumentsContext typeArguments(int i) {
			return getRuleContext(TypeArgumentsContext.class,i);
		}
		public ClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitClassOrInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitClassOrInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassOrInterfaceTypeContext classOrInterfaceType() throws RecognitionException {
		ClassOrInterfaceTypeContext _localctx = new ClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_classOrInterfaceType);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(608);
			match(Identifier);
			setState(610);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				{
				setState(609);
				typeArguments();
				}
				break;
			}
			setState(619);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(612);
					match(DOT);
					setState(613);
					match(Identifier);
					setState(615);
					switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
					case 1:
						{
						setState(614);
						typeArguments();
						}
						break;
					}
					}
					} 
				}
				setState(621);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
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

	public static class ArrayTypeContext extends ParserRuleContext {
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_arrayType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(622);
			match(LBRACK);
			setState(623);
			match(RBRACK);
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

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitPrimitiveType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(625);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT))) != 0)) ) {
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

	public static class TypeArgumentsContext extends ParserRuleContext {
		public List<TypeArgumentContext> typeArgument() {
			return getRuleContexts(TypeArgumentContext.class);
		}
		public TypeArgumentContext typeArgument(int i) {
			return getRuleContext(TypeArgumentContext.class,i);
		}
		public TypeArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterTypeArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitTypeArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitTypeArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeArgumentsContext typeArguments() throws RecognitionException {
		TypeArgumentsContext _localctx = new TypeArgumentsContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_typeArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(627);
			match(LT);
			setState(628);
			typeArgument();
			setState(633);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(629);
				match(COMMA);
				setState(630);
				typeArgument();
				}
				}
				setState(635);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(636);
			match(GT);
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

	public static class TypeArgumentContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterTypeArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitTypeArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitTypeArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeArgumentContext typeArgument() throws RecognitionException {
		TypeArgumentContext _localctx = new TypeArgumentContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_typeArgument);
		int _la;
		try {
			setState(644);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(638);
				type();
				}
				break;
			case QUESTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(639);
				match(QUESTION);
				setState(642);
				_la = _input.LA(1);
				if (_la==EXTENDS || _la==SUPER) {
					{
					setState(640);
					_la = _input.LA(1);
					if ( !(_la==EXTENDS || _la==SUPER) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(641);
					type();
					}
				}

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

	public static class QualifiedNameListContext extends ParserRuleContext {
		public List<QualifiedNameContext> qualifiedName() {
			return getRuleContexts(QualifiedNameContext.class);
		}
		public QualifiedNameContext qualifiedName(int i) {
			return getRuleContext(QualifiedNameContext.class,i);
		}
		public QualifiedNameListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedNameList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterQualifiedNameList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitQualifiedNameList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitQualifiedNameList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameListContext qualifiedNameList() throws RecognitionException {
		QualifiedNameListContext _localctx = new QualifiedNameListContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_qualifiedNameList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(646);
			qualifiedName();
			setState(651);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(647);
				match(COMMA);
				setState(648);
				qualifiedName();
				}
				}
				setState(653);
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

	public static class FormalParametersContext extends ParserRuleContext {
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public FormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterFormalParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitFormalParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitFormalParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_formalParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(654);
			match(LPAREN);
			setState(656);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT))) != 0) || _la==Identifier || _la==AT) {
				{
				setState(655);
				formalParameterList();
				}
			}

			setState(658);
			match(RPAREN);
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

	public static class FormalParameterListContext extends ParserRuleContext {
		public List<FormalParameterContext> formalParameter() {
			return getRuleContexts(FormalParameterContext.class);
		}
		public FormalParameterContext formalParameter(int i) {
			return getRuleContext(FormalParameterContext.class,i);
		}
		public LastFormalParameterContext lastFormalParameter() {
			return getRuleContext(LastFormalParameterContext.class,0);
		}
		public FormalParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterFormalParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitFormalParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitFormalParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterListContext formalParameterList() throws RecognitionException {
		FormalParameterListContext _localctx = new FormalParameterListContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_formalParameterList);
		int _la;
		try {
			int _alt;
			setState(673);
			switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(660);
				formalParameter();
				setState(665);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(661);
						match(COMMA);
						setState(662);
						formalParameter();
						}
						} 
					}
					setState(667);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
				}
				setState(670);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(668);
					match(COMMA);
					setState(669);
					lastFormalParameter();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(672);
				lastFormalParameter();
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

	public static class FormalParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public FormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitFormalParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitFormalParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_formalParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(678);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(675);
				variableModifier();
				}
				}
				setState(680);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(681);
			type();
			setState(682);
			variableDeclaratorId();
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

	public static class LastFormalParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public LastFormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lastFormalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterLastFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitLastFormalParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitLastFormalParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LastFormalParameterContext lastFormalParameter() throws RecognitionException {
		LastFormalParameterContext _localctx = new LastFormalParameterContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_lastFormalParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(687);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(684);
				variableModifier();
				}
				}
				setState(689);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(690);
			type();
			setState(691);
			match(ELLIPSIS);
			setState(692);
			variableDeclaratorId();
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

	public static class MethodBodyContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterMethodBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitMethodBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitMethodBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_methodBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(694);
			block();
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

	public static class ConstructorBodyContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ConstructorBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterConstructorBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitConstructorBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitConstructorBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorBodyContext constructorBody() throws RecognitionException {
		ConstructorBodyContext _localctx = new ConstructorBodyContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_constructorBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(696);
			block();
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

	public static class QualifiedNameContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(LatteXtendParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(LatteXtendParser.Identifier, i);
		}
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitQualifiedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitQualifiedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_qualifiedName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(698);
			match(Identifier);
			setState(703);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(699);
					match(DOT);
					setState(700);
					match(Identifier);
					}
					} 
				}
				setState(705);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
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

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(LatteXtendParser.IntegerLiteral, 0); }
		public TerminalNode FloatingPointLiteral() { return getToken(LatteXtendParser.FloatingPointLiteral, 0); }
		public TerminalNode CharacterLiteral() { return getToken(LatteXtendParser.CharacterLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(LatteXtendParser.StringLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(LatteXtendParser.BooleanLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(706);
			_la = _input.LA(1);
			if ( !(((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & ((1L << (IntegerLiteral - 63)) | (1L << (FloatingPointLiteral - 63)) | (1L << (BooleanLiteral - 63)) | (1L << (CharacterLiteral - 63)) | (1L << (StringLiteral - 63)) | (1L << (NullLiteral - 63)))) != 0)) ) {
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

	public static class AnnotationContext extends ParserRuleContext {
		public AnnotationNameContext annotationName() {
			return getRuleContext(AnnotationNameContext.class,0);
		}
		public ElementValuePairsContext elementValuePairs() {
			return getRuleContext(ElementValuePairsContext.class,0);
		}
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitAnnotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_annotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(708);
			match(AT);
			setState(709);
			annotationName();
			setState(716);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(710);
				match(LPAREN);
				setState(713);
				switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
				case 1:
					{
					setState(711);
					elementValuePairs();
					}
					break;
				case 2:
					{
					setState(712);
					elementValue();
					}
					break;
				}
				setState(715);
				match(RPAREN);
				}
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

	public static class AnnotationNameContext extends ParserRuleContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public AnnotationNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterAnnotationName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitAnnotationName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitAnnotationName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationNameContext annotationName() throws RecognitionException {
		AnnotationNameContext _localctx = new AnnotationNameContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_annotationName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(718);
			qualifiedName();
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

	public static class ElementValuePairsContext extends ParserRuleContext {
		public List<ElementValuePairContext> elementValuePair() {
			return getRuleContexts(ElementValuePairContext.class);
		}
		public ElementValuePairContext elementValuePair(int i) {
			return getRuleContext(ElementValuePairContext.class,i);
		}
		public ElementValuePairsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValuePairs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterElementValuePairs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitElementValuePairs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitElementValuePairs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementValuePairsContext elementValuePairs() throws RecognitionException {
		ElementValuePairsContext _localctx = new ElementValuePairsContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_elementValuePairs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(720);
			elementValuePair();
			setState(725);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(721);
				match(COMMA);
				setState(722);
				elementValuePair();
				}
				}
				setState(727);
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

	public static class ElementValuePairContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(LatteXtendParser.Identifier, 0); }
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public ElementValuePairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValuePair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterElementValuePair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitElementValuePair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitElementValuePair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementValuePairContext elementValuePair() throws RecognitionException {
		ElementValuePairContext _localctx = new ElementValuePairContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_elementValuePair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(728);
			match(Identifier);
			setState(729);
			match(ASSIGN);
			setState(730);
			elementValue();
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

	public static class ElementValueContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public ElementValueArrayInitializerContext elementValueArrayInitializer() {
			return getRuleContext(ElementValueArrayInitializerContext.class,0);
		}
		public ElementValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterElementValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitElementValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitElementValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementValueContext elementValue() throws RecognitionException {
		ElementValueContext _localctx = new ElementValueContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_elementValue);
		try {
			setState(735);
			switch (_input.LA(1)) {
			case NEW_ARRAY_LIST:
			case NEW_HASH_MAP:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case SHORT:
			case SUPER:
			case THIS:
			case VOID:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case LT:
			case BANG:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(732);
				expression(0);
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 2);
				{
				setState(733);
				annotation();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 3);
				{
				setState(734);
				elementValueArrayInitializer();
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

	public static class ElementValueArrayInitializerContext extends ParserRuleContext {
		public List<ElementValueContext> elementValue() {
			return getRuleContexts(ElementValueContext.class);
		}
		public ElementValueContext elementValue(int i) {
			return getRuleContext(ElementValueContext.class,i);
		}
		public ElementValueArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValueArrayInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterElementValueArrayInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitElementValueArrayInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitElementValueArrayInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementValueArrayInitializerContext elementValueArrayInitializer() throws RecognitionException {
		ElementValueArrayInitializerContext _localctx = new ElementValueArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_elementValueArrayInitializer);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(737);
			match(LBRACE);
			setState(746);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW_ARRAY_LIST) | (1L << NEW_HASH_MAP) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)) | (1L << (AT - 64)))) != 0)) {
				{
				setState(738);
				elementValue();
				setState(743);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(739);
						match(COMMA);
						setState(740);
						elementValue();
						}
						} 
					}
					setState(745);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
				}
				}
			}

			setState(749);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(748);
				match(COMMA);
				}
			}

			setState(751);
			match(RBRACE);
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

	public static class AnnotationTypeDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(LatteXtendParser.Identifier, 0); }
		public AnnotationTypeBodyContext annotationTypeBody() {
			return getRuleContext(AnnotationTypeBodyContext.class,0);
		}
		public AnnotationTypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterAnnotationTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitAnnotationTypeDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitAnnotationTypeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationTypeDeclarationContext annotationTypeDeclaration() throws RecognitionException {
		AnnotationTypeDeclarationContext _localctx = new AnnotationTypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_annotationTypeDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(753);
			match(AT);
			setState(754);
			match(INTERFACE);
			setState(755);
			match(Identifier);
			setState(756);
			annotationTypeBody();
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

	public static class AnnotationTypeBodyContext extends ParserRuleContext {
		public List<AnnotationTypeElementDeclarationContext> annotationTypeElementDeclaration() {
			return getRuleContexts(AnnotationTypeElementDeclarationContext.class);
		}
		public AnnotationTypeElementDeclarationContext annotationTypeElementDeclaration(int i) {
			return getRuleContext(AnnotationTypeElementDeclarationContext.class,i);
		}
		public AnnotationTypeBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterAnnotationTypeBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitAnnotationTypeBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitAnnotationTypeBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationTypeBodyContext annotationTypeBody() throws RecognitionException {
		AnnotationTypeBodyContext _localctx = new AnnotationTypeBodyContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_annotationTypeBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(758);
			match(LBRACE);
			setState(762);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << DOUBLE) | (1L << ENUM) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NATIVE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << SYNCHRONIZED) | (1L << TRANSIENT) | (1L << VOLATILE))) != 0) || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & ((1L << (SEMI - 75)) | (1L << (Identifier - 75)) | (1L << (AT - 75)))) != 0)) {
				{
				{
				setState(759);
				annotationTypeElementDeclaration();
				}
				}
				setState(764);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(765);
			match(RBRACE);
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

	public static class AnnotationTypeElementDeclarationContext extends ParserRuleContext {
		public AnnotationTypeElementRestContext annotationTypeElementRest() {
			return getRuleContext(AnnotationTypeElementRestContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public AnnotationTypeElementDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeElementDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterAnnotationTypeElementDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitAnnotationTypeElementDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitAnnotationTypeElementDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationTypeElementDeclarationContext annotationTypeElementDeclaration() throws RecognitionException {
		AnnotationTypeElementDeclarationContext _localctx = new AnnotationTypeElementDeclarationContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_annotationTypeElementDeclaration);
		try {
			int _alt;
			setState(775);
			switch (_input.LA(1)) {
			case ABSTRACT:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case CLASS:
			case DOUBLE:
			case ENUM:
			case FINAL:
			case FLOAT:
			case INT:
			case INTERFACE:
			case LONG:
			case NATIVE:
			case PRIVATE:
			case PROTECTED:
			case PUBLIC:
			case SHORT:
			case STATIC:
			case STRICTFP:
			case SYNCHRONIZED:
			case TRANSIENT:
			case VOLATILE:
			case Identifier:
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(770);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(767);
						modifier();
						}
						} 
					}
					setState(772);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
				}
				setState(773);
				annotationTypeElementRest();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				setState(774);
				match(SEMI);
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

	public static class AnnotationTypeElementRestContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public AnnotationMethodOrConstantRestContext annotationMethodOrConstantRest() {
			return getRuleContext(AnnotationMethodOrConstantRestContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public EnumDeclarationContext enumDeclaration() {
			return getRuleContext(EnumDeclarationContext.class,0);
		}
		public AnnotationTypeDeclarationContext annotationTypeDeclaration() {
			return getRuleContext(AnnotationTypeDeclarationContext.class,0);
		}
		public AnnotationTypeElementRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeElementRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterAnnotationTypeElementRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitAnnotationTypeElementRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitAnnotationTypeElementRest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationTypeElementRestContext annotationTypeElementRest() throws RecognitionException {
		AnnotationTypeElementRestContext _localctx = new AnnotationTypeElementRestContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_annotationTypeElementRest);
		try {
			setState(797);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(777);
				type();
				setState(778);
				annotationMethodOrConstantRest();
				setState(779);
				match(SEMI);
				}
				break;
			case CLASS:
				enterOuterAlt(_localctx, 2);
				{
				setState(781);
				classDeclaration();
				setState(783);
				switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
				case 1:
					{
					setState(782);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case INTERFACE:
				enterOuterAlt(_localctx, 3);
				{
				setState(785);
				interfaceDeclaration();
				setState(787);
				switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
				case 1:
					{
					setState(786);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 4);
				{
				setState(789);
				enumDeclaration();
				setState(791);
				switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
				case 1:
					{
					setState(790);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 5);
				{
				setState(793);
				annotationTypeDeclaration();
				setState(795);
				switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
				case 1:
					{
					setState(794);
					match(SEMI);
					}
					break;
				}
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

	public static class AnnotationMethodOrConstantRestContext extends ParserRuleContext {
		public AnnotationMethodRestContext annotationMethodRest() {
			return getRuleContext(AnnotationMethodRestContext.class,0);
		}
		public AnnotationConstantRestContext annotationConstantRest() {
			return getRuleContext(AnnotationConstantRestContext.class,0);
		}
		public AnnotationMethodOrConstantRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationMethodOrConstantRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterAnnotationMethodOrConstantRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitAnnotationMethodOrConstantRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitAnnotationMethodOrConstantRest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationMethodOrConstantRestContext annotationMethodOrConstantRest() throws RecognitionException {
		AnnotationMethodOrConstantRestContext _localctx = new AnnotationMethodOrConstantRestContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_annotationMethodOrConstantRest);
		try {
			setState(801);
			switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(799);
				annotationMethodRest();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(800);
				annotationConstantRest();
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

	public static class AnnotationMethodRestContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(LatteXtendParser.Identifier, 0); }
		public DefaultValueContext defaultValue() {
			return getRuleContext(DefaultValueContext.class,0);
		}
		public AnnotationMethodRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationMethodRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterAnnotationMethodRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitAnnotationMethodRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitAnnotationMethodRest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationMethodRestContext annotationMethodRest() throws RecognitionException {
		AnnotationMethodRestContext _localctx = new AnnotationMethodRestContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_annotationMethodRest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(803);
			match(Identifier);
			setState(804);
			match(LPAREN);
			setState(805);
			match(RPAREN);
			setState(807);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(806);
				defaultValue();
				}
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

	public static class AnnotationConstantRestContext extends ParserRuleContext {
		public VariableDeclaratorsContext variableDeclarators() {
			return getRuleContext(VariableDeclaratorsContext.class,0);
		}
		public AnnotationConstantRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationConstantRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterAnnotationConstantRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitAnnotationConstantRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitAnnotationConstantRest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationConstantRestContext annotationConstantRest() throws RecognitionException {
		AnnotationConstantRestContext _localctx = new AnnotationConstantRestContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_annotationConstantRest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(809);
			variableDeclarators();
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

	public static class DefaultValueContext extends ParserRuleContext {
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public DefaultValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterDefaultValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitDefaultValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitDefaultValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultValueContext defaultValue() throws RecognitionException {
		DefaultValueContext _localctx = new DefaultValueContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_defaultValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(811);
			match(DEFAULT);
			setState(812);
			elementValue();
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

	public static class BlockContext extends ParserRuleContext {
		public BlockBodyContext blockBody() {
			return getRuleContext(BlockBodyContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(814);
			match(LBRACE);
			setState(815);
			blockBody();
			setState(816);
			match(RBRACE);
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

	public static class BlockBodyContext extends ParserRuleContext {
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public BlockBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterBlockBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitBlockBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitBlockBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockBodyContext blockBody() throws RecognitionException {
		BlockBodyContext _localctx = new BlockBodyContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_blockBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(821);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << NEW_ARRAY_LIST) | (1L << NEW_HASH_MAP) | (1L << ABSTRACT) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << ENUM) | (1L << FINAL) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NEW) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << RETURN) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << SUPER) | (1L << SWITCH) | (1L << SYNCHRONIZED) | (1L << THIS) | (1L << THROW) | (1L << TRY) | (1L << VOID) | (1L << WHILE) | (1L << IntegerLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (SEMI - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)) | (1L << (AT - 64)))) != 0)) {
				{
				{
				setState(818);
				blockStatement();
				}
				}
				setState(823);
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

	public static class BlockStatementContext extends ParserRuleContext {
		public LocalVariableDeclarationStatementContext localVariableDeclarationStatement() {
			return getRuleContext(LocalVariableDeclarationStatementContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TypeDeclarationContext typeDeclaration() {
			return getRuleContext(TypeDeclarationContext.class,0);
		}
		public XmlElementContext xmlElement() {
			return getRuleContext(XmlElementContext.class,0);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_blockStatement);
		try {
			setState(828);
			switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(824);
				localVariableDeclarationStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(825);
				statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(826);
				typeDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(827);
				xmlElement();
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

	public static class XmlElementContext extends ParserRuleContext {
		public Token el;
		public List<TerminalNode> Identifier() { return getTokens(LatteXtendParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(LatteXtendParser.Identifier, i);
		}
		public List<XmlAttributeContext> xmlAttribute() {
			return getRuleContexts(XmlAttributeContext.class);
		}
		public XmlAttributeContext xmlAttribute(int i) {
			return getRuleContext(XmlAttributeContext.class,i);
		}
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public XmlElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xmlElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterXmlElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitXmlElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitXmlElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XmlElementContext xmlElement() throws RecognitionException {
		XmlElementContext _localctx = new XmlElementContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_xmlElement);
		int _la;
		try {
			setState(857);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(830);
				match(LT);
				setState(831);
				((XmlElementContext)_localctx).el = match(Identifier);
				setState(835);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Identifier) {
					{
					{
					setState(832);
					xmlAttribute();
					}
					}
					setState(837);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(838);
				match(GT);
				setState(842);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << NEW_ARRAY_LIST) | (1L << NEW_HASH_MAP) | (1L << ABSTRACT) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << ENUM) | (1L << FINAL) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NEW) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << RETURN) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << SUPER) | (1L << SWITCH) | (1L << SYNCHRONIZED) | (1L << THIS) | (1L << THROW) | (1L << TRY) | (1L << VOID) | (1L << WHILE) | (1L << IntegerLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (SEMI - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)) | (1L << (AT - 64)))) != 0)) {
					{
					{
					setState(839);
					blockStatement();
					}
					}
					setState(844);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(845);
				match(T__4);
				setState(846);
				match(Identifier);
				setState(847);
				match(GT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(848);
				match(LT);
				setState(849);
				((XmlElementContext)_localctx).el = match(Identifier);
				setState(853);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Identifier) {
					{
					{
					setState(850);
					xmlAttribute();
					}
					}
					setState(855);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(856);
				match(T__5);
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

	public static class XmlAttributeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(LatteXtendParser.Identifier, 0); }
		public TerminalNode StringLiteral() { return getToken(LatteXtendParser.StringLiteral, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public XmlAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xmlAttribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterXmlAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitXmlAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitXmlAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XmlAttributeContext xmlAttribute() throws RecognitionException {
		XmlAttributeContext _localctx = new XmlAttributeContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_xmlAttribute);
		try {
			setState(868);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(859);
				match(Identifier);
				setState(860);
				match(ASSIGN);
				setState(861);
				match(StringLiteral);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(862);
				match(Identifier);
				setState(863);
				match(ASSIGN);
				setState(864);
				match(LBRACE);
				setState(865);
				expression(0);
				setState(866);
				match(RBRACE);
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

	public static class LocalVariableDeclarationStatementContext extends ParserRuleContext {
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public LocalVariableDeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclarationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterLocalVariableDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitLocalVariableDeclarationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitLocalVariableDeclarationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVariableDeclarationStatementContext localVariableDeclarationStatement() throws RecognitionException {
		LocalVariableDeclarationStatementContext _localctx = new LocalVariableDeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_localVariableDeclarationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(870);
			localVariableDeclaration();
			setState(871);
			eos();
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

	public static class LocalVariableDeclarationContext extends ParserRuleContext {
		public Token mod;
		public VariableDeclaratorContext variableDeclarator() {
			return getRuleContext(VariableDeclaratorContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public LocalVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterLocalVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitLocalVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitLocalVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVariableDeclarationContext localVariableDeclaration() throws RecognitionException {
		LocalVariableDeclarationContext _localctx = new LocalVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_localVariableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(873);
			((LocalVariableDeclarationContext)_localctx).mod = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__2 || _la==T__3) ) {
				((LocalVariableDeclarationContext)_localctx).mod = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(877);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(874);
				variableModifier();
				}
				}
				setState(879);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(881);
			switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
			case 1:
				{
				setState(880);
				type();
				}
				break;
			}
			setState(883);
			variableDeclarator();
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

	public static class StatementContext extends ParserRuleContext {
		public BlockContext xblock;
		public Token xif;
		public StatementContext stmt;
		public Token xelse;
		public StatementContext e_stmt;
		public Token xfor;
		public Token xwhile;
		public Token xdo;
		public Token xtry;
		public Token xswitch;
		public Token xsynch;
		public Token xreturn;
		public Token xthrow;
		public Token xbreak;
		public Token xcontinue;
		public Token xsemi;
		public StatementExpressionContext xexpr;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode ASSERT() { return getToken(LatteXtendParser.ASSERT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ForControlContext forControl() {
			return getRuleContext(ForControlContext.class,0);
		}
		public FinallyBlockContext finallyBlock() {
			return getRuleContext(FinallyBlockContext.class,0);
		}
		public List<CatchClauseContext> catchClause() {
			return getRuleContexts(CatchClauseContext.class);
		}
		public CatchClauseContext catchClause(int i) {
			return getRuleContext(CatchClauseContext.class,i);
		}
		public ResourceSpecificationContext resourceSpecification() {
			return getRuleContext(ResourceSpecificationContext.class,0);
		}
		public List<SwitchBlockStatementGroupContext> switchBlockStatementGroup() {
			return getRuleContexts(SwitchBlockStatementGroupContext.class);
		}
		public SwitchBlockStatementGroupContext switchBlockStatementGroup(int i) {
			return getRuleContext(SwitchBlockStatementGroupContext.class,i);
		}
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public TerminalNode Identifier() { return getToken(LatteXtendParser.Identifier, 0); }
		public StatementExpressionContext statementExpression() {
			return getRuleContext(StatementExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(989);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(885);
				((StatementContext)_localctx).xblock = block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(886);
				match(ASSERT);
				setState(887);
				expression(0);
				setState(890);
				switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
				case 1:
					{
					setState(888);
					match(COLON);
					setState(889);
					expression(0);
					}
					break;
				}
				setState(892);
				eos();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(894);
				((StatementContext)_localctx).xif = match(IF);
				setState(895);
				parExpression();
				setState(896);
				((StatementContext)_localctx).stmt = statement();
				setState(899);
				switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
				case 1:
					{
					setState(897);
					((StatementContext)_localctx).xelse = match(ELSE);
					setState(898);
					((StatementContext)_localctx).e_stmt = statement();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(901);
				((StatementContext)_localctx).xfor = match(FOR);
				setState(902);
				match(LPAREN);
				setState(903);
				forControl();
				setState(904);
				match(RPAREN);
				setState(905);
				((StatementContext)_localctx).stmt = statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(907);
				((StatementContext)_localctx).xwhile = match(WHILE);
				setState(908);
				parExpression();
				setState(909);
				((StatementContext)_localctx).stmt = statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(911);
				((StatementContext)_localctx).xdo = match(DO);
				setState(912);
				((StatementContext)_localctx).stmt = statement();
				setState(913);
				match(WHILE);
				setState(914);
				parExpression();
				setState(915);
				eos();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(917);
				((StatementContext)_localctx).xtry = match(TRY);
				setState(918);
				block();
				setState(928);
				switch (_input.LA(1)) {
				case CATCH:
					{
					setState(920); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(919);
						catchClause();
						}
						}
						setState(922); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CATCH );
					setState(925);
					_la = _input.LA(1);
					if (_la==FINALLY) {
						{
						setState(924);
						finallyBlock();
						}
					}

					}
					break;
				case FINALLY:
					{
					setState(927);
					finallyBlock();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(930);
				((StatementContext)_localctx).xtry = match(TRY);
				setState(931);
				resourceSpecification();
				setState(932);
				block();
				setState(936);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CATCH) {
					{
					{
					setState(933);
					catchClause();
					}
					}
					setState(938);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(940);
				_la = _input.LA(1);
				if (_la==FINALLY) {
					{
					setState(939);
					finallyBlock();
					}
				}

				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(942);
				((StatementContext)_localctx).xswitch = match(SWITCH);
				setState(943);
				parExpression();
				setState(944);
				match(LBRACE);
				setState(948);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,109,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(945);
						switchBlockStatementGroup();
						}
						} 
					}
					setState(950);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,109,_ctx);
				}
				setState(954);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CASE || _la==DEFAULT) {
					{
					{
					setState(951);
					switchLabel();
					}
					}
					setState(956);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(957);
				match(RBRACE);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(959);
				((StatementContext)_localctx).xsynch = match(SYNCHRONIZED);
				setState(960);
				parExpression();
				setState(961);
				block();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(963);
				((StatementContext)_localctx).xreturn = match(RETURN);
				setState(965);
				switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
				case 1:
					{
					setState(964);
					expression(0);
					}
					break;
				}
				setState(967);
				eos();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(968);
				((StatementContext)_localctx).xthrow = match(THROW);
				setState(969);
				expression(0);
				setState(970);
				eos();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(972);
				((StatementContext)_localctx).xbreak = match(BREAK);
				setState(974);
				switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
				case 1:
					{
					setState(973);
					match(Identifier);
					}
					break;
				}
				setState(976);
				eos();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(977);
				((StatementContext)_localctx).xcontinue = match(CONTINUE);
				setState(979);
				switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
				case 1:
					{
					setState(978);
					match(Identifier);
					}
					break;
				}
				setState(981);
				eos();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(982);
				((StatementContext)_localctx).xsemi = match(SEMI);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(983);
				((StatementContext)_localctx).xexpr = statementExpression();
				setState(984);
				eos();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(986);
				match(Identifier);
				setState(987);
				match(COLON);
				setState(988);
				statement();
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

	public static class CatchClauseContext extends ParserRuleContext {
		public CatchTypeContext catchType() {
			return getRuleContext(CatchTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(LatteXtendParser.Identifier, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public CatchClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterCatchClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitCatchClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitCatchClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatchClauseContext catchClause() throws RecognitionException {
		CatchClauseContext _localctx = new CatchClauseContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_catchClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(991);
			match(CATCH);
			setState(992);
			match(LPAREN);
			setState(996);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(993);
				variableModifier();
				}
				}
				setState(998);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(999);
			catchType();
			setState(1000);
			match(Identifier);
			setState(1001);
			match(RPAREN);
			setState(1002);
			block();
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

	public static class CatchTypeContext extends ParserRuleContext {
		public List<QualifiedNameContext> qualifiedName() {
			return getRuleContexts(QualifiedNameContext.class);
		}
		public QualifiedNameContext qualifiedName(int i) {
			return getRuleContext(QualifiedNameContext.class,i);
		}
		public CatchTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterCatchType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitCatchType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitCatchType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatchTypeContext catchType() throws RecognitionException {
		CatchTypeContext _localctx = new CatchTypeContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_catchType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1004);
			qualifiedName();
			setState(1009);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BITOR) {
				{
				{
				setState(1005);
				match(BITOR);
				setState(1006);
				qualifiedName();
				}
				}
				setState(1011);
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

	public static class FinallyBlockContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FinallyBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finallyBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterFinallyBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitFinallyBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitFinallyBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FinallyBlockContext finallyBlock() throws RecognitionException {
		FinallyBlockContext _localctx = new FinallyBlockContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_finallyBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1012);
			match(FINALLY);
			setState(1013);
			block();
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

	public static class ResourceSpecificationContext extends ParserRuleContext {
		public ResourcesContext resources() {
			return getRuleContext(ResourcesContext.class,0);
		}
		public ResourceSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resourceSpecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterResourceSpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitResourceSpecification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitResourceSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResourceSpecificationContext resourceSpecification() throws RecognitionException {
		ResourceSpecificationContext _localctx = new ResourceSpecificationContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_resourceSpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1015);
			match(LPAREN);
			setState(1016);
			resources();
			setState(1018);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(1017);
				match(SEMI);
				}
			}

			setState(1020);
			match(RPAREN);
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

	public static class ResourcesContext extends ParserRuleContext {
		public List<ResourceContext> resource() {
			return getRuleContexts(ResourceContext.class);
		}
		public ResourceContext resource(int i) {
			return getRuleContext(ResourceContext.class,i);
		}
		public ResourcesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resources; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterResources(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitResources(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitResources(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResourcesContext resources() throws RecognitionException {
		ResourcesContext _localctx = new ResourcesContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_resources);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1022);
			resource();
			setState(1027);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,118,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1023);
					match(SEMI);
					setState(1024);
					resource();
					}
					} 
				}
				setState(1029);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,118,_ctx);
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

	public static class ResourceContext extends ParserRuleContext {
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public ResourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resource; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterResource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitResource(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitResource(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResourceContext resource() throws RecognitionException {
		ResourceContext _localctx = new ResourceContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_resource);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1033);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(1030);
				variableModifier();
				}
				}
				setState(1035);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1036);
			classOrInterfaceType();
			setState(1037);
			variableDeclaratorId();
			setState(1038);
			match(ASSIGN);
			setState(1039);
			expression(0);
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

	public static class SwitchBlockStatementGroupContext extends ParserRuleContext {
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public SwitchBlockStatementGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchBlockStatementGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterSwitchBlockStatementGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitSwitchBlockStatementGroup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitSwitchBlockStatementGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchBlockStatementGroupContext switchBlockStatementGroup() throws RecognitionException {
		SwitchBlockStatementGroupContext _localctx = new SwitchBlockStatementGroupContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_switchBlockStatementGroup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1042); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1041);
				switchLabel();
				}
				}
				setState(1044); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CASE || _la==DEFAULT );
			setState(1047); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1046);
				blockStatement();
				}
				}
				setState(1049); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << NEW_ARRAY_LIST) | (1L << NEW_HASH_MAP) | (1L << ABSTRACT) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << ENUM) | (1L << FINAL) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NEW) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << RETURN) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << SUPER) | (1L << SWITCH) | (1L << SYNCHRONIZED) | (1L << THIS) | (1L << THROW) | (1L << TRY) | (1L << VOID) | (1L << WHILE) | (1L << IntegerLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (SEMI - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)) | (1L << (AT - 64)))) != 0) );
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

	public static class SwitchLabelContext extends ParserRuleContext {
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public EnumConstantNameContext enumConstantName() {
			return getRuleContext(EnumConstantNameContext.class,0);
		}
		public SwitchLabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchLabel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterSwitchLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitSwitchLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitSwitchLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchLabelContext switchLabel() throws RecognitionException {
		SwitchLabelContext _localctx = new SwitchLabelContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_switchLabel);
		try {
			setState(1061);
			switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1051);
				match(CASE);
				setState(1052);
				constantExpression();
				setState(1053);
				match(COLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1055);
				match(CASE);
				setState(1056);
				enumConstantName();
				setState(1057);
				match(COLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1059);
				match(DEFAULT);
				setState(1060);
				match(COLON);
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

	public static class ForControlContext extends ParserRuleContext {
		public EnhancedForControlContext enhancedForControl() {
			return getRuleContext(EnhancedForControlContext.class,0);
		}
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForUpdateContext forUpdate() {
			return getRuleContext(ForUpdateContext.class,0);
		}
		public ForControlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forControl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterForControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitForControl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitForControl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForControlContext forControl() throws RecognitionException {
		ForControlContext _localctx = new ForControlContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_forControl);
		int _la;
		try {
			setState(1075);
			switch ( getInterpreter().adaptivePredict(_input,126,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1063);
				enhancedForControl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1065);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << NEW_ARRAY_LIST) | (1L << NEW_HASH_MAP) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(1064);
					forInit();
					}
				}

				setState(1067);
				match(SEMI);
				setState(1069);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW_ARRAY_LIST) | (1L << NEW_HASH_MAP) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(1068);
					expression(0);
					}
				}

				setState(1071);
				match(SEMI);
				setState(1073);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW_ARRAY_LIST) | (1L << NEW_HASH_MAP) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(1072);
					forUpdate();
					}
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

	public static class ForInitContext extends ParserRuleContext {
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterForInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitForInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitForInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_forInit);
		try {
			setState(1079);
			switch (_input.LA(1)) {
			case T__2:
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(1077);
				localVariableDeclaration();
				}
				break;
			case NEW_ARRAY_LIST:
			case NEW_HASH_MAP:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case SHORT:
			case SUPER:
			case THIS:
			case VOID:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case LT:
			case BANG:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(1078);
				expressionList();
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

	public static class EnhancedForControlContext extends ParserRuleContext {
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public EnhancedForControlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enhancedForControl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterEnhancedForControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitEnhancedForControl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitEnhancedForControl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnhancedForControlContext enhancedForControl() throws RecognitionException {
		EnhancedForControlContext _localctx = new EnhancedForControlContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_enhancedForControl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1082);
			switch ( getInterpreter().adaptivePredict(_input,128,_ctx) ) {
			case 1:
				{
				setState(1081);
				type();
				}
				break;
			}
			setState(1084);
			variableDeclaratorId();
			setState(1085);
			match(COLON);
			setState(1086);
			expression(0);
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

	public static class ForUpdateContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ForUpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forUpdate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterForUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitForUpdate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitForUpdate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForUpdateContext forUpdate() throws RecognitionException {
		ForUpdateContext _localctx = new ForUpdateContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_forUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1088);
			expressionList();
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

	public static class ParExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterParExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitParExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitParExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParExpressionContext parExpression() throws RecognitionException {
		ParExpressionContext _localctx = new ParExpressionContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_parExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1090);
			match(LPAREN);
			setState(1091);
			expression(0);
			setState(1092);
			match(RPAREN);
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

	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1094);
			expression(0);
			setState(1099);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1095);
				match(COMMA);
				setState(1096);
				expression(0);
				}
				}
				setState(1101);
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

	public static class StatementExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterStatementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitStatementExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitStatementExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementExpressionContext statementExpression() throws RecognitionException {
		StatementExpressionContext _localctx = new StatementExpressionContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_statementExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1102);
			expression(0);
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

	public static class ConstantExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConstantExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterConstantExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitConstantExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitConstantExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantExpressionContext constantExpression() throws RecognitionException {
		ConstantExpressionContext _localctx = new ConstantExpressionContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_constantExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1104);
			expression(0);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext left;
		public ExpressionContext array_ref_expr;
		public ExpressionContext method_call_expr;
		public ExpressionContext expr;
		public Token prefix_op;
		public Token logical_not_op;
		public PrimaryContext primaryExpression;
		public Token constructor;
		public Token newArrayList;
		public Token newHashMap;
		public Token op_math;
		public ExpressionContext right;
		public Token bit_op;
		public Token bitop;
		public Token logical_op;
		public Token boolean_op;
		public Token range_op;
		public Token assign_op;
		public Token dot;
		public Token member;
		public Token method;
		public ExplicitGenericInvocationContext generic_method;
		public ExpressionContext array_index;
		public ExpressionListContext invocation_parameters;
		public Token as_op;
		public Token postfix_op;
		public Token instanceof_op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public CreatorContext creator() {
			return getRuleContext(CreatorContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(LatteXtendParser.Identifier, 0); }
		public InnerCreatorContext innerCreator() {
			return getRuleContext(InnerCreatorContext.class,0);
		}
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
			return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public SuperSuffixContext superSuffix() {
			return getRuleContext(SuperSuffixContext.class,0);
		}
		public ExplicitGenericInvocationContext explicitGenericInvocation() {
			return getRuleContext(ExplicitGenericInvocationContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 182;
		enterRecursionRule(_localctx, 182, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1139);
			switch (_input.LA(1)) {
			case INC:
			case DEC:
			case ADD:
			case SUB:
				{
				setState(1111);
				switch (_input.LA(1)) {
				case ADD:
					{
					setState(1107);
					((ExpressionContext)_localctx).prefix_op = match(ADD);
					}
					break;
				case SUB:
					{
					setState(1108);
					((ExpressionContext)_localctx).prefix_op = match(SUB);
					}
					break;
				case INC:
					{
					setState(1109);
					((ExpressionContext)_localctx).prefix_op = match(INC);
					}
					break;
				case DEC:
					{
					setState(1110);
					((ExpressionContext)_localctx).prefix_op = match(DEC);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1113);
				((ExpressionContext)_localctx).expr = expression(12);
				 this.exprTypes.put(_localctx, ExpressionType.PrefixOperator); 
				}
				break;
			case BANG:
				{
				{
				setState(1116);
				((ExpressionContext)_localctx).logical_not_op = match(BANG);
				}
				setState(1117);
				expression(11);
				 this.exprTypes.put(_localctx, ExpressionType.Negate); 
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case SUPER:
			case THIS:
			case VOID:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case LT:
			case Identifier:
				{
				setState(1120);
				((ExpressionContext)_localctx).primaryExpression = primary();
				}
				break;
			case NEW:
				{
				setState(1121);
				((ExpressionContext)_localctx).constructor = match(NEW);
				setState(1122);
				creator();
				 this.exprTypes.put(_localctx, ExpressionType.CreatorExpression); 
				}
				break;
			case NEW_ARRAY_LIST:
				{
				setState(1125);
				((ExpressionContext)_localctx).newArrayList = match(NEW_ARRAY_LIST);
				setState(1126);
				match(LPAREN);
				setState(1128);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW_ARRAY_LIST) | (1L << NEW_HASH_MAP) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(1127);
					expressionList();
					}
				}

				setState(1130);
				match(RPAREN);
				 this.exprTypes.put(_localctx, ExpressionType.MutableArrayLiteral); 
				}
				break;
			case NEW_HASH_MAP:
				{
				setState(1132);
				((ExpressionContext)_localctx).newHashMap = match(NEW_HASH_MAP);
				setState(1133);
				match(LPAREN);
				setState(1135);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW_ARRAY_LIST) | (1L << NEW_HASH_MAP) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(1134);
					expressionList();
					}
				}

				setState(1137);
				match(RPAREN);
				 this.exprTypes.put(_localctx, ExpressionType.MutableMapLiteral); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1277);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,144,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1275);
					switch ( getInterpreter().adaptivePredict(_input,143,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1141);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1145);
						switch (_input.LA(1)) {
						case MUL:
							{
							setState(1142);
							((ExpressionContext)_localctx).op_math = match(MUL);
							}
							break;
						case DIV:
							{
							setState(1143);
							((ExpressionContext)_localctx).op_math = match(DIV);
							}
							break;
						case MOD:
							{
							setState(1144);
							((ExpressionContext)_localctx).op_math = match(MOD);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1147);
						((ExpressionContext)_localctx).right = expression(11);
						 this.exprTypes.put(_localctx, ExpressionType.Arithmetic); 
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1150);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(1153);
						switch (_input.LA(1)) {
						case ADD:
							{
							setState(1151);
							((ExpressionContext)_localctx).op_math = match(ADD);
							}
							break;
						case SUB:
							{
							setState(1152);
							((ExpressionContext)_localctx).op_math = match(SUB);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1155);
						((ExpressionContext)_localctx).right = expression(10);
						 this.exprTypes.put(_localctx, ExpressionType.Arithmetic); 
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1158);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(1162);
						switch (_input.LA(1)) {
						case T__7:
							{
							setState(1159);
							((ExpressionContext)_localctx).bit_op = match(T__7);
							}
							break;
						case T__8:
							{
							setState(1160);
							((ExpressionContext)_localctx).bit_op = match(T__8);
							}
							break;
						case T__9:
							{
							setState(1161);
							((ExpressionContext)_localctx).bitop = match(T__9);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1164);
						((ExpressionContext)_localctx).right = expression(9);
						 this.exprTypes.put(_localctx, ExpressionType.Logical); 
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1167);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1172);
						switch (_input.LA(1)) {
						case LE:
							{
							setState(1168);
							((ExpressionContext)_localctx).logical_op = match(LE);
							}
							break;
						case GE:
							{
							setState(1169);
							((ExpressionContext)_localctx).logical_op = match(GE);
							}
							break;
						case GT:
							{
							setState(1170);
							((ExpressionContext)_localctx).logical_op = match(GT);
							}
							break;
						case LT:
							{
							setState(1171);
							((ExpressionContext)_localctx).logical_op = match(LT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1174);
						((ExpressionContext)_localctx).right = expression(8);
						 this.exprTypes.put(_localctx, ExpressionType.Logical); 
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1177);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1180);
						switch (_input.LA(1)) {
						case EQUAL:
							{
							setState(1178);
							((ExpressionContext)_localctx).logical_op = match(EQUAL);
							}
							break;
						case NOTEQUAL:
							{
							setState(1179);
							((ExpressionContext)_localctx).logical_op = match(NOTEQUAL);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1182);
						((ExpressionContext)_localctx).right = expression(6);
						 this.exprTypes.put(_localctx, ExpressionType.EqualTest); 
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1185);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1186);
						((ExpressionContext)_localctx).boolean_op = match(AND);
						setState(1187);
						expression(5);
						 this.exprTypes.put(_localctx, ExpressionType.Logical); 
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1190);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1191);
						((ExpressionContext)_localctx).boolean_op = match(OR);
						setState(1192);
						expression(4);
						 this.exprTypes.put(_localctx, ExpressionType.Logical); 
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1195);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(1196);
						((ExpressionContext)_localctx).range_op = match(RANGE);
						setState(1197);
						expression(3);
						 this.exprTypes.put(_localctx, ExpressionType.Range); 
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1200);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(1213);
						switch (_input.LA(1)) {
						case ASSIGN:
							{
							setState(1201);
							((ExpressionContext)_localctx).assign_op = match(ASSIGN);
							}
							break;
						case ADD_ASSIGN:
							{
							setState(1202);
							((ExpressionContext)_localctx).assign_op = match(ADD_ASSIGN);
							}
							break;
						case SUB_ASSIGN:
							{
							setState(1203);
							((ExpressionContext)_localctx).assign_op = match(SUB_ASSIGN);
							}
							break;
						case MUL_ASSIGN:
							{
							setState(1204);
							((ExpressionContext)_localctx).assign_op = match(MUL_ASSIGN);
							}
							break;
						case DIV_ASSIGN:
							{
							setState(1205);
							((ExpressionContext)_localctx).assign_op = match(DIV_ASSIGN);
							}
							break;
						case AND_ASSIGN:
							{
							setState(1206);
							((ExpressionContext)_localctx).assign_op = match(AND_ASSIGN);
							}
							break;
						case OR_ASSIGN:
							{
							setState(1207);
							((ExpressionContext)_localctx).assign_op = match(OR_ASSIGN);
							}
							break;
						case XOR_ASSIGN:
							{
							setState(1208);
							((ExpressionContext)_localctx).assign_op = match(XOR_ASSIGN);
							}
							break;
						case RSHIFT_ASSIGN:
							{
							setState(1209);
							((ExpressionContext)_localctx).assign_op = match(RSHIFT_ASSIGN);
							}
							break;
						case URSHIFT_ASSIGN:
							{
							setState(1210);
							((ExpressionContext)_localctx).assign_op = match(URSHIFT_ASSIGN);
							}
							break;
						case LSHIFT_ASSIGN:
							{
							setState(1211);
							((ExpressionContext)_localctx).assign_op = match(LSHIFT_ASSIGN);
							}
							break;
						case MOD_ASSIGN:
							{
							setState(1212);
							((ExpressionContext)_localctx).assign_op = match(MOD_ASSIGN);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1215);
						((ExpressionContext)_localctx).right = expression(1);
						 this.exprTypes.put(_localctx, ExpressionType.AssignWithOp); 
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1218);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(1219);
						((ExpressionContext)_localctx).dot = match(DOT);
						setState(1220);
						((ExpressionContext)_localctx).member = match(Identifier);
						 this.exprTypes.put(_localctx, ExpressionType.MemberReference); 
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1222);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(1223);
						((ExpressionContext)_localctx).dot = match(DOT);
						setState(1224);
						((ExpressionContext)_localctx).member = match(THIS);
						 this.exprTypes.put(_localctx, ExpressionType.ThisReference); 
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1226);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(1227);
						((ExpressionContext)_localctx).dot = match(DOT);
						setState(1228);
						((ExpressionContext)_localctx).method = match(NEW);
						setState(1230);
						_la = _input.LA(1);
						if (_la==LT) {
							{
							setState(1229);
							nonWildcardTypeArguments();
							}
						}

						setState(1232);
						innerCreator();
						 this.exprTypes.put(_localctx, ExpressionType.SubAnonymouseClass); 
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1235);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(1236);
						((ExpressionContext)_localctx).dot = match(DOT);
						setState(1237);
						((ExpressionContext)_localctx).method = match(SUPER);
						setState(1238);
						superSuffix();
						 this.exprTypes.put(_localctx, ExpressionType.SuperInvocation); 
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1241);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(1242);
						((ExpressionContext)_localctx).dot = match(DOT);
						setState(1243);
						((ExpressionContext)_localctx).generic_method = explicitGenericInvocation();
						 this.exprTypes.put(_localctx, ExpressionType.ExplicitGenericInvocation); 
						}
						break;
					case 15:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.array_ref_expr = _prevctx;
						_localctx.array_ref_expr = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1246);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(1247);
						match(LBRACK);
						setState(1248);
						((ExpressionContext)_localctx).array_index = expression(0);
						setState(1249);
						match(RBRACK);
						 this.exprTypes.put(_localctx, ExpressionType.ArraySubscript); 
						}
						break;
					case 16:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.method_call_expr = _prevctx;
						_localctx.method_call_expr = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1252);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(1253);
						match(LPAREN);
						setState(1255);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW_ARRAY_LIST) | (1L << NEW_HASH_MAP) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
							{
							setState(1254);
							((ExpressionContext)_localctx).invocation_parameters = expressionList();
							}
						}

						setState(1257);
						match(RPAREN);
						 this.exprTypes.put(_localctx, ExpressionType.MethodInvocation); 
						}
						break;
					case 17:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1259);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(1260);
						((ExpressionContext)_localctx).as_op = match(T__6);
						setState(1261);
						type();
						 this.exprTypes.put(_localctx, ExpressionType.TypeCasting); 
						}
						break;
					case 18:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.expr = _prevctx;
						_localctx.expr = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1264);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1267);
						switch (_input.LA(1)) {
						case INC:
							{
							setState(1265);
							((ExpressionContext)_localctx).postfix_op = match(INC);
							}
							break;
						case DEC:
							{
							setState(1266);
							((ExpressionContext)_localctx).postfix_op = match(DEC);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						 this.exprTypes.put(_localctx, ExpressionType.PostfixOperator); 
						}
						break;
					case 19:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1270);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1271);
						((ExpressionContext)_localctx).instanceof_op = match(INSTANCEOF);
						setState(1272);
						type();
						 this.exprTypes.put(_localctx, ExpressionType.InstanceOf); 
						}
						break;
					}
					} 
				}
				setState(1279);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,144,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public Token thisRef;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(LatteXtendParser.Identifier, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
			return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public ExplicitGenericInvocationSuffixContext explicitGenericInvocationSuffix() {
			return getRuleContext(ExplicitGenericInvocationSuffixContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_primary);
		try {
			setState(1301);
			switch ( getInterpreter().adaptivePredict(_input,146,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1280);
				match(LPAREN);
				setState(1281);
				expression(0);
				setState(1282);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1284);
				((PrimaryContext)_localctx).thisRef = match(THIS);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1285);
				match(SUPER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1286);
				literal();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1287);
				match(Identifier);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1288);
				type();
				setState(1289);
				match(DOT);
				setState(1290);
				match(CLASS);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1292);
				match(VOID);
				setState(1293);
				match(DOT);
				setState(1294);
				match(CLASS);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1295);
				nonWildcardTypeArguments();
				setState(1299);
				switch (_input.LA(1)) {
				case SUPER:
				case Identifier:
					{
					setState(1296);
					explicitGenericInvocationSuffix();
					}
					break;
				case THIS:
					{
					setState(1297);
					match(THIS);
					setState(1298);
					arguments();
					}
					break;
				default:
					throw new NoViableAltException(this);
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

	public static class CreatorContext extends ParserRuleContext {
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
			return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public CreatedNameContext createdName() {
			return getRuleContext(CreatedNameContext.class,0);
		}
		public ClassCreatorRestContext classCreatorRest() {
			return getRuleContext(ClassCreatorRestContext.class,0);
		}
		public ArrayCreatorRestContext arrayCreatorRest() {
			return getRuleContext(ArrayCreatorRestContext.class,0);
		}
		public CreatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterCreator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitCreator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitCreator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreatorContext creator() throws RecognitionException {
		CreatorContext _localctx = new CreatorContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_creator);
		try {
			setState(1312);
			switch (_input.LA(1)) {
			case LT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1303);
				nonWildcardTypeArguments();
				setState(1304);
				createdName();
				setState(1305);
				classCreatorRest();
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(1307);
				createdName();
				setState(1310);
				switch (_input.LA(1)) {
				case LBRACK:
					{
					setState(1308);
					arrayCreatorRest();
					}
					break;
				case LPAREN:
					{
					setState(1309);
					classCreatorRest();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
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

	public static class CreatedNameContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(LatteXtendParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(LatteXtendParser.Identifier, i);
		}
		public List<TypeArgumentsOrDiamondContext> typeArgumentsOrDiamond() {
			return getRuleContexts(TypeArgumentsOrDiamondContext.class);
		}
		public TypeArgumentsOrDiamondContext typeArgumentsOrDiamond(int i) {
			return getRuleContext(TypeArgumentsOrDiamondContext.class,i);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public CreatedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createdName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterCreatedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitCreatedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitCreatedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreatedNameContext createdName() throws RecognitionException {
		CreatedNameContext _localctx = new CreatedNameContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_createdName);
		int _la;
		try {
			setState(1329);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1314);
				match(Identifier);
				setState(1316);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1315);
					typeArgumentsOrDiamond();
					}
				}

				setState(1325);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(1318);
					match(DOT);
					setState(1319);
					match(Identifier);
					setState(1321);
					_la = _input.LA(1);
					if (_la==LT) {
						{
						setState(1320);
						typeArgumentsOrDiamond();
						}
					}

					}
					}
					setState(1327);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1328);
				primitiveType();
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

	public static class InnerCreatorContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(LatteXtendParser.Identifier, 0); }
		public ClassCreatorRestContext classCreatorRest() {
			return getRuleContext(ClassCreatorRestContext.class,0);
		}
		public NonWildcardTypeArgumentsOrDiamondContext nonWildcardTypeArgumentsOrDiamond() {
			return getRuleContext(NonWildcardTypeArgumentsOrDiamondContext.class,0);
		}
		public InnerCreatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_innerCreator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterInnerCreator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitInnerCreator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitInnerCreator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InnerCreatorContext innerCreator() throws RecognitionException {
		InnerCreatorContext _localctx = new InnerCreatorContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_innerCreator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1331);
			match(Identifier);
			setState(1333);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(1332);
				nonWildcardTypeArgumentsOrDiamond();
				}
			}

			setState(1335);
			classCreatorRest();
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

	public static class ArrayCreatorRestContext extends ParserRuleContext {
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArrayCreatorRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayCreatorRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterArrayCreatorRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitArrayCreatorRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitArrayCreatorRest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayCreatorRestContext arrayCreatorRest() throws RecognitionException {
		ArrayCreatorRestContext _localctx = new ArrayCreatorRestContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_arrayCreatorRest);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1337);
			match(LBRACK);
			setState(1365);
			switch (_input.LA(1)) {
			case RBRACK:
				{
				setState(1338);
				match(RBRACK);
				setState(1343);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(1339);
					match(LBRACK);
					setState(1340);
					match(RBRACK);
					}
					}
					setState(1345);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1346);
				arrayInitializer();
				}
				break;
			case NEW_ARRAY_LIST:
			case NEW_HASH_MAP:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case SHORT:
			case SUPER:
			case THIS:
			case VOID:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case LT:
			case BANG:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case Identifier:
				{
				setState(1347);
				expression(0);
				setState(1348);
				match(RBRACK);
				setState(1355);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,155,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1349);
						match(LBRACK);
						setState(1350);
						expression(0);
						setState(1351);
						match(RBRACK);
						}
						} 
					}
					setState(1357);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,155,_ctx);
				}
				setState(1362);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,156,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1358);
						match(LBRACK);
						setState(1359);
						match(RBRACK);
						}
						} 
					}
					setState(1364);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,156,_ctx);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ClassCreatorRestContext extends ParserRuleContext {
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public ClassCreatorRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classCreatorRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterClassCreatorRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitClassCreatorRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitClassCreatorRest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassCreatorRestContext classCreatorRest() throws RecognitionException {
		ClassCreatorRestContext _localctx = new ClassCreatorRestContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_classCreatorRest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1367);
			arguments();
			setState(1369);
			switch ( getInterpreter().adaptivePredict(_input,158,_ctx) ) {
			case 1:
				{
				setState(1368);
				classBody();
				}
				break;
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

	public static class ExplicitGenericInvocationContext extends ParserRuleContext {
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
			return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public ExplicitGenericInvocationSuffixContext explicitGenericInvocationSuffix() {
			return getRuleContext(ExplicitGenericInvocationSuffixContext.class,0);
		}
		public ExplicitGenericInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicitGenericInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterExplicitGenericInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitExplicitGenericInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitExplicitGenericInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExplicitGenericInvocationContext explicitGenericInvocation() throws RecognitionException {
		ExplicitGenericInvocationContext _localctx = new ExplicitGenericInvocationContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_explicitGenericInvocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1371);
			nonWildcardTypeArguments();
			setState(1372);
			explicitGenericInvocationSuffix();
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

	public static class NonWildcardTypeArgumentsContext extends ParserRuleContext {
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public NonWildcardTypeArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonWildcardTypeArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterNonWildcardTypeArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitNonWildcardTypeArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitNonWildcardTypeArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonWildcardTypeArgumentsContext nonWildcardTypeArguments() throws RecognitionException {
		NonWildcardTypeArgumentsContext _localctx = new NonWildcardTypeArgumentsContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_nonWildcardTypeArguments);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1374);
			match(LT);
			setState(1375);
			typeList();
			setState(1376);
			match(GT);
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

	public static class TypeArgumentsOrDiamondContext extends ParserRuleContext {
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public TypeArgumentsOrDiamondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgumentsOrDiamond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterTypeArgumentsOrDiamond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitTypeArgumentsOrDiamond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitTypeArgumentsOrDiamond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeArgumentsOrDiamondContext typeArgumentsOrDiamond() throws RecognitionException {
		TypeArgumentsOrDiamondContext _localctx = new TypeArgumentsOrDiamondContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_typeArgumentsOrDiamond);
		try {
			setState(1381);
			switch ( getInterpreter().adaptivePredict(_input,159,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1378);
				match(LT);
				setState(1379);
				match(GT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1380);
				typeArguments();
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

	public static class NonWildcardTypeArgumentsOrDiamondContext extends ParserRuleContext {
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
			return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public NonWildcardTypeArgumentsOrDiamondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonWildcardTypeArgumentsOrDiamond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterNonWildcardTypeArgumentsOrDiamond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitNonWildcardTypeArgumentsOrDiamond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitNonWildcardTypeArgumentsOrDiamond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonWildcardTypeArgumentsOrDiamondContext nonWildcardTypeArgumentsOrDiamond() throws RecognitionException {
		NonWildcardTypeArgumentsOrDiamondContext _localctx = new NonWildcardTypeArgumentsOrDiamondContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_nonWildcardTypeArgumentsOrDiamond);
		try {
			setState(1386);
			switch ( getInterpreter().adaptivePredict(_input,160,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1383);
				match(LT);
				setState(1384);
				match(GT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1385);
				nonWildcardTypeArguments();
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

	public static class SuperSuffixContext extends ParserRuleContext {
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(LatteXtendParser.Identifier, 0); }
		public SuperSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_superSuffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterSuperSuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitSuperSuffix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitSuperSuffix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuperSuffixContext superSuffix() throws RecognitionException {
		SuperSuffixContext _localctx = new SuperSuffixContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_superSuffix);
		try {
			setState(1394);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(1388);
				arguments();
				}
				break;
			case DOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1389);
				match(DOT);
				setState(1390);
				match(Identifier);
				setState(1392);
				switch ( getInterpreter().adaptivePredict(_input,161,_ctx) ) {
				case 1:
					{
					setState(1391);
					arguments();
					}
					break;
				}
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

	public static class ExplicitGenericInvocationSuffixContext extends ParserRuleContext {
		public SuperSuffixContext superSuffix() {
			return getRuleContext(SuperSuffixContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(LatteXtendParser.Identifier, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ExplicitGenericInvocationSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicitGenericInvocationSuffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterExplicitGenericInvocationSuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitExplicitGenericInvocationSuffix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitExplicitGenericInvocationSuffix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExplicitGenericInvocationSuffixContext explicitGenericInvocationSuffix() throws RecognitionException {
		ExplicitGenericInvocationSuffixContext _localctx = new ExplicitGenericInvocationSuffixContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_explicitGenericInvocationSuffix);
		try {
			setState(1400);
			switch (_input.LA(1)) {
			case SUPER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1396);
				match(SUPER);
				setState(1397);
				superSuffix();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(1398);
				match(Identifier);
				setState(1399);
				arguments();
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

	public static class ArgumentsContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1402);
			match(LPAREN);
			setState(1404);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW_ARRAY_LIST) | (1L << NEW_HASH_MAP) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(1403);
				expressionList();
				}
			}

			setState(1406);
			match(RPAREN);
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

	public static class EosContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(LatteXtendParser.EOF, 0); }
		public EosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterEos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitEos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitEos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EosContext eos() throws RecognitionException {
		EosContext _localctx = new EosContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_eos);
		try {
			setState(1412);
			switch ( getInterpreter().adaptivePredict(_input,165,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1408);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1409);
				match(EOF);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1410);
				if (!(lineTerminatorAhead())) throw new FailedPredicateException(this, "lineTerminatorAhead()");
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1411);
				if (!(_input.LT(1).getType() == RBRACE)) throw new FailedPredicateException(this, "_input.LT(1).getType() == RBRACE");
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

	public static class EofContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(LatteXtendParser.EOF, 0); }
		public EofContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eof; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).enterEof(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatteXtendListener ) ((LatteXtendListener)listener).exitEof(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatteXtendVisitor ) return ((LatteXtendVisitor<? extends T>)visitor).visitEof(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EofContext eof() throws RecognitionException {
		EofContext _localctx = new EofContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_eof);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1414);
			match(EOF);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 91:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 105:
			return eos_sempred((EosContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		case 8:
			return precpred(_ctx, 1);
		case 9:
			return precpred(_ctx, 24);
		case 10:
			return precpred(_ctx, 23);
		case 11:
			return precpred(_ctx, 22);
		case 12:
			return precpred(_ctx, 21);
		case 13:
			return precpred(_ctx, 20);
		case 14:
			return precpred(_ctx, 19);
		case 15:
			return precpred(_ctx, 18);
		case 16:
			return precpred(_ctx, 14);
		case 17:
			return precpred(_ctx, 13);
		case 18:
			return precpred(_ctx, 6);
		}
		return true;
	}
	private boolean eos_sempred(EosContext _localctx, int predIndex) {
		switch (predIndex) {
		case 19:
			return lineTerminatorAhead();
		case 20:
			return _input.LT(1).getType() == RBRACE;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3y\u058b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\3\2\5\2\u00da\n\2\3\2\7\2\u00dd\n\2\f\2\16\2\u00e0\13\2\3\2\7"+
		"\2\u00e3\n\2\f\2\16\2\u00e6\13\2\3\2\3\2\3\3\7\3\u00eb\n\3\f\3\16\3\u00ee"+
		"\13\3\3\3\3\3\3\3\3\3\3\4\3\4\5\4\u00f6\n\4\3\4\3\4\3\4\5\4\u00fb\n\4"+
		"\3\4\3\4\3\5\7\5\u0100\n\5\f\5\16\5\u0103\13\5\3\5\3\5\7\5\u0107\n\5\f"+
		"\5\16\5\u010a\13\5\3\5\3\5\7\5\u010e\n\5\f\5\16\5\u0111\13\5\3\5\3\5\7"+
		"\5\u0115\n\5\f\5\16\5\u0118\13\5\3\5\3\5\5\5\u011c\n\5\3\6\3\6\5\6\u0120"+
		"\n\6\3\7\3\7\5\7\u0124\n\7\3\b\3\b\5\b\u0128\n\b\3\t\3\t\3\t\5\t\u012d"+
		"\n\t\3\t\3\t\5\t\u0131\n\t\3\t\3\t\5\t\u0135\n\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\7\n\u013d\n\n\f\n\16\n\u0140\13\n\3\n\3\n\3\13\3\13\3\13\5\13\u0147"+
		"\n\13\3\f\3\f\3\f\7\f\u014c\n\f\f\f\16\f\u014f\13\f\3\r\3\r\3\r\3\r\5"+
		"\r\u0155\n\r\3\r\3\r\5\r\u0159\n\r\3\r\5\r\u015c\n\r\3\r\5\r\u015f\n\r"+
		"\3\r\3\r\3\16\3\16\3\16\7\16\u0166\n\16\f\16\16\16\u0169\13\16\3\17\7"+
		"\17\u016c\n\17\f\17\16\17\u016f\13\17\3\17\3\17\5\17\u0173\n\17\3\17\5"+
		"\17\u0176\n\17\3\20\3\20\7\20\u017a\n\20\f\20\16\20\u017d\13\20\3\21\3"+
		"\21\3\21\5\21\u0182\n\21\3\21\3\21\5\21\u0186\n\21\3\21\3\21\3\22\3\22"+
		"\3\22\7\22\u018d\n\22\f\22\16\22\u0190\13\22\3\23\3\23\7\23\u0194\n\23"+
		"\f\23\16\23\u0197\13\23\3\23\3\23\3\24\3\24\7\24\u019d\n\24\f\24\16\24"+
		"\u01a0\13\24\3\24\3\24\3\25\3\25\5\25\u01a6\n\25\3\25\3\25\7\25\u01aa"+
		"\n\25\f\25\16\25\u01ad\13\25\3\25\5\25\u01b0\n\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u01be\n\26\3\27\3\27\5\27"+
		"\u01c2\n\27\3\27\3\27\3\27\3\27\7\27\u01c8\n\27\f\27\16\27\u01cb\13\27"+
		"\3\27\3\27\5\27\u01cf\n\27\3\27\3\27\5\27\u01d3\n\27\3\30\3\30\3\30\3"+
		"\31\3\31\3\31\3\31\5\31\u01dc\n\31\3\31\3\31\3\32\3\32\3\32\3\33\5\33"+
		"\u01e4\n\33\3\33\3\33\3\33\3\34\7\34\u01ea\n\34\f\34\16\34\u01ed\13\34"+
		"\3\34\3\34\5\34\u01f1\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u01fa"+
		"\n\35\3\36\3\36\3\36\3\36\7\36\u0200\n\36\f\36\16\36\u0203\13\36\3\36"+
		"\3\36\3\37\3\37\3\37\7\37\u020a\n\37\f\37\16\37\u020d\13\37\3\37\3\37"+
		"\3\37\3 \3 \5 \u0214\n \3 \3 \3 \3 \7 \u021a\n \f \16 \u021d\13 \3 \3"+
		" \5 \u0221\n \3 \3 \3!\3!\3!\3\"\3\"\3\"\7\"\u022b\n\"\f\"\16\"\u022e"+
		"\13\"\3#\3#\3#\5#\u0233\n#\3$\3$\3$\7$\u0238\n$\f$\16$\u023b\13$\3%\3"+
		"%\5%\u023f\n%\3&\3&\3&\3&\7&\u0245\n&\f&\16&\u0248\13&\3&\5&\u024b\n&"+
		"\5&\u024d\n&\3&\3&\3\'\3\'\3(\3(\7(\u0255\n(\f(\16(\u0258\13(\3(\3(\7"+
		"(\u025c\n(\f(\16(\u025f\13(\5(\u0261\n(\3)\3)\5)\u0265\n)\3)\3)\3)\5)"+
		"\u026a\n)\7)\u026c\n)\f)\16)\u026f\13)\3*\3*\3*\3+\3+\3,\3,\3,\3,\7,\u027a"+
		"\n,\f,\16,\u027d\13,\3,\3,\3-\3-\3-\3-\5-\u0285\n-\5-\u0287\n-\3.\3.\3"+
		".\7.\u028c\n.\f.\16.\u028f\13.\3/\3/\5/\u0293\n/\3/\3/\3\60\3\60\3\60"+
		"\7\60\u029a\n\60\f\60\16\60\u029d\13\60\3\60\3\60\5\60\u02a1\n\60\3\60"+
		"\5\60\u02a4\n\60\3\61\7\61\u02a7\n\61\f\61\16\61\u02aa\13\61\3\61\3\61"+
		"\3\61\3\62\7\62\u02b0\n\62\f\62\16\62\u02b3\13\62\3\62\3\62\3\62\3\62"+
		"\3\63\3\63\3\64\3\64\3\65\3\65\3\65\7\65\u02c0\n\65\f\65\16\65\u02c3\13"+
		"\65\3\66\3\66\3\67\3\67\3\67\3\67\3\67\5\67\u02cc\n\67\3\67\5\67\u02cf"+
		"\n\67\38\38\39\39\39\79\u02d6\n9\f9\169\u02d9\139\3:\3:\3:\3:\3;\3;\3"+
		";\5;\u02e2\n;\3<\3<\3<\3<\7<\u02e8\n<\f<\16<\u02eb\13<\5<\u02ed\n<\3<"+
		"\5<\u02f0\n<\3<\3<\3=\3=\3=\3=\3=\3>\3>\7>\u02fb\n>\f>\16>\u02fe\13>\3"+
		">\3>\3?\7?\u0303\n?\f?\16?\u0306\13?\3?\3?\5?\u030a\n?\3@\3@\3@\3@\3@"+
		"\3@\5@\u0312\n@\3@\3@\5@\u0316\n@\3@\3@\5@\u031a\n@\3@\3@\5@\u031e\n@"+
		"\5@\u0320\n@\3A\3A\5A\u0324\nA\3B\3B\3B\3B\5B\u032a\nB\3C\3C\3D\3D\3D"+
		"\3E\3E\3E\3E\3F\7F\u0336\nF\fF\16F\u0339\13F\3G\3G\3G\3G\5G\u033f\nG\3"+
		"H\3H\3H\7H\u0344\nH\fH\16H\u0347\13H\3H\3H\7H\u034b\nH\fH\16H\u034e\13"+
		"H\3H\3H\3H\3H\3H\3H\7H\u0356\nH\fH\16H\u0359\13H\3H\5H\u035c\nH\3I\3I"+
		"\3I\3I\3I\3I\3I\3I\3I\5I\u0367\nI\3J\3J\3J\3K\3K\7K\u036e\nK\fK\16K\u0371"+
		"\13K\3K\5K\u0374\nK\3K\3K\3L\3L\3L\3L\3L\5L\u037d\nL\3L\3L\3L\3L\3L\3"+
		"L\3L\5L\u0386\nL\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3"+
		"L\3L\6L\u039b\nL\rL\16L\u039c\3L\5L\u03a0\nL\3L\5L\u03a3\nL\3L\3L\3L\3"+
		"L\7L\u03a9\nL\fL\16L\u03ac\13L\3L\5L\u03af\nL\3L\3L\3L\3L\7L\u03b5\nL"+
		"\fL\16L\u03b8\13L\3L\7L\u03bb\nL\fL\16L\u03be\13L\3L\3L\3L\3L\3L\3L\3"+
		"L\3L\5L\u03c8\nL\3L\3L\3L\3L\3L\3L\3L\5L\u03d1\nL\3L\3L\3L\5L\u03d6\n"+
		"L\3L\3L\3L\3L\3L\3L\3L\3L\5L\u03e0\nL\3M\3M\3M\7M\u03e5\nM\fM\16M\u03e8"+
		"\13M\3M\3M\3M\3M\3M\3N\3N\3N\7N\u03f2\nN\fN\16N\u03f5\13N\3O\3O\3O\3P"+
		"\3P\3P\5P\u03fd\nP\3P\3P\3Q\3Q\3Q\7Q\u0404\nQ\fQ\16Q\u0407\13Q\3R\7R\u040a"+
		"\nR\fR\16R\u040d\13R\3R\3R\3R\3R\3R\3S\6S\u0415\nS\rS\16S\u0416\3S\6S"+
		"\u041a\nS\rS\16S\u041b\3T\3T\3T\3T\3T\3T\3T\3T\3T\3T\5T\u0428\nT\3U\3"+
		"U\5U\u042c\nU\3U\3U\5U\u0430\nU\3U\3U\5U\u0434\nU\5U\u0436\nU\3V\3V\5"+
		"V\u043a\nV\3W\5W\u043d\nW\3W\3W\3W\3W\3X\3X\3Y\3Y\3Y\3Y\3Z\3Z\3Z\7Z\u044c"+
		"\nZ\fZ\16Z\u044f\13Z\3[\3[\3\\\3\\\3]\3]\3]\3]\3]\5]\u045a\n]\3]\3]\3"+
		"]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\5]\u046b\n]\3]\3]\3]\3]\3]\5]\u0472"+
		"\n]\3]\3]\5]\u0476\n]\3]\3]\3]\3]\5]\u047c\n]\3]\3]\3]\3]\3]\3]\5]\u0484"+
		"\n]\3]\3]\3]\3]\3]\3]\3]\5]\u048d\n]\3]\3]\3]\3]\3]\3]\3]\3]\5]\u0497"+
		"\n]\3]\3]\3]\3]\3]\3]\5]\u049f\n]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]"+
		"\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\5]\u04c0\n]"+
		"\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\5]\u04d1\n]\3]\3]\3]\3]"+
		"\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\5]\u04ea\n]"+
		"\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\5]\u04f6\n]\3]\3]\3]\3]\3]\3]\7]\u04fe"+
		"\n]\f]\16]\u0501\13]\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3"+
		"^\3^\3^\5^\u0516\n^\5^\u0518\n^\3_\3_\3_\3_\3_\3_\3_\5_\u0521\n_\5_\u0523"+
		"\n_\3`\3`\5`\u0527\n`\3`\3`\3`\5`\u052c\n`\7`\u052e\n`\f`\16`\u0531\13"+
		"`\3`\5`\u0534\n`\3a\3a\5a\u0538\na\3a\3a\3b\3b\3b\3b\7b\u0540\nb\fb\16"+
		"b\u0543\13b\3b\3b\3b\3b\3b\3b\3b\7b\u054c\nb\fb\16b\u054f\13b\3b\3b\7"+
		"b\u0553\nb\fb\16b\u0556\13b\5b\u0558\nb\3c\3c\5c\u055c\nc\3d\3d\3d\3e"+
		"\3e\3e\3e\3f\3f\3f\5f\u0568\nf\3g\3g\3g\5g\u056d\ng\3h\3h\3h\3h\5h\u0573"+
		"\nh\5h\u0575\nh\3i\3i\3i\3i\5i\u057b\ni\3j\3j\5j\u057f\nj\3j\3j\3k\3k"+
		"\3k\3k\5k\u0587\nk\3l\3l\3l\2\3\u00b8m\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080"+
		"\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098"+
		"\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0"+
		"\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8"+
		"\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\2\t\6\2,,88<<??\6\2\17\17 "+
		" /\61\64\65\3\2\3\4\3\2\5\6\n\2\21\21\23\23\26\26\34\34\"\"))++\63\63"+
		"\4\2\37\37\66\66\3\2AF\u0619\2\u00d9\3\2\2\2\4\u00ec\3\2\2\2\6\u00f3\3"+
		"\2\2\2\b\u011b\3\2\2\2\n\u011f\3\2\2\2\f\u0123\3\2\2\2\16\u0127\3\2\2"+
		"\2\20\u0129\3\2\2\2\22\u0138\3\2\2\2\24\u0143\3\2\2\2\26\u0148\3\2\2\2"+
		"\30\u0150\3\2\2\2\32\u0162\3\2\2\2\34\u016d\3\2\2\2\36\u0177\3\2\2\2 "+
		"\u017e\3\2\2\2\"\u0189\3\2\2\2$\u0191\3\2\2\2&\u019a\3\2\2\2(\u01af\3"+
		"\2\2\2*\u01bd\3\2\2\2,\u01c1\3\2\2\2.\u01d4\3\2\2\2\60\u01d7\3\2\2\2\62"+
		"\u01df\3\2\2\2\64\u01e3\3\2\2\2\66\u01f0\3\2\2\28\u01f9\3\2\2\2:\u01fb"+
		"\3\2\2\2<\u0206\3\2\2\2>\u0213\3\2\2\2@\u0224\3\2\2\2B\u0227\3\2\2\2D"+
		"\u022f\3\2\2\2F\u0234\3\2\2\2H\u023e\3\2\2\2J\u0240\3\2\2\2L\u0250\3\2"+
		"\2\2N\u0260\3\2\2\2P\u0262\3\2\2\2R\u0270\3\2\2\2T\u0273\3\2\2\2V\u0275"+
		"\3\2\2\2X\u0286\3\2\2\2Z\u0288\3\2\2\2\\\u0290\3\2\2\2^\u02a3\3\2\2\2"+
		"`\u02a8\3\2\2\2b\u02b1\3\2\2\2d\u02b8\3\2\2\2f\u02ba\3\2\2\2h\u02bc\3"+
		"\2\2\2j\u02c4\3\2\2\2l\u02c6\3\2\2\2n\u02d0\3\2\2\2p\u02d2\3\2\2\2r\u02da"+
		"\3\2\2\2t\u02e1\3\2\2\2v\u02e3\3\2\2\2x\u02f3\3\2\2\2z\u02f8\3\2\2\2|"+
		"\u0309\3\2\2\2~\u031f\3\2\2\2\u0080\u0323\3\2\2\2\u0082\u0325\3\2\2\2"+
		"\u0084\u032b\3\2\2\2\u0086\u032d\3\2\2\2\u0088\u0330\3\2\2\2\u008a\u0337"+
		"\3\2\2\2\u008c\u033e\3\2\2\2\u008e\u035b\3\2\2\2\u0090\u0366\3\2\2\2\u0092"+
		"\u0368\3\2\2\2\u0094\u036b\3\2\2\2\u0096\u03df\3\2\2\2\u0098\u03e1\3\2"+
		"\2\2\u009a\u03ee\3\2\2\2\u009c\u03f6\3\2\2\2\u009e\u03f9\3\2\2\2\u00a0"+
		"\u0400\3\2\2\2\u00a2\u040b\3\2\2\2\u00a4\u0414\3\2\2\2\u00a6\u0427\3\2"+
		"\2\2\u00a8\u0435\3\2\2\2\u00aa\u0439\3\2\2\2\u00ac\u043c\3\2\2\2\u00ae"+
		"\u0442\3\2\2\2\u00b0\u0444\3\2\2\2\u00b2\u0448\3\2\2\2\u00b4\u0450\3\2"+
		"\2\2\u00b6\u0452\3\2\2\2\u00b8\u0475\3\2\2\2\u00ba\u0517\3\2\2\2\u00bc"+
		"\u0522\3\2\2\2\u00be\u0533\3\2\2\2\u00c0\u0535\3\2\2\2\u00c2\u053b\3\2"+
		"\2\2\u00c4\u0559\3\2\2\2\u00c6\u055d\3\2\2\2\u00c8\u0560\3\2\2\2\u00ca"+
		"\u0567\3\2\2\2\u00cc\u056c\3\2\2\2\u00ce\u0574\3\2\2\2\u00d0\u057a\3\2"+
		"\2\2\u00d2\u057c\3\2\2\2\u00d4\u0586\3\2\2\2\u00d6\u0588\3\2\2\2\u00d8"+
		"\u00da\5\4\3\2\u00d9\u00d8\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00de\3\2"+
		"\2\2\u00db\u00dd\5\6\4\2\u00dc\u00db\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de"+
		"\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e4\3\2\2\2\u00e0\u00de\3\2"+
		"\2\2\u00e1\u00e3\5\b\5\2\u00e2\u00e1\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4"+
		"\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00e4\3\2"+
		"\2\2\u00e7\u00e8\7\2\2\3\u00e8\3\3\2\2\2\u00e9\u00eb\5l\67\2\u00ea\u00e9"+
		"\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed"+
		"\u00ef\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f0\7.\2\2\u00f0\u00f1\5h\65"+
		"\2\u00f1\u00f2\7M\2\2\u00f2\5\3\2\2\2\u00f3\u00f5\7\'\2\2\u00f4\u00f6"+
		"\7\64\2\2\u00f5\u00f4\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\3\2\2\2"+
		"\u00f7\u00fa\5h\65\2\u00f8\u00f9\7O\2\2\u00f9\u00fb\7b\2\2\u00fa\u00f8"+
		"\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\7M\2\2\u00fd"+
		"\7\3\2\2\2\u00fe\u0100\5\f\7\2\u00ff\u00fe\3\2\2\2\u0100\u0103\3\2\2\2"+
		"\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0104\3\2\2\2\u0103\u0101"+
		"\3\2\2\2\u0104\u011c\5\20\t\2\u0105\u0107\5\f\7\2\u0106\u0105\3\2\2\2"+
		"\u0107\u010a\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010b"+
		"\3\2\2\2\u010a\u0108\3\2\2\2\u010b\u011c\5\30\r\2\u010c\u010e\5\f\7\2"+
		"\u010d\u010c\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110"+
		"\3\2\2\2\u0110\u0112\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u011c\5 \21\2\u0113"+
		"\u0115\5\f\7\2\u0114\u0113\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2"+
		"\2\2\u0116\u0117\3\2\2\2\u0117\u0119\3\2\2\2\u0118\u0116\3\2\2\2\u0119"+
		"\u011c\5x=\2\u011a\u011c\7M\2\2\u011b\u0101\3\2\2\2\u011b\u0108\3\2\2"+
		"\2\u011b\u010f\3\2\2\2\u011b\u0116\3\2\2\2\u011b\u011a\3\2\2\2\u011c\t"+
		"\3\2\2\2\u011d\u0120\5\f\7\2\u011e\u0120\t\2\2\2\u011f\u011d\3\2\2\2\u011f"+
		"\u011e\3\2\2\2\u0120\13\3\2\2\2\u0121\u0124\5l\67\2\u0122\u0124\t\3\2"+
		"\2\u0123\u0121\3\2\2\2\u0123\u0122\3\2\2\2\u0124\r\3\2\2\2\u0125\u0128"+
		"\7 \2\2\u0126\u0128\5l\67\2\u0127\u0125\3\2\2\2\u0127\u0126\3\2\2\2\u0128"+
		"\17\3\2\2\2\u0129\u012a\7\27\2\2\u012a\u012c\7s\2\2\u012b\u012d\5\22\n"+
		"\2\u012c\u012b\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012f"+
		"\7\37\2\2\u012f\u0131\5N(\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131"+
		"\u0134\3\2\2\2\u0132\u0133\7&\2\2\u0133\u0135\5\"\22\2\u0134\u0132\3\2"+
		"\2\2\u0134\u0135\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0137\5$\23\2\u0137"+
		"\21\3\2\2\2\u0138\u0139\7S\2\2\u0139\u013e\5\24\13\2\u013a\u013b\7N\2"+
		"\2\u013b\u013d\5\24\13\2\u013c\u013a\3\2\2\2\u013d\u0140\3\2\2\2\u013e"+
		"\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0141\3\2\2\2\u0140\u013e\3\2"+
		"\2\2\u0141\u0142\7R\2\2\u0142\23\3\2\2\2\u0143\u0146\7s\2\2\u0144\u0145"+
		"\7\37\2\2\u0145\u0147\5\26\f\2\u0146\u0144\3\2\2\2\u0146\u0147\3\2\2\2"+
		"\u0147\25\3\2\2\2\u0148\u014d\5N(\2\u0149\u014a\7d\2\2\u014a\u014c\5N"+
		"(\2\u014b\u0149\3\2\2\2\u014c\u014f\3\2\2\2\u014d\u014b\3\2\2\2\u014d"+
		"\u014e\3\2\2\2\u014e\27\3\2\2\2\u014f\u014d\3\2\2\2\u0150\u0151\7\36\2"+
		"\2\u0151\u0154\7s\2\2\u0152\u0153\7&\2\2\u0153\u0155\5\"\22\2\u0154\u0152"+
		"\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0158\7I\2\2\u0157"+
		"\u0159\5\32\16\2\u0158\u0157\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015b\3"+
		"\2\2\2\u015a\u015c\7N\2\2\u015b\u015a\3\2\2\2\u015b\u015c\3\2\2\2\u015c"+
		"\u015e\3\2\2\2\u015d\u015f\5\36\20\2\u015e\u015d\3\2\2\2\u015e\u015f\3"+
		"\2\2\2\u015f\u0160\3\2\2\2\u0160\u0161\7J\2\2\u0161\31\3\2\2\2\u0162\u0167"+
		"\5\34\17\2\u0163\u0164\7N\2\2\u0164\u0166\5\34\17\2\u0165\u0163\3\2\2"+
		"\2\u0166\u0169\3\2\2\2\u0167\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168\33"+
		"\3\2\2\2\u0169\u0167\3\2\2\2\u016a\u016c\5l\67\2\u016b\u016a\3\2\2\2\u016c"+
		"\u016f\3\2\2\2\u016d\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u0170\3\2"+
		"\2\2\u016f\u016d\3\2\2\2\u0170\u0172\7s\2\2\u0171\u0173\5\u00d2j\2\u0172"+
		"\u0171\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0175\3\2\2\2\u0174\u0176\5$"+
		"\23\2\u0175\u0174\3\2\2\2\u0175\u0176\3\2\2\2\u0176\35\3\2\2\2\u0177\u017b"+
		"\7M\2\2\u0178\u017a\5(\25\2\u0179\u0178\3\2\2\2\u017a\u017d\3\2\2\2\u017b"+
		"\u0179\3\2\2\2\u017b\u017c\3\2\2\2\u017c\37\3\2\2\2\u017d\u017b\3\2\2"+
		"\2\u017e\u017f\7*\2\2\u017f\u0181\7s\2\2\u0180\u0182\5\22\n\2\u0181\u0180"+
		"\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0185\3\2\2\2\u0183\u0184\7\37\2\2"+
		"\u0184\u0186\5\"\22\2\u0185\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0187"+
		"\3\2\2\2\u0187\u0188\5&\24\2\u0188!\3\2\2\2\u0189\u018e\5N(\2\u018a\u018b"+
		"\7N\2\2\u018b\u018d\5N(\2\u018c\u018a\3\2\2\2\u018d\u0190\3\2\2\2\u018e"+
		"\u018c\3\2\2\2\u018e\u018f\3\2\2\2\u018f#\3\2\2\2\u0190\u018e\3\2\2\2"+
		"\u0191\u0195\7I\2\2\u0192\u0194\5(\25\2\u0193\u0192\3\2\2\2\u0194\u0197"+
		"\3\2\2\2\u0195\u0193\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0198\3\2\2\2\u0197"+
		"\u0195\3\2\2\2\u0198\u0199\7J\2\2\u0199%\3\2\2\2\u019a\u019e\7I\2\2\u019b"+
		"\u019d\5\66\34\2\u019c\u019b\3\2\2\2\u019d\u01a0\3\2\2\2\u019e\u019c\3"+
		"\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a1\3\2\2\2\u01a0\u019e\3\2\2\2\u01a1"+
		"\u01a2\7J\2\2\u01a2\'\3\2\2\2\u01a3\u01b0\7M\2\2\u01a4\u01a6\7\64\2\2"+
		"\u01a5\u01a4\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01b0"+
		"\5\u0088E\2\u01a8\u01aa\5\n\6\2\u01a9\u01a8\3\2\2\2\u01aa\u01ad\3\2\2"+
		"\2\u01ab\u01a9\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01ae\3\2\2\2\u01ad\u01ab"+
		"\3\2\2\2\u01ae\u01b0\5*\26\2\u01af\u01a3\3\2\2\2\u01af\u01a5\3\2\2\2\u01af"+
		"\u01ab\3\2\2\2\u01b0)\3\2\2\2\u01b1\u01b2\t\4\2\2\u01b2\u01be\5,\27\2"+
		"\u01b3\u01b4\t\4\2\2\u01b4\u01be\5.\30\2\u01b5\u01b6\t\5\2\2\u01b6\u01be"+
		"\5\64\33\2\u01b7\u01be\5\60\31\2\u01b8\u01be\5\62\32\2\u01b9\u01be\5 "+
		"\21\2\u01ba\u01be\5x=\2\u01bb\u01be\5\20\t\2\u01bc\u01be\5\30\r\2\u01bd"+
		"\u01b1\3\2\2\2\u01bd\u01b3\3\2\2\2\u01bd\u01b5\3\2\2\2\u01bd\u01b7\3\2"+
		"\2\2\u01bd\u01b8\3\2\2\2\u01bd\u01b9\3\2\2\2\u01bd\u01ba\3\2\2\2\u01bd"+
		"\u01bb\3\2\2\2\u01bd\u01bc\3\2\2\2\u01be+\3\2\2\2\u01bf\u01c2\5N(\2\u01c0"+
		"\u01c2\7>\2\2\u01c1\u01bf\3\2\2\2\u01c1\u01c0\3\2\2\2\u01c2\u01c3\3\2"+
		"\2\2\u01c3\u01c4\7s\2\2\u01c4\u01c9\5\\/\2\u01c5\u01c6\7K\2\2\u01c6\u01c8"+
		"\7L\2\2\u01c7\u01c5\3\2\2\2\u01c8\u01cb\3\2\2\2\u01c9\u01c7\3\2\2\2\u01c9"+
		"\u01ca\3\2\2\2\u01ca\u01ce\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cc\u01cd\7;"+
		"\2\2\u01cd\u01cf\5Z.\2\u01ce\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d2"+
		"\3\2\2\2\u01d0\u01d3\5d\63\2\u01d1\u01d3\7M\2\2\u01d2\u01d0\3\2\2\2\u01d2"+
		"\u01d1\3\2\2\2\u01d3-\3\2\2\2\u01d4\u01d5\5\22\n\2\u01d5\u01d6\5,\27\2"+
		"\u01d6/\3\2\2\2\u01d7\u01d8\7s\2\2\u01d8\u01db\5\\/\2\u01d9\u01da\7;\2"+
		"\2\u01da\u01dc\5Z.\2\u01db\u01d9\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01dd"+
		"\3\2\2\2\u01dd\u01de\5f\64\2\u01de\61\3\2\2\2\u01df\u01e0\5\22\n\2\u01e0"+
		"\u01e1\5\60\31\2\u01e1\63\3\2\2\2\u01e2\u01e4\5N(\2\u01e3\u01e2\3\2\2"+
		"\2\u01e3\u01e4\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e6\5B\"\2\u01e6\u01e7"+
		"\7M\2\2\u01e7\65\3\2\2\2\u01e8\u01ea\5\n\6\2\u01e9\u01e8\3\2\2\2\u01ea"+
		"\u01ed\3\2\2\2\u01eb\u01e9\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01ee\3\2"+
		"\2\2\u01ed\u01eb\3\2\2\2\u01ee\u01f1\58\35\2\u01ef\u01f1\7M\2\2\u01f0"+
		"\u01eb\3\2\2\2\u01f0\u01ef\3\2\2\2\u01f1\67\3\2\2\2\u01f2\u01fa\5:\36"+
		"\2\u01f3\u01fa\5> \2\u01f4\u01fa\5@!\2\u01f5\u01fa\5 \21\2\u01f6\u01fa"+
		"\5x=\2\u01f7\u01fa\5\20\t\2\u01f8\u01fa\5\30\r\2\u01f9\u01f2\3\2\2\2\u01f9"+
		"\u01f3\3\2\2\2\u01f9\u01f4\3\2\2\2\u01f9\u01f5\3\2\2\2\u01f9\u01f6\3\2"+
		"\2\2\u01f9\u01f7\3\2\2\2\u01f9\u01f8\3\2\2\2\u01fa9\3\2\2\2\u01fb\u01fc"+
		"\5N(\2\u01fc\u0201\5<\37\2\u01fd\u01fe\7N\2\2\u01fe\u0200\5<\37\2\u01ff"+
		"\u01fd\3\2\2\2\u0200\u0203\3\2\2\2\u0201\u01ff\3\2\2\2\u0201\u0202\3\2"+
		"\2\2\u0202\u0204\3\2\2\2\u0203\u0201\3\2\2\2\u0204\u0205\7M\2\2\u0205"+
		";\3\2\2\2\u0206\u020b\7s\2\2\u0207\u0208\7K\2\2\u0208\u020a\7L\2\2\u0209"+
		"\u0207\3\2\2\2\u020a\u020d\3\2\2\2\u020b\u0209\3\2\2\2\u020b\u020c\3\2"+
		"\2\2\u020c\u020e\3\2\2\2\u020d\u020b\3\2\2\2\u020e\u020f\7Q\2\2\u020f"+
		"\u0210\5H%\2\u0210=\3\2\2\2\u0211\u0214\5N(\2\u0212\u0214\7>\2\2\u0213"+
		"\u0211\3\2\2\2\u0213\u0212\3\2\2\2\u0214\u0215\3\2\2\2\u0215\u0216\7s"+
		"\2\2\u0216\u021b\5\\/\2\u0217\u0218\7K\2\2\u0218\u021a\7L\2\2\u0219\u0217"+
		"\3\2\2\2\u021a\u021d\3\2\2\2\u021b\u0219\3\2\2\2\u021b\u021c\3\2\2\2\u021c"+
		"\u0220\3\2\2\2\u021d\u021b\3\2\2\2\u021e\u021f\7;\2\2\u021f\u0221\5Z."+
		"\2\u0220\u021e\3\2\2\2\u0220\u0221\3\2\2\2\u0221\u0222\3\2\2\2\u0222\u0223"+
		"\7M\2\2\u0223?\3\2\2\2\u0224\u0225\5\22\n\2\u0225\u0226\5> \2\u0226A\3"+
		"\2\2\2\u0227\u022c\5D#\2\u0228\u0229\7N\2\2\u0229\u022b\5D#\2\u022a\u0228"+
		"\3\2\2\2\u022b\u022e\3\2\2\2\u022c\u022a\3\2\2\2\u022c\u022d\3\2\2\2\u022d"+
		"C\3\2\2\2\u022e\u022c\3\2\2\2\u022f\u0232\5F$\2\u0230\u0231\7Q\2\2\u0231"+
		"\u0233\5H%\2\u0232\u0230\3\2\2\2\u0232\u0233\3\2\2\2\u0233E\3\2\2\2\u0234"+
		"\u0239\7s\2\2\u0235\u0236\7K\2\2\u0236\u0238\7L\2\2\u0237\u0235\3\2\2"+
		"\2\u0238\u023b\3\2\2\2\u0239\u0237\3\2\2\2\u0239\u023a\3\2\2\2\u023aG"+
		"\3\2\2\2\u023b\u0239\3\2\2\2\u023c\u023f\5J&\2\u023d\u023f\5\u00b8]\2"+
		"\u023e\u023c\3\2\2\2\u023e\u023d\3\2\2\2\u023fI\3\2\2\2\u0240\u024c\7"+
		"I\2\2\u0241\u0246\5H%\2\u0242\u0243\7N\2\2\u0243\u0245\5H%\2\u0244\u0242"+
		"\3\2\2\2\u0245\u0248\3\2\2\2\u0246\u0244\3\2\2\2\u0246\u0247\3\2\2\2\u0247"+
		"\u024a\3\2\2\2\u0248\u0246\3\2\2\2\u0249\u024b\7N\2\2\u024a\u0249\3\2"+
		"\2\2\u024a\u024b\3\2\2\2\u024b\u024d\3\2\2\2\u024c\u0241\3\2\2\2\u024c"+
		"\u024d\3\2\2\2\u024d\u024e\3\2\2\2\u024e\u024f\7J\2\2\u024fK\3\2\2\2\u0250"+
		"\u0251\7s\2\2\u0251M\3\2\2\2\u0252\u0256\5P)\2\u0253\u0255\5R*\2\u0254"+
		"\u0253\3\2\2\2\u0255\u0258\3\2\2\2\u0256\u0254\3\2\2\2\u0256\u0257\3\2"+
		"\2\2\u0257\u0261\3\2\2\2\u0258\u0256\3\2\2\2\u0259\u025d\5T+\2\u025a\u025c"+
		"\5R*\2\u025b\u025a\3\2\2\2\u025c\u025f\3\2\2\2\u025d\u025b\3\2\2\2\u025d"+
		"\u025e\3\2\2\2\u025e\u0261\3\2\2\2\u025f\u025d\3\2\2\2\u0260\u0252\3\2"+
		"\2\2\u0260\u0259\3\2\2\2\u0261O\3\2\2\2\u0262\u0264\7s\2\2\u0263\u0265"+
		"\5V,\2\u0264\u0263\3\2\2\2\u0264\u0265\3\2\2\2\u0265\u026d\3\2\2\2\u0266"+
		"\u0267\7O\2\2\u0267\u0269\7s\2\2\u0268\u026a\5V,\2\u0269\u0268\3\2\2\2"+
		"\u0269\u026a\3\2\2\2\u026a\u026c\3\2\2\2\u026b\u0266\3\2\2\2\u026c\u026f"+
		"\3\2\2\2\u026d\u026b\3\2\2\2\u026d\u026e\3\2\2\2\u026eQ\3\2\2\2\u026f"+
		"\u026d\3\2\2\2\u0270\u0271\7K\2\2\u0271\u0272\7L\2\2\u0272S\3\2\2\2\u0273"+
		"\u0274\t\6\2\2\u0274U\3\2\2\2\u0275\u0276\7S\2\2\u0276\u027b\5X-\2\u0277"+
		"\u0278\7N\2\2\u0278\u027a\5X-\2\u0279\u0277\3\2\2\2\u027a\u027d\3\2\2"+
		"\2\u027b\u0279\3\2\2\2\u027b\u027c\3\2\2\2\u027c\u027e\3\2\2\2\u027d\u027b"+
		"\3\2\2\2\u027e\u027f\7R\2\2\u027fW\3\2\2\2\u0280\u0287\5N(\2\u0281\u0284"+
		"\7V\2\2\u0282\u0283\t\7\2\2\u0283\u0285\5N(\2\u0284\u0282\3\2\2\2\u0284"+
		"\u0285\3\2\2\2\u0285\u0287\3\2\2\2\u0286\u0280\3\2\2\2\u0286\u0281\3\2"+
		"\2\2\u0287Y\3\2\2\2\u0288\u028d\5h\65\2\u0289\u028a\7N\2\2\u028a\u028c"+
		"\5h\65\2\u028b\u0289\3\2\2\2\u028c\u028f\3\2\2\2\u028d\u028b\3\2\2\2\u028d"+
		"\u028e\3\2\2\2\u028e[\3\2\2\2\u028f\u028d\3\2\2\2\u0290\u0292\7G\2\2\u0291"+
		"\u0293\5^\60\2\u0292\u0291\3\2\2\2\u0292\u0293\3\2\2\2\u0293\u0294\3\2"+
		"\2\2\u0294\u0295\7H\2\2\u0295]\3\2\2\2\u0296\u029b\5`\61\2\u0297\u0298"+
		"\7N\2\2\u0298\u029a\5`\61\2\u0299\u0297\3\2\2\2\u029a\u029d\3\2\2\2\u029b"+
		"\u0299\3\2\2\2\u029b\u029c\3\2\2\2\u029c\u02a0\3\2\2\2\u029d\u029b\3\2"+
		"\2\2\u029e\u029f\7N\2\2\u029f\u02a1\5b\62\2\u02a0\u029e\3\2\2\2\u02a0"+
		"\u02a1\3\2\2\2\u02a1\u02a4\3\2\2\2\u02a2\u02a4\5b\62\2\u02a3\u0296\3\2"+
		"\2\2\u02a3\u02a2\3\2\2\2\u02a4_\3\2\2\2\u02a5\u02a7\5\16\b\2\u02a6\u02a5"+
		"\3\2\2\2\u02a7\u02aa\3\2\2\2\u02a8\u02a6\3\2\2\2\u02a8\u02a9\3\2\2\2\u02a9"+
		"\u02ab\3\2\2\2\u02aa\u02a8\3\2\2\2\u02ab\u02ac\5N(\2\u02ac\u02ad\5F$\2"+
		"\u02ada\3\2\2\2\u02ae\u02b0\5\16\b\2\u02af\u02ae\3\2\2\2\u02b0\u02b3\3"+
		"\2\2\2\u02b1\u02af\3\2\2\2\u02b1\u02b2\3\2\2\2\u02b2\u02b4\3\2\2\2\u02b3"+
		"\u02b1\3\2\2\2\u02b4\u02b5\5N(\2\u02b5\u02b6\7u\2\2\u02b6\u02b7\5F$\2"+
		"\u02b7c\3\2\2\2\u02b8\u02b9\5\u0088E\2\u02b9e\3\2\2\2\u02ba\u02bb\5\u0088"+
		"E\2\u02bbg\3\2\2\2\u02bc\u02c1\7s\2\2\u02bd\u02be\7O\2\2\u02be\u02c0\7"+
		"s\2\2\u02bf\u02bd\3\2\2\2\u02c0\u02c3\3\2\2\2\u02c1\u02bf\3\2\2\2\u02c1"+
		"\u02c2\3\2\2\2\u02c2i\3\2\2\2\u02c3\u02c1\3\2\2\2\u02c4\u02c5\t\b\2\2"+
		"\u02c5k\3\2\2\2\u02c6\u02c7\7t\2\2\u02c7\u02ce\5n8\2\u02c8\u02cb\7G\2"+
		"\2\u02c9\u02cc\5p9\2\u02ca\u02cc\5t;\2\u02cb\u02c9\3\2\2\2\u02cb\u02ca"+
		"\3\2\2\2\u02cb\u02cc\3\2\2\2\u02cc\u02cd\3\2\2\2\u02cd\u02cf\7H\2\2\u02ce"+
		"\u02c8\3\2\2\2\u02ce\u02cf\3\2\2\2\u02cfm\3\2\2\2\u02d0\u02d1\5h\65\2"+
		"\u02d1o\3\2\2\2\u02d2\u02d7\5r:\2\u02d3\u02d4\7N\2\2\u02d4\u02d6\5r:\2"+
		"\u02d5\u02d3\3\2\2\2\u02d6\u02d9\3\2\2\2\u02d7\u02d5\3\2\2\2\u02d7\u02d8"+
		"\3\2\2\2\u02d8q\3\2\2\2\u02d9\u02d7\3\2\2\2\u02da\u02db\7s\2\2\u02db\u02dc"+
		"\7Q\2\2\u02dc\u02dd\5t;\2\u02dds\3\2\2\2\u02de\u02e2\5\u00b8]\2\u02df"+
		"\u02e2\5l\67\2\u02e0\u02e2\5v<\2\u02e1\u02de\3\2\2\2\u02e1\u02df\3\2\2"+
		"\2\u02e1\u02e0\3\2\2\2\u02e2u\3\2\2\2\u02e3\u02ec\7I\2\2\u02e4\u02e9\5"+
		"t;\2\u02e5\u02e6\7N\2\2\u02e6\u02e8\5t;\2\u02e7\u02e5\3\2\2\2\u02e8\u02eb"+
		"\3\2\2\2\u02e9\u02e7\3\2\2\2\u02e9\u02ea\3\2\2\2\u02ea\u02ed\3\2\2\2\u02eb"+
		"\u02e9\3\2\2\2\u02ec\u02e4\3\2\2\2\u02ec\u02ed\3\2\2\2\u02ed\u02ef\3\2"+
		"\2\2\u02ee\u02f0\7N\2\2\u02ef\u02ee\3\2\2\2\u02ef\u02f0\3\2\2\2\u02f0"+
		"\u02f1\3\2\2\2\u02f1\u02f2\7J\2\2\u02f2w\3\2\2\2\u02f3\u02f4\7t\2\2\u02f4"+
		"\u02f5\7*\2\2\u02f5\u02f6\7s\2\2\u02f6\u02f7\5z>\2\u02f7y\3\2\2\2\u02f8"+
		"\u02fc\7I\2\2\u02f9\u02fb\5|?\2\u02fa\u02f9\3\2\2\2\u02fb\u02fe\3\2\2"+
		"\2\u02fc\u02fa\3\2\2\2\u02fc\u02fd\3\2\2\2\u02fd\u02ff\3\2\2\2\u02fe\u02fc"+
		"\3\2\2\2\u02ff\u0300\7J\2\2\u0300{\3\2\2\2\u0301\u0303\5\n\6\2\u0302\u0301"+
		"\3\2\2\2\u0303\u0306\3\2\2\2\u0304\u0302\3\2\2\2\u0304\u0305\3\2\2\2\u0305"+
		"\u0307\3\2\2\2\u0306\u0304\3\2\2\2\u0307\u030a\5~@\2\u0308\u030a\7M\2"+
		"\2\u0309\u0304\3\2\2\2\u0309\u0308\3\2\2\2\u030a}\3\2\2\2\u030b\u030c"+
		"\5N(\2\u030c\u030d\5\u0080A\2\u030d\u030e\7M\2\2\u030e\u0320\3\2\2\2\u030f"+
		"\u0311\5\20\t\2\u0310\u0312\7M\2\2\u0311\u0310\3\2\2\2\u0311\u0312\3\2"+
		"\2\2\u0312\u0320\3\2\2\2\u0313\u0315\5 \21\2\u0314\u0316\7M\2\2\u0315"+
		"\u0314\3\2\2\2\u0315\u0316\3\2\2\2\u0316\u0320\3\2\2\2\u0317\u0319\5\30"+
		"\r\2\u0318\u031a\7M\2\2\u0319\u0318\3\2\2\2\u0319\u031a\3\2\2\2\u031a"+
		"\u0320\3\2\2\2\u031b\u031d\5x=\2\u031c\u031e\7M\2\2\u031d\u031c\3\2\2"+
		"\2\u031d\u031e\3\2\2\2\u031e\u0320\3\2\2\2\u031f\u030b\3\2\2\2\u031f\u030f"+
		"\3\2\2\2\u031f\u0313\3\2\2\2\u031f\u0317\3\2\2\2\u031f\u031b\3\2\2\2\u0320"+
		"\177\3\2\2\2\u0321\u0324\5\u0082B\2\u0322\u0324\5\u0084C\2\u0323\u0321"+
		"\3\2\2\2\u0323\u0322\3\2\2\2\u0324\u0081\3\2\2\2\u0325\u0326\7s\2\2\u0326"+
		"\u0327\7G\2\2\u0327\u0329\7H\2\2\u0328\u032a\5\u0086D\2\u0329\u0328\3"+
		"\2\2\2\u0329\u032a\3\2\2\2\u032a\u0083\3\2\2\2\u032b\u032c\5B\"\2\u032c"+
		"\u0085\3\2\2\2\u032d\u032e\7\32\2\2\u032e\u032f\5t;\2\u032f\u0087\3\2"+
		"\2\2\u0330\u0331\7I\2\2\u0331\u0332\5\u008aF\2\u0332\u0333\7J\2\2\u0333"+
		"\u0089\3\2\2\2\u0334\u0336\5\u008cG\2\u0335\u0334\3\2\2\2\u0336\u0339"+
		"\3\2\2\2\u0337\u0335\3\2\2\2\u0337\u0338\3\2\2\2\u0338\u008b\3\2\2\2\u0339"+
		"\u0337\3\2\2\2\u033a\u033f\5\u0092J\2\u033b\u033f\5\u0096L\2\u033c\u033f"+
		"\5\b\5\2\u033d\u033f\5\u008eH\2\u033e\u033a\3\2\2\2\u033e\u033b\3\2\2"+
		"\2\u033e\u033c\3\2\2\2\u033e\u033d\3\2\2\2\u033f\u008d\3\2\2\2\u0340\u0341"+
		"\7S\2\2\u0341\u0345\7s\2\2\u0342\u0344\5\u0090I\2\u0343\u0342\3\2\2\2"+
		"\u0344\u0347\3\2\2\2\u0345\u0343\3\2\2\2\u0345\u0346\3\2\2\2\u0346\u0348"+
		"\3\2\2\2\u0347\u0345\3\2\2\2\u0348\u034c\7R\2\2\u0349\u034b\5\u008cG\2"+
		"\u034a\u0349\3\2\2\2\u034b\u034e\3\2\2\2\u034c\u034a\3\2\2\2\u034c\u034d"+
		"\3\2\2\2\u034d\u034f\3\2\2\2\u034e\u034c\3\2\2\2\u034f\u0350\7\7\2\2\u0350"+
		"\u0351\7s\2\2\u0351\u035c\7R\2\2\u0352\u0353\7S\2\2\u0353\u0357\7s\2\2"+
		"\u0354\u0356\5\u0090I\2\u0355\u0354\3\2\2\2\u0356\u0359\3\2\2\2\u0357"+
		"\u0355\3\2\2\2\u0357\u0358\3\2\2\2\u0358\u035a\3\2\2\2\u0359\u0357\3\2"+
		"\2\2\u035a\u035c\7\b\2\2\u035b\u0340\3\2\2\2\u035b\u0352\3\2\2\2\u035c"+
		"\u008f\3\2\2\2\u035d\u035e\7s\2\2\u035e\u035f\7Q\2\2\u035f\u0367\7E\2"+
		"\2\u0360\u0361\7s\2\2\u0361\u0362\7Q\2\2\u0362\u0363\7I\2\2\u0363\u0364"+
		"\5\u00b8]\2\u0364\u0365\7J\2\2\u0365\u0367\3\2\2\2\u0366\u035d\3\2\2\2"+
		"\u0366\u0360\3\2\2\2\u0367\u0091\3\2\2\2\u0368\u0369\5\u0094K\2\u0369"+
		"\u036a\5\u00d4k\2\u036a\u0093\3\2\2\2\u036b\u036f\t\5\2\2\u036c\u036e"+
		"\5\16\b\2\u036d\u036c\3\2\2\2\u036e\u0371\3\2\2\2\u036f\u036d\3\2\2\2"+
		"\u036f\u0370\3\2\2\2\u0370\u0373\3\2\2\2\u0371\u036f\3\2\2\2\u0372\u0374"+
		"\5N(\2\u0373\u0372\3\2\2\2\u0373\u0374\3\2\2\2\u0374\u0375\3\2\2\2\u0375"+
		"\u0376\5D#\2\u0376\u0095\3\2\2\2\u0377\u03e0\5\u0088E\2\u0378\u0379\7"+
		"\20\2\2\u0379\u037c\5\u00b8]\2\u037a\u037b\7W\2\2\u037b\u037d\5\u00b8"+
		"]\2\u037c\u037a\3\2\2\2\u037c\u037d\3\2\2\2\u037d\u037e\3\2\2\2\u037e"+
		"\u037f\5\u00d4k\2\u037f\u03e0\3\2\2\2\u0380\u0381\7$\2\2\u0381\u0382\5"+
		"\u00b0Y\2\u0382\u0385\5\u0096L\2\u0383\u0384\7\35\2\2\u0384\u0386\5\u0096"+
		"L\2\u0385\u0383\3\2\2\2\u0385\u0386\3\2\2\2\u0386\u03e0\3\2\2\2\u0387"+
		"\u0388\7#\2\2\u0388\u0389\7G\2\2\u0389\u038a\5\u00a8U\2\u038a\u038b\7"+
		"H\2\2\u038b\u038c\5\u0096L\2\u038c\u03e0\3\2\2\2\u038d\u038e\7@\2\2\u038e"+
		"\u038f\5\u00b0Y\2\u038f\u0390\5\u0096L\2\u0390\u03e0\3\2\2\2\u0391\u0392"+
		"\7\33\2\2\u0392\u0393\5\u0096L\2\u0393\u0394\7@\2\2\u0394\u0395\5\u00b0"+
		"Y\2\u0395\u0396\5\u00d4k\2\u0396\u03e0\3\2\2\2\u0397\u0398\7=\2\2\u0398"+
		"\u03a2\5\u0088E\2\u0399\u039b\5\u0098M\2\u039a\u0399\3\2\2\2\u039b\u039c"+
		"\3\2\2\2\u039c\u039a\3\2\2\2\u039c\u039d\3\2\2\2\u039d\u039f\3\2\2\2\u039e"+
		"\u03a0\5\u009cO\2\u039f\u039e\3\2\2\2\u039f\u03a0\3\2\2\2\u03a0\u03a3"+
		"\3\2\2\2\u03a1\u03a3\5\u009cO\2\u03a2\u039a\3\2\2\2\u03a2\u03a1\3\2\2"+
		"\2\u03a3\u03e0\3\2\2\2\u03a4\u03a5\7=\2\2\u03a5\u03a6\5\u009eP\2\u03a6"+
		"\u03aa\5\u0088E\2\u03a7\u03a9\5\u0098M\2\u03a8\u03a7\3\2\2\2\u03a9\u03ac"+
		"\3\2\2\2\u03aa\u03a8\3\2\2\2\u03aa\u03ab\3\2\2\2\u03ab\u03ae\3\2\2\2\u03ac"+
		"\u03aa\3\2\2\2\u03ad\u03af\5\u009cO\2\u03ae\u03ad\3\2\2\2\u03ae\u03af"+
		"\3\2\2\2\u03af\u03e0\3\2\2\2\u03b0\u03b1\7\67\2\2\u03b1\u03b2\5\u00b0"+
		"Y\2\u03b2\u03b6\7I\2\2\u03b3\u03b5\5\u00a4S\2\u03b4\u03b3\3\2\2\2\u03b5"+
		"\u03b8\3\2\2\2\u03b6\u03b4\3\2\2\2\u03b6\u03b7\3\2\2\2\u03b7\u03bc\3\2"+
		"\2\2\u03b8\u03b6\3\2\2\2\u03b9\u03bb\5\u00a6T\2\u03ba\u03b9\3\2\2\2\u03bb"+
		"\u03be\3\2\2\2\u03bc\u03ba\3\2\2\2\u03bc\u03bd\3\2\2\2\u03bd\u03bf\3\2"+
		"\2\2\u03be\u03bc\3\2\2\2\u03bf\u03c0\7J\2\2\u03c0\u03e0\3\2\2\2\u03c1"+
		"\u03c2\78\2\2\u03c2\u03c3\5\u00b0Y\2\u03c3\u03c4\5\u0088E\2\u03c4\u03e0"+
		"\3\2\2\2\u03c5\u03c7\7\62\2\2\u03c6\u03c8\5\u00b8]\2\u03c7\u03c6\3\2\2"+
		"\2\u03c7\u03c8\3\2\2\2\u03c8\u03c9\3\2\2\2\u03c9\u03e0\5\u00d4k\2\u03ca"+
		"\u03cb\7:\2\2\u03cb\u03cc\5\u00b8]\2\u03cc\u03cd\5\u00d4k\2\u03cd\u03e0"+
		"\3\2\2\2\u03ce\u03d0\7\22\2\2\u03cf\u03d1\7s\2\2\u03d0\u03cf\3\2\2\2\u03d0"+
		"\u03d1\3\2\2\2\u03d1\u03d2\3\2\2\2\u03d2\u03e0\5\u00d4k\2\u03d3\u03d5"+
		"\7\31\2\2\u03d4\u03d6\7s\2\2\u03d5\u03d4\3\2\2\2\u03d5\u03d6\3\2\2\2\u03d6"+
		"\u03d7\3\2\2\2\u03d7\u03e0\5\u00d4k\2\u03d8\u03e0\7M\2\2\u03d9\u03da\5"+
		"\u00b4[\2\u03da\u03db\5\u00d4k\2\u03db\u03e0\3\2\2\2\u03dc\u03dd\7s\2"+
		"\2\u03dd\u03de\7W\2\2\u03de\u03e0\5\u0096L\2\u03df\u0377\3\2\2\2\u03df"+
		"\u0378\3\2\2\2\u03df\u0380\3\2\2\2\u03df\u0387\3\2\2\2\u03df\u038d\3\2"+
		"\2\2\u03df\u0391\3\2\2\2\u03df\u0397\3\2\2\2\u03df\u03a4\3\2\2\2\u03df"+
		"\u03b0\3\2\2\2\u03df\u03c1\3\2\2\2\u03df\u03c5\3\2\2\2\u03df\u03ca\3\2"+
		"\2\2\u03df\u03ce\3\2\2\2\u03df\u03d3\3\2\2\2\u03df\u03d8\3\2\2\2\u03df"+
		"\u03d9\3\2\2\2\u03df\u03dc\3\2\2\2\u03e0\u0097\3\2\2\2\u03e1\u03e2\7\25"+
		"\2\2\u03e2\u03e6\7G\2\2\u03e3\u03e5\5\16\b\2\u03e4\u03e3\3\2\2\2\u03e5"+
		"\u03e8\3\2\2\2\u03e6\u03e4\3\2\2\2\u03e6\u03e7\3\2\2\2\u03e7\u03e9\3\2"+
		"\2\2\u03e8\u03e6\3\2\2\2\u03e9\u03ea\5\u009aN\2\u03ea\u03eb\7s\2\2\u03eb"+
		"\u03ec\7H\2\2\u03ec\u03ed\5\u0088E\2\u03ed\u0099\3\2\2\2\u03ee\u03f3\5"+
		"h\65\2\u03ef\u03f0\7e\2\2\u03f0\u03f2\5h\65\2\u03f1\u03ef\3\2\2\2\u03f2"+
		"\u03f5\3\2\2\2\u03f3\u03f1\3\2\2\2\u03f3\u03f4\3\2\2\2\u03f4\u009b\3\2"+
		"\2\2\u03f5\u03f3\3\2\2\2\u03f6\u03f7\7!\2\2\u03f7\u03f8\5\u0088E\2\u03f8"+
		"\u009d\3\2\2\2\u03f9\u03fa\7G\2\2\u03fa\u03fc\5\u00a0Q\2\u03fb\u03fd\7"+
		"M\2\2\u03fc\u03fb\3\2\2\2\u03fc\u03fd\3\2\2\2\u03fd\u03fe\3\2\2\2\u03fe"+
		"\u03ff\7H\2\2\u03ff\u009f\3\2\2\2\u0400\u0405\5\u00a2R\2\u0401\u0402\7"+
		"M\2\2\u0402\u0404\5\u00a2R\2\u0403\u0401\3\2\2\2\u0404\u0407\3\2\2\2\u0405"+
		"\u0403\3\2\2\2\u0405\u0406\3\2\2\2\u0406\u00a1\3\2\2\2\u0407\u0405\3\2"+
		"\2\2\u0408\u040a\5\16\b\2\u0409\u0408\3\2\2\2\u040a\u040d\3\2\2\2\u040b"+
		"\u0409\3\2\2\2\u040b\u040c\3\2\2\2\u040c\u040e\3\2\2\2\u040d\u040b\3\2"+
		"\2\2\u040e\u040f\5P)\2\u040f\u0410\5F$\2\u0410\u0411\7Q\2\2\u0411\u0412"+
		"\5\u00b8]\2\u0412\u00a3\3\2\2\2\u0413\u0415\5\u00a6T\2\u0414\u0413\3\2"+
		"\2\2\u0415\u0416\3\2\2\2\u0416\u0414\3\2\2\2\u0416\u0417\3\2\2\2\u0417"+
		"\u0419\3\2\2\2\u0418\u041a\5\u008cG\2\u0419\u0418\3\2\2\2\u041a\u041b"+
		"\3\2\2\2\u041b\u0419\3\2\2\2\u041b\u041c\3\2\2\2\u041c\u00a5\3\2\2\2\u041d"+
		"\u041e\7\24\2\2\u041e\u041f\5\u00b6\\\2\u041f\u0420\7W\2\2\u0420\u0428"+
		"\3\2\2\2\u0421\u0422\7\24\2\2\u0422\u0423\5L\'\2\u0423\u0424\7W\2\2\u0424"+
		"\u0428\3\2\2\2\u0425\u0426\7\32\2\2\u0426\u0428\7W\2\2\u0427\u041d\3\2"+
		"\2\2\u0427\u0421\3\2\2\2\u0427\u0425\3\2\2\2\u0428\u00a7\3\2\2\2\u0429"+
		"\u0436\5\u00acW\2\u042a\u042c\5\u00aaV\2\u042b\u042a\3\2\2\2\u042b\u042c"+
		"\3\2\2\2\u042c\u042d\3\2\2\2\u042d\u042f\7M\2\2\u042e\u0430\5\u00b8]\2"+
		"\u042f\u042e\3\2\2\2\u042f\u0430\3\2\2\2\u0430\u0431\3\2\2\2\u0431\u0433"+
		"\7M\2\2\u0432\u0434\5\u00aeX\2\u0433\u0432\3\2\2\2\u0433\u0434\3\2\2\2"+
		"\u0434\u0436\3\2\2\2\u0435\u0429\3\2\2\2\u0435\u042b\3\2\2\2\u0436\u00a9"+
		"\3\2\2\2\u0437\u043a\5\u0094K\2\u0438\u043a\5\u00b2Z\2\u0439\u0437\3\2"+
		"\2\2\u0439\u0438\3\2\2\2\u043a\u00ab\3\2\2\2\u043b\u043d\5N(\2\u043c\u043b"+
		"\3\2\2\2\u043c\u043d\3\2\2\2\u043d\u043e\3\2\2\2\u043e\u043f\5F$\2\u043f"+
		"\u0440\7W\2\2\u0440\u0441\5\u00b8]\2\u0441\u00ad\3\2\2\2\u0442\u0443\5"+
		"\u00b2Z\2\u0443\u00af\3\2\2\2\u0444\u0445\7G\2\2\u0445\u0446\5\u00b8]"+
		"\2\u0446\u0447\7H\2\2\u0447\u00b1\3\2\2\2\u0448\u044d\5\u00b8]\2\u0449"+
		"\u044a\7N\2\2\u044a\u044c\5\u00b8]\2\u044b\u0449\3\2\2\2\u044c\u044f\3"+
		"\2\2\2\u044d\u044b\3\2\2\2\u044d\u044e\3\2\2\2\u044e\u00b3\3\2\2\2\u044f"+
		"\u044d\3\2\2\2\u0450\u0451\5\u00b8]\2\u0451\u00b5\3\2\2\2\u0452\u0453"+
		"\5\u00b8]\2\u0453\u00b7\3\2\2\2\u0454\u0459\b]\1\2\u0455\u045a\7`\2\2"+
		"\u0456\u045a\7a\2\2\u0457\u045a\7^\2\2\u0458\u045a\7_\2\2\u0459\u0455"+
		"\3\2\2\2\u0459\u0456\3\2\2\2\u0459\u0457\3\2\2\2\u0459\u0458\3\2\2\2\u045a"+
		"\u045b\3\2\2\2\u045b\u045c\5\u00b8]\16\u045c\u045d\b]\1\2\u045d\u0476"+
		"\3\2\2\2\u045e\u045f\7T\2\2\u045f\u0460\5\u00b8]\r\u0460\u0461\b]\1\2"+
		"\u0461\u0476\3\2\2\2\u0462\u0476\5\u00ba^\2\u0463\u0464\7-\2\2\u0464\u0465"+
		"\5\u00bc_\2\u0465\u0466\b]\1\2\u0466\u0476\3\2\2\2\u0467\u0468\7\r\2\2"+
		"\u0468\u046a\7G\2\2\u0469\u046b\5\u00b2Z\2\u046a\u0469\3\2\2\2\u046a\u046b"+
		"\3\2\2\2\u046b\u046c\3\2\2\2\u046c\u046d\7H\2\2\u046d\u0476\b]\1\2\u046e"+
		"\u046f\7\16\2\2\u046f\u0471\7G\2\2\u0470\u0472\5\u00b2Z\2\u0471\u0470"+
		"\3\2\2\2\u0471\u0472\3\2\2\2\u0472\u0473\3\2\2\2\u0473\u0474\7H\2\2\u0474"+
		"\u0476\b]\1\2\u0475\u0454\3\2\2\2\u0475\u045e\3\2\2\2\u0475\u0462\3\2"+
		"\2\2\u0475\u0463\3\2\2\2\u0475\u0467\3\2\2\2\u0475\u046e\3\2\2\2\u0476"+
		"\u04ff\3\2\2\2\u0477\u047b\f\f\2\2\u0478\u047c\7b\2\2\u0479\u047c\7c\2"+
		"\2\u047a\u047c\7g\2\2\u047b\u0478\3\2\2\2\u047b\u0479\3\2\2\2\u047b\u047a"+
		"\3\2\2\2\u047c\u047d\3\2\2\2\u047d\u047e\5\u00b8]\r\u047e\u047f\b]\1\2"+
		"\u047f\u04fe\3\2\2\2\u0480\u0483\f\13\2\2\u0481\u0484\7`\2\2\u0482\u0484"+
		"\7a\2\2\u0483\u0481\3\2\2\2\u0483\u0482\3\2\2\2\u0484\u0485\3\2\2\2\u0485"+
		"\u0486\5\u00b8]\f\u0486\u0487\b]\1\2\u0487\u04fe\3\2\2\2\u0488\u048c\f"+
		"\n\2\2\u0489\u048d\7\n\2\2\u048a\u048d\7\13\2\2\u048b\u048d\7\f\2\2\u048c"+
		"\u0489\3\2\2\2\u048c\u048a\3\2\2\2\u048c\u048b\3\2\2\2\u048d\u048e\3\2"+
		"\2\2\u048e\u048f\5\u00b8]\13\u048f\u0490\b]\1\2\u0490\u04fe\3\2\2\2\u0491"+
		"\u0496\f\t\2\2\u0492\u0497\7Y\2\2\u0493\u0497\7Z\2\2\u0494\u0497\7R\2"+
		"\2\u0495\u0497\7S\2\2\u0496\u0492\3\2\2\2\u0496\u0493\3\2\2\2\u0496\u0494"+
		"\3\2\2\2\u0496\u0495\3\2\2\2\u0497\u0498\3\2\2\2\u0498\u0499\5\u00b8]"+
		"\n\u0499\u049a\b]\1\2\u049a\u04fe\3\2\2\2\u049b\u049e\f\7\2\2\u049c\u049f"+
		"\7X\2\2\u049d\u049f\7[\2\2\u049e\u049c\3\2\2\2\u049e\u049d\3\2\2\2\u049f"+
		"\u04a0\3\2\2\2\u04a0\u04a1\5\u00b8]\b\u04a1\u04a2\b]\1\2\u04a2\u04fe\3"+
		"\2\2\2\u04a3\u04a4\f\6\2\2\u04a4\u04a5\7\\\2\2\u04a5\u04a6\5\u00b8]\7"+
		"\u04a6\u04a7\b]\1\2\u04a7\u04fe\3\2\2\2\u04a8\u04a9\f\5\2\2\u04a9\u04aa"+
		"\7]\2\2\u04aa\u04ab\5\u00b8]\6\u04ab\u04ac\b]\1\2\u04ac\u04fe\3\2\2\2"+
		"\u04ad\u04ae\f\4\2\2\u04ae\u04af\7P\2\2\u04af\u04b0\5\u00b8]\5\u04b0\u04b1"+
		"\b]\1\2\u04b1\u04fe\3\2\2\2\u04b2\u04bf\f\3\2\2\u04b3\u04c0\7Q\2\2\u04b4"+
		"\u04c0\7h\2\2\u04b5\u04c0\7i\2\2\u04b6\u04c0\7j\2\2\u04b7\u04c0\7k\2\2"+
		"\u04b8\u04c0\7l\2\2\u04b9\u04c0\7m\2\2\u04ba\u04c0\7n\2\2\u04bb\u04c0"+
		"\7q\2\2\u04bc\u04c0\7r\2\2\u04bd\u04c0\7p\2\2\u04be\u04c0\7o\2\2\u04bf"+
		"\u04b3\3\2\2\2\u04bf\u04b4\3\2\2\2\u04bf\u04b5\3\2\2\2\u04bf\u04b6\3\2"+
		"\2\2\u04bf\u04b7\3\2\2\2\u04bf\u04b8\3\2\2\2\u04bf\u04b9\3\2\2\2\u04bf"+
		"\u04ba\3\2\2\2\u04bf\u04bb\3\2\2\2\u04bf\u04bc\3\2\2\2\u04bf\u04bd\3\2"+
		"\2\2\u04bf\u04be\3\2\2\2\u04c0\u04c1\3\2\2\2\u04c1\u04c2\5\u00b8]\3\u04c2"+
		"\u04c3\b]\1\2\u04c3\u04fe\3\2\2\2\u04c4\u04c5\f\32\2\2\u04c5\u04c6\7O"+
		"\2\2\u04c6\u04c7\7s\2\2\u04c7\u04fe\b]\1\2\u04c8\u04c9\f\31\2\2\u04c9"+
		"\u04ca\7O\2\2\u04ca\u04cb\79\2\2\u04cb\u04fe\b]\1\2\u04cc\u04cd\f\30\2"+
		"\2\u04cd\u04ce\7O\2\2\u04ce\u04d0\7-\2\2\u04cf\u04d1\5\u00c8e\2\u04d0"+
		"\u04cf\3\2\2\2\u04d0\u04d1\3\2\2\2\u04d1\u04d2\3\2\2\2\u04d2\u04d3\5\u00c0"+
		"a\2\u04d3\u04d4\b]\1\2\u04d4\u04fe\3\2\2\2\u04d5\u04d6\f\27\2\2\u04d6"+
		"\u04d7\7O\2\2\u04d7\u04d8\7\66\2\2\u04d8\u04d9\5\u00ceh\2\u04d9\u04da"+
		"\b]\1\2\u04da\u04fe\3\2\2\2\u04db\u04dc\f\26\2\2\u04dc\u04dd\7O\2\2\u04dd"+
		"\u04de\5\u00c6d\2\u04de\u04df\b]\1\2\u04df\u04fe\3\2\2\2\u04e0\u04e1\f"+
		"\25\2\2\u04e1\u04e2\7K\2\2\u04e2\u04e3\5\u00b8]\2\u04e3\u04e4\7L\2\2\u04e4"+
		"\u04e5\b]\1\2\u04e5\u04fe\3\2\2\2\u04e6\u04e7\f\24\2\2\u04e7\u04e9\7G"+
		"\2\2\u04e8\u04ea\5\u00b2Z\2\u04e9\u04e8\3\2\2\2\u04e9\u04ea\3\2\2\2\u04ea"+
		"\u04eb\3\2\2\2\u04eb\u04ec\7H\2\2\u04ec\u04fe\b]\1\2\u04ed\u04ee\f\20"+
		"\2\2\u04ee\u04ef\7\t\2\2\u04ef\u04f0\5N(\2\u04f0\u04f1\b]\1\2\u04f1\u04fe"+
		"\3\2\2\2\u04f2\u04f5\f\17\2\2\u04f3\u04f6\7^\2\2\u04f4\u04f6\7_\2\2\u04f5"+
		"\u04f3\3\2\2\2\u04f5\u04f4\3\2\2\2\u04f6\u04f7\3\2\2\2\u04f7\u04fe\b]"+
		"\1\2\u04f8\u04f9\f\b\2\2\u04f9\u04fa\7(\2\2\u04fa\u04fb\5N(\2\u04fb\u04fc"+
		"\b]\1\2\u04fc\u04fe\3\2\2\2\u04fd\u0477\3\2\2\2\u04fd\u0480\3\2\2\2\u04fd"+
		"\u0488\3\2\2\2\u04fd\u0491\3\2\2\2\u04fd\u049b\3\2\2\2\u04fd\u04a3\3\2"+
		"\2\2\u04fd\u04a8\3\2\2\2\u04fd\u04ad\3\2\2\2\u04fd\u04b2\3\2\2\2\u04fd"+
		"\u04c4\3\2\2\2\u04fd\u04c8\3\2\2\2\u04fd\u04cc\3\2\2\2\u04fd\u04d5\3\2"+
		"\2\2\u04fd\u04db\3\2\2\2\u04fd\u04e0\3\2\2\2\u04fd\u04e6\3\2\2\2\u04fd"+
		"\u04ed\3\2\2\2\u04fd\u04f2\3\2\2\2\u04fd\u04f8\3\2\2\2\u04fe\u0501\3\2"+
		"\2\2\u04ff\u04fd\3\2\2\2\u04ff\u0500\3\2\2\2\u0500\u00b9\3\2\2\2\u0501"+
		"\u04ff\3\2\2\2\u0502\u0503\7G\2\2\u0503\u0504\5\u00b8]\2\u0504\u0505\7"+
		"H\2\2\u0505\u0518\3\2\2\2\u0506\u0518\79\2\2\u0507\u0518\7\66\2\2\u0508"+
		"\u0518\5j\66\2\u0509\u0518\7s\2\2\u050a\u050b\5N(\2\u050b\u050c\7O\2\2"+
		"\u050c\u050d\7\27\2\2\u050d\u0518\3\2\2\2\u050e\u050f\7>\2\2\u050f\u0510"+
		"\7O\2\2\u0510\u0518\7\27\2\2\u0511\u0515\5\u00c8e\2\u0512\u0516\5\u00d0"+
		"i\2\u0513\u0514\79\2\2\u0514\u0516\5\u00d2j\2\u0515\u0512\3\2\2\2\u0515"+
		"\u0513\3\2\2\2\u0516\u0518\3\2\2\2\u0517\u0502\3\2\2\2\u0517\u0506\3\2"+
		"\2\2\u0517\u0507\3\2\2\2\u0517\u0508\3\2\2\2\u0517\u0509\3\2\2\2\u0517"+
		"\u050a\3\2\2\2\u0517\u050e\3\2\2\2\u0517\u0511\3\2\2\2\u0518\u00bb\3\2"+
		"\2\2\u0519\u051a\5\u00c8e\2\u051a\u051b\5\u00be`\2\u051b\u051c\5\u00c4"+
		"c\2\u051c\u0523\3\2\2\2\u051d\u0520\5\u00be`\2\u051e\u0521\5\u00c2b\2"+
		"\u051f\u0521\5\u00c4c\2\u0520\u051e\3\2\2\2\u0520\u051f\3\2\2\2\u0521"+
		"\u0523\3\2\2\2\u0522\u0519\3\2\2\2\u0522\u051d\3\2\2\2\u0523\u00bd\3\2"+
		"\2\2\u0524\u0526\7s\2\2\u0525\u0527\5\u00caf\2\u0526\u0525\3\2\2\2\u0526"+
		"\u0527\3\2\2\2\u0527\u052f\3\2\2\2\u0528\u0529\7O\2\2\u0529\u052b\7s\2"+
		"\2\u052a\u052c\5\u00caf\2\u052b\u052a\3\2\2\2\u052b\u052c\3\2\2\2\u052c"+
		"\u052e\3\2\2\2\u052d\u0528\3\2\2\2\u052e\u0531\3\2\2\2\u052f\u052d\3\2"+
		"\2\2\u052f\u0530\3\2\2\2\u0530\u0534\3\2\2\2\u0531\u052f\3\2\2\2\u0532"+
		"\u0534\5T+\2\u0533\u0524\3\2\2\2\u0533\u0532\3\2\2\2\u0534\u00bf\3\2\2"+
		"\2\u0535\u0537\7s\2\2\u0536\u0538\5\u00ccg\2\u0537\u0536\3\2\2\2\u0537"+
		"\u0538\3\2\2\2\u0538\u0539\3\2\2\2\u0539\u053a\5\u00c4c\2\u053a\u00c1"+
		"\3\2\2\2\u053b\u0557\7K\2\2\u053c\u0541\7L\2\2\u053d\u053e\7K\2\2\u053e"+
		"\u0540\7L\2\2\u053f\u053d\3\2\2\2\u0540\u0543\3\2\2\2\u0541\u053f\3\2"+
		"\2\2\u0541\u0542\3\2\2\2\u0542\u0544\3\2\2\2\u0543\u0541\3\2\2\2\u0544"+
		"\u0558\5J&\2\u0545\u0546\5\u00b8]\2\u0546\u054d\7L\2\2\u0547\u0548\7K"+
		"\2\2\u0548\u0549\5\u00b8]\2\u0549\u054a\7L\2\2\u054a\u054c\3\2\2\2\u054b"+
		"\u0547\3\2\2\2\u054c\u054f\3\2\2\2\u054d\u054b\3\2\2\2\u054d\u054e\3\2"+
		"\2\2\u054e\u0554\3\2\2\2\u054f\u054d\3\2\2\2\u0550\u0551\7K\2\2\u0551"+
		"\u0553\7L\2\2\u0552\u0550\3\2\2\2\u0553\u0556\3\2\2\2\u0554\u0552\3\2"+
		"\2\2\u0554\u0555\3\2\2\2\u0555\u0558\3\2\2\2\u0556\u0554\3\2\2\2\u0557"+
		"\u053c\3\2\2\2\u0557\u0545\3\2\2\2\u0558\u00c3\3\2\2\2\u0559\u055b\5\u00d2"+
		"j\2\u055a\u055c\5$\23\2\u055b\u055a\3\2\2\2\u055b\u055c\3\2\2\2\u055c"+
		"\u00c5\3\2\2\2\u055d\u055e\5\u00c8e\2\u055e\u055f\5\u00d0i\2\u055f\u00c7"+
		"\3\2\2\2\u0560\u0561\7S\2\2\u0561\u0562\5\"\22\2\u0562\u0563\7R\2\2\u0563"+
		"\u00c9\3\2\2\2\u0564\u0565\7S\2\2\u0565\u0568\7R\2\2\u0566\u0568\5V,\2"+
		"\u0567\u0564\3\2\2\2\u0567\u0566\3\2\2\2\u0568\u00cb\3\2\2\2\u0569\u056a"+
		"\7S\2\2\u056a\u056d\7R\2\2\u056b\u056d\5\u00c8e\2\u056c\u0569\3\2\2\2"+
		"\u056c\u056b\3\2\2\2\u056d\u00cd\3\2\2\2\u056e\u0575\5\u00d2j\2\u056f"+
		"\u0570\7O\2\2\u0570\u0572\7s\2\2\u0571\u0573\5\u00d2j\2\u0572\u0571\3"+
		"\2\2\2\u0572\u0573\3\2\2\2\u0573\u0575\3\2\2\2\u0574\u056e\3\2\2\2\u0574"+
		"\u056f\3\2\2\2\u0575\u00cf\3\2\2\2\u0576\u0577\7\66\2\2\u0577\u057b\5"+
		"\u00ceh\2\u0578\u0579\7s\2\2\u0579\u057b\5\u00d2j\2\u057a\u0576\3\2\2"+
		"\2\u057a\u0578\3\2\2\2\u057b\u00d1\3\2\2\2\u057c\u057e\7G\2\2\u057d\u057f"+
		"\5\u00b2Z\2\u057e\u057d\3\2\2\2\u057e\u057f\3\2\2\2\u057f\u0580\3\2\2"+
		"\2\u0580\u0581\7H\2\2\u0581\u00d3\3\2\2\2\u0582\u0587\7M\2\2\u0583\u0587"+
		"\7\2\2\3\u0584\u0587\6k\25\2\u0585\u0587\6k\26\2\u0586\u0582\3\2\2\2\u0586"+
		"\u0583\3\2\2\2\u0586\u0584\3\2\2\2\u0586\u0585\3\2\2\2\u0587\u00d5\3\2"+
		"\2\2\u0588\u0589\7\2\2\3\u0589\u00d7\3\2\2\2\u00a8\u00d9\u00de\u00e4\u00ec"+
		"\u00f5\u00fa\u0101\u0108\u010f\u0116\u011b\u011f\u0123\u0127\u012c\u0130"+
		"\u0134\u013e\u0146\u014d\u0154\u0158\u015b\u015e\u0167\u016d\u0172\u0175"+
		"\u017b\u0181\u0185\u018e\u0195\u019e\u01a5\u01ab\u01af\u01bd\u01c1\u01c9"+
		"\u01ce\u01d2\u01db\u01e3\u01eb\u01f0\u01f9\u0201\u020b\u0213\u021b\u0220"+
		"\u022c\u0232\u0239\u023e\u0246\u024a\u024c\u0256\u025d\u0260\u0264\u0269"+
		"\u026d\u027b\u0284\u0286\u028d\u0292\u029b\u02a0\u02a3\u02a8\u02b1\u02c1"+
		"\u02cb\u02ce\u02d7\u02e1\u02e9\u02ec\u02ef\u02fc\u0304\u0309\u0311\u0315"+
		"\u0319\u031d\u031f\u0323\u0329\u0337\u033e\u0345\u034c\u0357\u035b\u0366"+
		"\u036f\u0373\u037c\u0385\u039c\u039f\u03a2\u03aa\u03ae\u03b6\u03bc\u03c7"+
		"\u03d0\u03d5\u03df\u03e6\u03f3\u03fc\u0405\u040b\u0416\u041b\u0427\u042b"+
		"\u042f\u0433\u0435\u0439\u043c\u044d\u0459\u046a\u0471\u0475\u047b\u0483"+
		"\u048c\u0496\u049e\u04bf\u04d0\u04e9\u04f5\u04fd\u04ff\u0515\u0517\u0520"+
		"\u0522\u0526\u052b\u052f\u0533\u0537\u0541\u054d\u0554\u0557\u055b\u0567"+
		"\u056c\u0572\u0574\u057a\u057e\u0586";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}