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
@RequestMapping("/api/")
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

    @GetMapping(value = "/categories", produces = "application/json")
    public List<Category> getCategories() {
        return categoryService.findAllCategories();
    }

    @GetMapping(path = "/category/{level}", produces = "application/json")
    public List<Category> getCategoriesByLevel(@PathVariable("level") int level) {
        return getCategoriesByLevelHelper(level);
    }

    @GetMapping(path = "/category/{level}/{sup_category_name}", produces = "application/json")
    public List<Category> getCategoriesByLevelAndSupCategoryName(@PathVariable("level") int level, @PathVariable("sup_category_name") String supCategoryName) {
        List<Category> supcategoryList = getCategoriesByLevelHelper(level);
        Category supCategory = categoryService.findCategoryByName(supCategoryName);
        Set<Category> supCategorySet = new HashSet<Category>(supcategoryList);
        if (!supCategorySet.contains(supCategory)) {
            logger.error("No super category in level " + level + " named: " + supCategoryName + "!");
            return null;
        }
        List<Category> categoryList = getCategoriesByLevelHelper(level + 1);
        List<Category> result = new LinkedList<Category>();
        Iterator<Category> iterator = categoryList.iterator();
        while (iterator.hasNext()) {
            Category category = iterator.next();
            if (category.getSupCategoryId() == supCategory.getCategoryId()) {
                result.add(category);
            }
        }
        return result;
    }

    @GetMapping(path = "/product/{categoryName}", produces = "application/json")
    public List<Product> getProductsByCategoryName(@PathVariable("categoryName") String categoryName) {
        return productService.findProductByCategoryName(categoryName);
    }

    @GetMapping(path = "/product/{categoryName}/{productName}", produces = "application/json")
    public Map<String, List<String>> getSKUAttributeAndSKUChoices(@PathVariable("productName") String productName) {
        return productService.findProductSKUAttributeAndChoices(productName);
    }

    @PostMapping(path = "/product/{categroyName}/{productName}", produces = "application/json")
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

    private List<Category> getCategoriesByLevelHelper(int level) {
        List<Category> categoryList = categoryService.findAllCategories();
        List<Category> categoryList1 = new LinkedList<Category>();
        List<Category> categoryList2 = new LinkedList<Category>();
        List<Category> categoryList3 = new LinkedList<Category>();
        Iterator<Category> iterator;
        iterator = categoryList.iterator();
        Set<Integer> supCategoryIdSet;
        Set<Integer> categoryIdSet = new HashSet<Integer>();
        while (iterator.hasNext()) {
            Category category = iterator.next();
            if (category.getSupCategoryId() == null) {
                categoryList1.add(category);
                categoryIdSet.add(category.getCategoryId());
            }
        }
        supCategoryIdSet = categoryIdSet;
        categoryIdSet = new HashSet<Integer>();
        iterator = categoryList.iterator();
        while (iterator.hasNext()) {
            Category category = iterator.next();
            if (supCategoryIdSet.contains(category.getSupCategoryId())) {
                categoryList2.add(category);
                categoryIdSet.add(category.getCategoryId());
            }
        }
        supCategoryIdSet = categoryIdSet;
        categoryIdSet = new HashSet<Integer>();
        iterator = categoryList.iterator();
        while (iterator.hasNext()) {
            Category category = iterator.next();
            if (supCategoryIdSet.contains(category.getSupCategoryId())) {
                categoryList3.add(category);
                categoryIdSet.add(category.getCategoryId());
            }
        }
        switch (level) {
            case 1: return categoryList1;
            case 2: return categoryList2;
            case 3: return categoryList3;
            default: return categoryList;
        }
    }
}
