package com.dhananjay.project1.HelloWorld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @RequestMapping(value = "/hello")
    public String sayHello(){
        return "Hello World";
    }
}
