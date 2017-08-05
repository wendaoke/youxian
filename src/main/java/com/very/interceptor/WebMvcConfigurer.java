package com.very.interceptor;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.very.youxian.controller.WeiXinController;
import com.very.youxian.entity.SessionUser;
import com.very.youxian.entity.WeiXinUrl;
import com.very.youxian.service.SessionUserService;
import com.very.youxian.service.UserService;
import com.very.youxian.service.WeiXinService;
import com.very.youxian.setting.YouXianSetting;
import com.very.youxian.util.Constants;
import com.very.youxian.util.HttpUtil;
import com.very.youxian.util.IdGenerator;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
	private static final Logger LOGGER = Logger.getLogger(WeiXinController.class);
	@Autowired
	private WeiXinService wxService;

	@Autowired
	private SessionUserService sessionUserService;

	@Autowired
	private YouXianSetting yxSetting;

	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new HandlerInterceptorAdapter() {
//
//			@Override
//			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//				WeiXinUrl wxUrl = wxService.loadByName(Constants.WEBPAGE_ACCESS_TOKEN_CODE);
//				LOGGER.info(wxUrl);
//				if (StringUtils.isNoneBlank(wxUrl.getUrl())) {
//					try {
//						String url = request.getRequestURI();
//						String sessionUserId = HttpUtil.getSessionUser(request.getSession());
//						if (StringUtils.isBlank(sessionUserId)) {
//							sessionUserId = IdGenerator.uuid19();
//							HttpUtil.saveSessionUserId(request.getSession(), sessionUserId);
//							SessionUser sUser = new SessionUser();
//							sUser.setSessionId(sessionUserId);
//							sUser.setLastUrl(url);
//							sessionUserService.addSessionUser(sUser);
//						}
//						SessionUser sUser = sessionUserService.findSessionUserById(sessionUserId);
//						if (sUser == null || StringUtils.isBlank(sUser.getId())) {
//							String tempContextUrl = yxSetting.getDomain()+"/weixin/getuser";
//							LOGGER.info("tempContextUrl:" + tempContextUrl);					
//							String redirectUrl = wxUrl.getUrl().replace("SESSION_ID", sessionUserId).replace("WEIXIN_APPID", yxSetting.getAppID()).replace("WEIXIN_REDIRECT_URI",
//									URLEncoder.encode(tempContextUrl, "UTF-8"));
//							LOGGER.info("redirectUrl:" + redirectUrl);
//							response.sendRedirect(redirectUrl);
//						}
//
//					} catch (IOException e) {
//						LOGGER.error(e.toString(), e);
//					}
//				}
//				return true;
//			}
//		}).addPathPatterns("/**").excludePathPatterns("/weixin/getuser");
	}
}
