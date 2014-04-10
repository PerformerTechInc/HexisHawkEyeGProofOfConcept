package com.mlb.qa.tests.atb.android.checkin;

import java.io.UnsupportedEncodingException;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mlb.qa.atb.AtbParameter;
import com.mlb.qa.atb.android.page.AtbAndroidPage;
import com.mlb.qa.atb.android.page.AtbCheckedInPage;
import com.mlb.qa.atb.model.Game;
import com.mlb.qa.atb.model.Team;
import com.mlb.qa.atb.model.identity_point.IdentityPoint;
import com.mlb.qa.common.comparator.FieldsComparator;
import com.mlb.qa.common.date.DateUtils;

public class AtbCheckInTest extends BaseCheckinTest {

	private Game game;
	private Team team;
	private IdentityPoint identityPoint;
	private DateTime gameDate;

	@BeforeClass(description = "Detect IdentityPoint for account")
	public void detectIdentityPoint() throws UnsupportedEncodingException {
		identityPoint = httpService.loadIdentityPointByEmail(AtbParameter.MLB_ATB_DEFAULT_USER.getValue(),
				AtbParameter.MLB_ATB_DEFAULT_PASSWORD.getValue());
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

	private void findNearestGameDateForBallpark(String teamAbbrev) {
		String season = AtbParameter.MLB_ATB_SEASON.getValue();
		team = lookupService.lookupTeamByAbbrev(teamAbbrev, season);
		DateTime today = new DateTime();
		game = lookupService.lookupNearestIncomingHomeGame(team.getTeamId(),
				team.getVenueId(), today, today.plusMonths(6), season);
	}

	private void allowCheckinForGameDate() throws UnsupportedEncodingException {
		gameDate = DateUtils.parseString(game.getGameTimeLocal(),
				Game.GAME_TIME_LOCAL_FORMAT_PATTERN);
		httpService.setGameFeedCheckinServiceProperty(gameDate);
		int daysBetween = new Period(new DateTime(), gameDate,
				PeriodType.days()).getDays() + 1;
		httpService
				.setTimeBoundaryCheckinServiceProperty(daysBetween * 24 * 60l);
	}

	private void checkin() {
		AtbCheckedInPage checkedInPage = new AtbAndroidPage(driver)
				.openBallparksFromMenu()
				.openBallparkByTeamName(team.getNameFull()).openCheckInPage()
				.processLocationDetermining().confirmCheckIn();
		if (!checkedInPage.isOpened()) {
			Assert.fail("Checked In page not opened");
		}
		boolean result = (0 == FieldsComparator.compareFieldsIgnoreCase("Displayed and expected ballpark",
				checkedInPage.loadCheckedInStadiumName(), detectVenueOnUi(game)));
		result &= isCheckinInHistoryCorrect(game, gameDate, identityPoint);
		Assert.assertTrue(result);
	}
}
