package com.qa.opecart.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtil;

public class ResultsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//Private By Locators
	By searchHeader = By.xpath("//div[@id='content']/h1");
	By productsResults = By.cssSelector("div.caption a");
	
	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public int getProductsListCount() {

		List<WebElement> productList = eleUtil.waitForElementsVisible(productsResults,Constants.DEFAULT_TIME_OUT);
		System.out.println("Total no of products available matching the search are "+productList.size());
		return productList.size();
	}
	
	public ProductInfoPage selectProduct(String productName) {
		System.out.println("Main product name : "+productName);
		List<WebElement> productList = eleUtil.waitForElementsVisible(productsResults,Constants.DEFAULT_TIME_OUT);

		//boolean flag = false;
		
		for (WebElement e : productList) {
			String productTxt = e.getText();
			if(productTxt.equals(productName)) {
				e.click();
				break;
			}
		}
		return new ProductInfoPage(driver);
	}
}
