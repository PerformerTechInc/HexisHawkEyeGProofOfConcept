package com.mlb.qa.tests.web.homebase;

import java.awt.AWTException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mlb.qa.gui.pages.homebaseproject.HB_HomePage;
import com.qaprosoft.carina.core.foundation.UITest;

public class HomebaseTestSuite extends UITest {

	//************ LOGIN OBJECTS ************//	
	public static String mainURL = "https://qahomebase.mlbcontrol.net/";
	public static String loginUser = "editorhb";
	public static String loginPassword = "B@tter1Up!";
	//************ LOGIN OBJECTS ************//	

	//************ MINOR LEAGUE OBJECTS ************//	
	public static String minorLeagueSiteSelection = "milb";
	public static String valueMinorTagToolPlayer = "heller";
	//************ MINOR LEAGUE OBJECTS ************//	

	//************ MAJOR LEAGUE OBJECTS ************//	
	public static String majorLeagueSiteSelection = "mlb";
	public static String valueMajorTagToolPlayer = "jeter";
	//************ MAJOR LEAGUE OBJECTS ************//	

	//************ SEARCH OBJECTS ************//	
	public static String valueBasicSearch = "sd:2014-01-01|ed:2014-04-15|kw:baseball|";
	//************ SEARCH OBJECTS ************//	

	//************ ARTICLE OBJECTS ************//	
	public static String valueArticleInternalName = "Internal Name";
	public static String valueArticleHeadline = "Headline";
	public static String valueArticleSubhead = "Subhead";
	public static String valueArticleAltHeadline = "Alt Headline";
	public static String valueArticleByline = "Byline";
	public static String valueArticleSeoHeadline = "SEO Headline";
	public static String valueArticlePoll = "Poll";
	public static String valueArticleBlurb = "Blurb";
	public static String valueArticleNotes = "Notes";
	public static String valueArticleTagline = "Tagline";
	//************ ARTICLE OBJECTS ************//	
	
	//************ ARTICLE-VIEW OBJECTS ************//	
	public static String valueArticleViewInternalName = "Internal Name";
	public static String valueArticleViewName = "Name";
	public static String valueArticleViewViewKey = "View Key";
	//************ ARTICLE-VIEW OBJECTS ************//	

	//************ AUDIO SCHEDULE OBJECTS ************//	
	public static String valueAudioScheduleInternalName = "Internal Name";
	//************ AUDIO SCHEDULE OBJECTS ************//	

	//************ BALLPARK OBJECTS ************//	
	public static String valueBallparkInternalName = "Internal Name";
	public static String valueBallparkID = "ID";
	public static String valueBallparkName = "Name";
	public static String valueBallparkAddress1 = "123 Address1";
	public static String valueBallparkAddress2 = "Apt Address2";
	public static String valueBallparkLocation = "Location";
	public static String valueBallparkMapType = "Map Type";
	public static String valueBallparkMapVersion = "Map Version 1.0";
	public static String valueBallparkFacebookID = "Facebook ID";
	public static String valueBallparkFoursquareID = "Foursquare ID";
	public static String valueBallparkWebsiteURL = "http://www.WebsiteURL.com";
	public static String valueBallparkThumbnailURL = "http://www.ThumbnailURL.com";
	public static String valueBallparkThumbnailCaption = "Thumbnail Caption";
	public static String valueBallparkTwitterHashTags = "#Twitter #Hash #Tags";
	public static String valueBallparkAboutURL = "http://www.AboutURL.com";
	public static String valueBallparkScheduleURL = "http://www.ScheduleURL.com";
	public static String valueBallparkSmallThumbnailURL = "http://www.SmallThumbnailURL.com";
	public static String valueBallparkStartYear = "Start Year";
	public static String valueBallparkEndYear = "End Year";
	public static String valueBallparkUpgradeURL = "Upgrade URL";
	public static String valueBallparkAbout = "About";
	public static String valueBallparkEventsText = "Events Text";
	public static String valueBallparkSponsorImageText = "Sponsor Image Text";
	public static String valueBallparkSponsorImageURL = "http://www.SponsorImageURL.com";
	public static String valueBallparkSponsorImage2Text = "Sponsor Image 2 Text";
	public static String valueBallparkSponsorImage2URL = "http://www.SponsorImage2URL.com";
	public static String valueBallparkTicketsText = "Tickets Text";
	public static String valueBallparkTicketsURL = "http://www.TicketsURL.com";
	public static String valueBallparkTicketsErrorText = "Tickets Error Text";
	//************ BALLPARK OBJECTS ************//	

