package com.mlb.qa.at_bat.ios.page.common;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

/**
 * Created by Igor Vayner on 6/25/14.
 */
public class AtBatIOSPage extends AbstractUIObject {

    //protected static long SHORT_TIMEOUT = 5;

    public AtBatIOSPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return true;
    }

    public void clickOnScreen(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        HashMap<String, Object> swipeObject = new HashMap<String, Object>();
        swipeObject.put("x", x);
        swipeObject.put("y", y);
        swipeObject.put("duration", 1.0);
        swipeObject.put("tapCount", 1.0);
        swipeObject.put("touchCount", 1.0);
        js.executeScript("mobile: swipe", swipeObject);
    }

}
