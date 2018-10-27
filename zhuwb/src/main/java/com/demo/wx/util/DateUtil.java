package com.demo.wx.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /**
     * 解析微信中的createTime
     * @param createTime
     * @return
     */
    public static Date parseWxTime(String createTime) {
        long msgCreateTime = Long.parseLong(createTime) * 1000L;
        return new Date(msgCreateTime);
    }

    /**
     * 将时间转为微信创建时间
     * @param date
     * @return
     */
    public static String formatWxTime(Date date){
        Long dateStr = date.getTime()/1000;
        return dateStr.toString();
    }

    /**
     * 将时间格式化成String
     * @param date
     * @param pattern
     * @return
     */
    public static String formatString(Date date,String pattern){
        DateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }
}
