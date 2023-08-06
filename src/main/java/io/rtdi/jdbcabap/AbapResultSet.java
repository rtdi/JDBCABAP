package io.rtdi.jdbcabap;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import io.rtdi.jdbcabap.sql.SQL;
import io.rtdi.jdbcabap.sql.SimpleResultSetMetadata;

/**
 * Implements a ResultSet
 */
public class AbapResultSet implements ResultSet {

	/**
	 * Formatter for all date related values
	 */
	public static final DateTimeFormatter formatteryyyymmdd = DateTimeFormatter.ofPattern("yyyyMMdd");
	/**
	 * Formatter for all time related values
	 */
	public static final DateTimeFormatter formatterhhmmss = DateTimeFormatter.ofPattern("HHmmss");
	private SimpleResultSetMetadata resultsetmetadata;
	private List<Object[]> data;
	private int index = 0;
	private int lastpos = 0;
	private Object[] currentrow = null;
	private Statement statement;

	/**
	 * Create a resultset for a given SQL statement as metadata and statement
	 * @param sql the resultsetmetadata
	 * @param stmt this resultset belongs to
	 */
	public AbapResultSet(SQL sql, AbapStatement stmt) {
		this.resultsetmetadata = sql;
		this.statement = stmt;
	}

	/**
	 * Result set with explicit metadata and data - used mostly for database metadata objects
	 * @param metadata of the result set
	 * @param data containing the rows or will contain the rows
	 */
	public AbapResultSet(SimpleResultSetMetadata metadata, List<Object[]> data) {
		this.resultsetmetadata = metadata;
		this.data = data;
	}
	
	@Override
	public boolean next() throws SQLException {
		if (data == null) {
			currentrow = null;
			return false;
		} else if (index < data.size()) {
			currentrow = data.get(index);
			index++;
			return true;
		} else {
			currentrow = null;
			index++;
			return false;
		}
	}

	@Override
	public void close() throws SQLException {
		data = null;
	}
	
	@Override
	public boolean wasNull() throws SQLException {
		if (currentrow == null) {
			throw new SQLException("No row is currently fetched");
		} else {
			return currentrow[lastpos] == null;
		}
	}
	
	@Override
	public String getString(int i) throws SQLException {
		Object value = getObject(i);
		if (value == null) {
			return null;
		} else if (value instanceof String) {
			return (String) value;
		} else {
			return value.toString();
		}
	}

	@Override
	public boolean getBoolean(int i) throws SQLException {
		Object value = getObject(i);
		if (value == null) {
			return false;
		} else if (value instanceof String && resultsetmetadata.getColumnDisplaySize(i) == 1) {
			return "X".equals(value);
		} else {
			throw new SQLException(String.format("Column %d is of datatype %s and hence does not support getBoolean", i, resultsetmetadata.getColumnTypeName(i)));
		}
	}

	@Override
	public byte getByte(int i) throws SQLException {
		return (byte) getInt(i);
	}

	@Override
	public short getShort(int i) throws SQLException {
		return (short) getInt(i);
	}

	@Override
	public int getInt(int i) throws SQLException {
		Object value = getObject(i);
		if (value == null) {
			return 0;
		} else if (value instanceof Integer) {
			return (Integer) value;
		} else {
			throw new SQLException(String.format("Column %d is of datatype %s and hence does not support getInt", i, resultsetmetadata.getColumnTypeName(i)));
		}
	}

	@Override
	public long getLong(int i) throws SQLException {
		return getInt(i);
	}

	@Override
	public float getFloat(int i) throws SQLException {
		Object value = getObject(i);
		if (value == null) {
			return 0;
		} else if (value instanceof Float) {
			return (Float) value;
		} else {
			throw new SQLException(String.format("Column %d is of datatype %s and hence does not support getFloat", i, resultsetmetadata.getColumnTypeName(i)));
		}
	}

	@Override
	public double getDouble(int i) throws SQLException {
		return (double) getFloat(i);
	}

	@Override
	public BigDecimal getBigDecimal(int i) throws SQLException {
		Object value = getObject(i);
		if (value == null) {
			return null;
		} else if (value instanceof BigDecimal) {
			return (BigDecimal) value;
		} else if (value instanceof Float) {
			return BigDecimal.valueOf((Float) value);
		} else {
			throw new SQLException(String.format("Column %d is of datatype %s and hence does not support getBigDecimal", i, resultsetmetadata.getColumnTypeName(i)));
		}
	}

	@Override
	public BigDecimal getBigDecimal(int i, int i1) throws SQLException {
		return getBigDecimal(i).setScale(i1, RoundingMode.HALF_UP);
	}

