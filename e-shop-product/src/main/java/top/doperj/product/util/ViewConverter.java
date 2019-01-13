package top.doperj.product.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.doperj.product.domain.SKU;
import top.doperj.product.domain.SKUChoice;
import top.doperj.product.service.ProductService;
import top.doperj.product.service.SKUChoiceService;
import top.doperj.service.Entity.SKUView;

import javax.annotation.PostConstruct;
import java.util.Iterator;

@Component
public class ViewConverter {
    @Autowired
    private ProductService productServiceHelper;

    private static ProductService productService;

    @Autowired
    private SKUChoiceService skuChoiceServiceHelper;

    private static SKUChoiceService skuChoiceService;

    @PostConstruct
    public void init() {
        productService = productServiceHelper;
        skuChoiceService = skuChoiceServiceHelper;
    }

    public SKUView convert(SKU sku) {
        SKUView skuView = new SKUView();
        skuView.setOriginalPrice(sku.getOriginalPrice());;
        if (sku.getSalePrice() == null) {
            skuView.setSalePrice(skuView.getOriginalPrice());
            skuView.setDiscount(0);;
        } else {
            skuView.setSalePrice(sku.getSalePrice());
            skuView.setDiscount((int)((skuView.getOriginalPrice() - skuView.getSalePrice()) / skuView.getOriginalPrice() * 100));
        }
        skuView.setStockQuantity(sku.getStockQuantity());
        skuView.setPhotoUrl(sku.getPhotoUrl());
/*        System.out.println(sku.getProductId());
        System.out.println(productService);
        System.out.println(productService.findProductById(sku.getProductId()));*/
        skuView.setProductName(productService.findProductById(sku.getProductId()).getProductName());
/*        skuView.setSkuChoices(skuChoiceService.findSKUChoiceBySKUId(sku.getSkuId()));*/
        String skuName = skuView.getProductName();
        Iterator<SKUChoice> skuViewIterator = skuChoiceService.findSKUChoiceBySKUId(sku.getSkuId()).iterator();
        while (skuViewIterator.hasNext()) {
            skuName += " ";
            skuName += skuViewIterator.next().getSkuChoiceName();
        }
        skuView.setSkuName(skuName);
        return skuView;
    }
}
