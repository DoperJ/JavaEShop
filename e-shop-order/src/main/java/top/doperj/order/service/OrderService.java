package top.doperj.order.service;

import com.netflix.ribbon.proxy.annotation.Http;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import top.doperj.order.POJO.OrderUser;
import top.doperj.order.POJO.ViewOrder;
import top.doperj.order.dao.OrderMapper;
import top.doperj.order.domain.Order;
import top.doperj.order.domain.SKUAndOrder;
import top.doperj.service.Entity.SKUView;
import top.doperj.service.Entity.ViewOrderResponse;
import top.doperj.service.Entity.Wrapper;

import java.util.*;

@Service
public class OrderService {
    Logger logger = LoggerFactory.getLogger(Object.class);

    @Autowired
    OrderMapper orderDAO;

    @Autowired
    RestTemplate restTemplate;

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
        List<ViewOrderResponse> result =  new LinkedList<ViewOrderResponse>();
        // 解决LinkedHashMap不能转换成SKUView问题
        ParameterizedTypeReference<List<SKUView>> typeRef = new ParameterizedTypeReference<List<SKUView>>() {
        };
        List<Integer> skuIdList = new LinkedList<Integer>();
        List<Integer> skuNumList = new LinkedList<Integer>();
        List<Order> orderList = orderDAO.selectByUserName(userName);
        Iterator<Order> orderIterator = orderList.iterator();
        while (orderIterator.hasNext()) {
            ViewOrderResponse viewOrderResponse = new ViewOrderResponse();
            Map<SKUView, Integer> items = new HashMap<SKUView, Integer>();
            Order order = orderIterator.next();
            System.out.println(order);
            List<SKUAndOrder> skuAndOrderList = skuAndOrderService.findSKUAndOrderByOrderId(order.getOrderId());
            Iterator<SKUAndOrder> skuAndOrderIterator = skuAndOrderList.iterator();
            String url = "http://product-services/api/sku/List?";
            if (skuAndOrderIterator.hasNext()) {
                SKUAndOrder skuAndOrder = skuAndOrderIterator.next();
                skuIdList.add(skuAndOrder.getSkuId());
                skuNumList.add(skuAndOrder.getSkuAmount());
                url = url + "skuId=" + skuAndOrder.getSkuId();
            }
            while (skuAndOrderIterator.hasNext()) {
                SKUAndOrder skuAndOrder = skuAndOrderIterator.next();
                skuIdList.add(skuAndOrder.getSkuId());
                skuNumList.add(skuAndOrder.getSkuAmount());
                url = url + "&skuId=" + skuAndOrder.getSkuId();
            }
/*            Wrapper<SKUView> response = restTemplate.exchange(url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<Wrapper<SKUView>>() {}).getBody();*/
            ResponseEntity<List<SKUView>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, typeRef);
            List<SKUView> skuViewList = responseEntity.getBody();

            //List<SKUView> skuViewList =  restTemplate.getForObject(url, List.class);
            logger.info("SKU View List: ");
            System.out.println(skuViewList);
            Iterator<SKUView> skuViewIterator = skuViewList.iterator();
            Iterator<Integer> skuNumInterator = skuNumList.iterator();
            float totalPrice = (float) 0.0;
            while (skuViewIterator.hasNext() && skuNumInterator.hasNext()) {
                SKUView skuView = skuViewIterator.next();
                int skuNum = skuNumInterator.next();
                items.put(skuView, skuNum);
                totalPrice += (skuView.getSalePrice() * skuNum);
            }
            viewOrderResponse.setItems(items);
            viewOrderResponse.setAddressId(order.getAddressId());
            viewOrderResponse.setFirst_name(order.getFirstName());
            viewOrderResponse.setLast_name(order.getLastName());
            viewOrderResponse.setTotalPrice(totalPrice);
            result.add(viewOrderResponse);
        }
        return result;
    }

    public Order addOrderByViewOrder(ViewOrder viewOrder) {
        return skuAndOrderService.addByViewOrder(viewOrder);
    }

    public OrderUser getUserNameByOrder(Order order) {
        return orderDAO.selectUserNameByOrderId(order.getOrderId());
    }

    public int deleteOrderByOrderId(Integer orderId) {
        skuAndOrderService.deleteSKUAndOrderByOrder(orderDAO.selectByPrimaryKey(orderId));
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
