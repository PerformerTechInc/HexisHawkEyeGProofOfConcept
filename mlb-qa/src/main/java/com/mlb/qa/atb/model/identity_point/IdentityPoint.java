package com.mlb.qa.atb.model.identity_point;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.mlb.qa.atb.model.Item;

@XmlAccessorType(XmlAccessType.FIELD)
public class IdentityPoint implements Item {
	@XmlAttribute(name = "type")
	private String identificationType;
	@XmlElement(name = "id")
	private String id;
	@XmlElement(name = "fingerprint")
	private String fingerPrint;
	@XmlElement(name = "address")
	private Email email;
	@XmlElement(name = "password")
	private String password;

	public String getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(String identificationType) {
		this.identificationType = identificationType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "IdentityPoint [identificationType=" + identificationType + ", id=" + id + ", fingerPrint="
				+ fingerPrint + ", email=" + email + ", password=" + password + "]";
	}
}
