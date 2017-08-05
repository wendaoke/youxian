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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.very.youxian.entity.Result;
import com.very.youxian.entity.SessionUser;
import com.very.youxian.entity.SnsapiUserinfoResponse;
import com.very.youxian.entity.User;
import com.very.youxian.entity.WeiXinUrl;
import com.very.youxian.service.SessionUserService;
import com.very.youxian.service.UserService;
import com.very.youxian.service.WeiXinService;
import com.very.youxian.setting.YouXianSetting;
import com.very.youxian.util.Constants;
import com.very.youxian.util.HttpUtil;
import com.very.youxian.util.IdGenerator;

@RestController
@ComponentScan
@RequestMapping("/weixin")
public class WeiXinController {
	private static final Logger LOGGER = Logger.getLogger(WeiXinController.class);
	@Autowired
	private WeiXinService wxService;

	@Autowired
	private SessionUserService sessionUserService;

	@Autowired
	private UserService userService;

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
	
	@CrossOrigin
	@RequestMapping(value = "/checkuser")
	@ResponseBody
	public Result queryWebPageAccessCode(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		result.setCode("");
		WeiXinUrl wxUrl = wxService.loadByName(Constants.WEBPAGE_ACCESS_TOKEN_CODE);
		LOGGER.info(wxUrl);
		if (StringUtils.isNoneBlank(wxUrl.getUrl())) {
			try {
				String url = request.getRequestURI();
				String sessionUserId = HttpUtil.getSessionUser(request.getSession());
				if (StringUtils.isBlank(sessionUserId)) {
					sessionUserId = IdGenerator.uuid19();
					HttpUtil.saveSessionUserId(request.getSession(), sessionUserId);
					SessionUser sUser = new SessionUser();
					sUser.setSessionId(sessionUserId);
					sUser.setLastUrl(url);
					sessionUserService.addSessionUser(sUser);
				}
				SessionUser sUser = sessionUserService.findSessionUserById(sessionUserId);
				if (sUser == null || StringUtils.isBlank(sUser.getId())) {
					String tempContextUrl = yxSetting.getDomain()+"/weixin/getuser";
					LOGGER.info("tempContextUrl:" + tempContextUrl);					
				   String redirectUrl = wxUrl.getUrl().replace("SESSION_ID", sessionUserId).replace("WEIXIN_APPID", yxSetting.getAppID()).replace("WEIXIN_REDIRECT_URI",
							URLEncoder.encode(tempContextUrl, "UTF-8"));
					LOGGER.info("redirectUrl:" + redirectUrl);
    				result.setCode(redirectUrl);
				}

			} catch (IOException e) {
				LOGGER.error(e.toString(), e);
			}
		}

		return result;
	}
	@CrossOrigin
	@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	public void getWebPageAccessCode(HttpServletRequest request, HttpServletResponse response, String code, String state, Model model) {
		try {
			LOGGER.info("code:" + code);
			LOGGER.info("state:" + state);
			if (StringUtils.isBlank(code) || StringUtils.isBlank(state)) {
				return;
			}
			SnsapiUserinfoResponse useResponse = wxService.getWebPageAccessToken(code);
			User user = new User();
			user.setId(IdGenerator.uuid32());
			BeanUtils.copyProperties(useResponse, user);
			userService.checkUser(user);
			SessionUser sUser = sessionUserService.findSessionUserById(state);
			if (sUser != null) {
				BeanUtils.copyProperties(user, sUser);
				sessionUserService.updateSessionUser(sUser);
				response.sendRedirect(yxSetting.getDomain()+sUser.getLastUrl());
			} else {
				LOGGER.error("state:" + state + ", we can not find the session user!");
			}
		} catch (IOException e) {
			LOGGER.error(e.toString(), e);
		}
		return;
	}
}
