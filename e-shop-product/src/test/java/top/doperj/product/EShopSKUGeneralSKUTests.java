package top.doperj.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.doperj.product.service.SKUService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EShopSKUGeneralSKUTests {
    @Autowired
    SKUService skuService;

    @Test
    public void searchSKU() throws Exception {
        System.out.println(skuService.findSKUByPartialName("ipad"));
    }
}
