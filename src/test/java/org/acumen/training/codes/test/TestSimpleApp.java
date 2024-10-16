package org.acumen.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.acumen.training.codes.SimpleApp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class TestSimpleApp {
	private static final Logger LOGGER = LogManager.getLogger("LOGGER1");
	@Test
	public void testApp() {
		LOGGER.info("testApp");
		SimpleApp app = new SimpleApp();
		assertTrue(app.returnOne() == 1,"app didn't return 1");
	}
}
