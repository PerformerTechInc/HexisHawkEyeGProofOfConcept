package com.mlb.qa.at_bat.android.page.common;

import com.mlb.qa.at_bat.android.page.media.AtBatAudioPage;
import com.mlb.qa.at_bat.android.page.media.AtBatTvPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by boyle on 8/5/14.
 */
public class AtBatActionBar extends AtBatAndroidPage {

    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/ActionBarMenuItem_audio")
    private ExtendedWebElement buttonAudio;
    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/ActionBarMenuItem_video")
    private ExtendedWebElement buttonVideo;
    @FindBy(id = "android:id/action_bar_title")
    private ExtendedWebElement actionBarTitle;

    public AtBatActionBar(WebDriver driver) {
        super(driver);
    }

    public AtBatAudioPage getAudioPage() {
        click(buttonAudio);

        return new AtBatAudioPage(driver);
    }

    public AtBatTvPage getVideoPage() {
        click(buttonVideo);

        return new AtBatTvPage(driver);
    }

    public boolean isPageTitle(String titleName) {
        return actionBarTitle.getText().contains(titleName);
    }

    public boolean isAudioButtonAvailable() {
        return isElementPresent(buttonAudio, delay);
    }

    public boolean isVideoButtonAvailable() {
        return isElementPresent(buttonVideo, delay);
    }
}
