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
public class CheckinHistoryJsonRS {

	@XmlElement(name = "response")
	List<CheckinHistoryItem> checkins;

	public List<CheckinHistoryItem> getCheckins() {
		return checkins;
	}

	public void setCheckins(List<CheckinHistoryItem> checkins) {
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
	public static CheckinHistoryJsonRS unmarshal(String jsonSource) {
		try {
			JAXBContext jc = JAXBContext.newInstance(CheckinHistoryJsonRS.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, Boolean.FALSE);
			unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, MediaType.APPLICATION_JSON);
			return (CheckinHistoryJsonRS) unmarshaller.unmarshal(new StreamSource(new StringReader(jsonSource)),
					CheckinHistoryJsonRS.class).getValue();
		} catch (JAXBException e) {
			throw new TestRuntimeException(
					String.format("Error while unmarshaling json response. Source: %s", jsonSource), e);
		}
	}

}
