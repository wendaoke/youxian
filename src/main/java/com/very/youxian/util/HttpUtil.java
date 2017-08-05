package com.very.youxian.util;

import javax.servlet.http.HttpSession;

import com.very.youxian.entity.User;

public class HttpUtil {
	private final static String CURRENT_USER = "CURRENT_USER";

	
	public static void saveSessionUserId(HttpSession session, String userId) {
		session.setAttribute(CURRENT_USER, userId);
	}
	
//	public static void saveSessionUser(HttpSession session, User user) {
//		session.setAttribute(CURRENT_USER, user);
//	}

	public static String getSessionUser(HttpSession session) {
		String userId = (String) session.getAttribute(CURRENT_USER);
		return userId;
	}

	public static String getRemoteHost(javax.servlet.http.HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}
}
