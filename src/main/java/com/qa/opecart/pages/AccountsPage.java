package com.qa.opecart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// private By header = By.linkText("Your Store");
	private By header = By.cssSelector("div#logo a");
	private By sections = By.cssSelector("div#content h2");
	private By logoutLink = By.linkText("Logout");
	private By search = By.name("search");
	//private By searchIcon = By.className("btn btn-default btn-lg");
	// org.openqa.selenium.InvalidSelectorException: Compound class names not permitted
	
	private By searchIcon = By.cssSelector("div#search button");

	public AccountsPage(WebDriver driver) {

		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getAccountsPageTitle() {

		return eleUtil.doGetPageTitleContains(Constants.ACCOUNTS_PAGE_TITTLE, Constants.DEFAULT_TIME_OUT);
		// waitForPageTitle(Constants.ACCOUNTS_PAGE_TITTLE, Constants.DEFAULT_TIME_OUT);
	}

	public String getAccountsPageUrl() {
		return eleUtil.waitForUrlContains(Constants.ACCOUNTS_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);
	}

	public String getAccPageHeader() {
		return eleUtil.doGetText(header);
	}

	public boolean isLogoutLinkExist() {
		return eleUtil.doIsDisplayed(logoutLink);
	}

	public boolean logout() {
		if (isLogoutLinkExist()) {
			eleUtil.doClick(logoutLink);
			return true;
		}
		return false;
	}

	public List<String> getAccPageSections() {

		//List<WebElement> sectionsList = eleUtil.getElements(sections);
		List<WebElement> sectionsList = eleUtil.waitForElementsVisible(sections, Constants.DEFAULT_TIME_OUT);
		
		List<String> sectionsListName = new ArrayList<String>();
		for (WebElement e : sectionsList) {
			System.out.println(e.getText());
			sectionsListName.add(e.getText());
		}
		return sectionsListName;
	}
	
	public boolean searchExist() {
		return eleUtil.doIsDisplayed(search);
	}
	
	public ResultsPage doSearch(String searchText) {
		if(searchExist()) {
			eleUtil.doSendKeys(search, searchText);
			eleUtil.doClick(searchIcon);
		}
		return new ResultsPage(driver);
	}
}
