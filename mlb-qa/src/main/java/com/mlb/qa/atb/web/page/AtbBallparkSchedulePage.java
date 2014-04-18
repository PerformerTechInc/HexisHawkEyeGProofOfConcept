package com.mlb.qa.atb.web.page;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mlb.qa.atb.model.schedule.ScheduleGameInfo;
import com.mlb.qa.common.date.DateUtils;
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
	//private static final String SCHEDULED_GAME_REGEXP = "[\\w-\\s]{1,} \\d{1,}:\\d{1,} \\w{2}";
	//private static final String FINAL_GAME_REGEXP = "[\\w-\\s]{1,} \\w \\d{1,}-\\d{1,}";
	
	// e.g. Sat, May 24, 2014
	private static final String DATE_FORMAT = "EEE, MMM dd, yyyy hh:mm aa";

	private static final String GAME_DAY_LIST_LOCATOR = ".//*[@class='game-day']/h5";
	private static final String GAME_OPPONENT_LIST_LOCATOR = ".//*[@class='game-opponent']";
	private static final String GAME_PROBABLES_LIST_LOCATOR = ".//div[@class='game-probables']";

	@FindBy(xpath = "//a[text()='Calendar']")
	private ExtendedWebElement calendarTab;
	@FindBy(xpath = "//a[text()='Opponent']")
	private ExtendedWebElement opponentTab;
	@FindBy(xpath = "//a[text()='List']")
	private ExtendedWebElement listTab;
	@FindBy(xpath = "//div[@class='game-details']")
	private List<ExtendedWebElement> gameDetailsContainersListView;
	@FindBy(xpath = "//td[contains(@class, 'game-home')]")
	private List<ExtendedWebElement> gameHomeDetailsContainersTableView;
	@FindBy(xpath = "//td[contains(@class, 'game-away')]")
	private List<ExtendedWebElement> gameAwayDetailsContainersTableView;

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

	public List<ScheduleGameInfo> loadGamesFromCalendarTab() {
		openCalendarTab();
		List<ScheduleGameInfo> result = new LinkedList<ScheduleGameInfo>();

		return result;
	}

	public List<ScheduleGameInfo> loadGamesFromListTab() {
		logger.info("Load list of scheduled events from List tab");
		openListTab();
		List<ScheduleGameInfo> result = new LinkedList<ScheduleGameInfo>();
		for (ExtendedWebElement container : gameDetailsContainersListView) {
			ScheduleGameInfo info = new ScheduleGameInfo();
			String gameDayStr = getTextIfPresent(container, GAME_DAY_LIST_LOCATOR);
			String gameOpponenStr = getTextIfPresent(container, GAME_OPPONENT_LIST_LOCATOR);
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
			if ("TDD".equalsIgnoreCase(datePart)){
				time = time.concat("12:00 PM");
			}
			else{
				time = time.concat(datePart) ;
			}
			infoToSave.setDate(DateUtils.parseString(time, DATE_FORMAT));
		}
		else if (opponentStr.matches(FINAL_GAME_REGEXP)) {
			infoToSave.setIsScheduled(false);
			String scorePart = StringUtils.substringAfterLast(opponentStr, " ");
			String opponentResultStr = StringUtils.substringBeforeLast(opponentStr, " ").trim();
			infoToSave.setOpponent(StringUtils.substringBeforeLast(opponentResultStr, opponentResultStr));
			infoToSave.setResult(StringUtils.substringAfterLast(opponentResultStr, opponentResultStr));
			infoToSave.setScore(scorePart);
			infoToSave.setDate(DateUtils.parseString(gameDayStr.concat(" 12:00 PM"), DATE_FORMAT));
		}
		else {
			throw new TestRuntimeException(String.format(
					"Unknown format of opponent info string: %s. Expected '%s' or '%s'", opponentStr,
					SCHEDULED_GAME_REGEXP, FINAL_GAME_REGEXP));
		}
	//	infoToSave.setProbable(StringUtils.substringAfter(probablesStr, "vs.").trim());
	//	infoToSave.setOpponentProbable(StringUtils.substringBefore(probablesStr, "vs.").trim());
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
