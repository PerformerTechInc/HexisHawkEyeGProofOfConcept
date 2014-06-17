package com.mlb.qa.tests.atb.android;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mlb.qa.atb.AtbParameter;
import com.mlb.qa.atb.service.authorization.AuthorizationService;
import com.qaprosoft.carina.core.foundation.UITest;

public class AtbBallparkLogin extends UITest {
    @Test()
    @Parameters()	
    public void login(){
        AuthorizationService authorizationService = new AuthorizationService(getDriver());
    	authorizationService.reloginUser(AtbParameter.MLB_ATB_DEFAULT_USER.getValue(),AtbParameter.MLB_ATB_DEFAULT_PASSWORD.getValue());
    }
}
