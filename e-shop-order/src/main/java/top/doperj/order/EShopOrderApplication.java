package top.doperj.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableDiscoveryClient(autoRegister = true)
@MapperScan("top.doperj.order.dao")
@EnableRedisHttpSession
@SpringBootApplication
public class EShopOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EShopOrderApplication.class, args);
	}
}
