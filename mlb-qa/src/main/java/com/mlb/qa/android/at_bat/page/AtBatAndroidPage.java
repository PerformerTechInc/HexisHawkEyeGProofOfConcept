package com.mlb.qa.android.at_bat.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.mlb.qa.android.at_bat.page.AtBatMenu.MenuItem;
import com.mlb.qa.android.common.page.AndroidPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * Base Android Page for 'At Bat' Application
 */
public class AtBatAndroidPage extends AndroidPage {
	
	@FindBy(id = "android:id/up")
	private ExtendedWebElement openMenuButton;

	public AtBatAndroidPage(WebDriver driver) {
		super(driver);
	}

	public AtBatMenu openMenu() {
		logger.debug("Open menu");
		click(openMenuButton);
		return new AtBatMenu(driver);
	}
	
	public AtBatMenuTeamsPage openTeamsFromMenu() {
		openMenu().selectMenuItem(MenuItem.TEAMS);
		return new AtBatMenuTeamsPage(driver);
	}
}
