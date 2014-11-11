package com.mlb.qa.tests.acctmgmt.web;

import java.io.UnsupportedEncodingException;
import org.testng.annotations.Test;
import com.mlb.qa.acctmgmt.service.http.*;
import com.qaprosoft.carina.core.foundation.UITest;
import com.mlb.qa.common.http.HttpResult;

public class AcctMgmtPOC001 extends UITest {

    //************ TEXT FIELD VALUES ************//
    //************ TEXT FIELD VALUES ************//
    //************ TEXT FIELD VALUES ************//

    //************ IDENTITY SERVICE POINT CREATE OBJECTS ************//
	public static long valueEmailUniqueAddressIncrementor = System.currentTimeMillis();
	public final String valueIdentityPointServiceCreateEndpointURL = "https://qasecure.mlb.com/pubajaxws/services/IdentityPointService";
	public final String valueIdentityPointServiceCreateSoapAction = "http://services.bamnetworks.com/registration/identityPoint/create";
//	public final String valueIdentityPointServiceCreateNewUserEmail = "testGmailAccount3@gmail.com";
	public final String valueIdentityPointServiceCreateNewUserEmail = "testGmailAccount" + valueEmailUniqueAddressIncrementor + "@gmail.com";
	public final String valueIdentityPointServiceCreateNewUserPassword = "Test1234";
	public final String valueIdentityPointServiceCreateSoapEnvelope = "<soapenv:Envelope xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Body><ns:identityPoint_create_request><ns:identification type=\"email-password\"><ns:email><ns:address>" + valueIdentityPointServiceCreateNewUserEmail + "</ns:address></ns:email><ns:password>" + valueIdentityPointServiceCreateNewUserPassword + "</ns:password></ns:identification></ns:identityPoint_create_request></soapenv:Body></soapenv:Envelope>";
	public final String valueIdentityPointServiceCreateSoapEnvelopePart1 = "<soapenv:Envelope xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Body><ns:identityPoint_create_request><ns:identification type=\"email-password\"><ns:email><ns:address>";
	public final String valueIdentityPointServiceCreateSoapEnvelopePart2 = "</ns:address></ns:email><ns:password>";
	public final String valueIdentityPointServiceCreateSoapEnvelopePart3 = "</ns:password></ns:identification></ns:identityPoint_create_request></soapenv:Body></soapenv:Envelope>";
	public final String valueIdentityPointServiceCreateSoapResponseFingerprintTag = "fingerprint";
	public final String valueIdentityPointServiceCreateSoapResponseFingerprintTagValue = "~";
	public final String valueIdentityPointServiceCreateSoapResponseIDTag = "id";
	public final String valueIdentityPointServiceCreateSoapResponseIDTagValue = "~";
	//************ IDENTITY SERVICE POINT CREATE OBJECTS ************//
	
    //************ IDENTITY SERVICE POINT CREATE REST MAI COOKIE OBJECTS ************//
	public final String valueIdentityPointServiceCreateRESTmaiCookieEndpointURL = "https://qaservices.bamnetworks.com/ws/services/IdentityPointService";
	public final String valueIdentityPointServiceCreateRESTmaiCookieSoapAction = "https://qasecure.mlb.com/pubajaxws/bamrest/IdentityPointService/op-xdCreate/v-1.5";
	public final String valueIdentityPointServiceCreateRESTmaiCookieNewUserEmail = "testGmailAccount" + valueEmailUniqueAddressIncrementor + "@gmail.com";
	public final String valueIdentityPointServiceCreateRESTmaiCookieNewUserPassword = "Test1234!";
//	public final String valueIdentityPointServiceCreateRESTmaiCookieSoapEnvelope = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header><ns0:appCredentials  ns0:name=\"account-name\"  ns0:password=\"password\"  ns0:targetAccountName=\"mlb\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:identityPoint_identify_request><ns:identification type=\"email-password\"><ns:email><ns:address>" + valueIdentityPointServiceCreateRESTmaiCookieNewUserEmail + "</ns:address></ns:email><ns:password>" + valueIdentityPointServiceCreateRESTmaiCookieNewUserPassword + "</ns:password></ns:identification></ns:identityPoint_identify_request></soapenv:Body></soapenv:Envelope>";
	public final String valueIdentityPointServiceCreateRESTmaiCookieSoapEnvelope = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header><ns0:appCredentials  ns0:name=\"account-name\"  ns0:password=\"password\"  ns0:targetAccountName=\"mlb\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:identityPoint_identify_request><ns:identification type=\"email-password\"><ns:email><ns:address>" + valueIdentityPointServiceCreateRESTmaiCookieNewUserEmail + "</ns:address></ns:email><ns:password>" + valueIdentityPointServiceCreateRESTmaiCookieNewUserPassword + "</ns:password></ns:identification></ns:identityPoint_identify_request></soapenv:Body></soapenv:Envelope>";
    //************ IDENTITY SERVICE POINT CREATE REST MAI COOKIE OBJECTS ************//	
	
