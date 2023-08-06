package io.rtdi.jdbcabap;

import java.sql.JDBCType;

/**
 * All data type Abap supports
 */
public enum AbapDataType {
	/**
	 * Integer 4 bytes
	 */
	I(JDBCType.INTEGER),
	/**
	 * float 8 bytes
	 */
	F(JDBCType.FLOAT),
	/**
	 * packed number 1-16
	 */
	P(JDBCType.DECIMAL),
	/**
	 * char 1-65536
	 */
	C(JDBCType.NVARCHAR),
	/**
	 * date 8 bytes
	 */
	D(JDBCType.DATE),
	/**
	 * numeric 1-65536
	 */
	N(JDBCType.DECIMAL),
	/**
	 * time 6 bytes
	 */
	T(JDBCType.TIME),
	/**
	 * hex 1-65536
	 */
	X(JDBCType.VARBINARY),
	/**
	 * a table structure returned by procedure calls, yes must be lower case
	 */
	u(JDBCType.ARRAY),
	/**
	 * Default data type for null constants
	 */
	NULL(JDBCType.NVARCHAR);
	
	private JDBCType jdbctype;

	AbapDataType(JDBCType jdbctype) {
		this.jdbctype = jdbctype;
	}

	/**
	 * @return the JdbcType equivalent to the AbapDataType
	 */
	public JDBCType getJdbcType() {
		return jdbctype;
	}
	
	/**
	 * @param jdbctype requested
	 * @return the AbapDataType matching the jdbctype or null
	 */
	public static AbapDataType of(JDBCType jdbctype) {
		switch (jdbctype) {
		case NULL: return NULL;
		case NVARCHAR: return C;
		case NUMERIC: return N;
		case ARRAY: return u;
		default: return null;
		}
	}

}
