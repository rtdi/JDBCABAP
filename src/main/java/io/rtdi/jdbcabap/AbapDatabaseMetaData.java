package io.rtdi.jdbcabap;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowIdLifetime;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoTable;

import io.rtdi.jdbcabap.parser.ColumnExpression;
import io.rtdi.jdbcabap.parser.JdbcTableTypes;
import io.rtdi.jdbcabap.parser.ProjectionColumn;
import io.rtdi.jdbcabap.parser.TabClass;
import io.rtdi.jdbcabap.sql.SimpleResultSetMetadata;

/**
 * Implementation of the DatabaseMetaData
 */
public class AbapDatabaseMetaData implements DatabaseMetaData {

	private AbapConnection conn;

	/**
	 * @param conn connection this metadata object belongs to
	 */
	public AbapDatabaseMetaData(AbapConnection conn) {
		this.conn = conn;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}

	@Override
	public boolean allProceduresAreCallable() throws SQLException {
		return true;
	}

	@Override
	public boolean allTablesAreSelectable() throws SQLException {
		return true;
	}

	@Override
	public String getURL() throws SQLException {
		return conn.getJdbcUrl();
	}

	@Override
	public String getUserName() throws SQLException {
		return conn.getUsername();
	}

	@Override
	public boolean isReadOnly() throws SQLException {
		return false;
	}

	@Override
	public boolean nullsAreSortedHigh() throws SQLException {
		return true;
	}

	@Override
	public boolean nullsAreSortedLow() throws SQLException {
		return false;
	}

	@Override
	public boolean nullsAreSortedAtStart() throws SQLException {
		return false;
	}

	@Override
	public boolean nullsAreSortedAtEnd() throws SQLException {
		return false;
	}

	@Override
	public String getDatabaseProductName() throws SQLException {
		return "SAP ABAP connection";
	}

	@Override
	public String getDatabaseProductVersion() throws SQLException {
		return null;
	}

	@Override
	public String getDriverName() throws SQLException {
		return "io.rtdi.jdbcabap.AbapDriver";
	}

	@Override
	public String getDriverVersion() throws SQLException {
		return "1.0";
	}

	@Override
	public int getDriverMajorVersion() {
		return 1;
	}

	@Override
	public int getDriverMinorVersion() {
		return 0;
	}

	@Override
	public boolean usesLocalFiles() throws SQLException {
		return false;
	}

	@Override
	public boolean usesLocalFilePerTable() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsMixedCaseIdentifiers() throws SQLException {
		return false;
	}

	@Override
	public boolean storesUpperCaseIdentifiers() throws SQLException {
		return true;
	}

	@Override
	public boolean storesLowerCaseIdentifiers() throws SQLException {
		return false;
	}

	@Override
	public boolean storesMixedCaseIdentifiers() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsMixedCaseQuotedIdentifiers() throws SQLException {
		return true;
	}

	@Override
	public boolean storesUpperCaseQuotedIdentifiers() throws SQLException {
		return true;
	}

	@Override
	public boolean storesLowerCaseQuotedIdentifiers() throws SQLException {
		return true;
	}

	@Override
	public boolean storesMixedCaseQuotedIdentifiers() throws SQLException {
		return true;
	}

	@Override
	public String getIdentifierQuoteString() throws SQLException {
		return "\"";
	}

	@Override
	public String getSQLKeywords() throws SQLException {
		return null;
	}

	@Override
	public String getNumericFunctions() throws SQLException {
		return null;
	}

	@Override
	public String getStringFunctions() throws SQLException {
		return null;
	}

	@Override
	public String getSystemFunctions() throws SQLException {
		return null;
	}

	@Override
	public String getTimeDateFunctions() throws SQLException {
		return null;
	}

	@Override
	public String getSearchStringEscape() throws SQLException {
		return null;
	}

	@Override
	public String getExtraNameCharacters() throws SQLException {
		return null;
	}

	@Override
	public boolean supportsAlterTableWithAddColumn() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsAlterTableWithDropColumn() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsColumnAliasing() throws SQLException {
		return true;
	}

	@Override
	public boolean nullPlusNonNullIsNull() throws SQLException {
		return true;
	}

	@Override
	public boolean supportsConvert() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsConvert(int fromType, int toType) throws SQLException {
		return false;
	}

	@Override
	public boolean supportsTableCorrelationNames() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsDifferentTableCorrelationNames() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsExpressionsInOrderBy() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsOrderByUnrelated() throws SQLException {
		return true;
	}

	@Override
	public boolean supportsGroupBy() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsGroupByUnrelated() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsGroupByBeyondSelect() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsLikeEscapeClause() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsMultipleResultSets() throws SQLException {
		return true;
	}

	@Override
	public boolean supportsMultipleTransactions() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsNonNullableColumns() throws SQLException {
		return true;
	}

	@Override
	public boolean supportsMinimumSQLGrammar() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsCoreSQLGrammar() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsExtendedSQLGrammar() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsANSI92EntryLevelSQL() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsANSI92IntermediateSQL() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsANSI92FullSQL() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsIntegrityEnhancementFacility() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsOuterJoins() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsFullOuterJoins() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsLimitedOuterJoins() throws SQLException {
		return false;
	}

	@Override
	public String getSchemaTerm() throws SQLException {
		return null;
	}

	@Override
	public String getProcedureTerm() throws SQLException {
		return "FUNCTIONMODULE";
	}

	@Override
	public String getCatalogTerm() throws SQLException {
		return null;
	}

	@Override
	public boolean isCatalogAtStart() throws SQLException {
		return true;
	}

