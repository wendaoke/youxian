package com.very.youxian.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.very.youxian.entity.SnsapiUserinfoResponse;
import com.very.youxian.entity.User;
import com.very.youxian.entity.WeiXinUrl;
import com.very.youxian.service.WeiXinService;
import com.very.youxian.setting.YouXianSetting;
import com.very.youxian.util.Constants;
import com.very.youxian.util.HttpUtil;

@RestController
@ComponentScan
@RequestMapping("/weixin")
public class WeiXinController {
	private static final Logger LOGGER = Logger.getLogger(WeiXinController.class);
	@Autowired
	private WeiXinService wxService;
	@Autowired
	private YouXianSetting yxSetting;

	@RequestMapping("/validate")
	public String home(String signature, String timestamp, String nonce, String echostr) {
		LOGGER.info("signature:" + signature);
		LOGGER.info("timestamp:" + timestamp);
		LOGGER.info("nonce:" + nonce);
		LOGGER.info("echostr:" + echostr);
		return echostr;
	}

	@RequestMapping(value = "/queryuser", method = RequestMethod.GET)
	public String queryWebPageAccessCode(HttpServletRequest request, HttpServletResponse response, Model model) {
		WeiXinUrl wxUrl = wxService.loadByName(Constants.WEBPAGE_ACCESS_TOKEN_CODE);
		LOGGER.info(wxUrl);
		if (StringUtils.isNoneBlank(wxUrl.getUrl())) {
			try {
				StringBuffer url = request.getRequestURL();
				String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/weixin/getuser").toString();
				String redirectUrl = wxUrl.getUrl().replace("WEIXIN_APPID", yxSetting.getAppID()).replace("WEIXIN_REDIRECT_URI", URLEncoder.encode(tempContextUrl, "UTF-8"));
				LOGGER.info("redirectUrl:" + redirectUrl);			
				response.sendRedirect(redirectUrl);
			} catch (IOException e) {
				LOGGER.error(e.toString(), e);
			}
		}
		return null;
	}

	@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	public void getWebPageAccessCode(HttpServletRequest request, HttpServletResponse response, String code, String state, Model model) {
		LOGGER.info("code:" + code);
		LOGGER.info("state:" + state);
		if (StringUtils.isBlank(code) || StringUtils.isBlank(state)) {
			return;
		}
		SnsapiUserinfoResponse useResponse = wxService.getWebPageAccessToken(code);
		User user = new User();
		BeanUtils.copyProperties(useResponse, user);
		HttpUtil.saveSessionUser(request.getSession(), user);
		return;
	}
}
