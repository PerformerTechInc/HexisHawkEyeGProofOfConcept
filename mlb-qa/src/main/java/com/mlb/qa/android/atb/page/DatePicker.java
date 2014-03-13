package com.mlb.qa.android.atb.page;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.mlb.qa.android.atb.utils.DateUtils.Month;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

/**
 * Date Picker<br>
 */
public class DatePicker extends AbstractUIObject {
	private static final Logger logger = Logger.getLogger(DatePicker.class);

	@FindBy(xpath = "//NumberPicker[1]/EditText")
	private ExtendedWebElement monthInput;
	@FindBy(xpath = "//NumberPicker[2]/EditText")
	private ExtendedWebElement dayInput;
	@FindBy(xpath = "//NumberPicker[3]/EditText")
	private ExtendedWebElement yearInput;
	@FindBy(xpath = "//NumberPicker[1]/Button[2]")
	private ExtendedWebElement nextMonth;
	@FindBy(xpath = "//NumberPicker[1]/Button[1]")
	private ExtendedWebElement prevMonth;
	@FindBy(xpath = "//NumberPicker[2]/Button[2]")
	private ExtendedWebElement nextDay;
	@FindBy(xpath = "//NumberPicker[2]/Button[1]")
	private ExtendedWebElement prevDay;
	@FindBy(xpath = "//NumberPicker[3]/Button[2]")
	private ExtendedWebElement nextYear;
	@FindBy(xpath = "//NumberPicker[3]/Button[1]")
	private ExtendedWebElement prevYear;
	@FindBy(id = "android:id/button1")
	private ExtendedWebElement doneButton;

	public DatePicker(WebDriver driver) {
		super(driver);
	}

	/**
	 * Select specified date in date picker and close dialog page
	 * 
	 * @param date
	 */
	public void selectDate(DateTime date) {
		// month
		Integer currentMonth = Month.getMonthOfYearByShortName(monthInput
				.getAttribute("text"));
		Integer requiredMonth = date.getMonthOfYear();
		selectDatePart(nextMonth, prevMonth, requiredMonth - currentMonth,
				"month");
		// day
		Integer currentDay = Integer.parseInt(dayInput.getAttribute("text"));
		Integer requiredDay = date.getDayOfMonth();
		selectDatePart(nextDay, prevDay, requiredDay - currentDay, "day");
		// year
		Integer requiredYear = date.getYear();
		Integer currentYear = Integer.parseInt(yearInput.getAttribute("text"));
		selectDatePart(nextYear, prevYear, requiredYear - currentYear, "year");
		click(doneButton);
	}

	private void selectDatePart(ExtendedWebElement nextButton,
			ExtendedWebElement prevButton, Integer diff, String option) {
		if (diff > 0) {
			logger.debug(new StringBuilder("Move ").append(option)
					.append(" picker to  ").append(diff)
					.append(" positions forward").toString());
			for (int i = 0; i < diff; i++) {
				click(nextButton);
			}
		} else {
			logger.debug(new StringBuilder("Move ").append(option)
					.append(" picker to  ").append(-diff)
					.append(" positions back").toString());
			for (int i = 0; i > diff; i--) {
				click(prevButton);
			}
		}
	}
}
