package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.util.Constants;

public class ProductInfoTest extends BaseTest {

	@BeforeClass
	public void productInfoSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void productHeaderTest() {

		resultsPage = accPage.doSearch("MacBook");
		prodInfoPage = resultsPage.selectProduct("MacBook Pro");
		String actualHeader = prodInfoPage.getProductHeaderName();
		Assert.assertEquals(actualHeader, "MacBook Pro");
	}

	@DataProvider
	public Object[][] getProductList() {

		return new Object[][] { { "MacBook", "MacBook Pro", Constants.MACBOOK_IMAGES_COUNT},
								{ "iPhone", "iPhone", Constants.IPHONE_IMAGES_COUNT },
								{ "Apple", "Apple Cinema 30\"", Constants.APPLECINEMA_IMAGES_COUNT } };
	}

	@Test( dataProvider = "getProductList")
	public void productImagesCountTest(String searchText, String actualProductname, int count) {

		resultsPage = accPage.doSearch(searchText);
		prodInfoPage = resultsPage.selectProduct(actualProductname);
		int imageCount = prodInfoPage.getProductImgCount();
		System.out.println("total images for :" + actualProductname + ":" + imageCount);
		Assert.assertEquals(imageCount, count);
	}
	//Hash Map - No order
//	Brand: Apple
//	Availability: Out Of Stock
//	ExTaxPrice:Ex Tax: $2,000.00
//	Price:$2,000.00
//	total Images:4
//	Product Code: Product 18
//	Reward Points: 800
//	Name:MacBook Pro

	//Linked Hash map - shows in order in order it was inserted 
//	Name:MacBook Pro
//	total Images:4
//	Brand:Apple
//	Product Code:Product 18
//	Reward Points:800
//	Availability:Out Of Stock
//	Price:$2,000.00
//	ExTaxPrice:Ex Tax: $2,000.00
	
	//TreeMap - alphabetical
//	Availability:Out Of Stock
//	Brand:Apple
//	ExTaxPrice:Ex Tax: $2,000.00
//	Name:MacBook Pro
//	Price:$2,000.00
//	Product Code:Product 18
//	Reward Points:800
//	total Images:4
	
	@Test
	public void productDataTest() {
		
		resultsPage = accPage.doSearch("MacBook");
		prodInfoPage = resultsPage.selectProduct("MacBook Pro");
		Map<String, String> actProductInfo = prodInfoPage.getProductInfo();
		actProductInfo.forEach((k,v) -> System.out.println(k+":"+v));
		softAssert.assertEquals(actProductInfo.get("Brand"), "Apple");
		softAssert.assertEquals(actProductInfo.get("Name"), "MacBook Pro");
		softAssert.assertEquals(actProductInfo.get("Product Code"), "Product 18");
		softAssert.assertEquals(actProductInfo.get("Price"), "$2,000.00");
		softAssert.assertAll();
	}

}
