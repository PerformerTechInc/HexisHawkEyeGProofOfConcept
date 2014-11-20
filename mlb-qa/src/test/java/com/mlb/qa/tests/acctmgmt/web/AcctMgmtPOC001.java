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
	
    //************ EMAIL SERVICE FIND PRIMARY EMAIL OBJECTS ************//
	public final String valueEmailServiceFindPrimaryEmailEndpointURL = "https://qasecure.mlb.com/pubajaxws/services/EmailService";
	public final String valueEmailServiceFindPrimaryEmailSoapAction = "http://services.bamnetworks.com/registration/email/findPrimary";
	public final String valueEmailServiceFindPrimaryEmailID = "";
	public final String valueEmailServiceFindPrimaryEmailFingerprint = "";
	public final String valueEmailServiceFindPrimaryEmailSoapEnvelope = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header><ns0:appCredentials ns0:name=\"<account name>\" ns0:password=\"<password>\" ns0:targetAccountName=\"mlb\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:email_findPrimary_request><ns:identification type=\"fingerprint\"><ns:id>" + valueEmailServiceFindPrimaryEmailID + "</ns:id><ns:fingerprint>" + valueEmailServiceFindPrimaryEmailFingerprint + "</ns:fingerprint></ns:identification></ns:email_findPrimary_request></soapenv:Body></soapenv:Envelope>";
	public final String valueEmailServiceFindPrimaryEmailSoapEnvelopePart1 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header><ns0:appCredentials ns0:name=\"<account name>\" ns0:password=\"<password>\" ns0:targetAccountName=\"mlb\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:email_findPrimary_request><ns:identification type=\"fingerprint\"><ns:id>";
	public final String valueEmailServiceFindPrimaryEmailSoapEnvelopePart2 = "</ns:id><ns:fingerprint>";
	public final String valueEmailServiceFindPrimaryEmailSoapEnvelopePart3 = "</ns:fingerprint></ns:identification></ns:email_findPrimary_request></soapenv:Body></soapenv:Envelope>";
    //************ EMAIL SERVICE FIND PRIMARY EMAIL OBJECTS ************//
	
    //************ EMAIL SERVICE UPDATE EMAIL OBJECTS ************//
	public final String valueEmailServiceUpdateEmailEndpointURL = "https://qasecure.mlb.com/pubajaxws/services/EmailService";
	public final String valueEmailServiceUpdateEmailSoapAction = "http://services.bamnetworks.com/registration/email/update";
	public final String valueEmailServiceUpdateEmailUserEmail = "";
	public final String valueEmailServiceUpdateEmailUserPassword = "";
	public final String valueEmailServiceUpdateEmailUserNewEmail = "";
	public final String valueEmailServiceUpdateEmailSoapEnvelope = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header><ns0:appCredentials ns0:name=\"<account name>\" ns0:password=\"<password>\" ns0:targetAccountName=\"mlb\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:email_update_request><ns:identification type=\"email-password\"><ns:email><ns:address>" + valueEmailServiceUpdateEmailUserEmail + "</ns:address></ns:email><ns:password>" + valueEmailServiceUpdateEmailUserPassword + "</ns:password></ns:identification><ns:email><ns:address>" + valueEmailServiceUpdateEmailUserNewEmail + "</ns:address></ns:email></ns:email_update_request></soapenv:Body></soapenv:Envelope>";
	public final String valueEmailServiceUpdateEmailSoapEnvelopePart1 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header><ns0:appCredentials ns0:name=\"<account name>\" ns0:password=\"<password>\" ns0:targetAccountName=\"mlb\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:email_update_request><ns:identification type=\"email-password\"><ns:email><ns:address>";
	public final String valueEmailServiceUpdateEmailSoapEnvelopePart2 = "</ns:address></ns:email><ns:password>";
	public final String valueEmailServiceUpdateEmailSoapEnvelopePart3 = "</ns:password></ns:identification><ns:email><ns:address>";
	public final String valueEmailServiceUpdateEmailSoapEnvelopePart4 = "</ns:address></ns:email></ns:email_update_request></soapenv:Body></soapenv:Envelope>";
    //************ EMAIL SERVICE UPDATE EMAIL OBJECTS ************//	
	
    //************ PASSWORD SERVICE UPDATE WITH EMAIL AND PASSWORD OBJECTS ************//
	public final String valuePasswordServiceUpdateWithEmailAndPasswordEndpointURL = "https://qasecure.mlb.com/pubajaxws/services/PasswordService";
	public final String valuePasswordServiceUpdateWithEmailAndPasswordSoapAction = "http://services.bamnetworks.com/registration/password/update";
	public final String valuePasswordServiceUpdateWithEmailAndPasswordUserEmail = "";
	public final String valuePasswordServiceUpdateWithEmailAndPasswordUserOldPassword = "";
	public final String valuePasswordServiceUpdateWithEmailAndPasswordUserNewPassword = "";
	public final String valuePasswordServiceUpdateWithEmailAndPasswordSoapEnvelope = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header><ns0:appCredentials  ns0:name=\"<account-name>\"  ns0:password=\"<password>\"  ns0:targetAccountName=\"mlb\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:password_update_request><ns:identification type=\"email-password\"><ns:email><ns:address>" + valuePasswordServiceUpdateWithEmailAndPasswordUserEmail + "</ns:address></ns:email><ns:password>" + valuePasswordServiceUpdateWithEmailAndPasswordUserOldPassword + "</ns:password></ns:identification><ns:password>" + valuePasswordServiceUpdateWithEmailAndPasswordUserNewPassword + "</ns:password></ns:password_update_request></soapenv:Body></soapenv:Envelope>";
	public final String valuePasswordServiceUpdateWithEmailAndPasswordSoapEnvelopePart1 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header><ns0:appCredentials  ns0:name=\"<account-name>\"  ns0:password=\"<password>\"  ns0:targetAccountName=\"mlb\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:password_update_request><ns:identification type=\"email-password\"><ns:email><ns:address>";
	public final String valuePasswordServiceUpdateWithEmailAndPasswordSoapEnvelopePart2 = "</ns:address></ns:email><ns:password>";
	public final String valuePasswordServiceUpdateWithEmailAndPasswordSoapEnvelopePart3 = "</ns:password></ns:identification><ns:password>";
	public final String valuePasswordServiceUpdateWithEmailAndPasswordSoapEnvelopePart4 = "</ns:password></ns:password_update_request></soapenv:Body></soapenv:Envelope>";
    //************ PASSWORD SERVICE UPDATE WITH EMAIL AND PASSWORD OBJECTS ************//
	
    //************ PASSWORD SERVICE UPDATE WITH FINGERPRINT OBJECTS ************//
	public final String valuePasswordServiceUpdateWithFingerprintEndpointURL = "https://qasecure.mlb.com/pubajaxws/services/PasswordService";
	public final String valuePasswordServiceUpdateWithFingerprintSoapAction = "http://services.bamnetworks.com/registration/password/update";
	public final String valuePasswordServiceUpdateWithFingerprintID = "24295622";
	public final String valuePasswordServiceUpdateWithFingerprintFingerprint = "S3o0NWFrY2RTaGFTRW91ZjkyK0dpKzRJbm1rPXwxMzU3OTQ4MDcxNjk0fGlwdD1lbWFpbC1wYXNzd29yZA==";
	public final String valuePasswordServiceUpdateWithFingerprintUserNewPassword = "";
	public final String valuePasswordServiceUpdateWithFingerprintSoapEnvelope = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header><ns0:appCredentials  ns0:name=\"<account-name>\"  ns0:password=\"<password>\"  ns0:targetAccountName=\"mlb\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:password_update_request><ns:identification type=\"fingerprint\"><ns:id>" + valuePasswordServiceUpdateWithFingerprintID + "</ns:id><ns:fingerprint>" + valuePasswordServiceUpdateWithFingerprintFingerprint + "</ns:fingerprint></ns:identification><ns:password>" + valuePasswordServiceUpdateWithFingerprintUserNewPassword + "</ns:password></ns:password_update_request></soapenv:Body></soapenv:Envelope>";
	public final String valuePasswordServiceUpdateWithFingerprintSoapEnvelopePart1 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header><ns0:appCredentials  ns0:name=\"<account-name>\"  ns0:password=\"<password>\"  ns0:targetAccountName=\"mlb\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:password_update_request><ns:identification type=\"fingerprint\"><ns:id>";
	public final String valuePasswordServiceUpdateWithFingerprintSoapEnvelopePart2 = "</ns:id><ns:fingerprint>";
	public final String valuePasswordServiceUpdateWithFingerprintSoapEnvelopePart3 = "</ns:fingerprint></ns:identification><ns:password>";
	public final String valuePasswordServiceUpdateWithFingerprintSoapEnvelopePart4 = "</ns:password></ns:password_update_request></soapenv:Body></soapenv:Envelope>";
    //************ PASSWORD SERVICE UPDATE WITH FINGERPRINT OBJECTS ************//
	
    //************ PASSWORD SERVICE RESET OBJECTS ************//
	public final String valuePasswordServiceResetEndpointURL = "https://qasecure.mlb.com/pubajaxws/services/PasswordService";
	public final String valuePasswordServiceResetSoapAction = "http://services.bamnetworks.com/registration/password/reset";
	public final String valuePasswordServiceResetUserEmail = "";
	public final String valuePasswordServiceResetSoapEnvelope = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header><ns0:appCredentials ns0:name=\"partner-accont-name\" ns0:password=\"partner-account-password\" ns0:targetNamespaceId=\"1\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:password_reset_request><ns:identification type=\"email-password\"><ns:email><ns:address>" + valuePasswordServiceResetUserEmail + "</ns:address></ns:email></ns:identification></ns:password_reset_request></soapenv:Body></soapenv:Envelope>";
	public final String valuePasswordServiceResetSoapEnvelopePart1 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header><ns0:appCredentials ns0:name=\"partner-accont-name\" ns0:password=\"partner-account-password\" ns0:targetNamespaceId=\"1\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:password_reset_request><ns:identification type=\"email-password\"><ns:email><ns:address>";
	public final String valuePasswordServiceResetSoapEnvelopePart2 = "</ns:address></ns:email></ns:identification></ns:password_reset_request></soapenv:Body></soapenv:Envelope>";
    //************ PASSWORD SERVICE RESET OBJECTS ************//
	
    //************ PROFILE SERVICE FIND PROFILE OBJECTS ************//
	public final String valueProfileServiceFindProfileEndpointURL = "https://qasecure.mlb.com/pubajaxws/services/ProfileService";
	public final String valueProfileServiceFindProfileSoapAction = "http://services.bamnetworks.com/registration/profile/find";
	public final String valueProfileServiceFindProfileID = "15461828";
	public final String valueProfileServiceFindProfileFingerprint = "hpy0yKgqrUOWdMEoA/408lvhI38=";
	public final String valueProfileServiceFindProfileSoapEnvelope = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header><ns0:appCredentials ns0:name=\"<account name>\" ns0:password=\"<password>\" ns0:targetAccountName=\"mlb\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:profile_find_request><ns:identification type=\"fingerprint\"><ns:id>" + valueProfileServiceFindProfileID + "</ns:id><ns:fingerprint>" + valueProfileServiceFindProfileFingerprint + "</ns:fingerprint></ns:identification></ns:profile_find_request></soapenv:Body></soapenv:Envelope>";
	public final String valueProfileServiceFindProfileSoapEnvelopePart1 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header><ns0:appCredentials ns0:name=\"<account name>\" ns0:password=\"<password>\" ns0:targetAccountName=\"mlb\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:profile_find_request><ns:identification type=\"fingerprint\"><ns:id>"; 
	public final String valueProfileServiceFindProfileSoapEnvelopePart2 = "</ns:id><ns:fingerprint>";
	public final String valueProfileServiceFindProfileSoapEnvelopePart3 = "</ns:fingerprint></ns:identification></ns:profile_find_request></soapenv:Body></soapenv:Envelope>";
    //************ PROFILE SERVICE FIND PROFILE OBJECTS ************//
	
	
	
	//**********INCOMPLETE************//
	//**********INCOMPLETE************//
	//**********INCOMPLETE************//
	
    //************ PROFILE SERVICE FIND PROFILE REST JSON OBJECTS ************//
	public final String valueProfileServiceFindProfileRestJSONEndpointURL = "https://qasecure.mlb.com/pubajaxws/services/ProfileService";
	public final String valueProfileServiceFindProfileRestJSONSoapAction = "https://qasecure.mlb.com/pubajaxws/bamrest/ProfileService/op-jsFind/v-1.5";
	public final String valueProfileServiceFindProfileRestJSONID = "15461828";
	public final String valueProfileServiceFindProfileRestJSONFingerprint = "hpy0yKgqrUOWdMEoA/408lvhI38=";
	public final String valueProfileServiceFindProfileRestJSONSoapEnvelope = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header><ns0:appCredentials ns0:name=\"<account name>\" ns0:password=\"<password>\" ns0:targetAccountName=\"mlb\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:profile_find_request><ns:identification type=\"fingerprint\"><ns:id>" + valueProfileServiceFindProfileID + "</ns:id><ns:fingerprint>" + valueProfileServiceFindProfileFingerprint + "</ns:fingerprint></ns:identification></ns:profile_find_request></soapenv:Body></soapenv:Envelope>";
	public final String valueProfileServiceFindProfileRestJSONSoapEnvelopePart1 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header><ns0:appCredentials ns0:name=\"<account name>\" ns0:password=\"<password>\" ns0:targetAccountName=\"mlb\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:profile_find_request><ns:identification type=\"fingerprint\"><ns:id>"; 
	public final String valueProfileServiceFindProfileRestJSONSoapEnvelopePart2 = "</ns:id><ns:fingerprint>";
	public final String valueProfileServiceFindProfileRestJSONSoapEnvelopePart3 = "</ns:fingerprint></ns:identification></ns:profile_find_request></soapenv:Body></soapenv:Envelope>";
    //************ PROFILE SERVICE FIND PROFILE REST JSON OBJECTS ************//
	
    //************ PROFILE SERVICE FIND PROFILE REST MAI COOKIE OBJECTS ************//
	public final String valueProfileServiceFindProfileRestMaiCookieEndpointURL = "https://qasecure.mlb.com/pubajaxws/services/ProfileService";
	public final String valueProfileServiceFindProfileRestMaiCookieSoapAction = "https://qasecure.mlb.com/pubajaxws/bamrest/ProfileService/op-jsFind/v-1.5";
	public final String valueProfileServiceFindProfileRestMaiCookieID = "15461828";
	public final String valueProfileServiceFindProfileRestMaiCookieFingerprint = "hpy0yKgqrUOWdMEoA/408lvhI38=";
	public final String valueProfileServiceFindProfileRestMaiCookieSoapEnvelope = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header><ns0:appCredentials ns0:name=\"<account name>\" ns0:password=\"<password>\" ns0:targetAccountName=\"mlb\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:profile_find_request><ns:identification type=\"fingerprint\"><ns:id>" + valueProfileServiceFindProfileID + "</ns:id><ns:fingerprint>" + valueProfileServiceFindProfileFingerprint + "</ns:fingerprint></ns:identification></ns:profile_find_request></soapenv:Body></soapenv:Envelope>";
	public final String valueProfileServiceFindProfileRestMaiCookieSoapEnvelopePart1 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header><ns0:appCredentials ns0:name=\"<account name>\" ns0:password=\"<password>\" ns0:targetAccountName=\"mlb\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:profile_find_request><ns:identification type=\"fingerprint\"><ns:id>"; 
	public final String valueProfileServiceFindProfileRestMaiCookieSoapEnvelopePart2 = "</ns:id><ns:fingerprint>";
	public final String valueProfileServiceFindProfileRestMaiCookieSoapEnvelopePart3 = "</ns:fingerprint></ns:identification></ns:profile_find_request></soapenv:Body></soapenv:Envelope>";
    //************ PROFILE SERVICE FIND PROFILE REST MAI COOKIE OBJECTS ************//
	
	//**********INCOMPLETE************//
	//**********INCOMPLETE************//
	//**********INCOMPLETE************//

    //************ PROFILE SERVICE SAVE PROFILE OBJECTS ************//
	public final String valueProfileServiceSaveProfileEndpointURL = "https://qasecure.mlb.com/pubajaxws/services/ProfileService";
	public final String valueProfileServiceSaveProfileSoapAction = "https://qasecure.mlb.com/pubajaxws/bamrest/ProfileService/op-jsFind/v-1.5";
	public final String valueProfileServiceSaveProfileUserEmail = valueIdentityPointServiceCreateNewUserEmail;
	public final String valueProfileServiceSaveProfileUserPassword = "valueIdentityPointServiceCreateNewUserPassword";
	public final String valueProfileServiceSaveProfileNickname = "Nickey Namey";
	public final String valueProfileServiceSaveProfileFirstName = "First";
	public final String valueProfileServiceSaveProfileLastName = "Last";
	public final String valueProfileServiceSaveProfileMiddleName = "Middle";
	public final String valueProfileServiceSaveProfileClubAffiliation = "New York Yankee Lovers Association";
	public final String valueProfileServiceSaveProfileGameEventID1 = "nyy_vs_nym";
	public final String valueProfileServiceSaveProfileGameEventID2 = "nyy_vs_phi";
	public final String valueProfileServiceSaveProfileFavoriteTeam = "121";
	public final String valueProfileServiceSaveProfileFavoriteTeamReason = "Because They Got Bo, and Bo Knows!@#$";
	public final String valueProfileServiceSaveProfileAboutMe = "I am the best baseball fan in America!";
	public final String valueProfileServiceSaveProfileSoapEnvelope = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header><ns0:appCredentials  ns0:name=\"<account-name>\"  ns0:password=\"<password>\"  ns0:targetAccountName=\"mlb\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:profile_save_request><ns:identification type=\"email-password\"><ns:email><ns:address>" + valueProfileServiceSaveProfileUserEmail + "</ns:address></ns:email><ns:password>" + valueProfileServiceSaveProfileUserPassword + "</ns:password></ns:identification><ns:profileProperty><ns:name>nickname</ns:name><ns:value>" + valueProfileServiceSaveProfileNickname + "</ns:value></ns:profileProperty><ns:profileProperty><ns:name>firstName</ns:name><ns:value>" + valueProfileServiceSaveProfileFirstName + "</ns:value></ns:profileProperty><ns:profileProperty><ns:name>lastName</ns:name><ns:value>" + valueProfileServiceSaveProfileLastName + "</ns:value></ns:profileProperty><ns:profileProperty><ns:name>middleName</ns:name><ns:value>" + valueProfileServiceSaveProfileMiddleName + "</ns:value></ns:profileProperty><ns:profileProperty><ns:name>clubAffiliation</ns:name><ns:value>" + valueProfileServiceSaveProfileClubAffiliation + "</ns:value></ns:profileProperty><ns:profileProperty><ns:name>gameEventId</ns:name><ns:value>" + valueProfileServiceSaveProfileGameEventID1 + "</ns:value><ns:value>" + valueProfileServiceSaveProfileGameEventID2 + "</ns:value></ns:profileProperty><ns:profileProperty><ns:name>favoriteTeam</ns:name><ns:value>" + valueProfileServiceSaveProfileFavoriteTeam + "</ns:value></ns:profileProperty><ns:profileProperty><ns:name>favoriteTeamReason</ns:name><ns:value>" + valueProfileServiceSaveProfileFavoriteTeamReason + "</ns:value></ns:profileProperty><ns:profileProperty><ns:name>aboutMe</ns:name><ns:value>" + valueProfileServiceSaveProfileAboutMe + "</ns:value></ns:profileProperty></ns:profile_save_request></soapenv:Body></soapenv:Envelope>";
	public final String valueProfileServiceSaveProfileSoapEnvelopePart1 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header><ns0:appCredentials  ns0:name=\"<account-name>\"  ns0:password=\"<password>\"  ns0:targetAccountName=\"mlb\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:profile_save_request><ns:identification type=\"email-password\"><ns:email><ns:address>"; 
	public final String valueProfileServiceSaveProfileSoapEnvelopePart2 = "</ns:address></ns:email><ns:password>";
	public final String valueProfileServiceSaveProfileSoapEnvelopePart3 =  "</ns:password></ns:identification><ns:profileProperty><ns:name>nickname</ns:name><ns:value>";
	public final String valueProfileServiceSaveProfileSoapEnvelopePart4 =  "</ns:value></ns:profileProperty><ns:profileProperty><ns:name>firstName</ns:name><ns:value>"; 
	public final String valueProfileServiceSaveProfileSoapEnvelopePart5 =  "</ns:value></ns:profileProperty><ns:profileProperty><ns:name>lastName</ns:name><ns:value>";
	public final String valueProfileServiceSaveProfileSoapEnvelopePart6 =  "</ns:value></ns:profileProperty><ns:profileProperty><ns:name>middleName</ns:name><ns:value>";
	public final String valueProfileServiceSaveProfileSoapEnvelopePart7 =  "</ns:value></ns:profileProperty><ns:profileProperty><ns:name>clubAffiliation</ns:name><ns:value>"; 
	public final String valueProfileServiceSaveProfileSoapEnvelopePart8 =  "</ns:value></ns:profileProperty><ns:profileProperty><ns:name>gameEventId</ns:name><ns:value>";
	public final String valueProfileServiceSaveProfileSoapEnvelopePart9 =  "</ns:value><ns:value>";
	public final String valueProfileServiceSaveProfileSoapEnvelopePart10 =  "</ns:value></ns:profileProperty><ns:profileProperty><ns:name>favoriteTeam</ns:name><ns:value>"; 
	public final String valueProfileServiceSaveProfileSoapEnvelopePart11 =  "</ns:value></ns:profileProperty><ns:profileProperty><ns:name>favoriteTeamReason</ns:name><ns:value>";
	public final String valueProfileServiceSaveProfileSoapEnvelopePart12 =  "</ns:value></ns:profileProperty><ns:profileProperty><ns:name>aboutMe</ns:name><ns:value>";
	public final String valueProfileServiceSaveProfileSoapEnvelopePart13 =  "</ns:value></ns:profileProperty></ns:profile_save_request></soapenv:Body></soapenv:Envelope>";
    //************ PROFILE SERVICE SAVE PROFILE OBJECTS ************//
	
    //************ CREDIT CARD SERVICE FIND PRIMARY OBJECTS ************//
	public final String valueCreditCardServiceFindPrimaryEndpointURL = "https://secure.mlb.com/pubajaxws/services/CreditCardService";
	public final String valueCreditCardServiceFindPrimarySoapAction = "http://services.bamnetworks.com/registration/creditCard/findPrimary/";
	public final String valueCreditCardServiceFindPrimaryID = "14386700";
	public final String valueCreditCardServiceFindPrimaryFingerprint = "dC22RV5OzBXrcaA0wAm1HEwOGRE=";
	public final String valueCreditCardServiceFindPrimarySoapEnvelope = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header><ns0:appCredentials  ns0:name=\"<account name>\"  ns0:password=\"<password>\"  ns0:targetAccountName=\"mlb\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:creditCard_findPrimary_request><ns:identification type=\"fingerprint\"><ns:id>" + valueCreditCardServiceFindPrimaryID + "</ns:id><ns:fingerprint>" + valueCreditCardServiceFindPrimaryFingerprint + "</ns:fingerprint></ns:identification></ns:creditCard_findPrimary_request></soapenv:Body></soapenv:Envelope>";
	public final String valueCreditCardServiceFindPrimarySoapEnvelopePart1 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header><ns0:appCredentials  ns0:name=\"<account name>\"  ns0:password=\"<password>\"  ns0:targetAccountName=\"mlb\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:creditCard_findPrimary_request><ns:identification type=\"fingerprint\"><ns:id>"; 
	public final String valueCreditCardServiceFindPrimarySoapEnvelopePart2 = "</ns:id><ns:fingerprint>";
	public final String valueCreditCardServiceFindPrimarySoapEnvelopePart3 = "</ns:fingerprint></ns:identification></ns:creditCard_findPrimary_request></soapenv:Body></soapenv:Envelope>";
    //************ CREDIT CARD SERVICE FIND PRIMARY OBJECTS ************//
	
    //************ CREDIT CARD SERVICE SET PRIMARY OBJECTS ************//
	public final String valueCreditCardServiceSetPrimaryEndpointURL = "https://secure.mlb.com/pubajaxws/services/CreditCardService";
	public final String valueCreditCardServiceSetPrimarySoapAction = "http://services.bamnetworks.com/registration/creditCard/setPrimary/";
	public final String valueCreditCardServiceSetPrimaryID = "24295632";
	public final String valueCreditCardServiceSetPrimaryFingerprint = "ZEE0RStidW0vbi9NR0xtWmpzVTFoSEdGd0w4PXwxMzU3OTQ4ODE2NjcwfGlwdD1lbWFpbC1wYXNzd29yZA==";
	public final String valueCreditCardServiceSetPrimaryCardID = "8888";
	public final String valueCreditCardServiceSetPrimarySoapEnvelope = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header><ns0:appCredentials ns0:name=\"<account name>\" ns0:password=\"<password>\" ns0:targetAccountName=\"mlb\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:creditCard_setPrimary_request><ns:identification type=\"fingerprint\"><ns:id>" + valueCreditCardServiceSetPrimaryID + "</ns:id><ns:fingerprint>" + valueCreditCardServiceSetPrimaryFingerprint + "</ns:fingerprint></ns:identification><ns:creditCardId>" + valueCreditCardServiceSetPrimaryCardID + "</ns:creditCardId></ns:creditCard_setPrimary_request></soapenv:Body></soapenv:Envelope>";
	public final String valueCreditCardServiceSetPrimarySoapEnvelopePart1 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header><ns0:appCredentials ns0:name=\"<account name>\" ns0:password=\"<password>\" ns0:targetAccountName=\"mlb\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:creditCard_setPrimary_request><ns:identification type=\"fingerprint\"><ns:id>"; 
	public final String valueCreditCardServiceSetPrimarySoapEnvelopePart2 =  "</ns:id><ns:fingerprint>";
	public final String valueCreditCardServiceSetPrimarySoapEnvelopePart3 =  "</ns:fingerprint></ns:identification><ns:creditCardId>";
	public final String valueCreditCardServiceSetPrimarySoapEnvelopePart4 =  "</ns:creditCardId></ns:creditCard_setPrimary_request></soapenv:Body></soapenv:Envelope>";
    //************ CREDIT CARD SERVICE SET PRIMARY OBJECTS ************//
	   
    //************ WALLET SERVICE FIND ALL OBJECTS ************//
	public final String valueWalletServiceFindAllEndpointURL = "https://secure.mlb.com/pubajaxws/services/WalletService";
	public final String valueWalletServiceFindAllSoapAction = "http://services.bamnetworks.com/registration/wallet/findAll";
	public final String valueWalletServiceFindAllID = "15461828";
	public final String valueWalletServiceFindAllFingerprint = "hpy0yKgqrUOWdMEoA/408lvhI38=";
	public final String valueWalletServiceFindAllSoapEnvelope = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header><ns0:appCredentials ns0:name=\"<account name>\" ns0:password=\"<password>\" ns0:targetAccountName=\"mlb\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:profile_find_request><ns:identification type=\"fingerprint\"><ns:id>" + valueWalletServiceFindAllID + "</ns:id><ns:fingerprint>" + valueWalletServiceFindAllFingerprint + "</ns:fingerprint></ns:identification></ns:profile_find_request></soapenv:Body></soapenv:Envelope>";
	public final String valueWalletServiceFindAllSoapEnvelopePart1 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\"><soapenv:Header><ns0:appCredentials ns0:name=\"<account name>\" ns0:password=\"<password>\" ns0:targetAccountName=\"mlb\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:profile_find_request><ns:identification type=\"fingerprint\"><ns:id>";
	public final String valueWalletServiceFindAllSoapEnvelopePart2 = "</ns:id><ns:fingerprint>";
	public final String valueWalletServiceFindAllSoapEnvelopePart3 = "</ns:fingerprint></ns:identification></ns:profile_find_request></soapenv:Body></soapenv:Envelope>";
    //************ WALLET SERVICE FIND ALL OBJECTS ************//
	 
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

