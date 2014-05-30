package com.mlb.qa.atb.android.page.history;

import com.mlb.qa.atb.AtbHistoryItem;
import com.mlb.qa.atb.android.page.AtbAndroidPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class AtbHistoryMainPage extends AtbAndroidPage {

    @FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/ballpark_name")
    private ExtendedWebElement ballparkName;

    @FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/checkinDay")
    private ExtendedWebElement date;

    @FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/checkinMonth")
    private ExtendedWebElement month;

    @FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/checkinYear")
    private ExtendedWebElement year;

    @FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/menu_add_checkin")
    private ExtendedWebElement addButton;

    @FindBy(xpath = "//TextView[@text='History']")
    private ExtendedWebElement pageHeader;

    @FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/ballpark_score_container")
    private ExtendedWebElement historyContainer;

    public AtbHistoryMainPage(WebDriver driver) {
        super(driver);
    }


    public List<AtbHistoryItem> getListOfHistoryItems() {
        List<WebElement> ballparkNames = driver.findElements(ballparkName.getBy());

        List<WebElement> dates = driver.findElements(date.getBy());

        List<WebElement> months = driver.findElements(month.getBy());

        List<WebElement> years = driver.findElements(year.getBy());

        List<AtbHistoryItem> atbHistoryItems = new ArrayList<AtbHistoryItem>();

        if (ballparkNames.size() == dates.size() && ballparkNames.size() == months.size() && ballparkNames.size() == years.size()) {
            for (int i = 0; i < ballparkNames.size(); i++) {
                AtbHistoryItem atbHistoryItem = new AtbHistoryItem();
                Map<String, String> map = splitName(ballparkNames.get(i).getText());
                atbHistoryItem.setBallpark_name(map.get("name"));
                atbHistoryItem.setCity(map.get("city") + " ");
                atbHistoryItem.setCheckinDate(months.get(i).getText() + " " + dates.get(i).getText() + " " + years.get(i).getText());
                atbHistoryItems.add(atbHistoryItem);
            }
        }
        return atbHistoryItems;
    }

    public AtbAddGamePage getAtbAddGamePage() {
        click(addButton);
        return new AtbAddGamePage(driver);
    }

    public AtbEventDetailsPage getRandomEvent() {
        List<WebElement> items = driver.findElements(historyContainer.getBy());
        Random random = new Random();
        WebElement webElement = items.get(random.nextInt(items.size() - 1));
        logger.info("Click on random Ballpark: " + webElement.findElement(ballparkName.getBy()).getText());
        webElement.click();
        return new AtbEventDetailsPage(driver);
    }

    private Map<String, String> splitName(String name) {
        String[] parts = name.split(", ");
        Map<String, String> map = new HashMap<String, String>();
        map.put("city", parts[1] + ", " + parts[2]);
        map.put("name", parts[0]);
        return map;

    }

    @Override
    public boolean isOpened() {
        return isElementPresent(pageHeader, 10);
    }


}