	@Override
	public byte[] getBytes(int i) throws SQLException {
		Object value = getObject(i);
		if (value == null) {
			return null;
		} else if (value instanceof byte[]) {
			return (byte[]) value;
		} else {
			throw new SQLException(String.format("Column %d is of datatype %s and hence does not support getBytes", i, resultsetmetadata.getColumnTypeName(i)));
		}
	}

	@Override
	public Date getDate(int i) throws SQLException {
		Object value = getObject(i);
		if (value == null) {
			return null;
		} else if (value instanceof Date) {
			return (Date) value;
		} else {
			throw new SQLException(String.format("Column %d is of datatype %s and hence does not support getDate", i, resultsetmetadata.getColumnTypeName(i)));
		}
	}

	@Override
	public Time getTime(int i) throws SQLException {
		Object value = getObject(i);
		if (value == null) {
			return null;
		} else if (value instanceof Time) {
			return (Time) value;
		} else {
			throw new SQLException(String.format("Column %d is of datatype %s and hence does not support getTime", i, resultsetmetadata.getColumnTypeName(i)));
		}
	}

	@Override
	public Timestamp getTimestamp(int i) throws SQLException {
		Object value = getObject(i);
		if (value == null) {
			return null;
		} else if (value instanceof Date) {
			Date date = (Date) value;
			LocalDateTime datetime = date.toLocalDate().atTime(LocalTime.of(0, 0));
			return Timestamp.valueOf(datetime);
		} else {
			throw new SQLException(String.format("Column %d is of datatype %s and hence does not support getTimestamp", i, resultsetmetadata.getColumnTypeName(i)));
		}
	}

	@Override
	public InputStream getAsciiStream(int i) throws SQLException {
		String s = getString(i);
		return new ByteArrayInputStream(s.getBytes());
	}

	@Override
	public InputStream getUnicodeStream(int i) throws SQLException {
		String s = getString(i);
		return new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
	}

	@Override
	public InputStream getBinaryStream(int i) throws SQLException {
		byte[] b = getBytes(i);
		return new ByteArrayInputStream(b);
	}

	@Override
	public String getString(String s) throws SQLException {
		return getString(resultsetmetadata.getColumnPositionByName(s));
	}

	@Override
	public boolean getBoolean(String s) throws SQLException {
		return getBoolean(resultsetmetadata.getColumnPositionByName(s));
	}

	@Override
	public byte getByte(String s) throws SQLException {
		return getByte(resultsetmetadata.getColumnPositionByName(s));
	}

	@Override
	public short getShort(String s) throws SQLException {
		return getShort(resultsetmetadata.getColumnPositionByName(s));
	}

	@Override
	public int getInt(String s) throws SQLException {
		return getInt(resultsetmetadata.getColumnPositionByName(s));
	}

	@Override
	public long getLong(String s) throws SQLException {
		return getLong(resultsetmetadata.getColumnPositionByName(s));
	}

	@Override
	public float getFloat(String s) throws SQLException {
		return getFloat(resultsetmetadata.getColumnPositionByName(s));
	}

	@Override
	public double getDouble(String s) throws SQLException {
		return getDouble(resultsetmetadata.getColumnPositionByName(s));
	}

	@Override
	public BigDecimal getBigDecimal(String s, int i) throws SQLException {
		return getBigDecimal(resultsetmetadata.getColumnPositionByName(s), i);
	}

	@Override
	public byte[] getBytes(String s) throws SQLException {
		return getBytes(resultsetmetadata.getColumnPositionByName(s));
	}

	@Override
	public Date getDate(String s) throws SQLException {
		return getDate(resultsetmetadata.getColumnPositionByName(s));
	}

	@Override
	public Time getTime(String s) throws SQLException {
		return getTime(resultsetmetadata.getColumnPositionByName(s));
	}

	@Override
	public Timestamp getTimestamp(String s) throws SQLException {
		return getTimestamp(resultsetmetadata.getColumnPositionByName(s));
	}

	@Override
	public InputStream getAsciiStream(String s) throws SQLException {
		return getAsciiStream(resultsetmetadata.getColumnPositionByName(s));
	}

	@Override
	public InputStream getUnicodeStream(String s) throws SQLException {
		return getUnicodeStream(resultsetmetadata.getColumnPositionByName(s));
	}

	@Override
	public InputStream getBinaryStream(String s) throws SQLException {
		return getBinaryStream(resultsetmetadata.getColumnPositionByName(s));
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		return null;
	}

	@Override
	public void clearWarnings() throws SQLException {
	}

	@Override
	public String getCursorName() throws SQLException {
		return null;
	}

	@Override
	public ResultSetMetaData getMetaData() throws SQLException {
		return resultsetmetadata;
	}

	@Override
	public Object getObject(int i) throws SQLException {
		if (currentrow == null) {
			throw new SQLException("No row is currently fetched");
		} else if(i>0 && i <= resultsetmetadata.getColumnCount()) {
			lastpos = i-1;
			return currentrow[i-1];
		} else {
			throw new SQLException(String.format("Requested position %d is outside the resultset columns 1..%d", i, resultsetmetadata.getColumnCount()));
		}
	}

