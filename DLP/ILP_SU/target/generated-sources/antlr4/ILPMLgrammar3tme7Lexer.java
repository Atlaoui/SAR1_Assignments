// Generated from ILPMLgrammar3tme7.g4 by ANTLR 4.4

    package antlr4;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ILPMLgrammar3tme7Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__35=1, T__34=2, T__33=3, T__32=4, T__31=5, T__30=6, T__29=7, T__28=8, 
		T__27=9, T__26=10, T__25=11, T__24=12, T__23=13, T__22=14, T__21=15, T__20=16, 
		T__19=17, T__18=18, T__17=19, T__16=20, T__15=21, T__14=22, T__13=23, 
		T__12=24, T__11=25, T__10=26, T__9=27, T__8=28, T__7=29, T__6=30, T__5=31, 
		T__4=32, T__3=33, T__2=34, T__1=35, T__0=36, IDENT=37, INT=38, FLOAT=39, 
		STRING=40, ESC=41, LINE_COMMENT=42, COMMENT=43, SPACE=44;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'", "'''", 
		"'('", "')'", "'*'", "'+'", "','"
	};
	public static final String[] ruleNames = {
		"T__35", "T__34", "T__33", "T__32", "T__31", "T__30", "T__29", "T__28", 
		"T__27", "T__26", "T__25", "T__24", "T__23", "T__22", "T__21", "T__20", 
		"T__19", "T__18", "T__17", "T__16", "T__15", "T__14", "T__13", "T__12", 
		"T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", 
		"T__2", "T__1", "T__0", "IDENT", "INT", "FLOAT", "STRING", "ESC", "LINE_COMMENT", 
		"COMMENT", "SPACE"
	};


	public ILPMLgrammar3tme7Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ILPMLgrammar3tme7.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2.\u0125\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3"+
		"\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3"+
		"\33\3\34\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3"+
		"\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3"+
		"$\3$\3%\3%\3&\3&\7&\u00e0\n&\f&\16&\u00e3\13&\3\'\6\'\u00e6\n\'\r\'\16"+
		"\'\u00e7\3(\7(\u00eb\n(\f(\16(\u00ee\13(\3(\3(\7(\u00f2\n(\f(\16(\u00f5"+
		"\13(\3)\3)\3)\7)\u00fa\n)\f)\16)\u00fd\13)\3)\3)\3*\3*\3*\3+\3+\3+\3+"+
		"\7+\u0108\n+\f+\16+\u010b\13+\3+\3+\3,\3,\3,\3,\3,\3,\7,\u0115\n,\f,\16"+
		",\u0118\13,\3,\3,\3,\3,\3,\3-\6-\u0120\n-\r-\16-\u0121\3-\3-\2\2.\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.\3\2\13\5\2C\\aac|\6\2\62;C\\aac|\3\2\62;"+
		"\4\2$$^^\7\2$$^^ppttvv\4\2\f\f\17\17\3\2\61\61\3\2,,\5\2\13\f\17\17\""+
		"\"\u012e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\3[\3\2\2\2\5]\3\2\2\2\7c\3\2"+
		"\2\2\tk\3\2\2\2\13s\3\2\2\2\rx\3\2\2\2\17{\3\2\2\2\21\u0081\3\2\2\2\23"+
		"\u0083\3\2\2\2\25\u0085\3\2\2\2\27\u0088\3\2\2\2\31\u008a\3\2\2\2\33\u008e"+
		"\3\2\2\2\35\u0091\3\2\2\2\37\u0093\3\2\2\2!\u0096\3\2\2\2#\u0098\3\2\2"+
		"\2%\u009a\3\2\2\2\'\u009c\3\2\2\2)\u00a2\3\2\2\2+\u00a9\3\2\2\2-\u00ac"+
		"\3\2\2\2/\u00ae\3\2\2\2\61\u00b1\3\2\2\2\63\u00b3\3\2\2\2\65\u00b5\3\2"+
		"\2\2\67\u00b7\3\2\2\29\u00bb\3\2\2\2;\u00bd\3\2\2\2=\u00c2\3\2\2\2?\u00c5"+
		"\3\2\2\2A\u00ce\3\2\2\2C\u00d0\3\2\2\2E\u00d4\3\2\2\2G\u00d9\3\2\2\2I"+
		"\u00db\3\2\2\2K\u00dd\3\2\2\2M\u00e5\3\2\2\2O\u00ec\3\2\2\2Q\u00f6\3\2"+
		"\2\2S\u0100\3\2\2\2U\u0103\3\2\2\2W\u010e\3\2\2\2Y\u011f\3\2\2\2[\\\7"+
		"\61\2\2\\\4\3\2\2\2]^\7e\2\2^_\7c\2\2_`\7v\2\2`a\7e\2\2ab\7j\2\2b\6\3"+
		"\2\2\2cd\7e\2\2de\7q\2\2ef\7u\2\2fg\7v\2\2gh\7c\2\2hi\7t\2\2ij\7v\2\2"+
		"j\b\3\2\2\2kl\7h\2\2lm\7k\2\2mn\7p\2\2no\7c\2\2op\7n\2\2pq\7n\2\2qr\7"+
		"{\2\2r\n\3\2\2\2st\7v\2\2tu\7t\2\2uv\7w\2\2vw\7g\2\2w\f\3\2\2\2xy\7#\2"+
		"\2yz\7?\2\2z\16\3\2\2\2{|\7y\2\2|}\7j\2\2}~\7k\2\2~\177\7n\2\2\177\u0080"+
		"\7g\2\2\u0080\20\3\2\2\2\u0081\u0082\7=\2\2\u0082\22\3\2\2\2\u0083\u0084"+
		"\7?\2\2\u0084\24\3\2\2\2\u0085\u0086\7k\2\2\u0086\u0087\7h\2\2\u0087\26"+
		"\3\2\2\2\u0088\u0089\7`\2\2\u0089\30\3\2\2\2\u008a\u008b\7v\2\2\u008b"+
		"\u008c\7t\2\2\u008c\u008d\7{\2\2\u008d\32\3\2\2\2\u008e\u008f\7>\2\2\u008f"+
		"\u0090\7?\2\2\u0090\34\3\2\2\2\u0091\u0092\7(\2\2\u0092\36\3\2\2\2\u0093"+
		"\u0094\7f\2\2\u0094\u0095\7q\2\2\u0095 \3\2\2\2\u0096\u0097\7*\2\2\u0097"+
		"\"\3\2\2\2\u0098\u0099\7,\2\2\u0099$\3\2\2\2\u009a\u009b\7.\2\2\u009b"+
		"&\3\2\2\2\u009c\u009d\7h\2\2\u009d\u009e\7c\2\2\u009e\u009f\7n\2\2\u009f"+
		"\u00a0\7u\2\2\u00a0\u00a1\7g\2\2\u00a1(\3\2\2\2\u00a2\u00a3\7n\2\2\u00a3"+
		"\u00a4\7c\2\2\u00a4\u00a5\7o\2\2\u00a5\u00a6\7d\2\2\u00a6\u00a7\7f\2\2"+
		"\u00a7\u00a8\7c\2\2\u00a8*\3\2\2\2\u00a9\u00aa\7@\2\2\u00aa\u00ab\7?\2"+
		"\2\u00ab,\3\2\2\2\u00ac\u00ad\7~\2\2\u00ad.\3\2\2\2\u00ae\u00af\7?\2\2"+
		"\u00af\u00b0\7?\2\2\u00b0\60\3\2\2\2\u00b1\u00b2\7>\2\2\u00b2\62\3\2\2"+
		"\2\u00b3\u00b4\7@\2\2\u00b4\64\3\2\2\2\u00b5\u00b6\7#\2\2\u00b6\66\3\2"+
		"\2\2\u00b7\u00b8\7n\2\2\u00b8\u00b9\7g\2\2\u00b9\u00ba\7v\2\2\u00ba8\3"+
		"\2\2\2\u00bb\u00bc\7\'\2\2\u00bc:\3\2\2\2\u00bd\u00be\7g\2\2\u00be\u00bf"+
		"\7n\2\2\u00bf\u00c0\7u\2\2\u00c0\u00c1\7g\2\2\u00c1<\3\2\2\2\u00c2\u00c3"+
		"\7k\2\2\u00c3\u00c4\7p\2\2\u00c4>\3\2\2\2\u00c5\u00c6\7h\2\2\u00c6\u00c7"+
		"\7w\2\2\u00c7\u00c8\7p\2\2\u00c8\u00c9\7e\2\2\u00c9\u00ca\7v\2\2\u00ca"+
		"\u00cb\7k\2\2\u00cb\u00cc\7q\2\2\u00cc\u00cd\7p\2\2\u00cd@\3\2\2\2\u00ce"+
		"\u00cf\7+\2\2\u00cfB\3\2\2\2\u00d0\u00d1\7c\2\2\u00d1\u00d2\7p\2\2\u00d2"+
		"\u00d3\7f\2\2\u00d3D\3\2\2\2\u00d4\u00d5\7v\2\2\u00d5\u00d6\7j\2\2\u00d6"+
		"\u00d7\7g\2\2\u00d7\u00d8\7p\2\2\u00d8F\3\2\2\2\u00d9\u00da\7-\2\2\u00da"+
		"H\3\2\2\2\u00db\u00dc\7/\2\2\u00dcJ\3\2\2\2\u00dd\u00e1\t\2\2\2\u00de"+
		"\u00e0\t\3\2\2\u00df\u00de\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2"+
		"\2\2\u00e1\u00e2\3\2\2\2\u00e2L\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e6"+
		"\t\4\2\2\u00e5\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7"+
		"\u00e8\3\2\2\2\u00e8N\3\2\2\2\u00e9\u00eb\t\4\2\2\u00ea\u00e9\3\2\2\2"+
		"\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ef"+
		"\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f3\7\60\2\2\u00f0\u00f2\t\4\2\2"+
		"\u00f1\u00f0\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4"+
		"\3\2\2\2\u00f4P\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6\u00fb\7$\2\2\u00f7\u00fa"+
		"\5S*\2\u00f8\u00fa\n\5\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00f8\3\2\2\2\u00fa"+
		"\u00fd\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fe\3\2"+
		"\2\2\u00fd\u00fb\3\2\2\2\u00fe\u00ff\7$\2\2\u00ffR\3\2\2\2\u0100\u0101"+
		"\7^\2\2\u0101\u0102\t\6\2\2\u0102T\3\2\2\2\u0103\u0104\7\61\2\2\u0104"+
		"\u0105\7\61\2\2\u0105\u0109\3\2\2\2\u0106\u0108\n\7\2\2\u0107\u0106\3"+
		"\2\2\2\u0108\u010b\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a"+
		"\u010c\3\2\2\2\u010b\u0109\3\2\2\2\u010c\u010d\b+\2\2\u010dV\3\2\2\2\u010e"+
		"\u010f\7\61\2\2\u010f\u0110\7,\2\2\u0110\u0116\3\2\2\2\u0111\u0112\7,"+
		"\2\2\u0112\u0115\n\b\2\2\u0113\u0115\n\t\2\2\u0114\u0111\3\2\2\2\u0114"+
		"\u0113\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2"+
		"\2\2\u0117\u0119\3\2\2\2\u0118\u0116\3\2\2\2\u0119\u011a\7,\2\2\u011a"+
		"\u011b\7\61\2\2\u011b\u011c\3\2\2\2\u011c\u011d\b,\2\2\u011dX\3\2\2\2"+
		"\u011e\u0120\t\n\2\2\u011f\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u011f"+
		"\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124\b-\2\2\u0124"+
		"Z\3\2\2\2\r\2\u00e1\u00e7\u00ec\u00f3\u00f9\u00fb\u0109\u0114\u0116\u0121"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}