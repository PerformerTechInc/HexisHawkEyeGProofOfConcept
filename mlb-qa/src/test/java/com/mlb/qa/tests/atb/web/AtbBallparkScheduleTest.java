package com.mlb.qa.tests.atb.web;

import java.util.List;

import org.joda.time.DateTime;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mlb.qa.atb.AtbParameter;
import com.mlb.qa.atb.model.Team;
import com.mlb.qa.atb.model.game.Game;
import com.mlb.qa.atb.model.schedule.GameScheduleCalendarViewComparator;
import com.mlb.qa.atb.model.schedule.GameScheduleListViewComparator;
import com.mlb.qa.atb.service.lookup.AtbLookupService;
import com.mlb.qa.atb.web.page.AtbBallparkSchedulePage;
import com.mlb.qa.common.comparator.ListComparator;

/**
 * Schedule test
 */
public class AtbBallparkScheduleTest extends AtbBaseWebTest {
	private AtbLookupService lookupService = new AtbLookupService();

	@Test(dataProvider = "excel_ds", description = "Check schedule on List tab")
	@Parameters({ "team_abbrev", "team_schedule_web" })
	public void checkListSchedule(String teamAbbrev, String scheduleUrl) {
		String year = AtbParameter.MLB_ATB_SEASON.getValue();
		Team team = lookupService.lookupTeamByAbbrev(teamAbbrev, year);
		List<Game> gamesUi = AtbBallparkSchedulePage.open(getDriver(),
				scheduleUrl).loadGamesFromListTab(team.getName());
		int month = new DateTime().getMonthOfYear();
		List<Game> gamesBe = lookupService.loookupListOfGamesForTheMonth(team.getTeamId(),
				Integer.parseInt(year),
				month);
		Assert.assertTrue(0 == new ListComparator<Game>(new
				GameScheduleListViewComparator()).compareContent(gamesUi, gamesBe),
				"Check schedule on List tab. Team: " +
						teamAbbrev + "; web:" + scheduleUrl);

	}

	@Test(enabled = true, dataProvider = "excel_ds", description = "Check schedule on Calendar tab")
	@Parameters({ "team_abbrev", "team_schedule_web" })
	public void checkCalendarSchedule(String teamAbbrev, String scheduleUrl) {
		List<Game> gamesUi = AtbBallparkSchedulePage.open(getDriver(),
				scheduleUrl).loadGamesFromCalendarTab(teamAbbrev);
		String year = AtbParameter.MLB_ATB_SEASON.getValue();
		int month = new DateTime().getMonthOfYear();
		Team team = lookupService.lookupTeamByAbbrev(teamAbbrev, year);
		List<Game> gamesBe = lookupService.loookupListOfGamesForTheMonth(team.getTeamId(),
				Integer.parseInt(year),
				month);
		Assert.assertTrue(0 == new ListComparator<Game>(new
				GameScheduleCalendarViewComparator()).compareContent(gamesUi, gamesBe),
				"Check schedule on Calendar tab. Team: " +
						teamAbbrev + "; web:" + scheduleUrl);
	}
}
