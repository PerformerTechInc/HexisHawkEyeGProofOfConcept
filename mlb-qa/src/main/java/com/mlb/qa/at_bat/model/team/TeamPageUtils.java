package com.mlb.qa.at_bat.model.team;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Instant;

import com.mlb.qa.atb.model.game.Game;
import com.mlb.qa.common.date.DateUtils;

public class TeamPageUtils {
	private static final Logger logger = Logger.getLogger(TeamPageUtils.class);

	public final String gamePagerDateFormat = "EEE, MMM d";

	/**
	 * Brings back the 3 games that show up on the Team Page
	 * @param gameList game list to parse.
	 * @param currentDate today's date to look for.
	 * @return list of 3 games
	 */
	public List<String> getCurrentGamePagerDates(List<Game> gameList) {		
		DateTime currentDate = getCorrectScoreboardDate();

		int d = 0;
		for (int i = 0; i < gameList.size(); i++) {
			DateTime dt = DateUtils.parseString(gameList.get(i).getGameDate().toString(), DateUtils.GAME_DATE_FORMAT);
			String stringDate = DateUtils.dateToString(dt, gamePagerDateFormat);

			logger.info("Bringing Back Game Date for (" + i + "): " + stringDate);
			if (stringDate.equals(DateUtils.dateToString(currentDate, gamePagerDateFormat))) {
				d = i;
				break;
			}
		}

		List<Game> subGameList = gameList.subList(d - 1, d + 2);
		List<String> stringGameList = new LinkedList<String>();
		for (int i = 0; i < subGameList.size(); i ++) {
			DateTime dt = DateUtils.parseString(subGameList.get(i).getGameDate().toString(), DateUtils.GAME_DATE_FORMAT);

			String stringDate = DateUtils.dateToString(dt, gamePagerDateFormat);
			stringGameList.add(stringDate);

			logger.info("Checking Sublist Items: " + stringDate);
		}
		return stringGameList;
	}

	/**
	 * Checks if the time is before the 10 AM EST Scoreboard Flip
	 * @return true if it's after 10 AM EST
	 */
	public Boolean isAfterScoreboardFlip() {
		DateTime dt = new DateTime();
		DateTimeZone zoneEST = DateTimeZone.forID("EST");
		DateTime dateFlipTime = dt.withTime(10, 0, 0, 0).withZone(zoneEST);

		boolean isStandardOffset = zoneEST.isStandardOffset(Instant.now().getMillis());
		boolean isDSTOffset = !isStandardOffset;
		
		if (!isDSTOffset) {
			dateFlipTime = dateFlipTime.plusHours(1);
		}
		
		if (dt.isAfter(dateFlipTime)) {
			return true;
		}
		return false;
	}

	public DateTime getCorrectScoreboardDate() {
		if (isAfterScoreboardFlip()) {
			return new DateTime();
		} else {
			return new DateTime().minusDays(1);
		}
	}
}
