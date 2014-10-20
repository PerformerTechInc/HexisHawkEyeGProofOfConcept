package com.mlb.qa.at_bat.ios.page.header;

import com.mlb.qa.at_bat.ios.page.common.AtBatIOSPage;
import com.mlb.qa.at_bat.ios.page.tv.AtBatTVPage;
import com.qaprosoft.carina.core.foundation.webdriver.appium.AppiumNativeDriver;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;

/**
 * Created by Igor Vayner on 10/13/14.
 */
public class AtBatHeaderPage extends AtBatIOSPage {

    public AtBatHeaderPage(WebDriver driver) {
        super(driver);
    }

    public AtBatTVPage getAtBatTVPage(){

        ExtendedWebElement tvButton = ((AppiumNativeDriver) driver).findElementByIosUIAutomation(".navigationBars()[0].buttons()['TV']");
        click(tvButton);
        return  new AtBatTVPage(driver);
    }
}
