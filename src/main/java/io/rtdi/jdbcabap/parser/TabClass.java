package io.rtdi.jdbcabap.parser;

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

	public JdbcTableTypes getType() {
		return type;
	}
	
	public static TabClass[] allFor(JdbcTableTypes type) {
		switch (type) {
		case TABLE: return new TabClass[] {TRANSP, CLUSTER, POOL};
		case VIEW: return new TabClass[] {VIEW};
		case TYPE: return new TabClass[] {INTTAB, APPEND};
		default: return new TabClass[] {TRANSP, CLUSTER, POOL, VIEW};
		}
	}
}
