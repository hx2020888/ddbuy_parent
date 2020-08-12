package com.ddbuy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.service.TestHello;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @Reference(interfaceClass = TestHello.class)
    private TestHello testHello;

    @RequestMapping("/getHw")
    @ResponseBody
    public String getHw(){
        return testHello.getHW();
    }

    @RequestMapping("/test1")
    public String test1(){
        return "jsp/test.jsp";
    }
}
