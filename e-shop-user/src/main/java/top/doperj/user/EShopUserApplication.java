package top.doperj.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableDiscoveryClient(autoRegister = true)
@MapperScan("top.doperj.user.dao")
@EnableRedisHttpSession
@SpringBootApplication()
public class EShopUserApplication {

    /*
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    */

	public static void main(String[] args) {
		SpringApplication.run(EShopUserApplication.class, args);
	}
}