	@Override
	public String getCatalogSeparator() throws SQLException {
		return ".";
	}

	@Override
	public boolean supportsSchemasInDataManipulation() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsSchemasInProcedureCalls() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsSchemasInTableDefinitions() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsSchemasInIndexDefinitions() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsSchemasInPrivilegeDefinitions() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsCatalogsInDataManipulation() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsCatalogsInProcedureCalls() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsCatalogsInTableDefinitions() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsCatalogsInIndexDefinitions() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsCatalogsInPrivilegeDefinitions() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsPositionedDelete() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsPositionedUpdate() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsSelectForUpdate() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsStoredProcedures() throws SQLException {
		return true;
	}

	@Override
	public boolean supportsSubqueriesInComparisons() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsSubqueriesInExists() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsSubqueriesInIns() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsSubqueriesInQuantifieds() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsCorrelatedSubqueries() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsUnion() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsUnionAll() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsOpenCursorsAcrossCommit() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsOpenCursorsAcrossRollback() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsOpenStatementsAcrossCommit() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsOpenStatementsAcrossRollback() throws SQLException {
		return false;
	}

	@Override
	public int getMaxBinaryLiteralLength() throws SQLException {
		return 65535;
	}

	@Override
	public int getMaxCharLiteralLength() throws SQLException {
		return 65535;
	}

	@Override
	public int getMaxColumnNameLength() throws SQLException {
		return 30;
	}

	@Override
	public int getMaxColumnsInGroupBy() throws SQLException {
		return 30;
	}

	@Override
	public int getMaxColumnsInIndex() throws SQLException {
		return 30;
	}

	@Override
	public int getMaxColumnsInOrderBy() throws SQLException {
		return 30;
	}

	@Override
	public int getMaxColumnsInSelect() throws SQLException {
		return 500;
	}

	@Override
	public int getMaxColumnsInTable() throws SQLException {
		return 500;
	}

	@Override
	public int getMaxConnections() throws SQLException {
		return 0;
	}

	@Override
	public int getMaxCursorNameLength() throws SQLException {
		return 16;
	}

	@Override
	public int getMaxIndexLength() throws SQLException {
		return 0;
	}

	@Override
	public int getMaxSchemaNameLength() throws SQLException {
		return 0;
	}

	@Override
	public int getMaxProcedureNameLength() throws SQLException {
		return 30;
	}

	@Override
	public int getMaxCatalogNameLength() throws SQLException {
		return 0;
	}

	@Override
	public int getMaxRowSize() throws SQLException {
		return 0;
	}

	@Override
	public boolean doesMaxRowSizeIncludeBlobs() throws SQLException {
		return true;
	}

	@Override
	public int getMaxStatementLength() throws SQLException {
		return 0;
	}

	@Override
	public int getMaxStatements() throws SQLException {
		return 0;
	}

	@Override
	public int getMaxTableNameLength() throws SQLException {
		return 30;
	}

	@Override
	public int getMaxTablesInSelect() throws SQLException {
		return 1;
	}

	@Override
	public int getMaxUserNameLength() throws SQLException {
		return 0;
	}

	@Override
	public int getDefaultTransactionIsolation() throws SQLException {
		return Connection.TRANSACTION_READ_COMMITTED;
	}

	@Override
	public boolean supportsTransactions() throws SQLException {
		return true;
	}

