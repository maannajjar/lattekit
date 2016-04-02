// Generated from /Users/maan/git/lattekit-android/lattekit-tools/transformer/src/main/antlr/io/lattekit/parser/Latte.g4 by ANTLR 4.5.1
package io.lattekit.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LatteLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "LAYOUT_CLASS", "LAYOUT_FUN", "LAYOUT_FUN_BLOCK", 
		"BRACE_OPEN", "BRACE_CLOSE", "PAREN_OPEN", "PAREN_CLOSE", "CHAR", "XML_TAG_OPEN", 
		"XML_TAG_CLOSE", "PACKAGE_DECLARATION", "IMPORT_STMT", "WS"
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


	public LatteLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Latte.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 22:
			return PACKAGE_DECLARATION_sempred((RuleContext)_localctx, predIndex);
		case 23:
			return IMPORT_STMT_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean PACKAGE_DECLARATION_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return getCharPositionInLine() == 0;
		}
		return true;
	}
	private boolean IMPORT_STMT_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return getCharPositionInLine() == 0;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\33\u014d\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3"+
		"\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16`\n\16"+
		"\3\16\6\16c\n\16\r\16\16\16d\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\5\16s\n\16\3\16\6\16v\n\16\r\16\16\16w\5\16z\n\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\6\16\u0083\n\16\r\16\16\16\u0084\3\16"+
		"\6\16\u0088\n\16\r\16\16\16\u0089\3\16\7\16\u008d\n\16\f\16\16\16\u0090"+
		"\13\16\3\16\3\16\7\16\u0094\n\16\f\16\16\16\u0097\13\16\3\16\6\16\u009a"+
		"\n\16\r\16\16\16\u009b\3\16\7\16\u009f\n\16\f\16\16\16\u00a2\13\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00ae\n\17\3\17\3\17"+
		"\3\17\3\17\3\17\6\17\u00b5\n\17\r\17\16\17\u00b6\3\17\6\17\u00ba\n\17"+
		"\r\17\16\17\u00bb\3\17\7\17\u00bf\n\17\f\17\16\17\u00c2\13\17\3\17\3\17"+
		"\7\17\u00c6\n\17\f\17\16\17\u00c9\13\17\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00da\n\20\3\20\3\20"+
		"\3\20\3\20\3\20\6\20\u00e1\n\20\r\20\16\20\u00e2\3\20\6\20\u00e6\n\20"+
		"\r\20\16\20\u00e7\3\20\7\20\u00eb\n\20\f\20\16\20\u00ee\13\20\3\20\3\20"+
		"\7\20\u00f2\n\20\f\20\16\20\u00f5\13\20\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\6\26\u0108\n\26"+
		"\r\26\16\26\u0109\3\27\3\27\3\27\3\27\6\27\u0110\n\27\r\27\16\27\u0111"+
		"\3\27\3\27\3\30\3\30\7\30\u0118\n\30\f\30\16\30\u011b\13\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\6\30\u0126\n\30\r\30\16\30\u0127\3"+
		"\30\6\30\u012b\n\30\r\30\16\30\u012c\3\31\3\31\7\31\u0131\n\31\f\31\16"+
		"\31\u0134\13\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\6\31\u013e\n\31"+
		"\r\31\16\31\u013f\3\31\6\31\u0143\n\31\r\31\16\31\u0144\3\32\6\32\u0148"+
		"\n\32\r\32\16\32\u0149\3\32\3\32\2\2\33\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30/\31\61\32\63\33\3\2\b\5\2..<=}}\4\2<=}}\4\2??}}\b\2\"\"$$\61\61>"+
		"@}}\177\177\6\2\f\f\17\17\"\"==\5\2\13\13\16\16\"\"\u016a\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\3\65\3\2\2\2\59\3\2\2\2\7;\3\2\2\2\t=\3\2\2\2\13?\3\2"+
		"\2\2\rB\3\2\2\2\17D\3\2\2\2\21F\3\2\2\2\23H\3\2\2\2\25J\3\2\2\2\27L\3"+
		"\2\2\2\31N\3\2\2\2\33_\3\2\2\2\35\u00ad\3\2\2\2\37\u00d9\3\2\2\2!\u00fb"+
		"\3\2\2\2#\u00fd\3\2\2\2%\u00ff\3\2\2\2\'\u0101\3\2\2\2)\u0103\3\2\2\2"+
		"+\u0105\3\2\2\2-\u010b\3\2\2\2/\u0115\3\2\2\2\61\u012e\3\2\2\2\63\u0147"+
		"\3\2\2\2\65\66\7$\2\2\66\67\7$\2\2\678\7$\2\28\4\3\2\2\29:\7&\2\2:\6\3"+
		"\2\2\2;<\7>\2\2<\b\3\2\2\2=>\7@\2\2>\n\3\2\2\2?@\7\61\2\2@A\7@\2\2A\f"+
		"\3\2\2\2BC\7\61\2\2C\16\3\2\2\2DE\7$\2\2E\20\3\2\2\2FG\7?\2\2G\22\3\2"+
		"\2\2HI\7)\2\2I\24\3\2\2\2JK\7B\2\2K\26\3\2\2\2LM\7<\2\2M\30\3\2\2\2NO"+
		"\7n\2\2OP\7z\2\2PQ\7o\2\2QR\7n\2\2R\32\3\2\2\2ST\7q\2\2TU\7r\2\2UV\7g"+
		"\2\2V`\7p\2\2WX\7c\2\2XY\7d\2\2YZ\7u\2\2Z[\7v\2\2[\\\7t\2\2\\]\7c\2\2"+
		"]^\7e\2\2^`\7v\2\2_S\3\2\2\2_W\3\2\2\2`b\3\2\2\2ac\5\63\32\2ba\3\2\2\2"+
		"cd\3\2\2\2db\3\2\2\2de\3\2\2\2ey\3\2\2\2fg\7c\2\2gh\7d\2\2hi\7u\2\2ij"+
		"\7v\2\2jk\7t\2\2kl\7c\2\2lm\7e\2\2ms\7v\2\2no\7q\2\2op\7r\2\2pq\7g\2\2"+
		"qs\7p\2\2rf\3\2\2\2rn\3\2\2\2su\3\2\2\2tv\5\63\32\2ut\3\2\2\2vw\3\2\2"+
		"\2wu\3\2\2\2wx\3\2\2\2xz\3\2\2\2yr\3\2\2\2yz\3\2\2\2z{\3\2\2\2{|\7e\2"+
		"\2|}\7n\2\2}~\7c\2\2~\177\7u\2\2\177\u0080\7u\2\2\u0080\u0082\3\2\2\2"+
		"\u0081\u0083\5\63\32\2\u0082\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0082"+
		"\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0087\3\2\2\2\u0086\u0088\n\2\2\2\u0087"+
		"\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2"+
		"\2\2\u008a\u008e\3\2\2\2\u008b\u008d\5\63\32\2\u008c\u008b\3\2\2\2\u008d"+
		"\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2"+
		"\2\2\u0090\u008e\3\2\2\2\u0091\u0095\7<\2\2\u0092\u0094\5\63\32\2\u0093"+
		"\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2"+
		"\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u009a\n\3\2\2\u0099"+
		"\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2"+
		"\2\2\u009c\u00a0\3\2\2\2\u009d\u009f\5\63\32\2\u009e\u009d\3\2\2\2\u009f"+
		"\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\34\3\2\2"+
		"\2\u00a2\u00a0\3\2\2\2\u00a3\u00a4\7q\2\2\u00a4\u00a5\7x\2\2\u00a5\u00a6"+
		"\7g\2\2\u00a6\u00a7\7t\2\2\u00a7\u00a8\7t\2\2\u00a8\u00a9\7k\2\2\u00a9"+
		"\u00aa\7f\2\2\u00aa\u00ab\7g\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\5\63"+
		"\32\2\u00ad\u00a3\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af"+
		"\u00b0\7h\2\2\u00b0\u00b1\7w\2\2\u00b1\u00b2\7p\2\2\u00b2\u00b4\3\2\2"+
		"\2\u00b3\u00b5\5\63\32\2\u00b4\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00ba\n\4"+
		"\2\2\u00b9\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb"+
		"\u00bc\3\2\2\2\u00bc\u00c0\3\2\2\2\u00bd\u00bf\5\63\32\2\u00be\u00bd\3"+
		"\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1"+
		"\u00c3\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c7\7?\2\2\u00c4\u00c6\5\63"+
		"\32\2\u00c5\u00c4\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7"+
		"\u00c8\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cb\7n"+
		"\2\2\u00cb\u00cc\7z\2\2\u00cc\u00cd\7o\2\2\u00cd\u00ce\7n\2\2\u00ce\36"+
		"\3\2\2\2\u00cf\u00d0\7q\2\2\u00d0\u00d1\7x\2\2\u00d1\u00d2\7g\2\2\u00d2"+
		"\u00d3\7t\2\2\u00d3\u00d4\7t\2\2\u00d4\u00d5\7k\2\2\u00d5\u00d6\7f\2\2"+
		"\u00d6\u00d7\7g\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00da\5\63\32\2\u00d9\u00cf"+
		"\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\7h\2\2\u00dc"+
		"\u00dd\7w\2\2\u00dd\u00de\7p\2\2\u00de\u00e0\3\2\2\2\u00df\u00e1\5\63"+
		"\32\2\u00e0\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2"+
		"\u00e3\3\2\2\2\u00e3\u00e5\3\2\2\2\u00e4\u00e6\n\4\2\2\u00e5\u00e4\3\2"+
		"\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8"+
		"\u00ec\3\2\2\2\u00e9\u00eb\5\63\32\2\u00ea\u00e9\3\2\2\2\u00eb\u00ee\3"+
		"\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ef\3\2\2\2\u00ee"+
		"\u00ec\3\2\2\2\u00ef\u00f3\7}\2\2\u00f0\u00f2\5\63\32\2\u00f1\u00f0\3"+
		"\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4"+
		"\u00f6\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6\u00f7\7n\2\2\u00f7\u00f8\7z\2"+
		"\2\u00f8\u00f9\7o\2\2\u00f9\u00fa\7n\2\2\u00fa \3\2\2\2\u00fb\u00fc\7"+
		"}\2\2\u00fc\"\3\2\2\2\u00fd\u00fe\7\177\2\2\u00fe$\3\2\2\2\u00ff\u0100"+
		"\7*\2\2\u0100&\3\2\2\2\u0101\u0102\7+\2\2\u0102(\3\2\2\2\u0103\u0104\n"+
		"\5\2\2\u0104*\3\2\2\2\u0105\u0107\7>\2\2\u0106\u0108\5)\25\2\u0107\u0106"+
		"\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a"+
		",\3\2\2\2\u010b\u010c\7>\2\2\u010c\u010d\7\61\2\2\u010d\u010f\3\2\2\2"+
		"\u010e\u0110\5)\25\2\u010f\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u010f"+
		"\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0114\7@\2\2\u0114"+
		".\3\2\2\2\u0115\u0119\6\30\2\2\u0116\u0118\5\63\32\2\u0117\u0116\3\2\2"+
		"\2\u0118\u011b\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011c"+
		"\3\2\2\2\u011b\u0119\3\2\2\2\u011c\u011d\7r\2\2\u011d\u011e\7c\2\2\u011e"+
		"\u011f\7e\2\2\u011f\u0120\7m\2\2\u0120\u0121\7c\2\2\u0121\u0122\7i\2\2"+
		"\u0122\u0123\7g\2\2\u0123\u0125\3\2\2\2\u0124\u0126\5\63\32\2\u0125\u0124"+
		"\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128"+
		"\u012a\3\2\2\2\u0129\u012b\n\6\2\2\u012a\u0129\3\2\2\2\u012b\u012c\3\2"+
		"\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d\60\3\2\2\2\u012e\u0132"+
		"\6\31\3\2\u012f\u0131\5\63\32\2\u0130\u012f\3\2\2\2\u0131\u0134\3\2\2"+
		"\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0135\3\2\2\2\u0134\u0132"+
		"\3\2\2\2\u0135\u0136\7k\2\2\u0136\u0137\7o\2\2\u0137\u0138\7r\2\2\u0138"+
		"\u0139\7q\2\2\u0139\u013a\7t\2\2\u013a\u013b\7v\2\2\u013b\u013d\3\2\2"+
		"\2\u013c\u013e\5\63\32\2\u013d\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f"+
		"\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0142\3\2\2\2\u0141\u0143\n\6"+
		"\2\2\u0142\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0142\3\2\2\2\u0144"+
		"\u0145\3\2\2\2\u0145\62\3\2\2\2\u0146\u0148\t\7\2\2\u0147\u0146\3\2\2"+
		"\2\u0148\u0149\3\2\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014b"+
		"\3\2\2\2\u014b\u014c\b\32\2\2\u014c\64\3\2\2\2!\2_drwy\u0084\u0089\u008e"+
		"\u0095\u009b\u00a0\u00ad\u00b6\u00bb\u00c0\u00c7\u00d9\u00e2\u00e7\u00ec"+
		"\u00f3\u0109\u0111\u0119\u0127\u012c\u0132\u013f\u0144\u0149\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}