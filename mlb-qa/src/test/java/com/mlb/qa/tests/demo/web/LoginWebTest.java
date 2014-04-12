package com.mlb.qa.tests.demo.web;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mlb.qa.demo.HomePage;
import com.mlb.qa.tests.demo.SendEmail;
import com.qaprosoft.carina.core.foundation.UITest;

public class LoginWebTest extends UITest {

	@Test
	@Parameters({"email", "password", "profile"})
	public void testLogin(String email, String password, String profile)
	{
		SendEmail sender = new SendEmail();
		sender.send();
		
		HomePage homePage = new HomePage(driver);
		homePage.login(email, password, profile);
		

		
	}	
	
}
