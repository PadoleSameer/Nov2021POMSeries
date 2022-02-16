package com.qa.opecart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//1. private By locators
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	//private By loginBtn = By.cssSelector("input.btn.btn-primary");
	private By loginBtn = By.xpath("//input[@value='Login']");
	//private By forgotPwdLink = By.linkText("Forgotten Password");
	private By forgotPwdLink = By.xpath("//div[@class='form-group']//a");
	private By registerLink	= By.linkText("Register");
	
	
	
	//2. Page Constructor
	public LoginPage(WebDriver driver){
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	//3. public page actions/methods:
	public String getLoginPageTitle() {
		return eleUtil.doGetPageTitleIs(Constants.LOGIN_PAGE_TITTLE, Constants.DEFAULT_TIME_OUT);
	}
	
	public String getLoginPageUrl() {
		 return eleUtil.waitForUrlContains(Constants.LOGIN_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);
	}
	
	public boolean isForgotPwdLinkExist() {
		return eleUtil.doIsDisplayed(forgotPwdLink);
		//return eleUtil.waitForElementVisible(forgotPwdLink, Constants.DEFAULT_TIME_OUT).isDisplayed();
		//System.out.println(forgotPwdLink);
		//System.out.println(loginBtn);		
	}
	
	public AccountsPage doLogin(String userName, String passWord ) {
		
		eleUtil.doActionsSendKeys(emailId, userName);
		eleUtil.doSendKeys(password, passWord);
		eleUtil.doClick(loginBtn);
		return new AccountsPage(driver);
		
//		driver.findElement(emailId).sendKeys(userName);
//		driver.findElement(password).sendKeys(passWord);
//		driver.findElement(loginBtn).click();
	
	}
	
	public RegisterPage goToRegisterPage() {
		eleUtil.doClick(registerLink);
		return new RegisterPage(driver);
	}
	
}
