package com.mlb.qa.tests.android.atb;

import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mlb.qa.android.atb.model.Game;
import com.mlb.qa.android.atb.model.Team;
import com.mlb.qa.android.atb.page.AtbAndroidPage;
import com.mlb.qa.android.atb.page.AtbCheckedInPage;
import com.mlb.qa.android.atb.utils.AtbParameter;
import com.mlb.qa.android.atb.utils.DateUtils;
import com.mlb.qa.exception.TestRuntimeException;

public class AtbCheckInFixedGameFeedUrlTest extends BaseCheckinTest {

	@Test(dataProvider = "prepareTestData", description = "Check in")
	public void checkin(String teamAbbrev, Game game, Team team) {
		loginIfNotLogged();
		openCheckinWindow();
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

	@DataProvider(name = "prepareTestData")
	public Object[][] prepareTestData(ITestContext context)
	{
		logger.info("Prepare list of ballparks with nearest incoming game date equal to the current check-in window date");
		Object[][] allArguments = createTestArgSets(context, "Execute", "y");
		DateTime checkinDate = httpService.getCheckinDate();
		List<List<Object>> dataToRun = new LinkedList<List<Object>>();
		for (int i = 0; i < allArguments.length; i++) {
			String teamAbbrev = (String) allArguments[i][0];
			String season = AtbParameter.MLB_ATB_SEASON.getValue();
			Team team = lookupService.lookupTeamByAbbrev(teamAbbrev, season);
			DateTime today = new DateTime();
			Game game = lookupService.lookupNearestIncomingHomeGame(team.getTeamId(),
					team.getVenueId(), today, today.plusMonths(6), season);
			DateTime gameDate = DateUtils.parseString(game.getGameTimeLocal(),
					Game.GAME_TIME_LOCAL_FORMAT_PATTERN);
			if (DateUtils.hasEqualDates(checkinDate, gameDate)) {
				List<Object> row = new LinkedList<Object>();
				row.add("TUID:" + teamAbbrev);
				row.add(game);
				row.add(team);
				dataToRun.add(row);
			}
		}
		// copy to array
		Object[][] dataToRunArr = new Object[dataToRun.size()][3];
		for (int i = 0; i < dataToRun.size(); i++) {
			dataToRunArr[i][0] = dataToRun.get(i).get(0);
			dataToRunArr[i][1] = dataToRun.get(i).get(1);
			dataToRunArr[i][2] = dataToRun.get(i).get(2);
		}
		if (dataToRunArr.length != 0){
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
			logger.info("No one balpark has nearest incoming game date equal to current system check-in window date. No tests to run");
		}
		return dataToRunArr;
	}
}
