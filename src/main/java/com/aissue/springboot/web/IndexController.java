package com.aissue.springboot.web;

import com.aissue.springboot.entity.Student;
import com.aissue.springboot.service.StudentService;
import com.aissue.springboot.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    private static final Logger Log= LoggerFactory.getLogger(IndexController.class);

    @Autowired
    public StudentService studentService;

    @RequestMapping("/index")
    public String index(Student student){
        return "Hello SpringBoot!"+ JsonUtil.obj2StringPretty(student);
    }

    @RequestMapping("/search")
    public String search(Integer id){
        return JsonUtil.obj2String(studentService.selectById(id));
    }
}
