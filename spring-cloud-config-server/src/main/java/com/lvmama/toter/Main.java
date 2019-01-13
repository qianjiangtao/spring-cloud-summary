package com.lvmama.toter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Toter
 * @since 2019-01-12 18:05
 **/
@SpringBootApplication
@EnableConfigServer
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
