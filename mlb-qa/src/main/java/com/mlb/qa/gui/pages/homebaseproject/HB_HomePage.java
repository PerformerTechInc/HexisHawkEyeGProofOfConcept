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

import java.awt.event.KeyEvent;
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

	@FindBy(id="item-panel-save")
	public ExtendedWebElement BtnSave;

	@FindBy(id="item-panel-publish-beta")
	public ExtendedWebElement BtnToBeta;

	@FindBy(name="@name")
	public ExtendedWebElement FieldInternalName;

	@FindBy(name="headline")
	public ExtendedWebElement FieldHeadline;

	@FindBy(name="subhead")
	public ExtendedWebElement FieldSubhead;

	@FindBy(name="alt-headline")
	public ExtendedWebElement FieldAltHeadline;

	@FindBy(name="byline")
	public ExtendedWebElement FieldByline;

	@FindBy(name="summary")
	public ExtendedWebElement FieldSeoHeadline;

	@FindBy(name="source")
	public ExtendedWebElement FieldSource;

	@FindBy(name="poll")
	public ExtendedWebElement FieldPoll;

	@FindBy(name="displayName")
	public ExtendedWebElement FieldDisplayName;

	@FindBy(name="value")
	public ExtendedWebElement FieldValue;

	@FindBy(name="year")
	public ExtendedWebElement FieldYear;

	@FindBy(name="title")
	public ExtendedWebElement FieldTitle;

	@FindBy(name="spanish-title")
	public ExtendedWebElement FieldSpanishTitle;

	@FindBy(name="url-text")
	public ExtendedWebElement FieldURLText;

	@FindBy(name="url")
	public ExtendedWebElement FieldURL;

	@FindBy(name="mobile-url")
	public ExtendedWebElement FieldMobileURL;

	@FindBy(name="sponsor-url")
	public ExtendedWebElement FieldSponsorURL;

	@FindBy(name="display-time")
	public ExtendedWebElement FieldDisplayTimeInSeconds;

	@FindBy(name="video-alias")
	public ExtendedWebElement FieldVideoAlias;

	@FindBy(xpath="//button[contains(text(), 'Tag Tool')]")
	public ExtendedWebElement BtnTagTool;

	@FindBy(id="compactLayout")
	public ExtendedWebElement CheckboxTagToolAdvancedFields;

	@FindBy(xpath="//input[@class='autocomplete-maininput processedYes']")
	public ExtendedWebElement FieldTagToolPlayer;	

	@FindBy(id="taggingGameDayBrowse")
	public ExtendedWebElement BtnTagToolChangeDate;

	@FindBy(xpath="(//button[@type='button'])[2]")
	public ExtendedWebElement BtnApplyTagsAndClose;

	//************ ITEM CREATION OBJECTS ************//	
	
	//************ ARTICLE CREATION OBJECTS ************//	

	@FindBy(id="tagging-autocompletePlayer")
	public ExtendedWebElement articleRequiredClickC;

	@FindBy(linkText="View Beta Article")
	public ExtendedWebElement linkViewBetaArticle;

	//************ ARTICLE CREATION OBJECTS ************//	

	//************ DIGITAL ASSET CREATION OBJECTS ************//	

	//************ DIGITAL ASSET CREATION OBJECTS ************//	

	//************ FIELD OPTION CREATION OBJECTS ************//	

	//************ FIELD OPTION CREATION OBJECTS ************//	

	//************ HIGHLIGHT CREATION OBJECTS ************//	

	//************ HIGHLIGHT CREATION OBJECTS ************//	

	//************ HTML PAGE CREATION OBJECTS ************//	

	//************ HTML PAGE CREATION OBJECTS ************//	

	//************ LINK CREATION OBJECTS ************//	

	@FindBy(name="link-url")
	public ExtendedWebElement FieldLinkURL;

	//************ LINK CREATION OBJECTS ************//	

	//************ MEDIAWALL CREATION OBJECTS ************//	

	//************ MEDIAWALL CREATION OBJECTS ************//	

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
	
	public void fillAndSaveNewArticle(String mainURLCall, String articleReqFieldInternalName, String articleReqFieldHeadline, String articleReqFieldSubhead, String articleReqFieldAltHeadline, String articleReqFieldByline, String articleReqFieldSeoHeadline, String articleReqFieldPoll, String tagToolPlayerValue, String articleBlurbValue, String articleTaglineValue) throws InterruptedException	{
//		newArticlePageSource = driver.getPageSource();
//		DefaultSelenium seleniumDefault = new DefaultSelenium("localhost",4444,"*firefox","https://qahomebase.mlbcontrol.net");
		Selenium seleniumArticle = new WebDriverBackedSelenium(driver, mainURLCall);
		type(FieldInternalName, articleReqFieldInternalName);
		click(BtnTagTool);
		click(CheckboxTagToolAdvancedFields);
		click(BtnTagToolChangeDate);
		pause(1);
		seleniumArticle.keyPressNative(String.valueOf(KeyEvent.VK_ENTER));
		pause(1);
		pressTab();
		pause(1);
		pressTab();
		pause(1);
		pressTab();
		pause(1);
		sendKeys(tagToolPlayerValue);
		pause(1);
		pressTab();
		click(BtnApplyTagsAndClose);
		type(FieldHeadline, articleReqFieldHeadline);
		type(FieldSubhead, articleReqFieldSubhead);
		type(FieldAltHeadline, articleReqFieldAltHeadline);
		type(FieldByline, articleReqFieldByline);
		type(FieldSeoHeadline, articleReqFieldSeoHeadline);
		pause(1);
		pressTab();
		sendKeys(articleBlurbValue);
		pause(1);
		pressTab();
		sendKeys(articleTaglineValue);
		pause(1);
		type(FieldPoll, articleReqFieldPoll);
		click(BtnSave);
		click(BtnToBeta);
		click(linkViewBetaArticle);


		
//		String enterTag = Keys.chord(Keys.ENTER);
//		driver.findElement(By.id("tagging-autocompletePlayer")).sendKeys(enterTag);
//		pressTab();
//		sendKeys("Test");
//		click(articleRequiredClickC);
//		click(articleRequiredApplyTagsAndClose);
//		selenium.typeKeys("style='width:330px'", "Heller");
//		click(articleRequiredApplyTagsAndClose);
//		selenium.typeKeys(articleRequiredFieldHeadline.toString(), "Headline");
//		type(articleRequiredFieldHeadline, articleReqFieldHeadline);
//		selenium.keyPressNative(String.valueOf(KeyEvent.VK_TAB));
//		type(articleRequiredFieldSubhead, articleReqFieldSubhead);
//		click(articleRequiredPlayerTagInputField);
//		type(articleRequiredClickC,"x488");
//		click(articleRequiredApplyTagsAndClose);
//		selenium.typeKeys(articleRequiredFieldHeadline.toString(), "Something");
//		selenium.keyPress("Snehal Test Hello", "Snehal Test Hello");
//		pressTab();
//		sendKeys("Subhead ");
//		pressTab();
//		type(articleRequiredFieldHeadline, articleReqFieldHeadline);
//		type(articleRequiredFieldSubhead, articleReqFieldSubhead);
//		click(articleBtnSave);
//		click(articleRequiredClickH);
//		click(articleBtnToBeta);
//		isElementPresent(linkViewBetaArticle, 30);
//		click(linkViewBetaArticle);

	}

	public void fillAndSaveNewDigitalAsset(String mainURLCall, String digitalAssetReqFieldInternalName, String digitalAssetReqFieldHeadline, String tagToolPlayerValue) throws InterruptedException	{
		newDigitalAssetPageSource = driver.getPageSource();
		Selenium seleniumDigitalAsset = new WebDriverBackedSelenium(driver, mainURLCall);
		type(FieldInternalName, digitalAssetReqFieldInternalName);
		click(BtnTagTool);
		click(CheckboxTagToolAdvancedFields);
		click(BtnTagToolChangeDate);
		pause(1);
		seleniumDigitalAsset.keyPressNative(String.valueOf(KeyEvent.VK_ENTER));
		pause(1);
		pressTab();
		pause(1);
		pressTab();
		pause(1);
		pressTab();
		pause(1);
		sendKeys(tagToolPlayerValue);
		pause(1);
		pressTab();
		click(BtnApplyTagsAndClose);
		type(FieldHeadline, digitalAssetReqFieldHeadline);
		click(BtnSave);
		click(BtnToBeta);
	}

	public void fillAndSaveNewFieldOption(String mainURLCall, String fieldOptionReqFieldInternalName, String fieldOptionReqFieldDisplayName, String fieldOptionReqFieldValue, String tagToolPlayerValue) throws InterruptedException	{
//		newArticlePageSource = driver.getPageSource();
//		DefaultSelenium seleniumDefault = new DefaultSelenium("localhost",4444,"*firefox","https://qahomebase.mlbcontrol.net");
		Selenium seleniumFieldOption = new WebDriverBackedSelenium(driver, mainURLCall);
		type(FieldInternalName, fieldOptionReqFieldInternalName);
		click(BtnTagTool);
		click(CheckboxTagToolAdvancedFields);
		click(BtnTagToolChangeDate);
		pause(1);
		seleniumFieldOption.keyPressNative(String.valueOf(KeyEvent.VK_ENTER));
		pause(1);
		pressTab();
		pause(1);
		pressTab();
		pause(1);
		pressTab();
		pause(1);
		sendKeys(tagToolPlayerValue);
		pause(1);
		pressTab();
		click(BtnApplyTagsAndClose);
		type(FieldDisplayName, fieldOptionReqFieldDisplayName);
		type(FieldValue, fieldOptionReqFieldValue);
		click(BtnSave);
		click(BtnToBeta);

	}

	public void fillAndSaveNewHighlight(String mainURLCall, String highlightReqFieldInternalName, String highlightReqFieldYear, String tagToolPlayerValue) throws InterruptedException	{
//		newArticlePageSource = driver.getPageSource();
//		DefaultSelenium seleniumDefault = new DefaultSelenium("localhost",4444,"*firefox","https://qahomebase.mlbcontrol.net");
		Selenium seleniumHighlight = new WebDriverBackedSelenium(driver, mainURLCall);
		type(FieldInternalName, highlightReqFieldInternalName);
		click(BtnTagTool);
		click(CheckboxTagToolAdvancedFields);
		click(BtnTagToolChangeDate);
		pause(1);
		seleniumHighlight.keyPressNative(String.valueOf(KeyEvent.VK_ENTER));
		pause(1);
		pressTab();
		pause(1);
		pressTab();
		pause(1);
		pressTab();
		pause(1);
		sendKeys(tagToolPlayerValue);
		pause(1);
		pressTab();
		click(BtnApplyTagsAndClose);
		type(FieldYear, highlightReqFieldYear);
		click(BtnSave);
		click(BtnToBeta);

	}

	public void fillAndSaveNewHTMLPage(String mainURLCall, String hTMLPageReqFieldInternalName, String hTMLPageReqFieldHeadline, String hTMLPageBlurbValue, String tagToolPlayerValue) throws InterruptedException	{
//		newArticlePageSource = driver.getPageSource();
//		DefaultSelenium seleniumDefault = new DefaultSelenium("localhost",4444,"*firefox","https://qahomebase.mlbcontrol.net");
		Selenium seleniumHTMLPage = new WebDriverBackedSelenium(driver, mainURLCall);
		type(FieldInternalName, hTMLPageReqFieldInternalName);
		click(BtnTagTool);
		click(CheckboxTagToolAdvancedFields);
		click(BtnTagToolChangeDate);
		pause(1);
		seleniumHTMLPage.keyPressNative(String.valueOf(KeyEvent.VK_ENTER));
		pause(1);
		pressTab();
		pause(1);
		pressTab();
		pause(1);
		pressTab();
		pause(1);
		sendKeys(tagToolPlayerValue);
		pause(1);
		pressTab();
		click(BtnApplyTagsAndClose);
		type(FieldHeadline, hTMLPageReqFieldHeadline);
		pause(1);
		pressTab();
		sendKeys(hTMLPageBlurbValue);
		pause(1);
		click(BtnSave);
		click(BtnToBeta);

	}

	public void fillAndSaveNewLink(String mainURLCall, String linkReqFieldInternalName, String linkReqFieldLinkText, String linkReqFieldLinkURL, String linkReqFieldWidth, String linkReqFieldHeight, String tagToolPlayerValue) throws InterruptedException	{
//		newArticlePageSource = driver.getPageSource();
//		DefaultSelenium seleniumDefault = new DefaultSelenium("localhost",4444,"*firefox","https://qahomebase.mlbcontrol.net");
		Selenium seleniumLink = new WebDriverBackedSelenium(driver, mainURLCall);
		pause(3);
		sendKeys(linkReqFieldLinkText);
		pressTab();
		pause(3);
		type(FieldInternalName, linkReqFieldInternalName);
		click(BtnTagTool);
		click(CheckboxTagToolAdvancedFields);
		click(BtnTagToolChangeDate);
		seleniumLink.keyPressNative(String.valueOf(KeyEvent.VK_ENTER));
		pause(1);
		pressTab();
		pause(1);
		pressTab();
		pause(1);
		pressTab();
		pause(1);
		sendKeys(tagToolPlayerValue);
		pause(1);
		pressTab();
		click(BtnApplyTagsAndClose);
		type(FieldLinkURL, linkReqFieldLinkURL);
		pause(1);
		pressTab();
		pause(1);
		pressTab();
		sendKeys(linkReqFieldWidth);
		pause(1);
		pressTab();
		sendKeys(linkReqFieldHeight);
		pause(1);
		pressTab();
		pause(1);
		click(BtnSave);
		click(BtnToBeta);

	}

	public void fillAndSaveNewMediaWall(String mainURLCall, String mediawallReqFieldInternalName, String mediawallReqFieldHeadline, String mediawallReqFieldURLText, String mediawallReqFieldURL, String mediawallReqFieldMobileURL, String mediawallReqFieldSponsorURL, String mediawallReqFieldBlurb, String mediawallReqFieldNotes, String mediawallReqFieldDisplayTimeInSeconds, String mediawallReqFieldVideoAlias, String tagToolPlayerValue) throws InterruptedException	{
		newMediaWallPageSource = driver.getPageSource();
//		newArticlePageSource = driver.getPageSource();
//		DefaultSelenium seleniumDefault = new DefaultSelenium("localhost",4444,"*firefox","https://qahomebase.mlbcontrol.net");
		Selenium seleniumMediawall = new WebDriverBackedSelenium(driver, mainURLCall);
		type(FieldInternalName, mediawallReqFieldInternalName);
		click(BtnTagTool);
		click(CheckboxTagToolAdvancedFields);
		click(BtnTagToolChangeDate);
		pause(1);
		seleniumMediawall.keyPressNative(String.valueOf(KeyEvent.VK_ENTER));
		pause(1);
		pressTab();
		pause(1);
		pressTab();
		pause(1);
		pressTab();
		pause(1);
		sendKeys(tagToolPlayerValue);
		pause(1);
		pressTab();
		click(BtnApplyTagsAndClose);
		type(FieldHeadline, mediawallReqFieldHeadline);
		type(FieldURLText, mediawallReqFieldURLText);
		type(FieldURL, mediawallReqFieldURL);
		type(FieldMobileURL, mediawallReqFieldMobileURL);
		type(FieldSponsorURL, mediawallReqFieldSponsorURL);
		pause(1);
		pressTab();
		sendKeys(mediawallReqFieldBlurb);
		pause(1);
		pressTab();
		sendKeys(mediawallReqFieldNotes);
		pressTab();
		pause(1);
		type(FieldDisplayTimeInSeconds, mediawallReqFieldDisplayTimeInSeconds);
		type(FieldVideoAlias, mediawallReqFieldVideoAlias);
		click(BtnSave);
		click(BtnToBeta);
	}
	
	public void fillAndSaveNewNotebook(String mainURLCall, String notebookReqFieldInternalName, String notebookReqFieldHeadline, String notebookReqFieldByline, String notebookReqFieldSource, String notebookTaglineValue, String tagToolPlayerValue) throws InterruptedException	{
		newMediaWallPageSource = driver.getPageSource();
//		newArticlePageSource = driver.getPageSource();
//		DefaultSelenium seleniumDefault = new DefaultSelenium("localhost",4444,"*firefox","https://qahomebase.mlbcontrol.net");
		Selenium seleniumNotebook = new WebDriverBackedSelenium(driver, mainURLCall);
		type(FieldInternalName, notebookReqFieldInternalName);
		click(BtnTagTool);
		click(CheckboxTagToolAdvancedFields);
		click(BtnTagToolChangeDate);
		pause(1);
		seleniumNotebook.keyPressNative(String.valueOf(KeyEvent.VK_ENTER));
		pause(1);
		pressTab();
		pause(1);
		pressTab();
		pause(1);
		pressTab();
		pause(1);
		sendKeys(tagToolPlayerValue);
		pause(1);
		pressTab();
		click(BtnApplyTagsAndClose);
		type(FieldHeadline, notebookReqFieldHeadline);
		type(FieldByline, notebookReqFieldByline);
		type(FieldSource, notebookReqFieldSource);
		pause(1);
		pressTab();
		sendKeys(notebookTaglineValue);
		pause(1);
		pressTab();
		pause(1);
		click(BtnSave);
		click(BtnToBeta);
	}

	public void fillAndSaveNewPhotoGallery(String mainURLCall, String photoGalleryReqFieldInternalName, String photoGalleryReqFieldTitle, String photoGalleryReqFieldSpanishTitle, String photoGalleryReqFieldBlurb, String photoGalleryReqFieldSpanishBlurb, String tagToolPlayerValue) throws InterruptedException	{
		newMediaWallPageSource = driver.getPageSource();
//		newArticlePageSource = driver.getPageSource();
//		DefaultSelenium seleniumDefault = new DefaultSelenium("localhost",4444,"*firefox","https://qahomebase.mlbcontrol.net");
		Selenium seleniumPhotoGallery = new WebDriverBackedSelenium(driver, mainURLCall);
		type(FieldInternalName, photoGalleryReqFieldInternalName);
		click(BtnTagTool);
		click(CheckboxTagToolAdvancedFields);
		click(BtnTagToolChangeDate);
		pause(1);
		seleniumPhotoGallery.keyPressNative(String.valueOf(KeyEvent.VK_ENTER));
		pause(1);
		pressTab();
		pause(1);
		pressTab();
		pause(1);
		pressTab();
		pause(1);
		sendKeys(tagToolPlayerValue);
		pause(1);
		pressTab();
		click(BtnApplyTagsAndClose);
		type(FieldTitle, photoGalleryReqFieldTitle);
		type(FieldSpanishTitle, photoGalleryReqFieldSpanishTitle);
		pause(1);
		pressTab();
		sendKeys(photoGalleryReqFieldBlurb);
		pause(1);
		pressTab();
		sendKeys(photoGalleryReqFieldSpanishBlurb);
		pause(1);
		pressTab();
		pause(1);
		click(BtnSave);
		click(BtnToBeta);
	}

}
