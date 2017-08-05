package com.very.youxian.filter;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.very.youxian.entity.SessionUser;
import com.very.youxian.entity.WeiXinUrl;
import com.very.youxian.job.WeiXinJobs;
import com.very.youxian.service.SessionUserService;
import com.very.youxian.service.WeiXinService;
import com.very.youxian.setting.YouXianSetting;
import com.very.youxian.util.Constants;
import com.very.youxian.util.HttpUtil;
import com.very.youxian.util.IdGenerator;

@WebFilter(urlPatterns = "/*", filterName = "indexFilter")
public class IndexFilter implements Filter {
	private static final Logger LOGGER = Logger.getLogger(WeiXinJobs.class);
	@Autowired
	private WeiXinService wxService;

	@Autowired
	private SessionUserService sessionUserService;

	@Autowired
	private YouXianSetting yxSetting;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		LOGGER.info("init IndexFilter");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//		HttpServletRequest request = (HttpServletRequest) servletRequest;
//		HttpServletResponse response = (HttpServletResponse) servletResponse;
//		LOGGER.info("doFilter IndexFilter");
//		WeiXinUrl wxUrl = wxService.loadByName(Constants.WEBPAGE_ACCESS_TOKEN_CODE);
//		LOGGER.info(wxUrl);
//		if (StringUtils.isNoneBlank(wxUrl.getUrl())) {
//			try {
//				String url = request.getRequestURI();
//				String sessionUserId = HttpUtil.getSessionUser(request.getSession());
//				if (StringUtils.isBlank(sessionUserId)) {
//					sessionUserId = IdGenerator.uuid19();
//					HttpUtil.saveSessionUserId(request.getSession(), sessionUserId);
//					SessionUser sUser = new SessionUser();
//					sUser.setSessionId(sessionUserId);
//					sUser.setLastUrl(url);
//					sessionUserService.addSessionUser(sUser);
//				}
//				SessionUser sUser = sessionUserService.findSessionUserById(sessionUserId);
//				if (sUser == null || StringUtils.isBlank(sUser.getId())) {
//					String tempContextUrl = yxSetting.getDomain() + "/weixin/getuser";
//					LOGGER.info("tempContextUrl3:" + tempContextUrl);
//					String redirectUrl = wxUrl.getUrl().replace("SESSION_ID", sessionUserId).replace("WEIXIN_APPID", yxSetting.getAppID()).replace("WEIXIN_REDIRECT_URI",
//							URLEncoder.encode(tempContextUrl, "UTF-8"));
//					LOGGER.info("redirectUrl:" + redirectUrl);
////					response.sendRedirect(redirectUrl);
//					response.getWriter().write("<script>window.top.location='"+redirectUrl+"';</script>");
//					return ;
//				}else{
//					filterChain.doFilter(servletRequest, servletResponse);
//				}
//				filterChain.doFilter(servletRequest, servletResponse);
//			} catch (IOException e) {
//				LOGGER.error(e.toString(), e);
//			}
//		}
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {

	}
}