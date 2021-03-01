package com.learn.springbootkubernetes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Value("${name}")
    private String name;

    @RequestMapping("/")
    public String index() {
        return "Hello " + name + ", Spring-Boot app successfully deployed and running on Minishift";
    }
}
