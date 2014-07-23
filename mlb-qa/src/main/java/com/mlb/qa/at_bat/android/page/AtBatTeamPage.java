package com.mlb.qa.at_bat.android.page;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;
import com.mlb.qa.common.exception.TestRuntimeException;
import com.mlb.qa.common.timeout.Timeouts;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * MLB At Bat - Team page
 * @author boyle
 *
 */
public class AtBatTeamPage extends AtBatAndroidPage {

	public static String MENU_ITEM_LOCATOR_PATTERN = "//android.widget.TextView[@text='%s']";
	public static String BALLPARK_NAME_LOCATOR_PATTERN = "//android.widget.ImageView[@content-desc='%s']";

	//Navigation Bar
	@FindBy(id="android:id/action_bar_title")
	private ExtendedWebElement navigationTitle;

	//Team Game Preview Area / Game Pager Fragment
	@FindBy(id="com.bamnetworks.mobile.android.gameday.atbat:id.TeamGamePagerFragment_progressBar")
	private ExtendedWebElement gamePagerProgressBar;
	@FindBy(id="com.bamnetworks.mobile.android.gameday.atbat:id/TeamGamePagerFragment_gamesPager")
	private ExtendedWebElement gamePagerLayout;
	@FindBy(id="com.bamnetworks.mobile.android.gameday.atbat:id/TeamGamePagerFragment_gamesPagerTitleStrip")
	private ExtendedWebElement teamDatesAvailable;

	//Team Home Wall / Carousel
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id.TeamHomeWallFragment_progressBar")
	private ExtendedWebElement teamCarouselProgressBar;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/teamhome_carouselview")
	private ExtendedWebElement teamCarouselView;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/CarouselView_indicatorsContainer")
	private ExtendedWebElement teamCarouselIndicatorContainer;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/CarouselIndicatorView_indicator")
	private List<ExtendedWebElement> teamCarouselIndicators;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/TeamItemView_item")
	private ExtendedWebElement teamCarouselItem;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/TeamHomeWallAd_imageDefaultView")
	private ExtendedWebElement teamCarouselAdImage;

