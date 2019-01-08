package top.doperj.product.dao;

import org.apache.ibatis.annotations.Select;
import top.doperj.product.domain.Product;
import top.doperj.product.domain.SKU;

import java.util.List;
import java.util.Map;

public interface SKUMapper {
    String TABLE_NAME = " t_sku ";
    String SELECT_FIELDS = " sku_id, product_id, photo_url, original_price, sale_price, stock_quantity ";
    String SELECT_FIELDS_WITH_PREFIX = " a.sku_id, a.product_id, a.photo_url, a.original_price, a.sale_price, a.stock_quantity ";

    // Create
    int insert(SKU record);

    int insertSelective(SKU record);

    void insertSKUBatch(List<Integer> SKUBatch);

    // Read
    SKU selectByPrimaryKey(Integer skuId);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME})
    List<SKU> selectAllSKUs();

    @Select({"select", SELECT_FIELDS_WITH_PREFIX, "from", TABLE_NAME, "as a, t_product as b ", "where a.product_id=b.product_id and b.product_name=#{productName}"})
    List<SKU> selectSKUByProductName(String productName);

    List<SKU> selectSKUBySKUAttributeAndChoiceMap(List<Integer> skuChoiceIdList);

    List<SKU> selectSKUByCategoryName(String categoryName);

    // Update
    int updateByPrimaryKeySelective(SKU record);

    int updateByPrimaryKey(SKU record);

    void setSKUProductBatch(Map<String, Object> map);

    // Delete
    int deleteByPrimaryKey(Integer skuId);

}