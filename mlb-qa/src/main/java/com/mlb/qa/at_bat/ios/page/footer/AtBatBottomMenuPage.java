package com.mlb.qa.at_bat.ios.page.footer;

import com.mlb.qa.at_bat.ios.page.common.AtBatIOSPage;
import com.qaprosoft.carina.core.foundation.webdriver.appium.AppiumNativeDriver;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Igor Vayner on 6/30/14.
 */
public class AtBatBottomMenuPage extends AtBatIOSPage {

    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[1]")
    private ExtendedWebElement scores;

    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[2]")
    private ExtendedWebElement news;

    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[3]")
    private ExtendedWebElement standings;

    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[4]")
    private ExtendedWebElement stats;

    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[5]")
    private ExtendedWebElement more;


    public AtBatMorePage getAtBatMorePage() {
        ExtendedWebElement webElement = ((AppiumNativeDriver) driver).findElementByIosUIAutomation(".tabBar().buttons()['More']");
        click(webElement);
        return new AtBatMorePage(driver);
    }

    public AtBatNewsPage getAtBatNewsPage() {
        ExtendedWebElement webElement = ((AppiumNativeDriver) driver).findElementByIosUIAutomation(".tabBar().buttons()['News']");
        click(webElement);
        return new AtBatNewsPage(driver);
    }
    public AtBatBottomMenuPage(WebDriver driver) {
        super(driver);
    }


}