//	@Test
	public void accountManagementTest008EmailServiceFindPrimaryEmail() throws UnsupportedEncodingException	{
		AcctMgmtHttpServiceTest001 serviceCall = new AcctMgmtHttpServiceTest001();
		HttpResult valueEmailServiceFindPrimaryEmailSoapResponse = (serviceCall.setEmailServiceFindPrimaryEmail(valueEmailServiceFindPrimaryEmailEndpointURL, valueEmailServiceFindPrimaryEmailSoapAction, valueEmailServiceFindPrimaryEmailSoapEnvelopePart1, valueEmailServiceFindPrimaryEmailSoapEnvelopePart2, valueEmailServiceFindPrimaryEmailSoapEnvelopePart3, valueEmailServiceFindPrimaryEmailID, valueEmailServiceFindPrimaryEmailFingerprint));
		return;
	}	

//	@Test
	public void accountManagementTest009EmailServiceUpdateEmail() throws UnsupportedEncodingException	{
		AcctMgmtHttpServiceTest001 serviceCall = new AcctMgmtHttpServiceTest001();
		HttpResult valueEmailServiceUpdateEmailSoapResponse = (serviceCall.setEmailServiceUpdateEmail(valueEmailServiceUpdateEmailEndpointURL, valueEmailServiceUpdateEmailSoapAction, valueEmailServiceUpdateEmailSoapEnvelopePart1, valueEmailServiceUpdateEmailSoapEnvelopePart2, valueEmailServiceUpdateEmailSoapEnvelopePart3, valueEmailServiceUpdateEmailSoapEnvelopePart4, valueEmailServiceUpdateEmailUserEmail, valueEmailServiceUpdateEmailUserPassword, valueEmailServiceUpdateEmailUserNewEmail));
		return;
	}	

