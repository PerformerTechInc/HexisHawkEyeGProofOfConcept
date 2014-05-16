package com.mlb.qa.at_bat.model.roster;

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
import com.mlb.qa.common.exception.TestRuntimeException;

@XmlRootElement(name = "roster_40")
public class QueryPlayerRosterRS {
	@XmlElement(name = "row")
	List<Roster> teamRosters;
	
	public List<Roster> getTeamRosters() {
		return teamRosters;
	}

	@Override
	public String toString() {
		return "QueryPlayerRosterRS [teamRosters=" + teamRosters + "]";
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Item> List<T> unmarshal(
			String source) {
		List<T> result = new LinkedList<T>();

		Matcher matcher = Pattern.compile("<row[^<]*/>", Pattern.DOTALL)
				.matcher(source);
		try {
			while (matcher.find()) {
				JAXBContext jaxbContext = JAXBContext.newInstance(Roster.class);
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
