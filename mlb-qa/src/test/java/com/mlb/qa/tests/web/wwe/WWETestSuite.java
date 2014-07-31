package com.mlb.qa.tests.web.wwe;

import java.awt.AWTException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mlb.qa.gui.pages.wweproject.WWE_HomePage;
import com.qaprosoft.carina.core.foundation.UITest;

public class WWETestSuite extends UITest {

	//************ SIGN IN OBJECTS ************//	
	public static String mainURL = "https://qasecure.net.wwe.com/enterworkflow.do?flowId=account.login";
	public static String signInEmailAddress = "snehal.chudgar@mlb.com";
	public static String signInPassword = "quxnva4e";
	//************ SIGN IN OBJECTS ************//	

	//************ CREATE NEW ACCOUNT OBJECTS ************//	
	public static long WWETestEmailAddressIncrementor = System.currentTimeMillis();
	public static String valueCreateNewAccountReqFieldProfileFirstName = "FirstName";
	public static String valueCreateNewAccountReqFieldProfileLastName = "LastName";
	public static String valueCreateNewAccountReqFieldProfileEmailAddress = "WWETestEmailAddress+"+WWETestEmailAddressIncrementor+"@gmail.com";
	public static String valueCreateNewAccountReqFieldProfilePassword = "Test1234!";
	public static String valueCreateNewAccountReqFieldProfileConfirmPassword = "Test1234!";
	public static String valueCreateNewAccountReqDropDownListProfileAddressCountry = "US - United States";
	public static String valueCreateNewAccountReqFieldProfileAddressZipCode = "10011";
	public static String valueCreateNewAccountReqDropDownListProfileBirthDateMonth = "1";
	public static String valueCreateNewAccountReqDropDownListProfileBirthDateDay = "1";
	public static String valueCreateNewAccountReqDropDownListProfileBirthDateYear = "1977";
	//************ CREATE NEW ACCOUNT OBJECTS ************//	

	//************ UPDATE CONTACT INFORMATION OBJECTS ************//	
	public static String valueUpdateContactInformationReqFieldProfileFirstName = "UpdateFirstName";
	public static String valueUpdateContactInformationReqFieldProfileLastName = "UpdateFirstName";
	public static String valueUpdateContactInformationReqDropDownListProfileBirthDateMonth = "2";
	public static String valueUpdateContactInformationReqDropDownListProfileBirthDateDay = "2";
	public static String valueUpdateContactInformationReqDropDownListProfileBirthDateYear = "1978";
	public static String valueUpdateContactInformationOptDropDownListProfileGender = "Male";
	public static String valueUpdateContactInformationOptFieldProfileAddressStreet1 = "123 45th Street";
	public static String valueUpdateContactInformationOptFieldProfileAddressStreet2 = "Apt 67";
	public static String valueUpdateContactInformationOptFieldProfileAddressCity = "Brooklyn";
	public static String valueUpdateContactInformationOptDropDownListProfileAddressState = "NY - New York";
	public static String valueUpdateContactInformationOptDropDownListProfileAddressCountry = "US - United States";
	public static String valueUpdateContactInformationReqFieldProfileAddressZipCode = "10029";
	public static String valueUpdateContactInformationOptDropDownListProfileIncome = "$250,000 and up";
	public static String valueUpdateContactInformationOptDropDownListProfileEducation = "Master's Degree";
	public static String valueUpdateContactInformationOptDropDownListProfileEthnicity = "Asian";
	public static String valueUpdateContactInformationOptDropDownListProfileChildrensAgeRange = "13+";
	public static String valueUpdateContactInformationOptDropDownListProfileChildrensGender = "Both";		
	//************ UPDATE CONTACT INFORMATION OBJECTS ************//	

