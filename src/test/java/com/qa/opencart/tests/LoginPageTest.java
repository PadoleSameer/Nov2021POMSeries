package com.qa.opencart.tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.qa.opencart.util.Constants;

public class LoginPageTest extends BaseTest{

	@Test(priority = 1)
	public void loginPageTitleTest() {
		
		String pageTitle = loginPage.getLoginPageTitle();
		System.out.println("Login page title :"+pageTitle);
		Assert.assertEquals(pageTitle, Constants.LOGIN_PAGE_TITTLE);			
	}
	
	@Test(priority = 2)
	public void loginPageUrlTest() {
		
		String url = loginPage.getLoginPageUrl();
		System.out.println("Login page URL  : "+url);
		//Assert.assertEquals(url, "https://demo.opencart.com/index.php?route=account/login");			
		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_URL_FRACTION));
	}
	
	@Test(priority = 3)
	public void verifyForgotPwdLinkTest(){
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Test (priority = 4)
	public void loginTest() {
		accPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
}