package com.mlb.qa.at_bat.model.standings;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.mlb.qa.atb.AtbParameter;
import com.mlb.qa.atb.service.lookup.AtbLookupService;
import com.mlb.qa.common.http.HttpHelper;
import com.mlb.qa.common.http.HttpResult;

public class StandingsLookup extends AtbLookupService {
	public static final String STANDINGS_QUERY = "named.standings_schedule_date.bam?season=2014&league_id=103&league_id=104&sit_code='h0'&schedule_game_date.game_date='2014/06/04'&all_star_sw='N'";

	private static final Logger logger = Logger
			.getLogger(StandingsLookup.class);
	
	public void lookupStandings() {
		logger.info("Attempting to Load the Standings List");
		String getQueryRequest = AtbParameter.MLB_ATB_LOOKUP_SERVICE.getValue()
				+ STANDINGS_QUERY;
		logger.info(String.format("Request: %s", getQueryRequest));
		HttpResult result = HttpHelper.executeGet(getQueryRequest, new HashMap<String, String>());
		HttpHelper.checkResultOk(result);
		
	}
	
	public Boolean isClinchedFound() {
		String getQueryRequest = AtbParameter.MLB_ATB_LOOKUP_SERVICE.getValue()
				+ STANDINGS_QUERY;
		logger.info(String.format("Request: %s", getQueryRequest));
		HttpResult result = HttpHelper.executeGet(getQueryRequest, new HashMap<String, String>());
		HttpHelper.checkResultOk(result);
		
		List<Standings> listStandings = QueryStandingsRS.unmarshal(result.getResponseBody());
		
		for (int i = 0; i < listStandings.size(); i++) {
			if (listStandings.get(i).getClinchedSW() != null) {
					if (listStandings.get(i).getClinchedSW().contains("Y")) {
						return true;
					}
				} 
		}
		return false;
	}
}
