package com.very.youxian.job;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.very.rest.client.SimpleRestClient;
import com.very.youxian.entity.JSTokenResponse;
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
		try {
			WeiXinUrl url = wxService.loadByName(Constants.ACCESS_TOKEN_CODE);
			LOGGER.info("url:" + url.toString() + ";yxSetting:" + yxSetting.toString());
			TokenResponse res = SimpleRestClient.getClient().getForObject(url.getUrl(), TokenResponse.class, yxSetting.getAppID(), yxSetting.getAppsecret());
			if (StringUtils.isEmpty(res.getErrcode())) {
				Constants.ACCESS_TOKEN = res.getAccess_token();
			} else {
				LOGGER.error(res.toString());
			}
			
			LOGGER.error("ACCESS_TOKEN:" + Constants.ACCESS_TOKEN);
			
			url = wxService.loadByName(Constants.JSAPI_TICKET_CODE);
			
			JSTokenResponse jsres = SimpleRestClient.getClient().getForObject(url.getUrl(), JSTokenResponse.class, Constants.ACCESS_TOKEN);
			
			if (Constants.SUCCESS_CODE.equalsIgnoreCase(jsres.getErrcode())) {
				Constants.JSAPI_TICKET = jsres.getTicket();
			} else {
				LOGGER.error(res.toString());
			}
			
			LOGGER.error("JSAPI_TICKET:" + Constants.JSAPI_TICKET);
			
		} catch (Exception ex) {
			LOGGER.error(ex.toString(), ex);
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
}