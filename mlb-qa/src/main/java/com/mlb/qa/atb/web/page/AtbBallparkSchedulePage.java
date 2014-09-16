package com.mlb.qa.atb.web.page;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mlb.qa.atb.model.game.Game;
import com.mlb.qa.atb.model.game.GameStatus;
import com.mlb.qa.common.date.DateUtils;
import com.mlb.qa.common.date.TimeZone;
import com.mlb.qa.common.exception.TestRuntimeException;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.Configuration.Parameter;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

/**
 * Ballpark schedule page
 * 
 */
public class AtbBallparkSchedulePage extends AbstractPage {
	private static final Logger logger = Logger.getLogger(AtbBallparkSchedulePage.class);
	private static final String HOME_PREFIX = "vs.";
	private static final String GAME_OPPONENT_LIST_REGEXP = "(@|vs\\.) [\\w-\\s]* ([LW] \\d{1,}-\\d{1,}|\\d{1,2}:\\d{1,2} [PA]M|\\d{1,2}|PPD|TBD|(Gm|Bot|Mid|End|Top) \\d{1,2}( \\d{1,}-\\d{1,})?)";
	private static final String GAME_IN_PROGRESS_STATUSES_REGEXP = "(Gm|Bot|Mid|End|Top) \\d{1,2}( \\d{1,}-\\d{1,})?";
	private static final String SCORE_REGEXP = "[LW] \\d{1,}-\\d{1,}";
	private static final String GAME_TIME_REGEXP = "\\d{1,2}:\\d{1,2} [PA]M";
	private static final String GAME_STATUS_POSTPONED = "PPD";

	// e.g. Sat, May 24, 2014 03:14 PM
	private static final String DATE_FORMAT_LIST = "EEE, MMM dd, yyyy hh:mm aa";
	// e.g. April 2014 07 03:14 PM
	private static final String DATE_FORMAT_CALENDAR = "MMMM y d hh:mm aa";
	private static final String START_OF_DAY = "12:00 PM";

