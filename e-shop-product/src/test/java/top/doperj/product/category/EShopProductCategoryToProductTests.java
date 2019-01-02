package top.doperj.product.category;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.doperj.product.service.CategoryService;
import top.doperj.product.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EShopProductCategoryToProductTests {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Test
    public void findProductsByCategoryName() {
        //System.out.println(productService.findProductByCategoryName("手机"));
        //System.out.println(productService.findProductByCategoryName("电脑办公"));
        System.out.println(productService.findProductByCategoryName("电子产品"));
    }
}
