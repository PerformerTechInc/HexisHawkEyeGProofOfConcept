package com.mlb.qa.android.at_bat.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.mlb.qa.android.common.page.AndroidPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

public class AtBatAndroidPage extends AndroidPage {
	
	@FindBy(id = "android:id/up")
	private ExtendedWebElement openMenuButton;

	public AtBatAndroidPage(WebDriver driver) {
		super(driver);
	}

	public Menu openMenu() {
		logger.debug("Open menu");
		click(openMenuButton);
		return new Menu(driver);
	}
}
