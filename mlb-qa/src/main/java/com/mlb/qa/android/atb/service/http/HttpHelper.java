package com.mlb.qa.android.atb.service.http;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

import com.mlb.qa.exception.TestRuntimeException;
import com.qaprosoft.carina.core.foundation.utils.R;

public class HttpHelper {
	private static final Logger logger = Logger.getLogger(HttpHelper.class);
	public static final String UTF_8_CHARSET = "UTF-8";
	public static final Integer DEFAULT_HTTP_PORT = 80;
	public static final String HTTP_PROXY_HOSTNAME = "http_proxy_host_name";
	public static final String HTTP_PROXY_PORT = "http_proxy_port";

	/**
	 * @param method
	 * @param user
	 * @param password
	 * @param contentEncoding
	 * @return
	 */
	public static HttpResult executeHttpRequest(HttpUriRequest request,
			String charset) {
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
		try {
			HttpResponse response = client.execute(request);
			logger.info("Response: " + response);
			HttpResult result = new HttpResult();
			result.setResponseCode(response.getStatusLine().getStatusCode());
			if (response.getEntity() != null) {
				result.setResponseBody(IOUtils.toString(response.getEntity()
						.getContent()));
			}
			return result;
		} catch (Exception e) {
			throw new TestRuntimeException("Error while http method execution",
					e);
		}

	}

	/**
	 * Executes POST method and returns response body as String
	 * 
	 * @throws UnsupportedEncodingException
	 * 
	 */
	public static HttpResult executePost(String url,
			Map<String, String> parameters, String encoding)
			throws UnsupportedEncodingException {
		HttpPost post = new HttpPost(url);
		// parameters
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		for (String key : parameters.keySet()) {
			nvps.add(new BasicNameValuePair(key, parameters.get(key)));
		}
		post.setEntity(new UrlEncodedFormEntity(nvps, encoding));
		return executeHttpRequest(post, encoding);
	}

	/**
	 * Executes GET method
	 * 
	 * @param url
	 * @param charset
	 * @return
	 */
	public static HttpResult executeGet(String url, String encoding) {
		HttpGet get = new HttpGet(url);
		return executeHttpRequest(get, encoding);
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
