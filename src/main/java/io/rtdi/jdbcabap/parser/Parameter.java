package io.rtdi.jdbcabap.parser;

import java.sql.SQLException;

import io.rtdi.jdbcabap.AbapColumn;
import io.rtdi.jdbcabap.AbapDataType;
import io.rtdi.jdbcabap.AbapTableMetadata;

public class Parameter implements ValueExpression {
	private String value;
	private AbapDataType datatype;
	private int len;
	private int scale;
	
	public Parameter() {
	}
	
	@Override
	public String toString() {
		if (value == null) {
			return "?";
		} else if (datatype == null) {
			return value;
		} else {
			switch (datatype) {
			case D:
			case T:
			case X:
			case C: return "'" + value + "'";
			case F:
			case I:
			case N:
			case NULL:
			case P:return value;
			}
			return value;
		}
	}

	public void setValue(String value) throws SQLException {
		this.value = WhereClause.validateStringWithDatatype(datatype, value);
	}

	public AbapDataType getDatatype() {
		return datatype;
	}

	public void setDatatype(AbapDataType datatype) throws SQLException {
		this.datatype = datatype;
		value = WhereClause.validateStringWithDatatype(datatype, value);
	}

	@Override
	public void updateMetadata(AbapTableMetadata tablemetadata) throws SQLException {
	}

	public String getText() {
		return value;
	}

	@Override
	public int getLen() {
		return len;
	}

	@Override
	public int getScale() {
		return scale;
	}

	@Override
	public void setMetadata(AbapColumn col) throws SQLException {
		len = col.getLen();
		scale = col.getScale();
		setDatatype(col.getDatatype());
	}
	
}
