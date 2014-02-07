package com.premise.eventsapi.services.impl;

import java.util.List;

import android.util.Log;

import com.premise.eventsapi.models.EventModel;
import com.premise.eventsapi.services.GitHubEventsService;
import com.premise.eventsapi.services.SimpleHttpService;

public class GitHubEventsServiceImpl implements GitHubEventsService {
	private static final String API_URL = "https://api.github.com/events";
	SimpleHttpService httpService = new HttpServiceSimpleImpl();
	
	@Override
	public List<EventModel> getEvents() {
		
		String jsonEvents = httpService.makeServiceCall(API_URL, SimpleHttpService.GET);
		Log.d("GitHubEventsServiceImpl", String.format("Get Events Response: %s", jsonEvents));
		return EventsMapperHelper.Map(jsonEvents);
	}

}
