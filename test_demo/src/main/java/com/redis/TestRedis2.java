package com.redis;

import redis.clients.jedis.Jedis;

public class TestRedis2 {
    public static void main(String[] args) throws InterruptedException {
// 创建 jedis 对象
        Jedis jedis=new Jedis("localhost",6379);
        // 判断
        if (jedis.exists("names"))
            jedis.del("names");
// 通过 jedis 对象操作键值对系统
        jedis.lpush("names"," 杨过"," 小龙女"," 郭靖");
// 获取长度
        long len=jedis.llen("names");
        System.out.println("有"+len+"个数据");
// 取值第一个元素
//        System.out.println("取值=" + jedis.lindex("names",0));
// 输出所有的元素
        for (int i=0;i<len;i++){
            System.out.println(jedis.lindex("names",i));
        }
        jedis.close();
    }
}