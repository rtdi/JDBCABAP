package io.rtdi.jdbcabap;

import java.util.ArrayList;

import io.rtdi.jdbcabap.parser.ProjectionColumn;
import io.rtdi.jdbcabap.sql.SimpleResultSetMetadata;

/**
 * A result set implementation used for procedure metadata
 */
public class AbapProcedureResultSet extends AbapResultSet {
	
	private static SimpleResultSetMetadata rsmetadata;

	static {
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
		rsmetadata = new SimpleResultSetMetadata();
		rsmetadata.setTablename("PROCEDURE_PARAMETERS");
		int i = 0;
		rsmetadata.addColumn(new ProjectionColumn("PROCEDURE_CAT", i++));
		rsmetadata.addColumn(new ProjectionColumn("PROCEDURE_SCHEM", i++));
		rsmetadata.addColumn(new ProjectionColumn("PROCEDURE_NAME", i++));
		rsmetadata.addColumn(new ProjectionColumn("COLUMN_NAME", i++));
		rsmetadata.addColumn(new ProjectionColumn("COLUMN_TYPE", i++));
		rsmetadata.addColumn(new ProjectionColumn("DATA_TYPE", i++));
		rsmetadata.addColumn(new ProjectionColumn("TYPE_NAME", i++));
		rsmetadata.addColumn(new ProjectionColumn("PRECISION", i++));
		rsmetadata.addColumn(new ProjectionColumn("LENGTH", i++));
		rsmetadata.addColumn(new ProjectionColumn("SCALE", i++));
		rsmetadata.addColumn(new ProjectionColumn("RADIX", i++));
		rsmetadata.addColumn(new ProjectionColumn("NULLABLE", i++));
		rsmetadata.addColumn(new ProjectionColumn("REMARKS", i++));
		rsmetadata.addColumn(new ProjectionColumn("COLUMN_DEF", i++));
		rsmetadata.addColumn(new ProjectionColumn("SQL_DATA_TYPE", i++));
		rsmetadata.addColumn(new ProjectionColumn("SQL_DATETIME_SUB", i++));
		rsmetadata.addColumn(new ProjectionColumn("CHAR_OCTET_LENGTH", i++));
		rsmetadata.addColumn(new ProjectionColumn("IS_NULLABLE", i++));
		rsmetadata.addColumn(new ProjectionColumn("SPECIFIC_NAME", i++));
	}

	/**
	 * Create a new result set with no data yet, just the metadata structure
	 */
	public AbapProcedureResultSet() {
		super(rsmetadata, new ArrayList<>());
	}


}
