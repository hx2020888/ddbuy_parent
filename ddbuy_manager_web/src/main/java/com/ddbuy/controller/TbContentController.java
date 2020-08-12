package com.ddbuy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.entity.TbContent;
import com.ddbuy.service.TbContentService;
import com.ddbuy.util.FastDfsUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class TbContentController {
    @Value("${nginx.fastdfs.address}")//方便以后修改id只需要修改配置文件
    private String nginx_fastdfs_address;

    @Reference(interfaceClass = TbContentService.class)
    private TbContentService tbContentService;
    // 实现添加广告(强调返回值是json)
    @RequestMapping(value = "/addContent",produces = "application/json")
    public String addContent(TbContent content, @RequestParam("file") MultipartFile file){
        try {
//1 实现文件上传 springboot 实现文件上传，上传到 fastDFS
            String filename = file.getOriginalFilename();
            String extname = filename.substring(filename.lastIndexOf(".")+1);
// 运用 fastDSF 工具类上传
            String[] strings = FastDfsUtil.uploadFile(file.getBytes(), extname);
            System.out.println("图片上传成功");
//2 添加数据到数据库
            if (strings!=null){
                String url =nginx_fastdfs_address+"/"+strings[0]+"/"+strings[1];
                content.setPic(url);
                tbContentService.addContent(content);
                System.out.println("添加成功");
            }
            Integer i=1;
            return "{\"result\":"+i+"}";
        }catch (IOException e){
            e.printStackTrace();
            Integer i=0;
            return "{\"result\":"+i+"}";
        }
    }


}