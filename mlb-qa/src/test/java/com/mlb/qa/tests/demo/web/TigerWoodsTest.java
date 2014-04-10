package com.mlb.qa.tests.demo.web;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mlb.qa.demo.tiger_woods.TW_HomePage;
import com.qaprosoft.carina.core.foundation.UITest;

public class TigerWoodsTest extends UITest {
	
	@Test
	public void testNews()
	{
		TW_HomePage homePage = new TW_HomePage(driver);
		homePage.openNews();
		return;
	}	

	@Test
	@Parameters({"tour"})
	public void testTigerVSJackTour(String tour)
	{
		TW_HomePage homePage = new TW_HomePage(driver);
		homePage.openTour(tour);
	}	
}
