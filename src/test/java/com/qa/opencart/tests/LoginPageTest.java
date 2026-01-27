package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constant.AppConstants;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void navigateLoginTest() {
		loginPage = homePage.navigateToLoginPage();

	}

	@Test(priority = 2)
	public void verifyLoginPageTitle() {

		String actualTitle = loginPage.getTitle();
		Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE);

	}

	@Test(priority = 3)
	public void verifyLoginPageURL() {

		String actualURL = loginPage.getURL();
		Assert.assertEquals(actualURL, AppConstants.LOGIN_PAGE_URL);

	}

	@Test(priority = 4)
	public void doLogin() {
		loginPage.enterEmailId(prop.getProperty("email"));
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.clickOnLogin();

		if (loginPage.isLogoutButtonVisible() == true) {

			System.out.println("Login successful.");
		} else {
			System.out.println("Login failed");
		}

	}

}
