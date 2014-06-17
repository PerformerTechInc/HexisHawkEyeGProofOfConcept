package com.mlb.qa.atb.android.page.history;

import com.mlb.qa.atb.android.page.AtbAndroidPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 5/30/2014.
 */
public class AtbAddGamePage extends AtbAndroidPage {

    @FindBy(xpath = "//android.widget.TextView[@text='Add Games']")
    private ExtendedWebElement pageHeader;

    @FindBy(className = "android.widget.ListView")
    private ExtendedWebElement listView;

    @FindBy(xpath = "//android.widget.TextView[@text='Home Team *']")
    private ExtendedWebElement homeTeamButtom;

    @FindBy(xpath = "//android.widget.TextView[@text='Away Team']")
    private ExtendedWebElement awayTeamButtom;

    @FindBy(xpath = "//android.widget.TextView[@text='Month']")
    private ExtendedWebElement monthButtom;

    @FindBy(xpath = "//android.widget.TextView[@text='Year *']")
    private ExtendedWebElement yearButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Day']")
    private ExtendedWebElement dayButton;

    @FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/GameSearchFilterFragment_searchButton")
    private ExtendedWebElement searchButton;

    @FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/teams")
    private ExtendedWebElement firstTeam;

    @FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/AddDeleteCheckinFragment_button")
    private ExtendedWebElement addDeleteButton;

    @FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/AddDeleteCheckinFragment_status")
    private ExtendedWebElement addDeleteStatus;

    @FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/menuitem_delete_checkin")
    private ExtendedWebElement deleteButton;

    private static String SEARCH_PAATERN = "//android.widget.TextView[@text='%s']";

    private final static String ERROR_TEXT = "You can only add games that have already been played. Please search again";

    private final static String SUCCESS_TEXT = "Successfully updated";

    public AtbAddGamePage(WebDriver driver) {
        super(driver);
    }

    public void selectHomeTeam(String name) {
        click(homeTeamButtom);
        scrollTo(name, listView);
        WebElement element = driver.findElement(By.xpath(String.format(SEARCH_PAATERN, name)));
        element.click();
    }

    public void selectYear(String year) {
        click(yearButton);
        scrollTo(year, listView);
        WebElement element = driver.findElement(By.xpath(String.format(SEARCH_PAATERN, year)));
        element.click();
    }

    public void selectDay(String day) {
        click(dayButton);
        scrollTo(day, listView);
        WebElement element = driver.findElement(By.xpath(String.format(SEARCH_PAATERN, day)));
        element.click();
    }

    public void selectAwayTeam(String name) {
        click(awayTeamButtom);
        scrollTo(name, listView);
        WebElement element = driver.findElement(By.xpath(String.format(SEARCH_PAATERN, name)));
        element.click();
    }

    public void selectMonth(String month) {
        click(monthButtom);
        scrollTo(month, listView);
        WebElement element = driver.findElement(By.xpath(String.format(SEARCH_PAATERN, month)));
        element.click();
    }

    public void clickSearchAmdSelectGame() {
        click(searchButton);
        pause(5);
        click(firstTeam);
    }

    public void clickAddDeleteButton() {
        click(addDeleteButton);
    }

    public void clickDeleteChekIn() {
        click(deleteButton);
    }

    public boolean checkErrorText() {
        pause(5);
        return addDeleteStatus.getText().contains(ERROR_TEXT);
    }

    public boolean checkSuccessText() {
        return isElementWithTextPresent(addDeleteStatus,SUCCESS_TEXT,20);
    }

    @Override
    public boolean isOpened() {
        return isElementPresent(pageHeader, 10);
    }
}
