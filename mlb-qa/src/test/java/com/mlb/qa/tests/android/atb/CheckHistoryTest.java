package com.mlb.qa.tests.android.atb;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.joda.time.DateTime;
import org.testng.annotations.Test;

import com.mlb.qa.android.atb.model.checkin_history.CheckinHistoryItem;
import com.mlb.qa.android.atb.model.checkin_history.CheckinHistoryJsonRS;
import com.mlb.qa.android.atb.model.identity_point.IdentityPoint;
import com.mlb.qa.android.atb.model.identity_point.IdentityPointIdentifyRS;
import com.mlb.qa.android.atb.service.http.AtbHttpService;
import com.qaprosoft.carina.core.foundation.APITest;

public class CheckHistoryTest extends APITest {
	public static final String correct = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Header /<soapenv:Body><identityPoint_identify_response xmlns=\"http://services.bamnetworks.com/registration/types/1.5\"><identification type=\"email-password\"><id>25925174</id><fingerprint>cWQ2MWlxM2xyT3d6ekU4bitWQVJKZDF6Z2x3PXwxMzk2NjQ1NTAzMzg4fGlwdD1lbWFpbC1wYXNzd29yZA==</fingerprint><email><id>20212068</id><address>igor.vayner@outlook.com</address></email><password>123QWEasd</password><mobilePhone /><profileProperty /></identification><status><code>1</code><message>OK</message></status></identityPoint_identify_response></soapenv:Body></soapenv:Envelope>";
	public static final String wrong = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Header /><soapenv:Body><identityPoint_identify_response xmlns=\"http://services.bamnetworks.com/registration/types/1.5\"><status><code>-1000</code><message>[Invalid credentials for identification] [com.bamnetworks.registration.types.exception.IdentificationException: Account doesn't exits]</message><exceptionClass>com.bamnetworks.registration.types.exception.IdentificationException</exceptionClass><detail type=\"identityPoint\" field=\"exists\" message=\"false\" messageKey=\"identityPoint.exists\" /><detail type=\"identityPoint\" field=\"email-password\" message=\"identification error on identity point of type email-password\" messageKey=\"identityPoint.email-password\" /></status></identityPoint_identify_response></soapenv:Body></soapenv:Envelope>";
	public static final String jsonSource = "{\"response\":[{\"checkinType\":\"mlb\",\"homeScore\":\"\",\"checkinStatusId\":0,\"venueType\":\"MLB\",\"checkinDate\":\"2014-04-04T16:02:59\",\"eventType\":\"R\",\"checkinId\":\"4c44d152-d223-4b98-a197-0719d8a3a892\",\"row\":\"\",\"section\":\"\",\"nthCheckin\":9,\"photos\":[],\"eventId\":\"380601\",\"seat\":\"\",\"awayName\":\"SF\",\"official\":true,\"homeName\":\"LAD\",\"eventName\":\"2014/04/04/sfnmlb-lanmlb-1\",\"longitude\":-118.24053,\"latitude\":34.07368,\"createdDate\":\"2014-03-06T15:50:16\",\"venueName\":\"Dodger Stadium\",\"venueId\":\"22\",\"awayScore\":\"\"},{\"checkinType\":\"mlb\",\"homeScore\":\"5\",\"checkinStatusId\":0,\"venueType\":\"MLB\",\"checkinDate\":\"2014-03-28T21:09:55\",\"eventType\":\"R\",\"checkinId\":\"6b96747f-a34e-4382-b1a8-6c6c2aed08ef\",\"row\":\"\",\"section\":\"\",\"nthCheckin\":4,\"photos\":[],\"eventId\":\"395717\",\"seat\":\"\",\"awayName\":\"LAA\",\"official\":true,\"homeName\":\"LAD\",\"eventName\":\"2014/03/28/anamlb-lanmlb-1\",\"longitude\":-118.24053,\"latitude\":34.07368,\"createdDate\":\"2014-03-28T19:11:50\",\"venueName\":\"Dodger Stadium\",\"venueId\":\"22\",\"awayScore\":\"4\"},{\"checkinType\":\"mlb\",\"homeScore\":\"\",\"checkinStatusId\":0,\"venueType\":\"MLB\",\"checkinDate\":\"2014-03-05T19:34:37\",\"eventType\":\"R\",\"checkinId\":\"8bcd1386-b6d5-4fe8-ade6-ae6161433d81\",\"row\":\"\",\"section\":\"\",\"nthCheckin\":1,\"photos\":[],\"eventId\":\"380549\",\"seat\":\"\",\"awayName\":\"SEA\",\"official\":true,\"homeName\":\"LAA\",\"eventName\":\"2014/03/31/seamlb-anamlb-1\",\"longitude\":-117.882399559021,\"latitude\":33.800190441380174,\"createdDate\":\"2014-03-05T19:34:03\",\"venueName\":\"Angel Stadium\",\"venueId\":\"1\",\"awayScore\":\"\"}]}";
	private String identityPoint;

	@Test
	public void getIdentityPoint() throws UnsupportedEncodingException {
		IdentityPoint ip = new AtbHttpService().loadIdentityPointByEmail("igor.vayner@outlook.com", "123QWEasd");
		identityPoint = ip.getId();
		System.out.println(ip);
	}

	@Test(dependsOnMethods = "getIdentityPoint")
	public void loadCheckinHistory() {
		DateTime date = new DateTime(2014, 04, 04, 0, 0);
		List<CheckinHistoryItem> checkins = new AtbHttpService().loadListOfCheckinsByIdentityPoint(identityPoint, date,
				date);
		System.out.println(checkins);
	}

}