    //************ IDENTITY SERVICE POINT IDENTIFY OBJECTS ************//
	public final String valueIdentityPointServiceIdentifyEndpointURL = "https://qasecure.mlb.com/pubajaxws/services/IdentityPointService";
	public final String valueIdentityPointServiceIdentifySoapAction = "http://services.bamnetworks.com/registration/identityPoint/identify";
	public final String valueIdentityPointServiceIdentifyNewUserEmail = valueIdentityPointServiceCreateNewUserEmail;
	public final String valueIdentityPointServiceIdentifyNewUserPassword = valueIdentityPointServiceCreateNewUserPassword;
//	public final String valueIdentityPointServiceIdentifyNewUserEmail = "snehal.chudgar@mlb.com";
//	public final String valueIdentityPointServiceIdentifyNewUserPassword = "--------";
//	public final String valueIdentityPointServiceIdentifySoapEnvelope = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header><ns0:appCredentials  ns0:name=\"account-name\"  ns0:password=\"password\"  ns0:targetAccountName=\"mlb\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:identityPoint_identify_request><ns:identification type=\"email-password\"><ns:email><ns:address>" + valueIdentityPointServiceIdentifyNewUserEmail + "</ns:address></ns:email><ns:password>" + valueIdentityPointServiceIdentifyNewUserPassword + "</ns:password></ns:identification></ns:identityPoint_identify_request></soapenv:Body></soapenv:Envelope>";
	public final String valueIdentityPointServiceIdentifySoapEnvelope = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header/><soapenv:Body><ns:identityPoint_identify_request><ns:identification type=\"email-password\"><ns:email><ns:address>" + valueIdentityPointServiceIdentifyNewUserEmail + "</ns:address></ns:email><ns:password>" + valueIdentityPointServiceIdentifyNewUserPassword + "</ns:password></ns:identification></ns:identityPoint_identify_request></soapenv:Body></soapenv:Envelope>";
    //************ IDENTITY SERVICE POINT IDENTIFY OBJECTS ************//

    //************ IDENTITY SERVICE POINT IDENTIFY WITH SSO OBJECTS ************//
	public final String valueIdentityPointServiceIdentifyWithSSOEndpointURL = "https://qasecure.mlb.com/pubajaxws/services/IdentityPointService";
	public final String valueIdentityPointServiceIdentifyWithSSOSoapAction = "http://services.bamnetworks.com/registration/identityPoint/identify";
	public final String valueIdentityPointServiceIdentifyWithSSONewUserEmail = "testGmailAccount3@gmail.com";
	public final String valueIdentityPointServiceIdentifyWithSSONewUserPassword = "Test1234!";
	public final String valueIdentityPointServiceIdentifyWithSSOSoapEnvelope = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header><ns0:appCredentials  ns0:name=\"account-name\"  ns0:password=\"password\"  ns0:targetAccountName=\"mlb\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:identityPoint_identify_request><ns:identification type=\"email-password\"><ns:email><ns:address>" + valueIdentityPointServiceIdentifyWithSSONewUserEmail + "</ns:address></ns:email><ns:password>" + valueIdentityPointServiceIdentifyWithSSONewUserPassword + "</ns:password><ns:signOnRestriction type=\"media\"> <ns:location>234.123.123.122</ns:location><ns:sessionKey>VLTbiiIURtIbeOCEa5o+HtAaLCk=</ns:sessionKey></ns:signOnRestriction></ns:identification></ns:identityPoint_identify_request></soapenv:Body></soapenv:Envelope>";
    //************ IDENTITY SERVICE POINT IDENTIFY WITH SSO OBJECTS ************//	
	
