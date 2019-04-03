package com.lvmama.toter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Tour Jiang
 * @since 2019-01-26 15:18
 **/
@SpringBootApplication
@EnableEurekaServer
public class MyEurekaServer02 {
    public static void main(String[] args) {
        SpringApplication.run(MyEurekaServer02.class, args);
    }
}