	@Override
	public boolean supportsTransactionIsolationLevel(int level) throws SQLException {
		if (level == Connection.TRANSACTION_READ_COMMITTED) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean supportsDataDefinitionAndDataManipulationTransactions() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsDataManipulationTransactionsOnly() throws SQLException {
		return false;
	}

	@Override
	public boolean dataDefinitionCausesTransactionCommit() throws SQLException {
		return true;
	}

	@Override
	public boolean dataDefinitionIgnoredInTransactions() throws SQLException {
		return false;
	}

	@Override
	public ResultSet getProcedures(String catalog, String schemaPattern, String procedureNamePattern) throws SQLException {
		/*
			1.PROCEDURE_CAT String => procedure catalog (may be null) 
			2.PROCEDURE_SCHEM String => procedure schema (may be null) 
			3.PROCEDURE_NAME String => procedure name 
			4. reserved for future use 
			5. reserved for future use 
			6. reserved for future use 
			7.REMARKS String => explanatory comment on the procedure 
			8.PROCEDURE_TYPE short => kind of procedure:
				◦ procedureResultUnknown - Cannot determine if a return value will be returned 
				◦ procedureNoResult - Does not return a return value 
				◦ procedureReturnsResult - Returns a return value 
			9.SPECIFIC_NAME String => The name which uniquely identifies this procedure within its schema. 
		 */
		String sqltext = "select null as PROCEDURE_CAT, null as PROCEDURE_SCHEM, FUNCNAME as PROCEDURE_NAME, null as reserved1, null as reserved2, "
				+ "null as reserved3, null as REMARKS, null as PROCEDURE_TYPE, FUNCNAME as SPECIFIC_NAME "
				+ "from V_FDIR where FMODE = 'R' and ACTIVE='X'";
		if (procedureNamePattern != null) {
			sqltext += " and FUNCNAME LIKE '" + procedureNamePattern.replace('*', '%') + "'";
		}
		try (AbapPreparedStatement stmt = conn.prepareStatement(sqltext)) {
			stmt.setDataType(1, AbapDataType.C);
			stmt.setDataType(2, AbapDataType.C);
			stmt.setDataType(4, AbapDataType.C);
			stmt.setDataType(5, AbapDataType.C);
			stmt.setDataType(6, AbapDataType.C);
			stmt.setDataType(7, AbapDataType.C);
			stmt.setDataType(8, AbapDataType.I);
			stmt.setRowTransform(new RowTransformation() {
				
				@Override
				public void apply(Object[] row) {
					// PROCEDURE_TYPE
					row[7] = DatabaseMetaData.procedureResultUnknown;
				}
			});
			return stmt.executeQuery();
		}
	}

	@Override
	public ResultSet getProcedureColumns(String catalog, String schemaPattern, String procedureNamePattern, String columnNamePattern) throws SQLException {
		Pattern columnpattern = null;
		if (columnNamePattern != null) {
			columnpattern = Pattern.compile(columnNamePattern.replace("*", ".*"));
		}
		/*
			1.PROCEDURE_CAT String => procedure catalog (may be null) 
			2.PROCEDURE_SCHEM String => procedure schema (may be null) 
			3.PROCEDURE_NAME String => procedure name 
			4.COLUMN_NAME String => column/parameter name 
			5.COLUMN_TYPE Short => kind of column/parameter:
				◦ procedureColumnUnknown - nobody knows 
				◦ procedureColumnIn - IN parameter 
				◦ procedureColumnInOut - INOUT parameter 
				◦ procedureColumnOut - OUT parameter 
				◦ procedureColumnReturn - procedure return value 
				◦ procedureColumnResult - result column in ResultSet 
			6.DATA_TYPE int => SQL type from java.sql.Types 
			7.TYPE_NAME String => SQL type name, for a UDT type the type name is fully qualified 
			8.PRECISION int => precision 
			9.LENGTH int => length in bytes of data 
			10.SCALE short => scale - null is returned for data types where SCALE is not applicable. 
			11.RADIX short => radix 
			12.NULLABLE short => can it contain NULL.
				◦ procedureNoNulls - does not allow NULL values 
				◦ procedureNullable - allows NULL values 
				◦ procedureNullableUnknown - nullability unknown 
			13.REMARKS String => comment describing parameter/column 
			14.COLUMN_DEF String => default value for the column, which should be interpreted as a string when the value is enclosed in single quotes (may be null)
				◦ The string NULL (not enclosed in quotes) - if NULL was specified as the default value 
				◦ TRUNCATE (not enclosed in quotes) - if the specified default value cannot be represented without truncation 
				◦ NULL - if a default value was not specified 
			15.SQL_DATA_TYPE int => reserved for future use 
			16.SQL_DATETIME_SUB int => reserved for future use 
			17.CHAR_OCTET_LENGTH int => the maximum length of binary and character based columns. For any other datatype the returned value is a NULL 
			18.ORDINAL_POSITION int => the ordinal position, starting from 1, for the input and output parameters for a procedure. A value of 0 is returned if this row describes the procedure's return value. For result set columns, it is the ordinal position of the column in the result set starting from 1. If there are multiple result sets, the column ordinal positions are implementation defined. 
			19.IS_NULLABLE String => ISO rules are used to determine the nullability for a column.
				◦ YES --- if the column can include NULLs 
				◦ NO --- if the column cannot include NULLs 
				◦ empty string --- if the nullability for the column is unknown 
			20.SPECIFIC_NAME String => the name which uniquely identifies this procedure within its schema. 
		 */
		List<String> procedurenames;
		if (procedureNamePattern != null && procedureNamePattern.contains("*")) {
			ResultSet procrs = getProcedures(catalog, schemaPattern, procedureNamePattern);
			procedurenames = new ArrayList<>();
			while (procrs.next()) {
				procedurenames.add(procrs.getString(3));
			}
		} else {
			procedurenames = Collections.singletonList(procedureNamePattern);
		}
		try {	
	        JCoFunction function = conn.getJCoDestination().getRepository().getFunction("RFC_GET_FUNCTION_INTERFACE");
	        if (function == null) {
	            throw new SQLException("Function RFC_GET_FUNCTION_INTERFACE not found in SAP");
	        }
	        AbapProcedureResultSet rs = new AbapProcedureResultSet();
	        for (String name : procedurenames) {
		    	function.getImportParameterList().setValue("FUNCNAME", name);
		    	function.getImportParameterList().setValue("LANGUAGE", "E");
		        function.execute(conn.getJCoDestination());
		    	JCoTable data = function.getTableParameterList().getTable("PARAMS");
		    	
		    	for (int i=0; i<data.getNumRows(); i++) {
		    		boolean skip = false;
		    		data.setRow(i);
		    		String parameter = data.getString("PARAMETER");
		    		if (columnpattern == null || columnpattern.matcher(parameter).matches()) {
			    		// String paramfieldname = data.getString("FIELDNAME");
			    		String paramexid = data.getString("EXID");
			    		int paramprecision = data.getInt("INTLENGTH");
			    		// String paramdefault = data.getString("DEFAULT");
			    		int paramtype = DatabaseMetaData.procedureColumnUnknown;
			    		switch (data.getString("PARAMCLASS")) {
			    		case "I": paramtype = DatabaseMetaData.procedureColumnIn; break;
			    		case "E": paramtype = DatabaseMetaData.procedureColumnOut; break;
			    		case "T": paramtype = DatabaseMetaData.procedureColumnResult; break;
			    		case "X": skip = true; break;
			    		default: skip = true; break;
			    		}
			    		if (!skip) {
				    		Object[] row = rs.append();
				    		row[2] = name;
				    		row[3] = parameter;
				    		row[4] = paramtype;
				    		if (paramexid != null && paramexid.length() != 0) {
				    			row[5] = AbapDataType.valueOf(paramexid).getJdbcType();
				    		} else {
				    			row[5] = AbapDataType.C.getJdbcType(); // should not happen as only import/export/table parameters can be in the paramclass
				    		}
				    		if (paramexid.equals(AbapDataType.u.name())) {
				    			row[6] = data.getString("TABNAME");
				    		}
				    		row[7] = paramprecision;
				    		row[8] = paramprecision;
				    		row[9] = data.getInt("DECIMALS");
				    		row[10] = 10;
				    		if ("X".equals(data.getString("OPTIONAL"))) {
				    			row[11] = DatabaseMetaData.procedureNullable;
				    			row[18] = "YES";
				    		} else {
				    			row[11] = DatabaseMetaData.procedureNoNulls;
				    			row[18] = "NO";
				    		}
				    		row[12] = data.getString("PARAMTEXT");
				    		row[14] = row[5];
				    		row[15] = 0;
				    		row[16] = paramprecision;
				    		row[17] = data.getInt("POSITION");
				    		row[19] = name;
			    		}
		    		}
		    	}
			}
	    	return rs;
	    } catch (JCoException e) {
	        throw new SQLException("Failed to execute RFC_GET_FUNCTION_INTERFACE", e);
	    }
	}

	@Override
	public ResultSet getTables(String catalog, String schemaPattern, String tableNamePattern, String[] types) throws SQLException {
		//1.TABLE_CAT String => table catalog (may be null) 
		//2.TABLE_SCHEM String => table schema (may be null) 
		//3.TABLE_NAME String => table name 
		//4.TABLE_TYPE String => table type. Typical types are "TABLE","VIEW", "SYSTEM TABLE", "GLOBAL TEMPORARY","LOCAL TEMPORARY", "ALIAS", "SYNONYM". 
		//5.REMARKS String => explanatory comment on the table (may be null) 
		//6.TYPE_CAT String => the types catalog (may be null) 
		//7.TYPE_SCHEM String => the types schema (may be null) 
		//8.TYPE_NAME String => type name (may be null) 
		//9.SELF_REFERENCING_COL_NAME String => name of the designated"identifier" column of a typed table (may be null) 
		//10.REF_GENERATION String => specifies how values in SELF_REFERENCING_COL_NAME are created. Values are "SYSTEM", "USER", "DERIVED". (may be null) 
		String sqltext = "select null as TABLE_CAT, null as TABLE_SCHEM, TABNAME as TABLE_NAME, TABCLASS as TABLE_TYPE, DDTEXT as REMARKS, "
				+ "null as TYPE_CAT, null as TYPE_SCHEM, null as TYPE_NAME, null as SELF_REFERENCING_COL_NAME, null as REF_GENERATION "
				+ "from DD02V where DDLANGUAGE = 'E'";
		if (tableNamePattern != null) {
			sqltext += " and TABNAME LIKE '" + tableNamePattern.replace('*', '%') + "'";
		}
		if (types == null) {
			types = new String[] {JdbcTableTypes.VIEW.name(), JdbcTableTypes.TABLE.name()};
		}
		sqltext += " and (";
		StringBuilder sb = new StringBuilder();
		for (String type : types) {
			JdbcTableTypes t = JdbcTableTypes.valueOf(type);
			for (TabClass tabclass : TabClass.allFor(t)) {
				if (sb.length() != 0) {
					sb.append(" or ");
				}
				sb.append("TABCLASS = '").append(tabclass.name()).append("'");
			}
		}
		sqltext += sb.toString() + ")";
		try (PreparedStatement stmt = conn.prepareStatement(sqltext)) {
			((AbapStatement) stmt).setRowTransform(new RowTransformation() {
				
				@Override
				public void apply(Object[] row) {
					// Translate ABAP internal TABCLASS to Jdbc Types
					row[3] = TabClass.valueOf(row[3].toString()).getType().name();
				}
			});
			return stmt.executeQuery();
		}
	}

	@Override
	public ResultSet getSchemas() throws SQLException {
		return null;
	}

	@Override
	public ResultSet getCatalogs() throws SQLException {
		return null;
	}

	@Override
	public ResultSet getTableTypes() throws SQLException {
		SimpleResultSetMetadata meta = new SimpleResultSetMetadata();
		meta.addColumn(new ProjectionColumn(new ColumnExpression("TABLE_TYPE"), "TABLE_TYPE", 0));
		List<Object[]> data = new ArrayList<>();
		for (JdbcTableTypes element : JdbcTableTypes.values()) {
			data.add(new Object[] {element.getText()});
		}
		return new AbapResultSet(meta, data );
	}

	@Override
	public ResultSet getColumns(String catalog, String schemaPattern, String tableNamePattern, String columnNamePattern) throws SQLException {
		/*
			1.TABLE_CAT String => table catalog (may be null) 
			2.TABLE_SCHEM String => table schema (may be null) 
			3.TABLE_NAME String => table name 
			4.COLUMN_NAME String => column name 
			5.DATA_TYPE int => SQL type from java.sql.Types 
			6.TYPE_NAME String => Data source dependent type name,for a UDT the type name is fully qualified 
			7.COLUMN_SIZE int => column size. 
			8.BUFFER_LENGTH is not used. 
			9.DECIMAL_DIGITS int => the number of fractional digits. Null is returned for data types where DECIMAL_DIGITS is not applicable. 
			10.NUM_PREC_RADIX int => Radix (typically either 10 or 2) 
			11.NULLABLE int => is NULL allowed.
				◦ columnNoNulls - might not allow NULL values 
				◦ columnNullable - definitely allows NULL values 
				◦ columnNullableUnknown - nullability unknown 
			
			12.REMARKS String => comment describing column (may be null) 
			13.COLUMN_DEF String => default value for the column, which should be interpreted as a string when the value is enclosed in single quotes (may be null) 
			14.SQL_DATA_TYPE int => unused 
			15.SQL_DATETIME_SUB int => unused 
			16.CHAR_OCTET_LENGTH int => for char types the maximum number of bytes in the column 
			17.ORDINAL_POSITION int => index of column in table(starting at 1) 
			18.IS_NULLABLE String => ISO rules are used to determine the nullability for a column.
				◦ YES --- if the column can include NULLs 
				◦ NO --- if the column cannot include NULLs 
				◦ empty string --- if the nullability for the column is unknown 
			
			19.SCOPE_CATALOG String => catalog of table that is the scopeof a reference attribute (null if DATA_TYPE isn't REF) 
			20.SCOPE_SCHEMA String => schema of table that is the scopeof a reference attribute (null if the DATA_TYPE isn't REF) 
			21.SCOPE_TABLE String => table name that this the scopeof a reference attribute (null if the DATA_TYPE isn't REF) 
			22.SOURCE_DATA_TYPE short => source type of a distinct type or user-generatedRef type, SQL type from java.sql.Types (null if DATA_TYPEisn't DISTINCT or user-generated REF) 
			23.IS_AUTOINCREMENT String => Indicates whether this column is auto incremented
				◦ YES --- if the column is auto incremented 
				◦ NO --- if the column is not auto incremented 
				◦ empty string --- if it cannot be determined whether the column is auto incremented 
			
			24.IS_GENERATEDCOLUMN String => Indicates whether this is a generated column
				◦ YES --- if this a generated column 
				◦ NO --- if this not a generated column 
				◦ empty string --- if it cannot be determined whether this is a generated column 
		 */
		String sqltext = "select null as TABLE_CAT, null as TABLE_SCHEM, TABNAME as TABLE_NAME, FIELDNAME as COLUMN_NAME, INTTYPE as DATA_TYPE, "
				+ "DOMNAME as TYPE_NAME, INTLEN as COLUMN_SIZE, null as BUFFER_LENGTH, "
				+ "0 as DECIMAL_DIGITS, 10 as NUM_PREC_RADIX, NOTNULL as NULLABLE, DDTEXT as REMARKS, null as COLUMN_DEF, "
				+ "INTTYPE as SQL_DATA_TYPE, 0 as SQL_DATETIME_SUB, null as CHAR_OCTET_LENGTH, POSITION as ORDINAL_POSITION, NOTNULL as IS_NULLABLE, "
				+ "null as SCOPE_CATALOG, null as SCOPE_SCHEMA, null as SCOPE_TABLE, 'NO' as IS_AUTOINCREMENT, 'NO' as IS_GENERATEDCOLUMN "
				+ "from DD03VT where DDLANGUAGE = 'E'";
		if (tableNamePattern != null) {
			sqltext += " and TABNAME LIKE '" + tableNamePattern.replace('*', '%') + "'";
		}
		if (columnNamePattern != null) {
			sqltext += " and FIELDNAME like '" + columnNamePattern.replace('*', '%') + "'";
		}
		try (PreparedStatement stmt = conn.prepareStatement(sqltext)) {
			((AbapStatement) stmt).setRowTransform(new RowTransformation() {
				
				@Override
				public void apply(Object[] row) {
					// Translate ABAP internal TABCLASS to Jdbc Types
					row[4] = AbapDataType.valueOf(row[4].toString()).getJdbcType().getVendorTypeNumber();
					row[13] = row[4];
					if ("X".equals(row[10])) {
						row[10] = ResultSetMetaData.columnNullable;
						row[17] = "YES";
					} else {
						row[10] = ResultSetMetaData.columnNoNulls;
						row[17] = "NO";
					}
				}
			});
			return stmt.executeQuery();
		}
	}

	@Override
	public ResultSet getColumnPrivileges(String catalog, String schema, String table, String columnNamePattern) throws SQLException {
		throw new SQLException("Not supported by ABAP");
	}

	@Override
	public ResultSet getTablePrivileges(String catalog, String schemaPattern, String tableNamePattern) throws SQLException {
		throw new SQLException("Not supported by ABAP");
	}

	@Override
	public ResultSet getBestRowIdentifier(String catalog, String schema, String table, int scope, boolean nullable) throws SQLException {
		return null;
	}

	@Override
	public ResultSet getVersionColumns(String catalog, String schema, String table) throws SQLException {
		return null;
	}

	@Override
	public ResultSet getPrimaryKeys(String catalog, String schema, String table) throws SQLException {
		/*
		 * Where to find the primary key position???
		 * 
			1.TABLE_CAT String => table catalog (may be null) 
			2.TABLE_SCHEM String => table schema (may be null) 
			3.TABLE_NAME String => table name 
			4.COLUMN_NAME String => column name 
			5.KEY_SEQ short => sequence number within primary key( a value of 1 represents the first column of the primary key, a value of 2 would represent the second column within the primary key). 
			6.PK_NAME String => primary key name (may be null) 
		 */
		String sqltext = "select null as TABLE_CAT, null as TABLE_SCHEM, TABNAME as TABLE_NAME, FIELDNAME as COLUMN_NAME, null as KEY_SEQ, null as PK_NAME "
				+ "from DD03L where TABNAME = ? and KEYFLAG = 'X' and AS4LOCAL = 'A'";
		try (PreparedStatement stmt = conn.prepareStatement(sqltext)) {
			stmt.setString(1, table);
			((AbapStatement) stmt).setRowTransform(new RowTransformation() {
				int keypos = 1;
				
				@Override
				public void apply(Object[] row) {
					// create KEY_SEQ
					row[4] = keypos++;
				}
			});
			return stmt.executeQuery();
		}
	}

	@Override
	public ResultSet getImportedKeys(String catalog, String schema, String table) throws SQLException {
		/*
		1.PKTABLE_CAT String => parent key table catalog (may be null) 
		2.PKTABLE_SCHEM String => parent key table schema (may be null) 
		3.PKTABLE_NAME String => parent key table name 
		4.PKCOLUMN_NAME String => parent key column name 
		5.FKTABLE_CAT String => foreign key table catalog (may be null) being exported (may be null) 
		6.FKTABLE_SCHEM String => foreign key table schema (may be null) being exported (may be null) 
		7.FKTABLE_NAME String => foreign key table name being exported 
		8.FKCOLUMN_NAME String => foreign key column name being exported 
		9.KEY_SEQ short => sequence number within foreign key( a value of 1 represents the first column of the foreign key, a value of 2 would represent the second column within the foreign key). 
		10.UPDATE_RULE short => What happens to foreign key when parent key is updated:
		◦ importedNoAction - do not allow update of parent key if it has been imported 
		◦ importedKeyCascade - change imported key to agree with parent key update 
		◦ importedKeySetNull - change imported key to NULL if its parent key has been updated 
		◦ importedKeySetDefault - change imported key to default values if its parent key has been updated 
		◦ importedKeyRestrict - same as importedKeyNoAction(for ODBC 2.x compatibility) 
		
		11.DELETE_RULE short => What happens to the foreign key when parent key is deleted.
		◦ importedKeyNoAction - do not allow delete of parent key if it has been imported 
		◦ importedKeyCascade - delete rows that import a deleted key 
		◦ importedKeySetNull - change imported key to NULL if its primary key has been deleted 
		◦ importedKeyRestrict - same as importedKeyNoAction(for ODBC 2.x compatibility) 
		◦ importedKeySetDefault - change imported key to default if its parent key has been deleted 
		
		12.FK_NAME String => foreign key name (may be null) 
		13.PK_NAME String => parent key name (may be null) 
		14.DEFERRABILITY short => can the evaluation of foreign key constraints be deferred until commit
		◦ importedKeyInitiallyDeferred - see SQL92 for definition 
		◦ importedKeyInitiallyImmediate - see SQL92 for definition 
		◦ importedKeyNotDeferrable - see SQL92 for definition
		 */
		String sqltext = "select null as PKTABLE_CAT, null as PKTABLE_SCHEM, CHECKTABLE as PKTABLE_NAME, CHECKFIELD as PKCOLUMN_NAME, "
				+ "null as FKTABLE_CAT, null as FKTABLE_SCHEM, TABNAME as FKTABLE_NAME, FORKEY as FKCOLUMN_NAME, "
				+ "PRIMPOS as KEY_SEQ, 0 as UPDATE_RULE, 0 as DELETE_RULE, FIELDNAME as FK_NAME, null as PK_NAME, 0 as DEFERRABILITY "
				+ "from DD05Q where TABNAME = ? and FORTABLE <> '*'";
		try (AbapPreparedStatement stmt = conn.prepareStatement(sqltext)) {
			stmt.setDataType(1, AbapDataType.C);
			stmt.setDataType(2, AbapDataType.C);
			stmt.setDataType(5, AbapDataType.C);
			stmt.setDataType(6, AbapDataType.C);
			stmt.setDataType(13, AbapDataType.C);
			stmt.setString(1, table);
			((AbapStatement) stmt).setRowTransform(new RowTransformation() {
				
				@Override
				public void apply(Object[] row) {
					row[9] = DatabaseMetaData.importedKeyNoAction;
					row[10] = DatabaseMetaData.importedKeyNoAction;
					row[11] = row[2].toString() + '_' + row[11].toString(); // FK name is table name plus field name  
					row[13] = DatabaseMetaData.importedKeyNotDeferrable;
				}
			});
			return stmt.executeQuery();
		}
	}

	@Override
	public ResultSet getExportedKeys(String catalog, String schema, String table) throws SQLException {
		/*
		1.PKTABLE_CAT String => parent key table catalog (may be null) 
		2.PKTABLE_SCHEM String => parent key table schema (may be null) 
		3.PKTABLE_NAME String => parent key table name 
		4.PKCOLUMN_NAME String => parent key column name 
		5.FKTABLE_CAT String => foreign key table catalog (may be null) being exported (may be null) 
		6.FKTABLE_SCHEM String => foreign key table schema (may be null) being exported (may be null) 
		7.FKTABLE_NAME String => foreign key table name being exported 
		8.FKCOLUMN_NAME String => foreign key column name being exported 
		9.KEY_SEQ short => sequence number within foreign key( a value of 1 represents the first column of the foreign key, a value of 2 would represent the second column within the foreign key). 
		10.UPDATE_RULE short => What happens to foreign key when parent key is updated:
		◦ importedNoAction - do not allow update of parent key if it has been imported 
		◦ importedKeyCascade - change imported key to agree with parent key update 
		◦ importedKeySetNull - change imported key to NULL if its parent key has been updated 
		◦ importedKeySetDefault - change imported key to default values if its parent key has been updated 
		◦ importedKeyRestrict - same as importedKeyNoAction(for ODBC 2.x compatibility) 
		
		11.DELETE_RULE short => What happens to the foreign key when parent key is deleted.
		◦ importedKeyNoAction - do not allow delete of parent key if it has been imported 
		◦ importedKeyCascade - delete rows that import a deleted key 
		◦ importedKeySetNull - change imported key to NULL if its primary key has been deleted 
		◦ importedKeyRestrict - same as importedKeyNoAction(for ODBC 2.x compatibility) 
		◦ importedKeySetDefault - change imported key to default if its parent key has been deleted 
		
		12.FK_NAME String => foreign key name (may be null) 
		13.PK_NAME String => parent key name (may be null) 
		14.DEFERRABILITY short => can the evaluation of foreign key constraints be deferred until commit
		◦ importedKeyInitiallyDeferred - see SQL92 for definition 
		◦ importedKeyInitiallyImmediate - see SQL92 for definition 
		◦ importedKeyNotDeferrable - see SQL92 for definition
		 */
		String sqltext = "select null as PKTABLE_CAT, null as PKTABLE_SCHEM, CHECKTABLE as PKTABLE_NAME, CHECKFIELD as PKCOLUMN_NAME, "
				+ "null as FKTABLE_CAT, null as FKTABLE_SCHEM, TABNAME as FKTABLE_NAME, FORKEY as FKCOLUMN_NAME, "
				+ "PRIMPOS as KEY_SEQ, 0 as UPDATE_RULE, 0 as DELETE_RULE, FIELDNAME as FK_NAME, null as PK_NAME, 0 as DEFERRABILITY "
				+ "from DD05Q where CHECKTABLE = ? and FORTABLE <> '*'";
		try (AbapPreparedStatement stmt = conn.prepareStatement(sqltext)) {
			stmt.setDataType(1, AbapDataType.C);
			stmt.setDataType(2, AbapDataType.C);
			stmt.setDataType(5, AbapDataType.C);
			stmt.setDataType(6, AbapDataType.C);
			stmt.setDataType(13, AbapDataType.C);
			stmt.setString(1, table);
			((AbapStatement) stmt).setRowTransform(new RowTransformation() {
				
				@Override
				public void apply(Object[] row) {
					row[9] = DatabaseMetaData.importedKeyNoAction;
					row[10] = DatabaseMetaData.importedKeyNoAction;
					row[11] = row[2].toString() + '_' + row[11].toString(); // FK name is table name plus field name  
					row[13] = DatabaseMetaData.importedKeyNotDeferrable;
				}
			});
			return stmt.executeQuery();
		}
	}

	@Override
	public ResultSet getCrossReference(String parentCatalog, String parentSchema, String parentTable,
			String foreignCatalog, String foreignSchema, String foreignTable) throws SQLException {
		/*
			1.PKTABLE_CAT String => parent key table catalog (may be null) 
			2.PKTABLE_SCHEM String => parent key table schema (may be null) 
			3.PKTABLE_NAME String => parent key table name 
			4.PKCOLUMN_NAME String => parent key column name 
			5.FKTABLE_CAT String => foreign key table catalog (may be null) being exported (may be null) 
			6.FKTABLE_SCHEM String => foreign key table schema (may be null) being exported (may be null) 
			7.FKTABLE_NAME String => foreign key table name being exported 
			8.FKCOLUMN_NAME String => foreign key column name being exported 
			9.KEY_SEQ short => sequence number within foreign key( a value of 1 represents the first column of the foreign key, a value of 2 would represent the second column within the foreign key). 
			10.UPDATE_RULE short => What happens to foreign key when parent key is updated:
			◦ importedNoAction - do not allow update of parent key if it has been imported 
			◦ importedKeyCascade - change imported key to agree with parent key update 
			◦ importedKeySetNull - change imported key to NULL if its parent key has been updated 
			◦ importedKeySetDefault - change imported key to default values if its parent key has been updated 
			◦ importedKeyRestrict - same as importedKeyNoAction(for ODBC 2.x compatibility) 
			
			11.DELETE_RULE short => What happens to the foreign key when parent key is deleted.
			◦ importedKeyNoAction - do not allow delete of parent key if it has been imported 
			◦ importedKeyCascade - delete rows that import a deleted key 
			◦ importedKeySetNull - change imported key to NULL if its primary key has been deleted 
			◦ importedKeyRestrict - same as importedKeyNoAction(for ODBC 2.x compatibility) 
			◦ importedKeySetDefault - change imported key to default if its parent key has been deleted 
			
			12.FK_NAME String => foreign key name (may be null) 
			13.PK_NAME String => parent key name (may be null) 
			14.DEFERRABILITY short => can the evaluation of foreign key constraints be deferred until commit
			◦ importedKeyInitiallyDeferred - see SQL92 for definition 
			◦ importedKeyInitiallyImmediate - see SQL92 for definition 
			◦ importedKeyNotDeferrable - see SQL92 for definition
		 */
		String sqltext = "select null as PKTABLE_CAT, null as PKTABLE_SCHEM, CHECKTABLE as PKTABLE_NAME, CHECKFIELD as PKCOLUMN_NAME, "
				+ "null as FKTABLE_CAT, null as FKTABLE_SCHEM, TABNAME as FKTABLE_NAME, FORKEY as FKCOLUMN_NAME, "
				+ "PRIMPOS as KEY_SEQ, 0 as UPDATE_RULE, 0 as DELETE_RULE, FIELDNAME as FK_NAME, null as PK_NAME, 0 as DEFERRABILITY "
				+ "from DD05Q where TABNAME = ? and CHECKTABLE = ? and FORTABLE <> '*'";
		try (AbapPreparedStatement stmt = conn.prepareStatement(sqltext)) {
			stmt.setDataType(1, AbapDataType.C);
			stmt.setDataType(2, AbapDataType.C);
			stmt.setDataType(5, AbapDataType.C);
			stmt.setDataType(6, AbapDataType.C);
			stmt.setDataType(13, AbapDataType.C);
			stmt.setString(1, parentTable);
			stmt.setString(2, foreignTable);
			((AbapStatement) stmt).setRowTransform(new RowTransformation() {
				
				@Override
				public void apply(Object[] row) {
					row[9] = DatabaseMetaData.importedKeyNoAction;
					row[10] = DatabaseMetaData.importedKeyNoAction;
					row[11] = row[2].toString() + '_' + row[11].toString(); // FK name is table name plus field name  
					row[13] = DatabaseMetaData.importedKeyNotDeferrable;
				}
			});
			return stmt.executeQuery();
		}
	}

	@Override
	public ResultSet getTypeInfo() throws SQLException {
		return AbapDatatypeResultSet.INSTANCE;
	}

	@Override
	public ResultSet getIndexInfo(String catalog, String schema, String table, boolean unique, boolean approximate) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supportsResultSetType(int type) throws SQLException {
		if (type == ResultSet.TYPE_FORWARD_ONLY) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean supportsResultSetConcurrency(int type, int concurrency) throws SQLException {
		return supportsResultSetType(type);
	}

	@Override
	public boolean ownUpdatesAreVisible(int type) throws SQLException {
		return true;
	}

	@Override
	public boolean ownDeletesAreVisible(int type) throws SQLException {
		return true;
	}

	@Override
	public boolean ownInsertsAreVisible(int type) throws SQLException {
		return true;
	}

	@Override
	public boolean othersUpdatesAreVisible(int type) throws SQLException {
		return false;
	}

	@Override
	public boolean othersDeletesAreVisible(int type) throws SQLException {
		return false;
	}

	@Override
	public boolean othersInsertsAreVisible(int type) throws SQLException {
		return false;
	}

	@Override
	public boolean updatesAreDetected(int type) throws SQLException {
		return false;
	}

	@Override
	public boolean deletesAreDetected(int type) throws SQLException {
		return false;
	}

	@Override
	public boolean insertsAreDetected(int type) throws SQLException {
		return false;
	}

	@Override
	public boolean supportsBatchUpdates() throws SQLException {
		return false;
	}

	@Override
	public ResultSet getUDTs(String catalog, String schemaPattern, String typeNamePattern, int[] types)
			throws SQLException {
		return null;
	}

	@Override
	public Connection getConnection() throws SQLException {
		return conn;
	}

	@Override
	public boolean supportsSavepoints() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsNamedParameters() throws SQLException {
		return true;
	}

	@Override
	public boolean supportsMultipleOpenResults() throws SQLException {
		return true;
	}

	@Override
	public boolean supportsGetGeneratedKeys() throws SQLException {
		return false;
	}

	@Override
	public ResultSet getSuperTypes(String catalog, String schemaPattern, String typeNamePattern) throws SQLException {
		return null;
	}

	@Override
	public ResultSet getSuperTables(String catalog, String schemaPattern, String tableNamePattern) throws SQLException {
		return null;
	}

	@Override
	public ResultSet getAttributes(String catalog, String schemaPattern, String typeNamePattern,
			String attributeNamePattern) throws SQLException {
		return null;
	}

	@Override
	public boolean supportsResultSetHoldability(int holdability) throws SQLException {
		return holdability == ResultSet.CLOSE_CURSORS_AT_COMMIT;
	}

	@Override
	public int getResultSetHoldability() throws SQLException {
		return ResultSet.CLOSE_CURSORS_AT_COMMIT;
	}

	@Override
	public int getDatabaseMajorVersion() throws SQLException {
		return 1;
	}

	@Override
	public int getDatabaseMinorVersion() throws SQLException {
		return 0;
	}

	@Override
	public int getJDBCMajorVersion() throws SQLException {
		return 1;
	}

	@Override
	public int getJDBCMinorVersion() throws SQLException {
		return 0;
	}

	@Override
	public int getSQLStateType() throws SQLException {
		return 0;
	}

	@Override
	public boolean locatorsUpdateCopy() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsStatementPooling() throws SQLException {
		return true;
	}

	@Override
	public RowIdLifetime getRowIdLifetime() throws SQLException {
		return null;
	}

	@Override
	public ResultSet getSchemas(String catalog, String schemaPattern) throws SQLException {
		return null;
	}

	@Override
	public boolean supportsStoredFunctionsUsingCallSyntax() throws SQLException {
		return true;
	}

	@Override
	public boolean autoCommitFailureClosesAllResultSets() throws SQLException {
		return true;
	}

	@Override
	public ResultSet getClientInfoProperties() throws SQLException {
		return null;
	}

	@Override
	public ResultSet getFunctions(String catalog, String schemaPattern, String functionNamePattern) throws SQLException {
		return null;
	}

	@Override
	public ResultSet getFunctionColumns(String catalog, String schemaPattern, String functionNamePattern, String columnNamePattern) throws SQLException {
		return null;
	}

	@Override
	public ResultSet getPseudoColumns(String catalog, String schemaPattern, String tableNamePattern, String columnNamePattern) throws SQLException {
		return null;
	}

	@Override
	public boolean generatedKeyAlwaysReturned() throws SQLException {
		return false;
	}

}
