package com.premise.eventsapi.services.impl;

import java.util.List;

import android.util.Log;

import com.premise.eventsapi.models.EventModel;
import com.premise.eventsapi.services.GitHubEventsService;
import com.premise.eventsapi.services.RestService;

public class GitHubEventsServiceImpl implements GitHubEventsService {
	
	// base url
	private static final String API_URL = "https://api.github.com";
	// To List public events
	private static String EVENTS_METHOD = "/events";
	RestService restService = new RestServiceSimpleImpl(API_URL);
	
	@Override
	public List<EventModel> getEvents() {
		
		String jsonEvents = restService.get(EVENTS_METHOD);
		Log.d("GitHubEventsServiceImpl", String.format("Get Events Response: %s", jsonEvents));
		return EventsMapperHelper.Map(jsonEvents);
	}

}
