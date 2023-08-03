package io.rtdi.jdbcabap;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoTable;

import io.rtdi.jdbcabap.parser.ColumnExpression;
import io.rtdi.jdbcabap.parser.Constant;
import io.rtdi.jdbcabap.parser.ProjectionColumn;
import io.rtdi.jdbcabap.sql.SQL;

public class AbapStatement implements Statement {

	private AbapConnection connection;
	private int querytimeout;
	protected SQL sql;
	private int maxrows;
	protected AbapProcedure procedure;
	protected int resultsetindex;
	private RowTransformation rowtransform;

	AbapStatement(AbapConnection connection) {
		this.connection = connection;
	}

	protected AbapResultSet rfcReadTable() throws SQLException {
       try {
            JCoFunction function = connection.getJCoDestination().getRepository().getFunction("/BODS/RFC_READ_TABLE2");
            if(function == null) {
                throw new SQLException("Function /BODS/RFC_READ_TABLE2 not found in SAP");
            }
        	function.getImportParameterList().setValue("QUERY_TABLE", sql.getTablename());
        	AbapResultSet rs = new AbapResultSet(sql, this);
        	/*
        	 * The FIELDS structure and result set can be different, e.g. the sql might contain
        	 * constants, functions, null values,...
        	 */
        	JCoTable fields = function.getTableParameterList().getTable("FIELDS");
        	List<ColumnExpression> datatypes = new ArrayList<>();
        	if (sql.getFields() != null) {
        		for (ProjectionColumn field : sql.getFields()) {
        			if (field.getExpression() instanceof ColumnExpression c) {
	        			fields.appendRow();
	        			fields.setValue("FIELDNAME", c.getColumnname());
	        			datatypes.add(c);
        			}
        		}
        	}
        	if (sql.getLimit() != null) {
        		function.getImportParameterList().setValue("ROWCOUNT", sql.getLimit().intValue());
        	}
        	if (sql.getOffset() != null) {
        		function.getImportParameterList().setValue("ROWSKIPS", sql.getOffset().intValue());
        	}
        	String whereclause = sql.getWhereClause();
        	if (whereclause != null) {
        		JCoTable options = function.getTableParameterList().getTable("OPTIONS");
        		int pos = 0;
        		/*
        		 * break the entire text into lines of 72 chars
        		 */
        		do {
        			options.appendRow();
            		int maxpos;
            		if (pos+72 < whereclause.length()) {
            			maxpos = whereclause.substring(0, pos+72).lastIndexOf(' ');
            		} else {
            			maxpos = whereclause.length();
            		}
        			options.setValue("TEXT", whereclause.substring(pos, maxpos));
        			pos = maxpos;
        		} while (pos < whereclause.length());
        	}
            function.execute(connection.getJCoDestination());
            String outputjcotablename = function.getExportParameterList().getString("OUT_TABLE"); 
        	JCoTable data = function.getTableParameterList().getTable(outputjcotablename);
        	fields = function.getTableParameterList().getTable("FIELDS");
        	
        	/*
        	 * The function updates the FIELDS array with the offset/len information required for the fixed-width string parsing
        	 */
        	int[] offsets = new int[fields.getNumRows()];
        	int[] lengths = new int[fields.getNumRows()];
    		for (int c=0; c<fields.getNumRows(); c++) {
    			fields.setRow(c);
    			int offset = fields.getInt("OFFSET");
    			int len = fields.getInt("LENGTH");
    			offsets[c] = offset;
    			lengths[c] = len;
    		}
        	
        	for (int i=0; i<data.getNumRows(); i++) {
        		data.setRow(i);
        		String rowtext = data.getString("WA");
        		Object[] row = rs.append();
        		/*
        		 * First create a map with all values.
        		 */
        		Map<String, Object> rowvalues = new HashMap<>();
        		for (int c=0; c<fields.getNumRows(); c++) {
        			int offset = offsets[c];
        			int len = lengths[c];
        			if (offset < rowtext.length()) {
        				int endindex = Math.min(offset+len, rowtext.length());
        				String text = rowtext.substring(offset, endindex).stripTrailing();
        				ColumnExpression field = datatypes.get(c);
        				rowvalues.put(field.getColumnname(), convert(text, field.getDatatype()));
        			}
        		}
        		/*
        		 * Second project these values into the resultset
        		 */
        		for (ProjectionColumn field : sql.getFields()) {
        			if (field.getExpression() instanceof ColumnExpression c) {
        				row[field.getPosition()] = rowvalues.get(c.getColumnname());
        			} else if (field.getExpression() instanceof Constant c) {
        				row[field.getPosition()] = c.getValue();
        			}
        		}
        		if (rowtransform != null) {
        			rowtransform.apply(row);
        		}
        	}
        	return rs;
        } catch(JCoException e) {
            throw new SQLException("Failed to execute /BODS/RFC_READ_TABLE2", e);
        }
 	}
	
