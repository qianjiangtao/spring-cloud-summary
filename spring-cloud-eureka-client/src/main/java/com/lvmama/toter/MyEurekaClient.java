package com.lvmama.toter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Tour Jiang
 * @since 2019-01-26 14:33
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class MyEurekaClient {
    public static void main(String[] args) {
        SpringApplication.run(MyEurekaClient.class, args);
    }
}