    //************ IDENTITY SERVICE POINT FIND IDENTITY POINT KEYS OBJECTS ************//
	public final String valueIdentityPointServiceFindIdentityPointKeysEndpointURL = "https://qasecure.mlb.com/pubajaxws/services/IdentityPointService";
	public final String valueIdentityPointServiceFindIdentityPointKeysSoapAction = "http://services.bamnetworks.com/registration/identityPoint/identify";
	public final String valueIdentityPointServiceFindIdentityPointKeysUserEmail = "test@mlb.com";
	public final String valueIdentityPointServiceFindIdentityPointKeysUserPassword = "asdfasdf!";
	public final String valueIdentityPointServiceFindIdentityPointKeysSoapEnvelope = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header><ns0:appCredentials  ns0:name=\"appAccount\"  ns0:password=\"password\"  ns0:targetAccountName=\"mlb\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:identityPoint_findIdentityPointKeys_request><ns:identification type=\"email-password\"><ns:email><ns:address>" + valueIdentityPointServiceFindIdentityPointKeysUserEmail + "</ns:address></ns:email><ns:password>" + valueIdentityPointServiceFindIdentityPointKeysUserPassword + "</ns:password></ns:identification></ns:identityPoint_findIdentityPointKeys_request></soapenv:Body></soapenv:Envelope>";
    //************ IDENTITY SERVICE POINT FIND IDENTITY POINT KEYS OBJECTS ************//
	   
    //************ IDENTITY SERVICE POINT LINK OBJECTS ************//
	public final String valueIdentityPointServiceLinkEndpointURL = "https://qasecure.mlb.com/pubajaxws/services/IdentityPointService";
	public final String valueIdentityPointServiceLinkSoapAction = "http://services.bamnetworks.com/registration/identityPoint/link";
	public final String valueIdentityPointServiceLinkAccountToLinkToUserEmail = "test@mlb.com";
	public final String valueIdentityPointServiceLinkAccountToLinkToUserPassword = "asdfasdf!";
	public final String valueIdentityPointServiceLinkAccountToBeLinkedID = "xbox:40A406912410B9976B6164FDDC042E871A02524E";
	public final String valueIdentityPointServiceLinkAccountToBeLinkedFingerprint = "FiTbHwrqfQk5CSLYEdzC7nO/9F0=";
	public final String valueIdentityPointServiceLinkSoapEnvelope = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soap:Header><ns0:appCredentials ns0:name=\"bam-service-media\" ns0:password=\"password\" ns0:targetAccountId=\"14\" ns0:targetAccountName=\"mlb\" ns0:targetNamespaceId=\"1\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soap:Header><soap:Body><ns:identityPoint_link_request><ns:identification type=\"email-password\"><ns:email><ns:address>" + valueIdentityPointServiceLinkAccountToLinkToUserEmail + "</ns:address></ns:email><ns:password>" + valueIdentityPointServiceLinkAccountToLinkToUserPassword + "</ns:password></ns:identification><ns:linkIdentification type=\"fingerprint\"><ns:id>" + valueIdentityPointServiceLinkAccountToBeLinkedID + "</ns:id><ns:fingerprint>" + valueIdentityPointServiceLinkAccountToBeLinkedFingerprint + "</ns:fingerprint></ns:linkIdentification></ns:identityPoint_link_request></soap:Body></soap:Envelope>";
    //************ IDENTITY SERVICE POINT LINK OBJECTS ************//

