package com.very.youxian.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.jdbc.StringUtils;
import com.very.youxian.entity.SessionUser;
import com.very.youxian.entity.User;
import com.very.youxian.entity.UserExtraInfo;
import com.very.youxian.service.SessionUserService;
import com.very.youxian.service.UserExtraInfoService;
import com.very.youxian.util.HttpUtil;
import com.very.youxian.util.IdGenerator;

@RestController
@ComponentScan
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserExtraInfoService service;
	@Autowired
	private SessionUserService sessionUserService;
	@CrossOrigin
	@RequestMapping(value = "/getcurrentuser", method = RequestMethod.POST)
	@ResponseBody
	public UserExtraInfo getCurrentUser(HttpServletRequest request) {
		String sessionUserId = HttpUtil.getSessionUser(request.getSession());
		if (StringUtils.isNullOrEmpty(sessionUserId)) {
			return new UserExtraInfo();
		}
		SessionUser sUser = sessionUserService.findSessionUserById(sessionUserId);
		UserExtraInfo dd = service.findUserExtraInfoByUserId(sUser.getId());
		User user = new User();
		BeanUtils.copyProperties(user,sUser);
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
		String sessionUserId = HttpUtil.getSessionUser(request.getSession());
		if (StringUtils.isNullOrEmpty(sessionUserId)) {
			return 0;
		}
		SessionUser sUser = sessionUserService.findSessionUserById(sessionUserId);
		if (sUser == null) {
			return 0;
		}
		userExtraInfo.setUserid(sUser.getId());
		Integer result = 0;
		if (null == service.findUserExtraInfoByUserId(sUser.getId())) {
			userExtraInfo.setId(IdGenerator.uuid32());
			result = service.addUserExtraInfo(userExtraInfo);
		} else {
			result = service.updateUserExtraInfo(userExtraInfo);
		}

		return result;
	}

}
