// Generated from /Users/didriksivertsen/Documents/Informatikk/Courses/IN2031/oblig_2/aeroscript/src/main/antlr/AeroScript.g4 by ANTLR 4.13.1

package no.uio.aeroscript.antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class AeroScriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, COMMENT=2, LINE_COMMENT=3, LCURL=4, RCURL=5, LSQUARE=6, RSQUARE=7, 
		LPAREN=8, RPAREN=9, NEG=10, SEMI=11, COMMA=12, GREATER=13, ARROW=14, PLUS=15, 
		MINUS=16, TIMES=17, RANDOM=18, POINT=19, DESCEND_TO_GROUND=20, RETURN_TO_BASE=21, 
		DESCEND_BY=22, ASCEND_BY=23, AT_SPEED=24, SECONDS=25, RIGHT=26, MOVE=27, 
		TURN=28, LEFT=29, FOR=30, TO=31, BY=32, ID=33, NUMBER=34;
	public static final int
		RULE_program = 0, RULE_execution = 1, RULE_statement = 2, RULE_action = 3, 
		RULE_acDock = 4, RULE_acMove = 5, RULE_acTurn = 6, RULE_acAscend = 7, 
		RULE_acDescend = 8, RULE_expression = 9, RULE_point = 10, RULE_range = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "execution", "statement", "action", "acDock", "acMove", "acTurn", 
			"acAscend", "acDescend", "expression", "point", "range"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'{'", "'}'", "'['", "']'", "'('", "')'", "'--'", 
			"';'", "','", "'>'", "'->'", "'+'", "'-'", "'*'", "'random'", "'point'", 
			"'descend to groud'", "'return to base'", "'descend by'", "'ascend by'", 
			"'at speed'", "'seconds'", "'right'", "'move'", "'turn'", "'left'", "'for'", 
			"'to'", "'by'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "COMMENT", "LINE_COMMENT", "LCURL", "RCURL", "LSQUARE", "RSQUARE", 
			"LPAREN", "RPAREN", "NEG", "SEMI", "COMMA", "GREATER", "ARROW", "PLUS", 
			"MINUS", "TIMES", "RANDOM", "POINT", "DESCEND_TO_GROUND", "RETURN_TO_BASE", 
			"DESCEND_BY", "ASCEND_BY", "AT_SPEED", "SECONDS", "RIGHT", "MOVE", "TURN", 
			"LEFT", "FOR", "TO", "BY", "ID", "NUMBER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "AeroScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AeroScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<ExecutionContext> execution() {
			return getRuleContexts(ExecutionContext.class);
		}
		public ExecutionContext execution(int i) {
			return getRuleContext(ExecutionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(24);
				execution();
				}
				}
				setState(27); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ARROW || _la==ID );
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExecutionContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(AeroScriptParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AeroScriptParser.ID, i);
		}
		public TerminalNode LCURL() { return getToken(AeroScriptParser.LCURL, 0); }
		public TerminalNode RCURL() { return getToken(AeroScriptParser.RCURL, 0); }
		public List<TerminalNode> ARROW() { return getTokens(AeroScriptParser.ARROW); }
		public TerminalNode ARROW(int i) {
			return getToken(AeroScriptParser.ARROW, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ExecutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_execution; }
	}

	public final ExecutionContext execution() throws RecognitionException {
		ExecutionContext _localctx = new ExecutionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_execution);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARROW) {
				{
				setState(29);
				match(ARROW);
				}
			}

			setState(32);
			match(ID);
			setState(33);
			match(LCURL);
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 417333248L) != 0)) {
				{
				{
				setState(34);
				statement();
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(40);
			match(RCURL);
			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(41);
				match(ARROW);
				setState(42);
				match(ID);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			action();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ActionContext extends ParserRuleContext {
		public AcDockContext acDock() {
			return getRuleContext(AcDockContext.class,0);
		}
		public AcMoveContext acMove() {
			return getRuleContext(AcMoveContext.class,0);
		}
		public AcTurnContext acTurn() {
			return getRuleContext(AcTurnContext.class,0);
		}
		public AcAscendContext acAscend() {
			return getRuleContext(AcAscendContext.class,0);
		}
		public AcDescendContext acDescend() {
			return getRuleContext(AcDescendContext.class,0);
		}
		public TerminalNode FOR() { return getToken(AeroScriptParser.FOR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SECONDS() { return getToken(AeroScriptParser.SECONDS, 0); }
		public TerminalNode AT_SPEED() { return getToken(AeroScriptParser.AT_SPEED, 0); }
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURN_TO_BASE:
				{
				setState(47);
				acDock();
				}
				break;
			case MOVE:
				{
				setState(48);
				acMove();
				}
				break;
			case TURN:
				{
				setState(49);
				acTurn();
				}
				break;
			case ASCEND_BY:
				{
				setState(50);
				acAscend();
				}
				break;
			case DESCEND_BY:
				{
				setState(51);
				acDescend();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(60);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				{
				{
				setState(54);
				match(FOR);
				setState(55);
				expression(0);
				setState(56);
				match(SECONDS);
				}
				}
				break;
			case AT_SPEED:
				{
				{
				setState(58);
				match(AT_SPEED);
				setState(59);
				expression(0);
				}
				}
				break;
			case RCURL:
			case RETURN_TO_BASE:
			case DESCEND_BY:
			case ASCEND_BY:
			case MOVE:
			case TURN:
				break;
			default:
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

	@SuppressWarnings("CheckReturnValue")
	public static class AcDockContext extends ParserRuleContext {
		public TerminalNode RETURN_TO_BASE() { return getToken(AeroScriptParser.RETURN_TO_BASE, 0); }
		public AcDockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acDock; }
	}

	public final AcDockContext acDock() throws RecognitionException {
		AcDockContext _localctx = new AcDockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_acDock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(RETURN_TO_BASE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AcMoveContext extends ParserRuleContext {
		public TerminalNode MOVE() { return getToken(AeroScriptParser.MOVE, 0); }
		public TerminalNode TO() { return getToken(AeroScriptParser.TO, 0); }
		public TerminalNode POINT() { return getToken(AeroScriptParser.POINT, 0); }
		public PointContext point() {
			return getRuleContext(PointContext.class,0);
		}
		public TerminalNode BY() { return getToken(AeroScriptParser.BY, 0); }
		public TerminalNode NUMBER() { return getToken(AeroScriptParser.NUMBER, 0); }
		public AcMoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acMove; }
	}

	public final AcMoveContext acMove() throws RecognitionException {
		AcMoveContext _localctx = new AcMoveContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_acMove);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(MOVE);
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TO:
				{
				setState(65);
				match(TO);
				setState(66);
				match(POINT);
				setState(67);
				point();
				}
				break;
			case BY:
				{
				setState(68);
				match(BY);
				setState(69);
				match(NUMBER);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AcTurnContext extends ParserRuleContext {
		public TerminalNode TURN() { return getToken(AeroScriptParser.TURN, 0); }
		public TerminalNode BY() { return getToken(AeroScriptParser.BY, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT() { return getToken(AeroScriptParser.RIGHT, 0); }
		public TerminalNode LEFT() { return getToken(AeroScriptParser.LEFT, 0); }
		public AcTurnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acTurn; }
	}

	public final AcTurnContext acTurn() throws RecognitionException {
		AcTurnContext _localctx = new AcTurnContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_acTurn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(TURN);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RIGHT || _la==LEFT) {
				{
				setState(73);
				_la = _input.LA(1);
				if ( !(_la==RIGHT || _la==LEFT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(76);
			match(BY);
			setState(77);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AcAscendContext extends ParserRuleContext {
		public TerminalNode ASCEND_BY() { return getToken(AeroScriptParser.ASCEND_BY, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AcAscendContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acAscend; }
	}

	public final AcAscendContext acAscend() throws RecognitionException {
		AcAscendContext _localctx = new AcAscendContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_acAscend);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(ASCEND_BY);
			setState(80);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AcDescendContext extends ParserRuleContext {
		public TerminalNode DESCEND_BY() { return getToken(AeroScriptParser.DESCEND_BY, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AcDescendContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acDescend; }
	}

	public final AcDescendContext acDescend() throws RecognitionException {
		AcDescendContext _localctx = new AcDescendContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_acDescend);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(DESCEND_BY);
			setState(83);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PlusExpContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public TerminalNode PLUS() { return getToken(AeroScriptParser.PLUS, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PlusExpContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TimesExpContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public TerminalNode TIMES() { return getToken(AeroScriptParser.TIMES, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TimesExpContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegExpContext extends ExpressionContext {
		public TerminalNode NEG() { return getToken(AeroScriptParser.NEG, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NegExpContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumExpContext extends ExpressionContext {
		public TerminalNode NUMBER() { return getToken(AeroScriptParser.NUMBER, 0); }
		public NumExpContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParentExpContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(AeroScriptParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(AeroScriptParser.RPAREN, 0); }
		public ParentExpContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RangeExpContext extends ExpressionContext {
		public TerminalNode RANDOM() { return getToken(AeroScriptParser.RANDOM, 0); }
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public RangeExpContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MinusExpContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public TerminalNode MINUS() { return getToken(AeroScriptParser.MINUS, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MinusExpContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PointExpContext extends ExpressionContext {
		public TerminalNode POINT() { return getToken(AeroScriptParser.POINT, 0); }
		public PointContext point() {
			return getRuleContext(PointContext.class,0);
		}
		public PointExpContext(ExpressionContext ctx) { copyFrom(ctx); }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEG:
				{
				_localctx = new NegExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(86);
				match(NEG);
				setState(87);
				expression(8);
				}
				break;
			case NUMBER:
				{
				_localctx = new NumExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88);
				match(NUMBER);
				}
				break;
			case RANDOM:
				{
				_localctx = new RangeExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89);
				match(RANDOM);
				setState(90);
				range();
				}
				break;
			case POINT:
				{
				_localctx = new PointExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(91);
				match(POINT);
				setState(92);
				point();
				}
				break;
			case LPAREN:
				{
				_localctx = new ParentExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(93);
				match(LPAREN);
				setState(94);
				expression(0);
				setState(95);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(110);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(108);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new TimesExpContext(new ExpressionContext(_parentctx, _parentState));
						((TimesExpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(99);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(100);
						match(TIMES);
						setState(101);
						((TimesExpContext)_localctx).right = expression(8);
						}
						break;
					case 2:
						{
						_localctx = new PlusExpContext(new ExpressionContext(_parentctx, _parentState));
						((PlusExpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(102);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(103);
						match(PLUS);
						setState(104);
						((PlusExpContext)_localctx).right = expression(7);
						}
						break;
					case 3:
						{
						_localctx = new MinusExpContext(new ExpressionContext(_parentctx, _parentState));
						((MinusExpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(105);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(106);
						match(MINUS);
						setState(107);
						((MinusExpContext)_localctx).right = expression(6);
						}
						break;
					}
					} 
				}
				setState(112);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PointContext extends ParserRuleContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public TerminalNode LPAREN() { return getToken(AeroScriptParser.LPAREN, 0); }
		public TerminalNode COMMA() { return getToken(AeroScriptParser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(AeroScriptParser.RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_point; }
	}

	public final PointContext point() throws RecognitionException {
		PointContext _localctx = new PointContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_point);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(LPAREN);
			setState(114);
			((PointContext)_localctx).left = expression(0);
			setState(115);
			match(COMMA);
			setState(116);
			((PointContext)_localctx).right = expression(0);
			setState(117);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RangeContext extends ParserRuleContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public TerminalNode LSQUARE() { return getToken(AeroScriptParser.LSQUARE, 0); }
		public TerminalNode COMMA() { return getToken(AeroScriptParser.COMMA, 0); }
		public TerminalNode RSQUARE() { return getToken(AeroScriptParser.RSQUARE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public RangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range; }
	}

	public final RangeContext range() throws RecognitionException {
		RangeContext _localctx = new RangeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(LSQUARE);
			setState(120);
			((RangeContext)_localctx).left = expression(0);
			setState(121);
			match(COMMA);
			setState(122);
			((RangeContext)_localctx).right = expression(0);
			setState(123);
			match(RSQUARE);
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
		case 9:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\"~\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001"+
		"\u0000\u0004\u0000\u001a\b\u0000\u000b\u0000\f\u0000\u001b\u0001\u0001"+
		"\u0003\u0001\u001f\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"$\b\u0001\n\u0001\f\u0001\'\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001,\b\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u00035\b\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"=\b\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005G\b\u0005\u0001\u0006"+
		"\u0001\u0006\u0003\u0006K\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\tb\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0005\tm\b\t\n\t\f\tp\t\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0000\u0001\u0012\f\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0000\u0001\u0002\u0000\u001a"+
		"\u001a\u001d\u001d\u0084\u0000\u0019\u0001\u0000\u0000\u0000\u0002\u001e"+
		"\u0001\u0000\u0000\u0000\u0004-\u0001\u0000\u0000\u0000\u00064\u0001\u0000"+
		"\u0000\u0000\b>\u0001\u0000\u0000\u0000\n@\u0001\u0000\u0000\u0000\fH"+
		"\u0001\u0000\u0000\u0000\u000eO\u0001\u0000\u0000\u0000\u0010R\u0001\u0000"+
		"\u0000\u0000\u0012a\u0001\u0000\u0000\u0000\u0014q\u0001\u0000\u0000\u0000"+
		"\u0016w\u0001\u0000\u0000\u0000\u0018\u001a\u0003\u0002\u0001\u0000\u0019"+
		"\u0018\u0001\u0000\u0000\u0000\u001a\u001b\u0001\u0000\u0000\u0000\u001b"+
		"\u0019\u0001\u0000\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c"+
		"\u0001\u0001\u0000\u0000\u0000\u001d\u001f\u0005\u000e\u0000\u0000\u001e"+
		"\u001d\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f"+
		" \u0001\u0000\u0000\u0000 !\u0005!\u0000\u0000!%\u0005\u0004\u0000\u0000"+
		"\"$\u0003\u0004\u0002\u0000#\"\u0001\u0000\u0000\u0000$\'\u0001\u0000"+
		"\u0000\u0000%#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&(\u0001"+
		"\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000(+\u0005\u0005\u0000\u0000"+
		")*\u0005\u000e\u0000\u0000*,\u0005!\u0000\u0000+)\u0001\u0000\u0000\u0000"+
		"+,\u0001\u0000\u0000\u0000,\u0003\u0001\u0000\u0000\u0000-.\u0003\u0006"+
		"\u0003\u0000.\u0005\u0001\u0000\u0000\u0000/5\u0003\b\u0004\u000005\u0003"+
		"\n\u0005\u000015\u0003\f\u0006\u000025\u0003\u000e\u0007\u000035\u0003"+
		"\u0010\b\u00004/\u0001\u0000\u0000\u000040\u0001\u0000\u0000\u000041\u0001"+
		"\u0000\u0000\u000042\u0001\u0000\u0000\u000043\u0001\u0000\u0000\u0000"+
		"5<\u0001\u0000\u0000\u000067\u0005\u001e\u0000\u000078\u0003\u0012\t\u0000"+
		"89\u0005\u0019\u0000\u00009=\u0001\u0000\u0000\u0000:;\u0005\u0018\u0000"+
		"\u0000;=\u0003\u0012\t\u0000<6\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000"+
		"\u0000<=\u0001\u0000\u0000\u0000=\u0007\u0001\u0000\u0000\u0000>?\u0005"+
		"\u0015\u0000\u0000?\t\u0001\u0000\u0000\u0000@F\u0005\u001b\u0000\u0000"+
		"AB\u0005\u001f\u0000\u0000BC\u0005\u0013\u0000\u0000CG\u0003\u0014\n\u0000"+
		"DE\u0005 \u0000\u0000EG\u0005\"\u0000\u0000FA\u0001\u0000\u0000\u0000"+
		"FD\u0001\u0000\u0000\u0000G\u000b\u0001\u0000\u0000\u0000HJ\u0005\u001c"+
		"\u0000\u0000IK\u0007\u0000\u0000\u0000JI\u0001\u0000\u0000\u0000JK\u0001"+
		"\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LM\u0005 \u0000\u0000MN\u0003"+
		"\u0012\t\u0000N\r\u0001\u0000\u0000\u0000OP\u0005\u0017\u0000\u0000PQ"+
		"\u0003\u0012\t\u0000Q\u000f\u0001\u0000\u0000\u0000RS\u0005\u0016\u0000"+
		"\u0000ST\u0003\u0012\t\u0000T\u0011\u0001\u0000\u0000\u0000UV\u0006\t"+
		"\uffff\uffff\u0000VW\u0005\n\u0000\u0000Wb\u0003\u0012\t\bXb\u0005\"\u0000"+
		"\u0000YZ\u0005\u0012\u0000\u0000Zb\u0003\u0016\u000b\u0000[\\\u0005\u0013"+
		"\u0000\u0000\\b\u0003\u0014\n\u0000]^\u0005\b\u0000\u0000^_\u0003\u0012"+
		"\t\u0000_`\u0005\t\u0000\u0000`b\u0001\u0000\u0000\u0000aU\u0001\u0000"+
		"\u0000\u0000aX\u0001\u0000\u0000\u0000aY\u0001\u0000\u0000\u0000a[\u0001"+
		"\u0000\u0000\u0000a]\u0001\u0000\u0000\u0000bn\u0001\u0000\u0000\u0000"+
		"cd\n\u0007\u0000\u0000de\u0005\u0011\u0000\u0000em\u0003\u0012\t\bfg\n"+
		"\u0006\u0000\u0000gh\u0005\u000f\u0000\u0000hm\u0003\u0012\t\u0007ij\n"+
		"\u0005\u0000\u0000jk\u0005\u0010\u0000\u0000km\u0003\u0012\t\u0006lc\u0001"+
		"\u0000\u0000\u0000lf\u0001\u0000\u0000\u0000li\u0001\u0000\u0000\u0000"+
		"mp\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000"+
		"\u0000o\u0013\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000qr\u0005"+
		"\b\u0000\u0000rs\u0003\u0012\t\u0000st\u0005\f\u0000\u0000tu\u0003\u0012"+
		"\t\u0000uv\u0005\t\u0000\u0000v\u0015\u0001\u0000\u0000\u0000wx\u0005"+
		"\u0006\u0000\u0000xy\u0003\u0012\t\u0000yz\u0005\f\u0000\u0000z{\u0003"+
		"\u0012\t\u0000{|\u0005\u0007\u0000\u0000|\u0017\u0001\u0000\u0000\u0000"+
		"\u000b\u001b\u001e%+4<FJaln";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}