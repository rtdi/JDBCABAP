package io.rtdi.jdbcabap.parser;

import java.math.BigDecimal;
import java.sql.JDBCType;
import java.sql.SQLException;
import java.util.List;

import io.rtdi.jdbcabap.AbapColumn;
import io.rtdi.jdbcabap.AbapDataType;
import io.rtdi.jdbcabap.AbapStatement;
import io.rtdi.jdbcabap.AbapTableMetadata;

/**
 * A Constant expression with a given data type
 */
public class Constant implements ValueExpression {
	private String text;
	private Object value;
	private int len;
	private int scale;
	private AbapDataType datatype;

	/**
	 * @param text contains the value in the native format, so including quotes if required 
	 * @param type is a compatible data type
	 * @throws SQLException in case the type is not supported
	 */
	public Constant(String text, JDBCType type) throws SQLException {
		this.text = text;
		this.datatype = AbapDataType.of(type);
		setValue(text);
	}

	/**
	 * @param text contains the value in the native format, so including quotes if required 
	 * @throws SQLException in case the text does not match the data type
	 */
	public Constant(String text) throws SQLException {
		this.text = text;
		if (text == null) {
			datatype = AbapDataType.NULL;
		} else if (text.startsWith("'")) {
			datatype = AbapDataType.C;
		} else {
			datatype = AbapDataType.N;
		}
		setValue(text);
	}

	@Override
	public String toString() {
		return text;
	}

	/**
	 * @return datatype of the constant
	 */
	public AbapDataType getDatatype() {
		return datatype;
	}

	/**
	 * @param datatype this constant must have
	 */
	public void setDatatype(AbapDataType datatype) throws SQLException {
		this.datatype = datatype;
		text = WhereClause.validateStringWithDatatype(datatype, text);
	}

	@Override
	public void updateMetadata(List<AbapTableMetadata> tablemetadata) throws SQLException {
	}

	public String getText() {
		return text;
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
	 * @return Jdbc equivalent Java object containing the value
	 */
	public Object getValue() {
		return value;
	}

	private void setValue(String text) throws SQLException {
		if (text == null) {
			value = null;
		} else {
			if (text.startsWith("'")) {
				text = text.substring(1, text.length()-1);
			}
			len = text.length();
			value = AbapStatement.convert(text, datatype);
			if (value instanceof BigDecimal d) {
				scale = d.scale();
			}
		}
	}

	@Override
	public void setMetadata(AbapColumn col) throws SQLException {
		setDatatype(col.getDatatype());
	}
}
