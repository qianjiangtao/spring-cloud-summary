package com.lvmama.toter.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author Toter
 * @since 2019-01-13 15:50
 **/
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Main.class).web(true).run(args);
    }
}