    //************ IDENTITY SERVICE POINT UNLINK OBJECTS ************//
	public final String valueIdentityPointServiceUnlinkEndpointURL = "https://qasecure.mlb.com/pubajaxws/services/IdentityPointService";
	public final String valueIdentityPointServiceUnlinkSoapAction = "http://services.bamnetworks.com/registration/identityPoint/unlink";
	public final String valueIdentityPointServiceUnlinkID = "xbox:DA4855859530B3D9C05BFC84895C2F53FCBD74F6";
	public final String valueIdentityPointServiceUnlinkFingerprint = "ZUNVOGlFSTJPTnBHQmhMdExqNDNpeVBkS1hrPXwxMzkwNTk1Nzg3MTc0fGlwdD1pZGVudGl0eXBvaW50aWQ=";
	public final String valueIdentityPointServiceUnlinkSoapEnvelope = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.6\"><soap:Header/><soap:Body><ns:identityPoint_unlink_request><ns:identification type=\"fingerprint\"><ns:id>" + valueIdentityPointServiceUnlinkID + "</ns:id><ns:fingerprint>" + valueIdentityPointServiceUnlinkFingerprint + "</ns:fingerprint></ns:identification></ns:identityPoint_unlink_request></soap:Body></soap:Envelope>";
    //************ IDENTITY SERVICE POINT UNLINK OBJECTS ************//	
	
//	@Test
	public void accountManagementTest000TestFunction() throws UnsupportedEncodingException	{
		AcctMgmtHttpServiceTest001 serviceCall = new AcctMgmtHttpServiceTest001();
		HttpResult valueIdentityPointServiceCreateSoapResponse = (serviceCall.setIdentityPointServiceCreate(valueIdentityPointServiceCreateEndpointURL, valueIdentityPointServiceCreateSoapAction, valueIdentityPointServiceCreateSoapEnvelopePart1, valueIdentityPointServiceCreateSoapEnvelopePart2, valueIdentityPointServiceCreateSoapEnvelopePart3, valueIdentityPointServiceCreateNewUserEmail, valueIdentityPointServiceCreateNewUserPassword));
		return;
	}	

	@Test
	public void accountManagementTest001IdentityPointServiceCreate() throws UnsupportedEncodingException	{
		AcctMgmtHttpServiceTest001 serviceCall = new AcctMgmtHttpServiceTest001();
		HttpResult valueIdentityPointServiceCreateSoapResponse = (serviceCall.setIdentityPointServiceCreate(valueIdentityPointServiceCreateEndpointURL, valueIdentityPointServiceCreateSoapAction, valueIdentityPointServiceCreateSoapEnvelopePart1, valueIdentityPointServiceCreateSoapEnvelopePart2, valueIdentityPointServiceCreateSoapEnvelopePart3, valueIdentityPointServiceCreateNewUserEmail, valueIdentityPointServiceCreateNewUserPassword));
		serviceCall.soapResponseValidator(valueIdentityPointServiceCreateSoapResponse.toString());
		String soapResponseFingerprint = serviceCall.soapTagValidator(valueIdentityPointServiceCreateSoapResponse.toString(), valueIdentityPointServiceCreateSoapResponseFingerprintTag, valueIdentityPointServiceCreateSoapResponseFingerprintTagValue);
		String soapResponseID = serviceCall.soapTagValidator(valueIdentityPointServiceCreateSoapResponse.toString(), valueIdentityPointServiceCreateSoapResponseIDTag, valueIdentityPointServiceCreateSoapResponseIDTagValue);
		return;
	}	

//	@Test
	public void accountManagementTest002IdentityPointServiceCreateRESTmaiCookie() throws UnsupportedEncodingException	{
		AcctMgmtHttpServiceTest001 serviceCall = new AcctMgmtHttpServiceTest001();
		HttpResult valueIdentityPointServiceCreateRESTmaiCookieSoapResponse = (serviceCall.setIdentityPointServiceCreateRESTmaiCookie(valueIdentityPointServiceCreateRESTmaiCookieEndpointURL, valueIdentityPointServiceCreateRESTmaiCookieSoapAction, valueIdentityPointServiceCreateRESTmaiCookieSoapEnvelope, valueIdentityPointServiceCreateRESTmaiCookieNewUserEmail, valueIdentityPointServiceCreateRESTmaiCookieNewUserPassword));
		return;
	}	

