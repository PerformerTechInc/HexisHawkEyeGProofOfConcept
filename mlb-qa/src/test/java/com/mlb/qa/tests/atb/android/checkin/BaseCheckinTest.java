package com.mlb.qa.tests.atb.android.checkin;

import java.util.List;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import com.mlb.qa.atb.AtbParameter;
import com.mlb.qa.atb.android.page.AtbAndroidPage;
import com.mlb.qa.atb.android.page.AtbStartPage;
import com.mlb.qa.atb.model.checkin_history.CheckinHistoryJsonItem;
import com.mlb.qa.atb.model.game.Game;
import com.mlb.qa.atb.model.identity_point.IdentityPoint;
import com.mlb.qa.atb.service.http.AtbHttpService;
import com.mlb.qa.atb.service.lookup.AtbLookupService;
import com.mlb.qa.common.comparator.FieldsComparator;
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

	protected boolean isCheckinInHistoryCorrect(Game game, DateTime checkinDate, IdentityPoint identityPoint) {
		List<CheckinHistoryJsonItem> checkins = httpService.loadListOfCheckinsByIdentityPoint(identityPoint.getId(),
				checkinDate, checkinDate);
		boolean result = false;
		if (!checkins.isEmpty()) {
			CheckinHistoryJsonItem latestCheckin = checkins.get(0);
			result = (0 == FieldsComparator.compareFields("Event id (game name)", latestCheckin.getEventName(),
					game.getGameId()));
			result &= (0 == FieldsComparator.compareFields("Checkin status id", latestCheckin.getCheckinStatusId(), 0));
		}
		return result;
	}
}
