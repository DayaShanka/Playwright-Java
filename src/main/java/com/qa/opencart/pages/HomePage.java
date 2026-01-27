package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {

	Page page;

	private String searchField = "//input[@placeholder='Search']";
	private String searchButton = "//button[@class='btn btn-default btn-lg']";
	private String searchedHeader = "div[id='content'] h1";
	private String myAccountLink = "//a[@title='My Account']";
	private String loginLink = "//a[normalize-space()='Login']";

	public HomePage(Page page) {

		this.page = page;

	}

	public String getTitle() {

		String title = page.title();
		System.out.println("Title of the page: " + title);
		return title;
	}

	public String getURL() {

		String url = page.url();
		System.out.println("URL of the page: " + url);
		return url;
	}

	public String doSearch(String searchValue) {

		page.fill(searchField, searchValue);
		page.click(searchButton);
		String actualString = page.locator(searchedHeader).textContent();
		return actualString;

	}

	public LoginPage navigateToLoginPage() {
		page.click(myAccountLink);
		page.click(loginLink);
		return new LoginPage(page);

	}

}
