package com.mlb.qa.tests.atb.android;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Test;

import com.mlb.qa.atb.service.http.AtbHttpService;
import com.mlb.qa.atb.service.lookup.AtbLookupService;
import com.qaprosoft.carina.core.foundation.APITest;

public class CheckProxyTest extends APITest {
	private AtbLookupService lookupService = new AtbLookupService();
	private AtbHttpService httpService = new AtbHttpService();

	@Test()
	public void checkProxyGet() throws ClientProtocolException, IOException {

		lookupService.lookupTeamByAbbrev("ARI", "2014");
	}

	@Test()
	public void checkPost() throws ClientProtocolException, IOException {
		httpService.setTimeBoundaryCheckinServiceProperty(60 * 24l);
	}

}
