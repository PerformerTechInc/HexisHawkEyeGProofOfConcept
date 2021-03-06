package com.mlb.qa.at_bat.ios.page.team.tickets;

import com.mlb.qa.at_bat.ios.page.team.AtBatBaseTeamPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Igor Vayner on 7/7/14.
 */
public class AtBatTicketsPage extends AtBatBaseTeamPage {

    private final static String TICKETS = "Tickets";

    public AtBatTicketsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        LOGGER.info("Page name: "+pageHeader.getAttribute("name"));
        return pageHeader.getAttribute("name").equals(TICKETS);
    }


}
