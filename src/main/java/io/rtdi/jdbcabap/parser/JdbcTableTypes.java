package io.rtdi.jdbcabap.parser;

public enum JdbcTableTypes {
	TABLE("TABLE"),
	VIEW("VIEW"),
	SYSTEM_TABLE("SYSTEM TABLE"),
	GLOBAL_TEMPORARY("GLOBAL TEMPORARY"),
	LOCAL_TEMPORARY("LOCAL TEMPORARY"),
	ALIAS("ALIAS"),
	SYNONYM("SYNONYM"),
	TYPE("TYPE");

	private String text;

	JdbcTableTypes(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
