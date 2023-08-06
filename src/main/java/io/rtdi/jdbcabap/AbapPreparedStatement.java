package io.rtdi.jdbcabap;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import io.rtdi.jdbcabap.sql.SQL;

/**
 * PreparedStatement implementation for Abap
 */
public class AbapPreparedStatement extends AbapStatement implements PreparedStatement {

	/**
	 * Creates a new PreparedStatement for the given connection and sql text
	 * 
	 * @param connection of the PreparedStatement
	 * @param sqltext to prepare
	 * @throws SQLException in case of errors in the sql text
	 */
	AbapPreparedStatement(AbapConnection connection, String sqltext) throws SQLException {
		super(connection);
		sql = new SQL(sqltext);
		List<AbapTableMetadata> tablemetadata = new ArrayList<>();
		tablemetadata.add(AbapTableMetadata.get(sql.getTablename(), connection));
    	sql.updateMetadata(tablemetadata);
	}

	@Override
	public ResultSet executeQuery() throws SQLException {
		return rfcReadTable();
	}

	@Override
	public int executeUpdate() throws SQLException {
		throw new SQLException("Not implemented");
	}

	@Override
	public void setNull(int parameterIndex, int sqlType) throws SQLException {
		sql.setParameter(parameterIndex, null);
	}

	@Override
	public void setBoolean(int parameterIndex, boolean x) throws SQLException {
		sql.setParameter(parameterIndex, x?"X":"");
	}

	@Override
	public void setByte(int parameterIndex, byte x) throws SQLException {
		sql.setParameter(parameterIndex, String.valueOf(x));
	}

	@Override
	public void setShort(int parameterIndex, short x) throws SQLException {
		sql.setParameter(parameterIndex, String.valueOf(x));
	}

	@Override
	public void setInt(int parameterIndex, int x) throws SQLException {
		sql.setParameter(parameterIndex, String.valueOf(x));
	}

	@Override
	public void setLong(int parameterIndex, long x) throws SQLException {
		sql.setParameter(parameterIndex, String.valueOf(x));
	}

	@Override
	public void setFloat(int parameterIndex, float x) throws SQLException {
		sql.setParameter(parameterIndex, String.valueOf(x));
	}

	@Override
	public void setDouble(int parameterIndex, double x) throws SQLException {
		sql.setParameter(parameterIndex, String.valueOf(x));
	}

	@Override
	public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {
		setObject(parameterIndex, x);
	}

	@Override
	public void setString(int parameterIndex, String x) throws SQLException {
		sql.setParameter(parameterIndex, x);
	}

	@Override
	public void setBytes(int parameterIndex, byte[] x) throws SQLException {
	}

	@Override
	public void setDate(int parameterIndex, Date x) throws SQLException {
		setObject(parameterIndex, x);
	}

	@Override
	public void setTime(int parameterIndex, Time x) throws SQLException {
		setObject(parameterIndex, x);
	}

