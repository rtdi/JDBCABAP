package io.rtdi.jdbcabap.parser;

import java.sql.SQLException;
import java.util.List;

import io.rtdi.jdbcabap.AbapTableMetadata;

/**
 * A unary expression like NOT condition
 */
public class UnaryExpression implements Expression {
	private Expression expr;
	private UnaryOperator op;
	
	@Override
	public String toString() {
		return op + " " + expr;
	}

	@Override
	public void updateMetadata(List<AbapTableMetadata> tablemetadata) throws SQLException {
		if (expr != null) {
			expr.updateMetadata(tablemetadata);
		}
	}
	
	/**
	 * @return the unary operant
	 */
	public UnaryOperator getOp() {
		return op;
	}
	
	/**
	 * @return the child expression
	 */
	public Expression getRight() {
		return expr;
	}

}
