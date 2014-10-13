package com.mlb.qa.tests.atbat.ios;

import com.mlb.qa.at_bat.ios.page.authentication.AtBatLoginPage;
import com.mlb.qa.at_bat.ios.page.common.AtBatStartPage;
import com.mlb.qa.at_bat.ios.page.games.AtBatClassicGamePage;
import com.mlb.qa.at_bat.ios.page.header.AtBatHeaderPage;
import com.mlb.qa.at_bat.ios.page.tv.AtBatTVPage;
import com.mlb.qa.atb.service.lookup.AtbLookupService;
import com.qaprosoft.carina.core.foundation.UITest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

/**
 * Created by Igor Vayner on 10/13/14.
 */
public class AtBatClassicGameTest extends UITest {

    @Test
    public void classicGameTest(){
        AtBatStartPage atBatStartPage = new AtBatStartPage(driver);
        AtBatLoginPage atBatLoginPage = atBatStartPage.getAtBatLoginPage();
        atBatLoginPage.login();

        AtBatHeaderPage atBatHeaderPage = new AtBatHeaderPage(driver);
        AtBatTVPage atBatTVPage = atBatHeaderPage.getAtBatTVPage();
        AtBatClassicGamePage atBatClassicGamePage = atBatTVPage.getAtBatClassicGamePage();
        AtbLookupService lookupService = new AtbLookupService();
        List<String> uiTitles = atBatClassicGamePage.getClassicGameTitles();
        List<String> beTitles = lookupService.getClassicGameList();
        SoftAssert softAssert = new SoftAssert();
        for (int i =0; i < uiTitles.size(); i++){
            System.out.println("Iteration: " + i);
            System.out.println("Expected: " + beTitles.get(i));
            System.out.println("Actual: " + uiTitles.get(i));
            softAssert.assertTrue(uiTitles.get(i).contains(beTitles.get(i)), "Game with title '" + beTitles.get(i) + "' not present");
        }

        softAssert.assertAll();

    }
}
