package com.mlb.qa.android.at_bat.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.mlb.qa.android.at_bat.page.AtBatMenu.MenuItem;
import com.mlb.qa.common.android.page.AndroidPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * Base Android Page for 'At Bat' Application
 */
public class AtBatAndroidPage extends AndroidPage {
	
	@FindBy(id = "android:id/up")
	private ExtendedWebElement openMenuButton;
	@FindBy(name = "Navigate up")
	private ExtendedWebElement openMenuButtonText;

	public AtBatAndroidPage(WebDriver driver) {
		super(driver);
	}

	public AtBatMenu openMenu() {
		logger.debug("Open menu");
		if (isElementPresent(openMenuButton, delay)) {
			click(openMenuButton);
		} else if (isElementPresent(openMenuButtonText, delay)){
			click(openMenuButtonText);
		}
		return new AtBatMenu(driver);
	}
	
	public AtBatMenuTeamsPage openTeamsFromMenu() {
		openMenu().selectMenuItem(MenuItem.TEAMS);
		return new AtBatMenuTeamsPage(driver);
	}
}
