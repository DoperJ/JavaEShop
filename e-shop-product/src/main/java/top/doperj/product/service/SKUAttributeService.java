package top.doperj.product.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.doperj.product.dao.SKUAttributeMapper;
import top.doperj.product.domain.SKUAttribute;
import top.doperj.product.domain.SKUChoice;

import java.util.Arrays;
import java.util.List;

@Service
public class SKUAttributeService {
    @Autowired
    SKUAttributeMapper skuAttributeDAO;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    // Create
    public void addSKUAttributeBatch(String[] skuAttributeBatch) {
        skuAttributeDAO.insertSKUAttributeBatch(Arrays.asList(skuAttributeBatch));
    }

    // Read
    public List<SKUAttribute> findAllSKUAttributes() {
        return skuAttributeDAO.selectAllSKUAttribute();
    }

    public SKUAttribute findSKUAttributeByName(String skuAttributeName) {
        return skuAttributeDAO.selectSKUAttributeByName(skuAttributeName);
    }

    public SKUAttribute findSKUAttributeBySKUChoice(SKUChoice skuChoice) {
        return skuAttributeDAO.selectByPrimaryKey(skuChoice.getSkuAttributeId());
    }

    // Delete
    public void removeSKUAttribute(String skuAttributeName) {
        SKUAttribute skuAttribute = skuAttributeDAO.selectSKUAttributeByName(skuAttributeName);
        if (skuAttribute == null) {
            logger.error("No SKU Attribute Named: " + skuAttributeName);
        }
        skuAttributeDAO.deleteByPrimaryKey(skuAttribute.getSkuAttributeId());
    }

    public void removeSKUAttributeBatch(String[] skuAttributeBatch) {
        skuAttributeDAO.deleteSKUAttributeBatch(Arrays.asList(skuAttributeBatch));
    }
}
