package com.very.youxian.entity;

public class TokenResponse extends BaseResponse {
	private String access_token;
	private String expires_in;

	public String getAccess_token() {
		return access_token;
	}

	public String getExpires_in() {
		return expires_in;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

	@Override
	public String toString() {
		return "TokenResponse [getAccess_token()=" + getAccess_token() + ", getExpires_in()=" + getExpires_in() + ", getErrcode()=" + getErrcode() + ", getErrmsg()=" + getErrmsg() + "]";
	}

}
