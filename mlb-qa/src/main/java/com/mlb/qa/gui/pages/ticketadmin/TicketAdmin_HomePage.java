package com.mlb.qa.gui.pages.ticketadmin;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Hashtable;
import java.util.List;

@SuppressWarnings("deprecation")
public class TicketAdmin_HomePage extends AbstractPage {
    private static final Logger logger = Logger.getLogger(TicketAdmin_HomePage.class);

    public TicketAdmin_HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://bamutil.qa.mlb.com/ticketing-admin/login.jsp");
        open();
    }

    private static final String hostName = "https://bamutil.qa.mlb.com/ticketing-admin/login.jsp";

    //************ IDENTIFIER OBJECTS ************//
    //************ IDENTIFIER OBJECTS ************//
    //************ IDENTIFIER OBJECTS ************//

    //************ LOGIN OBJECTS ************//

    @FindBy(name = "uid")
    private ExtendedWebElement fieldUsername;

    @FindBy(name = "password")
    private ExtendedWebElement fieldPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private ExtendedWebElement btnLogin;

    @FindBy(xpath = "//h1[@style='margin-top: 0px;'][contains(text(), 'MLB.com - Ticketing-Admin (QA)')]")
    private ExtendedWebElement bannerTicketingAdminHomePageQA;

    //************ LOGIN OBJECTS ************//

    //************ MENU BAR OBJECTS ************//

    @FindBy(xpath = "//span[@class='v-menubar-menuitem']/span[@class='v-menubar-menuitem-caption'][contains(text(), 'Home')]")
    private ExtendedWebElement btnMenuBarHome;

    @FindBy(xpath = "//span[@class='v-menubar-menuitem v-menubar-menuitem-selected']/span[@class='v-menubar-menuitem-caption'][contains(text(), 'Home')]")
    private ExtendedWebElement btnMenuBarHomeDropDownListHome;

    @FindBy(xpath = "//span[contains(text(), 'Offers')]")
    private ExtendedWebElement btnMenuBarOffers;

    @FindBy(xpath = "//span[contains(text(), 'Create')]")
    private ExtendedWebElement btnMenuBarOffersDropDownListCreate;

    @FindBy(xpath = "//span[contains(text(), 'Search')]")
    private ExtendedWebElement btnMenuBarOffersDropDownListSearch;

    @FindBy(xpath = "//span[contains(text(), 'Offer Plans')]")
    private ExtendedWebElement btnMenuBarOffersDropDownListOfferPlans;

    @FindBy(xpath = "//span[contains(text(), 'Offer Groups')]")
    private ExtendedWebElement btnMenuBarOffersDropDownListOfferGroups;

    @FindBy(xpath = "//span[contains(text(), 'Bulk Import Offers')]")
    private ExtendedWebElement btnMenuBarOffersDropDownListBulkImportOffers;

    @FindBy(xpath = "//span[contains(text(), 'Event Management')]")
    private ExtendedWebElement btnMenuBarEventManagement;

    @FindBy(xpath = "//span[contains(text(), 'Manage Event Mappings')]")
    private ExtendedWebElement btnMenuBarEventManagementDropDownListManageEventMappings;

    @FindBy(xpath = "//span[contains(text(), 'Bulk Update')]")
    private ExtendedWebElement btnMenuBarEventManagementDropDownListBulkUpdate;

    @FindBy(xpath = "//span[contains(text(), 'Bulk Insert')]")
    private ExtendedWebElement btnMenuBarEventManagementDropDownListBulkInsert;

    @FindBy(xpath = "//span[contains(text(), 'Sub Category')]")
    private ExtendedWebElement btnMenuBarEventManagementDropDownListSubCategory;

    @FindBy(xpath = "//span[contains(text(), 'Event ReMapping')]")
    private ExtendedWebElement btnMenuBarEventManagementDropDownListEventReMapping;

    @FindBy(xpath = "//span[contains(text(), 'Pricing')]")
    private ExtendedWebElement btnMenuBarPricing;

    @FindBy(xpath = "//span[contains(text(), 'General Pricing')]")
    private ExtendedWebElement btnMenuBarPricingDropDownListGeneralPricing;

    @FindBy(xpath = "//span[contains(text(), 'Event Pricing')]")
    private ExtendedWebElement btnMenuBarPricingDropDownListEventPricing;

    @FindBy(xpath = "//span[contains(text(), 'General Fees')]")
    private ExtendedWebElement btnMenuBarPricingDropDownListGeneralFees;

    @FindBy(xpath = "//span[contains(text(), 'Event Fees')]")
    private ExtendedWebElement btnMenuBarPricingDropDownListEventFees;

    @FindBy(xpath = "//span[contains(text(), 'Price Cloning')]")
    private ExtendedWebElement btnMenuBarPricingDropDownListPriceCloning;

    @FindBy(xpath = "//span[contains(text(), 'Price Service Access')]")
    private ExtendedWebElement btnMenuBarPricingDropDownListPriceServiceAccess;

    @FindBy(xpath = "//span[contains(text(), 'Manage Sections')]")
    private ExtendedWebElement btnMenuBarPricingDropDownListManageSections;

    @FindBy(xpath = "//span[contains(text(), 'Reporting')]")
    private ExtendedWebElement btnMenuBarReporting;

    @FindBy(xpath = "//span[contains(text(), 'Scheduler')]")
    private ExtendedWebElement btnMenuBarReportingDropDownListScheduler;

    @FindBy(xpath = "//span[contains(text(), 'Middleware')]")
    private ExtendedWebElement btnMenuBarMiddleware;

    @FindBy(xpath = "//span[contains(text(), 'Buyer Type Mapping')]")
    private ExtendedWebElement btnMenuBarMiddlewareDropDownListBuyerTypeMapping;

    @FindBy(xpath = "//span[contains(text(), 'Availability Services Test')]")
    private ExtendedWebElement btnMenuBarMiddlewareDropDownListAvailabilityServicesTest;

    @FindBy(xpath = "//span[contains(text(), 'Other')]")
    private ExtendedWebElement btnMenuBarOther;

    @FindBy(xpath = "//span[contains(text(), 'URL Shortener')]")
    private ExtendedWebElement btnMenuBarOtherDropDownListURLShortener;

    @FindBy(xpath = "//span[contains(text(), 'Hash Generator')]")
    private ExtendedWebElement btnMenuBarOtherDropDownListHashGenerator;

    @FindBy(xpath = "//span[contains(text(), 'Secure Keys')]")
    private ExtendedWebElement btnMenuBarOtherDropDownListSecureKeys;

    @FindBy(xpath = "//span[contains(text(), 'Dynamic Attributes')]")
    private ExtendedWebElement btnMenuBarOtherDropDownListDynamicAttributes;

    @FindBy(xpath = "//span[@class='v-menubar-menuitem']/span[@class='v-menubar-menuitem-caption'][contains(text(), 'Admin')]")
    private ExtendedWebElement btnMenuBarAdmin;

    @FindBy(xpath = "//span[@class='v-menubar-menuitem v-menubar-menuitem-selected']/span[@class='v-menubar-menuitem-caption'][contains(text(), 'Admin')]")
    private ExtendedWebElement btnMenuBarAdminDropDownListAdmin;

   @FindBy(xpath = "//span[contains(text(), 'Customer Service')]")
    private ExtendedWebElement btnMenuBarCustomerService;

   @FindBy(xpath = "//span[contains(text(), 'Integration Support')]")
   private ExtendedWebElement btnMenuBarCustomerServiceDropDownListIntegrationSupport;

   @FindBy(xpath = "//span[contains(text(), 'Error Messaging Threshold Alerts')]")
   private ExtendedWebElement btnMenuBarCustomerServiceDropDownListErrorMessagingThresholdAlerts;

    //************ MENU BAR OBJECTS ************//

    //************ IDENTIFIER OBJECTS ************//
    //************ IDENTIFIER OBJECTS ************//
    //************ IDENTIFIER OBJECTS ************//

    //************ BEGIN FUNCTIONS ************//
    //************ BEGIN FUNCTIONS ************//
    //************ BEGIN FUNCTIONS ************//
    //************ BEGIN FUNCTIONS ************//
    //************ BEGIN FUNCTIONS ************//
    //************ BEGIN FUNCTIONS ************//
    //************ BEGIN FUNCTIONS ************//
    //************ BEGIN FUNCTIONS ************//
    //************ BEGIN FUNCTIONS ************//

    public void testGoogleSearch() {
        driver.get("http://www.google.com/xhtml");
        pause(10);  // Let the user actually see something!
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("ChromeDriver");
        searchBox.submit();
        pause(10);  // Let the user actually see something!
        driver.quit();
    }

    public void login(String username, String password) {
        if (isElementPresent(fieldUsername) == true) {
            type(fieldUsername, username);
            type(fieldPassword, password);
            click(btnLogin);
            Assert.assertTrue("Home Page Header Banner Is Not Found! Login Operation Is Not Successful!", isElementPresent(bannerTicketingAdminHomePageQA, 60));
        }
    }

 
}
