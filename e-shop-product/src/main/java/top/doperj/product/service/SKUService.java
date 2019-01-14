package top.doperj.product.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.doperj.product.dao.*;
import top.doperj.product.domain.*;
import top.doperj.service.Entity.SKUView;

import java.util.*;

@Service
public class SKUService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProductService productService;

    @Autowired
    SKUMapper skuDAO;

    @Autowired
    BrandService brandService;

    @Autowired
    SKUAndSKUChoiceService skuAndSKUChoiceService;

    @Autowired
    SKUAttributeService skuAttributeService;

    @Autowired
    SKUChoiceService skuChoiceService;


    public List<SKU> findAllSKUs() {
        return skuDAO.selectAllSKUs();
    }

    public List<SKU> findSKUByProductName(String name) {
        return skuDAO.selectSKUByProductName(name);
    }

    public List<SKU> findSKUByCategoryName(String categoryName) {
        return skuDAO.selectSKUByCategoryName(categoryName);
    }

    public List<SKU> findSKUbySKUIdList(List<Integer> skuIdList) {
        return skuDAO.selectSKUBySKUIdList(skuIdList);
    }

    public int addSKU(SKU sku) {
        return skuDAO.insertSelective(sku);
    }

    public void addSKUBatchByPrices(Integer[] batch) {
        skuDAO.insertSKUBatch(Arrays.asList(batch));
    }

    public void setSKUProductBatch(Integer[] arr, String productName) {
        Product product = productService.findProductByName(productName);
        if (product == null) {
            System.out.println("No category named: " + productName);
            return;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", Arrays.asList(arr));
        map.put("productId", product.getProductId());
        skuDAO.setSKUProductBatch(map);
    }

    public void setSKUChoice(String skuAttributeName, String skuChoiceName, Integer skuId) {
        SKUAttribute skuAttribute = skuAttributeService.findSKUAttributeByName(skuAttributeName);
        if (skuAttribute == null) {
            logger.error("No sku attribute named: " + skuAttributeName);
            return;
        }
        SKUChoice skuChoice = skuChoiceService.findSKUChoiceByAttributeAndName(skuAttribute.getSkuAttributeName(), skuChoiceName);
        if (skuChoice == null) {
            logger.error("No sku choice named: " + skuChoiceName);
            return;
        }
        SKUAndSKUChoice skuAndSKUChoice = new SKUAndSKUChoice();
        skuAndSKUChoice.setSkuId(skuId);
        skuAndSKUChoice.setSkuChoiceId(skuChoice.getSkuChoiceId());
        skuAndSKUChoiceService.addSKUAndSKUChoice(skuAndSKUChoice);
    }

    public void addSKUChoiceBatch(String[][] skuAttributeAndChoiceBatch, Integer skuId) {
        int len = skuAttributeAndChoiceBatch.length;
        String skuAttributeName, skuChoiceName;
        SKUAttribute skuAttribute;
        SKUChoice skuChoice;
        List<Integer> skuChoiceList = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            skuAttributeName = skuAttributeAndChoiceBatch[i][0];
            skuChoiceName = skuAttributeAndChoiceBatch[i][1];
            setSKUChoice(skuAttributeName, skuChoiceName, skuId);
        }
    }

    // 根据SKU属性-选项对应表获取SKU
    public List<SKU> findSKUBySKUAttributeAndChoiceMap(Map<String, String> map) {
        Set<String> keySet = map.keySet();
        Iterator<String> keyIterator = keySet.iterator();
        List<Integer> skuChoiceIdList = new LinkedList<Integer>();
        while (keyIterator.hasNext()) {
            String skuAttributeName = keyIterator.next();
            String skuChoiceName = map.get(skuAttributeName);
            SKUAttribute skuAttribute = skuAttributeService.findSKUAttributeByName(skuAttributeName);
            if (skuAttribute == null) {
                logger.error("No sku attribute named: " + skuAttributeName);
                return null;
            }
            SKUChoice skuChoice = skuChoiceService.findSKUChoiceByAttributeAndName(skuAttribute.getSkuAttributeName(), skuChoiceName);
            if (skuChoice == null) {
                logger.error("No sku choice named: " + skuChoiceName);
                return null;
            }
            skuChoiceIdList.add(skuChoice.getSkuChoiceId());
        }
        System.out.println(skuChoiceIdList);
        return skuDAO.selectSKUBySKUAttributeAndChoiceMap(skuChoiceIdList);
    }

    public SKUView convertSKUToView(SKU sku) {
        SKUView skuView = new SKUView();
//        Integer skuId;
        skuView.setSkuId(sku.getSkuId());
//        String productName;
        skuView.setProductName(productService.findProductById(sku.getProductId()).getProductName());
//        String skuName;
        String skuName = skuView.getProductName();
        Iterator<SKUChoice> skuViewIterator = skuChoiceService.findSKUChoiceBySKUId(sku.getSkuId()).iterator();
        while (skuViewIterator.hasNext()) {
            skuName += " ";
            skuName += skuViewIterator.next().getSkuChoiceName();
        }
        skuView.setSkuName(skuName);
//        String brandName;
        skuView.setBrandName(brandService.findBrandBySKUId(sku.getSkuId()).getBrandName());
//        float originalPrice;
        skuView.setOriginalPrice(sku.getOriginalPrice());;
        if (sku.getSalePrice() == null) {
//        float salePrice;
            skuView.setSalePrice(skuView.getOriginalPrice());
//        Integer discount;
            skuView.setDiscount(0);;
        } else {
            skuView.setSalePrice(sku.getSalePrice());
            skuView.setDiscount((int)((skuView.getOriginalPrice() - skuView.getSalePrice()) / skuView.getOriginalPrice() * 100));
        }
//        Integer stockQuantity;
        skuView.setStockQuantity(sku.getStockQuantity());
//        String photoUrl;
        skuView.setPhotoUrl(sku.getPhotoUrl());
        return skuView;
    }

    public List<SKU> findSKUByPartialName(String partialName) {
        return skuDAO.selectSKUByNameLike(partialName);
    }
}
