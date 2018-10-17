package top.doperj.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.doperj.product.service.SKUAttributeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EShopProductSKUAttributeTests {
    String[] skuAttributeBatch = {"颜色", "版本", "容量", "购买方式"};

    @Autowired
    SKUAttributeService skuAttributeService;

    @Test
    public void findAllSKUAttribute() throws Exception {
        System.out.println(skuAttributeService.findAllSKUAttributes());
    }

    @Test
    public void addSKUAttributeBatch() throws Exception {
        skuAttributeService.addSKUAttributeBatch(skuAttributeBatch);
        System.out.println(skuAttributeService.findAllSKUAttributes());
    }

    @Test
    public void removeSKUAttributeBatch() throws Exception {
        skuAttributeService.removeSKUAttributeBatch(skuAttributeBatch);
        System.out.println(skuAttributeService.findAllSKUAttributes());
    }
}
