package io.rtdi.jdbcabap.parser;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import io.rtdi.jdbcabap.AbapDataType;
import io.rtdi.jdbcabap.AbapTableMetadata;

public class WhereClause implements Expression, WithParent {
	private Expression left;
	private List<AndOr> right;
	private BracketExpression parent;

	public WhereClause(BracketExpression parent) {
		this.parent = parent;
	}

	@Override
	public BracketExpression getParent() {
		return parent;
	}

	public void add(Expression expr) {
		if (left == null) {
			left = expr;
		} else {
			AndOr e = right.get(right.size()-1);
			e.setRight(expr);
		}
	}
	
	public void addOperator(String op) {
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
	public void updateMetadata(AbapTableMetadata tablemetadata) throws SQLException {
		if (left != null) {
			left.updateMetadata(tablemetadata);
		}
		if (right != null) {
			for (AndOr part : right) {
				part.updateMetadata(tablemetadata);
			}
		}
	}

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