	// common locators for nested elements
	private static final String GAME_OPPONENT_LOCATOR = ".//*[@class='game-opponent']";
	// List view specific locators
	private static final String GAME_DAY_LIST_LOCATOR = ".//*[@class='game-day']/h5";
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
	@FindBy(xpath = "//*[@class='schedule-list']//div[@class='game-details']")
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
		pause(3);		
		return this;
	}

	public AtbBallparkSchedulePage openListTab() {
		logger.info("Open List tab");
		click(listTab);
		pause(3);
		return this;
	}

	public AtbBallparkSchedulePage openOpponentTab() {
		logger.info("Open Opponent tab");
		click(opponentTab);
		pause(3);		
		return this;
	}

	public List<Game> loadGamesFromListTab(String teamBrief) {
		logger.info("Load list of scheduled events from List tab");
		openListTab();
		String timeZoneName = StringUtils.substringBetween(timeZoneWarningLabel.getText(), "All Times ",
				". Subject To Change.");
		List<Game> result = new LinkedList<Game>();
		for (ExtendedWebElement container : gameDetailsContainersListView) {
			String gameTimeStr = getTextIfPresent(container, GAME_DAY_LIST_LOCATOR);
			String gameOpponentStr = getTextIfPresent(container, GAME_OPPONENT_LOCATOR);
			if (!gameOpponentStr.matches(GAME_OPPONENT_LIST_REGEXP)) {
				if (!gameOpponentStr.contains("TBD") && !gameOpponentStr.contains("@") && !gameOpponentStr.contains("vs.")) {				
					throw new TestRuntimeException(String.format(
						"Opponent string has wrong format. Regexp: '%s', but found: '%s'", GAME_OPPONENT_LIST_REGEXP,
						gameOpponentStr));
				}
			}
			Game game = new Game();
			// home/away prefix
			String homeAwayPrefix = StringUtils.substringBefore(gameOpponentStr, " ");
			// opponent result
			gameOpponentStr = StringUtils.substringAfter(gameOpponentStr, " ");
			String opponent;
			if (gameOpponentStr.endsWith(GAME_STATUS_POSTPONED)) {
				opponent = StringUtils.substringBefore(gameOpponentStr, " " + GAME_STATUS_POSTPONED).trim();
				game.setGameStatus(GameStatus.POSTPONED);
				gameTimeStr = gameTimeStr.concat(" ").concat(START_OF_DAY);
			}
			else if (gameOpponentStr.matches(".*" + SCORE_REGEXP)) {
				String score = findByRegexp(gameOpponentStr, SCORE_REGEXP);
				opponent = StringUtils.substringBefore(gameOpponentStr, score).trim();
				game.setGameStatus(GameStatus.FINAL);
				storeScoreToGame(game, score, homeAwayPrefix.equals(HOME_PREFIX));
				gameTimeStr = gameTimeStr.concat(" ").concat(START_OF_DAY);
			}
			else if (gameOpponentStr.matches(".*" + GAME_TIME_REGEXP)) {
				game.setGameStatus(GameStatus.SCHEDULED);
				String gameTime = findByRegexp(gameOpponentStr, GAME_TIME_REGEXP);
				opponent = StringUtils.substringBefore(gameOpponentStr, gameTime).trim();
				gameTimeStr = gameTimeStr.concat(" ").concat(gameTime);
			}
			else {
				game.setGameStatus(GameStatus.IN_PROGRESS);
				opponent = StringUtils.substringBefore(gameOpponentStr,
						findByRegexp(gameOpponentStr, GAME_IN_PROGRESS_STATUSES_REGEXP)).trim();
				gameTimeStr = gameTimeStr.concat(" ").concat(START_OF_DAY);
			}
			// store to object
			if (homeAwayPrefix.equals(HOME_PREFIX)) {
				game.setHomeTeamBrief(teamBrief);
				game.setAwayTeamBrief(opponent);
			}
			else {
				game.setHomeTeamBrief(opponent);
				game.setAwayTeamBrief(teamBrief);
			}
			storeGameDateTime(game, gameTimeStr, timeZoneName, DATE_FORMAT_LIST);
			result.add(game);
		}
		return result;
	}

	public List<Game> loadGamesFromCalendarTab(String teamAbbrev) {
		logger.info("Load list of scheduled events from Calendar tab");
		openCalendarTab();
		String monthYearString = monthYearNavigation.getText().trim();
		String timeZoneName = StringUtils.substringBetween(timeZoneWarningLabel.getText(), "All Times ",
				". Subject To Change.");
		List<Game> result = new LinkedList<Game>();
		for (ExtendedWebElement container : gameDetailsContainersCalendarView) {
			String dateStr = monthYearString.concat(" ").concat(getTextIfPresent(container, GAME_DAY_CALENDAR_LOCATOR));
			String containerClass = container.getAttribute("class");
			List<WebElement> opponents = container.getElement().findElements(By.xpath(GAME_OPPONENT_LOCATOR));
			List<WebElement> gameStatuses = container.getElement().findElements(By.xpath(GAME_STATUS_CALENDAR_LOCATOR));
			// there may be 2 games in 1 day...
			for (int i = 0; i < opponents.size(); i++) {
				Game game = new Game();
				String opponentStr = new ExtendedWebElement(opponents.get(i)).getText().trim();
				// The count of game status should be equal to the count of game
				// opponents!
				String dateStrCopy = dateStr; // local copy to avoid duplicating
												// of suffix like 12:00 PM
				String gameStatusStr = new ExtendedWebElement(gameStatuses.get(i)).getText().trim();
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
					dateStrCopy = dateStrCopy.concat(" ").concat(START_OF_DAY);
				} else if (gameStatusStr.matches(SCORE_REGEXP)) {
					game.setGameStatus(GameStatus.FINAL);
					storeScoreToGame(game, gameStatusStr, containerClass.contains("home"));
					dateStrCopy = dateStrCopy.concat(" ").concat(START_OF_DAY);
				}
				else if (gameStatusStr.matches(GAME_TIME_REGEXP)) {
					game.setGameStatus(GameStatus.SCHEDULED);
					dateStrCopy = dateStrCopy.concat(" ").concat(gameStatusStr);
				}
				else {
					game.setGameStatus(GameStatus.getByStatusText(gameStatusStr));
					dateStrCopy = dateStrCopy.concat(" ").concat(START_OF_DAY);
				}
				storeGameDateTime(game, dateStrCopy, timeZoneName, DATE_FORMAT_CALENDAR);
				result.add(game);
			}
		}
		return result;
	}

	private void storeScoreToGame(Game target, String scoreStr, Boolean isHomeGame) {
		String teamResult = StringUtils.substringBefore(scoreStr, " ");
		String opponentResult = detectOpponenResult(teamResult);
		String scorePart = StringUtils.substringAfter(scoreStr, " ");
		String[] score = scorePart.split("-");
		String winnerResult = score[0].trim();
		String loserResult = score[1].trim();
		if (isHomeGame) {
			target.setHomeResult(teamResult);
			target.setAwayResult(opponentResult);
			if ("W".equalsIgnoreCase(teamResult)) {
				target.setHomeTeamScore(winnerResult);
				target.setAwayTeamScore(loserResult);
			}
			else {
				target.setHomeTeamScore(loserResult);
				target.setAwayTeamScore(winnerResult);
			}
		}
		else {
			target.setHomeResult(opponentResult);
			target.setAwayResult(teamResult);
			if ("W".equalsIgnoreCase(teamResult)) {
				target.setHomeTeamScore(loserResult);
				target.setAwayTeamScore(winnerResult);
			}
			else {
				target.setHomeTeamScore(winnerResult);
				target.setAwayTeamScore(loserResult);
			}
		}
	}

	private void storeGameDateTime(Game target, String timeStr, String timeZoneStr, String format) {
		DateTime dt = DateUtils.parseString(timeStr, format);
		target.setGameDate(dt);
		if (GameStatus.SCHEDULED.equals(target.getGameStatus())) {
			dt = dt.withZoneRetainFields(DateTimeZone.forID(TimeZone.valueOf(timeZoneStr).getId())).withZone(
					DateTimeZone.forOffsetHours(0));
			target.setGameTimeGmt(dt);
		}
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

	private String findByRegexp(String source, String regexp) {
		Matcher m = Pattern.compile(regexp).matcher(source);
		if (!m.find()) {
			//additional verification onto presence of TBD, @, "vs.", 
			if (!source.contains("Susp.")) {
				throw new TestRuntimeException(String.format("No group found by regexp '%s' in the input string '%s'",
					regexp, source));
			}
		}
		return regexp = m.group();
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
