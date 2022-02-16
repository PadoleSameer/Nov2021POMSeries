package com.qa.opencart.tests;

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

}
