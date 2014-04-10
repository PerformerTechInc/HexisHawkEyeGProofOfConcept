package com.mlb.qa.demo.tiger_woods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

public class TW_NewsPage extends TW_AbstractPage {

	private final static String HEADER = "NEWS & FEATURES";
	@FindBy(xpath="//*[@id='content']/div/h1")
	public ExtendedWebElement labelHeader;
	
	@FindBy(xpath="//*[@id='content']/div/div/select[1]")
	public ExtendedWebElement selectMonth;
	
	
	public TW_NewsPage(WebDriver driver) {
		super(driver);
		assertOpened(labelHeader, HEADER);
	}


}
