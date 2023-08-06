package io.rtdi.jdbcabap.parser;

import java.sql.SQLException;
import java.util.List;

import io.rtdi.jdbcabap.AbapTableMetadata;

/**
 * An Expression is something that evaluates to a value
 */
public interface Expression {
	
	/**
	 * Some parsing of the expression happens in JDBC using the table metadata to figure out the data types of expressions and their compatibility
	 * 
	 * @param tablemetadata lists all used tables and their structure info
	 * @throws SQLException if the expression is invalid, e.g. a none existing column
	 */
	void updateMetadata(List<AbapTableMetadata> tablemetadata) throws SQLException;
	
}
