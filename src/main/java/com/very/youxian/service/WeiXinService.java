package com.very.youxian.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.very.rest.client.SimpleRestClient;
import com.very.youxian.controller.WeiXinController;
import com.very.youxian.dao.WeiXinMapper;
import com.very.youxian.entity.SnsapiUserinfoResponse;
import com.very.youxian.entity.WebPageAccessTokenResponse;
import com.very.youxian.entity.WeiXinUrl;
import com.very.youxian.setting.YouXianSetting;
import com.very.youxian.util.Constants;

@Component
public class WeiXinService {
	private static final Logger LOGGER = Logger.getLogger(WeiXinService.class);
	@Autowired
	private WeiXinMapper wxMapper;
	@Autowired
	private YouXianSetting yxSetting;

	public WeiXinUrl loadByName(String name) {
		return wxMapper.loadByName(name);
	}

	public SnsapiUserinfoResponse getWebPageAccessToken(String code) {
		WeiXinUrl url = loadByName(Constants.WEBPAGE_ACCESS_TOKEN_GET);

		String returnStr = SimpleRestClient.getClient().getForObject(url.getUrl(), String.class, yxSetting.getAppID(), yxSetting.getAppsecret(), code);
		LOGGER.info(returnStr.toString());
		WebPageAccessTokenResponse response = JSON.parseObject(returnStr, WebPageAccessTokenResponse.class);
		SnsapiUserinfoResponse user = null;
		if (StringUtils.isBlank(response.getErrcode())) {
			String accessToken = response.getAccess_token();
			String openId = response.getOpenid();
			user = getWebpageAccessTokenUserinfo(accessToken, openId);
		} else {
			LOGGER.error("query web page access token error:" + response.toString());
		}
		return user;
	}

	public SnsapiUserinfoResponse getWebpageAccessTokenUserinfo(String accessToken, String openId) {
		WeiXinUrl url = loadByName(Constants.WEBPAGE_ACCESS_TOKEN_USERINFO);

		String returnStr = SimpleRestClient.getClient().getForObject(url.getUrl(), String.class, accessToken, openId);
		LOGGER.info(returnStr.toString());
		SnsapiUserinfoResponse response = JSON.parseObject(returnStr, SnsapiUserinfoResponse.class);
		LOGGER.info(response.toString());
		return response;
	}
}
