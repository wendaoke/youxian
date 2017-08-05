package com.very.youxian.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.very.rest.client.SimpleRestClient;
import com.very.youxian.component.entity.position.BaiduPosition;
import com.very.youxian.dao.PositionMapper;
import com.very.youxian.dao.WeiXinMapper;
import com.very.youxian.entity.City;
import com.very.youxian.entity.WeiXinUrl;
import com.very.youxian.util.Constants;

@Component
public class PositionService {
	private static final Logger LOGGER = Logger.getLogger(PositionService.class);
	@Autowired
	private PositionMapper mapper;
	@Autowired
	private WeiXinMapper wxmapper;

	public List<City> findCityByName(String cityName) {
		return mapper.findCityByName(cityName);
	}

	public City findCityByIP(String ip) {
		try {

			WeiXinUrl url = wxmapper.loadByName(Constants.BAIDU_POSITION_API);
			String returnStr = SimpleRestClient.getClient().getForObject(url.getUrl(), String.class, ip);
			BaiduPosition bp = JSON.parseObject(returnStr, BaiduPosition.class);
			String cityName = bp.getContent().getAddress_detail().getCity();
			List<City> cl = findCityByName(cityName);
			if (!CollectionUtils.isEmpty(cl)) {
				return cl.get(0);
			} else {
				return null;
			}
		} catch (Exception ex) {
			LOGGER.error(ex.toString(), ex);
			return null;
		}
	}
}