	//************ BALLPARK MENU OBJECTS ************//	
	public static String valueBallparkMenuInternalName = "Internal Name";
	public static String valueBallparkMenuDisplayName = "Display Name";
	public static String valueBallparkMenuDisplayImageURL = "http://www.DisplayImageURL.com";
	public static String valueBallparkMenuLinkURL = "http:/www.LinkURL.com";
	public static String valueBallparkMenuLinkName = "Menu Link Name";
	public static String valueBallparkMenuBundleKey = "Bundle Key";
	public static String valueBallparkMenuBundleName = "Bundle Name";
	public static String valueBallparkMenuBundleURL = "http://www.BundleURL.com";
	public static String valueBallparkMenuSharingURL = "http://www.SharingURL.com";
	public static String valueBallparkMenuSharingText = "Sharing Text";
	public static String valueBallparkMenuErrorText = "Error Text";
	public static String valueBallparkMenuSourceURL = "http://www.SourceURL.com";
	//************ BALLPARK MENU OBJECTS ************//	

	//************ BALLPARK MUSIC OBJECTS ************//	
	public static String valueBallparkMusicInternalName = "Internal Name";
	public static String valueBallparkMusicTitle = "Title";
	public static String valueBallparkMusicArtist = "Artist";
	public static String valueBallparkMusicDescription = "Description";
	public static String valueBallparkMusicThumbnail = "Thumbnail";
	public static String valueBallparkMusicRank = "Rank";
	//************ BALLPARK MUSIC OBJECTS ************//	
	
	//************ BALLPARK SUBMENU OBJECTS ************//	
	public static String valueBallparkSubmenuInternalName = "Internal Name";
	public static String valueBallparkSubmenuDisplayName = "Display Name";
	public static String valueBallparkSubmenuDisplayImageURL = "http://www.DisplayImageURL.com";
	public static String valueBallparkSubmenuLinkURL = "http:/www.LinkURL.com";
	public static String valueBallparkSubmenuLinkName = "Menu Link Name";
	public static String valueBallparkSubmenuBundleKey = "Bundle Key";
	public static String valueBallparkSubmenuBundleName = "Bundle Name";
	public static String valueBallparkSubmenuBundleURL = "http://www.BundleURL.com";
	public static String valueBallparkSubmenuSharingURL = "http://www.SharingURL.com";
	public static String valueBallparkSubmenuSharingText = "Sharing Text";
	public static String valueBallparkSubmenuErrorText = "Error Text";
	public static String valueBallparkSubmenuSourceURL = "http://www.SourceURL.com";
	//************ BALLPARK SUBMENU OBJECTS ************//	

	//************ BLOG CONTENT OBJECTS ************//	
	public static String valueBlogContentInternalName = "Internal Name";
	public static String valueBlogContentURL = "http://www.URL.com";
	public static String valueBlogContentURLText = "URL Text";
	public static String valueBlogContentHeadline = "Headline";
	public static String valueBlogContentAltHeadline = "Alt Headline";
	public static String valueBlogContentSEOHeadline = "SEO Headline";
	public static String valueBlogContentBlurb = "Blurb";
	public static String valueBlogContentByline = "Byline";
	public static String valueBlogContentCaption = "Caption";
	public static String valueBlogContentMediaCredit = "Media Credit";
	public static String valueBlogContentBody = "Body";
	public static String valueBlogContentSummary = "Summary";
	//************ BLOG CONTENT OBJECTS ************//	

	//************ CHRON OBJECTS ************//	
	public static String valueChronInternalName = "Internal Name";
	public static String valueChronDateNotation = "Date Notation";
	public static String valueChronYear = "Year";
	public static String valueChronDisplayYear = "Display Year";
	public static String valueChronTitle = "Title";
	public static String valueChronCMSDescription = "CMS Description";
	//************ CHRON OBJECTS ************//	

	//************ CLOSED CAPTION OBJECTS ************//	
	public static String valueClosedCaptionInternalName = "Internal Name";
	//************ CLOSED CAPTION OBJECTS ************//	

