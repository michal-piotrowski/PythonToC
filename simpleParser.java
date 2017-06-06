package pl.edu.agh.compilers;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class simpleParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, NUMBER=20, STRING_VAL=21, CLASS=22, IMPORT=23, IF=24, 
		DEF=25, NAME=26, ELIF=27, ELSE=28, NEWLINE=29, SKIP_=30, SPACES=31, INDENT=32, 
		DEDENT=33;
	public static final int
		RULE_program = 0, RULE_funcDefinition = 1, RULE_classDefinition = 2, RULE_block = 3, 
		RULE_instruction = 4, RULE_compoundAssignment = 5, RULE_compAssign_op = 6, 
		RULE_conditionalStatement = 7, RULE_test = 8, RULE_test_op = 9, RULE_assignment = 10, 
		RULE_expression = 11, RULE_addition = 12, RULE_multiplication = 13, RULE_atom = 14;
	public static final String[] ruleNames = {
		"program", "funcDefinition", "classDefinition", "block", "instruction", 
		"compoundAssignment", "compAssign_op", "conditionalStatement", "test", 
		"test_op", "assignment", "expression", "addition", "multiplication", "atom"
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
		"SPACES", "INDENT", "DEDENT"
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
	public String getGrammarFileName() { return "simple.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public simpleParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(simpleParser.EOF, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(simpleParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(simpleParser.NEWLINE, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << NUMBER) | (1L << STRING_VAL) | (1L << IF) | (1L << DEF) | (1L << NAME))) != 0)) {
				{
				{
				setState(30);
				block();
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(31);
					match(NEWLINE);
					}
					}
					setState(36);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(42);
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

	public static class FuncDefinitionContext extends ParserRuleContext {
		public TerminalNode DEF() { return getToken(simpleParser.DEF, 0); }
		public List<TerminalNode> NAME() { return getTokens(simpleParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(simpleParser.NAME, i);
		}
		public TerminalNode NEWLINE() { return getToken(simpleParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(simpleParser.INDENT, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode DEDENT() { return getToken(simpleParser.DEDENT, 0); }
		public TerminalNode EOF() { return getToken(simpleParser.EOF, 0); }
		public FuncDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).enterFuncDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).exitFuncDefinition(this);
		}
	}

	public final FuncDefinitionContext funcDefinition() throws RecognitionException {
		FuncDefinitionContext _localctx = new FuncDefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_funcDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(DEF);
			setState(45);
			match(NAME);
			setState(46);
			match(T__0);
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(47);
				match(NAME);
				}
			}

			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(50);
				match(T__1);
				setState(51);
				match(NAME);
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
			match(T__2);
			setState(58);
			match(T__3);
			setState(59);
			match(NEWLINE);
			setState(60);
			match(INDENT);
			setState(61);
			block();
			setState(62);
			_la = _input.LA(1);
			if ( !(_la==EOF || _la==DEDENT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static class ClassDefinitionContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(simpleParser.CLASS, 0); }
		public TerminalNode NAME() { return getToken(simpleParser.NAME, 0); }
		public ClassDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).enterClassDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).exitClassDefinition(this);
		}
	}

	public final ClassDefinitionContext classDefinition() throws RecognitionException {
		ClassDefinitionContext _localctx = new ClassDefinitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(CLASS);
			setState(65);
			match(NAME);
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
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(simpleParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(simpleParser.NEWLINE, i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(74); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(67);
					instruction();
					setState(71);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(68);
							match(NEWLINE);
							}
							} 
						}
						setState(73);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(76); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(78);
				block();
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

	public static class InstructionContext extends ParserRuleContext {
		public ConditionalStatementContext conditionalStatement() {
			return getRuleContext(ConditionalStatementContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public CompoundAssignmentContext compoundAssignment() {
			return getRuleContext(CompoundAssignmentContext.class,0);
		}
		public FuncDefinitionContext funcDefinition() {
			return getRuleContext(FuncDefinitionContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).exitInstruction(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_instruction);
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				conditionalStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(83);
				compoundAssignment();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(84);
				funcDefinition();
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

	public static class CompoundAssignmentContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public CompAssign_opContext compAssign_op() {
			return getRuleContext(CompAssign_opContext.class,0);
		}
		public CompoundAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).enterCompoundAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).exitCompoundAssignment(this);
		}
	}

	public final CompoundAssignmentContext compoundAssignment() throws RecognitionException {
		CompoundAssignmentContext _localctx = new CompoundAssignmentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_compoundAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			expression();
			setState(88);
			compAssign_op();
			setState(89);
			expression();
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

	public static class CompAssign_opContext extends ParserRuleContext {
		public CompAssign_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compAssign_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).enterCompAssign_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).exitCompAssign_op(this);
		}
	}

	public final CompAssign_opContext compAssign_op() throws RecognitionException {
		CompAssign_opContext _localctx = new CompAssign_opContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_compAssign_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static class ConditionalStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(simpleParser.IF, 0); }
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(simpleParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(simpleParser.NEWLINE, i);
		}
		public List<TerminalNode> INDENT() { return getTokens(simpleParser.INDENT); }
		public TerminalNode INDENT(int i) {
			return getToken(simpleParser.INDENT, i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<TerminalNode> DEDENT() { return getTokens(simpleParser.DEDENT); }
		public TerminalNode DEDENT(int i) {
			return getToken(simpleParser.DEDENT, i);
		}
		public TerminalNode ELIF() { return getToken(simpleParser.ELIF, 0); }
		public TerminalNode ELSE() { return getToken(simpleParser.ELSE, 0); }
		public ConditionalStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).enterConditionalStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).exitConditionalStatement(this);
		}
	}

	public final ConditionalStatementContext conditionalStatement() throws RecognitionException {
		ConditionalStatementContext _localctx = new ConditionalStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_conditionalStatement);
		int _la;
		try {
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				match(IF);
				setState(94);
				test();
				setState(95);
				match(T__3);
				setState(96);
				match(NEWLINE);
				setState(97);
				match(INDENT);
				setState(98);
				block();
				setState(99);
				match(DEDENT);
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELIF) {
					{
					setState(100);
					match(ELIF);
					setState(101);
					test();
					setState(102);
					match(T__3);
					setState(103);
					match(NEWLINE);
					setState(104);
					match(INDENT);
					setState(105);
					block();
					setState(106);
					match(DEDENT);
					}
				}

				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(110);
					match(ELSE);
					setState(111);
					test();
					setState(112);
					match(T__3);
					setState(113);
					match(NEWLINE);
					setState(114);
					match(INDENT);
					setState(115);
					block();
					setState(116);
					match(DEDENT);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				match(IF);
				setState(121);
				match(T__0);
				setState(122);
				test();
				setState(123);
				match(T__2);
				setState(124);
				match(T__3);
				setState(125);
				match(NEWLINE);
				setState(126);
				match(INDENT);
				setState(127);
				block();
				setState(128);
				match(DEDENT);
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELIF) {
					{
					setState(129);
					match(ELIF);
					setState(130);
					match(T__0);
					setState(131);
					test();
					setState(132);
					match(T__2);
					setState(133);
					match(T__3);
					setState(134);
					match(NEWLINE);
					setState(135);
					match(INDENT);
					setState(136);
					block();
					setState(137);
					match(DEDENT);
					}
				}

				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(141);
					match(ELSE);
					setState(142);
					match(T__0);
					setState(143);
					test();
					setState(144);
					match(T__2);
					setState(145);
					match(T__3);
					setState(146);
					match(NEWLINE);
					setState(147);
					match(INDENT);
					setState(148);
					block();
					setState(149);
					match(DEDENT);
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

	public static class TestContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Test_opContext test_op() {
			return getRuleContext(Test_opContext.class,0);
		}
		public TestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).enterTest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).exitTest(this);
		}
	}

	public final TestContext test() throws RecognitionException {
		TestContext _localctx = new TestContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_test);
		try {
			setState(160);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case NUMBER:
			case STRING_VAL:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				expression();
				setState(156);
				test_op();
				setState(157);
				expression();
				}
				break;
			case T__2:
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class Test_opContext extends ParserRuleContext {
		public Test_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).enterTest_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).exitTest_op(this);
		}
	}

	public final Test_opContext test_op() throws RecognitionException {
		Test_opContext _localctx = new Test_opContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_test_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(simpleParser.NAME, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(NAME);
			setState(165);
			match(T__14);
			setState(166);
			expression();
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
		public AdditionContext addition() {
			return getRuleContext(AdditionContext.class,0);
		}
		public TerminalNode STRING_VAL() { return getToken(simpleParser.STRING_VAL, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expression);
		try {
			setState(170);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case NUMBER:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				addition();
				}
				break;
			case STRING_VAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				match(STRING_VAL);
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

	public static class AdditionContext extends ParserRuleContext {
		public List<MultiplicationContext> multiplication() {
			return getRuleContexts(MultiplicationContext.class);
		}
		public MultiplicationContext multiplication(int i) {
			return getRuleContext(MultiplicationContext.class,i);
		}
		public AdditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).enterAddition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).exitAddition(this);
		}
	}

	public final AdditionContext addition() throws RecognitionException {
		AdditionContext _localctx = new AdditionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_addition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			multiplication();
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15 || _la==T__16) {
				{
				setState(177);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__15:
					{
					setState(173);
					match(T__15);
					setState(174);
					multiplication();
					}
					break;
				case T__16:
					{
					setState(175);
					match(T__16);
					setState(176);
					multiplication();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(181);
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

	public static class MultiplicationContext extends ParserRuleContext {
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public MultiplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplication; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).enterMultiplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).exitMultiplication(this);
		}
	}

	public final MultiplicationContext multiplication() throws RecognitionException {
		MultiplicationContext _localctx = new MultiplicationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_multiplication);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			atom();
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17 || _la==T__18) {
				{
				setState(187);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__17:
					{
					setState(183);
					match(T__17);
					setState(184);
					atom();
					}
					break;
				case T__18:
					{
					setState(185);
					match(T__18);
					setState(186);
					atom();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(191);
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

	public static class AtomContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(simpleParser.NUMBER, 0); }
		public AdditionContext addition() {
			return getRuleContext(AdditionContext.class,0);
		}
		public TerminalNode NAME() { return getToken(simpleParser.NAME, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleListener ) ((simpleListener)listener).exitAtom(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_atom);
		try {
			setState(198);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
				match(NUMBER);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
				match(T__0);
				setState(194);
				addition();
				setState(195);
				match(T__2);
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 3);
				{
				setState(197);
				match(NAME);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u00cb\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\7\2#\n\2\f\2"+
		"\16\2&\13\2\7\2(\n\2\f\2\16\2+\13\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3\63\n\3"+
		"\3\3\3\3\7\3\67\n\3\f\3\16\3:\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\5\3\5\7\5H\n\5\f\5\16\5K\13\5\6\5M\n\5\r\5\16\5N\3\5\5\5R\n\5\3"+
		"\6\3\6\3\6\3\6\5\6X\n\6\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\to\n\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\5\ty\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u008e\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\5\t\u009a\n\t\5\t\u009c\n\t\3\n\3\n\3\n\3\n\3\n\5\n\u00a3\n"+
		"\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\5\r\u00ad\n\r\3\16\3\16\3\16\3\16"+
		"\3\16\7\16\u00b4\n\16\f\16\16\16\u00b7\13\16\3\17\3\17\3\17\3\17\3\17"+
		"\7\17\u00be\n\17\f\17\16\17\u00c1\13\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\5\20\u00c9\n\20\3\20\2\2\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2"+
		"\5\3\3##\3\2\7\n\3\2\13\20\2\u00d2\2)\3\2\2\2\4.\3\2\2\2\6B\3\2\2\2\b"+
		"L\3\2\2\2\nW\3\2\2\2\fY\3\2\2\2\16]\3\2\2\2\20\u009b\3\2\2\2\22\u00a2"+
		"\3\2\2\2\24\u00a4\3\2\2\2\26\u00a6\3\2\2\2\30\u00ac\3\2\2\2\32\u00ae\3"+
		"\2\2\2\34\u00b8\3\2\2\2\36\u00c8\3\2\2\2 $\5\b\5\2!#\7\37\2\2\"!\3\2\2"+
		"\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%(\3\2\2\2&$\3\2\2\2\' \3\2\2\2(+\3\2"+
		"\2\2)\'\3\2\2\2)*\3\2\2\2*,\3\2\2\2+)\3\2\2\2,-\7\2\2\3-\3\3\2\2\2./\7"+
		"\33\2\2/\60\7\34\2\2\60\62\7\3\2\2\61\63\7\34\2\2\62\61\3\2\2\2\62\63"+
		"\3\2\2\2\638\3\2\2\2\64\65\7\4\2\2\65\67\7\34\2\2\66\64\3\2\2\2\67:\3"+
		"\2\2\28\66\3\2\2\289\3\2\2\29;\3\2\2\2:8\3\2\2\2;<\7\5\2\2<=\7\6\2\2="+
		">\7\37\2\2>?\7\"\2\2?@\5\b\5\2@A\t\2\2\2A\5\3\2\2\2BC\7\30\2\2CD\7\34"+
		"\2\2D\7\3\2\2\2EI\5\n\6\2FH\7\37\2\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3"+
		"\2\2\2JM\3\2\2\2KI\3\2\2\2LE\3\2\2\2MN\3\2\2\2NL\3\2\2\2NO\3\2\2\2OQ\3"+
		"\2\2\2PR\5\b\5\2QP\3\2\2\2QR\3\2\2\2R\t\3\2\2\2SX\5\20\t\2TX\5\26\f\2"+
		"UX\5\f\7\2VX\5\4\3\2WS\3\2\2\2WT\3\2\2\2WU\3\2\2\2WV\3\2\2\2X\13\3\2\2"+
		"\2YZ\5\30\r\2Z[\5\16\b\2[\\\5\30\r\2\\\r\3\2\2\2]^\t\3\2\2^\17\3\2\2\2"+
		"_`\7\32\2\2`a\5\22\n\2ab\7\6\2\2bc\7\37\2\2cd\7\"\2\2de\5\b\5\2en\7#\2"+
		"\2fg\7\35\2\2gh\5\22\n\2hi\7\6\2\2ij\7\37\2\2jk\7\"\2\2kl\5\b\5\2lm\7"+
		"#\2\2mo\3\2\2\2nf\3\2\2\2no\3\2\2\2ox\3\2\2\2pq\7\36\2\2qr\5\22\n\2rs"+
		"\7\6\2\2st\7\37\2\2tu\7\"\2\2uv\5\b\5\2vw\7#\2\2wy\3\2\2\2xp\3\2\2\2x"+
		"y\3\2\2\2y\u009c\3\2\2\2z{\7\32\2\2{|\7\3\2\2|}\5\22\n\2}~\7\5\2\2~\177"+
		"\7\6\2\2\177\u0080\7\37\2\2\u0080\u0081\7\"\2\2\u0081\u0082\5\b\5\2\u0082"+
		"\u008d\7#\2\2\u0083\u0084\7\35\2\2\u0084\u0085\7\3\2\2\u0085\u0086\5\22"+
		"\n\2\u0086\u0087\7\5\2\2\u0087\u0088\7\6\2\2\u0088\u0089\7\37\2\2\u0089"+
		"\u008a\7\"\2\2\u008a\u008b\5\b\5\2\u008b\u008c\7#\2\2\u008c\u008e\3\2"+
		"\2\2\u008d\u0083\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0099\3\2\2\2\u008f"+
		"\u0090\7\36\2\2\u0090\u0091\7\3\2\2\u0091\u0092\5\22\n\2\u0092\u0093\7"+
		"\5\2\2\u0093\u0094\7\6\2\2\u0094\u0095\7\37\2\2\u0095\u0096\7\"\2\2\u0096"+
		"\u0097\5\b\5\2\u0097\u0098\7#\2\2\u0098\u009a\3\2\2\2\u0099\u008f\3\2"+
		"\2\2\u0099\u009a\3\2\2\2\u009a\u009c\3\2\2\2\u009b_\3\2\2\2\u009bz\3\2"+
		"\2\2\u009c\21\3\2\2\2\u009d\u009e\5\30\r\2\u009e\u009f\5\24\13\2\u009f"+
		"\u00a0\5\30\r\2\u00a0\u00a3\3\2\2\2\u00a1\u00a3\3\2\2\2\u00a2\u009d\3"+
		"\2\2\2\u00a2\u00a1\3\2\2\2\u00a3\23\3\2\2\2\u00a4\u00a5\t\4\2\2\u00a5"+
		"\25\3\2\2\2\u00a6\u00a7\7\34\2\2\u00a7\u00a8\7\21\2\2\u00a8\u00a9\5\30"+
		"\r\2\u00a9\27\3\2\2\2\u00aa\u00ad\5\32\16\2\u00ab\u00ad\7\27\2\2\u00ac"+
		"\u00aa\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\31\3\2\2\2\u00ae\u00b5\5\34\17"+
		"\2\u00af\u00b0\7\22\2\2\u00b0\u00b4\5\34\17\2\u00b1\u00b2\7\23\2\2\u00b2"+
		"\u00b4\5\34\17\2\u00b3\u00af\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00b7\3"+
		"\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\33\3\2\2\2\u00b7"+
		"\u00b5\3\2\2\2\u00b8\u00bf\5\36\20\2\u00b9\u00ba\7\24\2\2\u00ba\u00be"+
		"\5\36\20\2\u00bb\u00bc\7\25\2\2\u00bc\u00be\5\36\20\2\u00bd\u00b9\3\2"+
		"\2\2\u00bd\u00bb\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf"+
		"\u00c0\3\2\2\2\u00c0\35\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c9\7\26\2"+
		"\2\u00c3\u00c4\7\3\2\2\u00c4\u00c5\5\32\16\2\u00c5\u00c6\7\5\2\2\u00c6"+
		"\u00c9\3\2\2\2\u00c7\u00c9\7\34\2\2\u00c8\u00c2\3\2\2\2\u00c8\u00c3\3"+
		"\2\2\2\u00c8\u00c7\3\2\2\2\u00c9\37\3\2\2\2\26$)\628INQWnx\u008d\u0099"+
		"\u009b\u00a2\u00ac\u00b3\u00b5\u00bd\u00bf\u00c8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}