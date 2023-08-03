package io.rtdi.jdbcabap;

import java.sql.JDBCType;

public enum AbapDataType {
	I(JDBCType.INTEGER),	// Integer 4 bytes
	F(JDBCType.FLOAT), 		// float 8 bytes
	P(JDBCType.DECIMAL),	// packed number 1-16
	C(JDBCType.NVARCHAR),	// char 1-65536
	D(JDBCType.DATE),		// date 8 bytes
	N(JDBCType.DECIMAL),	// numeric 1-65536
	T(JDBCType.TIME),		// time 6 bytes
	X(JDBCType.VARBINARY),	// hex 1-65536
	NULL(JDBCType.NVARCHAR);
	
	private JDBCType jdbctype;

	AbapDataType(JDBCType jdbctype) {
		this.jdbctype = jdbctype;
	}

	public JDBCType getJdbcType() {
		return jdbctype;
	}
	
	public static AbapDataType of(JDBCType jdbctype) {
		switch (jdbctype) {
		case NULL: return NULL;
		case NVARCHAR: return C;
		case NUMERIC: return N;
		default: return null;
		}
	}

}
