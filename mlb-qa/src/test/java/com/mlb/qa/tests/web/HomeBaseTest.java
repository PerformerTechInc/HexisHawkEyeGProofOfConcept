package com.mlb.qa.tests.web;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mlb.qa.gui.pages.HomebaseHomePage;
import com.qaprosoft.carina.core.foundation.UITest;

public class HomeBaseTest extends UITest {

	@Test
	@Parameters({"username", "password", "profile"})
	public void checkHomebaseTest(String username, String password, String profile)
	{
		HomebaseHomePage homePage = new HomebaseHomePage(driver);
		homePage.login(username, password, profile);
		homePage.showHistory();
		homePage.hideHistory();
		homePage.search("Mobile");
	}

}
