package com.aissue.springboot.web;

import com.aissue.springboot.entity.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/index")
    public String index(Student student){
        return "Hello SpringBoot!"+student.toString();
    }
}
