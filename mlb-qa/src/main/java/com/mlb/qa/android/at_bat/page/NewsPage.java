package com.mlb.qa.android.at_bat.page;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.mlb.qa.exception.CommonTestRuntimeException;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

public class NewsPage extends AtBatAndroidPage {
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/NewsListItem_title")
	private List<ExtendedWebElement> newsTitles;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/default_banner_ad")
	private ExtendedWebElement sponsorImage;
	@FindBy(xpath = "//ImageView[@desc='Share with']")
	private ExtendedWebElement shareWithButton;
	@FindBy(id = "android:id/title")
	private List<ExtendedWebElement> shareWithMessageOptions;
	@FindBy(xpath = "//TextView[@text='See all']")
	private ExtendedWebElement seeAllButton;

	public NewsPage(WebDriver driver) {
		super(driver);
	}

	public NewsPage switchToDetailedView() {
		logger.debug("Try to switch to detailed view");
		if (newsTitles.isEmpty()) {
			throw new CommonTestRuntimeException(
					"Impossible to No any news displayed or you already on the detailed view");
		}
		click(newsTitles.get(0));
		return new NewsPage(driver);
	}

	public Boolean isSponsorSlideDisplayed() {
		return isElementPresent(sponsorImage);
	}

	public List<String> loadShareWithOptions() {
		click(shareWithButton);
		if (isElementPresent(seeAllButton)) {
			click(seeAllButton);
		}
		List<String> shareOptions = new LinkedList<String>();
		for (ExtendedWebElement element : shareWithMessageOptions) {
			shareOptions.add(element.getText());
		}
		return shareOptions;
	}
}
