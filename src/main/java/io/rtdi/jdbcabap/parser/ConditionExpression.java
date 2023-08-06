package io.rtdi.jdbcabap.parser;

import java.sql.SQLException;
import java.util.List;

import io.rtdi.jdbcabap.AbapDataType;
import io.rtdi.jdbcabap.AbapTableMetadata;

/**
 * An Expression that returns true/false
 */
public class ConditionExpression implements Condition, WithParent {
	private ValueExpression left;
	private Comparison op;
	private ValueExpression right;
	private WhereClause parent;

	/**
	 * Condition is part of parent
	 * 
	 * @param parent expression
	 */
	public ConditionExpression(WhereClause parent) {
		this.parent = parent;
	}

	@Override
	public WithParent getParent() {
		return parent;
	}

	/**
	 * Comparison operation
	 * 
	 * @param text of the comparison
	 */
	public void setOp(String text) {
		op = Comparison.of(text);
	}
	
	/**
	 * Left side of the comparison
	 * 
	 * @param e expression
	 */
	public void setLeft(ValueExpression e) {
		this.left = e;
	}
	
	/**
	 * Right side of the comparison
	 * 
	 * @param e expression
	 */
	public void setRight(ValueExpression e) {
		this.right = e;
	}

	@Override
	public String toString() {
		return "" + left + op + right;
	}

	@Override
	public void updateMetadata(List<AbapTableMetadata> tablemetadata) throws SQLException {
		if (left != null && right != null) {
			left.updateMetadata(tablemetadata);
			right.updateMetadata(tablemetadata);
			AbapDataType datatype = left.getDatatype();
			if (datatype != null) {
				right.setDatatype(datatype);
			} else {
				datatype = right.getDatatype();
				if (datatype != null) {
					left.setDatatype(datatype);
				}
			}
		}
	}

}
