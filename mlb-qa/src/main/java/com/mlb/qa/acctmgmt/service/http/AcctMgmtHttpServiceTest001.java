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

	public String postSoapRequest(String endpointURL, String soapAction, String soapEnvelope) throws UnsupportedEncodingException {
		Map<String, String> postHeaders = new HashMap<String, String>();
		postHeaders.put("SOAPAction", soapAction);
		postHeaders.put("Content-Type","text/xml; charset=utf-8");
		String soapResponse = (HttpHelper.executePost(endpointURL, postHeaders, soapEnvelope)).toString();
		logger.info("SOAP Request: " + soapEnvelope);
		logger.info("SOAP Response: " + soapResponse);
		return(soapResponse);
	}

	public void soapResponseValidator (String[] soapResponseString) {
		int httpResponseCodeIndex = soapResponseString[1].indexOf("responseCode=");
		String httpResponseCode = soapResponseString[1].substring((httpResponseCodeIndex + 13), (httpResponseCodeIndex + 16));
		logger.info("HTTP Response Code: " + httpResponseCode);

		if (httpResponseCode.equals("200")) {
			int soapResponseCodeIndexLeftBoundary = soapResponseString[1].indexOf("<code>");
			int soapResponseCodeIndexRightBoundary = soapResponseString[1].indexOf("</code>");
			int soapResponseMessageIndexLeftBoundary = soapResponseString[1].indexOf("<message>");
			int soapResponseMessageIndexRightBoundary = soapResponseString[1].indexOf("</message>");
			String soapResponseCode = soapResponseString[1].substring((soapResponseCodeIndexLeftBoundary + 6), (soapResponseCodeIndexRightBoundary));
			String soapResponseMessage = soapResponseString[1].substring((soapResponseMessageIndexLeftBoundary + 9), (soapResponseMessageIndexRightBoundary));
			logger.info("SOAP Response Code: " + soapResponseCode);
			logger.info("SOAP Response Message: " + soapResponseMessage);
			if (!(soapResponseCode.equals("1"))) {
				logger.info("ERROR: HTTP " + httpResponseCode + " / " + "SOAP Response Code: " + soapResponseCode + " / SOAP Response Message: " + soapResponseMessage);
				Assert.fail("\nERROR: \n\nHTTP " + httpResponseCode + "\n\nSOAP Response Code: " + soapResponseCode + "\n\nSOAP Response Message: " + soapResponseMessage + "\n\nFULL SOAP Request Envelope: " + soapResponseString[0] + "\n\nFULL SOAP Response: " + soapResponseString[1]);
			}
		}

		if ((httpResponseCode.equals("500"))) {
			int soapResponseFaultCodeIndexLeftBoundary = soapResponseString[1].indexOf("<faultcode>");
			int soapResponseFaultCodeIndexRightBoundary = soapResponseString[1].indexOf("</faultcode>");
			int soapResponseFaultStringIndexLeftBoundary = soapResponseString[1].indexOf("<faultstring>");
			int soapResponseFaultStringIndexRightBoundary = soapResponseString[1].indexOf("</faultstring>");
			String soapResponseFaultCode = soapResponseString[1].substring((soapResponseFaultCodeIndexLeftBoundary + 11), (soapResponseFaultCodeIndexRightBoundary));
			String soapResponseFaultString = soapResponseString[1].substring((soapResponseFaultStringIndexLeftBoundary + 13), (soapResponseFaultStringIndexRightBoundary));
			logger.info("SOAP Response Fault Code: " + soapResponseFaultCode);
			logger.info("SOAP Response Fault String: " + soapResponseFaultString);
			logger.info("ERROR: HTTP " + httpResponseCode + " / " + "SOAP Response Fault Code: " + soapResponseFaultCode + " / SOAP Response Fault String: " + soapResponseFaultString);
			Assert.fail("\nERROR: \n\nHTTP " + httpResponseCode + "\n\nSOAP Response Fault Code: " + soapResponseFaultCode + "\n\nSOAP Response Fault String: " + soapResponseFaultString + "\n\nFULL SOAP Request Envelope: " + soapResponseString[0] + "\n\nFULL SOAP Response: " + soapResponseString[1]);
		}
	}
	
	public String soapTagValidator(String[] soapResponseString, String soapTagToValidate, String soapTagToValidateValue) throws UnsupportedEncodingException {
		int httpResponseCodeIndex = soapResponseString[1].indexOf("responseCode=");
		String httpResponseCode = soapResponseString[1].substring((httpResponseCodeIndex + 13), (httpResponseCodeIndex + 16));
		logger.info("HTTP Response Code: " + httpResponseCode);

		int soapTagToValidateIndex = soapTagToValidate.length();
		int soapResponseTagToValidateIndexLeftBoundary = soapResponseString[1].indexOf("<" + soapTagToValidate + ">");
		int soapResponseTagToValidateIndexRightBoundary = soapResponseString[1].indexOf("</" + soapTagToValidate + ">");
		String soapResponseTagToValidate = soapResponseString[1].substring((soapResponseTagToValidateIndexLeftBoundary + soapTagToValidateIndex + 2), (soapResponseTagToValidateIndexRightBoundary));
		logger.info("SOAP Response For " + soapTagToValidate + ": " + soapResponseTagToValidate);

		if (!(soapTagToValidateValue.equals("~"))) {
			if (!(soapResponseTagToValidate.equals(soapTagToValidateValue))) {
				logger.info("ERROR: HTTP " + httpResponseCode + " / " + "SOAP Response Code: " + soapResponseTagToValidate + " / SOAP Response For " + soapTagToValidate + ": " + soapResponseTagToValidate);
				Assert.fail("\nERROR: \n\nHTTP " + httpResponseCode + "\n\nSOAP Response Code: " + soapResponseTagToValidate + "\n\nExpected SOAP Response For " + soapTagToValidate + ": " + soapTagToValidateValue+ "\n\nActual   SOAP Response For " + soapTagToValidate + ": " + soapResponseTagToValidate);
			}
		}
		return (soapResponseTagToValidate);
	}

	public String[] setIdentityPointServiceCreate(String IdentityPointServiceCreateEndpointURL, String IdentityPointServiceCreateSoapAction, String IdentityPointServiceCreateSoapEnvelopePart1, String IdentityPointServiceCreateSoapEnvelopePart2, String IdentityPointServiceCreateSoapEnvelopePart3, String IdentityPointServiceCreateNewUserEmail, String IdentityPointServiceCreateNewUserPassword) throws UnsupportedEncodingException {
		String IdentityPointServiceCreateSoapEnvelope = (IdentityPointServiceCreateSoapEnvelopePart1 + IdentityPointServiceCreateNewUserEmail + IdentityPointServiceCreateSoapEnvelopePart2 + IdentityPointServiceCreateNewUserPassword + IdentityPointServiceCreateSoapEnvelopePart3); 
		String identityPointServiceCreateSoapResponse = (postSoapRequest(IdentityPointServiceCreateEndpointURL, IdentityPointServiceCreateSoapAction, IdentityPointServiceCreateSoapEnvelope));
		String[] identityPointServiceCreateSoapMessages = {IdentityPointServiceCreateSoapEnvelope, identityPointServiceCreateSoapResponse.toString()};
		return(identityPointServiceCreateSoapMessages);
	}

	public String[] setIdentityPointServiceCreateRESTmaiCookie(String IdentityPointServiceCreateRESTmaiCookieEndpointURL, String IdentityPointServiceCreateRESTmaiCookieSoapAction, String IdentityPointServiceCreateRESTmaiCookieSoapEnvelope, String IdentityPointServiceCreateRESTmaiCookieNewUserEmail, String IdentityPointServiceCreateRESTmaiCookieNewUserPassword) throws UnsupportedEncodingException {
		String identityPointServiceCreateRESTmaiCookieSoapResponse = (postSoapRequest(IdentityPointServiceCreateRESTmaiCookieEndpointURL, IdentityPointServiceCreateRESTmaiCookieSoapAction, IdentityPointServiceCreateRESTmaiCookieSoapEnvelope));
		String[] identityPointServiceCreateRESTmaiCookieSoapMessages = {IdentityPointServiceCreateRESTmaiCookieSoapEnvelope, identityPointServiceCreateRESTmaiCookieSoapResponse.toString()};
		return(identityPointServiceCreateRESTmaiCookieSoapMessages);
	}

	public String[] setIdentityPointServiceIdentify(String IdentityPointServiceIdentifyEndpointURL, String IdentityPointServiceIdentifySoapAction, String IdentityPointServiceIdentifySoapEnvelope, String IdentityPointServiceIdentifyNewUserEmail, String IdentityPointServiceIdentifyNewUserPassword) throws UnsupportedEncodingException {
		String identityPointServiceIdentifySoapResponse = (postSoapRequest(IdentityPointServiceIdentifyEndpointURL, IdentityPointServiceIdentifySoapAction, IdentityPointServiceIdentifySoapEnvelope));
		String[] identityPointServiceIdentifySoapMessages = {IdentityPointServiceIdentifySoapEnvelope, identityPointServiceIdentifySoapResponse.toString()};
		return(identityPointServiceIdentifySoapMessages);
	}

	public String[] setIdentityPointServiceIdentifyWithSSO(String IdentityPointServiceIdentifyWithSSOEndpointURL, String IdentityPointServiceIdentifyWithSSOSoapAction, String IdentityPointServiceIdentifyWithSSOSoapEnvelope, String IdentityPointServiceIdentifyWithSSONewUserEmail, String IdentityPointServiceIdentifyWithSSONewUserPassword) throws UnsupportedEncodingException {
		String identityPointServiceIdentifyWithSSOSoapResponse = (postSoapRequest(IdentityPointServiceIdentifyWithSSOEndpointURL, IdentityPointServiceIdentifyWithSSOSoapAction, IdentityPointServiceIdentifyWithSSOSoapEnvelope));
		String[] identityPointServiceIdentifyWithSSOSoapMessages = {IdentityPointServiceIdentifyWithSSOSoapEnvelope, identityPointServiceIdentifyWithSSOSoapResponse.toString()};
		return(identityPointServiceIdentifyWithSSOSoapMessages);
	}

	public String[] setIdentityPointServiceFindIdentityPointKeys(String IdentityPointServiceFindIdentityPointKeysEndpointURL, String IdentityPointServiceFindIdentityPointKeysSoapAction, String IdentityPointServiceFindIdentityPointKeysSoapEnvelope, String IdentityPointServiceFindIdentityPointKeysUserEmail, String IdentityPointServiceFindIdentityPointKeysUserPassword) throws UnsupportedEncodingException {
		String identityPointServiceFindIdentityPointKeysSoapResponse = (postSoapRequest(IdentityPointServiceFindIdentityPointKeysEndpointURL, IdentityPointServiceFindIdentityPointKeysSoapAction, IdentityPointServiceFindIdentityPointKeysSoapEnvelope));
		String[] identityPointServiceFindIdentityPointKeysSoapMessages = {IdentityPointServiceFindIdentityPointKeysSoapEnvelope, identityPointServiceFindIdentityPointKeysSoapResponse.toString()};
		return(identityPointServiceFindIdentityPointKeysSoapMessages);
	}

	public String[] setIdentityPointServiceLink(String IdentityPointServiceLinkEndpointURL, String IdentityPointServiceLinkSoapAction, String IdentityPointServiceLinkSoapEnvelope, String IdentityPointServiceLinkAccountToLinkToUserEmail, String IdentityPointServiceLinkAccountToLinkToUserPassword, String IdentityPointServiceLinkAccountToBeLinkedID, String IdentityPointServiceLinkAccountToBeLinkedFingerprint) throws UnsupportedEncodingException {
		String identityPointServiceLinkSoapResponse = (postSoapRequest(IdentityPointServiceLinkEndpointURL, IdentityPointServiceLinkSoapAction, IdentityPointServiceLinkSoapEnvelope));
		String[] identityPointServiceLinkSoapMessages = {IdentityPointServiceLinkSoapEnvelope, identityPointServiceLinkSoapResponse.toString()};
		return(identityPointServiceLinkSoapMessages);
	}

	public String[] setIdentityPointServiceUnlink(String IdentityPointServiceUnlinkEndpointURL, String IdentityPointServiceUnlinkSoapAction, String IdentityPointServiceUnlinkSoapEnvelope, String IdentityPointServiceUnlinkID, String IdentityPointServiceUnlinkFingerprint) throws UnsupportedEncodingException {
		String identityPointServiceUnlinkSoapResponse = (postSoapRequest(IdentityPointServiceUnlinkEndpointURL, IdentityPointServiceUnlinkSoapAction, IdentityPointServiceUnlinkSoapEnvelope));
		String[] identityPointServiceUnlinkSoapMessages = {IdentityPointServiceUnlinkSoapEnvelope, identityPointServiceUnlinkSoapResponse.toString()};
		return(identityPointServiceUnlinkSoapMessages);
	}

	public String[] setEmailServiceFindPrimaryEmail(String EmailServiceFindPrimaryEmailEndpointURL, String EmailServiceFindPrimaryEmailSoapAction, String EmailServiceFindPrimaryEmailSoapEnvelopePart1, String EmailServiceFindPrimaryEmailSoapEnvelopePart2, String EmailServiceFindPrimaryEmailSoapEnvelopePart3, String EmailServiceFindPrimaryEmailID, String EmailServiceFindPrimaryEmailFingerprint) throws UnsupportedEncodingException {
		String EmailServiceFindPrimaryEmailSoapEnvelope = (EmailServiceFindPrimaryEmailSoapEnvelopePart1 + EmailServiceFindPrimaryEmailID + EmailServiceFindPrimaryEmailSoapEnvelopePart2 + EmailServiceFindPrimaryEmailFingerprint + EmailServiceFindPrimaryEmailSoapEnvelopePart3); 
		String emailServiceFindPrimaryEmailSoapResponse = (postSoapRequest(EmailServiceFindPrimaryEmailEndpointURL, EmailServiceFindPrimaryEmailSoapAction, EmailServiceFindPrimaryEmailSoapEnvelope));
		String[] emailServiceFindPrimaryEmailSoapMessages = {EmailServiceFindPrimaryEmailSoapEnvelope, emailServiceFindPrimaryEmailSoapResponse.toString()};
		return(emailServiceFindPrimaryEmailSoapMessages);
	}

	public String[] setEmailServiceUpdateEmail(String EmailServiceUpdateEmailEndpointURL, String EmailServiceUpdateEmailSoapAction, String EmailServiceUpdateEmailSoapEnvelopePart1, String EmailServiceUpdateEmailSoapEnvelopePart2, String EmailServiceUpdateEmailSoapEnvelopePart3, String EmailServiceUpdateEmailSoapEnvelopePart4, String EmailServiceUpdateEmailUserEmail, String EmailServiceUpdateEmailUserPassword, String EmailServiceUpdateEmailUserNewEmail) throws UnsupportedEncodingException {
		String EmailServiceUpdateEmailSoapEnvelope = (EmailServiceUpdateEmailSoapEnvelopePart1 + EmailServiceUpdateEmailUserEmail + EmailServiceUpdateEmailSoapEnvelopePart2 + EmailServiceUpdateEmailUserPassword + EmailServiceUpdateEmailSoapEnvelopePart3 + EmailServiceUpdateEmailUserNewEmail + EmailServiceUpdateEmailSoapEnvelopePart4); 
		String emailServiceUpdateEmailSoapResponse = (postSoapRequest(EmailServiceUpdateEmailEndpointURL, EmailServiceUpdateEmailSoapAction, EmailServiceUpdateEmailSoapEnvelope));
		String[] emailServiceUpdateEmailSoapMessages = {EmailServiceUpdateEmailSoapEnvelope, emailServiceUpdateEmailSoapResponse.toString()};
		return(emailServiceUpdateEmailSoapMessages);
	}

	public String[] setPasswordServiceUpdateWithEmailAndPassword(String PasswordServiceUpdateWithEmailAndPasswordEndpointURL, String PasswordServiceUpdateWithEmailAndPasswordSoapAction, String PasswordServiceUpdateWithEmailAndPasswordSoapEnvelopePart1, String PasswordServiceUpdateWithEmailAndPasswordSoapEnvelopePart2, String PasswordServiceUpdateWithEmailAndPasswordSoapEnvelopePart3, String PasswordServiceUpdateWithEmailAndPasswordSoapEnvelopePart4, String PasswordServiceUpdateWithEmailAndPasswordUserEmail, String PasswordServiceUpdateWithEmailAndPasswordUserOldPassword, String PasswordServiceUpdateWithEmailAndPasswordUserNewPassword) throws UnsupportedEncodingException {
		String PasswordServiceUpdateWithEmailAndPasswordSoapEnvelope = (PasswordServiceUpdateWithEmailAndPasswordSoapEnvelopePart1 + PasswordServiceUpdateWithEmailAndPasswordUserEmail + PasswordServiceUpdateWithEmailAndPasswordSoapEnvelopePart2 + PasswordServiceUpdateWithEmailAndPasswordUserOldPassword + PasswordServiceUpdateWithEmailAndPasswordSoapEnvelopePart3 + PasswordServiceUpdateWithEmailAndPasswordUserNewPassword + PasswordServiceUpdateWithEmailAndPasswordSoapEnvelopePart4); 
		String passwordServiceUpdateWithEmailAndPasswordSoapResponse = (postSoapRequest(PasswordServiceUpdateWithEmailAndPasswordEndpointURL, PasswordServiceUpdateWithEmailAndPasswordSoapAction, PasswordServiceUpdateWithEmailAndPasswordSoapEnvelope));
		String[] passwordServiceUpdateWithEmailAndPasswordSoapMessages = {PasswordServiceUpdateWithEmailAndPasswordSoapEnvelope, passwordServiceUpdateWithEmailAndPasswordSoapResponse.toString()};
		return(passwordServiceUpdateWithEmailAndPasswordSoapMessages);
	}

	public String[] setPasswordServiceUpdateWithFingerprint(String PasswordServiceUpdateWithFingerprintEndpointURL, String PasswordServiceUpdateWithFingerprintSoapAction, String PasswordServiceUpdateWithFingerprintSoapEnvelopePart1, String PasswordServiceUpdateWithFingerprintSoapEnvelopePart2, String PasswordServiceUpdateWithFingerprintSoapEnvelopePart3, String PasswordServiceUpdateWithFingerprintSoapEnvelopePart4, String PasswordServiceUpdateWithFingerprintID, String PasswordServiceUpdateWithFingerprintFingerprint, String PasswordServiceUpdateWithFingerprintUserNewPassword) throws UnsupportedEncodingException {
		String PasswordServiceUpdateWithFingerprintSoapEnvelope = (PasswordServiceUpdateWithFingerprintSoapEnvelopePart1 + PasswordServiceUpdateWithFingerprintID + PasswordServiceUpdateWithFingerprintSoapEnvelopePart2 + PasswordServiceUpdateWithFingerprintFingerprint + PasswordServiceUpdateWithFingerprintSoapEnvelopePart3 + PasswordServiceUpdateWithFingerprintUserNewPassword + PasswordServiceUpdateWithFingerprintSoapEnvelopePart4); 
		String passwordServiceUpdateWithFingerprintSoapResponse = (postSoapRequest(PasswordServiceUpdateWithFingerprintEndpointURL, PasswordServiceUpdateWithFingerprintSoapAction, PasswordServiceUpdateWithFingerprintSoapEnvelope));
		String[] passwordServiceUpdateWithFingerprintSoapMessages = {PasswordServiceUpdateWithFingerprintSoapEnvelope, passwordServiceUpdateWithFingerprintSoapResponse.toString()};
		return(passwordServiceUpdateWithFingerprintSoapMessages);
	}

	public String[] setPasswordServiceReset(String PasswordServiceResetEndpointURL, String PasswordServiceResetSoapAction, String PasswordServiceResetSoapEnvelopePart1, String PasswordServiceResetSoapEnvelopePart2, String PasswordServiceResetUserEmail) throws UnsupportedEncodingException {
		String PasswordServiceResetSoapEnvelope = (PasswordServiceResetSoapEnvelopePart1 + PasswordServiceResetUserEmail + PasswordServiceResetSoapEnvelopePart2); 
		String passwordServiceResetSoapResponse = (postSoapRequest(PasswordServiceResetEndpointURL, PasswordServiceResetSoapAction, PasswordServiceResetSoapEnvelope));
		String[] passwordServiceResetSoapMessages = {PasswordServiceResetSoapEnvelope, passwordServiceResetSoapResponse.toString()};
		return(passwordServiceResetSoapMessages);
	}

	public String[] setProfileServiceFindProfile(String ProfileServiceFindProfileEndpointURL, String ProfileServiceFindProfileSoapAction, String ProfileServiceFindProfileSoapEnvelopePart1, String ProfileServiceFindProfileSoapEnvelopePart2, String ProfileServiceFindProfileSoapEnvelopePart3, String ProfileServiceFindProfileID, String ProfileServiceFindProfileFingerprint) throws UnsupportedEncodingException {
		String ProfileServiceFindProfileSoapEnvelope = (ProfileServiceFindProfileSoapEnvelopePart1 + ProfileServiceFindProfileID + ProfileServiceFindProfileSoapEnvelopePart2+ ProfileServiceFindProfileFingerprint + ProfileServiceFindProfileSoapEnvelopePart3); 
		String profileServiceFindProfileSoapResponse = (postSoapRequest(ProfileServiceFindProfileEndpointURL, ProfileServiceFindProfileSoapAction, ProfileServiceFindProfileSoapEnvelope));
		String[] profileServiceFindProfileSoapMessages = {ProfileServiceFindProfileSoapEnvelope, profileServiceFindProfileSoapResponse.toString()};
		return(profileServiceFindProfileSoapMessages);
	}

	public String[] setProfileServiceFindProfileRestJSON(String ProfileServiceFindProfileRestJSONEndpointURL, String ProfileServiceFindProfileRestJSONSoapAction, String ProfileServiceFindProfileRestJSONSoapEnvelopePart1, String ProfileServiceFindProfileRestJSONSoapEnvelopePart2, String ProfileServiceFindProfileRestJSONSoapEnvelopePart3, String ProfileServiceFindProfileRestJSONID, String ProfileServiceFindProfileRestJSONFingerprint) throws UnsupportedEncodingException {
		String ProfileServiceFindProfileRestJSONSoapEnvelope = (ProfileServiceFindProfileRestJSONSoapEnvelopePart1 + ProfileServiceFindProfileRestJSONID + ProfileServiceFindProfileRestJSONSoapEnvelopePart2+ ProfileServiceFindProfileRestJSONFingerprint + ProfileServiceFindProfileRestJSONSoapEnvelopePart3); 
		String profileServiceFindProfileRestJSONSoapResponse = (postSoapRequest(ProfileServiceFindProfileRestJSONEndpointURL, ProfileServiceFindProfileRestJSONSoapAction, ProfileServiceFindProfileRestJSONSoapEnvelope));
		String[] profileServiceFindProfileRestJSONSoapMessages = {ProfileServiceFindProfileRestJSONSoapEnvelope, profileServiceFindProfileRestJSONSoapResponse.toString()};
		return(profileServiceFindProfileRestJSONSoapMessages);
	}

	public String[] setProfileServiceFindProfileRestMaiCookie(String ProfileServiceFindProfileRestMaiCookieEndpointURL, String ProfileServiceFindProfileRestMaiCookieSoapAction, String ProfileServiceFindProfileRestMaiCookieSoapEnvelopePart1, String ProfileServiceFindProfileRestMaiCookieSoapEnvelopePart2, String ProfileServiceFindProfileRestMaiCookieSoapEnvelopePart3, String ProfileServiceFindProfileRestMaiCookieID, String ProfileServiceFindProfileRestMaiCookieFingerprint) throws UnsupportedEncodingException {
		String ProfileServiceFindProfileRestMaiCookieSoapEnvelope = (ProfileServiceFindProfileRestMaiCookieSoapEnvelopePart1 + ProfileServiceFindProfileRestMaiCookieID + ProfileServiceFindProfileRestMaiCookieSoapEnvelopePart2+ ProfileServiceFindProfileRestMaiCookieFingerprint + ProfileServiceFindProfileRestMaiCookieSoapEnvelopePart3); 
		String profileServiceFindProfileRestMaiCookieSoapResponse = (postSoapRequest(ProfileServiceFindProfileRestMaiCookieEndpointURL, ProfileServiceFindProfileRestMaiCookieSoapAction, ProfileServiceFindProfileRestMaiCookieSoapEnvelope));
		String[] profileServiceFindProfileRestMaiCookieSoapMessages = {ProfileServiceFindProfileRestMaiCookieSoapEnvelope, profileServiceFindProfileRestMaiCookieSoapResponse.toString()};
		return(profileServiceFindProfileRestMaiCookieSoapMessages);
	}

	public String[] setProfileServiceSaveProfile(String ProfileServiceSaveProfileEndpointURL, String ProfileServiceSaveProfileSoapAction, String ProfileServiceSaveProfileSoapEnvelopePart1, String ProfileServiceSaveProfileSoapEnvelopePart2, String ProfileServiceSaveProfileSoapEnvelopePart3, String ProfileServiceSaveProfileSoapEnvelopePart4, String ProfileServiceSaveProfileSoapEnvelopePart5, String ProfileServiceSaveProfileSoapEnvelopePart6, String ProfileServiceSaveProfileSoapEnvelopePart7, String ProfileServiceSaveProfileSoapEnvelopePart8, String ProfileServiceSaveProfileSoapEnvelopePart9, String ProfileServiceSaveProfileSoapEnvelopePart10, String ProfileServiceSaveProfileSoapEnvelopePart11, String ProfileServiceSaveProfileSoapEnvelopePart12, String ProfileServiceSaveProfileSoapEnvelopePart13, String ProfileServiceSaveProfileUserEmail, String ProfileServiceSaveProfileUserPassword, String ProfileServiceSaveProfileNickname, String ProfileServiceSaveProfileFirstName, String ProfileServiceSaveProfileLastName, String ProfileServiceSaveProfileMiddleName, String ProfileServiceSaveProfileClubAffiliation, String ProfileServiceSaveProfileGameEventID1, String ProfileServiceSaveProfileGameEventID2, String ProfileServiceSaveProfileFavoriteTeam, String ProfileServiceSaveProfileFavoriteTeamReason, String ProfileServiceSaveProfileAboutMe) throws UnsupportedEncodingException {
		String ProfileServiceSaveProfileSoapEnvelope = (ProfileServiceSaveProfileSoapEnvelopePart1 + ProfileServiceSaveProfileUserEmail + ProfileServiceSaveProfileSoapEnvelopePart2 + ProfileServiceSaveProfileUserPassword + ProfileServiceSaveProfileSoapEnvelopePart3 + ProfileServiceSaveProfileNickname + ProfileServiceSaveProfileSoapEnvelopePart4 + ProfileServiceSaveProfileFirstName + ProfileServiceSaveProfileSoapEnvelopePart5 + ProfileServiceSaveProfileLastName + ProfileServiceSaveProfileSoapEnvelopePart6 + ProfileServiceSaveProfileMiddleName + ProfileServiceSaveProfileSoapEnvelopePart7 + ProfileServiceSaveProfileClubAffiliation + ProfileServiceSaveProfileSoapEnvelopePart8 + ProfileServiceSaveProfileGameEventID1 + ProfileServiceSaveProfileSoapEnvelopePart9 + ProfileServiceSaveProfileGameEventID2 + ProfileServiceSaveProfileSoapEnvelopePart10 + ProfileServiceSaveProfileFavoriteTeam + ProfileServiceSaveProfileSoapEnvelopePart11 + ProfileServiceSaveProfileFavoriteTeamReason + ProfileServiceSaveProfileSoapEnvelopePart12 + ProfileServiceSaveProfileAboutMe + ProfileServiceSaveProfileSoapEnvelopePart13); 
		String profileServiceSaveProfileSoapResponse = (postSoapRequest(ProfileServiceSaveProfileEndpointURL, ProfileServiceSaveProfileSoapAction, ProfileServiceSaveProfileSoapEnvelope));
		String[] profileServiceSaveProfileSoapMessages = {ProfileServiceSaveProfileSoapEnvelope, profileServiceSaveProfileSoapResponse.toString()};
		return(profileServiceSaveProfileSoapMessages);
	}

	public String[] setCreditCardServiceFindPrimary(String CreditCardServiceFindPrimaryEndpointURL, String CreditCardServiceFindPrimarySoapAction, String CreditCardServiceFindPrimarySoapEnvelopePart1, String CreditCardServiceFindPrimarySoapEnvelopePart2, String CreditCardServiceFindPrimarySoapEnvelopePart3, String CreditCardServiceFindPrimaryID, String CreditCardServiceFindPrimaryFingerprint) throws UnsupportedEncodingException {
		String CreditCardServiceFindPrimarySoapEnvelope = (CreditCardServiceFindPrimarySoapEnvelopePart1 + CreditCardServiceFindPrimaryID + CreditCardServiceFindPrimarySoapEnvelopePart2+ CreditCardServiceFindPrimaryFingerprint + CreditCardServiceFindPrimarySoapEnvelopePart3); 
		String creditCardServiceFindPrimarySoapResponse = (postSoapRequest(CreditCardServiceFindPrimaryEndpointURL, CreditCardServiceFindPrimarySoapAction, CreditCardServiceFindPrimarySoapEnvelope));
		String[] creditCardServiceFindPrimarySoapMessages = {CreditCardServiceFindPrimarySoapEnvelope, creditCardServiceFindPrimarySoapResponse.toString()};
		return(creditCardServiceFindPrimarySoapMessages);
	}
	
	public String[] setCreditCardServiceSetPrimary(String CreditCardServiceSetPrimaryEndpointURL, String CreditCardServiceSetPrimarySoapAction, String CreditCardServiceSetPrimarySoapEnvelopePart1, String CreditCardServiceSetPrimarySoapEnvelopePart2, String CreditCardServiceSetPrimarySoapEnvelopePart3, String CreditCardServiceSetPrimarySoapEnvelopePart4, String CreditCardServiceSetPrimaryID, String CreditCardServiceSetPrimaryFingerprint, String CreditCardServiceSetPrimaryCardID) throws UnsupportedEncodingException {
		String CreditCardServiceSetPrimarySoapEnvelope = (CreditCardServiceSetPrimarySoapEnvelopePart1 + CreditCardServiceSetPrimaryID + CreditCardServiceSetPrimarySoapEnvelopePart2+ CreditCardServiceSetPrimaryFingerprint + CreditCardServiceSetPrimarySoapEnvelopePart3 + CreditCardServiceSetPrimaryCardID + CreditCardServiceSetPrimarySoapEnvelopePart4); 
		String creditCardServiceSetPrimarySoapResponse = (postSoapRequest(CreditCardServiceSetPrimaryEndpointURL, CreditCardServiceSetPrimarySoapAction, CreditCardServiceSetPrimarySoapEnvelope));
		String[] creditCardServiceSetPrimarySoapMessages = {CreditCardServiceSetPrimarySoapEnvelope, creditCardServiceSetPrimarySoapResponse.toString()};
		return(creditCardServiceSetPrimarySoapMessages);
	}
	
	public String[] setWalletServiceFindAll(String WalletServiceFindAllEndpointURL, String WalletServiceFindAllSoapAction, String WalletServiceFindAllSoapEnvelopePart1, String WalletServiceFindAllSoapEnvelopePart2, String WalletServiceFindAllSoapEnvelopePart3, String WalletServiceFindAllID, String WalletServiceFindAllFingerprint) throws UnsupportedEncodingException {
		String WalletServiceFindAllSoapEnvelope = (WalletServiceFindAllSoapEnvelopePart1 + WalletServiceFindAllID + WalletServiceFindAllSoapEnvelopePart2+ WalletServiceFindAllFingerprint + WalletServiceFindAllSoapEnvelopePart3); 
		String walletServiceFindAllSoapResponse = (postSoapRequest(WalletServiceFindAllEndpointURL, WalletServiceFindAllSoapAction, WalletServiceFindAllSoapEnvelope));
		String[] walletServiceFindAllSoapMessages = {WalletServiceFindAllSoapEnvelope, walletServiceFindAllSoapResponse.toString()};
		return(walletServiceFindAllSoapMessages);
	}
	
}
