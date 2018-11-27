package com.aissue.springboot.service;

import com.aissue.springboot.entity.Student;

import java.util.List;

public interface StudentService {
    int insert(Student student);
    Student selectById(Integer id);
    List<Student> selectAll();
    List<Student> selectPage(Integer pageNum,Integer pageSize);
}
