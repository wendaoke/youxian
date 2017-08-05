package com.very.youxian.setting;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@PropertySource("classpath:conf/youxian.properties")
@ConfigurationProperties(prefix = "youxian")
@Component
public class YouXianSetting {
	private String appID;
	private String appsecret;
	private String uploadImagePath;
	private String domain;
	public String getUploadImagePath() {
		return uploadImagePath;
	}

	public void setUploadImagePath(String uploadImagePath) {
		this.uploadImagePath = uploadImagePath;
	}

	public String getAppID() {
		return appID;
	}

	public String getAppsecret() {
		return appsecret;
	}

	public void setAppID(String appID) {
		this.appID = appID;
	}

	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	@Override
	public String toString() {
		return "YouXianSetting [appID=" + appID + ", appsecret=" + appsecret + ", uploadImagePath=" + uploadImagePath + ", domain=" + domain + "]";
	}


}
