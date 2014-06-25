package com.mlb.qa.at_bat.model.standings;

import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.mlb.qa.atb.model.Item;

import org.apache.log4j.Logger;

import com.mlb.qa.common.exception.TestRuntimeException;

@XmlRootElement(name = "standings_all_date")
public class QueryStandingsRS {
	private static final Logger logger = Logger.getLogger(QueryStandingsRS.class);	
	
	@XmlElement(name = "row")
	List<Standings> standingsList;

	public List<Standings> getStandingsList() {
		return standingsList;
	}

	@Override
	public String toString() {
		return "QueryStandingsRS [standingsList=" + standingsList + "]";
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Item> List<T> unmarshal(
			String source) {
		List<T> result = new LinkedList<T>();
		
		Matcher firstMatch = Pattern.compile("<standings_all_date[^<]*/>", Pattern.DOTALL)
				.matcher(source);

		Matcher matcher = Pattern.compile("<row[^<]*/>", Pattern.DOTALL)
			.matcher(source);
		try {
			while (firstMatch.find()) {
				logger.info("Found?");
			}
			while (matcher.find()) {
				JAXBContext jaxbContext = JAXBContext.newInstance(Standings.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext
						.createUnmarshaller();
				result.add((T) jaxbUnmarshaller.unmarshal(new StringReader(
						matcher.group())));
			}
		} catch (JAXBException e) {
			throw new TestRuntimeException(
					String.format("Error while unmarshaling xml response. Error: %s", e.getMessage()), e);
		}  
		return result;
	}
}
