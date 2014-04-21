package com.mlb.qa.android.at_bat.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * MLB At Bat - Team Schedule Page
 * @author boyle
 *
 */
public class AtBatSchedulePage extends AtBatAndroidPage {

	@FindBy(xpath = "//TextView[@text='Month']")
	private ExtendedWebElement monthLink;
	@FindBy(xpath = "//TextView[@text='List']")
	private ExtendedWebElement listLink;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/schedulemonthwrapper")
	private ExtendedWebElement monthContainer;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/teamschedulelistlayout")
	private ExtendedWebElement listContainer;

	public AtBatSchedulePage(WebDriver driver) {
		super(driver);
	}

	public AtBatSchedulePage selectList() {
		if (isElementPresent(listLink, delay)) {
			click(listLink);
		}

		return new AtBatSchedulePage(driver);
	}

	public AtBatSchedulePage selectMonth() {
		if (isElementPresent(monthLink, delay)) {
			click(monthLink);
		}

		return new AtBatSchedulePage(driver);
	}

	public boolean isListVisible() {
		if (isElementPresent(listLink, delay)) {
			return true;
		}
		return false;
	}

	public boolean isMonthVisible() {
		if (isElementPresent(monthLink, delay)) {
			return true;
		}
		return false;
	}
}
