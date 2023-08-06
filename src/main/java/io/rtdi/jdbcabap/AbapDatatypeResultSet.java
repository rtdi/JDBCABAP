package io.rtdi.jdbcabap;

import java.sql.DatabaseMetaData;
import java.sql.JDBCType;
import java.util.ArrayList;
import java.util.List;

import io.rtdi.jdbcabap.parser.ProjectionColumn;
import io.rtdi.jdbcabap.sql.SimpleResultSetMetadata;

/**
 * ResultSet and metadata returned by the database metadata object
 */
public class AbapDatatypeResultSet extends AbapResultSet {
	
	private static List<Object[]> data;
	private static SimpleResultSetMetadata rsmetadata;
	
	/**
	 * Instance of the class
	 */
	public static final AbapDatatypeResultSet INSTANCE = new AbapDatatypeResultSet();

	static {
		
		/*
			1.TYPE_NAME String => Type name 
			2.DATA_TYPE int => SQL data type from java.sql.Types 
			3.PRECISION int => maximum precision 
			4.LITERAL_PREFIX String => prefix used to quote a literal(may be null) 
			5.LITERAL_SUFFIX String => suffix used to quote a literal(may be null) 
			6.CREATE_PARAMS String => parameters used in creating the type (may be null) 
			7.NULLABLE short => can you use NULL for this type.
				◦ typeNoNulls - does not allow NULL values 
				◦ typeNullable - allows NULL values 
				◦ typeNullableUnknown - nullability unknown 
			
			8.CASE_SENSITIVE boolean=> is it case sensitive. 
			9.SEARCHABLE short => can you use "WHERE" based on this type:
				◦ typePredNone - No support 
				◦ typePredChar - Only supported with WHERE .. LIKE 
				◦ typePredBasic - Supported except for WHERE .. LIKE 
				◦ typeSearchable - Supported for all WHERE .. 
			
			10.UNSIGNED_ATTRIBUTE boolean => is it unsigned. 
			11.FIXED_PREC_SCALE boolean => can it be a money value. 
			12.AUTO_INCREMENT boolean => can it be used for an auto-increment value. 
			13.LOCAL_TYPE_NAME String => localized version of type name(may be null) 
			14.MINIMUM_SCALE short => minimum scale supported 
			15.MAXIMUM_SCALE short => maximum scale supported 
			16.SQL_DATA_TYPE int => unused 
			17.SQL_DATETIME_SUB int => unused 
			18.NUM_PREC_RADIX int => usually 2 or 10 
		 */
		rsmetadata = new SimpleResultSetMetadata();
		rsmetadata.setTablename("DATATYPES");
		int i = 0;
		rsmetadata.addColumn(new ProjectionColumn("TYPE_NAME", i++));
		rsmetadata.addColumn(new ProjectionColumn("DATA_TYPE", i++));
		rsmetadata.addColumn(new ProjectionColumn("PRECISION", i++));
		rsmetadata.addColumn(new ProjectionColumn("LITERAL_PREFIX", i++));
		rsmetadata.addColumn(new ProjectionColumn("LITERAL_SUFFIX", i++));
		rsmetadata.addColumn(new ProjectionColumn("CREATE_PARAMS", i++));
		rsmetadata.addColumn(new ProjectionColumn("NULLABLE", i++));
		rsmetadata.addColumn(new ProjectionColumn("CASE_SENSITIVE", i++));
		rsmetadata.addColumn(new ProjectionColumn("SEARCHABLE", i++));
		rsmetadata.addColumn(new ProjectionColumn("UNSIGNED_ATTRIBUTE", i++));
		rsmetadata.addColumn(new ProjectionColumn("FIXED_PREC_SCALE", i++));
		rsmetadata.addColumn(new ProjectionColumn("AUTO_INCREMENT", i++));
		rsmetadata.addColumn(new ProjectionColumn("LOCAL_TYPE_NAME", i++));
		rsmetadata.addColumn(new ProjectionColumn("MINIMUM_SCALE", i++));
		rsmetadata.addColumn(new ProjectionColumn("MAXIMUM_SCALE", i++));
		rsmetadata.addColumn(new ProjectionColumn("SQL_DATA_TYPE", i++));
		rsmetadata.addColumn(new ProjectionColumn("SQL_DATETIME_SUB", i++));
		rsmetadata.addColumn(new ProjectionColumn("NUM_PREC_RADIX", i++));

		
		data = new ArrayList<>();
		JDBCType type = JDBCType.NVARCHAR;
		data.add(new Object[] {type.getName(), type.getVendorTypeNumber(), 65535, "'", "'",
				null, DatabaseMetaData.typeNullable, true, DatabaseMetaData.typeSearchable, false,
				true, false, type.getName(), 0, 0,
				type.getVendorTypeNumber(), 0, 10});
	
		type = JDBCType.VARCHAR;
		data.add(new Object[] {type.getName(), type.getVendorTypeNumber(), 65535, "'", "'",
				null, DatabaseMetaData.typeNullable, true, DatabaseMetaData.typeSearchable, false,
				true, false, type.getName(), 0, 0,
				type.getVendorTypeNumber(), 0, 10});
	
		type = JDBCType.VARBINARY;
		data.add(new Object[] {type.getName(), type.getVendorTypeNumber(), 65535, "'", "'",
				null, DatabaseMetaData.typeNullable, true, DatabaseMetaData.typePredNone, false,
				true, false, type.getName(), 0, 0,
				type.getVendorTypeNumber(), 0, 10});
	
		type = JDBCType.BOOLEAN;
		data.add(new Object[] {type.getName(), type.getVendorTypeNumber(), 1, "'", "'",
				null, DatabaseMetaData.typeNullable, true, DatabaseMetaData.typeSearchable, false,
				true, false, type.getName(), 0, 0,
				type.getVendorTypeNumber(), 0, 10});
	
		type = JDBCType.INTEGER;
		data.add(new Object[] {type.getName(), type.getVendorTypeNumber(), 65535, "'", "'",
				null, DatabaseMetaData.attributeNoNulls, true, DatabaseMetaData.typeSearchable, false,
				true, false, type.getName(), 0, 0,
				type.getVendorTypeNumber(), 0, 10});
	
		type = JDBCType.FLOAT;
		data.add(new Object[] {type.getName(), type.getVendorTypeNumber(), 65535, "'", "'",
				null, DatabaseMetaData.attributeNoNulls, true, DatabaseMetaData.typeSearchable, false,
				true, false, type.getName(), -308, 308,
				type.getVendorTypeNumber(), 0, 10});
	
		type = JDBCType.DOUBLE;
		data.add(new Object[] {type.getName(), type.getVendorTypeNumber(), 65535, "'", "'",
				null, DatabaseMetaData.attributeNoNulls, true, DatabaseMetaData.typeSearchable, false,
				true, false, type.getName(), -308, 308,
				type.getVendorTypeNumber(), 0, 10});
	
		type = JDBCType.DECIMAL;
		data.add(new Object[] {type.getName(), type.getVendorTypeNumber(), 65535, "'", "'",
				null, DatabaseMetaData.attributeNoNulls, true, DatabaseMetaData.typeSearchable, false,
				true, false, type.getName(), -308, 308,
				type.getVendorTypeNumber(), 0, 10});
	
		type = JDBCType.NUMERIC;
		data.add(new Object[] {type.getName(), type.getVendorTypeNumber(), 65535, "'", "'",
				null, DatabaseMetaData.attributeNoNulls, true, DatabaseMetaData.typeSearchable, false,
				true, false, type.getName(), -308, 308,
				type.getVendorTypeNumber(), 0, 10});
	
		type = JDBCType.DATE;
		data.add(new Object[] {type.getName(), type.getVendorTypeNumber(), 8, "'", "'",
				null, DatabaseMetaData.typeNullable, true, DatabaseMetaData.typeSearchable, false,
				true, false, type.getName(), 0, 0,
				type.getVendorTypeNumber(), 0, 10});
	
		type = JDBCType.TIME;
		data.add(new Object[] {type.getName(), type.getVendorTypeNumber(), 6, "'", "'",
				null, DatabaseMetaData.typeNullable, true, DatabaseMetaData.typeSearchable, false,
				true, false, type.getName(), 0, 0,
				type.getVendorTypeNumber(), 0, 10});
	
		type = JDBCType.TIMESTAMP;
		data.add(new Object[] {type.getName(), type.getVendorTypeNumber(), 8, "'", "'",
				null, DatabaseMetaData.typeNullable, true, DatabaseMetaData.typeSearchable, false,
				true, false, type.getName(), 0, 0,
				type.getVendorTypeNumber(), 0, 10});
	
	
		// type = JDBCType.STRUCT;
		// type = JDBCType.ARRAY;
	
		// type = JDBCType.TINYINT;
		// type = JDBCType.SMALLINT;
		// type = JDBCType.BIGINT;
		// type = JDBCType.REAL;
		// type = JDBCType.CHAR;
		// type = JDBCType.LONGVARCHAR;
		// type = JDBCType.BINARY;
		// type = JDBCType.LONGVARBINARY;
		// type = JDBCType.BLOB;
		// type = JDBCType.CLOB;
		// type = JDBCType.NCHAR;
		// type = JDBCType.LONGNVARCHAR;
		// type = JDBCType.NCLOB;
	}

	private AbapDatatypeResultSet() {
		super(rsmetadata, data);
	}


}
