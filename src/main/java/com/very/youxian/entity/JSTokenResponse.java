package com.very.youxian.entity;

public class JSTokenResponse extends BaseResponse {
	private String ticket;
	private String expires_in;


	public String getExpires_in() {
		return expires_in;
	}


	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}


	public String getTicket() {
		return ticket;
	}


	public void setTicket(String ticket) {
		this.ticket = ticket;
	}


	@Override
	public String toString() {
		return "JSTokenResponse [ticket=" + ticket + ", expires_in=" + expires_in + ", errcode=" + errcode + ", errmsg=" + errmsg + "]";
	}


}
