package com.mlb.qa.demo;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class HomebaseHomePage extends AbstractPage {
	private static final String SHOW_HISTORY_LABEL = "Show History";
	private static final String HIDE_HISTORY_LABEL = "Hide History";

	@FindBy(id="userName")
	public ExtendedWebElement txtUsername;
	@FindBy(id="userPassword")
	public ExtendedWebElement txtUserPassword;
	@FindBy(id="submit")
	public ExtendedWebElement btnSubmit;
	@FindBy(id="userAppId")
	public ExtendedWebElement selProfile;
	@FindBy(id="submit")
	public ExtendedWebElement btnSubmitProfile;
	@FindBy(xpath="//*[@id='header-info-top']/div")
	public ExtendedWebElement headerLabel;
	@FindBy(id="history-panel-icon-search")
	public ExtendedWebElement btnShowHideHistory;
	@FindBy(xpath="//span[contains(text(), 'Recent Items')]")
	public ExtendedWebElement btnRecentItems;
	@FindBy(xpath="//span[contains(text(), 'Activity Monitor')]")
	public ExtendedWebElement btnActivityMonitor;
	@FindBy(id="searchHeaderText")
	public ExtendedWebElement txtSearch;
	@FindBy(id="searchBtn")
	public ExtendedWebElement btnSearch;
	@FindBy(id="search-result-content-panel")
	public ExtendedWebElement panelSearch;
	
	public HomebaseHomePage(WebDriver driver) {
		super(driver);
		setPageAbsoluteURL("https://qahomebase.mlbcontrol.net/");
		open();
	}
	
	public void login(String username, String password, String profile) {
		type(txtUsername, username);
		type(txtUserPassword, password);
		click(btnSubmit);
		
		select(selProfile, profile);
		click(btnSubmitProfile);
		Assert.assertTrue("Profile label was not found! Login operation is not successful!", isElementPresent(headerLabel, 60));
		Assert.assertEquals("Profile name is not match!", profile, headerLabel.getText().toLowerCase());
	}
	
	public void showHistory() {
		if(btnShowHideHistory.getText().equals(SHOW_HISTORY_LABEL)){
			click(btnShowHideHistory);	
		} else {
			Assert.fail("Button " + btnShowHideHistory + " is already clicked or does not exist on the page!");
		}
		Assert.assertTrue("Button 'Recent Items' not found!", isElementPresent(btnRecentItems));
		Assert.assertTrue("Button 'Activity Monitor' not found!", isElementPresent(btnActivityMonitor));
	}
	
	public void hideHistory() {
		if(btnShowHideHistory.getText().equals(HIDE_HISTORY_LABEL)){
			click(btnShowHideHistory);	
		} else {
			Assert.fail("Button " + btnShowHideHistory + " is already clicked or does not exist on the page!");
		}
		Assert.assertTrue("Button 'Recent Items' is found!", isElementNotPresent(btnRecentItems));
		Assert.assertTrue("Button 'Activity Monitor' is found!", isElementNotPresent(btnActivityMonitor));
	}

	public void search(String searchText){
		type(txtSearch, searchText);
		click(btnSearch);
		Assert.assertTrue("'Search' panel is not found", isElementPresent(panelSearch));
	}
	
}
