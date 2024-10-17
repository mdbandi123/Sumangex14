package org.acumen.training.codes.test;

import org.acumen.training.codes.Coin;
import org.acumen.training.codes.VendingMachine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestVendingMachine {
	private VendingMachine vm;
	private static final Logger LOGGER = LogManager.getLogger("LOGGER4");

	@BeforeEach
	public void setup() {
		vm = new VendingMachine();
	}
	
	@AfterEach
	public void teardown() {
		vm = null;
	}
	
	@Test
	public void testInsert() {
		Coin coin = new Coin("penny");
		
		vm.insert(coin);
	}
	
	@Test
	public void testReturnCoins() {
		vm.returnCoins();
	}
	
	@Test
	public void testVend() {
		try {
			vm.vend();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
	}
}
