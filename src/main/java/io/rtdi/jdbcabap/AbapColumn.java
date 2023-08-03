package io.rtdi.jdbcabap;

public class AbapColumn {

	private String columnname;
	private int position;
	private int offset;
	private int len;
	private int scale;
	private AbapDataType datatype;

	public AbapColumn(String text) {
		columnname = text;
		this.position = -1;
	}

	public AbapColumn(String fieldname, int position, int offset, int len, int scale, String datatype) {
		this.columnname = fieldname;
		this.position = position;
		this.offset = offset;
		this.len = len;
		this.scale = scale;
		this.datatype = AbapDataType.valueOf(datatype);
	}

	public String getColumnname() {
		return columnname;
	}

	public int getPosition() {
		return position;
	}

	public int getOffset() {
		return offset;
	}

	public int getLen() {
		return len;
	}

	public int getScale() {
		return scale;
	}

	public AbapDataType getDatatype() {
		return datatype;
	}

	public void setColumnname(String columnname) {
		this.columnname = columnname;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public void setLen(int len) {
		this.len = len;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public void setDataType(AbapDataType datatype) {
		this.datatype = datatype;
	}

	@Override
	public String toString() {
		return columnname;
	}

}
