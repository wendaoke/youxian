package com.very.youxian.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.very.youxian.dao.UserMapper;
import com.very.youxian.entity.User;

@Component
public class UserService {
	@Autowired
	private UserMapper userMapper;

	public User findUserById(String id) {
		return userMapper.findUserById(id);
	}

	public User findUserByOpenId(String openId) {
		return userMapper.findUserByOpenId(openId);
	}

	public Integer addUser(User user) {
		return userMapper.addUser(user);
	}

	public Integer updateUser(User user) {
		return userMapper.updateUser(user);
	}

	public Integer checkUser(User user) {
		if (null == findUserByOpenId(user.getOpenid())) {
			return addUser(user);
		} else {
			return updateUser(user);
		}
	}
}
