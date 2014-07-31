package com.mlb.qa.gui.pages.wweproject;

import net.sf.saxon.exslt.Date;

import org.junit.Assert;
import com.thoughtworks.selenium.DefaultSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.FindBy;
import com.thoughtworks.selenium.*;
import com.qaprosoft.carina.core.foundation.*;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.*;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import com.qaprosoft.carina.core.foundation.http.*;
import com.mlb.qa.atb.AtbParameter;
import com.mlb.qa.common.http.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import java.sql.*;
import java.util.Calendar;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.mlb.qa.atb.AtbParameter;
import com.mlb.qa.atb.model.about.BallparkInformation;
import com.mlb.qa.atb.model.checkin_history.CheckinHistoryJsonItem;
import com.mlb.qa.atb.model.checkin_history.CheckinHistoryJson;
import com.mlb.qa.atb.model.game_promotion.GamePromotion;
import com.mlb.qa.atb.model.game_promotion.QueryGamePromotionsRS;
import com.mlb.qa.atb.model.game_ticket.GameTicket;
import com.mlb.qa.atb.model.game_ticket.QueryGameTicketsRS;
import com.mlb.qa.atb.model.identity_point.IdentityPoint;
import com.mlb.qa.atb.model.identity_point.IdentityPointIdentifyRS;
import com.mlb.qa.common.date.DateUtils;
import com.mlb.qa.common.exception.TestRuntimeException;
import com.mlb.qa.common.http.HttpHelper;
import com.mlb.qa.common.http.HttpResult;


public class WWE_HomePage extends AbstractPage {
	private static final Logger logger = Logger.getLogger(WWE_HomePage.class);

	public WWE_HomePage(WebDriver driver) {
		super(driver);
		setPageAbsoluteURL("https://qasecure.net.wwe.com/enterworkflow.do?flowId=account.login");
		open();
	}
	

	private static final String hostName = "https://qasecure.net.wwe.com";

	//************ SIGN IN OBJECTS ************//	

	@FindBy(id="emailAddress")
	public ExtendedWebElement fieldSignInEmailAddress;

	@FindBy(id="password-login")
	public ExtendedWebElement fieldSignInPassword;
	
	@FindBy(name="submitButton")
	public ExtendedWebElement btnSignInSubmit;

	//************ SIGN IN OBJECTS ************//	

	//************ NAVIGATION OBJECTS ************//	

	@FindBy(xpath="//a[@class='wwe-logo pull-left'][@href='http://www.wwe.com']")
	public ExtendedWebElement btnLogoHomePage;
	
	@FindBy(xpath="//a[@class='display-name'][@href='https://secure.net.wwe.com/enterworkflow.do?flowId=account.profile']")
	public ExtendedWebElement btnLogout;
	
	//************ NAVIGATION OBJECTS ************//	

	//************ CREATE NEW ACCOUNT/CONTACT INFORMATION OBJECTS ************//	

	@FindBy(xpath="//a[@class='btn btn-default'][@role='button'][@href='/enterworkflow.do?flowId=account.register']")
	public ExtendedWebElement btnCreateNewAccount;

	@FindBy(id="profile_firstName")
	public ExtendedWebElement fieldProfileFirstName;

	@FindBy(id="profile_lastName")
	public ExtendedWebElement fieldProfileLastName;

	@FindBy(id="emailAddress")
	public ExtendedWebElement fieldProfileEmailAddress;

	@FindBy(id="password")
	public ExtendedWebElement fieldProfilePassword;
	
	@FindBy(id="password2")
	public ExtendedWebElement fieldProfileConfirmPassword;

	@FindBy(id="profile_birthMonth")
	public ExtendedWebElement dropDownListProfileBirthDateMonth;
	
	@FindBy(id="profile_birthDay")
	public ExtendedWebElement dropDownListProfileBirthDateDay;
	
