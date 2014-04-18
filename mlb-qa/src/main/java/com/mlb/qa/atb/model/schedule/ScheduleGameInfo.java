package com.mlb.qa.atb.model.schedule;

import org.joda.time.DateTime;

import com.mlb.qa.atb.model.Item;

public class ScheduleGameInfo implements Item {

	private DateTime date;
	private String score;
	private String result;
	private String opponent;
	private Boolean isHome;
	private Boolean isScheduled;

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getOpponent() {
		return opponent;
	}

	public void setOpponent(String opponent) {
		this.opponent = opponent;
	}

	public Boolean getIsHome() {
		return isHome;
	}

	public void setIsHome(Boolean isHome) {
		this.isHome = isHome;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Boolean getIsScheduled() {
		return isScheduled;
	}

	public void setIsScheduled(Boolean isScheduled) {
		this.isScheduled = isScheduled;
	}

	@Override
	public String toString() {
		return "ScheduledGameInfo [date=" + date
				+ ", score=" + score + ", result=" + result + ", opponent=" + opponent + ", isHome=" + isHome
				+ ", isScheduled=" + isScheduled + "]";
	}

}
