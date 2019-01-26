package com.lvmama.toter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * <p>
 *
 * @author Toter
 * @date 2019/1/26
 */
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/consumer-hello")
    public Object hello(){
        ResponseEntity entity = restTemplate.getForEntity("http://HELLO-SERVCE/hello",String.class);
        return entity.getBody();
    }
}
