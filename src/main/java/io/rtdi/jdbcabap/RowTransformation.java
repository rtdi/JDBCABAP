package io.rtdi.jdbcabap;

/**
 * Allows to modify result sets after the row values have been added
 */
public interface RowTransformation {

	/**
	 * Current active row with its values
	 * 
	 * @param row contains all value of the current row and can be modified
	 */
	void apply(Object[] row);

}
