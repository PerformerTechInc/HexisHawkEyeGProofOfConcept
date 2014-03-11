package com.mlb.qa.gui.pages.mobile;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class StatsPageMobile extends AbstractPage {
	private final static String HEADER = "Stats";
	private final static String SORTER_LABEL = "//div[text() = '%s']";
	private static String TEAM_PLAYER = "//a[contains(text(), '%s')]";
	
	@FindBy(xpath="//a[contains(text(), 'Batting')]")
	public ExtendedWebElement lnkBatting;
	
	@FindBy(xpath="//a[contains(text(), 'Pitching')]")
	public ExtendedWebElement lnkPitching;
	
	@FindBy(xpath="//a[contains(text(), 'Fielding')]")
	public ExtendedWebElement lnkFielding;
	
	@FindBy(xpath="//*[@id='stats_index']/div/div[2]/div/section/header/h2")
	public ExtendedWebElement labelHeader;

	public StatsPageMobile(WebDriver driver) {
		super(driver);
		isOpened();
	}
	
	public void sortStats(String role, String sortValue){
		
		if (role.equalsIgnoreCase("BATTING")){
			click(lnkBatting);
		} else if (role.equalsIgnoreCase("PITCHING")){
			click(lnkPitching);
		} else if (role.equalsIgnoreCase("FIELDING")){
			click(lnkFielding);
		}
		sort(sortValue);
	}
	
	private void sort(String sortValue){
		ExtendedWebElement lnkSort = new ExtendedWebElement(driver.findElement(By.xpath(String.format(SORTER_LABEL, sortValue))), "lnkSort");
		click(lnkSort);
		pause(1);
	}
	
	public PersonPageMobile openPerson(String person){
		ExtendedWebElement lnkPlayer = new ExtendedWebElement(driver.findElement(By.xpath(String.format(TEAM_PLAYER, person))), "lnkPlayer");
		click(lnkPlayer);
		return new PersonPageMobile(driver);
	}	
	
	protected void isOpened(){
		Assert.assertTrue("Label Header " + HEADER + "is not recognized!", isElementPresent(labelHeader));
		Assert.assertEquals("Header name is not match!", HEADER, labelHeader.getText());
	}
}
