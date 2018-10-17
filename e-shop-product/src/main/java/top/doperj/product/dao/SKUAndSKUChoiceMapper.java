package top.doperj.product.dao;

import org.apache.ibatis.annotations.Select;
import top.doperj.product.domain.SKUAndSKUChoice;

import java.util.List;
import java.util.Map;

public interface SKUAndSKUChoiceMapper {
    String TABLE_NAME = " t_sku_and_sku_choice ";
    String SELECT_FIELDS = " id, sku_choice_id, sku_id ";

    // Create
    int insert(SKUAndSKUChoice record);

    int insertSelective(SKUAndSKUChoice record);

    void insertBySKUChoiceBatch(List<Integer> skuChoiceBatch);

    // Read
    SKUAndSKUChoice selectByPrimaryKey(Integer id);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME})
    List<SKUAndSKUChoice> selectAllSKUAndSKUChoices();

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where sku_id=#{skuId}"})
    List<SKUAndSKUChoice> selectBySKU(int skuId);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where sku_choice_id=#{skuChoiceId}"})
    List<SKUAndSKUChoice> selectBySKUChoice(int skuChoiceId);

    // Update
    int updateByPrimaryKeySelective(SKUAndSKUChoice record);

    int updateByPrimaryKey(SKUAndSKUChoice record);

    void updateSKUIdBySKUChoiceBatch(Map<String, Object> map);

    // Delete
    int deleteByPrimaryKey(Integer id);
}