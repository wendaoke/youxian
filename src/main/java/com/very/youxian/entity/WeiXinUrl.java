package com.very.youxian.entity;

public class WeiXinUrl {
	private String name;
	private String type;
	private String url;

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getUrl() {
		return url;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "WeiXinUrl [name=" + name + ", type=" + type + ", url=" + url + "]";
	}

}
