package com.example.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @RequestMapping("/index")
    public String index(String param){
        return "Hello SpringBoot! This is server-192.168.40.77:8080 and params is:"+ param;
    }

}