//	@Test
	public void accountManagementTest010PasswordServiceUpdateWithEmailAndPassword() throws UnsupportedEncodingException	{
		AcctMgmtHttpServiceTest001 serviceCall = new AcctMgmtHttpServiceTest001();
		HttpResult valuePasswordServiceUpdateWithEmailAndPasswordSoapResponse = (serviceCall.setPasswordServiceUpdateWithEmailAndPassword(valuePasswordServiceUpdateWithEmailAndPasswordEndpointURL, valuePasswordServiceUpdateWithEmailAndPasswordSoapAction, valuePasswordServiceUpdateWithEmailAndPasswordSoapEnvelopePart1, valuePasswordServiceUpdateWithEmailAndPasswordSoapEnvelopePart2, valuePasswordServiceUpdateWithEmailAndPasswordSoapEnvelopePart3, valuePasswordServiceUpdateWithEmailAndPasswordSoapEnvelopePart4, valuePasswordServiceUpdateWithEmailAndPasswordUserEmail, valuePasswordServiceUpdateWithEmailAndPasswordUserOldPassword, valuePasswordServiceUpdateWithEmailAndPasswordUserNewPassword));
		return;
	}	

//	@Test
	public void accountManagementTest011PasswordServiceUpdateWithFingerprint() throws UnsupportedEncodingException	{
		AcctMgmtHttpServiceTest001 serviceCall = new AcctMgmtHttpServiceTest001();
		HttpResult valuePasswordServiceUpdateWithFingerprintSoapResponse = (serviceCall.setPasswordServiceUpdateWithFingerprint(valuePasswordServiceUpdateWithFingerprintEndpointURL, valuePasswordServiceUpdateWithFingerprintSoapAction, valuePasswordServiceUpdateWithFingerprintSoapEnvelopePart1, valuePasswordServiceUpdateWithFingerprintSoapEnvelopePart2, valuePasswordServiceUpdateWithFingerprintSoapEnvelopePart3, valuePasswordServiceUpdateWithFingerprintSoapEnvelopePart4, valuePasswordServiceUpdateWithFingerprintID, valuePasswordServiceUpdateWithFingerprintFingerprint, valuePasswordServiceUpdateWithFingerprintUserNewPassword));
		return;
	}	