	//Team Main Menu Options
	@FindBy(id="com.bamnetworks.mobile.android.gameday.atbat:id/teamhome_scrollcontainer")
	private ExtendedWebElement teamScrollContainer;
	@FindBy(id="com.bamnetworks.mobile.android.gameday.atbat:id/TeamHome_teamhometablefragmentContainer")
	private ExtendedWebElement teamHomeFragmentContainer;
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='News']")
	private ExtendedWebElement itemNews;
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Video']")
	private ExtendedWebElement itemVideo;
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Schedule']")
	private ExtendedWebElement itemSchedule;
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Tickets']")
	private ExtendedWebElement itemTickets;
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Shop']")
	private ExtendedWebElement itemShop;

	//Team Option Container
	@FindBy(id="com.bamnetworks.mobile.android.gameday.atbat:id/TeamHome_optionsContainer")
	private ExtendedWebElement teamOptionContainer;
	@FindBy(xpath = "//android.widget.TextView[@text='Roster']")
	private ExtendedWebElement itemRoster;
	@FindBy(xpath = "//android.widget.TextView[@text='Notifications']")
	private ExtendedWebElement itemNotifications;	

	//Team More Area
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'More from')]")
	private ExtendedWebElement itemMorePartial;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/TeamHomeMoreFrag_container")
	private ExtendedWebElement itemMoreContainer;
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'on Instagram')]")
	private ExtendedWebElement itemInstagramPartial;
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'on Facebook')]")
	private ExtendedWebElement itemFacebookPartial;
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'on Twitter')]")
	private ExtendedWebElement itemTwitterPartial;

	//Team Ad
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/AdWrapperActivity_bannerView")
	private ExtendedWebElement teamAdWrapper;

	public AtBatTeamPage(WebDriver driver) {
		super(driver);
	}

	public AtBatTeamPage selectDateItem(int i) {
		if (isElementPresent(teamDatesAvailable, 10)) {
			click(String.format("Day: '%s'", teamDatesAvailable.getElement().findElements(By.className("android.widget.TextView")).get(i).getText()),
					teamDatesAvailable.getElement().findElements(By.className("android.widget.TextView")).get(i));
		}

		return new AtBatTeamPage(driver);
	}

	public AtBatTeamPage selectTeamMenuOptionByName(String teamName) {
		scrollTo(teamName, teamScrollContainer);
		click(String.format("Menu '%s' option", teamName),
				driver.findElement(By.xpath(String.format(
						MENU_ITEM_LOCATOR_PATTERN, teamName))));
		return new AtBatTeamPage(driver);
	}

	public AtBatNewsPage selectTeamNews() {
		if (isElementPresent(itemNews, delay)) {
			click(itemNews);
		} 

		return new AtBatNewsPage(driver);
	}

	public AtBatTeamPage selectTeamVideo() {
		if (isElementPresent(itemVideo, delay)) {
			int counter = 0;
			while (counter <= 5) {
				if (isElementPresent(teamHomeFragmentContainer, delay)) {
					click(itemVideo);		
				} else {
					break;	
				}
				counter = counter + 1;
			}
		} else {
			throw new TestRuntimeException(
					"The 'Video' menu item is not recognized on this page, and can't be selected.");
		}

		return new AtBatTeamPage(driver);
	}

	public AtBatSchedulePage selectTeamSchedule() {
		if (isElementPresent(itemSchedule, delay)) {
			click(itemSchedule);
		}

		return new AtBatSchedulePage(driver);
	}

	public AtBatTeamPage selectTeamTickets() {
		//TODO:  Need to determine what to do with selecting the Tickets page if anything.
		return new AtBatTeamPage(driver);
	}

	public AtBatTeamRosterPage selectTeamRoster() {
		if (isElementPresent(itemRoster, delay)) {
			click(itemRoster);
		}

		return new AtBatTeamRosterPage(driver);
	}

	public AtBatNotificationsPage selectTeamNotifications() {
		if (isElementPresent(itemNotifications, delay)) {
			click(itemNotifications);
		}
		
		return new AtBatNotificationsPage(driver);
	}

	public AtBatTeamPage selectCarouselItem(final int i) {
		if (isElementPresent(teamCarouselIndicators.get(i), delay)) {
			click(teamCarouselIndicators.get(i));
		}
		
		return new AtBatTeamPage(driver);
	}

	public AtBatTeamPage selectTeamMore() {
		if (isElementPresent(itemMorePartial, 10)) {
			int counter = 0;
			while (counter <= 5) {
				if (!isElementPresent(itemMoreContainer, delay)) {
					click(itemMorePartial);					
				} else {
					break;
				}
				counter = counter + 1;
			}
		}

		return new AtBatTeamPage(driver);
	}

	public AtBatWebViewPage selectTeamMoreFacebook() {
		if (isElementPresent(itemFacebookPartial, 10)) {
			click(itemFacebookPartial);
		}

		return new AtBatWebViewPage(driver);
	}

	public Boolean isSponsorSlideDisplayed() {		
		logger.info("Sponsor Slide Present: " + isElementPresent(teamCarouselAdImage) + " Normal Item Present: " + isElementPresent(teamCarouselItem));
		return isElementPresent(teamCarouselAdImage, 10);
	}

	public Boolean isTeamStadium(String stadiumName) {
		if (isElementPresent(String.format("Stadium '%s' name", stadiumName),
				driver.findElement(By.xpath(String.format(
						BALLPARK_NAME_LOCATOR_PATTERN, stadiumName))))) {
			return true;
		}
		return false;
	}

	public Boolean isCarouselItemVisible(int i) {
		if (isElementPresent(teamCarouselIndicators.get(i), 20)) {
			if (teamCarouselIndicators.get(i).getElement().isDisplayed()) {
				return true;
			}
			return false;
		}
		return false;
	}

	public Boolean isMoreContainerVisible() {
		if (isElementPresent(itemMoreContainer, 10)) {
			return true;
		}
		return false;
	}

	public Boolean isTeamsPage(String teamAbbrev) {
		if (isElementPresent(navigationTitle, delay)) {
			if (isElementPresent(String.format("Team '%s'", teamAbbrev),
					driver.findElement(By.xpath(String.format(
							MENU_ITEM_LOCATOR_PATTERN, teamAbbrev))), delay)) {
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean isDateProgressBarPresent() {
		return isElementPresent(gamePagerProgressBar, delay);
	}

	public boolean isCarouselProgressBarPresent() {
		return isElementPresent(teamCarouselProgressBar, delay);
	}

	public boolean isAdVisible() {
		return isElementPresent(teamAdWrapper, delay);
	}

	public AtBatTeamPage waitForDateProgressBarLoad() {
		new WebDriverWait(driver,
				120)
				.until(new Predicate<WebDriver>() {

					@Override
					public boolean apply(WebDriver arg0) {
						logger.info("Progress Bar Not Present: " + !isDateProgressBarPresent());
						logger.info("Date Container Present: " + isElementPresent(teamDatesAvailable));
						return (!isDateProgressBarPresent() && isElementPresent(teamDatesAvailable, delay));
					}
				});

		return new AtBatTeamPage(driver);
	}

	public AtBatTeamPage waitForCarouselLoad() {
		new WebDriverWait(driver,
				Timeouts.DEFAULT_CONTENT_LOADING_TIMEOUT.getTimeoutInSeconds())
				.until(new Predicate<WebDriver>() {

					@Override
					public boolean apply(WebDriver arg0) {
						logger.info("Carousel Progress Bar Not Present: " + !isCarouselProgressBarPresent());
						logger.info("Carousel Indicators Present: " + isElementPresent(teamCarouselIndicatorContainer));
						return (!isCarouselProgressBarPresent() && isElementPresent(teamCarouselIndicatorContainer));
					}
				});

		return new AtBatTeamPage(driver);
	}

	public int getNumberOfCarouselItems() {
		return teamCarouselIndicators.size();
	}

	public int getNumberOfDateItems() {
		int counter = 0;
		while (counter <= 5) {
			if (isElementPresent(teamDatesAvailable, 10)) {
				return teamDatesAvailable.getElement().findElements(By.className("android.widget.TextView")).size();				
			}
			counter = counter + 1;
		}
		
		throw new TestRuntimeException(
				"The 'Date Bar' hasn't loaded/or doesn't exist at this time and we're unable to gather the current size of it.");
	}

	public List<String> getDateItems() {
		int counter = 0;
		List<String> dateList = new LinkedList<String>();
		while (counter <= 5) {
			if (isElementPresent(teamDatesAvailable, 10)) {
				List<WebElement> dateWebElementList = teamDatesAvailable.getElement().findElements(By.className("android.widget.TextView"));
				for (int i = 0; i < dateWebElementList.size(); i++) {
					dateList.add(dateWebElementList.get(i).getText());
				}
				break;
			}
		}
		return dateList;
	}

	public String getDateItem(int i) {
		if (isElementPresent(teamDatesAvailable, 10)) {			
			return teamDatesAvailable.getElement().findElements(By.className("android.widget.TextView")).get(i).getText();
		}
		return "";
	}

	public int getNumberOfMoreItems() {
		if (isElementPresent(itemMoreContainer)) {
			return itemMoreContainer.getElement().findElements(By.className("android.widget.TextView")).size();
		} 
		throw new TestRuntimeException(
				"'More from' is not visible on this page and can't have its contents checked.");
	}
}