	@Override
	public Object getObject(String s) throws SQLException {
		return getObject(resultsetmetadata.getColumnPositionByName(s));
	}

	@Override
	public int findColumn(String s) throws SQLException {
		return resultsetmetadata.getColumnPositionByName(s)+1;
	}

	@Override
	public Reader getCharacterStream(int i) throws SQLException {
		String s = getString(i);
		return new StringReader(s);
	}

	@Override
	public Reader getCharacterStream(String s) throws SQLException {
		return getCharacterStream(resultsetmetadata.getColumnPositionByName(s));
	}

	@Override
	public BigDecimal getBigDecimal(String s) throws SQLException {
		return getBigDecimal(resultsetmetadata.getColumnPositionByName(s));
	}

	@Override
	public boolean isBeforeFirst() throws SQLException {
		return index == 0;
	}

	@Override
	public boolean isAfterLast() throws SQLException {
		return index > data.size();
	}

	@Override
	public boolean isFirst() throws SQLException {
		return index == 1;
	}

	@Override
	public boolean isLast() throws SQLException {
		return index == data.size();
	}

	@Override
	public void beforeFirst() throws SQLException {
		index = 0;
	}

	@Override
	public void afterLast() throws SQLException {
		index = data.size()+1;
	}

	@Override
	public boolean first() throws SQLException {
		if (data != null && data.size() != 0) {
			currentrow = data.get(0);
			index = 1;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean last() throws SQLException {
		if (data != null && data.size() != 0) {
			index = data.size();
			currentrow = data.get(index-1);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int getRow() throws SQLException {
		return index;
	}

	@Override
	public boolean absolute(int i) throws SQLException {
		if (data != null && data.size() != 0) {
			index = i;
			currentrow = data.get(index-1);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean relative(int i) throws SQLException {
		if (data != null && data.size() != 0 && index+i>0 && index+i<=data.size()) {
			index += i;
			currentrow = data.get(index-1);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean previous() throws SQLException {
		if (data != null && data.size() != 0 && index > 1) {
			index--;
			currentrow = data.get(index-1);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void setFetchDirection(int i) throws SQLException {
	}

	@Override
	public int getFetchDirection() throws SQLException {
		return 0;
	}

	@Override
	public void setFetchSize(int i) throws SQLException {
	}

	@Override
	public int getFetchSize() throws SQLException {
		return 0;
	}

	@Override
	public int getType() throws SQLException {
		return 0;
	}

	@Override
	public int getConcurrency() throws SQLException {
		return 0;
	}

	@Override
	public boolean rowUpdated() throws SQLException {
		return false;
	}

	@Override
	public boolean rowInserted() throws SQLException {
		return false;
	}

	@Override
	public boolean rowDeleted() throws SQLException {
		return false;
	}

	@Override
	public void updateNull(int i) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateBoolean(int i, boolean b) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateByte(int i, byte b) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateShort(int i, short i1) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateInt(int i, int i1) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateLong(int i, long l) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateFloat(int i, float v) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateDouble(int i, double v) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateBigDecimal(int i, BigDecimal bigDecimal) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateString(int i, String s) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateBytes(int i, byte[] bytes) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateDate(int i, Date date) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateTime(int i, Time time) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateTimestamp(int i, Timestamp timestamp) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateAsciiStream(int i, InputStream inputStream, int i1) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateBinaryStream(int i, InputStream inputStream, int i1) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateCharacterStream(int i, Reader reader, int i1) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateObject(int i, Object o, int i1) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateObject(int i, Object o) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateNull(String s) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateBoolean(String s, boolean b) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateByte(String s, byte b) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateShort(String s, short i) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateInt(String s, int i) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateLong(String s, long l) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateFloat(String s, float v) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateDouble(String s, double v) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateBigDecimal(String s, BigDecimal bigDecimal) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateString(String s, String s1) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateBytes(String s, byte[] bytes) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateDate(String s, Date date) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateTime(String s, Time time) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateTimestamp(String s, Timestamp timestamp) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateAsciiStream(String s, InputStream inputStream, int i) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateBinaryStream(String s, InputStream inputStream, int i) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateCharacterStream(String s, Reader reader, int i) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateObject(String s, Object o, int i) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateObject(String s, Object o) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void insertRow() throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateRow() throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void deleteRow() throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void refreshRow() throws SQLException {
	}

	@Override
	public void cancelRowUpdates() throws SQLException {
	}

	@Override
	public void moveToInsertRow() throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void moveToCurrentRow() throws SQLException {
	}

	@Override
	public Statement getStatement() throws SQLException {
		return statement;
	}

	@Override
	public Object getObject(int i, Map<String, Class<?>> map) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public Ref getRef(int i) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public Blob getBlob(int i) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public Clob getClob(int i) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public Array getArray(int i) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public Object getObject(String s, Map<String, Class<?>> map) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public Ref getRef(String s) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public Blob getBlob(String s) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public Clob getClob(String s) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public Array getArray(String s) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public Date getDate(int i, Calendar calendar) throws SQLException {
		return getDate(i);
	}

	@Override
	public Date getDate(String s, Calendar calendar) throws SQLException {
		return getDate(s);
	}

	@Override
	public Time getTime(int i, Calendar calendar) throws SQLException {
		return getTime(i);
	}

	@Override
	public Time getTime(String s, Calendar calendar) throws SQLException {
		return getTime(s);
	}

	@Override
	public Timestamp getTimestamp(int i, Calendar calendar) throws SQLException {
		return getTimestamp(i);
	}

	@Override
	public Timestamp getTimestamp(String s, Calendar calendar) throws SQLException {
		return getTimestamp(s);
	}

	@Override
	public URL getURL(int i) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public URL getURL(String s) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateRef(int i, Ref ref) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateRef(String s, Ref ref) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateBlob(int i, Blob blob) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateBlob(String s, Blob blob) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateClob(int i, Clob clob) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateClob(String s, Clob clob) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateArray(int i, Array array) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateArray(String s, Array array) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public RowId getRowId(int i) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public RowId getRowId(String s) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateRowId(int i, RowId rowId) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateRowId(String s, RowId rowId) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public int getHoldability() throws SQLException {
		return 0;
	}

	@Override
	public boolean isClosed() throws SQLException {
		return false;
	}

	@Override
	public void updateNString(int i, String s) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateNString(String s, String s1) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateNClob(int i, NClob nClob) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateNClob(String s, NClob nClob) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public NClob getNClob(int i) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public NClob getNClob(String s) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public SQLXML getSQLXML(int i) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public SQLXML getSQLXML(String s) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateSQLXML(int i, SQLXML sqlxml) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateSQLXML(String s, SQLXML sqlxml) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public String getNString(int i) throws SQLException {
		return getString(i);
	}

	@Override
	public String getNString(String s) throws SQLException {
		return getString(s);
	}

	@Override
	public Reader getNCharacterStream(int i) throws SQLException {
		return getCharacterStream(i);
	}

	@Override
	public Reader getNCharacterStream(String s) throws SQLException {
		return getCharacterStream(s);
	}

	@Override
	public void updateNCharacterStream(int i, Reader reader, long l) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateNCharacterStream(String s, Reader reader, long l) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateAsciiStream(int i, InputStream inputStream, long l) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateBinaryStream(int i, InputStream inputStream, long l) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateCharacterStream(int i, Reader reader, long l) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateAsciiStream(String s, InputStream inputStream, long l) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateBinaryStream(String s, InputStream inputStream, long l) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateCharacterStream(String s, Reader reader, long l) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateBlob(int i, InputStream inputStream, long l) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateBlob(String s, InputStream inputStream, long l) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateClob(int i, Reader reader, long l) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateClob(String s, Reader reader, long l) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateNClob(int i, Reader reader, long l) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateNClob(String s, Reader reader, long l) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateNCharacterStream(int i, Reader reader) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateNCharacterStream(String s, Reader reader) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateAsciiStream(int i, InputStream inputStream) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateBinaryStream(int i, InputStream inputStream) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateCharacterStream(int i, Reader reader) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateAsciiStream(String s, InputStream inputStream) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateBinaryStream(String s, InputStream inputStream) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateCharacterStream(String s, Reader reader) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateBlob(int i, InputStream inputStream) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateBlob(String s, InputStream inputStream) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateClob(int i, Reader reader) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateClob(String s, Reader reader) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateNClob(int i, Reader reader) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void updateNClob(String s, Reader reader) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public <T> T getObject(int i, Class<T> aClass) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public <T> T getObject(String s, Class<T> aClass) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public <T> T unwrap(Class<T> aClass) throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public boolean isWrapperFor(Class<?> aClass) throws SQLException {
		return false;
	}

	/**
	 * Add a new row to the result set and return it, so the caller can fill in the values
	 * 
	 * @return a new Object[] to be used to store the row values
	 * @throws SQLException if the column count is unknown yet
	 */
	public Object[] append() throws SQLException {
		if (data == null) {
			data = new ArrayList<>();
		}
		Object[] row = new Object[resultsetmetadata.getColumnCount()];
		data.add(row);
		return row;
	}

}