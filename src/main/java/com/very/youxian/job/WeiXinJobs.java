package com.very.youxian.job;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.very.rest.client.SimpleRestClient;
import com.very.youxian.controller.WeiXinController;
import com.very.youxian.entity.TokenResponse;
import com.very.youxian.entity.WeiXinUrl;
import com.very.youxian.service.WeiXinService;
import com.very.youxian.setting.YouXianSetting;
import com.very.youxian.util.Constants;

@Component
public class WeiXinJobs {
	private static final Logger LOGGER = Logger.getLogger(WeiXinJobs.class);
	public final static long ONE_HOUR = 60 * 60 * 1000;
	@Autowired
	private WeiXinService wxService;
	@Autowired
	private YouXianSetting yxSetting;

	@Scheduled(fixedDelay = ONE_HOUR)
	public void fixedDelayJob() {
		WeiXinUrl url = wxService.loadByName(Constants.ACCESS_TOKEN_CODE);
		TokenResponse res = SimpleRestClient.getClient().getForObject(url.getUrl(), TokenResponse.class, yxSetting.getAppID(), yxSetting.getAppsecret());
		if (StringUtils.isEmpty(res.getErrcode())) {
			Constants.ACCESS_TOKEN = res.getAccess_token();
		} else {
			LOGGER.error(res.toString());
		}
		LOGGER.error("ACCESS_TOKEN:" + Constants.ACCESS_TOKEN);
	}

	// @Scheduled(fixedRate=ONE_Minute)
	// public void fixedRateJob(){
	// System.out.println(Dates.format_yyyyMMddHHmmss(new Date())+"
	// >>fixedRate执行....");
	// }

	// @Scheduled(cron="0 15 3 * * ?")
	// public void cronJob(){
	// System.out.println(Dates.format_yyyyMMddHHmmss(new Date())+"
	// >>cron执行....");
	// }
}