	@Override
	public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {
		setObject(parameterIndex, x);
	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException {
		throw new SQLException("Method not supported");
	}

	@Override
	public void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException {
		throw new SQLException("Method not supported");
	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException {
		throw new SQLException("Method not supported");
	}

	@Override
	public void clearParameters() throws SQLException {
	}

	@Override
	public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {
		setObject(parameterIndex, x);
	}

	@Override
	public void setObject(int parameterIndex, Object x) throws SQLException {
		if (x == null) {
			sql.setParameter(parameterIndex, null);
		} else if (x instanceof Date d) {
			sql.setParameter(parameterIndex, AbapResultSet.formatteryyyymmdd.format(LocalDate.ofInstant(d.toInstant(), ZoneOffset.UTC)));
		} else if (x instanceof Time t) {
			sql.setParameter(parameterIndex, AbapResultSet.formatterhhmmss.format(t.toLocalTime()));
		} else if (x instanceof Timestamp t) {
			sql.setParameter(parameterIndex, AbapResultSet.formatteryyyymmdd.format(LocalDate.ofInstant(t.toInstant(), ZoneOffset.UTC)));
		} else if (x instanceof byte[] b) {
			setBytes(parameterIndex, b);
		} else {
			sql.setParameter(parameterIndex, String.valueOf(x));
		}
	}

	@Override
	public boolean execute() throws SQLException {
		procedure = new AbapProcedure(sql);
		resultsetindex = 0;
		return procedure.hasResultSets();
	}

	@Override
	public void addBatch() throws SQLException {
		throw new SQLException("Method not supported");
	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException {
		throw new SQLException("Method not supported");
	}

	@Override
	public void setRef(int parameterIndex, Ref x) throws SQLException {
		throw new SQLException("Method not supported");
	}

	@Override
	public void setBlob(int parameterIndex, Blob x) throws SQLException {
		throw new SQLException("Method not supported");
	}

	@Override
	public void setClob(int parameterIndex, Clob x) throws SQLException {
		throw new SQLException("Method not supported");
	}

	@Override
	public void setArray(int parameterIndex, Array x) throws SQLException {
		throw new SQLException("Method not supported");
	}

	@Override
	public ResultSetMetaData getMetaData() throws SQLException {
		return sql;
	}

	@Override
	public void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException {
		setDate(parameterIndex, x);
	}

	@Override
	public void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException {
		setTime(parameterIndex, x);
	}

	@Override
	public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException {
		setTimestamp(parameterIndex, x);
	}

	@Override
	public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {
		sql.setParameter(parameterIndex, null);
	}

	@Override
	public void setURL(int parameterIndex, URL x) throws SQLException {
		setObject(parameterIndex, x);
	}

	@Override
	public ParameterMetaData getParameterMetaData() throws SQLException {
		return sql.getParameterMetadata();
	}

	@Override
	public void setRowId(int parameterIndex, RowId x) throws SQLException {
		throw new SQLException("Method not supported");
	}

	@Override
	public void setNString(int parameterIndex, String value) throws SQLException {
		setString(parameterIndex, value);
	}

	@Override
	public void setNCharacterStream(int parameterIndex, Reader value, long length) throws SQLException {
		throw new SQLException("Method not supported");
	}

	@Override
	public void setNClob(int parameterIndex, NClob value) throws SQLException {
		throw new SQLException("Method not supported");
	}

	@Override
	public void setClob(int parameterIndex, Reader reader, long length) throws SQLException {
		throw new SQLException("Method not supported");
	}

	@Override
	public void setBlob(int parameterIndex, InputStream inputStream, long length) throws SQLException {
		throw new SQLException("Method not supported");
	}

	@Override
	public void setNClob(int parameterIndex, Reader reader, long length) throws SQLException {
		throw new SQLException("Method not supported");
	}

	@Override
	public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException {
		setObject(parameterIndex, xmlObject);
	}

	@Override
	public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength) throws SQLException {
		setObject(parameterIndex, x);
	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException {
		throw new SQLException("Method not supported");
	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException {
		throw new SQLException("Method not supported");
	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader, long length) throws SQLException {
		throw new SQLException("Method not supported");
	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x) throws SQLException {
		throw new SQLException("Method not supported");
	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x) throws SQLException {
		throw new SQLException("Method not supported");
	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException {
		throw new SQLException("Method not supported");
	}

	@Override
	public void setNCharacterStream(int parameterIndex, Reader value) throws SQLException {
		throw new SQLException("Method not supported");
	}

	@Override
	public void setClob(int parameterIndex, Reader reader) throws SQLException {
		throw new SQLException("Method not supported");
	}

	@Override
	public void setBlob(int parameterIndex, InputStream inputStream) throws SQLException {
		throw new SQLException("Method not supported");
	}

	@Override
	public void setNClob(int parameterIndex, Reader reader) throws SQLException {
		throw new SQLException("Method not supported");
	}

}
