package com.mlb.qa.acctmgmt.service.http;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import com.mlb.qa.common.http.HttpHelper;
import com.mlb.qa.common.http.HttpResult;
import org.junit.Assert;

public class AcctMgmtHttpServiceTest001 {
	private static final Logger logger = Logger.getLogger(AcctMgmtHttpServiceTest001.class); 

	public HttpResult postSoapRequest(String endpointURL, String soapAction, String soapEnvelope) throws UnsupportedEncodingException {
		Map<String, String> postHeaders = new HashMap<String, String>();
		postHeaders.put("SOAPAction", soapAction);
		postHeaders.put("Content-Type","text/xml; charset=utf-8");
		HttpResult soapResponse = HttpHelper.executePost(endpointURL, postHeaders, soapEnvelope);
		logger.info("SOAP Request: " + soapEnvelope);
		logger.info("SOAP Response: " + soapResponse);
		return(soapResponse);
	}

	public void soapResponseValidator (String soapResponseString) {
		int httpResponseCodeIndex = soapResponseString.indexOf("responseCode=");
		String httpResponseCode = soapResponseString.substring((httpResponseCodeIndex + 13), (httpResponseCodeIndex + 16));
		logger.info("HTTP Response Code: " + httpResponseCode);

		if (httpResponseCode.equals("200")) {
			int soapResponseCodeIndexLeftBoundary = soapResponseString.indexOf("<code>");
			int soapResponseCodeIndexRightBoundary = soapResponseString.indexOf("</code>");
			int soapResponseMessageIndexLeftBoundary = soapResponseString.indexOf("<message>");
			int soapResponseMessageIndexRightBoundary = soapResponseString.indexOf("</message>");
			String soapResponseCode = soapResponseString.substring((soapResponseCodeIndexLeftBoundary + 6), (soapResponseCodeIndexRightBoundary));
			String soapResponseMessage = soapResponseString.substring((soapResponseMessageIndexLeftBoundary + 9), (soapResponseMessageIndexRightBoundary));
			logger.info("SOAP Response Code: " + soapResponseCode);
			logger.info("SOAP Response Message: " + soapResponseMessage);
			if (!(soapResponseCode.equals("1"))) {
				logger.info("ERROR: HTTP " + httpResponseCode + " / " + "SOAP Response Code: " + soapResponseCode + " / SOAP Response Message: " + soapResponseMessage);
				Assert.fail("\nERROR: \n\nHTTP " + httpResponseCode + "\n\nSOAP Response Code: " + soapResponseCode + "\n\nSOAP Response Message: " + soapResponseMessage + "\n\nFULL SOAP Response: " + soapResponseString);
			}
		}

		if ((httpResponseCode.equals("500"))) {
			int soapResponseFaultCodeIndexLeftBoundary = soapResponseString.indexOf("<faultcode>");
			int soapResponseFaultCodeIndexRightBoundary = soapResponseString.indexOf("</faultcode>");
			int soapResponseFaultStringIndexLeftBoundary = soapResponseString.indexOf("<faultstring>");
			int soapResponseFaultStringIndexRightBoundary = soapResponseString.indexOf("</faultstring>");
			String soapResponseFaultCode = soapResponseString.substring((soapResponseFaultCodeIndexLeftBoundary + 11), (soapResponseFaultCodeIndexRightBoundary));
			String soapResponseFaultString = soapResponseString.substring((soapResponseFaultStringIndexLeftBoundary + 13), (soapResponseFaultStringIndexRightBoundary));
			logger.info("SOAP Response Fault Code: " + soapResponseFaultCode);
			logger.info("SOAP Response Fault String: " + soapResponseFaultString);
			logger.info("ERROR: HTTP " + httpResponseCode + " / " + "SOAP Response Fault Code: " + soapResponseFaultCode + " / SOAP Response Fault String: " + soapResponseFaultString);
			Assert.fail("\nERROR: \n\nHTTP " + httpResponseCode + "\n\nSOAP Response Fault Code: " + soapResponseFaultCode + "\n\nSOAP Response Fault String: " + soapResponseFaultString + "\n\nFULL SOAP Response: " + soapResponseString);
		}
	}
	
