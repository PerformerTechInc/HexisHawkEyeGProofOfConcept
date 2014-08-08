package com.mlb.qa.atb.web.page;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mlb.qa.atb.model.game_promotion.GamePromotion;
import com.mlb.qa.atb.model.game_promotion.Promotion;
import com.mlb.qa.common.date.DateUtils.Month;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.Configuration.Parameter;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

@SuppressWarnings("unused")
public class AtbBallparkPromotionsPage extends AbstractPage {
	private static final Logger logger = Logger.getLogger(AtbBallparkPromotionsPage.class);
	// promo item
	private static final String PROMOTION_CONTAINER_LOCATOR = ".//div[@class='promo-details-item']";
	private static final String OFFER_NAME_LOCATOR = ".//h7";
	private static final String DESCRIPTION_LOCATOR = ".//p[not (starts-with(.,'Presented By '))]";
			
	private static final String PRESENTED_BY_LOCATOR = ".//p[starts-with(.,'Presented By ')]";
	// Buy tickets link
	private static final String BUY_TICKETS_LINK_LOCATOR = ".//a[text()='Buy Tickets']";
	private static final String HREF_ATTR = "href";
	// away team
	private static final String OPPONENT_LOCATOR = ".//*[@class='promo-details-opponent']";
	// date
	private static final String DAY_LOCATOR = ".//div[@class='promo-date-number']";

	private static final String PRESENTED_BY = "Presented By ";

	@FindBy(xpath = "//nav[@class='nav-pagination']//li/h5")
	private ExtendedWebElement monthYearLabel;
	// game promotion containers
	@FindBy(xpath = "//*[@id='promotions']/ul/li[not(contains(h6,'Promotion'))]")
	private List<ExtendedWebElement> gamePromotionContainers;

	public AtbBallparkPromotionsPage(WebDriver driver) {
		super(driver);
	}

	public static AtbBallparkPromotionsPage open(WebDriver driver, String url) {
		logger.info("Open " + url);
		driver.get(url);
		return new AtbBallparkPromotionsPage(driver);
	}

	public List<GamePromotion> loadListOfGamePromotions() {
		logger.info("Load list of game promotions");
		pause(1);
		// get year and month
		String monthYear = monthYearLabel.getText().trim();
		int year = Integer.parseInt(StringUtils.substringAfter(monthYear, " "));
		int month = Month.getMonthOfYearByFullName(StringUtils.substringBefore(monthYear, " "));
		List<GamePromotion> gamePromotions = new LinkedList<GamePromotion>();
		logger.info("gamePromotionContainers size: " + gamePromotionContainers.size());
		
		for (ExtendedWebElement gamePromotionContainer : gamePromotionContainers) {
			GamePromotion gamePromotion = new GamePromotion();
			int day = Integer.parseInt((new ExtendedWebElement(gamePromotionContainer.getElement().findElement(
					By.xpath(DAY_LOCATOR)))).getText());
			LOGGER.info("gamePromotionContainer text: " + gamePromotionContainer.getText());
			gamePromotion.setGameDate(new DateTime(year, month, day, 0, 0));
			gamePromotion.setAwayNameTeam(StringUtils.substringAfter(
					getTextIfPresent(gamePromotionContainer, OPPONENT_LOCATOR), "vs. "));
			String href = getAttributeIfElementPresent(gamePromotionContainer, BUY_TICKETS_LINK_LOCATOR, HREF_ATTR);
			List<Promotion> promotions = new LinkedList<Promotion>();
			for (WebElement promoItemContainer : gamePromotionContainer.getElement().findElements(
					By.xpath(PROMOTION_CONTAINER_LOCATOR))) {
				LOGGER.info("promoItemContainer text: " + promoItemContainer.getText());
				Promotion promotion = new Promotion();
//				promotion.setDescription(getTextIfPresent(new ExtendedWebElement(promoItemContainer),
//						DESCRIPTION_LOCATOR));
				promotion.setPresentedBy(StringUtils.substringAfter(
						getTextIfPresent(new ExtendedWebElement(promoItemContainer),
								PRESENTED_BY_LOCATOR), PRESENTED_BY));
				promotion
						.setOfferName(getTextIfPresent(new ExtendedWebElement(promoItemContainer), OFFER_NAME_LOCATOR));
				promotion.setTlink(href);
				promotions.add(promotion);
			}
			gamePromotion.setPromotions(promotions);
			gamePromotions.add(gamePromotion);
		}
		logger.info("Found promotions: " + gamePromotions);
		return gamePromotions;
	}

	private String getTextIfPresent(ExtendedWebElement container, String nestedLocator) {
		String text = "";
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			List<WebElement> foundElements = container.getElement().findElements(By.xpath(nestedLocator));
			if (!foundElements.isEmpty()) {
				text = (new ExtendedWebElement(foundElements.get(0))).getText();
			}
		} finally {
			driver.manage().timeouts()
					.implicitlyWait(Configuration.getLong(Parameter.IMPLICIT_TIMEOUT), TimeUnit.SECONDS);
		}
		return text;
	}

	private String getAttributeIfElementPresent(ExtendedWebElement container, String nestedLocator, String attribute) {
		String text = "";
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			List<WebElement> foundElements = container.getElement().findElements(By.xpath(nestedLocator));
			if (!foundElements.isEmpty()) {
				text = (new ExtendedWebElement(foundElements.get(0))).getAttribute(attribute);
			}
		} finally {
			driver.manage().timeouts()
					.implicitlyWait(Configuration.getLong(Parameter.IMPLICIT_TIMEOUT), TimeUnit.SECONDS);
		}
		return text;
	}
}
