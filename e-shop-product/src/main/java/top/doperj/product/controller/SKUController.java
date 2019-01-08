package top.doperj.product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.doperj.product.domain.SKU;
import top.doperj.product.service.SKUService;

import java.util.List;

@RestController
@RequestMapping("/api/sku")
public class SKUController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SKUService skuService;

    @GetMapping(value = "", produces = "application/json")
    public List<SKU> getAllSKU() {
        return skuService.findAllSKUs();
    }

    @GetMapping(value = "/{category}", produces = "application/json")
    public List<SKU> getSKUByCategory(@PathVariable("category") String categoryName) {
        return skuService.findSKUByCategoryName(categoryName);
    }
}