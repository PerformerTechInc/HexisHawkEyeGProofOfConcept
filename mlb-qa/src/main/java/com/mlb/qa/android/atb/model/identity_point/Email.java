package com.mlb.qa.android.atb.model.identity_point;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.mlb.qa.android.atb.model.Item;

@XmlAccessorType(XmlAccessType.FIELD)
public class Email implements Item {
	@XmlElement(name = "id")
	private String id;
	@XmlElement(name = "email")
	private String email;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Email [id=" + id + ", email=" + email + "]";
	}
}
