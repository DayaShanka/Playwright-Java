package com.qa.opencart.base;

import java.util.Properties;

import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {

	PlaywrightFactory pf;
	Page page;
	protected HomePage homePage;
	protected LoginPage loginPage;
	protected Properties prop;

	@BeforeTest
	public void setUP() {
		pf = new PlaywrightFactory();
		prop = pf.init_properties();
		page = pf.initBrowser(prop);
		homePage = new HomePage(page);
		loginPage = new LoginPage(page);
	}

}
