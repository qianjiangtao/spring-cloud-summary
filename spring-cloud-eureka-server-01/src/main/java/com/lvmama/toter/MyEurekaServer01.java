package com.lvmama.toter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Tour Jiang
 * @since 2019-01-26 14:33
 **/
@SpringBootApplication
@EnableEurekaServer
public class MyEurekaServer01 {
    public static void main(String[] args) {
        SpringApplication.run(MyEurekaServer01.class, args);
    }
}
