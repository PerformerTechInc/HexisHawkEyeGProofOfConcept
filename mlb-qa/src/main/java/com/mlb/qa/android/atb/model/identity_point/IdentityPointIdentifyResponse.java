package com.mlb.qa.android.atb.model.identity_point;

import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.mlb.qa.android.atb.model.Item;
import com.mlb.qa.exception.TestRuntimeException;

@XmlRootElement(name = "identityPoint_identify_response")
@XmlType(namespace="http://services.bamnetworks.com/registration/types/1.5")
public class IdentityPointIdentifyResponse implements Item {
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

	/**
	 * Find first occurrence of the identityPoint_identify_response element and
	 * unmarshal
	 * 
	 */
	public static IdentityPointIdentifyResponse unmarshal(String xmlSource) {
		// String responseSource =
		Matcher matcher = Pattern.compile("<identityPoint_identify_response.*</identityPoint_identify_response>",
				Pattern.DOTALL)
				.matcher(xmlSource);
		if (!matcher.find()) {
			throw new TestRuntimeException("No identityPoint_identify_response element found in the source");
		}
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(IdentityPointIdentifyResponse.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext
					.createUnmarshaller();
			String toUnmarshall = matcher.group();
			return (IdentityPointIdentifyResponse) jaxbUnmarshaller.unmarshal(new StringReader(
					toUnmarshall));
		} catch (JAXBException e) {
			throw new TestRuntimeException(
					"Error while unmarshaling identityPoint_identify_response", e);
		}
	}
}
