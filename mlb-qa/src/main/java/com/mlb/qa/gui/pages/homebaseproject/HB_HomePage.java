package com.mlb.qa.gui.pages.homebaseproject;

import org.junit.Assert;
import com.thoughtworks.selenium.DefaultSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.thoughtworks.selenium.*;
import com.qaprosoft.carina.core.foundation.*;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.*;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.regex.Pattern;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class HB_HomePage extends AbstractPage {
	public HB_HomePage(WebDriver driver) {
		super(driver);
		setPageAbsoluteURL("https://qahomebase.mlbcontrol.net/");
		open();
	}
	

	private static final String SHOW_HISTORY_LABEL = "Show History";
	private static final String HIDE_HISTORY_LABEL = "Hide History";
	private static String newArticlePageSource;
	private static String articleInternalNameUniqueID;
	private static String newMediaWallPageSource;
	private static String mediaWallInternalNameUniqueID;
	private static String newDigitalAssetPageSource;
	private static String digitalAssetInternalNameUniqueID;

/*	public void selenium(){
		
	}
*/	
	//	private ExtendedWebElement waitPeriod;
	
	//************ LOGIN OBJECTS ************//	

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

	//************ LOGIN OBJECTS ************//	

	//************ HISTORY PANEL OBJECTS ************//	

	@FindBy(id="history-panel-icon-search")
	public ExtendedWebElement btnShowHideHistory;
	@FindBy(xpath="//span[contains(text(), 'Recent Items')]")
	public ExtendedWebElement btnRecentItems;
	@FindBy(xpath="//span[contains(text(), 'Activity Monitor')]")
	public ExtendedWebElement btnActivityMonitor;

	//************ HISTORY PANEL OBJECTS ************//	

	//************ SEARCH OBJECTS ************//	
	
	@FindBy(id="searchHeaderText")
	public ExtendedWebElement txtSearch;
	@FindBy(id="searchBtn")
	public ExtendedWebElement btnSearch;
	@FindBy(id="search-result-content-panel")
	public ExtendedWebElement panelSearch;

	//************ SEARCH OBJECTS ************//	
	
	//************ ITEM CREATION OBJECTS ************//	

	@FindBy(id="new-types-list")
	public ExtendedWebElement dropDownListNewItem;
	@FindBy(id="new-types-list")
	public ExtendedWebElement dropDownListItemSelection;
	@FindBy(id="newTypesButton")
	public ExtendedWebElement btnNewItem;

	//************ ITEM CREATION OBJECTS ************//	
	
	//************ ARTICLE CREATION OBJECTS ************//	

	@FindBy(name="@name")
	public ExtendedWebElement articleRequiredFieldInternalName;

	@FindBy(name="headline")
	public ExtendedWebElement articleRequiredFieldHeadline;

	@FindBy(name="subhead")
	public ExtendedWebElement articleRequiredFieldSubhead;

//	@FindBy(id="05257329-1BA8-44F9-849B-F5E0CA2FEF45")
//	public ExtendedWebElement articleRequiredFieldA;

	@FindBy(xpath="//button[contains(text(), 'Tag Tool')]")
	public ExtendedWebElement articleRequiredClickTagTool;

	@FindBy(id="compactLayout")
	public ExtendedWebElement articleAdvancedFieldsCheckbox;

	@FindBy(id="tagging-autocompletePlayer")
	public ExtendedWebElement articleRequiredClickC;

	@FindBy(xpath="//input[@class='autocomplete-maininput processedYes']")
	public ExtendedWebElement articleRequiredPlayerTagInputField;	

	@FindBy(xpath="(//button[@type='button'])[2]")
	public ExtendedWebElement articleRequiredApplyTagsAndClose;

	@FindBy(id="taggingTagSelectLeagueMiLB")
	public ExtendedWebElement articleRequiredClickE;

	@FindBy(id="taggingKeywordTaxED")
	public ExtendedWebElement articleRequiredClickF;

	@FindBy(id="70E551FF-F54B-42FF-93E2-2B5F05F7BB87")
	public ExtendedWebElement articleRequiredFieldG;

	@FindBy(id="item-panel-save")
	public ExtendedWebElement articleBtnSave;

	@FindBy(xpath="//button[contains(text(), 'Tag Tool')]")
	public ExtendedWebElement articleRequiredClickH;

	@FindBy(id="item-panel-publish-beta")
	public ExtendedWebElement articleBtnToBeta;

	@FindBy(linkText="View Beta Article")
	public ExtendedWebElement linkViewBetaArticle;

	//************ ARTICLE CREATION OBJECTS ************//	

	//************ MEDIAWALL CREATION OBJECTS ************//	

	@FindBy(xpath="//for[label@title='Internal Name']")
	public ExtendedWebElement mediaWallRequiredFieldA;
//	@FindBy(id="05257329-1BA8-44F9-849B-F5E0CA2FEF45")
//	public ExtendedWebElement mediaWallRequiredFieldA;
	@FindBy(id="autocomplete-maininput processedYes")
	public ExtendedWebElement mediaWallRequiredClickB;
	@FindBy(id="autocomplete-maininput processedYes")
	public ExtendedWebElement mediaWallRequiredClickC;
	@FindBy(xpath="(//button[@type='button'])[2]")
	public ExtendedWebElement mediaWallRequiredClickD;
	@FindBy(id="taggingTagSelectLeagueMiLB")
	public ExtendedWebElement mediaWallRequiredClickE;
	@FindBy(id="taggingKeywordTaxED")
	public ExtendedWebElement mediaWallRequiredClickF;
	@FindBy(id="70E551FF-F54B-42FF-93E2-2B5F05F7BB87")
	public ExtendedWebElement mediaWallRequiredFieldG;
	@FindBy(id="item-panel-save")
	public ExtendedWebElement mediaWallBtnSave;
	@FindBy(id="3BA6CEBA-2B9C-4110-AA64-51719F353EF6")
	public ExtendedWebElement mediaWallRequiredClickH;
	@FindBy(id="item-panel-publish-beta")
	public ExtendedWebElement mediaWallBtnToBeta;
	@FindBy(linkText="View Beta Article")
	public ExtendedWebElement linkViewBetaMediaWall;

	//************ ARTICLE CREATION OBJECTS ************//	

	//************ DIGITAL ASSET CREATION OBJECTS ************//	

	@FindBy(xpath="//for[label@title='Internal Name']")
	public ExtendedWebElement digitalAssetRequiredFieldA;
//	@FindBy(id="05257329-1BA8-44F9-849B-F5E0CA2FEF45")
//	public ExtendedWebElement digitalAssetRequiredFieldA;
	@FindBy(id="F56F2E2F-E00A-46D9-AF01-1404017D46D0")
	public ExtendedWebElement digitalAssetRequiredClickB;
	@FindBy(id="tagauto-7B479973-46DB-47E6-A4C2-25A74DE0C687-input")
	public ExtendedWebElement digitalAssetRequiredClickC;
	@FindBy(xpath="(//button[@type='button'])[2]")
	public ExtendedWebElement digitalAssetRequiredClickD;
	@FindBy(id="taggingTagSelectLeagueMiLB")
	public ExtendedWebElement digitalAssetRequiredClickE;
	@FindBy(id="taggingKeywordTaxED")
	public ExtendedWebElement digitalAssetRequiredClickF;
	@FindBy(id="70E551FF-F54B-42FF-93E2-2B5F05F7BB87")
	public ExtendedWebElement digitalAssetRequiredFieldG;
	@FindBy(id="item-panel-save")
	public ExtendedWebElement digitalAssetBtnSave;
	@FindBy(id="3BA6CEBA-2B9C-4110-AA64-51719F353EF6")
	public ExtendedWebElement digitalAssetRequiredClickH;
	@FindBy(id="item-panel-publish-beta")
	public ExtendedWebElement digitalAssetBtnToBeta;
	@FindBy(linkText="View Beta Article")
	public ExtendedWebElement linkViewBetaDigitalAsset;

	//************ ARTICLE CREATION OBJECTS ************//	
	
	public void login(String username, String password, String profile) {
		type(txtUsername, username);
		type(txtUserPassword, password);
		click(btnSubmit);
		select(selProfile, profile);
//		Assert.assertTrue("Search results not found! Login operation is not successful!", isElementPresent(headerLabel, 60));

		click(btnSubmitProfile);
		Assert.assertTrue("Profile label was not found! Login operation is not successful!", isElementPresent(headerLabel, 60));
		Assert.assertEquals("Profile name is not match!", profile, headerLabel.getText().toLowerCase());
	}

	public void basicSearch(String searchCriteria) {
		type(txtSearch, searchCriteria);
		click(btnSearch);

//		Assert.assertEquals("Profile name is not match!", profile, headerLabel.getText().toLowerCase());
	}

	public void selectNewItem(String itemSelection)	{
//		click(dropDownListNewItem);
		select(dropDownListItemSelection, itemSelection);
		click(btnNewItem);
	}
	
	public void fillAndSaveNewArticle(String articleReqFieldInternalName, String articleReqFieldG, String articleReqFieldHeadline, String articleReqFieldSubhead)	{
		newArticlePageSource = driver.getPageSource();
		type(articleRequiredFieldInternalName, articleReqFieldInternalName);
//		click(articleRequiredClickTagTool);
//		click(articleAdvancedFieldsCheckbox);
//		pressTab();
//		pressTab();
//		pressTab();
//		pressTab();
//		pressTab();
//		sendKeys("Heller");
//		pressTab();
//		click(articleRequiredPlayerTagInputField);
//		type(articleRequiredClickC,"x488");
//		click(articleRequiredApplyTagsAndClose);
//		click(articleRequiredClickE);
//		click(articleRequiredClickF);
//		type(articleRequiredFieldG, articleReqFieldG);
//		type(articleRequiredFieldHeadline, articleReqFieldHeadline);
		click(articleRequiredFieldHeadline);
		sendKeys("Snehal Test Hello");
//		DefaultSelenium selenium = new DefaultSelenium("localhost",4444,"*firefox","https://qahomebase.mlbcontrol.net");
		Selenium selenium = new WebDriverBackedSelenium(driver, "https://qahomebase.mlbcontrol.net/");
		selenium.typeKeys("Something", "Something");
//		selenium.keyPress("Snehal Test Hello", "Snehal Test Hello");
		pressTab();
		sendKeys("Subhead ");
		pressTab();
		//		type(articleRequiredFieldHeadline, articleReqFieldHeadline);
		type(articleRequiredFieldSubhead, articleReqFieldSubhead);
		click(articleBtnSave);
//		click(articleRequiredClickH);
		click(articleBtnToBeta);
		isElementPresent(linkViewBetaArticle, 15);
		click(linkViewBetaArticle);

	}

	public void fillAndSaveNewMediaWall(String mediaWallReqFieldA, String mediaWallReqFieldG)	{
		newMediaWallPageSource = driver.getPageSource();
		type(mediaWallRequiredFieldA, mediaWallReqFieldA);
		click(mediaWallRequiredClickB);
		click(mediaWallRequiredClickC);
		click(mediaWallRequiredClickD);
		click(mediaWallRequiredClickE);
		click(mediaWallRequiredClickF);
		type(mediaWallRequiredFieldG, mediaWallReqFieldG);
		click(mediaWallBtnSave);
		click(mediaWallRequiredClickH);
		click(mediaWallBtnToBeta);
		click(linkViewBetaMediaWall);
	}
	
	public void fillAndSaveNewDigitalAsset(String digitalAssetReqFieldA, String digitalAssetReqFieldG)	{
		newDigitalAssetPageSource = driver.getPageSource();
		type(digitalAssetRequiredFieldA, digitalAssetReqFieldA);
		click(digitalAssetRequiredClickB);
		click(digitalAssetRequiredClickC);
		click(digitalAssetRequiredClickD);
		click(digitalAssetRequiredClickE);
		click(digitalAssetRequiredClickF);
		type(digitalAssetRequiredFieldG, digitalAssetReqFieldG);
		click(digitalAssetBtnSave);
		click(digitalAssetRequiredClickH);
		click(digitalAssetBtnToBeta);
		click(linkViewBetaDigitalAsset);
	}
}
