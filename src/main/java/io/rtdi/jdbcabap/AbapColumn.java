package io.rtdi.jdbcabap;

/**
 * A column within a source table, used to gather field information in SQLs
 */
public class AbapColumn {

	private String columnname;
	private int position;
	private int offset;
	private int len;
	private int scale;
	private AbapDataType datatype;

	/**
	 * Create a column with a defined name
	 * 
	 * @param name of the column
	 */
	public AbapColumn(String name) {
		columnname = name;
		this.position = -1;
	}

	/**
	 * Create a new column with all metadata fields
	 * @param fieldname of the column
	 * @param position in the table or result set
	 * @param offset value in the byte string
	 * @param len of the column
	 * @param scale of decimal columns
	 * @param datatype of the column
	 */
	public AbapColumn(String fieldname, int position, int offset, int len, int scale, String datatype) {
		this.columnname = fieldname;
		this.position = position;
		this.offset = offset;
		this.len = len;
		this.scale = scale;
		this.datatype = AbapDataType.valueOf(datatype);
	}

	/**
	 * @return the column name
	 */
	public String getColumnname() {
		return columnname;
	}

	/**
	 * @return the column position value
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * @return the offset within the byte string
	 */
	public int getOffset() {
		return offset;
	}

	/**
	 * @return the length of the column
	 */
	public int getLen() {
		return len;
	}

	/**
	 * @return the scale information for decimal values
	 */
	public int getScale() {
		return scale;
	}

	/**
	 * @return the data type of the column
	 */
	public AbapDataType getDatatype() {
		return datatype;
	}

	/**
	 * @param columnname to be used
	 */
	public void setColumnname(String columnname) {
		this.columnname = columnname;
	}

	/**
	 * @param position of the column
	 */
	public void setPosition(int position) {
		this.position = position;
	}

	/**
	 * @param offset of the column
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}

	/**
	 * @param len of the column
	 */
	public void setLen(int len) {
		this.len = len;
	}

	/**
	 * @param scale of the column
	 */
	public void setScale(int scale) {
		this.scale = scale;
	}

	/**
	 * @param datatype of the column
	 */
	public void setDataType(AbapDataType datatype) {
		this.datatype = datatype;
	}

	@Override
	public String toString() {
		return columnname;
	}

}
