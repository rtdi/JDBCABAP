package io.rtdi.jdbcabap;

public interface RowTransformation {

	void apply(Object[] row);

}
