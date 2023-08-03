package io.rtdi.jdbcabap;

import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.ext.DestinationDataEventListener;
import com.sap.conn.jco.ext.DestinationDataProvider;

/**
 * The logic of having one destination with host and user does not harmonize well with JDBC, where once connection is
 * an exclusive and unique database connection.
 * Hence each JDBC connection is one destination of its own.
 */
public class JdbcDestinationDataProvider implements DestinationDataProvider {
	private static DestinationDataEventListener listener;
	private static Map<String, Properties> connectionprops = Collections.synchronizedMap(new HashMap<String, Properties>());
	private static int connectioncounter = 0;

	@Override
	public Properties getDestinationProperties(String destinationName) {
		return connectionprops.get(destinationName);
	}

	@Override
	public void setDestinationDataEventListener(DestinationDataEventListener eventListener) {
		JdbcDestinationDataProvider.listener = eventListener;
	}

	@Override
	public boolean supportsEvents() {
		return true;
	}

	public static String createConnection(String host, String systemno, String client, String user, String passwd, String lang) {
		synchronized (connectionprops) {
			String name = String.valueOf(connectioncounter++);
			if (connectionprops.get(name) == null) {
				Properties connectProperties = new Properties();
				connectProperties.setProperty(DestinationDataProvider.JCO_ASHOST, host);
				connectProperties.setProperty(DestinationDataProvider.JCO_SYSNR, systemno);
				connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT, client);
				connectProperties.setProperty(DestinationDataProvider.JCO_USER, user);
				connectProperties.setProperty(DestinationDataProvider.JCO_PASSWD, passwd);
				connectProperties.setProperty(DestinationDataProvider.JCO_LANG, lang);
				connectionprops.put(name, connectProperties);
				if (listener != null) {
					listener.updated(name);
				}
			}
			return name;
		}
	}
	
	public static void removeConnection(String name) {
		synchronized (connectionprops) {
			if (connectionprops.containsKey(name)) {
				connectionprops.remove(name);
				if (listener != null) {
					listener.deleted(name);
				}
			}
		}
	}
	
	public static void close() {
		Iterator<String> iter = connectionprops.keySet().iterator();
		while (iter.hasNext()) {
			removeConnection(iter.next());
		}
	}

	public static boolean validate(String name) throws SQLException {
		try {
			JCoDestination dest = JCoDestinationManager.getDestination(name);
			if (dest == null) {
				throw new SQLException("No JCo destination with this name added yet (" + name + ")");
			} else {
				dest.ping();
				return true;
			}
		} catch (JCoException e) {
			throw new SQLException("JCo exception thrown", e);
		}
	}
	
	public static void register() {
		JdbcDestinationDataProvider provider = new JdbcDestinationDataProvider();
		try {
			com.sap.conn.jco.ext.Environment.registerDestinationDataProvider(provider);
		} catch (IllegalStateException providerAlreadyRegisteredException) {
			// ignore
		}
	}
	
	public static JCoDestination getJCoDestination(String name) throws SQLException {
		try {
			return JCoDestinationManager.getDestination(name);
		} catch (JCoException e) {
			throw new SQLException("Cannot get the JCo destination with name " + name, e);
		}
	}
}