	public String soapTagValidator(String soapResponseString, String soapTagToValidate, String soapTagToValidateValue) throws UnsupportedEncodingException {
		int httpResponseCodeIndex = soapResponseString.indexOf("responseCode=");
		String httpResponseCode = soapResponseString.substring((httpResponseCodeIndex + 13), (httpResponseCodeIndex + 16));
		logger.info("HTTP Response Code: " + httpResponseCode);

		int soapTagToValidateIndex = soapTagToValidate.length();
		int soapResponseTagToValidateIndexLeftBoundary = soapResponseString.indexOf("<" + soapTagToValidate + ">");
		int soapResponseTagToValidateIndexRightBoundary = soapResponseString.indexOf("</" + soapTagToValidate + ">");
		String soapResponseTagToValidate = soapResponseString.substring((soapResponseTagToValidateIndexLeftBoundary + soapTagToValidateIndex + 2), (soapResponseTagToValidateIndexRightBoundary));
		logger.info("SOAP Response For " + soapTagToValidate + ": " + soapResponseTagToValidate);

		if (!(soapTagToValidateValue.equals("~"))) {
			if (!(soapResponseTagToValidate.equals(soapTagToValidateValue))) {
				logger.info("ERROR: HTTP " + httpResponseCode + " / " + "SOAP Response Code: " + soapResponseTagToValidate + " / SOAP Response For " + soapTagToValidate + ": " + soapResponseTagToValidate);
				Assert.fail("\nERROR: \n\nHTTP " + httpResponseCode + "\n\nSOAP Response Code: " + soapResponseTagToValidate + "\n\nExpected SOAP Response For " + soapTagToValidate + ": " + soapTagToValidateValue+ "\n\nActual   SOAP Response For " + soapTagToValidate + ": " + soapResponseTagToValidate);
			}
		}
		return (soapResponseTagToValidate);
	}

	public HttpResult setIdentityPointServiceCreate(String IdentityPointServiceCreateEndpointURL, String IdentityPointServiceCreateSoapAction, String IdentityPointServiceCreateSoapEnvelopePart1, String IdentityPointServiceCreateSoapEnvelopePart2, String IdentityPointServiceCreateSoapEnvelopePart3, String IdentityPointServiceCreateNewUserEmail, String IdentityPointServiceCreateNewUserPassword) throws UnsupportedEncodingException {
		String IdentityPointServiceCreateSoapEnvelope = (IdentityPointServiceCreateSoapEnvelopePart1 + IdentityPointServiceCreateNewUserEmail + IdentityPointServiceCreateSoapEnvelopePart2 + IdentityPointServiceCreateNewUserPassword + IdentityPointServiceCreateSoapEnvelopePart3); 
		HttpResult identityPointServiceCreateSoapResponse = (postSoapRequest(IdentityPointServiceCreateEndpointURL, IdentityPointServiceCreateSoapAction, IdentityPointServiceCreateSoapEnvelope));
		return(identityPointServiceCreateSoapResponse);
	}

	public HttpResult setIdentityPointServiceCreateRESTmaiCookie(String IdentityPointServiceCreateRESTmaiCookieEndpointURL, String IdentityPointServiceCreateRESTmaiCookieSoapAction, String IdentityPointServiceCreateRESTmaiCookieSoapEnvelope, String IdentityPointServiceCreateRESTmaiCookieNewUserEmail, String IdentityPointServiceCreateRESTmaiCookieNewUserPassword) throws UnsupportedEncodingException {
		HttpResult identityPointServiceCreateRESTmaiCookieSoapResponse = (postSoapRequest(IdentityPointServiceCreateRESTmaiCookieEndpointURL, IdentityPointServiceCreateRESTmaiCookieSoapAction, IdentityPointServiceCreateRESTmaiCookieSoapEnvelope));
		return(identityPointServiceCreateRESTmaiCookieSoapResponse);
	}

