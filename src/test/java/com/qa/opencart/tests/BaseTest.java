package com.qa.opencart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opecart.pages.AccountsPage;
import com.qa.opecart.pages.LoginPage;
import com.qa.opecart.pages.ProductInfoPage;
import com.qa.opecart.pages.RegisterPage;
import com.qa.opecart.pages.ResultsPage;
import com.qa.opencart.factory.DriverFactory;

public class BaseTest {

	WebDriver driver;
	DriverFactory df;
	LoginPage loginPage;
	AccountsPage accPage;
	Properties prop;
	RegisterPage regPage;
	ResultsPage resultsPage;
	ProductInfoPage prodInfoPage;

	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		loginPage = new LoginPage(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
