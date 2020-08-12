package com.ddbuy.service;

import com.ddbuy.entity.TbContentCategory;
import com.ddbuy.util.Page;
import com.github.pagehelper.PageInfo;

public interface TbContentCategoryService {
    // 广告类型的接口
    public PageInfo<TbContentCategory> getTbContentCategory(Page page);

    PageInfo<TbContentCategory> getTbContentCategory1();
}
