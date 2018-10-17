package top.doperj.product.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.doperj.product.domain.SKUChoice;

import java.util.List;
import java.util.Map;

public interface SKUChoiceMapper {
    String TABLE_NAME = " t_sku_choice ";
    String SELECT_FIELDS = " sku_choice_id, sku_attribute_id, sku_choice_name ";
    String SELECT_FIELDS_AS_TABLE_A = " a.sku_choice_id, a.sku_attribute_id, a.sku_choice_name ";

    // Create
    int insert(SKUChoice record);

    int insertSelective(SKUChoice record);

    void insertSKUChoiceBatch(List<String> skuChoiceBatch);

    // Read
    SKUChoice selectByPrimaryKey(Integer skuChoiceId);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME})
    List<SKUChoice> selectAllSKUChoices();

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where sku_attribute_id=#{skuAttributeId} and sku_choice_name=#{skuChoiceName}"})
    SKUChoice selectSKUChoiceBySKUAttributeAndName(@Param("skuAttributeId") Integer skuAttributeId, @Param("skuChoiceName") String skuChoiceName);

    List<SKUChoice> selectSKUChoicesByProductName(String productName);

    // Update
    int updateByPrimaryKeySelective(SKUChoice record);

    int updateByPrimaryKey(SKUChoice record);

    void updateSKUAttributeByNameBatch(Map<String, Object> map);

    // Delete
    int deleteByPrimaryKey(Integer skuChoiceId);
}