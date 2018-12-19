package top.doperj.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.doperj.order.POJO.ViewOrder;
import top.doperj.order.dao.SKUAndOrderMapper;
import top.doperj.order.domain.Order;
import top.doperj.order.domain.SKUAndOrder;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class SKUAndOrderService {
    @Autowired
    SKUAndOrderMapper skuAndOrderDAO;

    @Autowired
    OrderService orderService;

    public Order addByViewOrder(ViewOrder viewOrder) {
        Map<Integer, Integer> skuMap = viewOrder.getItems();
        int addressId = viewOrder.getAddressId();
        Iterator<Integer> iterator = skuMap.keySet().iterator();
        Order order = orderService.addOrderByAddressId(addressId);
        while (iterator.hasNext()) {
            int skuId = iterator.next();
            System.out.println(order);
            SKUAndOrder skuAndOrder = addSKUAndOrder(skuId, order.getOrderId());
        }
        return order;
    }

    public SKUAndOrder addSKUAndOrder(int skuId, int orderId) {
        SKUAndOrder skuAndOrder = new SKUAndOrder();
        skuAndOrder.setSkuId(skuId);
        skuAndOrder.setOrderId(orderId);
        skuAndOrderDAO.insertSelective(skuAndOrder);
        System.out.println(skuAndOrder);
        return skuAndOrder;
    }
}
