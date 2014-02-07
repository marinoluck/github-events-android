package com.premise.eventsapi.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.premise.eventsapi.models.EventModel;

/**
 * Helper Class
 * Maps from a JSONArray to a list of event models
 * @author luck
 *
 */
public class EventsMapperHelper {
	/* root tags */
	private static final String TAG_ID = "id";
	private static final String TAG_TYPE = "type";
	private static final String TAG_ACTOR = "actor";
	private static final String SUBTAG_ACTOR_LOGIN = "login";
	private static final String TAG_REPO = "repo";
	private static final String SUBTAG_REPO_NAME = "name";

	/**
	 * Maps from json string  to a List<EventModel>
	 * @param rawData json with rawData (JSONArray)
	 * @return
	 */
	public static List<EventModel> Map(String rawData) {
		List<EventModel> result = new ArrayList<EventModel>();

		if (rawData != null) {
			try {
				// Getting JSON Array node
				JSONArray rawArray = new JSONArray(rawData);

				// looping through All rawArray
				for (int i = 0; i < rawArray.length(); i++) {
					JSONObject c = rawArray.getJSONObject(i);

					// Root values
					String id = c.getString(TAG_ID);
					String type = c.getString(TAG_TYPE);

					// Actor node is JSONObject
					JSONObject actor = c.getJSONObject(TAG_ACTOR);
					String login = actor.getString(SUBTAG_ACTOR_LOGIN);

					// Repo node is JSONObject
					JSONObject repo = c.getJSONObject(TAG_REPO);
					String repoName = repo.getString(SUBTAG_REPO_NAME);

					EventModel m = new EventModel(id, type, login,
							repoName);
					// adding contact to contact list
					result.add(m);
				}

			} catch (JSONException e) {
				Log.e("EventsMapperHelper", e.getMessage());
			}
		} else {
			Log.e("EventsMapperHelper",
					"Couldn't get any data from the rawData");
		}
		return result;
	}
}
