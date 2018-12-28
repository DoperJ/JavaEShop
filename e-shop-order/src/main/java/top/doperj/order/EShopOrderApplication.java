package top.doperj.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.client.RestTemplate;

//@ServletComponentScan(basePackages = "top.doperj.order.filter")
@EnableDiscoveryClient(autoRegister = true)
@MapperScan("top.doperj.order.dao")
@EnableRedisHttpSession
@SpringBootApplication
public class EShopOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EShopOrderApplication.class, args);
	}

    @Bean
	@LoadBalanced
    RestTemplate restTemplate() {
	    return new RestTemplate();
    }
}
