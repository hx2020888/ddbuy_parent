package com.ddbuy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.entity.TbContentCategory;
import com.ddbuy.service.TbContentCategoryService;
import com.ddbuy.util.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestTb {
    @Reference(interfaceClass = TbContentCategoryService.class)
    private TbContentCategoryService tbContentCategoryService;

/*    @RequestMapping("/getTb")
    @ResponseBody
    public List<TbContentCategory> getAll(){
        PageInfo<TbContentCategory> tbContentCategory = tbContentCategoryService.getTbContentCategory();
        System.out.println("tbContentCategory = " + tbContentCategory);
        return tbContentCategory;
    }*/
        @RequestMapping("/getPage")
        public String getPage(Model model){
            Page page =new Page();
            PageInfo<TbContentCategory> tbContentCategory = tbContentCategoryService.getTbContentCategory(page);
            System.out.println("tbContentCategory = " + tbContentCategory);
            model.addAttribute("tbCS",tbContentCategory);
            return "jsp/test.jsp";
        }
        @RequestMapping("/getTbContentCategory")
        public Map<String,Object> getPage(Page page){
            PageInfo<TbContentCategory> tbContentCategory = tbContentCategoryService.getTbContentCategory(page);
            Map<String,Object> map =new HashMap<>();
            map.put("total",tbContentCategory.getTotal());
            map.put("rows",tbContentCategory.getList());
            System.out.println("map = " + map);
            return map;
        }
        @RequestMapping("/getAllTbContentCategory")
        public List<TbContentCategory> getAllTbContentCategory(Page page){
            PageInfo<TbContentCategory> tbContentCategory = tbContentCategoryService.getTbContentCategory1();
            return tbContentCategory.getList();
        }





















}
