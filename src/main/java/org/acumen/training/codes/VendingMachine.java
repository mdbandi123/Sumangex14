package org.acumen.training.codes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VendingMachine {
	private int totValue;
	private int currValue;
	private boolean enabled;
	private static final int COST = 75;
	private static final Logger LOGGER = LogManager.getLogger("LOGGER4");

	public VendingMachine() {
		totValue = 0;
		currValue = 0;
		enabled = false;
	}

	public void insert(Coin coin) {
		LOGGER.info("executing insert()...");
		int value = coin.getValue();
		if (value == 0) {
			LOGGER.error("illegal value");
		} else {
			currValue += value;
			System.out.print("Current value = " + currValue);
			if (currValue >= COST) {
				enabled = true;
				LOGGER.info(" (sufficient credit)");
			} else
				LOGGER.info("");
		}
		LOGGER.info("end of insert()");
	}

	public void returnCoins() {
		LOGGER.info("executing returnCoins()...");
		if (currValue == 0) {
			LOGGER.error("no coins to return");
		} else {
			LOGGER.info("Take your coins");
			currValue = 0;

			enabled = false;
		}
		LOGGER.info("end of returnCoins()");
	}

	public void vend() throws Exception {
		LOGGER.info("executing vend()...");
		if (enabled) {
			LOGGER.info("Get your drink");
			totValue += COST;
			currValue -= COST;
			if (currValue == 0)
				enabled = false;
			LOGGER.info("Current value = {}", currValue);
		} else {
			LOGGER.info("Not enough credit: add {}", (COST - currValue));
		}
		if (currValue < 0) {
			LOGGER.error("Error: negative credit!");
			throw new Exception("Error: negative credit!");
		}
		
		LOGGER.info("end of vend()");
	}
}
