package com.mlb.qa.atb.web.page;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.mlb.qa.atb.model.Music;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class AtbTeamMusicPage extends AbstractPage {

	@FindBy(how = How.XPATH, using = "//div[@class='info']")
	List<ExtendedWebElement> musicListContainers;

	public AtbTeamMusicPage(WebDriver driver) {
		super(driver);
	}

	public static AtbTeamMusicPage open(WebDriver driver, String url) {
		driver.get(url);
		return new AtbTeamMusicPage(driver);
	}

	public List<Music> loadMusicList() {
		List<Music> musicList = new LinkedList<Music>();
		for (ExtendedWebElement container : musicListContainers) {
			Music music = new Music();
			container.getText();
			musicList.add(music);
		}
		return musicList;
	}

}
