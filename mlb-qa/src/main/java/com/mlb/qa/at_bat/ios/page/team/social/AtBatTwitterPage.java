package com.mlb.qa.at_bat.ios.page.team.social;

import org.openqa.selenium.WebDriver;

/**
 * Created by Igor Vayner on 6/26/14.
 */
public class AtBatTwitterPage extends AtBatDefaultSocialPage {

    private final String TWITTER = "Twitter";

    public AtBatTwitterPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        LOGGER.info("Page name: "+pageHeader.getAttribute("name"));
        return pageHeader.getAttribute("name").equals(TWITTER);
    }
}
