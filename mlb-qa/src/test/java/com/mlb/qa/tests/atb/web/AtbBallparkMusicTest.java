package com.mlb.qa.tests.atb.web;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mlb.qa.atb.model.music.Music;
import com.mlb.qa.atb.model.music.MusicComparator;
import com.mlb.qa.atb.model.music.json.BallparkMusicJson;
import com.mlb.qa.atb.web.page.AtbBallparkMusicPage;
import com.mlb.qa.common.comparator.ListComparator;
import com.qaprosoft.carina.core.foundation.UITest;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

/**
 * Check that content of music page for each team is correct<br>
 */
public class AtbBallparkMusicTest extends UITest {

	@Test(dataProvider="excel_ds")
	@Parameters({"team_abbrev", "team_web"})
	public void checkMusicList(String team_abbrev, String team_web) {
		

		//String jsonUrl = "http://m.mlb.com/gen/hb/ballpark-music/sf.json";
		String jsonUrl = Configuration.getEnvArg("mobile_url") + "/gen/hb/ballpark-music/" + team_abbrev.toLowerCase() + ".json";
		
		List<Music> musicUi = AtbBallparkMusicPage.open(driver, team_web).loadMusicList();
		System.out.println(musicUi);
		List<Music> musicBackEnd = BallparkMusicJson.unmarshal(jsonUrl).parseBalparkMusicList();
		System.out.println(musicBackEnd);
		Assert.assertTrue(0 == new ListComparator<Music>(new MusicComparator()).compareContent(musicUi, musicBackEnd),
				"List of music on UI isn't equal to list of music on back end for " + team_abbrev + "; web:" + team_web);
			
	}
}
