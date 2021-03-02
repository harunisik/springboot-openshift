package com.learn.springbootkubernetes;

import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private static final Logger logger = Logger.getLogger(Controller.class.getName());

    @Value("${name}")
    private String name;


    @RequestMapping("/")
    public String index() {
        logger.info("index method method has been called !");

        return "Hello " + name + ", Spring-Boot app successfully deployed.....";
    }
}
