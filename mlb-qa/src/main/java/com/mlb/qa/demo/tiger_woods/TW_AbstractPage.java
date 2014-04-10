package com.mlb.qa.demo.tiger_woods;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class TW_AbstractPage extends AbstractPage {
	private int WAIT_TIME = 3;

	public TW_AbstractPage(WebDriver driver) {
		super(driver);
	}

	protected void assertOpened(ExtendedWebElement labelHeader, String header){
		if (isElementPresent(labelHeader, WAIT_TIME)) {
			String text = labelHeader.getText();
			
			Assert.assertTrue("Page '" + header + "' activation is not verified!", text.contains(header));
		}
		else {
			Assert.fail("Page '" + header + "' was not opened!");
		}
	}
	
}
