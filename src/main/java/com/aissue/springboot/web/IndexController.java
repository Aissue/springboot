package com.aissue.springboot.web;

import com.aissue.springboot.entity.Student;
import com.aissue.springboot.utils.JsonUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/index")
    public String index(Student student){
        return "Hello SpringBoot!"+ JsonUtil.obj2StringPretty(student);
    }
}
