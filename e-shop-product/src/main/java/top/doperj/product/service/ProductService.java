package top.doperj.product.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.doperj.product.dao.ProductMapper;
import top.doperj.product.domain.*;

import java.util.*;

@Service
public class ProductService {
    @Autowired
    ProductMapper productDAO;

    @Autowired
    CategoryService categoryService;

    @Autowired
    SKUService skuService;

    @Autowired
    SKUChoiceService skuChoiceService;

    @Autowired
    BrandService brandService;

    @Autowired
    SKUAttributeService skuAttributeService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<Product> findAllProducts() {
        return productDAO.selectAllProducts();
    }

    public Product findProductById(Integer productId) {
        return productDAO.selectByPrimaryKey(productId);
    }

    public Product findProductByName(String name) {
        return productDAO.selectProductByName(name);
    }

    public List<Product> findProductByCategoryName(String categoryName) {
        Category category = categoryService.findCategoryByName(categoryName);
        if (category == null) {
            logger.error("No category named: " + categoryName + "!");
            return null;
        }
        return productDAO.selectProductByCategoryName(categoryName);
    }

    public int addProduct(Product product) {
        return productDAO.insertSelective(product);
    }

    public int addProductBatch(String[] batch) {
        return productDAO.insertProductBatch(Arrays.asList(batch));
    }

    public void setProductCategoryBatch(String[] arr, String categoryName) {
        Category category = categoryService.findCategoryByName(categoryName);
        if (category == null) {
            System.out.println("No category named: " + categoryName);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", Arrays.asList(arr));
        map.put("categoryId", category.getCategoryId());
        productDAO.setProductCategoryBatch(map);
    }

    public void setProductBrandBatch(String[] arr, String brandName) {
        Brand brand = brandService.findBrandByName(brandName);
        if (brand == null) {
            System.out.println("No category named: " + brandName);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", Arrays.asList(arr));
        map.put("brandId", brand.getBrandId());
        productDAO.setProductBrandBatch(map);
    }

    public Map<String, List<String>> findProductSKUAttributeAndChoices(String productName) {
        Map<String, List<String>> stringListMap = new HashMap<String, List<String>>();
        List<SKUChoice> skuChoiceList = skuChoiceService.findSKUChoicesByProductName(productName);
        System.out.println(skuChoiceList);
        Iterator<SKUChoice> skuChoiceIterator = skuChoiceList.iterator();
        while (skuChoiceIterator.hasNext()) {
            SKUChoice skuChoice = skuChoiceIterator.next();
            SKUAttribute skuAttribute = skuAttributeService.findSKUAttributeBySKUChoice(skuChoice);
            String skuAttributeName = skuAttribute.getSkuAttributeName();
            if (!stringListMap.containsKey(skuAttributeName)) {
                stringListMap.put(skuAttributeName, new LinkedList<String>());
            }
            stringListMap.get(skuAttributeName).add(skuChoice.getSkuChoiceName());
        }
        return stringListMap;
    }

    public List<Product> findProductByPartialName(String partialName) {
        return productDAO.selectProductByNameLike(partialName);
    }

}
