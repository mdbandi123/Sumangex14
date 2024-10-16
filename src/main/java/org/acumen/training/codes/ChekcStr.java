package org.acumen.training.codes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChekcStr {
	private static final Logger LOGGER = LogManager.getLogger("LOGGER3");

	public ChekcStr() {
		LOGGER.info("instantiated ChekcStr");
	}

	public String convert(String str) {
		LOGGER.info("executing convert...");
		String binarise = binarise(total(str));
		LOGGER.info("end of convert");
		LOGGER.info("returning with value: {}", binarise);
		return binarise;
	}

	public int total(String str) {
		LOGGER.info("executing total...");
		if (str == "") {
			LOGGER.info("end of total - str is empty string");
			LOGGER.info("returning with value: {}", 0);
			return 0;
		}
		if (str.length() == 1) {
			LOGGER.info("end of total - str length is 1");
			LOGGER.info("returning with value: {}", ((int) (str.charAt(0))));
			return ((int) (str.charAt(0)));
		}
		LOGGER.info("end of total");
		LOGGER.info("returning with value: {}", ((int) (str.charAt(0))) + total(str.substring(1)));
		return ((int) (str.charAt(0))) + total(str.substring(1));

	}

	public String binarise(int givenstrvalue) {
		LOGGER.info("executing binarise...");
		if (givenstrvalue == 0) {
			LOGGER.info("end of binarise - givenstrvalue is empty string");
			LOGGER.info("returning with value: {}", "");
			return "";
		}
		if (givenstrvalue % 2 == 1) {
			LOGGER.info("end of binarise - givenstrvalue is odd");
			LOGGER.info("returning with value: {}", ("1" + binarise(givenstrvalue / 2)));
			return "1" + binarise(givenstrvalue / 2);
		}
		LOGGER.info("end of binarise");
		LOGGER.info("returning with value: {}", ("0" + binarise(givenstrvalue / 2)));
		return "0" + binarise(givenstrvalue / 2);
	}
}
