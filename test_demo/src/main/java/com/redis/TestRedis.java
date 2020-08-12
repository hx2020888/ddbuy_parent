package com.redis;

import redis.clients.jedis.Jedis;

public class TestRedis {
    // 操作字符串
    public static void main(String[] args) {
// 创建 jedis 对象
        Jedis jedis=new Jedis("localhost",6379);
// 通过 jedis 对象操作键值对系统
        jedis.set("name"," 张三");// 设置键值
// 获取值
        String s = jedis.get("name");
        System.out.println("获取的值为： " + s);
// 保存有效期 60 秒
        jedis.expire("name",60);
        // 睡眠时间
        // Thread.sleep(10000);
// 关闭
        jedis.close();
    }
}