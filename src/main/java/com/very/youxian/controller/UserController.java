package com.very.youxian.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.jdbc.StringUtils;
import com.very.youxian.entity.User;
import com.very.youxian.entity.UserExtraInfo;
import com.very.youxian.service.UserExtraInfoService;
import com.very.youxian.util.HttpUtil;
import com.very.youxian.util.IdGenerator;

@RestController
@ComponentScan
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserExtraInfoService service;

	@CrossOrigin
	@RequestMapping(value = "/getcurrentuser", method = RequestMethod.POST)
	@ResponseBody
	public UserExtraInfo getCurrentUser(HttpServletRequest request) {
		User user = HttpUtil.getSessionUser(request.getSession());
		if (ObjectUtils.isEmpty(user)||StringUtils.isEmptyOrWhitespaceOnly(user.getId())) {
			return new UserExtraInfo();
		}
		UserExtraInfo dd = service.findUserExtraInfoByUserId(user.getId());
		dd.setUser(user);
		return dd;
	}

	@CrossOrigin
	@RequestMapping(value = "/addextrainfo", method = RequestMethod.POST)
	@ResponseBody
	public Integer addUserExtraInfo(@RequestBody UserExtraInfo userExtraInfo) {
		Integer result = service.addUserExtraInfo(userExtraInfo);
		return result;
	}

	@CrossOrigin
	@RequestMapping("/detail/{userId}")
	@ResponseBody
	public UserExtraInfo userExtraInfoDetail(@PathVariable String userId) {
		if (StringUtils.isEmptyOrWhitespaceOnly(userId)) {
			return null;
		}
		UserExtraInfo dd = service.findUserExtraInfoByUserId(userId);
		return dd;
	}

	@CrossOrigin
	@RequestMapping(value = "/modifyextrainfo", method = RequestMethod.POST)
	@ResponseBody
	public Integer modifyUserExtraInfo(@RequestBody UserExtraInfo userExtraInfo) {
		Integer result = service.updateUserExtraInfo(userExtraInfo);
		return result;
	}

	@CrossOrigin
	@RequestMapping(value = "/updateextrainfo", method = RequestMethod.POST)
	@ResponseBody
	public Integer updateUserExtraInfo(HttpServletRequest request, @RequestBody UserExtraInfo userExtraInfo) {
		User user = HttpUtil.getSessionUser(request.getSession());
		if (user == null) {
			return 0;
		}
		userExtraInfo.setUserid(user.getId());
		Integer result = 0;
		if (null == service.findUserExtraInfoByUserId(user.getId())) {
			userExtraInfo.setId(IdGenerator.uuid32());
			result = service.addUserExtraInfo(userExtraInfo);
		} else {
			result = service.updateUserExtraInfo(userExtraInfo);
		}

		return result;
	}

}