	@FindBy(id="profile_birthYear")
	public ExtendedWebElement dropDownListProfileBirthDateYear;
	
	@FindBy(name="optin")
	public ExtendedWebElement checkBoxProfileOptIn;
	
	@FindBy(name="terms")
	public ExtendedWebElement checkBoxProfileAgreeToTerms;
	
	@FindBy(name="submitButton")
	public ExtendedWebElement btnProfileSubmit;

	@FindBy(id="profile_gender")
	public ExtendedWebElement dropDownListProfileGender;

	@FindBy(id="address_street1")
	public ExtendedWebElement fieldProfileAddressStreet1;
	
	@FindBy(id="address_street2")
	public ExtendedWebElement fieldProfileAddressStreet2;
	
	@FindBy(id="address_city")
	public ExtendedWebElement fieldProfileAddressCity;
	
	@FindBy(id="address_state")
	public ExtendedWebElement dropDownListProfileAddressState;
	
	@FindBy(id="addressCountry")
	public ExtendedWebElement dropDownListProfileAddressCountry;
	
	@FindBy(id="addressZip")
	public ExtendedWebElement fieldProfileAddressZipCode;
	
	@FindBy(id="income")
	public ExtendedWebElement dropDownListProfileIncome;
	
	@FindBy(id="education")
	public ExtendedWebElement dropDownListProfileEducation;
	
	@FindBy(id="ethnicity")
	public ExtendedWebElement dropDownListProfileEthnicity;
	
	@FindBy(id="childAgeRange")
	public ExtendedWebElement dropDownListProfileChildrensAgeRange;
	
	@FindBy(id="childGender")
	public ExtendedWebElement dropDownListProfileChildrensGender;
	
	@FindBy(name="submitButton")
	public ExtendedWebElement btnProfileUpdateMyProfile;
	
	@FindBy(xpath="//h3[contains(text(), 'My Profile')]")
	public ExtendedWebElement statusMyProfile;

	@FindBy(xpath="//li[contains(text(), 'Profile has been updated.')]")
	public ExtendedWebElement statusProfileHasBeenUpdated;

	//************ CREATE NEW ACCOUNT/CONTACT INFORMATION OBJECTS ************//	

	//************ SUBSCRIBE TO WWE NETWORK OBJECTS ************//	

	@FindBy(xpath="//a[@class='btn btn-default'][@role='button'][@href='http://www.wwe.com/wwenetwork']")
	public ExtendedWebElement btnSubscribeToWWENetworkContinue;

	@FindBy(xpath="//a[@target='_blank'][@title='Get WWE Network (desktop)'][@href='https://secure.net.wwe.com/enterworkflow.do?flowId=commerce.cart.SASOP&keepWfParams=true&voucherCode=WWENET_PURCHASE_VOCHR&sku=8310199913509911151499000&campaignCode=WWENET_PURCHASE_CMPGN']")
	public ExtendedWebElement btnBuyNow;

	@FindBy(xpath="//h1[@class='login']")
	public ExtendedWebElement statusBuyNowPageGettingStarted;
	
	@FindBy(xpath="//h1[contains(text(), 'Step 2: Enter billing information')]")
	public ExtendedWebElement statusBuyNowPageStepTwoEnterBillingInformation;
	
	@FindBy(id="login_email")
	public ExtendedWebElement fieldLoginToSubscribeEmailAddress;
	
	@FindBy(id="login_password")
	public ExtendedWebElement fieldLoginToSubscribePassword;
	
	@FindBy(xpath="//input[@class='bam-button bam-button-primary bam-button-wwe'][@type='submit'][@name='submitButton']")
	public ExtendedWebElement btnLoginToSubscribeLogin;

	@FindBy(id="firstName")
	public ExtendedWebElement fieldSubscribeToWWENetworkStepTwoEnterBillingInformationFirstName;
	
	@FindBy(id="lastName")
	public ExtendedWebElement fieldSubscribeToWWENetworkStepTwoEnterBillingInformationLastName;
	
