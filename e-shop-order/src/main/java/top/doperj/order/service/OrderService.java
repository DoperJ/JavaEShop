package top.doperj.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.doperj.order.POJO.ViewOrder;
import top.doperj.order.dao.OrderMapper;
import top.doperj.order.domain.Order;

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

    public Order addOrderByAddressId(int addressId) {
        Order order = new Order();
        order.setAddressId(addressId);
        int i = orderDAO.insertSelective(order);
        System.out.println("i = " + i);
        return order;
    }

    public Order addOrderByViewOrder(ViewOrder viewOrder) {
        return skuAndOrderService.addByViewOrder(viewOrder);
    }
}
