package com.mlb.qa.gui.pages.homebaseproject;

import org.junit.Assert;
import com.thoughtworks.selenium.DefaultSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.FindBy;
import com.thoughtworks.selenium.*;
import com.qaprosoft.carina.core.foundation.*;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.*;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import com.qaprosoft.carina.core.foundation.http.*;
import com.mlb.qa.atb.AtbParameter;
import com.mlb.qa.common.http.*;

import java.util.Set;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.mlb.qa.atb.AtbParameter;
import com.mlb.qa.atb.model.about.BallparkInformation;
import com.mlb.qa.atb.model.checkin_history.CheckinHistoryJsonItem;
import com.mlb.qa.atb.model.checkin_history.CheckinHistoryJson;
import com.mlb.qa.atb.model.game_promotion.GamePromotion;
import com.mlb.qa.atb.model.game_promotion.QueryGamePromotionsRS;
import com.mlb.qa.atb.model.game_ticket.GameTicket;
import com.mlb.qa.atb.model.game_ticket.QueryGameTicketsRS;
import com.mlb.qa.atb.model.identity_point.IdentityPoint;
import com.mlb.qa.atb.model.identity_point.IdentityPointIdentifyRS;
import com.mlb.qa.common.date.DateUtils;
import com.mlb.qa.common.exception.TestRuntimeException;
import com.mlb.qa.common.http.HttpHelper;
import com.mlb.qa.common.http.HttpResult;
//import com.mlb.qa.tests.web.homebase.ChromeDriver;


public class HB_HomePage extends AbstractPage {
	private static final Logger logger = Logger.getLogger(HB_HomePage.class);

	public HB_HomePage(WebDriver driver) {
		super(driver);
		setPageAbsoluteURL("https://qahomebase.mlbcontrol.net/");
		open();
	}
	

	private static final String hostName = "https://qahomebase.mlbcontrol.net/";
	private static final String SHOW_HISTORY_LABEL = "Show History";
	private static final String HIDE_HISTORY_LABEL = "Hide History";
	private static String newArticlePageSource;
	private static String articleInternalNameUniqueID;
	private static String newMediaWallPageSource;
	private static String mediaWallInternalNameUniqueID;
	private static String newDigitalAssetPageSource;
	private static String digitalAssetInternalNameUniqueID;
	private static String newUploadPhotosPageSource;
	private static final String addressMultipleCutUpload =  hostName + "photo-asset/image/upload?";
	private static final String multipleCutUploadURLCreateThumb = "yes";
	private static final String multipleCutUploadURLPhotoTemplateID = "43123107";
	private static final String multipleCutUploadURLResizeQuality = "100";
	
	//************ LOGIN OBJECTS ************//	

	@FindBy(xpath="//div[@id='cke_16_contents']")
	public ExtendedWebElement FieldWYSIWYGParent;
	
	@FindBy(xpath="//iframe[@class='cke_wysiwyg_frame cke_reset']")
	public ExtendedWebElement FieldWYSIWYG;

	@FindBy(xpath="//br[@type='_moz']")
	public ExtendedWebElement FieldWYSIWYGBody;

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

	//************ MENU BAR OBJECTS ************//	

	@FindBy(xpath="//span[contains(text(), 'Dashboard')]")
	public ExtendedWebElement btnMenuBarDashboard;

	@FindBy(xpath="//span[contains(text(), 'Upload Photos')]")
	public ExtendedWebElement btnMenuBarUploadPhotos;

	@FindBy(xpath="//span[contains(text(), 'Item Editor')]")
	public ExtendedWebElement btnMenuBarItemEditor;

	@FindBy(xpath="//span[contains(text(), 'Control Panel')]")
	public ExtendedWebElement btnMenuBarControlPanel;

	@FindBy(xpath="//span[contains(text(), 'Settings')]")
	public ExtendedWebElement btnMenuBarSettings;

	//************ MENU BAR OBJECTS ************//	

	//************ SETTINGS OBJECTS ************//	

	@FindBy(xpath="//option[contains(text(), '120SPORTS')]")
	public ExtendedWebElement dropDownCurrentDomain120SPORTS;

	@FindBy(xpath="//option[contains(text(), 'MILB')]")
	public ExtendedWebElement dropDownCurrentDomainMILB;

	@FindBy(xpath="//option[contains(text(), 'MLB')]")
	public ExtendedWebElement dropDownCurrentDomainMLB;

	//************ SETTINGS OBJECTS ************//	

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

	@FindBy(id="searchHeaderText")
	public ExtendedWebElement FieldMainSearch;

	@FindBy(xpath="//ul[@class='ui-sortable']")
	public ExtendedWebElement panelSearchUISortable;

	@FindBy(xpath="//div[contains(text(), 'Hide Options')]")
	public ExtendedWebElement btnSearchHideOptions; 
	
    @FindBy(xpath="//*[@id='search-result-content-panel']/ul/li[2]/div/div[@class='tiletextblock']/div[@class='tileInfo ']/div")
    public ExtendedWebElement panelSearchTileInfo;
	
    @FindBy(xpath="//*[@id='search-result-content-panel']/ul/li[2]/div/div[@class='tiletextblock']/div[@class='tileControls']/div")
    public ExtendedWebElement panelSearchTileControls;
	
	//************ SEARCH OBJECTS ************//	
	
	//************ TAG TOOL OBJECTS ************//	

	@FindBy(xpath="//input[@type='text'][@style='width:330px']")
	public ExtendedWebElement fieldTagToolPlayerTagByName;
	
	@FindBy(xpath="//input[@type='text'][@style='width:245px']")
	public ExtendedWebElement fieldTagToolPlayerTagByTeam;
	
	@FindBy(xpath="//input[@type='text'][@style='width:320px']")
	public ExtendedWebElement fieldTagToolPlayerTagByTeamPlayerName;
	
	//************ TAG TOOL OBJECTS ************//	

	//************ ITEM CREATION OBJECTS ************//	

	@FindBy(xpath="//div[contains(text(), 'Publish Complete')]")
	public ExtendedWebElement statusPublishComplete; 
	
	@FindBy(id="item-panel-delete")
	public ExtendedWebElement deleteItem;

	@FindBy(xpath="//span[contains(text(), 'Delete item')]")
	public ExtendedWebElement deleteItemConfirm; 
	
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

	@FindBy(id="item-panel-publish-prod")
	public ExtendedWebElement BtnToProd;

	@FindBy(xpath="//span[contains(text(), 'Send To Prod')]")
	public ExtendedWebElement BtnToProdConfirm;

	@FindBy(xpath="//div[contains(text(), 'New Audio Show')]")
	public ExtendedWebElement btnNewAudioShow;

	@FindBy(xpath="//span[contains(text(), 'Select Site')]")
	public ExtendedWebElement dropDownSelectSite;
	
	@FindBy(xpath="//a[contains(text(), 'mlb')]")
	public ExtendedWebElement dropDownSelectMLB;
	
	@FindBy(xpath="//a[contains(text(), 'milb')]")
	public ExtendedWebElement dropDownSelectMiLB;
	
	@FindBy(name="@name")
	public ExtendedWebElement FieldInternalName;

	@FindBy(name="name")
	public ExtendedWebElement FieldName;

	@FindBy(name="vkey")
	public ExtendedWebElement FieldViewKey;

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

	@FindBy(name="seo-headline")
	public ExtendedWebElement FieldSeoHeadline2;

	@FindBy(name="summary")
	public ExtendedWebElement FieldSummary;

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

	@FindBy(name="id")
	public ExtendedWebElement FieldID;

	@FindBy(xpath="//button[contains(text(), 'Tag Tool')]")
	public ExtendedWebElement BtnTagTool;

	@FindBy(xpath="//span[contains(text(), 'Save All and Publish to Prod')]")
	public ExtendedWebElement BtnSaveAllAndPublishToProd;	

	@FindBy(xpath="//span[contains(text(), 'Send To Prod')]")
	public ExtendedWebElement BtnSendToProd;	

	@FindBy(xpath="//span[contains(text(), 'Close')]")
	public ExtendedWebElement BtnClose;	
	
	@FindBy(xpath="//div[contains(text(), 'Choose a File to Upload')]")
	public ExtendedWebElement BtnChooseAFileToUpload;

	@FindBy(xpath="//span[contains(text(), 'Upload Photos')]")
	public ExtendedWebElement BtnHomePageUploadPhotos;

	@FindBy(xpath="//div[@class='monitorForItem']")
	public ExtendedWebElement StatusPublishComplete;

	@FindBy(xpath="//div[@style='font-size: 13px;min-height:16px;']")
	public ExtendedWebElement valuePhotoAsset;
	
	@FindBy(xpath="//*[@value='265']")
	public ExtendedWebElement FieldPhotoAssetCutWidth001;

	@FindBy(xpath="//*[@value='150']")
	public ExtendedWebElement FieldPhotoAssetCutHeight001;

	@FindBy(id="multiUPstartBrowse")
	public ExtendedWebElement BtnMultipleCutUploadAddFiles;

	@FindBy(id="singleUPstartBrowse")
	public ExtendedWebElement BtnSingleCutUploadAddFiles;

	@FindBy(id="compactLayout")
	public ExtendedWebElement CheckboxTagToolAdvancedFields;

	@FindBy(xpath="//input[@class='autocomplete-maininput processedYes']")
	public ExtendedWebElement FieldTagToolPlayer;	

	@FindBy(id="taggingGameDayBrowse")
	public ExtendedWebElement BtnTagToolChangeDate;

	@FindBy(xpath="//td[@class=' ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today']")
	public ExtendedWebElement BtnTagToolSelectCurrentDate;

	@FindBy(xpath="//div[@class='autocompleteResultsContainer'][@style='width:330px']")
	public ExtendedWebElement FieldTagToolPlayerTag;

	@FindBy(xpath="(//button[@type='button'])[2]")
	public ExtendedWebElement BtnApplyTagsAndClose;

	@FindBy(name="caption")
	public ExtendedWebElement FieldCaption;

	@FindBy(name="media-credit")
	public ExtendedWebElement FieldMediaCredit;

	@FindBy(xpath="//textarea[@data-field-key='blurb']")
	public ExtendedWebElement FieldBlurb;

	@FindBy(xpath="//textarea[@data-field-key='notes']")
	public ExtendedWebElement FieldNotes;

	@FindBy(xpath="//textarea[@data-field-key='tagline']")
	public ExtendedWebElement FieldTagline;

	@FindBy(xpath="//span[contains(text(), 'WYSIWYG')]")
	public ExtendedWebElement BtnCmsToolWysiwyg;

	@FindBy(xpath="//span[contains(text(), 'HTML')]")
	public ExtendedWebElement BtnCmsToolHtml;

	@FindBy(xpath="//span[2][contains(text(), 'WYSIWYG')]")
	public ExtendedWebElement BtnCmsToolWysiwyg2;

	@FindBy(xpath="//span[2][contains(text(), 'HTML')]")
	public ExtendedWebElement BtnCmsToolHtml2;

	//************ ITEM CREATION OBJECTS ************//	
	
	//************ ARTICLE CREATION OBJECTS ************//	

	@FindBy(id="tagging-autocompletePlayer")
	public ExtendedWebElement articleRequiredClickC;

	@FindBy(linkText="View Beta Article")
	public ExtendedWebElement linkViewBetaArticle;

	//************ ARTICLE CREATION OBJECTS ************//	

	//************ ARTICLE VIEW CREATION OBJECTS ************//	
	
	//************ ARTICLE VIEW CREATION OBJECTS ************//	

	//************ AUDIO SCHEDULE CREATION OBJECTS ************//	

	@FindBy(xpath="//button[contains(text(), 'New Audio Show')]")
	public ExtendedWebElement BtnNewAudioShow;

	//************ AUDIO SCHEDULE CREATION OBJECTS ************//	

	//************ BALLPARK CREATION OBJECTS ************//	

	@FindBy(name="address1")
	public ExtendedWebElement FieldAddress1;

	@FindBy(name="address2")
	public ExtendedWebElement FieldAddress2;

	@FindBy(name="location")
	public ExtendedWebElement FieldLocation;

	@FindBy(name="mapVersion")
	public ExtendedWebElement FieldMapVersion;

	@FindBy(name="mapType")
	public ExtendedWebElement FieldMapType;

	@FindBy(name="facebookId")
	public ExtendedWebElement FieldFacebookID;

	@FindBy(name="facebook-id")
	public ExtendedWebElement FieldFacebookID2;

	@FindBy(name="foursquareId")
	public ExtendedWebElement FieldFoursquareID;

	@FindBy(name="websiteURL")
	public ExtendedWebElement FieldWebsiteURL;

	@FindBy(name="thumbnailCaption")
	public ExtendedWebElement FieldThumbnailCaption;

	@FindBy(name="thumbnailURL")
	public ExtendedWebElement FieldThumbnailURL;

	@FindBy(name="twitterHashTags")
	public ExtendedWebElement FieldTwitterHashTags;

	@FindBy(name="aboutURL")
	public ExtendedWebElement FieldAboutURL;

	@FindBy(name="scheduleURL")
	public ExtendedWebElement FieldScheduleURL;

	@FindBy(name="smallThumbnailURL")
	public ExtendedWebElement FieldSmallThumbnailURL;

	@FindBy(name="startYear")
	public ExtendedWebElement FieldStartYear;

	@FindBy(name="endYear")
	public ExtendedWebElement FieldEndYear;

	@FindBy(name="upgradeURL")
	public ExtendedWebElement FieldUpgradeURL;

	@FindBy(xpath="//textarea[@data-field-key='about']")
	public ExtendedWebElement FieldAbout;

	@FindBy(name="eventsText")
	public ExtendedWebElement FieldEventsText;

	@FindBy(name="sponsorshipImageText")
	public ExtendedWebElement FieldSponsorImageText;

	@FindBy(name="sponsorshipImageURL")
	public ExtendedWebElement FieldSponsorImageURL;

	@FindBy(name="sponsorshipImage2Text")
	public ExtendedWebElement FieldSponsorImage2Text;

	@FindBy(name="sponsorshipImage2URL")
	public ExtendedWebElement FieldSponsorImage2URL;

	@FindBy(name="ticketsText")
	public ExtendedWebElement FieldTicketsText;

	@FindBy(name="ticketsURL")
	public ExtendedWebElement FieldTicketsURL;

	@FindBy(name="ticketsErrorText")
	public ExtendedWebElement FieldTicketsErrorText;

	//************ BALLPARK CREATION OBJECTS ************//	

	//************ BALLPARK MENU CREATION OBJECTS ************//	

	@FindBy(name="displayImageURL")
	public ExtendedWebElement FieldDisplayImageURL;

	@FindBy(name="linkName")
	public ExtendedWebElement FieldLinkName;

	@FindBy(name="linkURL")
	public ExtendedWebElement FieldLinkURL2;

	@FindBy(name="bundleKey")
	public ExtendedWebElement FieldBundleKey;

	@FindBy(name="bundleName")
	public ExtendedWebElement FieldBundleName;

	@FindBy(name="bundleURL")
	public ExtendedWebElement FieldBundleURL;

	@FindBy(name="sharingURL")
	public ExtendedWebElement FieldSharingURL;

	@FindBy(name="sharingText")
	public ExtendedWebElement FieldSharingText;

	@FindBy(name="errorText")
	public ExtendedWebElement FieldErrorText;

	@FindBy(name="sourceURL")
	public ExtendedWebElement FieldSourceURL;

	//************ BALLPARK MENU CREATION OBJECTS ************//	

	//************ BALLPARK MUSIC CREATION OBJECTS ************//	

	@FindBy(name="artist")
	public ExtendedWebElement FieldArtist;

	@FindBy(xpath="//textarea[@data-field-key='description']")
	public ExtendedWebElement FieldDescription;

	// *** ALSO FOUND IN BALLPARK CREATION AND ITEM CREATION SECTIONS *** //
	
	//************ BALLPARK MUSIC CREATION OBJECTS ************//	

	//************ BALLPARK SUBMENU CREATION OBJECTS ************//	

	// *** ALSO FOUND IN BALLPARK CREATION AND ITEM CREATION SECTIONS *** //
	
	//************ BALLPARK SUBMENU CREATION OBJECTS ************//	

	//************ BLOG CONTENT CREATION OBJECTS ************//	

	@FindBy(xpath="//textarea[@data-field-key='blurb']")
	public ExtendedWebElement FieldBody;

	//************ BLOG CONTENT CREATION OBJECTS ************//	

	//************ CHRON CREATION OBJECTS ************//	

	@FindBy(name="notation")
	public ExtendedWebElement FieldDateNotation;

	@FindBy(name="displayYear")
	public ExtendedWebElement FieldDisplayYear;

	@FindBy(xpath="//textarea[@data-field-key='blurb']")
	public ExtendedWebElement FieldCMSDescription;

	//************ CHRON CREATION OBJECTS ************//	

	//************ CLUB PROMO CREATION OBJECTS ************//	

	@FindBy(name="urlExtension")
	public ExtendedWebElement FieldURLExtension;
	
	@FindBy(name="eventTitle")
	public ExtendedWebElement FieldEventTitle;
	
	@FindBy(name="event-subtitle")
	public ExtendedWebElement FieldEventSubtitle;
	
	@FindBy(name="promo")
	public ExtendedWebElement FieldPromoText;
	
	@FindBy(name="ticketsText")
	public ExtendedWebElement FieldMobileTicketsText;

	@FindBy(name="mobileTicketsURL")
	public ExtendedWebElement FieldMobileTicketsURL;

	@FindBy(name="textCampaignPromo")
	public ExtendedWebElement FieldTextCampaignPromo;
	
	@FindBy(name="social-keyword")
	public ExtendedWebElement FieldSocialKeyword;
	
