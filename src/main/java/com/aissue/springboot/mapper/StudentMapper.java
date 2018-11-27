package com.aissue.springboot.mapper;

import com.aissue.springboot.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    int insert(Student student);
    Student selectById(Integer id);
    List<Student> selectAll();
}
