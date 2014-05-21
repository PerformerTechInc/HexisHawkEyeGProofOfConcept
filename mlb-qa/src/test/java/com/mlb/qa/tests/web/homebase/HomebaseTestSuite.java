package com.mlb.qa.tests.web.homebase;

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
	public static String valueMajorTagToolPlayer = "heller";
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
	public static String valueArticleTagline = "Tagline";
	//************ ARTICLE OBJECTS ************//	
	
	//************ DIGITAL ASSET OBJECTS ************//	
	public static String valueDigitalAssetInternalName = "Internal Name";
	public static String valueDigitalAssetHeadline = "Headline";
	//************ DIGITAL ASSET OBJECTS ************//	
	
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

	
	
	@Test
	public void homeBaseTestMiLB001Login()
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		return;
	}	

	@Test
	public void homeBaseTestMiLB002BasicSearch()
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.basicSearch(valueBasicSearch);
		return;
	}	

	@Test
	public void homeBaseTestMiLB003CreateSaveBetaNewArticle() throws InterruptedException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.selectNewItem("Article");
		homePage.fillAndSaveNewArticle(mainURL,valueArticleInternalName,valueArticleHeadline,valueArticleSubhead,valueArticleAltHeadline,valueArticleByline,valueArticleSeoHeadline,valueArticlePoll,valueMinorTagToolPlayer,valueArticleBlurb,valueArticleTagline);
		return;
	}	

	@Test
	public void homeBaseTestMiLB004CreateSaveBetaNewDigitalAsset() throws InterruptedException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.selectNewItem("Digital Asset");
		homePage.fillAndSaveNewDigitalAsset(mainURL,valueDigitalAssetInternalName,valueDigitalAssetHeadline, valueMinorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMiLB005CreateSaveBetaNewFieldOption() throws InterruptedException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.selectNewItem("Field Option");
		homePage.fillAndSaveNewFieldOption(mainURL,valueFieldOptionInternalName,valueFieldOptionDisplayName,valueFieldOptionValue,valueMinorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMiLB006CreateSaveBetaNewHighlight() throws InterruptedException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.selectNewItem("Hightlight");
		homePage.fillAndSaveNewHighlight(mainURL,valueHighlightInternalName,valueHighlightYear,valueMinorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMiLB007CreateSaveBetaNewHTMLPage() throws InterruptedException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.selectNewItem("HTML Page");
		homePage.fillAndSaveNewHTMLPage(mainURL,valueHTMLPageInternalName,valueHTMLPageHeadline,valueHTMLPageBlurb, valueMinorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMiLB008CreateSaveBetaNewLink() throws InterruptedException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.selectNewItem("Link");
		homePage.fillAndSaveNewLink(mainURL,valueLinkInternalName,valueLinkLinkText,valueLinkLinkURL, valueLinkWidth,valueLinkHeight, valueMinorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMiLB009CreateSaveBetaNewMediaWall() throws InterruptedException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.selectNewItem("Mediawall Panel");
		homePage.fillAndSaveNewMediaWall(mainURL,valueMediawallInternalName,valueMediawallHeadline,valueMediawallURLText, valueMediawallURL,valueMediawallMobileURL,valueMediawallSponsorURL,valueMediawallBlurb,valueMediawallNotes, valueMediawallDisplayTimeInSeconds, valueMediawallVideoAlias, valueMinorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMiLB010CreateSaveBetaNewNotebook() throws InterruptedException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.selectNewItem("Notebook");
		homePage.fillAndSaveNewNotebook(mainURL,valueNotebookInternalName,valueNotebookHeadline,valueNotebookByline,valueNotebookSource, valueNotebookTagline, valueMinorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMiLB011CreateSaveBetaNewPhotoGallery() throws InterruptedException
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.selectNewItem("Photo Gallery");
		homePage.fillAndSaveNewPhotoGallery(mainURL,valuePhotoGalleryInternalName,valuePhotoGalleryTitle,valuePhotoGallerySpanishTitle,valuePhotoGalleryBlurb,valuePhotoGallerySpanishBlurb, valueMinorTagToolPlayer);
		return;
	}	



}