	@FindBy(name="highlights-title")
	public ExtendedWebElement FieldHighlightsTitle;
	
	@FindBy(xpath="//textarea[@data-field-key='locationAddress']")
	public ExtendedWebElement FieldLocationAddress;

	@FindBy(name="eventMapTitle")
	public ExtendedWebElement FieldEventMapTitle;
	
	@FindBy(name="schedule-title")
	public ExtendedWebElement FieldScheduleTitle;
	
	@FindBy(name="faq-title")
	public ExtendedWebElement FieldFAQTitle;

	@FindBy(xpath="//label[contains(text(), 'Sponsors')]")
	public ExtendedWebElement labelSponsors;

	//************ CLUB PROMO CREATION OBJECTS ************//		
	
	//************ CONTRIBUTOR CREATION OBJECTS ************//		
	@FindBy(name="first-name")
	public ExtendedWebElement FieldFirstName;
	
	@FindBy(name="last-name")
	public ExtendedWebElement FieldLastName;
	
	@FindBy(name="email")
	public ExtendedWebElement FieldEmail;
	
	@FindBy(name="twitter")
	public ExtendedWebElement FieldTwitterHandle;
	
	@FindBy(name="blog")
	public ExtendedWebElement FieldBlog;
	
	@FindBy(name="blog-title")
	public ExtendedWebElement FieldBlogTitle;
	
	@FindBy(name="atom-rss")
	public ExtendedWebElement FieldRSSFeed;
	
	@FindBy(name="active-tab")
	public ExtendedWebElement FieldActiveTab;
	
	@FindBy(name="hide-articles")
	public ExtendedWebElement FieldHideArticles;
	
	@FindBy(name="video-keyword-type")
	public ExtendedWebElement FieldVideoKeywordType;
	
	@FindBy(name="video-keyword-value")
	public ExtendedWebElement FieldVideoKeywordValue;
	
	@FindBy(name="video-landing-page")
	public ExtendedWebElement FieldVideoLandingPage;
	
	@FindBy(xpath="//label[contains(text(), 'Big Blurb')]")
	public ExtendedWebElement labelBigBlurb;

	//************ CONTRIBUTOR CREATION OBJECTS ************//		

	//************ DAILY EMAIL CREATION OBJECTS ************//	

	@FindBy(name="subject")
	public ExtendedWebElement FieldSubject;

	@FindBy(name="subjectb")
	public ExtendedWebElement FieldSubjectB;

	@FindBy(name="triviaQuestion")
	public ExtendedWebElement FieldTriviaQuestion;

	@FindBy(name="triviaAnswer")
	public ExtendedWebElement FieldTriviaAnswer;

	//************ DAILY EMAIL CREATION OBJECTS ************//	

	//************ DEVICE ANNOUNCEMENT CREATION OBJECTS ************//	

	@FindBy(name="appVersion")
	public ExtendedWebElement FieldAppVersion;

	@FindBy(name="osVersion")
	public ExtendedWebElement FieldOSVersion;

	@FindBy(name="entitlement")
	public ExtendedWebElement FieldEntitlement;

	@FindBy(name="screen")
	public ExtendedWebElement FieldScreen;

	@FindBy(name="type")
	public ExtendedWebElement FieldType;

	@FindBy(name="displayType")
	public ExtendedWebElement FieldDisplayType;

	@FindBy(name="text")
	public ExtendedWebElement FieldMessage;

	@FindBy(name="open-title")
	public ExtendedWebElement FieldOpenLabel;

	@FindBy(name="openLink")
	public ExtendedWebElement FieldOpenLink;

	@FindBy(name="close-title")
	public ExtendedWebElement FieldCloseLabel;

	@FindBy(name="closeLink")
	public ExtendedWebElement FieldCloseLink;

	//************ DEVICE ANNOUNCEMENT CREATION OBJECTS ************//	

	//************ DEVICE BANNER CREATION OBJECTS ************//	

	@FindBy(name="accessFeature")
	public ExtendedWebElement FieldAccessFeature;

	@FindBy(name="viewid")
	public ExtendedWebElement FieldViewID;

	@FindBy(name="webviewtype")
	public ExtendedWebElement FieldWebViewType;

	@FindBy(name="link")
	public ExtendedWebElement FieldLink;

	@FindBy(name="bgcolor")
	public ExtendedWebElement FieldBackgroundColor;

	@FindBy(name="trackingString")
	public ExtendedWebElement FieldTrackingString;

	@FindBy(name="adMarvelId")
	public ExtendedWebElement FieldAdMarvelID;

	@FindBy(name="sizeWidth")
	public ExtendedWebElement FieldAdMarvelWidth;

	@FindBy(name="sizeHeight")
	public ExtendedWebElement FieldAdMarvelHeight;

	@FindBy(name="sectionId")
	public ExtendedWebElement FieldAdMarvelSectionID;

	@FindBy(name="mlbtarget")
	public ExtendedWebElement FieldAdMarvelMLBTarget;

	@FindBy(name="admarvelExpiryTime")
	public ExtendedWebElement FieldAdMarvelExpiryTime;

	@FindBy(name="contentID")
	public ExtendedWebElement FieldMLBTVContentID;

	@FindBy(name="calendarEventID")
	public ExtendedWebElement FieldMLBTVCalendarEventID;

	@FindBy(name="sponsor")
	public ExtendedWebElement FieldSponsor;

	//************ DEVICE BANNER CREATION OBJECTS ************//	

	//************ DEVICE PAGE CREATION OBJECTS ************//	

	@FindBy(name="yearly-purchase-flow")
	public ExtendedWebElement FieldYearlyPurchaseFlow;

	@FindBy(name="monthly-purchase-flow")
	public ExtendedWebElement FieldMonthlyPurchaseFlow;

	@FindBy(name="upgrade-link")
	public ExtendedWebElement FieldUpgradeLink;

	@FindBy(name="activation-link")
	public ExtendedWebElement FieldActivationLink;

	//************ DEVICE PAGE CREATION OBJECTS ************//	

	//************ DRAWER CREATION OBJECTS ************//	

	@FindBy(xpath="//input[@data-field-key='appears']")
	public ExtendedWebElement FieldAppears;

	@FindBy(xpath="//input[@data-field-key='expires']")
	public ExtendedWebElement FieldExpires;

	@FindBy(name="kicker")
	public ExtendedWebElement FieldKicker;

	@FindBy(name="custom-content")
	public ExtendedWebElement FieldCustomContent;

	@FindBy(name="numitems")
	public ExtendedWebElement FieldNumberOfItems;

	//************ DRAWER CREATION OBJECTS ************//	

	//************ EVENT CREATION OBJECTS ************//	

	@FindBy(name="program-id")
	public ExtendedWebElement FieldProgramID;

	@FindBy(name="program")
	public ExtendedWebElement FieldProgram;

	@FindBy(name="event-title")
	public ExtendedWebElement FieldEventTitle2;
	
	@FindBy(xpath="//textarea[@data-field-key='event-description']")
	public ExtendedWebElement FieldEventDescription;

	@FindBy(name="event-url")
	public ExtendedWebElement FieldEventURL;

	@FindBy(xpath="//input[@data-field-key='end-datetime']")
	public ExtendedWebElement FieldEndDateAndTime;

	@FindBy(xpath="//input[@data-field-key='start-datetime']")
	public ExtendedWebElement FieldStartDateAndTime;

	//************ EVENT CREATION OBJECTS ************//	

	//************ DIGITAL ASSET CREATION OBJECTS ************//	

	//************ DIGITAL ASSET CREATION OBJECTS ************//	

	//************ FIELD OPTION CREATION OBJECTS ************//	

	//************ FIELD OPTION CREATION OBJECTS ************//	

	//************ GAME PREVIEW CREATION OBJECTS ************//	

	@FindBy(name="home-headline")
	public ExtendedWebElement FieldHomeHeadline;

	@FindBy(name="away-headline")
	public ExtendedWebElement FieldAwayHeadline;

	//************ GAME PREVIEW CREATION OBJECTS ************//	

	//************ HIGHLIGHT CREATION OBJECTS ************//	

	@FindBy(xpath="//input[@data-field-key='default-alt-text']")
	public ExtendedWebElement FieldDefaultAltText;

	@FindBy(xpath="//input[@data-field-key='default-clickthrough-url']")
	public ExtendedWebElement FieldDefaultClickthroughURL;

	//************ HIGHLIGHT CREATION OBJECTS ************//	

	//************ HP CONFIG CREATION OBJECTS ************//	
	@FindBy(xpath="//input[@data-field-key='breaking-news']")
	public ExtendedWebElement FieldBreakingNews;

	@FindBy(xpath="//input[@data-field-key='breaking-news-url']")
	public ExtendedWebElement FieldBreakingNewsURL;

	@FindBy(xpath="//input[@data-field-key='abTests']")
	public ExtendedWebElement FieldABTests;

	@FindBy(xpath="//input[@data-field-key='header-url']")
	public ExtendedWebElement FieldHeaderURL;

	@FindBy(xpath="//input[@data-field-key='header-alt']")
	public ExtendedWebElement FieldHeaderAlt;

	//************ HP CONFIG CREATION OBJECTS ************//	

	//************ HTML PAGE CREATION OBJECTS ************//	

	//************ HTML PAGE CREATION OBJECTS ************//	

	//************ INSTAGRAM PHOTO CREATION OBJECTS ************//	

	@FindBy(name="approver")
	public ExtendedWebElement FieldApprover;

	@FindBy(xpath="//input[@data-field-key='approvedTime']")
	public ExtendedWebElement FieldApprovedTime;

	@FindBy(name="id")
	public ExtendedWebElement FieldInstagramID;

	@FindBy(name="image")
	public ExtendedWebElement FieldImageURL;

	@FindBy(name="bigImage")
	public ExtendedWebElement FieldLargeImageURL;

	@FindBy(name="userID")
	public ExtendedWebElement FieldCreatorID;

	@FindBy(name="userName")
	public ExtendedWebElement FieldCreatorName;

	@FindBy(name="userImage")
	public ExtendedWebElement FieldCreatorProfilePicture;

	@FindBy(xpath="//input[@data-field-key='createdTime']")
	public ExtendedWebElement FieldCreatedTime;

	@FindBy(name="latitude")
	public ExtendedWebElement FieldLatitude;

	@FindBy(name="latitude")
	public ExtendedWebElement FieldLongitude;

	//************ INSTAGRAM PHOTO CREATION OBJECTS ************//	

	//************ INSTAGRAM STREAM CREATION OBJECTS ************//
	
	@FindBy(name="name")
	public ExtendedWebElement FieldInstagramStreamDisplayName;

	@FindBy(name="key")
	public ExtendedWebElement FieldKey;

	//************ INSTAGRAM STREAM CREATION OBJECTS ************//

	//************ KIOSK CREATION OBJECTS ************//	

	@FindBy(name="calendar-event-id")
	public ExtendedWebElement FieldCalendarEventID;

	@FindBy(name="content-id")
	public ExtendedWebElement FieldContentID;

	//************ KIOSK CREATION OBJECTS ************//	
	
	//************ LINEUP CREATION OBJECTS ************//	

	@FindBy(xpath="//input[@data-field-key='umpire_id_hp']")
	public ExtendedWebElement FieldUmpireHP;

	@FindBy(xpath="//input[@data-field-key='umpire_id_1b']")
	public ExtendedWebElement FieldUmpire1st;

	@FindBy(xpath="//input[@data-field-key='umpire_id_2b']")
	public ExtendedWebElement FieldUmpire2nd;

	@FindBy(xpath="//input[@data-field-key='umpire_id_3b']")
	public ExtendedWebElement FieldUmpire3rd;

	@FindBy(xpath="//input[@data-field-key='umpire_id_lf']")
	public ExtendedWebElement FieldUmpireLF;

	@FindBy(xpath="//input[@data-field-key='umpire_id_rf']")
	public ExtendedWebElement FieldUmpireRF;

	@FindBy(xpath="//input[@data-field-key='official_scorer_id']")
	public ExtendedWebElement FieldUmpireOS;

	@FindBy(name="notes")
	public ExtendedWebElement FieldLineupNotes;

	@FindBy(xpath="//button[@data-sub-item-type='lineup-player']")
	public ExtendedWebElement btnSearchForLineupPlayer;

	//************ LINEUP CREATION OBJECTS ************//	

	//************ LINEUP PLAYER CREATION OBJECTS ************//	

	//************ LINEUP PLAYER CREATION OBJECTS ************//	

	@FindBy(name="position")
	public ExtendedWebElement FieldPosition;

	//************ LINK CREATION OBJECTS ************//	

	@FindBy(name="link-url")
	public ExtendedWebElement FieldLinkURL;

	@FindBy(name="thumbnail")
	public ExtendedWebElement FieldThumbnail;

	@FindBy(name="rank")
	public ExtendedWebElement FieldRank;

	//************ LINK CREATION OBJECTS ************//	

	//************ LIST CREATION OBJECTS ************//	

	@FindBy(xpath="//button[contains(text(), 'Search for Items')]")
	public ExtendedWebElement btnSearchForItems;
	
	//************ LIST CREATION OBJECTS ************//	

	//************ MEDIAWALL CREATION OBJECTS ************//	

	@FindBy(name="numpanels")
	public ExtendedWebElement FieldNumberOfPanels;

	//************ MEDIAWALL CREATION OBJECTS ************//	

	//************ MLBTV AD MODULE CREATION OBJECTS ************//	

	@FindBy(name="tablet-url")
	public ExtendedWebElement FieldTabletURL;

	//************ MLBTV AD MODULE CREATION OBJECTS ************//	

	//************ PRESS RELEASE CREATION OBJECTS ************//	

	@FindBy(name="alt-headline")
	public ExtendedWebElement FieldDisplayHeadline;

	@FindBy(name="subheadline")
	public ExtendedWebElement FieldSubHeadline;

	@FindBy(xpath="//label[@title='* Body']")
	public ExtendedWebElement HeaderBody;

	//************ PRESS RELEASE CREATION OBJECTS ************//	

	//************ SECTION CREATION OBJECTS ************//	

	@FindBy(name="id")
	public ExtendedWebElement FieldSectionID;

	@FindBy(name="short_title")
	public ExtendedWebElement FieldShortTitle;

	@FindBy(name="long_title")
	public ExtendedWebElement FieldLongTitle;

	@FindBy(xpath="//textarea[@data-field-key='url']")
	public ExtendedWebElement FieldWiredURL;

	@FindBy(name="target")
	public ExtendedWebElement FieldTarget;

	//************ SECTION CREATION OBJECTS ************//	

	//************ VIDEO TOPIC PAGE CREATION OBJECTS ************//	

	@FindBy(xpath="//textarea[@data-field-key='description']")
	public ExtendedWebElement FieldFacebookDescription;

	@FindBy(xpath="//input[@data-field-key='max-items']")
	public ExtendedWebElement FieldMaxItems;

	@FindBy(xpath="//input[@data-field-key='items-per-page']")
	public ExtendedWebElement FieldItemsPerPage;

	@FindBy(xpath="//input[@data-field-key='search_criteria']")
	public ExtendedWebElement FieldSearchCriteria;

	@FindBy(xpath="//input[@data-field-key='related_link']")
	public ExtendedWebElement FieldRelatedLink;

	@FindBy(xpath="//input[@data-field-key='jsp_path']")
	public ExtendedWebElement FieldCustomTemplatePath;

	@FindBy(xpath="//input[@data-field-key='js_path']")
	public ExtendedWebElement FieldJavascriptPath;

	@FindBy(xpath="//input[@data-field-key='css_path']")
	public ExtendedWebElement FieldStylesheetPath;

	@FindBy(xpath="//input[@data-field-key='customPanel']")
	public ExtendedWebElement FieldCustomPanel;

	@FindBy(xpath="//input[@data-field-key='twitter-handle']")
	public ExtendedWebElement FieldTwitterHandleVTP;

	@FindBy(xpath="//input[@data-field-key='poll_key']")
	public ExtendedWebElement FieldPollKey;

	@FindBy(xpath="//button[@data-sub-item-type='video_clip_list']")
	public ExtendedWebElement btnSearchForVideoClipList;

    @FindBy(xpath="//*[@id='search-autocompleteQuery']/div[@class='autocompleteResultsContainer']/ul[@class='ac-holder']/li/input[@class='autocomplete-maininput processedYes']")
	public ExtendedWebElement FieldSearchWordOrPhraseOrContentID;

	@FindBy(id="refreshSearchBot")
	public ExtendedWebElement btnSearchForVideoClipListSearchButton;

	//************ VIDEO TOPIC PAGE CREATION OBJECTS ************//	
	
	//************ VIDEO CLIP LIST CREATION OBJECTS ************//	

	@FindBy(xpath="//input[@data-field-key='listDefaultView']")
	public ExtendedWebElement FieldListDefaultView;
	
	@FindBy(xpath="//button[@data-sub-item-type='video']")
	public ExtendedWebElement btnSearchForVideo;

	//************ VIDEO CLIP LIST CREATION OBJECTS ************//	

	//************ DASHBOARD TEAM CONTENT OBJECTS ************//	

	@FindBy(id="tabBtn-team")
	public ExtendedWebElement btnDashboardTeamContent;

	@FindBy(xpath="//a[contains(text(), 'Depth Charts')]")
	public ExtendedWebElement btnDashboardTeamContentDepthCharts;

	@FindBy(id="tabBtn-team-_-mlb")
	public ExtendedWebElement btnDashboardTeamContentMLB;

	@FindBy(id="tabBtn-team-_-mlbcom")
	public ExtendedWebElement btnDashboardTeamContentMLBcom;

	@FindBy(id="tabBtn-team-_-mlb_network")
	public ExtendedWebElement btnDashboardTeamContentMLBNetwork;

