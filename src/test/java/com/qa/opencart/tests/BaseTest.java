package com.qa.opencart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opecart.pages.AccountsPage;
import com.qa.opecart.pages.LoginPage;
import com.qa.opecart.pages.ProductInfoPage;
import com.qa.opecart.pages.RegisterPage;
import com.qa.opecart.pages.ResultsPage;
import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.factory.OptionsManager;

public class BaseTest {

	WebDriver driver;
	DriverFactory df;
	LoginPage loginPage;
	AccountsPage accPage;
	Properties prop;
	RegisterPage regPage;
	ResultsPage resultsPage;
	ProductInfoPage prodInfoPage;
	OptionsManager opsMgr;

	SoftAssert softAssert;
	
	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		prop = df.init_prop();
		opsMgr = new OptionsManager(prop);
		driver = df.init_driver(prop);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();
		
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
