package com.lvmama.toter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>
 * <p>
 *
 * @author Toter
 * @date 2019/1/29
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Consul {
    public static void main(String[] args) {
        SpringApplication.run(Consul.class,args);
    }
}
