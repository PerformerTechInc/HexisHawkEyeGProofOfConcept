package com.mlb.qa.at_bat.ios.page.team.shop;

import com.mlb.qa.at_bat.ios.page.team.AtBatBaseTeamPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Igor Vayner on 7/7/14.
 */
public class AtBatShopPage extends AtBatBaseTeamPage {

    private final static String SHOP = "Shop";

    public AtBatShopPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        LOGGER.info("Page name: "+pageHeader.getAttribute("name"));
        return pageHeader.getAttribute("name").equals(SHOP);
    }
}
