package pl.edu.agh.compilers;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class simpleLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, NUMBER=20, STRING_VAL=21, CLASS=22, IMPORT=23, IF=24, 
		DEF=25, NAME=26, ELIF=27, ELSE=28, NEWLINE=29, SKIP_=30, SPACES=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "NUMBER", "STRING_VAL", "CLASS", "IMPORT", "IF", "DEF", 
		"NAME", "ELIF", "ELSE", "NEWLINE", "SKIP_", "SPACES"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "','", "')'", "':'", "'+='", "'-='", "'*='", "'/='", "'=='", 
		"'!='", "'>='", "'<='", "'<'", "'>'", "'='", "'+'", "'-'", "'*'", "'/'", 
		null, null, "'class'", "'import'", "'if'", "'def'", null, "'elif'", "'else'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "NUMBER", "STRING_VAL", 
		"CLASS", "IMPORT", "IF", "DEF", "NAME", "ELIF", "ELSE", "NEWLINE", "SKIP_", 
		"SPACES"
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



	  public static java.util.Map names = new java.util.HashMap();

	    // A queue where extra tokens are pushed on (see the NEWLINE lexer rule).
	  private java.util.LinkedList<Token> tokens = new java.util.LinkedList<>();
	    // The stack that keeps track of the indentation level.
	  private java.util.Stack<Integer> indents = new java.util.Stack<>();
	    // The amount of opened braces, brackets and parenthesis.
	  private int opened = 0;
	    // The most recently produced token.
	  private Token lastToken = null;
	  @Override
	  public void emit(Token t) {
	    super.setToken(t);
	    tokens.offer(t);
	  }

	  @Override
	  public Token nextToken() {
	    // Check if the end-of-file is ahead and there are still some DEDENTS expected.
	    if (_input.LA(1) == EOF && !this.indents.isEmpty()) {
	      // Remove any trailing EOF tokens from our buffer.
	      for (int i = tokens.size() - 1; i >= 0; i--) {
	        if (tokens.get(i).getType() == EOF) {
	          tokens.remove(i);
	        }
	      }

	      // First emit an extra line break that serves as the end of the statement.
	      this.emit(commonToken(simpleParser.NEWLINE, "\n"));

	      // Now emit as much DEDENT tokens as needed.
	      while (!indents.isEmpty()) {
	        this.emit(createDedent());
	        indents.pop();
	      }

	      // Put the EOF back on the token stream.
	      this.emit(commonToken(simpleParser.EOF, "<EOF>"));
	    }

	    Token next = super.nextToken();

	    if (next.getChannel() == Token.DEFAULT_CHANNEL) {
	      // Keep track of the last token on the default channel.
	      this.lastToken = next;
	    }

	    return tokens.isEmpty() ? next : tokens.poll();
	  }

	  private Token createDedent() {
	    CommonToken dedent = commonToken(simpleParser.DEDENT, "");
	    dedent.setLine(this.lastToken.getLine());
	    return dedent;
	  }

	  private CommonToken commonToken(int type, String text) {
	    int stop = this.getCharIndex() - 1;
	    int start = text.isEmpty() ? stop : stop - text.length() + 1;
	    return new CommonToken(this._tokenFactorySourcePair, type, DEFAULT_TOKEN_CHANNEL, start, stop);
	  }

	  // Calculates the indentation of the provided spaces, taking the
	  // following rules into account:
	  //
	  // "Tabs are replaced (from left to right) by one to eight spaces
	  //  such that the total number of characters up to and including
	  //  the replacement is a multiple of eight [...]"
	  //
	  //  -- https://docs.python.org/3.1/reference/lexical_analysis.html#indentation
	  static int getIndentationCount(String spaces) {
	    int count = 0;
	    for (char ch : spaces.toCharArray()) {
	      switch (ch) {
	        case '\t':
	          count += 8 - (count % 8);
	          break;
	        default:
	          // A normal space char.
	          count++;
	      }
	    }
	    System.out.println("indentationCount: " + count);
	    return count;
	  }

	  boolean atStartOfInput() {
	    return super.getCharPositionInLine() == 0 && super.getLine() == 1;
	  }


	public simpleLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "simple.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 28:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void NEWLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			     String newLine = getText().replaceAll("[^\r\n\f]+", "");
			     String spaces = getText().replaceAll("[\r\n\f]+", "");
			     int next = _input.LA(1);
			     if (opened > 0 || next == '\r' || next == '\n' || next == '\f' || next == '#') {
			       // If we're inside a list or on a blank line, ignore all indents,
			       // dedents and line breaks.
			       skip();
			     }
			     else {
			       emit(commonToken(NEWLINE, newLine));
			       int indent = getIndentationCount(spaces);
			       int previous = indents.isEmpty() ? 0 : indents.peek();
			       if (indent == previous) {
			         // skip indents of the same size as the present indent-size
			         skip();
			       }
			       else if (indent > previous) {
			         indents.push(indent);
			         emit(commonToken(simpleParser.INDENT, spaces));
			         System.out.println("###INDENT###");
			       }
			       else {
			         // Possibly emit more than 1 DEDENT token.
			         while(!indents.isEmpty() && indents.peek() > indent) {
			           this.emit(createDedent());
			           indents.pop();
			         }
			       }
			     }
			   
			break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 28:
			return NEWLINE_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean NEWLINE_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return atStartOfInput();
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u00ec\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3"+
		"\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\6\25q"+
		"\n\25\r\25\16\25r\3\25\6\25v\n\25\r\25\16\25w\3\25\3\25\7\25|\n\25\f\25"+
		"\16\25\177\13\25\5\25\u0081\n\25\3\26\3\26\7\26\u0085\n\26\f\26\16\26"+
		"\u0088\13\26\3\26\3\26\3\26\7\26\u008d\n\26\f\26\16\26\u0090\13\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\7\26\u0098\n\26\f\26\16\26\u009b\13\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u00a5\n\26\f\26\16\26\u00a8\13"+
		"\26\3\26\3\26\3\26\5\26\u00ad\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33"+
		"\3\33\7\33\u00c5\n\33\f\33\16\33\u00c8\13\33\3\34\3\34\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\5\36\u00d7\n\36\3\36\3\36\5\36"+
		"\u00db\n\36\3\36\5\36\u00de\n\36\5\36\u00e0\n\36\3\36\3\36\3\37\3\37\3"+
		"\37\3\37\3 \6 \u00e9\n \r \16 \u00ea\4\u0099\u00a6\2!\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!\3\2\b\3\2\62"+
		";\6\2\f\f\16\17$$^^\6\2\f\f\16\17))^^\5\2C\\aac|\6\2\62;C\\aac|\4\2\13"+
		"\13\"\"\2\u00fc\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\3A\3\2\2\2\5C\3\2\2\2\7E\3"+
		"\2\2\2\tG\3\2\2\2\13I\3\2\2\2\rL\3\2\2\2\17O\3\2\2\2\21R\3\2\2\2\23U\3"+
		"\2\2\2\25X\3\2\2\2\27[\3\2\2\2\31^\3\2\2\2\33a\3\2\2\2\35c\3\2\2\2\37"+
		"e\3\2\2\2!g\3\2\2\2#i\3\2\2\2%k\3\2\2\2\'m\3\2\2\2)\u0080\3\2\2\2+\u00ac"+
		"\3\2\2\2-\u00ae\3\2\2\2/\u00b4\3\2\2\2\61\u00bb\3\2\2\2\63\u00be\3\2\2"+
		"\2\65\u00c2\3\2\2\2\67\u00c9\3\2\2\29\u00ce\3\2\2\2;\u00df\3\2\2\2=\u00e3"+
		"\3\2\2\2?\u00e8\3\2\2\2AB\7*\2\2B\4\3\2\2\2CD\7.\2\2D\6\3\2\2\2EF\7+\2"+
		"\2F\b\3\2\2\2GH\7<\2\2H\n\3\2\2\2IJ\7-\2\2JK\7?\2\2K\f\3\2\2\2LM\7/\2"+
		"\2MN\7?\2\2N\16\3\2\2\2OP\7,\2\2PQ\7?\2\2Q\20\3\2\2\2RS\7\61\2\2ST\7?"+
		"\2\2T\22\3\2\2\2UV\7?\2\2VW\7?\2\2W\24\3\2\2\2XY\7#\2\2YZ\7?\2\2Z\26\3"+
		"\2\2\2[\\\7@\2\2\\]\7?\2\2]\30\3\2\2\2^_\7>\2\2_`\7?\2\2`\32\3\2\2\2a"+
		"b\7>\2\2b\34\3\2\2\2cd\7@\2\2d\36\3\2\2\2ef\7?\2\2f \3\2\2\2gh\7-\2\2"+
		"h\"\3\2\2\2ij\7/\2\2j$\3\2\2\2kl\7,\2\2l&\3\2\2\2mn\7\61\2\2n(\3\2\2\2"+
		"oq\t\2\2\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2s\u0081\3\2\2\2tv\t"+
		"\2\2\2ut\3\2\2\2vw\3\2\2\2wu\3\2\2\2wx\3\2\2\2xy\3\2\2\2y}\7\60\2\2z|"+
		"\t\2\2\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0081\3\2\2\2\177"+
		"}\3\2\2\2\u0080p\3\2\2\2\u0080u\3\2\2\2\u0081*\3\2\2\2\u0082\u0086\7$"+
		"\2\2\u0083\u0085\n\3\2\2\u0084\u0083\3\2\2\2\u0085\u0088\3\2\2\2\u0086"+
		"\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0089\3\2\2\2\u0088\u0086\3\2"+
		"\2\2\u0089\u00ad\7$\2\2\u008a\u008e\7)\2\2\u008b\u008d\n\4\2\2\u008c\u008b"+
		"\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f"+
		"\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u00ad\7)\2\2\u0092\u0093\7$\2"+
		"\2\u0093\u0094\7$\2\2\u0094\u0095\7$\2\2\u0095\u0099\3\2\2\2\u0096\u0098"+
		"\13\2\2\2\u0097\u0096\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u009a\3\2\2\2"+
		"\u0099\u0097\3\2\2\2\u009a\u009c\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009d"+
		"\7$\2\2\u009d\u009e\7$\2\2\u009e\u00ad\7$\2\2\u009f\u00a0\7)\2\2\u00a0"+
		"\u00a1\7)\2\2\u00a1\u00a2\7)\2\2\u00a2\u00a6\3\2\2\2\u00a3\u00a5\13\2"+
		"\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a6"+
		"\u00a4\3\2\2\2\u00a7\u00a9\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00aa\7)"+
		"\2\2\u00aa\u00ab\7)\2\2\u00ab\u00ad\7)\2\2\u00ac\u0082\3\2\2\2\u00ac\u008a"+
		"\3\2\2\2\u00ac\u0092\3\2\2\2\u00ac\u009f\3\2\2\2\u00ad,\3\2\2\2\u00ae"+
		"\u00af\7e\2\2\u00af\u00b0\7n\2\2\u00b0\u00b1\7c\2\2\u00b1\u00b2\7u\2\2"+
		"\u00b2\u00b3\7u\2\2\u00b3.\3\2\2\2\u00b4\u00b5\7k\2\2\u00b5\u00b6\7o\2"+
		"\2\u00b6\u00b7\7r\2\2\u00b7\u00b8\7q\2\2\u00b8\u00b9\7t\2\2\u00b9\u00ba"+
		"\7v\2\2\u00ba\60\3\2\2\2\u00bb\u00bc\7k\2\2\u00bc\u00bd\7h\2\2\u00bd\62"+
		"\3\2\2\2\u00be\u00bf\7f\2\2\u00bf\u00c0\7g\2\2\u00c0\u00c1\7h\2\2\u00c1"+
		"\64\3\2\2\2\u00c2\u00c6\t\5\2\2\u00c3\u00c5\t\6\2\2\u00c4\u00c3\3\2\2"+
		"\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\66"+
		"\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00ca\7g\2\2\u00ca\u00cb\7n\2\2\u00cb"+
		"\u00cc\7k\2\2\u00cc\u00cd\7h\2\2\u00cd8\3\2\2\2\u00ce\u00cf\7g\2\2\u00cf"+
		"\u00d0\7n\2\2\u00d0\u00d1\7u\2\2\u00d1\u00d2\7g\2\2\u00d2:\3\2\2\2\u00d3"+
		"\u00d4\6\36\2\2\u00d4\u00e0\5? \2\u00d5\u00d7\7\17\2\2\u00d6\u00d5\3\2"+
		"\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00db\7\f\2\2\u00d9"+
		"\u00db\4\16\17\2\u00da\u00d6\3\2\2\2\u00da\u00d9\3\2\2\2\u00db\u00dd\3"+
		"\2\2\2\u00dc\u00de\5? \2\u00dd\u00dc\3\2\2\2\u00dd\u00de\3\2\2\2\u00de"+
		"\u00e0\3\2\2\2\u00df\u00d3\3\2\2\2\u00df\u00da\3\2\2\2\u00e0\u00e1\3\2"+
		"\2\2\u00e1\u00e2\b\36\2\2\u00e2<\3\2\2\2\u00e3\u00e4\5? \2\u00e4\u00e5"+
		"\3\2\2\2\u00e5\u00e6\b\37\3\2\u00e6>\3\2\2\2\u00e7\u00e9\t\7\2\2\u00e8"+
		"\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2"+
		"\2\2\u00eb@\3\2\2\2\22\2rw}\u0080\u0086\u008e\u0099\u00a6\u00ac\u00c6"+
		"\u00d6\u00da\u00dd\u00df\u00ea\4\3\36\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}