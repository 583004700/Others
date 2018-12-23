package com.byefan.xhoa.utils;

import java.util.Calendar;

public  class CodeUtil {
    public static Calendar calendar = Calendar.getInstance() ;
    public static int getYear(){
        return calendar.get(Calendar.YEAR) ;
    }
    public static int getMonth(){
        return calendar.get(Calendar.MONTH)+1 ;
    }
    public static int getDay(){
        return calendar.get(Calendar.DATE) ;
    }
    //生成年月日
    public static String getDayStr(){
        return String.valueOf(getYear())+String.valueOf(getMonth())+String.valueOf(getDay()) ;
    }
    public static String getMonthStr(){
        return String.valueOf(getYear())+String.valueOf(getMonth()) ;
    }
    //生成0001
    public static String getFourCode(long value,int length) {
        String valueStr=String.valueOf(value);
        int end=length-(valueStr.length());
        for (int i=0;i<end;i++){
            valueStr ="0"+valueStr;
        }
        return valueStr;
    }

}
