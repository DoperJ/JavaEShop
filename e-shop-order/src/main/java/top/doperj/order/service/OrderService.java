package top.doperj.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.doperj.order.POJO.OrderUser;
import top.doperj.order.POJO.ViewOrder;
import top.doperj.order.dao.OrderMapper;
import top.doperj.order.domain.Order;
import top.doperj.service.Entity.ViewOrderResponse;

import java.util.Iterator;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderMapper orderDAO;

    @Autowired
    SKUAndOrderService skuAndOrderService;

    public List<Order> findOrdersByUserName(String userName) {
        return orderDAO.selectByUserName(userName);
    }

    public Order selectOrderByOrderId(Integer orderId) {
        return orderDAO.selectByPrimaryKey(orderId);
    }

    public Order addOrderByAddressAndName(int addressId, String firstName, String lastName) {
        Order order = new Order();
        order.setAddressId(addressId);
        order.setFirstName(firstName);
        order.setLastName(lastName);
        int i = orderDAO.insertSelective(order);
        System.out.println("i = " + i);
        return order;
    }

    public List<ViewOrderResponse> findViewOrderResponseByUserName(String userName) {
        List<Order> orderList = orderDAO.selectByUserName(userName);
        return null;
    }

    public Order addOrderByViewOrder(ViewOrder viewOrder) {
        return skuAndOrderService.addByViewOrder(viewOrder);
    }

    public OrderUser getUserNameByOrder(Order order) {
        return orderDAO.selectUserNameByOrderId(order.getOrderId());
    }

    public int deleteOrderByOrderId(Integer orderId) {
        return orderDAO.deleteByPrimaryKey(orderId);
    }

    public int deleteOrderByUserName(String userName) {
        List<Order> orderList = orderDAO.selectByUserName(userName);
        Iterator<Order> orderIterator = orderList.iterator();
        while (orderIterator.hasNext()) {
            skuAndOrderService.deleteSKUAndOrderByOrder(orderIterator.next());
        }
        int i = orderDAO.deleteByUserName(userName);
        return i;
    }
}
