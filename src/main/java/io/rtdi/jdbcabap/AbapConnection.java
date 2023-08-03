package io.rtdi.jdbcabap;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;

public class AbapConnection implements java.sql.Connection {
	private final String jdbcpattern = "jdbc:abap:\\/\\/(([^\\:]+)\\\\:([^\\@]+)@)?([^\\:]+)\\:(\\d\\d)\\:(\\d\\d\\d)(\\:([a-zA-Z][a-zA-Z]))?(\\?.*)?";
	private final Pattern pattern = Pattern.compile(jdbcpattern);
	private String destinationname;
	private JCoDestination destination;
	private String jdbcurl;
	private String username;

	AbapConnection(String urltext, Properties info) throws SQLException {
		// jdbc:abap://[<user>:<passwd>@]<host>:<systemno>:<client>:[<lang>]
		Matcher matcher = pattern.matcher(urltext);
		if (matcher.matches()) {
			try {
				String user = matcher.group(2);
				String passwd = matcher.group(3);
				String host = matcher.group(4);
				String systemno = matcher.group(5);
				String client = matcher.group(6);
				String lang = matcher.group(8);
				@SuppressWarnings("unused")
				String queryparams = matcher.group(9); // "?x=2"
				if (lang == null) {
					lang = "EN";
				}
				if (info != null) {
					if (info.getProperty("user") != null) {
						user = info.getProperty("user");
					}
					if (info.getProperty("password") != null) {
						passwd = info.getProperty("password");
					}
				}
				checkParameter(user, "No user provided via the URL nor as property");
				checkParameter(passwd, "No passwd provided via the URL nor as property");
				checkParameter(host, "No hostname provided");
				checkParameter(systemno, "No system number provided");
				checkParameter(client, "No client provided");
				this.jdbcurl = urltext;
				this.username = user;
				destinationname = JdbcDestinationDataProvider.createConnection(host, systemno, client, user, passwd, lang);
				destination = JdbcDestinationDataProvider.getJCoDestination(destinationname);
				destination.ping();
			} catch (JCoException e) {
				throw new SQLException("Failed to connect target system", e);
			}
		} else {
			throw new SQLException("jdbc url is invalid, must be in pattern jdbc:abap://[<user>:<passwd>@]<host>:<systemno>:<client>[:<lang>][?<param>=<value>] where "
					+ "systemno is a two digit number and client a 3 digit number");
		}
	}
	
	private void checkParameter(String value, String exceptiontext) throws SQLException {
		if (value == null) {
			throw new SQLException(exceptiontext);
		}
	}

	@Override
	public void close() throws SQLException {
		JdbcDestinationDataProvider.removeConnection(destinationname);
		destination = null;
		destinationname = null;
	}

	@Override
	public boolean isClosed() throws SQLException {
		return destination == null;
	}

	@Override
	public Statement createStatement() throws SQLException {
		return new AbapStatement(this);
	}

	@Override
	public PreparedStatement prepareStatement(String sql) throws SQLException {
		return new AbapPreparedStatement(this, sql);
	}

	@Override
	public CallableStatement prepareCall(String sql) throws SQLException {
		return null;
	}

	@Override
	public String nativeSQL(String sql) throws SQLException {
		return null;
	}

	@Override
	public void setAutoCommit(boolean b) throws SQLException {

	}

	@Override
	public boolean getAutoCommit() throws SQLException {
		return false;
	}

	@Override
	public void commit() throws SQLException {

	}

	@Override
	public void rollback() throws SQLException {

	}

	@Override
	public DatabaseMetaData getMetaData() throws SQLException {
		return new AbapDatabaseMetaData(this);
	}

	@Override
	public void setReadOnly(boolean b) throws SQLException {

	}

	@Override
	public boolean isReadOnly() throws SQLException {
		return false;
	}

	@Override
	public void setCatalog(String s) throws SQLException {

	}

	@Override
	public String getCatalog() throws SQLException {
		return null;
	}

	@Override
	public void setTransactionIsolation(int i) throws SQLException {

	}

	@Override
	public int getTransactionIsolation() throws SQLException {
		return 0;
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		return null;
	}

	@Override
	public void clearWarnings() throws SQLException {

	}

	@Override
	public Statement createStatement(int i, int i1) throws SQLException {
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String s, int i, int i1) throws SQLException {
		return null;
	}

	@Override
	public CallableStatement prepareCall(String s, int i, int i1) throws SQLException {
		return null;
	}

	@Override
	public Map<String, Class<?>> getTypeMap() throws SQLException {
		return null;
	}

	@Override
	public void setTypeMap(Map<String, Class<?>> map) throws SQLException {

	}

	@Override
	public void setHoldability(int i) throws SQLException {

	}

	@Override
	public int getHoldability() throws SQLException {
		return 0;
	}

	@Override
	public Savepoint setSavepoint() throws SQLException {
		return null;
	}

	@Override
	public Savepoint setSavepoint(String s) throws SQLException {
		return null;
	}

	@Override
	public void rollback(Savepoint savepoint) throws SQLException {

	}

	@Override
	public void releaseSavepoint(Savepoint savepoint) throws SQLException {

	}

	@Override
	public Statement createStatement(int i, int i1, int i2) throws SQLException {
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String s, int i, int i1, int i2) throws SQLException {
		return null;
	}

	@Override
	public CallableStatement prepareCall(String s, int i, int i1, int i2) throws SQLException {
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String s, int i) throws SQLException {
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String s, int[] ints) throws SQLException {
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String s, String[] strings) throws SQLException {
		return null;
	}

	@Override
	public Clob createClob() throws SQLException {
		return null;
	}

	@Override
	public Blob createBlob() throws SQLException {
		return null;
	}

	@Override
	public NClob createNClob() throws SQLException {
		return null;
	}

	@Override
	public SQLXML createSQLXML() throws SQLException {
		return null;
	}

	@Override
	public boolean isValid(int i) throws SQLException {
		return false;
	}

	@Override
	public void setClientInfo(String s, String s1) throws SQLClientInfoException {

	}

	@Override
	public void setClientInfo(Properties properties) throws SQLClientInfoException {

	}

	@Override
	public String getClientInfo(String s) throws SQLException {
		return null;
	}

	@Override
	public Properties getClientInfo() throws SQLException {
		return null;
	}

	@Override
	public Array createArrayOf(String s, Object[] objects) throws SQLException {
		return null;
	}

	@Override
	public Struct createStruct(String s, Object[] objects) throws SQLException {
		return null;
	}

	@Override
	public void setSchema(String s) throws SQLException {

	}

	@Override
	public String getSchema() throws SQLException {
		return null;
	}

	@Override
	public void abort(Executor executor) throws SQLException {

	}

	@Override
	public void setNetworkTimeout(Executor executor, int i) throws SQLException {

	}

	@Override
	public int getNetworkTimeout() throws SQLException {
		return 0;
	}

	@Override
	public <T> T unwrap(Class<T> aClass) throws SQLException {
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> aClass) throws SQLException {
		return false;
	}

	public JCoDestination getJCoDestination() throws SQLException {
		if (destination == null) {
			throw new SQLException("Abap connection is closed");
		}
		return destination;
	}

	public String getJdbcUrl() {
		return jdbcurl;
	}

	public String getUsername() {
		return username;
	}
	
}