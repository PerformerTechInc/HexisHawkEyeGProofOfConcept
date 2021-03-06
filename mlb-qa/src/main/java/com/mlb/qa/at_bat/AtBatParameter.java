package com.mlb.qa.at_bat;

import com.qaprosoft.carina.core.foundation.utils.R;

public enum AtBatParameter {
	MLB_ATBAT_ROSTER_LOOKUP("mlb_atbat_roster_lookup"),
	MLB_ATBAT_PLAYER_CARD("mlb_atbat_player_card"),
	MLB_ATBAT_PLAYER_MUGSHOT("mlb_atbat_player_mugshot"),
	MLB_ATBAT_ANDROID_STANDINGS("mlb_atbat_android_standings"),
	MLB_ATBAT_SEASON("mlb_atbat_season"),
	MLB_ATBAT_MASTER_SCOREBOARD("mlb_atbat_master_scoreboard");

	private String key;

	private AtBatParameter(String key){
		this.key = key;
	}

	public String getKey(){
		return this.key;
	}

	public String getValue(){
		return R.TESTDATA.get(this.key);
	}
}
