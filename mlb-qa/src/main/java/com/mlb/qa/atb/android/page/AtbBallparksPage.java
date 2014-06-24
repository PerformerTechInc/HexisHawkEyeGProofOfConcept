package com.mlb.qa.atb.android.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.log.TestLogCollector;
import com.qaprosoft.carina.core.foundation.webdriver.Screenshot;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * BALLBARKS page
 */
public class AtbBallparksPage extends AtbAndroidPage {
	public static String BALLPARK_NAME_LOCATOR_PATTERN = "//android.widget.TextView[@text='%s']";
	
	@FindBy(id="com.bamnetworks.mobile.android.ballpark:id/ballparklistview")
	private ExtendedWebElement ballparksListContainer;
	
    @FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/statusprogressbar")
    private ExtendedWebElement progressBar;
    
	public AtbBallparksPage(WebDriver driver) {
		super(driver);
	}

	public AtbBallparkPage openBallparkByTeamName(String ballParkName) {
/*		int count = 0;
		while (driver.findElements(By.xpath(String.format(BALLPARK_NAME_LOCATOR_PATTERN, ballParkName))).size() == 0  && ++count < 3) {
			scrollTo(ballParkName, ballparksListContainer);
		}*/

		TestLogCollector.addScreenshotComment(Screenshot.capture(driver, true), "All Ballparks window.");
		while(isElementPresent(progressBar, 2)) {
			LOGGER.info("FINDING NEARBY BALLPARKS spinner exists. Waiting 5 sec.");
			pause(5);
		}
		
		pause(5);
		
		scrollTo(ballParkName, ballparksListContainer);
		pause(2);
		
		TestLogCollector.addScreenshotComment(Screenshot.capture(driver, true), "before ballpark click.");

        click(String.format("Ballpark '%s' name", ballParkName), driver.findElement(By.xpath(String.format(BALLPARK_NAME_LOCATOR_PATTERN, ballParkName))));
		return new AtbBallparkPage(driver);
	}
}
