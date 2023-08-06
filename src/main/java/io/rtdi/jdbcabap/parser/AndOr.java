package io.rtdi.jdbcabap.parser;

import java.sql.SQLException;
import java.util.List;

import org.antlr.v4.runtime.misc.ParseCancellationException;

import io.rtdi.jdbcabap.AbapTableMetadata;

/**
 * Adds an and/or condition to the same level
 */
public class AndOr implements Expression {
	private AndOrOp logicop;
	private Condition right;

	/**
	 * Creates and AndOr condition POJO
	 */
	public AndOr() {
	}

	/**
	 * (existing expression) AND/OR expression
	 * @param right the expression to and/or with
	 */
	public void setRight(Condition right) {
		this.right = right;
	}

	/**
	 * The logical operator, can be either AND or OR
	 * @param op operation to use
	 */
	public void setOperator(AndOrOp op) {
		this.logicop = op;
	}
	
	@Override
	public String toString() {
		return " " + logicop + " " + right;
	}

	@Override
	public void updateMetadata(List<AbapTableMetadata> tablemetadata) throws SQLException {
		if (right != null) {
			right.updateMetadata(tablemetadata);
		}
	}

	/**
	 * Supported operands
	 */
	public static enum AndOrOp {
		/**
		 * AND ...
		 */
		AND,
		/**
		 * OR ...
		 */
		OR;

		/**
		 * Convert the text and/or of any spelling into the operant
		 * 
		 * @param text either AND/OR in any spelling
		 * @return AND/OR
		 * @throws ParseCancellationException in case the text is neither AND nor OR
		 */
		static AndOrOp of(String text) throws ParseCancellationException {
			if (text == null) {
				throw new ParseCancellationException("Invalid operant, can only be AND/OR");
			} else if (text.equalsIgnoreCase(AND.name())) {
				return AND;
			} else if (text.equalsIgnoreCase(OR.name())) {
				return OR;
			} else {
				throw new ParseCancellationException("Invalid operant, can only be AND/OR");
			}
		}
	}
}
