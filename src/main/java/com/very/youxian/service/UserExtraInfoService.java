package com.very.youxian.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.very.youxian.dao.UserExtraInfoMapper;
import com.very.youxian.entity.UserExtraInfo;

@Component
public class UserExtraInfoService {
	@Autowired
	private UserExtraInfoMapper mapper;

	public UserExtraInfo findUserExtraInfoByUserId(String userId) {
		return mapper.findUserExtraInfoByUserId(userId);
	}

	public Integer addUserExtraInfo(UserExtraInfo userExtraInfo) {
		return mapper.addUserExtraInfo(userExtraInfo);
	}

	public Integer updateUserExtraInfo(UserExtraInfo userExtraInfo) {
		return mapper.updateUserExtraInfo(userExtraInfo);
	}
}