	//************ CLUB PROMO OBJECTS ************//	
	public static String valueClubPromoInternalName = "Internal Name";
	public static String valueClubPromoURLExtension = "URL Extension";
	public static String valueClubPromoEventTitle = "Event Title";
	public static String valueClubPromoEventSubtitle = "Event Subtitle";
	public static String valueClubPromoPromoText = "Promo Text";
	public static String valueClubPromoMobileTicketsText = "Mobile Tickets Text";
	public static String valueClubPromoMobileTicketsURL = "http://www.MobileTicketsURL.com";
	public static String valueClubPromoTicketsURL = "http://www.TicketsURL.com";
	public static String valueClubPromoTextCampaignPromo = "Text Campaign Promo";
	public static String valueClubPromoSocialKeyword = "Social Keyword";
	public static String valueClubPromoHighlightsTitle = "Highlights Title";
	public static String valueClubPromoLocationAddress = "Location Address";
	public static String valueClubPromoEventMapTitle = "Event Map Title";
	public static String valueClubPromoScheduleTitle = "Schedule Title";
	public static String valueClubPromoFAQTitle = "FAQ Title";
	//************ CLUB PROMO OBJECTS ************//	

	//************ CONTRIBUTOR OBJECTS ************//	
	public static String valueContributorInternalName = "Internal Name";
	public static String valueContributorFirstName = "First Name";
	public static String valueContributorLastName = "Last Name";
	public static String valueContributorTitle = "Title";
	public static String valueContributorEmail = "Email@mlb.com";
	public static String valueContributorTwitterHandle = "@TwitterHandle";
	public static String valueContributorBlog = "Blog";
	public static String valueContributorBlogTitle = "Blog Title";
	public static String valueContributorRSSFeed = "RSS Feed";
	public static String valueContributorFacebookID = "Facebook ID";
	public static String valueContributorActiveTab = "Active Tab";
	public static String valueContributorHideArticles = "Hide Articles";
	public static String valueContributorVideoKeywordType = "Video Keyword Type";
	public static String valueContributorVideoKeywordValue = "Video Keyword Value";
	public static String valueContributorVideoLandingPage = "Video Landing Page";
	public static String valueContributorBlurb = "Blurb";
	//************ CONTRIBUTOR OBJECTS ************//	

	//************ DAILY EMAIL  OBJECTS ************//	
	public static String valueDailyEmailInternalName = "Internal Name";
	public static String valueDailyEmailSubject = "Subject";
	public static String valueDailyEmailSubjectB = "Subject B";
	public static String valueDailyEmailTriviaQuestion = "Trivia Question";
	public static String valueDailyEmailTriviaAnswer = "Trivia Answer";
	//************ DAILY EMAIL  OBJECTS ************//	

	//************ DEVICE PAGE OBJECTS ************//	
	public static String valueDevicePageInternalName = "Internal Name";
	public static String valueDevicePageHeadline = "Headline";
	public static String valueDevicePageBlurb = "Blurb";
	public static String valueDevicePageYearlyPurchaseFlow = "Yearly Purchase Flow";
	public static String valueDevicePageMonthlyPurchaseFlow = "Monthly Purchase Flow";
	public static String valueDevicePageUpgradeLink = "http://www.UpgradeLink.com";
	public static String valueDevicePageActivationLink = "http://www.ActivationLink.com";
	//************ DEVICE PAGE OBJECTS ************//	

	//************ DIGITAL ASSET OBJECTS ************//	
	public static String valueDigitalAssetInternalName = "Internal Name";
	public static String valueDigitalAssetHeadline = "Headline";
	//************ DIGITAL ASSET OBJECTS ************//	
	
	//************ DRAWER OBJECTS ************//	
	public static String valueDrawerInternalName = "Internal Name";
	public static String valueDrawerKicker = "Kicker";
	public static String valueDrawerCustomContent = "Custom Content";
	public static String valueDrawerBlurb = "Blurb";
	public static String valueDrawerURL = "http://www.URL.com";
	public static String valueDrawerURLText = "URL Text";
	public static String valueDrawerNumberOfItems = "Number Of Items";
	//************ DRAWER OBJECTS ************//	

	//************ EVENT OBJECTS ************//	
	public static String valueEventInternalName = "Internal Name";
	public static String valueEventProgramID = "Program ID";
	public static String valueEventProgram = "Program";
	public static String valueEventLocation = "Location";
	public static String valueEventEventTitle = "Event Title";
	public static String valueEventDescription = "Event Description";
	public static String valueEventURL = "http://www.EventURL.com";
	//************ EVENT OBJECTS ************//	
	
	//************ FEATURE OBJECTS ************//	
	public static String valueFeatureInternalName = "Internal Name";
	public static String valueFeatureHeadline = "Headline";
	public static String valueFeatureURL = "http://www.URL.com";
	public static String valueFeatureURLText = "URL Text";
	public static String valueFeatureMobileURL = "http://www.MobileURL.com";
	public static String valueFeatureBlurb = "Blurb";
	//************ FEATURE OBJECTS ************//	

