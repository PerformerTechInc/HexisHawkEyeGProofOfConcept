package com.mlb.qa.at_bat.android.page;

import com.mlb.qa.at_bat.android.page.common.AtBatAndroidPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * MLB At Bat - Generic Webview Page
 * @author boyle
 *
 */
public class AtBatWebViewPage extends AtBatAndroidPage {

	public static String ACTION_BAR_NAME_LOCATOR_PATTERN = "//android.widget.TextView[@text='%s']";

	@FindBy(id = "android:id/action_bar_title")
	private ExtendedWebElement actionBarTitle;

	public AtBatWebViewPage(WebDriver driver) {
		super(driver);
	}

	public boolean isTeamsWebView(String teamAbbrev) {
		if (isElementPresent(actionBarTitle, delay)) {
			if (isElementPresent(String.format("Team '%s'", teamAbbrev),
					driver.findElement(By.xpath(String.format(
							ACTION_BAR_NAME_LOCATOR_PATTERN, teamAbbrev))), delay)) {
				return true;
			}
			return false;
		}
		return false;
	}
}
