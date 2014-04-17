package com.mlb.qa.tests.atb.web;

import java.util.List;

import org.joda.time.DateTime;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mlb.qa.atb.AtbParameter;
import com.mlb.qa.atb.model.Team;
import com.mlb.qa.atb.model.game_ticket.GameTicket;
import com.mlb.qa.atb.model.game_ticket.GameTicketComparator;
import com.mlb.qa.atb.service.http.AtbHttpService;
import com.mlb.qa.atb.service.lookup.AtbLookupService;
import com.mlb.qa.atb.web.page.AtbBallparkTicketsPage;
import com.mlb.qa.common.comparator.ListComparator;
import com.qaprosoft.carina.core.foundation.UITest;

/**
 * Check that content of Tickets page for each ballpark is correct<br>
 */
public class AtbBallparkTicketsTest extends UITest {
	private AtbHttpService httpService = new AtbHttpService();
	private AtbLookupService lookupService = new AtbLookupService();

	@Test(dataProvider = "excel_ds", description = "Check list of tickets correct")
	@Parameters({ "team_abbrev", "team_tickets_web" })
	public void checkTicketsList(String teamAbbrev, String ticketsUrl) {
		List<GameTicket> ticketsUi = AtbBallparkTicketsPage.open(driver, ticketsUrl).loadListOfGameTickets();
		String season = AtbParameter.MLB_ATB_SEASON.getValue();
		Team team = lookupService.lookupTeamByAbbrev(teamAbbrev, season);
		List<GameTicket> ticketsBackend = httpService.loadListOfTicketsFromGameTicketService(team.getTeamId(),
				team.getVenueId(), new DateTime());
		Assert.assertTrue(0 == new ListComparator<GameTicket>(new
				GameTicketComparator()).compareContent(ticketsUi, ticketsBackend),
				"List of tickets on UI isn't equal to list of ticket on TicketsService " +
						teamAbbrev + "; web:" + ticketsUrl);
	}
}
