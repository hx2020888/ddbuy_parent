package ddbuy;

import com.ddbuy.service.TbContentCategoryImpl;
import com.sun.glass.ui.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DdbuyProtalWebApplicationTests {
    @Autowired(required = false)
    private TbContentCategoryImpl tbContentCategory;
    @Test
   public void contextLoads() {
        System.out.println("测试...");
/*        List<TbContentCategory> tbContentCategory1 = tbContentCategory.getTbContentCategory();
        System.out.println(tbContentCategory1);*/
    }

}
