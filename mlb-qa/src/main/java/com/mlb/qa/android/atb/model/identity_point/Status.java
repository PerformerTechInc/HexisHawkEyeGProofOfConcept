package com.mlb.qa.android.atb.model.identity_point;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.mlb.qa.android.atb.model.Item;

@XmlAccessorType(XmlAccessType.FIELD)
public class Status implements Item {
	@XmlElement(name = "code")
	private Integer code;
	@XmlElement(name = "message")
	private String message;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
