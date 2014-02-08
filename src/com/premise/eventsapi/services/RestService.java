package com.premise.eventsapi.services;

import java.util.List;

import org.apache.http.NameValuePair;

/** 
 * HttpService
 * 
 * @author luck
 *
 */

public interface RestService {
	
	/**
	 * Configure the base url to use in service
	 * @param baseUrlApi
	 */
	public void configure(String baseUrlApi);
	
	/**
	 * 
	 * @param method
	 * @return
	 */
	public String post(String method) ;
	/**	
	 * 
	 * @param method
	 * @param params
	 * @return
	 */
	public String post(String method, List<NameValuePair> params) ;
	/**
	 * 
	 * @param method
	 * @return
	 */
	public String get(String method) ;
	/**
	 * 
	 * @param method
	 * @param params
	 * @return
	 */
	public String get(String method, List<NameValuePair> params) ;

}