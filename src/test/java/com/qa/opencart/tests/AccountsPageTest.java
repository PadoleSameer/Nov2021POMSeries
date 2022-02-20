package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.util.Constants;

public class AccountsPageTest extends BaseTest {

	@BeforeTest
	public void accPageSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void accPageTitleTest() {
		String actTitle = accPage.getAccountsPageTitle();
		System.out.println("Acc Page title : " + actTitle);
		Assert.assertEquals(actTitle, Constants.ACCOUNTS_PAGE_TITTLE);
	}

	@Test
	public void accPageUrlTest() {
		String actUrl = accPage.getAccountsPageUrl();
		System.out.println("Acc Page title : " + actUrl);
		Assert.assertTrue(actUrl.contains(Constants.ACCOUNTS_PAGE_URL_FRACTION));
	}

	@Test
	public void accPageHeaderTest() {

		String header = accPage.getAccPageHeader();
		System.out.println("Acc page header :" + header);
		Assert.assertEquals(header, Constants.ACCOUNTS_PAGE_HEADER);
	}

	@Test
	public void logoutLinkExistTest() {
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}

	@Test
	public void searchExistTest() {
		Assert.assertTrue(accPage.searchExist());
	}

	@Test
	public void accPageSectionsTest() {

		List<String> sectionsList = accPage.getAccPageSections();
		System.out.println("actual sec list:" + sectionsList);

//		int i=0;
//		for (String str : sectionsList) {
//			Assert.assertEquals(str, Constants.ACCOUNTS_PAGE_SECTIONS_LIST.get(i));
//			i++;
//		}
		Assert.assertEquals(sectionsList, Constants.ACCOUNTS_PAGE_SECTIONS_LIST);
	}

	@DataProvider
	public Object[] getSearchData() {
//		return new Object[][] {
//				{"MacBook" },
//				{"iPhone"},
//				{"iPad"}
//		};

		return new Object[] { "MacBook", "iPhone", "Apple" };

	}

	@Test(dataProvider = "getSearchData")
	public void searchTest(String productName) {
		resultsPage = accPage.doSearch(productName);
		Assert.assertTrue(resultsPage.getProductsListCount() > 0);
	}

	@DataProvider
	public Object[][] productSelectData() {
		return new Object[][] { { "MacBook", "MacBook Pro" },
								{ "iPhone", "iPhone" },
								{ "Apple", "Apple Cinema 30\"" }
							};
	}

	@Test(dataProvider = "productSelectData")
	public void selectProductTest(String searchText, String mainProductName) {
		resultsPage = accPage.doSearch(searchText);
		prodInfoPage = resultsPage.selectProduct(mainProductName);
		Assert.assertEquals(prodInfoPage.getProductHeaderName(), mainProductName);
	}

}