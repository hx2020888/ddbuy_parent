package com.ddbuy;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.service.TbContentCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DdbuyProtalWebApplicationTests {
    @Reference(interfaceClass = TbContentCategoryService.class)
    private TbContentCategoryService tbContentCategoryService;
    @Test
   public void contextLoads() {
        System.out.println("测试...");
    }

}
