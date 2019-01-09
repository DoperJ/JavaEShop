package top.doperj.product.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.doperj.product.dao.SKUAndSKUChoiceMapper;
import top.doperj.product.dao.SKUAttributeMapper;
import top.doperj.product.dao.SKUChoiceMapper;
import top.doperj.product.dao.SKUMapper;
import top.doperj.product.domain.Product;
import top.doperj.product.domain.SKUAndSKUChoice;
import top.doperj.product.domain.SKUAttribute;
import top.doperj.product.domain.SKUChoice;

import java.util.*;

@Service
public class SKUChoiceService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    SKUChoiceMapper skuChoiceDAO;

    @Autowired
    SKUAttributeMapper skuAttributeDAO;

    @Autowired
    SKUAndSKUChoiceMapper skuAndSKUChoiceDAO;

    @Autowired
    ProductService productService;

    public List<SKUChoice> findAllSKUChoices() {
        return skuChoiceDAO.selectAllSKUChoices();
    }

    public SKUChoice findSKUChoiceByAttributeAndName(String skuAttributeName, String skuChoiceName) {
        SKUAttribute skuAttribute = skuAttributeDAO.selectSKUAttributeByName(skuAttributeName);
        if (skuAttribute == null) {
            logger.error("No sku attribute named: " + skuAttributeName);
            return null;
        }
        return skuChoiceDAO.selectSKUChoiceBySKUAttributeAndName(skuAttribute.getSkuAttributeId(), skuChoiceName);
    }

    public List<SKUChoice> findSKUChoicesByProductName(String productName) {
        Product product = productService.findProductByName(productName);
        if (product == null) {
            logger.error("No product named: " + productName + "!");
            return null;
        }
        return skuChoiceDAO.selectSKUChoicesByProductName(productName);
    };

    public void addSKUChoiceBatch(String[] skuChoiceBatch) {
        skuChoiceDAO.insertSKUChoiceBatch(Arrays.asList(skuChoiceBatch));
    }

    public void setSKUAttributeByNameBatch(String[] skuChoiceBatch, String skuAttributeName) {
        Map<String, Object> map = new HashMap<String, Object>();
        SKUAttribute skuAttribute = skuAttributeDAO.selectSKUAttributeByName(skuAttributeName);
        if (skuAttribute == null) {
            logger.error("No sku attribute named: " + skuAttributeName + "!");
            return;
        }
        logger.info("Setting sku attribute...");
        map.put("list", Arrays.asList(skuChoiceBatch));
        map.put("skuAttributeId", skuAttribute.getSkuAttributeId());
        skuChoiceDAO.updateSKUAttributeByNameBatch(map);
    }

    public List<SKUChoice> findSKUChoiceBySKUId(Integer skuId) {
/*        List<SKUAndSKUChoice> skuAndSKUChoiceList = skuAndSKUChoiceDAO.selectBySKU(skuId);
        Iterator<SKUAndSKUChoice> iterator = skuAndSKUChoiceList.iterator();
        List<SKUChoice> skuChoiceList = new LinkedList<SKUChoice>();
        while (iterator.hasNext()) {
            SKUAndSKUChoice skuAndSKUChoice = iterator.next();
            Integer skuChoiceId = skuAndSKUChoice.getSkuChoiceId();
            SKUChoice skuChoice = skuChoiceDAO.selectByPrimaryKey(skuChoiceId);
            skuChoiceList.add(skuChoice);
        }*/
        return skuChoiceDAO.selectSKUChoiceBySKUId(skuId);
    }
}
