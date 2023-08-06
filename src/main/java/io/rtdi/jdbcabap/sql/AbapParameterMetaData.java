package io.rtdi.jdbcabap.sql;

import java.sql.ParameterMetaData;
import java.sql.SQLException;
import java.util.List;

import io.rtdi.jdbcabap.parser.Parameter;

/**
 * Required class for parameter metadata
 */
public class AbapParameterMetaData implements ParameterMetaData {

	private List<Parameter> parameters;

	/**
	 * 
	 * @param parameters of the statement
	 */
	public AbapParameterMetaData(List<Parameter> parameters) {
		this.parameters = parameters;
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
	public int getParameterCount() throws SQLException {
		if (parameters == null) {
			return 0;
		} else {
			return parameters.size();
		}
	}

	@Override
	public int isNullable(int param) throws SQLException {
		return ParameterMetaData.parameterNoNulls;
	}

	@Override
	public boolean isSigned(int param) throws SQLException {
		return true;
	}

	@Override
	public int getPrecision(int param) throws SQLException {
		return 0;
	}

	@Override
	public int getScale(int param) throws SQLException {
		return 0;
	}

	@Override
	public int getParameterType(int param) throws SQLException {
		return getParameter(param).getDatatype().getJdbcType().getVendorTypeNumber();
	}

	@Override
	public String getParameterTypeName(int param) throws SQLException {
		return getParameter(param).getDatatype().getJdbcType().getName();
	}

	@Override
	public String getParameterClassName(int param) throws SQLException {
		return null;
	}

	@Override
	public int getParameterMode(int param) throws SQLException {
		return ParameterMetaData.parameterModeIn;
	}

	private Parameter getParameter(int param) throws SQLException {
		if (parameters == null) {
			throw new SQLException("SQL statement has no parameters");
		} else if (param > 0 && param <= parameters.size()) {
			return parameters.get(param-1);
		} else {
			throw new SQLException(String.format("SQL statement has %d parameters and provided index of %d is not in range", parameters.size(), param));
		}
	}
}
