package top.doperj.product.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import top.doperj.product.domain.Category;

import java.util.List;
import java.util.Map;

public interface CategoryMapper {
    String TABLE_NAME = " t_category ";
    String SELECT_FIELDS = " category_id, sup_category_id, category_name, preview ";

    // Create
    int insert(Category record);

    int insertSelective(Category record);

    int insertCategoryBatch(List<String> categoryBatch);

    //Read
    Category selectByPrimaryKey(Integer categoryId);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME})
    List<Category> selectAllCategories();

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where category_id=#{categoryId}"})
    Category selectByBrandId(int categoryId);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where category_name=#{categoryName}"})
    Category selectByCategoryName(String categoryName);

    // Update
    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    void setSupCategoryBatch(Map<String, Object> map);
    // Delete
    int deleteByPrimaryKey(Integer categoryId);

    @Delete({"delete from", TABLE_NAME, "where category_name=#{categoryName}"})
    int deleteByCategoryName(String categoryName);
}