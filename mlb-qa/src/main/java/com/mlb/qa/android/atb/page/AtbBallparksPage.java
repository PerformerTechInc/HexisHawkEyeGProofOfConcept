package com.mlb.qa.android.atb.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * BALLBARKS page
 */
public class AtbBallparksPage extends AtbAndroidPage {
	public static String BALLPARK_NAME_LOCATOR_PATTERN = "//TextView[@text='%s']";

	public AtbBallparksPage(WebDriver driver) {
		super(driver);
	}

	public AtbBallparkPage openBallparkByName(String ballParkName) {
		click(String.format("Ballpark '%s' name", ballParkName),
				driver.findElement(By.xpath(String.format(
						BALLPARK_NAME_LOCATOR_PATTERN, ballParkName))));
		return new AtbBallparkPage(driver);
	}
}
