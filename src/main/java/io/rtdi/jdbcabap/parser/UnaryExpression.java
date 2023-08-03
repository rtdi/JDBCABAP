package io.rtdi.jdbcabap.parser;

import java.sql.SQLException;

import io.rtdi.jdbcabap.AbapTableMetadata;

public class UnaryExpression implements Expression {
	private Expression expr;
	private UnaryOperator op;
	
	@Override
	public String toString() {
		return op + " " + expr;
	}

	@Override
	public void updateMetadata(AbapTableMetadata tablemetadata) throws SQLException {
		if (expr != null) {
			expr.updateMetadata(tablemetadata);
		}
	}

}
