package com.mlb.qa.android.atb.service.http;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

import com.mlb.qa.exception.TestRuntimeException;
import com.qaprosoft.carina.core.foundation.utils.R;

public class HttpHelper {
	private static final Logger logger = Logger.getLogger(HttpHelper.class);

	public static final String UTF_8_CHARSET = "UTF-8";
	public static final Integer DEFAULT_HTTP_PORT = 80;
	public static final String HTTP_PROXY_HOSTNAME = "http.proxyHost";
	public static final String HTTP_PROXY_PORT = "http.proxyPort";
	// Headers
	public static final String HEADER_SOAP_ACTION = "SOAPAction";
	public static final String HEADER_CONTENT_TYPE = "Content-Type";
	// Content types
	public static final String CONTENT_TYPE_XML_UTF_8 = "text/xml; charset=utf-8";
	public static final String CONTENT_TYPE_APPLICATION_JSON = "application/json";

	/**
	 * @param method
	 * @param user
	 * @param password
	 * @param contentEncoding
	 * @return
	 */
	public static HttpResult executeHttpRequest(HttpUriRequest request, Map<String, String> headers) {
		logger.info("Execute HTTP request: " + request);
		DefaultHttpClient client = new DefaultHttpClient();
		// http proxy
		String hostname = R.CONFIG.get(HTTP_PROXY_HOSTNAME);
		if (hostname != null && !"NULL".equalsIgnoreCase(hostname)) {
			Integer port = R.CONFIG.getInt(HTTP_PROXY_PORT);
			port = port == null ? DEFAULT_HTTP_PORT : port;
			HttpHost proxy = new HttpHost(hostname, port);
			client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY,
					proxy);
		}
		for (String header : headers.keySet()) {
			request.addHeader(header, headers.get(header));
		}
		try {
			HttpResponse response = client.execute(request);
			// logger.info("Response: " + response);
			HttpResult result = new HttpResult();
			result.setResponseCode(response.getStatusLine().getStatusCode());
			if (response.getEntity() != null) {
				result.setResponseBody(IOUtils.toString(response.getEntity()
						.getContent()));
			}
			//logger.info("Result: " + result);
			return result;
		} catch (Exception e) {
			throw new TestRuntimeException("Error while http method execution",
					e);
		}

	}

	/**
	 * Executes POST method
	 * 
	 * @param url
	 * @param parameters
	 * @param headers
	 * @param encoding
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static HttpResult executePost(String url,
			Map<String, String> parameters, Map<String, String> headers, String encoding)
			throws UnsupportedEncodingException {
		HttpPost post = new HttpPost(url);
		// parameters
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		for (String key : parameters.keySet()) {
			nvps.add(new BasicNameValuePair(key, parameters.get(key)));
		}
		post.setEntity(new UrlEncodedFormEntity(nvps, encoding));
		return executeHttpRequest(post, headers);
	}

	/**
	 * Executes POST method
	 * 
	 * @param url
	 * @param headers
	 * @param body
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static HttpResult executePost(String url,
			Map<String, String> headers, String body)
			throws UnsupportedEncodingException {
		HttpPost post = new HttpPost(url);
		post.setEntity(new StringEntity(body));
		return executeHttpRequest(post, headers);
	}

	/**
	 * Executes GET method
	 * 
	 * @param url
	 * @param charset
	 * @return
	 */
	public static HttpResult executeGet(String url, Map<String, String> headers) {
		HttpGet get = new HttpGet(url);
		return executeHttpRequest(get, headers);
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

	public static void checkResultOk(HttpResult result) {
		checkResult(result, HttpStatus.SC_OK, ".*");
	}
}
