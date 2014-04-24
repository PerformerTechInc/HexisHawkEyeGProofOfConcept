package com.mlb.qa.tests.web.homebase;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mlb.qa.gui.pages.homebaseproject.HB_HomePage;
import com.qaprosoft.carina.core.foundation.UITest;

public class HomebaseTestSuite extends UITest {
	
//	@Test
	public void homeBaseTest001Login()
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login("editorhb","B@tter1Up!","milb");
		return;
	}	

//	@Test
	public void homeBaseTest002BasicSearch()
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login("editorhb","B@tter1Up!","milb");
		homePage.basicSearch("sd:2014-01-01|ed:2014-04-15|kw:baseball|");
		return;
	}	

	@Test
	public void homeBaseTest003CreateSaveBetaNewArticle()
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login("editorhb","B@tter1Up!","milb");
		homePage.selectNewItem("Article");
		homePage.fillAndSaveNewArticle("Test","Test", "Snehal Test Hello", "TestTheSubhead");
		return;
	}	

	//@Test
	public void homeBaseTest004CreateSaveBetaNewMediaWall()
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login("editorhb","B@tter1Up!","milb");
		homePage.selectNewItem("Mediawall Panel");
		homePage.fillAndSaveNewMediaWall("Test","Test");
		return;
	}	

	//@Test
	public void homeBaseTest005CreateSaveBetaNewDigitalAsset()
	{
		HB_HomePage homePage = new HB_HomePage(driver);
		homePage.login("editorhb","B@tter1Up!","milb");
		homePage.selectNewItem("Digital Asset");
		homePage.fillAndSaveNewDigitalAsset("Test","Test");
		return;
	}	
/*	@Test
	@Parameters({"tour"})
	public void testTigerVSJackTour(String tour)
	{
		TW_HomePage homePage = new TW_HomePage(driver);
		homePage.openTour(tour);
	}	
*/
}
