package com.ddbuy.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = TestHello.class)
public class TestHelloImpl implements TestHello{
    @Override
    public String getHW() {
        return "Hello world";
    }
}
