package com.qa.opecart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtil;

public class RegisterPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//Private by Locators
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By emailId = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By cnfPassword = By.id("input-confirm");
	
	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[position()=1]//input[@type='radio']");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[position()=2]//input[@type='radio']");
	
	//private By agreeCheckBox = By.xpath("//input[@name='agree']");
	private By agreeCheckBox = By.name("agree");
	private By contineButton = By.xpath("//input[@value='Continue' and@type='submit']");
	
	private By sucessMesg = By.xpath("//div[@id='content']/h1");
	
	private By logoutLink = By.linkText("Logout");
	private By registerLink	= By.linkText("Register");
	
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);	
	}
	
	public boolean accountRegistration(String firstName, String lastName, String emailId,String telephone,String password, String subscribe) {
		
		eleUtil.doSendKeys(this.firstName,firstName);
		eleUtil.doSendKeys(this.lastName,lastName);
		eleUtil.doSendKeys(this.emailId,emailId);
		eleUtil.doSendKeys(this.telephone,telephone);
		eleUtil.doSendKeys(this.password,password);
		eleUtil.doSendKeys(cnfPassword, password);
				
		if(subscribe.equalsIgnoreCase("Yes")) {
			eleUtil.doClick(subscribeYes);
		}
		else 
		{
			eleUtil.doClick(subscribeNo);
		}
		
		eleUtil.doClick(agreeCheckBox);
		eleUtil.doClick(contineButton);
		
		String successMsg = eleUtil.doGetText(sucessMesg);
		System.out.println(successMsg);
		
		if(successMsg.contains(Constants.REGISTER_SUCCESS_MESSAGE)) {
			eleUtil.doActionsClick(logoutLink);
			eleUtil.doClick(registerLink);
			return true;
		}
		return false;
		
	}
	
	

}
