package com.sxt.t022.redis.cluster;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

public class Cluster {
    //创建集群 ./redis-trib.rb create --replicas 1 192.168.0.107:6379 192.168.0.108:6379
    // 192.168.0.109:6379 192.168.0.110:6379 192.168.0.111:6379 192.168.0.112:6379

    //客户端连接 ./redis-cli -c -h 192.168.0.107 -p 6379
    public static void main(String[] args) throws Exception{
        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
        jedisClusterNodes.add(new HostAndPort("192.168.0.107",6379));
        jedisClusterNodes.add(new HostAndPort("192.168.0.108",6379));
        jedisClusterNodes.add(new HostAndPort("192.168.0.109",6379));
        jedisClusterNodes.add(new HostAndPort("192.168.0.110",6379));
        jedisClusterNodes.add(new HostAndPort("192.168.0.111",6379));
        jedisClusterNodes.add(new HostAndPort("192.168.0.112",6379));

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(100);
        jedisPoolConfig.setMaxIdle(20);
        jedisPoolConfig.setMaxWaitMillis(-1);
        jedisPoolConfig.setTestOnBorrow(true);
        JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes,6000,100,jedisPoolConfig);

        jedisCluster.set("name","张三");
        System.out.println(jedisCluster.get("name"));
        jedisCluster.close();
    }
}
