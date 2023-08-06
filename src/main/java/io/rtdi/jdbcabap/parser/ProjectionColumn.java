package io.rtdi.jdbcabap.parser;

import java.sql.SQLException;
import java.util.List;

import io.rtdi.jdbcabap.AbapColumn;
import io.rtdi.jdbcabap.AbapDataType;
import io.rtdi.jdbcabap.AbapTableMetadata;

/**
 * A column in the select list, backed by an expression
 */
public class ProjectionColumn implements ValueExpression {

	private ValueExpression expr;
	private int position;
	private String columnname;

	/**
	 * @param expr used for this column
	 * @param columnname the alias of the column
	 * @param pos within the projection list
	 */
	public ProjectionColumn(ValueExpression expr, String columnname, int pos) {
		this.expr = expr;
		this.position = pos;
		this.columnname = columnname;
	}

	/**
	 * A projection of a single column of a table
	 * 
	 * @param columnname of the table
	 * @param pos within the projection list
	 */
	public ProjectionColumn(String columnname, int pos) {
		this(new ColumnExpression(columnname), columnname, pos);
	}

	@Override
	public void updateMetadata(List<AbapTableMetadata> tablemetadata) throws SQLException {
		if (expr instanceof ColumnExpression c) {
			boolean found = false;
			for (AbapTableMetadata table : tablemetadata) {
				AbapColumn col = table.getField(c.getColumnname());
				if (col != null) {
					expr.setMetadata(col);
					found = true;
					break;
				}
			}
			if (!found) {
				throw new SQLException(String.format("Cannot find the column %s in the tables", c.getColumnname()));
			}
		}
	}

	@Override
	public AbapDataType getDatatype() {
		return expr.getDatatype();
	}

	@Override
	public void setDatatype(AbapDataType dt) throws SQLException {
		expr.setDatatype(dt);
	}

	/**
	 * @return the expression's text
	 */
	public String getText() {
		return expr.getText();
	}

	/**
	 * @return the expression of this select column
	 */
	public ValueExpression getExpression() {
		return expr;
	}

	/**
	 * @return column name of the selected field
	 */
	public String getColumnname() {
		return columnname;
	}

	/**
	 * @return position of the field within the select clause
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * @return value of the expr.getLen()
	 */
	public int getLen() {
		return expr.getLen();
	}

	/**
	 * @return value of the expr.getScale()
	 */
	public int getScale() {
		return expr.getScale();
	}

	@Override
	public void setMetadata(AbapColumn col) throws SQLException {
		expr.setMetadata(col);
	}

	@Override
	public String toString() {
		if (expr != null) {
			return expr.toString();
		} else {
			return "projection empty";
		}
	}

	/**
	 * @param name to be used for this column, e.g. to allow setting the alias after the column had been created
	 */
	public void setColumnname(String name) {
		this.columnname = name;
	}

}
