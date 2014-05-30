package com.mlb.qa.atb.android.page.journal;

import com.mlb.qa.atb.AtbHistoryItem;
import com.mlb.qa.atb.android.page.AtbAndroidPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AtbJournalPage extends AtbAndroidPage {

    @FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/ballpark_name")
    private ExtendedWebElement ballparkName;

    @FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/city")
    private ExtendedWebElement city;

    @FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/checkinDate")
    private ExtendedWebElement checkinDate;


    public AtbJournalPage(WebDriver driver) {
        super(driver);
    }

    public List<AtbHistoryItem> getListOfHistoryItems() {
        List<WebElement> ballparkNames = driver.findElements(ballparkName.getBy());

        List<WebElement> cities = driver.findElements(city.getBy());

        List<WebElement> checkinDates = driver.findElements(checkinDate.getBy());

        List<AtbHistoryItem> atbHistoryItems = new ArrayList<AtbHistoryItem>();

        if (ballparkNames.size() == cities.size() && ballparkNames.size() == checkinDates.size()) {
            for (int i = 0; i < ballparkNames.size(); i++) {
                AtbHistoryItem atbHistoryItem = new AtbHistoryItem();
                atbHistoryItem.setBallpark_name(ballparkNames.get(i).getText());
                atbHistoryItem.setCity(cities.get(i).getText());
                atbHistoryItem.setCheckinDate(getDateString(checkinDates.get(i).getText()));
                atbHistoryItems.add(atbHistoryItem);
            }
        }
        return atbHistoryItems;
    }

    private String getDateString(String stringFromUi){

        String [] splitParams = stringFromUi.split(", ");
        if(splitParams.length==3){
            return splitParams[1]+ " " + splitParams[2];
        }
    return null;
    }

}
