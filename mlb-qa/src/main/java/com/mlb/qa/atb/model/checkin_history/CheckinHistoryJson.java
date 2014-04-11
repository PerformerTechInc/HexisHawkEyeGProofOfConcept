package com.mlb.qa.atb.model.checkin_history;

import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.persistence.jaxb.UnmarshallerProperties;
import org.eclipse.persistence.oxm.MediaType;

import com.mlb.qa.common.exception.TestRuntimeException;


/**
 * Load check-in history response bean
 */
public class CheckinHistoryJson {

	@XmlElement(name = "response")
	List<CheckinHistoryJsonItem> checkins;

	public List<CheckinHistoryJsonItem> getCheckins() {
		return checkins;
	}

	public void setCheckins(List<CheckinHistoryJsonItem> checkins) {
		this.checkins = checkins;
	}

	@Override
	public String toString() {
		return "CheckinHistoryRS [checkins=" + checkins + "]";
	}

	/**
	 * Unmarshal from json source
	 * 
	 * @param jsonSource
	 * @return
	 * @throws JAXBException
	 */
	public static CheckinHistoryJson unmarshal(String jsonSource) {
		try {
			JAXBContext jc = JAXBContext.newInstance(CheckinHistoryJson.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, Boolean.FALSE);
			unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, MediaType.APPLICATION_JSON);
			return (CheckinHistoryJson) unmarshaller.unmarshal(new StreamSource(new StringReader(jsonSource)),
					CheckinHistoryJson.class).getValue();
		} catch (JAXBException e) {
			throw new TestRuntimeException(
					String.format("Error while unmarshaling json response. Source: %s", jsonSource), e);
		}
	}

}
