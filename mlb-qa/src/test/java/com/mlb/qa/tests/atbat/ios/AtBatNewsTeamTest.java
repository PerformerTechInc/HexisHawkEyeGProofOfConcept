package com.mlb.qa.tests.atbat.ios;

import com.mlb.qa.at_bat.ios.page.authentication.AtBatLoginPage;
import com.mlb.qa.at_bat.ios.page.common.AtBatStartPage;
import com.mlb.qa.at_bat.ios.page.footer.AtBatBottomMenuPage;
import com.mlb.qa.at_bat.ios.page.footer.AtBatMorePage;
import com.mlb.qa.at_bat.ios.page.team.AtBatTeamPage;
import com.mlb.qa.at_bat.ios.page.team.AtBatTeamSelectionPage;
import com.mlb.qa.atb.service.lookup.AtbLookupService;
import com.qaprosoft.carina.core.foundation.UITest;
import org.openqa.selenium.By;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AtBatNewsTeamTest extends UITest {


    @Parameters({"team_abbrev", "TUID"})
    @Test(dataProvider = "excel_ds")
    public void checkNewsGlobal(String team_abbrev, String TUID) {
        AtBatStartPage atBatStartPage = new AtBatStartPage(getDriver());
        AtBatLoginPage atBatLoginPage = atBatStartPage.getAtBatLoginPage();
        atBatLoginPage.login();

        AtBatBottomMenuPage atBatBottomMenuPage = new AtBatBottomMenuPage(getDriver());
        AtBatMorePage atBatMorePage = atBatBottomMenuPage.getAtBatMorePage();

        AtBatTeamSelectionPage atBatTeamSelectionPage = atBatMorePage.getAtBatTeamSelectionPage();
        AtBatTeamPage atBatTeamPage = atBatTeamSelectionPage.selectTeam(TUID);
        atBatTeamPage.getAtBatNewsPage();

        AtbLookupService lookupService = new AtbLookupService();
        List<String> news = lookupService.getNewsTitles(team_abbrev.toLowerCase());

        int i = 1;
        SoftAssert softAssert = new SoftAssert();
        Sleeper.sleepTightInSeconds(7);
        for (String aNew : news) {

            if (aNew != null && !aNew.contains("'")) {
                softAssert.assertTrue(getDriver().findElements(By.name(aNew)).size() > 0, "Post with title '" + aNew + "' not present");
            }
            System.out.println("Iteration: " + i);
            i++;
            if (i == 10) {
                break;
            }
        }
        softAssert.assertAll();
    }


}