	@Test
	public void accountManagementTest003IdentityPointServiceIdentify() throws UnsupportedEncodingException	{
		AcctMgmtHttpServiceTest001 serviceCall = new AcctMgmtHttpServiceTest001();
		HttpResult valueIdentityPointServiceIdentifySoapResponse = (serviceCall.setIdentityPointServiceIdentify(valueIdentityPointServiceIdentifyEndpointURL, valueIdentityPointServiceIdentifySoapAction, valueIdentityPointServiceIdentifySoapEnvelope, valueIdentityPointServiceIdentifyNewUserEmail, valueIdentityPointServiceIdentifyNewUserPassword));
		serviceCall.soapResponseValidator(valueIdentityPointServiceIdentifySoapResponse.toString());
		String soapResponseFingerprint = serviceCall.soapTagValidator(valueIdentityPointServiceIdentifySoapResponse.toString(), valueIdentityPointServiceCreateSoapResponseFingerprintTag, valueIdentityPointServiceCreateSoapResponseFingerprintTagValue);
		String soapResponseID = serviceCall.soapTagValidator(valueIdentityPointServiceIdentifySoapResponse.toString(), valueIdentityPointServiceCreateSoapResponseIDTag, valueIdentityPointServiceCreateSoapResponseIDTagValue);
		return;
	}	

//	@Test
	public void accountManagementTest004IdentityPointServiceIdentifyWithSSO() throws UnsupportedEncodingException	{
		AcctMgmtHttpServiceTest001 serviceCall = new AcctMgmtHttpServiceTest001();
		HttpResult valueIdentityPointServiceIdentifyWithSSOSoapResponse = (serviceCall.setIdentityPointServiceIdentifyWithSSO(valueIdentityPointServiceIdentifyWithSSOEndpointURL, valueIdentityPointServiceIdentifyWithSSOSoapAction, valueIdentityPointServiceIdentifyWithSSOSoapEnvelope, valueIdentityPointServiceIdentifyWithSSONewUserEmail, valueIdentityPointServiceIdentifyWithSSONewUserPassword));
		return;
	}	

//	@Test
	public void accountManagementTest005IdentityPointServiceFindIdentityPointKeys() throws UnsupportedEncodingException	{
		AcctMgmtHttpServiceTest001 serviceCall = new AcctMgmtHttpServiceTest001();
		HttpResult valueIdentityPointServiceFindIdentityPointKeysSoapResponse = (serviceCall.setIdentityPointServiceFindIdentityPointKeys(valueIdentityPointServiceFindIdentityPointKeysEndpointURL, valueIdentityPointServiceFindIdentityPointKeysSoapAction, valueIdentityPointServiceFindIdentityPointKeysSoapEnvelope, valueIdentityPointServiceFindIdentityPointKeysUserEmail, valueIdentityPointServiceFindIdentityPointKeysUserPassword));
		return;
	}	

//	@Test
	public void accountManagementTest006IdentityPointServiceLink() throws UnsupportedEncodingException	{
		AcctMgmtHttpServiceTest001 serviceCall = new AcctMgmtHttpServiceTest001();
		HttpResult valueIdentityPointServiceLinkSoapResponse = (serviceCall.setIdentityPointServiceLink(valueIdentityPointServiceLinkEndpointURL, valueIdentityPointServiceLinkSoapAction, valueIdentityPointServiceLinkSoapEnvelope, valueIdentityPointServiceLinkAccountToLinkToUserEmail, valueIdentityPointServiceLinkAccountToLinkToUserPassword, valueIdentityPointServiceLinkAccountToBeLinkedID, valueIdentityPointServiceLinkAccountToBeLinkedFingerprint));
		return;
	}	

//	@Test
	public void accountManagementTest007IdentityPointServiceUnlink() throws UnsupportedEncodingException	{
		AcctMgmtHttpServiceTest001 serviceCall = new AcctMgmtHttpServiceTest001();
		HttpResult valueIdentityPointServiceUnlinkSoapResponse = (serviceCall.setIdentityPointServiceUnlink(valueIdentityPointServiceUnlinkEndpointURL, valueIdentityPointServiceUnlinkSoapAction, valueIdentityPointServiceUnlinkSoapEnvelope, valueIdentityPointServiceUnlinkID, valueIdentityPointServiceUnlinkID));
		return;
	}	

}

