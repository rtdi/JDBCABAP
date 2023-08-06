package io.rtdi.jdbcabap;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoTable;

/**
 * Structure holding all information about a table
 */
public class AbapTableMetadata {
	private Map<String, AbapColumn> columns = new HashMap<>();
	private List<AbapColumn> columnlist = new ArrayList<>();
	private String tablename;

	private AbapTableMetadata(String tablename, AbapConnection conn) throws SQLException {
		this.tablename = tablename;
		try {
			JCoDestination destination = conn.getJCoDestination();
	        JCoFunction function = destination.getRepository().getFunction("RFC_GET_STRUCTURE_DEFINITION");
	        if(function == null) {
	            throw new SQLException("Function RFC_GET_STRUCTURE_DEFINITION not found in SAP");
	        }
	    	function.getImportParameterList().setValue("TABNAME", tablename);
	        function.execute(destination);
	    	JCoTable data = function.getTableParameterList().getTable("FIELDS");
	    	for (int i=0; i<data.getNumRows(); i++) {
	    		data.setRow(i);
	    		String fieldname = data.getString("FIELDNAME");
	    		int position = data.getInt("POSITION");
	    		int offset = data.getInt("OFFSET");
	    		int len = data.getInt("INTLENGTH");
	    		int scale = data.getInt("DECIMALS");
	    		String datatype = data.getString("EXID");
	    		AbapColumn c = new AbapColumn(fieldname, position, offset, len, scale, datatype);
	    		columnlist.add(c);
	    		columns.put(fieldname, c);
	    	}
		} catch (JCoException e) {
			throw new SQLException("Calling RFC_GET_STRUCTURE_DEFINITION failed with message: " + e.getMessage(), e);
		}
	}

	/**
	 * Returns the column of a named field
	 * 
	 * @param field is the name of the column to be returned
	 * @return the AbapColumn with this name
	 */
	public AbapColumn getField(String field) {
		return columns.get(field);
	}
	
	/**
	 * @return a list of all columns
	 */
	public List<AbapColumn> getFields() {
		return columnlist;
	}

	/**
	 * Provides the table metadata for a given table name using the specified connection
	 * @param tablename to get
	 * @param connection to use
	 * @return AbapTableMetadata for this table
	 * @throws SQLException if the metadata cannot be created, e.g. connection issues or table does not exist
	 */
	public static AbapTableMetadata get(String tablename, AbapConnection connection) throws SQLException {
		return new AbapTableMetadata(tablename, connection);
	}

	/**
	 * @return tablename of this table
	 */
	public String getTablename() {
		return tablename;
	}

}
