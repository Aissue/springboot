package com.aissue.springboot.web;

import com.aissue.springboot.entity.Student;
import com.aissue.springboot.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class ContainerController {
    private static final Logger logger= LoggerFactory.getLogger(ContainerController.class);

    @Autowired
    public StudentService studentService;

    @RequestMapping("/selectAll")
    public List<Student> searchALL(){
        logger.info("selectAll");
        sleep(3);
        return studentService.selectAll();
    }

    @RequestMapping("/selectById")
    public Student searchById(Integer id){
        logger.info("selectById");
//        sleep(0);
        return studentService.selectById(id);
    }

    @RequestMapping("/selectByPage")
    public List<Student> selectByPage(Integer pageNum,Integer pageSize){
        logger.info("selectByPage");
//        sleep(0);
        return studentService.selectPage(pageNum,pageSize);
    }

    private void sleep(int time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