	@FindBy(id="address1")
	public ExtendedWebElement fieldSubscribeToWWENetworkStepTwoEnterBillingInformationAddress1;
	
	@FindBy(id="address2")
	public ExtendedWebElement fieldSubscribeToWWENetworkStepTwoEnterBillingInformationAddress2;
	
	@FindBy(id="city")
	public ExtendedWebElement fieldSubscribeToWWENetworkStepTwoEnterBillingInformationCity;
	
	@FindBy(id="state")
	public ExtendedWebElement dropDownListSubscribeToWWENetworkStepTwoEnterBillingInformationState;
	
	@FindBy(id="country")
	public ExtendedWebElement dropDownListSubscribeToWWENetworkStepTwoEnterBillingInformationCountry;
	
	@FindBy(id="postalCode")
	public ExtendedWebElement fieldSubscribeToWWENetworkStepTwoEnterBillingInformationZipCode;
	
	@FindBy(id="dayPhone")
	public ExtendedWebElement fieldSubscribeToWWENetworkStepTwoEnterBillingInformationPhoneNumber;
	
	@FindBy(id="auto_renew")
	public ExtendedWebElement checkBoxSubscribeToWWENetworkStepTwoEnterBillingInformationAutoRenew;
	
	@FindBy(xpath="//input[@class='bam-button bam-button-primary bam-button-large bam-button-wwe'][@type='submit'][@value='Continue'][@name='send']")
	public ExtendedWebElement btnSubscribeToWWENetworkStepTwoEnterBillingInformationContinue;

	@FindBy(xpath="//h2[contains(text(), 'Select your Payment Method')]")
	public ExtendedWebElement statusSubscribeToWWENetworkStepTwoEnterBillingInformationContinue;
	
	@FindBy(id="paymentmethod_isPayPal")
	public ExtendedWebElement radioButtonSubscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodPayPal;

	@FindBy(id="paymentmethod_isCreditCard")
	public ExtendedWebElement radioButtonSubscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodCreditCard;

	@FindBy(xpath="//div[@id='iframeDiv']")
	public ExtendedWebElement frameSubscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethod;

	@FindBy(id="new-credit-card")
	public ExtendedWebElement statusSubscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodCreditCardSelected;

	@FindBy(id="ccNumber")
	public ExtendedWebElement fieldSubscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodCreditCardNumber;
	
	@FindBy(id="ccSecurityCode")
	public ExtendedWebElement fieldSubscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodCreditCardSecurityCode;
	
	@FindBy(id="ccMonth")
	public ExtendedWebElement fieldSubscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodCreditCardExpirationMonth;
	
	@FindBy(id="ccYear")
	public ExtendedWebElement fieldSubscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodCreditCardExpirationYear;
	
	@FindBy(id="submitButton")
	public ExtendedWebElement btnSubscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodSubmit;
	
	@FindBy(xpath="//span[contains(text(), 'Thank you! Your order has been confirmed.')]")
	public ExtendedWebElement frameSubscribeToWWENetworkStepThreeConfirmSubscription;

	//************ SUBSCRIBE TO WWE NETWORK OBJECTS ************//	

	
	
	//************ BEGIN FUNCTIONS ************//	
	//************ BEGIN FUNCTIONS ************//	
	//************ BEGIN FUNCTIONS ************//	
	//************ BEGIN FUNCTIONS ************//	
	//************ BEGIN FUNCTIONS ************//	
	//************ BEGIN FUNCTIONS ************//	
	//************ BEGIN FUNCTIONS ************//	
	//************ BEGIN FUNCTIONS ************//	
	//************ BEGIN FUNCTIONS ************//	
	
	public void homePageBaseState() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		if (isElementPresent(btnLogoHomePage) == true) {
			click(btnLogoHomePage);
		}
	}
	
	public void signIn(String signInEmailAddress, String signInPassword) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
