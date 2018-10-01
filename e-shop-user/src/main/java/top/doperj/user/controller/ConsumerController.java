package top.doperj.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/*
@RestController
public class ConsumerController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer")
    public String consumer() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("common-services");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/common?name=doperj";
        //return new RestTemplate().getForObject(url, String.class);
        return restTemplate.getForEntity("http://common-services/common?name=dop", String.class).getBody();
    }
}
*/
