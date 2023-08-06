package io.rtdi.jdbcabap.parser;

/**
 * All supported comparison operators
 */
public enum Comparison {
	/**
	 * equal
	 */
	EQ,
	/**
	 * not equal
	 */
	NOT_EQ,
	/**
	 * less than
	 */
	LT,
	/**
	 * greater than
	 */
	GT,
	/**
	 * less or equal
	 */
	LE,
	/**
	 * greater or equal
	 */
	GE,
	/**
	 * like
	 */
	LIKE,
	/**
	 * yet unknown comparison operand, needed for sequential parsing
	 */
	NONE;

	static Comparison of(String text) {
		switch (text.toUpperCase()) {
		case "=": return EQ;
		case "<>": return NOT_EQ;
		case "<": return LT;
		case ">": return GT;
		case "<=": return LE;
		case ">=": return GE;
		case "LIKE": return LIKE;
		default: return NONE;
		}
	}
	
	@Override
	public String toString() {
		switch(this) {
		case EQ: return " EQ ";
		case GE: return " GE ";
		case GT: return " GT ";
		case LE: return " LE ";
		case LT: return " LT ";
		case NOT_EQ: return " NE ";
		case LIKE: return " LIKE ";
		default: return "???";
		}
	}

}
