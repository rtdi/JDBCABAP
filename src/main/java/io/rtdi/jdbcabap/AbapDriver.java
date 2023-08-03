package io.rtdi.jdbcabap;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

public class AbapDriver implements Driver {
	private static final Driver INSTANCE = new AbapDriver();
	private static boolean registered;
	
	public AbapDriver() {
		super();
		JdbcDestinationDataProvider.register();
	}

	@Override
	public Connection connect(String url, Properties info) throws SQLException {
		return new AbapConnection(url, info);
	}

	@Override
	public boolean acceptsURL(String url) throws SQLException {
		return url.startsWith("jdbc:abap:");
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String s, Properties properties) throws SQLException {
		return new DriverPropertyInfo[0];
	}

	@Override
	public int getMajorVersion() {
		return 0;
	}

	@Override
	public int getMinorVersion() {
		return 1;
	}

	@Override
	public boolean jdbcCompliant() {
		return true;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

	public static synchronized Driver load() {
		if (!registered) {
			registered = true;
			try {
				DriverManager.registerDriver(INSTANCE);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return INSTANCE;
	}

	static {
		load();
	}
}