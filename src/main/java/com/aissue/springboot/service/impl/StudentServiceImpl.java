package com.aissue.springboot.service.impl;

import com.aissue.springboot.entity.Student;
import com.aissue.springboot.mapper.StudentMapper;
import com.aissue.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int insert(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public Student selectById(Integer id) {
        return studentMapper.selectById(id);
    }

    @Override
    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }
}
