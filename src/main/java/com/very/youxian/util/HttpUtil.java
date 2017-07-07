package com.very.youxian.util;

import javax.servlet.http.HttpSession;

import com.very.youxian.entity.User;

public class HttpUtil {
	private final static String CURRENT_USER = "CURRENT_USER";
	public static void saveSessionUser(HttpSession session,User user)
	{
		session.setAttribute(CURRENT_USER, user);
	}
	public static User getSessionUser(HttpSession session){
		User user = (User)session.getAttribute(CURRENT_USER);
		return user;
	}
}
