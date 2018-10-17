package top.doperj.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.doperj.product.service.SKUChoiceService;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EShopProductSKUChoiceTests {
    String[] skuChoicesForColor = {"银色", "深空灰色"};
    String[] skuChoicesForVersion = {"公开版", "原厂延保版", "双网通版"};
    String[] skuChoicesForStorage = {"64GB", "256GB"};
    String[] skuChoicesForWay = {"官方标配", "移动-移动专享版"};

    @Autowired
    SKUChoiceService skuChoiceService;

    // Read
    @Test
    public void findAllSKUChoices() throws Exception {
        System.out.println(skuChoiceService.findAllSKUChoices());
    }

    @Test
    public void findSKUChoiceByName() throws Exception {
        System.out.println(skuChoiceService.findSKUChoiceByAttributeAndName("颜色", "银色"));
    }

    @Test
    public void findSKUChoicesByProductName() throws Exception {
        System.out.println(skuChoiceService.findSKUChoicesByProductName("Apple iPhone X(A1865)"));
    }

    //@Test
    public void addSKUChoiceForColorBatch() throws Exception {
        skuChoiceService.addSKUChoiceBatch(skuChoicesForColor);
        System.out.println(skuChoiceService.findAllSKUChoices());
    }

    @Test
    public void setSKUAttributeForColorBatch() throws Exception {
        skuChoiceService.setSKUAttributeByNameBatch(skuChoicesForColor, "颜色");
        System.out.println(skuChoiceService.findAllSKUChoices());
    }

    @Test
    public void addSKUChoiceForVersionBatch() throws Exception {
        skuChoiceService.addSKUChoiceBatch(skuChoicesForVersion);
        System.out.println(skuChoiceService.findAllSKUChoices());
    }

    @Test
    public void setSKUAttributeForVersionBatch() throws Exception {
        skuChoiceService.setSKUAttributeByNameBatch(skuChoicesForVersion, "版本");
        System.out.println(skuChoiceService.findAllSKUChoices());
    }

    @Test
    public void addSKUChoiceForStorageBatch() throws Exception {
        skuChoiceService.addSKUChoiceBatch(skuChoicesForStorage);
        System.out.println(skuChoiceService.findAllSKUChoices());
    }

    @Test
    public void setSKUChoiceForStorageBatch() throws Exception {
        skuChoiceService.setSKUAttributeByNameBatch(skuChoicesForStorage, "容量");
        System.out.println(skuChoiceService.findAllSKUChoices());
    }

    @Test
    public void addSKUChoiceForWayBatch() throws Exception {
        skuChoiceService.addSKUChoiceBatch(skuChoicesForWay);
        System.out.println(skuChoiceService.findAllSKUChoices());
    }

    @Test
    public void setSKUChoiceForWayBatch() throws Exception {
        skuChoiceService.setSKUAttributeByNameBatch(skuChoicesForWay, "购买方式");
        System.out.println(skuChoiceService.findAllSKUChoices());
    }

    @Test
    public void removeSKUChoiceBatch() throws Exception {
    }
}
