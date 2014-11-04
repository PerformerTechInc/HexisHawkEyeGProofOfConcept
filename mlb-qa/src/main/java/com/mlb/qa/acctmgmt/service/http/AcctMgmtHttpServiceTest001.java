package com.mlb.qa.acctmgmt.service.http;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import com.mlb.qa.common.http.HttpHelper;
import com.mlb.qa.common.http.HttpResult;

public class AcctMgmtHttpServiceTest001 {
	private static final Logger logger = Logger.getLogger(AcctMgmtHttpServiceTest001.class);
//	private static final String LOAD_IDENTITY_POINT_BODY_XML_PATTERN = "<?xml version='1.0' encoding='UTF-8'?><SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><SOAP-ENV:Body><tns:identityPoint_identify_request xmlns:tns=\"http://services.bamnetworks.com/registration/types/1.5\"><tns:identification type=\"email-password\"><tns:id xsi:nil=\"true\"/><tns:fingerprint xsi:nil=\"true\"/><tns:email><tns:id xsi:nil=\"true\"/><tns:address>%s</tns:address></tns:email><tns:password>%s</tns:password><tns:mobilePhone xsi:nil=\"true\"/><tns:profileProperty xsi:nil=\"true\"/></tns:identification></tns:identityPoint_identify_request></SOAP-ENV:Body></SOAP-ENV:Envelope>";
	public void setIdentityPointServiceCreate() throws UnsupportedEncodingException {
		String userEmail = "testGmailAccount@gmail.com";
		String userPassword = "test1234";
//		String endpointURL = "https://qaservices.bamnetworks.com/ws/services/IdentityPointService";
		String endpointURL = "https://qasecure.mlb.com/pubajaxws/services/IdentityPointService";
		Map<String, String> postHeaders = new HashMap<String, String>();
		String soapEnvelope = "<?xml version='1.0' encoding='UTF-8'?><SOAP-ENV:Envelope xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\" xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\"><SOAP-ENV:Header><ns0:appCredentials ns0:name=\"account-name\" ns0:password=\"password\" ns0:targetNamespaceId=\"1\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></SOAP-ENV:Header><SOAP-ENV:Body><ns:identityPoint_create_request><ns:identification type=\"email-password\"><ns:email><ns:address>" + userEmail + "</ns:address></ns:email><ns:password>" + userPassword + "</ns:password></ns:identification></ns:identityPoint_create_request></SOAP-ENV:Body></SOAP-ENV:Envelope>";
		int soapEnvelopeLength = soapEnvelope.length();
//		postHeaders.put("Content-Length",Integer.toString(soapEnvelopeLength));
		postHeaders.put("SOAPAction","http://services.bamnetworks.com/registration/identityPoint/create");
//		postHeaders.put("Content-Type","text/xml;");
//		String soapEnvelopeOriginal = "<soapenv:Envelope xmlns:ns=\"http://services.bamnetworks.com/registration/types/1.7\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Header><ns0:appCredentials ns0:name=\"account-name\" ns0:password=\"password\" ns0:targetNamespaceId=\"1\" xmlns:ns0=\"http://services.bamnetworks.com/application/types/1.0\"/></soapenv:Header><soapenv:Body><ns:identityPoint_create_request><ns:identification type=\"email-password\"><ns:email><ns:address>new@mlb.com</ns:address></ns:email><ns:password>password</ns:password></ns:identification></ns:identityPoint_create_request></soapenv:Body></soapenv:Envelope>";
		HttpResult soapResponse = HttpHelper.executePost(endpointURL, postHeaders, soapEnvelope);
		logger.info("SOAP Request: " + soapEnvelope);
		logger.info("SOAP Response: " + soapResponse);
	}

}
