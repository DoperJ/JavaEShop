package top.doperj.order.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import top.doperj.order.domain.SKUAndOrder;

import java.util.List;

public interface SKUAndOrderMapper {
    String TABLE_NAME = " t_sku_and_order ";
    String SELECT_FIELDS = " sku_and_order_id, sku_id, order_id, sku_amount ";

    int deleteByPrimaryKey(Integer skuAndOrderId);

    @Delete({"delete from", TABLE_NAME, "where order_id=#{orderId}"})
    int deleteByOrderId(Integer orderId);

    int insert(SKUAndOrder record);

    int insertSelective(SKUAndOrder record);

    SKUAndOrder selectByPrimaryKey(Integer skuAndOrderId);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where order_id=#{orderId}"})
    List<SKUAndOrder> selectByOrderId(Integer orderId);

    int updateByPrimaryKeySelective(SKUAndOrder record);

    int updateByPrimaryKey(SKUAndOrder record);
}