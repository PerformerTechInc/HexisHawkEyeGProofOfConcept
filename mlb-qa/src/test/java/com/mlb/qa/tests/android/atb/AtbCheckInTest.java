package com.mlb.qa.tests.android.atb;

import java.io.UnsupportedEncodingException;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.testng.Assert;

//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mlb.qa.android.atb.model.Game;
import com.mlb.qa.android.atb.model.Team;
import com.mlb.qa.android.atb.page.AtbAndroidPage;
import com.mlb.qa.android.atb.page.AtbCheckedInPage;
import com.mlb.qa.android.atb.service.http.AtbHttpService;
import com.mlb.qa.android.atb.service.lookup.AtbLookupService;
import com.mlb.qa.android.atb.utils.AtbParameter;
import com.mlb.qa.android.atb.utils.DateUtils;

public class AtbCheckInTest extends BaseCheckinTest {

	private Game game;
	private Team team;

	private AtbHttpService httpService = new AtbHttpService();
	private AtbLookupService lookupService = new AtbLookupService();

	// @Parameters("team_abbrev")
	// @BeforeClass(enabled = true, description =
	// "Find nearest incoming game for the specified team")
	public void findNearestGameDateForBallpark(String teamAbbrev) {
		String season = AtbParameter.MLB_ATB_SEASON.getValue();
		team = lookupService.lookupTeamByAbbrev(teamAbbrev, season);
		DateTime today = new DateTime();
		game = lookupService.lookupNearestIncomingHomeGame(team.getTeamId(),
				team.getVenueId(), today, today.plusMonths(6), season);
	}

	// @BeforeClass(enabled = true, dependsOnMethods =
	// "findNearestGameDateForBallpark", description =
	// "Allow checkin for the game date")
	public void allowCheckinForGameDate() throws UnsupportedEncodingException {
		DateTime gameDate = DateUtils.parseString(game.getGameTimeLocal(),
				Game.GAME_TIME_LOCAL_FORMAT_PATTERN);
		httpService.setGameFeedCheckinServiceProperty(gameDate);
		int daysBetween = new Period(new DateTime(), gameDate,
				PeriodType.days()).getDays() + 1;
		httpService
				.setTimeBoundaryCheckinServiceProperty(daysBetween * 24 * 60l);
	}

	// @Test(enabled = true, dependsOnMethods = "openCheckinWindow", description
	// = "Check in")
	public void checkin() {
		AtbCheckedInPage checkedInPage = new AtbAndroidPage(driver)
				.openBallparksFromMenu()
				.openBallparkByTeamName(team.getNameFull()).openCheckInPage()
				.processLocationDetermining().confirmCheckIn();
		Assert.assertTrue(
				checkedInPage.isOpened()
						&& detectVenueOnUi(game).equalsIgnoreCase(
								checkedInPage.loadCheckedInStadiumName()),
				"Checked In page not opened or wrong stadium page displayed");
	}

	@Test(dataProvider = "excel_ds", description = "Check in")
	public void checkin(String teamAbbrev)
			throws UnsupportedEncodingException {
		findNearestGameDateForBallpark(teamAbbrev);
		allowCheckinForGameDate();
		loginIfNotLogged();
		openCheckinWindow();
		checkin();
	}
}
