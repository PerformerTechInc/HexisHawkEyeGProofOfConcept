package com.mlb.qa.android.atb.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * BALLBARKS page
 */
public class BallparksPage extends AtbAndroidPage {
	public static String BALLPARK_NAME_LOCATOR_PATTERN = "//TextView[@text='%s']";

	public BallparksPage(WebDriver driver) {
		super(driver);
	}

	public BallparkPage openBallparkByName(String ballParkName) {
		click(String.format("Ballpark '%s' name", ballParkName),
				driver.findElement(By.xpath(String.format(
						BALLPARK_NAME_LOCATOR_PATTERN, ballParkName))));
		return new BallparkPage(driver);
	}
}
