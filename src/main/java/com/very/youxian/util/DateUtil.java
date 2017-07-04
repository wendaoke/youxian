package com.very.youxian.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

public class DateUtil {
	private static final Logger LOGGER = Logger.getLogger(DateUtil.class);

	public static String getStringFromTimeStamp(Timestamp ts) {
		String tsStr = "";
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		try {
			tsStr = sdf.format(ts);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
		}
		return tsStr;
	}
}
