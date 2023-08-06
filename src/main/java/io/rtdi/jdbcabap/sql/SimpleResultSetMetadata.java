package io.rtdi.jdbcabap.sql;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.rtdi.jdbcabap.parser.ProjectionColumn;

/**
 * Implements a ResultSetMetaData
 */
public class SimpleResultSetMetadata implements ResultSetMetaData {
	/**
	 * All fields of the result set
	 */
	protected List<ProjectionColumn> fields;
	private Map<String, Integer> nameindex;
	private String tablename;

	/**
	 * create a new POJO
	 */
	public SimpleResultSetMetadata() {
	}

	/**
	 * @return table name the result set belongs to
	 */
	public String getTablename() {
		return tablename;
	}

	/**
	 * @return fields of the result set
	 */
	public List<ProjectionColumn> getFields() {
		return fields;
	}

	/**
	 * @param tablename of the resultset
	 */
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	/**
	 * Clear all fields of the result set
	 */
	public void init() {
		fields = null;
		nameindex = null;
	}
	
	/**
	 * @param columnname to search for
	 * @return the 0 based index where the column can be found, null if not found
	 */
	public Integer getColumnPositionByName(String columnname) {
		return nameindex.get(columnname);
	}
	
	/**
	 * @return the last field added to the resultset or null of there are none yet
	 */
	public ProjectionColumn getLastColumn() {
		if (fields != null && fields.size() > 0) {
			return fields.get(fields.size()-1);
		} else {
			return null;
		}
	}

	/**
	 * @param columnExpression to be added to the result set
	 */
	public void addColumn(ProjectionColumn columnExpression) {
		if (fields == null) {
			fields = new ArrayList<>();
			nameindex = new HashMap<>();
		}
		fields.add(columnExpression);
		nameindex.put(columnExpression.getColumnname(), nameindex.size());
	}

	/**
	 * @param index is the 0 based position of the field
	 * @return the ProjectionColumn at the 0 based index
	 */
	public ProjectionColumn getColumn(int index) {
		return fields.get(index);
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
	public int getColumnCount() throws SQLException {
		return fields.size();
	}

	@Override
	public boolean isAutoIncrement(int column) throws SQLException {
		return false;
	}

	@Override
	public boolean isCaseSensitive(int column) throws SQLException {
		return false;
	}

	@Override
	public boolean isSearchable(int column) throws SQLException {
		return true;
	}

	@Override
	public boolean isCurrency(int column) throws SQLException {
		return false;
	}

	@Override
	public int isNullable(int column) throws SQLException {
		return 0;
	}

	@Override
	public boolean isSigned(int column) throws SQLException {
		return true;
	}

	@Override
	public int getColumnDisplaySize(int column) throws SQLException {
		return getColumnMetadata(column).getLen();
	}

	private ProjectionColumn getColumnMetadata(int column) throws SQLException {
		if (fields == null) {
			throw new SQLException("ResultSet has no fields yet");
		} else if (column > 0 && column < fields.size()+1) {
			return fields.get(column-1);
		} else {
			throw new SQLException(String.format("ResultSet has %d fields but requested column index is %d", fields.size(), column));
		}
	}

	@Override
	public String getColumnLabel(int column) throws SQLException {
		return getColumnMetadata(column).getColumnname();
	}

	@Override
	public String getColumnName(int column) throws SQLException {
		return getColumnMetadata(column).getColumnname();
	}

	@Override
	public String getSchemaName(int column) throws SQLException {
		return null;
	}

	@Override
	public int getPrecision(int column) throws SQLException {
		return getColumnMetadata(column).getLen();
	}

	@Override
	public int getScale(int column) throws SQLException {
		return getColumnMetadata(column).getScale();
	}

	@Override
	public String getTableName(int column) throws SQLException {
		return tablename;
	}

	@Override
	public String getCatalogName(int column) throws SQLException {
		return null;
	}

	@Override
	public int getColumnType(int column) throws SQLException {
		return getColumnMetadata(column).getDatatype().getJdbcType().getVendorTypeNumber();
	}

	@Override
	public String getColumnTypeName(int column) throws SQLException {
		return getColumnMetadata(column).getDatatype().name();
	}

	@Override
	public boolean isReadOnly(int column) throws SQLException {
		return true;
	}

	@Override
	public boolean isWritable(int column) throws SQLException {
		return false;
	}

	@Override
	public boolean isDefinitelyWritable(int column) throws SQLException {
		return false;
	}

	@Override
	public String getColumnClassName(int column) throws SQLException {
		return null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (fields != null) {
			for (ProjectionColumn f : fields) {
				if (sb.length() != 0) {
					sb.append(", ");
				}
				sb.append(f.getColumnname());
			}
		}
		String fieldlist = sb.toString();
		return fieldlist;
	}

}
