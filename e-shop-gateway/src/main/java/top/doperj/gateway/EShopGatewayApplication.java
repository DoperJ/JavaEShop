package top.doperj.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
//@EnableDiscoveryClient(autoRegister = false)
public class EShopGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EShopGatewayApplication.class, args);
	}
}