	//************ FEATURES OBJECTS ************//	
	public static String valueFeaturesInternalName = "Internal Name";
	public static String valueFeaturesNumberOfItems = "Number Of Items";
	//************ FEATURES OBJECTS ************//	

	//************ FIELD OPTION OBJECTS ************//	
	public static String valueFieldOptionInternalName = "Internal Name";
	public static String valueFieldOptionDisplayName = "Display Name";
	public static String valueFieldOptionValue = "Value";
	//************ FIELD OPTION OBJECTS ************//	
	
	//************ HIGHLIGHT OBJECTS ************//	
	public static String valueHighlightInternalName = "Internal Name";
	public static String valueHighlightYear = "1982";
	//************ HIGHLIGHT OBJECTS ************//	
	
	//************ HTML PAGE OBJECTS ************//	
	public static String valueHTMLPageInternalName = "Internal Name";
	public static String valueHTMLPageHeadline = "Headline";
	public static String valueHTMLPageBlurb = "Blurb";
	//************ HTML PAGE OBJECTS ************//	

	//************ LINK OBJECTS ************//	
	public static String valueLinkInternalName = "Internal Name";
	public static String valueLinkLinkText = "Link Test";
	public static String valueLinkLinkURL = "http://www.milb.com";
	public static String valueLinkWidth = "320";
	public static String valueLinkHeight = "240";
	//************ LINK OBJECTS ************//	
	
	//************ MEDIAWALL PANEL OBJECTS ************//	
	public static String valueMediawallInternalName = "Internal Name";
	public static String valueMediawallHeadline = "Headline";
	public static String valueMediawallURLText = "URL Text";
	public static String valueMediawallURL = "http://www.milb.com";
	public static String valueMediawallMobileURL = "http://m.mlb.com";
	public static String valueMediawallSponsorURL = "http://www.mlb.com";
	public static String valueMediawallBlurb = "Blurb";
	public static String valueMediawallNotes = "Notes";
	public static String valueMediawallDisplayTimeInSeconds = "30";
	public static String valueMediawallVideoAlias = "Baseball.mov";
	//************ MEDIAWALL PANEL OBJECTS ************//	

	//************ NOTEBOOK OBJECTS ************//	
	public static String valueNotebookInternalName = "Internal Name";
	public static String valueNotebookHeadline = "Headline";
	public static String valueNotebookByline = "Byline";
	public static String valueNotebookSource = "Source";
	public static String valueNotebookTagline = "Tagline";
	//************ NOTEBOOK OBJECTS ************//	

	//************ PHOTO GALLERY OBJECTS ************//	
	public static String valuePhotoGalleryInternalName = "Internal Name";
	public static String valuePhotoGalleryTitle = "Title";
	public static String valuePhotoGallerySpanishTitle = "El Title En Espanol";
	public static String valuePhotoGalleryBlurb = "Blurb";
	public static String valuePhotoGallerySpanishBlurb = "El Blurb En Espanol";
	//************ PHOTO GALLERY OBJECTS ************//	

	
	
	//************ MAJOR LEAGUE TESTS ************//
	//************ MAJOR LEAGUE TESTS ************//
	//************ MAJOR LEAGUE TESTS ************//

