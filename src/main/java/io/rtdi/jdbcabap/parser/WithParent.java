package io.rtdi.jdbcabap.parser;

/**
 * An Expression that can be nested inside another
 */
public interface WithParent {
	
	/**
	 * An Expression is nested within another
	 * @return the parent or null
	 */
	WithParent getParent();

}
