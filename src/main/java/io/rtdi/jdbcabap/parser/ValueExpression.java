package io.rtdi.jdbcabap.parser;

import java.sql.SQLException;

import io.rtdi.jdbcabap.AbapColumn;
import io.rtdi.jdbcabap.AbapDataType;

public interface ValueExpression extends Expression {

	AbapDataType getDatatype();
	void setDatatype(AbapDataType dt) throws SQLException;
	String getText();
	int getLen();
	int getScale();
	void setMetadata(AbapColumn col) throws SQLException;

}
