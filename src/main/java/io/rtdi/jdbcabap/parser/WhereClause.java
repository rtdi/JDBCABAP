package io.rtdi.jdbcabap.parser;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import io.rtdi.jdbcabap.AbapDataType;
import io.rtdi.jdbcabap.AbapTableMetadata;
import io.rtdi.jdbcabap.parser.AndOr.AndOrOp;

/**
 * A clause with a left expression and a list of right expressions AND/ORed together
 */
public class WhereClause implements Condition, WithParent {
	private Condition left;
	private List<AndOr> right;
	private BracketExpression parent;

	/**
	 * @param parent of the where expression or null for the root
	 */
	public WhereClause(BracketExpression parent) {
		this.parent = parent;
	}

	@Override
	public BracketExpression getParent() {
		return parent;
	}

	/**
	 * Add another expression - first call goes to the left expression, all others wrap it into an AndOr element and add it to the right list
	 * @param expr Condition
	 */
	public void add(Condition expr) {
		if (left == null) {
			left = expr;
		} else {
			AndOr e = right.get(right.size()-1);
			e.setRight(expr);
		}
	}
	
	public void addOperator(AndOrOp op) {
		if (right == null) {
			right = new ArrayList<>();
		}
		AndOr r = new AndOr();
		r.setOperator(op);
		right.add(r);		
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(left);
		if (right != null) {
			for(AndOr e : right) {
				sb.append(e);
			}
		}
		return sb.toString();
	}

	@Override
	public void updateMetadata(List<AbapTableMetadata> tablemetadata) throws SQLException {
		if (left != null) {
			left.updateMetadata(tablemetadata);
		}
		if (right != null) {
			for (AndOr part : right) {
				part.updateMetadata(tablemetadata);
			}
		}
	}

	/**
	 * Derive from the input string and the data type the true string to be used for this value.
	 * Example: a date column with the value null is represented by the string 00000000
	 * @param dt data type of the value
	 * @param value the value text representation as provided by the user
	 * @return the internal text representation as required by ABAP
	 * @throws SQLException in case of incompatibilities
	 */
	public static String validateStringWithDatatype(AbapDataType dt, String value) throws SQLException {
		if (dt == null) {
			return value;
		}
		switch (dt) {
		case C: return value;
		case D:
			if (value == null) {
				return "00000000";
			} else if (value.matches("\\'[\\d]{8}\\'")) {
				return value;
			} else {
				throw new SQLException(String.format("The required datatype is a date but the input string %s is not in the form 'yyyymmdd'", value));
			}
		case F:
		case N:
		case P:
			if (value == null) {
				return "0";
			} else if (value.matches("[+-]?((\\d+(\\.\\d*)?)|(\\.\\d+))")) {
				return value;
			} else {
				throw new SQLException(String.format("The required datatype is a %s but the input string %s is not a decimal number", dt.name(), value));
			}
		case I:
			if (value == null) {
				return "0";
			} else if (value.matches("[\\d]+")) {
				return value;
			} else {
				throw new SQLException(String.format("The required datatype is a date but the input string %s is not in the form 'yyyymmdd'", value));
			}
		case T:
			if (value == null) {
				return "000000";
			} else if (value.matches("\\'[\\d]{6}\\'")) {
				return value;
			} else {
				throw new SQLException(String.format("The required datatype is a time but the input string %s is not in the form 'hhmmss'", value));
			}
		case X:
			return value;
		default:
			return value;
		}
	}
}
