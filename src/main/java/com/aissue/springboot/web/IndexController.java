package com.aissue.springboot.web;

import com.aissue.springboot.entity.Student;
import com.aissue.springboot.service.StudentService;
import com.aissue.springboot.utils.JsonUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping("/searchAll")
    public String searchALL(HttpServletRequest httpServletRequest){
        String uri = httpServletRequest.getRequestURI();
        Log.info("==="+uri);
        return JsonUtil.obj2StringPretty(studentService.selectAll());
    }

    @RequestMapping("/searchPage")
    public String searchPage(Integer pageNum,Integer pageSize){
        Log.info("log info ...");
        Log.error("log error ...");
        Log.debug("log debug ...");
        Log.warn("log warn ...");
        return JsonUtil.obj2StringPretty(studentService.selectPage(pageNum,pageSize));
    }
}
