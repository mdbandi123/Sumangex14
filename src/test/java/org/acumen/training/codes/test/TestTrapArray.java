package org.acumen.training.codes.test;

import org.acumen.training.codes.TrapArray;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTrapArray {
	private TrapArray ta;
	
	@BeforeEach
	public void setup() {
		ta = new TrapArray();
	}
	
	@AfterEach
	public void teardown() {
		ta = null;
	}
	
	@Test
	public void testArrayTransact() {
		ta.arrayTransact();
	}
}
