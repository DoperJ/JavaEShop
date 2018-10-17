package top.doperj.product.dao;

import org.apache.ibatis.annotations.Select;
import top.doperj.product.domain.SKUAttribute;

import java.util.List;
import java.util.Map;

public interface SKUAttributeMapper {
    String TABLE_NAME = " t_sku_attribute ";
    String SELECT_FIELDS = " sku_attribute_id, sku_attribute_name ";

    // Create
    int insert(SKUAttribute record);

    int insertSelective(SKUAttribute record);

    int insertSKUAttributeBatch(List<String> attributeNameBatch);

    // Read
    SKUAttribute selectByPrimaryKey(Integer skuAttributeId);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME})
    List<SKUAttribute> selectAllSKUAttribute();

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where sku_attribute_name=#{skuAttributeName}"})
    SKUAttribute selectSKUAttributeByName(String skuAttributeName);

    // Update
    int updateByPrimaryKeySelective(SKUAttribute record);

    int updateByPrimaryKey(SKUAttribute record);

    void setSKUAttributeByNameBatch(Map<String, Object> map);

    // Delete
    int deleteByPrimaryKey(Integer skuAttributeId);

    void deleteSKUAttributeBatch(List<String> skuAttributeBatch);
}