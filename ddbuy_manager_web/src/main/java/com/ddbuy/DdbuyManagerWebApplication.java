package com.ddbuy;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubboConfiguration
@SpringBootApplication
public class DdbuyManagerWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DdbuyManagerWebApplication.class, args);
    }

}
