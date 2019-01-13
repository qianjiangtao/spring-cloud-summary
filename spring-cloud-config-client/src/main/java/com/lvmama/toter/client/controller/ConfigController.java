package com.lvmama.toter.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Toter
 * @since 2019-01-13 17:51
 **/
@RestController
public class ConfigController {

    @Value("${config.name}")
    private String name;

    @GetMapping("/config")
    public Object config(){
        return name;
    }
}
