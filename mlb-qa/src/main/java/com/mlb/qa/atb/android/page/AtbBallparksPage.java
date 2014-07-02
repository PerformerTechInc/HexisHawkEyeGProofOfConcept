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
	
    @FindBy(xpath = "//android.widget.TextView[@text='LOADING BALLPARKS...']")
    private ExtendedWebElement loadingMessage;
    
    @FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/statusprogressbar")
    private ExtendedWebElement progressBar;
    
    @FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/miniheader")
    private ExtendedWebElement miniHeader;
    
    
	public AtbBallparksPage(WebDriver driver) {
		super(driver);
	}

	public AtbBallparkPage openBallparkByTeamName(String ballParkName) {
/*		int count = 0;
		while (driver.findElements(By.xpath(String.format(BALLPARK_NAME_LOCATOR_PATTERN, ballParkName))).size() == 0  && ++count < 3) {
			scrollTo(ballParkName, ballparksListContainer);
		}*/

		TestLogCollector.addScreenshotComment(Screenshot.capture(driver, true), "All Ballparks window.");
		int i=0;

		while(isElementPresent(loadingMessage, 2) && ++i<10) {
			LOGGER.info("LOADING BALLPARKS spinner exists. Waiting 5 sec.");
			pause(5);
		}
		i = 0;
		while(isElementPresent(progressBar, 2) && ++i<10) {
			LOGGER.info("FINDING NEARBY BALLPARKS spinner exists. Waiting 5 sec.");
			pause(5);
		}
		
		scrollTo(ballParkName, ballparksListContainer);
		pause(3);
		
		String xpath = String.format(BALLPARK_NAME_LOCATOR_PATTERN, ballParkName);
		ExtendedWebElement ballparkLink = new ExtendedWebElement(driver.findElement(By.xpath(xpath)), "ballparkLink");
		click(ballparkLink);
		pause(3);
		
		i = 0;
		while (isElementPresent(miniHeader, 2) && miniHeader.getText().equals("ALL BALLPARKS") && ++i<10) {
			LOGGER.error("ALL BALPARKS activity is still displayed! Trying to click again. Attempt: " + i);
			TestLogCollector.addScreenshotComment(Screenshot.capture(driver, true), "ALL BALPARKS activity is still displayed! Attempt: " + i);
			click(String.format("Ballpark '%s' name", ballParkName), driver.findElement(By.xpath(String.format(BALLPARK_NAME_LOCATOR_PATTERN, ballParkName))));
		}
		
/*		pause(3);
		if (isElementPresent(ballparkLink)) {
			TestLogCollector.addScreenshotComment(Screenshot.capture(driver, true), "before ballpark click.");
			swipe(0.5, 0.85, 0.5, 0.65, 1);
			pause(5);
			TestLogCollector.addScreenshotComment(Screenshot.capture(driver, true), "ballparks after swipeUp.");
			clickIfPresent(ballparkLink, 5);	
		}
*/		
        //click(String.format("Ballpark '%s' name", ballParkName), driver.findElement(By.xpath(String.format(BALLPARK_NAME_LOCATOR_PATTERN, ballParkName))));

		return new AtbBallparkPage(driver);
	}
}
