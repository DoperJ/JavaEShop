package top.doperj.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.doperj.product.service.SKUService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EShopProductSKUTests {
    @Autowired
    SKUService skuService;

    String[] appleIPhoneProducts = {"Apple iPhone X(A1865)", "Apple iPhone 6s Plus (A1699)", "Apple iPhone XS Max(A2104)",
            "Apple iPhone XS (A2100)"};
    String[] appleMacBookProducts = {"Apple MacBook Pro (2017款)", "Apple MacBook Pro (2018新款)"};
    String[] appleIPadProducts = {"Apple iPad (2018新款)", "Apple iPad mini 4", "Apple 2017 新苹果 new iPad", "Apple iPad Pro"};

    Integer[] appleIPhoneSKUPrices = {
            7099, //银色-公开版-64GB-官方标配
            8388, //银色-公开版-64GB-移动专享
            8299, //银色-公开版-256GB-官方标配
            9688, //银色-公开版-256GB-移动专享
            8898, //银色-原厂延保版-64GB
            10098, //银色-原厂延保版-256GB
            6499, //银色-双网通-64GB
            7599, //银色-原厂延保版-256GB
            7099, //深空灰色-公开版-64GB-官方标配
            8388, //深空灰色-公开版-64GB-移动专享
            8299, //深空灰色-公开版-256GB-官方标配
            9688, //深空灰色-公开版-256GB-移动专享
            8898, //深空灰色-原厂延保版-64GB
            10098, //深空灰色-原厂延保版-256GB
            };
    Integer[] appleMacBookSKUs = {};
    Integer[] appleIPadSKUs = {};

    @Test
    public void findAllSKUs() throws Exception {
        System.out.println(skuService.findAllSKUs());
    }

    @Test
    public void findSKUByProductName() throws Exception {
        skuService.findSKUByProductName("Apple iPhone X(A1865)");
    }

    @Test
    public void addSKUByPrices() throws Exception {
        System.out.println(skuService);
        skuService.addSKUBatchByPrices(appleIPhoneSKUPrices);
        System.out.println(skuService.findAllSKUs());
    }

    @Test
    public void setSKUProducts() throws Exception {
        skuService.setSKUProductBatch(appleIPhoneSKUPrices, "Apple iPhone X(A1865)");
    }
}
