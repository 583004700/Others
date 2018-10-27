package com.ry.cds.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * 
 * @author 幸仁强
 *
 */
public class DateUtil {
	/**
	 *按特定格式得到当前时间的字符串
	 *
	 * @param format
	 * @return
	 */
	public static String getDateString(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());
	}
	
	/**
	 * 比较startDateStr和endDateStr,如果startDateStr>endDateStr,返回1,否则返回-1
	 * @param startDateStr
	 * @param endDateStr
	 * @return
	 */
	public static int dateCompare(String startDateStr, String endDateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startDate;
		Date endDate;
		try {
			startDate = sdf.parse(startDateStr);
			endDate = sdf.parse(endDateStr);
			if (startDate.after(endDate)) {
				return 1;
			} else {
				return -1;
			}
		} catch (ParseException e) {
			return -1;
		}
	}
	
	/**
	 * 得到当前时间的后一个小时的时间
	 * @param format
	 * @return
	 */
	public static String getNextHourStrByFomat(String format) {
		Calendar c = Calendar.getInstance();// 可以对每个时间域单独修改
		c.add(Calendar.HOUR_OF_DAY, 1);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String dateTimeString = sdf.format(c.getTime());
		return dateTimeString;
	}

	/**
	 * 判断当前时间是否在startDateStr和endDateStr时间之内
	 * @param startDateStr
	 * @param endDateStr
	 * @return
	 */
	public static boolean currentBetweenParamDate(String startDateStr, String endDateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startDate;
		Date endDate;
		Date currentDate;
		String currentDateStr = sdf.format(new Date());
		try {
			startDate = sdf.parse(startDateStr);
			endDate = sdf.parse(endDateStr);
			currentDate = sdf.parse(currentDateStr);
			return currentDate.after(startDate) && currentDate.before(endDate);
		} catch (ParseException e) {
			return false;
		}
	}
	
}