//	@Test
	public void accountManagementTest012PasswordServiceReset() throws UnsupportedEncodingException	{
		AcctMgmtHttpServiceTest001 serviceCall = new AcctMgmtHttpServiceTest001();
		HttpResult valuePasswordServiceResetSoapResponse = (serviceCall.setPasswordServiceReset(valuePasswordServiceResetEndpointURL, valuePasswordServiceResetSoapAction, valuePasswordServiceResetSoapEnvelopePart1, valuePasswordServiceResetSoapEnvelopePart2, valuePasswordServiceResetUserEmail));
		return;
	}	

//	@Test
	public void accountManagementTest013ProfileServiceFindProfile() throws UnsupportedEncodingException	{
		AcctMgmtHttpServiceTest001 serviceCall = new AcctMgmtHttpServiceTest001();
		HttpResult valueProfileServiceFindProfileSoapResponse = (serviceCall.setProfileServiceFindProfile(valueProfileServiceFindProfileEndpointURL, valueProfileServiceFindProfileSoapAction, valueProfileServiceFindProfileSoapEnvelopePart1, valueProfileServiceFindProfileSoapEnvelopePart2, valueProfileServiceFindProfileSoapEnvelopePart3, valueProfileServiceFindProfileID, valueProfileServiceFindProfileFingerprint));
		return;
	}	

