package com.kavinschool.book;

public class LocatorManager {
	
	private ExternalIsbnDataService apiService;

	private ExternalIsbnDataService dbService;
	
	public void setApiService(ExternalIsbnDataService service) {
		this.apiService = service;
	}


	public void setDbService(ExternalIsbnDataService dbService) {
		this.dbService = dbService;
	}


	public String getLocatorCode(String isbn) {
		Book book = dbService.lookup(isbn);
		if (book == null) book = apiService.lookup(isbn);
		StringBuilder locator = new StringBuilder();
		locator.append(isbn.substring(isbn.length() - 4));
		locator.append(book.getAuthor().substring(0, 1));
		locator.append(book.getTitle().split(" ").length);
		return locator.toString();
	}

}
