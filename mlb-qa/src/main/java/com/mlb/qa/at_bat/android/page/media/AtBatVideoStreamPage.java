package com.mlb.qa.at_bat.android.page.media;

import com.mlb.qa.at_bat.android.page.common.AtBatAndroidPage;
import org.openqa.selenium.WebDriver;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by boyle on 8/6/14.
 */
public class AtBatVideoStreamPage extends AtBatAndroidPage {

    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/video_mainContainer")
    private ExtendedWebElement videoContainer;
    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/VideoViewOutput_Frame")
    private ExtendedWebElement videoOutputFrame;
    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/top_controls")
    private ExtendedWebElement topControls;
    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/feed")
    private ExtendedWebElement feedName;
    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/seekbar_volume")
    private ExtendedWebElement volumeControl;
    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/audio_image")
    private ExtendedWebElement audioMuteUnMuteButton;
    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/closedCaption")
    private ExtendedWebElement closedCaptionButton;
    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/stop")
    private ExtendedWebElement stopButton;

    public AtBatVideoStreamPage(WebDriver driver) {
        super(driver);
    }

    public void stopStream() {
        if (!isElementPresent(stopButton)) {
            if (isElementPresent(videoOutputFrame, delay)) {
                click(videoOutputFrame);
            }
        }
        click(stopButton);
    }

    public void toggleCaption() {
        if (!isElementPresent(closedCaptionButton)) {
            if (isElementPresent(videoOutputFrame, delay)) {
                click(videoOutputFrame);
            }
        }
        click(closedCaptionButton);
    }

    public void toggleAudio() {
        if (!isElementPresent(audioMuteUnMuteButton)) {
            if (isElementPresent(videoOutputFrame)) {
                click(videoOutputFrame);
            }
        }
        click(audioMuteUnMuteButton);
    }

    public boolean isOpen() {
        return isElementPresent(videoContainer);
    }
}
