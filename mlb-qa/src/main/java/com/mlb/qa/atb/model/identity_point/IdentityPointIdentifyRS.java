package com.mlb.qa.atb.model.identity_point;

import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.mlb.qa.atb.model.Item;
import com.mlb.qa.common.exception.TestRuntimeException;

/**
 * Java bean for mapping of the identityPoint_identify_response<br>
 * 
 */
@XmlRootElement(name = "identityPoint_identify_response")
public class IdentityPointIdentifyRS implements Item {
	@XmlElement(name = "identification", required = false)
	private IdentityPoint identityPoint;
	@XmlElement(name = "status")
	private Status status;

	public IdentityPoint getIdentityPoint() {
		return identityPoint;
	}

	public void setIdentityPoint(IdentityPoint identityPoint) {
		this.identityPoint = identityPoint;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "IdentityPointIdentifyResponse [identityPoint=" + identityPoint + ", status=" + status + "]";
	}

	/**
	 * Find first occurrence of the identityPoint_identify_response element and
	 * unmarshal
	 * 
	 */
	public static IdentityPointIdentifyRS unmarshal(String xmlSource) {
		// String responseSource =
		Matcher matcher = Pattern.compile("<identityPoint_identify_response.*</identityPoint_identify_response>",
				Pattern.DOTALL)
				.matcher(xmlSource);
		if (!matcher.find()) {
			throw new TestRuntimeException("No identityPoint_identify_response element found in the source");
		}
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(IdentityPointIdentifyRS.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext
					.createUnmarshaller();
			return (IdentityPointIdentifyRS) jaxbUnmarshaller.unmarshal(new StringReader(
					matcher.group()));
		} catch (JAXBException e) {
			throw new TestRuntimeException(
					String.format("Error while unmarshaling identityPoint_identify_response. Source: %s", xmlSource), e);
		}
	}
}
