package top.doperj.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.doperj.product.dao.SKUAndSKUChoiceMapper;
import top.doperj.product.domain.SKUAndSKUChoice;

@Service
public class SKUAndSKUChoiceService {
    @Autowired
    SKUAndSKUChoiceMapper skuAndSKUChoiceDAO;

    public int addSKUAndSKUChoice(SKUAndSKUChoice skuAndSKUChoice) {
        return skuAndSKUChoiceDAO.insertSelective(skuAndSKUChoice);
    }
}