	@FindBy(id="tabBtn-team-_-ari")
	public ExtendedWebElement btnDashboardTeamContentArizonaDiamondbacks;

	@FindBy(id="tabBtn-team-_-atl")
	public ExtendedWebElement btnDashboardTeamContentAtlantaBraves;

	@FindBy(id="tabBtn-team-_-bal")
	public ExtendedWebElement btnDashboardTeamContentBaltimoreOrioles;

	@FindBy(id="tabBtn-team-_-bos")
	public ExtendedWebElement btnDashboardTeamContentBostonRedSox;

	@FindBy(id="tabBtn-team-_-chc")
	public ExtendedWebElement btnDashboardTeamContentChicagoCubs;

	@FindBy(id="tabBtn-team-_-cws")
	public ExtendedWebElement btnDashboardTeamContentChicagoWhiteSox;

	@FindBy(id="tabBtn-team-_-cin")
	public ExtendedWebElement btnDashboardTeamContentCincinnatiReds;

	@FindBy(id="tabBtn-team-_-cle")
	public ExtendedWebElement btnDashboardTeamContentClevelandIndians;

	@FindBy(id="tabBtn-team-_-col")
	public ExtendedWebElement btnDashboardTeamContentColoradoRockies;

	@FindBy(id="tabBtn-team-_-det")
	public ExtendedWebElement btnDashboardTeamContentDetroitTigers;

	@FindBy(id="tabBtn-team-_-hou")
	public ExtendedWebElement btnDashboardTeamContentHoustonAstros;

	@FindBy(id="tabBtn-team-_-kc")
	public ExtendedWebElement btnDashboardTeamContentKansasCityRoyals;

	@FindBy(id="tabBtn-team-_-ana")
	public ExtendedWebElement btnDashboardTeamContentLosAngelesAngels;

	@FindBy(id="tabBtn-team-_-la")
	public ExtendedWebElement btnDashboardTeamContentLosAngelesDodgers;

	@FindBy(id="tabBtn-team-_-mia")
	public ExtendedWebElement btnDashboardTeamContentMiamiMarlins;

	@FindBy(id="tabBtn-team-_-mil")
	public ExtendedWebElement btnDashboardTeamContentMilwaukeeBrewers;

	@FindBy(id="tabBtn-team-_-min")
	public ExtendedWebElement btnDashboardTeamContentMinnesotaTwins;

	@FindBy(id="tabBtn-team-_-nym")
	public ExtendedWebElement btnDashboardTeamContentNewYorkMets;

	@FindBy(id="tabBtn-team-_-nyy")
	public ExtendedWebElement btnDashboardTeamContentNewYorkYankees;

	@FindBy(id="tabBtn-team-_-oak")
	public ExtendedWebElement btnDashboardTeamContentOaklandAthletics;

	@FindBy(id="tabBtn-team-_-phi")
	public ExtendedWebElement btnDashboardTeamContentPhiladelphiaPhillies;

	@FindBy(id="tabBtn-team-_-pit")
	public ExtendedWebElement btnDashboardTeamContentPittsburghPirates;

	@FindBy(id="tabBtn-team-_-sd")
	public ExtendedWebElement btnDashboardTeamContentSanDiegoPadres;

	@FindBy(id="tabBtn-team-_-sf")
	public ExtendedWebElement btnDashboardTeamContentSanFranciscoGiants;

	@FindBy(id="tabBtn-team-_-sea")
	public ExtendedWebElement btnDashboardTeamContentSeattleMariners;

	@FindBy(id="tabBtn-team-_-stl")
	public ExtendedWebElement btnDashboardTeamContentSaintLouisCardinals;

	@FindBy(id="tabBtn-team-_-tb")
	public ExtendedWebElement btnDashboardTeamContentTampaBayRays;

	@FindBy(id="tabBtn-team-_-tex")
	public ExtendedWebElement btnDashboardTeamContentTexasRangers;

	@FindBy(id="tabBtn-team-_-tor")
	public ExtendedWebElement btnDashboardTeamContentTorontoBlueJays;

	@FindBy(id="tabBtn-team-_-was")
	public ExtendedWebElement btnDashboardTeamContentWashingtonNationals;

	//************ DASHBOARD TEAM CONTENT OBJECTS ************//	

	//************ DASHBOARD GAME CONTENT OBJECTS ************//	

	@FindBy(id="tabBtn-game")
	public ExtendedWebElement btnDashboardGameContent;

	@FindBy(id="dashDayBrowse")
	public ExtendedWebElement btnDashboardGameContentChangeDate;

	@FindBy(xpath="//a[contains(text(), 'Probables')]")
	public ExtendedWebElement btnDashboardGameContentProbables;

	@FindBy(xpath="//a[contains(text(), 'Lineup')]")
	public ExtendedWebElement btnDashboardGameContentLineup;

	@FindBy(xpath="//ul[@id='gameUl'][@class='ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all'][@role='tablist']")
	public ExtendedWebElement gameContentGamesFieldDataPosition;

	//************ DASHBOARD GAME CONTENT OBJECTS ************//	

	//************ DASHBOARD TEAM CONTENT DEPTH CHART OBJECTS ************//	

	@FindBy(xpath="//div[@class='reloadIcon rosterControlIcons triggerAble']")
	public ExtendedWebElement iconDepthChartRosterControlsReSync;

	@FindBy(xpath="//div[@class='addRoster rosterControlIcons triggerAble']")
	public ExtendedWebElement iconDepthChartRosterControlsAddPlayer;

	@FindBy(xpath="//button[contains(text(), 'Save Depth Chart')]")
	public ExtendedWebElement btnSaveDepthChart;

	@FindBy(xpath="//div[@class='depthChartSlots']")
	public ExtendedWebElement depthChartsFieldDataPositionDescription;

	//************ DASHBOARD TEAM CONTENT DEPTH CHART OBJECTS ************//	

	//************ DASHBOARD TEAM CONTENT PROBABLES OBJECTS ************//	

	@FindBy(xpath="//a[contains(text(), 'Probables')]")
	public ExtendedWebElement btnDashboardTeamContentProbables;

	@FindBy(xpath="//button[contains(text(), 'Save Probables')]")
	public ExtendedWebElement btnSaveProbables;

	@FindBy(xpath="//div[@class='probableEntries']")
	public ExtendedWebElement probablesFieldDataPositionDescription;

	//************ DASHBOARD TEAM CONTENT PROBABLES OBJECTS ************//	
	
	//************ DASHBOARD GAME CONTENT PROBABLES OBJECTS ************//	

	@FindBy(xpath="//div[@class='probableVsEntry ']")
	public ExtendedWebElement probablesGameContentFieldDataPositionDescription;

	//************ DASHBOARD GAME CONTENT PROBABLES OBJECTS ************//	
	
	//************ DASHBOARD GAME CONTENT LINEUP OBJECTS ************//	

	@FindBy(xpath="//button[contains(text(), 'Unlock')]")
	public ExtendedWebElement btnUnlock;

	@FindBy(xpath="//div[@class='collectionPanel positionRelative ui-tabs-panel ui-widget-content ui-corner-bottom lineupParent']")
	public ExtendedWebElement lineupGameContentFieldDataPositionDescription;

	@FindBy(xpath="//div[@class='lineupColumn']")
	public ExtendedWebElement lineupGameContentFieldDataPositionDescription2;

	@FindBy(xpath="//div[@class='ac-holder'][@style='width:30px;']")
	public ExtendedWebElement lineupGameContentFieldDataPositionSetDescription;

	@FindBy(xpath="//div[@class='bit-box'][@data-tag-type='baseballpositions']")
	public ExtendedWebElement lineupGameContentFieldDataPositionPlayerTypeExistingIndicator;

	@FindBy(xpath="//button[contains(text(), 'Save')]")
	public ExtendedWebElement btnLineupSave;

	@FindBy(xpath="//button[contains(text(), 'To Beta')]")
	public ExtendedWebElement btnLineupToBeta;

	@FindBy(xpath="//button[contains(text(), 'To Prod')]")
	public ExtendedWebElement btnLineupToProd;

	@FindBy(xpath="//div[@class='awayRemove1 removeLineupEntry triggerAble']")
	public ExtendedWebElement btnLineupDeleteEntryAway1;

	@FindBy(xpath="//div[@class='awayRemove2 removeLineupEntry triggerAble']")
	public ExtendedWebElement btnLineupDeleteEntryAway2;

	@FindBy(xpath="//div[@class='awayRemove3 removeLineupEntry triggerAble']")
	public ExtendedWebElement btnLineupDeleteEntryAway3;

	@FindBy(xpath="//div[@class='awayRemove4 removeLineupEntry triggerAble']")
	public ExtendedWebElement btnLineupDeleteEntryAway4;

	@FindBy(xpath="//div[@class='awayRemove5 removeLineupEntry triggerAble']")
	public ExtendedWebElement btnLineupDeleteEntryAway5;

	@FindBy(xpath="//div[@class='awayRemove6 removeLineupEntry triggerAble']")
	public ExtendedWebElement btnLineupDeleteEntryAway6;

	@FindBy(xpath="//div[@class='awayRemove7 removeLineupEntry triggerAble']")
	public ExtendedWebElement btnLineupDeleteEntryAway7;

	@FindBy(xpath="//div[@class='awayRemove8 removeLineupEntry triggerAble']")
	public ExtendedWebElement btnLineupDeleteEntryAway8;

	@FindBy(xpath="//div[@class='awayRemove9 removeLineupEntry triggerAble']")
	public ExtendedWebElement btnLineupDeleteEntryAway9;

	@FindBy(xpath="//div[@class='awayRemoveSP removeLineupEntry triggerAble']")
	public ExtendedWebElement btnLineupDeleteEntryAway10;

	@FindBy(xpath="//div[@class='homeRemove1 removeLineupEntry triggerAble']")
	public ExtendedWebElement btnLineupDeleteEntryHome1;

	@FindBy(xpath="//div[@class='homeRemove2 removeLineupEntry triggerAble']")
	public ExtendedWebElement btnLineupDeleteEntryHome2;

	@FindBy(xpath="//div[@class='homeRemove3 removeLineupEntry triggerAble']")
	public ExtendedWebElement btnLineupDeleteEntryHome3;

	@FindBy(xpath="//div[@class='homeRemove4 removeLineupEntry triggerAble']")
	public ExtendedWebElement btnLineupDeleteEntryHome4;

	@FindBy(xpath="//div[@class='homeRemove5 removeLineupEntry triggerAble']")
	public ExtendedWebElement btnLineupDeleteEntryHome5;

	@FindBy(xpath="//div[@class='homeRemove6 removeLineupEntry triggerAble']")
	public ExtendedWebElement btnLineupDeleteEntryHome6;

	@FindBy(xpath="//div[@class='homeRemove7 removeLineupEntry triggerAble']")
	public ExtendedWebElement btnLineupDeleteEntryHome7;

	@FindBy(xpath="//div[@class='homeRemove8 removeLineupEntry triggerAble']")
	public ExtendedWebElement btnLineupDeleteEntryHome8;

	@FindBy(xpath="//div[@class='homeRemove9 removeLineupEntry triggerAble']")
	public ExtendedWebElement btnLineupDeleteEntryHome9;

	@FindBy(xpath="//div[@class='homeRemoveSP removeLineupEntry triggerAble']")
	public ExtendedWebElement btnLineupDeleteEntryHome10;

	@FindBy(xpath="//div[@class='hpRemove removeLineupEntry triggerAble']")
	public ExtendedWebElement btnLineupDeleteEntryOfficialHP;

	@FindBy(xpath="//div[@class='1bRemove removeLineupEntry triggerAble']")
	public ExtendedWebElement btnLineupDeleteEntryOfficial1B;

	@FindBy(xpath="//div[@class='2bRemove removeLineupEntry triggerAble']")
	public ExtendedWebElement btnLineupDeleteEntryOfficial2B;

	@FindBy(xpath="//div[@class='3bRemove removeLineupEntry triggerAble']")
	public ExtendedWebElement btnLineupDeleteEntryOfficial3B;

	@FindBy(xpath="//div[@class='lfRemove removeLineupEntry triggerAble']")
	public ExtendedWebElement btnLineupDeleteEntryOfficialLF;

	@FindBy(xpath="//div[@class='rfRemove removeLineupEntry triggerAble']")
	public ExtendedWebElement btnLineupDeleteEntryOfficialRF;

	@FindBy(xpath="//div[@class='osRemove removeLineupEntry triggerAble']")
	public ExtendedWebElement btnLineupDeleteEntryOfficialOS;
	
	//************ DASHBOARD GAME CONTENT LINEUP OBJECTS ************//	
	
	
	//************ BEGIN FUNCTIONS ************//	
	//************ BEGIN FUNCTIONS ************//	
	//************ BEGIN FUNCTIONS ************//	
	//************ BEGIN FUNCTIONS ************//	
	//************ BEGIN FUNCTIONS ************//	
	//************ BEGIN FUNCTIONS ************//	
	//************ BEGIN FUNCTIONS ************//	
	//************ BEGIN FUNCTIONS ************//	
	//************ BEGIN FUNCTIONS ************//	
	
	public void testGoogleSearch() {
		  driver.get("http://www.google.com/xhtml");
		  pause(10);  // Let the user actually see something!
		  WebElement searchBox = driver.findElement(By.name("q"));
		  searchBox.sendKeys("ChromeDriver");
		  searchBox.submit();
		  pause(10);  // Let the user actually see something!
		  driver.quit();
		}
	
	public void login(String username, String password, String profile) throws AWTException {
		if (isElementPresent(txtUsername) == true) {
		type(txtUsername, username);
		type(txtUserPassword, password);
		click(btnSubmit);
		if (isElementPresent(selProfile) == true) {
		select(selProfile, profile);
		click(btnSubmitProfile);
	}
		Assert.assertTrue("Profile label was not found! Login operation is not successful!", isElementPresent(headerLabel, 60));
		Assert.assertEquals("Profile name is not match!", profile, headerLabel.getText().toLowerCase());
	}
	}

	public void oldUIToNewUI(String majorVSMinor) {
	if (isElementPresent(dropDownSelectSite,10) == true) {
			click(dropDownSelectSite);
	if (majorVSMinor == "mlb") {
		click(dropDownSelectMLB);
	}
	if (majorVSMinor == "milb") {
		click(dropDownSelectMiLB);
	}
	}
	}
	
	public void testPhotoFileDialog() throws AWTException {
		pause(1);
		clickPosition(760,130);
		pause(1);
		clickPosition(760,130);
		pause(1);
		pressT();
		pressE();
		pressS();
		pressT();
		pressP();
		pressH();
		pressO();
		pressT();
		pressO();
		press0();
		press0();
		press2();
		pressPeriod();
		pause(3);
		pressEnter();
		pause(3);
		clickPosition(500, 320);
		pause(1);
		pressEnter();
		pause(1);
	}

	public void testPhotoFileDialog001() throws AWTException {

		Robot robot = new Robot();
		pause(1);
		clickPosition(1215, 10);
		pause(1);
		clickPosition(950, 35);
		pause(1);

		pressT();
		pressE();
		pressS();
		pressT();
		pressP();
		pressH();
		pressO();
		pressT();
		pressO();
		press0();
		press0();
		press2();
		pressPeriod();

		pause(3);
		clickPosition(940, 95);
		pause(1);
		clickPosition(300, 400);
		pause(3);
		clickPosition(1215, 10);
		pause(1);
		clickPosition(1215, 40);
		pause(1);
		robot.mouseMove(1215, 10);
		pause(1);
	}

	public void useTagTool(String mainURL, String tagToolPlayer) throws InterruptedException, AWTException {
//		Selenium seleniumTagTool = new WebDriverBackedSelenium(driver, mainURL);
		click(BtnTagTool);
		click(CheckboxTagToolAdvancedFields);
		click(BtnTagToolChangeDate);
		pause(1);
		click(BtnTagToolSelectCurrentDate);
		pause(1);
		pressEnter();
		pause(1);
		pressTab();
		pause(1);
		sendKeys(tagToolPlayer);
		pause(1);
		pressTab();
		pause(1);
		pressTab();
		pressA();
		pause(1);
		pressEnter();
		pause(1);
		pressA();
		pause(1);
		pressEnter();
		click(BtnApplyTagsAndClose);	
	}

	public void useTagToolNew(String mainURL, String tagToolPlayer) throws InterruptedException, AWTException {
//		Selenium seleniumTagTool = new WebDriverBackedSelenium(driver, mainURL);
		click(BtnTagTool);
		click(CheckboxTagToolAdvancedFields);
		click(BtnTagToolChangeDate);
		click(BtnTagToolSelectCurrentDate);
		pause(0.5);
		pressEnter();
		pause(1);
		pressTab();
		pause(1);
		sendKeys(tagToolPlayer);
		pause(1);
		pressTab();
		pause(1);
		pressTab();
		pressA();
		pause(1);
		pressEnter();
		pause(1);
		pressA();
		pause(1);
		pressEnter();
		click(BtnApplyTagsAndClose);	
	}

	public void saveItemAndPublishToBeta() throws AWTException {
		click(BtnSave);
		pause(1);
		click(BtnToBeta);
		Assert.assertTrue("Item Has Not Been Published To Beta!", isElementPresent(statusPublishComplete, 600));
		if (isElementPresent(statusPublishComplete) == true) {
		deleteCreatedItem();
		}		
	}
	
	public void saveItemAndPublishToProd() throws AWTException{
		click(BtnSave);
		pause(1);
		click(BtnToProd);
		click(BtnToProdConfirm);
		Assert.assertTrue("Item Has Not Been Published To Prod!", isElementPresent(statusPublishComplete, 600));
		if (isElementPresent(statusPublishComplete) == true) {
		deleteCreatedItem();
		}		
	}
	
