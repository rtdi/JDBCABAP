package io.rtdi.jdbcabap.parser;

import java.sql.SQLException;

import io.rtdi.jdbcabap.AbapColumn;
import io.rtdi.jdbcabap.AbapDataType;

/**
 * Value expressions are all expressions that return a value and hence have data type information 
 */
public interface ValueExpression extends Expression {

	/**
	 * @return the AbapDataType or null if unknown
	 */
	AbapDataType getDatatype();
	/**
	 * Called when the data type of this expression is known in order to validate and assign
	 * 
	 * @param dt the targeted data type
	 * @throws SQLException in case there is a data type compatibility issue
	 */
	void setDatatype(AbapDataType dt) throws SQLException;
	/**
	 * @return the textual representation of the expression
	 */
	String getText();
	/**
	 * @return the length/precision information of the data type
	 */
	int getLen();
	/**
	 * @return the scale of a decimal or 0
	 */
	int getScale();
	/**
	 * Sets the data type of this expression using this column information
	 * @param col contain all the metadata info like data type, length
	 * @throws SQLException if there are inconsistencies between data type and value
	 */
	void setMetadata(AbapColumn col) throws SQLException;

}