//	@Test
	public void accountManagementTest014ProfileServiceFindProfileRestJSON() throws UnsupportedEncodingException	{
		AcctMgmtHttpServiceTest001 serviceCall = new AcctMgmtHttpServiceTest001();
		HttpResult valueProfileServiceFindProfileRestJSONSoapResponse = (serviceCall.setProfileServiceFindProfileRestJSON(valueProfileServiceFindProfileRestJSONEndpointURL, valueProfileServiceFindProfileRestJSONSoapAction, valueProfileServiceFindProfileRestJSONSoapEnvelopePart1, valueProfileServiceFindProfileRestJSONSoapEnvelopePart2, valueProfileServiceFindProfileRestJSONSoapEnvelopePart3, valueProfileServiceFindProfileRestJSONID, valueProfileServiceFindProfileRestJSONFingerprint));
		return;
	}	

//	@Test
	public void accountManagementTest015ProfileServiceFindProfileRestMaiCookie() throws UnsupportedEncodingException	{
		AcctMgmtHttpServiceTest001 serviceCall = new AcctMgmtHttpServiceTest001();
		HttpResult valueProfileServiceFindProfileRestMaiCookieSoapResponse = (serviceCall.setProfileServiceFindProfileRestMaiCookie(valueProfileServiceFindProfileRestMaiCookieEndpointURL, valueProfileServiceFindProfileRestMaiCookieSoapAction, valueProfileServiceFindProfileRestMaiCookieSoapEnvelopePart1, valueProfileServiceFindProfileRestMaiCookieSoapEnvelopePart2, valueProfileServiceFindProfileRestMaiCookieSoapEnvelopePart3, valueProfileServiceFindProfileRestMaiCookieID, valueProfileServiceFindProfileRestMaiCookieFingerprint));
		return;
	}	

