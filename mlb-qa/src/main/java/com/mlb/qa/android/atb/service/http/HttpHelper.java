package com.mlb.qa.android.atb.service.http;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.mlb.qa.exception.TestRuntimeException;

public class HttpHelper {
	private static final Logger logger = Logger.getLogger(HttpHelper.class);

	/**
	 * @param method
	 * @param user
	 * @param password
	 * @param contentEncoding
	 * @return
	 */
	public static HttpResult executeHttpMethod(HttpMethod method, String charset) {
		logger.info("Execute HTTP method: " + method);
		HttpClient client = new HttpClient();
		try {
			client.getParams().setParameter("http.protocol.content-charset",
					charset);
			int responseCode = client.executeMethod(method);
			logger.info("Response code: " + responseCode);
			HttpResult result = new HttpResult();
			result.setResponseCode(responseCode);
			result.setResponseBody(IOUtils.toString(
					method.getResponseBodyAsStream(), charset));
			return result;
		} catch (Exception e) {
			throw new TestRuntimeException("Error while http method execution",
					e);
		}

	}

	/**
	 * Executes POST method and returns response body as String
	 * 
	 */
	public static HttpResult executePostMethod(String url,
			Map<String, String> parameters, Map<String, String> bodyParameters,
			String charset) {
		PostMethod pMethod = new PostMethod(url);
		pMethod.setDoAuthentication(false);
		// parameters
		for (String key : parameters.keySet()) {
			pMethod.addParameter(new NameValuePair(key, parameters.get(key)));
		}
		// body
		if (null != bodyParameters && bodyParameters.size() != 0) {
			List<NameValuePair> bodyAsList = new LinkedList<NameValuePair>();
			for (String param : bodyParameters.keySet()) {
				bodyAsList.add(new NameValuePair(param, bodyParameters
						.get(param)));
			}
			NameValuePair[] body = bodyAsList
					.toArray(new NameValuePair[bodyAsList.size()]);
			pMethod.setRequestBody((NameValuePair[]) body);
		}

		return executeHttpMethod(pMethod, charset);
	}

	public static void checkResult(HttpResult result, int responseCode,
			String bodyRegex) {
		if (responseCode != result.getResponseCode()
				|| !Pattern.compile(bodyRegex, Pattern.DOTALL)
						.matcher(result.getResponseBody()).find()) {
			throw new TestRuntimeException(
					new StringBuilder(
							"Response code or body don't match to expected one. HttpResult: ")
							.append(result)
							.append(", expected response code: ")
							.append(responseCode)
							.append(", required body part regex: ")
							.append(bodyRegex).toString());
		}
	}
}
