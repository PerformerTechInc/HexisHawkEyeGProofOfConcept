package com.mlb.qa.atb.web.page;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.MutableDateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mlb.qa.atb.model.game.Game;
import com.mlb.qa.atb.model.game.GameStatus;
import com.mlb.qa.atb.model.schedule.ScheduleGameInfo;
import com.mlb.qa.common.date.DateUtils;
import com.mlb.qa.common.date.TimeZone;
import com.mlb.qa.common.exception.TestRuntimeException;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.Configuration.Parameter;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

/**
 * Ballpark schedule page
 */
public class AtbBallparkSchedulePage extends AbstractPage {
	private static final Logger logger = Logger.getLogger(AtbBallparkSchedulePage.class);
	private static final String HOME_PREFIX = "vs. ";
	private static final String AWAY_PREFIX = "@ ";
	private static final String SCHEDULED_GAME_REGEXP = "[\\w-]{1,} \\d{1,}:\\d{1,} \\w{2}";
	private static final String FINAL_GAME_REGEXP = "[\\w-]{1,} \\w \\d{1,}-\\d{1,}";
	// private static final String SCHEDULED_GAME_REGEXP =
	// "[\\w-\\s]{1,} \\d{1,}:\\d{1,} \\w{2}";
	// private static final String FINAL_GAME_REGEXP =
	// "[\\w-\\s]{1,} \\w \\d{1,}-\\d{1,}";
	private static final String SCORE_REGEXP = "[LW] \\d{1,}-\\d{1,}";
	private static final String GAME_STATUS_CALENDAR_SCHEDULED_REGEXP = "\\d{1,2}:\\d{1,2} [PA]M";
	private static final String GAME_STATUS_POSTPONED = "PPD";

	// e.g. Sat, May 24, 2014
	private static final String DATE_FORMAT_LIST = "EEE, MMM dd, yyyy hh:mm aa";
	// e.g. April 2014 07 03:14 PM
	private static final String DATE_FORMAT_CALENDAR = "MMMM y d hh:mm aa";
	private static final String START_OF_DAY = "12:00 PM";

	// common locators for nested elements
	private static final String GAME_OPPONENT_LOCATOR = ".//*[@class='game-opponent']";
	// List view specific locators
	private static final String GAME_DAY_LIST_LOCATOR = ".//*[@class='game-day']/h5";
	private static final String GAME_PROBABLES_LIST_LOCATOR = ".//div[@class='game-probables']";
	// Calendar view specific locators
	private static final String GAME_DAY_CALENDAR_LOCATOR = "./div[@class='game-day']";
	private static final String GAME_STATUS_CALENDAR_LOCATOR = "./div[@class='game-status']";

	// Common elements
	@FindBy(xpath = "//a[text()='Calendar']")
	private ExtendedWebElement calendarTab;
	@FindBy(xpath = "//a[text()='Opponent']")
	private ExtendedWebElement opponentTab;
	@FindBy(xpath = "//a[text()='List']")
	private ExtendedWebElement listTab;
	@FindBy(xpath = "//*[@class='nav-pagination']//li/h5")
	private ExtendedWebElement monthYearNavigation;
	@FindBy(xpath = "//section[@class='schedule-footnote']/p")
	private ExtendedWebElement timeZoneWarningLabel;

	// List view specific elements
	@FindBy(xpath = "//div[@class='game-details']")
	private List<ExtendedWebElement> gameDetailsContainersListView;
	// Calendar view specific elements
	@FindBy(xpath = "//td[contains(@class,'game-')]")
	private List<ExtendedWebElement> gameDetailsContainersCalendarView;

	public AtbBallparkSchedulePage(WebDriver driver) {
		super(driver);
	}

	public static AtbBallparkSchedulePage open(WebDriver driver, String url) {
		logger.info("Open " + url);
		driver.get(url);
		return new AtbBallparkSchedulePage(driver);
	}

	public AtbBallparkSchedulePage openCalendarTab() {
		logger.info("Open Calendar tab");
		click(calendarTab);
		return this;
	}

	public AtbBallparkSchedulePage openListTab() {
		logger.info("Open List tab");
		click(listTab);
		return this;
	}

