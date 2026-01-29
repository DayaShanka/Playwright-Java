package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constant.AppConstants;
import com.qa.opencart.listeners.ExtentLogger;

public class HomePageTest extends BaseTest {

	@Test(priority = 1)
	public void verifyHomePageTitle() {

		String actualTitle = homePage.getTitle();
		Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
		ExtentLogger.pass("Title of the homePage:- " + actualTitle);

	}

	@Test(priority = 2)
	public void verifyHomePageURL() {

		String actualURL = homePage.getURL();
		Assert.assertEquals(actualURL, AppConstants.HOME_PAGE_URL);

	}

	@DataProvider
	public Object[][] getProductData() {

		Object[][] arr = { { "Macbook" }, { "iMac" }, { "Samsung" } };
		return arr;

	}

	@Test(priority = 3, dataProvider = "getProductData")
	public void verifySearchField(String productName) {
		// String searchingText = prop.getProperty("searchValue");
		String actualHeaderText = homePage.doSearch(productName);
		System.out.println("Searching:- " + actualHeaderText);

		Assert.assertTrue(actualHeaderText.contains(productName),
				"Search result header does not contain searched value. Actual: " + actualHeaderText);
	}

}
