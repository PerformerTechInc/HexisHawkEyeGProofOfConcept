package com.mlb.qa.tests.atbat.ios;

import com.mlb.qa.at_bat.ios.page.authentication.AtBatLoginPage;
import com.mlb.qa.at_bat.ios.page.common.AtBatStartPage;
import com.mlb.qa.at_bat.ios.page.footer.AtBatBottomMenuPage;
import com.mlb.qa.at_bat.ios.page.footer.AtBatMorePage;
import com.mlb.qa.at_bat.ios.page.team.AtBatTeamPage;
import com.mlb.qa.at_bat.ios.page.team.AtBatTeamSelectionPage;
import com.mlb.qa.at_bat.ios.page.team.videos.AtBatVideosPage;
import com.mlb.qa.atb.service.lookup.AtbLookupService;
import com.qaprosoft.carina.core.foundation.UITest;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AtBatVideoTeamTest extends UITest {


    @Parameters({"team_abbrev", "TUID", "team_name"})
    @Test(dataProvider = "excel_ds")
    public void checkNewsGlobal(String team_abbrev, String TUID, String team_name) {

        AtBatStartPage atBatStartPage = new AtBatStartPage(getDriver());
        AtBatLoginPage atBatLoginPage = atBatStartPage.getAtBatLoginPage();
        atBatLoginPage.login();

        AtBatBottomMenuPage atBatBottomMenuPage = new AtBatBottomMenuPage(getDriver());
        AtBatMorePage atBatMorePage = atBatBottomMenuPage.getAtBatMorePage();

        AtBatTeamSelectionPage atBatTeamSelectionPage = atBatMorePage.getAtBatTeamSelectionPage();
        AtBatTeamPage atBatTeamPage = atBatTeamSelectionPage.selectTeam(TUID);
        Sleeper.sleepTightInSeconds(3);
        AtBatVideosPage atBatVideosPage = atBatTeamPage.getAtBatVideosPage();
        Sleeper.sleepTightInSeconds(3);
        AtbLookupService lookupService = new AtbLookupService();
        List<String> videos = lookupService.getVideoList(team_abbrev.toLowerCase());
        List<String> uiVideosList = atBatVideosPage.getVideosListFromUI();

        SoftAssert softAssert = new SoftAssert();
        for (int i =0; i < uiVideosList.size(); i++){
            System.out.println("Iteration: " + i);
            System.out.println("Expected: " + videos.get(i));
            System.out.println("Actual: " + uiVideosList.get(i));
            softAssert.assertTrue(uiVideosList.get(i).contains(videos.get(i)), "Video with title '" + videos.get(i) + "' not present");
        }

        atBatVideosPage.backToPrevious();
        softAssert.assertAll();


    }


}
