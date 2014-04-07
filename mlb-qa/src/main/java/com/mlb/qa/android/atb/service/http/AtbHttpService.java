package com.mlb.qa.android.atb.service.http;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import com.mlb.qa.android.atb.utils.AtbParameter;
import com.mlb.qa.exception.TestRuntimeException;

public class AtbHttpService {
	private static final Logger logger = Logger.getLogger(AtbHttpService.class);

	private static final String KEY_PARAM = "key";
	private static final String VALUE_PARAM = "value";
	private static final String PROPERTY_UPDATED_RESPONSE_REGEX = ".*%s.*property is updated to.*s.*";
	private static final String GAME_FEED_URL_PATTERN = "http://gd.qa.mlb.com/components/game/mlb/year_%4d/month_%02d/day_%02d/master_scoreboard.xml";
	private static final String GET_PROPERTY_REQUEST_PATTERN = "host_value?key=property_value";
		
	private static Pattern YEAR_PATTERN = Pattern.compile("year_[0-9]+");
	private static Pattern MONTH_PATTERN = Pattern.compile("month_[0-9]+");
	private static Pattern DAY_PATTERN = Pattern.compile("day_[0-9]+");
	
	public enum AtbCheckinProperty {
		GAME_FEED("com.bamnetworks.mobile.service.social.game.GameService.gameFeedURL"), 
		TIME_BOUNDARY("com.bamnetworks.mobile.service.social.game.GameService.timeBoundary"),
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
	 * 
	 * @param timeInMinutes
	 * @throws UnsupportedEncodingException
	 */
	public void setTimeBoundaryCheckinServiceProperty(Long timeInMinutes)
			throws UnsupportedEncodingException {
		logger.info(String.format("Set checkin timeBoundary property to %s",
				timeInMinutes));
		Map<String, String> bodyParameters = new HashMap<String, String>();
		bodyParameters.put(KEY_PARAM,
				AtbCheckinProperty.TIME_BOUNDARY.getPropertyName());
		bodyParameters.put(VALUE_PARAM, timeInMinutes.toString());
		HttpResult result = HttpHelper.executePost(
				AtbParameter.MLB_ATB_SOCIAL_SERVICE_PROPERTY_HOST.getValue(),
				bodyParameters, HttpHelper.UTF_8_CHARSET);
		logger.info("Operation result: ");
		HttpHelper.checkResult(result, HttpStatus.SC_OK, String.format(
				PROPERTY_UPDATED_RESPONSE_REGEX,
				AtbCheckinProperty.TIME_BOUNDARY.getPropertyName(),
				timeInMinutes.toString()));
	}

	/**
	 * Set GameFeed property of mobile-service-social (for the specified date)
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @throws UnsupportedEncodingException
	 */
	public void setGameFeedCheckinServiceProperty(Integer year, Integer month,
			Integer day) throws UnsupportedEncodingException {
		logger.info(String
				.format("Allow checkin for the specified date. Year: %04d, Month: %02d, Day: %02d",
						year, month, day));
		Map<String, String> bodyParameters = new HashMap<String, String>();
		bodyParameters.put(KEY_PARAM,
				AtbCheckinProperty.GAME_FEED.getPropertyName());
		String value = String.format(GAME_FEED_URL_PATTERN, year, month, day);
		bodyParameters.put(VALUE_PARAM, value);
		HttpResult result = HttpHelper.executePost(
				AtbParameter.MLB_ATB_SOCIAL_SERVICE_PROPERTY_HOST.getValue(),
				bodyParameters, HttpHelper.UTF_8_CHARSET);
		logger.info("Operation result: " + result);
		HttpHelper.checkResult(result, HttpStatus.SC_OK, String.format(
				PROPERTY_UPDATED_RESPONSE_REGEX,
				AtbCheckinProperty.GAME_FEED.getPropertyName(), value));
	}

	/**
	 * Set GameFeed property of mobile-service-social (for the date)
	 * 
	 * @param dateTime
	 * @throws UnsupportedEncodingException
	 */
	public void setGameFeedCheckinServiceProperty(DateTime dateTime)
			throws UnsupportedEncodingException {
		setGameFeedCheckinServiceProperty(dateTime.getYear(),
				dateTime.getMonthOfYear(), dateTime.getDayOfMonth());
	}
	
	/**
	 * Load check-in window date from gameFeeedUrl property<br>
	 * 
	 * @return
	 */
	public DateTime getCheckinDate() {
		logger.info("Load checkin window date from gameFeeedUrl property");
		HttpResult result = HttpHelper.executeGet(
				GET_PROPERTY_REQUEST_PATTERN.replace("host_value", AtbParameter.MLB_ATB_SOCIAL_SERVICE_PROPERTY_HOST
						.getValue()).replace("property_value", AtbCheckinProperty.GAME_FEED.getPropertyName()),
				HttpHelper.UTF_8_CHARSET);
		HttpHelper.checkResultOk(result);
		return new DateTime(getValueByPattern(result.getResponseBody(), YEAR_PATTERN), getValueByPattern(result.getResponseBody(), MONTH_PATTERN),
				getValueByPattern(result.getResponseBody(), DAY_PATTERN), 0, 0);
	}
	
	 private int getValueByPattern(String str, Pattern pattern) {
	        Matcher matcher = pattern.matcher(str);
	        if (matcher.find()) {
	            return Integer.parseInt((matcher.group()).split("_")[1]);
	        }
	        throw new TestRuntimeException("Substring not found");
	    }
}