	public AtbBallparkSchedulePage openOpponentTab() {
		logger.info("Open Opponent tab");
		click(opponentTab);
		return this;
	}

	public List<Game> loadGamesFromCalendarTab(String teamAbbrev) {
		logger.info("Load list of scheduled events from Calendar tab");
		openCalendarTab();
		String monthYearString = monthYearNavigation.getText().trim();
		String timeZoneName = StringUtils.substringBetween(timeZoneWarningLabel.getText(), "All Times ",
				". Subject To Change.");
		List<Game> result = new LinkedList<Game>();
		for (ExtendedWebElement container : gameDetailsContainersCalendarView) {
			Game game = new Game();
			String dateStr = monthYearString.concat(" ").concat(getTextIfPresent(container, GAME_DAY_CALENDAR_LOCATOR));
			String containerClass = container.getAttribute("class");
			String opponentStr = getTextIfPresent(container, GAME_OPPONENT_LOCATOR).trim();
			String gameStatusStr = getTextIfPresent(container, GAME_STATUS_CALENDAR_LOCATOR).trim();
			if (containerClass.contains("home")) {
				game.setHomeTeamAbbrev(teamAbbrev);
				game.setAwayTeamAbbrev(opponentStr);
			}
			else {
				game.setAwayTeamAbbrev(teamAbbrev);
				game.setHomeTeamAbbrev(opponentStr);
			}
			if (GAME_STATUS_POSTPONED.equals(gameStatusStr)) {
				game.setGameStatus(GameStatus.POSTPONED);
				dateStr = dateStr.concat(" ").concat(START_OF_DAY);
			} else if (gameStatusStr.matches(SCORE_REGEXP)) {
				game.setGameStatus(GameStatus.FINAL);
				String teamResult = StringUtils.substringBefore(gameStatusStr, " ");
				String opponentResult = detectOpponenResult(teamResult);
				String scorePart = StringUtils.substringAfter(gameStatusStr, " ");
				String[] score = scorePart.split("-");
				String winnerResult = score[0].trim();
				String loserResult = score[1].trim();
				if (containerClass.contains("home")) {
					game.setHomeResult(teamResult);
					game.setAwayResult(opponentResult);
					if ("W".equalsIgnoreCase(teamResult)) {
						game.setHomeTeamScore(winnerResult);
						game.setAwayTeamScore(loserResult);
					}
					else {
						game.setHomeTeamScore(loserResult);
						game.setAwayTeamScore(winnerResult);
					}
				}
				else {
					game.setHomeResult(opponentResult);
					game.setAwayResult(teamResult);
					if ("W".equalsIgnoreCase(teamResult)) {
						game.setHomeTeamScore(loserResult);
						game.setAwayTeamScore(winnerResult);
					}
					else {
						game.setHomeTeamScore(winnerResult);
						game.setAwayTeamScore(loserResult);
					}
				}
				dateStr = dateStr.concat(" ").concat(START_OF_DAY);
			}
			else if (gameStatusStr.matches(GAME_STATUS_CALENDAR_SCHEDULED_REGEXP)) {
				game.setGameStatus(GameStatus.SCHEDULED);
				dateStr = dateStr.concat(" ").concat(gameStatusStr);
			}
			else {
				game.setGameStatus(GameStatus.getByStatusText(gameStatusStr));
				dateStr = dateStr.concat(" ").concat(START_OF_DAY);
			}
			DateTime dt = DateUtils.parseString(dateStr, DATE_FORMAT_CALENDAR);
			game.setGameDate(dt);
			if (GameStatus.SCHEDULED.equals(game.getGameStatus())){
				MutableDateTime mdt = dt.toMutableDateTime();
				mdt.setZone(DateTimeZone.forOffsetHours(TimeZone.valueOf(timeZoneName).getOffset()));
				dt = mdt.toDateTime().withZone(DateTimeZone.forOffsetHours(0));
				game.setGameTimeGmt(dt);
			}
			result.add(game);
		}
		return result;
	}

	private String detectOpponenResult(String mainResult) {
		if ("L".equalsIgnoreCase(mainResult)) {
			return "W";
		}
		else if ("W".equalsIgnoreCase(mainResult)) {
			return "L";
		}
		else {
			throw new TestRuntimeException(String.format("Unknown result: %s", mainResult));
		}
	}

