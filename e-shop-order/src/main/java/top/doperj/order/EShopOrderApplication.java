package top.doperj.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient(autoRegister = true)
@MapperScan("top.doperj.order.dao")
@SpringBootApplication
public class EShopOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EShopOrderApplication.class, args);
	}
}
