package top.doperj.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.doperj.product.domain.SKU;
import top.doperj.product.service.SKUChoiceService;
import top.doperj.product.service.SKUService;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EShopProductSKUTests {
    @Autowired
    SKUService skuService;

    @Autowired
    SKUChoiceService skuChoiceService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

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
            7599, //银色-双网通-256GB
            7099, //深空灰色-公开版-64GB-官方标配
            8388, //深空灰色-公开版-64GB-移动专享
            8299, //深空灰色-公开版-256GB-官方标配
            9688, //深空灰色-公开版-256GB-移动专享
            8898, //深空灰色-原厂延保版-64GB
            10098, //深空灰色-原厂延保版-256GB
    };
    Integer[] appleMacBookSKUs = {};
    Integer[] appleIPadSKUs = {};

    String[][][] appleIPhoneSKUAttributeAndChoices = {
            {
                    {"颜色", "银色"},
                    {"版本", "公开版"},
                    {"容量", "64GB"},
                    {"购买方式", "官方标配"},
            },
            {
                    {"颜色", "银色"},
                    {"版本", "公开版"},
                    {"容量", "64GB"},
                    {"购买方式", "移动-移动专享版"},
            },
            {
                    {"颜色", "银色"},
                    {"版本", "公开版"},
                    {"容量", "256GB"},
                    {"购买方式", "官方标配"},
            },
            {
                    {"颜色", "银色"},
                    {"版本", "公开版"},
                    {"容量", "256GB"},
                    {"购买方式", "移动-移动专享版"},
            },
            {
                    {"颜色", "银色"},
                    {"版本", "原厂延保版"},
                    {"容量", "64GB"},
                    {"购买方式", "官方标配"},
            },
            {
                    {"颜色", "银色"},
                    {"版本", "原厂延保版"},
                    {"容量", "256GB"},
                    {"购买方式", "官方标配"},
            },
            {
                    {"颜色", "银色"},
                    {"版本", "双网通版"},
                    {"容量", "64GB"},
                    {"购买方式", "官方标配"},
            },
            {
                    {"颜色", "银色"},
                    {"版本", "双网通版"},
                    {"容量", "256GB"},
                    {"购买方式", "官方标配"},
            },
            {
                    {"颜色", "深空灰色"},
                    {"版本", "公开版"},
                    {"容量", "64GB"},
                    {"购买方式", "官方标配"},
            },
            {
                    {"颜色", "深空灰色"},
                    {"版本", "公开版"},
                    {"容量", "64GB"},
                    {"购买方式", "移动-移动专享版"},
            },
            {
                    {"颜色", "深空灰色"},
                    {"版本", "公开版"},
                    {"容量", "256GB"},
                    {"购买方式", "官方标配"},
            },
            {
                    {"颜色", "深空灰色"},
                    {"版本", "公开版"},
                    {"容量", "256GB"},
                    {"购买方式", "移动-移动专享版"},
            },
            {
                    {"颜色", "深空灰色"},
                    {"版本", "原厂延保版"},
                    {"容量", "64GB"},
                    {"购买方式", "官方标配"},
            },
            {
                    {"颜色", "深空灰色"},
                    {"版本", "原厂延保版"},
                    {"容量", "256GB"},
                    {"购买方式", "官方标配"},
            },
    };

    @Test
    public void addAppleIPhoneSKUAttributeAndChoices() throws Exception {
        int len = appleIPhoneSKUAttributeAndChoices.length;
        if (len != 14) {
            logger.error("Bad Length!");
            throw new Exception();
        }
        for (int i = 0; i < len; i++) {
            SKU sku = skuService.findAllSKUs().get(i);
            skuService.addSKUChoiceBatch(appleIPhoneSKUAttributeAndChoices[i], sku.getSkuId());
        }
    }

    @Test
    public void findAppleIPhoneSKUChoices() throws Exception {
        Iterator<SKU> iterator = skuService.findAllSKUs().iterator();
        while (iterator.hasNext()) {
            SKU sku = iterator.next();
            System.out.println(sku);
            System.out.println(skuChoiceService.findSKUChoiceBySKUId(sku.getSkuId()));
        }
    }

    @Test
    public void findAllSKUs() throws Exception {
        System.out.println(skuService.findAllSKUs());
    }

    @Test
    public void findSKUByProductName() throws Exception {
        System.out.println(skuService.findSKUByProductName("Apple iPhone X(A1865)"));
    }

    @Test
    public void findSKUByCategoryName() throws Exception {
        //System.out.println(skuService.findSKUByCategoryName("电脑办公"));
        System.out.println(skuService.findSKUByCategoryName("手机数码"));
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

    @Test
    public void findSKUBySKUAttributeAndChoiceMap() throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("颜色", "深空灰色");
        //map.put("颜色", "银色");
        map.put("版本", "公开版");
        //map.put("版本", "移动-移动专享版");
        map.put("购买方式", "官方标配");
        //map.put("购买方式", "官方标配");
        map.put("容量", "256GB");
        System.out.println(skuService.findSKUBySKUAttributeAndChoiceMap(map));
    }
}
