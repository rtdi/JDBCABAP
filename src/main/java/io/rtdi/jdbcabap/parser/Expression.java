package io.rtdi.jdbcabap.parser;

import java.sql.SQLException;

import io.rtdi.jdbcabap.AbapTableMetadata;

public interface Expression {
	
	void updateMetadata(AbapTableMetadata tablemetadata) throws SQLException;
	
}
