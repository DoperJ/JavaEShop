package top.doperj.product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.doperj.product.domain.SKU;
import top.doperj.product.service.SKUService;
import top.doperj.product.util.ViewConverter;
import top.doperj.service.Entity.SKUView;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/sku")
public class SKUController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ViewConverter viewConverter;

    @Autowired
    SKUService skuService;

    @GetMapping(value = "", produces = "application/json")
    public List<SKUView> getAllSKU() {
        List<SKU> skuList = skuService.findAllSKUs();
        List<SKUView> skuViewList = new LinkedList<>();
        Iterator<SKU> skuIterator = skuList.iterator();
        while (skuIterator.hasNext()) {
            SKUView skuView = skuService.convertSKUToView(skuIterator.next());
            skuViewList.add(skuView);
        }
        //System.out.println(skuViewList);
        return skuViewList;
    }

    @GetMapping(value = "/{category}", produces = "application/json")
    public List<SKUView> getSKUByCategory(@PathVariable("category") String categoryName) {
        List<SKU> skuList = skuService.findSKUByCategoryName(categoryName);
        List<SKUView> skuViewList = new LinkedList<>();
        Iterator<SKU> skuIterator = skuList.iterator();
        while (skuIterator.hasNext()) {
            SKUView skuView = skuService.convertSKUToView(skuIterator.next());
            skuViewList.add(skuView);
        }
        //System.out.println(skuViewList);
        return skuViewList;
    }

    @GetMapping(value = "/List", produces = "application/json")
    public List<SKUView> getSKUBySKUIdList(@RequestParam("skuId") List<Integer> skuIdList) {
        System.out.println(skuIdList);
        List<SKU> skuList = skuService.findSKUbySKUIdList(skuIdList);
        List<SKUView> skuViewList = new LinkedList<>();
        Iterator<SKU> skuIterator = skuList.iterator();
        while (skuIterator.hasNext()) {
            SKUView skuView = skuService.convertSKUToView(skuIterator.next());
            skuViewList.add(skuView);
        }
        //System.out.println(skuViewList);
        return skuViewList;
    }

    @GetMapping(value = "/search", produces = "application/json")
    public List<SKUView> searchSKU(@RequestParam(value = "key")String key) {
        logger.info(key);
        List<SKU> skuList = skuService.findSKUByPartialName(key);
        logger.info(skuList.size() + " results is found.");
        List<SKUView> skuViewList = new LinkedList<>();
        Iterator<SKU> skuIterator = skuList.iterator();
        while (skuIterator.hasNext()) {
            SKUView skuView = skuService.convertSKUToView(skuIterator.next());
            skuViewList.add(skuView);
        }
        //System.out.println(skuViewList);
        return skuViewList;
    }
}