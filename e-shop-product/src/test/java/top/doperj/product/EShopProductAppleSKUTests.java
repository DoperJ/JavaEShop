package top.doperj.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.doperj.product.domain.SKU;
import top.doperj.product.service.SKUChoiceService;
import top.doperj.product.service.SKUService;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EShopProductAppleSKUTests {
    @Autowired
    SKUService skuService;

    @Autowired
    SKUChoiceService skuChoiceService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    String[] appleIPhoneProducts = {"Apple iPhone X(A1865)", "Apple iPhone 6s Plus (A1699)", "Apple iPhone XS Max(A2104)",
            "Apple iPhone XS (A2100)"};
    String[] appleMacBookProducts = {"Apple MacBook Pro (2017款)", "Apple MacBook Pro (2018新款)"};
    String[] appleIPadProducts = {"Apple iPad (2018新款)", "Apple iPad mini 4", "Apple 2017 新苹果 new iPad", "Apple iPad Pro"};

    Integer[] appleIPad2018SKUsPrices = {
            2999, //金色-WIFI版-128GB-官方标配
            2999, //银色-WIFI版-128GB-官方标配
            2999, //深空灰色-WIFI版-128GB-官方标配
            2365, //金色-WIFI版-32GB-官方标配
            2365, //银色-WIFI版-32GB-官方标配
            2365, //深空灰色-WIFI版-32GB-官方标配
            3978, //金色-Cellular版-128GB-官方标配
            3978, //银色-Cellular版-128GB-官方标配
            3978, //深空灰色-Cellular版-128GB-官方标配
            3288, //金色-Cellular版-32GB-官方标配
            3288, //银色-Cellular版-32GB-官方标配
            3288, //深空灰色-Cellular版-32GB-官方标配
    };

    String[][][] appleIPad2018SKUAttributeAndChoices = {
            {
                    {"颜色", "金色"},
                    {"版本", "WIFI版"},
                    {"容量", "128GB"},
                    {"购买方式", "官方标配"},
            },
            {
                    {"颜色", "银色"},
                    {"版本", "WIFI版"},
                    {"容量", "128GB"},
                    {"购买方式", "官方标配"},
            },
            {
                    {"颜色", "深空灰色"},
                    {"版本", "WIFI版"},
                    {"容量", "128GB"},
                    {"购买方式", "官方标配"},
            },
            {
                    {"颜色", "金色"},
                    {"版本", "WIFI版"},
                    {"容量", "32GB"},
                    {"购买方式", "官方标配"},
            },
            {
                    {"颜色", "银色"},
                    {"版本", "WIFI版"},
                    {"容量", "32GB"},
                    {"购买方式", "官方标配"},
            },
            {
                    {"颜色", "深空灰色"},
                    {"版本", "WIFI版"},
                    {"容量", "32GB"},
                    {"购买方式", "官方标配"},
            },
            {
                    {"颜色", "金色"},
                    {"版本", "Cellular版"},
                    {"容量", "128GB"},
                    {"购买方式", "官方标配"},
            },
            {
                    {"颜色", "银色"},
                    {"版本", "Cellular版"},
                    {"容量", "128GB"},
                    {"购买方式", "官方标配"},
            },
            {
                    {"颜色", "深空灰色"},
                    {"版本", "Cellular版"},
                    {"容量", "128GB"},
                    {"购买方式", "官方标配"},
            },
            {
                    {"颜色", "金色"},
                    {"版本", "Cellular版"},
                    {"容量", "32GB"},
                    {"购买方式", "官方标配"},
            },
            {
                    {"颜色", "银色"},
                    {"版本", "Cellular版"},
                    {"容量", "32GB"},
                    {"购买方式", "官方标配"},
            },
            {
                    {"颜色", "深空灰色"},
                    {"版本", "Cellular版"},
                    {"容量", "32GB"},
                    {"购买方式", "官方标配"},
            },
    };

    @Test
    public void addAppleIPad2018SKU() throws Exception {
/*        System.out.println(skuService);
        skuService.addSKUBatchByPrices(appleIPad2018SKUsPrices);
        skuService.setSKUProductBatch(appleIPad2018SKUsPrices, "Apple iPad (2018新款)");
        System.out.println(skuService.findAllSKUs());*/

        int[] skuIds = {42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53};
        int len = appleMacBookPro2017SKUAttributeAndChoices.length;
        for (int i = 0; i < len; i++) {
            skuService.addSKUChoiceBatch(appleIPhoneXSKUAttributeAndChoices[i], skuIds[i]);
        }
    }

    Integer[] appleMacBookPro2017SKUPrices = {
            9099, //银色-8+128G-i5-13.3-官方标配
            9099, //灰色-8+128G-i5-13.3-官方标配
            10499, //银色-8+256GB-i5-13.3-官方标配
            10499, //灰色-8+256GB-i5-13.3-官方标配
    };

    String[][][] appleMacBookPro2017SKUAttributeAndChoices = {
            {
                    {"颜色", "银色"},
                    {"容量", "8+128GB"},
                    {"处理器", "i5"},
                    {"尺寸", "13.3寸"},
                    {"购买方式", "官方标配"},
            },
            {
                    {"颜色", "灰色"},
                    {"容量", "8+128GB"},
                    {"处理器", "i5"},
                    {"尺寸", "13.3寸"},
                    {"购买方式", "官方标配"},
            },
            {
                    {"颜色", "银色"},
                    {"容量", "8+256GB"},
                    {"处理器", "i5"},
                    {"尺寸", "13.3寸"},
                    {"购买方式", "官方标配"},
            },
            {
                    {"颜色", "灰色"},
                    {"容量", "8+256GB"},
                    {"处理器", "i5"},
                    {"尺寸", "13.3寸"},
                    {"购买方式", "官方标配"},
            },
    };

    @Test
    public void addAppleMacBookPro2017SKU() throws Exception {
/*        System.out.println(skuService);
        skuService.addSKUBatchByPrices(appleMacBookPro2017SKUPrices);
        skuService.setSKUProductBatch(appleMacBookPro2017SKUPrices, "Apple MacBook Pro (2017款)");
        System.out.println(skuService.findAllSKUs());*/

        int[] skuIds = {38, 39, 40, 41};
        int len = appleMacBookPro2017SKUAttributeAndChoices.length;
        for (int i = 0; i < len; i++) {
            skuService.addSKUChoiceBatch(appleIPhoneXSKUAttributeAndChoices[i], skuIds[i]);
        }
    }


    // IPhone X
    Integer[] appleIPhoneXSKUPrices = {
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
    String[][][] appleIPhoneXSKUAttributeAndChoices = {
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
                    {"购买方式", "官方标配"},
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
                    {"购买方式", "官方标配"},
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
    public void addSKUByPrices() throws Exception {
        System.out.println(skuService);
        skuService.addSKUBatchByPrices(appleIPhoneXSKUPrices);
        skuService.setSKUProductBatch(appleIPhoneXSKUPrices, "Apple iPhone X(A1865)");
        System.out.println(skuService.findAllSKUs());
    }

    @Test
    public void addAppleIPhoneSKUAttributeAndChoices() throws Exception {
        int len = appleIPhoneXSKUAttributeAndChoices.length;
        if (len != 14) {
            logger.error("Bad Length!");
            throw new Exception();
        }
        for (int i = 0; i < len; i++) {
            SKU sku = skuService.findAllSKUs().get(i);
            skuService.addSKUChoiceBatch(appleIPhoneXSKUAttributeAndChoices[i], sku.getSkuId());
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