	//************ SUBSCRIBE TO WWE NETWORK OBJECTS ************//	
	public static String valueSubscribeToWWENetworkStepTwoEnterBillingInformationReqFieldFirstName = valueUpdateContactInformationReqFieldProfileFirstName;
	public static String valueSubscribeToWWENetworkStepTwoEnterBillingInformationReqFieldLastName = valueUpdateContactInformationReqFieldProfileLastName;
	public static String valueSubscribeToWWENetworkStepTwoEnterBillingInformationReqFieldAddress1 = valueUpdateContactInformationOptFieldProfileAddressStreet1;
	public static String valueSubscribeToWWENetworkStepTwoEnterBillingInformationOptFieldAddress2 = valueUpdateContactInformationOptFieldProfileAddressStreet2;
	public static String valueSubscribeToWWENetworkStepTwoEnterBillingInformationReqFieldCity = valueUpdateContactInformationOptFieldProfileAddressCity;
	public static String valueSubscribeToWWENetworkStepTwoEnterBillingInformationReqDropDownListState = "NY---New York";
	public static String valueSubscribeToWWENetworkStepTwoEnterBillingInformationReqDropDownListCountry = "US---United States";
	public static String valueSubscribeToWWENetworkStepTwoEnterBillingInformationReqFieldZipCode = valueUpdateContactInformationReqFieldProfileAddressZipCode;
	public static String valueSubscribeToWWENetworkStepTwoEnterBillingInformationReqFieldPhoneNumber = "9177654321";
	public static String valueSubscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodReqFieldCreditCardNumber = "4111111111111111";
	public static String valueSubscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodReqFieldCreditCardSecurityCode = "123";
	public static String valueSubscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodReqFieldCreditCardExpirationMonth = "12";
	public static String valueSubscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodReqFieldCreditCardExpirationYear = "2020";
	//************ SUBSCRIBE TO WWE NETWORK OBJECTS ************//	

	//************ WWE TESTS ************//
	//************ WWE TESTS ************//
	//************ WWE TESTS ************//
	
//	@Test
	public void wweTest000TestFunction() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException 
	{
		WWE_HomePage homePage = new WWE_HomePage(driver);
//		homePage.signIn(signInEmailAddress,signInPassword);
		homePage.getTimestamp();
//		homePage.logout();
		return;
	}	

//	@Test
	public void wweTest001MyAccountSignIn() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException 
	{
		WWE_HomePage homePage = new WWE_HomePage(driver);
		homePage.signIn(signInEmailAddress,signInPassword);
		homePage.homePageBaseState();
		homePage.logout();
		return;
	}	

//	@Test
	public void wweTest002MyAccountSignUp() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException 
	{
		WWE_HomePage homePage = new WWE_HomePage(driver);
		homePage.createNewAccount(valueCreateNewAccountReqFieldProfileFirstName, valueCreateNewAccountReqFieldProfileLastName, valueCreateNewAccountReqFieldProfileEmailAddress, valueCreateNewAccountReqFieldProfilePassword, valueCreateNewAccountReqFieldProfileConfirmPassword, valueCreateNewAccountReqDropDownListProfileAddressCountry, valueCreateNewAccountReqFieldProfileAddressZipCode, valueCreateNewAccountReqDropDownListProfileBirthDateMonth, valueCreateNewAccountReqDropDownListProfileBirthDateDay, valueCreateNewAccountReqDropDownListProfileBirthDateYear);
		homePage.updateContactInformation(valueUpdateContactInformationReqFieldProfileFirstName, valueUpdateContactInformationReqFieldProfileLastName, valueUpdateContactInformationReqDropDownListProfileBirthDateMonth, valueUpdateContactInformationReqDropDownListProfileBirthDateDay, valueUpdateContactInformationReqDropDownListProfileBirthDateYear, valueUpdateContactInformationOptDropDownListProfileGender, valueUpdateContactInformationOptFieldProfileAddressStreet1, valueUpdateContactInformationOptFieldProfileAddressStreet2, valueUpdateContactInformationOptFieldProfileAddressCity, valueUpdateContactInformationOptDropDownListProfileAddressState, valueUpdateContactInformationOptDropDownListProfileAddressCountry, valueUpdateContactInformationReqFieldProfileAddressZipCode, valueUpdateContactInformationOptDropDownListProfileIncome, valueUpdateContactInformationOptDropDownListProfileEducation, valueUpdateContactInformationOptDropDownListProfileEthnicity, valueUpdateContactInformationOptDropDownListProfileChildrensAgeRange, valueUpdateContactInformationOptDropDownListProfileChildrensGender);
		homePage.homePageBaseState();
		homePage.logout();
		return;
	}	

