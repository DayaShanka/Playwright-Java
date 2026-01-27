package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

	Page page;

	private String emailField = "//input[@id='input-email']";
	private String passwordField = "//input[@id='input-password']";
	private String loginButton = "//input[@value='Login']";
	private String logoutButton = "//a[@class='list-group-item'][normalize-space()='Logout']";

	public LoginPage(Page page) {
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

	public void enterEmailId(String emailid) {
		page.fill(emailField, emailid);

	}

	public void enterPassword(String password) {
		page.fill(passwordField, password);

	}

	public void clickOnLogin() {
		page.click(loginButton);

	}

	public boolean isLogoutButtonVisible() {
		return page.isVisible(logoutButton);

	}
}
