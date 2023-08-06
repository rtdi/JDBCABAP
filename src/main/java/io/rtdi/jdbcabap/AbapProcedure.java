package io.rtdi.jdbcabap;

import java.util.List;

import io.rtdi.jdbcabap.sql.SQL;

/**
 * Holds all the information about an Abap function module
 */
public class AbapProcedure {

	/**
	 * Create a new procedure for the sql statement
	 * @param sql call statement
	 */
	public AbapProcedure(SQL sql) {
	}

	/**
	 * @return true if the procedure has result sets
	 */
	public boolean hasResultSets() {
		return true;
	}

	/**
	 * @return a list of all result sets the function module returns
	 */
	public List<AbapResultSet> getResultSets() {
		return null;
	}

}