	@Test
	public void wweTest003MyAccountSignUpAndSubscribe() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException 
	{
		WWE_HomePage homePage = new WWE_HomePage(driver);
		homePage.createNewAccount(valueCreateNewAccountReqFieldProfileFirstName, valueCreateNewAccountReqFieldProfileLastName, valueCreateNewAccountReqFieldProfileEmailAddress, valueCreateNewAccountReqFieldProfilePassword, valueCreateNewAccountReqFieldProfileConfirmPassword, valueCreateNewAccountReqDropDownListProfileAddressCountry, valueCreateNewAccountReqFieldProfileAddressZipCode, valueCreateNewAccountReqDropDownListProfileBirthDateMonth, valueCreateNewAccountReqDropDownListProfileBirthDateDay, valueCreateNewAccountReqDropDownListProfileBirthDateYear);
		homePage.updateContactInformation(valueUpdateContactInformationReqFieldProfileFirstName, valueUpdateContactInformationReqFieldProfileLastName, valueUpdateContactInformationReqDropDownListProfileBirthDateMonth, valueUpdateContactInformationReqDropDownListProfileBirthDateDay, valueUpdateContactInformationReqDropDownListProfileBirthDateYear, valueUpdateContactInformationOptDropDownListProfileGender, valueUpdateContactInformationOptFieldProfileAddressStreet1, valueUpdateContactInformationOptFieldProfileAddressStreet2, valueUpdateContactInformationOptFieldProfileAddressCity, valueUpdateContactInformationOptDropDownListProfileAddressState, valueUpdateContactInformationOptDropDownListProfileAddressCountry, valueUpdateContactInformationReqFieldProfileAddressZipCode, valueUpdateContactInformationOptDropDownListProfileIncome, valueUpdateContactInformationOptDropDownListProfileEducation, valueUpdateContactInformationOptDropDownListProfileEthnicity, valueUpdateContactInformationOptDropDownListProfileChildrensAgeRange, valueUpdateContactInformationOptDropDownListProfileChildrensGender);
		homePage.subscribeToWWENetwork();
		homePage.subscribeToWWENetworkStepTwoEnterBillingInformation(valueSubscribeToWWENetworkStepTwoEnterBillingInformationReqFieldFirstName, valueSubscribeToWWENetworkStepTwoEnterBillingInformationReqFieldLastName, valueSubscribeToWWENetworkStepTwoEnterBillingInformationReqFieldAddress1, valueSubscribeToWWENetworkStepTwoEnterBillingInformationOptFieldAddress2, valueSubscribeToWWENetworkStepTwoEnterBillingInformationReqFieldCity, valueSubscribeToWWENetworkStepTwoEnterBillingInformationReqDropDownListState, valueSubscribeToWWENetworkStepTwoEnterBillingInformationReqDropDownListCountry, valueSubscribeToWWENetworkStepTwoEnterBillingInformationReqFieldZipCode, valueSubscribeToWWENetworkStepTwoEnterBillingInformationReqFieldPhoneNumber);
		homePage.subscribeToWWENetworkStepTwoEnterBillingInformationPaymentInformation(valueSubscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodReqFieldCreditCardNumber, valueSubscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodReqFieldCreditCardSecurityCode, valueSubscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodReqFieldCreditCardExpirationMonth, valueSubscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodReqFieldCreditCardExpirationYear);
		homePage.subscribeToWWENetworkStepThreeConfirmSubscription();
//		homePage.homePageBaseState();
//		homePage.logout();
		return;
	}	


	
	
	//************ WWE TESTS ************//
	//************ WWE TESTS ************//
	//************ WWE TESTS ************//


}
