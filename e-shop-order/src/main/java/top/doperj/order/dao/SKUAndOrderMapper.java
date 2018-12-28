package top.doperj.order.dao;

import org.apache.ibatis.annotations.Delete;
import top.doperj.order.domain.SKUAndOrder;

public interface SKUAndOrderMapper {
    String TABLE_NAME = " t_sku_and_order ";
    String SELECT_FIELDS = " sku_and_order_id, sku_id, order_id, sku_amount ";

    int deleteByPrimaryKey(Integer skuAndOrderId);

    @Delete({"delete from", TABLE_NAME, "where order_id=#{orderId}"})
    int deleteByOrderId(Integer orderId);

    int insert(SKUAndOrder record);

    int insertSelective(SKUAndOrder record);

    SKUAndOrder selectByPrimaryKey(Integer skuAndOrderId);

    int updateByPrimaryKeySelective(SKUAndOrder record);

    int updateByPrimaryKey(SKUAndOrder record);
}