	public HttpResult setIdentityPointServiceIdentify(String IdentityPointServiceIdentifyEndpointURL, String IdentityPointServiceIdentifySoapAction, String IdentityPointServiceIdentifySoapEnvelope, String IdentityPointServiceIdentifyNewUserEmail, String IdentityPointServiceIdentifyNewUserPassword) throws UnsupportedEncodingException {
		HttpResult identityPointServiceIdentifySoapResponse = (postSoapRequest(IdentityPointServiceIdentifyEndpointURL, IdentityPointServiceIdentifySoapAction, IdentityPointServiceIdentifySoapEnvelope));
		return(identityPointServiceIdentifySoapResponse);
	}

	public HttpResult setIdentityPointServiceIdentifyWithSSO(String IdentityPointServiceIdentifyWithSSOEndpointURL, String IdentityPointServiceIdentifyWithSSOSoapAction, String IdentityPointServiceIdentifyWithSSOSoapEnvelope, String IdentityPointServiceIdentifyWithSSONewUserEmail, String IdentityPointServiceIdentifyWithSSONewUserPassword) throws UnsupportedEncodingException {
		HttpResult identityPointServiceIdentifyWithSSOSoapResponse = (postSoapRequest(IdentityPointServiceIdentifyWithSSOEndpointURL, IdentityPointServiceIdentifyWithSSOSoapAction, IdentityPointServiceIdentifyWithSSOSoapEnvelope));
		return(identityPointServiceIdentifyWithSSOSoapResponse);
	}

	public HttpResult setIdentityPointServiceFindIdentityPointKeys(String IdentityPointServiceFindIdentityPointKeysEndpointURL, String IdentityPointServiceFindIdentityPointKeysSoapAction, String IdentityPointServiceFindIdentityPointKeysSoapEnvelope, String IdentityPointServiceFindIdentityPointKeysUserEmail, String IdentityPointServiceFindIdentityPointKeysUserPassword) throws UnsupportedEncodingException {
		HttpResult identityPointServiceFindIdentityPointKeysSoapResponse = (postSoapRequest(IdentityPointServiceFindIdentityPointKeysEndpointURL, IdentityPointServiceFindIdentityPointKeysSoapAction, IdentityPointServiceFindIdentityPointKeysSoapEnvelope));
		return(identityPointServiceFindIdentityPointKeysSoapResponse);
	}

	public HttpResult setIdentityPointServiceLink(String IdentityPointServiceLinkEndpointURL, String IdentityPointServiceLinkSoapAction, String IdentityPointServiceLinkSoapEnvelope, String IdentityPointServiceLinkAccountToLinkToUserEmail, String IdentityPointServiceLinkAccountToLinkToUserPassword, String IdentityPointServiceLinkAccountToBeLinkedID, String IdentityPointServiceLinkAccountToBeLinkedFingerprint) throws UnsupportedEncodingException {
		HttpResult identityPointServiceLinkSoapResponse = (postSoapRequest(IdentityPointServiceLinkEndpointURL, IdentityPointServiceLinkSoapAction, IdentityPointServiceLinkSoapEnvelope));
		return(identityPointServiceLinkSoapResponse);
	}

	public HttpResult setIdentityPointServiceUnlink(String IdentityPointServiceUnlinkEndpointURL, String IdentityPointServiceUnlinkSoapAction, String IdentityPointServiceUnlinkSoapEnvelope, String IdentityPointServiceUnlinkID, String IdentityPointServiceUnlinkFingerprint) throws UnsupportedEncodingException {
		HttpResult identityPointServiceUnlinkSoapResponse = (postSoapRequest(IdentityPointServiceUnlinkEndpointURL, IdentityPointServiceUnlinkSoapAction, IdentityPointServiceUnlinkSoapEnvelope));
		return(identityPointServiceUnlinkSoapResponse);
	}

}
