package com.kavinschool.book;

import static org.junit.Assert.*;

import org.junit.Test;

public class IsbnTest {

	@Test
	public void checkAValid10DigitISBN() {
		Isbn validator = new Isbn();
		boolean result = validator.checkISBN("0140449116");
		assertTrue("first value", result);
		result = validator.checkISBN("0140177396");
		assertTrue("second value", result);
	}
	
	@Test 
	public void checkAValid13DigitISBN() {
		Isbn validator = new Isbn();
		boolean result = validator.checkISBN("9781853260087");
		assertTrue("first value", result);
		result = validator.checkISBN("9781853267338");
		assertTrue("second value", result);
	}
	
	@Test
	public void TenDigitISBNNumbersEndingInAnXAreValid() {
		Isbn validator = new Isbn();
		boolean result = validator.checkISBN("012000030X");
		assertTrue(result);
	}
	
	@Test
	public void checkAnInvalid10DigitISBN() {
		Isbn validator = new Isbn();
		boolean result = validator.checkISBN("0140449117");
		assertFalse(result);
	}
	
	@Test
	public void checkAnInvalid13DigitISBN() {
		Isbn validator = new Isbn();
		boolean result = validator.checkISBN("9781853267336");
		assertFalse(result);
	}
	
	@Test(expected = NumberFormatException.class)
	public void nineDigitISBNsAreNotAllowed() {
		Isbn validator = new Isbn();
		validator.checkISBN("123456789");
	}
	
	@Test(expected = NumberFormatException.class)
	public void nonNumericISBNsAreNotAllowed() {
		Isbn validator = new Isbn();
		validator.checkISBN("ThisIsKangs");
	}

}
