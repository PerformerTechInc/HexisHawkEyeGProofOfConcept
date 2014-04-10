package com.mlb.qa.demo.tiger_woods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class TW_HomePage extends AbstractPage {
	private static String TOUR_NAME = "//a[contains(text(), '%s')]";
	
	@FindBy(xpath="//a[contains(text(), 'News')]")
	public ExtendedWebElement lnkNews;
	

	@FindBy(xpath="//a[contains(text(), 'On Tour')]")
	public ExtendedWebElement lnkOnTour;

	
	
	public TW_HomePage(WebDriver driver) {
		super(driver);
		setPageAbsoluteURL("http://qa2.tigerwoods.com");
		open();
	}
	
	public TW_NewsPage openNews(){
		click(lnkNews);
		
		return new TW_NewsPage(driver);
	}

	
	public TW_TourPage openTour(String tour){
		pause(1);
		hover(lnkOnTour);
		
		ExtendedWebElement lnkTour = new ExtendedWebElement(driver.findElement(By.xpath(String.format(TOUR_NAME, tour))), "lnkTour");
		click(lnkTour);
		

		return new TW_TourPage(driver);
	}
	

}
