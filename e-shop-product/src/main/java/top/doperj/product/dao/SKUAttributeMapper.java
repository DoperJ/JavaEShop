package top.doperj.product.dao;

import top.doperj.product.domain.SKUAttribute;

public interface SKUAttributeMapper {
    int deleteByPrimaryKey(Integer skuAttributeId);

    int insert(SKUAttribute record);

    int insertSelective(SKUAttribute record);

    SKUAttribute selectByPrimaryKey(Integer skuAttributeId);

    int updateByPrimaryKeySelective(SKUAttribute record);

    int updateByPrimaryKey(SKUAttribute record);
}