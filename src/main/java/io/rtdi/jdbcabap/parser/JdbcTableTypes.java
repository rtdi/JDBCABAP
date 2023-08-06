package io.rtdi.jdbcabap.parser;

/**
 * All supported object types this driver supports
 */
public enum JdbcTableTypes {
	/**
	 * The object is a database table
	 */
	TABLE("TABLE"),
	/**
	 * The object is a database view
	 */
	VIEW("VIEW"),
	/**
	 * currently not used
	 */
	SYSTEM_TABLE("SYSTEM TABLE"),
	/**
	 * currently not used
	 */
	GLOBAL_TEMPORARY("GLOBAL TEMPORARY"),
	/**
	 * currently not used
	 */
	LOCAL_TEMPORARY("LOCAL TEMPORARY"),
	/**
	 * not supported by Abap
	 */
	ALIAS("ALIAS"),
	/**
	 * not supported by Abap
	 */
	SYNONYM("SYNONYM"),
	/**
	 * An Abap structure
	 */
	TYPE("TYPE");

	private String text;

	JdbcTableTypes(String text) {
		this.text = text;
	}

	/**
	 * @return the string as returned by the database metadata methods
	 */
	public String getText() {
		return text;
	}
}
