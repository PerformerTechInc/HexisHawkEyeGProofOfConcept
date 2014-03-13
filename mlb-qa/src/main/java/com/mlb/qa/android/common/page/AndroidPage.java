package com.mlb.qa.android.common.page;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.remote.RemoteWebElement;

import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class AndroidPage extends AbstractUIObject {
	protected static final Logger logger = Logger.getLogger(AndroidPage.class);

	public AndroidPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * 
	 * @return true by default. Override it in child classes
	 */
	public boolean isOpened() {
		return true;
	}

	public void swipeLeft() {
		logger.debug("Swipe left");
		swipe(0.15, 0.5, 0.95, 0.5, 2);
		Sleeper.sleepTight(2000l);
	}

	public void swipeRight() {
		logger.debug("Swipe right");
		swipe(0.95, 0.5, 0.15, 0.5, 2);
		Sleeper.sleepTight(2000l);
	}

	public void swipeUp() {
		logger.debug("Swipe Up");
		swipe(0.5, 0.95, 0.5, 0.05, 2);
		Sleeper.sleepTight(2000l);
	}

	public void swipeDown() {
		logger.debug("Swipe down");
		swipe(0.5, 0.05, 0.5, 0.95, 2);
		Sleeper.sleepTight(2000l);
	}
	
	public void scrollTo(String scrollToText, By containerLocator) {
		logger.info(String.format("Scrolling to text '%s', Scroll container: %s", scrollToText, containerLocator));
		final JavascriptExecutor executor = (JavascriptExecutor) driver;
		final HashMap<String, String> scrollMap = new HashMap<String, String>();
		scrollMap.put("text", scrollToText);
		scrollMap.put("element", ((RemoteWebElement)driver.findElement(containerLocator)).getId());
		executor.executeScript("mobile: scrollTo", scrollMap);
	}
}
