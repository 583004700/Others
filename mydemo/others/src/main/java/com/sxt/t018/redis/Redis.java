package com.sxt.t018.redis;

public class Redis {
    //String类型
    //设置值 set key value
    //获取值 get key
    //如果不存在则设置值 setnx key value
    //删除值 del key
    //设置有效期的值 setex key 10 value
    //替换 setrange key 10 value
    //设置多个值 mset key1 value1 key2 value2
    //获取多个值 mget key1 key2
    //返回旧值并设置新值 getset key value
    //自增 incr key
    //自减 decr key
    //指定步长增加 incrby key 3
    //指定步长减小 decrby key 3
    //字符串追加 append key [字符串]
    //获取字符串长度 strlen key
    //Hash类型
    //设置值 hset hashkey key value
    //获取值 hget hashkey key
    //设置多个值 hmset hashkey key1 value1 key2 value2
    //获取多个值 hmget hashkey key1 key2
    //判断某个键是否存在 hexists hashkey key
    //获取键的数量 hlen hashkey
    //删除指定键 hdel hashkey key
    //获取所有键 hkeys hashkey
    //获取所有值 hvals hashkey
    //获取所有键值对 hgetall myhash
    //List类型
    //从左边（头部）添加 lpush listkey value
    //从右边（尾部）添加 rpush listkey value
    //从左边（头部）弹出 lpop listkey
    //从右边（尾部）弹出 rpop listkey
    //从0开始至结束找 lrange listkey 0 -1
    //在value1之前插入元素value2 linsert listkey before value1 value2
    //将下标为0的元素替换为b lset listkey 0 b
    //删除count个b元素,如果count>0，则从开始数，如果count<0，则从末尾开始数，如果count=0，则删除所有， 返回删除的个数 lrem listkey count b
    //rpoplpush 从尾部删除并从头部添加
    //lindex 获取下标为index的值
    //llen 获取长度
    //set类型
    //添加元素 sadd setkey value
    //获取所有元素 smembers setkey
}
