package com.kavinschool.book;

import static org.junit.Assert.*;

import org.junit.Test;

public class IsbnTest {

	@Test
	public void checkAValid10DigitIsbn() {
		Isbn validator = new Isbn();
		boolean result = validator.isIsbn("0140449116");
		assertTrue("first value", result);
		result = validator.isIsbn("0140177396");
		assertTrue("second value", result);
	}
	
	@Test 
	public void checkAValid13DigitIsbn() {
		Isbn validator = new Isbn();
		boolean result = validator.isIsbn("9781853260087");
		assertTrue("first value", result);
		result = validator.isIsbn("9781853267338");
		assertTrue("second value", result);
	}
	
	@Test
	public void TenDigitIsbnNumbersEndingInAnXAreValid() {
		Isbn validator = new Isbn();
		boolean result = validator.isIsbn("012000030X");
		assertTrue(result);
	}
	
	@Test
	public void checkAnInvalid10DigitIsbn() {
		Isbn validator = new Isbn();
		boolean result = validator.isIsbn("0140449117");
		assertFalse(result);
	}
	
	@Test
	public void checkAnInvalid13DigitIsbn() {
		Isbn validator = new Isbn();
		boolean result = validator.isIsbn("9781853267336");
		assertFalse(result);
	}
	
	@Test(expected = NumberFormatException.class)
	public void nineDigitIsbnsAreNotAllowed() {
		Isbn validator = new Isbn();
		validator.isIsbn("123456789");
	}
	
	@Test(expected = NumberFormatException.class)
	public void nonNumericIsbnsAreNotAllowed() {
		Isbn validator = new Isbn();
		validator.isIsbn("ThisIsKangs");
	}

}
