package com.mlb.qa.at_bat.ios.page.team.news;

import com.mlb.qa.at_bat.ios.page.team.AtBatBaseTeamPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Igor Vayner on 7/7/14.
 */
public class AtBatNewsPage extends AtBatBaseTeamPage {

    private final static String NEWS = "News";

    public AtBatNewsPage(WebDriver driver) {
        super(driver);
    }


    public boolean isCorrectHeader(String team_name) {
        LOGGER.info("Page name: " + pageHeader.getAttribute("name"));
        return pageHeader.getAttribute("name").equals(team_name + " " + NEWS);
    }
}
