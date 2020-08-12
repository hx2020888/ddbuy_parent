package com.ddbuy.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ddbuy.entity.TbContent;
import com.ddbuy.entity.TbContentExample;
import com.ddbuy.mapper.TbContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.List;

@Service(interfaceClass = TbContentService.class)
@Component
public class TbContentServiceImpl implements TbContentService {
    @Autowired(required = false)
    private TbContentMapper tbContentMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public int addContent(TbContent content) {
        return tbContentMapper.insertSelective(content);
    }
    @Override
    public List<TbContent> getAllTbContent() {
// 添加缓存支持
//1 、判断缓存是否存在广告的键
// 如果没有，去数据库查询，将结果保存到 Redis 中
// 如果有，直接提取缓存数据
//2 、 springboot 整合 Redis
        List<TbContent> list=null;
        ValueOperations<String,List<TbContent>> opiton=redisTemplate.opsForValue();
        if (redisTemplate.hasKey("contentkey")){
// 如果存在就从缓存中拿
            System.out.println(" 从缓存中取数据----");
            list=(List<TbContent>) opiton.get("contentkey");// 通过键取值
        }else {
// 不存在 , 从数据库查
            TbContentExample example=new TbContentExample();
            TbContentExample.Criteria criteria=example.createCriteria();
            criteria.andStatusEqualTo("1");// 状态为 1 （生效可用）
            list = tbContentMapper.selectByExample(example);
            System.out.println(" 查询数据库---");
// 第一次查完后将结合保存到 Redis 中，为第二次和以后访问 redis 缓存
            opiton.set("contentkey",list); // 还可以增加设置时间
        }
// 查询广告
/*TbContentExample example=new TbContentExample();
TbContentExample.Criteria criteria=example.createCriteria();
criteria.andStatusEqualTo("1");// 状态为 1 （生效可用）
List<TbContent> list = tbContentMapper.selectByExample(example);
*/
        return list;
    }
}
