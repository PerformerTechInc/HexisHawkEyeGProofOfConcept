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

    public void openMap(){
    	pause(1);
    	if (isElementPresent(gridItem)) {
    		TestLogCollector.addScreenshotComment(Screenshot.capture(driver, true), "Ballpark info opened.");
    		LOGGER.info("Grid images are present.");
    		int size = driver.findElements(gridItem.getBy()).size();
    		LOGGER.info("Grid image size is: " + size);
    		if (size < 2) {
    			scrollTo(ALL_STAR_NAME, stadiumLinkList); 
    			size = driver.findElements(gridItem.getBy()).size();
    			LOGGER.info("Grid image size is after scrolling to All-Star Game Vote: " + size);
    		}
    		if (size >= 2) {
    			LOGGER.info("Map & Directory image will be used.");
    			TestLogCollector.addScreenshotComment(Screenshot.capture(driver, true), "Before Ballpark Maps activation.");
    			driver.findElements(gridItem.getBy()).get(1).click();
    			return;
    		}    		
    	}
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
        pause(3);
        List<String> levelsName =new ArrayList<String>();
        for (WebElement webElement : driver.findElements(levelList.getBy())){
            levelsName.add(webElement.getText());
        }
        return levelsName;
    }

}
