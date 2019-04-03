package com.lvmama.tony.bootstrap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * <p>
 *
 * @author Tour Jiang
 * @date 2019/1/8
 */
@SpringBootApplication
public class Main {

    @Value("${spring.application.name}")
    private String value;

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Main.class);
        application.run(args);
    }
}
