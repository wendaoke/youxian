package com.very.youxian.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.very.youxian.entity.City;
import com.very.youxian.service.PositionService;
import com.very.youxian.util.HttpUtil;
import com.very.youxian.vo.Select;

@RestController
@ComponentScan
@RequestMapping("/position")
public class PositionController {
	@Autowired
	private PositionService positionService;

	@RequestMapping("/")
	public String home() {
		return "Hello";
	}

	@CrossOrigin
	@RequestMapping("/citylst")
	@ResponseBody
	public List<Select> findCityByName(@RequestParam("cityName") String cityName) {
		List<City> citylst = positionService.findCityByName(cityName);
		List<Select> selectlst = new ArrayList<Select>();
		Select s = null;
		for (City c : citylst) {
			s = new Select();
			s.setLabel(c.getCityName());
			s.setValue(c.getCityName());
			selectlst.add(s);
		}
		return selectlst;
	}

	@RequestMapping("/querycity")
	public String queryCity(HttpServletRequest  request) {
		String ip = HttpUtil.getRemoteHost(request);
		City c = positionService.findCityByIP(ip);
		if(ObjectUtils.isEmpty(c)){
			return "";
		}else{
			return c.getCityName();
		}
	}
	
}