//		Boolean doINeedToLogin = (isElementNotPresent(txtUsername));
		if (isElementPresent(fieldSignInEmailAddress) == true) {
		type(fieldSignInEmailAddress, signInEmailAddress);
		type(fieldSignInPassword, signInPassword);
		click(btnSignInSubmit);
		}
	}

	public void logout() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		if (isElementPresent(btnLogout) == true) {
			click(btnLogout);
		}
	}

	public void createNewAccount(String createNewAccountReqFieldProfileFirstName, String createNewAccountReqFieldProfileLastName, String createNewAccountReqFieldProfileEmailAddress, String createNewAccountReqFieldProfilePassword, String createNewAccountReqFieldProfileConfirmPassword, String createNewAccountReqDropDownListProfileAddressCountry, String createNewAccountReqFieldProfileAddressZipCode, String createNewAccountReqDropDownListProfileBirthDateMonth, String createNewAccountReqDropDownListProfileBirthDateDay, String createNewAccountReqDropDownListProfileBirthDateYear) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		if (isElementPresent(btnCreateNewAccount) == true) {
			click(btnCreateNewAccount);
		}
		Assert.assertTrue("Create Account Page was not Successfully Rendered", isElementPresent(fieldProfileFirstName, 60));
		type(fieldProfileFirstName, createNewAccountReqFieldProfileFirstName);
		type(fieldProfileLastName, createNewAccountReqFieldProfileLastName);
		type(fieldProfileEmailAddress, createNewAccountReqFieldProfileEmailAddress);
		type(fieldProfilePassword, createNewAccountReqFieldProfilePassword);
		type(fieldProfileConfirmPassword, createNewAccountReqFieldProfileConfirmPassword);
		select(dropDownListProfileAddressCountry, createNewAccountReqDropDownListProfileAddressCountry);
		type(fieldProfileAddressZipCode, createNewAccountReqFieldProfileAddressZipCode);
		select(dropDownListProfileBirthDateMonth, createNewAccountReqDropDownListProfileBirthDateMonth);
		select(dropDownListProfileBirthDateDay, createNewAccountReqDropDownListProfileBirthDateDay);
		select(dropDownListProfileBirthDateYear, createNewAccountReqDropDownListProfileBirthDateYear);
		click(checkBoxProfileAgreeToTerms);
		click(btnProfileSubmit);
		Assert.assertTrue("Account was not Successfully Created", isElementPresent(statusMyProfile, 60));
	}

	public void getTimestamp() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		long timestamp = System.currentTimeMillis();
	}

	public void updateContactInformation(String updateContactInformationReqFieldProfileFirstName, String updateContactInformationReqFieldProfileLastName, String updateContactInformationReqDropDownListProfileBirthDateMonth, String updateContactInformationReqDropDownListProfileBirthDateDay, String updateContactInformationReqDropDownListProfileBirthDateYear, String updateContactInformationOptDropDownListProfileGender, String updateContactInformationOptFieldProfileAddressStreet1, String updateContactInformationOptFieldProfileAddressStreet2, String updateContactInformationOptFieldProfileAddressCity, String updateContactInformationOptDropDownListProfileAddressState, String updateContactInformationOptDropDownListProfileAddressCountry, String updateContactInformationReqFieldProfileAddressZipCode, String updateContactInformationOptDropDownListProfileIncome, String updateContactInformationOptDropDownListProfileEducation, String updateContactInformationOptDropDownListProfileEthnicity, String updateContactInformationOptDropDownListProfileChildrensAgeRange, String updateContactInformationOptDropDownListProfileChildrensGender) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		Assert.assertTrue("My Profile Page was not Successfully Rendered", isElementPresent(dropDownListProfileGender, 60));
		type(fieldProfileFirstName, updateContactInformationReqFieldProfileFirstName);
		type(fieldProfileLastName, updateContactInformationReqFieldProfileLastName);
		select(dropDownListProfileBirthDateMonth, updateContactInformationReqDropDownListProfileBirthDateMonth);
		select(dropDownListProfileBirthDateDay, updateContactInformationReqDropDownListProfileBirthDateDay);
		select(dropDownListProfileBirthDateYear, updateContactInformationReqDropDownListProfileBirthDateYear);
		select(dropDownListProfileGender, updateContactInformationOptDropDownListProfileGender);
		type(fieldProfileAddressStreet1, updateContactInformationOptFieldProfileAddressStreet1);
		type(fieldProfileAddressStreet2, updateContactInformationOptFieldProfileAddressStreet2);
		type(fieldProfileAddressCity, updateContactInformationOptFieldProfileAddressCity);
		select(dropDownListProfileAddressState, updateContactInformationOptDropDownListProfileAddressState);
		select(dropDownListProfileAddressCountry, updateContactInformationOptDropDownListProfileAddressCountry);
		type(fieldProfileAddressZipCode, updateContactInformationReqFieldProfileAddressZipCode);
		select(dropDownListProfileIncome, updateContactInformationOptDropDownListProfileIncome);
		select(dropDownListProfileEducation, updateContactInformationOptDropDownListProfileEducation);
		select(dropDownListProfileEthnicity, updateContactInformationOptDropDownListProfileEthnicity);
		select(dropDownListProfileChildrensAgeRange, updateContactInformationOptDropDownListProfileChildrensAgeRange);
		select(dropDownListProfileChildrensGender, updateContactInformationOptDropDownListProfileChildrensGender); 
		click(btnProfileUpdateMyProfile);
		Assert.assertTrue("Profile was not Successfully Updated", isElementPresent(statusProfileHasBeenUpdated, 60));
		}

	public void subscribeToWWENetwork() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		Assert.assertTrue("Subscribe button was not Successfully Rendered", isElementPresent(btnSubscribeToWWENetworkContinue, 60));
		if (isElementPresent(btnSubscribeToWWENetworkContinue) == true) {
			click(btnSubscribeToWWENetworkContinue);
			Assert.assertTrue("Buy Now button was not Successfully Rendered", isElementPresent(btnBuyNow, 60));
			driver.get(hostName+"/enterworkflow.do?flowId=commerce.cart.SASOP&keepWfParams=true&voucherCode=WWENET_PURCHASE_VOCHR&sku=8310199913509911151499000&campaignCode=WWENET_PURCHASE_CMPGN&utm_campaign=WWEnetwork&utm_source=WWE&utm_medium=referral&utm_content=%2Fwwenetwork%3Amediabox%3A1Buy%20Now");
		}
	}
	
	public void subscribeToWWENetworkStepTwoEnterBillingInformation(String subscribeToWWENetworkStepTwoEnterBillingInformationReqFieldFirstName, String subscribeToWWENetworkStepTwoEnterBillingInformationReqFieldLastName, String subscribeToWWENetworkStepTwoEnterBillingInformationReqFieldAddress1, String subscribeToWWENetworkStepTwoEnterBillingInformationOptFieldAddress2, String subscribeToWWENetworkStepTwoEnterBillingInformationReqFieldCity, String subscribeToWWENetworkStepTwoEnterBillingInformationReqDropDownListState, String subscribeToWWENetworkStepTwoEnterBillingInformationReqDropDownListCountry, String subscribeToWWENetworkStepTwoEnterBillingInformationReqFieldZipCode, String subscribeToWWENetworkStepTwoEnterBillingInformationReqFieldPhoneNumber) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		Assert.assertTrue("Billing Information Page was not Successfully Rendered", isElementPresent(statusBuyNowPageStepTwoEnterBillingInformation, 60));
		type(fieldSubscribeToWWENetworkStepTwoEnterBillingInformationFirstName, subscribeToWWENetworkStepTwoEnterBillingInformationReqFieldFirstName);
		type(fieldSubscribeToWWENetworkStepTwoEnterBillingInformationLastName, subscribeToWWENetworkStepTwoEnterBillingInformationReqFieldLastName);
		type(fieldSubscribeToWWENetworkStepTwoEnterBillingInformationAddress1, subscribeToWWENetworkStepTwoEnterBillingInformationReqFieldAddress1);
		type(fieldSubscribeToWWENetworkStepTwoEnterBillingInformationAddress2, subscribeToWWENetworkStepTwoEnterBillingInformationOptFieldAddress2);
		type(fieldSubscribeToWWENetworkStepTwoEnterBillingInformationCity, subscribeToWWENetworkStepTwoEnterBillingInformationReqFieldCity);
		select(dropDownListSubscribeToWWENetworkStepTwoEnterBillingInformationState, subscribeToWWENetworkStepTwoEnterBillingInformationReqDropDownListState);
		select(dropDownListSubscribeToWWENetworkStepTwoEnterBillingInformationCountry, subscribeToWWENetworkStepTwoEnterBillingInformationReqDropDownListCountry);
		type(fieldSubscribeToWWENetworkStepTwoEnterBillingInformationZipCode, subscribeToWWENetworkStepTwoEnterBillingInformationReqFieldZipCode);
		type(fieldSubscribeToWWENetworkStepTwoEnterBillingInformationPhoneNumber, subscribeToWWENetworkStepTwoEnterBillingInformationReqFieldPhoneNumber);
		click(btnSubscribeToWWENetworkStepTwoEnterBillingInformationContinue);
		Assert.assertTrue("Billing Information was not accepted", isElementPresent(statusSubscribeToWWENetworkStepTwoEnterBillingInformationContinue, 60));
	}

	public void subscribeToWWENetworkStepTwoEnterBillingInformationPaymentInformation(String subscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodReqFieldCreditCardNumber, String subscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodReqFieldCreditCardSecurityCode, String subscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodReqFieldCreditCardExpirationMonth, String subscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodReqFieldCreditCardExpirationYear) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		click(radioButtonSubscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodCreditCard);
		WebElement paymentHopFrame = frameSubscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethod.getElement().findElement(By.xpath("//iframe[@name='hopFrame']"));
		driver.switchTo().frame(paymentHopFrame);
		Assert.assertTrue("Credit Card Payment was not Successfully Selected", isElementPresent(fieldSubscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodCreditCardNumber, 60));
		type(fieldSubscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodCreditCardNumber, subscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodReqFieldCreditCardNumber);
		type(fieldSubscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodCreditCardSecurityCode, subscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodReqFieldCreditCardSecurityCode);
		select(fieldSubscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodCreditCardExpirationMonth, subscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodReqFieldCreditCardExpirationMonth);
		select(fieldSubscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodCreditCardExpirationYear, subscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodReqFieldCreditCardExpirationYear);
		click(btnSubscribeToWWENetworkStepTwoEnterBillingInformationPaymentMethodSubmit);
	}

	public void subscribeToWWENetworkStepThreeConfirmSubscription() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		Assert.assertTrue("Credit Card Payment was not Successfully Selected", isElementPresent(frameSubscribeToWWENetworkStepThreeConfirmSubscription, 60));
	}
	
	public void loginToSubscribe(String loginToSubscribeEmailAddress, String loginToSubscribePassword) throws InterruptedException, UnsupportedEncodingException, AWTException, IOException	{
		Assert.assertTrue("Subscribe button was not Successfully Rendered", isElementPresent(statusBuyNowPageGettingStarted, 60));
		type(fieldLoginToSubscribeEmailAddress, loginToSubscribeEmailAddress);
		type(fieldLoginToSubscribePassword, loginToSubscribePassword);
		click(btnLoginToSubscribeLogin);
	}

	
	
	
	//************ MANUAL TYPE/CLICK FUNCTIONS ************//	
	//************ MANUAL TYPE/CLICK FUNCTIONS ************//	
	//************ MANUAL TYPE/CLICK FUNCTIONS ************//	

	public void pressA() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
	}
	
	public void pressB() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_B);
		robot.keyRelease(KeyEvent.VK_B);
	}
	
	public void pressC() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
	}
	
	public void pressD() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_D);
		robot.keyRelease(KeyEvent.VK_D);
	}
	
	public void pressE() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_E);
	}
	
	public void pressF() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_F);
		robot.keyRelease(KeyEvent.VK_F);
	}
	
	public void pressG() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_G);
		robot.keyRelease(KeyEvent.VK_G);
	}
	
	public void pressH() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_H);
		robot.keyRelease(KeyEvent.VK_H);
	}
	
	public void pressI() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_I);
		robot.keyRelease(KeyEvent.VK_I);
	}
	
	public void pressJ() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_J);
		robot.keyRelease(KeyEvent.VK_J);
	}
	
	public void pressK() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_K);
		robot.keyRelease(KeyEvent.VK_K);
	}
	
	public void pressL() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_L);
		robot.keyRelease(KeyEvent.VK_L);
	}
	
	public void pressM() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_M);
		robot.keyRelease(KeyEvent.VK_M);
	}
	
	public void pressN() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_N);
	}
	
	public void pressO() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_O);
		robot.keyRelease(KeyEvent.VK_O);
	}
	
	public void pressP() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_P);
		robot.keyRelease(KeyEvent.VK_P);
	}
	
	public void pressQ() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_Q);
		robot.keyRelease(KeyEvent.VK_Q);
	}
	
	public void pressR() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_R);
	}
	
	public void pressS() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);
	}
	
	public void pressT() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_T);
	}
	
	public void pressU() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_U);
		robot.keyRelease(KeyEvent.VK_U);
	}
	
	public void pressV() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
	}
	
	public void pressW() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_W);
		robot.keyRelease(KeyEvent.VK_W);
	}
	
	public void pressX() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_X);
		robot.keyRelease(KeyEvent.VK_X);
	}
	
	public void pressY() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_Y);
		robot.keyRelease(KeyEvent.VK_Y);
	}
	
	public void pressZ() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_Z);
		robot.keyRelease(KeyEvent.VK_Z);
	}
	
	public void press0() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_0);
		robot.keyRelease(KeyEvent.VK_0);
	}
	
	public void press1() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);
	}
	
	public void press2() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_2);
		robot.keyRelease(KeyEvent.VK_2);
	}
	
	public void press3() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_3);
		robot.keyRelease(KeyEvent.VK_3);
	}
	
	public void press4() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_4);
		robot.keyRelease(KeyEvent.VK_4);
	}
	
	public void press5() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_5);
		robot.keyRelease(KeyEvent.VK_5);
	}
	
	public void press6() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_6);
		robot.keyRelease(KeyEvent.VK_6);
	}
	
	public void press7() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_7);
		robot.keyRelease(KeyEvent.VK_7);
	}
	
	public void press8() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_8);
		robot.keyRelease(KeyEvent.VK_8);
	}
	
	public void press9() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_9);
		robot.keyRelease(KeyEvent.VK_9);
	}
	
	public void pressEnter() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void pressPeriod() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PERIOD);
		robot.keyRelease(KeyEvent.VK_PERIOD);
	}
	
	public void pressUp() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
	}
	
	public void pressDown() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
	}
	
	public void pressLeft() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.keyRelease(KeyEvent.VK_LEFT);
	}
	
	public void pressRight() throws AWTException	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);
	}
	
	public void clickPosition(int coordinateX, int coordinateY) throws AWTException	{
		Robot robot = new Robot();
		robot.mouseMove(coordinateX, coordinateY);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	//************ MANUAL TYPE/CLICK FUNCTIONS ************//	





}
