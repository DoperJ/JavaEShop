package top.doperj.product.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import top.doperj.product.domain.Brand;

import java.util.List;

public interface BrandMapper {
    String TABLE_NAME = " t_brand ";
    String SELECT_FIELDS = " brand_id, brand_name, introduction, logo_url ";

    // Create
    int insert(Brand record);

    int insertSelective(Brand record);

    // Read
    Brand selectByPrimaryKey(Integer brandId);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME})
    List<Brand> selectAllBrands();

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where brand_id=#{brandId}"})
    Brand selectByBrandId(int brandId);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where brand_name=#{brandName}"})
    Brand selectByBrandName(String brandName);

    // Update
    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);

    // Delete
    int deleteByPrimaryKey(Integer brandId);

    @Delete({"delete from", TABLE_NAME, "where brand_name=#{brandName}"})
    void deleteByBrandName(String brandName);

}