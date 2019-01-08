package top.doperj.product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.doperj.product.domain.Category;
import top.doperj.product.domain.Product;
import top.doperj.product.domain.SKU;
import top.doperj.product.domain.SKUAttribute;
import top.doperj.product.service.CategoryService;
import top.doperj.product.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.*;
import org.json.JSONObject;
import top.doperj.product.service.SKUAttributeService;
import top.doperj.product.service.SKUService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @Autowired
    SKUAttributeService skuAttributeService;

    @Autowired
    SKUService skuService;


    @GetMapping(path = "/{categoryName}", produces = "application/json")
    public List<Product> getProductsByCategoryName(@PathVariable("categoryName") String categoryName) {
        return productService.findProductByCategoryName(categoryName);
    }

    @GetMapping(path = "/{categoryName}/{productName}", produces = "application/json")
    public Map<String, List<String>> getSKUAttributeAndSKUChoices(@PathVariable("productName") String productName) {
        return productService.findProductSKUAttributeAndChoices(productName);
    }

    @PostMapping(path = "/{categroyName}/{productName}", produces = "application/json")
    public SKU getSKUByChoices(HttpServletRequest request) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            String reqBody = URLDecoder.decode(sb.toString(), "UTF-8");
            logger.info("Request Body:" + reqBody);
            JSONObject json = new JSONObject(reqBody);
            Iterator<String> keyIterator = json.keys();
            Map<String, String> map = new HashMap<String, String>();
            while (keyIterator.hasNext()) {
                String skuAttributeName = keyIterator.next();
                map.put(skuAttributeName, json.getString(skuAttributeName));
            }
            logger.info("[getRequestPostJson][" + json
                    + "]-- get request body with json success.");
            List<SKU> skuList = skuService.findSKUBySKUAttributeAndChoiceMap(map);
            if (skuList.size() > 1) {
                logger.error("More than 1 SKU is found. Maybe more SKU choices should be provided!");
                return null;
            } else if (skuList.size() < 1) {
                logger.error("No SKU is found!");
                return null;
            } else {
                SKU sku = skuList.get(0);
                logger.info(sku + " is found.");
                return sku;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/search", produces = "application/json")
    public List<Product> searchProduct(@RequestParam(value = "key")String key) {
        logger.info(key);
        List<Product> productList = productService.findProductByPartialName(key);
        logger.info(productList.size() + " results is found.");
        return productList;
    }

}
