package com.mlb.qa.common.android.page;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class AndroidPage extends AbstractUIObject {
    //TODO:  Need to rework the swipes as different screen sizes seem to need different values
    protected static final Logger logger = Logger.getLogger(AndroidPage.class);
    protected static final int delay = 10;

    public AndroidPage(WebDriver driver) {
        super(driver);
    }

    /**
     * @return true by default. Override it in child classes
     */
    public boolean isOpened() {
        return true;
    }

    public void swipeLeft() {
        logger.debug("Swipe left");
        swipe(0.15, 0.5, 0.45, 0.5, 2);
        pause(2);
    }

    public void swipeRight() {
        logger.debug("Swipe right");
        swipe(0.95, 0.5, 0.65, 0.5, 1);
        pause(2);
    }

    public void swipeUp() {
        logger.debug("Swipe Up");
        swipe(0.5, 0.85, 0.5, 0.55, 1);
        pause(2);
    }

    public void swipeDown() {
        logger.info("Swipe down");
        swipe(0.5, 0.05, 0.5, 0.55, 2);
        pause(5);
    }

    public void executeKeyEvent(int keyCode) {
        HashMap<String, Integer> keyCodeMap = new HashMap<String, Integer>();
        keyCodeMap.put("keycode", keyCode);
        ((JavascriptExecutor) driver).executeScript("mobile: keyevent", keyCodeMap);


    }

    public void scrollTo(String scrollToText, ExtendedWebElement containerElement) {
        try {

            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            RemoteWebElement element = (RemoteWebElement) driver.findElement(By.name(scrollToText));
            if (element.isDisplayed())
                return;
            driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        } catch (Exception e) {
            //restore timeout
            driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        }
        logger.info(String.format("Scrolling to text '%s', Scroll container: %s", scrollToText, containerElement.getNameWithLocator()));
        final JavascriptExecutor executor = (JavascriptExecutor) driver;
        final HashMap<String, String> scrollMap = new HashMap<String, String>();
        scrollMap.put("text", scrollToText);

        scrollMap.put("element", ((RemoteWebElement) driver.findElement(containerElement.getBy())).getId());
        logger.info(scrollMap);
        try {
            executor.executeScript("mobile: scrollTo", scrollMap);
        } catch (Exception e) {
            //do nothing
            logger.warn("Exception occurred for scroll operation! " + String.format("Scrolling to text '%s', Scroll container: %s", scrollToText, containerElement.getNameWithLocator()));
        }

    }
}
