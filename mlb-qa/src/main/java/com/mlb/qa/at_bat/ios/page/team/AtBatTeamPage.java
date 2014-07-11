package com.mlb.qa.at_bat.ios.page.team;

import com.mlb.qa.at_bat.ios.page.team.news.AtBatNewsPage;
import com.mlb.qa.at_bat.ios.page.team.roster.AtBatRosterPage;
import com.mlb.qa.at_bat.ios.page.team.schedule.AtBatCalendarPage;
import com.mlb.qa.at_bat.ios.page.team.settings.AtBatSettingsPage;
import com.mlb.qa.at_bat.ios.page.team.shop.AtBatShopPage;
import com.mlb.qa.at_bat.ios.page.team.social.AtBatFacebookPage;
import com.mlb.qa.at_bat.ios.page.team.social.AtBatInstagramPage;
import com.mlb.qa.at_bat.ios.page.team.social.AtBatTwitterPage;
import com.mlb.qa.at_bat.ios.page.team.videos.AtBatVideosPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Igor Vayner on 6/26/14.
 */
public class AtBatTeamPage extends AtBatBaseTeamPage {

    @FindBy(name = "Instagram")
    public ExtendedWebElement instagramButton;

    @FindBy(name = "Facebook")
    public ExtendedWebElement facebookButton;

    @FindBy(name = "Twitter")
    public ExtendedWebElement twitterButton;

    @FindBy(name = "Settings")
    public ExtendedWebElement settingsButton;

    @FindBy(name = "Roster")
    public ExtendedWebElement rosterButton;

    @FindBy(name = "News")
    public ExtendedWebElement newsButton;

    @FindBy(name = "Schedule")
    public ExtendedWebElement scheduleButton;

    @FindBy(name = "Video")
    public ExtendedWebElement videosButton;

    @FindBy(name = "Tickets")
    public ExtendedWebElement ticketsButton;

    @FindBy(name = "Shop")
    public ExtendedWebElement shopButton;

    public AtBatTeamPage(WebDriver driver) {
        super(driver);
    }

    public AtBatTwitterPage getAtBatTwitterPage() {
        click(twitterButton);
        return new AtBatTwitterPage(driver);
    }

    public AtBatFacebookPage getAtBatFacebookPage() {
        click(facebookButton);

        return new AtBatFacebookPage(driver);
    }

    public AtBatInstagramPage getAtBatInstagramPage() {
        click(instagramButton);
        return new AtBatInstagramPage(driver);
    }

    public AtBatShopPage getAtBatShopePage() {
        click(shopButton);
        return new AtBatShopPage(driver);
    }

    public AtBatNewsPage getAtBatNewsPage() {
        click(newsButton);
        return new AtBatNewsPage(driver);
    }

    public AtBatVideosPage getAtBatVideosPage() {
        click(videosButton);
        return new AtBatVideosPage(driver);
    }

    public AtBatRosterPage getAtBatRosterPage() {
        click(rosterButton);
        return new AtBatRosterPage(driver);
    }

    public AtBatCalendarPage getAtBatCalendarPage() {
        click(scheduleButton);
        return new AtBatCalendarPage(driver);
    }

    public AtBatSettingsPage getAtBatSettingsPage(){
        click(settingsButton);
        return new AtBatSettingsPage(driver);
    }
}
