package com.very.youxian.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.very.youxian.dao.UserMapper;
import com.very.youxian.entity.User;

@Component
public class UserService {
	@Autowired
private UserMapper userMapper;
	public User findUserById(String id){
		return userMapper.findUserById(id);
	}
	public Integer addUser(User user){
		return userMapper.addUser(user);
	}
}
