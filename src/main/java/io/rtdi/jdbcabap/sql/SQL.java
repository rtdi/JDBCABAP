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
import io.rtdi.jdbcabap.AbapDataType;
import io.rtdi.jdbcabap.AbapTableMetadata;
import io.rtdi.jdbcabap.parser.ColumnExpression;
import io.rtdi.jdbcabap.parser.Expression;
import io.rtdi.jdbcabap.parser.Parameter;
import io.rtdi.jdbcabap.parser.ProjectionColumn;
import io.rtdi.jdbcabap.parser.SqlAbapStatementListener;
import io.rtdi.jdbcabap.parser.WhereClause;
import io.rtdi.jdbcabap.parser.antlr.SqlAbapLexer;
import io.rtdi.jdbcabap.parser.antlr.SqlAbapParser;

/**
 * An object tree representing the SQL statement
 */
public class SQL extends SimpleResultSetMetadata implements Expression {
	private WhereClause whereclause;
	private Integer limit;
	private Integer offset;
	private AbapParameterMetaData parametermetadata;
	private List<Parameter> parameters;

	/**
	 * Create the object tree for the provided SQL statement - no validation of column names at this point in time, just validating the syntax requirements
	 * @param sqltext is the free form statement
	 * @throws SQLException in case of any parsing issues
	 */
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
	
	/**
	 * @return the where clause or null
	 */
	public String getWhereClause() {
		if (whereclause != null) {
			return whereclause.toString();
		} else {
			return null;
		}
	}

	@Override
	public void init() {
		super.init();
		whereclause = null;
	}
	
	@Override
	public void updateMetadata(List<AbapTableMetadata> tablemetadata) throws SQLException {
		if (fields != null) {
			int pos = 0;
			if (fields.size() == 1 && fields.get(0).getText().equals("*")) {
				fields.clear();
				for (AbapTableMetadata table : tablemetadata) {
					for (AbapColumn columnmetadata : table.getFields()) {
						ColumnExpression f = new ColumnExpression(columnmetadata.getColumnname());
						ProjectionColumn projection = new ProjectionColumn(f, columnmetadata.getColumnname(), pos);
						projection.updateMetadata(tablemetadata);
						fields.add(projection);
						pos++;
					}
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
	
	/**
	 * @param text for the limit clause, converted to an integer
	 */
	public void setLimit(String text) {
		this.limit = Integer.parseInt(text);
	}

	/**
	 * @param text for the offset clause, converted to an integer
	 */
	public void setOffset(String text) {
		this.offset = Integer.parseInt(text);
	}

	/**
	 * @return limit clause value or null if there was none
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * @return offset clause value or null if there was none
	 */
	public Integer getOffset() {
		return offset;
	}

	/**
	 * @param w whereclause to be used by this SQL tree
	 */
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

	/**
	 * Called right before the execution to provide values to the statement
	 * @param index 1 based position of the parameter
	 * @param value for the parameter
	 * @throws SQLException in case the parameter data type and the value do not match
	 */
	public void setParameter(int index, String value) throws SQLException {
		if (parameters == null) {
			throw new SQLException("SQL statement has no parameters");
		} else if (index > 0 && index <= parameters.size()) {
			parameters.get(index-1).setValue(value);
		} else {
			throw new SQLException(String.format("SQL statement has %d parameters and provided index of %d is not in range", parameters.size(), index));
		}
	}

	/**
	 * @return metadata object for the parameters
	 */
	public ParameterMetaData getParameterMetadata() {
		if (parametermetadata == null) {
			parametermetadata = new AbapParameterMetaData(parameters);
		}
		return parametermetadata;
	}

	/**
	 * Setter for all parameters
	 * @param parameters list to be set to
	 */
	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}

	/**
	 * Sets the exact data type of the field at position, for those cases where it might not be known, e.g. select NULL as COL1 ...
	 * @param pos 1 based position
	 * @param dt datatype to be used
	 * @throws SQLException in case the position is out of range or the data type does not match the value
	 */
	public void setDataType(int pos, AbapDataType dt) throws SQLException {
		if (fields != null) {
			if (pos > 0 && pos <= fields.size()) {
				fields.get(pos-1).setDatatype(dt);
			} else {
				throw new SQLException(String.format("SQL has %d columns but the provided position is %d, must be between 1 and %d", fields.size(), pos, fields.size()));
			}
		}
	}

}
