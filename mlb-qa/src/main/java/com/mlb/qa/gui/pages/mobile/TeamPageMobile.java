package com.mlb.qa.gui.pages.mobile;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.HTML;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class TeamPageMobile extends AbstractPage {

	@FindBy(xpath="//*[@id='site-navigation']/h1/a/img")
	public ExtendedWebElement captionTeam;
	
	@FindBy(id="nav-stats")
	public ExtendedWebElement lnkStats;
	
	public TeamPageMobile(WebDriver driver, String team) 
	{
		super(driver);
		assertOpened(team);
	}	

	
	protected void assertOpened(String team){
		if (isElementPresent(captionTeam, 5)) {
			String alt = captionTeam.getAttribute(HTML.ALT);
			Assert.assertTrue("Team '" + team + "' activation is not verified!", alt.contains(team));
		}
		else {
			Assert.fail("Team '" + team + "' was not activated!");
		}
	}
	
	public StatsPageMobile showStats(){
		click(lnkStats);
		return new StatsPageMobile(driver);
	}

}
