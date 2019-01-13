package top.doperj.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.doperj.order.POJO.OrderUser;
import top.doperj.order.domain.Order;
import top.doperj.order.service.OrderService;
import top.doperj.order.service.SKUAndOrderService;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("top.doperj.user.dao")
public class EShopOrderApplicationTests {

	@Autowired
	OrderService orderService;

	@Autowired
    SKUAndOrderService skuAndOrderService;

	@Test
	public void findOrderByUsername() {
		System.out.println(orderService.findOrdersByUserName("doperj"));
	}

	@Test
    public void deleteOrderByUsername() {
        System.out.println("before delete ----->");
        System.out.println(orderService.findOrdersByUserName("doperj"));
        System.out.println(orderService.deleteOrderByUserName("doperj"));
        System.out.println("after delete ----->");
        System.out.println(orderService.findOrdersByUserName("doperj"));
    }

    @Test
    public void findOrderByUserName() {
        Order order = orderService.findOrdersByUserName("doperj").get(0);
        System.out.println(order);
        OrderUser user = orderService.getUserNameByOrder(order);
        System.out.println(user);
    }

    @Test
    public void findViewOrderByUserName() {
        System.out.println(orderService.findViewOrderResponseByUserName("doperj"));
    }

    @Test
    public void findSKUAndOrderByOrderId() {
        System.out.println(skuAndOrderService.findSKUAndOrderByOrderId(34));
    }
}
