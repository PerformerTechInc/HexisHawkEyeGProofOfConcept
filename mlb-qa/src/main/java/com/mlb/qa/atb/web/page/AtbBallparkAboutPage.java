package com.mlb.qa.atb.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class AtbBallparkAboutPage extends AbstractPage {

	@FindBy(xpath = "//h2[contains(text(), 'Information') or contains(text(), 'Guide')]/../../div/p[1]")
	private ExtendedWebElement ballparkTextDescription;

	public AtbBallparkAboutPage(WebDriver driver, String url) {
		super(driver);
		pageURL = url;
	}

/*	public static AtbBallparkAboutPage open(WebDriver driver, String url) {
		driver.get(url);
		return new AtbBallparkAboutPage(driver);
	}
*/
	public String getBallparkTextDescription() {
		pause(1);
		String desc = "";
		LOGGER.info("driver: " + getDriver() + "team: " + pageURL);
		if (isElementPresent(ballparkTextDescription)) {
			desc = ballparkTextDescription.getText();
		}
		else
			LOGGER.warn("Empty description is returned as no appropriate UI item discovered!");
		
		return desc;
	}
}