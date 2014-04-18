package com.mlb.qa.tests.atb.web;

import java.util.List;

import org.joda.time.DateTime;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mlb.qa.atb.AtbParameter;
import com.mlb.qa.atb.model.Team;
import com.mlb.qa.atb.model.schedule.ScheduleGameInfo;
import com.mlb.qa.atb.model.schedule.ScheduleGameInfoComparator;
import com.mlb.qa.atb.service.lookup.AtbLookupService;
import com.mlb.qa.atb.web.page.AtbBallparkSchedulePage;
import com.mlb.qa.common.comparator.ListComparator;
import com.qaprosoft.carina.core.foundation.UITest;

/**
 */
public class AtbBallparkScheduleTest extends UITest {
	private AtbLookupService lookupService = new AtbLookupService();

	@Test(dataProvider = "excel_ds", description = "Check schedule on List tab")
	@Parameters({ "team_abbrev", "team_schedule_web" })
	public void checkListSchedule(String teamAbbrev, String scheduleUrl) {
		List<ScheduleGameInfo> scheduleUi = AtbBallparkSchedulePage.open(driver,
				scheduleUrl).loadGamesFromListTab();
		String year = AtbParameter.MLB_ATB_SEASON.getValue();
		int month = new DateTime().getMonthOfYear();
		Team team = lookupService.lookupTeamByAbbrev(teamAbbrev, year);
		List<ScheduleGameInfo> scheduleBe = lookupService.loookupListOfScheduledGamesForTheMonth(team.getTeamId(),
				Integer.parseInt(year),
				month);
		Assert.assertTrue(0 == new ListComparator<ScheduleGameInfo>(new
				ScheduleGameInfoComparator()).compareContent(scheduleUi, scheduleBe),
				"Check schedule on List tab for. Team: " +
						teamAbbrev + "; web:" + scheduleUrl);
	}
}
