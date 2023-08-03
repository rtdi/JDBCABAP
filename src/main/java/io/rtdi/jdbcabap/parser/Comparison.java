package io.rtdi.jdbcabap.parser;

public enum Comparison {
	EQ,
	NOT_EQ,
	LT,
	GT,
	LE,
	GE,
	LIKE,
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
