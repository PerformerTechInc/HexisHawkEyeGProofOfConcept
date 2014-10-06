package com.mlb.qa.atb.web.page;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mlb.qa.atb.model.game_ticket.GameTicket;
import com.mlb.qa.atb.model.game_ticket.TicketLink;
import com.mlb.qa.common.date.DateUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

/**
 * Tickets for games at the Ballpark page
 */
public class AtbBallparkTicketsPage extends AbstractPage {
	private static final Logger logger = Logger.getLogger(AtbBallparkTicketsPage.class);

	private static final String DATE_LOCATOR = "./time/span[contains(@class,'date')]";
	private static final String TIME_LOCATOR = "./time/span[contains(@class,'time')]";
	private static final String OPPONENT_LOCATOR = "./span/h5";
	private static final String BUY_TICKECTS_LINK_LOCATOR = ".//a[text()='Buy Tickets']";
	private static final String ID_ATTR = "id";
	private static final String HREF_ATTR = "href";
	private static final String DATE_FORMAT = "MMM dd, yyyy hh:mm aa";
	private static final String TBD = "TBD";
	private static final String START_OF_DAY_TIME = "03:33 AM";

	@FindBy(xpath = "//div[@class='game-container']")
	private List<ExtendedWebElement> gameContainers;

	public AtbBallparkTicketsPage(WebDriver driver, String url) {
		super(driver);
		pageURL = url;
	}

/*	public static AtbBallparkTicketsPage open(WebDriver driver, String url) {
		logger.info("Open " + url);
		driver.get(url);
		return new AtbBallparkTicketsPage(driver);
	}*/

	/**
	 * Load list of tickets
	 * 
	 * @return
	 */
	public List<GameTicket> loadListOfGameTickets() {
		logger.info("Load list of tickets from page");
		pause(1);
		List<GameTicket> result = new LinkedList<GameTicket>();
		for (ExtendedWebElement container : gameContainers) {
			GameTicket ticket = new GameTicket();
			// event (schedule) id
			ticket.setScheduleId(StringUtils.substringAfter(container.getAttribute(ID_ATTR), "gm"));
			// away team name
			ticket.setAwayNameTeam(new ExtendedWebElement(container.getElement()
					.findElement(By.xpath(OPPONENT_LOCATOR)),
					"Away team name").getText().trim());
			// game date
			String dateStr = new ExtendedWebElement(container.getElement()
					.findElement(By.xpath(DATE_LOCATOR)),
					"Game date").getText().trim();
			String time = new ExtendedWebElement(container.getElement()
					.findElement(By.xpath(TIME_LOCATOR)),
					"Game time").getText().trim();
			if (TBD.equalsIgnoreCase(time)) {
				time = START_OF_DAY_TIME;
			}
			ticket.setDateTimeLocal(DateUtils.parseString(dateStr + " " + time, DATE_FORMAT));
			// tickets link
			List<WebElement> ticketsLinks = container.getElement()
					.findElements(By.xpath(BUY_TICKECTS_LINK_LOCATOR));
			if (!ticketsLinks.isEmpty()) { // link present
				TicketLink tl = new TicketLink();
				tl.setLink((new ExtendedWebElement(ticketsLinks.get(0))).getAttribute(HREF_ATTR));
				ticket.setTicketLink(tl);
			}
			result.add(ticket);
		}
		logger.info("Found tickets: " + result);
		return result;
	}

}
