package com.mlb.qa.atb.android.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.mlb.qa.common.android.page.AndroidPage;
import com.qaprosoft.carina.core.foundation.log.TestLogCollector;
import com.qaprosoft.carina.core.foundation.webdriver.Screenshot;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * Created by Administrator on 5/19/2014.
 */
public class AtbMapPage extends AndroidPage {

    @FindBy(id="com.bamnetworks.mobile.android.ballpark:id/root")
    private ExtendedWebElement stadiumLinkList;

//    private final String MAP_LINK_NAME = "BALLPARK MAP";
//    private final String ALL_STAR_NAME = "All-Star Game Vote";
//    private final String TWINS_NAME = "Twins at the Plate";
    

    @FindBy(xpath = "//android.widget.TextView[contains(@text, 'BALLPARK MAP')]")
    private ExtendedWebElement mapButton;

    @FindBy(xpath = "//android.widget.TextView[contains(@text, 'Ballpark Map')]")
    private ExtendedWebElement mapButton2;

    @FindBy(id = "android:id/action_bar_title")
    private ExtendedWebElement stadiumName;

    @FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/spinner")
    private ExtendedWebElement spinner;

    @FindBy(className = "android.widget.TextView")
    private ExtendedWebElement levelList;

    @FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/ballpark_link_gridrow_item1")
    private ExtendedWebElement gridItem;


    public AtbMapPage(WebDriver driver) {
        super(driver);
    }
    

    public void openMap(String teamAbbrev){
    	pause(2);
    	
		LOGGER.info("Looking for Grid images...");
		int i = 0;
		while ((driver.findElements(gridItem.getBy()).size() < 2) && !isElementPresent(mapButton, 1) && ++i<10) {
			swipe(0.5, 0.85, 0.5, 0.55, 1);
			pause(1);
			LOGGER.info("swiping up to open Grid images or find BALLPARK maps , attempt: " + i);
			TestLogCollector.addScreenshotComment(Screenshot.capture(driver, true), "swiping up to Grid images " + i);
		}
		
		if(isElementPresent(mapButton, 5)){
			LOGGER.info("BALLPARK MAPS link will be used to activate required page.");
			TestLogCollector.addScreenshotComment(Screenshot.capture(driver, true), "BALLPARK MAPS link will be used to activate required page.");
            click(mapButton);
            return;
		} else if (driver.findElements(gridItem.getBy()).size() >= 2) {
			LOGGER.info("Map & Directory Grid image will be used to activate required page.");
			TestLogCollector.addScreenshotComment(Screenshot.capture(driver, true), "Map & Directory Grid image will be used to activate required page.");
			driver.findElements(gridItem.getBy()).get(1).click();
			return;
		}
		pause(5);
		TestLogCollector.addScreenshotComment(Screenshot.capture(driver, true), "Map button/link is not recognized!");
		Assert.fail("Unable to activate BALLPARK MAPS. Map button/link is not recognized!");
    		
    }

    public String getStadiumName(){
        return stadiumName.getText();

    }

    public List<String> getLevelList(){
        click(spinner);
        pause(10);
        List<String> levelsName = new ArrayList<String>();
        int i = 0;
        while (driver.findElements(levelList.getBy()).size() == 0 && ++i<10) {
        	LOGGER.info("Level list is not loaded yet. Waiting for 5 sec...");
        	pause(5);
        }
        	
        LOGGER.info("Number of discovered levels is: " + driver.findElements(levelList.getBy()).size());
        
        for (WebElement webElement : driver.findElements(levelList.getBy())){
            levelsName.add(webElement.getText());
            pause(1);
        }
        return levelsName;
    }
}
