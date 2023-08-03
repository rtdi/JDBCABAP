package io.rtdi.jdbcabap;

import java.util.List;

import io.rtdi.jdbcabap.sql.SQL;

public class AbapProcedure {

	public AbapProcedure(SQL sql) {
	}

	public boolean hasResultSets() {
		return true;
	}

	public List<AbapResultSet> getResultSets() {
		return null;
	}

}
