package com.mlb.qa.demo.mobile;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class PersonPageMobile extends AbstractPage {
	private final int WAIT_TIME = 3;
	
	@FindBy(xpath="//*[@class='nav-title' and contains(., 'Summary')]")
	public ExtendedWebElement personSummary;
	
	@FindBy(xpath="//*[@class='nav-title' and contains(., 'Stats')]")
	public ExtendedWebElement personStats;
	
	@FindBy(xpath="//*[@class='nav-title' and contains(., 'Splits')]")
	public ExtendedWebElement personSplits;
	
	@FindBy(xpath="//*[@class='nav-title' and contains(., 'Media')]")
	public ExtendedWebElement personMedia;
	
	@FindBy(xpath="//*[@class='nav-title' and contains(., 'Fantasy')]")
	public ExtendedWebElement personFantasy;
	
	
	@FindBy(xpath="//a[contains(., 'BIO')]")
	public ExtendedWebElement personBIO;

	@FindBy(id="player-bio")
	public ExtendedWebElement biographyLabel;
	

	public PersonPageMobile(WebDriver driver) 
	{
		super(driver);
		isOpened();
	}	
	
	protected void isOpened(){
		Assert.assertTrue("SUMMARY table is not recognized!", isElementPresent(personSummary, WAIT_TIME));
		Assert.assertTrue("STATS table is not recognized!", isElementPresent(personStats, WAIT_TIME));
		Assert.assertTrue("SPLITS table is not recognized!", isElementPresent(personSplits, WAIT_TIME));
		Assert.assertTrue("MEDIA table is not recognized!", isElementPresent(personMedia, WAIT_TIME));
		Assert.assertTrue("FANTASY table is not recognized!", isElementPresent(personFantasy, WAIT_TIME));
	}
	
	public void showBIO() {
		click(personBIO);
		
		Assert.assertTrue("Biography is not found!", isElementPresent(biographyLabel, WAIT_TIME));
	}
}
