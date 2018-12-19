package top.doperj.order.dao;

import org.apache.ibatis.annotations.Select;
import top.doperj.order.domain.SKUAndOrder;

import java.util.List;

public interface SKUAndOrderMapper {
    String TABLE_NAME = " t_sku_and_order ";
    String SELECT_FIELDS = " sku_and_order_id, sku_id, order_id, sku_amount ";

    // Create
    int insert(SKUAndOrder record);

    int insertSelective(SKUAndOrder record);

    // Read
    SKUAndOrder selectByPrimaryKey(Integer skuAndOrderId);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME})
    List<SKUAndOrder> selectAllOrders();

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where order_id=#{orderId}"})
    List<SKUAndOrder> selectByOrderId(int orderId);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where sku_id=#{skuId}"})
    List<SKUAndOrder> selectBySKUId(int skuId);

    int updateByPrimaryKeySelective(SKUAndOrder record);

    int updateByPrimaryKey(SKUAndOrder record);

    int deleteByPrimaryKey(Integer skuAndOrderId);
}