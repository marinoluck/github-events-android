package com.premise.eventsapi.services;

import java.util.List;

import com.premise.eventsapi.models.EventModel;

/**
 * Service that provides information events GitHub
 * @author luck
 *
 */
public interface GitHubEventsService {
	
	/**
	 * Gets a list of events without filters
	 * @return
	 */
	List<EventModel> getEvents();
}
