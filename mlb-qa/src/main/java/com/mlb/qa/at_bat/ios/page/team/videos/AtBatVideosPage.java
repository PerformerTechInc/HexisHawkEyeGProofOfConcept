package com.mlb.qa.at_bat.ios.page.team.videos;

import com.mlb.qa.at_bat.ios.page.team.AtBatBaseTeamPage;
import com.qaprosoft.carina.core.foundation.webdriver.appium.AppiumNativeDriver;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor Vayner on 7/7/14.
 */
public class AtBatVideosPage extends AtBatBaseTeamPage {

    private final static String VIDEOS = "Videos";

    public AtBatVideosPage(WebDriver driver) {
        super(driver);
    }


    public boolean isCorrectHeader(String team_name) {
        LOGGER.info("Page name: " + pageHeader.getAttribute("name"));
        return pageHeader.getAttribute("name").equals(team_name + " " + VIDEOS);
    }

    public List<String> getVideosListFromUI(){
        List<String> videoList = new ArrayList<String>();

        List<ExtendedWebElement> uiList = ((AppiumNativeDriver) driver).findElementsByIosUIAutomation(".tableViews()[0].cells()");

        for (ExtendedWebElement extendedWebElement : uiList) {
            videoList.add(extendedWebElement.getAttribute("name"));
        }

        return videoList;
    }
}
