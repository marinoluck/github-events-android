package com.premise.eventsapi.services.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.premise.eventsapi.services.RestService;

/**
 * RestServiceSimpleImpl
 * It is a class that encapsulates how http requests (get or post) are performed. 
 * It uses org.apache.http classes included in the android api
 * @author luck
 *
 */
public class RestServiceSimpleImpl implements RestService {

	private final static int GET = 1;
	private final static int POST = 2;
	protected String baseUrl = "";
	static String response = null;
	
	/**
	 * Configures the base url and initialize the service.
	 * @param baseUrlApi
	 */
	public RestServiceSimpleImpl(String baseUrlApi) 
	{
		configure(baseUrlApi);
	}
	
	public RestServiceSimpleImpl() 
	{
	
	}
	
	public String post(String method) {
		return this.makeServiceCall(baseUrl + method, POST, null);
	}
	
	public String post(String method, List<NameValuePair> params) {
		return this.makeServiceCall(baseUrl + method, POST, params);
	}
	
	public String get(String method) {
		return this.makeServiceCall(baseUrl + method, GET, null);
	}
	
	public String get(String method, List<NameValuePair> params) {
		return this.makeServiceCall(baseUrl + method, GET, params);
	}
	
	/**
	 * Making service call
	 * 
	 * @url - url to make request
	 * @method - http request method
	 * @params - http request params
	 * */
	private String makeServiceCall(String url, int method,
			List<NameValuePair> params) {
		
		try {
			// http client
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpEntity httpEntity = null;
			HttpResponse httpResponse = null;

			// Checking http request method type
			if (method == POST) {
				HttpPost httpPost = new HttpPost(url);
				// adding post params
				if (params != null) {
					httpPost.setEntity(new UrlEncodedFormEntity(params));
				}

				httpResponse = httpClient.execute(httpPost);

			} else if (method == GET) {
				// appending params to url
				if (params != null) {
					String paramString = URLEncodedUtils
							.format(params, "utf-8");
					url += "?" + paramString;
				}
				HttpGet httpGet = new HttpGet(url);

				httpResponse = httpClient.execute(httpGet);

			}
			httpEntity = httpResponse.getEntity();
			response = EntityUtils.toString(httpEntity);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return response;

	}

	@Override
	public void configure(String baseUrlApi) {
		this.baseUrl = baseUrlApi;
		
	}
}