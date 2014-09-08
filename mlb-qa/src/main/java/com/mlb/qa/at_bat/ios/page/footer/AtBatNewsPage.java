package com.mlb.qa.at_bat.ios.page.footer;

import com.mlb.qa.at_bat.ios.page.common.AtBatIOSPage;
import com.mlb.qa.at_bat.ios.page.team.AtBatTeamSelectionPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor Vayner on 6/30/14.
 */
public class AtBatNewsPage extends AtBatIOSPage {


    public AtBatNewsPage(WebDriver driver) {
        super(driver);
    }

    public ArrayList<String> getAllNewsTitles() {

        List<WebElement> newsNodes = driver.findElements(By.xpath(""));
        ArrayList<String> titles = new ArrayList<String>();
        for (WebElement newsNode : newsNodes) {
            titles.add(newsNode.getText());
        }
        return titles;
    }
}