package com.mlb.qa.atb.android.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    private final String MAP_LINK_NAME = "BALLPARK MAP";
    private final String ALL_STAR_NAME = "All-Star Game Vote";
    private final String TWINS_NAME = "Twins at the Plate";
    

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
    	
    	if (!teamAbbrev.equals("SD")) { //San Diego is the only team for which gridImage contains "express feedback" link
    		LOGGER.info("Looking for Grid images...");
    		int i = 0;
    		while (!isElementPresent(gridItem, 2) && ++i<10) {
    			swipe(0.5, 0.85, 0.5, 0.65, 1);
    			LOGGER.info("swiping up to find Grid images, attempt: " + i);
    			TestLogCollector.addScreenshotComment(Screenshot.capture(driver, true), "swiping up to Grid images " + i);
    		}
    		i = 0;
    		if (isElementPresent(gridItem)) {
        		while (driver.findElements(gridItem.getBy()).size() < 2 && ++i<10) {
        			swipe(0.5, 0.85, 0.5, 0.65, 1);
        			LOGGER.info("swiping up to open all Grid images, attempt: " + i);
        			TestLogCollector.addScreenshotComment(Screenshot.capture(driver, true), "swiping up to open all Grid images " + i);
        		}
    		} else {
    			LOGGER.info("Grid images are not recognized!");
    		}
    		
    		if (driver.findElements(gridItem.getBy()).size() >= 2) {
    			LOGGER.info("Map & Directory Grid image will be used.");
    			TestLogCollector.addScreenshotComment(Screenshot.capture(driver, true), "Before Ballpark Maps & Directory activation.");
    			driver.findElements(gridItem.getBy()).get(1).click();
    			return;
    		}
    		else {
    			LOGGER.warn("Map & Directory Grid images were not opened with size > 2!");
    		}
    	} 
/*    	if (isElementPresent(gridItem) && !teamAbbrev.equals("SD")) { //San Diego is the only team for which gridImage contains "express feedback" link
    		TestLogCollector.addScreenshotComment(Screenshot.capture(driver, true), "Ballpark info opened.");
    		LOGGER.info("Grid images are present.");
    		int size = driver.findElements(gridItem.getBy()).size();
    		LOGGER.info("Grid image size is: " + size);
    		
    		if (size < 2) {
    			TestLogCollector.addScreenshotComment(Screenshot.capture(driver, true), "Ballpark info before swipeUp");
    			swipe(0.5, 0.85, 0.5, 0.65, 1);
    			TestLogCollector.addScreenshotComment(Screenshot.capture(driver, true), "Ballpark info after swipeUp");
    			size = driver.findElements(gridItem.getBy()).size();
    			LOGGER.info("Grid image size after after swipeUp is: " + size);
    		}
    		if (size < 2) {
    			scrollTo(ALL_STAR_NAME, stadiumLinkList); 
    			TestLogCollector.addScreenshotComment(Screenshot.capture(driver, true), "Ballpark info after scrollTo " + ALL_STAR_NAME);
    			size = driver.findElements(gridItem.getBy()).size();
    			LOGGER.info("Grid image size after scrolling to " + ALL_STAR_NAME + " is: " + size);
    		}
    		if (size < 2) {
    			scrollTo(TWINS_NAME, stadiumLinkList); 
    			TestLogCollector.addScreenshotComment(Screenshot.capture(driver, true), "Ballpark info after scrollTo " + TWINS_NAME);
    			size = driver.findElements(gridItem.getBy()).size();
    			LOGGER.info("Grid image size after scrolling to " + TWINS_NAME + " is: " + size);
    		}
    		if (size >= 2) {
    			LOGGER.info("Map & Directory image will be used.");
    			TestLogCollector.addScreenshotComment(Screenshot.capture(driver, true), "Before Ballpark Maps activation.");
    			driver.findElements(gridItem.getBy()).get(1).click();
    			return;
    		}    		
    	}*/
    	LOGGER.info("No Grid images discovered. Trying to scroll to '" + MAP_LINK_NAME + "' text caption");
    	if(!isElementPresent(mapButton, 5)) {
    		try {
    			scrollTo(MAP_LINK_NAME, stadiumLinkList);
    			TestLogCollector.addScreenshotComment(Screenshot.capture(driver, true), "Ballpark info after scroll");
    		}
    		catch (Exception e){
    			e.printStackTrace();
    		}
    	}
    	
    	TestLogCollector.addScreenshotComment(Screenshot.capture(driver, true), "Ballpark info before click");    	
        if(isElementPresent(mapButton, 5)){
            click(mapButton);
        }else{
            throw new RuntimeException("Map button is not recognized!");
        }
    }


    public String getStadiumName(){
        return stadiumName.getText();

    }

    public List<String> getLevelList(){
        click(spinner);
        pause(9);
        List<String> levelsName =new ArrayList<String>();
        for (WebElement webElement : driver.findElements(levelList.getBy())){
            levelsName.add(webElement.getText());
        }
        return levelsName;
    }
}
