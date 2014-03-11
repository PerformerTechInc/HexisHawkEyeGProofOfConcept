package com.mlb.qa.tests.android.atb;

import org.testng.annotations.Test;

import com.mlb.qa.android.atb.exception.CheckInUnavailableException;
import com.mlb.qa.android.atb.page.AtbAndroidPage;
import com.qaprosoft.carina.core.foundation.UITest;

public class AtbCheckInTest extends UITest {

	// temporary test to check implemented pages
	@Test(expectedExceptions = CheckInUnavailableException.class)
	public void openCheckinPage() {
		new AtbAndroidPage(driver).openBallparksFromMenu()
				.openBallparkByName("Angel Stadium").openCheckInPage();
	}
}
