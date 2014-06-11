package com.mlb.qa.tests.atb.android;

import com.mlb.qa.atb.AtbParameter;
import com.mlb.qa.atb.android.page.AtbAndroidPage;
import com.mlb.qa.atb.android.page.history.AtbAddGamePage;
import com.mlb.qa.atb.android.page.history.AtbHistoryMainPage;
import com.mlb.qa.atb.model.Team;
import com.mlb.qa.atb.model.game.Game;
import com.mlb.qa.atb.service.authorization.AuthorizationService;
import com.mlb.qa.atb.service.lookup.AtbLookupService;
import com.qaprosoft.carina.core.foundation.UITest;
import org.joda.time.DateTime;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class AtbHistoryGamesTest extends UITest {

    private AuthorizationService authorizationService;

    @DataProvider(name = "prepareTestData")
    public Object[][] prepareTestData(ITestContext context) {
        Object[][] allArguments = createTestArgSets(context, "Execute", "y");
        Random rn = new Random();
        int i = rn.nextInt(allArguments.length);
        Object[][] a = {allArguments[i]};
        return a;
    }


    @Test(dataProvider = "prepareTestData", description = "Add game from the future", priority = 1)
    public void checkAddFutureGame(String teamAbbrev) {
        authorizationService = new AuthorizationService(getDriver());
        authorizationService.reloginUser(
                AtbParameter.MLB_ATB_ADITIONAL_USER.getValue(),
                AtbParameter.MLB_ATB_ADITIONAL_PASSWORD.getValue());
        AtbLookupService lookupService = new AtbLookupService();
        String year = AtbParameter.MLB_ATB_SEASON.getValue();
        int month = new DateTime().getMonthOfYear() + 1;
        Team team = lookupService.lookupTeamByAbbrev(teamAbbrev, year);
        List<Game> gamesBe = lookupService.lookupListOfGamesForTheMonth(
                team.getTeamId(), Integer.parseInt(year), month);

        AtbHistoryMainPage atbHistoryMainPage = new AtbHistoryMainPage(
                getDriver());
        atbHistoryMainPage.clickOnMenuItem(AtbAndroidPage.Menu.HISTORY);
        Assert.assertTrue(atbHistoryMainPage.isOpened(), "History isn't opened");
        AtbAddGamePage atbAddGamePage = atbHistoryMainPage.getAtbAddGamePage();
        Assert.assertTrue(atbAddGamePage.isOpened(), "Add Game isn't opened");
        atbAddGamePage.selectHomeTeam(gamesBe.get(gamesBe.size() - 1)
                .getHomeTeamFull());
        atbAddGamePage.selectAwayTeam(gamesBe.get(gamesBe.size() - 1)
                .getAwayTeamFull());
        atbAddGamePage.selectYear(year);
        atbAddGamePage.selectMonth(gamesBe.get(gamesBe.size() - 1)
                .getGameDate().monthOfYear().getAsText());
        atbAddGamePage.selectDay(((Integer) gamesBe.get(gamesBe.size() - 1)
                .getGameDate().getDayOfMonth()).toString());
        atbAddGamePage.clickSearchAmdSelectGame();
        atbAddGamePage.clickAddDeleteButton();
        Assert.assertTrue(atbAddGamePage.checkErrorText());

    }


    @Test(dataProvider = "prepareTestData", description = "Add game from the past", priority = 2)
    public void checkAddPastGame(String teamAbbrev) {
        authorizationService = new AuthorizationService(getDriver());
        authorizationService.reloginUser(
                AtbParameter.MLB_ATB_ADITIONAL_USER.getValue(),
                AtbParameter.MLB_ATB_ADITIONAL_PASSWORD.getValue());
        AtbLookupService lookupService = new AtbLookupService();
        String year = AtbParameter.MLB_ATB_SEASON.getValue();
        int month = new DateTime().getMonthOfYear() - 1;
        Team team = lookupService.lookupTeamByAbbrev(teamAbbrev, year);
        List<Game> gamesBe = lookupService.lookupListOfGamesForTheMonth(
                team.getTeamId(), Integer.parseInt(year), month);

        AtbHistoryMainPage atbHistoryMainPage = new AtbHistoryMainPage(
                getDriver());
        atbHistoryMainPage.clickOnMenuItem(AtbAndroidPage.Menu.HISTORY);
        Assert.assertTrue(atbHistoryMainPage.isOpened(), "History isn't opened");
        AtbAddGamePage atbAddGamePage = atbHistoryMainPage.getAtbAddGamePage();
        Assert.assertTrue(atbAddGamePage.isOpened(), "Add Game isn't opened");
        atbAddGamePage.selectHomeTeam(gamesBe.get(gamesBe.size() - 1)
                .getHomeTeamFull());
        atbAddGamePage.selectAwayTeam(gamesBe.get(gamesBe.size() - 1)
                .getAwayTeamFull());
        atbAddGamePage.selectYear(year);
        atbAddGamePage.selectMonth(gamesBe.get(gamesBe.size() - 1)
                .getGameDate().monthOfYear().getAsText());
        atbAddGamePage.selectDay(((Integer) gamesBe.get(gamesBe.size() - 1)
                .getGameDate().getDayOfMonth()).toString());
        atbAddGamePage.clickSearchAmdSelectGame();
        atbAddGamePage.clickAddDeleteButton();
        Assert.assertTrue(atbAddGamePage.checkSuccessText());

    }

    @Test(description = "Delete game from history", priority = 3)
    public void deleteGameTest() {
        try {
            authorizationService = new AuthorizationService(getDriver());
            authorizationService.reloginUser(
                    AtbParameter.MLB_ATB_ADITIONAL_USER.getValue(),
                    AtbParameter.MLB_ATB_ADITIONAL_PASSWORD.getValue());
            AtbHistoryMainPage atbHistoryMainPage = new AtbHistoryMainPage(
                    getDriver());
            atbHistoryMainPage.clickOnMenuItem(AtbAndroidPage.Menu.HISTORY);
            atbHistoryMainPage.getRandomEvent();
            AtbAddGamePage atbAddGamePage = new AtbAddGamePage(getDriver());
            atbAddGamePage.clickDeleteChekIn();
            atbAddGamePage.clickAddDeleteButton();
            Assert.assertTrue(atbAddGamePage.checkSuccessText());
        } finally {
           AtbAddGamePage atbAddGamePage = new AtbAddGamePage(getDriver());
            atbAddGamePage.executeKeyEvent(4);
            authorizationService = new AuthorizationService(getDriver());
            authorizationService.reloginUser(
                    AtbParameter.MLB_ATB_DEFAULT_USER.getValue(),
                    AtbParameter.MLB_ATB_DEFAULT_PASSWORD.getValue());
        }

    }
}
