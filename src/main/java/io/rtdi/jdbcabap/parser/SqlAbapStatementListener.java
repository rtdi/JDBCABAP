package io.rtdi.jdbcabap.parser;

import java.sql.JDBCType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import io.rtdi.jdbcabap.parser.AndOr.AndOrOp;
import io.rtdi.jdbcabap.parser.antlr.SqlAbapBaseListener;
import io.rtdi.jdbcabap.parser.antlr.SqlAbapParser.*;
import io.rtdi.jdbcabap.sql.SQL;

public class SqlAbapStatementListener extends SqlAbapBaseListener {
	private SQL sql;
	private WhereClause whereclause;
	private WithParent currentexpr;
	private List<Parameter> parameters;
	private int projectionpos;

	public SqlAbapStatementListener(SQL sql) {
		this.sql = sql;
	}
	
	@Override
	public void enterTablename(TablenameContext ctx) {
		String tablename = getName(ctx);
		sql.setTablename(tablename);
	}

	@Override
	public void enterResultcolumn(ResultcolumnContext ctx) {
	}

	@Override
	public void enterSelectstmt(SelectstmtContext ctx) {
		sql.init();
		whereclause = null;
		currentexpr = null;
		parameters = new ArrayList<>();
		sql.setParameters(parameters);
		projectionpos = 0;
	}
	
	public List<Parameter> getParameters() {
		return parameters;
	}

	@Override
	public void enterColumnname(ColumnnameContext ctx) {
		/*
		 * A projection that is a column only
		 */
		String columnname = getName(ctx);
		ProjectionColumn currentcolumn = new ProjectionColumn(new ColumnExpression(columnname), columnname, projectionpos++);
		sql.addColumn(currentcolumn);
	}

	@Override
	public void enterStarcolumn(StarcolumnContext ctx) {
		String columnname = "*";
		ProjectionColumn currentcolumn = new ProjectionColumn(new ColumnExpression(columnname), columnname, projectionpos++);
		sql.addColumn(currentcolumn);
	}

	@Override
	public void enterExprconstantstring(ExprconstantstringContext ctx) {
		String columnname = ctx.getText();
		try {
			ProjectionColumn currentcolumn = new ProjectionColumn(new Constant(ctx.getText(), JDBCType.NVARCHAR), columnname, projectionpos++);
			sql.addColumn(currentcolumn);
		} catch (SQLException e) {
			throw new ParseCancellationException("Cannot convert constant to nvarchar", e);
		}
	}

	@Override
	public void enterExprconstantnum(ExprconstantnumContext ctx) {
		String columnname = ctx.getText();
		try {
			ProjectionColumn currentcolumn = new ProjectionColumn(new Constant(ctx.getText(), JDBCType.NUMERIC), columnname, projectionpos++);
			sql.addColumn(currentcolumn);
		} catch (SQLException e) {
			throw new ParseCancellationException("Cannot convert constant to numeric", e);
		}
	}

	@Override
	public void enterExprnull(ExprnullContext ctx) {
		String columnname = ctx.getText();
		try {
			ProjectionColumn currentcolumn = new ProjectionColumn(new Constant(ctx.getText(), JDBCType.NULL), columnname, projectionpos++);
			sql.addColumn(currentcolumn);
		} catch (SQLException e) {
			throw new ParseCancellationException("Cannot convert constant to null", e);
		}
	}

	@Override
	public void enterColumnalias(ColumnaliasContext ctx) {
		ProjectionColumn currentcolumn = sql.getLastColumn();
		if (currentcolumn != null) {
			currentcolumn.setColumnname(getName(ctx));
		}
	}

	private String getName(ParserRuleContext ctx) {
		String name = ctx.getText();
		if (name.startsWith("\"")) {
			name = name.replace("\"", "");
		} else {
			name = name.toUpperCase();
		}
		return name;
	}

	@Override
	public void enterExprlimit(ExprlimitContext ctx) {
		sql.setLimit(ctx.getText());
	}

	@Override
	public void enterExproffset(ExproffsetContext ctx) {
		sql.setOffset(ctx.getText());
	}

	@Override
	public void enterWhereclause(WhereclauseContext ctx) {
		BracketExpression current = (BracketExpression) currentexpr;
		WhereClause w = new WhereClause(current);
		if (whereclause == null) {
			whereclause = w;
			sql.setWhereClause(w);
		} else {
			current.setInner(w);
		}
		currentexpr = w;
	}

	@Override
	public void exitWhereclause(WhereclauseContext ctx) {
		currentexpr = currentexpr.getParent();
	}
	
	@Override
	public void enterWhereconditionbrackets(WhereconditionbracketsContext ctx) {
		WhereClause current = (WhereClause) currentexpr;
		BracketExpression b = new BracketExpression(current);
		current.add(b);
		currentexpr = b;
	}

	@Override
	public void exitWhereconditionbrackets(WhereconditionbracketsContext ctx) {
		currentexpr = currentexpr.getParent();
	}

	@Override
	public void enterWhereandorop(WhereandoropContext ctx) {
		WhereClause current = (WhereClause) currentexpr;
		current.addOperator(AndOrOp.of(ctx.getText()));
	}

	@Override
	public void enterWhereconditioncomp(WhereconditioncompContext ctx) {
		WhereClause current = (WhereClause) currentexpr;
		ConditionExpression c = new ConditionExpression(current);
		current.add(c);
		currentexpr = c;
	}

	@Override
	public void exitWhereconditioncomp(WhereconditioncompContext ctx) {
		currentexpr = currentexpr.getParent();
	}

	@Override
	public void enterWhereop(WhereopContext ctx) {
		ConditionExpression current = (ConditionExpression) currentexpr;
		current.setOp(ctx.getText());
	}

	@Override
	public void enterWherecolumnnamel(WherecolumnnamelContext ctx) {
		ConditionExpression current = (ConditionExpression) currentexpr;
		String name = getName(ctx);
		current.setLeft(new ColumnExpression(name));
	}

	@Override
	public void enterWherevaluel(WherevaluelContext ctx) {
		ConditionExpression current = (ConditionExpression) currentexpr;
		String value = ctx.getText();
		if ("?".equals(value)) {
			Parameter p = new Parameter();
			parameters.add(p);
			current.setLeft(p);
		} else {
			try {
				current.setLeft(new Constant(value));
			} catch (SQLException e) {
				throw new ParseCancellationException("Cannot convert constant", e);
			}
		}
	}

	@Override
	public void enterWherecolumnnamer(WherecolumnnamerContext ctx) {
		ConditionExpression current = (ConditionExpression) currentexpr;
		String name = getName(ctx);
		current.setRight(new ColumnExpression(name));
	}

	@Override
	public void enterWherevaluer(WherevaluerContext ctx) {
		ConditionExpression current = (ConditionExpression) currentexpr;
		String value = ctx.getText();
		if ("?".equals(value)) {
			Parameter p = new Parameter();
			parameters.add(p);
			current.setRight(p);
		} else {
			try {
				current.setRight(new Constant(value));
			} catch (SQLException e) {
				throw new ParseCancellationException("Cannot convert constant", e);
			}
		}
	}

}
