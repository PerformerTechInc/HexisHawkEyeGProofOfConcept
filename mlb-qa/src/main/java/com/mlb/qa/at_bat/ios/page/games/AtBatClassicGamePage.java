package com.mlb.qa.at_bat.ios.page.games;

import com.mlb.qa.at_bat.ios.page.common.AtBatIOSPage;
import com.qaprosoft.carina.core.foundation.webdriver.appium.AppiumNativeDriver;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor Vayner on 10/13/14.
 */
public class AtBatClassicGamePage extends AtBatIOSPage {
    public AtBatClassicGamePage(WebDriver driver) {
        super(driver);
    }


    public List<String> getClassicGameTitles(){
        List<String> videoList = new ArrayList<String>();

        List<ExtendedWebElement> uiList = ((AppiumNativeDriver) driver).findElementsByIosUIAutomation(".tableViews()[0].cells()");

        for (ExtendedWebElement extendedWebElement : uiList) {
            videoList.add(extendedWebElement.getAttribute("name"));
        }

        return videoList;
    }
}
