package com.mlb.qa.android.at_bat.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * MLB At Bat - Team page
 * @author boyle
 *
 */
public class AtBatTeamPage extends AtBatAndroidPage {

	public static String MENU_ITEM_LOCATOR_PATTERN = "//TextView[@text='%s']";
	public static String BALLPARK_NAME_LOCATOR_PATTERN = "//ImageView[@name='%s']";

	//Team Game Preview Area
	@FindBy(id="com.bamnetworks.mobile.android.gameday.atbat:id/TeamGamePagerFragment_gamesPager")
	private ExtendedWebElement gamePagerLayout;
	@FindBy(id="com.bamnetworks.mobile.android.gameday.atbat:id/TeamGamePagerFragment_gamesPagerTitleStrip")
	private ExtendedWebElement teamDatesAvailable;

	//Team Carousel
	@FindBy(id="com.bamnetworks.mobile.android.gameday.atbat:id/CarouselIndicatorView_indicator")
	private List<ExtendedWebElement> teamCarouselIndicators;
	@FindBy(id="com.bamnetworks.mobile.android.gameday.atbat:id/TeamHomeWallAd_imageDefaultView")
	private ExtendedWebElement teamCarouselAdImage;

	@FindBy(id="com.bamnetworks.mobile.android.gameday.atbat:id/teamhome_scrollcontainer")
	private ExtendedWebElement teamScrollContainer;	
	@FindBy(xpath = "//ImageView[@name='News']")
	private ExtendedWebElement itemNews;
	@FindBy(xpath = "//ImageView[@name='Video']")
	private ExtendedWebElement itemVideo;
	@FindBy(xpath = "//ImageView[@name='Schedule']")
	private ExtendedWebElement itemSchedule;
	@FindBy(xpath = "//ImageView[@name='Tickets']")
	private ExtendedWebElement itemTickets;
	@FindBy(xpath = "//ImageView[@name='Shop']")
	private ExtendedWebElement itemShop;
	@FindBy(xpath = "//TextView[@text='Roster']")
	private ExtendedWebElement itemRoster;
	//TODO:  Need to change this based on the team we're on
	@FindBy(xpath = "//TextView[@text='More from New York Mets'")
	private ExtendedWebElement itemMore;
	@FindBy(xpath = "//TextView[contains(@text,'More from')]")
	private ExtendedWebElement itemMorePartial;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/TeamHomeMoreFrag_container")
	private ExtendedWebElement itemMoreContainer;
	@FindBy(xpath = "//TextView[contains(@text,'on Instagram')]")
	private ExtendedWebElement itemInstagramPartial;
	@FindBy(xpath = "//TextView[contains(@text,'on Facebook')]")
	private ExtendedWebElement itemFacebookPartial;
	@FindBy(xpath = "//TextView[contains(@text,'on Twitter')]")
	private ExtendedWebElement itemTwitterPartial;

	public AtBatTeamPage(WebDriver driver) {
		super(driver);
	}

	public AtBatTeamPage selectTeamMenuOptionByName(String teamName) {
		scrollTo(teamName, teamScrollContainer);
		click(String.format("Menu '%s' option", teamName),
				driver.findElement(By.xpath(String.format(
						MENU_ITEM_LOCATOR_PATTERN, teamName))));
		return new AtBatTeamPage(driver);
	}

	public AtBatNewsPage selectTeamNews() {
		click(itemNews);
		
		return new AtBatNewsPage(driver);
	}

	public AtBatTeamPage selectTeamVideo() {
		click(itemVideo);

		return new AtBatTeamPage(driver);
	}

	public AtBatSchedulePage selectTeamSchedule() {
		click(itemSchedule);

		return new AtBatSchedulePage(driver);
	}

	public AtBatTeamPage selectTeamTickets() {

		return new AtBatTeamPage(driver);
	}

	public AtBatTeamPage selectTeamStadium(String stadiumName) {

		if (isElementPresent(String.format("Stadium '%s' name", stadiumName),
				driver.findElement(By.xpath(String.format(
						BALLPARK_NAME_LOCATOR_PATTERN, stadiumName))))) {
			click(String.format("Stadium '%s' name", stadiumName),
					driver.findElement(By.xpath(String.format(
							BALLPARK_NAME_LOCATOR_PATTERN, stadiumName))));
		}

		return new AtBatTeamPage(driver);
	}

	public AtBatTeamRosterPage selectTeamRoster() {
		click(itemRoster);

		return new AtBatTeamRosterPage(driver);
	}

	public AtBatTeamPage selectCarouselItem(final int i) {

		click(teamCarouselIndicators.get(i));

		return new AtBatTeamPage(driver);
	}

	public Boolean isSponsorSlideDisplayed() {
		return isElementPresent(teamCarouselAdImage, 3);
	}

	public int getNumberOfDateItems() {
		return teamDatesAvailable.getElement().findElements(By.xpath("//TextView")).size();
	}

	public int getNumberOfCarouselItems() {
		return teamCarouselIndicators.size();
	}

	public AtBatTeamPage selectDateItem(int i) {
		if (isElementPresent(teamDatesAvailable, 10)) {
			click(String.format("Day: '%s'", teamDatesAvailable.getElement().findElements(By.xpath("//TextView")).get(i).getText()),
					teamDatesAvailable.getElement().findElements(By.xpath("//TextView")).get(i));
		}

		return new AtBatTeamPage(driver);
	}

	public AtBatTeamPage selectTeamMore() {
		if (isElementPresent(itemMorePartial, 10)) {
			click(itemMorePartial);
		}

		return new AtBatTeamPage(driver);
	}

	public AtBatWebViewPage selectTeamMoreFacebook() {
		if (isElementPresent(itemFacebookPartial, 10)) {
			click(itemFacebookPartial);
		}

		return new AtBatWebViewPage(driver);
	}

	public boolean isCarouselItemVisible(int i) {
		//TODO:  Need to revisit this and remove the first timer.
		Sleeper.sleepTightInSeconds(20);
		if (isElementPresent(teamCarouselIndicators.get(i), 20)) {
			if (teamCarouselIndicators.get(i).getElement().isDisplayed()) {
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean isMoreContainerVisible() {
		if (isElementPresent(itemMoreContainer, 10)) {
			return true;
		}
		return false;
	}
}