	public static Object convert(String inputstring, AbapDataType datatype) throws SQLException {
		if (inputstring == null || inputstring.length() == 0) {
			return null;
		} else {
			switch (datatype) {
			case C:
				return inputstring;
			case D:
				if ("00000000".equals(inputstring)) {
					return null;
				} else {
					try {
						LocalDate date = LocalDate.parse(inputstring, AbapResultSet.formatteryyyymmdd);
						return java.sql.Date.valueOf(date);
					} catch (DateTimeParseException e) {
						throw new SQLException(String.format("Cannot convert the text %s to a date", inputstring), e);
					}
				}
			case F:
				try {
					return Float.valueOf(inputstring);
				} catch (NumberFormatException e) {
					throw new SQLException(String.format("Cannot convert the text %s to a float", inputstring), e);
				}
			case I:
				try {
					return Integer.valueOf(inputstring);
				} catch (NumberFormatException e) {
					throw new SQLException(String.format("Cannot convert the text %s to an integer", inputstring), e);
				}
			case N:
				try {
					return new BigDecimal(inputstring);
				} catch (NumberFormatException e) {
					throw new SQLException(String.format("Cannot convert the text %s to a decimal", inputstring), e);
				}
			case P:
				try {
					return new BigDecimal(inputstring);
				} catch (NumberFormatException e) {
					throw new SQLException(String.format("Cannot convert the text %s to a decimal", inputstring), e);
				}
			case T:
				try {
					LocalTime time = LocalTime.parse(inputstring, AbapResultSet.formatterhhmmss);
					return java.sql.Time.valueOf(time);
				} catch (DateTimeParseException e) {
					throw new SQLException(String.format("Cannot convert the text %s to a time", inputstring), e);
				}
			case X:
				return inputstring.getBytes();
			default:
				return null;
			}
		}
	}


	@Override
	public AbapResultSet executeQuery(String sqltext) throws SQLException {
		sql = new SQL(sqltext);
		/*
		 * Updating the metadata is required so that proper value conversions can happen, e.g. where DATS is null must be turned into a DATS = '00000000'
		 */
	   	AbapTableMetadata tablemetadata = AbapTableMetadata.get(sql.getTablename(), connection);
    	sql.updateMetadata(tablemetadata);
		return rfcReadTable();
	}

	@Override
	public int executeUpdate(String s) throws SQLException {
		throw new SQLException("Not implemented");
	}
	
	@Override
	public void close() throws SQLException {
		// Do nothing
	}

	@Override
	public int getMaxFieldSize() throws SQLException {
		return 0;
	}

	@Override
	public void setMaxFieldSize(int i) throws SQLException {
	}

	@Override
	public int getMaxRows() throws SQLException {
		return maxrows;
	}

	@Override
	public void setMaxRows(int i) throws SQLException {
		maxrows = i;
	}

	@Override
	public void setEscapeProcessing(boolean b) throws SQLException {
	}

	@Override
	public int getQueryTimeout() throws SQLException {
		return querytimeout;
	}

	@Override
	public void setQueryTimeout(int i) throws SQLException {
		this.querytimeout = i;
	}

	@Override
	public void cancel() throws SQLException {
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		return null;
	}

	@Override
	public void clearWarnings() throws SQLException {
	}

	@Override
	public void setCursorName(String s) throws SQLException {
	}

	@Override
	public boolean execute(String sqltext) throws SQLException {
		sql = new SQL(sqltext);
		procedure = new AbapProcedure(sql);
		resultsetindex = 0;
		return procedure.hasResultSets();
	}

	@Override
	public ResultSet getResultSet() throws SQLException {
		if (procedure != null && resultsetindex > 0 && resultsetindex <= procedure.getResultSets().size()) {
			return procedure.getResultSets().get(resultsetindex-1);
		} else {
			return null;
		}
	}

	@Override
	public int getUpdateCount() throws SQLException {
		return 0;
	}

	@Override
	public boolean getMoreResults() throws SQLException {
		if (procedure != null && resultsetindex < procedure.getResultSets().size()) {
			resultsetindex++;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void setFetchDirection(int i) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public int getFetchDirection() throws SQLException {
		return ResultSet.FETCH_FORWARD;
	}

	@Override
	public void setFetchSize(int i) throws SQLException {
	}

	@Override
	public int getFetchSize() throws SQLException {
		return 1;
	}

	@Override
	public int getResultSetConcurrency() throws SQLException {
		return ResultSet.CONCUR_READ_ONLY;
	}

	@Override
	public int getResultSetType() throws SQLException {
		return ResultSet.TYPE_SCROLL_INSENSITIVE;
	}

	@Override
	public void addBatch(String s) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void clearBatch() throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public int[] executeBatch() throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public AbapConnection getConnection() throws SQLException {
		return connection;
	}

	@Override
	public boolean getMoreResults(int i) throws SQLException {
		return getMoreResults();
	}

	@Override
	public ResultSet getGeneratedKeys() throws SQLException {
		return null;
	}

	@Override
	public int executeUpdate(String s, int i) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public int executeUpdate(String s, int[] ints) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public int executeUpdate(String s, String[] strings) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public boolean execute(String s, int i) throws SQLException {
		return execute(s);
	}

	@Override
	public boolean execute(String s, int[] ints) throws SQLException {
		return execute(s);
	}

	@Override
	public boolean execute(String s, String[] strings) throws SQLException {
		return execute(s);
	}

	@Override
	public int getResultSetHoldability() throws SQLException {
		return ResultSet.CLOSE_CURSORS_AT_COMMIT;
	}

	@Override
	public boolean isClosed() throws SQLException {
		return connection.isClosed();
	}

	@Override
	public void setPoolable(boolean b) throws SQLException {
	}

	@Override
	public boolean isPoolable() throws SQLException {
		return true;
	}

	@Override
	public void closeOnCompletion() throws SQLException {
	}

	@Override
	public boolean isCloseOnCompletion() throws SQLException {
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> aClass) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public boolean isWrapperFor(Class<?> aClass) throws SQLException {
		throw new SQLException("Not implemented");
	}

	public RowTransformation getRowTransform() {
		return rowtransform;
	}

	public void setRowTransform(RowTransformation rowtransform) {
		this.rowtransform = rowtransform;
	}
}