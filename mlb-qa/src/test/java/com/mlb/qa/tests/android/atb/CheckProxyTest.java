package com.mlb.qa.tests.android.atb;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mlb.qa.android.atb.service.http.AtbHttpService;
import com.mlb.qa.android.atb.service.lookup.AtbLookupService;
import com.qaprosoft.carina.core.foundation.APITest;

public class CheckProxyTest extends APITest {
	private AtbLookupService lookupService = new AtbLookupService();
	private AtbHttpService httpService = new AtbHttpService();
	private static final Logger logger = Logger.getLogger(CheckProxyTest.class);
	@BeforeClass()
	public void setProxySettings(){
		//System.setProperty("http.proxyHost", "http://proxy-vip.mm3.mlbam.com");
       // System.setProperty("http.proxyPort", "80");
	}
	@Test()
	public void checkProxyGet() throws ClientProtocolException, IOException {
		/*String season = AtbParameter.MLB_ATB_SEASON.getValue();
		Team team = lookupService.lookupTeamByAbbrev("ARI", season);
		DateTime today = new DateTime();
		lookupService.lookupNearestIncomingHomeGame(
				team.getTeamId(), team.getVenueId(), today,
				today.plusMonths(6), season);*/
		HttpHost proxy = new HttpHost("proxy-vip.mm3.mlbam.com", 80);
		logger.info(proxy);
		DefaultHttpClient client = new DefaultHttpClient();
		logger.info(client);
		HttpGet get = new HttpGet("http://qa.mlb.com/lookup/named.team_all_season.bam?team_all_season.col_in=venue_id&team_all_season.col_in=name_display_full&team_all_season.col_in=team_id&team_all_season.col_in=name&team_all_season.col_in=name_short&team_all_season.col_in=name_abbrev&team_all_season.col_in=city&team_all_season.col_in=venue_name&name_abbrev='BAL'&season=2014&sport_id=1");
		logger.info(get);
		client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
			HttpResponse response = client.execute(get);
		logger.info(response.toString());
			String result = IOUtils.toString(response.getEntity().getContent());
			logger.info(result);

	}
	
	@Test()
	public void checkPost() throws ClientProtocolException, IOException{
		 HttpPost httpost = new HttpPost("http://qamsocial.bamnetworks.com/mobile-service-social/property");
			HttpHost proxy = new HttpHost("proxy-vip.mm3.mlbam.com", 80);

	        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
	        nvps.add(new BasicNameValuePair("key", "username"));
	        nvps.add(new BasicNameValuePair("IDToken2", "password"));
				httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
	
	        DefaultHttpClient client = new DefaultHttpClient();
	        client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
			logger.info(client);
	        HttpResponse response = client.execute(httpost);
	        logger.info(response);
	    	String result = IOUtils.toString(response.getEntity().getContent());
			logger.info(result);
	}
	
}
