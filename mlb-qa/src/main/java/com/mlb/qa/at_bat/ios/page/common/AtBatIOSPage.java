package com.mlb.qa.at_bat.ios.page.common;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;

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

}
