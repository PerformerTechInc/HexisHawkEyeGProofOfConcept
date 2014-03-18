package com.mlb.qa.android.atb.utils;

import com.qaprosoft.carina.core.foundation.utils.R;

public enum AtbParameter {
	MLB_ATB_LOOKUP_SERVICE("mlb_atb_lookup_service"),
	MLB_ATB_SOCIAL_SERVICE_PROPERTY_HOST("mlb_atb_social_service"),
	MLB_ATB_DEFAULT_USER("mlb_atb_default_user"),
	MLB_ATB_DEFAULT_PASSWORD("mlb_atb_default_password"),
	MLB_ATB_SEASON("mlb_atb_season"),
	;
	
	private String key;
	
	private AtbParameter(String key){
		this.key = key;
	}
	
	public String getKey(){
		return this.key;
	}
	
	public String getValue(){
		return R.TESTDATA.get(this.key);
	}
}
