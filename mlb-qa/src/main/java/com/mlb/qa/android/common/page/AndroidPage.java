package com.mlb.qa.android.common.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.browserlaunchers.Sleeper;

import com.qaprosoft.carina.core.foundation.webdriver.Screenshot;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class AndroidPage extends AbstractUIObject {
	protected static final Logger logger = Logger.getLogger(Screenshot.class);

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
}
