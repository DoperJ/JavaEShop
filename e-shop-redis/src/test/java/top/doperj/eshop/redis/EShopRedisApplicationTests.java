package top.doperj.eshop.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import top.doperj.eshop.redis.pojo.User;
import top.doperj.eshop.redis.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EShopRedisApplicationTests {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    UserService userService;

	@Test
	public void contextLoads() {
        System.out.println(userService.getUser("doperj"));
        System.out.println(userService.getUser("doperj"));
        System.out.println(userService.getUser("doperj"));
    }

}
