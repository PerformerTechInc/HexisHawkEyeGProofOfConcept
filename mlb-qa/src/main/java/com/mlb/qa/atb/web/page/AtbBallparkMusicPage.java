package com.mlb.qa.atb.web.page;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.mlb.qa.atb.model.music.Music;
import com.mlb.qa.atb.model.music.MusicCategory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class AtbBallparkMusicPage extends AbstractPage {
	public static final String PLAYER_RELATIVE_PATH = "./h3";
	public static final String TITLE_RELATIVE_PATH = "./h4";
	public static final String ARTIST_RELATIVE_PATH = "./h5";

	@FindBy(how = How.XPATH, using = "//section[contains(@class, 'music_Player')]//div[@class='info']")
	private List<ExtendedWebElement> playerMusicListContainers;
	@FindBy(how = How.XPATH, using = "//section[contains(@class, 'music_Stadium')]//div[@class='info']")
	private List<ExtendedWebElement> stadiumMusicListContainers;
	@FindBy(how = How.XPATH, using = "//section[contains(@class, 'music_Other')]//div[@class='info']")
	private List<ExtendedWebElement> otherMusicListContainers;
	
	public AtbBallparkMusicPage(WebDriver driver) {
		super(driver);
	}

	public static AtbBallparkMusicPage open(WebDriver driver, String url) {
		driver.get(url);
		return new AtbBallparkMusicPage(driver);
	}

	public List<Music> loadMusicList() {
		List<Music> musicList = new LinkedList<Music>();
		for (ExtendedWebElement container : playerMusicListContainers) {
			musicList.add(loadMusicFromContainer(container, MusicCategory.PLAYER));
		}
		for (ExtendedWebElement container : stadiumMusicListContainers) {
			musicList.add(loadMusicFromContainer(container, MusicCategory.STADIUM));
		}
		for (ExtendedWebElement container : otherMusicListContainers) {
			musicList.add(loadMusicFromContainer(container, MusicCategory.OTHER));
		}
		return musicList;
	}

	private Music loadMusicFromContainer(ExtendedWebElement container, MusicCategory category) {
		Music music = new Music();
		//music.setDescription(new ExtendedWebElement(container.getElement().findElement(
		//		By.xpath(PLAYER_RELATIVE_PATH)),
		//		"Description").getText());
		music.setTitle(new ExtendedWebElement(container.getElement().findElement(By.xpath(TITLE_RELATIVE_PATH)),
				"Title").getText());
		music.setArtist(new ExtendedWebElement(container.getElement().findElement(By.xpath(ARTIST_RELATIVE_PATH)),
				"Artist").getText());
		music.setCategory(category);
		return music;
	}

}
