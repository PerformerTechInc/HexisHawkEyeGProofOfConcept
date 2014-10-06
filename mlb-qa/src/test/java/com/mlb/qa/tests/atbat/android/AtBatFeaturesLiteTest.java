package com.mlb.qa.tests.atbat.android;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.mlb.qa.at_bat.android.page.common.AtBatActionBar;

/**
 * Created by boyle on 8/5/14.
 */
public class AtBatFeaturesLiteTest extends AtBatTest {

    @Test(priority = 1, description = "Lite User - Audio Feature Check (Scoreboard)", enabled = true)
    public void testLiteUserAudioFeaturesScoreboard() {
        liteUserInitialPath();

        AtBatActionBar actionBarPage = new AtBatActionBar(getDriver());
        actionBarPage.openScoreboard();
        actionBarPage.getAudioPage();

        assertLiteAudioResults("Scoreboard");
    }

    @Test(priority = 2, description = "Lite User - Audio Feature Check (News)", enabled = true)
    public void testLiteUserAudioFeaturesNews() {
        liteUserInitialPath();

        AtBatActionBar actionBarPage = new AtBatActionBar(getDriver());
        actionBarPage.openNews();
        actionBarPage.getAudioPage();

        assertLiteAudioResults("News");
    }

    @Test(priority = 3, description = "Lite User - Audio Feature Check (Video)", enabled = true)
    public void testLiteUserAudioFeaturesVideo() {
        liteUserInitialPath();

        AtBatActionBar actionBarPage = new AtBatActionBar(getDriver());
        actionBarPage.openVideo();

        Assert.assertTrue(!actionBarPage.isAudioButtonAvailable(), "Video - Audio Button is currently visible and should not be");
    }

    @Test(priority = 4, description = "Lite User - Audio Feature Check (Standings)", enabled = true)
    public void testLiteUserAudioFeaturesStandings() {
        liteUserInitialPath();

        AtBatActionBar actionBarPage = new AtBatActionBar(getDriver());
        actionBarPage.openStandings();
        actionBarPage.getAudioPage();

        assertLiteAudioResults("Standings");
    }

    @Test(priority = 5, description = "Lite User - Audio Feature Check (Teams)", enabled = true)
    public void testLiteUserAudioFeaturesTeams() {
        liteUserInitialPath();

        AtBatActionBar actionBarPage = new AtBatActionBar(getDriver());
        actionBarPage.openTeamsMenu();
        actionBarPage.getAudioPage();

        assertLiteAudioResults("Team");
    }

    @Test(priority = 6, description = "Lite User - TV Feature Check (Teams)", enabled = true)
    public void testLiteUserTvFeaturesTeams() {
        liteUserInitialPath();

        AtBatActionBar actionBarPage = new AtBatActionBar(getDriver());
        actionBarPage.openTeamsMenu();
        actionBarPage.getVideoPage();

        assertLiteTVResults("Teams");
    }

    @Test(priority = 7, description = "Lite User - TV Feature Check (Standings)", enabled = true)
    public void testLiteUserTvFeaturesStandings() {
        liteUserInitialPath();

        AtBatActionBar actionBarPage = new AtBatActionBar(getDriver());
        actionBarPage.openStandings();
        actionBarPage.getVideoPage();

        assertLiteTVResults("Standings");
    }

    @Test(priority = 8, description = "Lite User - TV Feature Check (Video)", enabled = true)
    public void testLiteUserTvFeaturesVideo() {
        liteUserInitialPath();

        AtBatActionBar actionBarPage = new AtBatActionBar(getDriver());
        actionBarPage.openVideo();

        Assert.assertTrue(!actionBarPage.isVideoButtonAvailable(), "Video - Tv Button is currently visible and should not be");
    }

    @Test(priority = 9, description = "Lite User - TV Feature Check (News)", enabled = true)
    public void testLiteUserTvFeaturesNews() {
        liteUserInitialPath();

        AtBatActionBar actionBarPage = new AtBatActionBar(getDriver());
        actionBarPage.openNews();
        actionBarPage.getVideoPage();

        assertLiteTVResults("News");
    }

    @Test(priority = 10, description = "Lite User - TV Feature Check (Scoreboard)", enabled = true)
    public void testLiteUserTvFeaturesScoreboard() {
        liteUserInitialPath();

        AtBatActionBar actionBarPage = new AtBatActionBar(getDriver());
        actionBarPage.openScoreboard();
        actionBarPage.getVideoPage();

        assertLiteTVResults("Scoreboard");
    }
}
