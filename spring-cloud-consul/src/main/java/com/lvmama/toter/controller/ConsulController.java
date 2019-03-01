package com.lvmama.toter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * <p>
 *
 * @author Toter
 * @date 2019/1/29
 */
@RestController
public class ConsulController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping(value = "/queryServices")
    public Object queryServices(){
        return discoveryClient.getServices();
    }
}
