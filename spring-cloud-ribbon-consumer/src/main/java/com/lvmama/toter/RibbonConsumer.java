package com.lvmama.toter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * <p>
 *
 * @author Tour Jiang
 * @date 2019/1/26
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RibbonConsumer {

    public static void main(String[] args) {
        SpringApplication.run(RibbonConsumer.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
