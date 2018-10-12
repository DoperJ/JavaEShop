package top.doperj.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.doperj.product.dao.ProductMapper;
import top.doperj.product.dao.SKUMapper;
import top.doperj.product.domain.Product;
import top.doperj.product.domain.SKU;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SKUService {
    @Autowired
    ProductMapper productDAO;

    @Autowired
    SKUMapper skuDAO;

    public List<SKU> findAllSKUs() {
        return skuDAO.selectAllSKUs();
    }

    public List<SKU> findSKUByProductName(String name) {
        return skuDAO.selectSKUByProductName(name);
    }

    public int addSKU(SKU sku) {
        return skuDAO.insertSelective(sku);
    }

    public void addSKUBatchByPrices(Integer[] batch) {
        skuDAO.insertSKUBatch(Arrays.asList(batch));
    }

    public void setSKUProductBatch(Integer[] arr, String productName) {
        Product product = productDAO.selectProductByName(productName);
        if (product == null) {
            System.out.println("No category named: " + productName);
            return;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", Arrays.asList(arr));
        map.put("productId", product.getCategoryId());
        skuDAO.setSKUProductBatch(map);
    }
}
