package com.mlb.qa.gui.pages.mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class HomePageMobile extends AbstractPage {

	private static String TEAM_NAME = "//a[contains(text(), '%s')]";
	
	@FindBy(id="overflow-nav-teams")
	public ExtendedWebElement lnkTeams;
	
	public HomePageMobile(WebDriver driver) 
	{
		super(driver);
		setPageAbsoluteURL(Configuration.getEnvArg("mobile_url"));
		open();
	}
	
	public TeamPageMobile openTeam(String team){
		click(lnkTeams);
		
		ExtendedWebElement lnkTeam = new ExtendedWebElement(driver.findElement(By.xpath(String.format(TEAM_NAME, team))), "lnkTeam");
		click(lnkTeam);
		
		return new TeamPageMobile(driver, team);
	}
	

}
