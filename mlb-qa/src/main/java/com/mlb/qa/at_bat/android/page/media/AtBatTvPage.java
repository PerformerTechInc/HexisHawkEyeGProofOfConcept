package com.mlb.qa.at_bat.android.page.media;

import java.util.List;

import com.mlb.qa.at_bat.android.page.common.AtBatAndroidPage;
import org.openqa.selenium.WebDriver;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by boyle on 8/5/14.
 */
public class AtBatTvPage extends AtBatAndroidPage {

    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/DateNavigationBarView_dateLabel")
    private ExtendedWebElement datePicker;
    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/DateNavigationBarView_nextButton")
    private ExtendedWebElement dateBarNextButton;
    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/DateNavigationBarView_previousButton")
    private ExtendedWebElement dateBarPreviousButton;
    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/psgameslist_status")
    private ExtendedWebElement notAvailable;
    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/psgameslist_gameslist")
    private ExtendedWebElement feedView;
    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/MlbTvListItemView_matchupLabel")
    private List<ExtendedWebElement> matchUpList;
    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/MlbTvListItemView_freeGameOfTheDayLabel")
    private List<ExtendedWebElement> gotdList;
    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/MlbTvListView_reloadView")
    private ExtendedWebElement reloadTV;
    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/archiveView")
    private ExtendedWebElement tvView;

    public AtBatTvPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpen() {
        return isElementPresent(tvView);
    }

    public boolean doGamesExist() {
        if (matchUpList.size() > 0) {
            logger.info("Feed Size is: " + matchUpList.size());
            return true;
        }
        return false;
    }

    public void tapPreviousDay() {
        click(dateBarPreviousButton);
    }

    public void tapNextDay() {
        click(dateBarNextButton);
    }

    public void selectStream(final int i) {
        if (isElementPresent(matchUpList.get(i), delay)) {
            click(matchUpList.get(i));
        }
    }

    public boolean isPreviousDayAvailable() {
        return isElementPresent(dateBarPreviousButton);
    }

    public boolean isNextDayAvailable() {
        return isElementPresent(dateBarNextButton);
    }
}