//	@Test
	public void accountManagementTest016ProfileServiceSaveProfile() throws UnsupportedEncodingException	{
		AcctMgmtHttpServiceTest001 serviceCall = new AcctMgmtHttpServiceTest001();
		HttpResult valueProfileServiceSaveProfileSoapResponse = (serviceCall.setProfileServiceSaveProfile(valueProfileServiceSaveProfileEndpointURL, valueProfileServiceSaveProfileSoapAction, valueProfileServiceSaveProfileSoapEnvelopePart1, valueProfileServiceSaveProfileSoapEnvelopePart2, valueProfileServiceSaveProfileSoapEnvelopePart3, valueProfileServiceSaveProfileSoapEnvelopePart4, valueProfileServiceSaveProfileSoapEnvelopePart5, valueProfileServiceSaveProfileSoapEnvelopePart6, valueProfileServiceSaveProfileSoapEnvelopePart7, valueProfileServiceSaveProfileSoapEnvelopePart8, valueProfileServiceSaveProfileSoapEnvelopePart9, valueProfileServiceSaveProfileSoapEnvelopePart10, valueProfileServiceSaveProfileSoapEnvelopePart11, valueProfileServiceSaveProfileSoapEnvelopePart12, valueProfileServiceSaveProfileSoapEnvelopePart13, valueProfileServiceSaveProfileUserEmail, valueProfileServiceSaveProfileUserPassword, valueProfileServiceSaveProfileNickname, valueProfileServiceSaveProfileFirstName, valueProfileServiceSaveProfileLastName, valueProfileServiceSaveProfileMiddleName, valueProfileServiceSaveProfileClubAffiliation, valueProfileServiceSaveProfileGameEventID1, valueProfileServiceSaveProfileGameEventID2, valueProfileServiceSaveProfileFavoriteTeam, valueProfileServiceSaveProfileFavoriteTeamReason, valueProfileServiceSaveProfileAboutMe));
		return;
	}	

