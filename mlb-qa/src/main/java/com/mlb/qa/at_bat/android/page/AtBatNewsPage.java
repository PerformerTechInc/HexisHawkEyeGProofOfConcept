package com.mlb.qa.at_bat.android.page;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.mlb.qa.common.exception.TestRuntimeException;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * MLB At Bat - News page
 * @author
 *
 */
public class AtBatNewsPage extends AtBatAndroidPage {
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/NewsListItem_title")
	private List<ExtendedWebElement> newsTitles;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/default_banner_ad")
	private ExtendedWebElement sponsorImage;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/NewsArticleFragment_body")
	private ExtendedWebElement newsArticleBody;
	@FindBy(xpath = "//ImageView[@desc='Share with']")
	private ExtendedWebElement shareWithButton;
	@FindBy(id = "android:id/title")
	private List<ExtendedWebElement> shareWithMessageOptions;
	@FindBy(xpath = "//android.widget.TextView[@text='See all']")
	private ExtendedWebElement seeAllButton;

	public AtBatNewsPage(WebDriver driver) {
		super(driver);
	}

	public AtBatNewsPage switchToDetailedView() {
		logger.debug("Try to switch to detailed view");
		if (newsTitles.isEmpty()) {
			throw new TestRuntimeException(
					"Impossible to No any news displayed or you already on the detailed view");
		}
		click(newsTitles.get(0));
		return new AtBatNewsPage(driver);
	}

	public Boolean isSponsorSlideDisplayed() {
		logger.info("Sponsor Slide Present: " + isElementPresent(sponsorImage, delay) /*+ " Normal Item Present: " + isElementPresent(newsArticleBody, delay)*/);
		return isElementPresent(sponsorImage, delay);
	}

	public List<String> loadShareWithOptions() {
		click(shareWithButton);
		if (isElementPresent(seeAllButton, delay)) {
			click(seeAllButton);
		}
		List<String> shareOptions = new LinkedList<String>();
		for (ExtendedWebElement element : shareWithMessageOptions) {
			shareOptions.add(element.getText());
		}
		return shareOptions;
	}
}
