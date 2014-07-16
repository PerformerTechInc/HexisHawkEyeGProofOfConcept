package com.mlb.qa.tests.atbat.ios;

import com.mlb.qa.at_bat.ios.page.authentication.AtBatLoginPage;
import com.mlb.qa.at_bat.ios.page.common.AtBatStartPage;
import com.mlb.qa.at_bat.ios.page.footer.AtBatBottomMenuPage;
import com.mlb.qa.at_bat.ios.page.footer.AtBatMorePage;
import com.mlb.qa.at_bat.ios.page.team.AtBatTeamPage;
import com.mlb.qa.at_bat.ios.page.team.AtBatTeamSelectionPage;
import com.mlb.qa.at_bat.ios.page.team.news.AtBatNewsPage;
import com.mlb.qa.at_bat.ios.page.team.roster.AtBatRosterPage;
import com.mlb.qa.at_bat.ios.page.team.schedule.AtBatCalendarPage;
import com.mlb.qa.at_bat.ios.page.team.settings.AtBatSettingsPage;
import com.mlb.qa.at_bat.ios.page.team.shop.AtBatShopPage;
import com.mlb.qa.at_bat.ios.page.team.social.AtBatFacebookPage;
import com.mlb.qa.at_bat.ios.page.team.social.AtBatInstagramPage;
import com.mlb.qa.at_bat.ios.page.team.social.AtBatTwitterPage;
import com.mlb.qa.at_bat.ios.page.team.videos.AtBatVideosPage;
import com.qaprosoft.carina.core.foundation.UITest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Igor Vayner on 6/25/14.
 */
public class AtBatAcceptanceTest extends UITest {


    @Parameters({"TUID", "team_name"})
    @Test(dataProvider = "excel_ds")
    public void login(String TUID, String team_name) {

        AtBatStartPage atBatStartPage = new AtBatStartPage(driver);
        AtBatLoginPage atBatLoginPage = atBatStartPage.getAtBatLoginPage();
        atBatLoginPage.login();

        AtBatBottomMenuPage atBatBottomMenuPage = new AtBatBottomMenuPage(driver);
        AtBatMorePage atBatMorePage = atBatBottomMenuPage.getAtBatMorePage();

        AtBatTeamSelectionPage atBatTeamSelectionPage = atBatMorePage.getAtBatTeamSelectionPage();
        AtBatTeamPage atBatTeamPage = atBatTeamSelectionPage.selectTeam(TUID);

        pause(5);
        AtBatTwitterPage atBatTwitterPage = atBatTeamPage.getAtBatTwitterPage();
        pause(5);
        Assert.assertTrue(atBatTwitterPage.isOpened(), "Twitter isn't opened!");
        atBatTwitterPage.backToPrevious();
        pause(5);
        AtBatFacebookPage atBatFaceBookPage = atBatTeamPage.getAtBatFacebookPage();
        pause(5);
        Assert.assertTrue(atBatFaceBookPage.isOpened(), "Facebook isn't opened!");
        atBatTwitterPage.backToPrevious();
        pause(5);
        AtBatInstagramPage atBatInstagramPage = atBatTeamPage.getAtBatInstagramPage();
        pause(5);
        Assert.assertTrue(atBatInstagramPage.isOpened(), "Instagram isn't opened!");
        atBatTwitterPage.backToPrevious();
        pause(5);
        AtBatNewsPage atBatNewsPage = atBatTeamPage.getAtBatNewsPage();
        pause(5);
        Assert.assertTrue(atBatNewsPage.isCorrectHeader(team_name), "News isn't opened!");
        atBatTwitterPage.backToPrevious();
        pause(5);
        AtBatVideosPage atBatVideosPage = atBatTeamPage.getAtBatVideosPage();
        pause(5);
        Assert.assertTrue(atBatVideosPage.isCorrectHeader(team_name), "Videos isn't opened!");
        atBatVideosPage.backToPrevious();
        pause(5);
        AtBatShopPage atBatShopPage = atBatTeamPage.getAtBatShopePage();
        pause(5);
        Assert.assertTrue(atBatShopPage.isOpened(), "Shop isn't opened!");
        atBatShopPage.backToPrevious();
        pause(5);
        AtBatRosterPage atBatRosterPage = atBatTeamPage.getAtBatRosterPage();
        pause(5);
        Assert.assertTrue(atBatRosterPage.isOpened(), "Roster isn't opened!");
        atBatRosterPage.backToPrevious();
        pause(5);

        AtBatSettingsPage atBatSettingsPage = atBatTeamPage.getAtBatSettingsPage();
        pause(5);
        Assert.assertTrue(atBatSettingsPage.isOpened(), "Settings isn't opened!");
        atBatRosterPage.backToPrevious();
        pause(5);

        AtBatCalendarPage atBatCalendarPage = atBatTeamPage.getAtBatCalendarPage();
        pause(5);
        Assert.assertTrue(atBatCalendarPage.isOpened(), "Calendar isn't opened!");
        atBatRosterPage.backToPrevious();
        pause(5);
    }

}
