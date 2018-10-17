package top.doperj.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.doperj.product.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EShopProductProductTests {
    @Autowired
    ProductService productService;

    String[] appleIPhoneProducts = {"Apple iPhone X(A1865)", "Apple iPhone 6s Plus (A1699)", "Apple iPhone XS Max(A2104)",
            "Apple iPhone XS (A2100)"};
    String[] appleMacBookProducts = {"Apple MacBook Pro (2017款)", "Apple MacBook Pro (2018新款)"};
    String[] appleIPadProducts = {"Apple iPad (2018新款)", "Apple iPad mini 4", "Apple 2017 新苹果 new iPad", "Apple iPad Pro"};

    @Test
    public void findAllProducts() throws Exception {
        System.out.println(productService.findAllProducts());
    }

    @Test
    public void findProductByName() throws Exception {
        System.out.println(productService.findProductByName("Apple iPhone X(A1865)"));
    }

    @Test
    public void addProducts() throws Exception {
        //System.out.println(productService.addProductBatch(appleIPhoneProducts));
        //System.out.println(productService.addProductBatch(appleMacBookProducts));
        System.out.println(productService.addProductBatch(appleIPadProducts));
        System.out.println(productService.findAllProducts());
    }

    @Test
    public void setProductCategoryBatch() throws Exception {
        //productService.setProductCategoryBatch(appleIPhoneProducts, "手机");
        productService.setProductCategoryBatch(appleMacBookProducts, "电脑");
        productService.setProductCategoryBatch(appleIPadProducts, "平板电脑");
    }

    @Test
    public void findAllSKUAttributesAndSKUChoicesByName() throws Exception {
        System.out.println(productService.findProductSKUAttributeAndChoices("Apple iPhone X(A1865)"));
    }
}