	@Test
	public void homeBaseTestMLB001Login() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException 
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		return;
	}	

	@Test
	public void homeBaseTestMLB002BasicSearch() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.basicSearch(valueBasicSearch);
		return;
	}	

	@Test
	public void homeBaseTestMLB003CreateSaveBetaNewArticle() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Article");
		homePage.fillAndSaveNewArticle(mainURL,"beta",valueArticleInternalName,valueArticleHeadline,valueArticleSubhead,valueArticleAltHeadline,valueArticleByline,valueArticleSeoHeadline,valueArticlePoll,valueMajorTagToolPlayer,valueArticleBlurb, valueArticleNotes,valueArticleTagline);
		return;
	}	

	@Test
	public void homeBaseTestMLB004CreateSaveBetaNewArticleView() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Article View");
		homePage.fillAndSaveNewArticleView(mainURL,"beta", valueArticleViewInternalName,valueArticleViewName,valueArticleViewViewKey, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB005CreateSaveBetaNewAudioSchedule() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Audio Schedule");
		homePage.fillAndSaveNewAudioSchedule(mainURL,"beta", valueAudioScheduleInternalName,valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB006CreateSaveBetaNewBallpark() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Ballpark");
		homePage.fillAndSaveNewBallpark(mainURL,"beta", valueBallparkInternalName, valueBallparkID, valueBallparkName, valueBallparkAddress1, valueBallparkAddress2, valueBallparkLocation, valueBallparkMapType, valueBallparkMapVersion, valueBallparkFacebookID, valueBallparkFoursquareID, valueBallparkWebsiteURL, valueBallparkThumbnailURL, valueBallparkThumbnailCaption, valueBallparkTwitterHashTags, valueBallparkAboutURL, valueBallparkScheduleURL, valueBallparkSmallThumbnailURL, valueBallparkStartYear, valueBallparkEndYear, valueBallparkUpgradeURL, valueBallparkAbout, valueBallparkEventsText, valueBallparkSponsorImageText, valueBallparkSponsorImageURL, valueBallparkSponsorImage2Text, valueBallparkSponsorImage2URL, valueBallparkTicketsText, valueBallparkTicketsURL, valueBallparkTicketsErrorText, valueMajorTagToolPlayer);
 		return;
	}	

	@Test
	public void homeBaseTestMLB007CreateSaveBetaNewBallparkMenu() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Ballpark Menu");
		homePage.fillAndSaveNewBallparkMenu(mainURL,"beta", valueBallparkMenuInternalName, valueBallparkMenuDisplayName, valueBallparkMenuDisplayImageURL, valueBallparkMenuLinkURL, valueBallparkMenuLinkName, valueBallparkMenuBundleKey, valueBallparkMenuBundleName, valueBallparkMenuBundleURL, valueBallparkMenuSharingURL, valueBallparkMenuSharingText, valueBallparkMenuErrorText, valueBallparkMenuSourceURL, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB008CreateSaveBetaNewBallparkMusic() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Ballpark Music");
		homePage.fillAndSaveNewBallparkMusic(mainURL,"beta", valueBallparkMusicInternalName, valueBallparkMusicTitle, valueBallparkMusicArtist, valueBallparkMusicDescription, valueBallparkMusicThumbnail, valueBallparkMusicRank, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB009CreateSaveBetaNewBallparkSubmenu() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Ballpark Submenu");
		homePage.fillAndSaveNewBallparkSubmenu(mainURL,"beta", valueBallparkMenuInternalName, valueBallparkMenuDisplayName, valueBallparkMenuDisplayImageURL, valueBallparkMenuLinkURL, valueBallparkMenuLinkName, valueBallparkMenuBundleKey, valueBallparkMenuBundleName, valueBallparkMenuBundleURL, valueBallparkMenuSharingURL, valueBallparkMenuSharingText, valueBallparkMenuErrorText, valueBallparkMenuSourceURL, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB010CreateSaveBetaNewBlogContent() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Blog Content");
		homePage.fillAndSaveNewBlogContent(mainURL,"beta",  valueBlogContentInternalName, valueBlogContentURL, valueBlogContentURLText, valueBlogContentHeadline, valueBlogContentAltHeadline, valueBlogContentSEOHeadline, valueBlogContentBlurb, valueBlogContentByline, valueBlogContentCaption, valueBlogContentMediaCredit, valueBlogContentBody, valueBlogContentSummary, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB011CreateSaveBetaNewChron() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Chron");
		homePage.fillAndSaveNewChron(mainURL,"beta", valueChronInternalName, valueChronDateNotation, valueChronYear, valueChronDisplayYear, valueChronTitle, valueChronCMSDescription, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB012CreateSaveBetaNewClosedCaption() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Closed Caption");
		homePage.fillAndSaveNewClosedCaption(mainURL,"beta", valueClosedCaptionInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB013CreateSaveBetaNewClubPromo() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Club Promo");
		homePage.fillAndSaveNewClubPromo(mainURL,"beta", valueClubPromoInternalName, valueClubPromoURLExtension, valueClubPromoEventTitle, valueClubPromoEventSubtitle, valueClubPromoPromoText, valueClubPromoMobileTicketsText, valueClubPromoMobileTicketsURL, valueClubPromoTicketsURL, valueClubPromoTextCampaignPromo, valueClubPromoSocialKeyword, valueClubPromoHighlightsTitle, valueClubPromoLocationAddress, valueClubPromoEventMapTitle, valueClubPromoScheduleTitle, valueClubPromoFAQTitle, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB014CreateSaveBetaNewContributor() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Contributor");
		homePage.fillAndSaveNewContributor(mainURL,"beta", valueContributorInternalName, valueContributorFirstName, valueContributorLastName, valueContributorTitle, valueContributorEmail, valueContributorTwitterHandle, valueContributorBlog, valueContributorBlogTitle, valueContributorRSSFeed, valueContributorFacebookID, valueContributorActiveTab, valueContributorHideArticles, valueContributorVideoKeywordType, valueContributorVideoKeywordValue, valueContributorVideoLandingPage, valueContributorBlurb, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB015CreateSaveBetaNewDailyEmail() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Daily Email");
		homePage.fillAndSaveNewDailyEmail(mainURL,"beta", valueDailyEmailInternalName, valueDailyEmailSubject, valueDailyEmailSubjectB, valueDailyEmailTriviaQuestion, valueDailyEmailTriviaAnswer, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB016CreateSaveBetaNewDevicePage() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Device Page");
		homePage.fillAndSaveNewDevicePage(mainURL,"beta", valueDevicePageInternalName, valueDevicePageHeadline, valueDevicePageBlurb, valueDevicePageYearlyPurchaseFlow, valueDevicePageMonthlyPurchaseFlow, valueDevicePageUpgradeLink, valueDevicePageActivationLink, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB017CreateSaveBetaNewDigitalAsset() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Digital Asset");
		homePage.fillAndSaveNewDigitalAsset(mainURL,"beta", valueDigitalAssetInternalName,valueDigitalAssetHeadline, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB018CreateSaveBetaNewDrawer() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Drawer");
		homePage.fillAndSaveNewDrawer(mainURL,"beta", valueDrawerInternalName, valueDrawerKicker, valueDrawerCustomContent, valueDrawerBlurb, valueDrawerURL, valueDrawerURLText, valueDrawerNumberOfItems, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB019CreateSaveBetaNewEvent() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Event");
		homePage.fillAndSaveNewEvent(mainURL,"beta", valueEventInternalName, valueEventProgramID, valueEventProgram, valueEventLocation, valueEventEventTitle, valueEventDescription, valueEventURL, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB020CreateSaveBetaNewFeature() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Feature");
		homePage.fillAndSaveNewFeature(mainURL,"beta", valueFeatureInternalName, valueFeatureHeadline, valueFeatureURL, valueFeatureURLText, valueFeatureMobileURL, valueFeatureBlurb, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB021CreateSaveBetaNewFeatures() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Features");
		homePage.fillAndSaveNewFeatures(mainURL,"beta", valueFeaturesInternalName, valueFeaturesNumberOfItems, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB022CreateSaveBetaNewFieldOption() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Field Option");
		homePage.fillAndSaveNewFieldOption(mainURL,"beta", valueFieldOptionInternalName,valueFieldOptionDisplayName,valueFieldOptionValue,valueMinorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB023CreateSaveBetaNewGamePreview() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Game Preview");
		homePage.fillAndSaveNewGamePreview(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB024CreateSaveBetaNewGameWrap() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Game Wrap");
		homePage.fillAndSaveNewGameWrap(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB025CreateSaveBetaNewHighlight() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Hightlight");
		homePage.fillAndSaveNewHighlight(mainURL,"beta", valueHighlightInternalName,valueHighlightYear,valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB026CreateSaveBetaNewHomepageTab() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Homepage Tab");
		homePage.fillAndSaveNewHomepageTab(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB027CreateSaveBetaNewHPConfig() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("HP Config");
		homePage.fillAndSaveNewHPConfig(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB028CreateSaveBetaNewInstagramPhoto() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Instagram Photo");
		homePage.fillAndSaveNewInstagramPhoto(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB029CreateSaveBetaNewKiosk() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Kiosk");
		homePage.fillAndSaveNewKiosk(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB030CreateSaveBetaNewLink() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Link");
		homePage.fillAndSaveNewLink(mainURL,"beta", valueLinkInternalName,valueLinkLinkText,valueLinkLinkURL, valueLinkWidth,valueLinkHeight, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB031CreateSaveBetaNewList() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("List");
		homePage.fillAndSaveNewList(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB032CreateSaveBetaNewMediawall() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Mediawall");
		homePage.fillAndSaveNewMediawall(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB033CreateSaveBetaNewMediawallOverlay() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Mediawall Overlay");
		homePage.fillAndSaveNewMediawallOverlay(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB034CreateSaveBetaNewMediaWallPanel() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Mediawall Panel");
		homePage.fillAndSaveNewMediaWallPanel(mainURL,"beta", valueMediawallInternalName,valueMediawallHeadline,valueMediawallURLText, valueMediawallURL,valueMediawallMobileURL,valueMediawallSponsorURL,valueMediawallBlurb,valueMediawallNotes, valueMediawallDisplayTimeInSeconds, valueMediawallVideoAlias, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB035CreateSaveBetaNewMLBTVAdModule() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("MLBTV Ad Module");
		homePage.fillAndSaveNewMLBTVAdModule(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB036CreateSaveBetaNewMoundBall() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Mound Ball");
		homePage.fillAndSaveNewMoundBall(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB037CreateSaveBetaNewMusicLink() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Music Link");
		homePage.fillAndSaveNewMusicLink(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB038CreateSaveBetaNewNote() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Note");
		homePage.fillAndSaveNewNote(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB039CreateSaveBetaNewNotebook() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Notebook");
		homePage.fillAndSaveNewNotebook(mainURL,"beta", valueNotebookInternalName,valueNotebookHeadline,valueNotebookByline,valueNotebookSource, valueNotebookTagline, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB040CreateSaveBetaNewPage() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Page");
		homePage.fillAndSaveNewPage(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB041CreateSaveBetaNewPhotoGallery() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Photo Gallery");
		homePage.fillAndSaveNewPhotoGallery(mainURL,"beta", valuePhotoGalleryInternalName,valuePhotoGalleryTitle,valuePhotoGallerySpanishTitle,valuePhotoGalleryBlurb,valuePhotoGallerySpanishBlurb, valueMajorTagToolPlayer);
		return;
	}	
	
	@Test
	public void homeBaseTestMLB042CreateSaveBetaNewPhotoGalleryAlias() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Photo Gallery Alias");
		homePage.fillAndSaveNewPhotoGalleryAlias(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB043CreateSaveBetaNewPhotoGalleryList() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Photo Gallery List");
		homePage.fillAndSaveNewPhotoGalleryList(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB044CreateSaveBetaNewProspect() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Prospect");
		homePage.fillAndSaveNewProspect(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB045CreateSaveBetaNewPodcastDetail() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Podcast Detail");
		homePage.fillAndSaveNewPodcastDetail(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB046CreateSaveBetaNewPodcastEpisode() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Podcast Episode");
		homePage.fillAndSaveNewPodcastEpisode(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB047CreateSaveBetaNewPressRelease() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Press Release");
		homePage.fillAndSaveNewPressRelease(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB048CreateSaveBetaNewPressboxAsset() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Pressbox Asset");
		homePage.fillAndSaveNewPressboxAsset(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB049CreateSaveBetaNewPressboxAssetList() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Pressbox Asset List");
		homePage.fillAndSaveNewPressboxAssetList(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB050CreateSaveBetaNewPreviewAlias() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Preview Alias");
		homePage.fillAndSaveNewPreviewAlias(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB051CreateSaveBetaNewProgramShow() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Program Show");
		homePage.fillAndSaveNewProgramShow(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB052CreateSaveBetaNewPromoApplication() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Promo Application");
		homePage.fillAndSaveNewPromoApplication(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB053CreateSaveBetaNewQuoteSheet() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Quote Sheet");
		homePage.fillAndSaveNewQuoteSheet(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB054CreateSaveBetaNewRaffle() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Raffle");
		homePage.fillAndSaveNewRaffle(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB055CreateSaveBetaNewSchedule() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Schedule");
		homePage.fillAndSaveNewSchedule(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB056CreateSaveBetaNewScrapbook() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Scrapbook");
		homePage.fillAndSaveNewScrapbook(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB057CreateSaveBetaNewScrapbookPage() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Scrapbook Page");
		homePage.fillAndSaveNewScrapbookPage(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB058CreateSaveBetaNewSection() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Section");
		homePage.fillAndSaveNewSection(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB059CreateSaveBetaNewSeriesConfiguration() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Series Configuration");
		homePage.fillAndSaveNewSeriesConfiguration(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB060CreateSaveBetaNewShortContent() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Short Content");
		homePage.fillAndSaveNewShortContent(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB061CreateSaveBetaNewTicketPage() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Ticket Page");
		homePage.fillAndSaveNewTicketPage(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB062CreateSaveBetaNewTrendingModule() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Trending Module");
		homePage.fillAndSaveNewTrendingModule(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB063CreateSaveBetaNewTweet() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Tweet");
		homePage.fillAndSaveNewTweet(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB064CreateSaveBetaNewVideoTopicPage() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Video Topic Page");
		homePage.fillAndSaveNewVideoTopicPage(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB065CreateSaveBetaNewTwitterHandle() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Twitter Handle");
		homePage.fillAndSaveNewTwitterHandle(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB066CreateSaveBetaNewVideoClipList() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem("Video Clip List");
		homePage.fillAndSaveNewVideoClipList(mainURL,"beta", valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB067UploadPhotos() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectHomePageUploadPhotos();
		homePage.uploadPhotos(mainURL, valueMajorTagToolPlayer);
		return;
	}	

	
	//************ MAJOR LEAGUE TESTS ************//
	//************ MAJOR LEAGUE TESTS ************//
	//************ MAJOR LEAGUE TESTS ************//

	
	//************ MINOR LEAGUE TESTS ************//
	//************ MINOR LEAGUE TESTS ************//
	//************ MINOR LEAGUE TESTS ************//
	
	@Test
	public void homeBaseTestMiLB001Login() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.oldUIToNewUI(minorLeagueSiteSelection);
		return;
	}	

	@Test
	public void homeBaseTestMiLB002BasicSearch() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.oldUIToNewUI(minorLeagueSiteSelection);
		homePage.basicSearch(valueBasicSearch);
		return;
	}	

	@Test
	public void homeBaseTestMiLB003CreateSaveBetaNewArticle() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.oldUIToNewUI(minorLeagueSiteSelection);
		homePage.selectNewItem("Article");
		homePage.fillAndSaveNewArticle(mainURL,"beta",valueArticleInternalName,valueArticleHeadline,valueArticleSubhead,valueArticleAltHeadline,valueArticleByline,valueArticleSeoHeadline,valueArticlePoll,valueMinorTagToolPlayer,valueArticleBlurb, valueArticleNotes,valueArticleTagline);
		return;
	}	

	@Test
	public void homeBaseTestMiLB004CreateSaveBetaNewDigitalAsset() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.oldUIToNewUI(minorLeagueSiteSelection);
		homePage.selectNewItem("Digital Asset");
		homePage.fillAndSaveNewDigitalAsset(mainURL,"beta", valueDigitalAssetInternalName,valueDigitalAssetHeadline, valueMinorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMiLB005CreateSaveBetaNewFieldOption() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.oldUIToNewUI(minorLeagueSiteSelection);
		homePage.selectNewItem("Field Option");
		homePage.fillAndSaveNewFieldOption(mainURL,"beta", valueFieldOptionInternalName,valueFieldOptionDisplayName,valueFieldOptionValue,valueMinorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMiLB006CreateSaveBetaNewHighlight() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.oldUIToNewUI(minorLeagueSiteSelection);
		homePage.selectNewItem("Hightlight");
		homePage.fillAndSaveNewHighlight(mainURL,"beta", valueHighlightInternalName,valueHighlightYear,valueMinorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMiLB007CreateSaveBetaNewHTMLPage() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.oldUIToNewUI(minorLeagueSiteSelection);
		homePage.selectNewItem("HTML Page");
		homePage.fillAndSaveNewHTMLPage(mainURL,"beta", valueHTMLPageInternalName,valueHTMLPageHeadline,valueHTMLPageBlurb, valueMinorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMiLB008CreateSaveBetaNewLink() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.oldUIToNewUI(minorLeagueSiteSelection);
		homePage.selectNewItem("Link");
		homePage.fillAndSaveNewLink(mainURL,"beta", valueLinkInternalName,valueLinkLinkText,valueLinkLinkURL, valueLinkWidth,valueLinkHeight, valueMinorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMiLB009CreateSaveBetaNewMediaWallPanel() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.oldUIToNewUI(minorLeagueSiteSelection);
		homePage.selectNewItem("Mediawall Panel");
		homePage.fillAndSaveNewMediaWallPanel(mainURL,"beta", valueMediawallInternalName,valueMediawallHeadline,valueMediawallURLText, valueMediawallURL,valueMediawallMobileURL,valueMediawallSponsorURL,valueMediawallBlurb,valueMediawallNotes, valueMediawallDisplayTimeInSeconds, valueMediawallVideoAlias, valueMinorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMiLB010CreateSaveBetaNewNotebook() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.oldUIToNewUI(minorLeagueSiteSelection);
		homePage.selectNewItem("Notebook");
		homePage.fillAndSaveNewNotebook(mainURL,"beta", valueNotebookInternalName,valueNotebookHeadline,valueNotebookByline,valueNotebookSource, valueNotebookTagline, valueMinorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMiLB011CreateSaveBetaNewPhotoGallery() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.oldUIToNewUI(minorLeagueSiteSelection);
		homePage.selectNewItem("Photo Gallery");
		homePage.fillAndSaveNewPhotoGallery(mainURL,"beta", valuePhotoGalleryInternalName,valuePhotoGalleryTitle,valuePhotoGallerySpanishTitle,valuePhotoGalleryBlurb,valuePhotoGallerySpanishBlurb, valueMinorTagToolPlayer);
		return;
	}	

	//************ MINOR LEAGUE TESTS ************//
	//************ MINOR LEAGUE TESTS ************//
	//************ MINOR LEAGUE TESTS ************//


}
