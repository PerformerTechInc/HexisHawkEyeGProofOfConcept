package com.mlb.qa.tests.android.atb;

import org.apache.log4j.Logger;

import com.mlb.qa.android.atb.model.Game;
import com.mlb.qa.android.atb.page.AtbAndroidPage;
import com.mlb.qa.android.atb.page.AtbStartPage;
import com.mlb.qa.android.atb.service.http.AtbHttpService;
import com.mlb.qa.android.atb.service.lookup.AtbLookupService;
import com.mlb.qa.android.atb.utils.AtbParameter;
import com.qaprosoft.carina.core.foundation.UITest;

public abstract class BaseCheckinTest extends UITest {
	protected static final Logger logger = Logger.getLogger(BaseCheckinTest.class);
	protected AtbHttpService httpService;
	protected AtbLookupService lookupService;

	public BaseCheckinTest() {
		super();
		httpService = new AtbHttpService();
		lookupService = new AtbLookupService();
	}

	protected void loginIfNotLogged() {
		AtbStartPage sp = new AtbStartPage(driver);
		if (sp.isOpened()) {
			sp.passToLoginPage()
					.login(AtbParameter.MLB_ATB_DEFAULT_USER.getValue(),
							AtbParameter.MLB_ATB_DEFAULT_PASSWORD.getValue())
					.skipFavoriteTeamSelection();
			;
		}
	}

	protected String detectVenueOnUi(Game game) {
		String venueShort = game.getVenueShort();
		if (null == venueShort || venueShort.isEmpty()) {
			return game.getVenue();
		}
		return venueShort;
	}

	protected void openCheckinWindow() {
		new AtbAndroidPage(driver).openCheckinWindow();
	}
}
