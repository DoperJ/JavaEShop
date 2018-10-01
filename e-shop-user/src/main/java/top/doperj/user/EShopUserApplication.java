package top.doperj.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient(autoRegister = true)
@SpringBootApplication()
@MapperScan("com.doperj.user.dao")
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