	public void saveItemAndPublishToBetaWithoutDelete() throws AWTException {
		click(BtnSave);
		pause(1);
		click(BtnToBeta);
		Assert.assertTrue("Item Has Not Been Published To Beta!", isElementPresent(statusPublishComplete, 600));
		if (isElementPresent(statusPublishComplete) == true) {
		}		
	}
	
	public void saveItemAndPublishToProdWithoutDelete() throws AWTException{
		click(BtnSave);
		pause(1);
		click(BtnToProd);
		click(BtnToProdConfirm);
		Assert.assertTrue("Item Has Not Been Published To Prod!", isElementPresent(statusPublishComplete, 600));
		if (isElementPresent(statusPublishComplete) == true) {
		}		
	}
	
	public void deleteCreatedItem() throws AWTException {
		String valueItemNumber = StatusPublishComplete.getText();
		int valueItemNumberTrimmedHashTagValue = valueItemNumber.indexOf("#");
		String valueItemNumberTrimmed = valueItemNumber.substring(valueItemNumberTrimmedHashTagValue+1);
		click(FieldMainSearch);		
		pause(1);
		type(FieldMainSearch, valueItemNumberTrimmed);
		click(btnSearch);
		pause(3);
		WebElement btnItemSearchedForDeletion = panelSearchTileInfo.getElement().findElement(By.xpath("h4[contains(text(), '" + valueItemNumberTrimmed + "')]"));
		btnItemSearchedForDeletion.click();
		click(deleteItem);
		click(deleteItemConfirm);
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
	
	public void selectDashboard()	{
		click(btnMenuBarDashboard);
	}

	public void selectTeamContent()	{
		selectDashboard();
		click(btnDashboardTeamContent);
	}
	
	public void selectGameContent()	{
		selectDashboard();
		click(btnDashboardGameContent);
	}
	
	public void selectHomePageUploadPhotos()	{
//		click(dropDownListNewItem);
		click(BtnHomePageUploadPhotos);
//		pause(60);
	}
	
	public void uploadPhotos(String mainURLCall, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{

		click(BtnMultipleCutUploadAddFiles);
		testPhotoFileDialog();
		click(BtnSaveAllAndPublishToProd);
		click(BtnSendToProd);
		click(BtnClose);
		String valuePhotoAsset = StatusPublishComplete.getText();
		String valuePhotoAssetTrimmed = valuePhotoAsset.substring(15);
		type(FieldMainSearch, valuePhotoAssetTrimmed);
		click(btnSearch);
		pause(3);
		clickPosition(980, 255);
		Assert.assertTrue("Cut Width Value Doesn't Exist! :)", isElementPresent(FieldPhotoAssetCutWidth001, 5));
		Assert.assertTrue("Cut Height Value Doesn't Exist! :)", isElementPresent(FieldPhotoAssetCutHeight001, 5));
		pause(5);

	}

	public void testCMSTool (int coordinateX, int coordinateY) throws AWTException {
		pause(3);
		clickPosition(coordinateX, coordinateY);
//		pause(1);
		clickPosition(coordinateX, coordinateY);
		pause(1);
		pressT();
		pressE();
		pressS();
		pressT();
		pause(1);
	}
	
	public void testCMSToolNewFunctionHTML () {
		WebElement testBeforeElement = driver.findElement(By.xpath("//div[contains(@class, 'cke_reset') and not(contains(@class, 'cke_editor_htmlScrubber'))]/div[@class='cke_inner cke_reset']/div/iframe"));
		testBeforeElement.sendKeys(Keys.TAB);
		testBeforeElement.sendKeys("Hi Snehal!  Hi Chris!  Let's see if this works!");

	}
	
	public void testCMSToolNewFunctionWYSIWYG () {
		WebElement testBeforeElement = driver.findElement(By.xpath("//textarea[@class='cke_source cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr']"));
		testBeforeElement.sendKeys(Keys.TAB);
		testBeforeElement.sendKeys("Hi Snehal!  Hi Chris!  Let's see if this works!");

	}
	
	public void testCMSToolWithClipBoard (String testCMSToolWithClipBoardContents, int coordinateX, int coordinateY) throws AWTException {
		pause(1);
		clickPosition(coordinateX, coordinateY);
		pause(1);
		clickPosition(coordinateX, coordinateY);
		pause(1);
		clipBoardCopy(testCMSToolWithClipBoardContents);
		clipBoardPaste();
		pause(1);

	}
	
	public void depthChartsBaseState(String mainURLCall) throws InterruptedException, AWTException	{
		selectTeamContent();
		click(btnDashboardTeamContentWashingtonNationals);
		click(btnDashboardTeamContentArizonaDiamondbacks);
		click(btnDashboardTeamContentDepthCharts);
		pause(5);
		pause(0.5);
		clickPosition(750,250);
		clickPosition(750,250);
		pause(0.5);
	}

	public void depthChartsAddPlayers(String mainURLCall) throws InterruptedException, AWTException	{
		depthChartsBaseState(hostName);
		List<WebElement> FieldDataPosition = depthChartsFieldDataPositionDescription.getElement().findElements(By.xpath("//input[@class='autocomplete-maininput processedYes'][@type='text'][@style='width:240px']"));
		logger.info(FieldDataPosition.size());
		int NumberOfFieldDataPositionPlayerTextInputBoxes = FieldDataPosition.size();
		for (int a = 0; a < NumberOfFieldDataPositionPlayerTextInputBoxes; a++) {
			(FieldDataPosition.get(a)).click();
			pause(0.5);
			(FieldDataPosition.get(a)).sendKeys("6");
			pause(0.5);
			(FieldDataPosition.get(a)).sendKeys(Keys.ARROW_DOWN);
//			pause(0.5);
			for (int b = (a+a); b > a; b--) {
			(FieldDataPosition.get(a)).sendKeys(Keys.ARROW_DOWN);
//			pause(0.5);
			}
			(FieldDataPosition.get(a)).sendKeys(Keys.ARROW_UP);
//			pause(0.5);
			(FieldDataPosition.get(a)).sendKeys(Keys.ENTER);
			pause(0.5);
			(FieldDataPosition.get(a)).click();
			pause(0.5);
			(FieldDataPosition.get(a)).sendKeys("5");
			pause(0.5);
			(FieldDataPosition.get(a)).sendKeys(Keys.ARROW_DOWN);
//			pause(0.5);
			for (int b = (a+a); b > a; b--) {
			(FieldDataPosition.get(a)).sendKeys(Keys.ARROW_DOWN);
//			pause(0.5);
			}
			(FieldDataPosition.get(a)).sendKeys(Keys.ARROW_UP);
//			pause(0.5);
			(FieldDataPosition.get(a)).sendKeys(Keys.ENTER);
			pause(0.5);
		}
		click(btnSaveDepthChart);		
		List<WebElement> FieldDataPositionDeleteButtons = depthChartsFieldDataPositionDescription.getElement().findElements(By.xpath("//div[@class='removePlayerDepthChart triggerAble ']"));
		int depthChartPlayerValueExpectedAfterAdd = 22;
		int depthChartsPlayerNumberOfAddButtonsAfter = FieldDataPositionDeleteButtons.size();	
		Assert.assertEquals((depthChartsPlayerNumberOfAddButtonsAfter + " out of "+ depthChartPlayerValueExpectedAfterAdd +" Depth Chart Player Adds were performed."), depthChartPlayerValueExpectedAfterAdd, depthChartsPlayerNumberOfAddButtonsAfter);
	}

	public void depthChartsRepositionPlayers(String mainURLCall) throws InterruptedException, AWTException	{
		depthChartsBaseState(hostName);
		List<WebElement> FieldDataPositionDepthUp = depthChartsFieldDataPositionDescription.getElement().findElements(By.xpath("//div[@class='depthUp triggerAble ']"));
		List<WebElement> FieldDataPositionDepthDown = depthChartsFieldDataPositionDescription.getElement().findElements(By.xpath("//div[@class='depthDown triggerAble ']"));

		int depthChartsPlayerNumberOfDepthUpButtons = FieldDataPositionDepthUp.size();
		int depthChartsPlayerNumberOfDepthDownButtons = FieldDataPositionDepthDown.size();

		for (int a = 0; a < depthChartsPlayerNumberOfDepthDownButtons; a++) {
			WebElement depthChartsPlayerDepthDownButton = FieldDataPositionDepthDown.get(a);
			depthChartsPlayerDepthDownButton.click();
		}

		for (int a = 0; a < depthChartsPlayerNumberOfDepthUpButtons; a++) {
			WebElement depthChartsPlayerDepthUpButton = FieldDataPositionDepthUp.get(a);
			depthChartsPlayerDepthUpButton.click();
		}
		click(btnSaveDepthChart);
		}

	public void depthChartsDeletePlayers(String mainURLCall) throws InterruptedException, AWTException	{
		depthChartsBaseState(hostName);
		List<WebElement> FieldDataPosition = depthChartsFieldDataPositionDescription.getElement().findElements(By.xpath("//div[@class='removePlayerDepthChart triggerAble ']"));
		int depthChartsPlayerNumberOfDeleteButtons = FieldDataPosition.size();
		for (int a = 0; a < depthChartsPlayerNumberOfDeleteButtons; a++) {
			WebElement depthChartsPlayerDeleteButton = FieldDataPosition.get(a);
			depthChartsPlayerDeleteButton.click();
		}
		click(btnSaveDepthChart);
		}

	public void probablesTeamContentBaseState(String mainURLCall) throws InterruptedException, AWTException	{
		selectTeamContent();
		click(btnDashboardTeamContentWashingtonNationals);
		click(btnDashboardTeamContentArizonaDiamondbacks);
		click(btnDashboardTeamContentProbables);
		pause(5);
		pause(0.5);
		clickPosition(750,250);
		clickPosition(750,250);
		pause(0.5);
	}

	public void probablesTeamContentAddPlayers(String mainURLCall) throws InterruptedException, AWTException	{
		probablesTeamContentBaseState(hostName);
		List<WebElement> FieldDataPosition = probablesFieldDataPositionDescription.getElement().findElements(By.xpath("//input[@class='autocomplete-maininput processedYes'][@type='text'][@style='width:220px']"));
		logger.info(FieldDataPosition.size());
		int NumberOfFieldDataPositionPlayerTextInputBoxes = FieldDataPosition.size();

		for (int a = 0; a < NumberOfFieldDataPositionPlayerTextInputBoxes; a++) {
			(FieldDataPosition.get(a)).click();
//			pause(0.5);
			(FieldDataPosition.get(a)).sendKeys(Keys.ARROW_DOWN);
//			pause(0.5);
			for (int b = (a+a); b > a; b--) {
			(FieldDataPosition.get(a)).sendKeys(Keys.ARROW_DOWN);
//			pause(0.5);
			}
			(FieldDataPosition.get(a)).sendKeys(Keys.ARROW_UP);
//			pause(0.5);
			(FieldDataPosition.get(a)).sendKeys(Keys.TAB);
			pause(0.5);
		}
		click(btnSaveProbables);		
	}

	public void probablesTeamContentRepositionPlayers(String mainURLCall) throws InterruptedException, AWTException	{
		probablesTeamContentBaseState(hostName);
		List<WebElement> FieldDataPositionProbablesUp = probablesFieldDataPositionDescription.getElement().findElements(By.xpath("//div[@class=' triggerAble probablesUp probablesUpShow']"));
		List<WebElement> FieldDataPositionProbablesDown = probablesFieldDataPositionDescription.getElement().findElements(By.xpath("//div[@class=' triggerAble probablesDown probablesDownShow']"));

		int probablesPlayerNumberOfDepthUpButtons = FieldDataPositionProbablesUp.size();
		int probablesPlayerNumberOfDepthDownButtons = FieldDataPositionProbablesDown.size();

		for (int a = 0; a < probablesPlayerNumberOfDepthDownButtons; a++) {
			WebElement probablesPlayerDepthDownButton = FieldDataPositionProbablesDown.get(a);
			probablesPlayerDepthDownButton.click();
			pause(0.5);
		}

		for (int a = 0; a < probablesPlayerNumberOfDepthUpButtons; a++) {
			WebElement probablesPlayerDepthUpButton = FieldDataPositionProbablesUp.get(a);
			probablesPlayerDepthUpButton.click();
			pause(0.5);
		}
		click(btnSaveProbables);
		}

	public void probablesTeamContentDeletePlayers(String mainURLCall) throws InterruptedException, AWTException	{
		probablesTeamContentBaseState(hostName);
		List<WebElement> FieldDataPosition = probablesFieldDataPositionDescription.getElement().findElements(By.xpath("//div[@class='removeProbableEntry triggerAble']"));
		int depthChartsPlayerNumberOfDeleteButtons = FieldDataPosition.size();
		for (int a = 0; a < depthChartsPlayerNumberOfDeleteButtons; a++) {
			WebElement depthChartsPlayerDeleteButton = FieldDataPosition.get(a);
			depthChartsPlayerDeleteButton.click();
		}
		click(btnSaveProbables);
		}

	public void probablesGameContentBaseState(String mainURLCall) throws InterruptedException, AWTException	{
		selectGameContent();
		List<WebElement> gameContentSelectGame = gameContentGamesFieldDataPosition.getElement().findElements(By.xpath("//a[contains(text(), ' at ')]"));
		(gameContentSelectGame.get(0)).click();
		click(btnDashboardGameContentProbables);
		pause(0.5);
		clickPosition(750,250);
		clickPosition(750,250);
		pause(0.5);
	}

	public void probablesGameContentAddPlayers(String mainURLCall) throws InterruptedException, AWTException	{
		probablesGameContentBaseState(hostName);
		List<WebElement> FieldDataPosition = probablesGameContentFieldDataPositionDescription.getElement().findElements(By.xpath("//input[@class='autocomplete-maininput processedYes'][@type='text'][@style='width:280px']"));
		logger.info(FieldDataPosition.size());

		int NumberOfFieldDataPositionPlayerTextInputBoxes = FieldDataPosition.size();

		for (int a = 0; a < NumberOfFieldDataPositionPlayerTextInputBoxes; a++) {
			(FieldDataPosition.get(a)).click();
//			pause(0.5);
			(FieldDataPosition.get(a)).sendKeys(Keys.ARROW_DOWN);
//			pause(0.5);
			for (int b = (a+a); b > a; b--) {
			(FieldDataPosition.get(a)).sendKeys(Keys.ARROW_DOWN);
//			pause(0.5);
			}
			(FieldDataPosition.get(a)).sendKeys(Keys.ARROW_UP);
//			pause(0.5);
			(FieldDataPosition.get(a)).sendKeys(Keys.TAB);
			pause(0.5);
		}
		click(btnSaveProbables);		
	}

	public void probablesGameContentDeletePlayers(String mainURLCall) throws InterruptedException, AWTException	{
		probablesGameContentBaseState(hostName);
		List<WebElement> FieldDataPosition = probablesGameContentFieldDataPositionDescription.getElement().findElements(By.xpath("//div[@class='removeProbableEntry triggerAble']"));
		int depthChartsPlayerNumberOfDeleteButtons = FieldDataPosition.size();
		for (int a = 0; a < depthChartsPlayerNumberOfDeleteButtons; a++) {
			WebElement depthChartsPlayerDeleteButton = FieldDataPosition.get(a);
			depthChartsPlayerDeleteButton.click();
		}
		click(btnSaveProbables);
		}

	public void lineupGameContentBaseState(String mainURLCall) throws InterruptedException, AWTException	{
		selectGameContent();
		List<WebElement> gameContentSelectGame = gameContentGamesFieldDataPosition.getElement().findElements(By.xpath("//a[contains(text(), ' at ')]"));
		(gameContentSelectGame.get(2)).click();
		click(btnDashboardGameContentLineup);
		pause(0.5);
		clickPosition(750,250);
		clickPosition(750,250);
		pause(0.5);
	}

	public void lineupGameContentAddPlayers(String mainURLCall) throws InterruptedException, AWTException	{
		lineupGameContentBaseState(hostName);
		List<WebElement> FieldDataPosition = lineupGameContentFieldDataPositionDescription.getElement().findElements(By.xpath("//input[@class='autocomplete-maininput processedYes'][@type='text'][@style='width:220px']"));
		List<WebElement> FieldDataPosition2 = lineupGameContentFieldDataPositionDescription.getElement().findElements(By.xpath("//input[@class='autocomplete-maininput processedYes'][@type='text'][@style='width:280px']"));

		int NumberOfFieldDataPositionPlayerTextInputBoxes = FieldDataPosition.size();
		int NumberOfFieldDataPosition2PlayerTextInputBoxes = FieldDataPosition2.size();

/*
		if (isElementPresent(btnUnlock) == true) {

		while (isElementPresent(btnUnlock) == true) {
			click(btnUnlock);
		}
		}
*/		
		for (int a = 0; a < NumberOfFieldDataPositionPlayerTextInputBoxes; a++) {

			if (NumberOfFieldDataPositionPlayerTextInputBoxes == 20) {
				
			if (a == 0) {
				(FieldDataPosition.get(a)).click();				
			}
			
			if (a == 10) {
				(FieldDataPosition.get(a)).click();				
			}
			
			(FieldDataPosition.get(a)).sendKeys(Keys.ARROW_DOWN);
			for (int b = (a+1); b > 0; b--) {
			(FieldDataPosition.get(a)).sendKeys(Keys.ARROW_DOWN);
			}
			(FieldDataPosition.get(a)).sendKeys(Keys.ARROW_UP);
			(FieldDataPosition.get(a)).sendKeys(Keys.ENTER);
			pause(0.5);
			}

			if (NumberOfFieldDataPositionPlayerTextInputBoxes == 18) {
				
			if (a == 0) {
				(FieldDataPosition.get(a)).click();				
			}
			
			if (a == 9) {
				(FieldDataPosition.get(a)).click();				
			}
			
			(FieldDataPosition.get(a)).sendKeys(Keys.ARROW_DOWN);
			for (int b = (a+1); b > 0; b--) {
			(FieldDataPosition.get(a)).sendKeys(Keys.ARROW_DOWN);
			}
			(FieldDataPosition.get(a)).sendKeys(Keys.ARROW_UP);
			(FieldDataPosition.get(a)).sendKeys(Keys.ENTER);
			pause(0.5);
			}

		}

		List<WebElement> FieldDataPositionPlayerType2Child = lineupGameContentFieldDataPositionDescription.getElement().findElements(By.xpath("//div[@class='lineupColumn']"));
		List<WebElement> fieldPlayerTypeDataDataSourceAL = (FieldDataPositionPlayerType2Child.get(0).findElements(By.xpath("//div[@data-data-source='baseballPositionsAL']")));
		List<WebElement> fieldPlayerTypeDataDataSourceNL = (FieldDataPositionPlayerType2Child.get(0).findElements(By.xpath("//div[@data-data-source='baseballPositionsNL']")));
		
		if (fieldPlayerTypeDataDataSourceAL.size() == 20) {
			WebElement lineupAwayPlayerPosition1 = fieldPlayerTypeDataDataSourceAL.get(0);
			WebElement lineupAwayPlayerPosition2 = fieldPlayerTypeDataDataSourceAL.get(1);
			WebElement lineupAwayPlayerPosition3 = fieldPlayerTypeDataDataSourceAL.get(2);
			WebElement lineupAwayPlayerPosition4 = fieldPlayerTypeDataDataSourceAL.get(3);
			WebElement lineupAwayPlayerPosition5 = fieldPlayerTypeDataDataSourceAL.get(4);
			WebElement lineupAwayPlayerPosition6 = fieldPlayerTypeDataDataSourceAL.get(5);
			WebElement lineupAwayPlayerPosition7 = fieldPlayerTypeDataDataSourceAL.get(6);
			WebElement lineupAwayPlayerPosition8 = fieldPlayerTypeDataDataSourceAL.get(7);
			WebElement lineupAwayPlayerPosition9 = fieldPlayerTypeDataDataSourceAL.get(8);
			WebElement lineupAwayPlayerPosition10 = fieldPlayerTypeDataDataSourceAL.get(9);
			WebElement lineupHomePlayerPosition1 = fieldPlayerTypeDataDataSourceAL.get(10);
			WebElement lineupHomePlayerPosition2 = fieldPlayerTypeDataDataSourceAL.get(11);
			WebElement lineupHomePlayerPosition3 = fieldPlayerTypeDataDataSourceAL.get(12);
			WebElement lineupHomePlayerPosition4 = fieldPlayerTypeDataDataSourceAL.get(13);
			WebElement lineupHomePlayerPosition5 = fieldPlayerTypeDataDataSourceAL.get(14);
			WebElement lineupHomePlayerPosition6 = fieldPlayerTypeDataDataSourceAL.get(15);
			WebElement lineupHomePlayerPosition7 = fieldPlayerTypeDataDataSourceAL.get(16);
			WebElement lineupHomePlayerPosition8 = fieldPlayerTypeDataDataSourceAL.get(17);
			WebElement lineupHomePlayerPosition9 = fieldPlayerTypeDataDataSourceAL.get(18);
			WebElement lineupHomePlayerPosition10 = fieldPlayerTypeDataDataSourceAL.get(19);
			List<WebElement> PlayerPositionDropDownList = lineupAwayPlayerPosition1.findElements(By.xpath("//input[@class='autocomplete-maininput processedYes'][@style='width:30px']"));
			
			if (lineupAwayPlayerPosition1.getText().toString().equals("P")) {
			}
			else {
				PlayerPositionDropDownList.get(0).click();
				pause(0.5);
				pressP();
				pause(0.5);
				pressEnter();
			}

			if (lineupAwayPlayerPosition2.getText().toString().equals("C")) {
			}
			else {
				PlayerPositionDropDownList.get(1).click();
				pause(0.5);
				pressC();
				pause(0.5);
				pressEnter();
			}

			if (lineupAwayPlayerPosition3.getText().toString().equals("1B")) {
			}
			else {
				PlayerPositionDropDownList.get(2).click();
				pause(0.5);
				press1();
				pressB();
				pause(0.5);
				pressEnter();
			}

			if (lineupAwayPlayerPosition4.getText().toString().equals("2B")) {
			}
			else {
				PlayerPositionDropDownList.get(3).click();
				pause(0.5);
				press2();
				pressB();
				pause(0.5);
				pressEnter();
			}

			if (lineupAwayPlayerPosition5.getText().toString().equals("3B")) {
			}
			else {
				PlayerPositionDropDownList.get(4).click();
				pause(0.5);
				press3();
				pressB();
				pause(0.5);
				pressEnter();
			}

			if (lineupAwayPlayerPosition6.getText().toString().equals("SS")) {
			}
			else {
				PlayerPositionDropDownList.get(5).click();
				pause(0.5);
				pressS();
				pressS();
				pause(0.5);
				pressEnter();
			}

			if (lineupAwayPlayerPosition7.getText().toString().equals("LF")) {
			}
			else {
				PlayerPositionDropDownList.get(6).click();
				pause(0.5);
				pressL();
				pressF();
				pause(0.5);
				pressEnter();
			}

			if (lineupAwayPlayerPosition8.getText().toString().equals("CF")) {
			}
			else {
				PlayerPositionDropDownList.get(7).click();
				pause(0.5);
				pressC();
				pressF();
				pause(0.5);
				pressEnter();
			}

			if (lineupAwayPlayerPosition9.getText().toString().equals("RF")) {
			}
			else {
				PlayerPositionDropDownList.get(8).click();
				pause(0.5);
				pressR();
				pressF();
				pause(0.5);
				pressEnter();
			}

			if (lineupAwayPlayerPosition10.getText().toString().equals("DH")) {
			}
			else {
				PlayerPositionDropDownList.get(9).click();
				pause(0.5);
				pressD();
				pressH();
				pause(0.5);
				pressEnter();
			}

			if (lineupHomePlayerPosition1.getText().toString().equals("P")) {
			}
			else {
				PlayerPositionDropDownList.get(10).click();
				pause(0.5);
				pressP();
				pause(0.5);
				pressEnter();
			}

			if (lineupHomePlayerPosition2.getText().toString().equals("C")) {
			}
			else {
				PlayerPositionDropDownList.get(11).click();
				pause(0.5);
				pressC();
				pause(0.5);
				pressEnter();
			}

			if (lineupHomePlayerPosition3.getText().toString().equals("1B")) {
			}
			else {
				PlayerPositionDropDownList.get(12).click();
				pause(0.5);
				press1();
				pressB();
				pause(0.5);
				pressEnter();
			}

			if (lineupHomePlayerPosition4.getText().toString().equals("2B")) {
			}
			else {
				PlayerPositionDropDownList.get(13).click();
				pause(0.5);
				press2();
				pressB();
				pause(0.5);
				pressEnter();
			}

			if (lineupHomePlayerPosition5.getText().toString().equals("3B")) {
			}
			else {
				PlayerPositionDropDownList.get(14).click();
				pause(0.5);
				press3();
				pressB();
				pause(0.5);
				pressEnter();
			}

			if (lineupHomePlayerPosition6.getText().toString().equals("SS")) {
			}
			else {
				PlayerPositionDropDownList.get(15).click();
				pause(0.5);
				pressS();
				pressS();
				pause(0.5);
				pressEnter();
			}

			if (lineupHomePlayerPosition7.getText().toString().equals("LF")) {
			}
			else {
				PlayerPositionDropDownList.get(16).click();
				pause(0.5);
				pressL();
				pressF();
				pause(0.5);
				pressEnter();
			}

			if (lineupHomePlayerPosition8.getText().toString().equals("CF")) {
			}
			else {
				PlayerPositionDropDownList.get(17).click();
				pause(0.5);
				pressC();
				pressF();
				pause(0.5);
				pressEnter();
			}

			if (lineupHomePlayerPosition9.getText().toString().equals("RF")) {
			}
			else {
				PlayerPositionDropDownList.get(18).click();
				pause(0.5);
				pressR();
				pressF();
				pause(0.5);
				pressEnter();
			}

			if (lineupHomePlayerPosition10.getText().toString().equals("DH")) {
			}
			else {
				PlayerPositionDropDownList.get(19).click();
				pause(0.5);
				pressD();
				pressH();
				pause(0.5);
				pressEnter();
			}
		}

		if (fieldPlayerTypeDataDataSourceNL.size() == 18) {
			WebElement lineupAwayPlayerPosition1 = fieldPlayerTypeDataDataSourceNL.get(0);
			WebElement lineupAwayPlayerPosition2 = fieldPlayerTypeDataDataSourceNL.get(1);
			WebElement lineupAwayPlayerPosition3 = fieldPlayerTypeDataDataSourceNL.get(2);
			WebElement lineupAwayPlayerPosition4 = fieldPlayerTypeDataDataSourceNL.get(3);
			WebElement lineupAwayPlayerPosition5 = fieldPlayerTypeDataDataSourceNL.get(4);
			WebElement lineupAwayPlayerPosition6 = fieldPlayerTypeDataDataSourceNL.get(5);
			WebElement lineupAwayPlayerPosition7 = fieldPlayerTypeDataDataSourceNL.get(6);
			WebElement lineupAwayPlayerPosition8 = fieldPlayerTypeDataDataSourceNL.get(7);
			WebElement lineupAwayPlayerPosition9 = fieldPlayerTypeDataDataSourceNL.get(8);
			WebElement lineupHomePlayerPosition1 = fieldPlayerTypeDataDataSourceNL.get(9);
			WebElement lineupHomePlayerPosition2 = fieldPlayerTypeDataDataSourceNL.get(10);
			WebElement lineupHomePlayerPosition3 = fieldPlayerTypeDataDataSourceNL.get(11);
			WebElement lineupHomePlayerPosition4 = fieldPlayerTypeDataDataSourceNL.get(12);
			WebElement lineupHomePlayerPosition5 = fieldPlayerTypeDataDataSourceNL.get(13);
			WebElement lineupHomePlayerPosition6 = fieldPlayerTypeDataDataSourceNL.get(14);
			WebElement lineupHomePlayerPosition7 = fieldPlayerTypeDataDataSourceNL.get(15);
			WebElement lineupHomePlayerPosition8 = fieldPlayerTypeDataDataSourceNL.get(16);
			WebElement lineupHomePlayerPosition9 = fieldPlayerTypeDataDataSourceNL.get(17);
			List<WebElement> PlayerPositionDropDownList = lineupAwayPlayerPosition1.findElements(By.xpath("//input[@class='autocomplete-maininput processedYes'][@style='width:30px']"));
			
			if (lineupAwayPlayerPosition1.getText().toString().equals("P")) {
			}
			else {
				PlayerPositionDropDownList.get(0).click();
				pause(0.5);
				pressP();
				pause(0.5);
				pressEnter();
			}

			if (lineupAwayPlayerPosition2.getText().toString().equals("C")) {
			}
			else {
				PlayerPositionDropDownList.get(1).click();
				pause(0.5);
				pressC();
				pause(0.5);
				pressEnter();
			}

			if (lineupAwayPlayerPosition3.getText().toString().equals("1B")) {
			}
			else {
				PlayerPositionDropDownList.get(2).click();
				pause(0.5);
				press1();
				pressB();
				pause(0.5);
				pressEnter();
			}

			if (lineupAwayPlayerPosition4.getText().toString().equals("2B")) {
			}
			else {
				PlayerPositionDropDownList.get(3).click();
				pause(0.5);
				press2();
				pressB();
				pause(0.5);
				pressEnter();
			}

			if (lineupAwayPlayerPosition5.getText().toString().equals("3B")) {
			}
			else {
				PlayerPositionDropDownList.get(4).click();
				pause(0.5);
				press3();
				pressB();
				pause(0.5);
				pressEnter();
			}

			if (lineupAwayPlayerPosition6.getText().toString().equals("SS")) {
			}
			else {
				PlayerPositionDropDownList.get(5).click();
				pause(0.5);
				pressS();
				pressS();
				pause(0.5);
				pressEnter();
			}

			if (lineupAwayPlayerPosition7.getText().toString().equals("LF")) {
			}
			else {
				PlayerPositionDropDownList.get(6).click();
				pause(0.5);
				pressL();
				pressF();
				pause(0.5);
				pressEnter();
			}

			if (lineupAwayPlayerPosition8.getText().toString().equals("CF")) {
			}
			else {
				PlayerPositionDropDownList.get(7).click();
				pause(0.5);
				pressC();
				pressF();
				pause(0.5);
				pressEnter();
			}

			if (lineupAwayPlayerPosition9.getText().toString().equals("RF")) {
			}
			else {
				PlayerPositionDropDownList.get(8).click();
				pause(0.5);
				pressR();
				pressF();
				pause(0.5);
				pressEnter();
			}

			if (lineupHomePlayerPosition1.getText().toString().equals("P")) {
			}
			else {
				PlayerPositionDropDownList.get(9).click();
				pause(0.5);
				pressP();
				pause(0.5);
				pressEnter();
			}

			if (lineupHomePlayerPosition2.getText().toString().equals("C")) {
			}
			else {
				PlayerPositionDropDownList.get(10).click();
				pause(0.5);
				pressC();
				pause(0.5);
				pressEnter();
			}

			if (lineupHomePlayerPosition3.getText().toString().equals("1B")) {
			}
			else {
				PlayerPositionDropDownList.get(11).click();
				pause(0.5);
				press1();
				pressB();
				pause(0.5);
				pressEnter();
			}

			if (lineupHomePlayerPosition4.getText().toString().equals("2B")) {
			}
			else {
				PlayerPositionDropDownList.get(12).click();
				pause(0.5);
				press2();
				pressB();
				pause(0.5);
				pressEnter();
			}

			if (lineupHomePlayerPosition5.getText().toString().equals("3B")) {
			}
			else {
				PlayerPositionDropDownList.get(13).click();
				pause(0.5);
				press3();
				pressB();
				pause(0.5);
				pressEnter();
			}

			if (lineupHomePlayerPosition6.getText().toString().equals("SS")) {
			}
			else {
				PlayerPositionDropDownList.get(14).click();
				pause(0.5);
				pressS();
				pressS();
				pause(0.5);
				pressEnter();
			}

			if (lineupHomePlayerPosition7.getText().toString().equals("LF")) {
			}
			else {
				PlayerPositionDropDownList.get(15).click();
				pause(0.5);
				pressL();
				pressF();
				pause(0.5);
				pressEnter();
			}

			if (lineupHomePlayerPosition8.getText().toString().equals("CF")) {
			}
			else {
				PlayerPositionDropDownList.get(16).click();
				pause(0.5);
				pressC();
				pressF();
				pause(0.5);
				pressEnter();
			}

			if (lineupHomePlayerPosition9.getText().toString().equals("RF")) {
			}
			else {
				PlayerPositionDropDownList.get(17).click();
				pause(0.5);
				pressR();
				pressF();
				pause(0.5);
				pressEnter();
			}
		}

		(FieldDataPosition2.get(0)).click();
		for (int c = 0; c < NumberOfFieldDataPosition2PlayerTextInputBoxes; c++) {
			(FieldDataPosition2.get(c)).sendKeys(Keys.ARROW_DOWN);
			for (int d = (c+1); d > 0; d--) {
			(FieldDataPosition2.get(c)).sendKeys(Keys.ARROW_DOWN);
			}
			(FieldDataPosition2.get(c)).sendKeys(Keys.ARROW_UP);
			(FieldDataPosition2.get(c)).sendKeys(Keys.TAB);
			pause(0.5);
		}

		click(btnLineupSave);
		click(btnLineupToBeta);

		List<WebElement> FieldDataPositionPlayerFieldsAfterLineupPopulate = lineupGameContentFieldDataPositionDescription.getElement().findElements(By.xpath("//div[@class='bit-box']"));

		if (fieldPlayerTypeDataDataSourceNL.size() == 18) {
		Assert.assertEquals(("Number of Bit-Box fields after Delete: " + FieldDataPositionPlayerFieldsAfterLineupPopulate.size() + ". Expected number is 46."), FieldDataPositionPlayerFieldsAfterLineupPopulate.size(), 46);		
		}
		if (fieldPlayerTypeDataDataSourceAL.size() == 20) {		
		Assert.assertEquals(("Number of Bit-Box fields after Delete: " + FieldDataPositionPlayerFieldsAfterLineupPopulate.size() + ". Expected number is 50."), FieldDataPositionPlayerFieldsAfterLineupPopulate.size(), 50);		
		}
	}

	public void lineupGameContentDeletePlayers(String mainURLCall) throws InterruptedException, AWTException	{
		lineupGameContentBaseState(hostName);
		List<WebElement> FieldDataPositionPlayerType2Child = lineupGameContentFieldDataPositionDescription.getElement().findElements(By.xpath("//div[@class='lineupColumn']"));
		List<WebElement> fieldPlayerTypeDataDataSourceAL = (FieldDataPositionPlayerType2Child.get(0).findElements(By.xpath("//div[@data-data-source='baseballPositionsAL']")));
		List<WebElement> fieldPlayerTypeDataDataSourceNL = (FieldDataPositionPlayerType2Child.get(0).findElements(By.xpath("//div[@data-data-source='baseballPositionsNL']")));

		if (isElementPresent(btnUnlock) == true) {
		while (isElementPresent(btnUnlock) == true) {
			click(btnUnlock);
		}
		}
		
		if (fieldPlayerTypeDataDataSourceNL.size() == 18) {
			click(btnLineupDeleteEntryAway1);
			click(btnLineupDeleteEntryAway2);
			click(btnLineupDeleteEntryAway3);
			click(btnLineupDeleteEntryAway4);
			click(btnLineupDeleteEntryAway5);
			click(btnLineupDeleteEntryAway6);
			click(btnLineupDeleteEntryAway7);
			click(btnLineupDeleteEntryAway8);
			click(btnLineupDeleteEntryAway9);
			click(btnLineupDeleteEntryHome1);
			click(btnLineupDeleteEntryHome2);
			click(btnLineupDeleteEntryHome3);
			click(btnLineupDeleteEntryHome4);
			click(btnLineupDeleteEntryHome5);
			click(btnLineupDeleteEntryHome6);
			click(btnLineupDeleteEntryHome7);
			click(btnLineupDeleteEntryHome8);
			click(btnLineupDeleteEntryHome9);
		}
						
		if (fieldPlayerTypeDataDataSourceAL.size() == 20) {
			click(btnLineupDeleteEntryAway1);
			click(btnLineupDeleteEntryAway2);
			click(btnLineupDeleteEntryAway3);
			click(btnLineupDeleteEntryAway4);
			click(btnLineupDeleteEntryAway5);
			click(btnLineupDeleteEntryAway6);
			click(btnLineupDeleteEntryAway7);
			click(btnLineupDeleteEntryAway8);
			click(btnLineupDeleteEntryAway9);
			click(btnLineupDeleteEntryAway10);
			click(btnLineupDeleteEntryHome1);
			click(btnLineupDeleteEntryHome2);
			click(btnLineupDeleteEntryHome3);
			click(btnLineupDeleteEntryHome4);
			click(btnLineupDeleteEntryHome5);
			click(btnLineupDeleteEntryHome6);
			click(btnLineupDeleteEntryHome7);
			click(btnLineupDeleteEntryHome8);
			click(btnLineupDeleteEntryHome9);
			click(btnLineupDeleteEntryHome10);
		}
						
		click(btnLineupDeleteEntryOfficialHP);
		click(btnLineupDeleteEntryOfficial1B);
		click(btnLineupDeleteEntryOfficial2B);
		click(btnLineupDeleteEntryOfficial3B);
		click(btnLineupDeleteEntryOfficialLF);
		click(btnLineupDeleteEntryOfficialRF);
		click(btnLineupDeleteEntryOfficialOS);

		List<WebElement> FieldDataPositionPlayerFieldsAfterDelete = lineupGameContentFieldDataPositionDescription.getElement().findElements(By.xpath("//div[@class='bit-box']"));
		Assert.assertEquals(("Number of Bit-Box fields after Delete: " + FieldDataPositionPlayerFieldsAfterDelete.size() + ". Expected number is 3."), FieldDataPositionPlayerFieldsAfterDelete.size(), 3);		
		}

	public void fillAndSaveNewArticle(String mainURLCall, String betaOrProd, String articleReqFieldInternalName, String articleReqFieldHeadline, String articleReqFieldSubhead, String articleReqFieldAltHeadline, String articleReqFieldByline, String articleReqFieldSeoHeadline, String articleReqFieldPoll, String tagToolPlayerValue, String articleBlurbValue, String articleNotesValue, String articleTaglineValue) throws InterruptedException, AWTException	{
		type(FieldInternalName, articleReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldHeadline, articleReqFieldHeadline);
		type(FieldSubhead, articleReqFieldSubhead);
		type(FieldAltHeadline, articleReqFieldAltHeadline);
		type(FieldByline, articleReqFieldByline);
		type(FieldSeoHeadline, articleReqFieldSeoHeadline);
		type(FieldBlurb, articleBlurbValue);
		if (tagToolPlayerValue == "smith") {
			type(FieldNotes, articleNotesValue);
		}
		type(FieldTagline, articleTaglineValue);
//		testCMSTool(500,500);
		click(BtnCmsToolWysiwyg);
		testCMSToolNewFunctionHTML();
		click(BtnCmsToolHtml);
		type(FieldPoll, articleReqFieldPoll);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
//		click(linkViewBetaArticle);
	}

	public void fillAndSaveNewArticleView(String mainURLCall, String betaOrProd, String articleViewReqFieldInternalName, String articleViewReqFieldName, String articleViewReqFieldViewKey, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException {
		type(FieldInternalName, articleViewReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldName, articleViewReqFieldName);
		type(FieldViewKey, articleViewReqFieldViewKey);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewAudioSchedule(String mainURLCall, String betaOrProd, String audioScheduleReqFieldInternalName, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException {
		type(FieldInternalName, audioScheduleReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewBallpark(String mainURLCall, String betaOrProd, String ballparkReqFieldInternalName, String ballparkReqFieldID, String ballparkReqFieldName, String ballparkReqFieldAddress1, String ballparkReqFieldAddress2, String ballparkReqFieldLocation, String ballparkReqFieldMapType, String ballparkReqFieldMapVersion, String ballparkReqFieldFacebookID, String ballparkReqFieldFoursquareID, String ballparkReqFieldWebsiteURL, String ballparkReqFieldThumbnailURL, String ballparkReqFieldThumbnailCaption, String ballparkReqFieldTwitterHashTags, String ballparkReqFieldAboutURL, String ballparkReqFieldScheduleURL, String ballparkReqFieldSmallThumbnailURL, String ballparkReqFieldStartYear, String ballparkReqFieldEndYear, String ballparkReqFieldUpgradeURL, String ballparkReqFieldAbout, String ballparkReqFieldEventsText, String ballparkReqFieldSponsorImageText, String ballparkReqFieldSponsorImageURL, String ballparkReqFieldSponsorImage2Text, String ballparkReqFieldSponsorImage2URL, String ballparkReqFieldTicketsText, String ballparkReqFieldTicketsURL, String ballparkReqFieldTicketsErrorText, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, ballparkReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldID, ballparkReqFieldID);
		type(FieldName, ballparkReqFieldName);
		type(FieldAddress1, ballparkReqFieldAddress1);
		type(FieldAddress2, ballparkReqFieldAddress2);
		type(FieldLocation, ballparkReqFieldLocation);
		type(FieldMapType, ballparkReqFieldMapType);
		type(FieldMapVersion, ballparkReqFieldMapVersion);
		type(FieldFacebookID, ballparkReqFieldFacebookID);
		type(FieldFoursquareID, ballparkReqFieldFoursquareID);
		type(FieldWebsiteURL, ballparkReqFieldWebsiteURL);
		type(FieldThumbnailURL, ballparkReqFieldThumbnailURL);
		type(FieldThumbnailCaption, ballparkReqFieldThumbnailCaption);
		type(FieldTwitterHashTags, ballparkReqFieldTwitterHashTags);
		type(FieldAboutURL, ballparkReqFieldAboutURL);
		type(FieldScheduleURL, ballparkReqFieldScheduleURL);
		type(FieldSmallThumbnailURL, ballparkReqFieldSmallThumbnailURL);
		type(FieldStartYear, ballparkReqFieldStartYear);
		type(FieldEndYear, ballparkReqFieldEndYear);
		type(FieldUpgradeURL, ballparkReqFieldUpgradeURL);
		type(FieldAbout, ballparkReqFieldAbout);
		type(FieldEventsText, ballparkReqFieldEventsText);
		type(FieldSponsorImageText, ballparkReqFieldSponsorImageText);
		type(FieldSponsorImageURL, ballparkReqFieldSponsorImageURL);
		type(FieldSponsorImage2Text, ballparkReqFieldSponsorImage2Text);
		type(FieldSponsorImage2URL, ballparkReqFieldSponsorImage2URL);
		type(FieldTicketsText, ballparkReqFieldTicketsText);
		type(FieldTicketsURL, ballparkReqFieldTicketsURL);
		type(FieldTicketsErrorText, ballparkReqFieldTicketsErrorText);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewBallparkMenu(String mainURLCall, String betaOrProd, String ballparkMenuReqFieldInternalName, String ballparkMenuReqFieldDisplayName, String ballparkMenuReqFieldDisplayImageURL, String ballparkMenuReqFieldLinkURL, String ballparkMenuReqFieldLinkName, String ballparkMenuReqFieldBundleKey, String ballparkMenuReqFieldBundleName, String ballparkMenuReqFieldBundleURL, String ballparkMenuReqFieldSharingURL, String ballparkMenuReqFieldSharingText, String ballparkMenuReqFieldErrorText, String ballparkMenuReqFieldSourceURL, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, ballparkMenuReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldDisplayName, ballparkMenuReqFieldDisplayName);
		type(FieldDisplayImageURL, ballparkMenuReqFieldDisplayImageURL);
		type(FieldLinkURL2, ballparkMenuReqFieldLinkURL);
		type(FieldLinkName, ballparkMenuReqFieldLinkName);
		type(FieldBundleKey, ballparkMenuReqFieldBundleKey);
		type(FieldBundleName, ballparkMenuReqFieldBundleName);
		type(FieldBundleURL, ballparkMenuReqFieldBundleURL);
		type(FieldSharingURL, ballparkMenuReqFieldSharingURL);
		type(FieldSharingText, ballparkMenuReqFieldSharingText);
		type(FieldErrorText, ballparkMenuReqFieldErrorText);
		type(FieldSourceURL, ballparkMenuReqFieldSourceURL);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewBallparkMusic(String mainURLCall, String betaOrProd, String ballparkMusicReqFieldInternalName, String ballparkMusicReqFieldTitle, String ballparkMusicReqFieldArtist, String ballparkMusicReqFieldDescription, String ballparkMusicReqFieldThumbnail, String ballparkMusicReqFieldRank, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, ballparkMusicReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldTitle, ballparkMusicReqFieldTitle);
		type(FieldArtist, ballparkMusicReqFieldArtist);
		type(FieldDescription, ballparkMusicReqFieldDescription);
		type(FieldThumbnail, ballparkMusicReqFieldThumbnail);
		type(FieldRank, ballparkMusicReqFieldRank);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewBallparkSubmenu(String mainURLCall, String betaOrProd, String ballparkSubmenuReqFieldInternalName, String ballparkSubmenuReqFieldDisplayName, String ballparkSubmenuReqFieldDisplayImageURL, String ballparkSubmenuReqFieldLinkURL, String ballparkSubmenuReqFieldLinkName, String ballparkSubmenuReqFieldBundleKey, String ballparkSubmenuReqFieldBundleName, String ballparkSubmenuReqFieldBundleURL, String ballparkSubmenuReqFieldSharingURL, String ballparkSubmenuReqFieldSharingText, String ballparkSubmenuReqFieldErrorText, String ballparkSubmenuReqFieldSourceURL, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, ballparkSubmenuReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldDisplayName, ballparkSubmenuReqFieldDisplayName);
		type(FieldDisplayImageURL, ballparkSubmenuReqFieldDisplayImageURL);
		type(FieldLinkURL2, ballparkSubmenuReqFieldLinkURL);
		type(FieldLinkName, ballparkSubmenuReqFieldLinkName);
		type(FieldBundleKey, ballparkSubmenuReqFieldBundleKey);
		type(FieldBundleName, ballparkSubmenuReqFieldBundleName);
		type(FieldBundleURL, ballparkSubmenuReqFieldBundleURL);
		type(FieldSharingURL, ballparkSubmenuReqFieldSharingURL);
		type(FieldSharingText, ballparkSubmenuReqFieldSharingText);
		type(FieldErrorText, ballparkSubmenuReqFieldErrorText);
		type(FieldSourceURL, ballparkSubmenuReqFieldSourceURL);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewBlogContent(String mainURLCall, String betaOrProd, String blogContentReqFieldInternalName, String blogContentReqFieldURL, String blogContentReqFieldURLText, String blogContentReqFieldHeadline, String blogContentReqFieldAltHeadline, String blogContentReqFieldSEOHeadline, String blogContentReqFieldBlurb, String blogContentReqFieldByline, String blogContentReqFieldCaption, String blogContentReqFieldMediaCredit, String blogContentReqFieldBody, String blogContentReqFieldSummary, String tagToolPlayerValue) throws InterruptedException, AWTException	{
		type(FieldInternalName, blogContentReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldURL, blogContentReqFieldURL);
		type(FieldURLText, blogContentReqFieldURLText);
		type(FieldHeadline, blogContentReqFieldHeadline);
		type(FieldAltHeadline, blogContentReqFieldAltHeadline);
		type(FieldSeoHeadline2, blogContentReqFieldSEOHeadline);
		type(FieldBlurb, blogContentReqFieldBlurb);
		type(FieldByline, blogContentReqFieldByline);
		type(FieldCaption, blogContentReqFieldCaption);
		type(FieldMediaCredit, blogContentReqFieldMediaCredit);
		click(BtnCmsToolHtml);
		testCMSToolNewFunctionWYSIWYG();
		click(BtnCmsToolHtml);
		click(BtnCmsToolWysiwyg);
		testCMSToolNewFunctionWYSIWYG();
		click(BtnCmsToolWysiwyg);

		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}
	
	public void fillAndSaveNewBlogContentAlias(String mainURLCall, String betaOrProd, String blogContentAliasReqFieldInternalName, String blogContentAliasReqFieldHeadline, String blogContentAliasReqFieldBlurb, String blogContentAliasReqFieldSummary, String tagToolPlayerValue) throws InterruptedException, AWTException	{
		type(FieldInternalName, blogContentAliasReqFieldInternalName);
		type(FieldHeadline, blogContentAliasReqFieldHeadline);
		type(FieldBlurb, blogContentAliasReqFieldBlurb);
		type(FieldSummary, blogContentAliasReqFieldSummary);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}
	
	public void fillAndSaveNewChron(String mainURLCall, String betaOrProd, String chronReqFieldInternalName, String chronReqFieldDateNotation, String chronReqFieldYear, String chronReqFieldDisplayYear, String chronReqFieldTitle, String chronReqFieldCMSDescription, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, chronReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldDateNotation, chronReqFieldDateNotation);
		type(FieldYear, chronReqFieldYear);
		type(FieldDisplayYear, chronReqFieldDisplayYear);
		type(FieldTitle, chronReqFieldTitle);
		testCMSToolNewFunctionHTML();
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}
	
	public void fillAndSaveNewClosedCaption(String mainURLCall, String betaOrProd, String closedCaptionReqFieldInternalName, String tagToolPlayerValue) throws InterruptedException, AWTException	{
		type(FieldInternalName, closedCaptionReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		testCMSToolNewFunctionHTML();
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewClubPromo(String mainURLCall, String betaOrProd, String clubPromoReqFieldInternalName, String clubPromoReqFieldURLExtension, String clubPromoReqFieldEventTitle, String clubPromoReqFieldEventSubtitle, String clubPromoReqFieldPromoText, String clubPromoReqFieldMobileTicketsText, String clubPromoReqFieldMobileTicketsURL, String clubPromoReqFieldTicketsURL, String clubPromoReqFieldTextCampaignPromo, String clubPromoReqFieldSocialKeyword, String clubPromoReqFieldHighlightsTitle, String clubPromoReqFieldLocationAddress, String clubPromoReqFieldEventMapTitle, String clubPromoReqFieldScheduleTitle, String clubPromoReqFieldFAQTitle, String tagToolPlayerValue) throws InterruptedException, AWTException	{
		type(FieldInternalName, clubPromoReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldURLExtension, clubPromoReqFieldURLExtension);
		type(FieldEventTitle, clubPromoReqFieldEventTitle);
		type(FieldEventSubtitle, clubPromoReqFieldEventSubtitle);
		type(FieldPromoText, clubPromoReqFieldPromoText);
		type(FieldMobileTicketsText, clubPromoReqFieldMobileTicketsText);
		type(FieldMobileTicketsURL, clubPromoReqFieldMobileTicketsURL);
		type(FieldTicketsURL, clubPromoReqFieldTicketsURL);
		type(FieldTextCampaignPromo, clubPromoReqFieldTextCampaignPromo);
		type(FieldSocialKeyword, clubPromoReqFieldSocialKeyword);
		type(FieldHighlightsTitle, clubPromoReqFieldHighlightsTitle);
		type(FieldLocationAddress, clubPromoReqFieldLocationAddress);
		type(FieldEventMapTitle, clubPromoReqFieldEventMapTitle);
		type(FieldScheduleTitle, clubPromoReqFieldScheduleTitle);
		type(FieldFAQTitle, clubPromoReqFieldFAQTitle);
		click(labelSponsors);
		testCMSToolNewFunctionHTML();
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewContributor(String mainURLCall, String betaOrProd, String contributorReqFieldInternalName, String contributorReqFieldFirstName, String contributorReqFieldLastName, String contributorReqFieldTitle, String contributorReqFieldEmail, String contributorReqFieldTwitterHandle, String contributorReqFieldBlog, String contributorReqFieldBlogTitle, String contributorReqFieldRSSFeed, String contributorReqFieldFacebookID, String contributorReqFieldActiveTab, String contributorReqFieldHideArticles, String contributorReqFieldVideoKeywordType, String contributorReqFieldVideoKeywordValue, String contributorReqFieldVideoLandingPage, String contributorReqFieldBlurb, String tagToolPlayerValue) throws InterruptedException, AWTException	{
		type(FieldInternalName, contributorReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldFirstName, contributorReqFieldFirstName);
		type(FieldLastName, contributorReqFieldLastName);
		type(FieldTitle, contributorReqFieldTitle);
		type(FieldEmail, contributorReqFieldEmail);
		type(FieldTwitterHandle, contributorReqFieldTwitterHandle);
		type(FieldBlog, contributorReqFieldBlog);
		type(FieldBlogTitle, contributorReqFieldBlogTitle);
		type(FieldRSSFeed, contributorReqFieldRSSFeed);
		type(FieldFacebookID2, contributorReqFieldFacebookID);
		type(FieldActiveTab, contributorReqFieldActiveTab);
		type(FieldHideArticles, contributorReqFieldHideArticles);
		type(FieldVideoKeywordType, contributorReqFieldVideoKeywordType);
		type(FieldVideoKeywordValue, contributorReqFieldVideoKeywordValue);
		type(FieldVideoLandingPage, contributorReqFieldVideoLandingPage);
		type(FieldBlurb, contributorReqFieldBlurb);
		click(labelBigBlurb);
		testCMSToolNewFunctionHTML();
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewDailyEmail(String mainURLCall, String betaOrProd, String dailyEmailReqFieldInternalName, String dailyEmailReqFieldSubject, String dailyEmailReqFieldSubjectB, String dailyEmailReqFieldTriviaQuestion, String dailyEmailReqFieldTriviaAnswer, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, dailyEmailReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldSubject, dailyEmailReqFieldSubject);
		type(FieldSubjectB, dailyEmailReqFieldSubjectB);
		type(FieldTriviaQuestion, dailyEmailReqFieldTriviaQuestion);
		type(FieldTriviaAnswer, dailyEmailReqFieldTriviaAnswer);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewDeviceAnnouncement(String mainURLCall, String betaOrProd, String deviceAnnouncementReqFieldInternalName, String deviceAnnouncementReqFieldAppVersion, String deviceAnnouncementReqFieldOSVersion, String deviceAnnouncementReqFieldEntitlement, String deviceAnnouncementReqFieldScreen, String deviceAnnouncementReqFieldType, String deviceAnnouncementReqFieldDisplayType, String deviceAnnouncementReqFieldTitle, String deviceAnnouncementReqFieldMessage, String deviceAnnouncementReqFieldOpenLabel, String deviceAnnouncementReqFieldOpenLink, String deviceAnnouncementReqFieldCloseLabel, String deviceAnnouncementReqFieldCloseLink, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, deviceAnnouncementReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldAppVersion, deviceAnnouncementReqFieldAppVersion);
		type(FieldOSVersion, deviceAnnouncementReqFieldOSVersion);
		type(FieldEntitlement, deviceAnnouncementReqFieldEntitlement);
		type(FieldScreen, deviceAnnouncementReqFieldScreen);
		type(FieldType, deviceAnnouncementReqFieldType);
		type(FieldDisplayType, deviceAnnouncementReqFieldDisplayType);
		type(FieldTitle, deviceAnnouncementReqFieldTitle);
		type(FieldMessage, deviceAnnouncementReqFieldMessage);
		type(FieldOpenLabel, deviceAnnouncementReqFieldOpenLabel);
		type(FieldOpenLink, deviceAnnouncementReqFieldOpenLink);
		type(FieldCloseLabel, deviceAnnouncementReqFieldCloseLabel);
		type(FieldCloseLink, deviceAnnouncementReqFieldCloseLink);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewDeviceBanner(String mainURLCall, String betaOrProd, String deviceBannerReqFieldInternalName, String deviceBannerReqFieldAppVersion, String deviceBannerReqFieldOSVersion, String deviceBannerReqFieldEntitlement, String deviceBannerReqFieldAccessFeature, String deviceBannerReqFieldScreen, String deviceBannerReqFieldViewID, String deviceBannerReqFieldType, String deviceBannerReqFieldWebViewType, String deviceBannerReqFieldTitle, String deviceBannerReqFieldLink, String deviceBannerReqFieldBackgroundColor, String deviceBannerReqFieldTrackingString, String deviceBannerReqFieldAdMarvelID, String deviceBannerReqFieldAdMarvelWidth, String deviceBannerReqFieldAdMarvelHeight, String deviceBannerReqFieldAdMarvelSectionID, String deviceBannerReqFieldAdMarvelMLBTarget, String deviceBannerReqFieldAdMarvelExpiryTime, String deviceBannerReqFieldMLBTVContentID, String deviceBannerReqFieldMLBTVCalendarEventID, String deviceBannerReqFieldSponsor, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, deviceBannerReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldAppVersion, deviceBannerReqFieldAppVersion);
		type(FieldOSVersion, deviceBannerReqFieldOSVersion);
		type(FieldEntitlement, deviceBannerReqFieldEntitlement);
		type(FieldAccessFeature, deviceBannerReqFieldAccessFeature);
		type(FieldScreen, deviceBannerReqFieldScreen);
		type(FieldViewID, deviceBannerReqFieldViewID);
		type(FieldType, deviceBannerReqFieldType);
		type(FieldWebViewType, deviceBannerReqFieldWebViewType);
		type(FieldTitle, deviceBannerReqFieldTitle);
		type(FieldLink, deviceBannerReqFieldLink);
		type(FieldBackgroundColor, deviceBannerReqFieldBackgroundColor);
		type(FieldTrackingString, deviceBannerReqFieldTrackingString);
		type(FieldAdMarvelID, deviceBannerReqFieldAdMarvelID);
		type(FieldAdMarvelWidth, deviceBannerReqFieldAdMarvelWidth);
		type(FieldAdMarvelHeight, deviceBannerReqFieldAdMarvelHeight);
		type(FieldAdMarvelSectionID, deviceBannerReqFieldAdMarvelSectionID);
		type(FieldAdMarvelMLBTarget, deviceBannerReqFieldAdMarvelMLBTarget);
		type(FieldAdMarvelExpiryTime, deviceBannerReqFieldAdMarvelExpiryTime);
		type(FieldMLBTVContentID, deviceBannerReqFieldMLBTVContentID);
		type(FieldMLBTVCalendarEventID, deviceBannerReqFieldMLBTVCalendarEventID);
		type(FieldSponsor, deviceBannerReqFieldSponsor);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewDevicePage(String mainURLCall, String betaOrProd, String devicePageReqFieldInternalName, String devicePageReqFieldHeadline, String devicePageReqFieldBlurb, String devicePageReqFieldYearlyPurchaseFlow, String devicePageReqFieldMonthlyPurchaseFlow, String devicePageReqFieldUpgradeLink, String devicePageReqFieldActivationLink, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, devicePageReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldHeadline, devicePageReqFieldHeadline);
		type(FieldBlurb, devicePageReqFieldBlurb);
		type(FieldYearlyPurchaseFlow, devicePageReqFieldYearlyPurchaseFlow);
		type(FieldMonthlyPurchaseFlow, devicePageReqFieldMonthlyPurchaseFlow);
		type(FieldUpgradeLink, devicePageReqFieldUpgradeLink);
		type(FieldActivationLink, devicePageReqFieldActivationLink);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewDigitalAsset(String mainURLCall, String betaOrProd, String digitalAssetReqFieldInternalName, String digitalAssetReqFieldHeadline, String tagToolPlayerValue) throws InterruptedException, AWTException	{
		type(FieldInternalName, digitalAssetReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldHeadline, digitalAssetReqFieldHeadline);
		testCMSToolNewFunctionHTML();
		click(BtnChooseAFileToUpload);
		testPhotoFileDialog();
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewDrawer(String mainURLCall, String betaOrProd, String drawerReqFieldInternalName, String drawerReqFieldKicker, String drawerReqFieldCustomContent, String drawerReqFieldBlurb, String drawerReqFieldURL, String drawerReqFieldURLText, String drawerReqFieldNumberOfItems, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		Selenium seleniumDrawer = new WebDriverBackedSelenium(driver, mainURLCall);
		type(FieldInternalName, drawerReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		click(FieldAppears);
		pause(1);
		seleniumDrawer.keyPressNative(String.valueOf(KeyEvent.VK_ENTER));
		pause(1);
		click(FieldExpires);
		pause(1);
		seleniumDrawer.keyPressNative(String.valueOf(KeyEvent.VK_ENTER));
		pause(1);
		type(FieldKicker, drawerReqFieldKicker);
		type(FieldCustomContent, drawerReqFieldCustomContent);
		type(FieldBlurb, drawerReqFieldBlurb);
		type(FieldURL, drawerReqFieldURL);
		type(FieldURLText, drawerReqFieldURLText);
		type(FieldNumberOfItems, drawerReqFieldNumberOfItems);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewEvent(String mainURLCall, String betaOrProd, String eventReqFieldInternalName, String eventReqFieldProgramID, String eventReqFieldProgram, String eventReqFieldLocation, String eventReqFieldEventTitle, String eventReqFieldEventDescription, String eventReqFieldEventURL, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		Selenium seleniumEvent = new WebDriverBackedSelenium(driver, mainURLCall);
		type(FieldInternalName, eventReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldProgramID, eventReqFieldProgramID);
		type(FieldProgram, eventReqFieldProgram);
		type(FieldLocation, eventReqFieldLocation);
		type(FieldEventTitle2, eventReqFieldEventTitle);
		type(FieldEventDescription, eventReqFieldEventDescription);
		type(FieldEventURL, eventReqFieldEventURL);
		click(FieldEndDateAndTime);
		pause(1);
		seleniumEvent.keyPressNative(String.valueOf(KeyEvent.VK_ENTER));
		pause(1);
		click(FieldStartDateAndTime);
		pause(1);
		seleniumEvent.keyPressNative(String.valueOf(KeyEvent.VK_ENTER));
		pause(1);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewFeature(String mainURLCall, String betaOrProd, String featureReqFieldInternalName, String featureReqFieldHeadline, String featureReqFieldURL, String featureReqFieldURLText, String featureReqFieldMobileURL, String featureReqFieldBlurb, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, featureReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldHeadline, featureReqFieldHeadline);
		type(FieldURL, featureReqFieldURL);
		type(FieldURLText, featureReqFieldURLText);
		type(FieldMobileURL, featureReqFieldMobileURL);
		type(FieldBlurb, featureReqFieldBlurb);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewFeatures(String mainURLCall, String betaOrProd, String featuresReqFieldInternalName, String featuresReqFieldNumberOfItems, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, featuresReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldNumberOfItems, featuresReqFieldNumberOfItems);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewFieldOption(String mainURLCall, String betaOrProd, String fieldOptionReqFieldInternalName, String fieldOptionReqFieldDisplayName, String fieldOptionReqFieldValue, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, fieldOptionReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldDisplayName, fieldOptionReqFieldDisplayName);
		type(FieldValue, fieldOptionReqFieldValue);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewGamePreview(String mainURLCall, String betaOrProd, String gamePreviewReqFieldInternalName, String gamePreviewReqFieldHeadline, String gamePreviewReqFieldHomeHeadline, String gamePreviewReqFieldAwayHeadline, String gamePreviewReqFieldSubhead, String gamePreviewReqFieldAltHeadline, String gamePreviewReqFieldByline, String gamePreviewReqFieldBlurb, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, gamePreviewReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldHeadline, gamePreviewReqFieldHeadline);
		type(FieldHomeHeadline, gamePreviewReqFieldHomeHeadline);
		type(FieldAwayHeadline, gamePreviewReqFieldAwayHeadline);
		type(FieldSubhead, gamePreviewReqFieldSubhead);
		type(FieldAltHeadline, gamePreviewReqFieldAltHeadline);
		type(FieldByline, gamePreviewReqFieldByline);
		type(FieldBlurb, gamePreviewReqFieldBlurb); 
		testCMSToolNewFunctionHTML();
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewGameWrap(String mainURLCall, String betaOrProd, String gameWrapReqFieldInternalName, String gameWrapReqFieldHeadline, String gameWrapReqFieldBlurb, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, gameWrapReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldHeadline, gameWrapReqFieldHeadline);
		type(FieldBlurb, gameWrapReqFieldBlurb); 
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewHighlight(String mainURLCall, String betaOrProd, String highlightReqFieldInternalName, String highlightReqFieldYear, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, highlightReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldYear, highlightReqFieldYear);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewHomepageTab(String mainURLCall, String betaOrProd, String homepageTabReqFieldInternalName, String homepageTabReqFieldDefaultAltText, String homepageTabReqFieldDefaultClickthroughURL, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, homepageTabReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldDefaultAltText, homepageTabReqFieldDefaultAltText);
		type(FieldDefaultClickthroughURL, homepageTabReqFieldDefaultClickthroughURL);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewHPConfig(String mainURLCall, String betaOrProd, String hPConfigReqFieldInternalName, String hPConfigReqFieldBreakingNews, String hPConfigReqFieldBreakingNewsURL, String hPConfigReqFieldABTests, String hPConfigReqFieldHeaderURL, String hPConfigReqFieldHeaderAlt, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, hPConfigReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldBreakingNews, hPConfigReqFieldBreakingNews);
		type(FieldBreakingNewsURL, hPConfigReqFieldBreakingNewsURL);
		type(FieldABTests, hPConfigReqFieldABTests);
		type(FieldHeaderURL, hPConfigReqFieldHeaderURL);
		type(FieldHeaderAlt, hPConfigReqFieldHeaderAlt);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewHTMLInclude(String mainURLCall, String betaOrProd, String hTMLIncludeReqFieldInternalName, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, hTMLIncludeReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewHTMLPage(String mainURLCall, String betaOrProd, String hTMLPageReqFieldInternalName, String hTMLPageReqFieldHeadline, String hTMLPageBlurbValue, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, hTMLPageReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldHeadline, hTMLPageReqFieldHeadline);
		pause(1);
		pressTab();
		sendKeys(hTMLPageBlurbValue);
		pause(1);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewInstagramPhoto(String mainURLCall, String betaOrProd, String instagramPhotoReqFieldInternalName, String instagramPhotoReqFieldApprover, String instagramPhotoReqFieldApprovedTime, String instagramPhotoReqFieldInstagramID, String instagramPhotoReqFieldImageURL, String instagramPhotoReqFieldLargeImageURL, String instagramPhotoReqFieldCaption, String instagramPhotoReqFieldCreatorID, String instagramPhotoReqFieldCreatorName, String instagramPhotoReqFieldCreatorProfilePicture, String instagramPhotoReqFieldCreatedTime, String instagramPhotoReqFieldLatitude, String instagramPhotoReqFieldLongitude, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, instagramPhotoReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldApprover, instagramPhotoReqFieldApprover);
		type(FieldApprovedTime, instagramPhotoReqFieldApprovedTime);
		type(FieldInstagramID, instagramPhotoReqFieldInstagramID);
		type(FieldImageURL, instagramPhotoReqFieldImageURL);
		type(FieldLargeImageURL, instagramPhotoReqFieldLargeImageURL);
		type(FieldCaption, instagramPhotoReqFieldCaption);
		type(FieldCreatorID, instagramPhotoReqFieldCreatorID);
		type(FieldCreatorName, instagramPhotoReqFieldCreatorName);
		type(FieldCreatorProfilePicture, instagramPhotoReqFieldCreatorProfilePicture);
		type(FieldCreatedTime, instagramPhotoReqFieldCreatedTime);
		type(FieldLatitude, instagramPhotoReqFieldLatitude);
		type(FieldLongitude, instagramPhotoReqFieldLongitude);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewInstagramStream(String mainURLCall, String betaOrProd, String instagramStreamReqFieldInternalName, String instagramStreamReqFieldDisplayName, String instagramStreamReqFieldKey, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, instagramStreamReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldInstagramStreamDisplayName, instagramStreamReqFieldDisplayName);
		type(FieldKey, instagramStreamReqFieldKey);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewKiosk(String mainURLCall, String betaOrProd, String kioskReqFieldInternalName, String kioskReqFieldCalendarEventID, String kioskReqFieldContentID, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, kioskReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldCalendarEventID, kioskReqFieldCalendarEventID);
		type(FieldContentID, kioskReqFieldContentID);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewLineup(String mainURLCall, String betaOrProd, String lineupReqFieldInternalName, String lineupReqFieldUmpireHP, String lineupReqFieldUmpire1st, String lineupReqFieldUmpire2nd, String lineupReqFieldUmpire3rd, String lineupReqFieldUmpireLF, String lineupReqFieldUmpireRF, String lineupReqFieldUmpireOS, String lineupReqFieldNotes, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, lineupReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldUmpireHP, lineupReqFieldUmpireHP);
		type(FieldUmpire1st, lineupReqFieldUmpire1st);
		type(FieldUmpire2nd, lineupReqFieldUmpire2nd);
		type(FieldUmpire3rd, lineupReqFieldUmpire3rd);
		type(FieldUmpireLF, lineupReqFieldUmpireLF);
		type(FieldUmpireRF, lineupReqFieldUmpireRF);
		type(FieldUmpireOS, lineupReqFieldUmpireOS);
		type(FieldLineupNotes, lineupReqFieldNotes);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewLineupPlayer(String mainURLCall, String betaOrProd, String lineupPlayerReqFieldInternalName, String lineupPlayerReqFieldPosition, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, lineupPlayerReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldPosition, lineupPlayerReqFieldPosition);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewLink(String mainURLCall, String betaOrProd, String linkReqFieldInternalName, String linkReqFieldLinkText, String linkReqFieldLinkURL, String linkReqFieldWidth, String linkReqFieldHeight, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		pause(3);
		sendKeys(linkReqFieldLinkText);
		pressTab();
		pause(3);
		type(FieldInternalName, linkReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
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
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewList(String mainURLCall, String betaOrProd, String listReqFieldInternalName, String listReqFieldKey, String listReqFieldNumberOfItems, String listReqFieldBlurb, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, listReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldKey, listReqFieldKey);
		type(FieldNumberOfItems, listReqFieldNumberOfItems);
		type(FieldBlurb, listReqFieldBlurb);

		click(btnSearchForItems);
		click(btnSearchHideOptions);

		type(FieldMainSearch, "89238938");
		click(btnSearch);
		WebElement btnAddVideoClipListBeingSearched = panelSearchTileControls.getElement().findElement(By.xpath("//div[@class='add-icon-all_types add-icon-link']"));
		btnAddVideoClipListBeingSearched.click();

		type(FieldMainSearch, "91905926");
		click(btnSearch);
		WebElement btnAddVideoClipListBeingSearched2 = panelSearchTileControls.getElement().findElement(By.xpath("//div[@class='add-icon-all_types add-icon-digital-asset']"));
		btnAddVideoClipListBeingSearched2.click();
		
		type(FieldMainSearch, "92932056");
		click(btnSearch);
		WebElement btnAddVideoClipListBeingSearched3 = panelSearchTileControls.getElement().findElement(By.xpath("//div[@class='add-icon-all_types add-icon-tweet']"));
		btnAddVideoClipListBeingSearched3.click();


		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewMediawall(String mainURLCall, String betaOrProd, String mediawallReqFieldInternalName, String mediawallReqFieldNumberOfPanels, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, mediawallReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldNumberOfPanels, mediawallReqFieldNumberOfPanels);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBetaWithoutDelete();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProdWithoutDelete();
		}
	}

	public void fillAndSaveNewMediawallOverlay(String mainURLCall, String betaOrProd, String mediawallOverlayReqFieldInternalName, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, mediawallOverlayReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldInternalName, mediawallOverlayReqFieldInternalName);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewMediaWallPanel(String mainURLCall, String betaOrProd, String mediawallPanelReqFieldInternalName, String mediawallReqFieldHeadline, String mediawallReqFieldURLText, String mediawallReqFieldURL, String mediawallReqFieldMobileURL, String mediawallReqFieldSponsorURL, String mediawallReqFieldBlurb, String mediawallReqFieldNotes, String mediawallReqFieldDisplayTimeInSeconds, String mediawallReqFieldVideoAlias, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, mediawallPanelReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
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
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}
	
	public void fillAndSaveNewMLBTVAdModule(String mainURLCall, String betaOrProd, String mLBTVAdModuleReqFieldInternalName, String mLBTVAdModuleReqFieldURL, String mLBTVAdModuleReqFieldMobileURL, String mLBTVAdModuleReqFieldTabletURL, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, mLBTVAdModuleReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldURL, mLBTVAdModuleReqFieldURL);
		type(FieldMobileURL, mLBTVAdModuleReqFieldMobileURL);
		type(FieldTabletURL, mLBTVAdModuleReqFieldTabletURL);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewMoundBall(String mainURLCall, String betaOrProd, String moundBallReqFieldInternalName, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, moundBallReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewMusicLink(String mainURLCall, String betaOrProd, String musicLinkReqFieldInternalName, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, musicLinkReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewNote(String mainURLCall, String betaOrProd, String noteReqFieldInternalName, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, noteReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewNotebook(String mainURLCall, String betaOrProd, String notebookReqFieldInternalName, String notebookReqFieldHeadline, String notebookReqFieldByline, String notebookReqFieldSource, String notebookTaglineValue, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, notebookReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldHeadline, notebookReqFieldHeadline);
		type(FieldByline, notebookReqFieldByline);
		type(FieldSource, notebookReqFieldSource);
		pause(1);
		pressTab();
		sendKeys(notebookTaglineValue);
		pause(1);
		pressTab();
		pause(1);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewPage(String mainURLCall, String betaOrProd, String pageReqFieldInternalName, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, pageReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewPhotoGallery(String mainURLCall, String betaOrProd, String photoGalleryReqFieldInternalName, String photoGalleryReqFieldTitle, String photoGalleryReqFieldSpanishTitle, String photoGalleryReqFieldBlurb, String photoGalleryReqFieldSpanishBlurb, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, photoGalleryReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
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
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewPhotoGalleryAlias(String mainURLCall, String betaOrProd, String photoGalleryAliasReqFieldInternalName, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, photoGalleryAliasReqFieldInternalName);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewPhotoGalleryList(String mainURLCall, String betaOrProd, String photoGalleryListReqFieldInternalName, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, photoGalleryListReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewProspect(String mainURLCall, String betaOrProd, String prospectReqFieldInternalName, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, prospectReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewPodcastDetail(String mainURLCall, String betaOrProd, String podcastDetailReqFieldInternalName, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, podcastDetailReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewPodcastEpisode(String mainURLCall, String betaOrProd, String podcastEpisodeReqFieldInternalName, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, podcastEpisodeReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewPressRelease(String mainURLCall, String betaOrProd, String pressReleaseReqFieldInternalName, String pressReleaseReqFieldNotes, String pressReleaseReqFieldDisplayHeadline, String pressReleaseReqFieldHeadline, String pressReleaseReqFieldSubHeadline, String pressReleaseReqFieldBlurb, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, pressReleaseReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldNotes, pressReleaseReqFieldNotes);
		type(FieldDisplayHeadline, pressReleaseReqFieldDisplayHeadline);
		type(FieldHeadline, pressReleaseReqFieldHeadline);
		type(FieldSubHeadline, pressReleaseReqFieldSubHeadline);
		type(FieldBlurb, pressReleaseReqFieldBlurb);
		testCMSToolNewFunctionHTML();
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewPressboxAsset(String mainURLCall, String betaOrProd, String pressboxAssetReqFieldInternalName, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, pressboxAssetReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewPressboxAssetList(String mainURLCall, String betaOrProd, String pressboxAssetListReqFieldInternalName, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, pressboxAssetListReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewPreviewAlias(String mainURLCall, String betaOrProd, String previewAliasReqFieldInternalName, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, previewAliasReqFieldInternalName);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewProgramShow(String mainURLCall, String betaOrProd, String programShowReqFieldInternalName, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, programShowReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewPromoApplication(String mainURLCall, String betaOrProd, String promoApplicationReqFieldInternalName, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, promoApplicationReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewQuoteSheet(String mainURLCall, String betaOrProd, String quoteSheetReqFieldInternalName, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, quoteSheetReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewRaffle(String mainURLCall, String betaOrProd, String raffleReqFieldInternalName, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, raffleReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewSchedule(String mainURLCall, String betaOrProd, String scheduleReqFieldInternalName, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, scheduleReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewScrapbook(String mainURLCall, String betaOrProd, String scrapbookReqFieldInternalName, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, scrapbookReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewScrapbookPage(String mainURLCall, String betaOrProd, String scrapbookPageReqFieldInternalName, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, scrapbookPageReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewSection(String mainURLCall, String betaOrProd, String sectionReqFieldInternalName, String sectionReqFieldSectionID, String sectionReqFieldShortTitle, String sectionReqFieldLongTitle, String sectionReqFieldWiredURL, String sectionReqFieldMobileURL, String sectionReqFieldTarget, String sectionReqFieldType, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		testCMSToolNewFunctionHTML();
		type(FieldInternalName, sectionReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldSectionID, sectionReqFieldSectionID);
		type(FieldShortTitle, sectionReqFieldShortTitle);
		type(FieldLongTitle, sectionReqFieldLongTitle);
		type(FieldWiredURL, sectionReqFieldWiredURL);
		type(FieldMobileURL, sectionReqFieldMobileURL);
		type(FieldTarget, sectionReqFieldTarget);
		type(FieldType, sectionReqFieldType);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewSeriesConfiguration(String mainURLCall, String betaOrProd, String seriesConfigurationReqFieldInternalName, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, seriesConfigurationReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewShortContent(String mainURLCall, String betaOrProd, String shortContentReqFieldInternalName, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, shortContentReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewTicketPage(String mainURLCall, String betaOrProd, String ticketPageReqFieldInternalName, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, ticketPageReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewTrendingModule(String mainURLCall, String betaOrProd, String trendingModuleReqFieldInternalName, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, trendingModuleReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewTweet(String mainURLCall, String betaOrProd, String tweetReqFieldInternalName, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, tweetReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewVideoTopicPage(String mainURLCall, String betaOrProd, String videoTopicPageReqFieldInternalName, String videoTopicPageReqFieldHeadline, String videoTopicPageReqFieldFacebookDescription, String videoTopicPageReqFieldMaxItems, String videoTopicPageReqFieldItemsPerPage, String videoTopicPageReqFieldSearchCriteria, String videoTopicPageReqFieldRelatedLink, String videoTopicPageReqFieldCustomTemplatePath, String videoTopicPageReqFieldJavascriptPath, String videoTopicPageReqFieldStylesheetPath, String videoTopicPageReqFieldCustomPanel, String videoTopicPageReqFieldTwitterHandle, String videoTopicPageReqFieldPollKey, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, videoTopicPageReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldHeadline, videoTopicPageReqFieldHeadline);
		type(FieldFacebookDescription, videoTopicPageReqFieldFacebookDescription);
		type(FieldMaxItems, videoTopicPageReqFieldMaxItems);
		type(FieldItemsPerPage, videoTopicPageReqFieldItemsPerPage);
		type(FieldSearchCriteria, videoTopicPageReqFieldSearchCriteria);
		type(FieldRelatedLink, videoTopicPageReqFieldRelatedLink);
		type(FieldCustomTemplatePath, videoTopicPageReqFieldCustomTemplatePath);
		type(FieldJavascriptPath, videoTopicPageReqFieldJavascriptPath);
		type(FieldStylesheetPath, videoTopicPageReqFieldStylesheetPath);
		type(FieldCustomPanel, videoTopicPageReqFieldCustomPanel);
		type(FieldTwitterHandleVTP, videoTopicPageReqFieldTwitterHandle);
		type(FieldPollKey, videoTopicPageReqFieldPollKey);

		click(btnSearchForVideoClipList);
		click(btnSearchHideOptions);

		type(FieldMainSearch, "90754964");
		click(btnSearch);
		WebElement btnAddVideoClipListBeingSearched = panelSearchTileControls.getElement().findElement(By.xpath("//div[@class='add-icon-all_types add-icon-video_clip_list']"));
		btnAddVideoClipListBeingSearched.click();

		type(FieldMainSearch, "85559162");
		click(btnSearch);
		WebElement btnAddVideoClipListBeingSearched2 = panelSearchTileControls.getElement().findElement(By.xpath("//div[@class='add-icon-all_types add-icon-video_clip_list']"));
		btnAddVideoClipListBeingSearched2.click();
		
		type(FieldMainSearch, "81881448");
		click(btnSearch);
		WebElement btnAddVideoClipListBeingSearched3 = panelSearchTileControls.getElement().findElement(By.xpath("//div[@class='add-icon-all_types add-icon-video_clip_list']"));
		btnAddVideoClipListBeingSearched3.click();

		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewTwitterHandle(String mainURLCall, String betaOrProd, String twitterHandleReqFieldInternalName, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, twitterHandleReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void fillAndSaveNewVideoClipList(String mainURLCall, String betaOrProd, String videoClipListReqFieldInternalName, String videoClipListReqFieldHeadline, String videoClipListReqFieldListDefaultView, String tagToolPlayerValue) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		type(FieldInternalName, videoClipListReqFieldInternalName);
		useTagTool(mainURLCall, tagToolPlayerValue);
		type(FieldHeadline, videoClipListReqFieldHeadline);
		type(FieldListDefaultView, videoClipListReqFieldListDefaultView);

		click(btnSearchForVideo);
		click(btnSearchHideOptions);

		type(FieldMainSearch, "100000121569");
		click(btnSearch);
		WebElement btnAddVideoBeingSearched = panelSearchTileControls.getElement().findElement(By.xpath("//div[@class='add-icon-all_types add-icon-video']"));
		btnAddVideoBeingSearched.click();

		type(FieldMainSearch, "100000121579");
		click(btnSearch);
		WebElement btnAddVideoBeingSearched2 = panelSearchTileControls.getElement().findElement(By.xpath("//div[@class='add-icon-all_types add-icon-video']"));
		btnAddVideoBeingSearched2.click();
		
		type(FieldMainSearch, "100000121581");
		click(btnSearch);
		WebElement btnAddVideoBeingSearched3 = panelSearchTileControls.getElement().findElement(By.xpath("//div[@class='add-icon-all_types add-icon-video']"));
		btnAddVideoBeingSearched3.click();

		if (betaOrProd == "beta") {
			saveItemAndPublishToBeta();
		}
		if (betaOrProd == "prod") {
			saveItemAndPublishToProd();
		}
	}

	public void pressA() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
	}
	
	public void pressB() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_B);
		robot.keyRelease(KeyEvent.VK_B);
	}
	
	public void pressC() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
	}
	
	public void pressD() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_D);
		robot.keyRelease(KeyEvent.VK_D);
	}
	
	public void pressE() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_E);
	}
	
	public void pressF() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_F);
		robot.keyRelease(KeyEvent.VK_F);
	}
	
	public void pressG() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_G);
		robot.keyRelease(KeyEvent.VK_G);
	}
	
	public void pressH() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_H);
		robot.keyRelease(KeyEvent.VK_H);
	}
	
	public void pressI() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_I);
		robot.keyRelease(KeyEvent.VK_I);
	}
	
	public void pressJ() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_J);
		robot.keyRelease(KeyEvent.VK_J);
	}
	
	public void pressK() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_K);
		robot.keyRelease(KeyEvent.VK_K);
	}
	
	public void pressL() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_L);
		robot.keyRelease(KeyEvent.VK_L);
	}
	
	public void pressM() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_M);
		robot.keyRelease(KeyEvent.VK_M);
	}
	
	public void pressN() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_N);
	}
	
	public void pressO() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_O);
		robot.keyRelease(KeyEvent.VK_O);
	}
	
	public void pressP() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_P);
		robot.keyRelease(KeyEvent.VK_P);
	}
	
	public void pressQ() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_Q);
		robot.keyRelease(KeyEvent.VK_Q);
	}
	
	public void pressR() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_R);
	}
	
	public void pressS() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);
	}
	
	public void pressT() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_T);
	}
	
	public void pressU() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_U);
		robot.keyRelease(KeyEvent.VK_U);
	}
	
	public void pressV() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
	}
	
	public void pressW() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_W);
		robot.keyRelease(KeyEvent.VK_W);
	}
	
	public void pressX() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_X);
		robot.keyRelease(KeyEvent.VK_X);
	}
	
	public void pressY() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_Y);
		robot.keyRelease(KeyEvent.VK_Y);
	}
	
	public void pressZ() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_Z);
		robot.keyRelease(KeyEvent.VK_Z);
	}
	
	public void press0() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_0);
		robot.keyRelease(KeyEvent.VK_0);
	}
	
	public void press1() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);
	}
	
	public void press2() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_2);
		robot.keyRelease(KeyEvent.VK_2);
	}
	
	public void press3() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_3);
		robot.keyRelease(KeyEvent.VK_3);
	}
	
	public void press4() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_4);
		robot.keyRelease(KeyEvent.VK_4);
	}
	
	public void press5() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_5);
		robot.keyRelease(KeyEvent.VK_5);
	}
	
	public void press6() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_6);
		robot.keyRelease(KeyEvent.VK_6);
	}
	
	public void press7() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_7);
		robot.keyRelease(KeyEvent.VK_7);
	}
	
	public void press8() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_8);
		robot.keyRelease(KeyEvent.VK_8);
	}
	
	public void press9() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_9);
		robot.keyRelease(KeyEvent.VK_9);
	}
	
	public void pressEnter() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void pressPeriod() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PERIOD);
		robot.keyRelease(KeyEvent.VK_PERIOD);
	}
	
	public void pressUp() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
	}
	
	public void pressDown() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
	}
	
	public void pressLeft() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.keyRelease(KeyEvent.VK_LEFT);
	}
	
	public void pressRight() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);
	}
	
	public void clickPosition(int coordinateX, int coordinateY) throws AWTException	{
		Robot robot = new Robot();
		robot.mouseMove(coordinateX, coordinateY);
		robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}

	public void clipBoardCopy(String stringToCopyToClipboard) {
		String str = stringToCopyToClipboard.toString();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		StringSelection strSel = new StringSelection(str);
		clipboard.setContents(strSel, null);
	}
	
	public void clipBoardPaste() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PASTE);
		robot.keyRelease(KeyEvent.VK_PASTE);
	}
	
	public void testFunction(String mainURLCall) throws InterruptedException, AWTException	{
		depthChartsBaseState(hostName);
		List<WebElement> FieldDataPosition = depthChartsFieldDataPositionDescription.getElement().findElements(By.xpath("//div[@class='removePlayerDepthChart triggerAble ']"));
		int depthChartsPlayerNumberOfDeleteButtonsBefore = FieldDataPosition.size();
		for (int a = 0; a < depthChartsPlayerNumberOfDeleteButtonsBefore; a++) {

			WebElement depthChartsPlayerDeleteButton = FieldDataPosition.get(a);
			depthChartsPlayerDeleteButton.click();
		}
		click(btnSaveDepthChart);
		int depthChartPlayerValueExpectedAfterDelete = 0;
		int depthChartsPlayerNumberOfDeleteButtonsAfter = FieldDataPosition.size();	
//		Assert.assertTrue((depthChartsPlayerNumberOfDeleteButtonsAfter + " out of "+ depthChartPlayerValueExpectedAfterDelete +" Depth Chart Player Deletes were performed."), depthChartsPlayerNumberOfDeleteButtonsAfter == 0);		
		Assert.assertEquals((depthChartsPlayerNumberOfDeleteButtonsAfter + " out of "+ depthChartPlayerValueExpectedAfterDelete +" Depth Chart Player Deletes were performed."), depthChartPlayerValueExpectedAfterDelete, depthChartsPlayerNumberOfDeleteButtonsAfter);
	}
}
