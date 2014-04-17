package com.mlb.qa.atb.model.music.json;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.persistence.jaxb.UnmarshallerProperties;
import org.eclipse.persistence.oxm.MediaType;
import org.eclipse.persistence.oxm.annotations.XmlPath;

import com.mlb.qa.atb.model.Item;
import com.mlb.qa.atb.model.music.Music;
import com.mlb.qa.atb.model.music.MusicCategory;
import com.mlb.qa.common.exception.TestRuntimeException;

public class BallparkMusicJson implements Item {

	public static final String BALLPARK_MUSIC_KEY = "ballpark-music";
	public static final String TITLE_KEY = "title";
	public static final String ARTIST_KEY = "artist";
	public static final String DESCRIPTION_KEY = "description";
	public static final String CATEGORY_KEY = "category";

	public static final String CATEGORY_PLAYER = "Player";
	public static final String CATEGORY_STADIUM = "Stadium";
	public static final String CATEGORY_OTHER = "Other";

	public static final String NOT_AVAILABLE = "N/A";

	@XmlPath("list/item")
	public List<BallparkMusicJsonItem> jsonItems;

	public List<BallparkMusicJsonItem> getJsonItems() {
		return jsonItems;
	}

	/**
	 * Parse list of {@link Music} from JSON
	 * 
	 * @return
	 */
	public List<Music> parseBalparkMusicList() {
		List<Music> musicList = new LinkedList<Music>();
		for (BallparkMusicJsonItem item : jsonItems) {
			if (BALLPARK_MUSIC_KEY.equalsIgnoreCase(item.getItemType().getKey())) {
				Music music = new Music();
				for (BallparkMusicJsonKeyValuePair pair : item.getParameters()) {
					if (TITLE_KEY.equalsIgnoreCase(pair.getKey())) {
						music.setTitle(format(pair.getValue()));
					}
					else if (DESCRIPTION_KEY.equalsIgnoreCase(pair.getKey())) {
						// music.setDescription(format(pair.getValue()));
					}
					else if (ARTIST_KEY.equalsIgnoreCase(pair.getKey())) {
						music.setArtist(format(pair.getValue()));
					}
					else if (CATEGORY_KEY.equalsIgnoreCase(pair.getKey())) {
						if (CATEGORY_PLAYER.equalsIgnoreCase(trim(pair.getValue()))) {
							music.setCategory(MusicCategory.PLAYER);
						}
						else if (CATEGORY_STADIUM.equalsIgnoreCase(trim(pair.getValue()))) {
							music.setCategory(MusicCategory.STADIUM);
						}
						else if (CATEGORY_OTHER.equalsIgnoreCase(trim(pair.getValue()))) {
							music.setCategory(MusicCategory.OTHER);
						}
						else {
							throw new TestRuntimeException("Unknown music category found: " + pair.getValue());
						}
					}
				}
				if (music.getArtist() == null) {
					music.setArtist(NOT_AVAILABLE);
				}
				musicList.add(music);
			}
		}
		return musicList;
	}

	private String format(String source) {
		return com.mlb.qa.common.string.StringUtils.replaceUtf8HtmlCodesWithCharacters(trim(source));
	}

	private String trim(String source) {
		return null == source ? null : source.trim();
	}

	/**
	 * NOTE: as jsonSourceUrl should be correct link (like
	 * 
	 * @param jsonSourceUrl
	 * @return
	 * @throws FileNotFoundException
	 */
	public static BallparkMusicJson unmarshal(String jsonSourceUrl) {
		try {
			JAXBContext jc = JAXBContext.newInstance(BallparkMusicJson.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, Boolean.FALSE);
			unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, MediaType.APPLICATION_JSON);
			unmarshaller.setProperty(UnmarshallerProperties.JSON_ATTRIBUTE_PREFIX, "@");
			unmarshaller.setProperty(UnmarshallerProperties.JSON_VALUE_WRAPPER, "$");
			StreamSource ss = new StreamSource(jsonSourceUrl);
			return (BallparkMusicJson) unmarshaller.unmarshal(ss,
					BallparkMusicJson.class).getValue();
		} catch (JAXBException e) {
			throw new TestRuntimeException(
					String.format("Error while unmarshaling json response. Source: %s", jsonSourceUrl), e);
		}
	}
}
