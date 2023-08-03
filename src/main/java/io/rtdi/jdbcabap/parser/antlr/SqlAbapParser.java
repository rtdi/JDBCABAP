// Generated from SqlAbap.g4 by ANTLR 4.12.0
package io.rtdi.jdbcabap.parser.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SqlAbapParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SCOL=1, DOT=2, OPEN_PAR=3, CLOSE_PAR=4, COMMA=5, STAR=6, PLUS=7, MINUS=8, 
		PIPE2=9, DIV=10, MOD=11, LT=12, LT_EQ=13, GT=14, GT_EQ=15, EQ=16, NOT_EQ=17, 
		AND_=18, AS_=19, ASC_=20, BETWEEN_=21, BY_=22, CASE_=23, COLUMN_=24, COMMIT_=25, 
		CREATE_=26, CURRENT_DATE_=27, CURRENT_TIME_=28, CURRENT_TIMESTAMP_=29, 
		DESC_=30, DISTINCT_=31, ELSE_=32, END_=33, FOR_=34, FROM_=35, FULL_=36, 
		GROUP_=37, HAVING_=38, IF_=39, IN_=40, INNER_=41, IS_=42, ISNULL_=43, 
		JOIN_=44, KEY_=45, LEFT_=46, LIKE_=47, LIMIT_=48, NOT_=49, NULL_=50, OFFSET_=51, 
		ON_=52, OR_=53, ORDER_=54, OUTER_=55, RIGHT_=56, ROLLBACK_=57, SELECT_=58, 
		THEN_=59, WHEN_=60, WHERE_=61, IDENTIFIER=62, NUMERIC_LITERAL=63, STRING_LITERAL=64, 
		BLOB_LITERAL=65, SINGLE_LINE_COMMENT=66, MULTILINE_COMMENT=67, SPACES=68, 
		UNEXPECTED_CHAR=69;
	public static final int
		RULE_sql_stmt = 0, RULE_commitstmt = 1, RULE_rollbackstmt = 2, RULE_signednumber = 3, 
		RULE_expr = 4, RULE_exprconstantstring = 5, RULE_exprconstantnum = 6, 
		RULE_exprnull = 7, RULE_whereclause = 8, RULE_whereandorop = 9, RULE_whereop = 10, 
		RULE_wherecondition = 11, RULE_whereconditioncomp = 12, RULE_whereconditionbrackets = 13, 
		RULE_whereexprl = 14, RULE_whereexprr = 15, RULE_wheretablenamel = 16, 
		RULE_wherecolumnnamel = 17, RULE_wheretablenamer = 18, RULE_wherecolumnnamer = 19, 
		RULE_exprlimit = 20, RULE_exproffset = 21, RULE_literalvalue = 22, RULE_wherevaluel = 23, 
		RULE_wherevaluer = 24, RULE_selectstmt = 25, RULE_joinclause = 26, RULE_tableclause = 27, 
		RULE_selectcore = 28, RULE_simpleselectstmt = 29, RULE_starcolumn = 30, 
		RULE_resultcolumn = 31, RULE_joinoperator = 32, RULE_joinconstraint = 33, 
		RULE_qualifiedtablename = 34, RULE_orderbystmt = 35, RULE_limitstmt = 36, 
		RULE_orderingterm = 37, RULE_ascdesc = 38, RULE_initialselect = 39, RULE_unaryoperator = 40, 
		RULE_columnalias = 41, RULE_keyword = 42, RULE_name = 43, RULE_tablename = 44, 
		RULE_columnname = 45, RULE_tablealias = 46, RULE_alias = 47, RULE_any_name = 48;
	private static String[] makeRuleNames() {
		return new String[] {
			"sql_stmt", "commitstmt", "rollbackstmt", "signednumber", "expr", "exprconstantstring", 
			"exprconstantnum", "exprnull", "whereclause", "whereandorop", "whereop", 
			"wherecondition", "whereconditioncomp", "whereconditionbrackets", "whereexprl", 
			"whereexprr", "wheretablenamel", "wherecolumnnamel", "wheretablenamer", 
			"wherecolumnnamer", "exprlimit", "exproffset", "literalvalue", "wherevaluel", 
			"wherevaluer", "selectstmt", "joinclause", "tableclause", "selectcore", 
			"simpleselectstmt", "starcolumn", "resultcolumn", "joinoperator", "joinconstraint", 
			"qualifiedtablename", "orderbystmt", "limitstmt", "orderingterm", "ascdesc", 
			"initialselect", "unaryoperator", "columnalias", "keyword", "name", "tablename", 
			"columnname", "tablealias", "alias", "any_name"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'.'", "'('", "')'", "','", "'*'", "'+'", "'-'", "'||'", 
			"'/'", "'%'", "'<'", "'<='", "'>'", "'>='", "'='", "'<>'", "'AND'", "'AS'", 
			"'ASC'", "'BETWEEN'", "'BY'", "'CASE'", "'COLUMN'", "'COMMIT'", "'CREATE'", 
			"'CURRENT_DATE'", "'CURRENT_TIME'", "'CURRENT_TIMESTAMP'", "'DESC'", 
			"'DISTINCT'", "'ELSE'", "'END'", "'FOR'", "'FROM'", "'FULL'", "'GROUP'", 
			"'HAVING'", "'IF'", "'IN'", "'INNER'", "'IS'", "'ISNULL'", "'JOIN'", 
			"'KEY'", "'LEFT'", "'LIKE'", "'LIMIT'", "'NOT'", "'NULL'", "'OFFSET'", 
			"'ON'", "'OR'", "'ORDER'", "'OUTER'", "'RIGHT'", "'ROLLBACK'", "'SELECT'", 
			"'THEN'", "'WHEN'", "'WHERE'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SCOL", "DOT", "OPEN_PAR", "CLOSE_PAR", "COMMA", "STAR", "PLUS", 
			"MINUS", "PIPE2", "DIV", "MOD", "LT", "LT_EQ", "GT", "GT_EQ", "EQ", "NOT_EQ", 
			"AND_", "AS_", "ASC_", "BETWEEN_", "BY_", "CASE_", "COLUMN_", "COMMIT_", 
			"CREATE_", "CURRENT_DATE_", "CURRENT_TIME_", "CURRENT_TIMESTAMP_", "DESC_", 
			"DISTINCT_", "ELSE_", "END_", "FOR_", "FROM_", "FULL_", "GROUP_", "HAVING_", 
			"IF_", "IN_", "INNER_", "IS_", "ISNULL_", "JOIN_", "KEY_", "LEFT_", "LIKE_", 
			"LIMIT_", "NOT_", "NULL_", "OFFSET_", "ON_", "OR_", "ORDER_", "OUTER_", 
			"RIGHT_", "ROLLBACK_", "SELECT_", "THEN_", "WHEN_", "WHERE_", "IDENTIFIER", 
			"NUMERIC_LITERAL", "STRING_LITERAL", "BLOB_LITERAL", "SINGLE_LINE_COMMENT", 
			"MULTILINE_COMMENT", "SPACES", "UNEXPECTED_CHAR"
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
	public String getGrammarFileName() { return "SqlAbap.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SqlAbapParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Sql_stmtContext extends ParserRuleContext {
		public CommitstmtContext commitstmt() {
			return getRuleContext(CommitstmtContext.class,0);
		}
		public RollbackstmtContext rollbackstmt() {
			return getRuleContext(RollbackstmtContext.class,0);
		}
		public SelectstmtContext selectstmt() {
			return getRuleContext(SelectstmtContext.class,0);
		}
		public Sql_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterSql_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitSql_stmt(this);
		}
	}

	public final Sql_stmtContext sql_stmt() throws RecognitionException {
		Sql_stmtContext _localctx = new Sql_stmtContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sql_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
				{
				}
				break;
			case COMMIT_:
				{
				setState(99);
				commitstmt();
				}
				break;
			case ROLLBACK_:
				{
				setState(100);
				rollbackstmt();
				}
				break;
			case SELECT_:
				{
				setState(101);
				selectstmt();
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
	public static class CommitstmtContext extends ParserRuleContext {
		public TerminalNode COMMIT_() { return getToken(SqlAbapParser.COMMIT_, 0); }
		public CommitstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commitstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterCommitstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitCommitstmt(this);
		}
	}

	public final CommitstmtContext commitstmt() throws RecognitionException {
		CommitstmtContext _localctx = new CommitstmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_commitstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(COMMIT_);
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
	public static class RollbackstmtContext extends ParserRuleContext {
		public TerminalNode ROLLBACK_() { return getToken(SqlAbapParser.ROLLBACK_, 0); }
		public RollbackstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rollbackstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterRollbackstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitRollbackstmt(this);
		}
	}

	public final RollbackstmtContext rollbackstmt() throws RecognitionException {
		RollbackstmtContext _localctx = new RollbackstmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_rollbackstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(ROLLBACK_);
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
	public static class SignednumberContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(SqlAbapParser.NUMERIC_LITERAL, 0); }
		public TerminalNode PLUS() { return getToken(SqlAbapParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SqlAbapParser.MINUS, 0); }
		public SignednumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signednumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterSignednumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitSignednumber(this);
		}
	}

	public final SignednumberContext signednumber() throws RecognitionException {
		SignednumberContext _localctx = new SignednumberContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_signednumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(108);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(111);
			match(NUMERIC_LITERAL);
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
	public static class ExprContext extends ParserRuleContext {
		public ExprconstantnumContext exprconstantnum() {
			return getRuleContext(ExprconstantnumContext.class,0);
		}
		public ExprconstantstringContext exprconstantstring() {
			return getRuleContext(ExprconstantstringContext.class,0);
		}
		public ExprnullContext exprnull() {
			return getRuleContext(ExprnullContext.class,0);
		}
		public ColumnnameContext columnname() {
			return getRuleContext(ColumnnameContext.class,0);
		}
		public TablenameContext tablename() {
			return getRuleContext(TablenameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SqlAbapParser.DOT, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expr);
		try {
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				exprconstantnum();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				exprconstantstring();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(115);
				exprnull();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(119);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(116);
					tablename();
					setState(117);
					match(DOT);
					}
					break;
				}
				setState(121);
				columnname();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprconstantstringContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(SqlAbapParser.STRING_LITERAL, 0); }
		public ExprconstantstringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprconstantstring; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterExprconstantstring(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitExprconstantstring(this);
		}
	}

	public final ExprconstantstringContext exprconstantstring() throws RecognitionException {
		ExprconstantstringContext _localctx = new ExprconstantstringContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_exprconstantstring);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(STRING_LITERAL);
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
	public static class ExprconstantnumContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(SqlAbapParser.NUMERIC_LITERAL, 0); }
		public ExprconstantnumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprconstantnum; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterExprconstantnum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitExprconstantnum(this);
		}
	}

	public final ExprconstantnumContext exprconstantnum() throws RecognitionException {
		ExprconstantnumContext _localctx = new ExprconstantnumContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_exprconstantnum);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(NUMERIC_LITERAL);
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
	public static class ExprnullContext extends ParserRuleContext {
		public TerminalNode NULL_() { return getToken(SqlAbapParser.NULL_, 0); }
		public ExprnullContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprnull; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterExprnull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitExprnull(this);
		}
	}

	public final ExprnullContext exprnull() throws RecognitionException {
		ExprnullContext _localctx = new ExprnullContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_exprnull);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(NULL_);
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
	public static class WhereclauseContext extends ParserRuleContext {
		public List<WhereconditionContext> wherecondition() {
			return getRuleContexts(WhereconditionContext.class);
		}
		public WhereconditionContext wherecondition(int i) {
			return getRuleContext(WhereconditionContext.class,i);
		}
		public List<WhereandoropContext> whereandorop() {
			return getRuleContexts(WhereandoropContext.class);
		}
		public WhereandoropContext whereandorop(int i) {
			return getRuleContext(WhereandoropContext.class,i);
		}
		public WhereclauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereclause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterWhereclause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitWhereclause(this);
		}
	}

	public final WhereclauseContext whereclause() throws RecognitionException {
		WhereclauseContext _localctx = new WhereclauseContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_whereclause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			wherecondition();
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND_ || _la==OR_) {
				{
				{
				setState(131);
				whereandorop();
				setState(132);
				wherecondition();
				}
				}
				setState(138);
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhereandoropContext extends ParserRuleContext {
		public TerminalNode AND_() { return getToken(SqlAbapParser.AND_, 0); }
		public TerminalNode OR_() { return getToken(SqlAbapParser.OR_, 0); }
		public WhereandoropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereandorop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterWhereandorop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitWhereandorop(this);
		}
	}

	public final WhereandoropContext whereandorop() throws RecognitionException {
		WhereandoropContext _localctx = new WhereandoropContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_whereandorop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			_la = _input.LA(1);
			if ( !(_la==AND_ || _la==OR_) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhereopContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(SqlAbapParser.EQ, 0); }
		public TerminalNode NOT_EQ() { return getToken(SqlAbapParser.NOT_EQ, 0); }
		public TerminalNode LT() { return getToken(SqlAbapParser.LT, 0); }
		public TerminalNode LT_EQ() { return getToken(SqlAbapParser.LT_EQ, 0); }
		public TerminalNode GT() { return getToken(SqlAbapParser.GT, 0); }
		public TerminalNode GT_EQ() { return getToken(SqlAbapParser.GT_EQ, 0); }
		public TerminalNode LIKE_() { return getToken(SqlAbapParser.LIKE_, 0); }
		public TerminalNode NOT_() { return getToken(SqlAbapParser.NOT_, 0); }
		public WhereopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterWhereop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitWhereop(this);
		}
	}

	public final WhereopContext whereop() throws RecognitionException {
		WhereopContext _localctx = new WhereopContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_whereop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EQ:
				{
				setState(141);
				match(EQ);
				}
				break;
			case NOT_EQ:
				{
				setState(142);
				match(NOT_EQ);
				}
				break;
			case LT:
				{
				setState(143);
				match(LT);
				}
				break;
			case LT_EQ:
				{
				setState(144);
				match(LT_EQ);
				}
				break;
			case GT:
				{
				setState(145);
				match(GT);
				}
				break;
			case GT_EQ:
				{
				setState(146);
				match(GT_EQ);
				}
				break;
			case LIKE_:
			case NOT_:
				{
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT_) {
					{
					setState(147);
					match(NOT_);
					}
				}

				setState(150);
				match(LIKE_);
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
	public static class WhereconditionContext extends ParserRuleContext {
		public WhereconditionbracketsContext whereconditionbrackets() {
			return getRuleContext(WhereconditionbracketsContext.class,0);
		}
		public WhereconditioncompContext whereconditioncomp() {
			return getRuleContext(WhereconditioncompContext.class,0);
		}
		public WhereconditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wherecondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterWherecondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitWherecondition(this);
		}
	}

	public final WhereconditionContext wherecondition() throws RecognitionException {
		WhereconditionContext _localctx = new WhereconditionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_wherecondition);
		try {
			setState(155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				whereconditionbrackets();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				whereconditioncomp();
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhereconditioncompContext extends ParserRuleContext {
		public WhereexprlContext whereexprl() {
			return getRuleContext(WhereexprlContext.class,0);
		}
		public WhereopContext whereop() {
			return getRuleContext(WhereopContext.class,0);
		}
		public WhereexprrContext whereexprr() {
			return getRuleContext(WhereexprrContext.class,0);
		}
		public WhereconditioncompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereconditioncomp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterWhereconditioncomp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitWhereconditioncomp(this);
		}
	}

	public final WhereconditioncompContext whereconditioncomp() throws RecognitionException {
		WhereconditioncompContext _localctx = new WhereconditioncompContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_whereconditioncomp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			whereexprl();
			setState(158);
			whereop();
			setState(159);
			whereexprr();
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
	public static class WhereconditionbracketsContext extends ParserRuleContext {
		public TerminalNode OPEN_PAR() { return getToken(SqlAbapParser.OPEN_PAR, 0); }
		public WhereclauseContext whereclause() {
			return getRuleContext(WhereclauseContext.class,0);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SqlAbapParser.CLOSE_PAR, 0); }
		public WhereconditionbracketsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereconditionbrackets; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterWhereconditionbrackets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitWhereconditionbrackets(this);
		}
	}

	public final WhereconditionbracketsContext whereconditionbrackets() throws RecognitionException {
		WhereconditionbracketsContext _localctx = new WhereconditionbracketsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_whereconditionbrackets);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(OPEN_PAR);
			setState(162);
			whereclause();
			setState(163);
			match(CLOSE_PAR);
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
	public static class WhereexprlContext extends ParserRuleContext {
		public WherevaluelContext wherevaluel() {
			return getRuleContext(WherevaluelContext.class,0);
		}
		public WherecolumnnamelContext wherecolumnnamel() {
			return getRuleContext(WherecolumnnamelContext.class,0);
		}
		public WheretablenamelContext wheretablenamel() {
			return getRuleContext(WheretablenamelContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SqlAbapParser.DOT, 0); }
		public WhereexprlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereexprl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterWhereexprl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitWhereexprl(this);
		}
	}

	public final WhereexprlContext whereexprl() throws RecognitionException {
		WhereexprlContext _localctx = new WhereexprlContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_whereexprl);
		try {
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				wherevaluel();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(166);
					wheretablenamel();
					setState(167);
					match(DOT);
					}
					break;
				}
				setState(171);
				wherecolumnnamel();
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhereexprrContext extends ParserRuleContext {
		public WherevaluerContext wherevaluer() {
			return getRuleContext(WherevaluerContext.class,0);
		}
		public WherecolumnnamerContext wherecolumnnamer() {
			return getRuleContext(WherecolumnnamerContext.class,0);
		}
		public WheretablenamerContext wheretablenamer() {
			return getRuleContext(WheretablenamerContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SqlAbapParser.DOT, 0); }
		public WhereexprrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereexprr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterWhereexprr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitWhereexprr(this);
		}
	}

	public final WhereexprrContext whereexprr() throws RecognitionException {
		WhereexprrContext _localctx = new WhereexprrContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_whereexprr);
		try {
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				wherevaluer();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(175);
					wheretablenamer();
					setState(176);
					match(DOT);
					}
					break;
				}
				setState(180);
				wherecolumnnamer();
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

	@SuppressWarnings("CheckReturnValue")
	public static class WheretablenamelContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public WheretablenamelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wheretablenamel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterWheretablenamel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitWheretablenamel(this);
		}
	}

	public final WheretablenamelContext wheretablenamel() throws RecognitionException {
		WheretablenamelContext _localctx = new WheretablenamelContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_wheretablenamel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			any_name();
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
	public static class WherecolumnnamelContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public WherecolumnnamelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wherecolumnnamel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterWherecolumnnamel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitWherecolumnnamel(this);
		}
	}

	public final WherecolumnnamelContext wherecolumnnamel() throws RecognitionException {
		WherecolumnnamelContext _localctx = new WherecolumnnamelContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_wherecolumnnamel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			any_name();
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
	public static class WheretablenamerContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public WheretablenamerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wheretablenamer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterWheretablenamer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitWheretablenamer(this);
		}
	}

	public final WheretablenamerContext wheretablenamer() throws RecognitionException {
		WheretablenamerContext _localctx = new WheretablenamerContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_wheretablenamer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			any_name();
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
	public static class WherecolumnnamerContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public WherecolumnnamerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wherecolumnnamer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterWherecolumnnamer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitWherecolumnnamer(this);
		}
	}

	public final WherecolumnnamerContext wherecolumnnamer() throws RecognitionException {
		WherecolumnnamerContext _localctx = new WherecolumnnamerContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_wherecolumnnamer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			any_name();
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
	public static class ExprlimitContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(SqlAbapParser.NUMERIC_LITERAL, 0); }
		public ExprlimitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprlimit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterExprlimit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitExprlimit(this);
		}
	}

	public final ExprlimitContext exprlimit() throws RecognitionException {
		ExprlimitContext _localctx = new ExprlimitContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_exprlimit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(NUMERIC_LITERAL);
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
	public static class ExproffsetContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(SqlAbapParser.NUMERIC_LITERAL, 0); }
		public ExproffsetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exproffset; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterExproffset(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitExproffset(this);
		}
	}

	public final ExproffsetContext exproffset() throws RecognitionException {
		ExproffsetContext _localctx = new ExproffsetContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_exproffset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(NUMERIC_LITERAL);
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
	public static class LiteralvalueContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(SqlAbapParser.NUMERIC_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(SqlAbapParser.STRING_LITERAL, 0); }
		public LiteralvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalvalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterLiteralvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitLiteralvalue(this);
		}
	}

	public final LiteralvalueContext literalvalue() throws RecognitionException {
		LiteralvalueContext _localctx = new LiteralvalueContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_literalvalue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			_la = _input.LA(1);
			if ( !(_la==NUMERIC_LITERAL || _la==STRING_LITERAL) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class WherevaluelContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(SqlAbapParser.NUMERIC_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(SqlAbapParser.STRING_LITERAL, 0); }
		public WherevaluelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wherevaluel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterWherevaluel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitWherevaluel(this);
		}
	}

	public final WherevaluelContext wherevaluel() throws RecognitionException {
		WherevaluelContext _localctx = new WherevaluelContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_wherevaluel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			_la = _input.LA(1);
			if ( !(_la==NUMERIC_LITERAL || _la==STRING_LITERAL) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class WherevaluerContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(SqlAbapParser.NUMERIC_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(SqlAbapParser.STRING_LITERAL, 0); }
		public WherevaluerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wherevaluer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterWherevaluer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitWherevaluer(this);
		}
	}

	public final WherevaluerContext wherevaluer() throws RecognitionException {
		WherevaluerContext _localctx = new WherevaluerContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_wherevaluer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			_la = _input.LA(1);
			if ( !(_la==NUMERIC_LITERAL || _la==STRING_LITERAL) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class SelectstmtContext extends ParserRuleContext {
		public SelectcoreContext selectcore() {
			return getRuleContext(SelectcoreContext.class,0);
		}
		public OrderbystmtContext orderbystmt() {
			return getRuleContext(OrderbystmtContext.class,0);
		}
		public LimitstmtContext limitstmt() {
			return getRuleContext(LimitstmtContext.class,0);
		}
		public SelectstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterSelectstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitSelectstmt(this);
		}
	}

	public final SelectstmtContext selectstmt() throws RecognitionException {
		SelectstmtContext _localctx = new SelectstmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_selectstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			selectcore();
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ORDER_) {
				{
				setState(202);
				orderbystmt();
				}
			}

			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIMIT_) {
				{
				setState(205);
				limitstmt();
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

	@SuppressWarnings("CheckReturnValue")
	public static class JoinclauseContext extends ParserRuleContext {
		public List<TableclauseContext> tableclause() {
			return getRuleContexts(TableclauseContext.class);
		}
		public TableclauseContext tableclause(int i) {
			return getRuleContext(TableclauseContext.class,i);
		}
		public List<JoinoperatorContext> joinoperator() {
			return getRuleContexts(JoinoperatorContext.class);
		}
		public JoinoperatorContext joinoperator(int i) {
			return getRuleContext(JoinoperatorContext.class,i);
		}
		public List<JoinconstraintContext> joinconstraint() {
			return getRuleContexts(JoinconstraintContext.class);
		}
		public JoinconstraintContext joinconstraint(int i) {
			return getRuleContext(JoinconstraintContext.class,i);
		}
		public JoinclauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinclause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterJoinclause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitJoinclause(this);
		}
	}

	public final JoinclauseContext joinclause() throws RecognitionException {
		JoinclauseContext _localctx = new JoinclauseContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_joinclause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			tableclause();
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 90159953477664L) != 0)) {
				{
				{
				setState(209);
				joinoperator();
				setState(210);
				tableclause();
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ON_) {
					{
					setState(211);
					joinconstraint();
					}
				}

				}
				}
				setState(218);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TableclauseContext extends ParserRuleContext {
		public TablenameContext tablename() {
			return getRuleContext(TablenameContext.class,0);
		}
		public TablealiasContext tablealias() {
			return getRuleContext(TablealiasContext.class,0);
		}
		public TerminalNode AS_() { return getToken(SqlAbapParser.AS_, 0); }
		public TableclauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableclause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterTableclause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitTableclause(this);
		}
	}

	public final TableclauseContext tableclause() throws RecognitionException {
		TableclauseContext _localctx = new TableclauseContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_tableclause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			tablename();
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 3)) & ~0x3f) == 0 && ((1L << (_la - 3)) & 2882303761517182977L) != 0)) {
				{
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS_) {
					{
					setState(220);
					match(AS_);
					}
				}

				setState(223);
				tablealias();
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

	@SuppressWarnings("CheckReturnValue")
	public static class SelectcoreContext extends ParserRuleContext {
		public TerminalNode SELECT_() { return getToken(SqlAbapParser.SELECT_, 0); }
		public List<ResultcolumnContext> resultcolumn() {
			return getRuleContexts(ResultcolumnContext.class);
		}
		public ResultcolumnContext resultcolumn(int i) {
			return getRuleContext(ResultcolumnContext.class,i);
		}
		public TerminalNode DISTINCT_() { return getToken(SqlAbapParser.DISTINCT_, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SqlAbapParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlAbapParser.COMMA, i);
		}
		public TerminalNode FROM_() { return getToken(SqlAbapParser.FROM_, 0); }
		public TerminalNode WHERE_() { return getToken(SqlAbapParser.WHERE_, 0); }
		public WhereclauseContext whereclause() {
			return getRuleContext(WhereclauseContext.class,0);
		}
		public List<TableclauseContext> tableclause() {
			return getRuleContexts(TableclauseContext.class);
		}
		public TableclauseContext tableclause(int i) {
			return getRuleContext(TableclauseContext.class,i);
		}
		public JoinclauseContext joinclause() {
			return getRuleContext(JoinclauseContext.class,0);
		}
		public SelectcoreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectcore; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterSelectcore(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitSelectcore(this);
		}
	}

	public final SelectcoreContext selectcore() throws RecognitionException {
		SelectcoreContext _localctx = new SelectcoreContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_selectcore);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(226);
			match(SELECT_);
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DISTINCT_) {
				{
				setState(227);
				match(DISTINCT_);
				}
			}

			setState(230);
			resultcolumn();
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(231);
				match(COMMA);
				setState(232);
				resultcolumn();
				}
				}
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FROM_) {
				{
				setState(238);
				match(FROM_);
				setState(248);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(239);
					tableclause();
					setState(244);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(240);
						match(COMMA);
						setState(241);
						tableclause();
						}
						}
						setState(246);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 2:
					{
					setState(247);
					joinclause();
					}
					break;
				}
				}
			}

			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE_) {
				{
				setState(252);
				match(WHERE_);
				setState(253);
				whereclause();
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleselectstmtContext extends ParserRuleContext {
		public SelectcoreContext selectcore() {
			return getRuleContext(SelectcoreContext.class,0);
		}
		public OrderbystmtContext orderbystmt() {
			return getRuleContext(OrderbystmtContext.class,0);
		}
		public LimitstmtContext limitstmt() {
			return getRuleContext(LimitstmtContext.class,0);
		}
		public SimpleselectstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleselectstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterSimpleselectstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitSimpleselectstmt(this);
		}
	}

	public final SimpleselectstmtContext simpleselectstmt() throws RecognitionException {
		SimpleselectstmtContext _localctx = new SimpleselectstmtContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_simpleselectstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			selectcore();
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ORDER_) {
				{
				setState(257);
				orderbystmt();
				}
			}

			setState(261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIMIT_) {
				{
				setState(260);
				limitstmt();
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

	@SuppressWarnings("CheckReturnValue")
	public static class StarcolumnContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(SqlAbapParser.STAR, 0); }
		public StarcolumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_starcolumn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterStarcolumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitStarcolumn(this);
		}
	}

	public final StarcolumnContext starcolumn() throws RecognitionException {
		StarcolumnContext _localctx = new StarcolumnContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_starcolumn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(STAR);
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
	public static class ResultcolumnContext extends ParserRuleContext {
		public StarcolumnContext starcolumn() {
			return getRuleContext(StarcolumnContext.class,0);
		}
		public TablenameContext tablename() {
			return getRuleContext(TablenameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SqlAbapParser.DOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ColumnaliasContext columnalias() {
			return getRuleContext(ColumnaliasContext.class,0);
		}
		public TerminalNode AS_() { return getToken(SqlAbapParser.AS_, 0); }
		public ResultcolumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resultcolumn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterResultcolumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitResultcolumn(this);
		}
	}

	public final ResultcolumnContext resultcolumn() throws RecognitionException {
		ResultcolumnContext _localctx = new ResultcolumnContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_resultcolumn);
		int _la;
		try {
			setState(277);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(265);
				starcolumn();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(266);
				tablename();
				setState(267);
				match(DOT);
				setState(268);
				starcolumn();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(270);
				expr();
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 19)) & ~0x3f) == 0 && ((1L << (_la - 19)) & 43980465111041L) != 0)) {
					{
					setState(272);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==AS_) {
						{
						setState(271);
						match(AS_);
						}
					}

					setState(274);
					columnalias();
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

	@SuppressWarnings("CheckReturnValue")
	public static class JoinoperatorContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(SqlAbapParser.COMMA, 0); }
		public TerminalNode JOIN_() { return getToken(SqlAbapParser.JOIN_, 0); }
		public TerminalNode LEFT_() { return getToken(SqlAbapParser.LEFT_, 0); }
		public TerminalNode INNER_() { return getToken(SqlAbapParser.INNER_, 0); }
		public TerminalNode OUTER_() { return getToken(SqlAbapParser.OUTER_, 0); }
		public JoinoperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinoperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterJoinoperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitJoinoperator(this);
		}
	}

	public final JoinoperatorContext joinoperator() throws RecognitionException {
		JoinoperatorContext _localctx = new JoinoperatorContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_joinoperator);
		int _la;
		try {
			setState(288);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(279);
				match(COMMA);
				}
				break;
			case INNER_:
			case JOIN_:
			case LEFT_:
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LEFT_:
					{
					setState(280);
					match(LEFT_);
					setState(282);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==OUTER_) {
						{
						setState(281);
						match(OUTER_);
						}
					}

					}
					break;
				case INNER_:
					{
					setState(284);
					match(INNER_);
					}
					break;
				case JOIN_:
					break;
				default:
					break;
				}
				setState(287);
				match(JOIN_);
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

	@SuppressWarnings("CheckReturnValue")
	public static class JoinconstraintContext extends ParserRuleContext {
		public TerminalNode ON_() { return getToken(SqlAbapParser.ON_, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public JoinconstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinconstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterJoinconstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitJoinconstraint(this);
		}
	}

	public final JoinconstraintContext joinconstraint() throws RecognitionException {
		JoinconstraintContext _localctx = new JoinconstraintContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_joinconstraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(ON_);
			setState(291);
			expr();
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
	public static class QualifiedtablenameContext extends ParserRuleContext {
		public TablenameContext tablename() {
			return getRuleContext(TablenameContext.class,0);
		}
		public TerminalNode AS_() { return getToken(SqlAbapParser.AS_, 0); }
		public AliasContext alias() {
			return getRuleContext(AliasContext.class,0);
		}
		public QualifiedtablenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedtablename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterQualifiedtablename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitQualifiedtablename(this);
		}
	}

	public final QualifiedtablenameContext qualifiedtablename() throws RecognitionException {
		QualifiedtablenameContext _localctx = new QualifiedtablenameContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_qualifiedtablename);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			tablename();
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS_) {
				{
				setState(294);
				match(AS_);
				setState(295);
				alias();
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

	@SuppressWarnings("CheckReturnValue")
	public static class OrderbystmtContext extends ParserRuleContext {
		public TerminalNode ORDER_() { return getToken(SqlAbapParser.ORDER_, 0); }
		public TerminalNode BY_() { return getToken(SqlAbapParser.BY_, 0); }
		public List<OrderingtermContext> orderingterm() {
			return getRuleContexts(OrderingtermContext.class);
		}
		public OrderingtermContext orderingterm(int i) {
			return getRuleContext(OrderingtermContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlAbapParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlAbapParser.COMMA, i);
		}
		public OrderbystmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderbystmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterOrderbystmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitOrderbystmt(this);
		}
	}

	public final OrderbystmtContext orderbystmt() throws RecognitionException {
		OrderbystmtContext _localctx = new OrderbystmtContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_orderbystmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			match(ORDER_);
			setState(299);
			match(BY_);
			setState(300);
			orderingterm();
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(301);
				match(COMMA);
				setState(302);
				orderingterm();
				}
				}
				setState(307);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LimitstmtContext extends ParserRuleContext {
		public TerminalNode LIMIT_() { return getToken(SqlAbapParser.LIMIT_, 0); }
		public ExprlimitContext exprlimit() {
			return getRuleContext(ExprlimitContext.class,0);
		}
		public TerminalNode OFFSET_() { return getToken(SqlAbapParser.OFFSET_, 0); }
		public ExproffsetContext exproffset() {
			return getRuleContext(ExproffsetContext.class,0);
		}
		public LimitstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limitstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterLimitstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitLimitstmt(this);
		}
	}

	public final LimitstmtContext limitstmt() throws RecognitionException {
		LimitstmtContext _localctx = new LimitstmtContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_limitstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(LIMIT_);
			setState(309);
			exprlimit();
			setState(312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OFFSET_) {
				{
				setState(310);
				match(OFFSET_);
				setState(311);
				exproffset();
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

	@SuppressWarnings("CheckReturnValue")
	public static class OrderingtermContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AscdescContext ascdesc() {
			return getRuleContext(AscdescContext.class,0);
		}
		public OrderingtermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderingterm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterOrderingterm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitOrderingterm(this);
		}
	}

	public final OrderingtermContext orderingterm() throws RecognitionException {
		OrderingtermContext _localctx = new OrderingtermContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_orderingterm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			expr();
			setState(316);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASC_ || _la==DESC_) {
				{
				setState(315);
				ascdesc();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AscdescContext extends ParserRuleContext {
		public TerminalNode ASC_() { return getToken(SqlAbapParser.ASC_, 0); }
		public TerminalNode DESC_() { return getToken(SqlAbapParser.DESC_, 0); }
		public AscdescContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ascdesc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterAscdesc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitAscdesc(this);
		}
	}

	public final AscdescContext ascdesc() throws RecognitionException {
		AscdescContext _localctx = new AscdescContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_ascdesc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			_la = _input.LA(1);
			if ( !(_la==ASC_ || _la==DESC_) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class InitialselectContext extends ParserRuleContext {
		public SelectstmtContext selectstmt() {
			return getRuleContext(SelectstmtContext.class,0);
		}
		public InitialselectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initialselect; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterInitialselect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitInitialselect(this);
		}
	}

	public final InitialselectContext initialselect() throws RecognitionException {
		InitialselectContext _localctx = new InitialselectContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_initialselect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			selectstmt();
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
	public static class UnaryoperatorContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(SqlAbapParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(SqlAbapParser.PLUS, 0); }
		public TerminalNode NOT_() { return getToken(SqlAbapParser.NOT_, 0); }
		public UnaryoperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryoperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterUnaryoperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitUnaryoperator(this);
		}
	}

	public final UnaryoperatorContext unaryoperator() throws RecognitionException {
		UnaryoperatorContext _localctx = new UnaryoperatorContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_unaryoperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 562949953421696L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnaliasContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SqlAbapParser.IDENTIFIER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(SqlAbapParser.STRING_LITERAL, 0); }
		public ColumnaliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnalias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterColumnalias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitColumnalias(this);
		}
	}

	public final ColumnaliasContext columnalias() throws RecognitionException {
		ColumnaliasContext _localctx = new ColumnaliasContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_columnalias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==STRING_LITERAL) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class KeywordContext extends ParserRuleContext {
		public TerminalNode AND_() { return getToken(SqlAbapParser.AND_, 0); }
		public TerminalNode AS_() { return getToken(SqlAbapParser.AS_, 0); }
		public TerminalNode ASC_() { return getToken(SqlAbapParser.ASC_, 0); }
		public TerminalNode BETWEEN_() { return getToken(SqlAbapParser.BETWEEN_, 0); }
		public TerminalNode BY_() { return getToken(SqlAbapParser.BY_, 0); }
		public TerminalNode CASE_() { return getToken(SqlAbapParser.CASE_, 0); }
		public TerminalNode COLUMN_() { return getToken(SqlAbapParser.COLUMN_, 0); }
		public TerminalNode COMMIT_() { return getToken(SqlAbapParser.COMMIT_, 0); }
		public TerminalNode CREATE_() { return getToken(SqlAbapParser.CREATE_, 0); }
		public TerminalNode CURRENT_DATE_() { return getToken(SqlAbapParser.CURRENT_DATE_, 0); }
		public TerminalNode CURRENT_TIME_() { return getToken(SqlAbapParser.CURRENT_TIME_, 0); }
		public TerminalNode CURRENT_TIMESTAMP_() { return getToken(SqlAbapParser.CURRENT_TIMESTAMP_, 0); }
		public TerminalNode DESC_() { return getToken(SqlAbapParser.DESC_, 0); }
		public TerminalNode DISTINCT_() { return getToken(SqlAbapParser.DISTINCT_, 0); }
		public TerminalNode ELSE_() { return getToken(SqlAbapParser.ELSE_, 0); }
		public TerminalNode END_() { return getToken(SqlAbapParser.END_, 0); }
		public TerminalNode FOR_() { return getToken(SqlAbapParser.FOR_, 0); }
		public TerminalNode FROM_() { return getToken(SqlAbapParser.FROM_, 0); }
		public TerminalNode FULL_() { return getToken(SqlAbapParser.FULL_, 0); }
		public TerminalNode GROUP_() { return getToken(SqlAbapParser.GROUP_, 0); }
		public TerminalNode HAVING_() { return getToken(SqlAbapParser.HAVING_, 0); }
		public TerminalNode IF_() { return getToken(SqlAbapParser.IF_, 0); }
		public TerminalNode IN_() { return getToken(SqlAbapParser.IN_, 0); }
		public TerminalNode INNER_() { return getToken(SqlAbapParser.INNER_, 0); }
		public TerminalNode IS_() { return getToken(SqlAbapParser.IS_, 0); }
		public TerminalNode ISNULL_() { return getToken(SqlAbapParser.ISNULL_, 0); }
		public TerminalNode JOIN_() { return getToken(SqlAbapParser.JOIN_, 0); }
		public TerminalNode KEY_() { return getToken(SqlAbapParser.KEY_, 0); }
		public TerminalNode LEFT_() { return getToken(SqlAbapParser.LEFT_, 0); }
		public TerminalNode LIKE_() { return getToken(SqlAbapParser.LIKE_, 0); }
		public TerminalNode LIMIT_() { return getToken(SqlAbapParser.LIMIT_, 0); }
		public TerminalNode NOT_() { return getToken(SqlAbapParser.NOT_, 0); }
		public TerminalNode NULL_() { return getToken(SqlAbapParser.NULL_, 0); }
		public TerminalNode OFFSET_() { return getToken(SqlAbapParser.OFFSET_, 0); }
		public TerminalNode ON_() { return getToken(SqlAbapParser.ON_, 0); }
		public TerminalNode OR_() { return getToken(SqlAbapParser.OR_, 0); }
		public TerminalNode ORDER_() { return getToken(SqlAbapParser.ORDER_, 0); }
		public TerminalNode OUTER_() { return getToken(SqlAbapParser.OUTER_, 0); }
		public TerminalNode RIGHT_() { return getToken(SqlAbapParser.RIGHT_, 0); }
		public TerminalNode ROLLBACK_() { return getToken(SqlAbapParser.ROLLBACK_, 0); }
		public TerminalNode SELECT_() { return getToken(SqlAbapParser.SELECT_, 0); }
		public TerminalNode THEN_() { return getToken(SqlAbapParser.THEN_, 0); }
		public TerminalNode WHEN_() { return getToken(SqlAbapParser.WHEN_, 0); }
		public TerminalNode WHERE_() { return getToken(SqlAbapParser.WHERE_, 0); }
		public KeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitKeyword(this);
		}
	}

	public final KeywordContext keyword() throws RecognitionException {
		KeywordContext _localctx = new KeywordContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_keyword);
		try {
			setState(371);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case AND_:
				enterOuterAlt(_localctx, 2);
				{
				setState(327);
				match(AND_);
				}
				break;
			case AS_:
				enterOuterAlt(_localctx, 3);
				{
				setState(328);
				match(AS_);
				}
				break;
			case ASC_:
				enterOuterAlt(_localctx, 4);
				{
				setState(329);
				match(ASC_);
				}
				break;
			case BETWEEN_:
				enterOuterAlt(_localctx, 5);
				{
				setState(330);
				match(BETWEEN_);
				}
				break;
			case BY_:
				enterOuterAlt(_localctx, 6);
				{
				setState(331);
				match(BY_);
				}
				break;
			case CASE_:
				enterOuterAlt(_localctx, 7);
				{
				setState(332);
				match(CASE_);
				}
				break;
			case COLUMN_:
				enterOuterAlt(_localctx, 8);
				{
				setState(333);
				match(COLUMN_);
				}
				break;
			case COMMIT_:
				enterOuterAlt(_localctx, 9);
				{
				setState(334);
				match(COMMIT_);
				}
				break;
			case CREATE_:
				enterOuterAlt(_localctx, 10);
				{
				setState(335);
				match(CREATE_);
				}
				break;
			case CURRENT_DATE_:
				enterOuterAlt(_localctx, 11);
				{
				setState(336);
				match(CURRENT_DATE_);
				}
				break;
			case CURRENT_TIME_:
				enterOuterAlt(_localctx, 12);
				{
				setState(337);
				match(CURRENT_TIME_);
				}
				break;
			case CURRENT_TIMESTAMP_:
				enterOuterAlt(_localctx, 13);
				{
				setState(338);
				match(CURRENT_TIMESTAMP_);
				}
				break;
			case DESC_:
				enterOuterAlt(_localctx, 14);
				{
				setState(339);
				match(DESC_);
				}
				break;
			case DISTINCT_:
				enterOuterAlt(_localctx, 15);
				{
				setState(340);
				match(DISTINCT_);
				}
				break;
			case ELSE_:
				enterOuterAlt(_localctx, 16);
				{
				setState(341);
				match(ELSE_);
				}
				break;
			case END_:
				enterOuterAlt(_localctx, 17);
				{
				setState(342);
				match(END_);
				}
				break;
			case FOR_:
				enterOuterAlt(_localctx, 18);
				{
				setState(343);
				match(FOR_);
				}
				break;
			case FROM_:
				enterOuterAlt(_localctx, 19);
				{
				setState(344);
				match(FROM_);
				}
				break;
			case FULL_:
				enterOuterAlt(_localctx, 20);
				{
				setState(345);
				match(FULL_);
				}
				break;
			case GROUP_:
				enterOuterAlt(_localctx, 21);
				{
				setState(346);
				match(GROUP_);
				}
				break;
			case HAVING_:
				enterOuterAlt(_localctx, 22);
				{
				setState(347);
				match(HAVING_);
				}
				break;
			case IF_:
				enterOuterAlt(_localctx, 23);
				{
				setState(348);
				match(IF_);
				}
				break;
			case IN_:
				enterOuterAlt(_localctx, 24);
				{
				setState(349);
				match(IN_);
				}
				break;
			case INNER_:
				enterOuterAlt(_localctx, 25);
				{
				setState(350);
				match(INNER_);
				}
				break;
			case IS_:
				enterOuterAlt(_localctx, 26);
				{
				setState(351);
				match(IS_);
				}
				break;
			case ISNULL_:
				enterOuterAlt(_localctx, 27);
				{
				setState(352);
				match(ISNULL_);
				}
				break;
			case JOIN_:
				enterOuterAlt(_localctx, 28);
				{
				setState(353);
				match(JOIN_);
				}
				break;
			case KEY_:
				enterOuterAlt(_localctx, 29);
				{
				setState(354);
				match(KEY_);
				}
				break;
			case LEFT_:
				enterOuterAlt(_localctx, 30);
				{
				setState(355);
				match(LEFT_);
				}
				break;
			case LIKE_:
				enterOuterAlt(_localctx, 31);
				{
				setState(356);
				match(LIKE_);
				}
				break;
			case LIMIT_:
				enterOuterAlt(_localctx, 32);
				{
				setState(357);
				match(LIMIT_);
				}
				break;
			case NOT_:
				enterOuterAlt(_localctx, 33);
				{
				setState(358);
				match(NOT_);
				}
				break;
			case NULL_:
				enterOuterAlt(_localctx, 34);
				{
				setState(359);
				match(NULL_);
				}
				break;
			case OFFSET_:
				enterOuterAlt(_localctx, 35);
				{
				setState(360);
				match(OFFSET_);
				}
				break;
			case ON_:
				enterOuterAlt(_localctx, 36);
				{
				setState(361);
				match(ON_);
				}
				break;
			case OR_:
				enterOuterAlt(_localctx, 37);
				{
				setState(362);
				match(OR_);
				}
				break;
			case ORDER_:
				enterOuterAlt(_localctx, 38);
				{
				setState(363);
				match(ORDER_);
				}
				break;
			case OUTER_:
				enterOuterAlt(_localctx, 39);
				{
				setState(364);
				match(OUTER_);
				}
				break;
			case RIGHT_:
				enterOuterAlt(_localctx, 40);
				{
				setState(365);
				match(RIGHT_);
				}
				break;
			case ROLLBACK_:
				enterOuterAlt(_localctx, 41);
				{
				setState(366);
				match(ROLLBACK_);
				}
				break;
			case SELECT_:
				enterOuterAlt(_localctx, 42);
				{
				setState(367);
				match(SELECT_);
				}
				break;
			case THEN_:
				enterOuterAlt(_localctx, 43);
				{
				setState(368);
				match(THEN_);
				}
				break;
			case WHEN_:
				enterOuterAlt(_localctx, 44);
				{
				setState(369);
				match(WHEN_);
				}
				break;
			case WHERE_:
				enterOuterAlt(_localctx, 45);
				{
				setState(370);
				match(WHERE_);
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

	@SuppressWarnings("CheckReturnValue")
	public static class NameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitName(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			any_name();
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
	public static class TablenameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public TablenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tablename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterTablename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitTablename(this);
		}
	}

	public final TablenameContext tablename() throws RecognitionException {
		TablenameContext _localctx = new TablenameContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_tablename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			any_name();
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
	public static class ColumnnameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public ColumnnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterColumnname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitColumnname(this);
		}
	}

	public final ColumnnameContext columnname() throws RecognitionException {
		ColumnnameContext _localctx = new ColumnnameContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_columnname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			any_name();
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
	public static class TablealiasContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public TablealiasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tablealias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterTablealias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitTablealias(this);
		}
	}

	public final TablealiasContext tablealias() throws RecognitionException {
		TablealiasContext _localctx = new TablealiasContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_tablealias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			any_name();
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
	public static class AliasContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public AliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterAlias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitAlias(this);
		}
	}

	public final AliasContext alias() throws RecognitionException {
		AliasContext _localctx = new AliasContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			any_name();
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
	public static class Any_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SqlAbapParser.IDENTIFIER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(SqlAbapParser.STRING_LITERAL, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SqlAbapParser.OPEN_PAR, 0); }
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SqlAbapParser.CLOSE_PAR, 0); }
		public Any_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_any_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).enterAny_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlAbapListener ) ((SqlAbapListener)listener).exitAny_name(this);
		}
	}

	public final Any_nameContext any_name() throws RecognitionException {
		Any_nameContext _localctx = new Any_nameContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_any_name);
		try {
			setState(389);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(383);
				match(IDENTIFIER);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(384);
				match(STRING_LITERAL);
				}
				break;
			case OPEN_PAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(385);
				match(OPEN_PAR);
				setState(386);
				any_name();
				setState(387);
				match(CLOSE_PAR);
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
		"\u0004\u0001E\u0188\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0003\u0000g\b\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0003\u0003n\b\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004x\b\u0004\u0001\u0004\u0003\u0004{\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0005\b\u0087\b\b\n\b\f\b\u008a\t\b\u0001\t"+
		"\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\n\u0095\b\n\u0001\n\u0003\n\u0098\b\n\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u009c\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00aa"+
		"\b\u000e\u0001\u000e\u0003\u000e\u00ad\b\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0003\u000f\u00b3\b\u000f\u0001\u000f\u0003\u000f"+
		"\u00b6\b\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0019\u0001\u0019\u0003\u0019\u00cc\b\u0019\u0001\u0019"+
		"\u0003\u0019\u00cf\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0003\u001a\u00d5\b\u001a\u0005\u001a\u00d7\b\u001a\n\u001a\f\u001a\u00da"+
		"\t\u001a\u0001\u001b\u0001\u001b\u0003\u001b\u00de\b\u001b\u0001\u001b"+
		"\u0003\u001b\u00e1\b\u001b\u0001\u001c\u0001\u001c\u0003\u001c\u00e5\b"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u00ea\b\u001c\n"+
		"\u001c\f\u001c\u00ed\t\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0005\u001c\u00f3\b\u001c\n\u001c\f\u001c\u00f6\t\u001c\u0001\u001c"+
		"\u0003\u001c\u00f9\b\u001c\u0003\u001c\u00fb\b\u001c\u0001\u001c\u0001"+
		"\u001c\u0003\u001c\u00ff\b\u001c\u0001\u001d\u0001\u001d\u0003\u001d\u0103"+
		"\b\u001d\u0001\u001d\u0003\u001d\u0106\b\u001d\u0001\u001e\u0001\u001e"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0003\u001f\u0111\b\u001f\u0001\u001f\u0003\u001f\u0114\b"+
		"\u001f\u0003\u001f\u0116\b\u001f\u0001 \u0001 \u0001 \u0003 \u011b\b "+
		"\u0001 \u0003 \u011e\b \u0001 \u0003 \u0121\b \u0001!\u0001!\u0001!\u0001"+
		"\"\u0001\"\u0001\"\u0003\"\u0129\b\"\u0001#\u0001#\u0001#\u0001#\u0001"+
		"#\u0005#\u0130\b#\n#\f#\u0133\t#\u0001$\u0001$\u0001$\u0001$\u0003$\u0139"+
		"\b$\u0001%\u0001%\u0003%\u013d\b%\u0001&\u0001&\u0001\'\u0001\'\u0001"+
		"(\u0001(\u0001)\u0001)\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001"+
		"*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001"+
		"*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001"+
		"*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001"+
		"*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0003*\u0174"+
		"\b*\u0001+\u0001+\u0001,\u0001,\u0001-\u0001-\u0001.\u0001.\u0001/\u0001"+
		"/\u00010\u00010\u00010\u00010\u00010\u00010\u00030\u0186\b0\u00010\u0000"+
		"\u00001\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`\u0000\u0006\u0001"+
		"\u0000\u0007\b\u0002\u0000\u0012\u001255\u0001\u0000?@\u0002\u0000\u0014"+
		"\u0014\u001e\u001e\u0002\u0000\u0007\b11\u0002\u0000>>@@\u01b3\u0000f"+
		"\u0001\u0000\u0000\u0000\u0002h\u0001\u0000\u0000\u0000\u0004j\u0001\u0000"+
		"\u0000\u0000\u0006m\u0001\u0000\u0000\u0000\bz\u0001\u0000\u0000\u0000"+
		"\n|\u0001\u0000\u0000\u0000\f~\u0001\u0000\u0000\u0000\u000e\u0080\u0001"+
		"\u0000\u0000\u0000\u0010\u0082\u0001\u0000\u0000\u0000\u0012\u008b\u0001"+
		"\u0000\u0000\u0000\u0014\u0097\u0001\u0000\u0000\u0000\u0016\u009b\u0001"+
		"\u0000\u0000\u0000\u0018\u009d\u0001\u0000\u0000\u0000\u001a\u00a1\u0001"+
		"\u0000\u0000\u0000\u001c\u00ac\u0001\u0000\u0000\u0000\u001e\u00b5\u0001"+
		"\u0000\u0000\u0000 \u00b7\u0001\u0000\u0000\u0000\"\u00b9\u0001\u0000"+
		"\u0000\u0000$\u00bb\u0001\u0000\u0000\u0000&\u00bd\u0001\u0000\u0000\u0000"+
		"(\u00bf\u0001\u0000\u0000\u0000*\u00c1\u0001\u0000\u0000\u0000,\u00c3"+
		"\u0001\u0000\u0000\u0000.\u00c5\u0001\u0000\u0000\u00000\u00c7\u0001\u0000"+
		"\u0000\u00002\u00c9\u0001\u0000\u0000\u00004\u00d0\u0001\u0000\u0000\u0000"+
		"6\u00db\u0001\u0000\u0000\u00008\u00e2\u0001\u0000\u0000\u0000:\u0100"+
		"\u0001\u0000\u0000\u0000<\u0107\u0001\u0000\u0000\u0000>\u0115\u0001\u0000"+
		"\u0000\u0000@\u0120\u0001\u0000\u0000\u0000B\u0122\u0001\u0000\u0000\u0000"+
		"D\u0125\u0001\u0000\u0000\u0000F\u012a\u0001\u0000\u0000\u0000H\u0134"+
		"\u0001\u0000\u0000\u0000J\u013a\u0001\u0000\u0000\u0000L\u013e\u0001\u0000"+
		"\u0000\u0000N\u0140\u0001\u0000\u0000\u0000P\u0142\u0001\u0000\u0000\u0000"+
		"R\u0144\u0001\u0000\u0000\u0000T\u0173\u0001\u0000\u0000\u0000V\u0175"+
		"\u0001\u0000\u0000\u0000X\u0177\u0001\u0000\u0000\u0000Z\u0179\u0001\u0000"+
		"\u0000\u0000\\\u017b\u0001\u0000\u0000\u0000^\u017d\u0001\u0000\u0000"+
		"\u0000`\u0185\u0001\u0000\u0000\u0000bg\u0001\u0000\u0000\u0000cg\u0003"+
		"\u0002\u0001\u0000dg\u0003\u0004\u0002\u0000eg\u00032\u0019\u0000fb\u0001"+
		"\u0000\u0000\u0000fc\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000"+
		"fe\u0001\u0000\u0000\u0000g\u0001\u0001\u0000\u0000\u0000hi\u0005\u0019"+
		"\u0000\u0000i\u0003\u0001\u0000\u0000\u0000jk\u00059\u0000\u0000k\u0005"+
		"\u0001\u0000\u0000\u0000ln\u0007\u0000\u0000\u0000ml\u0001\u0000\u0000"+
		"\u0000mn\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000op\u0005?\u0000"+
		"\u0000p\u0007\u0001\u0000\u0000\u0000q{\u0003\f\u0006\u0000r{\u0003\n"+
		"\u0005\u0000s{\u0003\u000e\u0007\u0000tu\u0003X,\u0000uv\u0005\u0002\u0000"+
		"\u0000vx\u0001\u0000\u0000\u0000wt\u0001\u0000\u0000\u0000wx\u0001\u0000"+
		"\u0000\u0000xy\u0001\u0000\u0000\u0000y{\u0003Z-\u0000zq\u0001\u0000\u0000"+
		"\u0000zr\u0001\u0000\u0000\u0000zs\u0001\u0000\u0000\u0000zw\u0001\u0000"+
		"\u0000\u0000{\t\u0001\u0000\u0000\u0000|}\u0005@\u0000\u0000}\u000b\u0001"+
		"\u0000\u0000\u0000~\u007f\u0005?\u0000\u0000\u007f\r\u0001\u0000\u0000"+
		"\u0000\u0080\u0081\u00052\u0000\u0000\u0081\u000f\u0001\u0000\u0000\u0000"+
		"\u0082\u0088\u0003\u0016\u000b\u0000\u0083\u0084\u0003\u0012\t\u0000\u0084"+
		"\u0085\u0003\u0016\u000b\u0000\u0085\u0087\u0001\u0000\u0000\u0000\u0086"+
		"\u0083\u0001\u0000\u0000\u0000\u0087\u008a\u0001\u0000\u0000\u0000\u0088"+
		"\u0086\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089"+
		"\u0011\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008b"+
		"\u008c\u0007\u0001\u0000\u0000\u008c\u0013\u0001\u0000\u0000\u0000\u008d"+
		"\u0098\u0005\u0010\u0000\u0000\u008e\u0098\u0005\u0011\u0000\u0000\u008f"+
		"\u0098\u0005\f\u0000\u0000\u0090\u0098\u0005\r\u0000\u0000\u0091\u0098"+
		"\u0005\u000e\u0000\u0000\u0092\u0098\u0005\u000f\u0000\u0000\u0093\u0095"+
		"\u00051\u0000\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u0094\u0095\u0001"+
		"\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0098\u0005"+
		"/\u0000\u0000\u0097\u008d\u0001\u0000\u0000\u0000\u0097\u008e\u0001\u0000"+
		"\u0000\u0000\u0097\u008f\u0001\u0000\u0000\u0000\u0097\u0090\u0001\u0000"+
		"\u0000\u0000\u0097\u0091\u0001\u0000\u0000\u0000\u0097\u0092\u0001\u0000"+
		"\u0000\u0000\u0097\u0094\u0001\u0000\u0000\u0000\u0098\u0015\u0001\u0000"+
		"\u0000\u0000\u0099\u009c\u0003\u001a\r\u0000\u009a\u009c\u0003\u0018\f"+
		"\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009b\u009a\u0001\u0000\u0000"+
		"\u0000\u009c\u0017\u0001\u0000\u0000\u0000\u009d\u009e\u0003\u001c\u000e"+
		"\u0000\u009e\u009f\u0003\u0014\n\u0000\u009f\u00a0\u0003\u001e\u000f\u0000"+
		"\u00a0\u0019\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005\u0003\u0000\u0000"+
		"\u00a2\u00a3\u0003\u0010\b\u0000\u00a3\u00a4\u0005\u0004\u0000\u0000\u00a4"+
		"\u001b\u0001\u0000\u0000\u0000\u00a5\u00ad\u0003.\u0017\u0000\u00a6\u00a7"+
		"\u0003 \u0010\u0000\u00a7\u00a8\u0005\u0002\u0000\u0000\u00a8\u00aa\u0001"+
		"\u0000\u0000\u0000\u00a9\u00a6\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001"+
		"\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ad\u0003"+
		"\"\u0011\u0000\u00ac\u00a5\u0001\u0000\u0000\u0000\u00ac\u00a9\u0001\u0000"+
		"\u0000\u0000\u00ad\u001d\u0001\u0000\u0000\u0000\u00ae\u00b6\u00030\u0018"+
		"\u0000\u00af\u00b0\u0003$\u0012\u0000\u00b0\u00b1\u0005\u0002\u0000\u0000"+
		"\u00b1\u00b3\u0001\u0000\u0000\u0000\u00b2\u00af\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000"+
		"\u00b4\u00b6\u0003&\u0013\u0000\u00b5\u00ae\u0001\u0000\u0000\u0000\u00b5"+
		"\u00b2\u0001\u0000\u0000\u0000\u00b6\u001f\u0001\u0000\u0000\u0000\u00b7"+
		"\u00b8\u0003`0\u0000\u00b8!\u0001\u0000\u0000\u0000\u00b9\u00ba\u0003"+
		"`0\u0000\u00ba#\u0001\u0000\u0000\u0000\u00bb\u00bc\u0003`0\u0000\u00bc"+
		"%\u0001\u0000\u0000\u0000\u00bd\u00be\u0003`0\u0000\u00be\'\u0001\u0000"+
		"\u0000\u0000\u00bf\u00c0\u0005?\u0000\u0000\u00c0)\u0001\u0000\u0000\u0000"+
		"\u00c1\u00c2\u0005?\u0000\u0000\u00c2+\u0001\u0000\u0000\u0000\u00c3\u00c4"+
		"\u0007\u0002\u0000\u0000\u00c4-\u0001\u0000\u0000\u0000\u00c5\u00c6\u0007"+
		"\u0002\u0000\u0000\u00c6/\u0001\u0000\u0000\u0000\u00c7\u00c8\u0007\u0002"+
		"\u0000\u0000\u00c81\u0001\u0000\u0000\u0000\u00c9\u00cb\u00038\u001c\u0000"+
		"\u00ca\u00cc\u0003F#\u0000\u00cb\u00ca\u0001\u0000\u0000\u0000\u00cb\u00cc"+
		"\u0001\u0000\u0000\u0000\u00cc\u00ce\u0001\u0000\u0000\u0000\u00cd\u00cf"+
		"\u0003H$\u0000\u00ce\u00cd\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000"+
		"\u0000\u0000\u00cf3\u0001\u0000\u0000\u0000\u00d0\u00d8\u00036\u001b\u0000"+
		"\u00d1\u00d2\u0003@ \u0000\u00d2\u00d4\u00036\u001b\u0000\u00d3\u00d5"+
		"\u0003B!\u0000\u00d4\u00d3\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000"+
		"\u0000\u0000\u00d5\u00d7\u0001\u0000\u0000\u0000\u00d6\u00d1\u0001\u0000"+
		"\u0000\u0000\u00d7\u00da\u0001\u0000\u0000\u0000\u00d8\u00d6\u0001\u0000"+
		"\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d95\u0001\u0000\u0000"+
		"\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00db\u00e0\u0003X,\u0000\u00dc"+
		"\u00de\u0005\u0013\u0000\u0000\u00dd\u00dc\u0001\u0000\u0000\u0000\u00dd"+
		"\u00de\u0001\u0000\u0000\u0000\u00de\u00df\u0001\u0000\u0000\u0000\u00df"+
		"\u00e1\u0003\\.\u0000\u00e0\u00dd\u0001\u0000\u0000\u0000\u00e0\u00e1"+
		"\u0001\u0000\u0000\u0000\u00e17\u0001\u0000\u0000\u0000\u00e2\u00e4\u0005"+
		":\u0000\u0000\u00e3\u00e5\u0005\u001f\u0000\u0000\u00e4\u00e3\u0001\u0000"+
		"\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000"+
		"\u0000\u0000\u00e6\u00eb\u0003>\u001f\u0000\u00e7\u00e8\u0005\u0005\u0000"+
		"\u0000\u00e8\u00ea\u0003>\u001f\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000"+
		"\u00ea\u00ed\u0001\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000"+
		"\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec\u00fa\u0001\u0000\u0000\u0000"+
		"\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ee\u00f8\u0005#\u0000\u0000\u00ef"+
		"\u00f4\u00036\u001b\u0000\u00f0\u00f1\u0005\u0005\u0000\u0000\u00f1\u00f3"+
		"\u00036\u001b\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f3\u00f6\u0001"+
		"\u0000\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001"+
		"\u0000\u0000\u0000\u00f5\u00f9\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001"+
		"\u0000\u0000\u0000\u00f7\u00f9\u00034\u001a\u0000\u00f8\u00ef\u0001\u0000"+
		"\u0000\u0000\u00f8\u00f7\u0001\u0000\u0000\u0000\u00f9\u00fb\u0001\u0000"+
		"\u0000\u0000\u00fa\u00ee\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000"+
		"\u0000\u0000\u00fb\u00fe\u0001\u0000\u0000\u0000\u00fc\u00fd\u0005=\u0000"+
		"\u0000\u00fd\u00ff\u0003\u0010\b\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000"+
		"\u00fe\u00ff\u0001\u0000\u0000\u0000\u00ff9\u0001\u0000\u0000\u0000\u0100"+
		"\u0102\u00038\u001c\u0000\u0101\u0103\u0003F#\u0000\u0102\u0101\u0001"+
		"\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u0103\u0105\u0001"+
		"\u0000\u0000\u0000\u0104\u0106\u0003H$\u0000\u0105\u0104\u0001\u0000\u0000"+
		"\u0000\u0105\u0106\u0001\u0000\u0000\u0000\u0106;\u0001\u0000\u0000\u0000"+
		"\u0107\u0108\u0005\u0006\u0000\u0000\u0108=\u0001\u0000\u0000\u0000\u0109"+
		"\u0116\u0003<\u001e\u0000\u010a\u010b\u0003X,\u0000\u010b\u010c\u0005"+
		"\u0002\u0000\u0000\u010c\u010d\u0003<\u001e\u0000\u010d\u0116\u0001\u0000"+
		"\u0000\u0000\u010e\u0113\u0003\b\u0004\u0000\u010f\u0111\u0005\u0013\u0000"+
		"\u0000\u0110\u010f\u0001\u0000\u0000\u0000\u0110\u0111\u0001\u0000\u0000"+
		"\u0000\u0111\u0112\u0001\u0000\u0000\u0000\u0112\u0114\u0003R)\u0000\u0113"+
		"\u0110\u0001\u0000\u0000\u0000\u0113\u0114\u0001\u0000\u0000\u0000\u0114"+
		"\u0116\u0001\u0000\u0000\u0000\u0115\u0109\u0001\u0000\u0000\u0000\u0115"+
		"\u010a\u0001\u0000\u0000\u0000\u0115\u010e\u0001\u0000\u0000\u0000\u0116"+
		"?\u0001\u0000\u0000\u0000\u0117\u0121\u0005\u0005\u0000\u0000\u0118\u011a"+
		"\u0005.\u0000\u0000\u0119\u011b\u00057\u0000\u0000\u011a\u0119\u0001\u0000"+
		"\u0000\u0000\u011a\u011b\u0001\u0000\u0000\u0000\u011b\u011e\u0001\u0000"+
		"\u0000\u0000\u011c\u011e\u0005)\u0000\u0000\u011d\u0118\u0001\u0000\u0000"+
		"\u0000\u011d\u011c\u0001\u0000\u0000\u0000\u011d\u011e\u0001\u0000\u0000"+
		"\u0000\u011e\u011f\u0001\u0000\u0000\u0000\u011f\u0121\u0005,\u0000\u0000"+
		"\u0120\u0117\u0001\u0000\u0000\u0000\u0120\u011d\u0001\u0000\u0000\u0000"+
		"\u0121A\u0001\u0000\u0000\u0000\u0122\u0123\u00054\u0000\u0000\u0123\u0124"+
		"\u0003\b\u0004\u0000\u0124C\u0001\u0000\u0000\u0000\u0125\u0128\u0003"+
		"X,\u0000\u0126\u0127\u0005\u0013\u0000\u0000\u0127\u0129\u0003^/\u0000"+
		"\u0128\u0126\u0001\u0000\u0000\u0000\u0128\u0129\u0001\u0000\u0000\u0000"+
		"\u0129E\u0001\u0000\u0000\u0000\u012a\u012b\u00056\u0000\u0000\u012b\u012c"+
		"\u0005\u0016\u0000\u0000\u012c\u0131\u0003J%\u0000\u012d\u012e\u0005\u0005"+
		"\u0000\u0000\u012e\u0130\u0003J%\u0000\u012f\u012d\u0001\u0000\u0000\u0000"+
		"\u0130\u0133\u0001\u0000\u0000\u0000\u0131\u012f\u0001\u0000\u0000\u0000"+
		"\u0131\u0132\u0001\u0000\u0000\u0000\u0132G\u0001\u0000\u0000\u0000\u0133"+
		"\u0131\u0001\u0000\u0000\u0000\u0134\u0135\u00050\u0000\u0000\u0135\u0138"+
		"\u0003(\u0014\u0000\u0136\u0137\u00053\u0000\u0000\u0137\u0139\u0003*"+
		"\u0015\u0000\u0138\u0136\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000"+
		"\u0000\u0000\u0139I\u0001\u0000\u0000\u0000\u013a\u013c\u0003\b\u0004"+
		"\u0000\u013b\u013d\u0003L&\u0000\u013c\u013b\u0001\u0000\u0000\u0000\u013c"+
		"\u013d\u0001\u0000\u0000\u0000\u013dK\u0001\u0000\u0000\u0000\u013e\u013f"+
		"\u0007\u0003\u0000\u0000\u013fM\u0001\u0000\u0000\u0000\u0140\u0141\u0003"+
		"2\u0019\u0000\u0141O\u0001\u0000\u0000\u0000\u0142\u0143\u0007\u0004\u0000"+
		"\u0000\u0143Q\u0001\u0000\u0000\u0000\u0144\u0145\u0007\u0005\u0000\u0000"+
		"\u0145S\u0001\u0000\u0000\u0000\u0146\u0174\u0001\u0000\u0000\u0000\u0147"+
		"\u0174\u0005\u0012\u0000\u0000\u0148\u0174\u0005\u0013\u0000\u0000\u0149"+
		"\u0174\u0005\u0014\u0000\u0000\u014a\u0174\u0005\u0015\u0000\u0000\u014b"+
		"\u0174\u0005\u0016\u0000\u0000\u014c\u0174\u0005\u0017\u0000\u0000\u014d"+
		"\u0174\u0005\u0018\u0000\u0000\u014e\u0174\u0005\u0019\u0000\u0000\u014f"+
		"\u0174\u0005\u001a\u0000\u0000\u0150\u0174\u0005\u001b\u0000\u0000\u0151"+
		"\u0174\u0005\u001c\u0000\u0000\u0152\u0174\u0005\u001d\u0000\u0000\u0153"+
		"\u0174\u0005\u001e\u0000\u0000\u0154\u0174\u0005\u001f\u0000\u0000\u0155"+
		"\u0174\u0005 \u0000\u0000\u0156\u0174\u0005!\u0000\u0000\u0157\u0174\u0005"+
		"\"\u0000\u0000\u0158\u0174\u0005#\u0000\u0000\u0159\u0174\u0005$\u0000"+
		"\u0000\u015a\u0174\u0005%\u0000\u0000\u015b\u0174\u0005&\u0000\u0000\u015c"+
		"\u0174\u0005\'\u0000\u0000\u015d\u0174\u0005(\u0000\u0000\u015e\u0174"+
		"\u0005)\u0000\u0000\u015f\u0174\u0005*\u0000\u0000\u0160\u0174\u0005+"+
		"\u0000\u0000\u0161\u0174\u0005,\u0000\u0000\u0162\u0174\u0005-\u0000\u0000"+
		"\u0163\u0174\u0005.\u0000\u0000\u0164\u0174\u0005/\u0000\u0000\u0165\u0174"+
		"\u00050\u0000\u0000\u0166\u0174\u00051\u0000\u0000\u0167\u0174\u00052"+
		"\u0000\u0000\u0168\u0174\u00053\u0000\u0000\u0169\u0174\u00054\u0000\u0000"+
		"\u016a\u0174\u00055\u0000\u0000\u016b\u0174\u00056\u0000\u0000\u016c\u0174"+
		"\u00057\u0000\u0000\u016d\u0174\u00058\u0000\u0000\u016e\u0174\u00059"+
		"\u0000\u0000\u016f\u0174\u0005:\u0000\u0000\u0170\u0174\u0005;\u0000\u0000"+
		"\u0171\u0174\u0005<\u0000\u0000\u0172\u0174\u0005=\u0000\u0000\u0173\u0146"+
		"\u0001\u0000\u0000\u0000\u0173\u0147\u0001\u0000\u0000\u0000\u0173\u0148"+
		"\u0001\u0000\u0000\u0000\u0173\u0149\u0001\u0000\u0000\u0000\u0173\u014a"+
		"\u0001\u0000\u0000\u0000\u0173\u014b\u0001\u0000\u0000\u0000\u0173\u014c"+
		"\u0001\u0000\u0000\u0000\u0173\u014d\u0001\u0000\u0000\u0000\u0173\u014e"+
		"\u0001\u0000\u0000\u0000\u0173\u014f\u0001\u0000\u0000\u0000\u0173\u0150"+
		"\u0001\u0000\u0000\u0000\u0173\u0151\u0001\u0000\u0000\u0000\u0173\u0152"+
		"\u0001\u0000\u0000\u0000\u0173\u0153\u0001\u0000\u0000\u0000\u0173\u0154"+
		"\u0001\u0000\u0000\u0000\u0173\u0155\u0001\u0000\u0000\u0000\u0173\u0156"+
		"\u0001\u0000\u0000\u0000\u0173\u0157\u0001\u0000\u0000\u0000\u0173\u0158"+
		"\u0001\u0000\u0000\u0000\u0173\u0159\u0001\u0000\u0000\u0000\u0173\u015a"+
		"\u0001\u0000\u0000\u0000\u0173\u015b\u0001\u0000\u0000\u0000\u0173\u015c"+
		"\u0001\u0000\u0000\u0000\u0173\u015d\u0001\u0000\u0000\u0000\u0173\u015e"+
		"\u0001\u0000\u0000\u0000\u0173\u015f\u0001\u0000\u0000\u0000\u0173\u0160"+
		"\u0001\u0000\u0000\u0000\u0173\u0161\u0001\u0000\u0000\u0000\u0173\u0162"+
		"\u0001\u0000\u0000\u0000\u0173\u0163\u0001\u0000\u0000\u0000\u0173\u0164"+
		"\u0001\u0000\u0000\u0000\u0173\u0165\u0001\u0000\u0000\u0000\u0173\u0166"+
		"\u0001\u0000\u0000\u0000\u0173\u0167\u0001\u0000\u0000\u0000\u0173\u0168"+
		"\u0001\u0000\u0000\u0000\u0173\u0169\u0001\u0000\u0000\u0000\u0173\u016a"+
		"\u0001\u0000\u0000\u0000\u0173\u016b\u0001\u0000\u0000\u0000\u0173\u016c"+
		"\u0001\u0000\u0000\u0000\u0173\u016d\u0001\u0000\u0000\u0000\u0173\u016e"+
		"\u0001\u0000\u0000\u0000\u0173\u016f\u0001\u0000\u0000\u0000\u0173\u0170"+
		"\u0001\u0000\u0000\u0000\u0173\u0171\u0001\u0000\u0000\u0000\u0173\u0172"+
		"\u0001\u0000\u0000\u0000\u0174U\u0001\u0000\u0000\u0000\u0175\u0176\u0003"+
		"`0\u0000\u0176W\u0001\u0000\u0000\u0000\u0177\u0178\u0003`0\u0000\u0178"+
		"Y\u0001\u0000\u0000\u0000\u0179\u017a\u0003`0\u0000\u017a[\u0001\u0000"+
		"\u0000\u0000\u017b\u017c\u0003`0\u0000\u017c]\u0001\u0000\u0000\u0000"+
		"\u017d\u017e\u0003`0\u0000\u017e_\u0001\u0000\u0000\u0000\u017f\u0186"+
		"\u0005>\u0000\u0000\u0180\u0186\u0005@\u0000\u0000\u0181\u0182\u0005\u0003"+
		"\u0000\u0000\u0182\u0183\u0003`0\u0000\u0183\u0184\u0005\u0004\u0000\u0000"+
		"\u0184\u0186\u0001\u0000\u0000\u0000\u0185\u017f\u0001\u0000\u0000\u0000"+
		"\u0185\u0180\u0001\u0000\u0000\u0000\u0185\u0181\u0001\u0000\u0000\u0000"+
		"\u0186a\u0001\u0000\u0000\u0000&fmwz\u0088\u0094\u0097\u009b\u00a9\u00ac"+
		"\u00b2\u00b5\u00cb\u00ce\u00d4\u00d8\u00dd\u00e0\u00e4\u00eb\u00f4\u00f8"+
		"\u00fa\u00fe\u0102\u0105\u0110\u0113\u0115\u011a\u011d\u0120\u0128\u0131"+
		"\u0138\u013c\u0173\u0185";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}