package io.rtdi.jdbcabap.parser;

/**
 * All possible values SAP data dictionary know for the TABCLASS
 */
public enum TabClass {
	
	/*
		TRANSP	Transparent table
		INTTAB	Structure
		CLUSTER	Cluster table
		POOL	Pooled table
		VIEW	Generated View Structure
		APPEND	Append structure
	 */
	TRANSP(JdbcTableTypes.TABLE),
	INTTAB(JdbcTableTypes.TYPE),
	CLUSTER(JdbcTableTypes.TABLE),
	POOL(JdbcTableTypes.TABLE),
	VIEW(JdbcTableTypes.VIEW),
	APPEND(JdbcTableTypes.TYPE);

	private JdbcTableTypes type;

	TabClass(JdbcTableTypes type) {
		this.type = type;
	}

	/**
	 * @return the equivalent jdbc table type for this TABCLASS
	 */
	public JdbcTableTypes getType() {
		return type;
	}
	
	/**
	 * @param type is the jdbc table type to search for
	 * @return all TABLASS values to be returned to produce the data
	 */
	public static TabClass[] allFor(JdbcTableTypes type) {
		switch (type) {
		case TABLE: return new TabClass[] {TRANSP, CLUSTER, POOL};
		case VIEW: return new TabClass[] {VIEW};
		case TYPE: return new TabClass[] {INTTAB, APPEND};
		default: return new TabClass[] {TRANSP, CLUSTER, POOL, VIEW};
		}
	}
}
