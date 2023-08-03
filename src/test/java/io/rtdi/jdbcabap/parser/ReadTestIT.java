package io.rtdi.jdbcabap.parser;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class ReadTestIT {

	private static Connection conn;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		try {
			conn = DriverManager.getConnection("jdbc:abap://54.160.1.238:00:001", "DEVELOPER", "qrpXW32Wks9Fb5");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testOneCommand() {
		try {
			try (PreparedStatement stmt = conn.prepareStatement("select null, null, TABNAME from dd02l where tabname like 'DD02%'")) {
				try (ResultSet rs = stmt.executeQuery()) {
					int rowcount = 0;
					System.out.println("Select with pattern DD02%: ");
					while (rs.next()) {
						rowcount++;
						System.out.print(rowcount);
						for (int i=1; i <= rs.getMetaData().getColumnCount(); i++) {
							System.out.print(";");
							System.out.print(rs.getString(i));
						}
						System.out.println();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}

	@Test
	void testPrimaryKey() {
		try {
			List<String> pks = new ArrayList<>();
			ResultSet rs = conn.getMetaData().getPrimaryKeys(null, null, "DD02L");
			while (rs.next()) {
				pks.add(rs.getString(4) + ", " + rs.getInt(5));
			}
			System.out.print("PKs for DD02L: ");
			System.out.println(pks);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}

	@Test
	void testForeignKey1() {
		try {
			ResultSet rs = conn.getMetaData().getCrossReference(null, null, "DD08L", null, null, "DD03L");
			FKInfo fk = new FKInfo();
			while (rs.next()) {
				fk.add(rs);
			}
			System.out.print("FK relationship between DD08L to DD03L: ");
			System.out.println(fk);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}
	
	private static class FKInfo extends HashMap<String, List<String>>{
		
		private static final long serialVersionUID = -8877863628916583547L;

		private void add(ResultSet rs) throws SQLException {
			String fkname = rs.getString(12);
			List<String> conditions = get(fkname);
			if (conditions == null) {
				conditions = new ArrayList<>();
				put(fkname, conditions);
			}
			conditions.add(String.format("%s.%s = %s.%s", rs.getString(3), rs.getString(4), rs.getString(7), rs.getString(8)));
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (Entry<String, List<String>> entry : this.entrySet()) {
				sb.append(entry.getKey()).append(": ");
				List<String> conditions = entry.getValue();
				StringBuilder sbc = new StringBuilder();
				for (String condition : conditions) {
					if (sbc.length() != 0) {
						sbc.append(" AND ");
					}
					sbc.append(condition);
				}
				sb.append(sbc);
				sb.append("\r\n");
			}
			return sb.toString();
		}
	}

	@Test
	void testForeignKey2() {
		try {
			ResultSet rs = conn.getMetaData().getImportedKeys(null, null, "DD08L");
			FKInfo fk = new FKInfo();
			while (rs.next()) {
				fk.add(rs);
			}
			System.out.print("Importing FKs for DD08L: ");
			System.out.println(fk);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}

	@Test
	void testForeignKey3() {
		try {
			ResultSet rs = conn.getMetaData().getExportedKeys(null, null, "DD03L");
			FKInfo fk = new FKInfo();
			while (rs.next()) {
				fk.add(rs);
			}
			System.out.print("Exporting FKs for DD03L: ");
			System.out.println(fk);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}

	@Test
	void testParsingError() {
		try {
			assertThrowsExactly(SQLException.class, () -> {
					try (PreparedStatement stmt = conn.prepareStatement("select *, from from dd02l")) {
					}
				}
			);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}

	@Test
	void testTableNotExists() {
		try {
			assertThrowsExactly(SQLException.class, () -> {
					try (PreparedStatement stmt = conn.prepareStatement("select * from ABCDEFG")) {
					}
				}
			);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}

	@Test
	void testFieldNotExists() {
		try {
			assertThrowsExactly(SQLException.class, () -> {
					try (PreparedStatement stmt = conn.prepareStatement("select ABCDEFG from DD02L")) {
					}
				}
			);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}

	@Test
	void testGetTypes() {
		try {
			List<String> tabletypes = new ArrayList<>();
			ResultSet rs = conn.getMetaData().getTableTypes();
			while (rs.next()) {
				tabletypes.add(rs.getString(1));
			}
			System.out.print("Supported types: ");
			System.out.println(tabletypes);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}

	@Test
	void testGetTables() {
		try {
			ResultSet rs = conn.getMetaData().getTables(null, null, "DD02*", null);
			List<String> tables = new ArrayList<>();
			while (rs.next()) {
				tables.add(rs.getString(3));
			}
			System.out.print("Search for tables with pattern DD02%: ");
			System.out.println(tables);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}

	@Test
	void testGetColumns() {
		try {
			ResultSet rs = conn.getMetaData().getColumns(null, null, "DD02L", null);
			List<String> tables = new ArrayList<>();
			while (rs.next()) {
				tables.add(rs.getString(4));
			}
			System.out.print("All columns of table DD02L: ");
			System.out.println(tables);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}

}
