package io.rtdi.jdbcabap.parser;

import java.sql.SQLException;

import io.rtdi.jdbcabap.AbapColumn;
import io.rtdi.jdbcabap.AbapDataType;
import io.rtdi.jdbcabap.AbapTableMetadata;

public class ProjectionColumn implements ValueExpression {

	private ValueExpression expr;
	private int position;
	private String columnname;

	public ProjectionColumn(ValueExpression expr, String columnname, int pos) {
		this.expr = expr;
		this.position = pos;
		this.columnname = columnname;
	}

	public ProjectionColumn(String columnname, int pos) {
		this(new ColumnExpression(columnname), columnname, pos);
	}

	@Override
	public void updateMetadata(AbapTableMetadata tablemetadata) throws SQLException {
		if (expr instanceof ColumnExpression c) {
			AbapColumn col = tablemetadata.getField(c.getColumnname());
			if (col == null) {
				throw new SQLException(String.format("Cannot find the column %s in the table %s", columnname, tablemetadata.getTablename()));
			}
			expr.setMetadata(col);
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

	public String getText() {
		return expr.getText();
	}

	public ValueExpression getExpression() {
		return expr;
	}

	public String getColumnname() {
		return columnname;
	}

	public int getPosition() {
		return position;
	}

	public int getLen() {
		return expr.getLen();
	}

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

	public void setColumnname(String name) {
		this.columnname = name;
	}

}
