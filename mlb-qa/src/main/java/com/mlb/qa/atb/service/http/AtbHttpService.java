package com.mlb.qa.atb.service.http;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.mlb.qa.atb.AtbParameter;
import com.mlb.qa.atb.model.about.BallparkInformation;
import com.mlb.qa.atb.model.checkin_history.CheckinHistoryJsonItem;
import com.mlb.qa.atb.model.checkin_history.CheckinHistoryJson;
import com.mlb.qa.atb.model.game_promotion.GamePromotion;
import com.mlb.qa.atb.model.game_promotion.QueryGamePromotionsRS;
import com.mlb.qa.atb.model.game_ticket.GameTicket;
import com.mlb.qa.atb.model.game_ticket.QueryGameTicketsRS;
import com.mlb.qa.atb.model.identity_point.IdentityPoint;
import com.mlb.qa.atb.model.identity_point.IdentityPointIdentifyRS;
import com.mlb.qa.common.date.DateUtils;
import com.mlb.qa.common.exception.TestRuntimeException;
import com.mlb.qa.common.http.HttpHelper;
import com.mlb.qa.common.http.HttpResult;

public class AtbHttpService {
	private static final Logger logger = Logger.getLogger(AtbHttpService.class);
	// parameters
	private static final String KEY_PARAM = "key";
	private static final String VALUE_PARAM = "value";
	private static final String PROPERTY_UPDATED_RESPONSE_REGEX = ".*%s.*property is updated to.*s.*";
	private static final String GAME_FEED_URL_PATTERN = "http://gd.qa.mlb.com/components/game/mlb/year_%4d/month_%02d/day_%02d/master_scoreboard.xml";
	private static final String GET_PROPERTY_REQUEST_PATTERN = "host_value?key=property_value";
	private static final String GET_CHECKINS_FOR_DATE_PATTERN = "host_value?identityPoint=identity_point_value&fingerprint=ssss&checkinType=mlb&eventType=&official=1&startDate=start_date_value&endDate=end_date_value&contentType=application%2Fjson&apikey=tXVNdasBjK1Rr2S83DO5S0X3tZc%3D";
	private static final String PROPERTY_PATH = "/property";
	private static final String CHECKINS_PATH = "/checkins";
	// IdentityPointService
	private static final String SOAP_ACTION_IDENTITY_POINT_IDENTIFY = "http://services.bamnetworks.com/registration/identityPoint/identify";
	// GameTickets
	private static final String GET_GAME_TICKETS_PATH_PATTERN = "?team_id=home_team_id_value&home_team_id=home_team_id_value&venue_id=venue_id_value&site_section=MOBILE&ticket_category=TICKETS&begin_date=date_value";
	// GamePromotions
	private static final String GET_GAME_PROMOTIONS_PATH_PATTERN = "?display_in=ATBAT&sport_id=1&site_section=MOBILE&mobile=true&leave_empty_games=false&team_id=home_team_id_value&home_team_id=home_team_id_value&year=year_value&begin_date=begin_date_value&end_date=end_date_value";
	// date formats
	public static final String INPUT_DATE_FORMAT = "yyyyMMdd";
	/**
	 * TODO: replace this hardcode with IdentityPointIdentifyRequest with
	 * possibility to marshal/unmarshal with JAXB. See
	 * {@link IdentityPointIdentifyRS} as example
	 */
	private static final String LOAD_IDENTITY_POINT_BODY_XML_PATTERN = "<?xml version='1.0' encoding='UTF-8'?><SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><SOAP-ENV:Body><tns:identityPoint_identify_request xmlns:tns=\"http://services.bamnetworks.com/registration/types/1.5\"><tns:identification type=\"email-password\"><tns:id xsi:nil=\"true\"/><tns:fingerprint xsi:nil=\"true\"/><tns:email><tns:id xsi:nil=\"true\"/><tns:address>%s</tns:address></tns:email><tns:password>%s</tns:password><tns:mobilePhone xsi:nil=\"true\"/><tns:profileProperty xsi:nil=\"true\"/></tns:identification></tns:identityPoint_identify_request></SOAP-ENV:Body></SOAP-ENV:Envelope>";

