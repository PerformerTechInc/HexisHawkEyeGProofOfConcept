package com.mlb.qa.atb.model.schedule;

import com.mlb.qa.atb.model.Game;
import com.mlb.qa.common.date.DateUtils;
import com.mlb.qa.common.exception.TestRuntimeException;

public class ScheduleUtils {
	/**
	 * Parse schedule info from {@link Game} instance
	 * 
	 * @param game
	 * @param teamId
	 * @return
	 */
	public static ScheduleGameInfo parseGameScheduleInfo(Game game, String teamId) {
		ScheduleGameInfo info = new ScheduleGameInfo();
		if (teamId == null || game == null) {
			throw new TestRuntimeException("team id, game should be null");
		}
		boolean isScheduled = Game.GAME_STATUS_SCHEDULED.equalsIgnoreCase(game.getGameStatus());
		if (teamId.equals(game.getHomeTeamId())) {
			info.setIsHome(true);
			info.setOpponent(game.getAwayTeamBrief());
			info.setResult(game.getHomeResult());
		}
		else if (teamId.equals(game.getAwayTeamId())) {
			info.setIsHome(false);
			info.setOpponent(game.getHomeTeamBrief());
			info.setResult(game.getAwayResult());
		}
		else {
			throw new TestRuntimeException(
					String.format(
							"Wrong team id specified: %s. To build schedule info, teamId shuld be equal to away(%s) or home(%s) team id",
							teamId, game.getAwayTeamId(), game.getHomeTeamId()));
		}
		info.setIsScheduled(isScheduled);
		info.setDate(DateUtils.parseString(game.getGameTimeLocal(),
				Game.GAME_TIME_LOCAL_FORMAT_PATTERN));
		if (!isScheduled && game.getHomeTeamScore() != null && game.getAwayTeamScore() != null
				&& !game.getHomeTeamScore().isEmpty()
				&& !game.getAwayTeamScore().isEmpty()) {
			Integer homeInt = Integer.parseInt(game.getHomeTeamScore());
			Integer awayInt = Integer.parseInt(game.getAwayTeamScore());
			String score = String.format("%d-%d", Math.max(homeInt, awayInt), Math.min(homeInt, awayInt));
			info.setScore(score);
		}
		else {
			info.setScore("");
		}
		return info;
	}
}
