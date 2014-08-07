package com.mlb.qa.at_bat.android.page;

import com.mlb.qa.at_bat.android.page.common.AtBatAndroidPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * MLB At Bat - Team Schedule Page
 * @author boyle
 *
 */
public class AtBatSchedulePage extends AtBatAndroidPage {

	@FindBy(xpath = "//android.widget.TextView[@text='Month']")
	private ExtendedWebElement monthLink;
	@FindBy(xpath = "//android.widget.TextView[@text='List']")
	private ExtendedWebElement listLink;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/schedulemonthwrapper")
	private ExtendedWebElement monthContainer;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/teamschedulelistlayout")
	private ExtendedWebElement listContainer;

	public AtBatSchedulePage(WebDriver driver) {
		super(driver);
	}

	public AtBatSchedulePage selectList() {
		/*if (isElementPresent(listLink, delay)) {
			click(listLink);
		}*/

        retrySelectionMechanism(listLink);

		return new AtBatSchedulePage(driver);
	}

	public AtBatSchedulePage selectMonth() {
		/*if (isElementPresent(monthLink, delay)) {
			click(monthLink);
		}*/

        retrySelectionMechanism(monthLink);

		return new AtBatSchedulePage(driver);
	}

	public boolean isListVisible() {
		if (isElementPresent(listLink, delay)) {
			return true;
		}
		return false;
	}

	public boolean isMonthVisible() {
		if (isElementPresent(monthLink, delay)) {
			return true;
		}
		return false;
	}

    /*private void retrySelectionMechanism(ExtendedWebElement passedElement) {
        int i = 0;
        while (!passedElement.getElement().isSelected() && ++i < 10) {
            logger.info("Attempting to select Element: " + i);
            click(passedElement);
            pause(1);
        }
    }*/
}
