package com.mlb.qa.at_bat.model.scoreboard;

import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.stream.StreamSource;

import com.mlb.qa.common.exception.TestRuntimeException;

@XmlRootElement(name = "games")
public class QueryScoreboardRS {
	@XmlElement(name = "game")
	List<ScoreboardGame> gameList;

	public List<ScoreboardGame> getScoreboardGames() {
		return gameList;
	}

	@Override
	public String toString() {
		return "QueryScoreboardRS [gameList=" + gameList + "]";
	}
	
	public static QueryScoreboardRS unmarshal(String source) {
		try {
			JAXBContext jc = JAXBContext.newInstance(QueryScoreboardRS.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			return (QueryScoreboardRS) unmarshaller.unmarshal(new StreamSource(new StringReader(source)),
					QueryScoreboardRS.class).getValue();
		} catch (JAXBException e) {
			throw new TestRuntimeException(
					String.format("Error while unmarshaling xml response. Source: %s", source), e);
		}
	}
}
