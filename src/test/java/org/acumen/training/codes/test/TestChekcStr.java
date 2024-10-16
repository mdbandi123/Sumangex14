package org.acumen.training.codes.test;

import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.acumen.training.codes.ChekcStr;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestChekcStr {
	private ChekcStr chekc;
	private Map<String, String> testDataStrings = Map.ofEntries(
			entry("1", "00110001"), 
			entry("2", "00110010"), 
			entry("3", "00110011"), 
			entry("4", "00110100"),
			entry("5", "00110101"), 
			entry("6", "00110110"), 
			entry("7", "00110111"), 
			entry("8", "00111000"),
			entry("9", "00111001"), 
			entry("10", "00110001 00110000"));
	
	private Map<String, Integer> testDataTotal = Map.ofEntries(
			entry("1", 49), entry("2", 50), entry("3", 51), entry("4", 52),
			entry("5", 53), entry("6", 54), entry("7", 55), entry("8", 56),
			entry("9", 57), entry("10", 97));

	@BeforeEach
	public void setup() {
		chekc = new ChekcStr();
	}

	@AfterEach
	public void teardown() {
		chekc = null;
	}

	@ParameterizedTest
	@ValueSource(chars = { 'a', 'b', 'c', 'd', 'e' })
	public void testBinariseChar(char letter) {
		String expectedVal = Integer.toBinaryString(letter);

		String actualVal = chekc.binarise(letter);

		assertEquals(expectedVal, actualVal);
	}

	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 })
	public void testBinariseNum(int num) {
		String expectedVal = Integer.toBinaryString(num);

		String actualVal = chekc.binarise(num);

		assertEquals(expectedVal, actualVal);
	}

	@Test
	public void testBinariseZero() {
		int zero = 0;
		String expectedVal = "";

		String actualVal = chekc.binarise(zero);

		assertEquals(expectedVal, actualVal);
	}

	@ParameterizedTest
	@ValueSource(strings = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" })
	public void testConvert(String word) {

		String expectedVal = testDataStrings.get(word);

		assertDoesNotThrow(() -> {
			String actualVal = chekc.convert(word);
			assertEquals(expectedVal, actualVal);
		});

	}
	
	@Test
	public void testConvertNull() {
		assertThrows(NullPointerException.class,() -> {
			String actualVal = chekc.convert(null);
		});
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" })
	public void testTotal(String word) {

		int expectedVal = testDataTotal.get(word);

		assertDoesNotThrow(() -> {
			int actualVal = chekc.total(word);
			assertEquals(expectedVal, actualVal);
		});

	}
	
	@Test
	public void testTotalNull() {
		assertThrows(NullPointerException.class,() -> {
			String actualVal = chekc.convert(null);
		});
	}

}
