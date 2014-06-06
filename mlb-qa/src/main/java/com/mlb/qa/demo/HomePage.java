package com.mlb.qa.demo;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class HomePage extends AbstractPage {
		//private static String TEAM_NAME = "//a[contains(text(), '%s')]";

		@FindBy(id="authorization-lnk")
		public ExtendedWebElement lnkLogin;

		@FindBy(id="email")
		public ExtendedWebElement txtEmail;

		@FindBy(id="authorization-password")
		public ExtendedWebElement txtPassword;

		@FindBy(xpath="//input[@value='Login']")
		public ExtendedWebElement btnLogin;
		
		@FindBy(id="nav-teams")
		public ExtendedWebElement lnkTeams;

		
		@FindBy(id="profile-lnk")
		public ExtendedWebElement lnkProfile;
		
		public HomePage(WebDriver driver) 
		{
			super(driver);
			setPageAbsoluteURL(Configuration.getEnvArg("web_url"));
			open();
		}
		
		public void login(String email, String password, String profile) {
			click(lnkLogin);
			type(txtEmail, email);
			type(txtPassword, password);
			
			click(btnLogin);
			Assert.assertTrue("Profile link was not found! Login operation is not successful!", isElementPresent(lnkProfile));
			Assert.assertEquals("Profile name is not match!", profile, lnkProfile.getText());
		}
		
		/*
		public TeamPageMobile openTeam(String team){
			hover(lnkTeams);
			
			ExtendedWebElement lnkTeam = new ExtendedWebElement(driver.findElement(By.xpath(String.format(TEAM_NAME, team))), "lnkTeam");
			click(lnkTeam);
			
			return new TeamPage(driver, team);
		}
		*/		
}
