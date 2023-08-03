package io.rtdi.jdbcabap.sql;

import java.sql.ParameterMetaData;
import java.sql.SQLException;
import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import io.rtdi.jdbcabap.AbapColumn;
import io.rtdi.jdbcabap.AbapTableMetadata;
import io.rtdi.jdbcabap.parser.ColumnExpression;
import io.rtdi.jdbcabap.parser.Parameter;
import io.rtdi.jdbcabap.parser.ProjectionColumn;
import io.rtdi.jdbcabap.parser.SqlAbapStatementListener;
import io.rtdi.jdbcabap.parser.WhereClause;
import io.rtdi.jdbcabap.parser.antlr.SqlAbapLexer;
import io.rtdi.jdbcabap.parser.antlr.SqlAbapParser;

public class SQL extends SimpleResultSetMetadata {
	private WhereClause whereclause;
	private Integer limit;
	private Integer offset;
	private AbapParameterMetaData parametermetadata;
	private List<Parameter> parameters;

	public SQL(String sqltext) throws SQLException {
		try {
			SqlAbapLexer lexer = new SqlAbapLexer(CharStreams.fromString(sqltext));
			lexer.removeErrorListeners();
			lexer.addErrorListener(ErrorHandler.INSTANCE);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			SqlAbapParser parser = new SqlAbapParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(ErrorHandler.INSTANCE);
			ParseTreeWalker walker = new ParseTreeWalker();
			ParseTree tree = parser.sql_stmt();
			SqlAbapStatementListener listener = new SqlAbapStatementListener(this);
			walker.walk(listener, tree);
		} catch (ParseCancellationException e) {
			throw new SQLException("Failed to parse the SQL statement, ANTLR4 complains " + e.getMessage(), e);
		}
	}
	
	public String getWhereClause() {
		if (whereclause != null) {
			return whereclause.toString();
		} else {
			return null;
		}
	}

	public void init() {
		super.init();
		whereclause = null;
	}
	
	public void updateMetadata(AbapTableMetadata tablemetadata) throws SQLException {
		if (fields != null) {
			int pos = 0;
			if (fields.size() == 1 && fields.get(0).getText().equals("*")) {
				fields.clear();
				for (AbapColumn columnmetadata : tablemetadata.getFields()) {
					ColumnExpression f = new ColumnExpression(columnmetadata.getColumnname());
					ProjectionColumn projection = new ProjectionColumn(f, columnmetadata.getColumnname(), pos);
					projection.updateMetadata(tablemetadata);
					fields.add(projection);
					pos++;
				}
			} else {
				for(ProjectionColumn f : fields) {
					f.updateMetadata(tablemetadata);
				}
			}
		}
		if (whereclause != null) {
			whereclause.updateMetadata(tablemetadata);
		}
	}
	
	public void setLimit(String text) {
		this.limit = Integer.parseInt(text);
	}

	public void setOffset(String text) {
		this.offset = Integer.parseInt(text);
	}

	public Integer getLimit() {
		return limit;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setWhereClause(WhereClause w) {
		this.whereclause = w;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (fields != null) {
			for (ProjectionColumn f : fields) {
				if (sb.length() != 0) {
					sb.append(", ");
				}
				sb.append(f.getText());
			}
		}
		String fieldlist = sb.toString();
		String where;
		if (whereclause != null) {
			where = " where " + whereclause;
		} else {
			where = "";
		}
		return String.format("select %s from %s%s", fieldlist, getTablename(), where);
	}

	public void setParameter(int index, String value) throws SQLException {
		if (parameters == null) {
			throw new SQLException("SQL statement has no parameters");
		} else if (index > 0 && index <= parameters.size()) {
			parameters.get(index-1).setValue(value);
		} else {
			throw new SQLException(String.format("SQL statement has %d parameters and provided index of %d is not in range", parameters.size(), index));
		}
	}

	public ParameterMetaData getParameterMetadata() {
		if (parametermetadata == null) {
			parametermetadata = new AbapParameterMetaData(parameters);
		}
		return parametermetadata;
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}

}
