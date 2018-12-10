package com.aissue.springboot.web;

import com.aissue.springboot.service.StudentService;
import com.aissue.springboot.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lua")
public class LuaController {
    private static final Logger Log= LoggerFactory.getLogger(LuaController.class);
    @Autowired
    public StudentService studentService;

    @RequestMapping("/a")
    public String search(Integer id){
        Log.info("================/lua/a");
        return JsonUtil.obj2String(studentService.selectById(id));
    }
}
