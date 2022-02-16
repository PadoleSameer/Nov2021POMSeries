package com.qa.opecart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.util.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	
	private By productHeaderName = By.cssSelector("div#content h1");
	private By thumbNails = By.cssSelector("ul.thumbnails img");
	private By productMetaData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
	private By priceMetaData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li"); 
	private By quantity =By.id("product_id");
	private By addToCartBtn = By.id("button-cart");

	
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String getProductHeaderName() {
		return eleUtil.doGetText(productHeaderName);
	}
	
	public int getProductImgCount() {
		List<WebElement> images = eleUtil.waitForElementsVisible(thumbNails, 10);
		int imagesCount = images.size();
		return imagesCount;
	}
	
}
