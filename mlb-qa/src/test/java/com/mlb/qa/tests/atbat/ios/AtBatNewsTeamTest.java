package com.mlb.qa.tests.atbat.ios;

import com.mlb.qa.at_bat.ios.page.authentication.AtBatLoginPage;
import com.mlb.qa.at_bat.ios.page.common.AtBatStartPage;
import com.mlb.qa.at_bat.ios.page.footer.AtBatBottomMenuPage;
import com.mlb.qa.at_bat.ios.page.footer.AtBatMorePage;
import com.mlb.qa.at_bat.ios.page.footer.AtBatNewsPage;
import com.mlb.qa.at_bat.ios.page.team.AtBatTeamPage;
import com.mlb.qa.at_bat.ios.page.team.AtBatTeamSelectionPage;
import com.mlb.qa.atb.service.lookup.AtbLookupService;
import com.qaprosoft.carina.core.foundation.UITest;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AtBatNewsTeamTest extends UITest {


    @Parameters({"TUID", "team_name"})
    @Test(dataProvider = "excel_ds")
    public void checkNewsGlobal(String TUID, String team_name) {
        AtbLookupService lookupService = new AtbLookupService();
        List<String> news = lookupService.getNewsTitles("nym");
        int i = 1;
        for (String aNew : news) {
            if (aNew != null) {
                System.out.println(i + " " + aNew);
                i++;
            }
        }


        AtBatStartPage atBatStartPage = new AtBatStartPage(driver);
        AtBatLoginPage atBatLoginPage = atBatStartPage.getAtBatLoginPage();
        atBatLoginPage.login();

        AtBatBottomMenuPage atBatBottomMenuPage = new AtBatBottomMenuPage(driver);
        AtBatMorePage atBatMorePage = atBatBottomMenuPage.getAtBatMorePage();

        AtBatTeamSelectionPage atBatTeamSelectionPage = atBatMorePage.getAtBatTeamSelectionPage();
        AtBatTeamPage atBatTeamPage = atBatTeamSelectionPage.selectTeam(TUID);
        atBatTeamPage.getAtBatNewsPage();

        i = 1;
        SoftAssert softAssert = new SoftAssert();
        for (String aNew : news) {
            if (aNew != null && !aNew.contains("'")) {
                softAssert.assertTrue(driver.findElements(By.name(aNew)).size() > 0, "Post with title '" + aNew + "' not present");
            }
            i++;
            if (i == 30) {
                break;
            }
        }
        softAssert.assertAll();



    }


}
