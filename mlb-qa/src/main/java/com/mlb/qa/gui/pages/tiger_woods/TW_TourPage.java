package com.mlb.qa.gui.pages.tiger_woods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

public class TW_TourPage extends TW_AbstractPage {
	private final static String HEADER = "ON TOUR: TIGER VS. JACK";
	
	//@FindBy(xpath="//*[@id='content']/div/div/h2")
	@FindBy(xpath="//*[@id='content']/div/div/h1")
	
	public ExtendedWebElement labelHeader;
	

	public TW_TourPage(WebDriver driver) {
		super(driver);
		assertOpened(labelHeader, HEADER);
	}

}
