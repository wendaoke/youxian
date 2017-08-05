package com.very.youxian.entity;

public class SessionUser extends User {
	private String sessionId;
	private String lastUrl;

	public String getSessionId() {
		return sessionId;
	}

	public String getLastUrl() {
		return lastUrl;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public void setLastUrl(String lastUrl) {
		this.lastUrl = lastUrl;
	}

}
