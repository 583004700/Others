package com.sxt.t018.redis;

public class Sentinel {
    //修改配置文件 sentinel.conf
    //dir 修改文件存放路径
    //sentinel monitor mymaster 127.0.0.1 6379 1
    //sentinel down-after-milliseconds mymaster 30000 监控的时间间隔
    //sentinel parallel-syncs mymaster 2 配置节点数量
    //启动哨兵服务 redis-server sentinel.conf --sentinel &
    //查看哨兵信息 redis-cli -h 192.168.0.108 -p 26379 info Sentinel
}
