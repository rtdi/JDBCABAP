package io.rtdi.jdbcabap.parser;

import java.sql.SQLException;

import io.rtdi.jdbcabap.AbapTableMetadata;

public class AndOr implements Expression {
	private String logicop;
	private Expression right;

	public AndOr() {
	}

	public void setRight(Expression right) {
		this.right = right;
	}

	public void setOperator(String op) {
		this.logicop = op;
	}
	
	@Override
	public String toString() {
		return " " + logicop + " " + right;
	}

	@Override
	public void updateMetadata(AbapTableMetadata tablemetadata) throws SQLException {
		if (right != null) {
			right.updateMetadata(tablemetadata);
		}
	}

}
