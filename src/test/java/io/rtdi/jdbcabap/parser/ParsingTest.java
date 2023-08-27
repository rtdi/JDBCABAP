package io.rtdi.jdbcabap.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.rtdi.jdbcabap.sql.SQL;


class ParsingTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testOneCommand() {
		try {
			SQL parser = new SQL("select dd02l.sdgs from dd02l");
			assertNotNull(parser.getFields());
			assertEquals(1, parser.getFields().size());
			assertEquals("SDGS", parser.getFields().get(0).getColumnname());
			assertEquals("DD02L", parser.getTablename());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}

}
