package com.qa.opencart.tests;

import java.util.Random;

import org.apache.commons.lang.math.RandomUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ExcelUtil;

public class RegisterPageTest extends BaseTest{
	
	@BeforeClass
	public void regSetUp() {
		regPage = loginPage.goToRegisterPage();
	}
	
//	@DataProvider
//	public Object[][] loginTestData() {
//		return new Object[][] {
//				{ "admin@gmail.com", "admin123" }, 
//				{ "cust@gmail.com", "cust123" }, 
//				{ "vendor@gmail.com", "vendor123" },
//				{ "vendor@gmail.com", "@#@#@" },
//				{ "@#@#@#", "vendor123" },
//				{ " ", " " },
//				{ null, null }
//		};
//	}
//
//	@Test(dataProvider = "loginTestData")
//	public void loginTest(String userName, String password) {
//		Assert.assertTrue(doLogin(userName, password));
//	}

	public String getRandomEmail() {
		
		Random randomGen = new Random();
		String email = "textautomation"+randomGen.nextInt(1000)+"@gmail.com";			
		return email;
	}
	
	@DataProvider
	public Object [][] getRegistrationData() {
		Object regData[][] = ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return regData;
	}
	
	@Test(dataProvider = "getRegistrationData")
	public void accountRegistrationTest(String firstName, String lastName,
										String telephone,String password, String subscribe) {
		String email = getRandomEmail();
		//System.out.println("Email :"+email);
		
		Assert.assertTrue(regPage.accountRegistration(firstName, lastName,email ,telephone,password,subscribe));
		
	}
}
