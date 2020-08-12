package com.ddbuy.service;

import com.ddbuy.entity.TbContent;

import java.util.List;

public interface TbContentService {
    // 添加广告
    public int addContent(TbContent content);
    // 门户查询广告业务
    public List<TbContent> getAllTbContent();
}
