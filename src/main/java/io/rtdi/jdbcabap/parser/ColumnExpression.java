package io.rtdi.jdbcabap.parser;

import java.sql.SQLException;
import java.util.List;

import io.rtdi.jdbcabap.AbapColumn;
import io.rtdi.jdbcabap.AbapDataType;
import io.rtdi.jdbcabap.AbapTableMetadata;

/**
 * A ValueExpression that maps 1:1 to a column
 */
public class ColumnExpression implements ValueExpression {
	
	private String columnname;
	private int len;
	private int scale;
	private AbapDataType datatype;

	/**
	 * @param sourcecolumnname name of the table column
	 */
	public ColumnExpression(String sourcecolumnname) {
		this.columnname = sourcecolumnname;
	}

	@Override
	public String toString() {
		return columnname;
	}

	@Override
	public void updateMetadata(List<AbapTableMetadata> tablemetadata) throws SQLException {
		boolean found = false;
		for (AbapTableMetadata table : tablemetadata) {
			AbapColumn col = table.getField(columnname);
			if (col != null) {
				setDatatype(col.getDatatype());
				found = true;
				break;
			}
		}
		if (!found) {
			throw new SQLException(String.format("The column %s is not found in the tables", columnname));
		}
	}

	@Override
	public void setDatatype(AbapDataType dt) throws SQLException {
		if (datatype == null) {
			datatype = dt;
		} else if (!dt.equals(getDatatype())) {
			// This happens when a condition is tab1.col1 = tab1.col2
			throw new SQLException(String.format("Datatypes are not identical for the column %s", columnname));
		}
	}

	@Override
	public String getText() {
		return columnname;
	}

	@Override
	public AbapDataType getDatatype() {
		return datatype;
	}

	@Override
	public int getLen() {
		return len;
	}

	@Override
	public int getScale() {
		return scale;
	}

	/**
	 * @return the name of the column this expression points to
	 */
	public String getColumnname() {
		return columnname;
	}

	@Override
	public void setMetadata(AbapColumn col) throws SQLException {
		len = col.getLen();
		scale = col.getScale();
		setDatatype(col.getDatatype());
	}

}
