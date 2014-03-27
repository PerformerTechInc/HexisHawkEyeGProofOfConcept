package com.mlb.qa.tests.android.atb;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import org.apache.commons.httpclient.HttpHost;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.xmlbeans.impl.common.IOUtil;
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
		//System.setProperty("http.proxyHost", "http://proxy-vip.mm3.mlbam.com");
       // System.setProperty("http.proxyPort", "80");
	}
	@Test()
	public void checkProxyGet() {
		/*String season = AtbParameter.MLB_ATB_SEASON.getValue();
		Team team = lookupService.lookupTeamByAbbrev("ARI", season);
		DateTime today = new DateTime();
		lookupService.lookupNearestIncomingHomeGame(
				team.getTeamId(), team.getVenueId(), today,
				today.plusMonths(6), season);*/
		HttpHost proxy = new HttpHost("http://proxy-vip.mm3.mlbam.com", 80);
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet("http://qa.mlb.com/lookup/named.team_all_season.bam?team_all_season.col_in=venue_id&team_all_season.col_in=name_display_full&team_all_season.col_in=team_id&team_all_season.col_in=name&team_all_season.col_in=name_short&team_all_season.col_in=name_abbrev&team_all_season.col_in=city&team_all_season.col_in=venue_name&name_abbrev='BAL'&season=2014&sport_id=1");
		client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
		try {
			HttpResponse response = client.execute(get);
			System.out.print(response.toString() );
			InputStream istream = response.getEntity().getContent();
			String result = IOUtils.toString(istream);
			System.out.print(result);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test()
	public void checkProxyPost() {
		httpService.setTimeBoundaryCheckinServiceProperty(5 * 24 * 60l);
	}
	
	
}
