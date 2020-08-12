package com.ddbuy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.entity.TbContent;
import com.ddbuy.service.TbContentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TbContentController {
    @Reference(interfaceClass = TbContentService.class)
    private TbContentService tbContentService;
    @RequestMapping("/goIndex")
    public String goIndex(Model model){
// 调用业务查询广告
        List<TbContent> list = tbContentService.getAllTbContent();
        model.addAttribute("list",list);
        return "Index";
    }
}
