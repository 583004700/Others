package com.demo.yunxi.redis;

import org.apache.commons.lang3.time.DateUtils;
import redis.clients.jedis.BitOP;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataAnalysis {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
    private static final SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Jedis jedis;
    public DataAnalysis(){
        Jedis jedis = new Jedis("localhost");
        jedis.select(0);
        this.jedis = jedis;
    }

    /**
     * 更新并获取累计用户数
     * @param userId
     * @param day
     * @return
     */
    public Long updateAndGetUser(Long userId,String day){
        String key = "acc:users";
        String activeKey = String.format("active:%s",(day==null || day.equals("") ? DATE_FORMAT.format(new Date()) : day));

        if(!jedis.getbit(key,userId)){
            System.out.println(String.format("%s用户首次访问",userId));
        }else{
            System.out.println(String.format("%s用户再次访问",userId));
        }

        Transaction trans = jedis.multi();
        trans.setbit(key,userId,true);
        trans.setbit(activeKey,userId,true);
        Response<Long> total = trans.bitcount(key);
        trans.exec();
        return total.get();
    }

    /**
     * 获取指定天数内的日活跃用户
     * @param dayNum
     * @return
     */
    public Long getActiveUser(Integer dayNum){
        List<String> days = new ArrayList<String>();
        Date currentDate = new Date();
        for(int day = 0;day < dayNum;day++){
            days.add(String.format("active:%s",DATE_FORMAT.format(DateUtils.addDays(currentDate,-day))));
        }
        String key = String.format("active:lastdays:%s",dayNum);
        jedis.bitop(BitOP.AND,key,days.toArray(new String[0]));
        long activeUser = jedis.bitcount(key);
        return activeUser;
    }


    public static void main(String[] args){
        DataAnalysis dataAnalysis = new DataAnalysis();
        long users = 0;
        for(long userId=0;userId<12;userId++){
            users = dataAnalysis.updateAndGetUser(userId,DATE_FORMAT.format(new Date()));
        }

        System.out.println("======================================");

        for(long userId = 6;userId<16;userId++){
            users = dataAnalysis.updateAndGetUser(userId,DATE_FORMAT.format(DateUtils.addDays(new Date(),-1)));
        }
        System.out.println("======================================");
        System.out.println(String.format("累计用户人数：%s",users));
        System.out.println(String.format("连续两天内用户人数：%s",dataAnalysis.getActiveUser(2)));
    }
}