	public List<ScheduleGameInfo> loadGamesFromListTab() {
		logger.info("Load list of scheduled events from List tab");
		openListTab();
		List<ScheduleGameInfo> result = new LinkedList<ScheduleGameInfo>();
		for (ExtendedWebElement container : gameDetailsContainersListView) {
			ScheduleGameInfo info = new ScheduleGameInfo();
			String gameDayStr = getTextIfPresent(container, GAME_DAY_LIST_LOCATOR);
			String gameOpponenStr = getTextIfPresent(container, GAME_OPPONENT_LOCATOR);
			String gameProbablesStr = getTextIfPresent(container, GAME_PROBABLES_LIST_LOCATOR);
			// parse opponent string
			if (gameOpponenStr.startsWith(HOME_PREFIX)) {
				info.setIsHome(true);
				parseCommonGameInfo(info, StringUtils.substringAfter(gameOpponenStr, HOME_PREFIX), gameProbablesStr,
						gameDayStr);
			}
			else if (gameOpponenStr.startsWith(AWAY_PREFIX)) {
				info.setIsHome(false);
				parseCommonGameInfo(info, StringUtils.substringAfter(gameOpponenStr, AWAY_PREFIX), gameProbablesStr,
						gameDayStr);
			}
			else {
				throw new TestRuntimeException(String.format(
						"Unknown format of opponent info string: %s. Shoult start with '%s' or '%s'", gameOpponenStr,
						HOME_PREFIX, AWAY_PREFIX));
			}
			result.add(info);
		}
		return result;
	}

	private void parseCommonGameInfo(ScheduleGameInfo infoToSave, String opponentStr, String probablesStr,
			String gameDayStr) {
		if (opponentStr.matches(SCHEDULED_GAME_REGEXP)) {
			infoToSave.setIsScheduled(true);
			infoToSave.setOpponent(StringUtils.substringBeforeLast(opponentStr, " "));
			infoToSave.setScore("");
			infoToSave.setResult("");
			String datePart = StringUtils.substringAfterLast(opponentStr, " ");
			String time = gameDayStr.concat(" ");
			if ("PPD".equalsIgnoreCase(datePart)) {
				time = time.concat("12:00 PM");
			}
			else {
				time = time.concat(datePart);
			}
			infoToSave.setDate(DateUtils.parseString(time, DATE_FORMAT_LIST));
		}
		else if (opponentStr.matches(FINAL_GAME_REGEXP)) {
			infoToSave.setIsScheduled(false);
			String scorePart = StringUtils.substringAfterLast(opponentStr, " ");
			String opponentResultStr = StringUtils.substringBeforeLast(opponentStr, " ").trim();
			infoToSave.setOpponent(StringUtils.substringBeforeLast(opponentResultStr, opponentResultStr));
			infoToSave.setResult(StringUtils.substringAfterLast(opponentResultStr, opponentResultStr));
			infoToSave.setScore(scorePart);
			infoToSave.setDate(DateUtils.parseString(gameDayStr.concat(" 12:00 PM"), DATE_FORMAT_LIST));
		}
		else {
			throw new TestRuntimeException(String.format(
					"Unknown format of opponent info string: %s. Expected '%s' or '%s'", opponentStr,
					SCHEDULED_GAME_REGEXP, FINAL_GAME_REGEXP));
		}
		// infoToSave.setProbable(StringUtils.substringAfter(probablesStr,
		// "vs.").trim());
		// infoToSave.setOpponentProbable(StringUtils.substringBefore(probablesStr,
		// "vs.").trim());
	}

	private String getTextIfPresent(ExtendedWebElement container, String nestedLocator) {
		String text = "";
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			List<WebElement> foundElements = container.getElement().findElements(By.xpath(nestedLocator));
			if (!foundElements.isEmpty()) {
				text = (new ExtendedWebElement(foundElements.get(0))).getText();
			}
		} finally {
			driver.manage().timeouts()
					.implicitlyWait(Configuration.getLong(Parameter.IMPLICIT_TIMEOUT), TimeUnit.SECONDS);
		}
		return text;
	}
}
