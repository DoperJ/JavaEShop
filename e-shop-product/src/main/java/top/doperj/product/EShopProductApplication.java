package top.doperj.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient(autoRegister = true)
@MapperScan("top.doperj.product.dao")
@SpringBootApplication
public class EShopProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(EShopProductApplication.class, args);
	}
}
