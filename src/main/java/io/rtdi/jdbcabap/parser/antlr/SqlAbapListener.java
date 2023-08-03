// Generated from SqlAbap.g4 by ANTLR 4.12.0
package io.rtdi.jdbcabap.parser.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SqlAbapParser}.
 */
public interface SqlAbapListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#sql_stmt}.
	 * @param ctx the parse tree
	 */
	void enterSql_stmt(SqlAbapParser.Sql_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#sql_stmt}.
	 * @param ctx the parse tree
	 */
	void exitSql_stmt(SqlAbapParser.Sql_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#commitstmt}.
	 * @param ctx the parse tree
	 */
	void enterCommitstmt(SqlAbapParser.CommitstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#commitstmt}.
	 * @param ctx the parse tree
	 */
	void exitCommitstmt(SqlAbapParser.CommitstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#rollbackstmt}.
	 * @param ctx the parse tree
	 */
	void enterRollbackstmt(SqlAbapParser.RollbackstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#rollbackstmt}.
	 * @param ctx the parse tree
	 */
	void exitRollbackstmt(SqlAbapParser.RollbackstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#signednumber}.
	 * @param ctx the parse tree
	 */
	void enterSignednumber(SqlAbapParser.SignednumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#signednumber}.
	 * @param ctx the parse tree
	 */
	void exitSignednumber(SqlAbapParser.SignednumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(SqlAbapParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(SqlAbapParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#exprconstantstring}.
	 * @param ctx the parse tree
	 */
	void enterExprconstantstring(SqlAbapParser.ExprconstantstringContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#exprconstantstring}.
	 * @param ctx the parse tree
	 */
	void exitExprconstantstring(SqlAbapParser.ExprconstantstringContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#exprconstantnum}.
	 * @param ctx the parse tree
	 */
	void enterExprconstantnum(SqlAbapParser.ExprconstantnumContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#exprconstantnum}.
	 * @param ctx the parse tree
	 */
	void exitExprconstantnum(SqlAbapParser.ExprconstantnumContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#exprnull}.
	 * @param ctx the parse tree
	 */
	void enterExprnull(SqlAbapParser.ExprnullContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#exprnull}.
	 * @param ctx the parse tree
	 */
	void exitExprnull(SqlAbapParser.ExprnullContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#whereclause}.
	 * @param ctx the parse tree
	 */
	void enterWhereclause(SqlAbapParser.WhereclauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#whereclause}.
	 * @param ctx the parse tree
	 */
	void exitWhereclause(SqlAbapParser.WhereclauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#whereandorop}.
	 * @param ctx the parse tree
	 */
	void enterWhereandorop(SqlAbapParser.WhereandoropContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#whereandorop}.
	 * @param ctx the parse tree
	 */
	void exitWhereandorop(SqlAbapParser.WhereandoropContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#whereop}.
	 * @param ctx the parse tree
	 */
	void enterWhereop(SqlAbapParser.WhereopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#whereop}.
	 * @param ctx the parse tree
	 */
	void exitWhereop(SqlAbapParser.WhereopContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#wherecondition}.
	 * @param ctx the parse tree
	 */
	void enterWherecondition(SqlAbapParser.WhereconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#wherecondition}.
	 * @param ctx the parse tree
	 */
	void exitWherecondition(SqlAbapParser.WhereconditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#whereconditioncomp}.
	 * @param ctx the parse tree
	 */
	void enterWhereconditioncomp(SqlAbapParser.WhereconditioncompContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#whereconditioncomp}.
	 * @param ctx the parse tree
	 */
	void exitWhereconditioncomp(SqlAbapParser.WhereconditioncompContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#whereconditionbrackets}.
	 * @param ctx the parse tree
	 */
	void enterWhereconditionbrackets(SqlAbapParser.WhereconditionbracketsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#whereconditionbrackets}.
	 * @param ctx the parse tree
	 */
	void exitWhereconditionbrackets(SqlAbapParser.WhereconditionbracketsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#whereexprl}.
	 * @param ctx the parse tree
	 */
	void enterWhereexprl(SqlAbapParser.WhereexprlContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#whereexprl}.
	 * @param ctx the parse tree
	 */
	void exitWhereexprl(SqlAbapParser.WhereexprlContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#whereexprr}.
	 * @param ctx the parse tree
	 */
	void enterWhereexprr(SqlAbapParser.WhereexprrContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#whereexprr}.
	 * @param ctx the parse tree
	 */
	void exitWhereexprr(SqlAbapParser.WhereexprrContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#wheretablenamel}.
	 * @param ctx the parse tree
	 */
	void enterWheretablenamel(SqlAbapParser.WheretablenamelContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#wheretablenamel}.
	 * @param ctx the parse tree
	 */
	void exitWheretablenamel(SqlAbapParser.WheretablenamelContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#wherecolumnnamel}.
	 * @param ctx the parse tree
	 */
	void enterWherecolumnnamel(SqlAbapParser.WherecolumnnamelContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#wherecolumnnamel}.
	 * @param ctx the parse tree
	 */
	void exitWherecolumnnamel(SqlAbapParser.WherecolumnnamelContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#wheretablenamer}.
	 * @param ctx the parse tree
	 */
	void enterWheretablenamer(SqlAbapParser.WheretablenamerContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#wheretablenamer}.
	 * @param ctx the parse tree
	 */
	void exitWheretablenamer(SqlAbapParser.WheretablenamerContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#wherecolumnnamer}.
	 * @param ctx the parse tree
	 */
	void enterWherecolumnnamer(SqlAbapParser.WherecolumnnamerContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#wherecolumnnamer}.
	 * @param ctx the parse tree
	 */
	void exitWherecolumnnamer(SqlAbapParser.WherecolumnnamerContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#exprlimit}.
	 * @param ctx the parse tree
	 */
	void enterExprlimit(SqlAbapParser.ExprlimitContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#exprlimit}.
	 * @param ctx the parse tree
	 */
	void exitExprlimit(SqlAbapParser.ExprlimitContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#exproffset}.
	 * @param ctx the parse tree
	 */
	void enterExproffset(SqlAbapParser.ExproffsetContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#exproffset}.
	 * @param ctx the parse tree
	 */
	void exitExproffset(SqlAbapParser.ExproffsetContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#literalvalue}.
	 * @param ctx the parse tree
	 */
	void enterLiteralvalue(SqlAbapParser.LiteralvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#literalvalue}.
	 * @param ctx the parse tree
	 */
	void exitLiteralvalue(SqlAbapParser.LiteralvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#wherevaluel}.
	 * @param ctx the parse tree
	 */
	void enterWherevaluel(SqlAbapParser.WherevaluelContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#wherevaluel}.
	 * @param ctx the parse tree
	 */
	void exitWherevaluel(SqlAbapParser.WherevaluelContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#wherevaluer}.
	 * @param ctx the parse tree
	 */
	void enterWherevaluer(SqlAbapParser.WherevaluerContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#wherevaluer}.
	 * @param ctx the parse tree
	 */
	void exitWherevaluer(SqlAbapParser.WherevaluerContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#selectstmt}.
	 * @param ctx the parse tree
	 */
	void enterSelectstmt(SqlAbapParser.SelectstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#selectstmt}.
	 * @param ctx the parse tree
	 */
	void exitSelectstmt(SqlAbapParser.SelectstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#joinclause}.
	 * @param ctx the parse tree
	 */
	void enterJoinclause(SqlAbapParser.JoinclauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#joinclause}.
	 * @param ctx the parse tree
	 */
	void exitJoinclause(SqlAbapParser.JoinclauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#tableclause}.
	 * @param ctx the parse tree
	 */
	void enterTableclause(SqlAbapParser.TableclauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#tableclause}.
	 * @param ctx the parse tree
	 */
	void exitTableclause(SqlAbapParser.TableclauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#selectcore}.
	 * @param ctx the parse tree
	 */
	void enterSelectcore(SqlAbapParser.SelectcoreContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#selectcore}.
	 * @param ctx the parse tree
	 */
	void exitSelectcore(SqlAbapParser.SelectcoreContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#simpleselectstmt}.
	 * @param ctx the parse tree
	 */
	void enterSimpleselectstmt(SqlAbapParser.SimpleselectstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#simpleselectstmt}.
	 * @param ctx the parse tree
	 */
	void exitSimpleselectstmt(SqlAbapParser.SimpleselectstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#starcolumn}.
	 * @param ctx the parse tree
	 */
	void enterStarcolumn(SqlAbapParser.StarcolumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#starcolumn}.
	 * @param ctx the parse tree
	 */
	void exitStarcolumn(SqlAbapParser.StarcolumnContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#resultcolumn}.
	 * @param ctx the parse tree
	 */
	void enterResultcolumn(SqlAbapParser.ResultcolumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#resultcolumn}.
	 * @param ctx the parse tree
	 */
	void exitResultcolumn(SqlAbapParser.ResultcolumnContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#joinoperator}.
	 * @param ctx the parse tree
	 */
	void enterJoinoperator(SqlAbapParser.JoinoperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#joinoperator}.
	 * @param ctx the parse tree
	 */
	void exitJoinoperator(SqlAbapParser.JoinoperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#joinconstraint}.
	 * @param ctx the parse tree
	 */
	void enterJoinconstraint(SqlAbapParser.JoinconstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#joinconstraint}.
	 * @param ctx the parse tree
	 */
	void exitJoinconstraint(SqlAbapParser.JoinconstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#qualifiedtablename}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedtablename(SqlAbapParser.QualifiedtablenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#qualifiedtablename}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedtablename(SqlAbapParser.QualifiedtablenameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#orderbystmt}.
	 * @param ctx the parse tree
	 */
	void enterOrderbystmt(SqlAbapParser.OrderbystmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#orderbystmt}.
	 * @param ctx the parse tree
	 */
	void exitOrderbystmt(SqlAbapParser.OrderbystmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#limitstmt}.
	 * @param ctx the parse tree
	 */
	void enterLimitstmt(SqlAbapParser.LimitstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#limitstmt}.
	 * @param ctx the parse tree
	 */
	void exitLimitstmt(SqlAbapParser.LimitstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#orderingterm}.
	 * @param ctx the parse tree
	 */
	void enterOrderingterm(SqlAbapParser.OrderingtermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#orderingterm}.
	 * @param ctx the parse tree
	 */
	void exitOrderingterm(SqlAbapParser.OrderingtermContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#ascdesc}.
	 * @param ctx the parse tree
	 */
	void enterAscdesc(SqlAbapParser.AscdescContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#ascdesc}.
	 * @param ctx the parse tree
	 */
	void exitAscdesc(SqlAbapParser.AscdescContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#initialselect}.
	 * @param ctx the parse tree
	 */
	void enterInitialselect(SqlAbapParser.InitialselectContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#initialselect}.
	 * @param ctx the parse tree
	 */
	void exitInitialselect(SqlAbapParser.InitialselectContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#unaryoperator}.
	 * @param ctx the parse tree
	 */
	void enterUnaryoperator(SqlAbapParser.UnaryoperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#unaryoperator}.
	 * @param ctx the parse tree
	 */
	void exitUnaryoperator(SqlAbapParser.UnaryoperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#columnalias}.
	 * @param ctx the parse tree
	 */
	void enterColumnalias(SqlAbapParser.ColumnaliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#columnalias}.
	 * @param ctx the parse tree
	 */
	void exitColumnalias(SqlAbapParser.ColumnaliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#keyword}.
	 * @param ctx the parse tree
	 */
	void enterKeyword(SqlAbapParser.KeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#keyword}.
	 * @param ctx the parse tree
	 */
	void exitKeyword(SqlAbapParser.KeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(SqlAbapParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(SqlAbapParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#tablename}.
	 * @param ctx the parse tree
	 */
	void enterTablename(SqlAbapParser.TablenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#tablename}.
	 * @param ctx the parse tree
	 */
	void exitTablename(SqlAbapParser.TablenameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#columnname}.
	 * @param ctx the parse tree
	 */
	void enterColumnname(SqlAbapParser.ColumnnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#columnname}.
	 * @param ctx the parse tree
	 */
	void exitColumnname(SqlAbapParser.ColumnnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#tablealias}.
	 * @param ctx the parse tree
	 */
	void enterTablealias(SqlAbapParser.TablealiasContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#tablealias}.
	 * @param ctx the parse tree
	 */
	void exitTablealias(SqlAbapParser.TablealiasContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#alias}.
	 * @param ctx the parse tree
	 */
	void enterAlias(SqlAbapParser.AliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#alias}.
	 * @param ctx the parse tree
	 */
	void exitAlias(SqlAbapParser.AliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlAbapParser#any_name}.
	 * @param ctx the parse tree
	 */
	void enterAny_name(SqlAbapParser.Any_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlAbapParser#any_name}.
	 * @param ctx the parse tree
	 */
	void exitAny_name(SqlAbapParser.Any_nameContext ctx);
}