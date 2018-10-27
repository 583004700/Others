package com.sxt.t021.redis;

import redis.clients.jedis.Jedis;
import java.util.List;

public class TestRedis {
    public static void main(String[] args) {
        test();
    }

    public static void test(){
        Jedis j = new Jedis("192.168.0.109",6379);
        List<String> list = j.mget("name","age");
        list.forEach((o)->System.out.println(o));
        j.set("sex","man");
        System.out.println(j.get("sex"));
    }
}
