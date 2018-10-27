package com.ry.xk.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * 
 * @author 幸仁强
 */
public class DateUtil
{
    /**
     * 按特定格式得到当前时间的字符串
     *
     * @param format
     * @return
     */
    public static String getDateString(String format)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    /**
     * 日期转毫秒
     * 
     * @Title: date2MillionSeconds
     * @author 幸仁强
     * @param date
     * @return
     * @throws ParseException
     */
    public static long date2MillionSeconds(Date date)
        throws ParseException
    {
        long time = date.getTime();
        return time;
    }

    /**
     * 日期转秒
     * 
     * @Title: date2Seconds
     * @author 幸仁强
     * @param date
     * @return
     * @throws ParseException
     */
    public static long date2Seconds(Date date)
        throws ParseException
    {
        long time = date.getTime() / 1000;
        return time;
    }

    /**
     * 微信时间，格林尼治时间
     * 
     * @Title: getWeixinDateTime
     * @author 幸仁强
     * @param date
     * @return
     */
    public static long getWeixinDateTime(Date date)
    {
        long time = date.getTime() / 1000;
        return time;
    }

    public static Date millionSeconds2Date(long millionSeconds)
    {
        Date date2 = new Date();
        date2.setTime(millionSeconds);
        return date2;
    }

    /**
     * 比较startDateStr和endDateStr,如果startDateStr>endDateStr,返回1,否则返回-1
     * 
     * @param startDateStr
     * @param endDateStr
     * @return
     */
    public static int dateCompare(String startDateStr, String endDateStr)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate;
        Date endDate;
        try
        {
            startDate = sdf.parse(startDateStr);
            endDate = sdf.parse(endDateStr);
            if (startDate.after(endDate))
            {
                return 1;
            }
            else
            {
                return -1;
            }
        }
        catch (ParseException e)
        {
            return -1;
        }
    }

    /**
     * 得到当前时间的后一个小时的时间
     * 
     * @param format
     * @return
     */
    public static String getNextHourStrByFomat(String format)
    {
        Calendar c = Calendar.getInstance();// 可以对每个时间域单独修改
        c.add(Calendar.HOUR_OF_DAY, 1);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String dateTimeString = sdf.format(c.getTime());
        return dateTimeString;
    }

    /**
     * 判断当前时间是否在startDateStr和endDateStr时间之内
     * 
     * @param startDateStr
     * @param endDateStr
     * @return
     */
    public static boolean currentBetweenParamDate(String startDateStr, String endDateStr)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate;
        Date endDate;
        Date currentDate;
        String currentDateStr = sdf.format(new Date());
        try
        {
            startDate = sdf.parse(startDateStr);
            endDate = sdf.parse(endDateStr);
            currentDate = sdf.parse(currentDateStr);
            return currentDate.after(startDate) && currentDate.before(endDate);
        }
        catch (ParseException e)
        {
            return false;
        }
    }

    /**
     * 判断当前时间是否在startDateStr和endDateStr时间之内
     * 
     * @param startDateStr
     * @param endDateStr
     * @return
     */
    public static boolean isPassDate(Date startDate, Date endDate)
    {
        Date currentDate = new Date();
        return currentDate.after(startDate) && currentDate.before(endDate);
    }

    /**
     * 将时间格式化成特定格式字符串
     * 
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static Date parse(String dateStr,String pattern) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(dateStr);
    }

    /**
     * 计算时间之间相差多少分钟
     * @param begin
     * @param end
     * @return
     */
    public static long min(Date begin, Date end)
    {
        long min = second(begin,end) / 60;
        return min;
    }

    /**
     * 计算时间之间相差多少秒
     * @param begin
     * @param end
     * @return
     */
    public static long second(Date begin, Date end){
        if (begin == null || end == null)
        {
            return 0;
        }
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long between = (end.getTime() - begin.getTime()) / 1000;// 除以1000是为了转换成秒
        return between;
    }

    /**
     * 获取时间的简称，前天/昨天/今天
     * @param date
     * @return
     */
    public static String getTimeShortName(Date date){
        int dateyyyyMMdd = Integer.parseInt(DateUtil.format(date,"yyyyMMdd"));
        int currentTimeyyyyMMdd = Integer.parseInt(DateUtil.format(new Date(),"yyyyMMdd"));
        String yyyyMMdd = "";
        if(currentTimeyyyyMMdd - dateyyyyMMdd == 0){
            yyyyMMdd = "今天";
        }else if(currentTimeyyyyMMdd - dateyyyyMMdd == 1){
            yyyyMMdd = "昨天";
        }else if(currentTimeyyyyMMdd - dateyyyyMMdd == 2){
            yyyyMMdd = "前天";
        }else{
            yyyyMMdd = DateUtil.format(date,"yyyy/MM/dd");
        }
        return yyyyMMdd;
    }

}