	private static Pattern YEAR_PATTERN = Pattern.compile("year_[0-9]+");
	private static Pattern MONTH_PATTERN = Pattern.compile("month_[0-9]+");
	private static Pattern DAY_PATTERN = Pattern.compile("day_[0-9]+");

	public enum AtbCheckinProperty {
		GAME_FEED("com.bamnetworks.mobile.service.social.game.GameService.gameFeedURL"),
		TIME_BOUNDARY("com.bamnetworks.mobile.service.social.game.GameService.timeBoundary"), ;

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
				AtbParameter.MLB_ATB_SOCIAL_SERVICE_PROPERTY_HOST.getValue() + PROPERTY_PATH,
				bodyParameters, new HashMap<String, String>(), HttpHelper.UTF_8_CHARSET);
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
				AtbParameter.MLB_ATB_SOCIAL_SERVICE_PROPERTY_HOST.getValue() + PROPERTY_PATH,
				bodyParameters, new HashMap<String, String>(), HttpHelper.UTF_8_CHARSET);
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
						.getValue() + PROPERTY_PATH).replace("property_value",
						AtbCheckinProperty.GAME_FEED.getPropertyName()),
				new HashMap<String, String>());
		HttpHelper.checkResultOk(result);
		return new DateTime(getValueByPattern(result.getResponseBody(), YEAR_PATTERN), getValueByPattern(
				result.getResponseBody(), MONTH_PATTERN),
				getValueByPattern(result.getResponseBody(), DAY_PATTERN), 0, 0);
	}

	/**
	 * Get IdentityPoint from back-end (IdentityPointService) by account's
	 * email/password
	 * 
	 * @param email
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public IdentityPoint loadIdentityPointByEmail(String email, String password) throws UnsupportedEncodingException {
		logger.info(String.format("Load IdentityPoint from IdentityPointService for account: %s/%s", email, password));
		Map<String, String> headers = new HashMap<String, String>();
		headers.put(HttpHelper.HEADER_CONTENT_TYPE, HttpHelper.CONTENT_TYPE_XML_UTF_8);
		headers.put(HttpHelper.HEADER_SOAP_ACTION, SOAP_ACTION_IDENTITY_POINT_IDENTIFY);
		// execute, check result and return IP if found
		HttpResult result = HttpHelper.executePost(AtbParameter.MLB_ATB_IDENTITY_POINT_SERVICE.getValue(), headers,
				String.format(LOAD_IDENTITY_POINT_BODY_XML_PATTERN, email, password));
		logger.info(String.format("HTTP Response: %s", result));
		HttpHelper.checkResultOk(result);
		// unmarshal result
		IdentityPointIdentifyRS response = IdentityPointIdentifyRS.unmarshal(result.getResponseBody());
		if (response.getStatus() == null || !"ok".equalsIgnoreCase(response.getStatus().getMessage())) {
			throw new TestRuntimeException(String.format("Wrong response from IdentityPointService: %s",
					response.getStatus()));
		}
		return response.getIdentityPoint();
	}

	/**
	 * Load list of checkins by specified identity point
	 * 
	 * @param identityPoint
	 * @return
	 */
	public List<CheckinHistoryJsonItem> loadListOfCheckinsByIdentityPoint(String identityPoint, DateTime startDate,
			DateTime endDate) {
		logger.info(String.format("Load list of checkins by identity point: %s. Start date: %s, end date: %s",
				identityPoint, startDate, endDate));
		String rq = GET_CHECKINS_FOR_DATE_PATTERN
				.replace("host_value", AtbParameter.MLB_ATB_SOCIAL_SERVICE_PROPERTY_HOST.getValue() + CHECKINS_PATH)
				.replace("identity_point_value", identityPoint)
				.replace("start_date_value", DateUtils.dateToString(startDate, INPUT_DATE_FORMAT))
				.replace("end_date_value", DateUtils.dateToString(endDate, INPUT_DATE_FORMAT));
		HttpResult result = HttpHelper.executeGet(rq, new HashMap<String, String>());
		logger.debug(result);
		HttpHelper.checkResultOk(result);
		CheckinHistoryJson response = CheckinHistoryJson.unmarshal(result.getResponseBody());
		logger.info(String.format("Response: %s", response));
		return response.getCheckins();
	}

	/**
	 * Load list of events from GameTicket service
	 * 
	 * @param homeTeamId
	 * @param venueId
	 * @param beginDate
	 * @return
	 */
	public List<GameTicket> loadListOfTicketsFromGameTicketService(String homeTeamId, String venueId, DateTime beginDate) {
		logger.info(String.format("Load list of tickets by home team id: %s, venue id: %s, begin date: %s", homeTeamId,
				venueId, beginDate));
		String getQueryRequest = AtbParameter.MLB_ATB_GAME_TICKETS_SERVICE.getValue()
				+ GET_GAME_TICKETS_PATH_PATTERN.replaceAll("home_team_id_value", homeTeamId)
						.replaceAll("venue_id_value", venueId)
						.replaceAll("date_value", DateUtils.dateToString(beginDate,
								DateUtils.LOOKUP_INPUT_DATE_FORMAT));
		logger.info(String.format("Request: %s", getQueryRequest));
		HttpResult result = HttpHelper.executeGet(getQueryRequest, new HashMap<String, String>());
		HttpHelper.checkResultOk(result);
		List<GameTicket> gameTickets = QueryGameTicketsRS.unmarshal(result.getResponseBody()).getGameTickets();
		logger.info("Found game tickets: " + gameTickets);
		return gameTickets;
	}

	/**
	 * Load list of events from GamePromotion service
	 * 
	 * @param homeTeamId
	 * @param year
	 * @param month
	 * @return
	 */
	public List<GamePromotion> loadListOfPromotionsFromGamePromotionsService(String homeTeamId, Integer year,
			Integer month) {
		logger.info(String.format("Load list of promotions by home team id: %s, year: %s, month: %s", homeTeamId,
				year, month));
		DateTime beginDate = new DateTime(year, month, 1, 0, 0);
		DateTime endDate = beginDate.plusMonths(1).minusDays(1);
		String getQueryRequest = AtbParameter.MLB_ATB_GAME_PROMOTIONS_SERVICE.getValue()
				+ GET_GAME_PROMOTIONS_PATH_PATTERN.replaceAll("home_team_id_value", homeTeamId)
						.replaceAll("year_value", year.toString())
						.replaceAll("begin_date_value", DateUtils.dateToString(beginDate,
								DateUtils.LOOKUP_INPUT_DATE_FORMAT))
						.replaceAll("end_date_value", DateUtils.dateToString(endDate,
								DateUtils.LOOKUP_INPUT_DATE_FORMAT));
		logger.info(String.format("Request: %s", getQueryRequest));
		HttpResult result = HttpHelper.executeGet(getQueryRequest, new HashMap<String, String>());
		// logger.info(String.format("Result: %s", result));
		HttpHelper.checkResultOk(result);
		List<GamePromotion> gamePromotions = QueryGamePromotionsRS.unmarshal(result.getResponseBody())
				.getGamePromotions();
		logger.info("Found game promotions: " + gamePromotions);
		return gamePromotions;
	}

	public BallparkInformation getBallparkInformation(String url) throws JAXBException, ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		logger.info("Load checkin window date from gameFeeedUrl property");
		HttpResult result = HttpHelper.executeGet(url, new HashMap<String, String>());
		HttpHelper.checkResultOk(result);
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new InputSource
				(new ByteArrayInputStream(result.getResponseBody().getBytes("utf-8"))));		
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xpath = xPathfactory.newXPath();
		XPathExpression expression = xpath.compile("section/pages/page[@id='information']/body/text()");
		
		BallparkInformation ballparkInformation = new BallparkInformation();
		ballparkInformation.setBallparkTextDescription(expression.evaluate(document, XPathConstants.STRING).toString().
				split("p\\>")[1].split("\\<")[0]);	
		
//		logger.info(ballparkInformation);
		System.out.println(ballparkInformation.getBallparkTextDescription());
		
		return ballparkInformation;
	}

	private int getValueByPattern(String str, Pattern pattern) {
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			return Integer.parseInt((matcher.group()).split("_")[1]);
		}
		throw new TestRuntimeException("Substring not found");
	}
}
