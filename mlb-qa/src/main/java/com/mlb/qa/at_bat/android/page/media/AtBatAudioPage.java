package com.mlb.qa.at_bat.android.page.media;

import com.mlb.qa.at_bat.android.page.common.AtBatAndroidPage;
import org.openqa.selenium.WebDriver;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by boyle on 8/5/14.
 */
public class AtBatAudioPage extends AtBatAndroidPage {

    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/audioplayer_controlbutton")
    private ExtendedWebElement audioPlayerControlButton;
    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/audioplayer_statuslayout")
    private ExtendedWebElement audioPlayerStatus;
    @FindBy(xpath = "//android.widget.TextView[@text='No feeds/games currently available']")
    private ExtendedWebElement audioNoGames;
    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/AudioActivity_audioView")
    private ExtendedWebElement audioView;

    public AtBatAudioPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpen() {
        return isElementPresent(audioView);
    }
}
