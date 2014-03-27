package com.mlb.qa.tests.android.atb;

import org.joda.time.DateTime;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mlb.qa.android.atb.model.Game;
import com.mlb.qa.android.atb.model.Team;
import com.mlb.qa.android.atb.service.http.AtbHttpService;
import com.mlb.qa.android.atb.service.lookup.AtbLookupService;
import com.mlb.qa.android.atb.utils.AtbParameter;
import com.qaprosoft.carina.core.foundation.APITest;

public class CheckProxyTest extends APITest {
	private AtbLookupService lookupService = new AtbLookupService();
	private AtbHttpService httpService = new AtbHttpService();

	@BeforeClass()
	public void setProxySettings(){
		System.setProperty("http.proxyHost", "http://proxy-vip.mm3.mlbam.com");
        System.setProperty("http.proxyPort", "80");
	}
	@Test()
	public void checkProxyGet() {
		String season = AtbParameter.MLB_ATB_SEASON.getValue();
		Team team = lookupService.lookupTeamByAbbrev("ARI", season);
		DateTime today = new DateTime();
		lookupService.lookupNearestIncomingHomeGame(
				team.getTeamId(), team.getVenueId(), today,
				today.plusMonths(6), season);
	}

	@Test()
	public void checkProxyPost() {
		httpService.setTimeBoundaryCheckinServiceProperty(5 * 24 * 60l);
	}
}
