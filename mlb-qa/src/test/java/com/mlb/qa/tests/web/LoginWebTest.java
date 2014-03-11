package com.mlb.qa.tests.web;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mlb.qa.gui.pages.HomePage;
import com.qaprosoft.carina.core.foundation.UITest;

public class LoginWebTest extends UITest {

	@Test
	@Parameters({"email", "password", "profile"})
	public void testLogin(String email, String password, String profile)
	{
		HomePage homePage = new HomePage(driver);
		homePage.login(email, password, profile);
	}	
	
}
