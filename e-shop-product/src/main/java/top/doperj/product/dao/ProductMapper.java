package top.doperj.product.dao;

import org.apache.ibatis.annotations.Select;
import top.doperj.product.domain.Product;

import java.util.List;
import java.util.Map;

public interface ProductMapper {
    String TABLE_NAME = " t_product ";
    String SELECT_FIELDS = " product_id, product_name, abbreviation, details, clicked_times, sale_quantity, photo_url, is_hot, is_new, on_sale_date, category_id, brand_id ";

    // Create
    int insert(Product record);

    int insertSelective(Product record);

    int insertProductBatch(List<String> productBatch);

    // Read
    Product selectByPrimaryKey(Integer productId);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME})
    List<Product> selectAllProducts();

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where product_name=#{productName}"})
    Product selectProductByName(String productName);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where product_name like CONCAT('%', #{productPartialName}, '%')"})
    List<Product> selectProductByNameLike(String productPartialName);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where category_id=#{categoryId}"})
    List<Product> selectProductByCategoryId(int categoryId);

    // Update
    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    void setProductCategoryBatch(Map<String, Object> map);

    // Delete
    int deleteByPrimaryKey(Integer productId);
}