package com.mlb.qa.android.atb.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * BALLBARKS page
 */
public class AtbBallparksPage extends AtbAndroidPage {
	public static String BALLPARK_NAME_LOCATOR_PATTERN = "//TextView[@text='%s']";
	
	@FindBy(id="com.bamnetworks.mobile.android.ballpark:id/ballparklistview")
	private ExtendedWebElement ballparksListContainer;
	public AtbBallparksPage(WebDriver driver) {
		super(driver);
	}

	public AtbBallparkPage openBallparkByName(String ballParkName) {
		scrollTo(ballParkName, ballparksListContainer);
		click(String.format("Ballpark '%s' name", ballParkName),
				driver.findElement(By.xpath(String.format(
						BALLPARK_NAME_LOCATOR_PATTERN, ballParkName))));
		return new AtbBallparkPage(driver);
	}
}
