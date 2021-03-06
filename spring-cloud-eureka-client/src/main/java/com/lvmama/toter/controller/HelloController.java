package com.lvmama.toter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tour Jiang
 * @since 2019-01-26 14:57
 **/
@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "hello")
    public Object hello() {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        System.out.println("/hello, Host:" + instance.getHost() + " service_id:" + instance.getServiceId());
        return "Hello World";
    }
}
