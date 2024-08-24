package com.nik_jp.commons.lang;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for StringCombinationsTest.
 */
public class StringCombinationsTest {

	@Test
	public void test1() {
		try {
			StringCombinations.generateCombinations("ABC", 1, 3, StringCombinationsTest::processCombination);
		} catch (Exception ex) {
			fail("An exception occurred during a test case that was expected to complete successfully.");
		}
		assertTrue(true);
	}

	@Test
	public void testEx001() {
		try {
			StringCombinations.generateCombinations(null, 1, 3, StringCombinationsTest::processCombination);
		} catch (IllegalArgumentException ex) {
			assertEquals("Set the string to some value.", ex.getMessage());
		} catch (Exception ex) {
			fail("An unexpected exception occurred.");
		}

		try {
			StringCombinations.generateCombinations("", 1, 3, StringCombinationsTest::processCombination);
		} catch (IllegalArgumentException ex) {
			assertEquals("Set the string to some value.", ex.getMessage());
		} catch (Exception ex) {
			fail("An unexpected exception occurred.");
		}
	}

	@Test
	public void testEx002() {
		try {
			StringCombinations.generateCombinations("ABC", 0, 3, StringCombinationsTest::processCombination);
		} catch (IllegalArgumentException ex) {
			assertEquals("The minimum length cannot be negative.", ex.getMessage());
		} catch (Exception ex) {
			fail("An unexpected exception occurred.");
		}

		try {
			StringCombinations.generateCombinations("ABC", -1, 3, StringCombinationsTest::processCombination);
		} catch (IllegalArgumentException ex) {
			assertEquals("The minimum length cannot be negative.", ex.getMessage());
		} catch (Exception ex) {
			fail("An unexpected exception occurred.");
		}	
	}

	@Test
	public void testEx003() {
		try {
			StringCombinations.generateCombinations("ABC", 2, 1, StringCombinationsTest::processCombination);
		} catch (IllegalArgumentException ex) {
			assertTrue(true);
			assertEquals("Maximum length must be greater than minimum.", ex.getMessage());
		} catch (Exception ex) {
			fail("An unexpected exception occurred.");
		}
	}

	@Test
	public void testEx004() {
		try {
			StringCombinations.generateCombinations("ABC", 1, 3, null);
		} catch (IllegalArgumentException ex) {
			assertTrue(true);
			assertEquals("Processor function must not be null.", ex.getMessage());
		} catch (Exception ex) {
			fail("An unexpected exception occurred.");
		}
	}

	// Execute external method
	public static boolean processCombination(String combination) {
		return true;
	}

}
