package com.very.youxian.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.very.youxian.dao.SessionUserMapper;
import com.very.youxian.entity.SessionUser;

@Component
public class SessionUserService {
	@Autowired
	private SessionUserMapper sessionUserMapper;

	public SessionUser findSessionUserById(String sessionId) {
		return sessionUserMapper.findSessionUserById(sessionId);
	}

	public Integer addSessionUser(SessionUser user) {
		return sessionUserMapper.addSessionUser(user);
	}

	public Integer updateSessionUser(SessionUser user) {
		return sessionUserMapper.updateSessionUser(user);
	}
}
