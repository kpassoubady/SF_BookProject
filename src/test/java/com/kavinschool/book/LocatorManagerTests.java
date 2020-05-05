package com.kavinschool.book;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.mockito.Mockito.*;


public class LocatorManagerTests {

	@Test
	public void testCanGetACorrectLocatorCode() {
		
		ExternalIsbnDataService testWebService = new ExternalIsbnDataService() {
			@Override
			public Book lookup(String isbn) {
				return new Book(isbn, "Refactoring to Patterns", "Joshua Kerievsky");
			}
		};
		
		ExternalIsbnDataService testDatabaseService = new ExternalIsbnDataService() {
			@Override
			public Book lookup(String isbn) {
				return null;
			}
		};
		

		LocatorManager locatorManager = new LocatorManager();
		locatorManager.setApiService(testWebService);
		locatorManager.setDbService(testDatabaseService);
		
		String isbn = "0140188856";
		String locatorCode = locatorManager.getLocatorCode(isbn);
		assertEquals("8856J3", locatorCode);
	}
	
	@Test
	public void databaseIsUsedIfDataIsPresent() {
		ExternalIsbnDataService databaseService = mock(ExternalIsbnDataService.class);
		ExternalIsbnDataService webService = mock(ExternalIsbnDataService.class);
		
		when(databaseService.lookup("0140188856")).thenReturn(new Book("0140188856","Kangs","Kangs P"));
		
		LocatorManager locatorManager = new LocatorManager();
		locatorManager.setApiService(webService);
		locatorManager.setDbService(databaseService);
		
		String isbn = "0140188856";
		locatorManager.getLocatorCode(isbn);
		
		verify(databaseService).lookup("0140188856");
		verify(webService, never()).lookup(anyString());
		
	}
	
	@Test
	public void webserviceIsUsedIfDataIsNotPresentInDatabase() {
		ExternalIsbnDataService databaseService = mock(ExternalIsbnDataService.class);
		ExternalIsbnDataService webService = mock(ExternalIsbnDataService.class);
		
		when(databaseService.lookup("0140188856")).thenReturn(null);
		when(webService.lookup("0140188856")).thenReturn(new Book("0140188856","Kangs","Kangs P"));
		
		LocatorManager locatorManager = new LocatorManager();
		locatorManager.setApiService(webService);
		locatorManager.setDbService(databaseService);
		
		String isbn = "0140188856";
		locatorManager.getLocatorCode(isbn);
		
		verify(databaseService).lookup("0140188856");
		verify(webService).lookup("0140188856");
	}
	
}
