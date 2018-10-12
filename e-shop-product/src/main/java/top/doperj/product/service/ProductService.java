package top.doperj.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.doperj.product.dao.CategoryMapper;
import top.doperj.product.dao.ProductMapper;
import top.doperj.product.domain.Category;
import top.doperj.product.domain.Product;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    @Autowired
    ProductMapper productDAO;

    @Autowired
    CategoryMapper categoryDAO;

    public List<Product> findAllProducts() {
        return productDAO.selectAllProducts();
    }

    public Product findProductByName(String name) {
        return productDAO.selectProductByName(name);
    }

    public int addProduct(Product product) {
        return productDAO.insertSelective(product);
    }

    public int addProductBatch(String[] batch) {
        return productDAO.insertProductBatch(Arrays.asList(batch));
    }

    public void setProductCategoryBatch(String[] arr, String categoryName) {
        Category category = categoryDAO.selectByCategoryName(categoryName);
        if (category == null) {
            System.out.println("No category named: " + categoryName);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", Arrays.asList(arr));
        map.put("categoryId", category.getCategoryId());
        productDAO.setProductCategoryBatch(map);
    }
}
