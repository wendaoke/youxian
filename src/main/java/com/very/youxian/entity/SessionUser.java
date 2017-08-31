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

	@Override
	public String toString() {
		return "SessionUser [sessionId=" + sessionId + ", lastUrl=" + lastUrl + ", getId()=" + getId() + ", getOpenid()=" + getOpenid() + ", getNickname()=" + getNickname() + ", getSex()=" + getSex()
				+ ", getProvince()=" + getProvince() + ", getCity()=" + getCity() + ", getCountry()=" + getCountry() + ", getHeadimgurl()=" + getHeadimgurl() + ", getPrivilege()=" + getPrivilege()
				+ ", getUnionid()=" + getUnionid() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
