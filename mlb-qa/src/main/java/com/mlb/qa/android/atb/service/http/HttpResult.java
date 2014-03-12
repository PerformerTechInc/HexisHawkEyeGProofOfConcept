package com.mlb.qa.android.atb.service.http;

public class HttpResult {

	private Integer responseCode;
	private String responseBody;

	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}

	@Override
	public String toString() {
		return "HttpResult [responseCode=" + responseCode + ", responseBody="
				+ responseBody + "]";
	}

}
