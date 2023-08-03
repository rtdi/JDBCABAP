package io.rtdi.jdbcabap.parser;

import java.sql.SQLException;

import io.rtdi.jdbcabap.AbapTableMetadata;

public class BracketExpression implements Expression, WithParent {
	private WhereClause inner;
	private WhereClause parent;

	public void setInner(WhereClause w) {
		inner = w;
	}

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
	public void updateMetadata(AbapTableMetadata tablemetadata) throws SQLException {
		if (inner != null) {
			inner.updateMetadata(tablemetadata);
		}
	}

}