//	@Test
	public void accountManagementTest017CreditCardServiceFindPrimary() throws UnsupportedEncodingException	{
		AcctMgmtHttpServiceTest001 serviceCall = new AcctMgmtHttpServiceTest001();
		HttpResult valueCreditCardServiceFindPrimarySoapResponse = (serviceCall.setCreditCardServiceFindPrimary(valueCreditCardServiceFindPrimaryEndpointURL, valueCreditCardServiceFindPrimarySoapAction, valueCreditCardServiceFindPrimarySoapEnvelopePart1, valueCreditCardServiceFindPrimarySoapEnvelopePart2, valueCreditCardServiceFindPrimarySoapEnvelopePart3, valueCreditCardServiceFindPrimaryID, valueCreditCardServiceFindPrimaryFingerprint));
		return;
	}	

//	@Test
	public void accountManagementTest018CreditCardServiceSetPrimary() throws UnsupportedEncodingException	{
		AcctMgmtHttpServiceTest001 serviceCall = new AcctMgmtHttpServiceTest001();
		HttpResult valueCreditCardServiceSetPrimarySoapResponse = (serviceCall.setCreditCardServiceSetPrimary(valueCreditCardServiceSetPrimaryEndpointURL, valueCreditCardServiceSetPrimarySoapAction, valueCreditCardServiceSetPrimarySoapEnvelopePart1, valueCreditCardServiceSetPrimarySoapEnvelopePart2, valueCreditCardServiceSetPrimarySoapEnvelopePart3, valueCreditCardServiceSetPrimarySoapEnvelopePart4, valueCreditCardServiceSetPrimaryID, valueCreditCardServiceSetPrimaryFingerprint, valueCreditCardServiceSetPrimaryCardID));
		return;
	}	

//	@Test
	public void accountManagementTest019WalletServiceFindAll() throws UnsupportedEncodingException	{
		AcctMgmtHttpServiceTest001 serviceCall = new AcctMgmtHttpServiceTest001();
		HttpResult valueWalletServiceFindAllSoapResponse = (serviceCall.setWalletServiceFindAll(valueWalletServiceFindAllEndpointURL, valueWalletServiceFindAllSoapAction, valueWalletServiceFindAllSoapEnvelopePart1, valueWalletServiceFindAllSoapEnvelopePart2, valueWalletServiceFindAllSoapEnvelopePart3, valueWalletServiceFindAllID, valueWalletServiceFindAllFingerprint));
		return;
	}	

}

