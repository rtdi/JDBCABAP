package io.rtdi.jdbcabap.parser;

import java.sql.SQLException;
import java.util.List;

import io.rtdi.jdbcabap.AbapTableMetadata;

/**
 * An expression ( inner )
 */
public class BracketExpression implements Condition, WithParent {
	private WhereClause inner;
	private WhereClause parent;

	/**
	 * The inner where expression is within brackets
	 * 
	 * @param w the inner where expression that reads as (inner)
	 */
	public void setInner(WhereClause w) {
		inner = w;
	}

	/**
	 * A bracket expression within a parent
	 * @param parent expression
	 */
	public BracketExpression(WhereClause parent) {
		this.parent = parent;
	}

	@Override
	public WithParent getParent() {
		return parent;
	}

	@Override
	public String toString() {
		return "(" + inner + ")";
	}

	@Override
	public void updateMetadata(List<AbapTableMetadata> tablemetadata) throws SQLException {
		if (inner != null) {
			inner.updateMetadata(tablemetadata);
		}
	}

}
