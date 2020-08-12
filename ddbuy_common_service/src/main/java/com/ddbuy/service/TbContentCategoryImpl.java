package com.ddbuy.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ddbuy.entity.TbContentCategory;
import com.ddbuy.entity.TbContentCategoryExample;
import com.ddbuy.mapper.TbContentCategoryMapper;
import com.ddbuy.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service(interfaceClass = TbContentCategoryService.class)
@Component
public class TbContentCategoryImpl implements TbContentCategoryService{
    @Autowired(required = false)
    private TbContentCategoryMapper tbContentCategoryMapper;
    @Override
    public PageInfo<TbContentCategory> getTbContentCategory(Page page) {
        PageHelper.startPage(page.getPage(),page.getRows());
        List<TbContentCategory> tbContentCategories = tbContentCategoryMapper.selectByExample(new TbContentCategoryExample());
        PageInfo<TbContentCategory> tbContPageInfo = new PageInfo<>(tbContentCategories);
        return tbContPageInfo;
    }
    @Override
    public PageInfo<TbContentCategory> getTbContentCategory1() {
        List<TbContentCategory> tbContentCategories = tbContentCategoryMapper.selectByExample(new TbContentCategoryExample());
        return new PageInfo<>(tbContentCategories);
    }
}
