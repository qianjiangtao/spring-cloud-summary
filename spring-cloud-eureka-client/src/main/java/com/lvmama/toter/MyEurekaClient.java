package com.lvmama.toter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Toter
 * @since 2019-01-26 14:33
 **/
@SpringBootApplication
@EnableEurekaClient
public class MyEurekaClient {
    public static void main(String[] args) {
        SpringApplication.run(MyEurekaClient.class, args);
    }
}
