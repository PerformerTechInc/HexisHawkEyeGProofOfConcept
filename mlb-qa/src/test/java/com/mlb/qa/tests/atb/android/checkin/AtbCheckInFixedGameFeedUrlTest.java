package com.mlb.qa.tests.atb.android.checkin;

import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mlb.qa.atb.AtbParameter;
import com.mlb.qa.atb.android.page.AtbAndroidPage;
import com.mlb.qa.atb.android.page.AtbCheckedInPage;
import com.mlb.qa.atb.model.Team;
import com.mlb.qa.atb.model.game.Game;
import com.mlb.qa.atb.model.identity_point.IdentityPoint;
import com.mlb.qa.common.comparator.FieldsComparator;
import com.mlb.qa.common.date.DateUtils;
import com.mlb.qa.common.exception.TestRuntimeException;

public class AtbCheckInFixedGameFeedUrlTest extends BaseCheckinTest {
	private DateTime checkinDate;
	private IdentityPoint identityPoint;

	@BeforeClass(description = "Detect IdentityPoint for account")
	public void detectIdentityPoint() throws UnsupportedEncodingException {
		identityPoint = httpService.loadIdentityPointByEmail(AtbParameter.MLB_ATB_DEFAULT_USER.getValue(),
				AtbParameter.MLB_ATB_DEFAULT_PASSWORD.getValue());
	}

	@Test(dataProvider = "prepareTestData", description = "Check in")
	public void checkin(String teamAbbrev, Game game, Team team) {
		loginIfNotLogged();
		//openCheckinWindow();
		AtbCheckedInPage checkedInPage = new AtbAndroidPage(driver)
				.openBallparksFromMenu()
				.openBallparkByTeamName(team.getNameFull()).openCheckInPage()
				.processLocationDetermining().confirmCheckIn();
		if (!checkedInPage.isOpened()) {
			Assert.fail("Checked In page not opened");
		}
		boolean result = (0 == FieldsComparator.compareFieldsIgnoreCase("Displayed and expected ballpark",
				checkedInPage.loadCheckedInStadiumName(), detectVenueOnUi(game)));
		result &= isCheckinInHistoryCorrect(game, checkinDate, identityPoint);
		Assert.assertTrue(result);
	}

	@DataProvider(name = "prepareTestData")
	public Object[][] prepareTestData(ITestContext context)
	{
		logger.info("Prepare list of ballparks with nearest incoming game date equal to the current check-in window date");
		Object[][] allArguments = createTestArgSets(context, "Execute", "y");
		checkinDate = httpService.getCheckinDate();
		List<List<Object>> dataToRun = new LinkedList<List<Object>>();
		for (int i = 0; i < allArguments.length; i++) {
			String teamAbbrev = (String) allArguments[i][0];
			String season = AtbParameter.MLB_ATB_SEASON.getValue();
			Team team = lookupService.lookupTeamByAbbrev(teamAbbrev, season);
			DateTime today = new DateTime();
			Game game = lookupService.lookupNearestIncomingHomeGame(team.getTeamId(),
					team.getVenueId(), today, today.plusMonths(6), season);
			DateTime gameDate = game.getGameTimeLocal();
			if (DateUtils.hasEqualDates(checkinDate, gameDate)) {
				//secondary verification that time for the game is less then 4 hours otherwise window is still closed
				if (gameDate.minusHours(4).isBeforeNow() && !gameDate.isBeforeNow()) {
					List<Object> row = new LinkedList<Object>();
					row.add("TUID:" + teamAbbrev);
					row.add(game);
					row.add(team);
					dataToRun.add(row);
				}
			}
		}
		// copy to array
		Object[][] dataToRunArr = new Object[dataToRun.size()][3];
		for (int i = 0; i < dataToRun.size(); i++) {
			dataToRunArr[i][0] = dataToRun.get(i).get(0);
			dataToRunArr[i][1] = dataToRun.get(i).get(1);
			dataToRunArr[i][2] = dataToRun.get(i).get(2);
			logger.info("Applicable teams number for checkin with current date is " + dataToRun.size());
			logger.info("Team: " + dataToRun.get(i).get(2) + "; Game: " + dataToRun.get(i).get(1));
		}
		if (dataToRunArr.length != 0) {
			int daysBetween = new Period(new DateTime(), checkinDate,
					PeriodType.days()).getDays() + 1;
			try {
				httpService
						.setTimeBoundaryCheckinServiceProperty(daysBetween * 24 * 60l);
			} catch (UnsupportedEncodingException e) {
				throw new TestRuntimeException(e);
			}
		}
		else {
			logger.info("No one ballpark has nearest incoming game date equal to current system check-in window date. No tests to run");
		}
		return dataToRunArr;
	}
}
