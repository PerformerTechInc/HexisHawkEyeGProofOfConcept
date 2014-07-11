package com.mlb.qa.at_bat.ios.page.footer;

import com.mlb.qa.at_bat.ios.page.common.AtBatIOSPage;
import com.mlb.qa.at_bat.ios.page.team.AtBatTeamSelectionPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Igor Vayner on 6/30/14.
 */
public class AtBatMorePage extends AtBatIOSPage {

    @FindBy(name = "Teams")
    private ExtendedWebElement teamsButton;

    @FindBy(name = "Fantasy News")
    private ExtendedWebElement fantasyNewsButton;

    @FindBy(name = "All-Star Game Vote")
    private ExtendedWebElement allStarGameVoteButton;

    @FindBy(name = "Cut 4")
    private ExtendedWebElement cut4Button;

    @FindBy(name = "MLB.com Shop")
    private ExtendedWebElement shopButton;

    @FindBy(name = "Auctions")
    private ExtendedWebElement actionsButton;

    @FindBy(name = "Social Clubhouse")
    private ExtendedWebElement socialClubhouseButton;

    @FindBy(name = "MLB Network")
    private ExtendedWebElement mlbNetworkButton;

    @FindBy(name = "MLB Fan Cave")
    private ExtendedWebElement mlbFanCaveButton;

    public AtBatMorePage(WebDriver driver) {
        super(driver);
    }

    public AtBatTeamSelectionPage getAtBatTeamSelectionPage(){
        click(teamsButton);
        return new AtBatTeamSelectionPage(driver);
    }
}
