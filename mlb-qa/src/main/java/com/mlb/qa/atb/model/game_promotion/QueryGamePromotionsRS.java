package com.mlb.qa.atb.model.game_promotion;

import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.stream.StreamSource;

import com.mlb.qa.common.exception.TestRuntimeException;

@XmlRootElement(name = "events")
public class QueryGamePromotionsRS {
	@XmlElement(name = "game")
	List<GamePromotion> gamePromotions;

	public List<GamePromotion> getGamePromotions() {
		return gamePromotions;
	}

	@Override
	public String toString() {
		return "QueryGamePromotionsRS [gamePromotions=" + gamePromotions + "]";
	}

	public static QueryGamePromotionsRS unmarshal(String source) {
		try {
			JAXBContext jc = JAXBContext.newInstance(QueryGamePromotionsRS.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			return (QueryGamePromotionsRS) unmarshaller.unmarshal(new StreamSource(new StringReader(source)),
					QueryGamePromotionsRS.class).getValue();
		} catch (JAXBException e) {
			throw new TestRuntimeException(
					String.format("Error while unmarshaling xml response. Source: %s", source), e);
		}
	}
}
