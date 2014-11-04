package com.mlb.qa.tests.acctmgmt.web;

import java.io.UnsupportedEncodingException;
import org.testng.annotations.Test;
import com.mlb.qa.acctmgmt.service.http.*;
import com.qaprosoft.carina.core.foundation.UITest;

public class AcctMgmtPOC001 extends UITest {

	@Test
	public void accountManagementTest000TestFunction() throws UnsupportedEncodingException	{
		AcctMgmtHttpServiceTest001 serviceCall = new AcctMgmtHttpServiceTest001();
		serviceCall.setIdentityPointServiceCreate();
		return;
	}	
}
