package com.premise.eventsapi.services;

import java.util.List;

import org.apache.http.NameValuePair;

/** 
 * HttpService
 * 
 * @author luck
 *
 */

public interface SimpleHttpService {
	
	final static int GET = 1;
	final static int POST = 2;
	/**
	 * 
	 * @param url
	 * @param method
	 * @return
	 */
	String makeServiceCall(String url, int method);
	/**
	 * 
	 * @param url
	 * @param method
	 * @param params
	 * @return
	 */
	String makeServiceCall(String url, int method,
			List<NameValuePair> params); 

}