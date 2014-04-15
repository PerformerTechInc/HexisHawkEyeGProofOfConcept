package com.mlb.qa.atb.model.game_ticket;

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
public class QueryGameTicketsRS {

	@XmlElement(name = "game")
	private List<GameTicket> gameTickets;

	public List<GameTicket> getGameTickets() {
		return gameTickets;
	}

	@Override
	public String toString() {
		return "QueryGameTicketsRS [gameTickets=" + gameTickets + "]";
	}

	public static QueryGameTicketsRS unmarshal(String source) {
		try {
			JAXBContext jc = JAXBContext.newInstance(QueryGameTicketsRS.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			return (QueryGameTicketsRS) unmarshaller.unmarshal(new StreamSource(new StringReader(source)),
					QueryGameTicketsRS.class).getValue();
		} catch (JAXBException e) {
			throw new TestRuntimeException(
					String.format("Error while unmarshaling xml response. Source: %s", source), e);
		}
	}
}
