package com.premise.eventsapi.models;

/**
 * Represents a GitHub Event.
 * It is a simplification of a real event, then it can be improved.
 * I just want to demonstrate knowledge at this stage. Get the rest
 * of the data is a similar task.
 * 
 * @author luck
 * 
 */
public class EventModel {
	
	private String id;
	private String type;
	private String actorLogin;
	private String repoUrl;

	
	public EventModel() {
		
	}
	
	public EventModel(String id, String type, String actorLogin,
			String repoUrl) {
		super();
		this.id = id;
		this.type = type;
		this.actorLogin = actorLogin;
		this.repoUrl = repoUrl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getActorLogin() {
		return actorLogin;
	}

	public void setActorLogin(String actorLogin) {
		this.actorLogin = actorLogin;
	}

	public String getRepoUrl() {
		return repoUrl;
	}

	public void setRepoUrl(String repoUrl) {
		this.repoUrl = repoUrl;
	}
	
	@Override
	public String toString() {
		return "EventModel [id=" + id + ", type=" + type
				+ ", actorLogin=" + actorLogin + ", repoUrl=" + repoUrl + "]";
	}

}
