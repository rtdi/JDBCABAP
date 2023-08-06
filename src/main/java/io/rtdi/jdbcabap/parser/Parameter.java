package io.rtdi.jdbcabap.parser;

import java.sql.SQLException;
import java.util.List;

import io.rtdi.jdbcabap.AbapColumn;
import io.rtdi.jdbcabap.AbapDataType;
import io.rtdi.jdbcabap.AbapTableMetadata;

/**
 * The ? character in a SQL gets replaced with this parameter object
 */
public class Parameter implements ValueExpression {
	private String value;
	private AbapDataType datatype;
	private int len;
	private int scale;
	
	/**
	 * new parameter instance POJO
	 */
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
			case u: return value;
			}
			return value;
		}
	}

	/**
	 * Sets the value of the object to a valid equivalent
	 * 
	 * @param value of the parameter at execution time
	 * @throws SQLException in case the value does not match the data type
	 */
	public void setValue(String value) throws SQLException {
		this.value = WhereClause.validateStringWithDatatype(datatype, value);
	}

	/**
	 * @return datatype of the parameter
	 */
	public AbapDataType getDatatype() {
		return datatype;
	}

	/**
	 * @param datatype of the parameter
	 */
	public void setDatatype(AbapDataType datatype) throws SQLException {
		this.datatype = datatype;
		value = WhereClause.validateStringWithDatatype(datatype, value);
	}

	@Override
	public void updateMetadata(List<AbapTableMetadata> tablemetadata) throws SQLException {
	}

	/**
	 * Textual representation of the value
	 */
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
