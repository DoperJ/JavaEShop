package top.doperj.order.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import top.doperj.order.domain.Order;

import java.util.List;

public interface OrderMapper {
    String TABLE_NAME = " t_order ";
    String SELECT_FIELDS = " order_id, address_id, status, created_time, first_name, last_name ";

    // Create
    int insert(Order record);

    int insertSelective(Order record);

    // Read
    Order selectByPrimaryKey(Integer orderId);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME})
    List<Order> selectAllOrders();

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where address_i#{addressId}"})
    List<Order> selectByAddressId(int addressId);

    List<Order> selectByUserName(String userName);

    // Update
    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    // Delete
    int deleteByPrimaryKey(Integer orderId);

    int deleteByUserName(String userName);
}