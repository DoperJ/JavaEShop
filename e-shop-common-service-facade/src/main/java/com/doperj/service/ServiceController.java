package com.doperj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/common")
    public String commonService(String name) {
        return "Service: " + discoveryClient.getServices() + ", " + name;
    }
}
