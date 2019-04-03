package com.lvmama.toter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * <p>
 *
 * @author Tour Jiang
 * @date 2019/1/29
 */
@RestController
public class HealthController {

    @GetMapping(value = "/checkStatus")
    public String checkStatus() {
        return "ok";
    }
}
