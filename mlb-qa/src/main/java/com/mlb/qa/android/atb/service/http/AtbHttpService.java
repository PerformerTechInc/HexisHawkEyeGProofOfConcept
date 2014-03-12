package com.mlb.qa.android.atb.service.http;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import com.mlb.qa.android.atb.utils.AtbParameter;
import com.mlb.qa.exception.TestRuntimeException;


public class AtbHttpService {
	private static final Logger logger = Logger.getLogger(AtbHttpService.class);

	public static final String UTF_8_CHARSET = "UTF-8";
	private static final String KEY_PARAM = "key";
	private static final String VALUE_PARAM = "value";
	private static final String PROPERTY_UPDATED_RESPONSE_REGEX = ".*%s.*property is updated to.*s.*";

	public enum AtbCheckinProperty {
		GAME_FEED("com.bamnetworks.mobile.service.social.game.GameService.gameFeedURL"), 
		ALLOW_CHKECKIN_TIME("com.bamnetworks.mobile.service.social.game.GameService.timeBoundary"),
		;
		private String propertyName;

		private AtbCheckinProperty(String propertyName) {
			this.propertyName = propertyName;
		}

		public String getPropertyName() {
			return this.propertyName;
		}
	}

	/**
	 * Set timeBoundary property of mobile-service-social
	 * @param timeInSeconds
	 */
	public void setTimeBoundaryCheckinServiceProperty(Long timeInSeconds) {
		logger.info(String.format("Set checkin timeBoundary property to %s",
				timeInSeconds));
		Map<String, String> bodyParameters = new HashMap<String, String>();
		bodyParameters.put(KEY_PARAM,
				AtbCheckinProperty.ALLOW_CHKECKIN_TIME.getPropertyName());
		bodyParameters.put(VALUE_PARAM, timeInSeconds.toString());
		HttpResult result = HttpHelper.executePostMethod(
				AtbParameter.MLB_ATB_SOCIAL_SERVICE_PROPERTY_HOST.getValue(),
				new HashMap<String, String>(), bodyParameters, UTF_8_CHARSET);
		HttpHelper.checkResult(result, HttpStatus.SC_OK, String.format(
				PROPERTY_UPDATED_RESPONSE_REGEX,
				AtbCheckinProperty.ALLOW_CHKECKIN_TIME.getPropertyName(),
				timeInSeconds.toString()));
	}

	/**
	 * Set GameFeed property of mobile-service-social (for the specified day)
	 * 
	 * @param year
	 * @param month
	 * @param day
	 */
	public void setGameFeedCheckinServiceProperty(Integer year, Integer month,
			Integer day) {
		// TODO implement!
		throw new TestRuntimeException("Not implemented yet");
	}

	/**
	 * Set GameFeed property of mobile-service-social (for the date)
	 * @param dateTime
	 */
	public void setGameFeedCheckinServiceProperty(DateTime dateTime) {
		setGameFeedCheckinServiceProperty(dateTime.getYear(),
				dateTime.getMonthOfYear(), dateTime.getDayOfMonth());
	}
}
